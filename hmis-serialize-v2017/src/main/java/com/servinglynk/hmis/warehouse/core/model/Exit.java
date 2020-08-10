package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("exit")
public class Exit extends ClientModel{


       private UUID exitId;

       private Date exitDate;

       private String otherDestination;
       private Integer destination;      
       
    	Map<String,Map<String,List<ExitActionLinks>>> exitLinks;
       
     /*  
       @JsonProperty("enrollment")
       private Enrollment enrollment;*/

	public UUID getExitId() {
		return exitId;
	}

	public void setExitId(UUID exitId) {
		this.exitId = exitId;
	}

	public Date getExitDate() {
		return exitDate;
	}

	public void setExitDate(Date exitDate) {
		this.exitDate = exitDate;
	}

	public String getOtherDestination() {
		return otherDestination;
	}

	public void setOtherDestination(String otherDestination) {
		this.otherDestination = otherDestination;
	}

	public Integer getDestination() {
		return destination;
	}

	public void setDestination(Integer destination) {
		this.destination = destination;
	}
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
	 public LocalDateTime submissionDate;

     public LocalDateTime getSubmissionDate() {
		return submissionDate;
	}
	public void setSubmissionDate(LocalDateTime submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Map<String, Map<String, List<ExitActionLinks>>> getExitLinks() {
		return exitLinks;
	}

	public void setExitLinks(Map<String, Map<String, List<ExitActionLinks>>> exitLinks) {
		this.exitLinks = exitLinks;
	}
	
	

/*	public Enrollment getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(Enrollment enrollment) {
		this.enrollment = enrollment;
	}
	
	public void setEnrollment(UUID enrollmentId) {
		Enrollment enrollment = new Enrollment();
		enrollment.setEnrollmentId(enrollmentId);
		this.enrollment = enrollment;
	}*/
 }