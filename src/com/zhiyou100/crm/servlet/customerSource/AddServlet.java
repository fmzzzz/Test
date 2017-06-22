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

@WebServlet(urlPatterns = { "/customerSource/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customerSource/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerSource customerSource = new CustomerSource();
		customerSource.setCustomerSourceName(request.getParameter("customerSourceName"));
		customerSource.setCustomerSourceDesc(request.getParameter("customerSourceDesc"));
		customerSource.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerSource.setCreater(user.getUserId());
		
		System.out.println(customerSource);
		
		if (customerSourceService.add(customerSource)) {
			response.sendRedirect(request.getContextPath() + "/customerSource/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
