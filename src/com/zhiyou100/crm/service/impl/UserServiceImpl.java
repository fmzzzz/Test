package com.zhiyou100.crm.service.impl;

import com.zhiyou100.crm.dao.UserDao;
import com.zhiyou100.crm.dao.impl.UserDaoImpl;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User getUserByLogin(String username, String password) {
		return userDao.getUserByLogin(username, password);
	}

}
