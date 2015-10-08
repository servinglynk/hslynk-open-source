package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Housingassessmentdisposition extends BaseModel {

	@Column(name = "assessmentdisposition")
	private String assessmentdisposition;
	@Column(name = "exitid")
	private UUID exitid;
	@Column(name = "otherdisposition")
	private String otherdisposition;

	/**
	 * @return the assessmentdisposition
	 */
	public String getAssessmentdisposition() {
		return assessmentdisposition;
	}

	/**
	 * @param assessmentdisposition
	 *            the assessmentdisposition to set
	 */
	public void setAssessmentdisposition(String assessmentdisposition) {
		this.assessmentdisposition = assessmentdisposition;
	}

	/**
	 * @return the exitid
	 */
	public UUID getExitid() {
		return exitid;
	}

	/**
	 * @param exitid
	 *            the exitid to set
	 */
	public void setExitid(UUID exitid) {
		this.exitid = exitid;
	}

	/**
	 * @return the otherdisposition
	 */
	public String getOtherdisposition() {
		return otherdisposition;
	}

	/**
	 * @param otherdisposition
	 *            the otherdisposition to set
	 */
	public void setOtherdisposition(String otherdisposition) {
		this.otherdisposition = otherdisposition;
	}

}
