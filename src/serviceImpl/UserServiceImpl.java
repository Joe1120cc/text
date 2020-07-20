package serviceImpl;

import java.util.List;

import entity.CloudFactoryManager;
import entity.Dealer;
import service.UserService;
import utils.FileUtils;
import utils.GsonUtils;

public class UserServiceImpl implements UserService{

	@Override
	public int verify(String userID, String password) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		for(Object o : mList) {
			CloudFactoryManager user = (CloudFactoryManager)o;
			if(user.getUserID().equals(userID)&&user.getUserPassword().equals(password)) {
				return 1;
			}
		}
		for(Object o : dList) {
			Dealer user = (Dealer)o;
			if(user.getUserID().equals(userID)&&user.getUserPassword().equals(password)) {
				return 2;
			}
		}
		return 0;
	}

	@Override
	public boolean addCloudFactoryManager(CloudFactoryManager cfm) {
		try {
			String data = GsonUtils.toJson(cfm);
			FileUtils.writeData(data, "CloudFactoryManagers.txt", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean addDealer(Dealer d) {
		try {
			String data = GsonUtils.toJson(d);
			FileUtils.writeData(data, "Dealers.txt", true);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
