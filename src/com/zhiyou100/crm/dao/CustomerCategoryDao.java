package com.zhiyou100.crm.dao;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.CustomerCategory;

public interface CustomerCategoryDao {
	List<CustomerCategory> list();
	CustomerCategory getById(int categoryId);
	boolean add(CustomerCategory category);
	boolean removeById(int categoryId, int updater, Timestamp updateTime);
	boolean update(CustomerCategory category);
}
