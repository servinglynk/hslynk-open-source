package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnum;
import com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnum;

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
 * Object mapping for hibernate-handled table: medicalassistance.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "medicalassistance")
@Table(name = "medicalassistance", catalog = "hmis", schema = "live")
public class Medicalassistance implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = -2018797611075738704L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private MedicalassistanceAdapEnum adap;
	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private MedicalassistanceHivaidsassistanceEnum hivaidsassistance;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private MedicalassistanceNoadapreasonEnum noadapreason;
	/** Field mapping. */
	private MedicalassistanceNohivaidsassistancereasonEnum nohivaidsassistancereason;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Medicalassistance() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Medicalassistance(java.util.UUID id) {
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
		return Medicalassistance.class;
	}


	 /**
	 * Return the value associated with the column: adap.
	 * @return A MedicalassistanceAdapEnum object (this.adap)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.MedicalassistanceAdapEnumType")
	@Basic( optional = true )
	@Column
	public MedicalassistanceAdapEnum getAdap() {
		return this.adap;

	}



	 /**
	 * Set the value related to the column: adap.
	 * @param adap the adap value you wish to set
	 */
	public void setAdap(final MedicalassistanceAdapEnum adap) {
		this.adap = adap;
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
	 * Return the value associated with the column: hivaidsassistance.
	 * @return A MedicalassistanceHivaidsassistanceEnum object (this.hivaidsassistance)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.MedicalassistanceHivaidsassistanceEnumType")
	@Basic( optional = true )
	@Column
	public MedicalassistanceHivaidsassistanceEnum getHivaidsassistance() {
		return this.hivaidsassistance;

	}



	 /**
	 * Set the value related to the column: hivaidsassistance.
	 * @param hivaidsassistance the hivaidsassistance value you wish to set
	 */
	public void setHivaidsassistance(final MedicalassistanceHivaidsassistanceEnum hivaidsassistance) {
		this.hivaidsassistance = hivaidsassistance;
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
	 * Return the value associated with the column: noadapreason.
	 * @return A MedicalassistanceNoadapreasonEnum object (this.noadapreason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.MedicalassistanceNoadapreasonEnumType")
	@Basic( optional = true )
	@Column
	public MedicalassistanceNoadapreasonEnum getNoadapreason() {
		return this.noadapreason;

	}



	 /**
	 * Set the value related to the column: noadapreason.
	 * @param noadapreason the noadapreason value you wish to set
	 */
	public void setNoadapreason(final MedicalassistanceNoadapreasonEnum noadapreason) {
		this.noadapreason = noadapreason;
	}

	 /**
	 * Return the value associated with the column: nohivaidsassistancereason.
	 * @return A MedicalassistanceNohivaidsassistancereasonEnum object (this.nohivaidsassistancereason)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.MedicalassistanceNohivaidsassistancereasonEnumType")
	@Basic( optional = true )
	@Column
	public MedicalassistanceNohivaidsassistancereasonEnum getNohivaidsassistancereason() {
		return this.nohivaidsassistancereason;

	}



	 /**
	 * Set the value related to the column: nohivaidsassistancereason.
	 * @param nohivaidsassistancereason the nohivaidsassistancereason value you wish to set
	 */
	public void setNohivaidsassistancereason(final MedicalassistanceNohivaidsassistancereasonEnum nohivaidsassistancereason) {
		this.nohivaidsassistancereason = nohivaidsassistancereason;
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
    public Medicalassistance clone() throws CloneNotSupportedException {

        final Medicalassistance copy = (Medicalassistance)super.clone();

		copy.setAdap(this.getAdap());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setHivaidsassistance(this.getHivaidsassistance());
		copy.setId(this.getId());
		copy.setNoadapreason(this.getNoadapreason());
		copy.setNohivaidsassistancereason(this.getNohivaidsassistancereason());
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

		sb.append("adap: " + this.getAdap() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("hivaidsassistance: " + this.getHivaidsassistance() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("noadapreason: " + this.getNoadapreason() + ", ");
		sb.append("nohivaidsassistancereason: " + this.getNohivaidsassistancereason() + ", ");
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

		final Medicalassistance that;
		try {
			that = (Medicalassistance) proxyThat;
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
		result = result && (((getAdap() == null) && (that.getAdap() == null)) || (getAdap() != null && getAdap().equals(that.getAdap())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getHivaidsassistance() == null) && (that.getHivaidsassistance() == null)) || (getHivaidsassistance() != null && getHivaidsassistance().equals(that.getHivaidsassistance())));
		result = result && (((getNoadapreason() == null) && (that.getNoadapreason() == null)) || (getNoadapreason() != null && getNoadapreason().equals(that.getNoadapreason())));
		result = result && (((getNohivaidsassistancereason() == null) && (that.getNohivaidsassistancereason() == null)) || (getNohivaidsassistancereason() != null && getNohivaidsassistancereason().equals(that.getNohivaidsassistancereason())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}
}
