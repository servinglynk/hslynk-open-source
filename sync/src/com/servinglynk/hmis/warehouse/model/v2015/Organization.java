package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Organization extends BaseModel{
	@Column(name = "organizationcommonname")
	public String organizationcommonname;
	@Column(name = "organizationname")
	public String organizationname;
	@Column(name = "id")
	public UUID id;
	public String getOrganizationcommonname() {
		return organizationcommonname;
	}
	public void setOrganizationcommonname(String organizationcommonname) {
		this.organizationcommonname = organizationcommonname;
	}
	public String getOrganizationname() {
		return organizationname;
	}
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
	
}
