package service;

import entity.User;
import entity.CloudFactoryManager;
import entity.Dealer;

public interface UserService extends BaseService{
	public int verify(String userID,String password);
	
	public boolean addCloudFactoryManager(CloudFactoryManager cfm);
	
	public boolean addDealer(Dealer d);
	
    public boolean deleteUser(String userID);
    
    public User getUserById(String userID);
    
    public boolean changeCloudFactoryManager(CloudFactoryManager cfm);
    
    public boolean changeDealer(Dealer d);

}
