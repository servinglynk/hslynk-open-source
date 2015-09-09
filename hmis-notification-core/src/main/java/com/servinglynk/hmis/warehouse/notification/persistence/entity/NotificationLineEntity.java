package com.servinglynk.hmis.warehouse.notification.persistence.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationMethod;
import com.servinglynk.hmis.warehouse.notification.common.Constants.NotificationStatus;

@SuppressWarnings("serial")
@Entity
@Table(name = "HMIS_NOTIFICATION_LINE" )
public class NotificationLineEntity extends ParentEntity {

	private Long id;
	private Integer attempts;
	private String deliverTo;
	private String deliveryMethod;
	private Date sentAt;
	private String statusMessage;
	private String status;
	private String username;
	private TemplateHeaderEntity template;
	private Integer templateVersion;
	private String carrier;
	private String carrierConfirmation;
	private Integer carrierAttempts;
	private String externalId;
	
	@Id
	@SequenceGenerator(name="pk_sequence",sequenceName="hmis_notification_line_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	public Long getId() {
		return id;
	}
	

	public void setId(Long id) {
		this.id = id;
	}


	
	private NotificationHeaderEntity notificationHeaderEntity;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "notification_header_id", nullable = false, referencedColumnName = "id")
	public NotificationHeaderEntity getNotificationHeaderEntity() {
		return notificationHeaderEntity;
	}


	public void setNotificationHeaderEntity(
			NotificationHeaderEntity notificationHeaderEntity) {
		this.notificationHeaderEntity = notificationHeaderEntity;
	}


	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name = "attempts")
	public Integer getAttempts() {
		return attempts;
	}

	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}

	@Column(name = "deliver_to")
	public String getDeliverTo() {
		return deliverTo;
	}

	public void setDeliverTo(String deliverTo) {
		this.deliverTo = deliverTo;
	}

	@Column(name = "delivery_method")
	public NotificationMethod getDeliveryMethod() {
		return NotificationMethod.valueOf(deliveryMethod);
	}

	public void setDeliveryMethod(NotificationMethod deliveryMethod) {
		this.deliveryMethod = deliveryMethod.toString();
	}

	@Column(name = "sent_at")
	public Date getSentAt() {
		return sentAt;
	}

	public void setSentAt(Date sentAt) {
		this.sentAt = sentAt;
	}

	@Column(name = "status_message")
	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	@Column(name = "status")
	public NotificationStatus getStatus() {
		return NotificationStatus.valueOf(status);
	}

	public void setStatus(NotificationStatus status) {
		this.status = status.toString();
	}

	@Column(name = "username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	@Column(name = "carrier")
	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

	@Column(name = "carrier_confirmation")
	public String getCarrierConfirmation() {
		return carrierConfirmation;
	}

	public void setCarrierConfirmation(String carrierConfirmation) {
		this.carrierConfirmation = carrierConfirmation;
	}

	@Column(name = "carrier_attempts")
	public Integer getCarrierAttempts() {
		return carrierAttempts;
	}

	public void setCarrierAttempts(Integer carrierAttempts) {
		this.carrierAttempts = carrierAttempts;
	}
	
	@Column(name = "external_id")
	public String getExternalId() {
		return externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "template_id", nullable = false, referencedColumnName = "id")
	public TemplateHeaderEntity getTemplate() {
		return template;
	}


	public void setTemplate(TemplateHeaderEntity template) {
		this.template = template;
	}



	@Column(name = "template_version")
	public Integer getTemplateVersion() {
		return templateVersion;
	}





	


	public void setTemplateVersion(Integer templateVersion) {
		this.templateVersion = templateVersion;
	}
	
	


	
}
