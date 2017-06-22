package com.zhiyou100.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomerState implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int customerStateId;
	String customerStateName;
	String customerStateDesc;
	int status;
	String remark;
	Timestamp createTime;
	int creater;
	Timestamp updateTime;
	int updater;
	
	
	@Override
	public String toString() {
		return "{" +
				"customerStateId:" + this.customerStateId + ", " +
				"customerStateName:" + this.customerStateName + ", " +
				"customerStateDesc:" + this.customerStateDesc + ", " +
				"status:" + this.status + ", " +
				"remark:" + this.remark + ", " +
				"createTime:" + this.createTime + ", " +
				"creater:" + this.creater + ", " +
				"updateTime:" + this.updateTime + ", " +
				"updater:" + this.updater +
				"}";
	}


	public int getCustomerStateId() {
		return customerStateId;
	}


	public void setCustomerStateId(int customerStateId) {
		this.customerStateId = customerStateId;
	}


	public String getCustomerStateName() {
		return customerStateName;
	}


	public void setCustomerStateName(String customerStateName) {
		this.customerStateName = customerStateName;
	}


	public String getCustomerStateDesc() {
		return customerStateDesc;
	}


	public void setCustomerStateDesc(String customerStateDesc) {
		this.customerStateDesc = customerStateDesc;
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
