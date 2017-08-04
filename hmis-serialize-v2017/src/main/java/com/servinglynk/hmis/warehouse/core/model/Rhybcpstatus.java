package com.servinglynk.hmis.warehouse.core.model; 

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;


import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.thoughtworks.xstream.mapper.LocalConversionMapper;

@JsonRootName("rhybcpstatus")
public class Rhybcpstatus extends ClientModel{


      private UUID rhybcpstatusId;

      @JsonSerialize(using=JsonDateSerializer.class)
      @JsonDeserialize(using=JsonDateDeserializer.class)
      private LocalDateTime statusDate;

      private Integer fysbYouth;

      private Integer reasonNoServices;

	public UUID getRhybcpstatusId() {
		return rhybcpstatusId;
	}

	public void setRhybcpstatusId(UUID rhybcpstatusId) {
		this.rhybcpstatusId = rhybcpstatusId;
	}

	public LocalDateTime getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(LocalDateTime statusDate) {
		this.statusDate = statusDate;
	}

	public Integer getFysbYouth() {
		return fysbYouth;
	}

	public void setFysbYouth(Integer fysbYouth) {
		this.fysbYouth = fysbYouth;
	}

	public Integer getReasonNoServices() {
		return reasonNoServices;
	}

	public void setReasonNoServices(Integer reasonNoServices) {
		this.reasonNoServices = reasonNoServices;
	}




 }
