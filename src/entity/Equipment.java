package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备类
 */
public class Equipment {
	private int equipmentNumber;
	private String equipmentID;
	private String equipmentName;
	private EquipmentType euipmentType;
	private String equipmentSpecification;
	private CloudFactory equipmentOwnedFactory;
	private String equipmentDescription;
	private String equipmentState;
	private String rentState;

	public Equipment(String equipmentID, String equipmentName, EquipmentType euipmentType,
			String equipmentSpecification, CloudFactory equipmentOwnedFactory, String equipmentDescription,
			String equipmentState, String rentState) {
		super();
		this.equipmentID = equipmentID;
		this.equipmentName = equipmentName;
		this.euipmentType = euipmentType;
		this.equipmentSpecification = equipmentSpecification;
		this.equipmentOwnedFactory = equipmentOwnedFactory;
		this.equipmentDescription = equipmentDescription;
		this.equipmentState = equipmentState;
		this.rentState = rentState;
	}

	public int getEquipmentNumber() {// 返回设备序号
		return equipmentNumber;
	}

	public void setEquipmentNumber(int equipmentNumber) {// 设置设备序号
		this.equipmentNumber = equipmentNumber;
	}

	public String getEquipmentID() {// 返回设备ID
		return equipmentID;
	}

	public void setEquipmentID(String equipmentID) {// 设置设备ID
		this.equipmentID = equipmentID;
	}

	public String getEquipmentName() {// 获取设备名
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {// 设置设备名
		this.equipmentName = equipmentName;
	}

	public EquipmentType getEuipmentType() {// 获取设备类型
		return euipmentType;
	}

	public void setEuipmentType(EquipmentType euipmentType) {// 设置设备类型
		this.euipmentType = euipmentType;
	}

	public String getEquipmentSpecification() {// 获取设备规格
		return equipmentSpecification;
	}

	public void setEquipmentSpecification(String equipmentSpecification) {// 设置设备规格
		this.equipmentSpecification = equipmentSpecification;
	}

	public CloudFactory getEquipmentOwnedFactory() {// 获取拥有该设备的云工厂
		return equipmentOwnedFactory;
	}

	public void setEquipmentOwnedFactory(CloudFactory equipmentOwnedFactory) {// 设置拥有该设备的云工厂
		this.equipmentOwnedFactory = equipmentOwnedFactory;
	}

	public String getEquipmentState() {// 获取设备状态
		return equipmentState;
	}

	public void setEquipmentState(String equipmentState) {// 设置设备状态
		this.equipmentState = equipmentState;
	}

	public String getRentState() {// 获取租用状态
		return rentState;
	}

	public void setRentState(String rentState) {// 设置租用状态
		this.rentState = rentState;
	}

	public String getEquipmentDescription() {// 获取设备描述
		return equipmentDescription;
	}

	public void setEquipmentDescription(String equipmentDescription) {// 设置设备描述
		this.equipmentDescription = equipmentDescription;
	}

}
