package com.zhiyou100.crm.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 检查用户是否登录，如果没有登录则跳转到登录页
 */
public class UserFilter implements Filter {

	// 这个方法是过滤器必须实现的方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// Servlet过滤器工作在Http层之下，因此此处需要类型转换
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		if (session == null || session.getAttribute("username") == null) {
			System.out.println("用户过滤器：用户未登录，跳到登录页！");
			
			HttpServletResponse res = (HttpServletResponse)response;
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			
			// 不需要后续处理了！
			return;
		}
		else {
			System.out.println("用户过滤器：用户已登录，允许访问！");
			
			// 注意：调用chain.doFilter继续处理请求！
			chain.doFilter(request, response);
		}
		
	}

	
	/* 下面2个方法只有在使用特殊情况时才需要实现，大部分情况可留空
	 * 这2个方法删除也可以，因为最新版的Filter接口定义中已经把这2个方法声明为 default 的。
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
	
	public void destroy() {

	}
	
}
