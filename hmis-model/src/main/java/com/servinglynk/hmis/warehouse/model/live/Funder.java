package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.FunderFunderEnum;

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
 * Object mapping for hibernate-handled table: funder.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "funder")
@Table(name = "funder", catalog = "hmis", schema = "live")
public class Funder implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 3130486567455571039L;

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
	private LocalDate enddate;
	/** Field mapping. */
	private FunderFunderEnum funder;
	/** Field mapping. */
	private java.util.UUID grantid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Project projectid;
	/** Field mapping. */
	private LocalDate startdate;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Funder() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Funder(java.util.UUID id) {
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
		return Funder.class;
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
	 * Return the value associated with the column: enddate.
	 * @return A LocalDate object (this.enddate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column
	public LocalDate getEnddate() {
		return this.enddate;

	}



	 /**
	 * Set the value related to the column: enddate.
	 * @param enddate the enddate value you wish to set
	 */
	public void setEnddate(final LocalDate enddate) {
		this.enddate = enddate;
	}

	 /**
	 * Return the value associated with the column: funder.
	 * @return A FunderFunderEnum object (this.funder)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.FunderFunderEnumType")
	@Basic( optional = true )
	@Column
	public FunderFunderEnum getFunder() {
		return this.funder;

	}



	 /**
	 * Set the value related to the column: funder.
	 * @param funder the funder value you wish to set
	 */
	public void setFunder(final FunderFunderEnum funder) {
		this.funder = funder;
	}

	 /**
	 * Return the value associated with the column: grantid.
	 * @return A java.util.UUID object (this.grantid)
	 */
	@Basic( optional = true )
	@org.hibernate.annotations.Type(type="pg-uuid")
	public java.util.UUID getGrantid() {
		return this.grantid;

	}



	 /**
	 * Set the value related to the column: grantid.
	 * @param grantid the grantid value you wish to set
	 */
	public void setGrantid(final java.util.UUID grantid) {
		this.grantid = grantid;
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
	 * Return the value associated with the column: projectid.
	 * @return A Project object (this.projectid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "projectid", nullable = true )
	public Project getProjectid() {
		return this.projectid;

	}



	 /**
	 * Set the value related to the column: projectid.
	 * @param projectid the projectid value you wish to set
	 */
	public void setProjectid(final Project projectid) {
		this.projectid = projectid;
	}

	 /**
	 * Return the value associated with the column: startdate.
	 * @return A LocalDate object (this.startdate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	@Basic( optional = true )
	@Column
	public LocalDate getStartdate() {
		return this.startdate;

	}



	 /**
	 * Set the value related to the column: startdate.
	 * @param startdate the startdate value you wish to set
	 */
	public void setStartdate(final LocalDate startdate) {
		this.startdate = startdate;
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
    public Funder clone() throws CloneNotSupportedException {

        final Funder copy = (Funder)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnddate(this.getEnddate());
		copy.setFunder(this.getFunder());
		copy.setGrantid(this.getGrantid());
		copy.setId(this.getId());
		copy.setProjectid(this.getProjectid());
		copy.setStartdate(this.getStartdate());
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
		sb.append("enddate: " + this.getEnddate() + ", ");
		sb.append("funder: " + this.getFunder() + ", ");
		sb.append("grantid: " + this.getGrantid() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("startdate: " + this.getStartdate() + ", ");
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

		final Funder that;
		try {
			that = (Funder) proxyThat;
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
		result = result && (((getEnddate() == null) && (that.getEnddate() == null)) || (getEnddate() != null && getEnddate().equals(that.getEnddate())));
		result = result && (((getFunder() == null) && (that.getFunder() == null)) || (getFunder() != null && getFunder().equals(that.getFunder())));
		result = result && (((getGrantid() == null) && (that.getGrantid() == null)) || (getGrantid() != null && getGrantid().equals(that.getGrantid())));
		result = result && (((getProjectid() == null) && (that.getProjectid() == null)) || (getProjectid() != null && getProjectid().getId().equals(that.getProjectid().getId())));
		result = result && (((getStartdate() == null) && (that.getStartdate() == null)) || (getStartdate() != null && getStartdate().equals(that.getStartdate())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}

}
