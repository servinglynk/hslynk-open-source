package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("youthCriticalIssues")
public class YouthCriticalIssues extends PaginatedModel {

	@JsonProperty("youthCriticalIssues")
	public List<YouthCriticalIssue> youthCriticalIssues = new ArrayList<YouthCriticalIssue>();

	public List<YouthCriticalIssue> getYouthCriticalIssues() {
		return youthCriticalIssues;
	}

	public void setYouthCriticalIssues(List<YouthCriticalIssue> youthCriticalIssues) {
		this.youthCriticalIssues = youthCriticalIssues;
	}
	
	public void addYouthCriticalIssue(YouthCriticalIssue youthCriticalIssue){
		this.youthCriticalIssues.add(youthCriticalIssue);
	}
	
}
