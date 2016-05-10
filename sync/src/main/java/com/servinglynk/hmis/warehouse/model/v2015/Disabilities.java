package com.servinglynk.hmis.warehouse.model.v2015;

import java.sql.Timestamp;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


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
	private Integer viral_load;
	
	@Column( name = "viral_load_available")
	private Integer viral_load_available;
	
	@Column( name = "viral_load_source")
	private String viral_load_source;

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

	public Integer getViral_load() {
		return viral_load;
	}

	public void setViral_load(Integer viral_load) {
		this.viral_load = viral_load;
	}

	public Integer getViral_load_available() {
		return viral_load_available;
	}

	public void setViral_load_available(Integer viral_load_available) {
		this.viral_load_available = viral_load_available;
	}

	public String getViral_load_source() {
		return viral_load_source;
	}

	public void setViral_load_source(String viral_load_source) {
		this.viral_load_source = viral_load_source;
	}

	
	
	
	   
}
