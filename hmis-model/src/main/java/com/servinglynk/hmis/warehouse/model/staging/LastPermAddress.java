package com.servinglynk.hmis.warehouse.model.staging;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;

import com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnum;
import com.servinglynk.hmis.warehouse.enums.StateEnum;


/** 
 * Object mapping for hibernate-handled table: last_perm_address.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "last_perm_address_staging")
@Table(name = "last_perm_address", catalog = "hmis", schema = "staging")
public class LastPermAddress implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 1955232390265692952L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private LastPermAddressAddressDataQualityEnum addressDataQuality;
	/** Field mapping. */
	private String city;
	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private StateEnum state;
	/** Field mapping. */
	private String street;
	/** Field mapping. */
	private HmisUser user;
	/** Field mapping. */
	private String zip;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public LastPermAddress() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public LastPermAddress(java.util.UUID id) {
		this.id = id;
	}
	

	 
	/** Field mapping. */
	private Export export;
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



 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return LastPermAddress.class;
	}
 

	 /**
	 * Return the value associated with the column: addressDataQuality.
	 * @return A LastPermAddressAddressDataQualityEnum object (this.addressDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.LastPermAddressAddressDataQualityEnumType")
	@Basic( optional = true )
	@Column( name = "address_data_quality"  )
	public LastPermAddressAddressDataQualityEnum getAddressDataQuality() {
		return this.addressDataQuality;
		
	}
	

  
	 /**  
	 * Set the value related to the column: addressDataQuality.
	 * @param addressDataQuality the addressDataQuality value you wish to set
	 */
	public void setAddressDataQuality(final LastPermAddressAddressDataQualityEnum addressDataQuality) {
		this.addressDataQuality = addressDataQuality;
	}

	 /**
	 * Return the value associated with the column: city.
	 * @return A String object (this.city)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getCity() {
		return this.city;
		
	}
	

  
	 /**  
	 * Set the value related to the column: city.
	 * @param city the city value you wish to set
	 */
	public void setCity(final String city) {
		this.city = city;
	}

	 /**
	 * Return the value associated with the column: dateCreated.
	 * @return A LocalDateTime object (this.dateCreated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "date_created"  )
	public LocalDateTime getDateCreated() {
		return this.dateCreated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateCreated.
	 * @param dateCreated the dateCreated value you wish to set
	 */
	public void setDateCreated(final LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	 /**
	 * Return the value associated with the column: dateUpdated.
	 * @return A LocalDateTime object (this.dateUpdated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "date_updated"  )
	public LocalDateTime getDateUpdated() {
		return this.dateUpdated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateUpdated.
	 * @param dateUpdated the dateUpdated value you wish to set
	 */
	public void setDateUpdated(final LocalDateTime dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	 /**
	 * Return the value associated with the column: enrollmentid.
	 * @return A Enrollment object (this.enrollmentid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "enrollmentid", nullable = true )
	public Enrollment getEnrollmentid() {
		return this.enrollmentid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: enrollmentid.
	 * @param enrollmentid the enrollmentid value you wish to set
	 */
	public void setEnrollmentid(final Enrollment enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */
    @Id 
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final java.util.UUID id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null ) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	/**
	 * Return the value associated with the column: addressDataQuality.
	 * @return A StateEnum object (this.addressDataQuality)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.StateEnumType")
	@Basic( optional = true )
	@Column( name = "state"  )
	public StateEnum getState() {
		return this.state;
		
	}
	

  
	 /**  
	 * Set the value related to the column: addressDataQuality.
	 * @param addressDataQuality the addressDataQuality value you wish to set
	 */
	public void setState(final StateEnum state) {
		this.state = state;
	}


	 /**
	 * Return the value associated with the column: street.
	 * @return A String object (this.street)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getStreet() {
		return this.street;
		
	}
	

  
	 /**  
	 * Set the value related to the column: street.
	 * @param street the street value you wish to set
	 */
	public void setStreet(final String street) {
		this.street = street;
	}

	 /**
	 * Return the value associated with the column: user.
	 * @return A HmisUser object (this.user)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "user_id", nullable = true )
	public HmisUser getUser() {
		return this.user;
		
	}
	

  
	 /**  
	 * Set the value related to the column: user.
	 * @param user the user value you wish to set
	 */
	public void setUser(final HmisUser user) {
		this.user = user;
	}

	 /**
	 * Return the value associated with the column: zip.
	 * @return A String object (this.zip)
	 */
	@Basic( optional = true )
	@Column( length = 10  )
	public String getZip() {
		return this.zip;
		
	}
	

  
	 /**  
	 * Set the value related to the column: zip.
	 * @param zip the zip value you wish to set
	 */
	public void setZip(final String zip) {
		this.zip = zip;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public LastPermAddress clone() throws CloneNotSupportedException {
		
        final LastPermAddress copy = (LastPermAddress)super.clone();

		copy.setAddressDataQuality(this.getAddressDataQuality());
		copy.setCity(this.getCity());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setState(this.getState());
		copy.setStreet(this.getStreet());
		copy.setUser(this.getUser());
		copy.setZip(this.getZip());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("addressDataQuality: " + this.getAddressDataQuality() + ", ");
		sb.append("city: " + this.getCity() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("state: " + this.getState() + ", ");
		sb.append("street: " + this.getStreet() + ", ");
		sb.append("zip: " + this.getZip());
		return sb.toString();		
	}


	/** Equals implementation. 
	 * @see java.lang.Object#equals(java.lang.Object)
	 * @param aThat Object to compare with
	 * @return true/false
	 */
	@Override
	public boolean equals(final Object aThat) {
		Object proxyThat = aThat;
		
		if ( this == aThat ) {
			 return true;
		}

		
		if (aThat instanceof HibernateProxy) {
 			// narrow down the proxy to the class we are dealing with.
 			try {
				proxyThat = ((HibernateProxy) aThat).getHibernateLazyInitializer().getImplementation(); 
			} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		   	}
		}
		if (aThat == null)  {
			 return false;
		}
		
		final LastPermAddress that; 
		try {
			that = (LastPermAddress) proxyThat;
			if ( !(that.getClassType().equals(this.getClassType()))){
				return false;
			}
		} catch (org.hibernate.ObjectNotFoundException e) {
				return false;
		} catch (ClassCastException e) {
				return false;
		}
		
		
		boolean result = true;
		result = result && (((this.getId() == null) && ( that.getId() == null)) || (this.getId() != null  && this.getId().equals(that.getId())));
		result = result && (((getAddressDataQuality() == null) && (that.getAddressDataQuality() == null)) || (getAddressDataQuality() != null && getAddressDataQuality().equals(that.getAddressDataQuality())));
		result = result && (((getCity() == null) && (that.getCity() == null)) || (getCity() != null && getCity().equals(that.getCity())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getState() == null) && (that.getState() == null)) || (getState() != null && getState().equals(that.getState())));
		result = result && (((getStreet() == null) && (that.getStreet() == null)) || (getStreet() != null && getStreet().equals(that.getStreet())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		result = result && (((getZip() == null) && (that.getZip() == null)) || (getZip() != null && getZip().equals(that.getZip())));
		return result;
	}
}
