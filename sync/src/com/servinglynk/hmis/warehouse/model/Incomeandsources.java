package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Incomeandsources extends BaseModel {

	@Column(name = "alimony")
	private String alimony;
	@Column(name = "alimonyamount")
	private String alimonyamount;
	@Column(name = "childsupport")
	private String childsupport;
	@Column(name = "childsupportamount")
	private String childsupportamount;
	@Column(name = "earned")
	private String earned;
	@Column(name = "earnedamount")
	private String earnedamount;
	@Column(name = "ga")
	private String ga;
	@Column(name = "gaamount")
	private String gaamount;
	@Column(name = "incomefromanysource")
	private String incomefromanysource;
	@Column(name = "othersource")
	private String othersource;
	@Column(name = "othersourceamount")
	private String othersourceamount;
	@Column(name = "othersourceidentify")
	private String othersourceidentify;
	@Column(name = "pension")
	private String pension;
	@Column(name = "pensionamount")
	private String pensionamount;
	@Column(name = "privatedisability")
	private String privatedisability;
	@Column(name = "privatedisabilityamount")
	private String privatedisabilityamount;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	@Column(name = "socsecretirement")
	private String socsecretirement;
	@Column(name = "socsecretirementamount")
	private String socsecretirementamount;
	@Column(name = "ssdi")
	private String ssdi;
	@Column(name = "ssdiamount")
	private String ssdiamount;
	@Column(name = "ssi")
	private String ssi;
	@Column(name = "ssiamount")
	private String ssiamount;
	@Column(name = "tanf")
	private String tanf;
	@Column(name = "tanfamount")
	private String tanfamount;
	@Column(name = "totalmonthlyincome")
	private String totalmonthlyincome;
	@Column(name = "unemployment")
	private String unemployment;
	@Column(name = "unemploymentamount")
	private String unemploymentamount;
	@Column(name = "vadisabilitynonservice")
	private String vadisabilitynonservice;
	@Column(name = "vadisabilitynonserviceamount")
	private String vadisabilitynonserviceamount;
	@Column(name = "vadisabilityservice")
	private String vadisabilityservice;
	@Column(name = "vadisabilityserviceamount")
	private String vadisabilityserviceamount;
	@Column(name = "workerscomp")
	private String workerscomp;
	@Column(name = "workerscompamount")
	private String workerscompamount;

	/**
	 * @return the alimony
	 */
	public String getAlimony() {
		return alimony;
	}

	/**
	 * @param alimony
	 *            the alimony to set
	 */
	public void setAlimony(String alimony) {
		this.alimony = alimony;
	}

	/**
	 * @return the alimonyamount
	 */
	public String getAlimonyamount() {
		return alimonyamount;
	}

	/**
	 * @param alimonyamount
	 *            the alimonyamount to set
	 */
	public void setAlimonyamount(String alimonyamount) {
		this.alimonyamount = alimonyamount;
	}

	/**
	 * @return the childsupport
	 */
	public String getChildsupport() {
		return childsupport;
	}

	/**
	 * @param childsupport
	 *            the childsupport to set
	 */
	public void setChildsupport(String childsupport) {
		this.childsupport = childsupport;
	}

	/**
	 * @return the childsupportamount
	 */
	public String getChildsupportamount() {
		return childsupportamount;
	}

	/**
	 * @param childsupportamount
	 *            the childsupportamount to set
	 */
	public void setChildsupportamount(String childsupportamount) {
		this.childsupportamount = childsupportamount;
	}

	/**
	 * @return the earned
	 */
	public String getEarned() {
		return earned;
	}

	/**
	 * @param earned
	 *            the earned to set
	 */
	public void setEarned(String earned) {
		this.earned = earned;
	}

	/**
	 * @return the earnedamount
	 */
	public String getEarnedamount() {
		return earnedamount;
	}

	/**
	 * @param earnedamount
	 *            the earnedamount to set
	 */
	public void setEarnedamount(String earnedamount) {
		this.earnedamount = earnedamount;
	}

	/**
	 * @return the ga
	 */
	public String getGa() {
		return ga;
	}

	/**
	 * @param ga
	 *            the ga to set
	 */
	public void setGa(String ga) {
		this.ga = ga;
	}

	/**
	 * @return the gaamount
	 */
	public String getGaamount() {
		return gaamount;
	}

	/**
	 * @param gaamount
	 *            the gaamount to set
	 */
	public void setGaamount(String gaamount) {
		this.gaamount = gaamount;
	}

	/**
	 * @return the incomefromanysource
	 */
	public String getIncomefromanysource() {
		return incomefromanysource;
	}

	/**
	 * @param incomefromanysource
	 *            the incomefromanysource to set
	 */
	public void setIncomefromanysource(String incomefromanysource) {
		this.incomefromanysource = incomefromanysource;
	}

	/**
	 * @return the othersource
	 */
	public String getOthersource() {
		return othersource;
	}

	/**
	 * @param othersource
	 *            the othersource to set
	 */
	public void setOthersource(String othersource) {
		this.othersource = othersource;
	}

	/**
	 * @return the othersourceamount
	 */
	public String getOthersourceamount() {
		return othersourceamount;
	}

	/**
	 * @param othersourceamount
	 *            the othersourceamount to set
	 */
	public void setOthersourceamount(String othersourceamount) {
		this.othersourceamount = othersourceamount;
	}

	/**
	 * @return the othersourceidentify
	 */
	public String getOthersourceidentify() {
		return othersourceidentify;
	}

	/**
	 * @param othersourceidentify
	 *            the othersourceidentify to set
	 */
	public void setOthersourceidentify(String othersourceidentify) {
		this.othersourceidentify = othersourceidentify;
	}

	/**
	 * @return the pension
	 */
	public String getPension() {
		return pension;
	}

	/**
	 * @param pension
	 *            the pension to set
	 */
	public void setPension(String pension) {
		this.pension = pension;
	}

	/**
	 * @return the pensionamount
	 */
	public String getPensionamount() {
		return pensionamount;
	}

	/**
	 * @param pensionamount
	 *            the pensionamount to set
	 */
	public void setPensionamount(String pensionamount) {
		this.pensionamount = pensionamount;
	}

	/**
	 * @return the privatedisability
	 */
	public String getPrivatedisability() {
		return privatedisability;
	}

	/**
	 * @param privatedisability
	 *            the privatedisability to set
	 */
	public void setPrivatedisability(String privatedisability) {
		this.privatedisability = privatedisability;
	}

	/**
	 * @return the privatedisabilityamount
	 */
	public String getPrivatedisabilityamount() {
		return privatedisabilityamount;
	}

	/**
	 * @param privatedisabilityamount
	 *            the privatedisabilityamount to set
	 */
	public void setPrivatedisabilityamount(String privatedisabilityamount) {
		this.privatedisabilityamount = privatedisabilityamount;
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
	 * @return the socsecretirement
	 */
	public String getSocsecretirement() {
		return socsecretirement;
	}

	/**
	 * @param socsecretirement
	 *            the socsecretirement to set
	 */
	public void setSocsecretirement(String socsecretirement) {
		this.socsecretirement = socsecretirement;
	}

	/**
	 * @return the socsecretirementamount
	 */
	public String getSocsecretirementamount() {
		return socsecretirementamount;
	}

	/**
	 * @param socsecretirementamount
	 *            the socsecretirementamount to set
	 */
	public void setSocsecretirementamount(String socsecretirementamount) {
		this.socsecretirementamount = socsecretirementamount;
	}

	/**
	 * @return the ssdi
	 */
	public String getSsdi() {
		return ssdi;
	}

	/**
	 * @param ssdi
	 *            the ssdi to set
	 */
	public void setSsdi(String ssdi) {
		this.ssdi = ssdi;
	}

	/**
	 * @return the ssdiamount
	 */
	public String getSsdiamount() {
		return ssdiamount;
	}

	/**
	 * @param ssdiamount
	 *            the ssdiamount to set
	 */
	public void setSsdiamount(String ssdiamount) {
		this.ssdiamount = ssdiamount;
	}

	/**
	 * @return the ssi
	 */
	public String getSsi() {
		return ssi;
	}

	/**
	 * @param ssi
	 *            the ssi to set
	 */
	public void setSsi(String ssi) {
		this.ssi = ssi;
	}

	/**
	 * @return the ssiamount
	 */
	public String getSsiamount() {
		return ssiamount;
	}

	/**
	 * @param ssiamount
	 *            the ssiamount to set
	 */
	public void setSsiamount(String ssiamount) {
		this.ssiamount = ssiamount;
	}

	/**
	 * @return the tanf
	 */
	public String getTanf() {
		return tanf;
	}

	/**
	 * @param tanf
	 *            the tanf to set
	 */
	public void setTanf(String tanf) {
		this.tanf = tanf;
	}

	/**
	 * @return the tanfamount
	 */
	public String getTanfamount() {
		return tanfamount;
	}

	/**
	 * @param tanfamount
	 *            the tanfamount to set
	 */
	public void setTanfamount(String tanfamount) {
		this.tanfamount = tanfamount;
	}

	/**
	 * @return the totalmonthlyincome
	 */
	public String getTotalmonthlyincome() {
		return totalmonthlyincome;
	}

	/**
	 * @param totalmonthlyincome
	 *            the totalmonthlyincome to set
	 */
	public void setTotalmonthlyincome(String totalmonthlyincome) {
		this.totalmonthlyincome = totalmonthlyincome;
	}

	/**
	 * @return the unemployment
	 */
	public String getUnemployment() {
		return unemployment;
	}

	/**
	 * @param unemployment
	 *            the unemployment to set
	 */
	public void setUnemployment(String unemployment) {
		this.unemployment = unemployment;
	}

	/**
	 * @return the unemploymentamount
	 */
	public String getUnemploymentamount() {
		return unemploymentamount;
	}

	/**
	 * @param unemploymentamount
	 *            the unemploymentamount to set
	 */
	public void setUnemploymentamount(String unemploymentamount) {
		this.unemploymentamount = unemploymentamount;
	}

	/**
	 * @return the vadisabilitynonservice
	 */
	public String getVadisabilitynonservice() {
		return vadisabilitynonservice;
	}

	/**
	 * @param vadisabilitynonservice
	 *            the vadisabilitynonservice to set
	 */
	public void setVadisabilitynonservice(String vadisabilitynonservice) {
		this.vadisabilitynonservice = vadisabilitynonservice;
	}

	/**
	 * @return the vadisabilitynonserviceamount
	 */
	public String getVadisabilitynonserviceamount() {
		return vadisabilitynonserviceamount;
	}

	/**
	 * @param vadisabilitynonserviceamount
	 *            the vadisabilitynonserviceamount to set
	 */
	public void setVadisabilitynonserviceamount(
			String vadisabilitynonserviceamount) {
		this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
	}

	/**
	 * @return the vadisabilityservice
	 */
	public String getVadisabilityservice() {
		return vadisabilityservice;
	}

	/**
	 * @param vadisabilityservice
	 *            the vadisabilityservice to set
	 */
	public void setVadisabilityservice(String vadisabilityservice) {
		this.vadisabilityservice = vadisabilityservice;
	}

	/**
	 * @return the vadisabilityserviceamount
	 */
	public String getVadisabilityserviceamount() {
		return vadisabilityserviceamount;
	}

	/**
	 * @param vadisabilityserviceamount
	 *            the vadisabilityserviceamount to set
	 */
	public void setVadisabilityserviceamount(String vadisabilityserviceamount) {
		this.vadisabilityserviceamount = vadisabilityserviceamount;
	}

	/**
	 * @return the workerscomp
	 */
	public String getWorkerscomp() {
		return workerscomp;
	}

	/**
	 * @param workerscomp
	 *            the workerscomp to set
	 */
	public void setWorkerscomp(String workerscomp) {
		this.workerscomp = workerscomp;
	}

	/**
	 * @return the workerscompamount
	 */
	public String getWorkerscompamount() {
		return workerscompamount;
	}

	/**
	 * @param workerscompamount
	 *            the workerscompamount to set
	 */
	public void setWorkerscompamount(String workerscompamount) {
		this.workerscompamount = workerscompamount;
	}

}
