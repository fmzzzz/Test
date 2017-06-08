package com.zhiyou100.crm.service.impl;

import java.util.List;

import com.zhiyou100.crm.dao.NoticeDao;
import com.zhiyou100.crm.dao.impl.NoticeDaoImpl;
import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.service.NoticeService;
import com.zhiyou100.crm.util.Pager;

public class NoticeServiceImpl implements NoticeService {
	
	NoticeDao noticeDao = new NoticeDaoImpl();
	
	@Override
	public int total(String field, String keyword) {
		return noticeDao.total(field, keyword);
	}
	
	@Override
	public List<Notice> list(String field, String keyword, Pager pager) {
		return noticeDao.list(field, keyword, pager);
	}

	@Override
	public Notice getById(int noticeId) {
		return noticeDao.getById(noticeId);
	}

	@Override
	public boolean add(Notice notice) {
		return noticeDao.add(notice);
	}

	@Override
	public boolean removeById(int noticeId) {
		return noticeDao.removeById(noticeId);
	}

	@Override
	public boolean update(Notice notice) {
		return noticeDao.update(notice);
	}

}
