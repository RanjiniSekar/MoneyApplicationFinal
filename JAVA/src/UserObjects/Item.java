package UserObjects;

/**
*
* @author agiria
*/

public class Item {
	long portfolioId;
	long itemId;
	String symbol;
	int quantity;
	double pricePaid;
	double stopPrice;
	int accountType;
	long tradedBy;
	
	public long getPortfolioId() {
		return portfolioId;
	}
	
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public long getItemId() {
		return itemId;
	}
	
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double getPricePaid() {
		return pricePaid;
	}
	
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	
	public double getStopPrice() {
		return stopPrice;
	}
	
	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}
	
	public int getAccountType() {
		return accountType;
	}
	
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	
	public long getTradedBy() {
		return tradedBy;
	}
	
	public void setTradedBy(long tradedBy) {
		this.tradedBy = tradedBy;
	}
}
