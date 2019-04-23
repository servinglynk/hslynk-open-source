package com.servinglynk.hmis.warehouse.model.v2014;

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

import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.model.EnrollmentSharingModel;


/**
 * Object mapping for hibernate-handled table: path_status.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "path_status")
@Table(name = "path_status", catalog = "hmis", schema = "v2014")
public class Pathstatus extends HmisBaseModel implements Cloneable, Serializable,EnrollmentSharingModel {

	/** Serial Version UID. */
	private static final long serialVersionUID = -3511147204684378597L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private Long clientEnrolledInPath;
	/** Field mapping. */
	private LocalDateTime dateOfStatus;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private PathstatusReasonnotenrolledEnum reasonNotEnrolled;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Pathstatus() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Pathstatus(java.util.UUID id) {
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
		return Pathstatus.class;
	}


	 /**
	 * Return the value associated with the column: clientEnrolledInPath.
	 * @return A Long object (this.clientEnrolledInPath)
	 */
	@Basic( optional = true )
	@Column( name = "client_enrolled_in_path"  )
	public Long getClientEnrolledInPath() {
		return this.clientEnrolledInPath;

	}



	 /**
	 * Set the value related to the column: clientEnrolledInPath.
	 * @param clientEnrolledInPath the clientEnrolledInPath value you wish to set
	 */
	public void setClientEnrolledInPath(final Long clientEnrolledInPath) {
		this.clientEnrolledInPath = clientEnrolledInPath;
	}


	 /**
	 * Return the value associated with the column: dateOfStatus.
	 * @return A LocalDateTime object (this.dateOfStatus)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "date_of_status"  )
	public LocalDateTime getDateOfStatus() {
		return this.dateOfStatus;

	}



	 /**
	 * Set the value related to the column: dateOfStatus.
	 * @param dateOfStatus the dateOfStatus value you wish to set
	 */
	public void setDateOfStatus(final LocalDateTime dateOfStatus) {
		this.dateOfStatus = dateOfStatus;
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
	 * Return the value associated with the column: dobDataQuality.
	 * @return A ClientDobDataQualityEnum object (this.dobDataQuality)
	 */
	@Type(type="com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnumType")
	@Basic( optional = true )
	@Column( name = "reason_not_enrolled"  )
	public PathstatusReasonnotenrolledEnum getReasonNotEnrolled() {
		return this.reasonNotEnrolled;
		
	}
	

 
	 /**  
	 * Set the value related to the column: dobDataQuality.
	 * @param dobDataQuality the dobDataQuality value you wish to set
	 */
	public void setReasonNotEnrolled(final PathstatusReasonnotenrolledEnum reasonNotEnrolled) {
		this.reasonNotEnrolled = reasonNotEnrolled;
	}
   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Pathstatus clone() throws CloneNotSupportedException {

        final Pathstatus copy = (Pathstatus)super.clone();

		copy.setClientEnrolledInPath(this.getClientEnrolledInPath());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateOfStatus(this.getDateOfStatus());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setReasonNotEnrolled(this.getReasonNotEnrolled());
		copy.setUserId(this.getUserId());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("clientEnrolledInPath: " + this.getClientEnrolledInPath() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateOfStatus: " + this.getDateOfStatus() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("reasonNotEnrolled: " + this.getReasonNotEnrolled() + ", ");
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

		final Pathstatus that;
		try {
			that = (Pathstatus) proxyThat;
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
		result = result && (((getClientEnrolledInPath() == null) && (that.getClientEnrolledInPath() == null)) || (getClientEnrolledInPath() != null && getClientEnrolledInPath().equals(that.getClientEnrolledInPath())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateOfStatus() == null) && (that.getDateOfStatus() == null)) || (getDateOfStatus() != null && getDateOfStatus().equals(that.getDateOfStatus())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getReasonNotEnrolled() == null) && (that.getReasonNotEnrolled() == null)) || (getReasonNotEnrolled() != null && getReasonNotEnrolled().equals(that.getReasonNotEnrolled())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		return result;
	}

}
