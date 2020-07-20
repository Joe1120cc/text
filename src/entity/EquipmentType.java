package entity;

public class EquipmentType {
	private String equipmentType;

	public EquipmentType(String equipmentType) {
		super();
		this.equipmentType = equipmentType;
	}

	public String getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String toString() {
		return equipmentType;
	}
}
