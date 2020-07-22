package controller;

import entity.CloudFactoryManager;
import entity.Dealer;
import entity.User;
import factory.ServiceFactory;
import service.UserService;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description User控制层
 */
public class UserContoller extends BaseController {
	private UserService userService;

	public UserContoller(String message) {// 生成接口实现类
		super(message);
		userService = (UserService) ServiceFactory.createService(message);
	}

	public boolean addCloudFactoryManager(CloudFactoryManager cfm) {// 添加云工厂管理员
		return userService.addCloudFactoryManager(cfm);
	}

	public boolean addDealer(Dealer d) {// 添加经销商
		return userService.addDealer(d);

	}

	public int verify(String userID, String password) {// 验证账号和密码
		return userService.verify(userID, password);
	}

	public boolean deleteUser(String userID) {// 删除用户
		return userService.deleteUser(userID);
	}

	public User getUserById(String userID) {// 通过ID返回User对象
		return userService.getUserById(userID);
	}

	public boolean changeCloudFactoryManager(CloudFactoryManager cfm) {// 修改云工厂管理员信息
		return userService.changeCloudFactoryManager(cfm);
	}

	public boolean changeDealer(Dealer d) {// 修改经销商信息
		return userService.changeDealer(d);
	}

}
