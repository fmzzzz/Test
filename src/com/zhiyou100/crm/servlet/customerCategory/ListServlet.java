package com.zhiyou100.crm.servlet.customerCategory;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerCategory;
import com.zhiyou100.crm.service.CustomerCategoryService;
import com.zhiyou100.crm.service.impl.CustomerCategoryServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet("/customerCategory/list")
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

	CustomerCategoryService customerCategoryService = new CustomerCategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerCategory> list = customerCategoryService.list();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerCategory/list.jsp").forward(request, response);
	}

}
