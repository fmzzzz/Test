package com.zhiyou100.crm.servlet.customerState;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerState;
import com.zhiyou100.crm.service.CustomerStateService;
import com.zhiyou100.crm.service.impl.CustomerStateServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 更新客户状态
 */
@WebServlet("/customerState/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerStateService customerStateService = new CustomerStateServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerStateId = Integer.parseInt(request.getParameter("id"));
		CustomerState customerState = customerStateService.getById(customerStateId);
		request.setAttribute("customerState", customerState);
		System.out.println(customerState);
		
		request.getRequestDispatcher("/WEB-INF/view/customerState/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerState customerState = new CustomerState();
		customerState.setCustomerStateId(Integer.parseInt(request.getParameter("customerStateId")));
		customerState.setCustomerStateName(request.getParameter("customerStateName"));
		customerState.setCustomerStateDesc(request.getParameter("customerStateDesc"));
		customerState.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerState.setUpdater(user.getUserId());
		
		if (customerStateService.update(customerState)) {
			response.sendRedirect(request.getContextPath() + "/customerState/list");
		}
		else {
			request.setAttribute("customerState", customerState);
			request.getRequestDispatcher("/WEB-INF/view/customerState/update.jsp").forward(request, response);
		}
	}

}
