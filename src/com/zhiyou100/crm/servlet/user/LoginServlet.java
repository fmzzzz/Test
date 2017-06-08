package com.zhiyou100.crm.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.service.impl.UserServiceImpl;
import com.zhiyou100.crm.util.SessionKey;

/**
 * 处理登录请求
 * 注意：
 * 1.详细讲解Servlet的XML配置；
 * 2.无论多少个人访问这个Servlet，都访问的是同一个Servlet对象（即容器只创建一个LoginServlet对象）！
 */
public class LoginServlet extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();
	
	// 去掉了所有没必要的代码及注释
	// 主要讲页面跳转。
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 接收中文参数需要设置，已经改为通过Filter实现了
		//request.setCharacterEncoding("utf-8");
		
		// 注意参数与input标签中的name属性的值是一样的，与input标签的id无关
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println(username);
		System.out.println(password);
		
		/* 
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
		*/
		
		
		 User user = userService.getUserByLogin(username, password);
		 System.out.println("用户信息：" + user);
		 
		
		// 处理登录请求后不直接响应，而是跳转页面，这样我们可以利用JSP呈现复杂的页面，而不是用println/write之类写回大量的HTML
		if (user != null) {
			
			// 登录成功，在Session中保存用户信息
			// 查看源代码及文档的方法：从Tomcat官方下载源代码并附加到Eclipse中
			// 参数true的作用是如果还没有session，则创建一个。
			HttpSession session = request.getSession(true);
			session.setAttribute(SessionKey.USERNAME, user.getUsername());
			session.setAttribute(SessionKey.USER, user);
			
			// 登录成功，用重定向的方法跳到后台首页
			// 注意，因为重定向是浏览器行为，所以地址要加上应用路径，注意观察浏览器地址栏中地址的变化
			response.sendRedirect(request.getContextPath() + "/admin.jsp");
			
		}
		else {
			
			/* 方法1：
			// 登录失败，也用重定向的方法跳回登录页面
			// 这种方法只能通过URL传数据到登录页面
			// 但是重定向是通过Location响应头实现的，响应头中不能出现中文！这就需要进行特殊处理
			// 注意：通过网络工具监视是这样的：errorMessage=%E7%94%A8%E6%88%B... 用%E7这种英文字母代替了中文！
			response.sendRedirect(request.getContextPath() + "/index.jsp?errorMessage=" + URLEncoder.encode("用户名或密码错误！", "utf-8"));
			*/
			
			/* 方法2： */
			// 登录失败，将请求还转发回登录页，但是添加额外的错误提示（注意，当前在/user/login，而不是登录页index.jsp）
			// 注意向JSP页面传数据的方法！
			request.setAttribute("errorMessage", "用户名或密码错误！");
			// 注意，转发请求是服务器（应用内）行为，不需要加应用路径
			// 转发请求时，浏览器地址栏中无变化。转发时，要先获得请求派发器。
			// 转发是“请求”转发，而重定向是在“响应”中的；转发只有1次浏览器到服务器的往返，而重定向有2次
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		
		}
	}

}
