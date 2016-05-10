package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class Youthcriticalissues extends BaseModel{
	@Column(name = "abuseandneglectfam")	
	public String abuseandneglectfam;
	@Column(name = "abuseandneglectyouth")
	public String abuseandneglectyouth;
	@Column(name = "activemilitaryparent")
	public String activemilitaryparent;
	@Column(name = "alcoholdrugabusefam")
	public String alcoholdrugabusefam;
	@Column(name = "alcoholdrugabuseyouth")
	public String alcoholdrugabuseyouth;
	@Column(name = "healthissuesfam")
	public String healthissuesfam;
	@Column(name = "healthissuesyouth")
	public String healthissuesyouth;
	@Column(name = "householddynamics")
	public String householddynamics;
	@Column(name = "housingissuesfam")
	public String housingissuesfam;
	@Column(name = "housingissuesyouth")
	public String housingissuesyouth;
	@Column(name = "incarceratedparent")
	public String incarceratedparent;
	@Column(name = "incarceratedparentstatus")
	public String incarceratedparentstatus;
	@Column(name = "insufficientincome")
	public String insufficientincome;
	@Column(name = "mentaldisabilityfam")
	public String mentaldisabilityfam;
	@Column(name = "mentaldisabilityyouth")
	public String mentaldisabilityyouth;
	@Column(name = "mentalhealthissuesfam")
	public String mentalhealthissuesfam;
	@Column(name = "mentalhealthissuesyouth")
	public String mentalhealthissuesyouth;
	@Column(name = "physicaldisabilityfam")
	public String physicaldisabilityfam;
	@Column(name = "physicaldisabilityyouth")
	public String physicaldisabilityyouth;
	@Column(name = "enrollmentid")	
	public UUID enrollmentid;
	@Column(name = "schooleducationalissuesfam")
	public String schooleducationalissuesfam;
	@Column(name = "schooleducationalissuesyouth")
	public String schooleducationalissuesyouth;
	@Column(name = "sexualorientationgenderidfam")
	public String sexualorientationgenderidfam;
	@Column(name = "sexualorientationgenderidyouth")
	public String sexualorientationgenderidyouth;
	@Column(name = "unemploymentfam")
	public String unemploymentfam;
	@Column(name = "unemploymentyouth")
	public String unemploymentyouth;
	/**
	 * @return the abuseandneglectfam
	 */
	public String getAbuseandneglectfam() {
		return abuseandneglectfam;
	}
	/**
	 * @param abuseandneglectfam the abuseandneglectfam to set
	 */
	public void setAbuseandneglectfam(String abuseandneglectfam) {
		this.abuseandneglectfam = abuseandneglectfam;
	}
	/**
	 * @return the abuseandneglectyouth
	 */
	public String getAbuseandneglectyouth() {
		return abuseandneglectyouth;
	}
	/**
	 * @param abuseandneglectyouth the abuseandneglectyouth to set
	 */
	public void setAbuseandneglectyouth(String abuseandneglectyouth) {
		this.abuseandneglectyouth = abuseandneglectyouth;
	}
	/**
	 * @return the activemilitaryparent
	 */
	public String getActivemilitaryparent() {
		return activemilitaryparent;
	}
	/**
	 * @param activemilitaryparent the activemilitaryparent to set
	 */
	public void setActivemilitaryparent(String activemilitaryparent) {
		this.activemilitaryparent = activemilitaryparent;
	}
	/**
	 * @return the alcoholdrugabusefam
	 */
	public String getAlcoholdrugabusefam() {
		return alcoholdrugabusefam;
	}
	/**
	 * @param alcoholdrugabusefam the alcoholdrugabusefam to set
	 */
	public void setAlcoholdrugabusefam(String alcoholdrugabusefam) {
		this.alcoholdrugabusefam = alcoholdrugabusefam;
	}
	/**
	 * @return the alcoholdrugabuseyouth
	 */
	public String getAlcoholdrugabuseyouth() {
		return alcoholdrugabuseyouth;
	}
	/**
	 * @param alcoholdrugabuseyouth the alcoholdrugabuseyouth to set
	 */
	public void setAlcoholdrugabuseyouth(String alcoholdrugabuseyouth) {
		this.alcoholdrugabuseyouth = alcoholdrugabuseyouth;
	}
	/**
	 * @return the healthissuesfam
	 */
	public String getHealthissuesfam() {
		return healthissuesfam;
	}
	/**
	 * @param healthissuesfam the healthissuesfam to set
	 */
	public void setHealthissuesfam(String healthissuesfam) {
		this.healthissuesfam = healthissuesfam;
	}
	/**
	 * @return the healthissuesyouth
	 */
	public String getHealthissuesyouth() {
		return healthissuesyouth;
	}
	/**
	 * @param healthissuesyouth the healthissuesyouth to set
	 */
	public void setHealthissuesyouth(String healthissuesyouth) {
		this.healthissuesyouth = healthissuesyouth;
	}
	/**
	 * @return the householddynamics
	 */
	public String getHouseholddynamics() {
		return householddynamics;
	}
	/**
	 * @param householddynamics the householddynamics to set
	 */
	public void setHouseholddynamics(String householddynamics) {
		this.householddynamics = householddynamics;
	}
	/**
	 * @return the housingissuesfam
	 */
	public String getHousingissuesfam() {
		return housingissuesfam;
	}
	/**
	 * @param housingissuesfam the housingissuesfam to set
	 */
	public void setHousingissuesfam(String housingissuesfam) {
		this.housingissuesfam = housingissuesfam;
	}
	/**
	 * @return the housingissuesyouth
	 */
	public String getHousingissuesyouth() {
		return housingissuesyouth;
	}
	/**
	 * @param housingissuesyouth the housingissuesyouth to set
	 */
	public void setHousingissuesyouth(String housingissuesyouth) {
		this.housingissuesyouth = housingissuesyouth;
	}
	/**
	 * @return the incarceratedparent
	 */
	public String getIncarceratedparent() {
		return incarceratedparent;
	}
	/**
	 * @param incarceratedparent the incarceratedparent to set
	 */
	public void setIncarceratedparent(String incarceratedparent) {
		this.incarceratedparent = incarceratedparent;
	}
	/**
	 * @return the incarceratedparentstatus
	 */
	public String getIncarceratedparentstatus() {
		return incarceratedparentstatus;
	}
	/**
	 * @param incarceratedparentstatus the incarceratedparentstatus to set
	 */
	public void setIncarceratedparentstatus(String incarceratedparentstatus) {
		this.incarceratedparentstatus = incarceratedparentstatus;
	}
	/**
	 * @return the insufficientincome
	 */
	public String getInsufficientincome() {
		return insufficientincome;
	}
	/**
	 * @param insufficientincome the insufficientincome to set
	 */
	public void setInsufficientincome(String insufficientincome) {
		this.insufficientincome = insufficientincome;
	}
	/**
	 * @return the mentaldisabilityfam
	 */
	public String getMentaldisabilityfam() {
		return mentaldisabilityfam;
	}
	/**
	 * @param mentaldisabilityfam the mentaldisabilityfam to set
	 */
	public void setMentaldisabilityfam(String mentaldisabilityfam) {
		this.mentaldisabilityfam = mentaldisabilityfam;
	}
	/**
	 * @return the mentaldisabilityyouth
	 */
	public String getMentaldisabilityyouth() {
		return mentaldisabilityyouth;
	}
	/**
	 * @param mentaldisabilityyouth the mentaldisabilityyouth to set
	 */
	public void setMentaldisabilityyouth(String mentaldisabilityyouth) {
		this.mentaldisabilityyouth = mentaldisabilityyouth;
	}
	/**
	 * @return the mentalhealthissuesfam
	 */
	public String getMentalhealthissuesfam() {
		return mentalhealthissuesfam;
	}
	/**
	 * @param mentalhealthissuesfam the mentalhealthissuesfam to set
	 */
	public void setMentalhealthissuesfam(String mentalhealthissuesfam) {
		this.mentalhealthissuesfam = mentalhealthissuesfam;
	}
	/**
	 * @return the mentalhealthissuesyouth
	 */
	public String getMentalhealthissuesyouth() {
		return mentalhealthissuesyouth;
	}
	/**
	 * @param mentalhealthissuesyouth the mentalhealthissuesyouth to set
	 */
	public void setMentalhealthissuesyouth(String mentalhealthissuesyouth) {
		this.mentalhealthissuesyouth = mentalhealthissuesyouth;
	}
	/**
	 * @return the physicaldisabilityfam
	 */
	public String getPhysicaldisabilityfam() {
		return physicaldisabilityfam;
	}
	/**
	 * @param physicaldisabilityfam the physicaldisabilityfam to set
	 */
	public void setPhysicaldisabilityfam(String physicaldisabilityfam) {
		this.physicaldisabilityfam = physicaldisabilityfam;
	}
	/**
	 * @return the physicaldisabilityyouth
	 */
	public String getPhysicaldisabilityyouth() {
		return physicaldisabilityyouth;
	}
	/**
	 * @param physicaldisabilityyouth the physicaldisabilityyouth to set
	 */
	public void setPhysicaldisabilityyouth(String physicaldisabilityyouth) {
		this.physicaldisabilityyouth = physicaldisabilityyouth;
	}
	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}
	/**
	 * @param enrollmentid the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}
	/**
	 * @return the schooleducationalissuesfam
	 */
	public String getSchooleducationalissuesfam() {
		return schooleducationalissuesfam;
	}
	/**
	 * @param schooleducationalissuesfam the schooleducationalissuesfam to set
	 */
	public void setSchooleducationalissuesfam(String schooleducationalissuesfam) {
		this.schooleducationalissuesfam = schooleducationalissuesfam;
	}
	/**
	 * @return the schooleducationalissuesyouth
	 */
	public String getSchooleducationalissuesyouth() {
		return schooleducationalissuesyouth;
	}
	/**
	 * @param schooleducationalissuesyouth the schooleducationalissuesyouth to set
	 */
	public void setSchooleducationalissuesyouth(String schooleducationalissuesyouth) {
		this.schooleducationalissuesyouth = schooleducationalissuesyouth;
	}
	/**
	 * @return the sexualorientationgenderidfam
	 */
	public String getSexualorientationgenderidfam() {
		return sexualorientationgenderidfam;
	}
	/**
	 * @param sexualorientationgenderidfam the sexualorientationgenderidfam to set
	 */
	public void setSexualorientationgenderidfam(String sexualorientationgenderidfam) {
		this.sexualorientationgenderidfam = sexualorientationgenderidfam;
	}
	/**
	 * @return the sexualorientationgenderidyouth
	 */
	public String getSexualorientationgenderidyouth() {
		return sexualorientationgenderidyouth;
	}
	/**
	 * @param sexualorientationgenderidyouth the sexualorientationgenderidyouth to set
	 */
	public void setSexualorientationgenderidyouth(
			String sexualorientationgenderidyouth) {
		this.sexualorientationgenderidyouth = sexualorientationgenderidyouth;
	}
	/**
	 * @return the unemploymentfam
	 */
	public String getUnemploymentfam() {
		return unemploymentfam;
	}
	/**
	 * @param unemploymentfam the unemploymentfam to set
	 */
	public void setUnemploymentfam(String unemploymentfam) {
		this.unemploymentfam = unemploymentfam;
	}
	/**
	 * @return the unemploymentyouth
	 */
	public String getUnemploymentyouth() {
		return unemploymentyouth;
	}
	/**
	 * @param unemploymentyouth the unemploymentyouth to set
	 */
	public void setUnemploymentyouth(String unemploymentyouth) {
		this.unemploymentyouth = unemploymentyouth;
	}
	
	
}
