package com.zhiyou100.crm.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	int messageId;
	String subject;
	String content;
	int sender;
	String senderName;
	int sendDelete;
	int sendStatus;
	Timestamp saveTime;
	Timestamp sendTime;
	Timestamp sendUpdateTime;
	int receiver;
	String receiverName;
	int receiveDelete;
	int receiveStatus;
	Timestamp receiveUpdateTime;
	
	@Override
	public String toString() {
		return "{" +
				"messageId:" + this.messageId + ", " +
				"subject:" + this.subject + ", " +
				"content:" + this.content + ", " +
				"sender:" + this.sender + ", " +
				"senderName:" + this.senderName + ", " +
				"sendDelete:" + this.sendDelete + ", " +
				"sendStatus:" + this.sendStatus + ", " +
				"saveTime:" + this.saveTime + ", " +
				"sendTime:" + this.sendTime + ", " +
				"sendUpdateTime:" + this.sendUpdateTime + ", " +
				"receiver:" + this.receiver + ", " +
				"receiverName:" + this.receiverName + ", " +
				"receiveDelete:" + this.receiveDelete + ", " +
				"receiveStatus:" + this.receiveStatus + ", " +
				"receiveUpdateTime:" + this.receiveUpdateTime +
				"}";
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public int getSendDelete() {
		return sendDelete;
	}

	public void setSendDelete(int sendDelete) {
		this.sendDelete = sendDelete;
	}

	public int getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(int sendStatus) {
		this.sendStatus = sendStatus;
	}

	public Timestamp getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}

	public Timestamp getSendTime() {
		return sendTime;
	}

	public void setSendTime(Timestamp sendTime) {
		this.sendTime = sendTime;
	}

	public Timestamp getSendUpdateTime() {
		return sendUpdateTime;
	}

	public void setSendUpdateTime(Timestamp sendUpdateTime) {
		this.sendUpdateTime = sendUpdateTime;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public int getReceiveDelete() {
		return receiveDelete;
	}

	public void setReceiveDelete(int receiveDelete) {
		this.receiveDelete = receiveDelete;
	}

	public int getReceiveStatus() {
		return receiveStatus;
	}

	public void setReceiveStatus(int receiveStatus) {
		this.receiveStatus = receiveStatus;
	}

	public Timestamp getReceiveUpdateTime() {
		return receiveUpdateTime;
	}

	public void setReceiveUpdateTime(Timestamp receiveUpdateTime) {
		this.receiveUpdateTime = receiveUpdateTime;
	}
	
}
