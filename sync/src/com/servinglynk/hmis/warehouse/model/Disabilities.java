package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Disabilities extends BaseModel {
	
	@Column(name="disabilityresponse")
	public String disabilityresponse;
	@Column(name="disabilitytype")
	public String disabilitytype;
	@Column(name="documentationonfile")
	public String documentationonfile;
	@Column(name="indefiniteandimpairs")
	public String indefiniteandimpairs;
	@Column(name="pathhowconfirmed")
	public String pathhowconfirmed;
	@Column(name="pathsmiinformation")
	public String pathsmiinformation;
	@Column(name="enrollmentid")		
	public UUID enrollmentid;
	@Column(name="receivingservices")
	public String receivingservices;
	/**
	 * @return the disabilityresponse
	 */
	public String getDisabilityresponse() {
		return disabilityresponse;
	}
	/**
	 * @param disabilityresponse the disabilityresponse to set
	 */
	public void setDisabilityresponse(String disabilityresponse) {
		this.disabilityresponse = disabilityresponse;
	}
	/**
	 * @return the disabilitytype
	 */
	public String getDisabilitytype() {
		return disabilitytype;
	}
	/**
	 * @param disabilitytype the disabilitytype to set
	 */
	public void setDisabilitytype(String disabilitytype) {
		this.disabilitytype = disabilitytype;
	}
	/**
	 * @return the documentationonfile
	 */
	public String getDocumentationonfile() {
		return documentationonfile;
	}
	/**
	 * @param documentationonfile the documentationonfile to set
	 */
	public void setDocumentationonfile(String documentationonfile) {
		this.documentationonfile = documentationonfile;
	}
	/**
	 * @return the indefiniteandimpairs
	 */
	public String getIndefiniteandimpairs() {
		return indefiniteandimpairs;
	}
	/**
	 * @param indefiniteandimpairs the indefiniteandimpairs to set
	 */
	public void setIndefiniteandimpairs(String indefiniteandimpairs) {
		this.indefiniteandimpairs = indefiniteandimpairs;
	}
	/**
	 * @return the pathhowconfirmed
	 */
	public String getPathhowconfirmed() {
		return pathhowconfirmed;
	}
	/**
	 * @param pathhowconfirmed the pathhowconfirmed to set
	 */
	public void setPathhowconfirmed(String pathhowconfirmed) {
		this.pathhowconfirmed = pathhowconfirmed;
	}
	/**
	 * @return the pathsmiinformation
	 */
	public String getPathsmiinformation() {
		return pathsmiinformation;
	}
	/**
	 * @param pathsmiinformation the pathsmiinformation to set
	 */
	public void setPathsmiinformation(String pathsmiinformation) {
		this.pathsmiinformation = pathsmiinformation;
	}
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
	 * @return the receivingservices
	 */
	public String getReceivingservices() {
		return receivingservices;
	}
	/**
	 * @param receivingservices the receivingservices to set
	 */
	public void setReceivingservices(String receivingservices) {
		this.receivingservices = receivingservices;
	}
	
}
