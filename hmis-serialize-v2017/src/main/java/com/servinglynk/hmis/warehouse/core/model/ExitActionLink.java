package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExitActionLink {

	private String rel;
	private String href;
	
	Map<String,Map<String,List<ActionLinks>>> exitHousingAssessments = new HashMap<>();
	Map<String,Map<String,List<ActionLinks>>> housingAssessmentDispositions = new HashMap<>();
	Map<String,Map<String,List<ActionLinks>>> exitPaths = new HashMap<>();
	Map<String,Map<String,List<ActionLinks>>> exitrhys = new HashMap<>();
	
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
	
	public Map<String,Map<String,List<ActionLinks>>> getExitHousingAssessments() {
		return exitHousingAssessments;
	}
	public void setExitHousingAssessments(Map<String,Map<String,List<ActionLinks>>> exitHousingAssessments) {
		this.exitHousingAssessments = exitHousingAssessments;
	}
	public Map<String,Map<String,List<ActionLinks>>> getHousingAssessmentDispositions() {
		return housingAssessmentDispositions;
	}
	public void setHousingAssessmentDispositions(Map<String,Map<String,List<ActionLinks>>> housingAssessmentDispositions) {
		this.housingAssessmentDispositions = housingAssessmentDispositions;
	}
	public Map<String,Map<String,List<ActionLinks>>> getExitPaths() {
		return exitPaths;
	}
	public void setExitPaths(Map<String,Map<String,List<ActionLinks>>> exitPaths) {
		this.exitPaths = exitPaths;
	}
	public Map<String,Map<String,List<ActionLinks>>> getExitrhys() {
		return exitrhys;
	}
	public void setExitrhys(Map<String,Map<String,List<ActionLinks>>> exitrhys) {
		this.exitrhys = exitrhys;
	}
}