package belhard.web;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AppServletTest {

	@Test
	public void test() {
		List<User> collection1 = new ArrayList<>();
		collection1.add(new User("Petya", 10));
		collection1.add(new User("Ivan", 20));
		collection1.add(new User("Senya", 30));
		collection1.add(new User("Sasha", 40));

		List<User> collection2 = new ArrayList<>();
		collection2.add(new User("Petya", 10));
		collection2.add(new User("Tapak", 20));
		collection2.add(new User("Senya", 30));
		collection2.add(new User("Kuku", 40));

		collection1.removeAll(collection2);

		System.out.println(collection1.size());




	}

	private static class User {
		private String username;
		private int year;

		public User(String username, int year) {
			this.username = username;
			this.year = year;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			User user = (User) o;

			if (year != user.year) return false;
			return username != null ? username.equals(user.username) : user.username == null;
		}

		@Override
		public int hashCode() {
			int result = username != null ? username.hashCode() : 0;
			result = 31 * result + year;
			return result;
		}
	}
}