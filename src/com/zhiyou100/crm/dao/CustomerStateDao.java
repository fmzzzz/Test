package com.zhiyou100.crm.dao;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.CustomerState;

public interface CustomerStateDao {
	List<CustomerState> list();
	CustomerState getById(int stateId);
	boolean add(CustomerState state);
	boolean removeById(int stateId, int updater, Timestamp updateTime);
	boolean update(CustomerState state);
}
