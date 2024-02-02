package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.pojo.Portofolio;

public class PortofoliosDAO {

	public static ArrayList<Portofolio> getAll() throws SQLException {
		Connection conn = DBHelper.getConnection();
		ArrayList<Portofolio> result = new ArrayList<>();

		String query = "SELECT * FROM portofolios";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		while (rs.next()) {
			Portofolio portfolio = new Portofolio();
			portfolio.setId(rs.getInt("id"));
			portfolio.setStockId(rs.getInt("stock_id"));
			portfolio.setUserId(rs.getInt("user_id"));
			portfolio.setQuantity(rs.getInt("quantity"));

			result.add(portfolio);
		}
		return result;
	}

	public static Portofolio getById(int id) throws SQLException {
		Portofolio portfolio = null;

		Connection conn = DBHelper.getConnection();

		String query = "SELECT * FROM portofolios WHERE id=" + id;

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);

		if (rs.next()) {
			portfolio = new Portofolio();
			portfolio.setId(rs.getInt("id"));
			portfolio.setStockId(rs.getInt("stock_id"));
			portfolio.setUserId(rs.getInt("user_id"));
			portfolio.setQuantity(rs.getInt("quantity"));
		}

		return portfolio;
	}

	public static void insert(Portofolio portfolio) throws SQLException {
		Connection conn = DBHelper.getConnection();

		String sql = "INSERT INTO portofolios (stock_id, user_id, quantity) VALUES (" + portfolio.getStockId() + ","
				+ portfolio.getUserId() + "," + portfolio.getQuantity() + ")";

		Statement stmt = conn.createStatement();
		int rowsInserted = stmt.executeUpdate(sql);

		if (rowsInserted > 0) {
			System.out.println("A new portfolio entry was inserted successfully!");
		}
	}

	public static void update(Portofolio portfolio) throws SQLException {
		Connection conn = DBHelper.getConnection();

		String query = "UPDATE portofolios " + "SET stock_id = " + portfolio.getStockId() + ", " + "user_id = "
				+ portfolio.getUserId() + ", " + "quantity = " + portfolio.getQuantity() + " " + "WHERE id = "
				+ portfolio.getId();

		Statement stmt = conn.createStatement();
		int rowsUpdated = stmt.executeUpdate(query);

		if (rowsUpdated > 0) {
			System.out.println("Portfolio entry was updated successfully!");
		} else {
			System.out.println("Failed to update portfolio entry!");
		}
	}
	
	public static void delete(int id) throws SQLException {
		
		String sql = "DELETE FROM portofolios WHERE id=" + id;
		
		Connection conn = DBHelper.getConnection();

		Statement stmt = conn.createStatement();

		int rowsDeleted = stmt.executeUpdate(sql);
		if (rowsDeleted > 0) {
			System.out.println("Portfolio was deleted successfully!");
		}
	}
	
}
