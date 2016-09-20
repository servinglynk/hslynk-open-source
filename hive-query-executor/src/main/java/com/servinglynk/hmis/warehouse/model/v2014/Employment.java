package com.servinglynk.hmis.warehouse.model.v2014;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;
@Entity
public class Employment extends BaseModel{
	
	@Column(name="employed")		
	public String employed;
	@Column(name="employment_type")
	public String employment_type;
	@Column(name="not_employed_reason")
	public String not_employed_reason;
	@Column(name="enrollmentid")
	public UUID enrollmentid;
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
	/**
	 * @return the employed
	 */
	public String getEmployed() {
		return employed;
	}
	/**
	 * @param employed the employed to set
	 */
	public void setEmployed(String employed) {
		this.employed = employed;
	}
	/**
	 * @return the employment_type
	 */
	public String getEmployment_type() {
		return employment_type;
	}
	/**
	 * @param employment_type the employment_type to set
	 */
	public void setEmployment_type(String employment_type) {
		this.employment_type = employment_type;
	}
	/**
	 * @return the not_employed_reason
	 */
	public String getNot_employed_reason() {
		return not_employed_reason;
	}
	/**
	 * @param not_employed_reason the not_employed_reason to set
	 */
	public void setNot_employed_reason(String not_employed_reason) {
		this.not_employed_reason = not_employed_reason;
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
	
}
