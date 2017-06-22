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

@WebServlet("/customerState/add")
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerStateService customerStateService = new CustomerStateServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customerState/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerState customerState = new CustomerState();
		customerState.setCustomerStateName(request.getParameter("customerStateName"));
		customerState.setCustomerStateDesc(request.getParameter("customerStateDesc"));
		customerState.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerState.setCreater(user.getUserId());
		
		System.out.println(customerState);
		
		if (customerStateService.add(customerState)) {
			response.sendRedirect(request.getContextPath() + "/customerState/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
