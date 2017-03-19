package com.servinglynk.hmis.warehouse.core.model;

import java.util.ArrayList;
import java.util.List;

import com.servinglynk.hmis.warehouse.PaginatedModel;

public class ServicesList extends PaginatedModel {

	private List<Services> servicesList = new ArrayList<Services>();

	public List<Services> getServicesList() {
		return servicesList;
	}

	public void setServicesList(List<Services> servicesList) {
		this.servicesList = servicesList;
	}
	
	public void addServices(Services services){
		this.servicesList.add(services);
	}
	
}
