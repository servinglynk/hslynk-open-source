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
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipcode;
	private String longitude;
	private String latitude;
	private ShelterModel shelter;
	private Boolean occupancy;
	
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public Boolean getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(Boolean occupancy) {
		this.occupancy = occupancy;
	}	
}