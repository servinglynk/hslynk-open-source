package com.servinglynk.report.model;

public class CurrentLivingSituationModel extends BaseModel {

	private String enrollmentId;
	private String livingsituation;
	
	public CurrentLivingSituationModel(String enrollmentId, String livingsituation) {
		super();
		this.enrollmentId = enrollmentId;
		this.livingsituation = livingsituation;
	}

	/**
	 * @return the enrollmentId
	 */
	public String getEnrollmentId() {
		return enrollmentId;
	}

	/**
	 * @param enrollmentId the enrollmentId to set
	 */
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	/**
	 * @return the livingsituation
	 */
	public String getLivingsituation() {
		return livingsituation;
	}

	/**
	 * @param livingsituation the livingsituation to set
	 */
	public void setLivingsituation(String livingsituation) {
		this.livingsituation = livingsituation;
	}
}
