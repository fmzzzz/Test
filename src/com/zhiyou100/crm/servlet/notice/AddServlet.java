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
 * 发布公告
 */
@WebServlet("/notice/add")
public class AddServlet extends AdminBaseServlet {

	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/notice/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Notice notice = new Notice();
		notice.setPubTime(Timestamp.valueOf(request.getParameter("pubTime")));
		notice.setExpireTime(Timestamp.valueOf(request.getParameter("expireTime")));
		notice.setSubject(request.getParameter("subject"));
		notice.setText(request.getParameter("text"));
		notice.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
		notice.setCreater(user.getUserId());
		
		System.out.println(notice);
		
		if (noticeService.add(notice)) {
			response.sendRedirect(request.getContextPath() + "/notice/list");
		}
		else{
			doGet(request, response);
		}
		
	}

}
