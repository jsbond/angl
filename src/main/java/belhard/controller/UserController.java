package belhard.controller;

import belhard.annotation.RequestMapping;
import belhard.entity.User;
import belhard.service.UserService;
import belhard.web.Controller;
import belhard.web.HttpMethod;
import belhard.web.HttpStatus;
import belhard.web.ModelAndView;
import belhard.web.View;
import belhard.web.response.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.regex.Pattern;

import static belhard.web.View.LOGIN;
import static belhard.web.View.MAIN;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserController implements Controller {
	private UserService userService;
	public static final String YEAR = "grhge";
	
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(url = "/users/signUp", method = HttpMethod.POST)
	public ModelAndView signUp(String name, String email, String age) {
		ModelAndView view = new ModelAndView(View.MAIN);
		UserDTO user = userService.saveUser(name, email, age);
		view.addParameter("user", user);
		return view;
	}

	@RequestMapping(url = "/users/login", method = HttpMethod.GET)
	public ModelAndView getLoginPage() {
		return new ModelAndView(LOGIN);
	}

	@RequestMapping(url = "/users/login", method = HttpMethod.POST)
	public ModelAndView login(HttpServletRequest request, String email, String password) {
		ModelAndView view = new ModelAndView(LOGIN);
		UserDTO user = userService.login(email, password);

		if (user != null) {
			view = new ModelAndView(MAIN);
			view.addParameter("user", user);

			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
		}
		return view;
	}


}
