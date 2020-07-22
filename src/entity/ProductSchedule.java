package entity;

import java.sql.Date;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 排产类
 */
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

	public String getEuipmentID() {// 获取设备名
		return euipmentID;
	}

	public void setEuipmentID(String euipmentID) {// 设置设备名
		this.euipmentID = euipmentID;
	}

	public Date getStartTime() {// 获取开始时间
		return startTime;
	}

	public void setStartTime(Date startTime) {// 设置开始时间
		this.startTime = startTime;
	}

	public Date getEndTime() {// 获取结束时间
		return endTime;
	}

	public void setEndTime(Date endTime) {// 设置结束时间
		this.endTime = endTime;
	}

}
