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

import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnum;
import com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnum;


/**
 * Object mapping for hibernate-handled table: youthcriticalissues.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "youthcriticalissues")
@Table(name = "youthcriticalissues", catalog = "hmis", schema = "v2014")
public class Youthcriticalissues extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = 4114356379054175522L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private YouthcriticalissuesAbuseandneglectfamEnum abuseandneglectfam;
	/** Field mapping. */
	private YouthcriticalissuesAbuseandneglectyouthEnum abuseandneglectyouth;
	/** Field mapping. */
	private YouthcriticalissuesActivemilitaryparentEnum activemilitaryparent;
	/** Field mapping. */
	private YouthcriticalissuesAlcoholdrugabusefamEnum alcoholdrugabusefam;
	/** Field mapping. */
	private YouthcriticalissuesAlcoholdrugabuseyouthEnum alcoholdrugabuseyouth;
	/** Field mapping. */
	private Enrollment enrollmentid;
	/** Field mapping. */
	private YouthcriticalissuesHealthissuesfamEnum healthissuesfam;
	/** Field mapping. */
	private YouthcriticalissuesHealthissuesyouthEnum healthissuesyouth;
	/** Field mapping. */
	private YouthcriticalissuesHouseholddynamicsEnum householddynamics;
	/** Field mapping. */
	private YouthcriticalissuesHousingissuesfamEnum housingissuesfam;
	/** Field mapping. */
	private YouthcriticalissuesHousingissuesyouthEnum housingissuesyouth;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private YouthcriticalissuesIncarceratedparentEnum incarceratedparent;
	/** Field mapping. */
	private YouthcriticalissuesIncarceratedparentstatusEnum incarceratedparentstatus;
	/** Field mapping. */
	private YouthcriticalissuesInsufficientincomeEnum insufficientincome;
	/** Field mapping. */
	private YouthcriticalissuesMentaldisabilityfamEnum mentaldisabilityfam;
	/** Field mapping. */
	private YouthcriticalissuesMentaldisabilityyouthEnum mentaldisabilityyouth;
	/** Field mapping. */
	private YouthcriticalissuesMentalhealthissuesfamEnum mentalhealthissuesfam;
	/** Field mapping. */
	private YouthcriticalissuesMentalhealthissuesyouthEnum mentalhealthissuesyouth;
	/** Field mapping. */
	private YouthcriticalissuesPhysicaldisabilityfamEnum physicaldisabilityfam;
	/** Field mapping. */
	private YouthcriticalissuesPhysicaldisabilityyouthEnum physicaldisabilityyouth;
	/** Field mapping. */
	private YouthcriticalissuesSchooleducationalissuesfamEnum schooleducationalissuesfam;
	/** Field mapping. */
	private YouthcriticalissuesSchooleducationalissuesyouthEnum schooleducationalissuesyouth;
	/** Field mapping. */
	private YouthcriticalissuesSexualorientationgenderidfamEnum sexualorientationgenderidfam;
	/** Field mapping. */
	private YouthcriticalissuesSexualorientationgenderidyouthEnum sexualorientationgenderidyouth;
	/** Field mapping. */
	private YouthcriticalissuesUnemploymentfamEnum unemploymentfam;
	/** Field mapping. */
	private YouthcriticalissuesUnemploymentyouthEnum unemploymentyouth;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public Youthcriticalissues() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public Youthcriticalissues(java.util.UUID id) {
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
		return Youthcriticalissues.class;
	}


	 /**
	 * Return the value associated with the column: abuseandneglectfam.
	 * @return A YouthcriticalissuesAbuseandneglectfamEnum object (this.abuseandneglectfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesAbuseandneglectfamEnum getAbuseandneglectfam() {
		return this.abuseandneglectfam;

	}



	 /**
	 * Set the value related to the column: abuseandneglectfam.
	 * @param abuseandneglectfam the abuseandneglectfam value you wish to set
	 */
	public void setAbuseandneglectfam(final YouthcriticalissuesAbuseandneglectfamEnum abuseandneglectfam) {
		this.abuseandneglectfam = abuseandneglectfam;
	}

	 /**
	 * Return the value associated with the column: abuseandneglectyouth.
	 * @return A YouthcriticalissuesAbuseandneglectyouthEnum object (this.abuseandneglectyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAbuseandneglectyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesAbuseandneglectyouthEnum getAbuseandneglectyouth() {
		return this.abuseandneglectyouth;

	}



	 /**
	 * Set the value related to the column: abuseandneglectyouth.
	 * @param abuseandneglectyouth the abuseandneglectyouth value you wish to set
	 */
	public void setAbuseandneglectyouth(final YouthcriticalissuesAbuseandneglectyouthEnum abuseandneglectyouth) {
		this.abuseandneglectyouth = abuseandneglectyouth;
	}

	 /**
	 * Return the value associated with the column: activemilitaryparent.
	 * @return A YouthcriticalissuesActivemilitaryparentEnum object (this.activemilitaryparent)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesActivemilitaryparentEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesActivemilitaryparentEnum getActivemilitaryparent() {
		return this.activemilitaryparent;

	}



	 /**
	 * Set the value related to the column: activemilitaryparent.
	 * @param activemilitaryparent the activemilitaryparent value you wish to set
	 */
	public void setActivemilitaryparent(final YouthcriticalissuesActivemilitaryparentEnum activemilitaryparent) {
		this.activemilitaryparent = activemilitaryparent;
	}

	 /**
	 * Return the value associated with the column: alcoholdrugabusefam.
	 * @return A YouthcriticalissuesAlcoholdrugabusefamEnum object (this.alcoholdrugabusefam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabusefamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesAlcoholdrugabusefamEnum getAlcoholdrugabusefam() {
		return this.alcoholdrugabusefam;

	}



	 /**
	 * Set the value related to the column: alcoholdrugabusefam.
	 * @param alcoholdrugabusefam the alcoholdrugabusefam value you wish to set
	 */
	public void setAlcoholdrugabusefam(final YouthcriticalissuesAlcoholdrugabusefamEnum alcoholdrugabusefam) {
		this.alcoholdrugabusefam = alcoholdrugabusefam;
	}

	 /**
	 * Return the value associated with the column: alcoholdrugabuseyouth.
	 * @return A YouthcriticalissuesAlcoholdrugabuseyouthEnum object (this.alcoholdrugabuseyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesAlcoholdrugabuseyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesAlcoholdrugabuseyouthEnum getAlcoholdrugabuseyouth() {
		return this.alcoholdrugabuseyouth;

	}



	 /**
	 * Set the value related to the column: alcoholdrugabuseyouth.
	 * @param alcoholdrugabuseyouth the alcoholdrugabuseyouth value you wish to set
	 */
	public void setAlcoholdrugabuseyouth(final YouthcriticalissuesAlcoholdrugabuseyouthEnum alcoholdrugabuseyouth) {
		this.alcoholdrugabuseyouth = alcoholdrugabuseyouth;
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
	 * Return the value associated with the column: healthissuesfam.
	 * @return A YouthcriticalissuesHealthissuesfamEnum object (this.healthissuesfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesHealthissuesfamEnum getHealthissuesfam() {
		return this.healthissuesfam;

	}

	 /**
	 * Set the value related to the column: healthissuesfam.
	 * @param healthissuesfam the healthissuesfam value you wish to set
	 */
	public void setHealthissuesfam(final YouthcriticalissuesHealthissuesfamEnum healthissuesfam) {
		this.healthissuesfam = healthissuesfam;
	}

	 /**
	 * Return the value associated with the column: healthissuesyouth.
	 * @return A YouthcriticalissuesHealthissuesyouthEnum object (this.healthissuesyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHealthissuesyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesHealthissuesyouthEnum getHealthissuesyouth() {
		return this.healthissuesyouth;

	}



	 /**
	 * Set the value related to the column: healthissuesyouth.
	 * @param healthissuesyouth the healthissuesyouth value you wish to set
	 */
	public void setHealthissuesyouth(final YouthcriticalissuesHealthissuesyouthEnum healthissuesyouth) {
		this.healthissuesyouth = healthissuesyouth;
	}

	 /**
	 * Return the value associated with the column: householddynamics.
	 * @return A YouthcriticalissuesHouseholddynamicsEnum object (this.householddynamics)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHouseholddynamicsEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesHouseholddynamicsEnum getHouseholddynamics() {
		return this.householddynamics;

	}



	 /**
	 * Set the value related to the column: householddynamics.
	 * @param householddynamics the householddynamics value you wish to set
	 */
	public void setHouseholddynamics(final YouthcriticalissuesHouseholddynamicsEnum householddynamics) {
		this.householddynamics = householddynamics;
	}

	 /**
	 * Return the value associated with the column: housingissuesfam.
	 * @return A YouthcriticalissuesHousingissuesfamEnum object (this.housingissuesfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesHousingissuesfamEnum getHousingissuesfam() {
		return this.housingissuesfam;

	}



	 /**
	 * Set the value related to the column: housingissuesfam.
	 * @param housingissuesfam the housingissuesfam value you wish to set
	 */
	public void setHousingissuesfam(final YouthcriticalissuesHousingissuesfamEnum housingissuesfam) {
		this.housingissuesfam = housingissuesfam;
	}

	 /**
	 * Return the value associated with the column: housingissuesyouth.
	 * @return A YouthcriticalissuesHousingissuesyouthEnum object (this.housingissuesyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesHousingissuesyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesHousingissuesyouthEnum getHousingissuesyouth() {
		return this.housingissuesyouth;

	}



	 /**
	 * Set the value related to the column: housingissuesyouth.
	 * @param housingissuesyouth the housingissuesyouth value you wish to set
	 */
	public void setHousingissuesyouth(final YouthcriticalissuesHousingissuesyouthEnum housingissuesyouth) {
		this.housingissuesyouth = housingissuesyouth;
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
	 * Return the value associated with the column: incarceratedparent.
	 * @return A YouthcriticalissuesIncarceratedparentEnum object (this.incarceratedparent)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesIncarceratedparentEnum getIncarceratedparent() {
		return this.incarceratedparent;

	}



	 /**
	 * Set the value related to the column: incarceratedparent.
	 * @param incarceratedparent the incarceratedparent value you wish to set
	 */
	public void setIncarceratedparent(final YouthcriticalissuesIncarceratedparentEnum incarceratedparent) {
		this.incarceratedparent = incarceratedparent;
	}

	 /**
	 * Return the value associated with the column: incarceratedparentstatus.
	 * @return A YouthcriticalissuesIncarceratedparentstatusEnum object (this.incarceratedparentstatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesIncarceratedparentstatusEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesIncarceratedparentstatusEnum getIncarceratedparentstatus() {
		return this.incarceratedparentstatus;

	}



	 /**
	 * Set the value related to the column: incarceratedparentstatus.
	 * @param incarceratedparentstatus the incarceratedparentstatus value you wish to set
	 */
	public void setIncarceratedparentstatus(final YouthcriticalissuesIncarceratedparentstatusEnum incarceratedparentstatus) {
		this.incarceratedparentstatus = incarceratedparentstatus;
	}

	 /**
	 * Return the value associated with the column: insufficientincome.
	 * @return A YouthcriticalissuesInsufficientincomeEnum object (this.insufficientincome)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesInsufficientincomeEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesInsufficientincomeEnum getInsufficientincome() {
		return this.insufficientincome;

	}



	 /**
	 * Set the value related to the column: insufficientincome.
	 * @param insufficientincome the insufficientincome value you wish to set
	 */
	public void setInsufficientincome(final YouthcriticalissuesInsufficientincomeEnum insufficientincome) {
		this.insufficientincome = insufficientincome;
	}

	 /**
	 * Return the value associated with the column: mentaldisabilityfam.
	 * @return A YouthcriticalissuesMentaldisabilityfamEnum object (this.mentaldisabilityfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesMentaldisabilityfamEnum getMentaldisabilityfam() {
		return this.mentaldisabilityfam;

	}



	 /**
	 * Set the value related to the column: mentaldisabilityfam.
	 * @param mentaldisabilityfam the mentaldisabilityfam value you wish to set
	 */
	public void setMentaldisabilityfam(final YouthcriticalissuesMentaldisabilityfamEnum mentaldisabilityfam) {
		this.mentaldisabilityfam = mentaldisabilityfam;
	}

	 /**
	 * Return the value associated with the column: mentaldisabilityyouth.
	 * @return A YouthcriticalissuesMentaldisabilityyouthEnum object (this.mentaldisabilityyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentaldisabilityyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesMentaldisabilityyouthEnum getMentaldisabilityyouth() {
		return this.mentaldisabilityyouth;

	}



	 /**
	 * Set the value related to the column: mentaldisabilityyouth.
	 * @param mentaldisabilityyouth the mentaldisabilityyouth value you wish to set
	 */
	public void setMentaldisabilityyouth(final YouthcriticalissuesMentaldisabilityyouthEnum mentaldisabilityyouth) {
		this.mentaldisabilityyouth = mentaldisabilityyouth;
	}

	 /**
	 * Return the value associated with the column: mentalhealthissuesfam.
	 * @return A YouthcriticalissuesMentalhealthissuesfamEnum object (this.mentalhealthissuesfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesMentalhealthissuesfamEnum getMentalhealthissuesfam() {
		return this.mentalhealthissuesfam;

	}



	 /**
	 * Set the value related to the column: mentalhealthissuesfam.
	 * @param mentalhealthissuesfam the mentalhealthissuesfam value you wish to set
	 */
	public void setMentalhealthissuesfam(final YouthcriticalissuesMentalhealthissuesfamEnum mentalhealthissuesfam) {
		this.mentalhealthissuesfam = mentalhealthissuesfam;
	}

	 /**
	 * Return the value associated with the column: mentalhealthissuesyouth.
	 * @return A YouthcriticalissuesMentalhealthissuesyouthEnum object (this.mentalhealthissuesyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesMentalhealthissuesyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesMentalhealthissuesyouthEnum getMentalhealthissuesyouth() {
		return this.mentalhealthissuesyouth;

	}



	 /**
	 * Set the value related to the column: mentalhealthissuesyouth.
	 * @param mentalhealthissuesyouth the mentalhealthissuesyouth value you wish to set
	 */
	public void setMentalhealthissuesyouth(final YouthcriticalissuesMentalhealthissuesyouthEnum mentalhealthissuesyouth) {
		this.mentalhealthissuesyouth = mentalhealthissuesyouth;
	}

	 /**
	 * Return the value associated with the column: physicaldisabilityfam.
	 * @return A YouthcriticalissuesPhysicaldisabilityfamEnum object (this.physicaldisabilityfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesPhysicaldisabilityfamEnum getPhysicaldisabilityfam() {
		return this.physicaldisabilityfam;

	}



	 /**
	 * Set the value related to the column: physicaldisabilityfam.
	 * @param physicaldisabilityfam the physicaldisabilityfam value you wish to set
	 */
	public void setPhysicaldisabilityfam(final YouthcriticalissuesPhysicaldisabilityfamEnum physicaldisabilityfam) {
		this.physicaldisabilityfam = physicaldisabilityfam;
	}

	 /**
	 * Return the value associated with the column: physicaldisabilityyouth.
	 * @return A YouthcriticalissuesPhysicaldisabilityyouthEnum object (this.physicaldisabilityyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesPhysicaldisabilityyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesPhysicaldisabilityyouthEnum getPhysicaldisabilityyouth() {
		return this.physicaldisabilityyouth;

	}



	 /**
	 * Set the value related to the column: physicaldisabilityyouth.
	 * @param physicaldisabilityyouth the physicaldisabilityyouth value you wish to set
	 */
	public void setPhysicaldisabilityyouth(final YouthcriticalissuesPhysicaldisabilityyouthEnum physicaldisabilityyouth) {
		this.physicaldisabilityyouth = physicaldisabilityyouth;
	}

	 /**
	 * Return the value associated with the column: schooleducationalissuesfam.
	 * @return A YouthcriticalissuesSchooleducationalissuesfamEnum object (this.schooleducationalissuesfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesSchooleducationalissuesfamEnum getSchooleducationalissuesfam() {
		return this.schooleducationalissuesfam;

	}



	 /**
	 * Set the value related to the column: schooleducationalissuesfam.
	 * @param schooleducationalissuesfam the schooleducationalissuesfam value you wish to set
	 */
	public void setSchooleducationalissuesfam(final YouthcriticalissuesSchooleducationalissuesfamEnum schooleducationalissuesfam) {
		this.schooleducationalissuesfam = schooleducationalissuesfam;
	}

	 /**
	 * Return the value associated with the column: schooleducationalissuesyouth.
	 * @return A YouthcriticalissuesSchooleducationalissuesyouthEnum object (this.schooleducationalissuesyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSchooleducationalissuesyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesSchooleducationalissuesyouthEnum getSchooleducationalissuesyouth() {
		return this.schooleducationalissuesyouth;

	}



	 /**
	 * Set the value related to the column: schooleducationalissuesyouth.
	 * @param schooleducationalissuesyouth the schooleducationalissuesyouth value you wish to set
	 */
	public void setSchooleducationalissuesyouth(final YouthcriticalissuesSchooleducationalissuesyouthEnum schooleducationalissuesyouth) {
		this.schooleducationalissuesyouth = schooleducationalissuesyouth;
	}

	 /**
	 * Return the value associated with the column: sexualorientationgenderidfam.
	 * @return A YouthcriticalissuesSexualorientationgenderidfamEnum object (this.sexualorientationgenderidfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesSexualorientationgenderidfamEnum getSexualorientationgenderidfam() {
		return this.sexualorientationgenderidfam;

	}



	 /**
	 * Set the value related to the column: sexualorientationgenderidfam.
	 * @param sexualorientationgenderidfam the sexualorientationgenderidfam value you wish to set
	 */
	public void setSexualorientationgenderidfam(final YouthcriticalissuesSexualorientationgenderidfamEnum sexualorientationgenderidfam) {
		this.sexualorientationgenderidfam = sexualorientationgenderidfam;
	}

	 /**
	 * Return the value associated with the column: sexualorientationgenderidyouth.
	 * @return A YouthcriticalissuesSexualorientationgenderidyouthEnum object (this.sexualorientationgenderidyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesSexualorientationgenderidyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesSexualorientationgenderidyouthEnum getSexualorientationgenderidyouth() {
		return this.sexualorientationgenderidyouth;

	}



	 /**
	 * Set the value related to the column: sexualorientationgenderidyouth.
	 * @param sexualorientationgenderidyouth the sexualorientationgenderidyouth value you wish to set
	 */
	public void setSexualorientationgenderidyouth(final YouthcriticalissuesSexualorientationgenderidyouthEnum sexualorientationgenderidyouth) {
		this.sexualorientationgenderidyouth = sexualorientationgenderidyouth;
	}

	 /**
	 * Return the value associated with the column: unemploymentfam.
	 * @return A YouthcriticalissuesUnemploymentfamEnum object (this.unemploymentfam)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentfamEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesUnemploymentfamEnum getUnemploymentfam() {
		return this.unemploymentfam;

	}



	 /**
	 * Set the value related to the column: unemploymentfam.
	 * @param unemploymentfam the unemploymentfam value you wish to set
	 */
	public void setUnemploymentfam(final YouthcriticalissuesUnemploymentfamEnum unemploymentfam) {
		this.unemploymentfam = unemploymentfam;
	}

	 /**
	 * Return the value associated with the column: unemploymentyouth.
	 * @return A YouthcriticalissuesUnemploymentyouthEnum object (this.unemploymentyouth)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.YouthcriticalissuesUnemploymentyouthEnumType")
	@Basic( optional = true )
	@Column
	public YouthcriticalissuesUnemploymentyouthEnum getUnemploymentyouth() {
		return this.unemploymentyouth;

	}



	 /**
	 * Set the value related to the column: unemploymentyouth.
	 * @param unemploymentyouth the unemploymentyouth value you wish to set
	 */
	public void setUnemploymentyouth(final YouthcriticalissuesUnemploymentyouthEnum unemploymentyouth) {
		this.unemploymentyouth = unemploymentyouth;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public Youthcriticalissues clone() throws CloneNotSupportedException {

        final Youthcriticalissues copy = (Youthcriticalissues)super.clone();

		copy.setAbuseandneglectfam(this.getAbuseandneglectfam());
		copy.setAbuseandneglectyouth(this.getAbuseandneglectyouth());
		copy.setActivemilitaryparent(this.getActivemilitaryparent());
		copy.setAlcoholdrugabusefam(this.getAlcoholdrugabusefam());
		copy.setAlcoholdrugabuseyouth(this.getAlcoholdrugabuseyouth());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setEnrollmentid(this.getEnrollmentid());
		copy.setHealthissuesfam(this.getHealthissuesfam());
		copy.setHealthissuesyouth(this.getHealthissuesyouth());
		copy.setHouseholddynamics(this.getHouseholddynamics());
		copy.setHousingissuesfam(this.getHousingissuesfam());
		copy.setHousingissuesyouth(this.getHousingissuesyouth());
		copy.setId(this.getId());
		copy.setIncarceratedparent(this.getIncarceratedparent());
		copy.setIncarceratedparentstatus(this.getIncarceratedparentstatus());
		copy.setInsufficientincome(this.getInsufficientincome());
		copy.setMentaldisabilityfam(this.getMentaldisabilityfam());
		copy.setMentaldisabilityyouth(this.getMentaldisabilityyouth());
		copy.setMentalhealthissuesfam(this.getMentalhealthissuesfam());
		copy.setMentalhealthissuesyouth(this.getMentalhealthissuesyouth());
		copy.setPhysicaldisabilityfam(this.getPhysicaldisabilityfam());
		copy.setPhysicaldisabilityyouth(this.getPhysicaldisabilityyouth());
		copy.setSchooleducationalissuesfam(this.getSchooleducationalissuesfam());
		copy.setSchooleducationalissuesyouth(this.getSchooleducationalissuesyouth());
		copy.setSexualorientationgenderidfam(this.getSexualorientationgenderidfam());
		copy.setSexualorientationgenderidyouth(this.getSexualorientationgenderidyouth());
		copy.setUnemploymentfam(this.getUnemploymentfam());
		copy.setUnemploymentyouth(this.getUnemploymentyouth());
		copy.setUserId(this.getUser());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("abuseandneglectfam: " + this.getAbuseandneglectfam() + ", ");
		sb.append("abuseandneglectyouth: " + this.getAbuseandneglectyouth() + ", ");
		sb.append("activemilitaryparent: " + this.getActivemilitaryparent() + ", ");
		sb.append("alcoholdrugabusefam: " + this.getAlcoholdrugabusefam() + ", ");
		sb.append("alcoholdrugabuseyouth: " + this.getAlcoholdrugabuseyouth() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("healthissuesfam: " + this.getHealthissuesfam() + ", ");
		sb.append("healthissuesyouth: " + this.getHealthissuesyouth() + ", ");
		sb.append("householddynamics: " + this.getHouseholddynamics() + ", ");
		sb.append("housingissuesfam: " + this.getHousingissuesfam() + ", ");
		sb.append("housingissuesyouth: " + this.getHousingissuesyouth() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("incarceratedparent: " + this.getIncarceratedparent() + ", ");
		sb.append("incarceratedparentstatus: " + this.getIncarceratedparentstatus() + ", ");
		sb.append("insufficientincome: " + this.getInsufficientincome() + ", ");
		sb.append("mentaldisabilityfam: " + this.getMentaldisabilityfam() + ", ");
		sb.append("mentaldisabilityyouth: " + this.getMentaldisabilityyouth() + ", ");
		sb.append("mentalhealthissuesfam: " + this.getMentalhealthissuesfam() + ", ");
		sb.append("mentalhealthissuesyouth: " + this.getMentalhealthissuesyouth() + ", ");
		sb.append("physicaldisabilityfam: " + this.getPhysicaldisabilityfam() + ", ");
		sb.append("physicaldisabilityyouth: " + this.getPhysicaldisabilityyouth() + ", ");
		sb.append("schooleducationalissuesfam: " + this.getSchooleducationalissuesfam() + ", ");
		sb.append("schooleducationalissuesyouth: " + this.getSchooleducationalissuesyouth() + ", ");
		sb.append("sexualorientationgenderidfam: " + this.getSexualorientationgenderidfam() + ", ");
		sb.append("sexualorientationgenderidyouth: " + this.getSexualorientationgenderidyouth() + ", ");
		sb.append("unemploymentfam: " + this.getUnemploymentfam() + ", ");
		sb.append("unemploymentyouth: " + this.getUnemploymentyouth() + ", ");
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

		final Youthcriticalissues that;
		try {
			that = (Youthcriticalissues) proxyThat;
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
		result = result && (((getAbuseandneglectfam() == null) && (that.getAbuseandneglectfam() == null)) || (getAbuseandneglectfam() != null && getAbuseandneglectfam().equals(that.getAbuseandneglectfam())));
		result = result && (((getAbuseandneglectyouth() == null) && (that.getAbuseandneglectyouth() == null)) || (getAbuseandneglectyouth() != null && getAbuseandneglectyouth().equals(that.getAbuseandneglectyouth())));
		result = result && (((getActivemilitaryparent() == null) && (that.getActivemilitaryparent() == null)) || (getActivemilitaryparent() != null && getActivemilitaryparent().equals(that.getActivemilitaryparent())));
		result = result && (((getAlcoholdrugabusefam() == null) && (that.getAlcoholdrugabusefam() == null)) || (getAlcoholdrugabusefam() != null && getAlcoholdrugabusefam().equals(that.getAlcoholdrugabusefam())));
		result = result && (((getAlcoholdrugabuseyouth() == null) && (that.getAlcoholdrugabuseyouth() == null)) || (getAlcoholdrugabuseyouth() != null && getAlcoholdrugabuseyouth().equals(that.getAlcoholdrugabuseyouth())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getEnrollmentid() == null) && (that.getEnrollmentid() == null)) || (getEnrollmentid() != null && getEnrollmentid().getId().equals(that.getEnrollmentid().getId())));
		result = result && (((getHealthissuesfam() == null) && (that.getHealthissuesfam() == null)) || (getHealthissuesfam() != null && getHealthissuesfam().equals(that.getHealthissuesfam())));
		result = result && (((getHealthissuesyouth() == null) && (that.getHealthissuesyouth() == null)) || (getHealthissuesyouth() != null && getHealthissuesyouth().equals(that.getHealthissuesyouth())));
		result = result && (((getHouseholddynamics() == null) && (that.getHouseholddynamics() == null)) || (getHouseholddynamics() != null && getHouseholddynamics().equals(that.getHouseholddynamics())));
		result = result && (((getHousingissuesfam() == null) && (that.getHousingissuesfam() == null)) || (getHousingissuesfam() != null && getHousingissuesfam().equals(that.getHousingissuesfam())));
		result = result && (((getHousingissuesyouth() == null) && (that.getHousingissuesyouth() == null)) || (getHousingissuesyouth() != null && getHousingissuesyouth().equals(that.getHousingissuesyouth())));
		result = result && (((getIncarceratedparent() == null) && (that.getIncarceratedparent() == null)) || (getIncarceratedparent() != null && getIncarceratedparent().equals(that.getIncarceratedparent())));
		result = result && (((getIncarceratedparentstatus() == null) && (that.getIncarceratedparentstatus() == null)) || (getIncarceratedparentstatus() != null && getIncarceratedparentstatus().equals(that.getIncarceratedparentstatus())));
		result = result && (((getInsufficientincome() == null) && (that.getInsufficientincome() == null)) || (getInsufficientincome() != null && getInsufficientincome().equals(that.getInsufficientincome())));
		result = result && (((getMentaldisabilityfam() == null) && (that.getMentaldisabilityfam() == null)) || (getMentaldisabilityfam() != null && getMentaldisabilityfam().equals(that.getMentaldisabilityfam())));
		result = result && (((getMentaldisabilityyouth() == null) && (that.getMentaldisabilityyouth() == null)) || (getMentaldisabilityyouth() != null && getMentaldisabilityyouth().equals(that.getMentaldisabilityyouth())));
		result = result && (((getMentalhealthissuesfam() == null) && (that.getMentalhealthissuesfam() == null)) || (getMentalhealthissuesfam() != null && getMentalhealthissuesfam().equals(that.getMentalhealthissuesfam())));
		result = result && (((getMentalhealthissuesyouth() == null) && (that.getMentalhealthissuesyouth() == null)) || (getMentalhealthissuesyouth() != null && getMentalhealthissuesyouth().equals(that.getMentalhealthissuesyouth())));
		result = result && (((getPhysicaldisabilityfam() == null) && (that.getPhysicaldisabilityfam() == null)) || (getPhysicaldisabilityfam() != null && getPhysicaldisabilityfam().equals(that.getPhysicaldisabilityfam())));
		result = result && (((getPhysicaldisabilityyouth() == null) && (that.getPhysicaldisabilityyouth() == null)) || (getPhysicaldisabilityyouth() != null && getPhysicaldisabilityyouth().equals(that.getPhysicaldisabilityyouth())));
		result = result && (((getSchooleducationalissuesfam() == null) && (that.getSchooleducationalissuesfam() == null)) || (getSchooleducationalissuesfam() != null && getSchooleducationalissuesfam().equals(that.getSchooleducationalissuesfam())));
		result = result && (((getSchooleducationalissuesyouth() == null) && (that.getSchooleducationalissuesyouth() == null)) || (getSchooleducationalissuesyouth() != null && getSchooleducationalissuesyouth().equals(that.getSchooleducationalissuesyouth())));
		result = result && (((getSexualorientationgenderidfam() == null) && (that.getSexualorientationgenderidfam() == null)) || (getSexualorientationgenderidfam() != null && getSexualorientationgenderidfam().equals(that.getSexualorientationgenderidfam())));
		result = result && (((getSexualorientationgenderidyouth() == null) && (that.getSexualorientationgenderidyouth() == null)) || (getSexualorientationgenderidyouth() != null && getSexualorientationgenderidyouth().equals(that.getSexualorientationgenderidyouth())));
		result = result && (((getUnemploymentfam() == null) && (that.getUnemploymentfam() == null)) || (getUnemploymentfam() != null && getUnemploymentfam().equals(that.getUnemploymentfam())));
		result = result && (((getUnemploymentyouth() == null) && (that.getUnemploymentyouth() == null)) || (getUnemploymentyouth() != null && getUnemploymentyouth().equals(that.getUnemploymentyouth())));
		result = result && (((getUser() == null) && (that.getUser() == null)) || (getUser() != null && getUser().equals(that.getUser())));
		return result;
	}

}
