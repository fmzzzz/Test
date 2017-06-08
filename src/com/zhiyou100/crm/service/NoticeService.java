package com.zhiyou100.crm.service;

import java.util.List;

import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.util.Pager;

public interface NoticeService {
	int total(String field, String keyword);
	List<Notice> list(String field, String keyword, Pager pager);
	Notice getById(int noticeId);
	boolean add(Notice notice);
	boolean removeById(int noticeId);
	boolean update(Notice notice);
}
