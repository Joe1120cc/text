package factory;

import service.BaseService;
import serviceImpl.EquipmentServiceImpl;
import serviceImpl.EquipmentTypeServiceImpl;
import serviceImpl.ProductServiceImpl;
import serviceImpl.ProductTypeServiceImpl;
import serviceImpl.UserServiceImpl;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 接口工厂
 */
public interface ServiceFactory {// 工厂模式
	public static BaseService createService(String message) {// 根据message返回对应接口实现类
		if (message.equals("User")) {
			return new UserServiceImpl();
		}
		if (message.equals("Equipment")) {
			return new EquipmentServiceImpl();
		}
		if (message.equals("EquipmentType")) {
			return new EquipmentTypeServiceImpl();
		}
		if (message.equals("ProductType")) {
			return new ProductTypeServiceImpl();
		}
		if (message.equals("Product")) {
			return new ProductServiceImpl();
		}
		return null;
	}

}
