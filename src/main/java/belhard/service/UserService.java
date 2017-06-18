package belhard.service;

import belhard.dao.UserDAO;
import belhard.entity.User;
import belhard.web.response.UserDTO;

import static belhard.util.Validator.*;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserService {
	private UserDAO userDAO;

	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User findUserById(String id) {
		return userDAO.find(validateLong(id));
	}

	public UserDTO saveUser(String name, String email, String age) {
		User dto = new User();
		dto.setName(name);
		dto.setAge(validateInt(age));

		userDAO.save(dto);

		User user = userDAO.find(email);
		return new UserDTO(user);
	}
}
