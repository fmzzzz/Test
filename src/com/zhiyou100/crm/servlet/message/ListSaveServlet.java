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


@WebServlet("/message/listSave")
public class ListSaveServlet extends AdminBaseServlet {
	private static final long serialVersionUID = 1L;
       
	MessageService messageService = new MessageServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		List<Message> list = messageService.listSave(user.getUserId());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/view/message/listSave.jsp").forward(request, response);
	}

}
