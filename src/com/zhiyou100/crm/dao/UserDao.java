package com.zhiyou100.crm.dao;

import com.zhiyou100.crm.model.User;

public interface UserDao {
	public User getUserByLogin(String username, String password);
}
