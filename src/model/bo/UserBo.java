package model.bo;

import java.util.ArrayList;

import model.bean.UserBean;
import model.dao.UserDao;

public class UserBo {
	private UserDao userDao = new UserDao();
	
	public UserBean getLogin(String un, String pw) throws Exception{
		ArrayList<UserBean> users = userDao.getUser(un, pw);
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}
