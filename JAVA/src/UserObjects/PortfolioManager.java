package UserObjects;

import java.util.ArrayList;

/**
*
* @author agiria
*/

public class PortfolioManager extends User {
	ArrayList<Portfolio> portfolioList;
	ArrayList<Order> orderList;
	ArrayList<Trader> traderList;
	
	public ArrayList<Portfolio> getPortfolioList() {
		return portfolioList;
	}
	
	public void setPortfolioList(ArrayList<Portfolio> portfolioList) {
		this.portfolioList = portfolioList;
	}
	
	public ArrayList<Order> getOrderList() {
		return orderList;
	}
	
	public void setOrderList(ArrayList<Order> orderList) {
		this.orderList = orderList;
	}
	
	public ArrayList<Trader> getTraderList() {
		return traderList;
	}
	
	public void setTraderList(ArrayList<Trader> traderList) {
		this.traderList = traderList;
	}
	
	
}
