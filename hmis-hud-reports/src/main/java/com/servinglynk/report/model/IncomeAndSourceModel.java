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
	private String alimony;
	private String childsupport;
	private String earned;
	private String ga;
	private String othersource;
	private String pension;
	private String privatedisability;
	private String socsecretirement;
	private String ssdi;
	private String ssi;
	private String tanf;
	private String unemployment;
	private String vadisabilitynonservice;
	private String vadisabilityservice;
	private String workerscomp;
	
	
	
	/*" alimony, childsupport, earned, ga, othersource, pension, privatedisability, socsecretirement,ssdi, ssi, tanf, unemployment, vadisabilitynonservice, vadisabilityservice, workerscomp " +
	
	*/

	
	public IncomeAndSourceModel(String dataCollectionStage, String dedupClientId, Date informationDate, Date entryExitDate,
			Float alimonyamount, Float childsupportamount, Float earnedamount, Float gaamount, Float othersourceamount,
			Float pensionamount, Float privatedisabilityamount, Float socsecretirementamount, Float ssiamount,
			Float tanfamount, Float totalmonthlyincome, Float unemploymentamount, Float vadisabilitynonserviceamount,
			Float vadisabilityserviceamount, Float workerscompamount, String incomefromanysource,int ageAtEntry, String alimony,
			 String childsupport,
			 String earned,
			 String ga,
			 String othersource,
			 String pension,
			 String privatedisability,
			 String socsecretirement,
			 String ssdi,
			 String ssi,
			 String tanf,
			 String unemployment,
			 String vadisabilitynonservice,
			 String vadisabilityservice,
			 String workerscomp) {
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
		this.alimony = alimony;
		this.childsupport = childsupport;
		this.earned = earned;
		this.ga = ga;
		this.othersource = othersource;
		this.pension = pension;
		this.privatedisability = privatedisability;
		this.socsecretirement = socsecretirement;
		this.ssdi = ssdi;
		this.ssi = ssi;
		this.tanf = tanf;
		this.unemployment = unemployment;
		this.vadisabilitynonservice = vadisabilitynonservice;
		this.vadisabilityservice = vadisabilityservice;
		this.workerscomp = workerscomp;
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

	/**
	 * @return the alimony
	 */
	public String getAlimony() {
		return alimony;
	}

	/**
	 * @param alimony the alimony to set
	 */
	public void setAlimony(String alimony) {
		this.alimony = alimony;
	}

	/**
	 * @return the childsupport
	 */
	public String getChildsupport() {
		return childsupport;
	}

	/**
	 * @param childsupport the childsupport to set
	 */
	public void setChildsupport(String childsupport) {
		this.childsupport = childsupport;
	}

	/**
	 * @return the earned
	 */
	public String getEarned() {
		return earned;
	}

	/**
	 * @param earned the earned to set
	 */
	public void setEarned(String earned) {
		this.earned = earned;
	}

	/**
	 * @return the ga
	 */
	public String getGa() {
		return ga;
	}

	/**
	 * @param ga the ga to set
	 */
	public void setGa(String ga) {
		this.ga = ga;
	}

	/**
	 * @return the othersource
	 */
	public String getOthersource() {
		return othersource;
	}

	/**
	 * @param othersource the othersource to set
	 */
	public void setOthersource(String othersource) {
		this.othersource = othersource;
	}

	/**
	 * @return the pension
	 */
	public String getPension() {
		return pension;
	}

	/**
	 * @param pension the pension to set
	 */
	public void setPension(String pension) {
		this.pension = pension;
	}

	/**
	 * @return the privatedisability
	 */
	public String getPrivatedisability() {
		return privatedisability;
	}

	/**
	 * @param privatedisability the privatedisability to set
	 */
	public void setPrivatedisability(String privatedisability) {
		this.privatedisability = privatedisability;
	}

	/**
	 * @return the socsecretirement
	 */
	public String getSocsecretirement() {
		return socsecretirement;
	}

	/**
	 * @param socsecretirement the socsecretirement to set
	 */
	public void setSocsecretirement(String socsecretirement) {
		this.socsecretirement = socsecretirement;
	}

	/**
	 * @return the ssdi
	 */
	public String getSsdi() {
		return ssdi;
	}

	/**
	 * @param ssdi the ssdi to set
	 */
	public void setSsdi(String ssdi) {
		this.ssdi = ssdi;
	}

	/**
	 * @return the ssi
	 */
	public String getSsi() {
		return ssi;
	}

	/**
	 * @param ssi the ssi to set
	 */
	public void setSsi(String ssi) {
		this.ssi = ssi;
	}

	/**
	 * @return the tanf
	 */
	public String getTanf() {
		return tanf;
	}

	/**
	 * @param tanf the tanf to set
	 */
	public void setTanf(String tanf) {
		this.tanf = tanf;
	}

	/**
	 * @return the unemployment
	 */
	public String getUnemployment() {
		return unemployment;
	}

	/**
	 * @param unemployment the unemployment to set
	 */
	public void setUnemployment(String unemployment) {
		this.unemployment = unemployment;
	}

	/**
	 * @return the vadisabilitynonservice
	 */
	public String getVadisabilitynonservice() {
		return vadisabilitynonservice;
	}

	/**
	 * @param vadisabilitynonservice the vadisabilitynonservice to set
	 */
	public void setVadisabilitynonservice(String vadisabilitynonservice) {
		this.vadisabilitynonservice = vadisabilitynonservice;
	}

	/**
	 * @return the vadisabilityservice
	 */
	public String getVadisabilityservice() {
		return vadisabilityservice;
	}

	/**
	 * @param vadisabilityservice the vadisabilityservice to set
	 */
	public void setVadisabilityservice(String vadisabilityservice) {
		this.vadisabilityservice = vadisabilityservice;
	}

	/**
	 * @return the workerscomp
	 */
	public String getWorkerscomp() {
		return workerscomp;
	}

	/**
	 * @param workerscomp the workerscomp to set
	 */
	public void setWorkerscomp(String workerscomp) {
		this.workerscomp = workerscomp;
	}
	
	
}
