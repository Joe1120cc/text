package serviceImpl;

import java.util.ArrayList;
import java.util.List;

import entity.EquipmentType;
import service.EquipmentTypeService;
import utils.FileUtils;
import utils.GsonUtils;
import utils.Tool;


public class EquipmentTypeServiceImpl implements EquipmentTypeService{

	public boolean addEquipmentType(EquipmentType et) {
		try {
			String data = GsonUtils.toJson(et);
			FileUtils.writeData(data, "EquipmentTypes.txt", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean changeEquipmentType(String equipmentType, String newEquipmentType) {
		int i=1;
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		ArrayList<EquipmentType> ets = new ArrayList<EquipmentType>();
		for(Object o : etList) {
			EquipmentType et = (EquipmentType)o;
			if(et.getEquipmentType().equals(equipmentType)) {
				et.setEquipmentType(newEquipmentType);
			}
			ets.add(et);
		}
		try {
			for(EquipmentType et : ets) {
				String data = GsonUtils.toJson(et);
				if(i==1) {
					FileUtils.writeData(data, "EquipmentTypes.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "EquipmentTypes.txt", true);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteEquipmentType(String equipmentType) {
		int i=1;
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		ArrayList<EquipmentType> ets = new ArrayList<EquipmentType>();
		for(Object o : etList) {
			EquipmentType et = (EquipmentType)o;
			if(!et.getEquipmentType().equals(equipmentType)) {
				ets.add(et);
			}
		}
		if(ets.isEmpty()) {
			Tool.clearInfoForFile("EquipmentTypes.txt");
		}
		try {
			for(EquipmentType et : ets) {
				String data = GsonUtils.toJson(et);
				if(i==1) {
					FileUtils.writeData(data, "EquipmentTypes.txt", false);
					i++;
				}else {
					FileUtils.writeData(data, "EquipmentTypes.txt", true);
				}
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<String> getContainedEquipmentType(String data) {
		List<Object> etList = FileUtils.getData("EquipmentTypes.txt", EquipmentType.class);
		ArrayList<String> ets = new ArrayList<String>();
		for(Object o : etList) {
			EquipmentType et = (EquipmentType)o;
			if(et.getEquipmentType().contains(data)) {
				ets.add(et.getEquipmentType());
			}
		}
		return ets;
	}

}
