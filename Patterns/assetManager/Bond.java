package assetManager;

import java.util.Iterator;

public class Bond implements Asset {
	private String bondName;
	private double marketPrice;
	private int quantity;
	private double faceValue;
	private double interestRate;
	
	public Bond(String bondName, double marketPrice, int quantity, 
			double faceValue, double interestRate) {
		this.bondName = bondName.toLowerCase() + "-BOND";
		this.marketPrice = marketPrice;
		this.quantity = quantity;
		this.faceValue = faceValue;
		this.interestRate = interestRate;
	}
	
	public void add(Asset asset) {
		System.out.println("Can't add to a Bond Object (leaf)");
	}

	public void remove(String assetName) {
		System.out.println("Can't remove from a Bond Object (leaf)");
	}
	
	public boolean equals(String assetName) {
		if (this.toString().equalsIgnoreCase(assetName)) return true;
		return false;
	}
	
	public String toString() {
		return bondName;
	}
	
	public double getMarketPrice() {
		return marketPrice;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public double getFaceValue() {
		return faceValue;
	}
	
	public double getInterestRate() {
		return interestRate;
	}

	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}

	public double currentValue() {
		return getMarketPrice() * ((double) getQuantity());
	}
	
	public Iterator<Asset> createAssetIterator() {
		return new NullIterator();
	}

}
