package ro.emanuel.java.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ro.emanuel.java.helpers.DBHelper;
import ro.emanuel.java.helpers.StockBuilder;
import ro.emanuel.java.pojo.Stock;

public class StockDAO {

    public static ArrayList<Stock> getAll() throws SQLException {
        Connection conn = DBHelper.getConnection();
        ArrayList<Stock> result = new ArrayList<>();

        String query = "SELECT * FROM stocks";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
        	//Utilizarea design pattern-ului Builder
            Stock stock = new StockBuilder()
                    .StockBuilderId(rs.getInt("id"))
                    .StockBuilderName(rs.getString("name"))
                    .addTickerSymbol(rs.getString("ticker_symbol"))
                    .addPrice(rs.getFloat("price"))
                    .addQuantity(rs.getInt("quantity"))
                    .build();

            result.add(stock);
        }
        return result;
    }

    public static Stock getById(int id) throws SQLException {
        Stock stock = null;

        Connection conn = DBHelper.getConnection();

        String query = "SELECT * FROM stocks WHERE id=" + id;

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        if (rs.next()) {
            stock = new StockBuilder()
                    .StockBuilderId(rs.getInt("id"))
                    .StockBuilderName(rs.getString("name"))
                    .addTickerSymbol(rs.getString("ticker_symbol"))
                    .addPrice(rs.getFloat("price"))
                    .addQuantity(rs.getInt("quantity"))
                    .build();
        }

        return stock;
    }

    public static void insert(Stock stock) throws SQLException {
        Connection conn = DBHelper.getConnection();

        String sql = "INSERT INTO stocks (name, ticker_symbol, price, quantity) VALUES ('"
                + stock.getName() + "','" + stock.getTickerSymbol() + "'," + stock.getPrice() + ","
                + stock.getQuantity() + ")";

        Statement stmt = conn.createStatement();
        int rowsInserted = stmt.executeUpdate(sql);

        if (rowsInserted > 0) {
            System.out.println("A new stock was inserted successfully!");
        }
    }

    public static void update(Stock stock) throws SQLException {
        Connection conn = DBHelper.getConnection();

        String query = "UPDATE stocks SET "
                + "name = '" + stock.getName() + "', "
                + "ticker_symbol = '" + stock.getTickerSymbol() + "', "
                + "price = " + stock.getPrice() + ", "
                + "quantity = " + stock.getQuantity() + " "
                + "WHERE id = " + stock.getId();

        Statement stmt = conn.createStatement();
        int rowsUpdated = stmt.executeUpdate(query);

        if (rowsUpdated > 0) {
            System.out.println("Stock details were updated successfully!");
        } else {
            System.out.println("Failed to update stock details!");
        }
    }
}
