package com.servinglynk.hmis.warehouse.model.base;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@SuppressWarnings("serial")
@Entity
@Table(name="CLIENT_CONSENT_REQUEST_STATUS",schema="base",catalog="hmis")
public class ClientConsentStatusEntity extends BaseModel {

	@Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "ID")
	private UUID statuId;
	
	@ManyToOne
	@JoinColumn(name="consent_request_id")
	private ClientConsentRequestEntity clientConsentRequestEntity;
	
	@Column(name="approval_status")
	private String approvalStatus;
	
	@Column(name="approval_status_effective_from_date")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	private LocalDateTime approvalStatusEffectiveFromDate; 
	
	@Column(name="approval_status_effective_to_date")
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	private LocalDateTime approvalStatusEffectiveToDate; 
	
	@Column(name="deleted")
	private boolean deleted;

	public UUID getStatuId() {
		return statuId;
	}

	public void setStatuId(UUID statuId) {
		this.statuId = statuId;
	}

	public ClientConsentRequestEntity getClientConsentRequestEntity() {
		return clientConsentRequestEntity;
	}

	public void setClientConsentRequestEntity(ClientConsentRequestEntity clientConsentRequestEntity) {
		this.clientConsentRequestEntity = clientConsentRequestEntity;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}
	
	public LocalDateTime getApprovalStatusEffectiveFromDate() {
		return approvalStatusEffectiveFromDate;
	}

	public void setApprovalStatusEffectiveFromDate(LocalDateTime approvalStatusEffectiveFromDate) {
		this.approvalStatusEffectiveFromDate = approvalStatusEffectiveFromDate;
	}

	public LocalDateTime getApprovalStatusEffectiveToDate() {
		return approvalStatusEffectiveToDate;
	}

	public void setApprovalStatusEffectiveToDate(LocalDateTime approvalStatusEffectiveToDate) {
		this.approvalStatusEffectiveToDate = approvalStatusEffectiveToDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
}