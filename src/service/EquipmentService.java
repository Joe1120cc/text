package service;

import java.util.ArrayList;

import entity.Equipment;

public interface EquipmentService extends BaseService{
	public boolean addEquipment(Equipment e);
	
	public boolean changeEquipment(Equipment e);
	
	public boolean deleteEquipment(String euipmentID);
	
	public ArrayList<Equipment> getContainedEquipments(String data);
	
	public Equipment getEquipmentByID(String equipmentID);

}
