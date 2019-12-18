package model.bean;

public class Cart {
	private CartBean cart;
	private CartDetailBean cartDetail;
	private BookBean book;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(CartBean cart, CartDetailBean cartDetail, BookBean book) {
		super();
		this.cart = cart;
		this.cartDetail = cartDetail;
		this.book = book;
	}

	public CartBean getCart() {
		return cart;
	}

	public void setCart(CartBean cart) {
		this.cart = cart;
	}

	public CartDetailBean getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(CartDetailBean cartDetail) {
		this.cartDetail = cartDetail;
	}

	public BookBean getBook() {
		return book;
	}

	public void setBook(BookBean book) {
		this.book = book;
	}
}
