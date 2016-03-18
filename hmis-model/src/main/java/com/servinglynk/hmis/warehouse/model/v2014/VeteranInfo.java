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

import com.servinglynk.hmis.warehouse.enums.VeteranInfoAfghanistanOefEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDesertStormEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDischargeStatusEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOifEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOndEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoKoreanWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoMilitaryBranchEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoOtherTheaterEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoVietnamWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoWorldWar2Enum;


/**
 * Object mapping for hibernate-handled table: veteran_info.
 *
 *
 * @author Sandeep Dolia
 */
@Entity(name = "veteran_info")
@Table(name = "veteran_info", catalog = "hmis", schema = "v2014")
public class VeteranInfo extends HmisBaseModel  implements Cloneable, Serializable {

	/** Serial Version UID. */
	private static final long serialVersionUID = -6287250433537253318L;

	/** Use a WeakHashMap so entries will be garbage collected once all entities
		referring to a saved hash are garbage collected themselves. */
	private static final Map<Serializable, java.util.UUID> SAVED_HASHES =
		Collections.synchronizedMap(new WeakHashMap<Serializable, java.util.UUID>());

	/** hashCode temporary storage. */
	private volatile java.util.UUID hashCode;


	/** Field mapping. */
	private VeteranInfoAfghanistanOefEnum afghanistanOef;
	/** Field mapping. */
	private Client client;
	/** Field mapping. */
	private VeteranInfoDesertStormEnum desertStorm;
	/** Field mapping. */
	private VeteranInfoDischargeStatusEnum dischargeStatus;
	/** Field mapping. */
	private java.util.UUID id;
	/** Field mapping. */
	private VeteranInfoIraqOifEnum iraqOif;
	/** Field mapping. */
	private VeteranInfoIraqOndEnum iraqOnd;
	/** Field mapping. */
	private VeteranInfoKoreanWarEnum koreanWar;
	/** Field mapping. */
	private VeteranInfoMilitaryBranchEnum militaryBranch;
	/** Field mapping. */
	private VeteranInfoOtherTheaterEnum otherTheater;
	/** Field mapping. */
	private VeteranInfoVietnamWarEnum vietnamWar;
	/** Field mapping. */
	private VeteranInfoWorldWar2Enum worldWar2;
	/** Field mapping. */
	private Integer yearEntrdService;
	/** Field mapping. */
	private Integer yearSeperated;
	/**
	 * Default constructor, mainly for hibernate use.
	 */
	public VeteranInfo() {
		// Default constructor
	}

	/** Constructor taking a given ID.
	 * @param id to set
	 */
	public VeteranInfo(java.util.UUID id) {
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
		return VeteranInfo.class;
	}


	 /**
	 * Return the value associated with the column: afghanistanOef.
	 * @return A VeteranInfoAfghanistanOefEnum object (this.afghanistanOef)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoAfghanistanOefEnumType")
	@Basic( optional = true )
	@Column( name = "afghanistan_oef"  )
	public VeteranInfoAfghanistanOefEnum getAfghanistanOef() {
		return this.afghanistanOef;

	}



	 /**
	 * Set the value related to the column: afghanistanOef.
	 * @param afghanistanOef the afghanistanOef value you wish to set
	 */
	public void setAfghanistanOef(final VeteranInfoAfghanistanOefEnum afghanistanOef) {
		this.afghanistanOef = afghanistanOef;
	}

	 /**
	 * Return the value associated with the column: client.
	 * @return A Client object (this.client)
	 */
	@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
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
	 * Return the value associated with the column: desertStorm.
	 * @return A VeteranInfoDesertStormEnum object (this.desertStorm)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoDesertStormEnumType")
	@Basic( optional = true )
	@Column( name = "desert_storm"  )
	public VeteranInfoDesertStormEnum getDesertStorm() {
		return this.desertStorm;

	}



