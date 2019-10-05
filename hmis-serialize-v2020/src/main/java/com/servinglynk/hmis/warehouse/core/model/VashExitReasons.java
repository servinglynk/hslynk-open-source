package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("vashExitReasons")
public class VashExitReasons extends PaginatedModel{

	@JsonProperty("vashExitReasons")
	List<VashExitReason> vashExitReasons = new ArrayList<VashExitReason>();

	public List<VashExitReason> getVashExitReasons() {
		return vashExitReasons;
	}

	public void setVashExitReasons(List<VashExitReason> vashExitReasons) {
		this.vashExitReasons = vashExitReasons;
	}
	
	public void addVashExitReason(VashExitReason vashExitReason){
		this.vashExitReasons.add(vashExitReason);
	}
}
