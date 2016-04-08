package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Noncashbenefits extends BaseModel {
	@Column(name = "benefitsfromanysource")
	public String benefitsfromanysource;
	@Column(name = "othersource")
	public String othersource;
	@Column(name = "othersourceidentify")
	public String othersourceidentify;
	@Column(name = "othertanf")			
	public String othertanf;
	@Column(name = "enrollmentid")		
	public UUID enrollmentid;
	@Column(name = "rentalassistanceongoing")
	public String rentalassistanceongoing;
	@Column(name = "rentalassistancetemp")
	public String rentalassistancetemp;
	@Column(name = "snap")			
	public String snap;
	@Column(name = "tanfchildcare")		
	public String tanfchildcare;
	@Column(name = "tanftransportation")
	public String tanftransportation;
	@Column(name = "wic")
	public String wic;
	/**
	 * @return the benefitsfromanysource
	 */
	public String getBenefitsfromanysource() {
		return benefitsfromanysource;
	}
	/**
	 * @param benefitsfromanysource the benefitsfromanysource to set
	 */
	public void setBenefitsfromanysource(String benefitsfromanysource) {
		this.benefitsfromanysource = benefitsfromanysource;
	}
	/**
	 * @return the othersource
	 */
	public String getOthersource() {
		return othersource;
	}
	/**
	 * @param othersource the othersource to set
	 */
	public void setOthersource(String othersource) {
		this.othersource = othersource;
	}
	/**
	 * @return the othersourceidentify
	 */
	public String getOthersourceidentify() {
		return othersourceidentify;
	}
	/**
	 * @param othersourceidentify the othersourceidentify to set
	 */
	public void setOthersourceidentify(String othersourceidentify) {
		this.othersourceidentify = othersourceidentify;
	}
	/**
	 * @return the othertanf
	 */
	public String getOthertanf() {
		return othertanf;
	}
	/**
	 * @param othertanf the othertanf to set
	 */
	public void setOthertanf(String othertanf) {
		this.othertanf = othertanf;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the rentalassistanceongoing
	 */
	public String getRentalassistanceongoing() {
		return rentalassistanceongoing;
	}
	/**
	 * @param rentalassistanceongoing the rentalassistanceongoing to set
	 */
	public void setRentalassistanceongoing(String rentalassistanceongoing) {
		this.rentalassistanceongoing = rentalassistanceongoing;
	}
	/**
	 * @return the rentalassistancetemp
	 */
	public String getRentalassistancetemp() {
		return rentalassistancetemp;
	}
	/**
	 * @param rentalassistancetemp the rentalassistancetemp to set
	 */
	public void setRentalassistancetemp(String rentalassistancetemp) {
		this.rentalassistancetemp = rentalassistancetemp;
	}
	/**
	 * @return the snap
	 */
	public String getSnap() {
		return snap;
	}
	/**
	 * @param snap the snap to set
	 */
	public void setSnap(String snap) {
		this.snap = snap;
	}
	/**
	 * @return the tanfchildcare
	 */
	public String getTanfchildcare() {
		return tanfchildcare;
	}
	/**
	 * @param tanfchildcare the tanfchildcare to set
	 */
	public void setTanfchildcare(String tanfchildcare) {
		this.tanfchildcare = tanfchildcare;
	}
	/**
	 * @return the tanftransportation
	 */
	public String getTanftransportation() {
		return tanftransportation;
	}
	/**
	 * @param tanftransportation the tanftransportation to set
	 */
	public void setTanftransportation(String tanftransportation) {
		this.tanftransportation = tanftransportation;
	}
	/**
	 * @return the wic
	 */
	public String getWic() {
		return wic;
	}
	/**
	 * @param wic the wic to set
	 */
	public void setWic(String wic) {
		this.wic = wic;
	}
	
	

}
