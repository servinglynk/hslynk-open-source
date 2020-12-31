package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class HousingUnitOccupants extends PaginatedModel {

	List<HousingUnitOccupant> housingUnitOccupants = new ArrayList<HousingUnitOccupant>();

	public List<HousingUnitOccupant> getHousingUnitOccupants() {
		return housingUnitOccupants;
	}

	public void setHousingUnitOccupants(List<HousingUnitOccupant> housingUnitOccupants) {
		this.housingUnitOccupants = housingUnitOccupants;
	}
	
	public void addHousingUnitOccupant(HousingUnitOccupant housingUnitOccupant) {
		this.housingUnitOccupants.add(housingUnitOccupant);
	}
	
}
