package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.DepartmentDao;
import com.zhiyou100.crm.dao.impl.DepartmentDaoImpl;
import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.service.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService {
	
	DepartmentDao departmentDao = new DepartmentDaoImpl();
	
	@Override
	public List<Department> list() {
		return departmentDao.list();
	}
	
	@Override
	public Department getById(int departmentId) {
		return departmentDao.getById(departmentId);
	}
	
	@Override
	public boolean add(Department department) {
		return departmentDao.add(department);
	}
	
	@Override
	public boolean removeById(int departmentId, int updater, Timestamp updateTime){
		return departmentDao.removeById(departmentId, updater, updateTime);
	}
	
	@Override
	public boolean update(Department department){
		return departmentDao.update(department);
	}
}
