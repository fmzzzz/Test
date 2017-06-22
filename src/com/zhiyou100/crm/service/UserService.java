package com.zhiyou100.crm.service;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.util.Pager;

public interface UserService {
	public User getUserByLogin(String username, String password);
	
	int total(String field, String keyword);
	List<User> list(String field, String keyword, Pager pager);
	User getById(int userId);
	boolean add(User user);
	boolean removeById(int userId, int updater, Timestamp updateTime);
	boolean update(User user);
}
