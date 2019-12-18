package model.bean;

import java.util.Date;

public class CartBean {
	private long IDCart;
	private long IDCustomer;
	private Date DateBuy;
	private boolean HaveBuy;
	
	public CartBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartBean(long iDCart, long iDCustomer, Date dateBuy, boolean haveBuy) {
		super();
		IDCart = iDCart;
		IDCustomer = iDCustomer;
		DateBuy = dateBuy;
		HaveBuy = haveBuy;
	}
	
	public long getIDCart() {
		return IDCart;
	}
	
	public void setIDCart(long iDCart) {
		IDCart = iDCart;
	}
	
	public long getIDCustomer() {
		return IDCustomer;
	}
	
	public void setIDCustomer(long iDCustomer) {
		IDCustomer = iDCustomer;
	}
	
	public Date getDateBuy() {
		return DateBuy;
	}
	
	public void setDateBuy(Date dateBuy) {
		DateBuy = dateBuy;
	}
	
	public boolean isHaveBuy() {
		return HaveBuy;
	}
	
	public void setHaveBuy(boolean haveBuy) {
		HaveBuy = haveBuy;
	}
}
