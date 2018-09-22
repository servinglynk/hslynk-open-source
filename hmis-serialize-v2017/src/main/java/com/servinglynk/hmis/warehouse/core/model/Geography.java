package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("geography")
public class Geography extends ClientModel{
	private java.util.UUID id;
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime informationDate;
	private String geoCode;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String geographyType;
	/**
	 * @return the id
	 */
	public java.util.UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	/**
	 * @return the informationDate
	 */
	public LocalDateTime getInformationDate() {
		return informationDate;
	}
	/**
	 * @param informationDate the informationDate to set
	 */
	public void setInformationDate(LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}
	/**
	 * @return the geoCode
	 */
	public String getGeoCode() {
		return geoCode;
	}
	/**
	 * @param geoCode the geoCode to set
	 */
	public void setGeoCode(String geoCode) {
		this.geoCode = geoCode;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	/**
	 * @return the geographyType
	 */
	public String getGeographyType() {
		return geographyType;
	}
	/**
	 * @param geographyType the geographyType to set
	 */
	public void setGeographyType(String geographyType) {
		this.geographyType = geographyType;
	}
	
	
}
