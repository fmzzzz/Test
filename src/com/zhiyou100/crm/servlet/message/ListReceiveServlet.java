package com.zhiyou100.crm.servlet.message;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Message;
import com.zhiyou100.crm.service.MessageService;
import com.zhiyou100.crm.service.impl.MessageServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.Pager;


@WebServlet("/message/listReceive")
public class ListReceiveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       
	MessageService messageService = new MessageServiceImpl();
	
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
		
		int total = messageService.totalReceive(user.getUserId(), field, keyword);
		Pager pager = new Pager(total, pageNo);
		List<Message> list = messageService.listReceive(user.getUserId(), field, keyword, pager);
		
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("/WEB-INF/view/message/listReceive.jsp").forward(request, response);
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
