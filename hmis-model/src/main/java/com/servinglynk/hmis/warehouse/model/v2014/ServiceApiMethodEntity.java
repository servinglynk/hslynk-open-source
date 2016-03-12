package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@SuppressWarnings("serial")
@Entity
@Table(name = "hmis_service_api_method")
public class ServiceApiMethodEntity extends BaseModel {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;

	@ManyToOne
	@JoinColumn(name = "service_id", nullable=false, referencedColumnName="id")
	private DeveloperServiceEntity service;

	@ManyToOne
	@JoinColumn(name = "api_method_id", nullable=false, referencedColumnName="id")
	private ApiMethodEntity apiMethod;

	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public DeveloperServiceEntity getService() {
		return service;
	}
	public void setService(DeveloperServiceEntity service) {
		this.service = service;
	}
	public ApiMethodEntity getApiMethod() {
		return apiMethod;
	}
	public void setApiMethod(ApiMethodEntity apiMethod) {
		this.apiMethod = apiMethod;
	}

}
