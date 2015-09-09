package com.servinglynk.hmis.warehouse.model.staging;

import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeJuvenilejusticeyearsEnum;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: formerwardjuvenilejustice.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "formerwardjuvenilejustice_staging")
@Table(name = "formerwardjuvenilejustice", catalog = "hmis", schema = "staging")
public class Formerwardjuvenilejustice implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -7647221928717238272L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum formerwardjuvenilejustice;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Integer juvenilejusticemonths;
	/** Field mapping. */
	private FormerwardjuvenilejusticeJuvenilejusticeyearsEnum juvenilejusticeyears;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Formerwardjuvenilejustice() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Formerwardjuvenilejustice(java.util.UUID id) {
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
		return Formerwardjuvenilejustice.class;
	}
 

	 /**
	 * Return the value associated with the column: dateCreated.
	 * @return A LocalDate object (this.dateCreated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column( name = "date_created"  )
	public LocalDate getDateCreated() {
		return this.dateCreated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateCreated.
	 * @param dateCreated the dateCreated value you wish to set
	 */
	public void setDateCreated(final LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	 /**
	 * Return the value associated with the column: dateUpdated.
	 * @return A LocalDate object (this.dateUpdated)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column( name = "date_updated"  )
	public LocalDate getDateUpdated() {
		return this.dateUpdated;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dateUpdated.
	 * @param dateUpdated the dateUpdated value you wish to set
	 */
	public void setDateUpdated(final LocalDate dateUpdated) {
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
	 * Return the value associated with the column: formerwardjuvenilejustice.
	 * @return A FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum object (this.formerwardjuvenilejustice)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnumType")
	@Basic( optional = true )
	@Column
	public FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum getFormerwardjuvenilejustice() {
		return this.formerwardjuvenilejustice;
		
	}
	

  
	 /**  
	 * Set the value related to the column: formerwardjuvenilejustice.
	 * @param formerwardjuvenilejustice the formerwardjuvenilejustice value you wish to set
	 */
	public void setFormerwardjuvenilejustice(final FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum formerwardjuvenilejustice) {
		this.formerwardjuvenilejustice = formerwardjuvenilejustice;
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
	 * Return the value associated with the column: juvenilejusticemonths.
	 * @return A Integer object (this.juvenilejusticemonths)
	 */
	public Integer getJuvenilejusticemonths() {
		return this.juvenilejusticemonths;
		
	}
	

  
	 /**  
	 * Set the value related to the column: juvenilejusticemonths.
	 * @param juvenilejusticemonths the juvenilejusticemonths value you wish to set
	 */
	public void setJuvenilejusticemonths(final Integer juvenilejusticemonths) {
		this.juvenilejusticemonths = juvenilejusticemonths;
	}

	 /**
	 * Return the value associated with the column: juvenilejusticeyears.
	 * @return A FormerwardjuvenilejusticeJuvenilejusticeyearsEnum object (this.juvenilejusticeyears)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeJuvenilejusticeyearsEnumType")
	@Basic( optional = true )
	@Column
	public FormerwardjuvenilejusticeJuvenilejusticeyearsEnum getJuvenilejusticeyears() {
		return this.juvenilejusticeyears;
		
	}
	

  
	 /**  
	 * Set the value related to the column: juvenilejusticeyears.
	 * @param juvenilejusticeyears the juvenilejusticeyears value you wish to set
	 */
	public void setJuvenilejusticeyears(final FormerwardjuvenilejusticeJuvenilejusticeyearsEnum juvenilejusticeyears) {
		this.juvenilejusticeyears = juvenilejusticeyears;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Formerwardjuvenilejustice clone() throws CloneNotSupportedException {
		
        final Formerwardjuvenilejustice copy = (Formerwardjuvenilejustice)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setFormerwardjuvenilejustice(this.getFormerwardjuvenilejustice());
		copy.setId(this.getId());
		copy.setJuvenilejusticemonths(this.getJuvenilejusticemonths());
		copy.setJuvenilejusticeyears(this.getJuvenilejusticeyears());
		copy.setUser(this.getUser());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("formerwardjuvenilejustice: " + this.getFormerwardjuvenilejustice() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("juvenilejusticemonths: " + this.getJuvenilejusticemonths() + ", ");
		sb.append("juvenilejusticeyears: " + this.getJuvenilejusticeyears() + ", ");
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
		
		final Formerwardjuvenilejustice that; 
		try {
			that = (Formerwardjuvenilejustice) proxyThat;
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
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getFormerwardjuvenilejustice() == null) && (that.getFormerwardjuvenilejustice() == null)) || (getFormerwardjuvenilejustice() != null && getFormerwardjuvenilejustice().equals(that.getFormerwardjuvenilejustice())));
		result = result && (((getJuvenilejusticemonths() == null) && (that.getJuvenilejusticemonths() == null)) || (getJuvenilejusticemonths() != null && getJuvenilejusticemonths().equals(that.getJuvenilejusticemonths())));
		result = result && (((getJuvenilejusticeyears() == null) && (that.getJuvenilejusticeyears() == null)) || (getJuvenilejusticeyears() != null && getJuvenilejusticeyears().equals(that.getJuvenilejusticeyears())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		return result;
	}
}
