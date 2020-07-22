package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import entity.Equipment;
import service.EquipmentService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;

public class EquipmentServiceImpl implements EquipmentService{

	public boolean addEquipment(Equipment e) {
		try {
			String data = GsonUtils.toJson(e);
			FileUtils.writeData(data, "Equipments.txt", true);
			return true;
		} catch (Exception E) {
			return false;
		}
		
	}

	@Override
	public boolean changeEquipment(Equipment e) {
		int i=1;
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		ArrayList<Equipment> list = new ArrayList<Equipment>();
		for(Object o : eList) {
			Equipment E = (Equipment)o;
			if(E.getEquipmentID().equals(e.getEquipmentID())) {
				list.add(e);
				continue;
			}
			list.add(E);
		}
		for(Equipment E : list) {
			String data = GsonUtils.toJson(E);
			try {
				if(i==1) {
					FileUtils.writeData(data, "Equipments.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "Equipments.txt", true);
				}
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean deleteEquipment(String euipmentID) {
		int i=1;
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		ArrayList<Equipment> list = new ArrayList<Equipment>();
		for(Object o : eList) {
			Equipment E = (Equipment)o;
			if(!E.getEquipmentID().equals(euipmentID)) {
				list.add(E);
			}
		}
		if(list.isEmpty()) {
			Tool.clearInfoForFile("Equipments.txt");
		}
		for(Equipment E : list) {
			String data = GsonUtils.toJson(E);
			try {
				if(i==1) {
					FileUtils.writeData(data, "Equipments.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "Equipments.txt", true);
				}
			} catch (Exception e2) {
				return false;
			}
		}
		return true;
	}

	@Override
	public ArrayList<Equipment> getContainedEquipments(String data) {
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		ArrayList<Equipment> list = new ArrayList<Equipment>();
		for(Object o : eList) {
			Equipment e = (Equipment)o;
			if(e.getEquipmentID().contains(data)||e.getEquipmentName().contains(data)) {
				list.add(e);
			}
		}
		return list;
	}

	@Override
	public Equipment getEquipmentByID(String equipmentID) {
		List<Object> eList = FileUtils.getData("Equipments.txt", Equipment.class);
		for(Object o : eList) {
			Equipment e = (Equipment)o;
			if(e.getEquipmentID().equals(equipmentID)) {
				return e;
			}
		}
		return null;
	}

}
