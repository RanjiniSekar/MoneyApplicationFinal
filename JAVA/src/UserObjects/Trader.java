package UserObjects;

import java.util.ArrayList;

public class Trader extends User{
	
	ArrayList<Order> Order_list;
	ArrayList<Block> Block_list_generated ;
	ArrayList<Block> Block_list_sent ;

	
	
	

	public ArrayList<Order> getOrder_list() {
		return Order_list;
	}





	public void setOrder_list(ArrayList<Order> order_list) {
		Order_list = order_list;
	}





	public ArrayList<Block> getBlock_list_generated() {
		return Block_list_generated;
	}





	public void setBlock_list_generated(ArrayList<Block> block_list_generated) {
		Block_list_generated = block_list_generated;
	}





	public ArrayList<Block> getBlock_list_sent() {
		return Block_list_sent;
	}





	public void setBlock_list_sent(ArrayList<Block> block_list_sent) {
		Block_list_sent = block_list_sent;
	}



}
