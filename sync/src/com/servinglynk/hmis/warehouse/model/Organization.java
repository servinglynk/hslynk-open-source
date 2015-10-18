package com.servinglynk.hmis.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Organization extends BaseModel{
	@Column(name = "organizationcommonname")
	public String organizationcommonname;
	@Column(name = "organizationname")
	public String organizationname;
	/**
	 * @return the organizationcommonname
	 */
	public String getOrganizationcommonname() {
		return organizationcommonname;
	}
	/**
	 * @param organizationcommonname the organizationcommonname to set
	 */
	public void setOrganizationcommonname(String organizationcommonname) {
		this.organizationcommonname = organizationcommonname;
	}
	/**
	 * @return the organizationname
	 */
	public String getOrganizationname() {
		return organizationname;
	}
	/**
	 * @param organizationname the organizationname to set
	 */
	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}
	
	

}
