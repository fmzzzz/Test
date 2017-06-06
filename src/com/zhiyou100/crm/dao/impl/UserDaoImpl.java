package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.crm.dao.UserDao;
import com.zhiyou100.crm.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByLogin(String username, String password) {
		
		// 加载驱动，如果不加载驱动会因找不到驱动类而抛异常
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn = null;
		User user = null;
		
		// 连接数据用的连接字符串
		String connUrl = "jdbc:mysql://127.0.0.1:3306/zy_crm?user=root&password=Zhou123";
		// 参数化查询语句
		String sql = "select * from user where username = ? and password = ?";
		
		try {
			
			conn = DriverManager.getConnection(connUrl);
			PreparedStatement s = conn.prepareStatement(sql);
			
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
			
			// 关闭以释放资源
			s.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
}
