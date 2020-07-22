package entity;

import java.sql.Date;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 订单类
 */
public class Order {
	private int orderNumber;
	private String orderProductName;
	private int orderQuantity;
	private Date addDate;
	private Date bidDeadLine;
	private String consignee;
	private String consigneePhoneNumber;
	private String address;
	private String orderState;

	public Order(int orderNumber, String orderProductName, int orderQuantity, Date addDate, Date bidDeadLine,
			String consignee, String consigneePhoneNumber, String address, String orderState) {
		super();
		this.orderNumber = orderNumber;
		this.orderProductName = orderProductName;
		this.orderQuantity = orderQuantity;
		this.addDate = addDate;
		this.bidDeadLine = bidDeadLine;
		this.consignee = consignee;
		this.consigneePhoneNumber = consigneePhoneNumber;
		this.address = address;
		this.orderState = orderState;
	}

	public int getOrderNumber() {// 获取订单序号
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {// 设置订单序号
		this.orderNumber = orderNumber;
	}

	public String getOrderProductName() {// 获取订单产品名
		return orderProductName;
	}

	public void setOrderProductName(String orderProductName) {// 设置订单产品名
		this.orderProductName = orderProductName;
	}

	public int getOrderQuantity() {// 获取订单数量
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {// 设置订单数量
		this.orderQuantity = orderQuantity;
	}

	public Date getAddDate() {// 获取添加订单的日期
		return addDate;
	}

	public void setAddDate(Date addDate) {// 设置添加订单的日期
		this.addDate = addDate;
	}

	public Date getBidDeadLine() {// 获取截止日期
		return bidDeadLine;
	}

	public void setBidDeadLine(Date bidDeadLine) {// 设置截止日期
		this.bidDeadLine = bidDeadLine;
	}

	public String getConsignee() {// 获取收件人
		return consignee;
	}

	public void setConsignee(String consignee) {// 设置收件人
		this.consignee = consignee;
	}

	public String getConsigneePhoneNumber() {// 获取收件人联系方式
		return consigneePhoneNumber;
	}

	public void setConsigneePhoneNumber(String consigneePhoneNumber) {// 设置收件人联系方式
		this.consigneePhoneNumber = consigneePhoneNumber;
	}

	public String getAddress() {// 获取地址
		return address;
	}

	public void setAddress(String address) {// 设置地址
		this.address = address;
	}

	public String getOrderState() {// 获取订单状态
		return orderState;
	}

	public void setOrderState(String orderState) {// 设置订单状态
		this.orderState = orderState;
	}

}
