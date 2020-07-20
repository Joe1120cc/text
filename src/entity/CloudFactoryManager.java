package entity;

public class CloudFactoryManager extends User{
	private CloudFactory myCloudFactory;

	public CloudFactoryManager(String userName, String userID, String userPassword, String userPhoneNumber,
			CloudFactory myCloudFactory) {
		super(userName, userID, userPassword, userPhoneNumber);
		this.myCloudFactory = myCloudFactory;
	}

	public CloudFactory getMyCloudFactory() {
		return myCloudFactory;
	}

	public void setMyCloudFactory(CloudFactory myCloudFactory) {
		this.myCloudFactory = myCloudFactory;
	}

}
