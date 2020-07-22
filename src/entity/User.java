package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 用户类（父类）
 */
public class User {
	// 声明属性
	private String UserName;
	private String UserID;
	private String UserPassword;
	private String UserPhoneNumber;

	public User(String userName, String userID, String userPassword, String userPhoneNumber) {
		UserName = userName;
		UserID = userID;
		UserPassword = userPassword;
		UserPhoneNumber = userPhoneNumber;
	}

	public String getUserName() {// 返回用户名
		return UserName;
	}

	public void setUserName(String userName) {// 设置用户名
		UserName = userName;
	}

	public String getUserID() {// 返回用户ID
		return UserID;
	}

	public void setUserID(String userID) {// 设置用户ID
		UserID = userID;
	}

	public String getUserPassword() {// 获取密码
		return UserPassword;
	}

	public void setUserPassword(String userPassword) {// 设置密码
		UserPassword = userPassword;
	}

	public String getUserPhoneNumber() {// 获取用户联系方式
		return UserPhoneNumber;
	}

	public void setUserPhoneNumber(String userPhoneNumber) {// 设置用户联系方式
		UserPhoneNumber = userPhoneNumber;
	}

}
