package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.RoomModel;
import com.servinglynk.hmis.model.Rooms;

public interface RoomService {
	RoomModel createRoom(RoomModel room);
	void updateRoom(RoomModel room);
	void deleteRoom(UUID roomId);
	RoomModel getRoom(UUID roomId);
	Rooms getRooms(UUID shelterid, UUID areaid, Pageable pageable);
}