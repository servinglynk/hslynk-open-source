package com.servinglynk.hmis.warehouse.model.v2014;

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

import com.servinglynk.hmis.warehouse.enums.BedinventoryYouthAgeGroupEnum;


/** 
 * Object mapping for hibernate-handled table: bedinventory.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "bedinventory")
@Table(name = "bedinventory", catalog = "hmis", schema = "v2014")
public class Bedinventory  extends HmisBaseModel implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -5659967634977461140L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Integer bedInventory;
	/** Field mapping. */
	private Integer chBedInventory;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Integer vetBedInventory;
	/** Field mapping. */
	private BedinventoryYouthAgeGroupEnum youthAgeGroup;
	/** Field mapping. */
	private Long youthBedInventory;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Bedinventory() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Bedinventory(java.util.UUID id) {
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
		return Bedinventory.class;
	}
 

	 /**
	 * Return the value associated with the column: bedInventory.
	 * @return A Integer object (this.bedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "bed_inventory"  )
	public Integer getBedInventory() {
		return this.bedInventory;
		
	}
	

  
	 /**  
	 * Set the value related to the column: bedInventory.
	 * @param bedInventory the bedInventory value you wish to set
	 */
	public void setBedInventory(final Integer bedInventory) {
		this.bedInventory = bedInventory;
	}

	 /**
	 * Return the value associated with the column: chBedInventory.
	 * @return A Integer object (this.chBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "ch_bed_inventory"  )
	public Integer getChBedInventory() {
		return this.chBedInventory;
		
	}
	

  
	 /**  
	 * Set the value related to the column: chBedInventory.
	 * @param chBedInventory the chBedInventory value you wish to set
	 */
	public void setChBedInventory(final Integer chBedInventory) {
		this.chBedInventory = chBedInventory;
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
	 * Return the value associated with the column: vetBedInventory.
	 * @return A Integer object (this.vetBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "vet_bed_inventory"  )
	public Integer getVetBedInventory() {
		return this.vetBedInventory;
		
	}
	

  
	 /**  
	 * Set the value related to the column: vetBedInventory.
	 * @param vetBedInventory the vetBedInventory value you wish to set
	 */
	public void setVetBedInventory(final Integer vetBedInventory) {
		this.vetBedInventory = vetBedInventory;
	}

	 /**
	 * Return the value associated with the column: youthAgeGroup.
	 * @return A BedinventoryYouthAgeGroupEnum object (this.youthAgeGroup)
	 */
	@Type(type="com.servinglynk.hmis.warehouse.enums.BedinventoryYouthAgeGroupEnumType")
	@Basic( optional = true )
	@Column( name = "youth_age_group"  )
	public BedinventoryYouthAgeGroupEnum getYouthAgeGroup() {
		return this.youthAgeGroup;
		
	}
	

  
	 /**  
	 * Set the value related to the column: youthAgeGroup.
	 * @param youthAgeGroup the youthAgeGroup value you wish to set
	 */
	public void setYouthAgeGroup(final BedinventoryYouthAgeGroupEnum youthAgeGroup) {
		this.youthAgeGroup = youthAgeGroup;
	}

	 /**
	 * Return the value associated with the column: youthBedInventory.
	 * @return A Long object (this.youthBedInventory)
	 */
	@Basic( optional = true )
	@Column( name = "youth_bed_inventory"  )
	public Long getYouthBedInventory() {
		return this.youthBedInventory;
		
	}
	

  
	 /**  
	 * Set the value related to the column: youthBedInventory.
	 * @param youthBedInventory the youthBedInventory value you wish to set
	 */
	public void setYouthBedInventory(final Long youthBedInventory) {
		this.youthBedInventory = youthBedInventory;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Bedinventory clone() throws CloneNotSupportedException {
		
        final Bedinventory copy = (Bedinventory)super.clone();

		copy.setBedInventory(this.getBedInventory());
		copy.setChBedInventory(this.getChBedInventory());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setId(this.getId());
		copy.setUserId(this.getUserId());
		copy.setVetBedInventory(this.getVetBedInventory());
		copy.setYouthAgeGroup(this.getYouthAgeGroup());
		copy.setYouthBedInventory(this.getYouthBedInventory());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("bedInventory: " + this.getBedInventory() + ", ");
		sb.append("chBedInventory: " + this.getChBedInventory() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("vetBedInventory: " + this.getVetBedInventory() + ", ");
		sb.append("youthAgeGroup: " + this.getYouthAgeGroup() + ", ");
		sb.append("youthBedInventory: " + this.getYouthBedInventory());
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
		
		final Bedinventory that; 
		try {
			that = (Bedinventory) proxyThat;
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
		result = result && (((getBedInventory() == null) && (that.getBedInventory() == null)) || (getBedInventory() != null && getBedInventory().equals(that.getBedInventory())));
		result = result && (((getChBedInventory() == null) && (that.getChBedInventory() == null)) || (getChBedInventory() != null && getChBedInventory().equals(that.getChBedInventory())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));	
		result = result && (((getVetBedInventory() == null) && (that.getVetBedInventory() == null)) || (getVetBedInventory() != null && getVetBedInventory().equals(that.getVetBedInventory())));
		result = result && (((getYouthAgeGroup() == null) && (that.getYouthAgeGroup() == null)) || (getYouthAgeGroup() != null && getYouthAgeGroup().equals(that.getYouthAgeGroup())));
		result = result && (((getYouthBedInventory() == null) && (that.getYouthBedInventory() == null)) || (getYouthBedInventory() != null && getYouthBedInventory().equals(that.getYouthBedInventory())));
		return result;
	}
}
