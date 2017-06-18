package belhard.util;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCFactory {
	private static Logger logger = Logger.getLogger(JDBCFactory.class);
	private static LocalProperties properties = new LocalProperties();
	private static final String DB_URL = "db.url";
	private static final String DB_LOGIN = "db.login";
	private static final String DB_PASSWORD = "db.pass";
	private static final String SQL_DRIVER = "db.mysql.driver";

	public static Connection getConnection() {
		try {
			Connection connection;
			Class.forName(properties.get(SQL_DRIVER));
			logger.info("MySQL JDBC Driver Registered!");

			connection = DriverManager
					.getConnection(properties.get(DB_URL), properties.get(DB_LOGIN), properties.get(DB_PASSWORD));

			logger.info("connection to database created");
			return connection;
		} catch (ClassNotFoundException e) {
			logger.error("MySQL driver is not loaded");
			return null;
		} catch (SQLException e) {
			logger.error("Connection to database failed.");
			return null;
		}
	}
}
