package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("referralsources")
public class Referralsources extends PaginatedModel {

	@JsonProperty("referralsources")
	List<Referralsource> referralsources = new ArrayList<Referralsource>();

	public List<Referralsource> getReferralsources() {
		return referralsources;
	}

	public void setReferralsources(List<Referralsource> referralsources) {
		this.referralsources = referralsources;
	}
	
	
	public void addReferralsource(Referralsource referralsource){
		this.referralsources.add(referralsource);
	}
	
}
