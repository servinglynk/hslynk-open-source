package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.live.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.live.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.live.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.live.Familyreunification;
import com.servinglynk.hmis.warehouse.model.live.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.live.Projectcompletionstatus;

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

import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/** 
 * Object mapping for hibernate-handled table: exit.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "exit")
@Table(name = "exit", catalog = "hmis", schema = "live")
public class Exit implements Cloneable, Serializable{

	/** Serial Version UID. */
	private static final long serialVersionUID = -75314002207556153L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	

	/** Field mapping. */
	private Set<Connectionwithsoar> connectionwithsoars = new HashSet<Connectionwithsoar>();

	/** Field mapping. */
	private LocalDateTime dateCreated;
	/** Field mapping. */
	private LocalDateTime dateUpdated;
	/** Field mapping. */
	private ExitDestinationEnum destination;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private LocalDateTime exitdate;
	/** Field mapping. */
	private Set<Exithousingassessment> exithousingassessments = new HashSet<Exithousingassessment>();

	/** Field mapping. */
	private Set<Exitplansactions> exitplansactionss = new HashSet<Exitplansactions>();

	/** Field mapping. */
	private Set<Familyreunification> familyreunifications = new HashSet<Familyreunification>();

	/** Field mapping. */
	private Set<Housingassessmentdisposition> housingassessmentdispositions = new HashSet<Housingassessmentdisposition>();

	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private String otherdestination;
	/** Field mapping. */
	private Set<Projectcompletionstatus> projectcompletionstatuses = new HashSet<Projectcompletionstatus>();

	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Exit() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Exit(java.util.UUID id) {
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
		return Exit.class;
	}
 

	 /**
	 * Return the value associated with the column: connectionwithsoar.
	 * @return A Set&lt;Connectionwithsoar&gt; object (this.connectionwithsoar)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Connectionwithsoar> getConnectionwithsoars() {
		return this.connectionwithsoars;
		
	}
	
	/**
	 * Adds a bi-directional link of type Connectionwithsoar to the connectionwithsoars set.
	 * @param connectionwithsoar item to add
	 */
	public void addConnectionwithsoar(Connectionwithsoar connectionwithsoar) {
		connectionwithsoar.setExitid(this);
		this.connectionwithsoars.add(connectionwithsoar);
	}

  
	 /**  
	 * Set the value related to the column: connectionwithsoar.
	 * @param connectionwithsoar the connectionwithsoar value you wish to set
	 */
	public void setConnectionwithsoars(final Set<Connectionwithsoar> connectionwithsoar) {
		this.connectionwithsoars = connectionwithsoar;
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
	 * Return the value associated with the column: destination.
	 * @return A ExitDestinationEnum object (this.destination)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ExitDestinationEnumType")
	@Basic( optional = true )
	@Column
	public ExitDestinationEnum getDestination() {
		return this.destination;
		
	}
	

  
	 /**  
	 * Set the value related to the column: destination.
	 * @param destination the destination value you wish to set
	 */
	public void setDestination(final ExitDestinationEnum destination) {
		this.destination = destination;
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
	 * Return the value associated with the column: exitdate.
	 * @return A LocalDateTime object (this.exitdate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column
	public LocalDateTime getExitdate() {
		return this.exitdate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: exitdate.
	 * @param exitdate the exitdate value you wish to set
	 */
	public void setExitdate(final LocalDateTime exitdate) {
		this.exitdate = exitdate;
	}

	 /**
	 * Return the value associated with the column: exithousingassessment.
	 * @return A Set&lt;Exithousingassessment&gt; object (this.exithousingassessment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exithousingassessment> getExithousingassessments() {
		return this.exithousingassessments;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exithousingassessment to the exithousingassessments set.
	 * @param exithousingassessment item to add
	 */
	public void addExithousingassessment(Exithousingassessment exithousingassessment) {
		exithousingassessment.setExitid(this);
		this.exithousingassessments.add(exithousingassessment);
	}

  
	 /**  
	 * Set the value related to the column: exithousingassessment.
	 * @param exithousingassessment the exithousingassessment value you wish to set
	 */
	public void setExithousingassessments(final Set<Exithousingassessment> exithousingassessment) {
		this.exithousingassessments = exithousingassessment;
	}

	 /**
	 * Return the value associated with the column: exitplansactions.
	 * @return A Set&lt;Exitplansactions&gt; object (this.exitplansactions)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exitplansactions> getExitplansactionss() {
		return this.exitplansactionss;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exitplansactions to the exitplansactionss set.
	 * @param exitplansactions item to add
	 */
	public void addExitplansactions(Exitplansactions exitplansactions) {
		exitplansactions.setExitid(this);
		this.exitplansactionss.add(exitplansactions);
	}

  
	 /**  
	 * Set the value related to the column: exitplansactions.
	 * @param exitplansactions the exitplansactions value you wish to set
	 */
	public void setExitplansactionss(final Set<Exitplansactions> exitplansactions) {
		this.exitplansactionss = exitplansactions;
	}

	 /**
	 * Return the value associated with the column: familyreunification.
	 * @return A Set&lt;Familyreunification&gt; object (this.familyreunification)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Familyreunification> getFamilyreunifications() {
		return this.familyreunifications;
		
	}
	
	/**
	 * Adds a bi-directional link of type Familyreunification to the familyreunifications set.
	 * @param familyreunification item to add
	 */
	public void addFamilyreunification(Familyreunification familyreunification) {
		familyreunification.setExitid(this);
		this.familyreunifications.add(familyreunification);
	}

  
	 /**  
	 * Set the value related to the column: familyreunification.
	 * @param familyreunification the familyreunification value you wish to set
	 */
	public void setFamilyreunifications(final Set<Familyreunification> familyreunification) {
		this.familyreunifications = familyreunification;
	}

	 /**
	 * Return the value associated with the column: housingassessmentdisposition.
	 * @return A Set&lt;Housingassessmentdisposition&gt; object (this.housingassessmentdisposition)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Housingassessmentdisposition> getHousingassessmentdispositions() {
		return this.housingassessmentdispositions;
		
	}
	
	/**
	 * Adds a bi-directional link of type Housingassessmentdisposition to the housingassessmentdispositions set.
	 * @param housingassessmentdisposition item to add
	 */
	public void addHousingassessmentdisposition(Housingassessmentdisposition housingassessmentdisposition) {
		housingassessmentdisposition.setExitid(this);
		this.housingassessmentdispositions.add(housingassessmentdisposition);
	}

  
	 /**  
	 * Set the value related to the column: housingassessmentdisposition.
	 * @param housingassessmentdisposition the housingassessmentdisposition value you wish to set
	 */
	public void setHousingassessmentdispositions(final Set<Housingassessmentdisposition> housingassessmentdisposition) {
		this.housingassessmentdispositions = housingassessmentdisposition;
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
	 * Return the value associated with the column: otherdestination.
	 * @return A String object (this.otherdestination)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getOtherdestination() {
		return this.otherdestination;
		
	}
	

  
	 /**  
	 * Set the value related to the column: otherdestination.
	 * @param otherdestination the otherdestination value you wish to set
	 */
	public void setOtherdestination(final String otherdestination) {
		this.otherdestination = otherdestination;
	}

	 /**
	 * Return the value associated with the column: projectcompletionstatus.
	 * @return A Set&lt;Projectcompletionstatus&gt; object (this.projectcompletionstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "exitid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Projectcompletionstatus> getProjectcompletionstatuses() {
		return this.projectcompletionstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Projectcompletionstatus to the projectcompletionstatuses set.
	 * @param projectcompletionstatus item to add
	 */
	public void addProjectcompletionstatus(Projectcompletionstatus projectcompletionstatus) {
		projectcompletionstatus.setExitid(this);
		this.projectcompletionstatuses.add(projectcompletionstatus);
	}

  
	 /**  
	 * Set the value related to the column: projectcompletionstatus.
	 * @param projectcompletionstatus the projectcompletionstatus value you wish to set
	 */
	public void setProjectcompletionstatuses(final Set<Projectcompletionstatus> projectcompletionstatus) {
		this.projectcompletionstatuses = projectcompletionstatus;
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
    public Exit clone() throws CloneNotSupportedException {
		
        final Exit copy = (Exit)super.clone();

		if (this.getConnectionwithsoars() != null) {
			copy.getConnectionwithsoars().addAll(this.getConnectionwithsoars());
		}
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDestination(this.getDestination());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setExitdate(this.getExitdate());
		if (this.getExithousingassessments() != null) {
			copy.getExithousingassessments().addAll(this.getExithousingassessments());
		}
		if (this.getExitplansactionss() != null) {
			copy.getExitplansactionss().addAll(this.getExitplansactionss());
		}
		if (this.getFamilyreunifications() != null) {
			copy.getFamilyreunifications().addAll(this.getFamilyreunifications());
		}
		if (this.getHousingassessmentdispositions() != null) {
			copy.getHousingassessmentdispositions().addAll(this.getHousingassessmentdispositions());
		}
		copy.setId(this.getId());
		copy.setOtherdestination(this.getOtherdestination());
		if (this.getProjectcompletionstatuses() != null) {
			copy.getProjectcompletionstatuses().addAll(this.getProjectcompletionstatuses());
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
		
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("destination: " + this.getDestination() + ", ");
		sb.append("exitdate: " + this.getExitdate() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("otherdestination: " + this.getOtherdestination() + ", ");
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
		
		final Exit that; 
		try {
			that = (Exit) proxyThat;
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
		result = result && (((getDestination() == null) && (that.getDestination() == null)) || (getDestination() != null && getDestination().equals(that.getDestination())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));	
		result = result && (((getExitdate() == null) && (that.getExitdate() == null)) || (getExitdate() != null && getExitdate().equals(that.getExitdate())));
		result = result && (((getOtherdestination() == null) && (that.getOtherdestination() == null)) || (getOtherdestination() != null && getOtherdestination().equals(that.getOtherdestination())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		return result;
	}
	
}
