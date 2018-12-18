package com.servinglynk.report.model;

public class HealthInsuranceModel extends BaseModel {
	private String insurancefromanysource;
	private String medicaid;
	private String medicare;
	private String statehealthinadults;
	private String vamedicalservices;
	private String employerprovided;
	private String privatepay;
	private String schip;
	private String indianhealthservices;
	private String otherinsurance;
	private String dedupClientId;
	
	public HealthInsuranceModel(String insurancefromanysource, String medicaid, String medicare,
			String statehealthinadults, String vamedicalservices, String employerprovided, String privatepay,
			String schip, String indianhealthservices, String otherinsurance, String dedupClientId) {
		super();
		this.insurancefromanysource = insurancefromanysource;
		this.medicaid = medicaid;
		this.medicare = medicare;
		this.statehealthinadults = statehealthinadults;
		this.vamedicalservices = vamedicalservices;
		this.employerprovided = employerprovided;
		this.privatepay = privatepay;
		this.schip = schip;
		this.indianhealthservices = indianhealthservices;
		this.otherinsurance = otherinsurance;
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the insurancefromanysource
	 */
	public String getInsurancefromanysource() {
		return insurancefromanysource;
	}
	/**
	 * @param insurancefromanysource the insurancefromanysource to set
	 */
	public void setInsurancefromanysource(String insurancefromanysource) {
		this.insurancefromanysource = insurancefromanysource;
	}
	/**
	 * @return the medicaid
	 */
	public String getMedicaid() {
		return medicaid;
	}
	/**
	 * @param medicaid the medicaid to set
	 */
	public void setMedicaid(String medicaid) {
		this.medicaid = medicaid;
	}
	/**
	 * @return the medicare
	 */
	public String getMedicare() {
		return medicare;
	}
	/**
	 * @param medicare the medicare to set
	 */
	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}
	/**
	 * @return the statehealthinadults
	 */
	public String getStatehealthinadults() {
		return statehealthinadults;
	}
	/**
	 * @param statehealthinadults the statehealthinadults to set
	 */
	public void setStatehealthinadults(String statehealthinadults) {
		this.statehealthinadults = statehealthinadults;
	}
	/**
	 * @return the vamedicalservices
	 */
	public String getVamedicalservices() {
		return vamedicalservices;
	}
	/**
	 * @param vamedicalservices the vamedicalservices to set
	 */
	public void setVamedicalservices(String vamedicalservices) {
		this.vamedicalservices = vamedicalservices;
	}
	/**
	 * @return the employerprovided
	 */
	public String getEmployerprovided() {
		return employerprovided;
	}
	/**
	 * @param employerprovided the employerprovided to set
	 */
	public void setEmployerprovided(String employerprovided) {
		this.employerprovided = employerprovided;
	}
	/**
	 * @return the privatepay
	 */
	public String getPrivatepay() {
		return privatepay;
	}
	/**
	 * @param privatepay the privatepay to set
	 */
	public void setPrivatepay(String privatepay) {
		this.privatepay = privatepay;
	}
	/**
	 * @return the schip
	 */
	public String getSchip() {
		return schip;
	}
	/**
	 * @param schip the schip to set
	 */
	public void setSchip(String schip) {
		this.schip = schip;
	}
	/**
	 * @return the indianhealthservices
	 */
	public String getIndianhealthservices() {
		return indianhealthservices;
	}
	/**
	 * @param indianhealthservices the indianhealthservices to set
	 */
	public void setIndianhealthservices(String indianhealthservices) {
		this.indianhealthservices = indianhealthservices;
	}
	/**
	 * @return the otherinsurance
	 */
	public String getOtherinsurance() {
		return otherinsurance;
	}
	/**
	 * @param otherinsurance the otherinsurance to set
	 */
	public void setOtherinsurance(String otherinsurance) {
		this.otherinsurance = otherinsurance;
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
	
	
}
