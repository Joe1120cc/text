package controller;

import java.util.ArrayList;

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
	
	public ArrayList<Equipment> getContainedEquipments(String data){
		return equipmentService.getContainedEquipments(data);
	}
	
	public boolean deleteEquipment(String equipmentID) {
		return equipmentService.deleteEquipment(equipmentID);
	}
	
	public boolean changeEquipment(Equipment e) {
		return equipmentService.changeEquipment(e);
	}
	
	public Equipment getEquipmentByID(String equipmentID) {
		return equipmentService.getEquipmentByID(equipmentID);
	}

}
