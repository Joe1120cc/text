package serviceImpl;

import entity.Equipment;
import service.EquipmentService;
import utils.FileUtils;
import utils.GsonUtils;

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

}
