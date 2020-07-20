package controller;

import entity.Equipment;
import factory.ServiceFactory;
import service.EquipmentService;

public class EquipmentController extends BaseController{
	private EquipmentService equipmentService;

	public EquipmentController(String message) {
		super(message);
		equipmentService = (EquipmentService)ServiceFactory.createService(message);
	}
	public void addEquipment(Equipment e) {
		equipmentService.addEquipment(e);
	}

}
