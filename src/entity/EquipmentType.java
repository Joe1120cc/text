package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备类型类
 */
public class EquipmentType {
	private String equipmentType;

	public EquipmentType(String equipmentType) {
		super();
		this.equipmentType = equipmentType;
	}

	public String getEquipmentType() {// 获取设备类型
		return equipmentType;
	}

	public void setEquipmentType(String equipmentType) {// 设置设备类型
		this.equipmentType = equipmentType;
	}

	public String toString() {// 重载toString方法，以便于在下拉框中显示类型名
		return equipmentType;
	}
}
