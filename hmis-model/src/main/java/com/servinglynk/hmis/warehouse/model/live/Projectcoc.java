package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.model.live.Inventory;
import com.servinglynk.hmis.warehouse.model.live.Site;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: projectcoc.
 *
 *
 * @author Sandeep Dolia
 */


@Entity(name = "projectcoc")
@Table(name = "projectcoc", catalog = "hmis", schema = "v2014")
public class Projectcoc extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 6488195069713059339L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private String coccode;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Set<Inventory> inventories = new HashSet<Inventory>();

	/** Field mapping. */
	private Project projectid;
	/** Field mapping. */
	private Set<Site> sites = new HashSet<Site>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Projectcoc() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Projectcoc(java.util.UUID id) {
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
		return Projectcoc.class;
	}


	 /**
	 * Return the value associated with the column: coccode.
	 * @return A String object (this.coccode)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getCoccode() {
		return this.coccode;

	}



	 /**
	 * Set the value related to the column: coccode.
	 * @param coccode the coccode value you wish to set
	 */
	public void setCoccode(final String coccode) {
		this.coccode = coccode;
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
	 * Return the value associated with the column: inventory.
	 * @return A Set&lt;Inventory&gt; object (this.inventory)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projectCoc"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Inventory> getInventories() {
		return this.inventories;

	}

	/**
	 * Adds a bi-directional link of type Inventory to the inventories set.
	 * @param inventory item to add
	 */
	public void addInventory(Inventory inventory) {
		inventory.setProjectCoc(this);
		this.inventories.add(inventory);
	}


	 /**
	 * Set the value related to the column: inventory.
	 * @param inventory the inventory value you wish to set
	 */
	public void setInventories(final Set<Inventory> inventory) {
		this.inventories = inventory;
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
	 * Return the value associated with the column: site.
	 * @return A Set&lt;Site&gt; object (this.site)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projectCoc"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Site> getSites() {
		return this.sites;

	}

	/**
	 * Adds a bi-directional link of type Site to the sites set.
	 * @param site item to add
	 */
	public void addSite(Site site) {
		site.setProjectCoc(this);
		this.sites.add(site);
	}


	 /**
	 * Set the value related to the column: site.
	 * @param site the site value you wish to set
	 */
	public void setSites(final Set<Site> site) {
		this.sites = site;
	}



   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Projectcoc clone() throws CloneNotSupportedException {

        final Projectcoc copy = (Projectcoc)super.clone();

		copy.setCoccode(this.getCoccode());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setId(this.getId());
		if (this.getInventories() != null) {
			copy.getInventories().addAll(this.getInventories());
		}
		copy.setProjectid(this.getProjectid());
		if (this.getSites() != null) {
			copy.getSites().addAll(this.getSites());
		}
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

		sb.append("coccode: " + this.getCoccode() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
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

		final Projectcoc that;
		try {
			that = (Projectcoc) proxyThat;
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
		result = result && (((getCoccode() == null) && (that.getCoccode() == null)) || (getCoccode() != null && getCoccode().equals(that.getCoccode())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getProjectid() == null) && (that.getProjectid() == null)) || (getProjectid() != null && getProjectid().getId().equals(that.getProjectid().getId())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		return result;
	}

}
