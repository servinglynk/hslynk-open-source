package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class BedUnits extends PaginatedModel {

	List<BedUnit> bedUnits = new ArrayList<BedUnit>();

	public List<BedUnit> getBedUnits() {
		return bedUnits;
	}

	public void setBedUnits(List<BedUnit> bedUnits) {
		this.bedUnits = bedUnits;
	}
	
	public void addBedUnit(BedUnit bedUnit) {
		this.bedUnits.add(bedUnit);
	}
	
}
