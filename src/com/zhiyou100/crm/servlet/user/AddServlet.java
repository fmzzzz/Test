package com.zhiyou100.crm.servlet.user;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Department;
import com.zhiyou100.crm.model.Role;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.DepartmentService;
import com.zhiyou100.crm.service.RoleService;
import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.service.impl.DepartmentServiceImpl;
import com.zhiyou100.crm.service.impl.RoleServiceImpl;
import com.zhiyou100.crm.service.impl.UserServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

@WebServlet(urlPatterns = { "/user/add" })
public class AddServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();
	DepartmentService departmentService = new DepartmentServiceImpl();
	RoleService roleService = new RoleServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Department> departments = departmentService.list();
		List<Role> roles = roleService.list();
		
		request.setAttribute("departments", departments);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/WEB-INF/view/user/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setDepartmentId(Integer.parseInt(request.getParameter("departmentId")));
		user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
		user.setIsMale("true".equals(request.getParameter("isMale")));
		user.setMobile(request.getParameter("mobile"));
		user.setAddress(request.getParameter("address"));
		user.setAge(Integer.parseInt(request.getParameter("age")));
		user.setTel(request.getParameter("tel"));
		user.setIdNum(request.getParameter("idNum"));
		user.setEmail(request.getParameter("email"));
		user.setQq(request.getParameter("qq"));
		user.setHobby(request.getParameter("hobby"));
		user.setEducation(request.getParameter("education"));
		user.setCardNum(request.getParameter("cardNum"));
		user.setNation(request.getParameter("nation"));
		user.setMarry(Integer.parseInt(request.getParameter("marry")));
		user.setRemark(request.getParameter("remark"));
		
		user.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		user.setCreater(user.getUserId());
		
		System.out.println(user);
		
		if (userService.add(user)) {
			response.sendRedirect(request.getContextPath() + "/user/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
