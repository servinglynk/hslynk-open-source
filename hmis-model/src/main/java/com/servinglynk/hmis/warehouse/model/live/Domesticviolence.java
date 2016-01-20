package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnum;
import com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnum;

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
 * Object mapping for hibernate-handled table: domesticviolence.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "domesticviolence")
@Table(name = "domesticviolence", catalog = "hmis", schema = "live")
public class Domesticviolence extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -1553980337126312406L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private DomesticviolenceDomesticviolencevictimEnum domesticviolencevictim;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private DomesticviolenceWhenoccurredEnum whenoccurred;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Domesticviolence() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Domesticviolence(java.util.UUID id) {
		this.id = id;
	}





	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Domesticviolence.class;
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



	 /**
	 * Return the value associated with the column: domesticviolencevictim.
	 * @return A DomesticviolenceDomesticviolencevictimEnum object (this.domesticviolencevictim)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DomesticviolenceDomesticviolencevictimEnumType")
	@Basic( optional = true )
	@Column
	public DomesticviolenceDomesticviolencevictimEnum getDomesticviolencevictim() {
		return this.domesticviolencevictim;

	}



	 /**
	 * Set the value related to the column: domesticviolencevictim.
	 * @param domesticviolencevictim the domesticviolencevictim value you wish to set
	 */
	public void setDomesticviolencevictim(final DomesticviolenceDomesticviolencevictimEnum domesticviolencevictim) {
		this.domesticviolencevictim = domesticviolencevictim;
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
	 * Return the value associated with the column: whenoccurred.
	 * @return A DomesticviolenceWhenoccurredEnum object (this.whenoccurred)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DomesticviolenceWhenoccurredEnumType")
	@Basic( optional = true )
	@Column
	public DomesticviolenceWhenoccurredEnum getWhenoccurred() {
		return this.whenoccurred;

	}



	 /**
	 * Set the value related to the column: whenoccurred.
	 * @param whenoccurred the whenoccurred value you wish to set
	 */
	public void setWhenoccurred(final DomesticviolenceWhenoccurredEnum whenoccurred) {
		this.whenoccurred = whenoccurred;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Domesticviolence clone() throws CloneNotSupportedException {

        final Domesticviolence copy = (Domesticviolence)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDomesticviolencevictim(this.getDomesticviolencevictim());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setUser(this.getUser());
		copy.setWhenoccurred(this.getWhenoccurred());
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
		sb.append("domesticviolencevictim: " + this.getDomesticviolencevictim() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("whenoccurred: " + this.getWhenoccurred());
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

		final Domesticviolence that;
		try {
			that = (Domesticviolence) proxyThat;
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
		result = result && (((getDomesticviolencevictim() == null) && (that.getDomesticviolencevictim() == null)) || (getDomesticviolencevictim() != null && getDomesticviolencevictim().equals(that.getDomesticviolencevictim())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		result = result && (((getWhenoccurred() == null) && (that.getWhenoccurred() == null)) || (getWhenoccurred() != null && getWhenoccurred().equals(that.getWhenoccurred())));
		return result;
	}

}
