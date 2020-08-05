package com.servinglynk.report.model;

public enum HouseHoldType {


	AO("AO","Adult Only, Without Children"),
	AC("AC","With Children and Adults"),
	CO("AC","Children Only"),
	UK("UK","Unknown household type ");
	
	private String code;
	private String description;
	
	HouseHoldType (String code, String description) {
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
