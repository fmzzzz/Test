package com.zhiyou100.crm.model;

import java.util.Date;

public class User {
	int userId;
	String username;
	String password;
	Boolean isAdmin;
	int status;
	Date createTime;
	int creater;
	Date updateTime;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCreater() {
		return creater;
	}
	public void setCreater(int creater) {
		this.creater = creater;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getUpdater() {
		return updater;
	}
	public void setUpdater(int updater) {
		this.updater = updater;
	}
	
}
