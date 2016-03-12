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
@Table(name = "hmis_developer_company_status" )
public class DeveloperCompanyStatus extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@Column(name = "status")
	private String status;
	
	@Column(name = "comments")
	private String comments;


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public DeveloperCompanyEntity getDeveloperCompany() {
		return developerCompany;
	}


	public void setDeveloperCompany(DeveloperCompanyEntity developerCompany) {
		this.developerCompany = developerCompany;
	}


	@ManyToOne
	@JoinColumn(name = "developer_company_id", nullable=false, referencedColumnName="id")
	private DeveloperCompanyEntity developerCompany;


}
