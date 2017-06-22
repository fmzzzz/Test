package com.zhiyou100.crm.servlet.department;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.DepartmentService;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.DepartmentServiceImpl;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.SessionKey;

/**
 * 删除部门
 */
@WebServlet("/department/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	DepartmentService departmentService = new DepartmentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int departmentId = Integer.parseInt(request.getParameter("id"));

		departmentService.removeById(departmentId, user.getUserId(), Timestamp.valueOf(LocalDateTime.now()));
		response.sendRedirect(request.getContextPath() + "/department/list");
	}

}
