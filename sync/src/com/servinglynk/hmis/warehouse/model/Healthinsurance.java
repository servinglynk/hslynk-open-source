package com.servinglynk.hmis.warehouse.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Healthinsurance extends BaseModel {

	@Column(name = "cobra")
	private String cobra;
	@Column(name = "employerprovidedemployerprovided")
	private String employerprovided;
	@Column(name = "insurancefromanysource")
	private String insurancefromanysource;
	@Column(name = "medicaid")
	private String medicaid;
	@Column(name = "medicare")
	private String medicare;
	@Column(name = "nocobrareason")
	private String nocobrareason;
	@Column(name = "noemployerprovidedreason")
	private String noemployerprovidedreason;
	@Column(name = "nomedicaidreason")
	private String nomedicaidreason;
	@Column(name = "nomedicarereason")
	private String nomedicarereason;
	@Column(name = "noprivatepayreason")
	private String noprivatepayreason;
	@Column(name = "noschipreason")
	private String noschipreason;
	@Column(name = "nostatehealthinsreason")
	private String nostatehealthinsreason;
	@Column(name = "novamedreason")
	private String novamedreason;
	@Column(name = "privatepay")
	private String privatepay;
	@Column(name = "enrollmentid")
	private UUID enrollmentid;
	@Column(name = "schip")
	private String schip;
	@Column(name = "statehealthins")
	private String statehealthins;
	@Column(name = "vamedicalservices")
	private String vamedicalservices;

	/**
	 * @return the cobra
	 */
	public String getCobra() {
		return cobra;
	}

	/**
	 * @param cobra
	 *            the cobra to set
	 */
	public void setCobra(String cobra) {
		this.cobra = cobra;
	}

	/**
	 * @return the employerprovided
	 */
	public String getEmployerprovided() {
		return employerprovided;
	}

	/**
	 * @param employerprovided
	 *            the employerprovided to set
	 */
	public void setEmployerprovided(String employerprovided) {
		this.employerprovided = employerprovided;
	}

	/**
	 * @return the insurancefromanysource
	 */
	public String getInsurancefromanysource() {
		return insurancefromanysource;
	}

	/**
	 * @param insurancefromanysource
	 *            the insurancefromanysource to set
	 */
	public void setInsurancefromanysource(String insurancefromanysource) {
		this.insurancefromanysource = insurancefromanysource;
	}

	/**
	 * @return the medicaid
	 */
	public String getMedicaid() {
		return medicaid;
	}

	/**
	 * @param medicaid
	 *            the medicaid to set
	 */
	public void setMedicaid(String medicaid) {
		this.medicaid = medicaid;
	}

	/**
	 * @return the medicare
	 */
	public String getMedicare() {
		return medicare;
	}

	/**
	 * @param medicare
	 *            the medicare to set
	 */
	public void setMedicare(String medicare) {
		this.medicare = medicare;
	}

	/**
	 * @return the nocobrareason
	 */
	public String getNocobrareason() {
		return nocobrareason;
	}

	/**
	 * @param nocobrareason
	 *            the nocobrareason to set
	 */
	public void setNocobrareason(String nocobrareason) {
		this.nocobrareason = nocobrareason;
	}

	/**
	 * @return the noemployerprovidedreason
	 */
	public String getNoemployerprovidedreason() {
		return noemployerprovidedreason;
	}

	/**
	 * @param noemployerprovidedreason
	 *            the noemployerprovidedreason to set
	 */
	public void setNoemployerprovidedreason(String noemployerprovidedreason) {
		this.noemployerprovidedreason = noemployerprovidedreason;
	}

	/**
	 * @return the nomedicaidreason
	 */
	public String getNomedicaidreason() {
		return nomedicaidreason;
	}

	/**
	 * @param nomedicaidreason
	 *            the nomedicaidreason to set
	 */
	public void setNomedicaidreason(String nomedicaidreason) {
		this.nomedicaidreason = nomedicaidreason;
	}

	/**
	 * @return the nomedicarereason
	 */
	public String getNomedicarereason() {
		return nomedicarereason;
	}

	/**
	 * @param nomedicarereason
	 *            the nomedicarereason to set
	 */
	public void setNomedicarereason(String nomedicarereason) {
		this.nomedicarereason = nomedicarereason;
	}

	/**
	 * @return the noprivatepayreason
	 */
	public String getNoprivatepayreason() {
		return noprivatepayreason;
	}

	/**
	 * @param noprivatepayreason
	 *            the noprivatepayreason to set
	 */
	public void setNoprivatepayreason(String noprivatepayreason) {
		this.noprivatepayreason = noprivatepayreason;
	}

	/**
	 * @return the noschipreason
	 */
	public String getNoschipreason() {
		return noschipreason;
	}

	/**
	 * @param noschipreason
	 *            the noschipreason to set
	 */
	public void setNoschipreason(String noschipreason) {
		this.noschipreason = noschipreason;
	}

	/**
	 * @return the nostatehealthinsreason
	 */
	public String getNostatehealthinsreason() {
		return nostatehealthinsreason;
	}

	/**
	 * @param nostatehealthinsreason
	 *            the nostatehealthinsreason to set
	 */
	public void setNostatehealthinsreason(String nostatehealthinsreason) {
		this.nostatehealthinsreason = nostatehealthinsreason;
	}

	/**
	 * @return the novamedreason
	 */
	public String getNovamedreason() {
		return novamedreason;
	}

	/**
	 * @param novamedreason
	 *            the novamedreason to set
	 */
	public void setNovamedreason(String novamedreason) {
		this.novamedreason = novamedreason;
	}

	/**
	 * @return the privatepay
	 */
	public String getPrivatepay() {
		return privatepay;
	}

	/**
	 * @param privatepay
	 *            the privatepay to set
	 */
	public void setPrivatepay(String privatepay) {
		this.privatepay = privatepay;
	}

	/**
	 * @return the enrollmentid
	 */
	public UUID getEnrollmentid() {
		return enrollmentid;
	}

	/**
	 * @param enrollmentid
	 *            the enrollmentid to set
	 */
	public void setEnrollmentid(UUID enrollmentid) {
		this.enrollmentid = enrollmentid;
	}

	/**
	 * @return the schip
	 */
	public String getSchip() {
		return schip;
	}

	/**
	 * @param schip
	 *            the schip to set
	 */
	public void setSchip(String schip) {
		this.schip = schip;
	}

	/**
	 * @return the statehealthins
	 */
	public String getStatehealthins() {
		return statehealthins;
	}

	/**
	 * @param statehealthins
	 *            the statehealthins to set
	 */
	public void setStatehealthins(String statehealthins) {
		this.statehealthins = statehealthins;
	}

	/**
	 * @return the vamedicalservices
	 */
	public String getVamedicalservices() {
		return vamedicalservices;
	}

	/**
	 * @param vamedicalservices
	 *            the vamedicalservices to set
	 */
	public void setVamedicalservices(String vamedicalservices) {
		this.vamedicalservices = vamedicalservices;
	}

}
