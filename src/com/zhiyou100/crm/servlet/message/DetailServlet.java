package com.zhiyou100.crm.servlet.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.crm.model.Message;
import com.zhiyou100.crm.service.MessageService;
import com.zhiyou100.crm.service.impl.MessageServiceImpl;
import com.zhiyou100.crm.util.AdminBaseServlet;

/**
 * 邮件详情
 */
@WebServlet("/message/detail")
public class DetailServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
	
	MessageService messageService = new MessageServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int messageId = Integer.parseInt(request.getParameter("id"));
		Message message = messageService.getById(messageId);
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/view/message/detail.jsp").forward(request, response);
	}

}
