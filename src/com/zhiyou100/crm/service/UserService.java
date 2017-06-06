package com.zhiyou100.crm.service;

import com.zhiyou100.crm.model.User;

public interface UserService {
	public User getUserByLogin(String username, String password);
}
