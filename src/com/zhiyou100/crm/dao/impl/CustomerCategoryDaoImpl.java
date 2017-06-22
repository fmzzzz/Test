package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.CustomerCategoryDao;
import com.zhiyou100.crm.model.CustomerCategory;
import com.zhiyou100.crm.util.DBUtil;

public class CustomerCategoryDaoImpl implements CustomerCategoryDao {
	
	CustomerCategory fillObject(ResultSet set) throws SQLException {
		CustomerCategory customerCategory = new CustomerCategory();

		customerCategory.setCustomerCategoryId(set.getInt("customer_category_id"));
		customerCategory.setCustomerCategoryName(set.getString("customer_category_name"));
		customerCategory.setCustomerCategoryDesc(set.getString("customer_category_desc"));
		customerCategory.setStatus(set.getInt("status"));
		customerCategory.setRemark(set.getString("remark"));
		customerCategory.setCreateTime(set.getTimestamp("create_time"));
		customerCategory.setCreater(set.getInt("creater"));
		customerCategory.setUpdateTime(set.getTimestamp("update_time"));
		customerCategory.setUpdater(set.getInt("updater"));
		
		return customerCategory;
	}
	
	@Override
	public List<CustomerCategory> list() {
		List<CustomerCategory> list = new ArrayList<CustomerCategory>();
		String sql = "select * from customer_category where status = 2";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql);
				ResultSet set = s.executeQuery()) {
			while (set.next()) {
				CustomerCategory customerCategory = this.fillObject(set);
				list.add(customerCategory);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public CustomerCategory getById(int customerCategoryId) {
		String sql = "select * from customer_category where status = 2 and customer_category_id = ?";

		try (Connection conn = DBUtil.getConnection();
				PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, customerCategoryId);
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
	public boolean add(CustomerCategory customerCategory) {
		String sql = "INSERT INTO customer_category (`customer_category_name`, `customer_category_desc`, `status`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerCategory.getCustomerCategoryName());
			s.setString(2, customerCategory.getCustomerCategoryDesc());
			s.setInt(3, 2);
			s.setTimestamp(4, customerCategory.getCreateTime());
			s.setInt(5, customerCategory.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeById(int customerCategoryId, int updater, Timestamp updateTime) {
		// 逻辑删除
		String sql = "update customer_category set status = -2, updater = ?, update_time = ? where customer_category_id = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setInt(1, updater);
			s.setTimestamp(2, updateTime);
			s.setInt(3, customerCategoryId);
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean update(CustomerCategory customerCategory) {
		String sql = "UPDATE customer_category SET `customer_category_name` = ?, `customer_category_desc` = ?, "
				+ "`update_time` = ?, `updater` = ? WHERE `customer_category_id` = ?";

		try (Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, customerCategory.getCustomerCategoryName());
			s.setString(2, customerCategory.getCustomerCategoryDesc());
			s.setTimestamp(3, customerCategory.getUpdateTime());
			s.setInt(4, customerCategory.getUpdater());
			s.setInt(5, customerCategory.getCustomerCategoryId());
			return s.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
