package com.servinglynk.hmis.entity;

import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "shelter", schema =  "bed_inventory")
public class ShelterEntity extends BaseEntity {

	@Id
	@Basic(optional = false)
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "project_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID projectId;
	
	@Column(name = "project_type")
	private String projectType;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "occupant_capacity")
	private Long occupantCapacity;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "address_1")
	private String address1;
	
	@Column(name = "address_2")
	private String address2;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zipcode")
	private String zipcode;
	
	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "latitude")
	private String latitude;
	
	@Column(name = "total_areas")
	private Long totalAreas=0L;
	
	@Column(name = "total_rooms")	
	private Long totalRooms=0L;
	
	@Column(name = "total_beds")
	private Long totalBeds=0L;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public Long getTotalAreas() {
		return totalAreas;
	}
	public void setTotalAreas(Long totalAreas) {
		this.totalAreas = totalAreas;
	}
	public Long getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(Long totalRooms) {
		this.totalRooms = totalRooms;
	}
	public Long getTotalBeds() {
		return totalBeds;
	}
	public void setTotalBeds(Long totalBeds) {
		this.totalBeds = totalBeds;
	}
}