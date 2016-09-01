package TestModules.JTableDataPopulation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kjha4
 */
public class Trade {
    private String orderID;
    private String portfolioID;
    private String symbol;
    private int quantity;
    private String action;
    private float stopPrice;
    private float limitPrice;
    private String accountType;
    private String orderType;
    private String assignedTo;
    private String status;

    public Trade(String orderID, String portfolioID, String symbol, int quantity, String action, float stopPrice, float limitPrice, String accountType, String orderType, String assignedTo, String status) {
        this.orderID = orderID;
        this.portfolioID = portfolioID;
        this.symbol = symbol;
        this.quantity = quantity;
        this.action = action;
        this.stopPrice = stopPrice;
        this.limitPrice = limitPrice;
        this.accountType = accountType;
        this.orderType = orderType;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getPortfolioID() {
        return portfolioID;
    }

    public void setPortfolioID(String portfolioID) {
        this.portfolioID = portfolioID;
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

    public float getStopPrice() {
        return stopPrice;
    }

    public void setStopPrice(float stopPrice) {
        this.stopPrice = stopPrice;
    }

    public float getLimitPrice() {
        return limitPrice;
    }

    public void setLimitPrice(float limitPrice) {
        this.limitPrice = limitPrice;
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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Trade{" + "orderID=" + orderID + ", portfolioID=" + portfolioID + ", symbol=" + symbol + ", quantity=" + quantity + ", action=" + action + ", stopPrice=" + stopPrice + ", limitPrice=" + limitPrice + ", accountType=" + accountType + ", orderType=" + orderType + ", assignedTo=" + assignedTo + ", status=" + status + '}';
    }     
    
}
