package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.servinglynk.hmis.warehouse.enums.NoYesEnum;

@Entity(name = "rhyaftercare_v2017")
@Table(name = "rhyaftercare", catalog = "hmis", schema = "v2017")
public class RHYAfterCare extends HmisBaseModel implements Cloneable, Serializable   {
	
	private java.util.UUID id; 
	private LocalDateTime afterCareDate;
	private NoYesEnum afterProvided;
	private NoYesEnum emailSocialMedia;
	private NoYesEnum telephone;
	private NoYesEnum inPersonIndividual;
	private NoYesEnum inPersonGroup;
	/** Field mapping. */
	private Exitrhy exitrhyid;
	/**
	 * @return the id
	 */
	@Id
	@Basic( optional = false )
	@Column( name = "id", nullable = false  ) @org.hibernate.annotations.Type(type="org.hibernate.type.PostgresUUIDType")
	public java.util.UUID getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(java.util.UUID id) {
		this.id = id;
	}
	/**
	 * @return the afterCareDate
	 */
	@Basic(optional=true)
	@Column(name = "after_care_date")
	public LocalDateTime getAfterCareDate() {
		return afterCareDate;
	}
	/**
	 * @param afterCareDate the afterCareDate to set
	 */
	public void setAfterCareDate(LocalDateTime afterCareDate) {
		this.afterCareDate = afterCareDate;
	}
	/**
	 * @return the afterProvided
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoYesEnumType")
	@Basic(optional=true)
	@Column(name = "after_provided")
	public NoYesEnum getAfterProvided() {
		return afterProvided;
	}
	/**
	 * @param afterProvided the afterProvided to set
	 */
	public void setAfterProvided(NoYesEnum afterProvided) {
		this.afterProvided = afterProvided;
	}
	/**
	 * @return the emailSocialMedia
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoYesEnumType")
	@Basic(optional=true)
	@Column(name = "email_social_media")
	public NoYesEnum getEmailSocialMedia() {
		return emailSocialMedia;
	}
	/**
	 * @param emailSocialMedia the emailSocialMedia to set
	 */
	public void setEmailSocialMedia(NoYesEnum emailSocialMedia) {
		this.emailSocialMedia = emailSocialMedia;
	}
	/**
	 * @return the telephone
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoYesEnumType")
	@Basic(optional=true)
	@Column(name = "telephone")
	public NoYesEnum getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(NoYesEnum telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the inPersonIndividual
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoYesEnumType")
	@Basic(optional=true)
	@Column(name = "in_person_individual")
	public NoYesEnum getInPersonIndividual() {
		return inPersonIndividual;
	}
	/**
	 * @param inPersonIndividual the inPersonIndividual to set
	 */
	public void setInPersonIndividual(NoYesEnum inPersonIndividual) {
		this.inPersonIndividual = inPersonIndividual;
	}
	/**
	 * @return the inPersonGroup
	 */
	@Type(type = "com.servinglynk.hmis.warehouse.enums.NoYesEnumType")
	@Basic(optional=true)
	@Column(name = "in_person_group")
	public NoYesEnum getInPersonGroup() {
		return inPersonGroup;
	}
	/**
	 * @param inPersonGroup the inPersonGroup to set
	 */
	public void setInPersonGroup(NoYesEnum inPersonGroup) {
		this.inPersonGroup = inPersonGroup;
	}
	 /**
		 * Return the value associated with the column: exitid.
		 * @return A Exit object (this.exitid)
		 */
		@ManyToOne( cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY )
		@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
		@Basic( optional = true )
		@JoinColumn(name = "exitrhyid", nullable = true )
		public Exitrhy getExitrhyid() {
			return this.exitrhyid;

		}



		 /**
		 * Set the value related to the column: exitid.
		 * @param exitid the exitid value you wish to set
		 */
		public void setExitrhyid(final Exitrhy exitrhyid) {
			this.exitrhyid = exitrhyid;
		}
	/**
	 * @param id
	 * @param afterCareDate
	 * @param afterProvided
	 * @param emailSocialMedia
	 * @param telephone
	 * @param inPersonIndividual
	 * @param inPersonGroup
	 */
	public RHYAfterCare(UUID id, LocalDateTime afterCareDate,
			NoYesEnum afterProvided, NoYesEnum emailSocialMedia, NoYesEnum telephone,
			NoYesEnum inPersonIndividual, NoYesEnum inPersonGroup) {
		super();
		this.id = id;
		this.afterCareDate = afterCareDate;
		this.afterProvided = afterProvided;
		this.emailSocialMedia = emailSocialMedia;
		this.telephone = telephone;
		this.inPersonIndividual = inPersonIndividual;
		this.inPersonGroup = inPersonGroup;
	}
	public RHYAfterCare() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
