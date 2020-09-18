package com.servinglynk.hmis.dao;

import com.servinglynk.hmis.repository.AreaRepository;
import com.servinglynk.hmis.repository.BedOccupantRepository;
import com.servinglynk.hmis.repository.BedUnitRepository;
import com.servinglynk.hmis.repository.BedUnitReservationRepository;
import com.servinglynk.hmis.repository.HousingUnitOccupantRepository;
import com.servinglynk.hmis.repository.HousingUnitRepository;
import com.servinglynk.hmis.repository.HousingUnitReservationRepository;
import com.servinglynk.hmis.repository.RoomRepository;
import com.servinglynk.hmis.repository.RoomReservationRepository;
import com.servinglynk.hmis.repository.ShelterRepository;

public interface DaoFactory {

	
	ShelterRepository getShelterRepository();
	RoomRepository getRoomRepository();
	AreaRepository getAreaRepository();
	BedUnitRepository getBedUnitRepository();
	HousingUnitRepository getHousingUnitRepository();
	BedOccupantRepository getBedOccupantRepository();
	HousingUnitOccupantRepository getHousingUnitOccupantRepository();
	RoomReservationRepository getRoomReservationRepository();
	BedUnitReservationRepository getBedUnitReservationRepository();
	HousingUnitReservationRepository getHousingUnitReservationRepository();
}
