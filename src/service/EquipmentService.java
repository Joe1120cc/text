package service;

import java.util.ArrayList;

import entity.Equipment;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备接口
 */
public interface EquipmentService extends BaseService {
	public boolean addEquipment(Equipment e);// 添加设备

	public boolean changeEquipment(Equipment e);// 修改设备

	public boolean deleteEquipment(String euipmentID);// 删除设备

	public ArrayList<Equipment> getContainedEquipments(String data);// 获取模糊检索结果

	public Equipment getEquipmentByID(String equipmentID);// 通过ID获取设备

}
