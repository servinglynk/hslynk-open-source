package com.servinglynk.hmis.warehouse.core.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnrollmentLinks {
	
Map<String,Map<String,List<ActionLinks>>> enrollmentcocs = new HashMap<>();
	Map<String,Map<String,List<ActionLinks>>> educations = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> contacts = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> dateOfEngagements = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> disabilities = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> domesticViolences = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> employments = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> healthinsurances = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> healthStatuses = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> incomeandsources = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> medicalassistances = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> noncashbenefits = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> residentialMoveinDates = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> pathstatuses = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> serviceFaReferrals = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> events = new HashMap<>();
Map<String,Map<String,List<ActionLinks>>> assessments = new HashMap<>();
	
	public Map<String,Map<String,List<ActionLinks>>> getEnrollmentcocs() {
		return enrollmentcocs;
	}
	public void setEnrollmentcocs(Map<String,Map<String,List<ActionLinks>>> enrollmentcocs) {
		this.enrollmentcocs = enrollmentcocs;
	}
	public Map<String,Map<String,List<ActionLinks>>> getEducations() {
		return educations;
	}
	public void setEducations(Map<String,Map<String,List<ActionLinks>>> educations) {
		this.educations = educations;
	}
	public Map<String,Map<String,List<ActionLinks>>> getContacts() {
		return contacts;
	}
	public void setContacts(Map<String,Map<String,List<ActionLinks>>> contacts) {
		this.contacts = contacts;
	}
	public Map<String,Map<String,List<ActionLinks>>> getDateOfEngagements() {
		return dateOfEngagements;
	}
	public void setDateOfEngagements(Map<String,Map<String,List<ActionLinks>>> dateOfEngagements) {
		this.dateOfEngagements = dateOfEngagements;
	}
	public Map<String,Map<String,List<ActionLinks>>> getDisabilities() {
		return disabilities;
	}
	public void setDisabilities(Map<String,Map<String,List<ActionLinks>>> disabilities) {
		this.disabilities = disabilities;
	}
	public Map<String,Map<String,List<ActionLinks>>> getDomesticViolences() {
		return domesticViolences;
	}
	public void setDomesticViolences(Map<String,Map<String,List<ActionLinks>>> domesticViolences) {
		this.domesticViolences = domesticViolences;
	}
	public Map<String,Map<String,List<ActionLinks>>> getEmployments() {
		return employments;
	}
	public void setEmployments(Map<String,Map<String,List<ActionLinks>>> employments) {
		this.employments = employments;
	}
	public Map<String,Map<String,List<ActionLinks>>> getHealthinsurances() {
		return healthinsurances;
	}
	public void setHealthinsurances(Map<String,Map<String,List<ActionLinks>>> healthinsurances) {
		this.healthinsurances = healthinsurances;
	}
	public Map<String,Map<String,List<ActionLinks>>> getHealthStatuses() {
		return healthStatuses;
	}
	public void setHealthStatuses(Map<String,Map<String,List<ActionLinks>>> healthStatuses) {
		this.healthStatuses = healthStatuses;
	}
	public Map<String,Map<String,List<ActionLinks>>> getIncomeandsources() {
		return incomeandsources;
	}
	public void setIncomeandsources(Map<String,Map<String,List<ActionLinks>>> incomeandsources) {
		this.incomeandsources = incomeandsources;
	}
	public Map<String,Map<String,List<ActionLinks>>> getMedicalassistances() {
		return medicalassistances;
	}
	public void setMedicalassistances(Map<String,Map<String,List<ActionLinks>>> medicalassistances) {
		this.medicalassistances = medicalassistances;
	}
	public Map<String,Map<String,List<ActionLinks>>> getNoncashbenefits() {
		return noncashbenefits;
	}
	public void setNoncashbenefits(Map<String,Map<String,List<ActionLinks>>> noncashbenefits) {
		this.noncashbenefits = noncashbenefits;
	}
	public Map<String,Map<String,List<ActionLinks>>> getResidentialMoveinDates() {
		return residentialMoveinDates;
	}
	public void setResidentialMoveinDates(Map<String,Map<String,List<ActionLinks>>> residentialMoveinDates) {
		this.residentialMoveinDates = residentialMoveinDates;
	}
	public Map<String,Map<String,List<ActionLinks>>> getPathstatuses() {
		return pathstatuses;
	}
	public void setPathstatuses(Map<String,Map<String,List<ActionLinks>>> pathstatuses) {
		this.pathstatuses = pathstatuses;
	}
	public Map<String,Map<String,List<ActionLinks>>> getServiceFaReferrals() {
		return serviceFaReferrals;
	}
	public void setServiceFaReferrals(Map<String,Map<String,List<ActionLinks>>> serviceFaReferrals) {
		this.serviceFaReferrals = serviceFaReferrals;
	}
	public Map<String, Map<String, List<ActionLinks>>> getEvents() {
		return events;
	}
	public void setEvents(Map<String, Map<String, List<ActionLinks>>> events) {
		this.events = events;
	}
	public Map<String, Map<String, List<ActionLinks>>> getAssessments() {
		return assessments;
	}
	public void setAssessments(Map<String, Map<String, List<ActionLinks>>> assessments) {
		this.assessments = assessments;
	}	
}