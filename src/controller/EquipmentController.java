package controller;

import java.util.ArrayList;

import entity.Equipment;
import factory.ServiceFactory;
import service.EquipmentService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 设备控制器
 */
public class EquipmentController extends BaseController {
	private EquipmentService equipmentService;

	public EquipmentController(String message) {
		super(message);
		equipmentService = (EquipmentService) ServiceFactory.createService(message);
	}

	public void addEquipment(Equipment e) {// 添加设备
		equipmentService.addEquipment(e);
	}

	public ArrayList<Equipment> getContainedEquipments(String data) {// 获取模糊检索结果
		return equipmentService.getContainedEquipments(data);
	}

	public boolean deleteEquipment(String equipmentID) {// 删除设备
		return equipmentService.deleteEquipment(equipmentID);
	}

	public boolean changeEquipment(Equipment e) {// 修改设备
		return equipmentService.changeEquipment(e);
	}

	public Equipment getEquipmentByID(String equipmentID) {// 通过ID获取设备
		return equipmentService.getEquipmentByID(equipmentID);
	}

}
