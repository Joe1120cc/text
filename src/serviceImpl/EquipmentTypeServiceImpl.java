package serviceImpl;

import entity.EquipmentType;
import service.EquipmentTypeService;
import utils.FileUtils;
import utils.GsonUtils;

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

}
