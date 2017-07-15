package belhard.controller;

import belhard.annotation.RequestMapping;
import belhard.entity.User;
import belhard.service.UserService;
import belhard.web.Controller;
import belhard.web.HttpMethod;
import belhard.web.ModelAndView;
import belhard.web.View;
import belhard.web.response.UserDTO;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserController implements Controller{
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(url = "/users/find", method = HttpMethod.GET)
	public ModelAndView findUserById(String id) {
		ModelAndView view = new ModelAndView(View.USER);
		User user = userService.findUserById(id);
		view.addParameter("user", user);
		return view;
	}

	@RequestMapping(url = "/users/signUp", method = HttpMethod.POST)
	public ModelAndView signUp(String name, String email, String age) {
		ModelAndView view = new ModelAndView(View.MAIN);
		UserDTO user = userService.saveUser(name, email, age);
		view.addParameter("user", user);
		return view;
	}

	@RequestMapping(url = "/users/login", method = HttpMethod.POST)
	public ModelAndView login(String email, String password) {
		ModelAndView view = new ModelAndView(View.LOGIN);
		UserDTO userDTO = userService.login(email, password);

		if (userDTO != null) {
			view.setView(View.MAIN);
			view.addParameter("user", userDTO);
		}
		return view;
	}


}
