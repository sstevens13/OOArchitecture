package assetManager;

import java.util.Iterator;

public class MoneyMarket implements Asset {
	private String moneyMarketName;
	private int quantity;
	
	public MoneyMarket(String moneyMarketName, int quantity) {
		this.moneyMarketName = moneyMarketName.toLowerCase() + "-MONEYMARKET";
		this.quantity = quantity;
	}
	
	public void add(Asset asset) {
		System.out.println("Can't add to a MoneyMarket Object (leaf)");
	}

	public void remove(String assetName) {
		System.out.println("Can't remove from a MoneyMarket Object (leaf)");
	}
	
	public boolean equals(String assetName) {
		if (this.toString().equalsIgnoreCase(assetName)) return true;
		return false;
	}
	
	public String toString() {
		return moneyMarketName;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}
	
	public double currentValue() {
		return (double) getQuantity();
	}
	
	public Iterator<Asset> createAssetIterator() {
		return new NullIterator();
	}
}
