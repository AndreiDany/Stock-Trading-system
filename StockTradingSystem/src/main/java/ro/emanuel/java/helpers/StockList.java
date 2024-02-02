package ro.emanuel.java.helpers;

import ro.emanuel.java.pojo.Stock;
import java.util.ArrayList;
import java.util.List;

//Singleton - pentru lista de stock-uri trebuie sa existe o singura instanta pentru toti utilizatorii
public class StockList {
	private static StockList instance;
	private List<Stock> stockList;

	private StockList() {
		stockList = new ArrayList<>();
	}

	public static StockList getInstance() {
		if (instance == null) {
			instance = new StockList();
		}
		return instance;
	}

	public void addStock(Stock stock) {
		stockList.add(stock);
	}

	public void removeStock(Stock stock) {
		stockList.remove(stock);
	}

	public List<Stock> getStockList() {
		return stockList;
	}

}