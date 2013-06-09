package assetManager;

import java.util.Iterator;

public class Stock implements Asset {
	private String stockName;
	private double price;
	private int quantity;
	
	public Stock(String stockName, double price, int quantity) {
		this.stockName = stockName.toLowerCase() + "-STOCK";
		this.price = price;
		this.quantity = quantity;
	}
	
	public void add(Asset asset) {
		System.out.println("Can't add to a Stock Object (leaf)");
	}

	public void remove(String assetName) {
		System.out.println("Can't remove from a Stock Object (leaf)");
	}
	
	public boolean equals(String assetName) {
		if (this.toString().equalsIgnoreCase(assetName)) return true;
		return false;
	}
	
	public String toString() {
		return stockName;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}

	public double currentValue() {
		return getPrice() * ((double) getQuantity());
	}
	
	public Iterator<Asset> createAssetIterator() {
		return new NullIterator();
	}

}
