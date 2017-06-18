package belhard.entity;

import java.io.Serializable;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class User implements Serializable {
	private long id;
	private String name;
	private Integer age;
	private String email;
	private String password;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		User user = (User) o;

		return email != null ? email.equals(user.email) : user.email == null;
	}

	@Override
	public int hashCode() {
		int result = (int) (id ^ (id >>> 32));

		result = 31 * result + (email != null ? email.hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				'}';
	}
}
