package com.servinglynk.hmis.warehouse.model.v2020;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hmis_history_entity_mapping",schema="v2020")
public class HistoryEntityMapping {

	@Id
	@Column(name="id")
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	private UUID id;
	
	@Column(name="api_name")
	private String apiName;
	
	@Column(name="entity_name")
	private String entityName;
	
	@Column(name="conveter_class")
	private String converterClass;
	
	@Column(name="list_name")
	private String listName;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getConverterClass() {
		return converterClass;
	}
	public void setConverterClass(String converterClass) {
		this.converterClass = converterClass;
	}
	public String getListName() {
		return listName;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
}