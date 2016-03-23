package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("veteranInfos")
public class VeteranInfos extends PaginatedModel {

	@JsonProperty("veteranInfos")
	List<VeteranInfo> veteranInfos = new ArrayList<VeteranInfo>();

	public List<VeteranInfo> getVeteranInfos() {
		return veteranInfos;
	}

	public void setVeteranInfos(List<VeteranInfo> veteranInfos) {
		this.veteranInfos = veteranInfos;
	}
	
	
	public void addVeteranInfo(VeteranInfo veteranInfo){
		this.veteranInfos.add(veteranInfo);
	}
}