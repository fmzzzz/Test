package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.zhiyou100.crm.dao.NoticeDao;
import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.util.DBUtil;

public class NoticeDaoImpl implements NoticeDao {

	@Override
	public List<Notice> list(String field, String keyword, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice getById(int noticeId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean add(Notice notice) {
		
		String sql = "INSERT INTO notice (`subject`, `text`, `pub_time`, `expire_time`, `create_time`, `creater`) VALUES (?, ?, ?, ?, ?, ?)";
		
		try(Connection conn = DBUtil.getConnection(); PreparedStatement s = conn.prepareStatement(sql)) {
			s.setString(1, notice.getSubject());
			s.setString(2, notice.getText());
			s.setTimestamp(3, notice.getPubTime());
			s.setTimestamp(4, notice.getExpireTime());
			s.setTimestamp(5, notice.getCreateTime());
			s.setInt(6, notice.getCreater());

			// 增加，修改，删除都是调用executeUpdate方法
			int rowCount = s.executeUpdate();
			return rowCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean removeById(int noticeId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Notice notice) {
		// TODO Auto-generated method stub
		return false;
	}

}
