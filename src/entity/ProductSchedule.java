package entity;

import java.sql.Date;

public class ProductSchedule {
	private String euipmentID;
	private Date startTime;
	private Date endTime;
	public ProductSchedule(String euipmentName, Date startTime, Date endTime) {
		super();
		this.euipmentID = euipmentName;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public String getEuipmentName() {
		return euipmentID;
	}
	public void setEuipmentName(String euipmentName) {
		this.euipmentID = euipmentName;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
