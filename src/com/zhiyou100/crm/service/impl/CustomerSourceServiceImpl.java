package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerSourceDao;
import com.zhiyou100.crm.dao.impl.CustomerSourceDaoImpl;
import com.zhiyou100.crm.model.CustomerSource;
import com.zhiyou100.crm.service.CustomerSourceService;

public class CustomerSourceServiceImpl implements CustomerSourceService {
	
	CustomerSourceDao customerSourceDao = new CustomerSourceDaoImpl();
	
	@Override
	public List<CustomerSource> list() {
		return customerSourceDao.list();
	}
	
	@Override
	public CustomerSource getById(int customerSourceId) {
		return customerSourceDao.getById(customerSourceId);
	}
	
	@Override
	public boolean add(CustomerSource customerSource) {
		return customerSourceDao.add(customerSource);
	}
	
	@Override
	public boolean removeById(int customerSourceId, int updater, Timestamp updateTime){
		return customerSourceDao.removeById(customerSourceId, updater, updateTime);
	}
	
	@Override
	public boolean update(CustomerSource customerSource){
		return customerSourceDao.update(customerSource);
	}
}
