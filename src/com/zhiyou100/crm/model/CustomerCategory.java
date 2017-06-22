package com.zhiyou100.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerCategory implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int customerCategoryId;
	String customerCategoryName;
	String customerCategoryDesc;
	int status;
	String remark;
	Timestamp createTime;
	int creater;
	Timestamp updateTime;
	int updater;
	
	@Override
	public String toString() {
		return "{" +
				"customerCategoryId:" + this.customerCategoryId + ", " +
				"customerCategoryName:" + this.customerCategoryName + ", " +
				"customerCategoryDesc:" + this.customerCategoryDesc + ", " +
				"status:" + this.status + ", " +
				"remark:" + this.remark + ", " +
				"createTime:" + this.createTime + ", " +
				"creater:" + this.creater + ", " +
				"updateTime:" + this.updateTime + ", " +
				"updater:" + this.updater +
				"}";
	}

	public int getCustomerCategoryId() {
		return customerCategoryId;
	}

	public void setCustomerCategoryId(int customerCategoryId) {
		this.customerCategoryId = customerCategoryId;
	}

	public String getCustomerCategoryName() {
		return customerCategoryName;
	}

	public void setCustomerCategoryName(String customerCategoryName) {
		this.customerCategoryName = customerCategoryName;
	}

	public String getCustomerCategoryDesc() {
		return customerCategoryDesc;
	}

	public void setCustomerCategoryDesc(String customerCategoryDesc) {
		this.customerCategoryDesc = customerCategoryDesc;
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
