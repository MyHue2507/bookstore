package model.bo;

import model.bean.CustomerBean;
import model.dao.CustomerDao;

public class CustomerBo {
	private CustomerDao customerDao = new CustomerDao();
	
	public CustomerBean getCustomer(String un, String pw) throws Exception {
		return customerDao.getCustomer(un, pw);
	}
}
