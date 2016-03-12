package com.servinglynk.hmis.warehouse.model.live;

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

import com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnum;
import com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnum;


/**
 * Object mapping for hibernate-handled table: services.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "services")
@Table(name = "services", catalog = "hmis", schema = "v2014")
public class Services extends HmisBaseModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = -7410093721624490210L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private LocalDateTime dateprovided;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.math.BigDecimal faamount;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String othertypeprovided;
	/** Field mapping. */
	private ServicesRecordtypeEnum recordtype;
	/** Field mapping. */
	private ServicesReferraloutcomeEnum referraloutcome;
	/** Field mapping. */
	private Integer subtypeprovided;
	/** Field mapping. */
	private Integer typeprovided;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Services() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Services(java.util.UUID id) {
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
		return Services.class;
	}


	 /**
	 * Return the value associated with the column: dateprovided.
	 * @return A LocalDateTime object (this.dateprovided)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column
	public LocalDateTime getDateprovided() {
		return this.dateprovided;

	}



	 /**
	 * Set the value related to the column: dateprovided.
	 * @param dateprovided the dateprovided value you wish to set
	 */
	public void setDateprovided(final LocalDateTime dateprovided) {
		this.dateprovided = dateprovided;
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
	 * Return the value associated with the column: faamount.
	 * @return A Double object (this.faamount)
	 */
	public java.math.BigDecimal getFaamount() {
		return this.faamount;

	}



	 /**
	 * Set the value related to the column: faamount.
	 * @param faamount the faamount value you wish to set
	 */
	public void setFaamount(final java.math.BigDecimal faamount) {
		this.faamount = faamount;
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
	 * Return the value associated with the column: othertypeprovided.
	 * @return A String object (this.othertypeprovided)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getOthertypeprovided() {
		return this.othertypeprovided;

	}



	 /**
	 * Set the value related to the column: othertypeprovided.
	 * @param othertypeprovided the othertypeprovided value you wish to set
	 */
	public void setOthertypeprovided(final String othertypeprovided) {
		this.othertypeprovided = othertypeprovided;
	}

	 /**
	 * Return the value associated with the column: recordtype.
	 * @return A ServicesRecordtypeEnum object (this.recordtype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ServicesRecordtypeEnumType")
	@Basic( optional = true )
	@Column
	public ServicesRecordtypeEnum getRecordtype() {
		return this.recordtype;

	}



	 /**
	 * Set the value related to the column: recordtype.
	 * @param recordtype the recordtype value you wish to set
	 */
	public void setRecordtype(final ServicesRecordtypeEnum recordtype) {
		this.recordtype = recordtype;
	}

	 /**
	 * Return the value associated with the column: referraloutcome.
	 * @return A ServicesReferraloutcomeEnum object (this.referraloutcome)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ServicesReferraloutcomeEnumType")
	@Basic( optional = true )
	@Column
	public ServicesReferraloutcomeEnum getReferraloutcome() {
		return this.referraloutcome;

	}



	 /**
	 * Set the value related to the column: referraloutcome.
	 * @param referraloutcome the referraloutcome value you wish to set
	 */
	public void setReferraloutcome(final ServicesReferraloutcomeEnum referraloutcome) {
		this.referraloutcome = referraloutcome;
	}

	 /**
	 * Return the value associated with the column: subtypeprovided.
	 * @return A Integer object (this.subtypeprovided)
	 */
	public Integer getSubtypeprovided() {
		return this.subtypeprovided;

	}



	 /**
	 * Set the value related to the column: subtypeprovided.
	 * @param subtypeprovided the subtypeprovided value you wish to set
	 */
	public void setSubtypeprovided(final Integer subtypeprovided) {
		this.subtypeprovided = subtypeprovided;
	}

	 /**
	 * Return the value associated with the column: typeprovided.
	 * @return A Integer object (this.typeprovided)
	 */
	public Integer getTypeprovided() {
		return this.typeprovided;

	}



	 /**
	 * Set the value related to the column: typeprovided.
	 * @param typeprovided the typeprovided value you wish to set
	 */
	public void setTypeprovided(final Integer typeprovided) {
		this.typeprovided = typeprovided;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Services clone() throws CloneNotSupportedException {

        final Services copy = (Services)super.clone();

		copy.setDateprovided(this.getDateprovided());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setFaamount(this.getFaamount());
		copy.setId(this.getId());
		copy.setOthertypeprovided(this.getOthertypeprovided());
		copy.setRecordtype(this.getRecordtype());
		copy.setReferraloutcome(this.getReferraloutcome());
		copy.setSubtypeprovided(this.getSubtypeprovided());
		copy.setTypeprovided(this.getTypeprovided());
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

		sb.append("dateprovided: " + this.getDateprovided() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("faamount: " + this.getFaamount() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("othertypeprovided: " + this.getOthertypeprovided() + ", ");
		sb.append("recordtype: " + this.getRecordtype() + ", ");
		sb.append("referraloutcome: " + this.getReferraloutcome() + ", ");
		sb.append("subtypeprovided: " + this.getSubtypeprovided() + ", ");
		sb.append("typeprovided: " + this.getTypeprovided() + ", ");
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

		final Services that;
		try {
			that = (Services) proxyThat;
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
		result = result && (((getDateprovided() == null) && (that.getDateprovided() == null)) || (getDateprovided() != null && getDateprovided().equals(that.getDateprovided())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getFaamount() == null) && (that.getFaamount() == null)) || (getFaamount() != null && getFaamount().equals(that.getFaamount())));
		result = result && (((getOthertypeprovided() == null) && (that.getOthertypeprovided() == null)) || (getOthertypeprovided() != null && getOthertypeprovided().equals(that.getOthertypeprovided())));
		result = result && (((getRecordtype() == null) && (that.getRecordtype() == null)) || (getRecordtype() != null && getRecordtype().equals(that.getRecordtype())));
		result = result && (((getReferraloutcome() == null) && (that.getReferraloutcome() == null)) || (getReferraloutcome() != null && getReferraloutcome().equals(that.getReferraloutcome())));
		result = result && (((getSubtypeprovided() == null) && (that.getSubtypeprovided() == null)) || (getSubtypeprovided() != null && getSubtypeprovided().equals(that.getSubtypeprovided())));
		result = result && (((getTypeprovided() == null) && (that.getTypeprovided() == null)) || (getTypeprovided() != null && getTypeprovided().equals(that.getTypeprovided())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		return result;
	}

}
