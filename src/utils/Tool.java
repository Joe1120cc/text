package utils;

import java.util.List;

import entity.CloudFactory;
import entity.CloudFactoryManager;
import entity.Dealer;

public class Tool {
	public static boolean isIDExisted(String userID) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		List<Object> dList = FileUtils.getData("Dealers.txt", Dealer.class);
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(userID.equals(cfm.getUserID())) {
				return true;
			}
		}
		for(Object o : dList) {
			Dealer d = (Dealer)o;
			if(userID.equals(d.getUserID())) {
				return true;
			}
		}
		return false;
	}
	
	public static CloudFactory getCloudFactoryByID(String userID) {
		List<Object> mList = FileUtils.getData("CloudFactoryManagers.txt", CloudFactoryManager.class);
		for(Object o : mList) {
			CloudFactoryManager cfm = (CloudFactoryManager)o;
			if(userID.equals(cfm.getUserID())) {
				return cfm.getMyCloudFactory();
			}
		}
		return null;
	}

}
