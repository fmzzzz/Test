package com.zhiyou100.crm.servlet.department;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.DepartmentService;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.DepartmentServiceImpl;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.SessionKey;

/**
 * 更新部门
 */
@WebServlet("/department/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	DepartmentService departmentService = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentId = Integer.parseInt(request.getParameter("id"));
		Department department = departmentService.getById(departmentId);
		request.setAttribute("department", department);
		System.out.println(department);
		
		request.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Department department = new Department();
		department.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		department.setDepartmentName(request.getParameter("departmentName"));
		department.setDepartmentDesc(request.getParameter("departmentDesc"));
		department.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		department.setUpdater(user.getUserId());
		
		if (departmentService.update(department)) {
			response.sendRedirect(request.getContextPath() + "/department/list");
		}
		else {
			request.setAttribute("department", department);
			request.getRequestDispatcher("/WEB-INF/view/department/update.jsp").forward(request, response);
		}
	}

}
