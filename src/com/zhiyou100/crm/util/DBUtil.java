package com.zhiyou100.crm.util;

import java.sql.Connection;
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
        	DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/zycrm");    
        	con = ds.getConnection();  
             
        } catch (NamingException e) {  
        	e.printStackTrace();  
        } catch (SQLException e) {
        	e.printStackTrace();
		} 
        
        return con;    
	} 
}
