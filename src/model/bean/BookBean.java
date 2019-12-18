package model.bean;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class BookBean {
	private String	IDBook;
	private String	Name;
	private int		Quantity;
	private long	Price;
	private String	IDCategory;
	private String	Image;
	private Date	DateInput;
	private String	Author;
	
	public BookBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BookBean(String iDBook, String name, int quantity, long price, String iDCategory, String image, Date dateInput, String author) {
		super();
		IDBook = iDBook;
		Name = name;
		Quantity = quantity;
		Price = price;
		IDCategory = iDCategory;
		Image = image;
		DateInput = dateInput;
		Author = author;
	}
	
	public String getIDBook() {
		return IDBook;
	}
	
	public void setIDBook(String iDBook) {
		IDBook = iDBook;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public int getQuantity() {
		return Quantity;
	}
	
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public long getPrice() {
		return Price;
	}
	
	public void setPrice(long price) {
		Price = price;
	}
	
	public String getIDCategory() {
		return IDCategory;
	}
	
	public void setIDCategory(String iDCategory) {
		IDCategory = iDCategory;
	}
	public String getImage() {
		return Image;
	}
	
	public void setImage(String image) {
		Image = image;
	}
	public Date getDateInput() {
		return DateInput;
	}
	
	public void setDateInput(Date dateInput) {
		DateInput = dateInput;
	}
	public String getAuthor() {
		return Author;
	}
	
	public void setAuthor(String author) {
		Author = author;
	}
	
	public String getPriceFormat() {
		return NumberFormat.getCurrencyInstance(new Locale("vn", "VN")).format(Price);
	}
}
