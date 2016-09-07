package UserObjects;

import java.util.ArrayList;
import java.util.List;

public class Block {
    //CONSTRUCTOR FOR CREATING BLOCKS IN TRADER WINDOW
    public Block(long id, String email, String symbol, int quantity, String orderType, String status, List<SingleOrder> holdingOrders,String stockExchange) {
        this.b_id = id;
        this.b_email = email;
    	this.symbol = symbol;
        this.quantity = quantity;
        this.order_type = orderType;
        //this.stopPrice = stopPrice;
       // this.limitPrice = limitPrice;
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
	String symbol;
	int quantity;
	String order_type;
	
    long price_executed;
        
    String stockExchange;
    List<SingleOrder> holdingOrders;
    String status;

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
       
}
