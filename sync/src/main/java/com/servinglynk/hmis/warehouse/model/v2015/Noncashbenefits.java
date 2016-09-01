package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Noncashbenefits extends BaseModel {
	@Column(name = "benefitsfromanysource")
	public Integer benefitsfromanysource;
	@Column(name = "othersource")
	public Integer othersource;
	@Column(name = "othersourceidentify")
	public String othersourceidentify;
	@Column(name = "othertanf")			
	public Integer othertanf;
	@Column(name = "enrollmentid")		
	public UUID enrollmentid;
	@Column(name = "id")		
	public UUID id;
	@Column(name = "rentalassistanceongoing")
	public Integer rentalassistanceongoing;
	@Column(name = "rentalassistancetemp")
	public Integer rentalassistancetemp;
	@Column(name = "snap")			
	public Integer snap;
	@Column(name = "tanfchildcare")		
	public Integer tanfchildcare;
	@Column(name = "tanftransportation")
	public Integer tanftransportation;
	@Column(name = "wic")
	public Integer wic;
	@Column(name="datacollectionstage")
	public String datacollectionstage;
	@Column(name="information_date")
	private Date information_date;
	
	/**
	 * @return the datacollectionstage
	 */
	public String getDatacollectionstage() {
		return datacollectionstage;
	}
	/**
	 * @param datacollectionstage the datacollectionstage to set
	 */
	public void setDatacollectionstage(String datacollectionstage) {
		this.datacollectionstage = datacollectionstage;
	}
	/**
	 * @return the information_date
	 */
	public Date getInformation_date() {
		return information_date;
	}
	/**
	 * @param information_date the information_date to set
	 */
	public void setInformation_date(Date information_date) {
		this.information_date = information_date;
	}
	public Integer getBenefitsfromanysource() {
		return benefitsfromanysource;
	}
	public void setBenefitsfromanysource(Integer benefitsfromanysource) {
		this.benefitsfromanysource = benefitsfromanysource;
	}
	public Integer getOthersource() {
		return othersource;
	}
	public void setOthersource(Integer othersource) {
		this.othersource = othersource;
	}
	public String getOthersourceidentify() {
		return othersourceidentify;
	}
	public void setOthersourceidentify(String othersourceidentify) {
		this.othersourceidentify = othersourceidentify;
	}
	public Integer getOthertanf() {
		return othertanf;
	}
	public void setOthertanf(Integer othertanf) {
		this.othertanf = othertanf;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Integer getRentalassistanceongoing() {
		return rentalassistanceongoing;
	}
	public void setRentalassistanceongoing(Integer rentalassistanceongoing) {
		this.rentalassistanceongoing = rentalassistanceongoing;
	}
	public Integer getRentalassistancetemp() {
		return rentalassistancetemp;
	}
	public void setRentalassistancetemp(Integer rentalassistancetemp) {
		this.rentalassistancetemp = rentalassistancetemp;
	}
	public Integer getSnap() {
		return snap;
	}
	public void setSnap(Integer snap) {
		this.snap = snap;
	}
	public Integer getTanfchildcare() {
		return tanfchildcare;
	}
	public void setTanfchildcare(Integer tanfchildcare) {
		this.tanfchildcare = tanfchildcare;
	}
	public Integer getTanftransportation() {
		return tanftransportation;
	}
	public void setTanftransportation(Integer tanftransportation) {
		this.tanftransportation = tanftransportation;
	}
	public Integer getWic() {
		return wic;
	}
	public void setWic(Integer wic) {
		this.wic = wic;
	}
	
	
}
