package com.servinglynk.hmis.warehouse.notification.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("worker")
public class WorkerLine {

	private String workerHeaderId;
	
	private String input;
	
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
