package com.servinglynk.hmis.dao;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.RoomReservationEntity;

public interface RoomReservationDao {

	
	PageImpl<RoomReservationEntity> getRoomReservations(UUID roomId, Date fromdate,Date todate,Pageable pageable);
	PageImpl<RoomReservationEntity> getClientRoomReservations(UUID clientDedupId, Date fromdate, Date todate,
			Pageable pageable) ;
}
