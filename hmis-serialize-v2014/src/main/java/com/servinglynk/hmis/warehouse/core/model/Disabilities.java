package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import org.omg.CORBA.INTERNAL;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("disabilities")
public class Disabilities extends ClientModel{


      private UUID disabilitiesId;

      private Integer disabilityresponse;

      private Integer disabilitytype;

      private Integer documentationonfile;

      private Integer indefiniteandimpairs;

      private Integer pathhowconfirmed;

      private Integer receivingservices;

      private Integer pathsmiinformation;



      public UUID getDisabilitiesId(){
          return disabilitiesId;
      }
      public void setDisabilitiesId(UUID disabilitiesId){
          this.disabilitiesId = disabilitiesId;
      }
      public Integer getDisabilityresponse(){
          return disabilityresponse;
      }
      public void setDisabilityresponse(Integer disabilityresponse){
          this.disabilityresponse = disabilityresponse;
      }
      public Integer getDisabilitytype(){
          return disabilitytype;
      }
      public void setDisabilitytype(Integer disabilitytype){
          this.disabilitytype = disabilitytype;
      }
	public Integer getDocumentationonfile() {
		return documentationonfile;
	}
	public void setDocumentationonfile(Integer documentationonfile) {
		this.documentationonfile = documentationonfile;
	}
	public Integer getIndefiniteandimpairs() {
		return indefiniteandimpairs;
	}
	public void setIndefiniteandimpairs(Integer indefiniteandimpairs) {
		this.indefiniteandimpairs = indefiniteandimpairs;
	}
	public Integer getPathhowconfirmed() {
		return pathhowconfirmed;
	}
	public void setPathhowconfirmed(Integer pathhowconfirmed) {
		this.pathhowconfirmed = pathhowconfirmed;
	}
	public Integer getReceivingservices() {
		return receivingservices;
	}
	public void setReceivingservices(Integer receivingservices) {
		this.receivingservices = receivingservices;
	}
	public Integer getPathsmiinformation() {
		return pathsmiinformation;
	}
	public void setPathsmiinformation(Integer pathsmiinformation) {
		this.pathsmiinformation = pathsmiinformation;
	}
 }