package bean;

import java.io.Serializable;

public class Like implements Serializable{
	private int id;
	private String loginId;
	
	public Like() {}
	public Like(int id, String loginId) {
		super();
		this.id = id;
		this.loginId = loginId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	

}
