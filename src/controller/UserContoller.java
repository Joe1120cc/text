package controller;

import entity.CloudFactoryManager;
import entity.Dealer;
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

}
