package com.servinglynk.hmis.warehouse.core.model;

public class ActionLink {

	private String rel;
	private String href;
	public String getRel() {
		return rel;
	}
	public void setRel(String rel) {
		this.rel = rel;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	public ActionLink() {
		super();
	}
	public ActionLink(String rel, String href) {
		this.rel = rel;
		this.href = href;
	}
}