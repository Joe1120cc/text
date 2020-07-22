package factory;

import service.BaseService;
import serviceImpl.EquipmentServiceImpl;
import serviceImpl.EquipmentTypeServiceImpl;
import serviceImpl.ProductServiceImpl;
import serviceImpl.ProductTypeServiceImpl;
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
		if(message.equals("ProductType")) {
			return new ProductTypeServiceImpl();
		}
		if(message.equals("Product")){
			return new ProductServiceImpl();
		}
		return null;
	}

}
