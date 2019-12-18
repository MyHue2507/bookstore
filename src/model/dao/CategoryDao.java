package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import controller.ConnectionDatabase;
import model.bean.CategoryBean;

public class CategoryDao {
	
	private ConnectionDatabase cnn = new ConnectionDatabase();
	
	boolean ktTrungma(String maLoai) throws SQLException {
		//ham tra ve true neu co maloai trong bang loai
		//b1: tao cau  lenh SQL
		String query = "SELECT IDCategory FROM Category WHERE IDCategory=?";    
		//tao cau lenh preparestatement
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		//truyen tham so
		cmd.setString(1, maLoai);
		//cho thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();  
		boolean kq = rs.next();
		return  kq ;
	}
	
	public int them(String maLoai, String tenLoai) throws Exception {
		//Neu trung ma thi return 0
		// ket noi
		cnn.ConnectionDB();
		//Kt trung ma
		if(ktTrungma(maLoai)) 
			return 0 ;
		//tao cau lenh SQL
		String query = "INSERT INTO Category VALUES(?,?)";
		//tao cau lenh preparestatement
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		//truyen tham so
		cmd.setString(1, maLoai);
		cmd.setString(2, tenLoai);
		//thuc hien them
		int rs = cmd.executeUpdate();
		//dong ket noi
		cmd.close();
		cnn.connection.close();
		return rs ;
		
	}
	
	public int Sua(String maLoai,String tenLoai) throws Exception {
		// sua theo ma loai
		// ket noi
		cnn.ConnectionDB();
		String query = "UPDATE Category SET Name = ? WHERE IDCategory =?" ;
		//tao cau lenh preparestatement
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		//truyen tham so
		cmd.setString(1, tenLoai);
		cmd.setString(2, maLoai);
		int rs = cmd.executeUpdate() ;
		cmd.close();
		cnn.connection.close();
		return rs ;
	}
	
	boolean ktLoaiSach(String maLoai) throws Exception {
		
		// tim kiem xem trong bang sach co loai nay hay khong
		String query = "SELECT IDCategory FROM Sach WHERE IDCategory=?";    
		//tao cau lenh preparestatement
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		//truyen tham so
		cmd.setString(1, maLoai);
		//cho thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();  
		boolean kq = rs.next();
		rs.close();
		return kq;
		
	}
	
	public int xoa(String maLoai) throws Exception{
		cnn.ConnectionDB();
		//neu khong co trong bang sach k co sach nao thuoc maloai thi xoa
		if(ktLoaiSach(maLoai)) 
			return 0;
		String query = "DELETE FROM Category WHERE IDCategory=?";    
		//tao cau lenh preparestatement
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		//truyen tham so
		cmd.setString(1, maLoai);
		//cho thuc hien cau lenh
		int rs = cmd.executeUpdate();  
		cmd.close();
		cnn.connection.close();
		return rs ;
	
	}
	
	public ArrayList<CategoryBean> getCategories() throws Exception {
		ArrayList<CategoryBean> categories = new ArrayList<CategoryBean>();
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Category";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			String iDCategory = rs.getString("IDCategory");
			String name = rs.getString("Name");
			categories.add(new CategoryBean(iDCategory, name));
		}		
		// Đóng CSDL
		cnn.connection.close();
		return categories;
	}
	
	public CategoryBean getLoai(String maLoai) throws Exception {
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Category WHERE IDCategory=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setString(1, maLoai);
		ResultSet rs = cmd.executeQuery();        
		CategoryBean loai =null ;
		if (rs.next()) {

			String iDCategory = rs.getString("IDCategory");
			String name = rs.getString("Name");
			loai = new CategoryBean(iDCategory, name);
			
		}
		rs.close();
		// Đóng CSDL
		cnn.connection.close();
		return loai;
	}
	// ham sai chi tra ve 1 loai
	public ArrayList<CategoryBean> getCategoryByID(String id) throws Exception {
		ArrayList<CategoryBean> categories = new ArrayList<CategoryBean>();
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Category WHERE IDCategory=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setString(1, id);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			String iDCategory = rs.getString("IDCategory");
			String name = rs.getString("Name");
			categories.add(new CategoryBean(iDCategory, name));
		}		
		// Đóng CSDL
		cnn.connection.close();
		return categories;
	}
}
