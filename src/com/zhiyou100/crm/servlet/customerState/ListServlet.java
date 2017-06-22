package com.zhiyou100.crm.servlet.customerState;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.CustomerState;
import com.zhiyou100.crm.service.CustomerStateService;
import com.zhiyou100.crm.service.impl.CustomerStateServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;


@WebServlet("/customerState/list")
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       
	CustomerStateService customerStateService = new CustomerStateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<CustomerState> list = customerStateService.list();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/customerState/list.jsp").forward(request, response);
	}

}
