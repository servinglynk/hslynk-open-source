package com.servinglynk.report.model;

import java.math.BigInteger;

public class IncomeSourceModel extends BaseModel {
	private BigInteger  incomeAmount;
	private BigInteger  earnedIncome;
	private String dedupClientId;
	private BigInteger otherIncome;
	private String incomefromanysource;
	private String dataCollectionStage;
	public IncomeSourceModel(BigInteger incomeAmount, BigInteger earnedIncome,BigInteger otherIncome, String dedupClientId,String incomefromanysource) {
		super();
		this.incomeAmount = incomeAmount;
		this.earnedIncome = earnedIncome;
		this.otherIncome = otherIncome;
		this.dedupClientId = dedupClientId;
		this.incomefromanysource = incomefromanysource;
	}
	/**
	 * @return the dataCollectionStage
	 */
	public String getDataCollectionStage() {
		return dataCollectionStage;
	}

	/**
	 * @param dataCollectionStage the dataCollectionStage to set
	 */
	public void setDataCollectionStage(String dataCollectionStage) {
		this.dataCollectionStage = dataCollectionStage;
	}

	/**
	 * @return the incomeAmount
	 */
	public BigInteger getIncomeAmount() {
		return incomeAmount;
	}
	/**
	 * @param incomeAmount the incomeAmount to set
	 */
	public void setIncomeAmount(BigInteger incomeAmount) {
		this.incomeAmount = incomeAmount;
	}
	/**
	 * @return the earnedIncome
	 */
	public BigInteger getEarnedIncome() {
		return earnedIncome;
	}
	/**
	 * @param earnedIncome the earnedIncome to set
	 */
	public void setEarnedIncome(BigInteger earnedIncome) {
		this.earnedIncome = earnedIncome;
	}
	/**
	 * @return the dedupClientId
	 */
	public String getDedupClientId() {
		return dedupClientId;
	}
	/**
	 * @param dedupClientId the dedupClientId to set
	 */
	public void setDedupClientId(String dedupClientId) {
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the otherIncome
	 */
	public BigInteger getOtherIncome() {
		return otherIncome;
	}
	/**
	 * @param otherIncome the otherIncome to set
	 */
	public void setOtherIncome(BigInteger otherIncome) {
		this.otherIncome = otherIncome;
	}
	/**
	 * @return the incomefromanysource
	 */
	public String getIncomefromanysource() {
		return incomefromanysource;
	}
	/**
	 * @param incomefromanysource the incomefromanysource to set
	 */
	public void setIncomefromanysource(String incomefromanysource) {
		this.incomefromanysource = incomefromanysource;
	}
	
}
