package service;

import entity.User;
import entity.CloudFactoryManager;
import entity.Dealer;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 用户接口
 */
public interface UserService extends BaseService {
	public int verify(String userID, String password);// 登录验证

	public boolean addCloudFactoryManager(CloudFactoryManager cfm);// 添加云工厂管理员

	public boolean addDealer(Dealer d);// 添加经销商

	public boolean deleteUser(String userID);// 删除用户

	public User getUserById(String userID);// 通过ID寻找用户

	public boolean changeCloudFactoryManager(CloudFactoryManager cfm);// 修改云工厂管理员

	public boolean changeDealer(Dealer d);// 修改经销商

}
