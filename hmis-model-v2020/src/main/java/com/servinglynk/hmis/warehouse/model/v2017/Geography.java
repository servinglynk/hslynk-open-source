package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.GeographyTypeEnum;
@Entity(name = "geography_v2017")
@Table(name = "geography", catalog = "hmis", schema = "v2017")
public class Geography extends HmisBaseModel implements Cloneable, Serializable  {
	
	private java.util.UUID id;
	private LocalDateTime informationDate;
	private String geoCode;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private GeographyTypeEnum geographyType;
	/** Field mapping. */
	private Coc coc;
	private String coccode;
	/** Field mapping. */
	protected Export export;
	
	public Geography() {
		// Default constructor
	}
	
	
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "export_id", nullable = true )
	public Export getExport() {
		return this.export;

	}



	 /**
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final Export export) {
		this.export = export;
	}
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
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
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
	
	@Basic( optional = true )
	@Column( name = "geo_code" )
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
	@Type(type = "com.servinglynk.hmis.warehouse.enums.GeographyTypeEnumType")
	@Basic( optional = true )
	@Column( name = "geography_type" )
	public GeographyTypeEnum getGeographyType() {
		return geographyType;
	}
	/**
	 * @param geography_type the geography_type to set
	 */
	public void setGeographyType(GeographyTypeEnum geographyType) {
		this.geographyType = geographyType;
	}
	
	 /**
		 * Return the value associated with the column: coc.
		 * @return A Coc object (this.coc)
		 */
		@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
		@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
		@Basic( optional = true )
		@JoinColumn(name = "coc_id", nullable = true )
		public Coc getCoc() {
			return this.coc;
		}


		 /**
		 * Set the value related to the column: coc.
		 * @param coc the coc value you wish to set
		 */
		public void setCoc(final Coc coc) {
			this.coc = coc;
		}
		
		 /**
		 * Return the value associated with the column: coccode.
		 * @return A String object (this.coccode)
		 */
		@Basic( optional = true )
		@Column
		public String getCoccode() {
			return this.coccode;

		}



		 /**
		 * Set the value related to the column: coccode.
		 * @param coccode the coccode value you wish to set
		 */
		public void setCoccode(final String coccode) {
			this.coccode = coccode;
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
			String zip, GeographyTypeEnum geographyType,Export export) {
		super();
		this.id = id;
		this.informationDate = informationDate;
		this.geoCode = geoCode;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.geographyType = geographyType;
		this.export = export;
	}
	
	
	
}
