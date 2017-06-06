package com.zhiyou100.crm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理登录请求
 */
public class LoginServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	
	// 去掉了所有没必要的代码及注释
	// 主要讲 Servlet 处理请求的过程，重点是接收请求数据，写回响应数据，响应编码处理。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		
		// 注意这里判断相等的写法，这是一种比较好的写法！
		if ("admin".equals(username) && "123456".equals(password)) {
			// 因为没有输出<head><meta charset="utf-8"></head>
			// 所以设置这个响应头避免出现中文乱码，关键是后面的编码设置！
			// 这种设置方法可以影响响应的字符编码，也能告诉浏览器响应采用的编码方式
			response.setHeader("Content-Type", "text/html; charset=utf-8");
			
			// 将字符串写到响应中的办法
			response.getWriter().write("登录成功！");
		}
		else {
			// 注意这里设置响应的字符编码方式，否则中文会乱码！
			response.setCharacterEncoding("utf-8");
			
			// 输出一个完整的HTML文档
			PrintWriter w = response.getWriter();
			w.println("<html>");
			w.println("<head>");
			
			// 注意这一行如果没有，虽然响应的编码是utf-8，但浏览器不知道（中文浏览器一般默认GB<国标中文简体>系列编码）
			w.println("<meta charset=\"utf-8\">");
			w.println("</head>");
			w.println("<body>");
			w.println("<p style=\"color:red;\">登录失败！</p>");
			w.println("</body>");
			w.println("</html>");
		}
	}

}
