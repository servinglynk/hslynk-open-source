package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class Shelters extends PaginatedModel {

	private List<ShelterModel> shelters = new ArrayList<ShelterModel>();

	public List<ShelterModel> getShelters() {
		return shelters;
	}

	public void setShelters(List<ShelterModel> shelters) {
		this.shelters = shelters;
	}

	public void addShleter(ShelterModel shelter) {
		this.shelters.add(shelter);		
	}
	
	
	
}
