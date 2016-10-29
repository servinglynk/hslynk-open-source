package com.servinglynk.hmis.warehouse.model.v2016;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Project extends BaseModel{
	@Column(name = "enrollmentid")
	public UUID enrollmentid;
	@Column(name = "continuumproject")
	public String continuumproject;
	@Column(name = "organizationid")
	public UUID organizationid;
	@Column(name = "projectcommonname")	
	public String projectcommonname;
	@Column(name = "projectname")	
	public String projectname;
	@Column(name = "projecttype")	
	public String projecttype;
	@Column(name = "residentialaffiliation")
	public String residentialaffiliation;
	@Column(name = "targetpopulation")
	public String targetpopulation;
	@Column(name = "trackingmethod")
	public String trackingmethod;
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the continuumproject
	 */
	public String getContinuumproject() {
		return continuumproject;
	}
	/**
	 * @param continuumproject the continuumproject to set
	 */
	public void setContinuumproject(String continuumproject) {
		this.continuumproject = continuumproject;
	}
	/**
	 * @return the organizationid
	 */
	public UUID getOrganizationid() {
		return organizationid;
	}
	/**
	 * @param organizationid the organizationid to set
	 */
	public void setOrganizationid(UUID organizationid) {
		this.organizationid = organizationid;
	}
	/**
	 * @return the projectcommonname
	 */
	public String getProjectcommonname() {
		return projectcommonname;
	}
	/**
	 * @param projectcommonname the projectcommonname to set
	 */
	public void setProjectcommonname(String projectcommonname) {
		this.projectcommonname = projectcommonname;
	}
	/**
	 * @return the projectname
	 */
	public String getProjectname() {
		return projectname;
	}
	/**
	 * @param projectname the projectname to set
	 */
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	/**
	 * @return the projecttype
	 */
	public String getProjecttype() {
		return projecttype;
	}
	/**
	 * @param projecttype the projecttype to set
	 */
	public void setProjecttype(String projecttype) {
		this.projecttype = projecttype;
	}
	/**
	 * @return the residentialaffiliation
	 */
	public String getResidentialaffiliation() {
		return residentialaffiliation;
	}
	/**
	 * @param residentialaffiliation the residentialaffiliation to set
	 */
	public void setResidentialaffiliation(String residentialaffiliation) {
		this.residentialaffiliation = residentialaffiliation;
	}
	/**
	 * @return the targetpopulation
	 */
	public String getTargetpopulation() {
		return targetpopulation;
	}
	/**
	 * @param targetpopulation the targetpopulation to set
	 */
	public void setTargetpopulation(String targetpopulation) {
		this.targetpopulation = targetpopulation;
	}
	/**
	 * @return the trackingmethod
	 */
	public String getTrackingmethod() {
		return trackingmethod;
	}
	/**
	 * @param trackingmethod the trackingmethod to set
	 */
	public void setTrackingmethod(String trackingmethod) {
		this.trackingmethod = trackingmethod;
	}
	
	

}
