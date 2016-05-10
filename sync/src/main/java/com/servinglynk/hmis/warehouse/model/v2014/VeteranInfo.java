package com.servinglynk.hmis.warehouse.model.v2014;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;

@Entity
public class VeteranInfo extends BaseModel {
	@Column(name = "year_entrd_service")	
	public String year_entrd_service;
	@Column(name = "year_seperated")
	public String year_seperated;
	@Column(name = "world_war_2")	
	public String world_war_2;
	@Column(name = "korean_war")	
	public String korean_war;
	@Column(name = "vietnam_war")	
	public String vietnam_war;
	@Column(name = "desert_storm")	
	public String desert_storm;
	@Column(name = "afghanistan_oef")	
	public String afghanistan_oef;
	@Column(name = "iraq_oif")	
	public String iraq_oif;
	@Column(name = "iraq_ond")	
	public String iraq_ond;
	@Column(name = "other_theater")		
	public String other_theater;
	@Column(name = "military_branch")	
	public String military_branch;	
	@Column(name = "discharge_status")
	public String discharge_status;
	@Column(name = "cliend_id")
	public UUID cliend_id;
	/**
	 * @return the year_entrd_service
	 */
	public String getYear_entrd_service() {
		return year_entrd_service;
	}
	/**
	 * @param year_entrd_service the year_entrd_service to set
	 */
	public void setYear_entrd_service(String year_entrd_service) {
		this.year_entrd_service = year_entrd_service;
	}
	/**
	 * @return the year_seperated
	 */
	public String getYear_seperated() {
		return year_seperated;
	}
	/**
	 * @param year_seperated the year_seperated to set
	 */
	public void setYear_seperated(String year_seperated) {
		this.year_seperated = year_seperated;
	}
	/**
	 * @return the world_war_2
	 */
	public String getWorld_war_2() {
		return world_war_2;
	}
	/**
	 * @param world_war_2 the world_war_2 to set
	 */
	public void setWorld_war_2(String world_war_2) {
		this.world_war_2 = world_war_2;
	}
	/**
	 * @return the korean_war
	 */
	public String getKorean_war() {
		return korean_war;
	}
	/**
	 * @param korean_war the korean_war to set
	 */
	public void setKorean_war(String korean_war) {
		this.korean_war = korean_war;
	}
	/**
	 * @return the vietnam_war
	 */
	public String getVietnam_war() {
		return vietnam_war;
	}
	/**
	 * @param vietnam_war the vietnam_war to set
	 */
	public void setVietnam_war(String vietnam_war) {
		this.vietnam_war = vietnam_war;
	}
	/**
	 * @return the desert_storm
	 */
	public String getDesert_storm() {
		return desert_storm;
	}
	/**
	 * @param desert_storm the desert_storm to set
	 */
	public void setDesert_storm(String desert_storm) {
		this.desert_storm = desert_storm;
	}
	/**
	 * @return the afghanistan_oef
	 */
	public String getAfghanistan_oef() {
		return afghanistan_oef;
	}
	/**
	 * @param afghanistan_oef the afghanistan_oef to set
	 */
	public void setAfghanistan_oef(String afghanistan_oef) {
		this.afghanistan_oef = afghanistan_oef;
	}
	/**
	 * @return the iraq_oif
	 */
	public String getIraq_oif() {
		return iraq_oif;
	}
	/**
	 * @param iraq_oif the iraq_oif to set
	 */
	public void setIraq_oif(String iraq_oif) {
		this.iraq_oif = iraq_oif;
	}
	/**
	 * @return the iraq_ond
	 */
	public String getIraq_ond() {
		return iraq_ond;
	}
	/**
	 * @param iraq_ond the iraq_ond to set
	 */
	public void setIraq_ond(String iraq_ond) {
		this.iraq_ond = iraq_ond;
	}
	/**
	 * @return the other_theater
	 */
	public String getOther_theater() {
		return other_theater;
	}
	/**
	 * @param other_theater the other_theater to set
	 */
	public void setOther_theater(String other_theater) {
		this.other_theater = other_theater;
	}
	/**
	 * @return the military_branch
	 */
	public String getMilitary_branch() {
		return military_branch;
	}
	/**
	 * @param military_branch the military_branch to set
	 */
	public void setMilitary_branch(String military_branch) {
		this.military_branch = military_branch;
	}
	/**
	 * @return the discharge_status
	 */
	public String getDischarge_status() {
		return discharge_status;
	}
	/**
	 * @param discharge_status the discharge_status to set
	 */
	public void setDischarge_status(String discharge_status) {
		this.discharge_status = discharge_status;
	}
	/**
	 * @return the cliend_id
	 */
	public UUID getCliend_id() {
		return cliend_id;
	}
	/**
	 * @param cliend_id the cliend_id to set
	 */
	public void setCliend_id(UUID cliend_id) {
		this.cliend_id = cliend_id;
	}

}
