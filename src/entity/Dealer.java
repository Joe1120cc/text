package entity;

import java.util.ArrayList;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 经销商类（继承自用户类）
 */
public class Dealer extends User {
	private ArrayList<Order> orders = new ArrayList<Order>();

	public Dealer(String userName, String userID, String userPassword, String userPhoneNumber) {
		super(userName, userID, userPassword, userPhoneNumber);
	}

	public ArrayList<Order> getOrders() {// 返回订单
		return orders;
	}

	public void addOrder(Order o) {// 添加订单
		orders.add(o);
	}

}
