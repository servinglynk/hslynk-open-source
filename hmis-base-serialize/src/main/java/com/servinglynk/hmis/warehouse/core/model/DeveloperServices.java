package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("developerServices")
public class DeveloperServices extends PaginatedModel {

	@JsonProperty("developerService")
	private List<DeveloperService> services = new ArrayList<DeveloperService>();

	public List<DeveloperService> getServices() {
		return services;
	}

	public void setServices(List<DeveloperService> services) {
		this.services = services;
	}

	public void addService(DeveloperService service) {
		this.services.add(service);
	}

}
