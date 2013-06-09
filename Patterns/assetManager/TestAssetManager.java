package assetManager;

public class TestAssetManager {
	static AssetManager manager = AssetManager.getInstance();

	public static void main(String[] args) {
		manager.addAccount("user1");
		System.out.println("added user1-ACCOUNT to rootAccount");
		manager.addPortfolioToAsset("user1-ACCOUNT", "portfolio1");
		System.out.println("  added portfolio1 to user1-ACCOUNT");
		manager.addStockToAsset("portfolio1-PORTFOLIO", "aapl", 100, 10); // $1000
		System.out.println("    added $1000 of aapl-STOCK to portfolio1");
		manager.addBondToAsset("portfolio1-PORTFOLIO", "5year", 100, 1, 100, 5); // $100
		System.out.println("    added $100 of 5year-BOND to portfolio1");
		manager.addMoneyMarketToAsset("portfolio1-PORTFOLIO", "sprxx", 100); // $100
		System.out.println("    added $100 of sprxx-MONEYMARKET to portfolio1");
		manager.addPortfolioToAsset("portfolio1-PORTFOLIO", "childportfolio1");
		System.out.println("    added childportfolio1 to portfolio1");
		manager.addStockToAsset("childportfolio1-PORTFOLIO", "ge", 20, 5);	// $100
		manager.addStockToAsset("childportfolio1-PORTFOLIO", "itrn", 20, 5); // $100
		System.out.println("      added $100 of ge-STOCK and $100 of itrn-STOCK to childportfolio1");
		System.out.println("user1-ACCOUNT should be worth $1400");
		System.out.format("value of user1-Account: $%.2f%n", manager.getAssetValue("user1-ACCOUNT")); 
		System.out.println("childportfolio1 should be worth $200");
		System.out.format("value of childportfolio1-PORTFOLIO: $%.2f%n", manager.getAssetValue("childportfolio1-PORTFOLIO")); 
		
		System.out.println("\n\n");


		manager.addAccount("user2");
		System.out.println("added user2-ACCOUNT to rootAccount");
		manager.addPortfolioToAsset("user2-ACCOUNT", "portfolio2");
		System.out.println("  added portfolio2 to user2-ACCOUNT");
		manager.addStockToAsset("portfolio2-PORTFOLIO", "aapl", 100, 1); // $100
		System.out.println("    added $100 of aapl to portfolio2");
		manager.addStockToAsset("portfolio2-PORTFOLIO", "aapl", 100, 1); // $100
		System.out.println("    tried to add a second instance of $100 of aapl to portfolio2 (should fail)");
		manager.addPortfolioToAsset("portfolio2-PORTFOLIO", "childportfolio2"); 
		System.out.println("    added childportfolio2 to portfolio2");
		manager.addPortfolioToAsset("childportfolio2-PORTFOLIO", "childportfolio2-2");
		System.out.println("      added childportfolio2-2 to childportfolio2");
		manager.addStockToAsset("childportfolio2-PORTFOLIO", "bud", 10, 1); // $10
		System.out.println("      added $10 of bud to childportfolio2");
		manager.addStockToAsset("childportfolio2-2-PORTFOLIO", "bud", 10, 1); // $10
		System.out.println("        added $10 of bud to childportfolio2-2");
		System.out.println("user2-Account should be worth $120");
		System.out.format("value of user2-Account: $%.2f%n", manager.getAssetValue("user2-ACCOUNT"));
		System.out.println("value of user1-ACCOUNT + user2-ACCOUNT should be: $1400 + $120 = $1520");
		System.out.format("value of all accounts: $%.2f%n", manager.getValueAllAssets());
		
		System.out.println("\nRemoving aapl from user2-Account, should now be worth $20");
		manager.removeAssetFromAsset("portfolio2-PORTFOLIO", "aapl-STOCK");
		System.out.format("value of user2-Account: $%.2f%n", manager.getAssetValue("user2-ACCOUNT"));
		
		System.out.println("\nvalue of user1-ACCOUNT + user2-ACCOUNT should be: $1400 + $20 = $1420");
		System.out.format("value of all accounts: $%.2f%n", manager.getValueAllAssets());
		
		System.out.println("\nTrying to add node to a leaf"); 
		manager.addPortfolioToAsset("aapl-STOCK", "portfolioToLeaf");
	}
	
}
