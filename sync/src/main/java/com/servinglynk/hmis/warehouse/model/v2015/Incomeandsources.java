package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Incomeandsources extends BaseModel {

	@Column(name = "alimony")
	public String alimony;
	@Column(name = "alimonyamount")
	public Double alimonyamount;
	@Column(name = "childsupport")
	public String childsupport;
	@Column(name = "childsupportamount")
	public Double childsupportamount;
	@Column(name = "earned")
	public Integer earned;
	@Column(name = "earnedamount")
	public Double earnedamount;
	@Column(name = "ga")
	public Integer ga;
	@Column(name = "gaamount")
	public Double gaamount;
	@Column(name = "incomefromanysource")
	public Integer incomefromanysource;
	@Column(name = "othersource")
	public String othersource;
	@Column(name = "othersourceamount")
	public Double othersourceamount;
	@Column(name = "othersourceidentify")
	public String othersourceidentify;
	@Column(name = "pension")
	public Integer pension;
	@Column(name = "pensionamount")
	public Double pensionamount;
	@Column(name = "privatedisability")
	public Integer privatedisability;
	@Column(name = "privatedisabilityamount")
	public Double privatedisabilityamount;
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "socsecretirement")
	public Integer socsecretirement;
	@Column(name = "socsecretirementamount")
	public Double socsecretirementamount;
	@Column(name = "ssdi")
	public Integer ssdi;
	@Column(name = "ssdiamount")
	public Double ssdiamount;
	@Column(name = "ssi")
	public Integer ssi;
	@Column(name = "ssiamount")
	public Double ssiamount;
	@Column(name = "tanf")
	public Integer tanf;
	@Column(name = "tanfamount")
	public Double tanfamount;
	@Column(name = "totalmonthlyincome")
	public Double totalmonthlyincome;
	@Column(name = "unemployment")
	public Integer unemployment;
	@Column(name = "unemploymentamount")
	public Double unemploymentamount;
	@Column(name = "vadisabilitynonservice")
	public Integer vadisabilitynonservice;
	@Column(name = "vadisabilitynonserviceamount")
	public Double vadisabilitynonserviceamount;
	@Column(name = "vadisabilityservice")
	public Integer vadisabilityservice;
	@Column(name = "vadisabilityserviceamount")
	public Double vadisabilityserviceamount;
	@Column(name = "workerscomp")
	public Integer workerscomp;
	@Column(name = "workerscompamount")
	public Double workerscompamount;
	public String getAlimony() {
		return alimony;
	}
	public void setAlimony(String alimony) {
		this.alimony = alimony;
	}
	public Double getAlimonyamount() {
		return alimonyamount;
	}
	public void setAlimonyamount(Double alimonyamount) {
		this.alimonyamount = alimonyamount;
	}
	public String getChildsupport() {
		return childsupport;
	}
	public void setChildsupport(String childsupport) {
		this.childsupport = childsupport;
	}
	public Double getChildsupportamount() {
		return childsupportamount;
	}
	public void setChildsupportamount(Double childsupportamount) {
		this.childsupportamount = childsupportamount;
	}
	public Integer getEarned() {
		return earned;
	}
	public void setEarned(Integer earned) {
		this.earned = earned;
	}
	public Double getEarnedamount() {
		return earnedamount;
	}
	public void setEarnedamount(Double earnedamount) {
		this.earnedamount = earnedamount;
	}
	public Integer getGa() {
		return ga;
	}
	public void setGa(Integer ga) {
		this.ga = ga;
	}
	public Double getGaamount() {
		return gaamount;
	}
	public void setGaamount(Double gaamount) {
		this.gaamount = gaamount;
	}
	public Integer getIncomefromanysource() {
		return incomefromanysource;
	}
	public void setIncomefromanysource(Integer incomefromanysource) {
		this.incomefromanysource = incomefromanysource;
	}
	public String getOthersource() {
		return othersource;
	}
	public void setOthersource(String othersource) {
		this.othersource = othersource;
	}
	public Double getOthersourceamount() {
		return othersourceamount;
	}
	public void setOthersourceamount(Double othersourceamount) {
		this.othersourceamount = othersourceamount;
	}
	public String getOthersourceidentify() {
		return othersourceidentify;
	}
	public void setOthersourceidentify(String othersourceidentify) {
		this.othersourceidentify = othersourceidentify;
	}
	public Integer getPension() {
		return pension;
	}
	public void setPension(Integer pension) {
		this.pension = pension;
	}
	public Double getPensionamount() {
		return pensionamount;
	}
	public void setPensionamount(Double pensionamount) {
		this.pensionamount = pensionamount;
	}
	public Integer getPrivatedisability() {
		return privatedisability;
	}
	public void setPrivatedisability(Integer privatedisability) {
		this.privatedisability = privatedisability;
	}
	public Double getPrivatedisabilityamount() {
		return privatedisabilityamount;
	}
	public void setPrivatedisabilityamount(Double privatedisabilityamount) {
		this.privatedisabilityamount = privatedisabilityamount;
	}
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	public Integer getSocsecretirement() {
		return socsecretirement;
	}
	public void setSocsecretirement(Integer socsecretirement) {
		this.socsecretirement = socsecretirement;
	}
	public Double getSocsecretirementamount() {
		return socsecretirementamount;
	}
	public void setSocsecretirementamount(Double socsecretirementamount) {
		this.socsecretirementamount = socsecretirementamount;
	}
	public Integer getSsdi() {
		return ssdi;
	}
	public void setSsdi(Integer ssdi) {
		this.ssdi = ssdi;
	}
	public Double getSsdiamount() {
		return ssdiamount;
	}
	public void setSsdiamount(Double ssdiamount) {
		this.ssdiamount = ssdiamount;
	}
	public Integer getSsi() {
		return ssi;
	}
	public void setSsi(Integer ssi) {
		this.ssi = ssi;
	}
	public Double getSsiamount() {
		return ssiamount;
	}
	public void setSsiamount(Double ssiamount) {
		this.ssiamount = ssiamount;
	}
	public Integer getTanf() {
		return tanf;
	}
	public void setTanf(Integer tanf) {
		this.tanf = tanf;
	}
	public Double getTanfamount() {
		return tanfamount;
	}
	public void setTanfamount(Double tanfamount) {
		this.tanfamount = tanfamount;
	}
	public Double getTotalmonthlyincome() {
		return totalmonthlyincome;
	}
	public void setTotalmonthlyincome(Double totalmonthlyincome) {
		this.totalmonthlyincome = totalmonthlyincome;
	}
	public Integer getUnemployment() {
		return unemployment;
	}
	public void setUnemployment(Integer unemployment) {
		this.unemployment = unemployment;
	}
	public Double getUnemploymentamount() {
		return unemploymentamount;
	}
	public void setUnemploymentamount(Double unemploymentamount) {
		this.unemploymentamount = unemploymentamount;
	}
	public Integer getVadisabilitynonservice() {
		return vadisabilitynonservice;
	}
	public void setVadisabilitynonservice(Integer vadisabilitynonservice) {
		this.vadisabilitynonservice = vadisabilitynonservice;
	}
	public Double getVadisabilitynonserviceamount() {
		return vadisabilitynonserviceamount;
	}
	public void setVadisabilitynonserviceamount(Double vadisabilitynonserviceamount) {
		this.vadisabilitynonserviceamount = vadisabilitynonserviceamount;
	}
	public Integer getVadisabilityservice() {
		return vadisabilityservice;
	}
	public void setVadisabilityservice(Integer vadisabilityservice) {
		this.vadisabilityservice = vadisabilityservice;
	}
	public Double getVadisabilityserviceamount() {
		return vadisabilityserviceamount;
	}
	public void setVadisabilityserviceamount(Double vadisabilityserviceamount) {
		this.vadisabilityserviceamount = vadisabilityserviceamount;
	}
	public Integer getWorkerscomp() {
		return workerscomp;
	}
	public void setWorkerscomp(Integer workerscomp) {
		this.workerscomp = workerscomp;
	}
	public Double getWorkerscompamount() {
		return workerscompamount;
	}
	public void setWorkerscompamount(Double workerscompamount) {
		this.workerscompamount = workerscompamount;
	}

	
}
