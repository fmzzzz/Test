package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.DepartmentDao;
import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.util.DBUtil;

public class DepartmentDaoImpl implements DepartmentDao {
	
	Department fillObject(ResultSet set) throws SQLException {
		Department department = new Department();

		department.setDepartmentId(set.getInt("department_id"));
		department.setDepartmentName(set.getString("department_name"));
		department.setDepartmentDesc(set.getString("department_desc"));
		department.setStatus(set.getInt("status"));
		department.setRemark(set.getString("remark"));
		department.setCreateTime(set.getTimestamp("create_time"));
		department.setCreater(set.getInt("creater"));
		department.setUpdateTime(set.getTimestamp("update_time"));
		department.setUpdater(set.getInt("updater"));
		
		return department;
	}
	
	@Override
	public List<Department> list() {
		List<Department> list = new ArrayList<Department>();
		String sql = "select * from department where status = 2";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql);
				ResultSet set = s.executeQuery()) {
			while (set.next()) {
				Department department = this.fillObject(set);
				list.add(department);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Department getById(int departmentId) {
		String sql = "select * from department where status = 2 and department_id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, departmentId);
			try (ResultSet set = s.executeQuery()){
				if (set.next()) {
					return this.fillObject(set);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean add(Department department) {
		String sql = "INSERT INTO department (`department_name`, `department_desc`, `status`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, department.getDepartmentName());
			s.setString(2, department.getDepartmentDesc());
			s.setInt(3, 2);
			s.setTimestamp(4, department.getCreateTime());
			s.setInt(5, department.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeById(int departmentId, int updater, Timestamp updateTime) {
		// 逻辑删除
		String sql = "update department set status = -2, updater = ?, update_time = ? where department_id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, updater);
			s.setTimestamp(2, updateTime);
			s.setInt(3, departmentId);
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Department department) {
		String sql = "UPDATE department SET `department_name` = ?, `department_desc` = ?, "
				+ "`update_time` = ?, `updater` = ? WHERE `department_id` = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, department.getDepartmentName());
			s.setString(2, department.getDepartmentDesc());
			s.setTimestamp(3, department.getUpdateTime());
			s.setInt(4, department.getUpdater());
			s.setInt(5, department.getDepartmentId());
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
