package factory;

import service.BaseService;
import serviceImpl.EquipmentServiceImpl;
import serviceImpl.EquipmentTypeServiceImpl;
import serviceImpl.UserServiceImpl;

public interface ServiceFactory {
	public static BaseService createService(String message) {
		if(message.equals("User")) {
			return new UserServiceImpl();
		}
		if(message.equals("Equipment")) {
			return new EquipmentServiceImpl();
		}
		if(message.equals("EquipmentType")) {
			return new EquipmentTypeServiceImpl();
		}
		return null;
	}

}
