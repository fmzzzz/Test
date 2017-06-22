package com.zhiyou100.crm.service;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.CustomerCategory;

public interface CustomerCategoryService {
	
	List<CustomerCategory> list();
	CustomerCategory getById(int categoryId);
	boolean add(CustomerCategory category);
	boolean removeById(int categoryId, int updater, Timestamp updateTime);
	boolean update(CustomerCategory category);
	
}
