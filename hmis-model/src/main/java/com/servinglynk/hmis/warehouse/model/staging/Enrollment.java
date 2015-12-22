package com.servinglynk.hmis.warehouse.model.staging;

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

import com.servinglynk.hmis.warehouse.enums.EnrollmentContinuouslyhomelessoneyearEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelessthistimeEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentStatusdocumentedEnum;
import com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnum;
import com.servinglynk.hmis.warehouse.model.live.HmisBaseModel;


/** 
 * Object mapping for hibernate-handled table: enrollment.
 * 
 *
 * @author Sandeep Dolia
 */
@Entity(name = "enrollment_staging")
@Table(name = "enrollment", catalog = "hmis", schema = "staging")
public class Enrollment extends HmisBaseStagingModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -6048419471750369756L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities 
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());
	
	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;
	
	/** Field mapping. */
	private Client client;

	/** Field mapping. */
	private Set<Commercialsexualexploitation> commercialsexualexploitations = new HashSet<Commercialsexualexploitation>();

	/** Field mapping. */
	private EnrollmentContinuouslyhomelessoneyearEnum continuouslyhomelessoneyear;
	/** Field mapping. */
	private Set<Dateofengagement> dateofengagements = new HashSet<Dateofengagement>();

	/** Field mapping. */
	private Set<Disabilities> disabilitieses = new HashSet<Disabilities>();

	/** Field mapping. */
	private EnrollmentDisablingconditionEnum disablingcondition;
	/** Field mapping. */
	private Set<Domesticviolence> domesticviolences = new HashSet<Domesticviolence>();

	/** Field mapping. */
	private Set<Employment> employments = new HashSet<Employment>();

	/** Field mapping. */
	private Set<EnrollmentCoc> enrollmentCocs = new HashSet<EnrollmentCoc>();

	/** Field mapping. */
	private LocalDateTime entrydate;
	/** Field mapping. */
	private Set<Exit> exits = new HashSet<Exit>();

	/** Field mapping. */
	private Set<Formerwardchildwelfare> formerwardchildwelfares = new HashSet<Formerwardchildwelfare>();

	/** Field mapping. */
	private Set<Formerwardjuvenilejustice> formerwardjuvenilejustices = new HashSet<Formerwardjuvenilejustice>();

	/** Field mapping. */
	private Set<Healthinsurance> healthinsurances = new HashSet<Healthinsurance>();

	/** Field mapping. */
	private Set<HealthStatus> healthStatuses = new HashSet<HealthStatus>();

	/** Field mapping. */
	private java.util.UUID householdid;
	/** Field mapping. */
	private EnrollmentHousingstatusEnum housingstatus;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private Set<Incomeandsources> incomeandsourceses = new HashSet<Incomeandsources>();

	/** Field mapping. */
	private Set<Lastgradecompleted> lastgradecompleteds = new HashSet<Lastgradecompleted>();

	/** Field mapping. */
	private Set<LastPermAddress> lastPermAddresses = new HashSet<LastPermAddress>();

	/** Field mapping. */
	private Set<Medicalassistance> medicalassistances = new HashSet<Medicalassistance>();

	/** Field mapping. */
	private EnrollmentMonthshomelesspastthreeyearsEnum monthshomelesspastthreeyears;
	/** Field mapping. */
	private EnrollmentMonthshomelessthistimeEnum monthshomelessthistime;
	/** Field mapping. */
	private Set<Noncashbenefits> noncashbenefitss = new HashSet<Noncashbenefits>();

	/** Field mapping. */
	private String otherresidenceprior;
	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> pathstatuses = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Pathstatus>();

	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> percentamis = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Percentami>();

	/** Field mapping. */
	private java.util.UUID personalid;
	/** Field mapping. */
	private Set<Project> projects = new HashSet<Project>();

	/** Field mapping. */
	private java.util.UUID projectentryid;
	/** Field mapping. */
	private java.util.UUID projectid;
	/** Field mapping. */
	private Set<Referralsource> referralsources = new HashSet<Referralsource>();

	/** Field mapping. */
	private EnrollmentRelationshiptohohEnum relationshiptohoh;
	/** Field mapping. */
	private EnrollmentResidencepriorEnum residenceprior;
	/** Field mapping. */
	private EnrollmentResidencepriorlengthofstayEnum residencepriorlengthofstay;
	/** Field mapping. */
	private Set<Residentialmoveindate> residentialmoveindates = new HashSet<Residentialmoveindate>();

	/** Field mapping. */
	private Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> rhybcpstatuses = new HashSet<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus>();

	/** Field mapping. */
	private Set<Schoolstatus> schoolstatuses = new HashSet<Schoolstatus>();

	/** Field mapping. */
	private Set<Services> serviceses = new HashSet<Services>();

	/** Field mapping. */
	private Set<Sexualorientation> sexualorientations = new HashSet<Sexualorientation>();

	/** Field mapping. */
	private EnrollmentStatusdocumentedEnum statusdocumented;
	/** Field mapping. */
	private EnrollmentTimeshomelesspastthreeyearsEnum timeshomelesspastthreeyears;
	/** Field mapping. */
	private Set<Worsthousingsituation> worsthousingsituations = new HashSet<Worsthousingsituation>();

	/** Field mapping. */
	private Integer yearshomeless;
	/** Field mapping. */
	private Set<Youthcriticalissues> youthcriticalissueses = new HashSet<Youthcriticalissues>();

	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Enrollment() {
		// Default constructor
	} 

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Enrollment(java.util.UUID id) {
		this.id = id;
	}
	
 


	/** Field mapping. */
	private Export export;
	 /**
	 * Return the value associated with the column: export.
	 * @return A Export object (this.export)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
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
		return Enrollment.class;
	}
 

	 /**
	 * Return the value associated with the column: commercialsexualexploitation.
	 * @return A Set&lt;Commercialsexualexploitation&gt; object (this.commercialsexualexploitation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Commercialsexualexploitation> getCommercialsexualexploitations() {
		return this.commercialsexualexploitations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Commercialsexualexploitation to the commercialsexualexploitations set.
	 * @param commercialsexualexploitation item to add
	 */
	public void addCommercialsexualexploitation(Commercialsexualexploitation commercialsexualexploitation) {
		commercialsexualexploitation.setEnrollmentid(this);
		this.commercialsexualexploitations.add(commercialsexualexploitation);
	}

  
	 /**  
	 * Set the value related to the column: commercialsexualexploitation.
	 * @param commercialsexualexploitation the commercialsexualexploitation value you wish to set
	 */
	public void setCommercialsexualexploitations(final Set<Commercialsexualexploitation> commercialsexualexploitation) {
		this.commercialsexualexploitations = commercialsexualexploitation;
	}

	 /**
	 * Return the value associated with the column: continuouslyhomelessoneyear.
	 * @return A EnrollmentContinuouslyhomelessoneyearEnum object (this.continuouslyhomelessoneyear)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentContinuouslyhomelessoneyearEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentContinuouslyhomelessoneyearEnum getContinuouslyhomelessoneyear() {
		return this.continuouslyhomelessoneyear;
		
	}
	

  
	 /**  
	 * Set the value related to the column: continuouslyhomelessoneyear.
	 * @param continuouslyhomelessoneyear the continuouslyhomelessoneyear value you wish to set
	 */
	public void setContinuouslyhomelessoneyear(final EnrollmentContinuouslyhomelessoneyearEnum continuouslyhomelessoneyear) {
		this.continuouslyhomelessoneyear = continuouslyhomelessoneyear;
	}
	
	

	 /**
	 * Return the value associated with the column: client.
	 * @return A Client object (this.client)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = true )
	@JoinColumn(name = "client_id", nullable = true )
	public Client getClient() {
		return this.client;
		
	}
	

 
	 /**  
	 * Set the value related to the column: client.
	 * @param client the client value you wish to set
	 */
	public void setClient(final Client client) {
		this.client = client;
	}

	 /**
	 * Return the value associated with the column: dateofengagement.
	 * @return A Set&lt;Dateofengagement&gt; object (this.dateofengagement)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Dateofengagement> getDateofengagements() {
		return this.dateofengagements;
		
	}
	
	/**
	 * Adds a bi-directional link of type Dateofengagement to the dateofengagements set.
	 * @param dateofengagement item to add
	 */
	public void addDateofengagement(Dateofengagement dateofengagement) {
		dateofengagement.setEnrollmentid(this);
		this.dateofengagements.add(dateofengagement);
	}

  
	 /**  
	 * Set the value related to the column: dateofengagement.
	 * @param dateofengagement the dateofengagement value you wish to set
	 */
	public void setDateofengagements(final Set<Dateofengagement> dateofengagement) {
		this.dateofengagements = dateofengagement;
	}

	 /**
	 * Return the value associated with the column: disabilities.
	 * @return A Set&lt;Disabilities&gt; object (this.disabilities)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Disabilities> getDisabilitieses() {
		return this.disabilitieses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Disabilities to the disabilitieses set.
	 * @param disabilities item to add
	 */
	public void addDisabilities(Disabilities disabilities) {
		disabilities.setEnrollmentid(this);
		this.disabilitieses.add(disabilities);
	}

  
	 /**  
	 * Set the value related to the column: disabilities.
	 * @param disabilities the disabilities value you wish to set
	 */
	public void setDisabilitieses(final Set<Disabilities> disabilities) {
		this.disabilitieses = disabilities;
	}

	 /**
	 * Return the value associated with the column: disablingcondition.
	 * @return A EnrollmentDisablingconditionEnum object (this.disablingcondition)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentDisablingconditionEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentDisablingconditionEnum getDisablingcondition() {
		return this.disablingcondition;
		
	}
	

  
	 /**  
	 * Set the value related to the column: disablingcondition.
	 * @param disablingcondition the disablingcondition value you wish to set
	 */
	public void setDisablingcondition(final EnrollmentDisablingconditionEnum disablingcondition) {
		this.disablingcondition = disablingcondition;
	}

	 /**
	 * Return the value associated with the column: domesticviolence.
	 * @return A Set&lt;Domesticviolence&gt; object (this.domesticviolence)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Domesticviolence> getDomesticviolences() {
		return this.domesticviolences;
		
	}
	
	/**
	 * Adds a bi-directional link of type Domesticviolence to the domesticviolences set.
	 * @param domesticviolence item to add
	 */
	public void addDomesticviolence(Domesticviolence domesticviolence) {
		domesticviolence.setEnrollmentid(this);
		this.domesticviolences.add(domesticviolence);
	}

  
	 /**  
	 * Set the value related to the column: domesticviolence.
	 * @param domesticviolence the domesticviolence value you wish to set
	 */
	public void setDomesticviolences(final Set<Domesticviolence> domesticviolence) {
		this.domesticviolences = domesticviolence;
	}

	 /**
	 * Return the value associated with the column: employment.
	 * @return A Set&lt;Employment&gt; object (this.employment)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Employment> getEmployments() {
		return this.employments;
		
	}
	
	/**
	 * Adds a bi-directional link of type Employment to the employments set.
	 * @param employment item to add
	 */
	public void addEmployment(Employment employment) {
		employment.setEnrollmentid(this);
		this.employments.add(employment);
	}

  
	 /**  
	 * Set the value related to the column: employment.
	 * @param employment the employment value you wish to set
	 */
	public void setEmployments(final Set<Employment> employment) {
		this.employments = employment;
	}

	 /**
	 * Return the value associated with the column: enrollmentCoc.
	 * @return A Set&lt;EnrollmentCoc&gt; object (this.enrollmentCoc)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<EnrollmentCoc> getEnrollmentCocs() {
		return this.enrollmentCocs;
		
	}
	
	/**
	 * Adds a bi-directional link of type EnrollmentCoc to the enrollmentCocs set.
	 * @param enrollmentCoc item to add
	 */
	public void addEnrollmentCoc(EnrollmentCoc enrollmentCoc) {
		enrollmentCoc.setEnrollmentid(this);
		this.enrollmentCocs.add(enrollmentCoc);
	}

  
	 /**  
	 * Set the value related to the column: enrollmentCoc.
	 * @param enrollmentCoc the enrollmentCoc value you wish to set
	 */
	public void setEnrollmentCocs(final Set<EnrollmentCoc> enrollmentCoc) {
		this.enrollmentCocs = enrollmentCoc;
	}

	 /**
	 * Return the value associated with the column: entrydate.
	 * @return A LocalDateTime object (this.entrydate)
	 */
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	@Basic( optional = true )
	@Column
	public LocalDateTime getEntrydate() {
		return this.entrydate;
		
	}
	

  
	 /**  
	 * Set the value related to the column: entrydate.
	 * @param entrydate the entrydate value you wish to set
	 */
	public void setEntrydate(final LocalDateTime entrydate) {
		this.entrydate = entrydate;
	}

	 /**
	 * Return the value associated with the column: exit.
	 * @return A Set&lt;Exit&gt; object (this.exit)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Exit> getExits() {
		return this.exits;
		
	}
	
	/**
	 * Adds a bi-directional link of type Exit to the exits set.
	 * @param exit item to add
	 */
	public void addExit(Exit exit) {
		exit.setEnrollmentid(this);
		this.exits.add(exit);
	}

  
	 /**  
	 * Set the value related to the column: exit.
	 * @param exit the exit value you wish to set
	 */
	public void setExits(final Set<Exit> exit) {
		this.exits = exit;
	}

	 /**
	 * Return the value associated with the column: formerwardchildwelfare.
	 * @return A Set&lt;Formerwardchildwelfare&gt; object (this.formerwardchildwelfare)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Formerwardchildwelfare> getFormerwardchildwelfares() {
		return this.formerwardchildwelfares;
		
	}
	
	/**
	 * Adds a bi-directional link of type Formerwardchildwelfare to the formerwardchildwelfares set.
	 * @param formerwardchildwelfare item to add
	 */
	public void addFormerwardchildwelfare(Formerwardchildwelfare formerwardchildwelfare) {
		formerwardchildwelfare.setEnrollmentid(this);
		this.formerwardchildwelfares.add(formerwardchildwelfare);
	}

  
	 /**  
	 * Set the value related to the column: formerwardchildwelfare.
	 * @param formerwardchildwelfare the formerwardchildwelfare value you wish to set
	 */
	public void setFormerwardchildwelfares(final Set<Formerwardchildwelfare> formerwardchildwelfare) {
		this.formerwardchildwelfares = formerwardchildwelfare;
	}

	 /**
	 * Return the value associated with the column: formerwardjuvenilejustice.
	 * @return A Set&lt;Formerwardjuvenilejustice&gt; object (this.formerwardjuvenilejustice)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Formerwardjuvenilejustice> getFormerwardjuvenilejustices() {
		return this.formerwardjuvenilejustices;
		
	}
	
	/**
	 * Adds a bi-directional link of type Formerwardjuvenilejustice to the formerwardjuvenilejustices set.
	 * @param formerwardjuvenilejustice item to add
	 */
	public void addFormerwardjuvenilejustice(Formerwardjuvenilejustice formerwardjuvenilejustice) {
		formerwardjuvenilejustice.setEnrollmentid(this);
		this.formerwardjuvenilejustices.add(formerwardjuvenilejustice);
	}

  
	 /**  
	 * Set the value related to the column: formerwardjuvenilejustice.
	 * @param formerwardjuvenilejustice the formerwardjuvenilejustice value you wish to set
	 */
	public void setFormerwardjuvenilejustices(final Set<Formerwardjuvenilejustice> formerwardjuvenilejustice) {
		this.formerwardjuvenilejustices = formerwardjuvenilejustice;
	}

	 /**
	 * Return the value associated with the column: healthinsurance.
	 * @return A Set&lt;Healthinsurance&gt; object (this.healthinsurance)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Healthinsurance> getHealthinsurances() {
		return this.healthinsurances;
		
	}
	
	/**
	 * Adds a bi-directional link of type Healthinsurance to the healthinsurances set.
	 * @param healthinsurance item to add
	 */
	public void addHealthinsurance(Healthinsurance healthinsurance) {
		healthinsurance.setEnrollmentid(this);
		this.healthinsurances.add(healthinsurance);
	}

  
	 /**  
	 * Set the value related to the column: healthinsurance.
	 * @param healthinsurance the healthinsurance value you wish to set
	 */
	public void setHealthinsurances(final Set<Healthinsurance> healthinsurance) {
		this.healthinsurances = healthinsurance;
	}

	 /**
	 * Return the value associated with the column: healthStatus.
	 * @return A Set&lt;HealthStatus&gt; object (this.healthStatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<HealthStatus> getHealthStatuses() {
		return this.healthStatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type HealthStatus to the healthStatuses set.
	 * @param healthStatus item to add
	 */
	public void addHealthStatus(HealthStatus healthStatus) {
		healthStatus.setEnrollmentid(this);
		this.healthStatuses.add(healthStatus);
	}

  
	 /**  
	 * Set the value related to the column: healthStatus.
	 * @param healthStatus the healthStatus value you wish to set
	 */
	public void setHealthStatuses(final Set<HealthStatus> healthStatus) {
		this.healthStatuses = healthStatus;
	}

	 /**
	 * Return the value associated with the column: householdid.
	 * @return A java.util.UUID object (this.householdid)
	 */
	@Basic( optional = true )
	@org.hibernate.annotations.Type(type="pg-uuid")
	public java.util.UUID getHouseholdid() {
		return this.householdid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: householdid.
	 * @param householdid the householdid value you wish to set
	 */
	public void setHouseholdid(final java.util.UUID householdid) {
		this.householdid = householdid;
	}

	 /**
	 * Return the value associated with the column: housingstatus.
	 * @return A EnrollmentHousingstatusEnum object (this.housingstatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentHousingstatusEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentHousingstatusEnum getHousingstatus() {
		return this.housingstatus;
		
	}
	

  
	 /**  
	 * Set the value related to the column: housingstatus.
	 * @param housingstatus the housingstatus value you wish to set
	 */
	public void setHousingstatus(final EnrollmentHousingstatusEnum housingstatus) {
		this.housingstatus = housingstatus;
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
	 * Return the value associated with the column: incomeandsources.
	 * @return A Set&lt;Incomeandsources&gt; object (this.incomeandsources)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Incomeandsources> getIncomeandsourceses() {
		return this.incomeandsourceses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Incomeandsources to the incomeandsourceses set.
	 * @param incomeandsources item to add
	 */
	public void addIncomeandsources(Incomeandsources incomeandsources) {
		incomeandsources.setEnrollmentid(this);
		this.incomeandsourceses.add(incomeandsources);
	}

  
	 /**  
	 * Set the value related to the column: incomeandsources.
	 * @param incomeandsources the incomeandsources value you wish to set
	 */
	public void setIncomeandsourceses(final Set<Incomeandsources> incomeandsources) {
		this.incomeandsourceses = incomeandsources;
	}

	 /**
	 * Return the value associated with the column: lastgradecompleted.
	 * @return A Set&lt;Lastgradecompleted&gt; object (this.lastgradecompleted)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Lastgradecompleted> getLastgradecompleteds() {
		return this.lastgradecompleteds;
		
	}
	
	/**
	 * Adds a bi-directional link of type Lastgradecompleted to the lastgradecompleteds set.
	 * @param lastgradecompleted item to add
	 */
	public void addLastgradecompleted(Lastgradecompleted lastgradecompleted) {
		lastgradecompleted.setEnrollmentid(this);
		this.lastgradecompleteds.add(lastgradecompleted);
	}

  
	 /**  
	 * Set the value related to the column: lastgradecompleted.
	 * @param lastgradecompleted the lastgradecompleted value you wish to set
	 */
	public void setLastgradecompleteds(final Set<Lastgradecompleted> lastgradecompleted) {
		this.lastgradecompleteds = lastgradecompleted;
	}

	 /**
	 * Return the value associated with the column: lastPermAddress.
	 * @return A Set&lt;LastPermAddress&gt; object (this.lastPermAddress)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<LastPermAddress> getLastPermAddresses() {
		return this.lastPermAddresses;
		
	}
	
	/**
	 * Adds a bi-directional link of type LastPermAddress to the lastPermAddresses set.
	 * @param lastPermAddress item to add
	 */
	public void addLastPermAddress(LastPermAddress lastPermAddress) {
		lastPermAddress.setEnrollmentid(this);
		this.lastPermAddresses.add(lastPermAddress);
	}

  
	 /**  
	 * Set the value related to the column: lastPermAddress.
	 * @param lastPermAddress the lastPermAddress value you wish to set
	 */
	public void setLastPermAddresses(final Set<LastPermAddress> lastPermAddress) {
		this.lastPermAddresses = lastPermAddress;
	}

	 /**
	 * Return the value associated with the column: medicalassistance.
	 * @return A Set&lt;Medicalassistance&gt; object (this.medicalassistance)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Medicalassistance> getMedicalassistances() {
		return this.medicalassistances;
		
	}
	
	/**
	 * Adds a bi-directional link of type Medicalassistance to the medicalassistances set.
	 * @param medicalassistance item to add
	 */
	public void addMedicalassistance(Medicalassistance medicalassistance) {
		medicalassistance.setEnrollmentid(this);
		this.medicalassistances.add(medicalassistance);
	}

  
	 /**  
	 * Set the value related to the column: medicalassistance.
	 * @param medicalassistance the medicalassistance value you wish to set
	 */
	public void setMedicalassistances(final Set<Medicalassistance> medicalassistance) {
		this.medicalassistances = medicalassistance;
	}

	 /**
	 * Return the value associated with the column: monthshomelesspastthreeyears.
	 * @return A EnrollmentMonthshomelesspastthreeyearsEnum object (this.monthshomelesspastthreeyears)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelesspastthreeyearsEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentMonthshomelesspastthreeyearsEnum getMonthshomelesspastthreeyears() {
		return this.monthshomelesspastthreeyears;
		
	}
	

  
	 /**  
	 * Set the value related to the column: monthshomelesspastthreeyears.
	 * @param monthshomelesspastthreeyears the monthshomelesspastthreeyears value you wish to set
	 */
	public void setMonthshomelesspastthreeyears(final EnrollmentMonthshomelesspastthreeyearsEnum monthshomelesspastthreeyears) {
		this.monthshomelesspastthreeyears = monthshomelesspastthreeyears;
	}

	 /**
	 * Return the value associated with the column: monthshomelessthistime.
	 * @return A EnrollmentMonthshomelessthistimeEnum object (this.monthshomelessthistime)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentMonthshomelessthistimeEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentMonthshomelessthistimeEnum getMonthshomelessthistime() {
		return this.monthshomelessthistime;
		
	}
	

  
	 /**  
	 * Set the value related to the column: monthshomelessthistime.
	 * @param monthshomelessthistime the monthshomelessthistime value you wish to set
	 */
	public void setMonthshomelessthistime(final EnrollmentMonthshomelessthistimeEnum monthshomelessthistime) {
		this.monthshomelessthistime = monthshomelessthistime;
	}

	 /**
	 * Return the value associated with the column: noncashbenefits.
	 * @return A Set&lt;Noncashbenefits&gt; object (this.noncashbenefits)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Noncashbenefits> getNoncashbenefitss() {
		return this.noncashbenefitss;
		
	}
	
	/**
	 * Adds a bi-directional link of type Noncashbenefits to the noncashbenefitss set.
	 * @param noncashbenefits item to add
	 */
	public void addNoncashbenefits(Noncashbenefits noncashbenefits) {
		noncashbenefits.setEnrollmentid(this);
		this.noncashbenefitss.add(noncashbenefits);
	}

  
	 /**  
	 * Set the value related to the column: noncashbenefits.
	 * @param noncashbenefits the noncashbenefits value you wish to set
	 */
	public void setNoncashbenefitss(final Set<Noncashbenefits> noncashbenefits) {
		this.noncashbenefitss = noncashbenefits;
	}

	 /**
	 * Return the value associated with the column: otherresidenceprior.
	 * @return A String object (this.otherresidenceprior)
	 */
	@Basic( optional = true )
	@Column( length = 50  )
	public String getOtherresidenceprior() {
		return this.otherresidenceprior;
		
	}
	

  
	 /**  
	 * Set the value related to the column: otherresidenceprior.
	 * @param otherresidenceprior the otherresidenceprior value you wish to set
	 */
	public void setOtherresidenceprior(final String otherresidenceprior) {
		this.otherresidenceprior = otherresidenceprior;
	}

	 /**
	 * Return the value associated with the column: pathstatus.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Pathstatus&gt; object (this.pathstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> getPathstatuses() {
		return this.pathstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Pathstatus to the pathstatuses set.
	 * @param pathstatus item to add
	 */
	public void addPathstatus(com.servinglynk.hmis.warehouse.model.staging.Pathstatus pathstatus) {
		pathstatus.setEnrollmentid(this);
		this.pathstatuses.add(pathstatus);
	}

  
	 /**  
	 * Set the value related to the column: pathstatus.
	 * @param pathstatus the pathstatus value you wish to set
	 */
	public void setPathstatuses(final Set<com.servinglynk.hmis.warehouse.model.staging.Pathstatus> pathstatus) {
		this.pathstatuses = pathstatus;
	}

	 /**
	 * Return the value associated with the column: percentami.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Percentami&gt; object (this.percentami)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> getPercentamis() {
		return this.percentamis;
		
	}
	
	/**
	 * Adds a bi-directional link of type Percentami to the percentamis set.
	 * @param percentami item to add
	 */
	public void addPercentami(com.servinglynk.hmis.warehouse.model.staging.Percentami percentami) {
		percentami.setEnrollmentid(this);
		this.percentamis.add(percentami);
	}

  
	 /**  
	 * Set the value related to the column: percentami.
	 * @param percentami the percentami value you wish to set
	 */
	public void setPercentamis(final Set<com.servinglynk.hmis.warehouse.model.staging.Percentami> percentami) {
		this.percentamis = percentami;
	}

	 /**
	 * Return the value associated with the column: personalid.
	 * @return A java.util.UUID object (this.personalid)
	 */
	@Basic( optional = true )
	@org.hibernate.annotations.Type(type="pg-uuid")
	public java.util.UUID getPersonalid() {
		return this.personalid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: personalid.
	 * @param personalid the personalid value you wish to set
	 */
	public void setPersonalid(final java.util.UUID personalid) {
		this.personalid = personalid;
	}

	 /**
	 * Return the value associated with the column: project.
	 * @return A Set&lt;Project&gt; object (this.project)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Project> getProjects() {
		return this.projects;
		
	}
	
	/**
	 * Adds a bi-directional link of type Project to the projects set.
	 * @param project item to add
	 */
	public void addProject(Project project) {
		project.setEnrollmentid(this);
		this.projects.add(project);
	}

  
	 /**  
	 * Set the value related to the column: project.
	 * @param project the project value you wish to set
	 */
	public void setProjects(final Set<Project> project) {
		this.projects = project;
	}

	 /**
	 * Return the value associated with the column: projectentryid.
	 * @return A java.util.UUID object (this.projectentryid)
	 */
	@Basic( optional = true )
	@org.hibernate.annotations.Type(type="pg-uuid")
	public java.util.UUID getProjectentryid() {
		return this.projectentryid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectentryid.
	 * @param projectentryid the projectentryid value you wish to set
	 */
	public void setProjectentryid(final java.util.UUID projectentryid) {
		this.projectentryid = projectentryid;
	}

	 /**
	 * Return the value associated with the column: projectid.
	 * @return A java.util.UUID object (this.projectid)
	 */
	@Basic( optional = true )
	@org.hibernate.annotations.Type(type="pg-uuid")
	public java.util.UUID getProjectid() {
		return this.projectid;
		
	}
	

  
	 /**  
	 * Set the value related to the column: projectid.
	 * @param projectid the projectid value you wish to set
	 */
	public void setProjectid(final java.util.UUID projectid) {
		this.projectid = projectid;
	}

	 /**
	 * Return the value associated with the column: referralsource.
	 * @return A Set&lt;Referralsource&gt; object (this.referralsource)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Referralsource> getReferralsources() {
		return this.referralsources;
		
	}
	
	/**
	 * Adds a bi-directional link of type Referralsource to the referralsources set.
	 * @param referralsource item to add
	 */
	public void addReferralsource(Referralsource referralsource) {
		referralsource.setEnrollmentid(this);
		this.referralsources.add(referralsource);
	}

  
	 /**  
	 * Set the value related to the column: referralsource.
	 * @param referralsource the referralsource value you wish to set
	 */
	public void setReferralsources(final Set<Referralsource> referralsource) {
		this.referralsources = referralsource;
	}

	 /**
	 * Return the value associated with the column: relationshiptohoh.
	 * @return A EnrollmentRelationshiptohohEnum object (this.relationshiptohoh)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentRelationshiptohohEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentRelationshiptohohEnum getRelationshiptohoh() {
		return this.relationshiptohoh;
		
	}
	

  
	 /**  
	 * Set the value related to the column: relationshiptohoh.
	 * @param relationshiptohoh the relationshiptohoh value you wish to set
	 */
	public void setRelationshiptohoh(final EnrollmentRelationshiptohohEnum relationshiptohoh) {
		this.relationshiptohoh = relationshiptohoh;
	}

	 /**
	 * Return the value associated with the column: residenceprior.
	 * @return A EnrollmentResidencepriorEnum object (this.residenceprior)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentResidencepriorEnum getResidenceprior() {
		return this.residenceprior;
		
	}
	

  
	 /**  
	 * Set the value related to the column: residenceprior.
	 * @param residenceprior the residenceprior value you wish to set
	 */
	public void setResidenceprior(final EnrollmentResidencepriorEnum residenceprior) {
		this.residenceprior = residenceprior;
	}

	 /**
	 * Return the value associated with the column: residencepriorlengthofstay.
	 * @return A EnrollmentResidencepriorlengthofstayEnum object (this.residencepriorlengthofstay)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentResidencepriorlengthofstayEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentResidencepriorlengthofstayEnum getResidencepriorlengthofstay() {
		return this.residencepriorlengthofstay;
		
	}
	

  
	 /**  
	 * Set the value related to the column: residencepriorlengthofstay.
	 * @param residencepriorlengthofstay the residencepriorlengthofstay value you wish to set
	 */
	public void setResidencepriorlengthofstay(final EnrollmentResidencepriorlengthofstayEnum residencepriorlengthofstay) {
		this.residencepriorlengthofstay = residencepriorlengthofstay;
	}

	 /**
	 * Return the value associated with the column: residentialmoveindate.
	 * @return A Set&lt;Residentialmoveindate&gt; object (this.residentialmoveindate)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Residentialmoveindate> getResidentialmoveindates() {
		return this.residentialmoveindates;
		
	}
	
	/**
	 * Adds a bi-directional link of type Residentialmoveindate to the residentialmoveindates set.
	 * @param residentialmoveindate item to add
	 */
	public void addResidentialmoveindate(Residentialmoveindate residentialmoveindate) {
		residentialmoveindate.setEnrollmentid(this);
		this.residentialmoveindates.add(residentialmoveindate);
	}

  
	 /**  
	 * Set the value related to the column: residentialmoveindate.
	 * @param residentialmoveindate the residentialmoveindate value you wish to set
	 */
	public void setResidentialmoveindates(final Set<Residentialmoveindate> residentialmoveindate) {
		this.residentialmoveindates = residentialmoveindate;
	}

	 /**
	 * Return the value associated with the column: rhybcpstatus.
	 * @return A Set&lt;com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus&gt; object (this.rhybcpstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> getRhybcpstatuses() {
		return this.rhybcpstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Rhybcpstatus to the rhybcpstatuses set.
	 * @param rhybcpstatus item to add
	 */
	public void addRhybcpstatus(com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus rhybcpstatus) {
		rhybcpstatus.setEnrollmentid(this);
		this.rhybcpstatuses.add(rhybcpstatus);
	}

  
	 /**  
	 * Set the value related to the column: rhybcpstatus.
	 * @param rhybcpstatus the rhybcpstatus value you wish to set
	 */
	public void setRhybcpstatuses(final Set<com.servinglynk.hmis.warehouse.model.staging.Rhybcpstatus> rhybcpstatus) {
		this.rhybcpstatuses = rhybcpstatus;
	}

	 /**
	 * Return the value associated with the column: schoolstatus.
	 * @return A Set&lt;Schoolstatus&gt; object (this.schoolstatus)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Schoolstatus> getSchoolstatuses() {
		return this.schoolstatuses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Schoolstatus to the schoolstatuses set.
	 * @param schoolstatus item to add
	 */
	public void addSchoolstatus(Schoolstatus schoolstatus) {
		schoolstatus.setEnrollmentid(this);
		this.schoolstatuses.add(schoolstatus);
	}

  
	 /**  
	 * Set the value related to the column: schoolstatus.
	 * @param schoolstatus the schoolstatus value you wish to set
	 */
	public void setSchoolstatuses(final Set<Schoolstatus> schoolstatus) {
		this.schoolstatuses = schoolstatus;
	}

	 /**
	 * Return the value associated with the column: services.
	 * @return A Set&lt;Services&gt; object (this.services)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Services> getServiceses() {
		return this.serviceses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Services to the serviceses set.
	 * @param services item to add
	 */
	public void addServices(Services services) {
		services.setEnrollmentid(this);
		this.serviceses.add(services);
	}

  
	 /**  
	 * Set the value related to the column: services.
	 * @param services the services value you wish to set
	 */
	public void setServiceses(final Set<Services> services) {
		this.serviceses = services;
	}

	 /**
	 * Return the value associated with the column: sexualorientation.
	 * @return A Set&lt;Sexualorientation&gt; object (this.sexualorientation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Sexualorientation> getSexualorientations() {
		return this.sexualorientations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Sexualorientation to the sexualorientations set.
	 * @param sexualorientation item to add
	 */
	public void addSexualorientation(Sexualorientation sexualorientation) {
		sexualorientation.setEnrollmentid(this);
		this.sexualorientations.add(sexualorientation);
	}

  
	 /**  
	 * Set the value related to the column: sexualorientation.
	 * @param sexualorientation the sexualorientation value you wish to set
	 */
	public void setSexualorientations(final Set<Sexualorientation> sexualorientation) {
		this.sexualorientations = sexualorientation;
	}

	 /**
	 * Return the value associated with the column: statusdocumented.
	 * @return A EnrollmentStatusdocumentedEnum object (this.statusdocumented)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentStatusdocumentedEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentStatusdocumentedEnum getStatusdocumented() {
		return this.statusdocumented;
		
	}
	

  
	 /**  
	 * Set the value related to the column: statusdocumented.
	 * @param statusdocumented the statusdocumented value you wish to set
	 */
	public void setStatusdocumented(final EnrollmentStatusdocumentedEnum statusdocumented) {
		this.statusdocumented = statusdocumented;
	}

	 /**
	 * Return the value associated with the column: timeshomelesspastthreeyears.
	 * @return A EnrollmentTimeshomelesspastthreeyearsEnum object (this.timeshomelesspastthreeyears)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.EnrollmentTimeshomelesspastthreeyearsEnumType")
	@Basic( optional = true )
	@Column
	public EnrollmentTimeshomelesspastthreeyearsEnum getTimeshomelesspastthreeyears() {
		return this.timeshomelesspastthreeyears;
		
	}
	

  
	 /**  
	 * Set the value related to the column: timeshomelesspastthreeyears.
	 * @param timeshomelesspastthreeyears the timeshomelesspastthreeyears value you wish to set
	 */
	public void setTimeshomelesspastthreeyears(final EnrollmentTimeshomelesspastthreeyearsEnum timeshomelesspastthreeyears) {
		this.timeshomelesspastthreeyears = timeshomelesspastthreeyears;
	}

	 /**
	 * Return the value associated with the column: worsthousingsituation.
	 * @return A Set&lt;Worsthousingsituation&gt; object (this.worsthousingsituation)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Worsthousingsituation> getWorsthousingsituations() {
		return this.worsthousingsituations;
		
	}
	
	/**
	 * Adds a bi-directional link of type Worsthousingsituation to the worsthousingsituations set.
	 * @param worsthousingsituation item to add
	 */
	public void addWorsthousingsituation(Worsthousingsituation worsthousingsituation) {
		worsthousingsituation.setEnrollmentid(this);
		this.worsthousingsituations.add(worsthousingsituation);
	}

	 /**  
	 * Set the value related to the column: worsthousingsituation.
	 * @param worsthousingsituation the worsthousingsituation value you wish to set
	 */
	public void setWorsthousingsituations(final Set<Worsthousingsituation> worsthousingsituation) {
		this.worsthousingsituations = worsthousingsituation;
	}

	 /**
	 * Return the value associated with the column: yearshomeless.
	 * @return A Integer object (this.yearshomeless)
	 */
	public Integer getYearshomeless() {
		return this.yearshomeless;
		
	}
	

  
	 /**  
	 * Set the value related to the column: yearshomeless.
	 * @param yearshomeless the yearshomeless value you wish to set
	 */
	public void setYearshomeless(final Integer yearshomeless) {
		this.yearshomeless = yearshomeless;
	}

	 /**
	 * Return the value associated with the column: youthcriticalissues.
	 * @return A Set&lt;Youthcriticalissues&gt; object (this.youthcriticalissues)
	 */
 	@OneToMany( fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE }, mappedBy = "enrollmentid"  )
 	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.ALL})
	@Basic( optional = false )
	@Column( nullable = false  )
	public Set<Youthcriticalissues> getYouthcriticalissueses() {
		return this.youthcriticalissueses;
		
	}
	
	/**
	 * Adds a bi-directional link of type Youthcriticalissues to the youthcriticalissueses set.
	 * @param youthcriticalissues item to add
	 */
	public void addYouthcriticalissues(Youthcriticalissues youthcriticalissues) {
		youthcriticalissues.setEnrollmentid(this);
		this.youthcriticalissueses.add(youthcriticalissues);
	}

  
	 /**  
	 * Set the value related to the column: youthcriticalissues.
	 * @param youthcriticalissues the youthcriticalissues value you wish to set
	 */
	public void setYouthcriticalissueses(final Set<Youthcriticalissues> youthcriticalissues) {
		this.youthcriticalissueses = youthcriticalissues;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Enrollment clone() throws CloneNotSupportedException {
		
        final Enrollment copy = (Enrollment)super.clone();
        copy.setClient(this.getClient());
		if (this.getCommercialsexualexploitations() != null) {
			copy.getCommercialsexualexploitations().addAll(this.getCommercialsexualexploitations());
		}
		copy.setContinuouslyhomelessoneyear(this.getContinuouslyhomelessoneyear());
		if (this.getDateofengagements() != null) {
			copy.getDateofengagements().addAll(this.getDateofengagements());
		}
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		if (this.getDisabilitieses() != null) {
			copy.getDisabilitieses().addAll(this.getDisabilitieses());
		}
		copy.setDisablingcondition(this.getDisablingcondition());
		if (this.getDomesticviolences() != null) {
			copy.getDomesticviolences().addAll(this.getDomesticviolences());
		}
		if (this.getEmployments() != null) {
			copy.getEmployments().addAll(this.getEmployments());
		}
		if (this.getEnrollmentCocs() != null) {
			copy.getEnrollmentCocs().addAll(this.getEnrollmentCocs());
		}
		copy.setEntrydate(this.getEntrydate());
		if (this.getExits() != null) {
			copy.getExits().addAll(this.getExits());
		}
		if (this.getFormerwardchildwelfares() != null) {
			copy.getFormerwardchildwelfares().addAll(this.getFormerwardchildwelfares());
		}
		if (this.getFormerwardjuvenilejustices() != null) {
			copy.getFormerwardjuvenilejustices().addAll(this.getFormerwardjuvenilejustices());
		}
		if (this.getHealthinsurances() != null) {
			copy.getHealthinsurances().addAll(this.getHealthinsurances());
		}
		if (this.getHealthStatuses() != null) {
			copy.getHealthStatuses().addAll(this.getHealthStatuses());
		}
		copy.setHouseholdid(this.getHouseholdid());
		copy.setHousingstatus(this.getHousingstatus());
		copy.setId(this.getId());
		if (this.getIncomeandsourceses() != null) {
			copy.getIncomeandsourceses().addAll(this.getIncomeandsourceses());
		}
		if (this.getLastgradecompleteds() != null) {
			copy.getLastgradecompleteds().addAll(this.getLastgradecompleteds());
		}
		if (this.getLastPermAddresses() != null) {
			copy.getLastPermAddresses().addAll(this.getLastPermAddresses());
		}
		if (this.getMedicalassistances() != null) {
			copy.getMedicalassistances().addAll(this.getMedicalassistances());
		}
		copy.setMonthshomelesspastthreeyears(this.getMonthshomelesspastthreeyears());
		copy.setMonthshomelessthistime(this.getMonthshomelessthistime());
		if (this.getNoncashbenefitss() != null) {
			copy.getNoncashbenefitss().addAll(this.getNoncashbenefitss());
		}
		copy.setOtherresidenceprior(this.getOtherresidenceprior());
		if (this.getPathstatuses() != null) {
			copy.getPathstatuses().addAll(this.getPathstatuses());
		}
		if (this.getPercentamis() != null) {
			copy.getPercentamis().addAll(this.getPercentamis());
		}
		copy.setPersonalid(this.getPersonalid());
		if (this.getProjects() != null) {
			copy.getProjects().addAll(this.getProjects());
		}
		copy.setProjectentryid(this.getProjectentryid());
		copy.setProjectid(this.getProjectid());
		if (this.getReferralsources() != null) {
			copy.getReferralsources().addAll(this.getReferralsources());
		}
		copy.setRelationshiptohoh(this.getRelationshiptohoh());
		copy.setResidenceprior(this.getResidenceprior());
		copy.setResidencepriorlengthofstay(this.getResidencepriorlengthofstay());
		if (this.getResidentialmoveindates() != null) {
			copy.getResidentialmoveindates().addAll(this.getResidentialmoveindates());
		}
		if (this.getRhybcpstatuses() != null) {
			copy.getRhybcpstatuses().addAll(this.getRhybcpstatuses());
		}
		if (this.getSchoolstatuses() != null) {
			copy.getSchoolstatuses().addAll(this.getSchoolstatuses());
		}
		if (this.getServiceses() != null) {
			copy.getServiceses().addAll(this.getServiceses());
		}
		if (this.getSexualorientations() != null) {
			copy.getSexualorientations().addAll(this.getSexualorientations());
		}
		copy.setStatusdocumented(this.getStatusdocumented());
		copy.setTimeshomelesspastthreeyears(this.getTimeshomelesspastthreeyears());
		copy.setUser(this.getUser());
		if (this.getWorsthousingsituations() != null) {
			copy.getWorsthousingsituations().addAll(this.getWorsthousingsituations());
		}
		copy.setYearshomeless(this.getYearshomeless());
		if (this.getYouthcriticalissueses() != null) {
			copy.getYouthcriticalissueses().addAll(this.getYouthcriticalissueses());
		}
		return copy;
	}
	


	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		sb.append("continuouslyhomelessoneyear: " + this.getContinuouslyhomelessoneyear() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("disablingcondition: " + this.getDisablingcondition() + ", ");
		sb.append("entrydate: " + this.getEntrydate() + ", ");
		sb.append("householdid: " + this.getHouseholdid() + ", ");
		sb.append("housingstatus: " + this.getHousingstatus() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("monthshomelesspastthreeyears: " + this.getMonthshomelesspastthreeyears() + ", ");
		sb.append("monthshomelessthistime: " + this.getMonthshomelessthistime() + ", ");
		sb.append("otherresidenceprior: " + this.getOtherresidenceprior() + ", ");
		sb.append("personalid: " + this.getPersonalid() + ", ");
		sb.append("projectentryid: " + this.getProjectentryid() + ", ");
		sb.append("projectid: " + this.getProjectid() + ", ");
		sb.append("relationshiptohoh: " + this.getRelationshiptohoh() + ", ");
		sb.append("residenceprior: " + this.getResidenceprior() + ", ");
		sb.append("residencepriorlengthofstay: " + this.getResidencepriorlengthofstay() + ", ");
		sb.append("statusdocumented: " + this.getStatusdocumented() + ", ");
		sb.append("timeshomelesspastthreeyears: " + this.getTimeshomelesspastthreeyears() + ", ");
		sb.append("yearshomeless: " + this.getYearshomeless() + ", ");
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
		
		final Enrollment that; 
		try {
			that = (Enrollment) proxyThat;
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
		result = result && (((getContinuouslyhomelessoneyear() == null) && (that.getContinuouslyhomelessoneyear() == null)) || (getContinuouslyhomelessoneyear() != null && getContinuouslyhomelessoneyear().equals(that.getContinuouslyhomelessoneyear())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDisablingcondition() == null) && (that.getDisablingcondition() == null)) || (getDisablingcondition() != null && getDisablingcondition().equals(that.getDisablingcondition())));
		result = result && (((getEntrydate() == null) && (that.getEntrydate() == null)) || (getEntrydate() != null && getEntrydate().equals(that.getEntrydate())));
		result = result && (((getHouseholdid() == null) && (that.getHouseholdid() == null)) || (getHouseholdid() != null && getHouseholdid().equals(that.getHouseholdid())));
		result = result && (((getHousingstatus() == null) && (that.getHousingstatus() == null)) || (getHousingstatus() != null && getHousingstatus().equals(that.getHousingstatus())));
		result = result && (((getMonthshomelesspastthreeyears() == null) && (that.getMonthshomelesspastthreeyears() == null)) || (getMonthshomelesspastthreeyears() != null && getMonthshomelesspastthreeyears().equals(that.getMonthshomelesspastthreeyears())));
		result = result && (((getMonthshomelessthistime() == null) && (that.getMonthshomelessthistime() == null)) || (getMonthshomelessthistime() != null && getMonthshomelessthistime().equals(that.getMonthshomelessthistime())));
		result = result && (((getOtherresidenceprior() == null) && (that.getOtherresidenceprior() == null)) || (getOtherresidenceprior() != null && getOtherresidenceprior().equals(that.getOtherresidenceprior())));
		result = result && (((getPersonalid() == null) && (that.getPersonalid() == null)) || (getPersonalid() != null && getPersonalid().equals(that.getPersonalid())));
		result = result && (((getProjectentryid() == null) && (that.getProjectentryid() == null)) || (getProjectentryid() != null && getProjectentryid().equals(that.getProjectentryid())));
		result = result && (((getProjectid() == null) && (that.getProjectid() == null)) || (getProjectid() != null && getProjectid().equals(that.getProjectid())));
		result = result && (((getRelationshiptohoh() == null) && (that.getRelationshiptohoh() == null)) || (getRelationshiptohoh() != null && getRelationshiptohoh().equals(that.getRelationshiptohoh())));
		result = result && (((getResidenceprior() == null) && (that.getResidenceprior() == null)) || (getResidenceprior() != null && getResidenceprior().equals(that.getResidenceprior())));
		result = result && (((getResidencepriorlengthofstay() == null) && (that.getResidencepriorlengthofstay() == null)) || (getResidencepriorlengthofstay() != null && getResidencepriorlengthofstay().equals(that.getResidencepriorlengthofstay())));
		result = result && (((getStatusdocumented() == null) && (that.getStatusdocumented() == null)) || (getStatusdocumented() != null && getStatusdocumented().equals(that.getStatusdocumented())));
		result = result && (((getTimeshomelesspastthreeyears() == null) && (that.getTimeshomelesspastthreeyears() == null)) || (getTimeshomelesspastthreeyears() != null && getTimeshomelesspastthreeyears().equals(that.getTimeshomelesspastthreeyears())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().getId().equals(that.getUser().getId())));	
		result = result && (((getYearshomeless() == null) && (that.getYearshomeless() == null)) || (getYearshomeless() != null && getYearshomeless().equals(that.getYearshomeless())));
		return result;
	}
	
}
