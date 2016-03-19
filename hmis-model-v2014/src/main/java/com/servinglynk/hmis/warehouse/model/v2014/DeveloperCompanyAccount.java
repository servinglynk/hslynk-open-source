package com.servinglynk.hmis.warehouse.model.v2014;

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
@Table(name = "hmis_developer_company_account",schema = "stagv2014")
public class DeveloperCompanyAccount extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "developer_company_id", nullable=false, referencedColumnName="id")
	private DeveloperCompanyEntity developerCompany;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false, referencedColumnName="id")
	private HmisUser account;

	@Column(name = "role", nullable=false)
	private String role;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public DeveloperCompanyEntity getDeveloperCompany() {
		return developerCompany;
	}
	public void setDeveloperCompany(DeveloperCompanyEntity developerCompany) {
		this.developerCompany = developerCompany;
	}
	public HmisUser getAccount() {
		return account;
	}
	public void setAccount(HmisUser account) {
		this.account = account;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

}
