package belhard.dao;

import belhard.entity.User;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserDAOTest {

	private static UserDAO dao = new UserDAO();

	@Test
	public void shouldSaveAndRemoveUser() throws Exception {
		//given
		User user = new User();
		user.setAge(12);
		user.setName("Petya");
		user.setEmail("testemail@test.com");
		user.setPassword("1234");

		//when
		boolean saveResult = dao.save(user);
		boolean deleteResult = dao.delete("testemail@test.com");

		//then
		Assert.assertTrue(saveResult);
		Assert.assertTrue(deleteResult);
	}

	@Test
	public void shouldReturnUserById() {
		User actual = dao.find(1L);

		Assert.assertEquals("test1@test.com", actual.getEmail());
		Assert.assertEquals(new Integer(10), actual.getAge());
	}

	@Test
	public void shouldReturnUserByEmail() {
		User actual = dao.find("test1@test.com");

		Assert.assertEquals("test1", actual.getName());
		Assert.assertEquals(new Integer(10), actual.getAge());
	}
}