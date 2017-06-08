package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.crm.dao.UserDao;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByLogin(String username, String password) {
		
		// 参数化查询语句
		String sql = "select * from user where username = ? and password = ?";
		User user = null;
		
		
		// 封装一个工具类，否则的话获取数据库连接的代码会出每个DaoImpl出现！
		/*
		Connection conn = DBUtil.getConnection();
		PreparedStatement s = null;
		
		try {
			
			s = conn.prepareStatement(sql);
			
			// 按顺序设置查询参数，从1开始
			s.setString(1, username);
			s.setString(2, password);
			
			// 查询结果
			ResultSet set = s.executeQuery();
			
			// 读取查询结果中的第一条数据
			if (set.next()) {
				user = new User();
				
				// 将数据设置到模型对象中
				user.setUserId(set.getInt("user_id"));
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				user.setIsAdmin(set.getBoolean("is_admin"));
				user.setStatus(set.getInt("status"));
				user.setCreater(set.getInt("creater"));
				user.setCreateTime(set.getDate("create_time"));
				user.setUpdater(set.getInt("updater"));
				user.setUpdateTime(set.getDate("update_time"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			// 关闭以释放资源
			try {
				if (s != null) s.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		*/
		
		
		// 上面创建及关闭连接和参数化语句很烦人，
		// 得先在外面声明变量，还得写finally关闭，关闭时还得判断是否为null，关闭时还有可能抛出异常！
		// 幸好 Java 7中新增了try with resources功能！可以简化代码！
		// try with resources会倒序关闭try中创建的资源
		try(Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			
			// 按顺序设置查询参数，从1开始
			s.setString(1, username);
			s.setString(2, password);
			
			// 查询结果
			ResultSet set = s.executeQuery();
			
			// 读取查询结果中的第一条数据
			if (set.next()) {
				user = new User();
				
				// 将数据设置到模型对象中
				user.setUserId(set.getInt("user_id"));
				user.setUsername(set.getString("username"));
				user.setPassword(set.getString("password"));
				user.setIsAdmin(set.getBoolean("is_admin"));
				user.setStatus(set.getInt("status"));
				user.setCreater(set.getInt("creater"));
				user.setCreateTime(set.getTimestamp("create_time"));
				user.setUpdater(set.getInt("updater"));
				user.setUpdateTime(set.getTimestamp("update_time"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	}
	
}
