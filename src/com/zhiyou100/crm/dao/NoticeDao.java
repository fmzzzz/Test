package com.zhiyou100.crm.dao;

import java.util.List;

import com.zhiyou100.crm.model.Notice;

public interface NoticeDao {
	List<Notice> list(String field, String keyword, int pageNo, int pageSize);
	Notice getById(int noticeId);
	boolean add(Notice notice);
	boolean removeById(int noticeId);
	boolean update(Notice notice);
}
