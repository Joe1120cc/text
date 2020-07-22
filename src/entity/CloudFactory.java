package entity;

/**
 * @author 刘超20195556
 * @Date Jul 22, 2020
 * @Description 云工厂类
 */
public class CloudFactory {
	private String name;
	private String introduction;
	private String myManagerID;
	private String loginState;

	public String getName() {// 返回工厂名
		return name;
	}

	public void setName(String name) {// 设置工厂名
		this.name = name;
	}

	public String getIntroduction() {// 工厂介绍
		return introduction;
	}

	public void setIntroduction(String introduction) {// 设置工厂介绍
		this.introduction = introduction;
	}

	public String getMyManagerID() {// 获取该工厂的拥有者ID
		return myManagerID;
	}

	public void setMyManager(String myManagerID) {// 设置该工厂的拥有者ID
		this.myManagerID = myManagerID;
	}

	public String getLoginState() {// 获取工厂状态
		return loginState;
	}

	public void setLoginState(String loginState) {// 设置工厂状态
		this.loginState = loginState;
	}

	public CloudFactory(String name, String introduction, String myManagerID, String loginState) {
		this.name = name;
		this.introduction = introduction;
		this.myManagerID = myManagerID;
		this.loginState = loginState;
	}

}
