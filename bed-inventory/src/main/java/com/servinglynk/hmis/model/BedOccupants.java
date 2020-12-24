package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class BedOccupants extends PaginatedModel {

	List<BedOccupant> bedOccupants = new ArrayList<BedOccupant>();

	public List<BedOccupant> getBedOccupants() {
		return bedOccupants;
	}

	public void setBedOccupants(List<BedOccupant> bedOccupants) {
		this.bedOccupants = bedOccupants;
	}
	
	public void addBedOccupant(BedOccupant bedOccupant) {
		this.bedOccupants.add(bedOccupant);
	}
}
