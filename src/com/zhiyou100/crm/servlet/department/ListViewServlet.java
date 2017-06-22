package com.zhiyou100.crm.servlet.department;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.service.DepartmentService;
import com.zhiyou100.crm.service.impl.DepartmentServiceImpl;


@WebServlet(urlPatterns = { "/department/listview" })
public class ListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DepartmentService departmentService = new DepartmentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> list = departmentService.list();
		
		System.out.println(list);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/view/department/listview.jsp").forward(request, response);
	}

}
