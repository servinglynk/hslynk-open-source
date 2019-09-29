package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("rhyAfterCares")
public class RhyAfterCares extends PaginatedModel{
	
	 @JsonProperty("rhyAfterCares") 
     List<RhyAfterCare> rhyaftercares = new ArrayList<RhyAfterCare>();

	/**
	 * @return the rhyaftercares
	 */
	public List<RhyAfterCare> getRhyaftercares() {
		return rhyaftercares;
	}

	/**
	 * @param rhyaftercares the rhyaftercares to set
	 */
	public void setRhyaftercares(List<RhyAfterCare> rhyaftercares) {
		this.rhyaftercares = rhyaftercares;
	}
	 
	public void addRhyaftercares(RhyAfterCare rhyAfterCare) {
          this.rhyaftercares.add(rhyAfterCare);
    }
}
