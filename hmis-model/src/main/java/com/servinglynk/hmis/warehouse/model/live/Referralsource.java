package com.servinglynk.hmis.warehouse.model.live;

import java.io.Serializable;
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

import com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnum;


/**
 * Object mapping for hibernate-handled table: referralsource.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "referralsource")
@Table(name = "referralsource", catalog = "hmis", schema = "live")
public class Referralsource extends HmisBaseModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = 1161342024148964415L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private Integer countoutreachreferralapproaches;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private ReferralsourceReferralsourceEnum referralsource;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Referralsource() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Referralsource(java.util.UUID id) {
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
		return Referralsource.class;
	}


	 /**
	 * Return the value associated with the column: countoutreachreferralapproaches.
	 * @return A Integer object (this.countoutreachreferralapproaches)
	 */
	public Integer getCountoutreachreferralapproaches() {
		return this.countoutreachreferralapproaches;

	}



	 /**
	 * Set the value related to the column: countoutreachreferralapproaches.
	 * @param countoutreachreferralapproaches the countoutreachreferralapproaches value you wish to set
	 */
	public void setCountoutreachreferralapproaches(final Integer countoutreachreferralapproaches) {
		this.countoutreachreferralapproaches = countoutreachreferralapproaches;
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
	 * Return the value associated with the column: referralsource.
	 * @return A ReferralsourceReferralsourceEnum object (this.referralsource)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ReferralsourceReferralsourceEnumType")
	@Basic( optional = true )
	@Column
	public ReferralsourceReferralsourceEnum getReferralsource() {
		return this.referralsource;

	}



	 /**
	 * Set the value related to the column: referralsource.
	 * @param referralsource the referralsource value you wish to set
	 */
	public void setReferralsource(final ReferralsourceReferralsourceEnum referralsource) {
		this.referralsource = referralsource;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Referralsource clone() throws CloneNotSupportedException {

        final Referralsource copy = (Referralsource)super.clone();

		copy.setCountoutreachreferralapproaches(this.getCountoutreachreferralapproaches());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setReferralsource(this.getReferralsource());
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

		sb.append("countoutreachreferralapproaches: " + this.getCountoutreachreferralapproaches() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("referralsource: " + this.getReferralsource() + ", ");
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

		final Referralsource that;
		try {
			that = (Referralsource) proxyThat;
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
		result = result && (((getCountoutreachreferralapproaches() == null) && (that.getCountoutreachreferralapproaches() == null)) || (getCountoutreachreferralapproaches() != null && getCountoutreachreferralapproaches().equals(that.getCountoutreachreferralapproaches())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getReferralsource() == null) && (that.getReferralsource() == null)) || (getReferralsource() != null && getReferralsource().equals(that.getReferralsource())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}


}
