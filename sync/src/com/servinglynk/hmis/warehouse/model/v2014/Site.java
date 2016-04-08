package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Site extends BaseModel {
	@Column(name = "address")	
	public String address;
	@Column(name = "city")
	public String city;
	@Column(name = "geocode")
	public String geocode;
	@Column(name = "principal_site")
	public String principal_site;
	@Column(name = "project_coc_id")
	public UUID project_coc_id;
	@Column(name = "state")
	public String state;
	@Column(name = "zip")
	public String zip;
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the geocode
	 */
	public String getGeocode() {
		return geocode;
	}
	/**
	 * @param geocode the geocode to set
	 */
	public void setGeocode(String geocode) {
		this.geocode = geocode;
	}
	/**
	 * @return the principal_site
	 */
	public String getPrincipal_site() {
		return principal_site;
	}
	/**
	 * @param principal_site the principal_site to set
	 */
	public void setPrincipal_site(String principal_site) {
		this.principal_site = principal_site;
	}
	/**
	 * @return the project_coc_id
	 */
	public UUID getProject_coc_id() {
		return project_coc_id;
	}
	/**
	 * @param project_coc_id the project_coc_id to set
	 */
	public void setProject_coc_id(UUID project_coc_id) {
		this.project_coc_id = project_coc_id;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	
}
