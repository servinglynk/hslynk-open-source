package com.servinglynk.hmis.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.RoomOccupant;
import com.servinglynk.hmis.model.RoomOccupants;

public interface RoomOccupantService {

	RoomOccupants getRoomOccupants(UUID roomid, Date fromdate, Date todate, Pageable pageable);

	RoomOccupant getRoomOccupant(UUID roomreservationId);

	void checkoutRoomOccupant(RoomOccupant model) throws Exception;

	RoomOccupant createRoomOccupant(RoomOccupant model) throws Exception;

}
