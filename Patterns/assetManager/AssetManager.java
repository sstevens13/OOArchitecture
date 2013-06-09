package assetManager;

import java.util.Iterator;

public class AssetManager {
	private static AssetManager instance = null;
	private Asset rootAccount = new Account("rootAccount");
	
	// Singleton thus constructor is private
	private AssetManager() {}
	
	// returns the single instance of AssetManager
	public static AssetManager getInstance() {
		if (instance == null) {
			synchronized (AssetManager.class) {
				if (instance == null) {
					instance = new AssetManager();
				}
			}
		} 
		return instance;
	}

	//*************************************************************************
	//*  AssetManager only accepts Accounts as children of RootAccount
	//*  presumption that all assets must belong to some account
	//*************************************************************************
	public void addAccount(String accountName) {
		rootAccount.add(new Account(accountName));
	}
	
	//*************************************************************************
	//*  find asset by name, then adds portfolio to asset if asset can be a 
	//*  parent
	//*************************************************************************
	public void addPortfolioToAsset(String assetName, String portfolioName) {		
		Asset asset = getAsset(assetName);
		if (asset != null) {
			asset.add(new Portfolio(portfolioName));
		} else {
			System.out.println("must add portfolio to an account or portfolio");
		}
	}
	
	//*************************************************************************
	//*  finds asset by name, then adds account to said asset if asset can be
	//*  a parent
	//*************************************************************************
	public void addAccountToAsset(String assetName, String accountName) {
		Asset asset = getAsset(assetName);
		if (asset != null) {
			asset.add(new Portfolio(accountName));
		} else {
			System.out.println("must add account to an account or portfolio");
		}
	}
	
	//*************************************************************************
	//* Finds a asset if it exists, else returns null 
	//*************************************************************************
	public Asset getAsset(String assetName) {
		Iterator<Asset> iterator = new AssetIterator(rootAccount.createAssetIterator());
		Asset currentAsset;
		while(iterator.hasNext()) {
			currentAsset = iterator.next();
			if (currentAsset.equals(assetName)) {
				return currentAsset;
			}
		}
		return null;
	}
	
	//*************************************************************************
	//*  finds parent asset (using getCompositeAsset), then adds stock if 
	//*  compositeAsset exists
	//*************************************************************************
	public void addStockToAsset(String assetName, String stockName, double price, int quantity) {
		Asset asset = getAsset(assetName);
		if (asset != null) {
			asset.add(new Stock(stockName, price, quantity));
		}
	}
	
	//*************************************************************************
	//*  finds parent asset (using getCompositeAsset), then adds bond if 
	//*  compositeAsset exists
	//*************************************************************************
	public void addBondToAsset(String assetName, String bondName, double marketPrice, int quantity, 
			double faceValue, double interestRate) {
		Asset asset = getAsset(assetName);
		if (asset != null) {
			asset.add(new Bond(bondName, marketPrice, quantity, faceValue, interestRate));
		}
	}
	
	//*************************************************************************
	//*  finds parent asset (using getCompositeAsset), then adds MoneyMarket if 
	//*  compositeAsset exists
	//*************************************************************************
	public void addMoneyMarketToAsset(String assetName, String moneyMarketName, int quantity) {
		Asset asset = getAsset(assetName);
		if (asset != null) {
			asset.add(new MoneyMarket(moneyMarketName, quantity));
		}
	}
	
	//*************************************************************************
	//*  finds parent asset (using getCompositeAsset), then adds MoneyMarket if 
	//*  compositeAsset exists
	//*************************************************************************
	public void removeAssetFromAsset(String parentAsset, String childAsset) {
		Asset asset = getAsset(parentAsset);
		if (asset != null) {
			asset.remove(childAsset);
		}
	}
	
	//*************************************************************************
	//*  finds asset by name, then finds price of asset
	//*  the price of an asset is equal to itself plus all of it's children
	//*************************************************************************
	public double getAssetValue(String assetName) {
		Asset asset = getAsset(assetName);
		if (asset == null) {
			System.out.println("    no such asset!");
			return 0;
		} else {
			return asset.currentValue();
		}
	}
	
	//*************************************************************************
	//*  returns value of all accounts
	//*************************************************************************
	public double getValueAllAssets() {
		return rootAccount.currentValue();
	}
	
}
