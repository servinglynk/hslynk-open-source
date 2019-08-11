package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("sharingrules")
public class SharingRules extends PaginatedModel {
	
	@JsonProperty("sharingRule")
	List<SharingRule> sharingRules ;

	public List<SharingRule> getSharingRules() {
		return sharingRules;
	}

	public void setSharingRules(List<SharingRule> sharingRules) {
		this.sharingRules = sharingRules;
	}
	
	public void addSharingRule(SharingRule sharingRule){
		if(sharingRules==null) sharingRules = new ArrayList<SharingRule>();
		this.sharingRules.add(sharingRule);
	}

}
