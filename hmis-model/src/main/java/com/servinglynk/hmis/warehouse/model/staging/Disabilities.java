package com.servinglynk.hmis.warehouse.model.staging;

import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;

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
 * Object mapping for hibernate-handled table: disabilities.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "disabilities_staging")
@Table(name = "disabilities", catalog = "hmis", schema = "staging")
public class Disabilities implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 6492609509614588571L;

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
	private Integer disabilityresponse;
	/** Field mapping. */
	private DisabilitiesDisabilitytypeEnum disabilitytype;
	/** Field mapping. */
	private DisabilitiesDocumentationonfileEnum documentationonfile;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private DisabilitiesIndefiniteandimpairsEnum indefiniteandimpairs;
	/** Field mapping. */
	private DisabilitiesPathhowconfirmedEnum pathhowconfirmed;
	/** Field mapping. */
	private DisabilitiesPathsmiinformationEnum pathsmiinformation;
	/** Field mapping. */
	private DisabilitiesReceivingservicesEnum receivingservices;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Disabilities() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Disabilities(java.util.UUID id) {
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
		return Disabilities.class;
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
	 * Return the value associated with the column: disabilityresponse.
	 * @return A Integer object (this.disabilityresponse)
	 */
	public Integer getDisabilityresponse() {
		return this.disabilityresponse;
		
	}
	

  
	 /**  
	 * Set the value related to the column: disabilityresponse.
	 * @param disabilityresponse the disabilityresponse value you wish to set
	 */
	public void setDisabilityresponse(final Integer disabilityresponse) {
		this.disabilityresponse = disabilityresponse;
	}

	 /**
	 * Return the value associated with the column: disabilitytype.
	 * @return A DisabilitiesDisabilitytypeEnum object (this.disabilitytype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesDisabilitytypeEnum getDisabilitytype() {
		return this.disabilitytype;
		
	}
	

  
	 /**  
	 * Set the value related to the column: disabilitytype.
	 * @param disabilitytype the disabilitytype value you wish to set
	 */
	public void setDisabilitytype(final DisabilitiesDisabilitytypeEnum disabilitytype) {
		this.disabilitytype = disabilitytype;
	}

	 /**
	 * Return the value associated with the column: documentationonfile.
	 * @return A DisabilitiesDocumentationonfileEnum object (this.documentationonfile)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesDocumentationonfileEnum getDocumentationonfile() {
		return this.documentationonfile;
		
	}
	

  
	 /**  
	 * Set the value related to the column: documentationonfile.
	 * @param documentationonfile the documentationonfile value you wish to set
	 */
	public void setDocumentationonfile(final DisabilitiesDocumentationonfileEnum documentationonfile) {
		this.documentationonfile = documentationonfile;
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
	 * Return the value associated with the column: indefiniteandimpairs.
	 * @return A DisabilitiesIndefiniteandimpairsEnum object (this.indefiniteandimpairs)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesIndefiniteandimpairsEnum getIndefiniteandimpairs() {
		return this.indefiniteandimpairs;
		
	}
	

  
	 /**  
	 * Set the value related to the column: indefiniteandimpairs.
	 * @param indefiniteandimpairs the indefiniteandimpairs value you wish to set
	 */
	public void setIndefiniteandimpairs(final DisabilitiesIndefiniteandimpairsEnum indefiniteandimpairs) {
		this.indefiniteandimpairs = indefiniteandimpairs;
	}

	 /**
	 * Return the value associated with the column: pathhowconfirmed.
	 * @return A DisabilitiesPathhowconfirmedEnum object (this.pathhowconfirmed)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesPathhowconfirmedEnum getPathhowconfirmed() {
		return this.pathhowconfirmed;
		
	}
	

  
	 /**  
	 * Set the value related to the column: pathhowconfirmed.
	 * @param pathhowconfirmed the pathhowconfirmed value you wish to set
	 */
	public void setPathhowconfirmed(final DisabilitiesPathhowconfirmedEnum pathhowconfirmed) {
		this.pathhowconfirmed = pathhowconfirmed;
	}

	 /**
	 * Return the value associated with the column: pathsmiinformation.
	 * @return A DisabilitiesPathsmiinformationEnum object (this.pathsmiinformation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesPathsmiinformationEnum getPathsmiinformation() {
		return this.pathsmiinformation;
		
	}
	

  
	 /**  
	 * Set the value related to the column: pathsmiinformation.
	 * @param pathsmiinformation the pathsmiinformation value you wish to set
	 */
	public void setPathsmiinformation(final DisabilitiesPathsmiinformationEnum pathsmiinformation) {
		this.pathsmiinformation = pathsmiinformation;
	}

	 /**
	 * Return the value associated with the column: receivingservices.
	 * @return A DisabilitiesReceivingservicesEnum object (this.receivingservices)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnumType")
	@Basic( optional = true )
	@Column
	public DisabilitiesReceivingservicesEnum getReceivingservices() {
		return this.receivingservices;
		
	}
	

  
	 /**  
	 * Set the value related to the column: receivingservices.
	 * @param receivingservices the receivingservices value you wish to set
	 */
	public void setReceivingservices(final DisabilitiesReceivingservicesEnum receivingservices) {
		this.receivingservices = receivingservices;
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
    public Disabilities clone() throws CloneNotSupportedException {
		
        final Disabilities copy = (Disabilities)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDisabilityresponse(this.getDisabilityresponse());
		copy.setDisabilitytype(this.getDisabilitytype());
		copy.setDocumentationonfile(this.getDocumentationonfile());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setId(this.getId());
		copy.setIndefiniteandimpairs(this.getIndefiniteandimpairs());
		copy.setPathhowconfirmed(this.getPathhowconfirmed());
		copy.setPathsmiinformation(this.getPathsmiinformation());
		copy.setReceivingservices(this.getReceivingservices());
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
		sb.append("disabilityresponse: " + this.getDisabilityresponse() + ", ");
		sb.append("disabilitytype: " + this.getDisabilitytype() + ", ");
		sb.append("documentationonfile: " + this.getDocumentationonfile() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("indefiniteandimpairs: " + this.getIndefiniteandimpairs() + ", ");
		sb.append("pathhowconfirmed: " + this.getPathhowconfirmed() + ", ");
		sb.append("pathsmiinformation: " + this.getPathsmiinformation() + ", ");
		sb.append("receivingservices: " + this.getReceivingservices() + ", ");
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
		
		final Disabilities that; 
		try {
			that = (Disabilities) proxyThat;
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
		result = result && (((getDisabilityresponse() == null) && (that.getDisabilityresponse() == null)) || (getDisabilityresponse() != null && getDisabilityresponse().equals(that.getDisabilityresponse())));
		result = result && (((getDisabilitytype() == null) && (that.getDisabilitytype() == null)) || (getDisabilitytype() != null && getDisabilitytype().equals(that.getDisabilitytype())));
		result = result && (((getDocumentationonfile() == null) && (that.getDocumentationonfile() == null)) || (getDocumentationonfile() != null && getDocumentationonfile().equals(that.getDocumentationonfile())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getIndefiniteandimpairs() == null) && (that.getIndefiniteandimpairs() == null)) || (getIndefiniteandimpairs() != null && getIndefiniteandimpairs().equals(that.getIndefiniteandimpairs())));
		result = result && (((getPathhowconfirmed() == null) && (that.getPathhowconfirmed() == null)) || (getPathhowconfirmed() != null && getPathhowconfirmed().equals(that.getPathhowconfirmed())));
		result = result && (((getPathsmiinformation() == null) && (that.getPathsmiinformation() == null)) || (getPathsmiinformation() != null && getPathsmiinformation().equals(that.getPathsmiinformation())));
		result = result && (((getReceivingservices() == null) && (that.getReceivingservices() == null)) || (getReceivingservices() != null && getReceivingservices().equals(that.getReceivingservices())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		return result;
	}
}
