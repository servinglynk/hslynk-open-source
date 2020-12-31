package com.servinglynk.hmis.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "housing_unit", schema =  "bed_inventory")
public class HousingUnitEntity extends BaseEntity {

	@Id
	@Column(name = "id", nullable = false)
	  @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name =  "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "occupant_capacity")
	private Integer occupantCapacity;
	
	@Column(name = "project_id")
	@org.hibernate.annotations.Type(type = "org.hibernate.type.PostgresUUIDType")
	private UUID projectId;
	
	@Column(name = "project_type")
	private String projectType;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "shelter_id", nullable = true )
	private ShelterEntity shelter;
	
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
	public ShelterEntity getShelter() {
		return shelter;
	}
	public void setShelter(ShelterEntity shelter) {
		this.shelter = shelter;
	}	
}