package com.zhiyou100.crm.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhiyou100.crm.dao.NoticeDao;
import com.zhiyou100.crm.model.Notice;
import com.zhiyou100.crm.util.DBUtil;
import com.zhiyou100.crm.util.Pager;

public class NoticeDaoImpl implements NoticeDao {
	
	// 此处讲一个方法重载，Java不支持参数默认值！注意区别重载（Overload）与重写（Override）！
	StringBuilder buildQuerySql(String field, String keyword) {
		return buildQuerySql(field, keyword, false);
	}

	// 把拼接SQL语句的代码封装成一个方法
	StringBuilder buildQuerySql(String field, String keyword, boolean isCount) {
		String filter = "";
		if (keyword != null && !"".equals(keyword)) {
			// 此处会导入SQL注入漏洞！
			keyword = "'%" + keyword + "%' ";
			filter = "and n.subject like " + keyword;
			if ("text".equals(field)) {
				filter = "and n.text like " + keyword;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		if (isCount) {
			sb.append("select count(n.notice_id) from notice n ");
		}
		else {
			sb.append("select n.*, u.username creater_name from notice n ");
		}
		
		sb.append("left join user u on n.creater = u.user_id ");
		sb.append("where n.status = 2 ");
		sb.append(filter);
		
		return sb;
	}
	
	@Override
	public int total(String field, String keyword) {
		int total = 0;
		StringBuilder sb = buildQuerySql(field, keyword, true);
		
		try(
			Connection conn = DBUtil.getConnection(); 
			PreparedStatement s = conn.prepareStatement(sb.toString());
			ResultSet set = s.executeQuery()
		){
			while (set.next()) {
				return set.getInt(1); // 注意此处从1开始！
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return total;
	}
	
	@Override
	public List<Notice> list(String field, String keyword, Pager pager) {
		List<Notice> list = new ArrayList<Notice>();
		
		StringBuilder sb = buildQuerySql(field, keyword);
		sb.append("limit " + (pager.getPageNo() - 1) * pager.getPageSize() + ", " + pager.getPageSize());
		
		try(
			Connection conn = DBUtil.getConnection(); 
			PreparedStatement s = conn.prepareStatement(sb.toString());
			ResultSet set = s.executeQuery()
		){
			
			while (set.next()) {
				Notice notice = new Notice();
				
				notice.setNoticeId(set.getInt("notice_id"));
				notice.setPubTime(set.getTimestamp("pub_time"));
				notice.setExpireTime(set.getTimestamp("expire_time"));
				notice.setSubject(set.getString("subject"));
				notice.setText(set.getString("text"));
				notice.setStatus(set.getInt("status"));
				notice.setRemark(set.getString("remark"));
				notice.setCreateTime(set.getTimestamp("create_time"));
				notice.setCreater(set.getInt("creater"));
				notice.setCreaterName(set.getString("creater_name"));
				notice.setUpdateTime(set.getTimestamp("update_time"));
				notice.setUpdater(set.getInt("updater"));
				
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
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
