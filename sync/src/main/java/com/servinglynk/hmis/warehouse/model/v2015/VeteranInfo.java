package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.servinglynk.hmis.warehouse.BaseModel;


@Entity
public class VeteranInfo extends BaseModel{
	

	@Column( name = "afghanistan_oef")
	private Integer afghanistan_oef;
	
	@Column(name = "client_id")
	private UUID client_id;
	
	@Column( name = "desert_storm")
	private Integer desert_storm;
	
	@Column( name = "discharge_status")
	private Integer discharge_status;
	
	@Column( name = "id")
	private UUID id;
	
    @Column( name = "iraq_oif")
	private Integer iraq_oif;
	
	@Column( name = "iraq_ond")
	private Integer iraq_ond;
	
	@Column( name = "korean_war")
	private Integer korean_war;
	
	@Column( name = "military_branch")
	private Integer military_branch;
	
	@Column( name = "other_theater")
	private Integer other_theater;
	
	@Column( name = "vietnam_war")
	private Integer vietnam_war;
	
	@Column( name = "world_war_2")
	private Integer world_war_2;
	
	@Column( name = "year_entrd_service")
	private Integer year_entrd_service;
	
	@Column( name = "year_seperated")
	private Integer year_seperated;

	public Integer getAfghanistan_oef() {
		return afghanistan_oef;
	}

	public void setAfghanistan_oef(Integer afghanistan_oef) {
		this.afghanistan_oef = afghanistan_oef;
	}

	public UUID getClient_id() {
		return client_id;
	}

	public void setClient_id(UUID client_id) {
		this.client_id = client_id;
	}

	public Integer getDesert_storm() {
		return desert_storm;
	}

	public void setDesert_storm(Integer desert_storm) {
		this.desert_storm = desert_storm;
	}

	public Integer getDischarge_status() {
		return discharge_status;
	}

	public void setDischarge_status(Integer discharge_status) {
		this.discharge_status = discharge_status;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getIraq_oif() {
		return iraq_oif;
	}

	public void setIraq_oif(Integer iraq_oif) {
		this.iraq_oif = iraq_oif;
	}

	public Integer getIraq_ond() {
		return iraq_ond;
	}

	public void setIraq_ond(Integer iraq_ond) {
		this.iraq_ond = iraq_ond;
	}

	public Integer getKorean_war() {
		return korean_war;
	}

	public void setKorean_war(Integer korean_war) {
		this.korean_war = korean_war;
	}

	public Integer getMilitary_branch() {
		return military_branch;
	}

	public void setMilitary_branch(Integer military_branch) {
		this.military_branch = military_branch;
	}

	public Integer getOther_theater() {
		return other_theater;
	}

	public void setOther_theater(Integer other_theater) {
		this.other_theater = other_theater;
	}

	public Integer getVietnam_war() {
		return vietnam_war;
	}

	public void setVietnam_war(Integer vietnam_war) {
		this.vietnam_war = vietnam_war;
	}

	public Integer getWorld_war_2() {
		return world_war_2;
	}

	public void setWorld_war_2(Integer world_war_2) {
		this.world_war_2 = world_war_2;
	}

	public Integer getYear_entrd_service() {
		return year_entrd_service;
	}

	public void setYear_entrd_service(Integer year_entrd_service) {
		this.year_entrd_service = year_entrd_service;
	}

	public Integer getYear_seperated() {
		return year_seperated;
	}

	public void setYear_seperated(Integer year_seperated) {
		this.year_seperated = year_seperated;
	}

	

}

