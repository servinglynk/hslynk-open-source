package com.servinglynk.hmis.warehouse.model.v2017;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "rhyaftercare_v2017")
@Table(name = "rhyaftercare", catalog = "hmis", schema = "v2017")
public class RHYAfterCare extends HmisBaseModel implements Cloneable, Serializable   {
	
	private java.util.UUID id; 
	private LocalDateTime afterCareDate;
	private Integer afterProvided;
	private Integer emailSocialMedia;
	private Integer telephone;
	private Integer inPersonIndividual;
	private Integer inPersonGroup;
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
	@Basic(optional=true)
	@Column(name = "after_provided")
	public Integer getAfterProvided() {
		return afterProvided;
	}
	/**
	 * @param afterProvided the afterProvided to set
	 */
	public void setAfterProvided(Integer afterProvided) {
		this.afterProvided = afterProvided;
	}
	/**
	 * @return the emailSocialMedia
	 */
	@Basic(optional=true)
	@Column(name = "email_social_media")
	public Integer getEmailSocialMedia() {
		return emailSocialMedia;
	}
	/**
	 * @param emailSocialMedia the emailSocialMedia to set
	 */
	public void setEmailSocialMedia(Integer emailSocialMedia) {
		this.emailSocialMedia = emailSocialMedia;
	}
	/**
	 * @return the telephone
	 */
	@Basic(optional=true)
	@Column(name = "telephone")
	public Integer getTelephone() {
		return telephone;
	}
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}
	/**
	 * @return the inPersonIndividual
	 */
	@Basic(optional=true)
	@Column(name = "in_person_individual")
	public Integer getInPersonIndividual() {
		return inPersonIndividual;
	}
	/**
	 * @param inPersonIndividual the inPersonIndividual to set
	 */
	public void setInPersonIndividual(Integer inPersonIndividual) {
		this.inPersonIndividual = inPersonIndividual;
	}
	/**
	 * @return the inPersonGroup
	 */
	@Basic(optional=true)
	@Column(name = "in_person_group")
	public Integer getInPersonGroup() {
		return inPersonGroup;
	}
	/**
	 * @param inPersonGroup the inPersonGroup to set
	 */
	public void setInPersonGroup(Integer inPersonGroup) {
		this.inPersonGroup = inPersonGroup;
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
			Integer afterProvided, Integer emailSocialMedia, Integer telephone,
			Integer inPersonIndividual, Integer inPersonGroup) {
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
