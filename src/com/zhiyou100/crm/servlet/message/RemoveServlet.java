package com.zhiyou100.crm.servlet.message;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.MessageSide;
import com.zhiyou100.crm.service.MessageService;
import com.zhiyou100.crm.service.impl.MessageServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 删除邮件
 */
@WebServlet("/message/remove")
public class RemoveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("id"));
		String side = request.getParameter("side");
		String forever = request.getParameter("forever");

		System.out.println(messageId);
		
		if ("send".equals(side)) {
			messageService.removeById(MessageSide.send, messageId, Timestamp.valueOf(LocalDateTime.now()), forever != null);
		}
		else if ("receive".equals(side)) {
			messageService.removeById(MessageSide.receive, messageId, Timestamp.valueOf(LocalDateTime.now()), forever != null);
		}
		else {
			messageService.removeById(MessageSide.send, messageId, Timestamp.valueOf(LocalDateTime.now()), forever != null);
			messageService.removeById(MessageSide.receive, messageId, Timestamp.valueOf(LocalDateTime.now()), forever != null);
		}
		
		// 重定向到请求来源页，注意向学生讲一下Referer请求头
		response.sendRedirect(request.getHeader("Referer"));
	}

}
