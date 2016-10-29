	package com.servinglynk.hmis.warehouse.model.v2016;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class ServiceFaReferral extends BaseModel{


	@Column(name = "enrollmentid")
	private Enrollment enrollmentid;

	@Column( name = "fa_amount")
	private java.math.BigDecimal fa_amount;

	@Column( name = "funder_list")
	private Integer funder_list;

	@Column( name = "id")
	private java.util.UUID id;

	@Column( name = "other_type_provided")
	private String other_type_provided;

	@Column( name = "referral_outcome")
	private Integer referral_outcome;

	@Column( name = "service_category")
	private Integer service_category;
	
	@Column( name = "sub_type_provided")
	private Integer sub_type_provided;
	
	@Column( name = "type_provided")
	private Integer type_provided;
	
	@Column( name = "dateProvided")
	private LocalDateTime dateprovided;

	public Enrollment getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public java.math.BigDecimal getFa_amount() {
		return fa_amount;
	}

	public void setFa_amount(java.math.BigDecimal fa_amount) {
		this.fa_amount = fa_amount;
	}

	public Integer getFunder_list() {
		return funder_list;
	}

	public void setFunder_list(Integer funder_list) {
		this.funder_list = funder_list;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public String getOther_type_provided() {
		return other_type_provided;
	}

	public void setOther_type_provided(String other_type_provided) {
		this.other_type_provided = other_type_provided;
	}

	public Integer getReferral_outcome() {
		return referral_outcome;
	}

	public void setReferral_outcome(Integer referral_outcome) {
		this.referral_outcome = referral_outcome;
	}

	public Integer getService_category() {
		return service_category;
	}

	public void setService_category(Integer service_category) {
		this.service_category = service_category;
	}

	public Integer getSub_type_provided() {
		return sub_type_provided;
	}

	public void setSub_type_provided(Integer sub_type_provided) {
		this.sub_type_provided = sub_type_provided;
	}

	public Integer getType_provided() {
		return type_provided;
	}

	public void setType_provided(Integer type_provided) {
		this.type_provided = type_provided;
	}

	public LocalDateTime getDateprovided() {
		return dateprovided;
	}

	public void setDateprovided(LocalDateTime dateprovided) {
		this.dateprovided = dateprovided;
	}

		
	
}
