package model.bo;

import java.util.ArrayList;

import model.bean.BookBean;
import model.dao.BookDao;

public class BookBo {
	private BookDao bookDao = new BookDao();
	
	public ArrayList<BookBean> getBooks() throws Exception{
		return bookDao.getAllBooks();
	}
	
	public BookBean getBookByID(String id) throws Exception{
        ArrayList<BookBean> books = bookDao.getBooksByID(id);
        if (books.size() > 0) {
        	return books.get(0);
        } else {
        	return null;
        }
    }
	
	public ArrayList<BookBean> getBooksByCategory(String idCategory) throws Exception{
		return bookDao.getBooksByCategory(idCategory);
	}
}