	 /**
	 * Set the value related to the column: desertStorm.
	 * @param desertStorm the desertStorm value you wish to set
	 */
	public void setDesertStorm(final VeteranInfoDesertStormEnum desertStorm) {
		this.desertStorm = desertStorm;
	}

	 /**
	 * Return the value associated with the column: dischargeStatus.
	 * @return A VeteranInfoDischargeStatusEnum object (this.dischargeStatus)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoDischargeStatusEnumType")
	@Basic( optional = true )
	@Column( name = "discharge_status"  )
	public VeteranInfoDischargeStatusEnum getDischargeStatus() {
		return this.dischargeStatus;

	}



	 /**
	 * Set the value related to the column: dischargeStatus.
	 * @param dischargeStatus the dischargeStatus value you wish to set
	 */
	public void setDischargeStatus(final VeteranInfoDischargeStatusEnum dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
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
	 * Return the value associated with the column: iraqOif.
	 * @return A VeteranInfoIraqOifEnum object (this.iraqOif)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOifEnumType")
	@Basic( optional = true )
	@Column( name = "iraq_oif"  )
	public VeteranInfoIraqOifEnum getIraqOif() {
		return this.iraqOif;

	}



	 /**
	 * Set the value related to the column: iraqOif.
	 * @param iraqOif the iraqOif value you wish to set
	 */
	public void setIraqOif(final VeteranInfoIraqOifEnum iraqOif) {
		this.iraqOif = iraqOif;
	}

	 /**
	 * Return the value associated with the column: iraqOnd.
	 * @return A VeteranInfoIraqOndEnum object (this.iraqOnd)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOndEnumType")
	@Basic( optional = true )
	@Column( name = "iraq_ond"  )
	public VeteranInfoIraqOndEnum getIraqOnd() {
		return this.iraqOnd;

	}



	 /**
	 * Set the value related to the column: iraqOnd.
	 * @param iraqOnd the iraqOnd value you wish to set
	 */
	public void setIraqOnd(final VeteranInfoIraqOndEnum iraqOnd) {
		this.iraqOnd = iraqOnd;
	}

	 /**
	 * Return the value associated with the column: koreanWar.
	 * @return A VeteranInfoKoreanWarEnum object (this.koreanWar)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoKoreanWarEnumType")
	@Basic( optional = true )
	@Column( name = "korean_war"  )
	public VeteranInfoKoreanWarEnum getKoreanWar() {
		return this.koreanWar;

	}



	 /**
	 * Set the value related to the column: koreanWar.
	 * @param koreanWar the koreanWar value you wish to set
	 */
	public void setKoreanWar(final VeteranInfoKoreanWarEnum koreanWar) {
		this.koreanWar = koreanWar;
	}

	 /**
	 * Return the value associated with the column: militaryBranch.
	 * @return A VeteranInfoMilitaryBranchEnum object (this.militaryBranch)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoMilitaryBranchEnumType")
	@Basic( optional = true )
	@Column( name = "military_branch"  )
	public VeteranInfoMilitaryBranchEnum getMilitaryBranch() {
		return this.militaryBranch;

	}



	 /**
	 * Set the value related to the column: militaryBranch.
	 * @param militaryBranch the militaryBranch value you wish to set
	 */
	public void setMilitaryBranch(final VeteranInfoMilitaryBranchEnum militaryBranch) {
		this.militaryBranch = militaryBranch;
	}

	 /**
	 * Return the value associated with the column: otherTheater.
	 * @return A VeteranInfoOtherTheaterEnum object (this.otherTheater)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoOtherTheaterEnumType")
	@Basic( optional = true )
	@Column( name = "other_theater"  )
	public VeteranInfoOtherTheaterEnum getOtherTheater() {
		return this.otherTheater;

	}



	 /**
	 * Set the value related to the column: otherTheater.
	 * @param otherTheater the otherTheater value you wish to set
	 */
	public void setOtherTheater(final VeteranInfoOtherTheaterEnum otherTheater) {
		this.otherTheater = otherTheater;
	}


	 /**
	 * Return the value associated with the column: vietnamWar.
	 * @return A VeteranInfoVietnamWarEnum object (this.vietnamWar)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoVietnamWarEnumType")
	@Basic( optional = true )
	@Column( name = "vietnam_war"  )
	public VeteranInfoVietnamWarEnum getVietnamWar() {
		return this.vietnamWar;

	}


	 /**
	 * Set the value related to the column: vietnamWar.
	 * @param vietnamWar the vietnamWar value you wish to set
	 */
	public void setVietnamWar(final VeteranInfoVietnamWarEnum vietnamWar) {
		this.vietnamWar = vietnamWar;
	}

	 /**
	 * Return the value associated with the column: worldWar2.
	 * @return A VeteranInfoWorldWar2Enum object (this.worldWar2)
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.VeteranInfoWorldWar2EnumType")
	@Basic( optional = true )
	@Column( name = "world_war_2"  )
	public VeteranInfoWorldWar2Enum getWorldWar2() {
		return this.worldWar2;

	}



	 /**
	 * Set the value related to the column: worldWar2.
	 * @param worldWar2 the worldWar2 value you wish to set
	 */
	public void setWorldWar2(final VeteranInfoWorldWar2Enum worldWar2) {
		this.worldWar2 = worldWar2;
	}

	 /**
	 * Return the value associated with the column: yearEntrdService.
	 * @return A Integer object (this.yearEntrdService)
	 */
	@Basic( optional = true )
	@Column( name = "year_entrd_service"  )
	public Integer getYearEntrdService() {
		return this.yearEntrdService;

	}



	 /**
	 * Set the value related to the column: yearEntrdService.
	 * @param yearEntrdService the yearEntrdService value you wish to set
	 */
	public void setYearEntrdService(final Integer yearEntrdService) {
		this.yearEntrdService = yearEntrdService;
	}

	 /**
	 * Return the value associated with the column: yearSeperated.
	 * @return A Integer object (this.yearSeperated)
	 */
	@Basic( optional = true )
	@Column( name = "year_seperated"  )
	public Integer getYearSeperated() {
		return this.yearSeperated;

	}



	 /**
	 * Set the value related to the column: yearSeperated.
	 * @param yearSeperated the yearSeperated value you wish to set
	 */
	public void setYearSeperated(final Integer yearSeperated) {
		this.yearSeperated = yearSeperated;
	}


   /**
    * Deep copy.
	* @return cloned object
	* @throws CloneNotSupportedException on error
    */
    @Override
    public VeteranInfo clone() throws CloneNotSupportedException {

        final VeteranInfo copy = (VeteranInfo)super.clone();

		copy.setAfghanistanOef(this.getAfghanistanOef());
		copy.setClient(this.getClient());
		copy.setDateCreated(this.getDateCreated());
		copy.setDateUpdated(this.getDateUpdated());
		copy.setDesertStorm(this.getDesertStorm());
		copy.setDischargeStatus(this.getDischargeStatus());
		copy.setId(this.getId());
		copy.setIraqOif(this.getIraqOif());
		copy.setIraqOnd(this.getIraqOnd());
		copy.setKoreanWar(this.getKoreanWar());
		copy.setMilitaryBranch(this.getMilitaryBranch());
		copy.setOtherTheater(this.getOtherTheater());
		copy.setUserId(this.getUserId());
		copy.setVietnamWar(this.getVietnamWar());
		copy.setWorldWar2(this.getWorldWar2());
		copy.setYearEntrdService(this.getYearEntrdService());
		copy.setYearSeperated(this.getYearSeperated());
		return copy;
	}



	/** Provides toString implementation.
	 * @see java.lang.Object#toString()
	 * @return String representation of this class.
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("afghanistanOef: " + this.getAfghanistanOef() + ", ");
		sb.append("dateCreated: " + this.getDateCreated() + ", ");
		sb.append("dateUpdated: " + this.getDateUpdated() + ", ");
		sb.append("desertStorm: " + this.getDesertStorm() + ", ");
		sb.append("dischargeStatus: " + this.getDischargeStatus() + ", ");
		sb.append("id: " + this.getId() + ", ");
		sb.append("iraqOif: " + this.getIraqOif() + ", ");
		sb.append("iraqOnd: " + this.getIraqOnd() + ", ");
		sb.append("koreanWar: " + this.getKoreanWar() + ", ");
		sb.append("militaryBranch: " + this.getMilitaryBranch() + ", ");
		sb.append("otherTheater: " + this.getOtherTheater() + ", ");
		sb.append("vietnamWar: " + this.getVietnamWar() + ", ");
		sb.append("worldWar2: " + this.getWorldWar2() + ", ");
		sb.append("yearEntrdService: " + this.getYearEntrdService() + ", ");
		sb.append("yearSeperated: " + this.getYearSeperated());
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

		final VeteranInfo that;
		try {
			that = (VeteranInfo) proxyThat;
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
		result = result && (((getAfghanistanOef() == null) && (that.getAfghanistanOef() == null)) || (getAfghanistanOef() != null && getAfghanistanOef().equals(that.getAfghanistanOef())));
		result = result && (((getClient() == null) && (that.getClient() == null)) || (getClient() != null && getClient().getId().equals(that.getClient().getId())));
		result = result && (((getDateCreated() == null) && (that.getDateCreated() == null)) || (getDateCreated() != null && getDateCreated().equals(that.getDateCreated())));
		result = result && (((getDateUpdated() == null) && (that.getDateUpdated() == null)) || (getDateUpdated() != null && getDateUpdated().equals(that.getDateUpdated())));
		result = result && (((getDesertStorm() == null) && (that.getDesertStorm() == null)) || (getDesertStorm() != null && getDesertStorm().equals(that.getDesertStorm())));
		result = result && (((getDischargeStatus() == null) && (that.getDischargeStatus() == null)) || (getDischargeStatus() != null && getDischargeStatus().equals(that.getDischargeStatus())));
		result = result && (((getIraqOif() == null) && (that.getIraqOif() == null)) || (getIraqOif() != null && getIraqOif().equals(that.getIraqOif())));
		result = result && (((getIraqOnd() == null) && (that.getIraqOnd() == null)) || (getIraqOnd() != null && getIraqOnd().equals(that.getIraqOnd())));
		result = result && (((getKoreanWar() == null) && (that.getKoreanWar() == null)) || (getKoreanWar() != null && getKoreanWar().equals(that.getKoreanWar())));
		result = result && (((getMilitaryBranch() == null) && (that.getMilitaryBranch() == null)) || (getMilitaryBranch() != null && getMilitaryBranch().equals(that.getMilitaryBranch())));
		result = result && (((getOtherTheater() == null) && (that.getOtherTheater() == null)) || (getOtherTheater() != null && getOtherTheater().equals(that.getOtherTheater())));
		result = result && (((getUserId() == null) && (that.getUserId() == null)) || (getUserId() != null && getUserId().equals(that.getUserId())));
		result = result && (((getVietnamWar() == null) && (that.getVietnamWar() == null)) || (getVietnamWar() != null && getVietnamWar().equals(that.getVietnamWar())));
		result = result && (((getWorldWar2() == null) && (that.getWorldWar2() == null)) || (getWorldWar2() != null && getWorldWar2().equals(that.getWorldWar2())));
		result = result && (((getYearEntrdService() == null) && (that.getYearEntrdService() == null)) || (getYearEntrdService() != null && getYearEntrdService().equals(that.getYearEntrdService())));
		result = result && (((getYearSeperated() == null) && (that.getYearSeperated() == null)) || (getYearSeperated() != null && getYearSeperated().equals(that.getYearSeperated())));
		return result;
	}


}
