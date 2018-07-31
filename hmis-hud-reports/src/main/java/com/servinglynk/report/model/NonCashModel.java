package com.servinglynk.report.model;

public class NonCashModel {
//nb.snap,nb.wic,nb.tanfchildcare,nb.tanftransportation,nb.othertanf,nb.benefitsfromanysource
	private String snap;
	private String wic;
	private String tanfchildcare;
	private String tanftransportation;
	private String othertanf;
	private String benefitsfromanysource;
	private String dedupClientId;
	
	
	public NonCashModel(String snap, String wic, String tanfchildcare, String tanftransportation, String othertanf,
			String benefitsfromanysource, String dedupClientId) {
		super();
		this.snap = snap;
		this.wic = wic;
		this.tanfchildcare = tanfchildcare;
		this.tanftransportation = tanftransportation;
		this.othertanf = othertanf;
		this.benefitsfromanysource = benefitsfromanysource;
		this.dedupClientId = dedupClientId;
	}
	/**
	 * @return the snap
	 */
	public String getSnap() {
		return snap;
	}
	/**
	 * @param snap the snap to set
	 */
	public void setSnap(String snap) {
		this.snap = snap;
	}
	/**
	 * @return the wic
	 */
	public String getWic() {
		return wic;
	}
	/**
	 * @param wic the wic to set
	 */
	public void setWic(String wic) {
		this.wic = wic;
	}
	/**
	 * @return the tanfchildcare
	 */
	public String getTanfchildcare() {
		return tanfchildcare;
	}
	/**
	 * @param tanfchildcare the tanfchildcare to set
	 */
	public void setTanfchildcare(String tanfchildcare) {
		this.tanfchildcare = tanfchildcare;
	}
	/**
	 * @return the tanftransportation
	 */
	public String getTanftransportation() {
		return tanftransportation;
	}
	/**
	 * @param tanftransportation the tanftransportation to set
	 */
	public void setTanftransportation(String tanftransportation) {
		this.tanftransportation = tanftransportation;
	}
	/**
	 * @return the othertanf
	 */
	public String getOthertanf() {
		return othertanf;
	}
	/**
	 * @param othertanf the othertanf to set
	 */
	public void setOthertanf(String othertanf) {
		this.othertanf = othertanf;
	}
	/**
	 * @return the benefitsfromanysource
	 */
	public String getBenefitsfromanysource() {
		return benefitsfromanysource;
	}
	/**
	 * @param benefitsfromanysource the benefitsfromanysource to set
	 */
	public void setBenefitsfromanysource(String benefitsfromanysource) {
		this.benefitsfromanysource = benefitsfromanysource;
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
