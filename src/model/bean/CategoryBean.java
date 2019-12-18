package model.bean;

public class CategoryBean {
	private String	IDCategory;
	private String	Name;
	
	public CategoryBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryBean(String iDCategory, String name) {
		super();
		IDCategory = iDCategory;
		Name = name;
	}
	
	public String getIDCategory() {
		return IDCategory;
	}
	
	public void setIDCategory(String iDCategory) {
		IDCategory = iDCategory;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
}
