package entity;

import java.sql.Date;

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
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderProductName() {
		return orderProductName;
	}
	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}
	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Date getBidDeadLine() {
		return bidDeadLine;
	}
	public void setBidDeadLine(Date bidDeadLine) {
		this.bidDeadLine = bidDeadLine;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getConsigneePhoneNumber() {
		return consigneePhoneNumber;
	}
	public void setConsigneePhoneNumber(String consigneePhoneNumber) {
		this.consigneePhoneNumber = consigneePhoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

}
