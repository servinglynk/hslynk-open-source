package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projects")
public class GlobalProjectsMap {

	@JsonProperty("projects")
	public List<GlobalProjectMap> globalProjectMaps = new ArrayList<>();

	public List<GlobalProjectMap> getGlobalProjectMaps() {
		return globalProjectMaps;
	}

	public void setGlobalProjectMaps(List<GlobalProjectMap> globalProjectMaps) {
		this.globalProjectMaps = globalProjectMaps;
	}
	
	public void addGlobalProject(GlobalProjectMap globalProjectMap) {
		this.globalProjectMaps.add(globalProjectMap);
	}
}
