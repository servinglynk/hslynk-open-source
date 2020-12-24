package com.servinglynk.hmis.model;

import java.util.ArrayList;
import java.util.List;

public class Rooms extends PaginatedModel{
	
	List<RoomModel> rooms = new ArrayList<RoomModel>();

	
	
	public List<RoomModel> getRooms() {
		return rooms;
	}



	public void setRooms(List<RoomModel> rooms) {
		this.rooms = rooms;
	}



	public void addRoom(RoomModel room) {
	this.rooms.add(room);
		
	}

}
