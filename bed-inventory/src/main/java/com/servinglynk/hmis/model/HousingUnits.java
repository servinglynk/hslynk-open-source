package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(value = Include.NON_NULL)
public class HousingUnits extends PaginatedModel{

	List<HousingUnit> housingUnits = new ArrayList<HousingUnit>();

	public List<HousingUnit> getHousingUnits() {
		return housingUnits;
	}

	public void setHousingUnits(List<HousingUnit> housingUnits) {
		this.housingUnits = housingUnits;
	}
	
	public void addHousingUnit(HousingUnit housingUnit) {
		this.housingUnits.add(housingUnit);
	}
}
