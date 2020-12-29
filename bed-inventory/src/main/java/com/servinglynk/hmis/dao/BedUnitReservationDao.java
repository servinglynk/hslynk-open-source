package com.servinglynk.hmis.dao;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.BedUnitReservationEntity;

public interface BedUnitReservationDao {

	
	PageImpl<BedUnitReservationEntity> getBedUnits(UUID bedUnitId, Date fromdate,Date todate,Pageable pageable);
	PageImpl<BedUnitReservationEntity> getClientBedUnitReservations(UUID clientDedupId, Date fromdate,Date todate,Pageable pageable);
	Boolean checkBedUnitOrRoomReservation(UUID bedUnitId, UUID roomId, Date startDate, Date endDate,
			UUID clientId);
}
