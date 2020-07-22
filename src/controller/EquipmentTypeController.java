package controller;

import java.util.ArrayList;

import entity.EquipmentType;
import factory.ServiceFactory;
import service.EquipmentTypeService;

public class EquipmentTypeController extends BaseController{
	private EquipmentTypeService equipmentTypeService;

	public EquipmentTypeController(String message) {
		super(message);
		equipmentTypeService = (EquipmentTypeService)ServiceFactory.createService(message);
	}
	public boolean addEquipmentType(EquipmentType et) {
		return equipmentTypeService.addEquipmentType(et);
	}
	
	public boolean changeEquipmentType(String equipmentType, String newEquipmentType) {
		return equipmentTypeService.changeEquipmentType(equipmentType, newEquipmentType);
	}
	
	public boolean deleteEquipmentType(String equipmentType) {
		return equipmentTypeService.deleteEquipmentType(equipmentType);
	}
	
	public ArrayList<String> getContainedEquipmentType(String data){
		return equipmentTypeService.getContainedEquipmentType(data);
	}

}
