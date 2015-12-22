package com.servinglynk.hmis.warehouse.model.staging;

import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.live.HmisBaseModel;

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
 * Object mapping for hibernate-handled table: exithousingassessment.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "exithousingassessment_staging")
@Table(name = "exithousingassessment", catalog = "hmis", schema = "staging")
public class Exithousingassessment extends HmisBaseStagingModel  implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = 6863824805023629132L;

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
	private Exit exitid;
	/** Field mapping. */
	private ExithousingassessmentHousingassessmentEnum housingassessment;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private ExithousingassessmentSubsidyinformationEnum subsidyinformation;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Exithousingassessment() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Exithousingassessment(java.util.UUID id) {
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
		return Exithousingassessment.class;
	}
 


	 /**
	 * Return the value associated with the column: exitid.
	 * @return A Exit object (this.exitid)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = true )
	@JoinColumn(name = "exitid", nullable = true )
	public Exit getExitid() {
		return this.exitid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: exitid.
	 * @param exitid the exitid value you wish to set
	 */
	public void setExitid(final Exit exitid) {
		this.exitid = exitid;
	}

	 /**
	 * Return the value associated with the column: housingassessment.
	 * @return A ExithousingassessmentHousingassessmentEnum object (this.housingassessment)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnumType")
	@Basic( optional = true )
	@Column
	public ExithousingassessmentHousingassessmentEnum getHousingassessment() {
		return this.housingassessment;
		
	}
	 /**  
	 * Set the value related to the column: housingassessment.
	 * @param housingassessment the housingassessment value you wish to set
	 */
	public void setHousingassessment(final ExithousingassessmentHousingassessmentEnum housingassessment) {
		this.housingassessment = housingassessment;
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
	 * Return the value associated with the column: subsidyinformation.
	 * @return A ExithousingassessmentSubsidyinformationEnum object (this.subsidyinformation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnumType")
	@Basic( optional = true )
	@Column
	public ExithousingassessmentSubsidyinformationEnum getSubsidyinformation() {
		return this.subsidyinformation;
		
	}
	

  
	 /**  
	 * Set the value related to the column: subsidyinformation.
	 * @param subsidyinformation the subsidyinformation value you wish to set
	 */
	public void setSubsidyinformation(final ExithousingassessmentSubsidyinformationEnum subsidyinformation) {
		this.subsidyinformation = subsidyinformation;
	}

   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Exithousingassessment clone() throws CloneNotSupportedException {
		
        final Exithousingassessment copy = (Exithousingassessment)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setExitid(this.getExitid());
		copy.setHousingassessment(this.getHousingassessment());
		copy.setId(this.getId());
		copy.setSubsidyinformation(this.getSubsidyinformation());
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
		sb.append("housingassessment: " + this.getHousingassessment() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("subsidyinformation: " + this.getSubsidyinformation() + ", ");
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
		
		final Exithousingassessment that; 
		try {
			that = (Exithousingassessment) proxyThat;
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
		result = result && (((getExitid() == null) && (that.getExitid() == null)) || (getExitid() != null && getExitid().getId().equals(that.getExitid().getId())));	
		result = result && (((getHousingassessment() == null) && (that.getHousingassessment() == null)) || (getHousingassessment() != null && getHousingassessment().equals(that.getHousingassessment())));
		result = result && (((getSubsidyinformation() == null) && (that.getSubsidyinformation() == null)) || (getSubsidyinformation() != null && getSubsidyinformation().equals(that.getSubsidyinformation())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		return result;
	}
}
