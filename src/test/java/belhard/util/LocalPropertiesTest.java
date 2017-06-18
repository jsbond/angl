package belhard.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lenovo on 18.06.2017.
 */
public class LocalPropertiesTest {
	@Test
	public void shouldReturnDBProperty() throws Exception {
		LocalProperties properties = new LocalProperties();
		String actual = properties.get("db.url");
		Assert.assertEquals("jdbc:mysql://localhost:3306/angl", actual);
	}

}