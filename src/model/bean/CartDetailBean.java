package model.bean;

public class CartDetailBean {
	private long IDCartDetail;
	private String IDBook;
	private int QuantityBuy;
	private long IDCart;
	
	public CartDetailBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CartDetailBean(long iDCartDetail, String iDBook, int quantityBuy, long iDCart) {
		super();
		IDCartDetail = iDCartDetail;
		IDBook = iDBook;
		QuantityBuy = quantityBuy;
		IDCart = iDCart;
	}
	
	public long getIDCartDetail() {
		return IDCartDetail;
	}
	
	public void setIDCartDetail(long iDCartDetail) {
		IDCartDetail = iDCartDetail;
	}
	
	public String getIDBook() {
		return IDBook;
	}
	
	public void setIDBook(String iDBook) {
		IDBook = iDBook;
	}
	
	public int getQuantityBuy() {
		return QuantityBuy;
	}
	
	public void setQuantityBuy(int quantityBuy) {
		QuantityBuy = quantityBuy;
	}
	
	public long getIDCart() {
		return IDCart;
	}
	
	public void setIDCart(long iDCart) {
		IDCart = iDCart;
	}
}
