	package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.joda.time.LocalDateTime;


@Entity
public class ServiceFaReferral extends BaseModel{


	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;

	@Column( name = "fa_amount")
	private java.math.BigDecimal faAmount;

	@Column( name = "funder_list")
	private Integer funderList;

	@Column( name = "id")
	private java.util.UUID id;

	@Column( name = "other_type_provided")
	private String otherTypeProvided;

	@Column( name = "referral_outcome")
	private Integer referralOutcome;

	@Column( name = "service_category")
	private Integer serviceCategory;
	
	@Column( name = "sub_type_provided")
	private Integer subTypeProvided;
	
	@Column( name = "type_provided")
	private Integer typeProvided;
	
	@Column( name = "dateProvided")
	private Timestamp dateprovided;

	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public java.math.BigDecimal getFaAmount() {
		return faAmount;
	}

	public void setFaAmount(java.math.BigDecimal faAmount) {
		this.faAmount = faAmount;
	}

	public Integer getFunderList() {
		return funderList;
	}

	public void setFunderList(Integer funderList) {
		this.funderList = funderList;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public String getOtherTypeProvided() {
		return otherTypeProvided;
	}

	public void setOtherTypeProvided(String otherTypeProvided) {
		this.otherTypeProvided = otherTypeProvided;
	}

	public Integer getReferralOutcome() {
		return referralOutcome;
	}

	public void setReferralOutcome(Integer referralOutcome) {
		this.referralOutcome = referralOutcome;
	}

	public Integer getServiceCategory() {
		return serviceCategory;
	}

	public void setServiceCategory(Integer serviceCategory) {
		this.serviceCategory = serviceCategory;
	}

	public Integer getSubTypeProvided() {
		return subTypeProvided;
	}

	public void setSubTypeProvided(Integer subTypeProvided) {
		this.subTypeProvided = subTypeProvided;
	}

	public Integer getTypeProvided() {
		return typeProvided;
	}

	public void setTypeProvided(Integer typeProvided) {
		this.typeProvided = typeProvided;
	}

	public Timestamp getDateprovided() {
		return dateprovided;
	}

	public void setDateprovided(Timestamp dateprovided) {
		this.dateprovided = dateprovided;
	}
	
	
}
