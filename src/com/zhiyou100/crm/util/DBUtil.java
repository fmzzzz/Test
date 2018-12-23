package com.zhiyou100.crm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 使用JDBC连接池获取数据库连接
 * @author ChangWei
 *
 */
public class DBUtil {
	static Context ctx = getContext();
//	static String USERNAME = "root";  
//	static String PASSWORD = "123456";  
	static Context getContext() {
		Context ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e) {
			e.printStackTrace();
		} 
		return ctx;
	}
	
	/**
	 * 获取数据库连接
	 * @return 数据库连接
	 */
	public static Connection getConnection(){  
        Connection con = null;
       
        try {  
        	Class.forName("com.mysql.jdbc.Driver");  
        	 String url = "jdbc:mysql://localhost:3306/zycrm";  
            con=DriverManager.getConnection(url,"root","123456");  
        }catch (Exception e) {  
            System.out.println("DBUtils.getConnection---获取连接失败！");  
            e.printStackTrace();  
        }  
		return con;  
	}
}