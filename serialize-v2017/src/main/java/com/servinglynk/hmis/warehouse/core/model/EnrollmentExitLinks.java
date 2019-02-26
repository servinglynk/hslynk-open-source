package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentExitLinks {

	List<ActionLink> exitHousingAssessments = new ArrayList<>();
	List<ActionLink> housingAssessmentDispositions = new ArrayList<>();
	List<ActionLink> exitPaths = new ArrayList<>();
	List<ActionLink> exitrhys = new ArrayList<>();
	
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