package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Noncashbenefits extends BaseModel {
	@Column(name = "benefitsfromanysource")
	private String benefitsfromanysource;
	@Column(name = "othersource")
	private String othersource;
	@Column(name = "othersourceidentify")
	private String othersourceidentify;
	@Column(name = "othertanf")			
	private String othertanf;
	@Column(name = "enrollmentid")		
	private UUID enrollmentid;
	@Column(name = "rentalassistanceongoing")
	private String rentalassistanceongoing;
	@Column(name = "rentalassistancetemp")
	private String rentalassistancetemp;
	@Column(name = "snap")			
	private String snap;
	@Column(name = "tanfchildcare")		
	private String tanfchildcare;
	@Column(name = "tanftransportation")
	private String tanftransportation;
	@Column(name = "wic")
	private String wic;
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
