package com.zhiyou100.crm.servlet.customerSource;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerSource;
import com.zhiyou100.crm.service.CustomerSourceService;
import com.zhiyou100.crm.service.impl.CustomerSourceServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 更新角色
 */
@WebServlet("/customerSource/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerSourceId = Integer.parseInt(request.getParameter("id"));
		CustomerSource customerSource = customerSourceService.getById(customerSourceId);
		request.setAttribute("customerSource", customerSource);
		System.out.println(customerSource);
		
		request.getRequestDispatcher("/WEB-INF/view/customerSource/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerSource customerSource = new CustomerSource();
		customerSource.setCustomerSourceId(Integer.parseInt(request.getParameter("customerSourceId")));
		customerSource.setCustomerSourceName(request.getParameter("customerSourceName"));
		customerSource.setCustomerSourceDesc(request.getParameter("customerSourceDesc"));
		customerSource.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerSource.setUpdater(user.getUserId());
		
		if (customerSourceService.update(customerSource)) {
			response.sendRedirect(request.getContextPath() + "/customerSource/list");
		}
		else {
			request.setAttribute("customerSource", customerSource);
			request.getRequestDispatcher("/WEB-INF/view/customerSource/update.jsp").forward(request, response);
		}
	}

}
