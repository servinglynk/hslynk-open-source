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


/**
 * Object mapping for hibernate-handled table: source.
 *
 *
 * @author Sandeep Dolia
 */


@Entity(name = "source")
@Table(name = "source", catalog = "hmis", schema = "live")
public class Source implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -928940189757711412L;

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
	private String export;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String softwarevendor;
	/** Field mapping. */
	private String softwareversion;
	/** Field mapping. */
	private String sourcecontactemail;
	/** Field mapping. */
	private String sourcecontactextension;
	/** Field mapping. */
	private String sourcecontactfirst;
	/** Field mapping. */
	private String sourcecontactlast;
	/** Field mapping. */
	private String sourcecontactphone;
	/** Field mapping. */
	private String sourceid;
	/** Field mapping. */
	private String sourcename;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Source() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Source(java.util.UUID id) {
		this.id = id;
	}



	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return Source.class;
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
	 * Return the value associated with the column: export.
	 * @return A String object (this.export)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getExport() {
		return this.export;

	}



	 /**
	 * Set the value related to the column: export.
	 * @param export the export value you wish to set
	 */
	public void setExport(final String export) {
		this.export = export;
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
	 * Return the value associated with the column: softwarevendor.
	 * @return A String object (this.softwarevendor)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getSoftwarevendor() {
		return this.softwarevendor;

	}



	 /**
	 * Set the value related to the column: softwarevendor.
	 * @param softwarevendor the softwarevendor value you wish to set
	 */
	public void setSoftwarevendor(final String softwarevendor) {
		this.softwarevendor = softwarevendor;
	}

	 /**
	 * Return the value associated with the column: softwareversion.
	 * @return A String object (this.softwareversion)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getSoftwareversion() {
		return this.softwareversion;

	}



	 /**
	 * Set the value related to the column: softwareversion.
	 * @param softwareversion the softwareversion value you wish to set
	 */
	public void setSoftwareversion(final String softwareversion) {
		this.softwareversion = softwareversion;
	}

	 /**
	 * Return the value associated with the column: sourcecontactemail.
	 * @return A String object (this.sourcecontactemail)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getSourcecontactemail() {
		return this.sourcecontactemail;

	}



	 /**
	 * Set the value related to the column: sourcecontactemail.
	 * @param sourcecontactemail the sourcecontactemail value you wish to set
	 */
	public void setSourcecontactemail(final String sourcecontactemail) {
		this.sourcecontactemail = sourcecontactemail;
	}

	 /**
	 * Return the value associated with the column: sourcecontactextension.
	 * @return A String object (this.sourcecontactextension)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getSourcecontactextension() {
		return this.sourcecontactextension;

	}



	 /**
	 * Set the value related to the column: sourcecontactextension.
	 * @param sourcecontactextension the sourcecontactextension value you wish to set
	 */
	public void setSourcecontactextension(final String sourcecontactextension) {
		this.sourcecontactextension = sourcecontactextension;
	}

	 /**
	 * Return the value associated with the column: sourcecontactfirst.
	 * @return A String object (this.sourcecontactfirst)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getSourcecontactfirst() {
		return this.sourcecontactfirst;

	}



	 /**
	 * Set the value related to the column: sourcecontactfirst.
	 * @param sourcecontactfirst the sourcecontactfirst value you wish to set
	 */
	public void setSourcecontactfirst(final String sourcecontactfirst) {
		this.sourcecontactfirst = sourcecontactfirst;
	}

	 /**
	 * Return the value associated with the column: sourcecontactlast.
	 * @return A String object (this.sourcecontactlast)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getSourcecontactlast() {
		return this.sourcecontactlast;

	}



	 /**
	 * Set the value related to the column: sourcecontactlast.
	 * @param sourcecontactlast the sourcecontactlast value you wish to set
	 */
	public void setSourcecontactlast(final String sourcecontactlast) {
		this.sourcecontactlast = sourcecontactlast;
	}

	 /**
	 * Return the value associated with the column: sourcecontactphone.
	 * @return A String object (this.sourcecontactphone)
	 */
	@Basic( optional = true )
	@Column( length = 12  )
	public String getSourcecontactphone() {
		return this.sourcecontactphone;

	}



	 /**
	 * Set the value related to the column: sourcecontactphone.
	 * @param sourcecontactphone the sourcecontactphone value you wish to set
	 */
	public void setSourcecontactphone(final String sourcecontactphone) {
		this.sourcecontactphone = sourcecontactphone;
	}

	 /**
	 * Return the value associated with the column: sourceid.
	 * @return A String object (this.sourceid)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getSourceid() {
		return this.sourceid;

	}



	 /**
	 * Set the value related to the column: sourceid.
	 * @param sourceid the sourceid value you wish to set
	 */
	public void setSourceid(final String sourceid) {
		this.sourceid = sourceid;
	}

	 /**
	 * Return the value associated with the column: sourcename.
	 * @return A String object (this.sourcename)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getSourcename() {
		return this.sourcename;

	}



	 /**
	 * Set the value related to the column: sourcename.
	 * @param sourcename the sourcename value you wish to set
	 */
	public void setSourcename(final String sourcename) {
		this.sourcename = sourcename;
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
    public Source clone() throws CloneNotSupportedException {

        final Source copy = (Source)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setExport(this.getExport());
		copy.setId(this.getId());
		copy.setSoftwarevendor(this.getSoftwarevendor());
		copy.setSoftwareversion(this.getSoftwareversion());
		copy.setSourcecontactemail(this.getSourcecontactemail());
		copy.setSourcecontactextension(this.getSourcecontactextension());
		copy.setSourcecontactfirst(this.getSourcecontactfirst());
		copy.setSourcecontactlast(this.getSourcecontactlast());
		copy.setSourcecontactphone(this.getSourcecontactphone());
		copy.setSourceid(this.getSourceid());
		copy.setSourcename(this.getSourcename());
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
		sb.append("export: " + this.getExport() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("softwarevendor: " + this.getSoftwarevendor() + ", ");
		sb.append("softwareversion: " + this.getSoftwareversion() + ", ");
		sb.append("sourcecontactemail: " + this.getSourcecontactemail() + ", ");
		sb.append("sourcecontactextension: " + this.getSourcecontactextension() + ", ");
		sb.append("sourcecontactfirst: " + this.getSourcecontactfirst() + ", ");
		sb.append("sourcecontactlast: " + this.getSourcecontactlast() + ", ");
		sb.append("sourcecontactphone: " + this.getSourcecontactphone() + ", ");
		sb.append("sourceid: " + this.getSourceid() + ", ");
		sb.append("sourcename: " + this.getSourcename() + ", ");
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

		final Source that;
		try {
			that = (Source) proxyThat;
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
		result = result && (((getExport() == null) && (that.getExport() == null)) || (getExport() != null && getExport().equals(that.getExport())));
		result = result && (((getSoftwarevendor() == null) && (that.getSoftwarevendor() == null)) || (getSoftwarevendor() != null && getSoftwarevendor().equals(that.getSoftwarevendor())));
		result = result && (((getSoftwareversion() == null) && (that.getSoftwareversion() == null)) || (getSoftwareversion() != null && getSoftwareversion().equals(that.getSoftwareversion())));
		result = result && (((getSourcecontactemail() == null) && (that.getSourcecontactemail() == null)) || (getSourcecontactemail() != null && getSourcecontactemail().equals(that.getSourcecontactemail())));
		result = result && (((getSourcecontactextension() == null) && (that.getSourcecontactextension() == null)) || (getSourcecontactextension() != null && getSourcecontactextension().equals(that.getSourcecontactextension())));
		result = result && (((getSourcecontactfirst() == null) && (that.getSourcecontactfirst() == null)) || (getSourcecontactfirst() != null && getSourcecontactfirst().equals(that.getSourcecontactfirst())));
		result = result && (((getSourcecontactlast() == null) && (that.getSourcecontactlast() == null)) || (getSourcecontactlast() != null && getSourcecontactlast().equals(that.getSourcecontactlast())));
		result = result && (((getSourcecontactphone() == null) && (that.getSourcecontactphone() == null)) || (getSourcecontactphone() != null && getSourcecontactphone().equals(that.getSourcecontactphone())));
		result = result && (((getSourceid() == null) && (that.getSourceid() == null)) || (getSourceid() != null && getSourceid().equals(that.getSourceid())));
		result = result && (((getSourcename() == null) && (that.getSourcename() == null)) || (getSourcename() != null && getSourcename().equals(that.getSourcename())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}

}
