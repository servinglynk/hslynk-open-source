package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.ClientModel;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("dataElements")
public class HMISTypes extends ClientModel {

	@JsonProperty("dataElements")
	List<HMISType> hmisTypes = new ArrayList<HMISType>();

	public List<HMISType> getHmisTypes() {
		return hmisTypes;
	}

	public void setHmisTypes(List<HMISType> hmisTypes) {
		this.hmisTypes = hmisTypes;
	}
	
	public void addHmisType(HMISType hmisType) {
		this.hmisTypes.add(hmisType);
	}
}