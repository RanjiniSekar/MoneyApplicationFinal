package UserObjects;

public class SingleOrder {
	
    
	private long SingleOrderId;
	private long portfolioId ;
	private long OrderId;
	private long BlockId;
	private String symbol;
	private int quantity;
	private int action;
	private double stopPrice;
	private double limitPrice;
	private double pricePaid;
	private int stockExchange;
	private int accountType;
	private int orderType;
	private int status;
        private long pmId;
        private long assignedTo;

    public SingleOrder(long SingleOrderId, long portfolioId, long OrderId, long BlockId, String symbol, int quantitiy, int action, double stopPrice, double limitPrice, double pricePaid, int stockExchange, int accountType, int orderType, int status) {
        this.SingleOrderId = SingleOrderId;
        this.portfolioId = portfolioId;
        this.OrderId = OrderId;
        this.BlockId = BlockId;
        this.symbol = symbol;
        this.quantity = quantitiy;
        this.action = action;
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
        this.pricePaid = pricePaid;
        this.stockExchange = stockExchange;
        this.accountType = accountType;
        this.orderType = orderType;
        this.status = status;
    }

    public SingleOrder() {
        
    }

    public void SingleOrderMakeBlocks(Object[] object){
        
        this.OrderId = (long)object[0];
        this.portfolioId = (long)object[1];    
        this.symbol = (String)object[2];
        this.quantity = (int)object[3];
        String actionI = (String)object[4];
        if(actionI.equals("Sell")){
            this.action = 0;
        }
        else if(actionI.equals("Buy")){
            this.action = 1;
        }
        if(object[5] != null){
            this.stopPrice = (double)object[5];
        }
        if(object[6] != null){
            this.limitPrice = (double)object[6];
        }
        String exchange = (String)object[7];
        if(exchange.equals("New York Exchange")){
            this.stockExchange = 0;
        }
        else if(exchange.equals("London Stock Exchange")){
            this.stockExchange = 1;
        }
            
        if(object[8] != null){
            String acctT = (String)object[8];
            if(acctT.equals("Margin Account")){
                this.accountType = 0;
            }
            else if(acctT.equals("Cash Account")){
                this.accountType = 1;
            }
        }
        if(object[5] == null && object[6] == null){
            this.orderType = 0; //MARKET ORDER
        }
        if(object[5] != null && object[6] == null){
            this.orderType = 1; //STOP ORDER
        }
        if(object[5] == null && object[6] != null){
            this.orderType = 2; //LIMIT ORDER
        }
        if(object[5] != null && object[6] != null){
            this.orderType = 3; //STOP LIMIT ORDER
        }
        this.pmId = (long)object[10];
    }
    
    //SINGLE ORDER PARSED FROM TABLE - AT POINT OF SUBMITTING BY PM
    public SingleOrder(Object[] object) {
        
            this.portfolioId = (long)object[0];
            
            
            this.symbol = (String)object[1];
            this.quantity = (int)object[2];
            
            String actionI = (String)object[3];
            if(actionI.equals("Sell")){
                this.action = 0;
            }
            else if(actionI.equals("Buy")){
                this.action = 1;
            }
            
            if(object[4] != null){
                this.stopPrice = (double)object[4];
            }
            if(object[5] != null){
                this.limitPrice = (double)object[5];
            }
            //this.pricePaid = (double)pricePaid;
            //COLUMN 6: STOCK EXCHANGE: REQUIRED
            String exchange = (String)object[6];
            if(exchange.equals("New York Exchange")){
                this.stockExchange = 0;
            }
            else if(exchange.equals("London Stock Exchange")){
                this.stockExchange = 1;
            }
            
            if(object[7] != null){
                String acctT = (String)object[7];
                if(acctT.equals("Margin Account")){
                    this.accountType = 0;
                }
                else if(acctT.equals("Cash Account")){
                    this.accountType = 1;
                }
            }
            
            
            if(object[4] == null && object[5] == null){
                this.orderType = 0; //MARKET ORDER
            }
            if(object[4] != null && object[5] == null){
                this.orderType = 1; //STOP ORDER
            }
            if(object[4] == null && object[5] != null){
                this.orderType = 2; //LIMIT ORDER
            }
            if(object[4] != null && object[5] != null){
                this.orderType = 3; //STOP LIMIT ORDER
            }
            
    }

    @Override
    public String toString() {
        return "SingleOrder{" + "SingleOrderId=" + SingleOrderId + ", portfolioId=" + portfolioId + ", OrderId=" + OrderId + ", BlockId=" + BlockId + ", symbol=" + symbol + ", quantitiy=" + quantity + ", action=" + action + ", stopPrice=" + stopPrice + ", limitPrice=" + limitPrice + ", pricePaid=" + pricePaid + ", stockExchange=" + stockExchange + ", accountType=" + accountType + ", orderType=" + orderType + ", status=" + status + '}';
    } 

    public long getSingleOrderId() {
        return SingleOrderId;
    }

    public void setSingleOrderId(long SingleOrderId) {
        this.SingleOrderId = SingleOrderId;
    }

    public long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(long portfolioId) {
        this.portfolioId = portfolioId;
    }

    public long getOrderId() {
        return OrderId;
    }

    public void setOrderId(long OrderId) {
        this.OrderId = OrderId;
    }

    public long getBlockId() {
        return BlockId;
    }

    public void setBlockId(long BlockId) {
        this.BlockId = BlockId;
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

    public double getPricePaid() {
        return pricePaid;
    }

    public void setPricePaid(double pricePaid) {
        this.pricePaid = pricePaid;
    }

    public int getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(int stockExchange) {
        this.stockExchange = stockExchange;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getPmId() {
        return pmId;
    }

    public void setPmId(long pmId) {
        this.pmId = pmId;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }
    
}
