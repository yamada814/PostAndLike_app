package bean;

import java.io.Serializable;

public class Customer implements Serializable{
	private Integer id;
	private String loginId;
	private String password;
	private String role;
	
	public Customer() {}

	public Customer(Integer id, String loginId, String password,String role) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.role = role;
	}



	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
