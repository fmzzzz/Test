package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.UserDao;
import com.zhiyou100.crm.dao.impl.UserDaoImpl;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.util.Pager;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	
	@Override
	public User getUserByLogin(String username, String password) {
		return userDao.getUserByLogin(username, password);
	}

	@Override
	public int total(String field, String keyword) {
		return userDao.total(field, keyword);
	}
	
	@Override
	public List<User> list(String field, String keyword, Pager pager) {
		return userDao.list(field, keyword, pager);
	}

	@Override
	public User getById(int userId) {
		return userDao.getById(userId);
	}

	@Override
	public boolean add(User user) {
		return userDao.add(user);
	}

	@Override
	public boolean removeById(int userId, int updater, Timestamp updateTime) {
		return userDao.removeById(userId, updater, updateTime);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}
}
