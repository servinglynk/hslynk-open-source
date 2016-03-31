package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: organization.
 *
 *
 * @author Sandeep Dolia
 */


@Entity
@Table(name = "hmis_organization",schema="base")
public class OrganizationEntity extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -2976219126219903102L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String organizationcommonname;
	/** Field mapping. */
	private String organizationname;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public OrganizationEntity() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public OrganizationEntity(java.util.UUID id) {
		this.id = id;
	}


	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return OrganizationEntity.class;
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
	 * Return the value associated with the column: organizationcommonname.
	 * @return A String object (this.organizationcommonname)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getOrganizationcommonname() {
		return this.organizationcommonname;

	}

	 /**
	 * Set the value related to the column: organizationcommonname.
	 * @param organizationcommonname the organizationcommonname value you wish to set
	 */
	public void setOrganizationcommonname(final String organizationcommonname) {
		this.organizationcommonname = organizationcommonname;
	}

	 /**
	 * Return the value associated with the column: organizationname.
	 * @return A String object (this.organizationname)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getOrganizationname() {
		return this.organizationname;

	}



	 /**
	 * Set the value related to the column: organizationname.
	 * @param organizationname the organizationname value you wish to set
	 */
	public void setOrganizationname(final String organizationname) {
		this.organizationname = organizationname;
	}

	
   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public OrganizationEntity clone() throws CloneNotSupportedException {

        final OrganizationEntity copy = (OrganizationEntity)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setId(this.getId());
		copy.setOrganizationcommonname(this.getOrganizationcommonname());
		copy.setOrganizationname(this.getOrganizationname());
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
		sb.append("id: " + this.getId() + ", ");
		sb.append("organizationcommonname: " + this.getOrganizationcommonname() + ", ");
		sb.append("organizationname: " + this.getOrganizationname() + ", ");
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

		final OrganizationEntity that;
		try {
			that = (OrganizationEntity) proxyThat;
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
		result = result && (((getOrganizationcommonname() == null) && (that.getOrganizationcommonname() == null)) || (getOrganizationcommonname() != null && getOrganizationcommonname().equals(that.getOrganizationcommonname())));
		result = result && (((getOrganizationname() == null) && (that.getOrganizationname() == null)) || (getOrganizationname() != null && getOrganizationname().equals(that.getOrganizationname())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}

}
