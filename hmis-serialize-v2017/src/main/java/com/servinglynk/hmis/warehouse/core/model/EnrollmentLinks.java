package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentLinks {
	
	Map<String,Map<String,List<ActionLink>>> enrollmentcocs = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> educations = new HashMap<>();
	Map<String,List<ActionLink>> contacts = new HashMap<>();
	Map<String,List<ActionLink>> dateOfEngagements = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> disabilities = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> domesticViolences = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> employments = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> healthinsurances = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> healthStatuses = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> incomeandsources = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> medicalassistances = new HashMap<>();
	Map<String,Map<String,List<ActionLink>>> noncashbenefits = new HashMap<>();
	Map<String,List<ActionLink>> residentialMoveinDates = new HashMap<>();
	Map<String,List<ActionLink>> pathstatuses = new HashMap<>();
	Map<String,List<ActionLink>> serviceFaReferrals = new HashMap<>();
	
	public Map<String,Map<String,List<ActionLink>>> getEnrollmentcocs() {
		return enrollmentcocs;
	}
	public void setEnrollmentcocs(Map<String,Map<String,List<ActionLink>>> enrollmentcocs) {
		this.enrollmentcocs = enrollmentcocs;
	}
	public Map<String,Map<String,List<ActionLink>>> getEducations() {
		return educations;
	}
	public void setEducations(Map<String,Map<String,List<ActionLink>>> educations) {
		this.educations = educations;
	}
	public Map<String, List<ActionLink>> getContacts() {
		return contacts;
	}
	public void setContacts(Map<String, List<ActionLink>> contacts) {
		this.contacts = contacts;
	}
	public Map<String, List<ActionLink>> getDateOfEngagements() {
		return dateOfEngagements;
	}
	public void setDateOfEngagements(Map<String, List<ActionLink>> dateOfEngagements) {
		this.dateOfEngagements = dateOfEngagements;
	}
	public Map<String,Map<String, List<ActionLink>>> getDisabilities() {
		return disabilities;
	}
	public void setDisabilities(Map<String,Map<String, List<ActionLink>>> disabilities) {
		this.disabilities = disabilities;
	}
	public Map<String,Map<String,List<ActionLink>>> getDomesticViolences() {
		return domesticViolences;
	}
	public void setDomesticViolences(Map<String,Map<String,List<ActionLink>>> domesticViolences) {
		this.domesticViolences = domesticViolences;
	}
	public Map<String,Map<String,List<ActionLink>>> getEmployments() {
		return employments;
	}
	public void setEmployments(Map<String,Map<String,List<ActionLink>>> employments) {
		this.employments = employments;
	}
	public Map<String,Map<String,List<ActionLink>>> getHealthinsurances() {
		return healthinsurances;
	}
	public void setHealthinsurances(Map<String,Map<String,List<ActionLink>>> healthinsurances) {
		this.healthinsurances = healthinsurances;
	}
	public Map<String,Map<String,List<ActionLink>>> getHealthStatuses() {
		return healthStatuses;
	}
	public void setHealthStatuses(Map<String,Map<String,List<ActionLink>>> healthStatuses) {
		this.healthStatuses = healthStatuses;
	}
	public Map<String,Map<String,List<ActionLink>>> getIncomeandsources() {
		return incomeandsources;
	}
	public void setIncomeandsources(Map<String,Map<String,List<ActionLink>>> incomeandsources) {
		this.incomeandsources = incomeandsources;
	}
	public Map<String,Map<String,List<ActionLink>>> getMedicalassistances() {
		return medicalassistances;
	}
	public void setMedicalassistances(Map<String,Map<String,List<ActionLink>>> medicalassistances) {
		this.medicalassistances = medicalassistances;
	}
	public Map<String,Map<String,List<ActionLink>>> getNoncashbenefits() {
		return noncashbenefits;
	}
	public void setNoncashbenefits(Map<String,Map<String,List<ActionLink>>> noncashbenefits) {
		this.noncashbenefits = noncashbenefits;
	}
	public Map<String, List<ActionLink>> getResidentialMoveinDates() {
		return residentialMoveinDates;
	}
	public void setResidentialMoveinDates(Map<String, List<ActionLink>> residentialMoveinDates) {
		this.residentialMoveinDates = residentialMoveinDates;
	}
	public Map<String, List<ActionLink>> getPathstatuses() {
		return pathstatuses;
	}
	public void setPathstatuses(Map<String, List<ActionLink>> pathstatuses) {
		this.pathstatuses = pathstatuses;
	}
	public Map<String, List<ActionLink>> getServiceFaReferrals() {
		return serviceFaReferrals;
	}
	public void setServiceFaReferrals(Map<String, List<ActionLink>> serviceFaReferrals) {
		this.serviceFaReferrals = serviceFaReferrals;
	}	
}