package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.RoomReservation;
import com.servinglynk.hmis.model.RoomReservations;

public interface RoomReservationService {
	RoomReservation createRoomReservation(RoomReservation roomReservation);
	void updateRoomReservation(RoomReservation roomReservation);
	void deleteRoomReservation(UUID roomReservationId);
	RoomReservation getRoomReservation(UUID roomReservationId);
	RoomReservations getRoomReservations(UUID roomid, Date fromdate, Date todate, Pageable pageable);
}