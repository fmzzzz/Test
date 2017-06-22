package com.zhiyou100.crm.servlet.customerCategory;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerCategory;
import com.zhiyou100.crm.service.CustomerCategoryService;
import com.zhiyou100.crm.service.impl.CustomerCategoryServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet("/customerCategory/add")
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/customerCategory/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerCategory customerCategory = new CustomerCategory();
		customerCategory.setCustomerCategoryName(request.getParameter("customerCategoryName"));
		customerCategory.setCustomerCategoryDesc(request.getParameter("customerCategoryDesc"));
		customerCategory.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerCategory.setCreater(user.getUserId());
		
		System.out.println(customerCategory);
		
		if (customerCategoryService.add(customerCategory)) {
			response.sendRedirect(request.getContextPath() + "/customerCategory/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
