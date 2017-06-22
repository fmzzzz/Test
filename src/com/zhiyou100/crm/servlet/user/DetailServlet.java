package com.zhiyou100.crm.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.service.impl.UserServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 用户详情
 */
@WebServlet("/user/detail")
public class DetailServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = userService.getById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/view/user/detail.jsp").forward(request, response);
	}

}
