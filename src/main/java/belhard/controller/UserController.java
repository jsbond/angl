package belhard.controller;

import belhard.annotation.RequestMapping;
import belhard.entity.User;
import belhard.service.UserService;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(url = "users/find")
	public User findUserById(String id) {
		return userService.findUserById(id);
	}

	@RequestMapping(url = "users/create")
	public String createUser(String name, String age) {
		return userService.saveUser(name, age);
	}
}
