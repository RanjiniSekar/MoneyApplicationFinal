package UserObjects;

public class SingleOrder {
	
	long SingleOrderId;
	long portfolioId ;
	long OrderId;
	long BlockId;
	String symbol;
	int quantity;
	int action;
	double stopPrice;
	double limitPrice;
	double pricePaid;
	int stockExchange;
	int accountType;
	int orderType;
	int status;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    
}
