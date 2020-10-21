package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

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
