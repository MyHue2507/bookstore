package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import controller.ConnectionDatabase;
import model.bean.BookBean;
import model.bean.UserBean;

public class UserDao {
	private ConnectionDatabase cnn = new ConnectionDatabase();
	
	public ArrayList<UserBean> getUser(String un, String pw) throws Exception {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Account WHERE UserName=? AND Password=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setString(1, un);
		cmd.setString(2, pw);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			String userName = rs.getString("UserName");
			String password = rs.getString("Password");
			boolean premission = rs.getBoolean("Permission");
			users.add(new UserBean(userName, password, premission));
		}
		// Đóng CSDL
		cnn.connection.close();
		return users;
	}
}
