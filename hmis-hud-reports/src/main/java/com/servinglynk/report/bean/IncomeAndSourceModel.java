package com.servinglynk.report.bean;

public class IncomeAndSourceModel {
	
	private String dataCollectionStage;

	/**
	 * @return the dataCollectionStage
	 */
	public String getDataCollectionStage() {
		return dataCollectionStage;
	}

	public IncomeAndSourceModel(String dataCollectionStage) {
		super();
		this.dataCollectionStage = dataCollectionStage;
	}

	/**
	 * @param dataCollectionStage the dataCollectionStage to set
	 */
	public void setDataCollectionStage(String dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}
	

}
