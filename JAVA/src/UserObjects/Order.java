package UserObjects;

public class Order {
	
	long orderId;
	long portfolioId ;
	String symbol;
	int quantitiy;
	int action;
	double stopPrice;
	double limitPrice ;
	int accountType;
	int orderType;
	long assignedTo;
	int status;

		public Order()
		{
			
			
		}

		public long getOrderId() {
			return orderId;
		}

		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}

		public long getPortfolioId() {
			return portfolioId;
		}

		public void setPortfolioId(long portfolioId) {
			this.portfolioId = portfolioId;
		}

		public String getSymbol() {
			return symbol;
		}

		public void setSymbol(String symbol) {
			this.symbol = symbol;
		}

		public int getQuantitiy() {
			return quantitiy;
		}

		public void setQuantitiy(int quantitiy) {
			this.quantitiy = quantitiy;
		}

		public int getAction() {
			return action;
		}

		public void setAction(int action) {
			this.action = action;
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

		public int getAccountType() {
			return accountType;
		}

		public void setAccountType(int accountType) {
			this.accountType = accountType;
		}

		public int getOrderType() {
			return orderType;
		}

		public void setOrderType(int orderType) {
			this.orderType = orderType;
		}

		public long getAssignedTo() {
			return assignedTo;
		}

		public void setAssignedTo(long assignedTo) {
			this.assignedTo = assignedTo;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}



}
