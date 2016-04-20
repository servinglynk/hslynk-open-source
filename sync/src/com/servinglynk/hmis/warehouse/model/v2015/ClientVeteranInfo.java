package com.servinglynk.hmis.warehouse.model.v2015;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class ClientVeteranInfo extends BaseModel{
	

	@Column( name = "afghanistan_oef")
	private Integer afghanistanOef;
	
	@Column(name = "client_id")
	private UUID clientId;
	
	@Column( name = "desert_storm")
	private Integer desertStorm;
	
	@Column( name = "discharge_status")
	private Integer dischargeStatus;
	
	@Column( name = "id")
	private UUID id;
	
    @Column( name = "iraq_oif")
	private Integer iraqOif;
	
	@Column( name = "iraq_ond")
	private Integer iraqOnd;
	
	@Column( name = "korean_war")
	private Integer koreanWar;
	
	@Column( name = "military_branch")
	private Integer militaryBranch;
	
	@Column( name = "other_theater")
	private Integer otherTheater;
	
	@Column( name = "vietnam_war")
	private Integer vietnamWar;
	
	@Column( name = "world_war_2")
	private Integer worldWar2;
	
	@Column( name = "year_entrd_service")
	private Integer yearEntrdService;
	
	@Column( name = "year_seperated")
	private Integer yearSeperated;

	public Integer getAfghanistanOef() {
		return afghanistanOef;
	}

	public void setAfghanistanOef(Integer afghanistanOef) {
		this.afghanistanOef = afghanistanOef;
	}

	public UUID getClientId() {
		return clientId;
	}

	public void setClientId(UUID clientId) {
		this.clientId = clientId;
	}

	public Integer getDesertStorm() {
		return desertStorm;
	}

	public void setDesertStorm(Integer desertStorm) {
		this.desertStorm = desertStorm;
	}

	public Integer getDischargeStatus() {
		return dischargeStatus;
	}

	public void setDischargeStatus(Integer dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getIraqOif() {
		return iraqOif;
	}

	public void setIraqOif(Integer iraqOif) {
		this.iraqOif = iraqOif;
	}

	public Integer getIraqOnd() {
		return iraqOnd;
	}

	public void setIraqOnd(Integer iraqOnd) {
		this.iraqOnd = iraqOnd;
	}

	public Integer getKoreanWar() {
		return koreanWar;
	}

	public void setKoreanWar(Integer koreanWar) {
		this.koreanWar = koreanWar;
	}

	public Integer getMilitaryBranch() {
		return militaryBranch;
	}

	public void setMilitaryBranch(Integer militaryBranch) {
		this.militaryBranch = militaryBranch;
	}

	public Integer getOtherTheater() {
		return otherTheater;
	}

	public void setOtherTheater(Integer otherTheater) {
		this.otherTheater = otherTheater;
	}

	public Integer getVietnamWar() {
		return vietnamWar;
	}

	public void setVietnamWar(Integer vietnamWar) {
		this.vietnamWar = vietnamWar;
	}

	public Integer getWorldWar2() {
		return worldWar2;
	}

	public void setWorldWar2(Integer worldWar2) {
		this.worldWar2 = worldWar2;
	}

	public Integer getYearEntrdService() {
		return yearEntrdService;
	}

	public void setYearEntrdService(Integer yearEntrdService) {
		this.yearEntrdService = yearEntrdService;
	}

	public Integer getYearSeperated() {
		return yearSeperated;
	}

	public void setYearSeperated(Integer yearSeperated) {
		this.yearSeperated = yearSeperated;
	}
	
	

}

