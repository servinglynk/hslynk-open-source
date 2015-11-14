package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class ExitPlansActionsList extends PaginatedModel {

	private List<ExitPlansActions> exitPlansActionsList = new ArrayList<ExitPlansActions>();

	public List<ExitPlansActions> getExitPlansActionsList() {
		return exitPlansActionsList;
	}

	public void setExitPlansActionsList(List<ExitPlansActions> exitPlansActionsList) {
		this.exitPlansActionsList = exitPlansActionsList;
	}
	
	
	public void addExitPlansActions(ExitPlansActions exitPlansActions){
		this.exitPlansActionsList.add(exitPlansActions);
	}
	
}