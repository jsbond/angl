package belhard.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class AppServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String requestURI = req.getRequestURI();
		String method = req.getMethod();
		Map<String, String[]> parameterMap = req.getParameterMap();

		Dispatcher dispatcher = Dispatcher.getInstance();
		ModelAndView modelAndView = dispatcher.dispatch(requestURI, method, parameterMap);
		req.getRequestDispatcher("/WEB-INF/view/" + modelAndView.getView().getName() + ".jsp")
				.forward(req, resp);
	}

	@Override
	public void destroy() {
		super.destroy();
	}
}
