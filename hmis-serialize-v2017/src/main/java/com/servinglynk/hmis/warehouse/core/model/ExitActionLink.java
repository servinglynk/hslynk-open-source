package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

public class ExitActionLink {

	private String rel;
	private String href;
	
	List<ActionLink> exitHousingAssessments = new ArrayList<>();
	List<ActionLink> housingAssessmentDispositions = new ArrayList<>();
	List<ActionLink> exitPaths = new ArrayList<>();
	List<ActionLink> exitrhys = new ArrayList<>();
	
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
	public ExitActionLink(String rel, String href) {
		this.rel = rel;
		this.href = href;
	}
	public List<ActionLink> getExitHousingAssessments() {
		return exitHousingAssessments;
	}
	public void setExitHousingAssessments(List<ActionLink> exitHousingAssessments) {
		this.exitHousingAssessments = exitHousingAssessments;
	}
	public List<ActionLink> getHousingAssessmentDispositions() {
		return housingAssessmentDispositions;
	}
	public void setHousingAssessmentDispositions(List<ActionLink> housingAssessmentDispositions) {
		this.housingAssessmentDispositions = housingAssessmentDispositions;
	}
	public List<ActionLink> getExitPaths() {
		return exitPaths;
	}
	public void setExitPaths(List<ActionLink> exitPaths) {
		this.exitPaths = exitPaths;
	}
	public List<ActionLink> getExitrhys() {
		return exitrhys;
	}
	public void setExitrhys(List<ActionLink> exitrhys) {
		this.exitrhys = exitrhys;
	}
}