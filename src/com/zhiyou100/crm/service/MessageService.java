package com.zhiyou100.crm.service;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.Message;
import com.zhiyou100.crm.model.MessageSide;
import com.zhiyou100.crm.util.Pager;

public interface MessageService {
	
	boolean update(Message message, boolean send);
	boolean save(Message message, boolean send);
	boolean removeById(MessageSide side, int messageId, Timestamp updateTime, boolean forever);
	Message getById(int messageId);

	int totalReceive(int userId, String field, String keyword);
	List<Message> listReceive(int userId, String field, String keyword, Pager pager);
	
	int totalSend(int userId, String field, String keyword);
	List<Message> listSend(int userId, String field, String keyword, Pager pager);

	int totalRemove(int userId, String field, String keyword);
	List<Message> listRemove(int userId, String field, String keyword, Pager pager);
	
	List<Message> listSave(int userId);
	
}
