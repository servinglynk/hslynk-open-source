package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("developerCompanies")
public class DeveloperCompanies  extends PaginatedModel{
	
	@JsonProperty("developerCompanies")
	private List<DeveloperCompany> developerCompanies = new ArrayList<DeveloperCompany>();

	public List<DeveloperCompany> getDeveloperCompanies() {
		return developerCompanies;
	}

	public void setDeveloperCompanys(List<DeveloperCompany> developerCompanies) {
		this.developerCompanies = developerCompanies;
	}

	public void addDeveloperCompany(DeveloperCompany developerCompany) {
		this.developerCompanies.add(developerCompany);
	}

}
