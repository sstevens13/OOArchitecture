package assetManager;

public interface PricingVisitor {
	double visit(Stock stock);
	double visit(MoneyMarket moneyMarket);
	double visit(Bond bond);
	double visit(Portfolio portfolio);
	double visit(Account account);
}
