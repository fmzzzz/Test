package com.zhiyou100.crm.servlet.notice;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;

/**
 * 删除通知
 */
@WebServlet("/notice/remove")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeId = Integer.parseInt(request.getParameter("id"));
		noticeService.removeById(noticeId);
		response.sendRedirect(request.getContextPath() + "/notice/list");
	}

}
