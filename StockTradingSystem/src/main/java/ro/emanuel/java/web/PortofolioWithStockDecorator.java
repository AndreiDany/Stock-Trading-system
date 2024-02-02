package ro.emanuel.java.web;

import java.sql.SQLException;

import ro.emanuel.java.dao.StockDAO;
import ro.emanuel.java.pojo.Portofolio;
import ro.emanuel.java.pojo.Stock;

//Decorator - pentru ca obiectele din lista trimisa spre view-ul care afiseaza portofoliu sa contina toate informatiile necesare
public class PortofolioWithStockDecorator extends Portofolio {

	public Stock stock;

	public PortofolioWithStockDecorator(Portofolio portfolio) throws SQLException {
		this.setId(portfolio.getId());
		this.setStockId(portfolio.getStockId());
		this.setUserId(portfolio.getUserId());
		this.setQuantity(portfolio.getQuantity());
		this.stock = StockDAO.getById(portfolio.getStockId());
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

}
