package com.servinglynk.hmis.warehouse.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_account_data_change")
public class AccountDataChangeEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")
	private AccountEntity account;
	
	@Column(name = "old_user_name", nullable=false)
	private String oldUsername;
	
	@Column(name = "new_user_name", nullable=false)
	private String newUsername;
	
	@ManyToOne(optional = false)
    @JoinColumn(name = "verification_id", nullable = false, referencedColumnName = "id")
	private VerificationEntity verification;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
	public String getOldUsername() {
		return oldUsername;
	}
	
	public String getNewUsername() {
		return newUsername;
	}

	public void setNewUsername(String newUsername) {
		this.newUsername = newUsername;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setOldUsername(String oldUsername) {
		this.oldUsername = oldUsername;
	}

	public VerificationEntity getVerification() {
		return verification;
	}

	public void setVerification(VerificationEntity verification) {
		this.verification = verification;
	}
}
