package com.servinglynk.hmis.warehouse.core.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.apache.commons.lang.builder.ToStringBuilder;

@XmlType(name = "Worker")
@XmlRootElement(name = "worker")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkerLine {

	@XmlElement(name = "workerHeaderId")
	private String workerHeaderId;
	
	@XmlElement(name = "input")
	private String input;
	
	@XmlElement(name = "workerLineId")
	private String workerLineId;

	

	
	public String getWorkerHeaderId() {
		return workerHeaderId;
	}


	public void setWorkerHeaderId(String workerHeaderId) {
		this.workerHeaderId = workerHeaderId;
	}


	public String getWorkerLineId() {
		return workerLineId;
	}


	public void setWorkerLineId(String workerLineId) {
		this.workerLineId = workerLineId;
	}


	public String getInput() {
		return input;
	}


	public void setInput(String input) {
		this.input = input;
	}


	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
