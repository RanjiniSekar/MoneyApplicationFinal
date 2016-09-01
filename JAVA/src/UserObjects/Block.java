package UserObjects;

public class Block {
	
	long blockId;
	long traderId;
	long brokerId;
	String symbol;
	int quantity;
	int orderType;
	double stopPrice;
	double limitPrice;
	int status;
	
	public long getBlockId() {
		return blockId;
	}
	public void setBlockId(long blockId) {
		this.blockId = blockId;
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
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public double getStopPrice() {
		return stopPrice;
	}
	public void setStopPrice(double stopPrice) {
		this.stopPrice = stopPrice;
	}
	public double getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(double limitPrice) {
		this.limitPrice = limitPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
