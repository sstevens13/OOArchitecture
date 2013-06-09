package assetManager;

public class AssetPricingVisitor implements PricingVisitor {

	public double visit(Portfolio portfolio) {
		return 0;
	}

	public double visit(Account account) {
		return 0;
	}

	/*
	 * stock is equal to price * quantity
	 */
	public double visit(Stock stock) {
		return stock.getPrice()*((double)stock.getQuantity());
	}

	/*
	 * MoneyMarkets are (supposed to be) worth a $1 each
	 * thus just need to return the quantity
	 */
	public double visit(MoneyMarket moneyMarket) {
		return (double) moneyMarket.getQuantity();
	}

	/*
	 * there's a pretty complex equation to calculate bond prices
	 * based off of bond rating, face value, duration, interest rate
	 * or one can just look at the market price and assume that the 
	 * competitors have calculated the fair value. not to mention that
	 * in most valuation scenarios, mark to market is the best option 
	 */
	public double visit(Bond bond) {
		return bond.getMarketPrice()*bond.getQuantity();
	}

}
