package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.User;

public class UsersDAO {

	public static User getByEmail(String email) throws SQLException {

		Connection conn = DBHelper.getConnection();

		String query = "select * from users where email= '" + email + "'";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		User u = null;

		if (rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setName(rs.getString("name"));
			u.setEmail(rs.getString("email"));
			u.setPassword(rs.getString("password"));

		}

		return u;
	}

	public static int create(User u) throws SQLException {

		Connection conn = DBHelper.getConnection();

		String sql = "insert into users(name, email, password) " + "value ('" + u.getName() + "', '" + u.getEmail() + "', '"
				+ u.getPassword() + "')";

		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		int rowsInserted = stmt.executeUpdate();

		if (rowsInserted > 0) {
			System.out.println("User successfully created!");
		}

		try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
			if (generatedKeys.next()) {
				u.setId(generatedKeys.getInt(1));
			} else {
				throw new SQLException("Error creating the user!");
			}
		}

		return u.getId();

	}

}
