package UserObjects;

import java.util.ArrayList;
import java.util.List;

public class Block {
    //CONSTRUCTOR FOR CREATING BLOCKS IN TRADER WINDOW
    public Block(String symbol, int quantity, int orderType, double stopPrice, double limitPrice, int status, List<SingleOrder> holdingOrders,String stockExchange) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.orderType = orderType;
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
        this.status = status;
        this.holdingOrders = holdingOrders;
    }

    public Block(String commonSymbol, int totalQuantity, int commonOrderType,
			double commonStop, double commonLimit, int i, ArrayList c) {
		this.symbol = commonSymbol;
		this.quantity = totalQuantity;
		this.orderType = commonOrderType;
		this.stopPrice = commonStop;
		this.limitPrice = commonLimit;
		this.status = i;
		this.holdingOrders = c;
	}

	long blockId;
	long traderId;
	long brokerId;
	String symbol;
	int quantity;
	int orderType;
	double stopPrice;
	double limitPrice;
    String stockExchange;
    List<SingleOrder> holdingOrders;
    int status;

    public void setHoldingOrders(List<SingleOrder> holdingOrders) {
        this.holdingOrders = holdingOrders;
    }

    public List<SingleOrder> getHoldingOrders() {
        return holdingOrders;
    }
	
	
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

        public void setBrokerID(long brokerId) {
            this.brokerId = brokerId;
        }
        
        public long getBrokerID() {
            return this.brokerId;
        }

    public long getTraderId() {
        return traderId;
    }

    public void setTraderId(long traderId) {
        this.traderId = traderId;
    }

    public long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(long brokerId) {
        this.brokerId = brokerId;
    }
       
}
