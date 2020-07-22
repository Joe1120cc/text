package service;

import java.util.ArrayList;

import entity.EquipmentType;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备类型接口
 */
public interface EquipmentTypeService extends BaseService {
	public boolean addEquipmentType(EquipmentType et);// 添加设备类型

	public boolean changeEquipmentType(String equipmentType, String newEquipmentType);// 修改设备类型

	public boolean deleteEquipmentType(String equipmentType);// 删除设备类型

	public ArrayList<String> getContainedEquipmentType(String data);// 获取模糊检索结果

}
