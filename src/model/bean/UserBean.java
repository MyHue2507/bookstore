package model.bean;

public class UserBean {
	private String	UserName;
	private String	Password;
	private boolean	Permission;
	
	public UserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserBean(String userName, String password, boolean permission) {
		super();
		UserName = userName;
		Password = password;
		Permission = permission;
	}
	
	public String getUserName() {
		return UserName;
	}
	
	public void setUserName(String userName) {
		UserName = userName;
	}
	
	public String getPassword() {
		return Password;
	}
	
	public void setPassword(String password) {
		Password = password;
	}
	
	public boolean isPermission() {
		return Permission;
	}
	
	public void setPermission(boolean permission) {
		Permission = permission;
	}
}
