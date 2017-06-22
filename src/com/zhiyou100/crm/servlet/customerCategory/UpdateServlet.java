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

/**
 * 更新分类
 */
@WebServlet("/customerCategory/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerCategoryId = Integer.parseInt(request.getParameter("id"));
		CustomerCategory customerCategory = customerCategoryService.getById(customerCategoryId);
		request.setAttribute("customerCategory", customerCategory);
		System.out.println(customerCategory);
		
		request.getRequestDispatcher("/WEB-INF/view/customerCategory/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerCategory customerCategory = new CustomerCategory();
		customerCategory.setCustomerCategoryId(Integer.parseInt(request.getParameter("customerCategoryId")));
		customerCategory.setCustomerCategoryName(request.getParameter("customerCategoryName"));
		customerCategory.setCustomerCategoryDesc(request.getParameter("customerCategoryDesc"));
		customerCategory.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		customerCategory.setUpdater(user.getUserId());
		
		if (customerCategoryService.update(customerCategory)) {
			response.sendRedirect(request.getContextPath() + "/customerCategory/list");
		}
		else {
			request.setAttribute("customerCategory", customerCategory);
			request.getRequestDispatcher("/WEB-INF/view/customerCategory/update.jsp").forward(request, response);
		}
	}

}
