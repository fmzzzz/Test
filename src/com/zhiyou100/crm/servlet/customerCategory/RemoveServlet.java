package com.zhiyou100.crm.servlet.customerCategory;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.service.CustomerCategoryService;
import com.zhiyou100.crm.service.impl.CustomerCategoryServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 删除分类
 */
@WebServlet("/customerCategory/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sourceId = Integer.parseInt(request.getParameter("id"));

		customerCategoryService.removeById(sourceId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/customerCategory/list");
	}

}
