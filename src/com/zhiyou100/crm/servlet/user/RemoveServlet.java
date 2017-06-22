package com.zhiyou100.crm.servlet.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.service.impl.UserServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 删除用户
 */
@WebServlet("/user/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("id"));

		userService.removeById(userId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/user/list");
	}

}
