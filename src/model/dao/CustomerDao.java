package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.ConnectionDatabase;
import model.bean.CustomerBean;

public class CustomerDao {
	private ConnectionDatabase cnn = new ConnectionDatabase();
	
	public CustomerBean getCustomer(String un, String pw) throws Exception {
		CustomerBean customer = null;
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Customer WHERE UserName=? AND Password=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setString(1, un);
		cmd.setString(2, pw);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			long iDCustomer = rs.getLong("IDCustomer");
			String name = rs.getString("Name");
			String address = rs.getString("Address");
			String phone = rs.getString("Phone");
			String email = rs.getString("Email");
			String userName = rs.getString("UserName");
			String password = rs.getString("Password");
			customer = new CustomerBean(iDCustomer, name, address, phone, email, userName, password);
		}		
		// Đóng CSDL
		cnn.connection.close();
		return customer;
	}
}
