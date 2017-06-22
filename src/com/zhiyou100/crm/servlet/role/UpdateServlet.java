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

/**
 * 更新角色
 */
@WebServlet("/role/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	RoleService roleService = new RoleServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int roleId = Integer.parseInt(request.getParameter("id"));
		Role role = roleService.getById(roleId);
		request.setAttribute("role", role);
		System.out.println(role);
		
		request.getRequestDispatcher("/WEB-INF/view/role/update.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Role role = new Role();
		role.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		role.setRoleName(request.getParameter("roleName"));
		role.setRoleDesc(request.getParameter("roleDesc"));
		role.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		role.setUpdater(user.getUserId());
		
		if (roleService.update(role)) {
			response.sendRedirect(request.getContextPath() + "/role/list");
		}
		else {
			request.setAttribute("role", role);
			request.getRequestDispatcher("/WEB-INF/view/role/update.jsp").forward(request, response);
		}
	}

}
