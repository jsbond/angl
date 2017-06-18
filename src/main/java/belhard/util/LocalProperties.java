package belhard.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Lenovo on 18.06.2017.
 */
public class LocalProperties {
	private Properties properties;

	public LocalProperties() {
		load();
	}

	private void load() {
		try (FileInputStream fis = new FileInputStream("src/main/resources/local.properties")){
			properties = new Properties();
			properties.load(fis);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public String get(String name) {
		return properties.getProperty(name);
	}
}
