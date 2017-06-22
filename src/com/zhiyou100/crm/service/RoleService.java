package com.zhiyou100.crm.service;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.Role;

public interface RoleService {
	
	List<Role> list();
	Role getById(int roleId);
	boolean add(Role role);
	boolean removeById(int roleId, int updater, Timestamp updateTime);
	boolean update(Role role);
	
}
