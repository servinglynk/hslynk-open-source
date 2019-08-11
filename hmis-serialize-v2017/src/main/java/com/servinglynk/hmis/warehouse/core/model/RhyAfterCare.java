package com.servinglynk.hmis.warehouse.core.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonRootName("rhyAfterCare")
public class RhyAfterCare extends ClientModel{

	private java.util.UUID rhyAfterCareId; 
    @JsonSerialize(using=JsonDateSerializer.class)
    @JsonDeserialize(using=JsonDateDeserializer.class)
	private LocalDateTime afterCareDate;
	private Integer afterProvided;
	private Integer emailSocialMedia;
	private Integer telephone;
	private Integer inPersonIndividual;
	private Integer inPersonGroup;
	private UUID exitId;
	/**
	 * @return the rhyAfterCareId
	 */
	public java.util.UUID getRhyAfterCareId() {
		return rhyAfterCareId;
	}
	/**
	 * @param rhyAfterCareId the rhyAfterCareId to set
	 */
	public void setRhyAfterCareId(java.util.UUID rhyAfterCareId) {
		this.rhyAfterCareId = rhyAfterCareId;
	}
	/**
	 * @return the afterCareDate
	 */
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
	 * @return the exitId
	 */
	public UUID getExitId() {
		return exitId;
	}
	/**
	 * @param exitId the exitId to set
	 */
	public void setExitId(UUID exitId) {
		this.exitId = exitId;
	}
}

