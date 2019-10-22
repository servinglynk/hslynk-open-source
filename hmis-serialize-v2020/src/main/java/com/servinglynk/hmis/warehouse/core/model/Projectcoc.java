package com.servinglynk.hmis.warehouse.core.model; 

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("projectCoc")
public class Projectcoc extends ClientModel{


	@JsonProperty("projectCocId")
      private UUID projectcocId;
      @JsonProperty("cocCode")
      private String coccode;
      @JsonProperty("geocode")
      private String geocode;
      @JsonProperty("address1")
	  private String address1;
      @JsonProperty("address2")
	  private String address2;
      @JsonProperty("city")
	  private String city;
      @JsonProperty("state")
	  private String state;
      @JsonProperty("zip")
	  private String zip;
      @JsonProperty("geographyType")
	  private String geographyType;
      private String sourceSystemId;



      public UUID getProjectcocId(){
          return projectcocId;
      }
      public void setProjectcocId(UUID projectcocId){
          this.projectcocId = projectcocId;
      }
      public String getCoccode(){
          return coccode;
      }
      public void setCoccode(String coccode){
          this.coccode = coccode;
      }
	public String getSourceSystemId() {
		return sourceSystemId;
	}
	public void setSourceSystemId(String sourceSystemId) {
		this.sourceSystemId = sourceSystemId;
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
