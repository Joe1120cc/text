package controller;

import entity.CloudFactoryManager;
import entity.Dealer;
import entity.User;
import factory.ServiceFactory;
import service.UserService;

public class UserContoller extends BaseController{
	private UserService userService;

	public UserContoller(String message) {
		super(message);
		userService = (UserService)ServiceFactory.createService(message);
	}
	public boolean addCloudFactoryManager(CloudFactoryManager cfm) {
		return userService.addCloudFactoryManager(cfm);
	}
	public boolean addDealer(Dealer d) {
		return userService.addDealer(d);
		
	}
	public int verify(String userID, String password) {
		return userService.verify(userID, password);
	}
	public boolean deleteUser(String userID) {
		return userService.deleteUser(userID);
	}
	public User getUserById(String userID) {
		return userService.getUserById(userID);
	}
	public boolean changeCloudFactoryManager(CloudFactoryManager cfm) {
		return userService.changeCloudFactoryManager(cfm);
	}
	public boolean changeDealer(Dealer d) {
		return userService.changeDealer(d);
	}

}
