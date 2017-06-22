package com.zhiyou100.crm.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.UserService;
import com.zhiyou100.crm.service.impl.UserServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.Pager;

/**
 * 用户列表
 */
@WebServlet("/user/listview")
public class ListViewServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	UserService userService = new UserServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = "";
		String keyword = "";
		int pageNo = 1;
		
		if ("POST".equalsIgnoreCase(request.getMethod())) {
			field = (String)request.getAttribute("field");
			keyword = (String)request.getAttribute("keyword");
			pageNo = (int)request.getAttribute("pageNo");
		}		
		
		int total = userService.total(field, keyword);
		Pager pager = new Pager(total, pageNo);
		List<User> list = userService.list(field, keyword, pager);
		
		
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("/WEB-INF/view/user/listview.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String field = request.getParameter("searchField");
		String keyword = request.getParameter("keyword");
		
		int pageNo = 1;
		String pn = request.getParameter("pageNo");
		if (pn != null && !"".equals(pn)) {
			pageNo = Integer.parseInt(pn);
		}
		
		request.setAttribute("field", field);
		request.setAttribute("keyword", keyword);
		request.setAttribute("pageNo", pageNo);
		
		doGet(request, response);
	}

}
