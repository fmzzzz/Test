package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerSourceDao;
import com.zhiyou100.crm.model.CustomerSource;
import com.zhiyou100.crm.util.DBUtil;

public class CustomerSourceDaoImpl implements CustomerSourceDao {
	
	CustomerSource fillObject(ResultSet set) throws SQLException {
		CustomerSource customerSource = new CustomerSource();

		customerSource.setCustomerSourceId(set.getInt("customer_source_id"));
		customerSource.setCustomerSourceName(set.getString("customer_source_name"));
		customerSource.setCustomerSourceDesc(set.getString("customer_source_desc"));
		customerSource.setStatus(set.getInt("status"));
		customerSource.setRemark(set.getString("remark"));
		customerSource.setCreateTime(set.getTimestamp("create_time"));
		customerSource.setCreater(set.getInt("creater"));
		customerSource.setUpdateTime(set.getTimestamp("update_time"));
		customerSource.setUpdater(set.getInt("updater"));
		
		return customerSource;
	}
	
	@Override
	public List<CustomerSource> list() {
		List<CustomerSource> list = new ArrayList<CustomerSource>();
		String sql = "select * from customer_source where status = 2";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql);
				ResultSet set = s.executeQuery()) {
			while (set.next()) {
				CustomerSource customerSource = this.fillObject(set);
				list.add(customerSource);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerSource getById(int customerSourceId) {
		String sql = "select * from customer_source where status = 2 and customer_source_id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, customerSourceId);
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
	public boolean add(CustomerSource customerSource) {
		String sql = "INSERT INTO customer_source (`customer_source_name`, `customer_source_desc`, `status`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerSource.getCustomerSourceName());
			s.setString(2, customerSource.getCustomerSourceDesc());
			s.setInt(3, 2);
			s.setTimestamp(4, customerSource.getCreateTime());
			s.setInt(5, customerSource.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeById(int customerSourceId, int updater, Timestamp updateTime) {
		// 逻辑删除
		String sql = "update customer_source set status = -2, updater = ?, update_time = ? where customer_source_id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, updater);
			s.setTimestamp(2, updateTime);
			s.setInt(3, customerSourceId);
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(CustomerSource customerSource) {
		String sql = "UPDATE customer_source SET `customer_source_name` = ?, `customer_source_desc` = ?, "
				+ "`update_time` = ?, `updater` = ? WHERE `customer_source_id` = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerSource.getCustomerSourceName());
			s.setString(2, customerSource.getCustomerSourceDesc());
			s.setTimestamp(3, customerSource.getUpdateTime());
			s.setInt(4, customerSource.getUpdater());
			s.setInt(5, customerSource.getCustomerSourceId());
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
