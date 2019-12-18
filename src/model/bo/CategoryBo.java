package model.bo;

import java.util.ArrayList;

import model.bean.CategoryBean;
import model.dao.CategoryDao;

public class CategoryBo {
	private CategoryDao categoryDao = new CategoryDao();
	
	public ArrayList<CategoryBean> getCategories() throws Exception{
		return categoryDao.getCategories();
	}
	
	public CategoryBean getCategoryByID(String id) throws Exception{
        ArrayList<CategoryBean> categories = categoryDao.getCategoryByID(id);
        if (categories.size() > 0) {
        	return categories.get(0);
        } else {
        	return null;
        }
    }
	
	public int them(String maLoai,String tenLoai) throws Exception {
		return categoryDao.them(maLoai, tenLoai);
	}
	
	public int sua(String maLoai,String tenLoai) throws Exception {
		return categoryDao.Sua(maLoai, tenLoai);
	}
	
	public int Xoa(String maLoai) throws Exception {
		return categoryDao.xoa(maLoai);
	}
	
	public CategoryBean getLoai(String maLoai) throws Exception {
		return categoryDao.getLoai(maLoai);
	}
}
