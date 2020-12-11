package com.servinglynk.hmis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonRootName("summary")
@JsonInclude(value = Include.NON_NULL)
public class InventorySummary extends ClientModel {
	
	
	private Long totalAreas;
	private Long totalRooms;
	private Long totalBeds;
	private Long occupiedBeds;
	private Long reservedBeds;
	private Long vacantBeds;
	
	public Long getTotalAreas() {
		return totalAreas;
	}
	public void setTotalAreas(Long totalAreas) {
		this.totalAreas = totalAreas;
	}
	public Long getTotalRooms() {
		return totalRooms;
	}
	public void setTotalRooms(Long totalRooms) {
		this.totalRooms = totalRooms;
	}
	public Long getTotalBeds() {
		return totalBeds;
	}
	public void setTotalBeds(Long totalBeds) {
		this.totalBeds = totalBeds;
	}
	public Long getOccupiedBeds() {
		return occupiedBeds;
	}
	public void setOccupiedBeds(Long occupiedBeds) {
		this.occupiedBeds = occupiedBeds;
	}
	public Long getReservedBeds() {
		return reservedBeds;
	}
	public void setReservedBeds(Long reservedBeds) {
		this.reservedBeds = reservedBeds;
	}
	public Long getVacantBeds() {
		return vacantBeds;
	}
	public void setVacantBeds(Long vacantBeds) {
		this.vacantBeds = vacantBeds;
	}	
}