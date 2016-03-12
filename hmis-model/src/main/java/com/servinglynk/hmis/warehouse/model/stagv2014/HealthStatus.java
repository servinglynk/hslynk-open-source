package com.servinglynk.hmis.warehouse.model.stagv2014;

import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnum;
import com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;

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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: health_status.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "health_status_staging")
@Table(name = "health_status", catalog = "hmis", schema = "stagv2014")
public class HealthStatus extends HmisBaseStagingModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 903091481736147622L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private LocalDateTime dueDate;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private HealthStatusHealthCategoryEnum healthCategory;
	/** Field mapping. */
	private HealthStatusHealthStatusEnum healthStatus;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private LocalDateTime informationDate;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public HealthStatus() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public HealthStatus(java.util.UUID id) {
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
		return HealthStatus.class;
	}
 


	 /**
	 * Return the value associated with the column: dueDate.
	 * @return A LocalDateTime object (this.dueDate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "due_date"  )
	public LocalDateTime getDueDate() {
		return this.dueDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: dueDate.
	 * @param dueDate the dueDate value you wish to set
	 */
	public void setDueDate(final LocalDateTime dueDate) {
		this.dueDate = dueDate;
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
	 * Return the value associated with the column: healthCategory.
	 * @return A HealthStatusHealthCategoryEnum object (this.healthCategory)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthStatusHealthCategoryEnumType")
	@Basic( optional = true )
	@Column( name = "health_category"  )
	public HealthStatusHealthCategoryEnum getHealthCategory() {
		return this.healthCategory;
		
	}
	

  
	 /**  
	 * Set the value related to the column: healthCategory.
	 * @param healthCategory the healthCategory value you wish to set
	 */
	public void setHealthCategory(final HealthStatusHealthCategoryEnum healthCategory) {
		this.healthCategory = healthCategory;
	}

	 /**
	 * Return the value associated with the column: healthStatus.
	 * @return A HealthStatusHealthStatusEnum object (this.healthStatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.HealthStatusHealthStatusEnumType")
	@Basic( optional = true )
	@Column( name = "health_status"  )
	public HealthStatusHealthStatusEnum getHealthStatus() {
		return this.healthStatus;
		
	}
	

  
	 /**  
	 * Set the value related to the column: healthStatus.
	 * @param healthStatus the healthStatus value you wish to set
	 */
	public void setHealthStatus(final HealthStatusHealthStatusEnum healthStatus) {
		this.healthStatus = healthStatus;
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
	 * Return the value associated with the column: informationDate.
	 * @return A LocalDateTime object (this.informationDate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "information_date"  )
	public LocalDateTime getInformationDate() {
		return this.informationDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: informationDate.
	 * @param informationDate the informationDate value you wish to set
	 */
	public void setInformationDate(final LocalDateTime informationDate) {
		this.informationDate = informationDate;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public HealthStatus clone() throws CloneNotSupportedException {
		
        final HealthStatus copy = (HealthStatus)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDueDate(this.getDueDate());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setHealthCategory(this.getHealthCategory());
		copy.setHealthStatus(this.getHealthStatus());
		copy.setId(this.getId());
		copy.setInformationDate(this.getInformationDate());
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
		sb.append("dueDate: " + this.getDueDate() + ", ");
		sb.append("healthCategory: " + this.getHealthCategory() + ", ");
		sb.append("healthStatus: " + this.getHealthStatus() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("informationDate: " + this.getInformationDate() + ", ");
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
		
		final HealthStatus that; 
		try {
			that = (HealthStatus) proxyThat;
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
		result = result && (((getDueDate() == null) && (that.getDueDate() == null)) || (getDueDate() != null && getDueDate().equals(that.getDueDate())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getHealthCategory() == null) && (that.getHealthCategory() == null)) || (getHealthCategory() != null && getHealthCategory().equals(that.getHealthCategory())));
		result = result && (((getHealthStatus() == null) && (that.getHealthStatus() == null)) || (getHealthStatus() != null && getHealthStatus().equals(that.getHealthStatus())));
		result = result && (((getInformationDate() == null) && (that.getInformationDate() == null)) || (getInformationDate() != null && getInformationDate().equals(that.getInformationDate())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));	
		return result;
	}
}
