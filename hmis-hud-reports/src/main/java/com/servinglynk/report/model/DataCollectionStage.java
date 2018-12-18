package com.servinglynk.report.model;

public enum DataCollectionStage {

	ENTRY("1","Project entry"),
	UPDATE("2","Project update"),
	EXIT("3","Project exit"),
	ANNUAL_ASSESMENT("4","Project annual assessment");
	
	private String code;
	private String description;
	
	DataCollectionStage (String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
