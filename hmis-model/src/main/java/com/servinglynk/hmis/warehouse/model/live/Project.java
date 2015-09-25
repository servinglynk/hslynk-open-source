package com.servinglynk.hmis.warehouse.model.live;

import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.live.Affiliation;
import com.servinglynk.hmis.warehouse.model.live.Funder;
import com.servinglynk.hmis.warehouse.model.live.Projectcoc;

import java.io.Serializable;
import java.time.LocalDate;
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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.proxy.HibernateProxy;


/**
 * Object mapping for hibernate-handled table: project.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "project")
@Table(name = "project", catalog = "hmis", schema = "live")
public class Project implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -7029415480218844556L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private Set<Affiliation> affiliations = new HashSet<Affiliation>();

	/** Field mapping. */
	private ProjectContinuumprojectEnum continuumproject;
	/** Field mapping. */
	private LocalDate dateCreated;
	/** Field mapping. */
	private LocalDate dateUpdated;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private Set<Funder> funders = new HashSet<Funder>();

	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Organization organizationid;
	/** Field mapping. */
	private Set<Projectcoc> projectcocs = new HashSet<Projectcoc>();

	/** Field mapping. */
	private String projectcommonname;
	/** Field mapping. */
	private String projectname;
	/** Field mapping. */
	private ProjectProjecttypeEnum projecttype;
	/** Field mapping. */
	private ProjectResidentialaffiliationEnum residentialaffiliation;
	/** Field mapping. */
	private ProjectTargetpopulationEnum targetpopulation;
	/** Field mapping. */
	private ProjectTrackingmethodEnum trackingmethod;
	/** Field mapping. */
	private HmisUser user;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Project() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Project(java.util.UUID id) {
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
		return Project.class;
	}


	 /**
	 * Return the value associated with the column: affiliation.
	 * @return A Set&lt;Affiliation&gt; object (this.affiliation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projectid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Affiliation> getAffiliations() {
		return this.affiliations;

	}

	/**
	 * Adds a bi-directional link of type Affiliation to the affiliations set.
	 * @param affiliation item to add
	 */
	public void addAffiliation(Affiliation affiliation) {
		affiliation.setProjectid(this);
		this.affiliations.add(affiliation);
	}


	 /**
	 * Set the value related to the column: affiliation.
	 * @param affiliation the affiliation value you wish to set
	 */
	public void setAffiliations(final Set<Affiliation> affiliation) {
		this.affiliations = affiliation;
	}

	 /**
	 * Return the value associated with the column: continuumproject.
	 * @return A ProjectContinuumprojectEnum object (this.continuumproject)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnumType")
	@Basic( optional = true )
	@Column
	public ProjectContinuumprojectEnum getContinuumproject() {
		return this.continuumproject;

	}



	 /**
	 * Set the value related to the column: continuumproject.
	 * @param continuumproject the continuumproject value you wish to set
	 */
	public void setContinuumproject(final ProjectContinuumprojectEnum continuumproject) {
		this.continuumproject = continuumproject;
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
	 * Return the value associated with the column: funder.
	 * @return A Set&lt;Funder&gt; object (this.funder)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projectid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Funder> getFunders() {
		return this.funders;

	}

	/**
	 * Adds a bi-directional link of type Funder to the funders set.
	 * @param funder item to add
	 */
	public void addFunder(Funder funder) {
		funder.setProjectid(this);
		this.funders.add(funder);
	}


	 /**
	 * Set the value related to the column: funder.
	 * @param funder the funder value you wish to set
	 */
	public void setFunders(final Set<Funder> funder) {
		this.funders = funder;
	}

	 /**
	 * Return the value associated with the column: id.
	 * @return A java.util.UUID object (this.id)
	 */
    @Id
	@Basic( optional = false )
    @GenericGenerator(name = "uuid-gen", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-gen")
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="pg-uuid")
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
		 * Return the value associated with the column: organizationid.
		 * @return A Organization object (this.organizationid)
		 */
		@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
		@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
		@Basic( optional = true )
		@JoinColumn(name = "organizationid", nullable = true )
		public Organization getOrganizationid() {
			return this.organizationid;

		}



		 /**
		 * Set the value related to the column: organizationid.
		 * @param organizationid the organizationid value you wish to set
		 */
		public void setOrganizationid(final Organization organizationid) {
			this.organizationid = organizationid;
		}

	 /**
	 * Return the value associated with the column: projectcoc.
	 * @return A Set&lt;Projectcoc&gt; object (this.projectcoc)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "projectid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Projectcoc> getProjectcocs() {
		return this.projectcocs;

	}

	/**
	 * Adds a bi-directional link of type Projectcoc to the projectcocs set.
	 * @param projectcoc item to add
	 */
	public void addProjectcoc(Projectcoc projectcoc) {
		projectcoc.setProjectid(this);
		this.projectcocs.add(projectcoc);
	}


	 /**
	 * Set the value related to the column: projectcoc.
	 * @param projectcoc the projectcoc value you wish to set
	 */
	public void setProjectcocs(final Set<Projectcoc> projectcoc) {
		this.projectcocs = projectcoc;
	}

	 /**
	 * Return the value associated with the column: projectcommonname.
	 * @return A String object (this.projectcommonname)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getProjectcommonname() {
		return this.projectcommonname;

	}



	 /**
	 * Set the value related to the column: projectcommonname.
	 * @param projectcommonname the projectcommonname value you wish to set
	 */
	public void setProjectcommonname(final String projectcommonname) {
		this.projectcommonname = projectcommonname;
	}

	 /**
	 * Return the value associated with the column: projectname.
	 * @return A String object (this.projectname)
	 */
	@Basic( optional = true )
	@Column( length = 32  )
	public String getProjectname() {
		return this.projectname;

	}



	 /**
	 * Set the value related to the column: projectname.
	 * @param projectname the projectname value you wish to set
	 */
	public void setProjectname(final String projectname) {
		this.projectname = projectname;
	}

	 /**
	 * Return the value associated with the column: projecttype.
	 * @return A ProjectProjecttypeEnum object (this.projecttype)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnumType")
	@Basic( optional = true )
	@Column
	public ProjectProjecttypeEnum getProjecttype() {
		return this.projecttype;

	}



	 /**
	 * Set the value related to the column: projecttype.
	 * @param projecttype the projecttype value you wish to set
	 */
	public void setProjecttype(final ProjectProjecttypeEnum projecttype) {
		this.projecttype = projecttype;
	}

	 /**
	 * Return the value associated with the column: residentialaffiliation.
	 * @return A ProjectResidentialaffiliationEnum object (this.residentialaffiliation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnumType")
	@Basic( optional = true )
	@Column
	public ProjectResidentialaffiliationEnum getResidentialaffiliation() {
		return this.residentialaffiliation;

	}



	 /**
	 * Set the value related to the column: residentialaffiliation.
	 * @param residentialaffiliation the residentialaffiliation value you wish to set
	 */
	public void setResidentialaffiliation(final ProjectResidentialaffiliationEnum residentialaffiliation) {
		this.residentialaffiliation = residentialaffiliation;
	}

	 /**
	 * Return the value associated with the column: targetpopulation.
	 * @return A ProjectTargetpopulationEnum object (this.targetpopulation)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTargetpopulationEnum getTargetpopulation() {
		return this.targetpopulation;

	}



	 /**
	 * Set the value related to the column: targetpopulation.
	 * @param targetpopulation the targetpopulation value you wish to set
	 */
	public void setTargetpopulation(final ProjectTargetpopulationEnum targetpopulation) {
		this.targetpopulation = targetpopulation;
	}

	 /**
	 * Return the value associated with the column: trackingmethod.
	 * @return A ProjectTrackingmethodEnum object (this.trackingmethod)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnumType")
	@Basic( optional = true )
	@Column
	public ProjectTrackingmethodEnum getTrackingmethod() {
		return this.trackingmethod;

	}



	 /**
	 * Set the value related to the column: trackingmethod.
	 * @param trackingmethod the trackingmethod value you wish to set
	 */
	public void setTrackingmethod(final ProjectTrackingmethodEnum trackingmethod) {
		this.trackingmethod = trackingmethod;
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
    public Project clone() throws CloneNotSupportedException {

        final Project copy = (Project)super.clone();

		if (this.getAffiliations() != null) {
			copy.getAffiliations().addAll(this.getAffiliations());
		}
		copy.setContinuumproject(this.getContinuumproject());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		if (this.getFunders() != null) {
			copy.getFunders().addAll(this.getFunders());
		}
		copy.setId(this.getId());
		copy.setOrganizationid(this.getOrganizationid());
		if (this.getProjectcocs() != null) {
			copy.getProjectcocs().addAll(this.getProjectcocs());
		}
		copy.setProjectcommonname(this.getProjectcommonname());
		copy.setProjectname(this.getProjectname());
		copy.setProjecttype(this.getProjecttype());
		copy.setResidentialaffiliation(this.getResidentialaffiliation());
		copy.setTargetpopulation(this.getTargetpopulation());
		copy.setTrackingmethod(this.getTrackingmethod());
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

		sb.append("continuumproject: " + this.getContinuumproject() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("organizationid: " + this.getOrganizationid() + ", ");
		sb.append("projectcommonname: " + this.getProjectcommonname() + ", ");
		sb.append("projectname: " + this.getProjectname() + ", ");
		sb.append("projecttype: " + this.getProjecttype() + ", ");
		sb.append("residentialaffiliation: " + this.getResidentialaffiliation() + ", ");
		sb.append("targetpopulation: " + this.getTargetpopulation() + ", ");
		sb.append("trackingmethod: " + this.getTrackingmethod() + ", ");
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

		final Project that;
		try {
			that = (Project) proxyThat;
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
		result = result && (((getContinuumproject() == null) && (that.getContinuumproject() == null)) || (getContinuumproject() != null && getContinuumproject().equals(that.getContinuumproject())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getOrganizationid() == null) && (that.getOrganizationid() == null)) || (getOrganizationid() != null && getOrganizationid().equals(that.getOrganizationid())));
		result = result && (((getProjectcommonname() == null) && (that.getProjectcommonname() == null)) || (getProjectcommonname() != null && getProjectcommonname().equals(that.getProjectcommonname())));
		result = result && (((getProjectname() == null) && (that.getProjectname() == null)) || (getProjectname() != null && getProjectname().equals(that.getProjectname())));
		result = result && (((getProjecttype() == null) && (that.getProjecttype() == null)) || (getProjecttype() != null && getProjecttype().equals(that.getProjecttype())));
		result = result && (((getResidentialaffiliation() == null) && (that.getResidentialaffiliation() == null)) || (getResidentialaffiliation() != null && getResidentialaffiliation().equals(that.getResidentialaffiliation())));
		result = result && (((getTargetpopulation() == null) && (that.getTargetpopulation() == null)) || (getTargetpopulation() != null && getTargetpopulation().equals(that.getTargetpopulation())));
		result = result && (((getTrackingmethod() == null) && (that.getTrackingmethod() == null)) || (getTrackingmethod() != null && getTrackingmethod().equals(that.getTrackingmethod())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));
		return result;
	}
}
