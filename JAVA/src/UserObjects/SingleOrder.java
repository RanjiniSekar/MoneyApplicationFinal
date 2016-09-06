package UserObjects;

public class SingleOrder {
	
    
	private long sorder_id;
	private long p_id;
	private long order_id;
	private long block_id;
	private String symbol;
	private int quantity;
	private String action_type;
	private double price_stop;
	private double price_limit;
	private double price_executed;
	private String stock_exchange;
	private String account_type;
	private String order_type;
	private String status;
    private long pmId;
    private long assignedTo;

    
    public SingleOrder(long SingleOrderId, long portfolioId, long OrderId, long BlockId, String symbol, int quantity, String action, double stopPrice, double limitPrice, double pricePaid, String stockExchange, String accountType, String orderType, String status) {
        this.sorder_id = SingleOrderId;
        this.p_id = portfolioId;
        this.order_id = OrderId;
        this.block_id = BlockId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.action_type = action;
        this.price_stop = stopPrice;
        this.price_limit = limitPrice;
        this.price_executed = pricePaid;
        this.stock_exchange = stockExchange;
        this.account_type = accountType;
        this.order_type = orderType;
        this.status = status;
    }

    public SingleOrder() {
        
    }

    public void SingleOrderMakeBlocks(Object[] object){
        
        this.order_id = (long)object[0];
        this.p_id = (long)object[1];    
        this.symbol = (String)object[2];
        this.quantity = (int)object[3];
        
        this.action_type = (String)object[4];
        if(object[5] != null){
            this.price_stop = (double)object[5];
        }
        if(object[6] != null){
            this.price_limit = (double)object[6];
        }
        this.stock_exchange = (String)object[7];
        
            
        if(object[8] != null){
            this.account_type = (String)object[8];
            
        }
        if(object[5] == null && object[6] == null){
            this.order_type = "Market Order"; //MARKET ORDER
        }
        if(object[5] != null && object[6] == null){
            this.order_type = "Stop Order"; //STOP ORDER
        }
        if(object[5] == null && object[6] != null){
            this.order_type = "Limit Order"; //LIMIT ORDER
        }
        if(object[5] != null && object[6] != null){
            this.order_type = "Stop Limit Order"; //STOP LIMIT ORDER
        }
        this.pmId = (long)object[10];
    }
    
    //SINGLE ORDER PARSED FROM TABLE - AT POINT OF SUBMITTING BY PM
    public SingleOrder(Object[] object) {
        
            this.p_id = (long)object[0];
            
            //COLUMN 1: STOCK EXCHANGE: REQUIRED
            this.stock_exchange = (String)object[1];
            
            this.symbol = (String)object[2];
            this.quantity = (int)object[3];
            
            this.action_type = (String)object[4];
            
            
            if(object[5] != null){
                this.price_stop = (double)object[5];
            }
            if(object[6] != null){
                this.price_limit = (double)object[6];
            }
            //this.pricePaid = (double)pricePaid;
            
            
            
            if(object[7] != null){
                this.account_type = (String)object[7];
                
            }
            
            
            if(object[5] == null && object[6] == null){
                this.order_type = "Market Order"; //MARKET ORDER
            }
            if(object[5] != null && object[6] == null){
                this.order_type = "Stop Order"; //STOP ORDER
            }
            if(object[5] == null && object[6] != null){
                this.order_type = "Limit Order"; //LIMIT ORDER
            }
            if(object[5] != null && object[6] != null){
                this.order_type = "Stop Limit Order"; //STOP LIMIT ORDER
            }
            
    }
    
    @Override
    public String toString() {
        return "SingleOrder{" + "SingleOrderId=" + sorder_id + ", portfolioId=" + p_id + ", OrderId=" + order_id + ", BlockId=" + block_id + ", symbol=" + symbol + ", quantitiy=" + quantity + ", action=" + action_type + ", stopPrice=" + price_stop + ", limitPrice=" + price_limit + ", pricePaid=" + price_executed + ", stockExchange=" + stock_exchange + ", accountType=" + account_type + ", orderType=" + order_type + ", status=" + status + '}';
    } 

    public long getSingleOrderId() {
        return sorder_id;
    }

    public void setSingleOrderId(long SingleOrderId) {
        this.sorder_id = SingleOrderId;
    }

    public long getPortfolioId() {
        return p_id;
    }

    public void setPortfolioId(long portfolioId) {
        this.p_id = portfolioId;
    }

    public long getOrderId() {
        return order_id;
    }

    public void setOrderId(long OrderId) {
        this.order_id = OrderId;
    }

    public long getBlockId() {
        return block_id;
    }

    public void setBlockId(long BlockId) {
        this.block_id = BlockId;
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
        return action_type;
    }

    public void setAction(String action) {
        this.action_type = action;
    }

    public double getStopPrice() {
        return price_stop;
    }

    public void setStopPrice(double stopPrice) {
        this.price_stop = stopPrice;
    }

    public double getLimitPrice() {
        return price_limit;
    }

    public void setLimitPrice(double limitPrice) {
        this.price_limit = limitPrice;
    }

    public double getPricePaid() {
        return price_executed;
    }

    public void setPricePaid(double pricePaid) {
        this.price_executed = pricePaid;
    }

    public String getStockExchange() {
        return stock_exchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stock_exchange = stockExchange;
    }

    public String getAccountType() {
        return account_type;
    }

    public void setAccountType(String accountType) {
        this.account_type = accountType;
    }

    public String getOrderType() {
        return order_type;
    }

    public void setOrderType(String orderType) {
        this.order_type = orderType;
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
