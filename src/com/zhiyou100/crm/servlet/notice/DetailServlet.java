package com.zhiyou100.crm.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 公告详情
 */
@WebServlet("/notice/detail")
public class DetailServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeId = Integer.parseInt(request.getParameter("id"));
		Notice notice = noticeService.getById(noticeId);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(request, response);
	}

}
