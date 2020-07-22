package service;

import java.util.ArrayList;

import entity.EquipmentType;

public interface EquipmentTypeService extends BaseService{
	public boolean addEquipmentType(EquipmentType et);
	
	public boolean changeEquipmentType(String equipmentType, String newEquipmentType);
	
	public boolean deleteEquipmentType(String equipmentType);
	
	public ArrayList<String> getContainedEquipmentType(String data);

}
