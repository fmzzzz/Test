package com.zhiyou100.crm.service;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.CustomerSource;

public interface CustomerSourceService {
	
	List<CustomerSource> list();
	CustomerSource getById(int sourceId);
	boolean add(CustomerSource source);
	boolean removeById(int sourceId, int updater, Timestamp updateTime);
	boolean update(CustomerSource source);
	
}
