package UserObjects;

import java.util.List;

public class Order {

    long orderId;
    long pm_id;
    String pm_username;
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
        return pm_id;
    }

    public void setPortfolioManagerId(long portfolioManagerId) {
        this.pm_id = portfolioManagerId;
    }

    public long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getPmId() {
        return pm_id;
    }

    public void setPmId(long pm_id) {
        this.pm_id = pm_id;
    }

    public String getPmUsername() {
        return pm_username;
    }

    public void setPmUsername(String pm_username) {
        this.pm_username = pm_username;
    }
    
    
    
}
