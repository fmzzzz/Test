package com.zhiyou100.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerSource implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int customerSourceId;
	String customerSourceName;
	String customerSourceDesc;
	int status;
	String remark;
	Timestamp createTime;
	int creater;
	Timestamp updateTime;
	int updater;
	
	@Override
	public String toString() {
		return "{" +
				"customerSourceId:" + this.customerSourceId + ", " +
				"customerSourceName:" + this.customerSourceName + ", " +
				"customerSourceDesc:" + this.customerSourceDesc + ", " +
				"status:" + this.status + ", " +
				"remark:" + this.remark + ", " +
				"createTime:" + this.createTime + ", " +
				"creater:" + this.creater + ", " +
				"updateTime:" + this.updateTime + ", " +
				"updater:" + this.updater +
				"}";
	}

	public int getCustomerSourceId() {
		return customerSourceId;
	}

	public void setCustomerSourceId(int customerSourceId) {
		this.customerSourceId = customerSourceId;
	}

	public String getCustomerSourceName() {
		return customerSourceName;
	}

	public void setCustomerSourceName(String customerSourceName) {
		this.customerSourceName = customerSourceName;
	}

	public String getCustomerSourceDesc() {
		return customerSourceDesc;
	}

	public void setCustomerSourceDesc(String customerSourceDesc) {
		this.customerSourceDesc = customerSourceDesc;
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

	public void setRemark(String remark) {
		this.remark = remark;
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
