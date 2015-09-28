package com.servinglynk.hmis.warehouse.core.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("organization")
public class Organization extends ClientModel {

	private UUID organizationId;

	private String organizationName;

    private String organizationCommonName;


	public UUID getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(UUID organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationCommonName() {
		return organizationCommonName;
	}

	public void setOrganizationCommonName(String organizationCommonName) {
		this.organizationCommonName = organizationCommonName;
	}	
	
	
	
	
}