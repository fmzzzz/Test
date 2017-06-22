package com.zhiyou100.crm.servlet.department;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.service.DepartmentService;
import com.zhiyou100.crm.service.impl.DepartmentServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet(name = "DepartmentAddServlet", urlPatterns = { "/department/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	DepartmentService departmentService = new DepartmentServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/department/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Department department = new Department();
		department.setDepartmentName(request.getParameter("departmentName"));
		department.setDepartmentDesc(request.getParameter("departmentDesc"));
		department.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		department.setCreater(user.getUserId());
		
		System.out.println(department);
		
		if (departmentService.add(department)) {
			response.sendRedirect(request.getContextPath() + "/department/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
