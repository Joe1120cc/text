package entity;

public class User {
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
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserPassword() {
		return UserPassword;
	}
	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}
	public String getUserPhoneNumber() {
		return UserPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		UserPhoneNumber = userPhoneNumber;
	}

}
