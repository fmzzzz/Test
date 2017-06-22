package com.zhiyou100.crm.servlet.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.Pager;

/**
 * 通知公告列表
 */
@WebServlet("/notice/list")
public class ListServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();
       
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
		
		int total = noticeService.total(field, keyword);
		Pager pager = new Pager(total, pageNo);
		List<Notice> list = noticeService.list(field, keyword, pager);
		
		
		request.setAttribute("list", list);
		request.setAttribute("pager", pager);
		request.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(request, response);
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
