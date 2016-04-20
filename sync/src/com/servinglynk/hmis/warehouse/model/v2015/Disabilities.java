package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Disabilities extends BaseModel{

	@Column( name = "disabilityresponse")	
	private Integer disabilityresponse;
	
	@Column( name = "disabilitytype")
	private Integer disabilitytype;
	
	@Column(name = "documentationonfile")
	private Integer documentationonfile;
	
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	
	@Column( name = "id")
	private UUID id;
	
	@Column( name = "indefiniteandimpairs")
	private Integer indefiniteandimpairs;
	
	@Column( name = "information_date")
	private Timestamp informationDate;
	
	@Column( name = "pathhowconfirmed")
	private Integer pathhowconfirmed;
	
	@Column( name = "pathsmiinformation")
	private Integer pathsmiinformation;
	
	@Column( name = "receivingservices")
	private Integer receivingservices;
	
	@Column( name = "tcellcount")
	private Integer tcellcount;
	
	@Column( name = "tcellcountavailable")
	private Integer tcellcountavailable;
	
	@Column( name = "tcellcountsource")
	private String tcellcountsource;
	
	@Column( name = "viral_load")
	private Integer viralLoad;
	
	@Column( name = "viral_load_available")
	private Integer viralLoadAvailable;
	
	@Column( name = "viral_load_source")
	private String viralLoadSource;

	public Integer getDisabilityresponse() {
		return disabilityresponse;
	}

	public void setDisabilityresponse(Integer disabilityresponse) {
		this.disabilityresponse = disabilityresponse;
	}

	public Integer getDisabilitytype() {
		return disabilitytype;
	}

	public void setDisabilitytype(Integer disabilitytype) {
		this.disabilitytype = disabilitytype;
	}

	public Integer getDocumentationonfile() {
		return documentationonfile;
	}

	public void setDocumentationonfile(Integer documentationonfile) {
		this.documentationonfile = documentationonfile;
	}

	
	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	public java.util.UUID getId() {
		return id;
	}

	public void setId(java.util.UUID id) {
		this.id = id;
	}

	public Integer getIndefiniteandimpairs() {
		return indefiniteandimpairs;
	}

	public void setIndefiniteandimpairs(Integer indefiniteandimpairs) {
		this.indefiniteandimpairs = indefiniteandimpairs;
	}

	public Timestamp getInformationDate() {
		return informationDate;
	}

	public void setInformationDate(Timestamp informationDate) {
		this.informationDate = informationDate;
	}

	public Integer getPathhowconfirmed() {
		return pathhowconfirmed;
	}

	public void setPathhowconfirmed(Integer pathhowconfirmed) {
		this.pathhowconfirmed = pathhowconfirmed;
	}

	public Integer getPathsmiinformation() {
		return pathsmiinformation;
	}

	public void setPathsmiinformation(Integer pathsmiinformation) {
		this.pathsmiinformation = pathsmiinformation;
	}

	public Integer getReceivingservices() {
		return receivingservices;
	}

	public void setReceivingservices(Integer receivingservices) {
		this.receivingservices = receivingservices;
	}

	public Integer getTcellcount() {
		return tcellcount;
	}

	public void setTcellcount(Integer tcellcount) {
		this.tcellcount = tcellcount;
	}

	public Integer getTcellcountavailable() {
		return tcellcountavailable;
	}

	public void setTcellcountavailable(Integer tcellcountavailable) {
		this.tcellcountavailable = tcellcountavailable;
	}

	public String getTcellcountsource() {
		return tcellcountsource;
	}

	public void setTcellcountsource(String tcellcountsource) {
		this.tcellcountsource = tcellcountsource;
	}

	public Integer getViralLoad() {
		return viralLoad;
	}

	public void setViralLoad(Integer viralLoad) {
		this.viralLoad = viralLoad;
	}

	public Integer getViralLoadAvailable() {
		return viralLoadAvailable;
	}

	public void setViralLoadAvailable(Integer viralLoadAvailable) {
		this.viralLoadAvailable = viralLoadAvailable;
	}

	public String getViralLoadSource() {
		return viralLoadSource;
	}

	public void setViralLoadSource(String viralLoadSource) {
		this.viralLoadSource = viralLoadSource;
	}
	
	
	   
}
