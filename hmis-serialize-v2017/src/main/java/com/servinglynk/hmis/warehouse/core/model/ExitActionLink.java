package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExitActionLink {

	private String rel;
	private String href;
	
	Map<String,List<ActionLink>> exitHousingAssessments = new HashMap<>();
	Map<String,List<ActionLink>> housingAssessmentDispositions = new HashMap<>();
	Map<String,List<ActionLink>> exitPaths = new HashMap<>();
	Map<String,List<ActionLink>> exitrhys = new HashMap<>();
	
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
	
	public Map<String, List<ActionLink>> getExitHousingAssessments() {
		return exitHousingAssessments;
	}
	public void setExitHousingAssessments(Map<String, List<ActionLink>> exitHousingAssessments) {
		this.exitHousingAssessments = exitHousingAssessments;
	}
	public Map<String, List<ActionLink>> getHousingAssessmentDispositions() {
		return housingAssessmentDispositions;
	}
	public void setHousingAssessmentDispositions(Map<String, List<ActionLink>> housingAssessmentDispositions) {
		this.housingAssessmentDispositions = housingAssessmentDispositions;
	}
	public Map<String, List<ActionLink>> getExitPaths() {
		return exitPaths;
	}
	public void setExitPaths(Map<String, List<ActionLink>> exitPaths) {
		this.exitPaths = exitPaths;
	}
	public Map<String, List<ActionLink>> getExitrhys() {
		return exitrhys;
	}
	public void setExitrhys(Map<String, List<ActionLink>> exitrhys) {
		this.exitrhys = exitrhys;
	}
}