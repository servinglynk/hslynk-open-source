package com.servinglynk.hmis.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("area")
public class AreaModel {

	private UUID id;
	private String name;
	private String description;
	private Long occupantCapacity;
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
	public Long getOccupantCapacity() {
		return occupantCapacity;
	}
	public void setOccupantCapacity(Long occupantCapacity) {
		this.occupantCapacity = occupantCapacity;
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
	public void setShelterId(UUID id) {
		if(shelter == null) {
			shelter = new ShelterModel();
		}
		shelter.setId(id);
	}
}