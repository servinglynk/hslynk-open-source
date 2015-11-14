package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("nonCashBenefits")
public class NonCashBenefits extends PaginatedModel {

	@JsonProperty("nonCashBenefits")
	List<NonCashBenefit> nonCashBenefits = new ArrayList<NonCashBenefit>();

	public List<NonCashBenefit> getNonCashBenefits() {
		return nonCashBenefits;
	}

	public void setNonCashBenefits(List<NonCashBenefit> nonCashBenefits) {
		this.nonCashBenefits = nonCashBenefits;
	}
	
	public void addNonCashBenefit(NonCashBenefit nonCashBenefit){
		this.nonCashBenefits.add(nonCashBenefit);
	}
	
}
