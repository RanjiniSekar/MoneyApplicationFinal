package UserObjects;

import java.util.ArrayList;
import java.util.List;

public class Block {
    //CONSTRUCTOR FOR CREATING BLOCKS IN TRADER WINDOW
    public Block(long t_id,long id, String b_name, String email, String symbol, int quantity, String orderType, String status, List<SingleOrder> holdingOrders,String stockExchange) {
        this.t_id = t_id;
        this.b_id = id;
        this.b_name = b_name;
        this.b_email = email;
    	this.symbol = symbol;
        this.quantity = quantity;
        this.order_type = orderType;
        this.status = status;
        this.holdingOrders = holdingOrders;
    }

    public Block(String commonSymbol, int totalQuantity, String commonOrderType,
			double commonStop, double commonLimit, String i, ArrayList c) {
		this.symbol = commonSymbol;
		this.quantity = totalQuantity;
		this.order_type = commonOrderType;
		//this.stopPrice = commonStop;
		//this.limitPrice = commonLimit;
		this.status = i;
		this.holdingOrders = c;
	}

	long block_id;
	long t_id;
	long b_id;
	String b_email;
        String b_name;
	String symbol;
	int quantity;
	String order_type;	
        long price_executed;
        
    String stockExchange;
    List<SingleOrder> holdingOrders;
    String status;
    public Block(long block_id, long t_id, long b_id, String b_name,String b_email, String symbol, int quantity, String order_type, long price_executed, String stockExchange, List<SingleOrder> holdingOrders, String status) {
        this.block_id = block_id;
        this.t_id = t_id;
        this.b_id = b_id;
        this.b_name = b_name;
        this.b_email = b_email;
        this.symbol = symbol;
        this.quantity = quantity;
        this.order_type = order_type;
        this.price_executed = price_executed;
        this.stockExchange = stockExchange;
        this.holdingOrders = holdingOrders;
        this.status = status;
    }

    
    
    
    
    public void setHoldingOrders(List<SingleOrder> holdingOrders) {
        this.holdingOrders = holdingOrders;
    }

    public List<SingleOrder> getHoldingOrders() {
        return holdingOrders;
    }
	
	
	public long getBlockId() {
		return block_id;
	}
	public void setBlockId(long blockId) {
		this.block_id = blockId;
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

        public void setBrokerID(long brokerId) {
            this.b_id = brokerId;
        }
        
        public long getBrokerID() {
            return this.b_id;
        }

    public long getTraderId() {
        return t_id;
    }

    public void setTraderId(long traderId) {
        this.t_id = traderId;
    }

    public long getBrokerId() {
        return b_id;
    }

    public void setBrokerId(long brokerId) {
        this.b_id = brokerId;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public long getPriceExecuted() {
        return price_executed;
    }

    public void setPriceExecuted(long price_executed) {
        this.price_executed = price_executed;
    }

    @Override
    public String toString() {
        return "Block{" + "block_id=" + block_id + ", t_id=" + t_id + ", b_id=" + b_id + ", b_email=" + b_email + ", b_name=" + b_name + ", symbol=" + symbol + ", quantity=" + quantity + ", order_type=" + order_type + ", price_executed=" + price_executed + ", stockExchange=" + stockExchange + ", holdingOrders=" + holdingOrders + ", status=" + status + '}';
    }
       
    
    
}
