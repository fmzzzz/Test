package com.zhiyou100.crm.servlet.role;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Role;
import com.zhiyou100.crm.service.RoleService;
import com.zhiyou100.crm.service.impl.RoleServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet(name = "RoleListServlet", urlPatterns = { "/role/list" })
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;

	RoleService roleService = new RoleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Role> list = roleService.list();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/role/list.jsp").forward(request, response);
	}

}
