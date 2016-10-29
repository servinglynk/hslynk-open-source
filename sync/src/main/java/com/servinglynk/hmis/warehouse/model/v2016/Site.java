package com.servinglynk.hmis.warehouse.model.v2016;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Site extends BaseModel {
	@Column(name = "address")	
	public String address;
	@Column(name = "city")
	public String city;
	@Column(name = "geocode")
	public Integer geocode;
	@Column(name = "principal_site")
	public Integer principal_site;
	@Column(name = "coc_id")
	public UUID coc_id;
	@Column(name = "state")
	public String state;
	@Column(name = "zip")
	public String zip;
	@Column(name = "id")
	public UUID id;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getGeocode() {
		return geocode;
	}
	public void setGeocode(Integer geocode) {
		this.geocode = geocode;
	}
	public Integer getPrincipal_site() {
		return principal_site;
	}
	public void setPrincipal_site(Integer principal_site) {
		this.principal_site = principal_site;
	}
	
	public UUID getCoc_id() {
		return coc_id;
	}
	public void setCoc_id(UUID coc_id) {
		this.coc_id = coc_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	
	
}
