package com.servinglynk.report.model;

public class IncomeAndSourceModel {
	
	private String dataCollectionStage;
	private String projectEntryId;

	/**
	 * @return the dataCollectionStage
	 */
	public String getDataCollectionStage() {
		return dataCollectionStage;
	}

	public IncomeAndSourceModel(String dataCollectionStage, String projectEntryId) {
		super();
		this.dataCollectionStage = dataCollectionStage;
		this.projectEntryId = projectEntryId;
	}

	/**
	 * @param dataCollectionStage the dataCollectionStage to set
	 */
	public void setDataCollectionStage(String dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}

	/**
	 * @return the projectEntryId
	 */
	public String getProjectEntryId() {
		return projectEntryId;
	}

	/**
	 * @param projectEntryId the projectEntryId to set
	 */
	public void setProjectEntryId(String projectEntryId) {
		this.projectEntryId = projectEntryId;
	}

}
