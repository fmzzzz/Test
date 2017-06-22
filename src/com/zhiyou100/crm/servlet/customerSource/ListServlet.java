package com.zhiyou100.crm.servlet.customerSource;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerSource;
import com.zhiyou100.crm.service.CustomerSourceService;
import com.zhiyou100.crm.service.impl.CustomerSourceServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet(urlPatterns = { "/customerSource/list" })
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

	CustomerSourceService customerSourceService = new CustomerSourceServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerSource> list = customerSourceService.list();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerSource/list.jsp").forward(request, response);
	}

}
