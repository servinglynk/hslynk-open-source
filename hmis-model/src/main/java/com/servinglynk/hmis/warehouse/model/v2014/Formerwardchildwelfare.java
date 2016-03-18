package com.servinglynk.hmis.warehouse.model.v2014;

import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;

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
 * Object mapping for hibernate-handled table: formerwardchildwelfare.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "formerwardchildwelfare")
@Table(name = "formerwardchildwelfare", catalog = "hmis", schema = "v2014")
public class Formerwardchildwelfare extends HmisBaseModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = -3928627256475146486L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private Integer childwelfaremonths;
	/** Field mapping. */
	private FormerwardchildwelfareChildwelfareyearsEnum childwelfareyears;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private FormerwardchildwelfareFormerwardchildwelfareEnum formerwardchildwelfare;
	/** Field mapping. */
	private java.util.UUID id;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Formerwardchildwelfare() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Formerwardchildwelfare(java.util.UUID id) {
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
		return Formerwardchildwelfare.class;
	}


	 /**
	 * Return the value associated with the column: childwelfaremonths.
	 * @return A Integer object (this.childwelfaremonths)
	 */
	public Integer getChildwelfaremonths() {
		return this.childwelfaremonths;

	}



	 /**
	 * Set the value related to the column: childwelfaremonths.
	 * @param childwelfaremonths the childwelfaremonths value you wish to set
	 */
	public void setChildwelfaremonths(final Integer childwelfaremonths) {
		this.childwelfaremonths = childwelfaremonths;
	}

	 /**
	 * Return the value associated with the column: childwelfareyears.
	 * @return A FormerwardchildwelfareChildwelfareyearsEnum object (this.childwelfareyears)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnumType")
	@Basic( optional = true )
	@Column
	public FormerwardchildwelfareChildwelfareyearsEnum getChildwelfareyears() {
		return this.childwelfareyears;

	}



	 /**
	 * Set the value related to the column: childwelfareyears.
	 * @param childwelfareyears the childwelfareyears value you wish to set
	 */
	public void setChildwelfareyears(final FormerwardchildwelfareChildwelfareyearsEnum childwelfareyears) {
		this.childwelfareyears = childwelfareyears;
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
	 * Return the value associated with the column: formerwardchildwelfare.
	 * @return A FormerwardchildwelfareFormerwardchildwelfareEnum object (this.formerwardchildwelfare)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnumType")
	@Basic( optional = true )
	@Column
	public FormerwardchildwelfareFormerwardchildwelfareEnum getFormerwardchildwelfare() {
		return this.formerwardchildwelfare;

	}



	 /**
	 * Set the value related to the column: formerwardchildwelfare.
	 * @param formerwardchildwelfare the formerwardchildwelfare value you wish to set
	 */
	public void setFormerwardchildwelfare(final FormerwardchildwelfareFormerwardchildwelfareEnum formerwardchildwelfare) {
		this.formerwardchildwelfare = formerwardchildwelfare;
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
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Formerwardchildwelfare clone() throws CloneNotSupportedException {

        final Formerwardchildwelfare copy = (Formerwardchildwelfare)super.clone();

		copy.setChildwelfaremonths(this.getChildwelfaremonths());
		copy.setChildwelfareyears(this.getChildwelfareyears());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setFormerwardchildwelfare(this.getFormerwardchildwelfare());
		copy.setId(this.getId());
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

		sb.append("childwelfaremonths: " + this.getChildwelfaremonths() + ", ");
		sb.append("childwelfareyears: " + this.getChildwelfareyears() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("formerwardchildwelfare: " + this.getFormerwardchildwelfare() + ", ");
		sb.append("id: " + this.getId() + ", ");
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

		final Formerwardchildwelfare that;
		try {
			that = (Formerwardchildwelfare) proxyThat;
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
		result = result && (((getChildwelfaremonths() == null) && (that.getChildwelfaremonths() == null)) || (getChildwelfaremonths() != null && getChildwelfaremonths().equals(that.getChildwelfaremonths())));
		result = result && (((getChildwelfareyears() == null) && (that.getChildwelfareyears() == null)) || (getChildwelfareyears() != null && getChildwelfareyears().equals(that.getChildwelfareyears())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getFormerwardchildwelfare() == null) && (that.getFormerwardchildwelfare() == null)) || (getFormerwardchildwelfare() != null && getFormerwardchildwelfare().equals(that.getFormerwardchildwelfare())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		return result;
	}

}
