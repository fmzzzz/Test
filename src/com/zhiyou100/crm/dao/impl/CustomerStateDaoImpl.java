package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerStateDao;
import com.zhiyou100.crm.model.CustomerState;
import com.zhiyou100.crm.util.DBUtil;

public class CustomerStateDaoImpl implements CustomerStateDao {
	
	CustomerState fillObject(ResultSet set) throws SQLException {
		CustomerState customerState = new CustomerState();

		customerState.setCustomerStateId(set.getInt("customer_state_id"));
		customerState.setCustomerStateName(set.getString("customer_state_name"));
		customerState.setCustomerStateDesc(set.getString("customer_state_desc"));
		customerState.setStatus(set.getInt("status"));
		customerState.setRemark(set.getString("remark"));
		customerState.setCreateTime(set.getTimestamp("create_time"));
		customerState.setCreater(set.getInt("creater"));
		customerState.setUpdateTime(set.getTimestamp("update_time"));
		customerState.setUpdater(set.getInt("updater"));
		
		return customerState;
	}
	
	@Override
	public List<CustomerState> list() {
		List<CustomerState> list = new ArrayList<CustomerState>();
		String sql = "select * from customer_state where status = 2";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql);
				ResultSet set = s.executeQuery()) {
			while (set.next()) {
				CustomerState customerState = this.fillObject(set);
				list.add(customerState);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerState getById(int customerStateId) {
		String sql = "select * from customer_state where status = 2 and customer_state_id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, customerStateId);
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
	public boolean add(CustomerState customerState) {
		String sql = "INSERT INTO customer_state (`customer_state_name`, `customer_state_desc`, `status`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerState.getCustomerStateName());
			s.setString(2, customerState.getCustomerStateDesc());
			s.setInt(3, 2);
			s.setTimestamp(4, customerState.getCreateTime());
			s.setInt(5, customerState.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeById(int customerStateId, int updater, Timestamp updateTime) {
		// 逻辑删除
		String sql = "update customer_state set status = -2, updater = ?, update_time = ? where customer_state_id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, updater);
			s.setTimestamp(2, updateTime);
			s.setInt(3, customerStateId);
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(CustomerState customerState) {
		String sql = "UPDATE customer_state SET `customer_state_name` = ?, `customer_state_desc` = ?, "
				+ "`update_time` = ?, `updater` = ? WHERE `customer_state_id` = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerState.getCustomerStateName());
			s.setString(2, customerState.getCustomerStateDesc());
			s.setTimestamp(3, customerState.getUpdateTime());
			s.setInt(4, customerState.getUpdater());
			s.setInt(5, customerState.getCustomerStateId());
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
