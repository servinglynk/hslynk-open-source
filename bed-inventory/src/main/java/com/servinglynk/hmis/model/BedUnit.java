package com.servinglynk.hmis.model;

import java.util.UUID;

public class BedUnit {
	
	private UUID id;
	private Boolean occupancy;
	private Integer occupantCapacity;
	private Boolean overflow;
	private Boolean isActive;
	private RoomModel room;
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public Boolean getOccupancy() {
		return occupancy;
	}
	public void setOccupancy(Boolean occupancy) {
		this.occupancy = occupancy;
	}
	public Integer getOccupantCapacity() {
		return occupantCapacity;
	}
	public void setOccupantCapacity(Integer occupantCapacity) {
		this.occupantCapacity = occupantCapacity;
	}
	public Boolean getOverflow() {
		return overflow;
	}
	public void setOverflow(Boolean overflow) {
		this.overflow = overflow;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	public RoomModel getRoom() {
		return room;
	}
	public void setRoom(RoomModel room) {
		this.room = room;
	}
	public void setRoomId(UUID roomid) {
		if(this.room == null) room = new RoomModel();
		room.setId(roomid);		
	}
}