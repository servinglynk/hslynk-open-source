package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class EnrollmentCoc extends BaseModel {

	@Column(name = "project_co_id")
	private UUID project_co_id;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	@Column(name = "coc_code")
	private String coc_code;

	/**
	 * @return the project_co_id
	 */
	public UUID getProject_co_id() {
		return project_co_id;
	}

	/**
	 * @param project_co_id
	 *            the project_co_id to set
	 */
	public void setProject_co_id(UUID project_co_id) {
		this.project_co_id = project_co_id;
	}

	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	/**
	 * @param enrollmentid
	 *            the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	/**
	 * @return the coc_code
	 */
	public String getCoc_code() {
		return coc_code;
	}

	/**
	 * @param coc_code
	 *            the coc_code to set
	 */
	public void setCoc_code(String coc_code) {
		this.coc_code = coc_code;
	}

}
