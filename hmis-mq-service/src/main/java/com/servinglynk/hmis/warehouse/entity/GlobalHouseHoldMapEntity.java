package com.servinglynk.hmis.warehouse.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hmis_global_household_map",schema="base")
public class GlobalHouseHoldMapEntity extends HMISModel {
	

	private UUID id;
	

	private UUID hmisHouseHoldId;
	

	private UUID genericHouseHoldId;
	

	private String schemaYear;
	

	private GlobalHouseHoldEntity globalHouseHold;
	
	private String sourceSystemHouseHoldId;
	private String sourceSystemId;
	
	
	@Id
	@Column( name = "id", nullable = false  )
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Column( name = "hmis_household_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getHmisHouseHoldId() {
		return hmisHouseHoldId;
	}
	public void setHmisHouseHoldId(UUID hmisHouseHoldId) {
		this.hmisHouseHoldId = hmisHouseHoldId;
	}
	
	@Column( name = "generic_household_id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getGenericHouseHoldId() {
		return genericHouseHoldId;
	}
	public void setGenericHouseHoldId(UUID genericHouseHoldId) {
		this.genericHouseHoldId = genericHouseHoldId;
	}
	
	@Column( name = "schema_year")
	public String getSchemaYear() {
		return schemaYear;
	}
	public void setSchemaYear(String schemaYear) {
		this.schemaYear = schemaYear;
	}
	
	@ManyToOne
	@JoinColumn(name = "global_household_id", referencedColumnName="id")
	public GlobalHouseHoldEntity getGlobalHouseHold() {
		return globalHouseHold;
	}
	public void setGlobalHouseHold(GlobalHouseHoldEntity globalHouseHold) {
		this.globalHouseHold = globalHouseHold;
	}
	
	@Column(name = "source_system_house_hold_id")
	public String getSourceSystemHouseHoldId() {
		return sourceSystemHouseHoldId;
	}

	public void setSourceSystemHouseHoldId(String sourceSystemHouseHoldId) {
		this.sourceSystemHouseHoldId = sourceSystemHouseHoldId;
	}

	@Column(name = "source_system_id")
	public String getSourceSystemId() {
		return sourceSystemId;
	}

	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
	}
}