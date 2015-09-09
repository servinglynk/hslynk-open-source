package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("developerCompanyAccounts")
public class DeveloperCompanyAccounts extends PaginatedModel{
	
//	@JsonProperty("developerCompanyAccount")
	public List<DeveloperCompanyAccount> developerCompanyAccounts=new ArrayList<DeveloperCompanyAccount>();

	public List<DeveloperCompanyAccount> getDeveloperCompanyAccounts() {
		return developerCompanyAccounts;
	}

	public void setDeveloperCompanyAccounts(
			List<DeveloperCompanyAccount> developerCompanyAccounts) {
		this.developerCompanyAccounts = developerCompanyAccounts;
	}
	
	
	public void add(DeveloperCompanyAccount developerCompanyAccount){
		this.developerCompanyAccounts.add(developerCompanyAccount);
	}
	

}
