package com.zhiyou100.crm.servlet.notice;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.model.User;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.service.impl.NoticeServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;
import com.zhiyou100.crm.util.SessionKey;

/**
 * 更新通知公告
 */
@WebServlet("/notice/update")
public class UpdateServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeId = Integer.parseInt(request.getParameter("id"));
		Notice notice = noticeService.getById(noticeId);
		request.setAttribute("notice", notice);
		System.out.println(notice);
		
		request.getRequestDispatcher("/WEB-INF/view/notice/update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Notice notice = new Notice();
		
		notice.setNoticeId(Integer.parseInt(request.getParameter("noticeId")));
		notice.setSubject(request.getParameter("subject").trim());
		notice.setText(request.getParameter("text").trim());
		notice.setPubTime(Timestamp.valueOf(request.getParameter("pubTime")));
		notice.setExpireTime(Timestamp.valueOf(request.getParameter("expireTime")));
		notice.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
		notice.setUpdater(user.getUserId());
		
		if (noticeService.update(notice)) {
			response.sendRedirect(request.getContextPath() + "/notice/list");
		}
		else {
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/view/notice/update.jsp").forward(request, response);
		}
	}

}
