package com.servinglynk.hmis.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName("housingUnit")
@JsonInclude(value = Include.NON_NULL)
public class HousingUnit {

	private UUID id;
	private String name;
	private String description;
	private Integer occupantCapacity;
	private UUID projectId;
	private String projectType;
	private Boolean isActive;
	private ShelterModel shelter;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOccupantCapacity() {
		return occupantCapacity;
	}
	public void setOccupantCapacity(Integer occupantCapacity) {
		this.occupantCapacity = occupantCapacity;
	}
	public UUID getProjectId() {
		return projectId;
	}
	public void setProjectId(UUID projectId) {
		this.projectId = projectId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public ShelterModel getShelter() {
		return shelter;
	}
	public void setShelter(ShelterModel shelter) {
		this.shelter = shelter;
	}	
}