package com.zhiyou100.crm.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.dao.MessageDao;
import com.zhiyou100.crm.dao.impl.MessageDaoImpl;
import com.zhiyou100.crm.model.Message;
import com.zhiyou100.crm.model.MessageSide;
import com.zhiyou100.crm.service.MessageService;
import com.zhiyou100.crm.util.Pager;

public class MessageServiceImpl implements MessageService {
	
	MessageDao messageDao = new MessageDaoImpl();

	@Override
	public boolean update(Message message, boolean send) {
		return messageDao.update(message, send);
	}

	@Override
	public boolean save(Message message, boolean send) {
		return messageDao.save(message, send);
	}

	@Override
	public boolean removeById(MessageSide side, int messageId, Timestamp updateTime, boolean forever) {
		return messageDao.removeById(side, messageId, updateTime, forever);
	}

	@Override
	public Message getById(int messageId) {
		return messageDao.getById(messageId);
	}

	@Override
	public int totalReceive(int userId, String field, String keyword) {
		return messageDao.totalReceive(userId, field, keyword);
	}

	@Override
	public List<Message> listReceive(int userId, String field, String keyword, Pager pager) {
		return messageDao.listReceive(userId, field, keyword, pager);
	}

	@Override
	public int totalSend(int userId, String field, String keyword) {
		return messageDao.totalSend(userId, field, keyword);
	}

	@Override
	public List<Message> listSend(int userId, String field, String keyword, Pager pager) {
		return messageDao.listSend(userId, field, keyword, pager);
	}

	@Override
	public int totalRemove(int userId, String field, String keyword) {
		return messageDao.totalRemove(userId, field, keyword);
	}

	@Override
	public List<Message> listRemove(int userId, String field, String keyword, Pager pager) {
		return messageDao.listRemove(userId, field, keyword, pager);
	}

	@Override
	public List<Message> listSave(int userId) {
		return messageDao.listSave(userId);
	}
	
}
