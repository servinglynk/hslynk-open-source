package com.servinglynk.hmis.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.servinglynk.hmis.warehouse.model.base.BaseModel;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_notification",schema="notificationdb")
public class HMISNotificationEntity extends BaseModel {
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="notificationdb.hmis_notification_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id")
	private Long id;

	@Column(name="message_type")
    private String messageType;
	
	@Column(name="status")
	private String status;
	
	@Column(name="status_message")
	private String statusMessage;

	@Column(name="attachment")
	private String attachment;

	@Column(name="method")
	private String method;

	@Column(name="recipients")
	private String recipients;
	
	@Column(name="message")
	private String message;
	
	@Column(name="recipient_type")
	private String recipientType;
	
	@Column(name="recipient_id")
	private String recipientId;	
	
	@Column(name="project_group_code")
	private String projectGroupCode;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="priority")
	private Integer priority;
	
	@Column(name="delivered_at")  
	private Date deliveredAt;

	public String getMessageType() {
		return messageType;
	}

	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRecipientType() {
		return recipientType;
	}

	public void setRecipientType(String recipientType) {
		this.recipientType = recipientType;
	}

	public String getRecipientId() {
		return recipientId;
	}

	public void setRecipientId(String recipientId) {
		this.recipientId = recipientId;
	}

	public String getProjectGroupCode() {
		return projectGroupCode;
	}

	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getDeliveredAt() {
		return deliveredAt;
	}

	public void setDeliveredAt(Date deliveredAt) {
		this.deliveredAt = deliveredAt;
	}
}