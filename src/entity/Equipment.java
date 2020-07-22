package entity;

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
			String equipmentSpecification, CloudFactory equipmentOwnedFactory, String equipmentDescription,String equipmentState,String rentState) {
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
	public int getEquipmentNumber() {
		return equipmentNumber;
	}
	public void setEquipmentNumber(int equipmentNumber) {
		this.equipmentNumber = equipmentNumber;
	}
	public String getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(String equipmentID) {
		this.equipmentID = equipmentID;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public EquipmentType getEuipmentType() {
		return euipmentType;
	}
	public void setEuipmentType(EquipmentType euipmentType) {
		this.euipmentType = euipmentType;
	}
	public String getEquipmentSpecification() {
		return equipmentSpecification;
	}
	public void setEquipmentSpecification(String equipmentSpecification) {
		this.equipmentSpecification = equipmentSpecification;
	}
	public CloudFactory getEquipmentOwnedFactory() {
		return equipmentOwnedFactory;
	}
	public void setEquipmentOwnedFactory(CloudFactory equipmentOwnedFactory) {
		this.equipmentOwnedFactory = equipmentOwnedFactory;
	}
	public String getEquipmentState() {
		return equipmentState;
	}
	public void setEquipmentState(String equipmentState) {
		this.equipmentState = equipmentState;
	}
	public String getRentState() {
		return rentState;
	}
	public void setRentState(String rentState) {
		this.rentState = rentState;
	}
//	public void initRentState() {
//		this.rentState = null;
//	}
	public String getEquipmentDescription() {
		return equipmentDescription;
	}
	public void setEquipmentDescription(String equipmentDescription) {
		this.equipmentDescription = equipmentDescription;
	}

}
