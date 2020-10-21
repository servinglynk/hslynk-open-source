package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class Areas extends PaginatedModel{

	List<AreaModel> areas = new ArrayList<AreaModel>();

	public List<AreaModel> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaModel> areas) {
		this.areas = areas;
	}

	public void addArea(AreaModel areaModel) {
		this.areas.add(areaModel);

	}

}
