package UserObjects;

public class SingleOrder {
	
    
	private long singleOrderId;
	private long portfolioId ;
	private long OrderId;
	private long BlockId;
	private String symbol;
	private int quantity;
	private String action;
	private double stopPrice;
	private double limitPrice;
	private double pricePaid;
	private String stockExchange;
	private String accountType;
	private String orderType;
	private String status;
    private long pmId;
    private long assignedTo;

    
    public SingleOrder(long SingleOrderId, long portfolioId, long OrderId, long BlockId, String symbol, int quantitiy, String action, double stopPrice, double limitPrice, double pricePaid, String stockExchange, String accountType, String orderType, String status) {
        this.singleOrderId = SingleOrderId;
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
        
        this.action = (String)object[4];
        if(object[5] != null){
            this.stopPrice = (double)object[5];
        }
        if(object[6] != null){
            this.limitPrice = (double)object[6];
        }
        this.stockExchange = (String)object[7];
        
            
        if(object[8] != null){
            this.accountType = (String)object[8];
            
        }
        if(object[5] == null && object[6] == null){
            this.orderType = "Market Order"; //MARKET ORDER
        }
        if(object[5] != null && object[6] == null){
            this.orderType = "Stop Order"; //STOP ORDER
        }
        if(object[5] == null && object[6] != null){
            this.orderType = "Limit Order"; //LIMIT ORDER
        }
        if(object[5] != null && object[6] != null){
            this.orderType = "Stop Limit Order"; //STOP LIMIT ORDER
        }
        this.pmId = (long)object[10];
    }
    
    //SINGLE ORDER PARSED FROM TABLE - AT POINT OF SUBMITTING BY PM
    public SingleOrder(Object[] object) {
        
            this.portfolioId = (long)object[0];
            
            //COLUMN 1: STOCK EXCHANGE: REQUIRED
            this.stockExchange = (String)object[1];
            
            this.symbol = (String)object[2];
            this.quantity = (int)object[3];
            
            this.action = (String)object[4];
            
            
            if(object[5] != null){
                this.stopPrice = (double)object[5];
            }
            if(object[6] != null){
                this.limitPrice = (double)object[6];
            }
            //this.pricePaid = (double)pricePaid;
            
            
            
            if(object[7] != null){
                this.accountType = (String)object[7];
                
            }
            
            
            if(object[5] == null && object[6] == null){
                this.orderType = "Market Order"; //MARKET ORDER
            }
            if(object[5] != null && object[6] == null){
                this.orderType = "Stop Order"; //STOP ORDER
            }
            if(object[5] == null && object[6] != null){
                this.orderType = "Limit Order"; //LIMIT ORDER
            }
            if(object[5] != null && object[6] != null){
                this.orderType = "Stop Limit Order"; //STOP LIMIT ORDER
            }
            
    }

    @Override
    public String toString() {
        return "SingleOrder{" + "SingleOrderId=" + singleOrderId + ", portfolioId=" + portfolioId + ", OrderId=" + OrderId + ", BlockId=" + BlockId + ", symbol=" + symbol + ", quantitiy=" + quantity + ", action=" + action + ", stopPrice=" + stopPrice + ", limitPrice=" + limitPrice + ", pricePaid=" + pricePaid + ", stockExchange=" + stockExchange + ", accountType=" + accountType + ", orderType=" + orderType + ", status=" + status + '}';
    } 

    public long getSingleOrderId() {
        return singleOrderId;
    }

    public void setSingleOrderId(long SingleOrderId) {
        this.singleOrderId = SingleOrderId;
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

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
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

    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
