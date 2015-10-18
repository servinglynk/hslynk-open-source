package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Incomeandsources extends BaseModel {

	@Column(name = "alimony")
	public String alimony;
	@Column(name = "alimonyamount")
	public String alimonyamount;
	@Column(name = "childsupport")
	public String childsupport;
	@Column(name = "childsupportamount")
	public String childsupportamount;
	@Column(name = "earned")
	public String earned;
	@Column(name = "earnedamount")
	public String earnedamount;
	@Column(name = "ga")
	public String ga;
	@Column(name = "gaamount")
	public String gaamount;
	@Column(name = "incomefromanysource")
	public String incomefromanysource;
	@Column(name = "othersource")
	public String othersource;
	@Column(name = "othersourceamount")
	public String othersourceamount;
	@Column(name = "othersourceidentify")
	public String othersourceidentify;
	@Column(name = "pension")
	public String pension;
	@Column(name = "pensionamount")
	public String pensionamount;
	@Column(name = "privatedisability")
	public String privatedisability;
	@Column(name = "privatedisabilityamount")
	public String privatedisabilityamount;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "socsecretirement")
	public String socsecretirement;
	@Column(name = "socsecretirementamount")
	public String socsecretirementamount;
	@Column(name = "ssdi")
	public String ssdi;
	@Column(name = "ssdiamount")
	public String ssdiamount;
	@Column(name = "ssi")
	public String ssi;
	@Column(name = "ssiamount")
	public String ssiamount;
	@Column(name = "tanf")
	public String tanf;
	@Column(name = "tanfamount")
	public String tanfamount;
	@Column(name = "totalmonthlyincome")
	public String totalmonthlyincome;
	@Column(name = "unemployment")
	public String unemployment;
	@Column(name = "unemploymentamount")
	public String unemploymentamount;
	@Column(name = "vadisabilitynonservice")
	public String vadisabilitynonservice;
	@Column(name = "vadisabilitynonserviceamount")
	public String vadisabilitynonserviceamount;
	@Column(name = "vadisabilityservice")
	public String vadisabilityservice;
	@Column(name = "vadisabilityserviceamount")
	public String vadisabilityserviceamount;
	@Column(name = "workerscomp")
	public String workerscomp;
	@Column(name = "workerscompamount")
	public String workerscompamount;

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
