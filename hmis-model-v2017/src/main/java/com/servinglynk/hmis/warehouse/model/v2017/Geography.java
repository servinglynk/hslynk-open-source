package com.servinglynk.hmis.warehouse.model.v2017;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

public class Geography {
	
	private java.util.UUID id;
	private LocalDateTime informationDate;
	private GeographyEnum geoCode;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private Integer geography_type;
	
	/**
	 * @return the id
	 */
	@Id
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
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
	@Basic( optional = true )
	@Column(name = "information_date")
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
	@Type(type = "com.servinglynk.hmis.warehouse.enums.GeographyEnum")
	@Basic( optional = true )
	@Column( name = "geo_code" )
	public GeographyEnum getGeoCode() {
		return geoCode;
	}
	/**
	 * @param geoCode the geoCode to set
	 */
	public void setGeoCode(GeographyEnum geoCode) {
		this.geoCode = geoCode;
	}
	/**
	 * @return the address1
	 */
	@Basic( optional = true )
	@Column( name = "address1" )
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
	@Basic( optional = true )
	@Column( name = "address2" )
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
	@Basic( optional = true )
	@Column( name = "city" )
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
	@Basic( optional = true )
	@Column( name = "state" )
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
	@Basic( optional = true )
	@Column( name = "zip" )
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
	 * @return the geography_type
	 */
	@Basic( optional = true )
	@Column( name = "geography_type" )
	public Integer getGeography_type() {
		return geography_type;
	}
	/**
	 * @param geography_type the geography_type to set
	 */
	public void setGeography_type(Integer geography_type) {
		this.geography_type = geography_type;
	}
	/**
	 * @param id
	 * @param informationDate
	 * @param geoCode
	 * @param address1
	 * @param address2
	 * @param city
	 * @param state
	 * @param zip
	 * @param geography_type
	 */
	public Geography(UUID id, LocalDateTime informationDate, String geoCode,
			String address1, String address2, String city, String state,
			String zip, Integer geography_type) {
		super();
		this.id = id;
		this.informationDate = informationDate;
		this.geoCode = geoCode;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.geography_type = geography_type;
	}
	
	
	
}
