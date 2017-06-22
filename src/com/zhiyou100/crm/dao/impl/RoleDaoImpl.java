package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.RoleDao;
import com.zhiyou100.crm.model.Role;
import com.zhiyou100.crm.util.DBUtil;

public class RoleDaoImpl implements RoleDao {
	
	Role fillObject(ResultSet set) throws SQLException {
		Role role = new Role();

		role.setRoleId(set.getInt("role_id"));
		role.setRoleName(set.getString("role_name"));
		role.setRoleDesc(set.getString("role_desc"));
		role.setStatus(set.getInt("status"));
		role.setRemark(set.getString("remark"));
		role.setCreateTime(set.getTimestamp("create_time"));
		role.setCreater(set.getInt("creater"));
		role.setUpdateTime(set.getTimestamp("update_time"));
		role.setUpdater(set.getInt("updater"));
		
		return role;
	}
	
	@Override
	public List<Role> list() {
		List<Role> list = new ArrayList<Role>();
		String sql = "select * from role where status = 2";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql);
				ResultSet set = s.executeQuery()) {
			while (set.next()) {
				Role role = this.fillObject(set);
				list.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Role getById(int roleId) {
		String sql = "select * from role where status = 2 and role_id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, roleId);
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
	public boolean add(Role role) {
		String sql = "INSERT INTO role (`role_name`, `role_desc`, `status`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, role.getRoleName());
			s.setString(2, role.getRoleDesc());
			s.setInt(3, 2);
			s.setTimestamp(4, role.getCreateTime());
			s.setInt(5, role.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeById(int roleId, int updater, Timestamp updateTime) {
		// 逻辑删除
		String sql = "update role set status = -2, updater = ?, update_time = ? where role_id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, updater);
			s.setTimestamp(2, updateTime);
			s.setInt(3, roleId);
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(Role role) {
		String sql = "UPDATE role SET `role_name` = ?, `role_desc` = ?, "
				+ "`update_time` = ?, `updater` = ? WHERE `role_id` = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, role.getRoleName());
			s.setString(2, role.getRoleDesc());
			s.setTimestamp(3, role.getUpdateTime());
			s.setInt(4, role.getUpdater());
			s.setInt(5, role.getRoleId());
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
