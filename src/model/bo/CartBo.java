package model.bo;

import java.util.ArrayList;

import model.bean.CartBean;
import model.bean.CartDetailBean;
import model.dao.CartDao;

public class CartBo {
	private CartDao cartDao = new CartDao();
	
	public ArrayList<CartBean> getCarts(long idCustomer) throws Exception {
		return cartDao.getAllCarts(idCustomer);
	}
	
	public CartDetailBean getCartDetail(long idCart) throws Exception {
		return cartDao.getCartsDetailBuyID(idCart);
	}
}
