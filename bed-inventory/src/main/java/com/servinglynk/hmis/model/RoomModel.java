package com.servinglynk.hmis.model;

import java.util.UUID;

public class RoomModel {

	private UUID id;
	private String name;
	private Long occupantCapacity;
	private Boolean isActive;	
	private AreaModel area;
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
	public AreaModel getArea() {
		return area;
	}
	public void setArea(AreaModel area) {
		this.area = area;
	}
	public ShelterModel getShelter() {
		return shelter;
	}
	public void setShelter(ShelterModel shelter) {
		this.shelter = shelter;
	}
	public void setAreaId(UUID areaid) {
		if(this.area  == null) this.area = new AreaModel();
		this.area.setId(areaid);
	}
	public void setShelterId(UUID shelterid) {
		if(this.shelter  == null) this.shelter = new ShelterModel();
		this.shelter.setId(shelterid);
	}
}