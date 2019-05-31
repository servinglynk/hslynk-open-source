package com.servinglynk.hmis.warehouse.model.base;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="hmis_api_access", catalog = "hmis", schema = "base")
public class APIAccessEntity {

    @javax.persistence.Id
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
    @org.hibernate.annotations.Type(type="pg-uuid")
	@Column(name = "id")
	private UUID id;
    
    @Column(name="project_group_code")
	private String projectGroupCode;
    
    @Column(name="access_count")
	private long accessCount;
    
    @Column(name="access_date")
	private Date accessDate;
    
    @Column(name="service_name")
    private String serviceName;

    @Column(name="service_id")
    @org.hibernate.annotations.Type(type="pg-uuid")
    private UUID serviceId;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getProjectGroupCode() {
		return projectGroupCode;
	}
	public void setProjectGroupCode(String projectGroupCode) {
		this.projectGroupCode = projectGroupCode;
	}
	public long getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}
	public Date getAccessDate() {
		return accessDate;
	}
	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public UUID getServiceId() {
		return serviceId;
	}
	public void setServiceId(UUID serviceId) {
		this.serviceId = serviceId;
	}
}