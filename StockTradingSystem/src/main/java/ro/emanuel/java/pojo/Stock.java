package ro.emanuel.java.pojo;

public class Stock {

	int id;
	String name;
	String tickerSymbol;
	Float price;
	int quantity;
	

	public Stock(int id, String name, String tickerSymbol, Float price, int quantity) {
		this.id = id;
		this.name = name;
		this.tickerSymbol = tickerSymbol;
		this.price = price;
		this.quantity = quantity;
	}

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTickerSymbol() {
		return tickerSymbol;
	}


	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
