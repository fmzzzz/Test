package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerCategoryDao;
import com.zhiyou100.crm.dao.impl.CustomerCategoryDaoImpl;
import com.zhiyou100.crm.model.CustomerCategory;
import com.zhiyou100.crm.service.CustomerCategoryService;

public class CustomerCategoryServiceImpl implements CustomerCategoryService {
	
	CustomerCategoryDao customerCategoryDao = new CustomerCategoryDaoImpl();
	
	@Override
	public List<CustomerCategory> list() {
		return customerCategoryDao.list();
	}
	
	@Override
	public CustomerCategory getById(int customerCategoryId) {
		return customerCategoryDao.getById(customerCategoryId);
	}
	
	@Override
	public boolean add(CustomerCategory customerCategory) {
		return customerCategoryDao.add(customerCategory);
	}
	
	@Override
	public boolean removeById(int customerCategoryId, int updater, Timestamp updateTime){
		return customerCategoryDao.removeById(customerCategoryId, updater, updateTime);
	}
	
	@Override
	public boolean update(CustomerCategory customerCategory){
		return customerCategoryDao.update(customerCategory);
	}
}
