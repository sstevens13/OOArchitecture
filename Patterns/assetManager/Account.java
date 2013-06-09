package assetManager;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Account implements Asset {
	private List<Asset> assets = new LinkedList<Asset>();
	private String accountName;
	
	//*************************************************************************
	//*  on instantiation -ACCOUNT is added to the end of accountName
	//*************************************************************************
	public Account(String accountName) {
		this.accountName = accountName.toLowerCase() + "-ACCOUNT"; 
	}
	
	public void add(Asset asset) {
		assets.add(asset);
	}

	//*************************************************************************
	//*  uses (overridden) equals
	//*************************************************************************
	public void remove(String assetName) {
		Iterator<Asset> iterator = assets.iterator();
		Asset childAsset = null;
		while(iterator.hasNext()) {
			childAsset = iterator.next();
			if (childAsset.equals(assetName)) {
				iterator.remove();
			}
		}
	}

	//*************************************************************************
	//*  compares assetNames (each assetName ends with it's type, i.e. -ACCOUNT)
	//*************************************************************************
	public boolean equals(String assetName) {
		if ( this.toString().equalsIgnoreCase(assetName)) return true;
		return false;
	}
	
	public String toString() {
		return accountName;
	}
	
	//*************************************************************************
	//*  returns the sum of the values of all children of the node
	//*************************************************************************
	public double currentValue() {
		Iterator<Asset> iterator = new AssetIterator(assets.iterator());
		AssetPricingVisitor visitor = new AssetPricingVisitor();
		double assetValue = 0;
		while(iterator.hasNext()) {
			assetValue += iterator.next().accept(visitor);
		}
		return assetValue;
	}

	public double accept(PricingVisitor visitor) {
		return visitor.visit(this);
	}

	public Iterator<Asset> createAssetIterator() {
		return assets.iterator();
	}

}
