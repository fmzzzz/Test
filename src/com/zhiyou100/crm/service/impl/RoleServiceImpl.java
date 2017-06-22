package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.RoleDao;
import com.zhiyou100.crm.dao.impl.RoleDaoImpl;
import com.zhiyou100.crm.model.Role;
import com.zhiyou100.crm.service.RoleService;

public class RoleServiceImpl implements RoleService {
	
	RoleDao roleDao = new RoleDaoImpl();
	
	@Override
	public List<Role> list() {
		return roleDao.list();
	}
	
	@Override
	public Role getById(int roleId) {
		return roleDao.getById(roleId);
	}
	
	@Override
	public boolean add(Role role) {
		return roleDao.add(role);
	}
	
	@Override
	public boolean removeById(int roleId, int updater, Timestamp updateTime){
		return roleDao.removeById(roleId, updater, updateTime);
	}
	
	@Override
	public boolean update(Role role){
		return roleDao.update(role);
	}
}
