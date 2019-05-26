package com.servinglynk.hmis.warehouse.model.base;

import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import java.util.WeakHashMap;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.proxy.HibernateProxy;

@Entity
@Table(name = "bulk_upload",schema="base")
public class BulkUpload extends HmisBaseModel  implements Cloneable, Serializable {
	/** Serial Version UID. */
	private static final long serialVersionUID = 5515655458223886905L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, Long> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, Long>());
	
	/** hashCode temporary storage. */
	private volatile Long hashCode;
	
	/** Field mapping. */
	private Long id;
	/** Field mapping. */
	private String inputpath;
	/** Field mapping. */
	private String status;
	/** Field mapping. */
	private String description;
	/** Field mapping. */
	private UUID exportId;
	private Long size;
	private Long year;
	private String hudVersion;
	private boolean ignoreDuplicateCheck=false;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public BulkUpload() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public BulkUpload(Long id) {
		this.id = id;
	}
	
 


 
	/** Return the type of this class. Useful for when dealing with proxies.
	* @return Defining class.
	*/
	@Transient
	public Class<?> getClassType() {
		return BulkUpload.class;
	}
 

	 /**
	 * Return the value associated with the column: id.
	 * @return A Long object (this.id)
	 */
	@Id
	@SequenceGenerator(allocationSize=1, initialValue=1, sequenceName="base.bulk_upload_id_seq", name="base.bulk_upload_id_seq" , catalog = "hmis", schema = "base")
	@GeneratedValue(generator="base.bulk_upload_id_seq", strategy=GenerationType.SEQUENCE )
	public Long getId() {
		return this.id;
		
	}
	

  
	 /**  
	 * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	public void setId(final Long id) {
		// If we've just been persisted and hashCode has been
		// returned then make sure other entities with this
		// ID return the already returned hash code
		if ( (this.id == null || this.id == 0L) &&
				(id != null) &&
				(this.hashCode != null) ) {
		SAVED_HASHES.put( id, this.hashCode );
		}
		this.id = id;
	}

	 /**
	 * Return the value associated with the column: inputpath.
	 * @return A String object (this.inputpath)
	 */
	@Basic( optional = true )
	@Column( length = 2147483647  )
	public String getInputpath() {
		return this.inputpath;
		
	}
	

  
	 /**  
	 * Set the value related to the column: inputpath.
	 * @param inputpath the inputpath value you wish to set
	 */
	public void setInputpath(final String inputpath) {
		this.inputpath = inputpath;
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
	 * @return the ignoreDuplicateCheck
	 */
	public boolean isIgnoreDuplicateCheck() {
		return ignoreDuplicateCheck;
	}

	/**
	 * @param ignoreDuplicateCheck the ignoreDuplicateCheck to set
	 */
	public void setIgnoreDuplicateCheck(boolean ignoreDuplicateCheck) {
		this.ignoreDuplicateCheck = ignoreDuplicateCheck;
	}

	@Basic( optional = true )
	@Column
   public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Basic( optional = true )
	@Column( name = "export_id"  )
	@org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public UUID getExportId() {
		return exportId;
	}

	public void setExportId(UUID exportId) {
		this.exportId = exportId;
	}

/**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public BulkUpload clone() throws CloneNotSupportedException {
		
        final BulkUpload copy = (BulkUpload)super.clone();
        copy.setHudVersion(this.getHudVersion());
        copy.setYear(this.getYear());
		copy.setExportId(this.getExportId());
		copy.setId(this.getId());
		copy.setInputpath(this.getInputpath());
		copy.setStatus(this.getStatus());
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("id: " + this.getId() + ", ");
		sb.append("inputpath: " + this.getInputpath() + ", ");
		sb.append("status: " + this.getStatus() + ", ");
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
		
		final BulkUpload that; 
		try {
			that = (BulkUpload) proxyThat;
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
		result = result && (((getExportId() == null) && (that.getExportId() == null)) || (getExportId() != null && getExportId().equals(that.getExportId())));	
		result = result && (((getInputpath() == null) && (that.getInputpath() == null)) || (getInputpath() != null && getInputpath().equals(that.getInputpath())));
		result = result && (((getStatus() == null) && (that.getStatus() == null)) || (getStatus() != null && getStatus().equals(that.getStatus())));
		return result;
	}
	
	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getYear() {
		return year;
	}

	public void setYear(Long year) {
		this.year = year;
	}
	

	/**
	 * @return the hudVersion
	 */
	@Basic( optional = true )
	@Column( name = "hud_version" ,length=100 )
	public String getHudVersion() {
		return hudVersion;
	}

	/**
	 * @param hudVersion the hudVersion to set
	 */
	public void setHudVersion(String hudVersion) {
		this.hudVersion = hudVersion;
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
					Long newHashCode = null;

					if ( getId() != null ) {
					newHashCode = SAVED_HASHES.get( getId() );
					}
					
					if ( newHashCode == null ) {
						if ( getId() != null && getId() != 0L) {
							newHashCode = getId();
						} else {
							newHashCode = (long) super.hashCode();

						}
					}
					
					this.hashCode = newHashCode;
				}
			}
		}
		return (int) (this.hashCode & 0xffffff);
	}
	

}
