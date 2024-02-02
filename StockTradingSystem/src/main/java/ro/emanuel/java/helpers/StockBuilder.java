package ro.emanuel.java.helpers;

import ro.emanuel.java.pojo.Stock;

// Builder - pentru a putea construi pas cu pas obiectele de tip Stock
public class StockBuilder {
	private int id;
    private String name;
    private String tickerSymbol;
    private Float price;
	int quantity;

    public StockBuilder StockBuilderId(int id) {
        this.id = id;
        return this;
    }
    
    public StockBuilder StockBuilderName(String name) {
        this.name = name;
        return this;
    }

    public StockBuilder addTickerSymbol(String tickerSymbol) {
        this.tickerSymbol = tickerSymbol;
        return this;
    }

    public StockBuilder addPrice(Float price) {
        this.price = price;
        return this;
    }
    
    public StockBuilder addQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Stock build() {
        return new Stock(id, name, tickerSymbol, price, quantity);
    }
}
