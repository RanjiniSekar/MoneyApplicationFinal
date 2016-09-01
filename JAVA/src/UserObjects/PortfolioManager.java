package UserObjects;

import java.util.ArrayList;

/**
*
* @author agiria
*/

public class PortfolioManager extends User {
	
	long portfolioManagerId;
	ArrayList<PMPortfolio> portfolioList;
	ArrayList<Order> orderList;
	ArrayList<Trader> traderList;
	
	public ArrayList<PMPortfolio> getPortfolioList() {
		return portfolioList;
	}
	
	public void setPortfolioList(ArrayList<PMPortfolio> portfolioList) {
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
