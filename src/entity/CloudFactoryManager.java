package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 云工厂管理员类（继承自用户类）
 */
public class CloudFactoryManager extends User {
	private CloudFactory myCloudFactory;

	public CloudFactoryManager(String userName, String userID, String userPassword, String userPhoneNumber,
			CloudFactory myCloudFactory) {
		super(userName, userID, userPassword, userPhoneNumber);
		this.myCloudFactory = myCloudFactory;
	}

	public CloudFactory getMyCloudFactory() {// 获取该管理员拥有的云工厂
		return myCloudFactory;
	}

	public void setMyCloudFactory(CloudFactory myCloudFactory) {// 设置该管理员拥有的云工厂
		this.myCloudFactory = myCloudFactory;
	}

}
