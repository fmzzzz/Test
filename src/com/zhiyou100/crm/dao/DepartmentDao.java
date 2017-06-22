package com.zhiyou100.crm.dao;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.model.Notice;

public interface DepartmentDao {
	List<Department> list();
	Department getById(int departmentId);
	boolean add(Department department);
	boolean removeById(int departmentId, int updater, Timestamp updateTime);
	boolean update(Department department);
}
