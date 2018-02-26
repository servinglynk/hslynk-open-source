package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class GlobalProjects extends PaginatedModel {
	
	private List<GlobalProject> globalProjects = new ArrayList<>();

	public List<GlobalProject> getGlobalProjects() {
		return globalProjects;
	}

	public void setGlobalProjects(List<GlobalProject> globalProjects) {
		this.globalProjects = globalProjects;
	}
	
	public void addGlobalProject(GlobalProject globalProject) {
		this.globalProjects.add(globalProject);
	}

}
