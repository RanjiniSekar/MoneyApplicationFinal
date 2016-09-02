package UserObjects;

import java.util.ArrayList;

public class Trader extends User{
	
	long TraderId;
	ArrayList<Order> OrderList;
	ArrayList<Block> BlockListGenerated ;
	ArrayList<Block> BlockListSent ;

    public Trader(String name, String username, String temppass, String usertype) {
        super(name, username, temppass, usertype);
    }


	public ArrayList<Order> getOrder_list() {
		return OrderList;
	}

	public void setOrder_list(ArrayList<Order> order_list) {
		OrderList = order_list;
	}

	public ArrayList<Block> getBlock_list_generated() {
		return BlockListSent;
	}

	public void setBlock_list_generated(ArrayList<Block> block_list_generated) {
		BlockListSent = block_list_generated;
	}

	public ArrayList<Block> getBlock_list_sent() {
		return BlockListGenerated;
	}

	public void setBlock_list_sent(ArrayList<Block> block_list_sent) {
		BlockListGenerated = block_list_sent;
	}
}
