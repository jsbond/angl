package belhard.dao;

import belhard.exception.IllegalRequestException;
import belhard.entity.User;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08.06.2017.
 */
public class UserDAO extends AbstractDAO<User> {
	private Logger logger = Logger.getLogger(this.getClass());
	private String SAVE_QUERY = "INSERT INTO `users` (`name`, `age`, `email`, `password`) VALUES (?, ?, ?, ?)";
	private String SELECT_BY_ID_QUERY = "SELECT `id`, `name`, `age`, `email`, `password` FROM `users` WHERE id=?";
	private String SELECT_BY_EMAIL_QUERY = "SELECT `id`, `name`, `age`, `email`, `password` FROM `users` WHERE EMAIL=?";
	private String DELETE_QUERY = "DELETE FROM `users` WHERE EMAIL=?";

	public boolean save(User user) {
		try (PreparedStatement st = connection.prepareStatement(SAVE_QUERY)) {

			st.setString(1, user.getName());
			st.setInt(2, user.getAge());
			st.setString(3, user.getEmail());
			st.setString(4, user.getPassword());

			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Can't save user with name: " + user.getName());
			throw new IllegalRequestException("");
		}
	}

	public boolean delete(String email) {
		try (PreparedStatement st = connection.prepareStatement(DELETE_QUERY)) {
			st.setString(1, email);
			st.executeUpdate();
			return true;
		} catch (SQLException e) {
			logger.error("Can't delete user with email: " + email);
			throw new IllegalRequestException("");
		}
	}

	public User find(long id) {
		try (PreparedStatement st = connection.prepareStatement(SELECT_BY_ID_QUERY)) {
			st.setLong(1, id);

			ResultSet rs = st.executeQuery();
			User user = new User();

			while (rs.next()) {
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
			}
			return user;
		} catch (SQLException e) {
			logger.error("Can't find user with id: " + id);
			return null;
		}
	}

	public User find(String email) {
		try (PreparedStatement st = connection.prepareStatement(SELECT_BY_EMAIL_QUERY)) {
			st.setString(1, email);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getLong(1));
				user.setName(rs.getString(2));
				user.setAge(rs.getInt(3));
				user.setEmail(rs.getString(4));
				user.setPassword(rs.getString(5));
				return user;
			}
			return null;
		} catch (SQLException e) {
			logger.error("Can't find user with email: " + email);
			return null;
		}
	}
}
