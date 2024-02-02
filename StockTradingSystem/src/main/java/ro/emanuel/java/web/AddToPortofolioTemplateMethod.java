package ro.emanuel.java.web;

import java.sql.SQLException;

import ro.emanuel.java.pojo.Portofolio;
import ro.emanuel.java.pojo.User;

public abstract class AddToPortofolioTemplateMethod {

	// Template Method - defineste scheletul algoritmului care adauga un stock in portofoliul userului curent
	public void addToPortfolio(String id, String quantity) throws SQLException {

		int stockId = Integer.parseInt(id);
		int stockQuantity = Integer.parseInt(quantity);

		// Obtinerea userului curent
		int userId = User.getCurrentUser().getId();

		// Crearea noului item pentru portofoliu
		Portofolio portofolioItem = createPortfolioItem(userId, stockId, stockQuantity);

		// Introducerea noului item in portofoliul clientului
		insertItemIntoPortfolio(portofolioItem);
		
		// Scaderea cantitatii stock-ului
		modifystockQuantity(stockId);
		
	}

// Metoda template pentru crearea unui nou item pentru portofoliu
	protected abstract Portofolio createPortfolioItem(int userId, int stockId, int quantity);

// Metoda template pentru introducerea unui item în portofoliu
	protected abstract void insertItemIntoPortfolio(Portofolio portofolioItem) throws SQLException;
	
	protected abstract void modifystockQuantity(int stockId) throws SQLException;
}