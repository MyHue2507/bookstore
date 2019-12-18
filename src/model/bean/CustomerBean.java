package model.bean;

public class CustomerBean {
	private long IDCustomer;
	private String Name;
	private String Address;
	private String Phone;
	private String Email;
	private String UserName;
	private String Password;
	
	public CustomerBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CustomerBean(long iDCustomer, String name, String address, String phone, String email, String userName,
			String password) {
		super();
		IDCustomer = iDCustomer;
		Name = name;
		Address = address;
		Phone = phone;
		Email = email;
		UserName = userName;
		Password = password;
	}
	
	public long getIDCustomer() {
		return IDCustomer;
	}
	
	public void setIDCustomer(long iDCustomer) {
		IDCustomer = iDCustomer;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public String getAddress() {
		return Address;
	}
	
	public void setAddress(String address) {
		Address = address;
	}
	
	public String getPhone() {
		return Phone;
	}
	
	public void setPhone(String phone) {
		Phone = phone;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String email) {
		Email = email;
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

}
