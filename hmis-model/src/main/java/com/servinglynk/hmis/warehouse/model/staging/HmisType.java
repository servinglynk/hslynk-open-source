package com.servinglynk.hmis.warehouse.model.staging;

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: hmis_type.
 * 
 *
 * @author Sandeep Dolia
 */
		

@Entity(name = "hmis_type_staging")
@Table(name = "hmis_type", catalog = "hmis", schema = "staging")
public class HmisType implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = -4507557642147779013L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Integer> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Integer>());
	
	/** hashCode temporary storage. */
	private volatile Integer hashCode;
	

	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private LocalDateTime expirationDate;
	/** Field mapping. */
	private Integer id;
	/** Field mapping. */
	private String name;
	/** Field mapping. */
	private String status;
	/** Field mapping. */
	private HmisUser user;
	/** Field mapping. */
	private String value;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public HmisType() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public HmisType(Integer id) {
		this.id = id;
	}
	
	/** Constructor taking a given ID.
	 * @param id Integer object;
	 * @param name String object;
	 * @param value String object;
	 */
	public HmisType(Integer id, String name, String value) {

		this.id = id;
		this.name = name;
		this.value = value;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return HmisType.class;
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
	 * Return the value associated with the column: description.
	 * @return A String object (this.description)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getDescription() {
		return this.description;
		
	}
	

  
	 /**  
	 * Set the value related to the column: description.
	 * @param description the description value you wish to set
	 */
	public void setDescription(final String description) {
		this.description = description;
	}

	 /**
	 * Return the value associated with the column: expirationDate.
	 * @return A LocalDateTime object (this.expirationDate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column( name = "expiration_date"  )
	public LocalDateTime getExpirationDate() {
		return this.expirationDate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: expirationDate.
	 * @param expirationDate the expirationDate value you wish to set
	 */
	public void setExpirationDate(final LocalDateTime expirationDate) {
		this.expirationDate = expirationDate;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
    @Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hmisTypeIdGenerator")
	@Basic( optional = false )
	@Column( name = "id", nullable = false  )
	@SequenceGenerator(name = "hmisTypeIdGenerator", sequenceName = "hmis.live.hmis_type_id_seq", schema = "staging", catalog = "hmis")
	public Integer getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Integer id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: name.
	 * @return A String object (this.name)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 50  )
	public String getName() {
		return this.name;
		
	}
	

  
	 /**  
	 * Set the value related to the column: name.
	 * @param name the name value you wish to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	 /**
	 * Return the value associated with the column: status.
	 * @return A String object (this.status)
	 */
	@Basic( optional = true )
	@Column( length = 10  )
	public String getStatus() {
		return this.status;
		
	}
	

  
	 /**  
	 * Set the value related to the column: status.
	 * @param status the status value you wish to set
	 */
	public void setStatus(final String status) {
		this.status = status;
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
	 * Return the value associated with the column: value.
	 * @return A String object (this.value)
	 */
	@Basic( optional = false )
	@Column( nullable = false, length = 50  )
	public String getValue() {
		return this.value;
		
	}
	

  
	 /**  
	 * Set the value related to the column: value.
	 * @param value the value value you wish to set
	 */
	public void setValue(final String value) {
		this.value = value;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public HmisType clone() throws CloneNotSupportedException {
		
        final HmisType copy = (HmisType)super.clone();

		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDescription(this.getDescription());
		copy.setExpirationDate(this.getExpirationDate());
		copy.setId(this.getId());
		copy.setName(this.getName());
		copy.setStatus(this.getStatus());
		copy.setUser(this.getUser());
		copy.setValue(this.getValue());
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
		sb.append("description: " + this.getDescription() + ", ");
		sb.append("expirationDate: " + this.getExpirationDate() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("name: " + this.getName() + ", ");
		sb.append("status: " + this.getStatus() + ", ");
		sb.append("value: " + this.getValue());
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
		
		final HmisType that; 
		try {
			that = (HmisType) proxyThat;
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
		result = result && (((getDescription() == null) && (that.getDescription() == null)) || (getDescription() != null && getDescription().equals(that.getDescription())));
		result = result && (((getExpirationDate() == null) && (that.getExpirationDate() == null)) || (getExpirationDate() != null && getExpirationDate().equals(that.getExpirationDate())));
		result = result && (((getName() == null) && (that.getName() == null)) || (getName() != null && getName().equals(that.getName())));
		result = result && (((getStatus() == null) && (that.getStatus() == null)) || (getStatus() != null && getStatus().equals(that.getStatus())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		result = result && (((getValue() == null) && (that.getValue() == null)) || (getValue() != null && getValue().equals(that.getValue())));
		return result;
	}
	
	/** Calculate the hashcode.
	 * @see java.lang.Object#hashCode()
	 * @return a calculated number
	 */
	@Override
	public int hashCode() {
		if ( this.hashCode == null ) {
			synchronized ( this ) {
				if ( this.hashCode == null ) {
					Integer newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0) {
							newHashCode = getId();
						} else {
							newHashCode = super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
	return this.hashCode;
	}
	

	
}
