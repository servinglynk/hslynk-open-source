package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class RoomReservations {

	List<RoomReservation> roomReservations = new ArrayList<RoomReservation>();

	public List<RoomReservation> getRoomReservations() {
		return roomReservations;
	}

	public void setRoomReservations(List<RoomReservation> roomReservations) {
		this.roomReservations = roomReservations;
	}
	
	public void addRoomReservation(RoomReservation roomReservation) {
		this.roomReservations.add(roomReservation);
	}
}
