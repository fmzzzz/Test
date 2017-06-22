package com.zhiyou100.crm.servlet.role;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Role;
import com.zhiyou100.crm.service.RoleService;
import com.zhiyou100.crm.service.impl.RoleServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet(urlPatterns = { "/role/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	RoleService roleService = new RoleServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/role/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Role role = new Role();
		role.setRoleName(request.getParameter("roleName"));
		role.setRoleDesc(request.getParameter("roleDesc"));
		role.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		role.setCreater(user.getUserId());
		
		System.out.println(role);
		
		if (roleService.add(role)) {
			response.sendRedirect(request.getContextPath() + "/role/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
