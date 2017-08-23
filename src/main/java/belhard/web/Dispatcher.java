package belhard.web;

import belhard.annotation.RequestMapping;
import belhard.controller.UserController;
import belhard.dao.UserDAO;
import belhard.exception.IllegalRequestException;
import belhard.service.UserService;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Front Controller Dispatcher. Route request to controller
 * by url in request. Invoke target method of the controller.
 * Dispatcher keeps all controller instances.
 */
public class Dispatcher {
	private List<Controller> controllers;
	private Invoker invoker = new Invoker();
	private static Dispatcher dispatcher;

	private Dispatcher() {
		controllers = ImmutableList.<Controller>builder()
				.add(new UserController(new UserService(new UserDAO())))
				.build();
	}

	public static Dispatcher getInstance() {
		if (dispatcher == null) {
			dispatcher = new Dispatcher();
		}
		return dispatcher;
	}

	public ModelAndView dispatch(String url, String method, Map<String, String[]> parametersMap, HttpServletRequest req) {
		HttpMethod httpMethod = HttpMethod.valueOf(method);
		Target target = getTargetForInvoke(url, httpMethod);
		if (target != null) {
			fillTargetByParameters(target, parametersMap, req);

			Object result = invoker.invoke(target);
			return (ModelAndView) result;
		}
		return new ModelAndView(HttpStatus.PAGE_NOT_FOUND);
	}

	private void fillTargetByParameters(Target target, Map<String, String[]> stringParametersMap,
	                                    HttpServletRequest req) {
		HashMap<String, Object> parametersMap = new HashMap<>();
		stringParametersMap.forEach((k, v) -> parametersMap.put(k, v[0]));
		parametersMap.put("request", req);

		Arrays.stream(target.method.getParameters())
				.map(e -> parametersMap.get(e.getName()))
				.filter(Objects::nonNull)
				.forEach(e -> target.params.add(e));
	}

	private Target getTargetForInvoke(String requestedUrl, HttpMethod requestedHttpMethod) {
		Target target = null;

		for (Controller controller : controllers) {
			Method[] methods = controller.getClass().getMethods();

			for (Method method : methods) {
				if (method.isAnnotationPresent(RequestMapping.class)) {
					RequestMapping current = method.getAnnotation(RequestMapping.class);

					if (requestedHttpMethod == current.method() && StringUtils.equals(requestedUrl, current.url())) {
						target = new Target(controller, method);
						break;
					}
				}
			}
			if (target != null) {
				break;
			}
		}
		return target;
	}

	private static class Invoker {
		private Object invoke(Target target) {
			try {
				target.method.setAccessible(true);

				return target.method.invoke(target.controller, target.params.toArray());
			} catch (Exception e) {
				throw new IllegalRequestException(e.getMessage());
			}
		}
	}

	private static class Target {
		private Controller controller;
		private Method method;
		private List<Object> params = new ArrayList<>();

		Target(Controller controller, Method method) {
			this.controller = controller;
			this.method = method;
		}
	}
}
