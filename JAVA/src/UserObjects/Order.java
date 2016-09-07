package UserObjects;

import java.util.List;

public class Order {

    long orderId;
    long portfolioManagerId;
    long assignedTo;
    String assignedTrader;
    List<SingleOrder> containedSingleOrders;

    public Order(String assignedTrader, List<SingleOrder> containedSingleOrders) {
        this.assignedTrader = assignedTrader;
        this.containedSingleOrders = containedSingleOrders;
    }
    
    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getPortfolioManagerId() {
        return portfolioManagerId;
    }

    public void setPortfolioManagerId(long portfolioManagerId) {
        this.portfolioManagerId = portfolioManagerId;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }
}
