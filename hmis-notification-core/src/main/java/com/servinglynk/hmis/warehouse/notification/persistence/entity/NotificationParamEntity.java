package com.servinglynk.hmis.warehouse.notification.persistence.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "HMIS_NOTIFICATION_PARAM")
public class NotificationParamEntity extends ParentEntity {
	
	private Long id;
	private String senderEmailAddress;
	private String senderFriendlyName;
	private String templateId;
	private String externalId;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "sender_email_address")
	public String getSenderEmailAddress() {
		return senderEmailAddress;
	}
	public void setSenderEmailAddress(String senderEmailAddress) {
		this.senderEmailAddress = senderEmailAddress;
	}
	
	@Column(name = "sender_friendly_name")
	public String getSenderFriendlyName() {
		return senderFriendlyName;
	}
	public void setSenderFriendlyName(String senderFriendlyName) {
		this.senderFriendlyName = senderFriendlyName;
	}
	
	@Column(name = "template_id")
	public String getTemplateId() {
		return templateId;
	}
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	
	
	@Column(name = "external_id")
	public String getExternalId() {
		return externalId;
	}
	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}	
}
