package com.zhiyou100.crm.servlet.customerSource;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.service.CustomerSourceService;
import com.zhiyou100.crm.service.impl.CustomerSourceServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 删除来源
 */
@WebServlet("/customerSource/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sourceId = Integer.parseInt(request.getParameter("id"));

		customerSourceService.removeById(sourceId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/customerSource/list");
	}

}
