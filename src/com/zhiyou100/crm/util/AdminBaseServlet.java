package com.zhiyou100.crm.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.User;

/**
 * 管理后台请求的共同父类，从此类继承的Servlet能够提供用户信息，如果没有登录就跳到登录页
 * 标记为abstract，只能当做父类使用
 */
public abstract class AdminBaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected User user = null;
	
	protected void service(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
		
		user = (User)req.getSession().getAttribute(SessionKey.USER);
		
		// 再加一层登录保护
		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
			return;
		}
		
		// 注意一定要调用父类的方法，否则请求相当于没有处理。
		super.service(req, resp);
	}
	
	protected User getUser() {
		return this.user;
	}
}
