package com.zhiyou100.crm.dao;

import java.sql.Timestamp;
import java.util.List;

import com.zhiyou100.crm.model.Message;
import com.zhiyou100.crm.model.MessageSide;
import com.zhiyou100.crm.util.Pager;

// 设计难度较高，要一步步引导
public interface MessageDao {
	
	// 更新草稿/发送
	boolean update(Message message, boolean send);
	
	// 存草稿/直接发送
	boolean save(Message message, boolean send);
	
	// 删除
	boolean removeById(MessageSide side, int messageId, Timestamp updateTime, boolean forever);
	
	// 获取
	Message getById(int messageId);
	
	// 收件箱
	int totalReceive(int userId, String field, String keyword);
	List<Message> listReceive(int userId, String field, String keyword, Pager pager);
	
	// 发件箱
	int totalSend(int userId, String field, String keyword);
	List<Message> listSend(int userId, String field, String keyword, Pager pager);
	
	// 垃圾箱
	int totalRemove(int userId, String field, String keyword);
	List<Message> listRemove(int userId, String field, String keyword, Pager pager);
	
	// 草稿箱
	List<Message> listSave(int userId);
	
}
