package ro.emanuel.java.web;

import java.sql.SQLException;

import ro.emanuel.java.dao.PortofoliosDAO;
import ro.emanuel.java.dao.StockDAO;
import ro.emanuel.java.pojo.Portofolio;
import ro.emanuel.java.pojo.Stock;

public class AddToPortofolioMethods extends AddToPortofolioTemplateMethod {

    @Override
    protected Portofolio createPortfolioItem(int userId, int stockId, int quantity) {
        Portofolio portofolioItem = new Portofolio();
        portofolioItem.setUserId(userId);
        portofolioItem.setStockId(stockId);
        portofolioItem.setQuantity(quantity);
        return portofolioItem;
    }

    @Override
    protected void insertItemIntoPortfolio(Portofolio portofolioItem) throws SQLException {
        PortofoliosDAO.insert(portofolioItem);
    }
    
    @Override
    protected void modifystockQuantity(int stockId) throws SQLException {
    	
    	Stock stock = StockDAO.getById(stockId);
    	
    	stock.setQuantity(stock.getQuantity() - 1);
    	
    	StockDAO.update(stock);
    }
}
