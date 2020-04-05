package com.servinglynk.hmis.warehouse.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hmis_global_household",schema="base")
public class GlobalHouseHoldEntity extends HMISModel {
	
	private UUID id;
	
	private List<GlobalHouseHoldMapEntity> globalHouseHoldMapEntities; 

	@Id
	@Column( name = "id", nullable = false  )
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy = "globalHouseHold")
	public List<GlobalHouseHoldMapEntity> getGlobalHouseHoldMapEntities() {
		return globalHouseHoldMapEntities;
	}

	public void setGlobalHouseHoldMapEntities(List<GlobalHouseHoldMapEntity> globalHouseHoldMapEntities) {
		this.globalHouseHoldMapEntities = globalHouseHoldMapEntities;
	}
}