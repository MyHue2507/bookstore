package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import controller.ConnectionDatabase;
import model.bean.CartBean;
import model.bean.CartDetailBean;

public class CartDao {
	private ConnectionDatabase cnn = new ConnectionDatabase();
	
	public ArrayList<CartBean> getAllCarts(long idCustomer) throws Exception {
		ArrayList<CartBean> carts = new ArrayList<CartBean>();
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM Cart WHERE IDCustomer=? AND HaveBuy=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setLong(1, idCustomer);
		cmd.setBoolean(2, true);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			long iDCart = rs.getLong("IDCart");
			long iDCustomer = rs.getLong("IDCustomer");
			Date dateBuy = rs.getDate("DateBuy");
			boolean haveBuy = rs.getBoolean("HaveBuy");
			carts.add(new CartBean(iDCart, iDCustomer, dateBuy, haveBuy));
		}		
		// Đóng CSDL
		cnn.connection.close();
		return carts;
	}
	
	public CartDetailBean getCartsDetailBuyID(long id) throws Exception {
		CartDetailBean cart = null;
		// Kết nối CSDL
		cnn.ConnectionDB();
		// Lấy CSDL
		String query = "SELECT * FROM CartDetail WHERE IDCart=?";
		PreparedStatement cmd = cnn.connection.prepareStatement(query);
		cmd.setLong(1, id);
		ResultSet rs = cmd.executeQuery();        

		while (rs.next()) {
			long iDCartDetail = rs.getLong("IDCartDetail");
			String idBook = rs.getString("IDBook");
			int quantityBuy = rs.getInt("QuantityBuy");
			long idCart = rs.getLong("IDCart");
			cart = new CartDetailBean(iDCartDetail, idBook, quantityBuy, idCart);
		}		
		// Đóng CSDL
		cnn.connection.close();
		return cart;
	}
}
