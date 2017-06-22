package com.zhiyou100.crm.servlet.customerState;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.service.CustomerStateService;
import com.zhiyou100.crm.service.impl.CustomerStateServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 删除客户状态
 */
@WebServlet("/customerState/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerStateService customerStateService = new CustomerStateServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerStateId = Integer.parseInt(request.getParameter("id"));

		customerStateService.removeById(customerStateId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/customerState/list");
	}

}
