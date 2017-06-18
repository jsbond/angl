package belhard.web.response;

import belhard.entity.User;

import java.io.Serializable;

/**
 * Created by Lenovo on 17.06.2017.
 */
public class UserDTO implements Serializable {
	private String name;
	private int age;
	private long id;
	private String email;

	public UserDTO(User user) {
		name = user.getName();
		age = user.getAge();
		id = user.getId();
		email = user.getEmail();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
