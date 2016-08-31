package UserObjects;

import java.util.ArrayList;

/**
*
* @author agiria
*/

public class Portfolio {
	long portfolioId;
	long portfolioManagerId;
	ArrayList<Item> itemList;
	
	public long getPortfolioId() {
		return portfolioId;
	}
	
	public void setPortfolioId(long portfolioId) {
		this.portfolioId = portfolioId;
	}
	
	public long getPortfolioManagerId() {
		return portfolioManagerId;
	}
	
	public void setPortfolioManagerId(long portfolioManagerId) {
		this.portfolioManagerId = portfolioManagerId;
	}
	
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	
	public void setItemList(ArrayList<Item> itemList) {
		this.itemList = itemList;
	}
	
}
