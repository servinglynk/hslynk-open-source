package com.servinglynk.report.model;

import java.sql.Date;

public class IncomeAndSourceModel extends BaseModel {
	
	private String dataCollectionStage;
	private String dedupClientId;
	private Date informationDate;
	private Float alimonyamount;
	private Float childsupportamount;
	private Float earnedamount;
	private Float gaamount;
	private Float othersourceamount;
	private Float pensionamount;
	private Float privatedisabilityamount;
	private Float socsecretirementamount;
	private Float ssiamount;
	private Float tanfamount;
	private Float totalmonthlyincome;
	private Float unemploymentamount;
	private Float vadisabilitynonserviceamount;
	private Float vadisabilityserviceamount;
	private Float workerscompamount;
	private String incomefromanysource;
	private Date entryExitDate;
	private int ageAtEntry;
	
	public IncomeAndSourceModel(String dataCollectionStage, String dedupClientId, Date informationDate, Date entryExitDate,
			Float alimonyamount, Float childsupportamount, Float earnedamount, Float gaamount, Float othersourceamount,
			Float pensionamount, Float privatedisabilityamount, Float socsecretirementamount, Float ssiamount,
			Float tanfamount, Float totalmonthlyincome, Float unemploymentamount, Float vadisabilitynonserviceamount,
			Float vadisabilityserviceamount, Float workerscompamount, String incomefromanysource,int ageAtEntry) {
		super();
		this.dataCollectionStage = dataCollectionStage;
		this.dedupClientId = dedupClientId;
		this.informationDate = informationDate;
		this.alimonyamount = alimonyamount;
		this.childsupportamount = childsupportamount;
		this.earnedamount = earnedamount;
		this.gaamount = gaamount;
		this.othersourceamount = othersourceamount;
		this.pensionamount = pensionamount;
		this.privatedisabilityamount = privatedisabilityamount;
		this.socsecretirementamount = socsecretirementamount;
		this.ssiamount = ssiamount;
		this.tanfamount = tanfamount;
		this.totalmonthlyincome = totalmonthlyincome;
		this.unemploymentamount = unemploymentamount;
		this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
		this.vadisabilityserviceamount = vadisabilityserviceamount;
		this.workerscompamount = workerscompamount;
		this.incomefromanysource = incomefromanysource;
		this.entryExitDate = entryExitDate;
		this.ageAtEntry = ageAtEntry;
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
	 * @return the informationDate
	 */
	public Date getInformationDate() {
		return informationDate;
	}

	/**
	 * @param informationDate the informationDate to set
	 */
	public void setInformationDate(Date informationDate) {
		this.informationDate = informationDate;
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
	 * @return the alimonyamount
	 */
	public Float getAlimonyamount() {
		return alimonyamount;
	}

	/**
	 * @param alimonyamount the alimonyamount to set
	 */
	public void setAlimonyamount(Float alimonyamount) {
		this.alimonyamount = alimonyamount;
	}

	/**
	 * @return the childsupportamount
	 */
	public Float getChildsupportamount() {
		return childsupportamount;
	}

	/**
	 * @param childsupportamount the childsupportamount to set
	 */
	public void setChildsupportamount(Float childsupportamount) {
		this.childsupportamount = childsupportamount;
	}

	/**
	 * @return the earnedamount
	 */
	public Float getEarnedamount() {
		return earnedamount;
	}

	/**
	 * @param earnedamount the earnedamount to set
	 */
	public void setEarnedamount(Float earnedamount) {
		this.earnedamount = earnedamount;
	}

	/**
	 * @return the gaamount
	 */
	public Float getGaamount() {
		return gaamount;
	}

	/**
	 * @param gaamount the gaamount to set
	 */
	public void setGaamount(Float gaamount) {
		this.gaamount = gaamount;
	}

	/**
	 * @return the othersourceamount
	 */
	public Float getOthersourceamount() {
		return othersourceamount;
	}

	/**
	 * @param othersourceamount the othersourceamount to set
	 */
	public void setOthersourceamount(Float othersourceamount) {
		this.othersourceamount = othersourceamount;
	}

	/**
	 * @return the pensionamount
	 */
	public Float getPensionamount() {
		return pensionamount;
	}

	/**
	 * @param pensionamount the pensionamount to set
	 */
	public void setPensionamount(Float pensionamount) {
		this.pensionamount = pensionamount;
	}

	/**
	 * @return the privatedisabilityamount
	 */
	public Float getPrivatedisabilityamount() {
		return privatedisabilityamount;
	}

	/**
	 * @param privatedisabilityamount the privatedisabilityamount to set
	 */
	public void setPrivatedisabilityamount(Float privatedisabilityamount) {
		this.privatedisabilityamount = privatedisabilityamount;
	}

	/**
	 * @return the socsecretirementamount
	 */
	public Float getSocsecretirementamount() {
		return socsecretirementamount;
	}

	/**
	 * @param socsecretirementamount the socsecretirementamount to set
	 */
	public void setSocsecretirementamount(Float socsecretirementamount) {
		this.socsecretirementamount = socsecretirementamount;
	}

	/**
	 * @return the ssiamount
	 */
	public Float getSsiamount() {
		return ssiamount;
	}

	/**
	 * @param ssiamount the ssiamount to set
	 */
	public void setSsiamount(Float ssiamount) {
		this.ssiamount = ssiamount;
	}

	/**
	 * @return the tanfamount
	 */
	public Float getTanfamount() {
		return tanfamount;
	}

	/**
	 * @param tanfamount the tanfamount to set
	 */
	public void setTanfamount(Float tanfamount) {
		this.tanfamount = tanfamount;
	}

	/**
	 * @return the totalmonthlyincome
	 */
	public Float getTotalmonthlyincome() {
		return totalmonthlyincome;
	}

	/**
	 * @param totalmonthlyincome the totalmonthlyincome to set
	 */
	public void setTotalmonthlyincome(Float totalmonthlyincome) {
		this.totalmonthlyincome = totalmonthlyincome;
	}

	/**
	 * @return the unemploymentamount
	 */
	public Float getUnemploymentamount() {
		return unemploymentamount;
	}

	/**
	 * @param unemploymentamount the unemploymentamount to set
	 */
	public void setUnemploymentamount(Float unemploymentamount) {
		this.unemploymentamount = unemploymentamount;
	}

	/**
	 * @return the vadisabilitynonserviceamount
	 */
	public Float getVadisabilitynonserviceamount() {
		return vadisabilitynonserviceamount;
	}

	/**
	 * @param vadisabilitynonserviceamount the vadisabilitynonserviceamount to set
	 */
	public void setVadisabilitynonserviceamount(Float vadisabilitynonserviceamount) {
		this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
	}

	/**
	 * @return the vadisabilityserviceamount
	 */
	public Float getVadisabilityserviceamount() {
		return vadisabilityserviceamount;
	}

	/**
	 * @param vadisabilityserviceamount the vadisabilityserviceamount to set
	 */
	public void setVadisabilityserviceamount(Float vadisabilityserviceamount) {
		this.vadisabilityserviceamount = vadisabilityserviceamount;
	}

	/**
	 * @return the workerscompamount
	 */
	public Float getWorkerscompamount() {
		return workerscompamount;
	}

	/**
	 * @param workerscompamount the workerscompamount to set
	 */
	public void setWorkerscompamount(Float workerscompamount) {
		this.workerscompamount = workerscompamount;
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

	/**
	 * @return the entryExitDate
	 */
	public Date getEntryExitDate() {
		return entryExitDate;
	}

	/**
	 * @param entryExitDate the entryExitDate to set
	 */
	public void setEntryExitDate(Date entryExitDate) {
		this.entryExitDate = entryExitDate;
	}

	/**
	 * @return the ageAtEntry
	 */
	public int getAgeAtEntry() {
		return ageAtEntry;
	}

	/**
	 * @param ageAtEntry the ageAtEntry to set
	 */
	public void setAgeAtEntry(int ageAtEntry) {
		this.ageAtEntry = ageAtEntry;
	}
}
