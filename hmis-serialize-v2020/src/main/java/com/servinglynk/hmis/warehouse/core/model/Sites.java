package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("sites")
public class Sites extends PaginatedModel {

	@JsonProperty("sites")
	List<Site> sites = new ArrayList<Site>();

	public List<Site> getSites() {
		return sites;
	}

	public void setSites(List<Site> sites) {
		this.sites = sites;
	}
	
	public void addSite(Site site){
		this.sites.add(site);
	}
	
}
