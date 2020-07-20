package entity;

public class CloudFactory {
	private String name;
	private String introduction;
	private String myManagerID;
	private String loginState;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getMyManagerID() {
		return myManagerID;
	}
	public void setMyManager(String myManagerID) {
		this.myManagerID = myManagerID;
	}
	public String getLoginState() {
		return loginState;
	}
	public void setLoginState(String loginState) {
		this.loginState = loginState;
	}
	public CloudFactory(String name, String introduction, String myManagerID, String loginState) {
		this.name = name;
		this.introduction = introduction;
		this.myManagerID = myManagerID;
		this.loginState = loginState;
	}

}
