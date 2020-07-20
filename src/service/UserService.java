package service;

import entity.CloudFactoryManager;
import entity.Dealer;

public interface UserService extends BaseService{
	public int verify(String userID,String password);
	
	public boolean addCloudFactoryManager(CloudFactoryManager cfm);
	
	public boolean addDealer(Dealer d);

}
