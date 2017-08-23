package belhard.controller;

import belhard.annotation.RequestMapping;
import belhard.entity.User;
import belhard.service.UserService;
import belhard.web.HttpMethod;
import belhard.web.ModelAndView;
import belhard.web.View;
import belhard.web.response.UserDTO;

public class MainController {
	private UserService userService;

	public MainController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(url = "", method = HttpMethod.GET)
	public ModelAndView main(String userId) {
		ModelAndView view = new ModelAndView(View.MAIN);
		User user = userService.find(userId);

		if (user != null) {
			view.addParameter("user", user);
		}
		return view;
	}
}
