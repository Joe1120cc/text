package controller;

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

}
