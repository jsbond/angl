package belhard.service;

import belhard.dao.UserDAO;
import belhard.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnit44Runner;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 08.06.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	@Mock
	private UserDAO userDAO;

	@InjectMocks
	private UserService userService;

	@Spy
	private List<Integer> ints = new ArrayList<>();

	@Test
	public void test() {
		ints.add(1);
		ints.add(2);
		ints.add(3);
		Mockito.when(ints.size()).thenReturn(100);

		Assert.assertEquals(100, ints.size());
		ints.get(0);

	}

	@Test
	public void findUserById() throws Exception {
		//when
		User user = new User();
		user.setId(100L);
		user.setName("1");
		user.setAge(12);

		Mockito.when(userDAO.find(100L)).thenReturn(user);

		//then
		User actual = userService.findUserById("100");

		//verify
		Assert.assertEquals(100L, actual.getId());
		Assert.assertEquals("1", actual.getName());
		Assert.assertEquals(new Integer(12), actual.getAge());

		Mockito.verify(userDAO, Mockito.times(1)).find(100);
	}

	@Test
	public void saveUser() throws Exception {
	}

}