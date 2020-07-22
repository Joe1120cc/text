package entity;

import java.util.ArrayList;

public class Dealer extends User{
	private ArrayList<Order> orders = new ArrayList<Order>();

	public Dealer(String userName, String userID, String userPassword, String userPhoneNumber) {
		super(userName, userID, userPassword, userPhoneNumber);
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	
	public void addOrder(Order o) {
		orders.add(o);
	}

}
