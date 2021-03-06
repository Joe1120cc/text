package controller;

import java.util.ArrayList;

import entity.EquipmentType;
import factory.ServiceFactory;
import service.EquipmentTypeService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备类型控制器
 */
public class EquipmentTypeController extends BaseController {
	private EquipmentTypeService equipmentTypeService;

	public EquipmentTypeController(String message) {
		super(message);
		equipmentTypeService = (EquipmentTypeService) ServiceFactory.createService(message);
	}

	public boolean addEquipmentType(EquipmentType et) {// 添加设备类型
		return equipmentTypeService.addEquipmentType(et);
	}

	public boolean changeEquipmentType(String equipmentType, String newEquipmentType) {// 修改设备类型
		return equipmentTypeService.changeEquipmentType(equipmentType, newEquipmentType);
	}

	public boolean deleteEquipmentType(String equipmentType) {// 删除设备类型
		return equipmentTypeService.deleteEquipmentType(equipmentType);
	}

	public ArrayList<String> getContainedEquipmentType(String data) {// 获取模糊检索结果
		return equipmentTypeService.getContainedEquipmentType(data);
	}

}
