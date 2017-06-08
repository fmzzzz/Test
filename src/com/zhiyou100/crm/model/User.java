package com.zhiyou100.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

// 注意为了让保存在Session中的模型数据比较稳定，需要支持序列化
public class User implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	int userId;
	String username;
	String password;
	Boolean isAdmin;
	int status;
	String remark;
	Timestamp createTime;
	int creater;
	Timestamp updateTime;
	int updater;
	
	// 重写toString方法，便于打印日志观察对象内部的数据
	@Override
	public String toString() {
		return "{" +
				"userId:" + this.userId + ", " +
				"username:" + this.username + ", " +
				"password:" + this.password + ", " +
				"isAdmin:" + this.isAdmin + ", " + 
				"status:" + this.status + ", " +
				"remark:" + this.remark + "," +
 				"createTime:" + this.createTime + ", " +
				"creater:" + this.creater + ", " +
				"updateTime:" + this.updateTime + ", " +
				"updater:" + this.updater +
				"}";
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String value) {
		remark = value;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getCreater() {
		return creater;
	}
	public void setCreater(int creater) {
		this.creater = creater;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdater() {
		return updater;
	}
	public void setUpdater(int updater) {
		this.updater = updater;
	}
	
}
