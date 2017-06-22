package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerStateDao;
import com.zhiyou100.crm.dao.impl.CustomerStateDaoImpl;
import com.zhiyou100.crm.model.CustomerState;
import com.zhiyou100.crm.service.CustomerStateService;

public class CustomerStateServiceImpl implements CustomerStateService {
	
	CustomerStateDao customerStateDao = new CustomerStateDaoImpl();
	
	@Override
	public List<CustomerState> list() {
		return customerStateDao.list();
	}
	
	@Override
	public CustomerState getById(int customerStateId) {
		return customerStateDao.getById(customerStateId);
	}
	
	@Override
	public boolean add(CustomerState customerState) {
		return customerStateDao.add(customerState);
	}
	
	@Override
	public boolean removeById(int customerStateId, int updater, Timestamp updateTime){
		return customerStateDao.removeById(customerStateId, updater, updateTime);
	}
	
	@Override
	public boolean update(CustomerState customerState){
		return customerStateDao.update(customerState);
	}
}
