package com.servinglynk.hmis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class DaoFactoryImpl implements DaoFactory {

	
	@Autowired private ShelterRepository shelterRepository;
	@Autowired private RoomRepository roomRepository;
	@Autowired private AreaRepository areaRepository;
	@Autowired private BedUnitRepository bedUnitRepository;
	@Autowired private HousingUnitRepository housingUnitRepository;
	@Autowired private BedOccupantRepository bedOccupantRepository;
	@Autowired private HousingUnitOccupantRepository housingUnitOccupantRepository;
	@Autowired private RoomReservationRepository roomReservationRepository;
	@Autowired private BedUnitReservationRepository bedUnitReservationRepository;
	@Autowired private HousingUnitReservationRepository housingUnitReservationRepository;
	@Autowired private ShelterDao shelterDao;
	
	public ShelterRepository getShelterRepository() {
		return shelterRepository;
	}
	public void setShelterRepository(ShelterRepository shelterRepository) {
		this.shelterRepository = shelterRepository;
	}
	public RoomRepository getRoomRepository() {
		return roomRepository;
	}
	public void setRoomRepository(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}
	public AreaRepository getAreaRepository() {
		return areaRepository;
	}
	public void setAreaRepository(AreaRepository areaRepository) {
		this.areaRepository = areaRepository;
	}
	public BedUnitRepository getBedUnitRepository() {
		return bedUnitRepository;
	}
	public void setBedUnitRepository(BedUnitRepository bedUnitRepository) {
		this.bedUnitRepository = bedUnitRepository;
	}
	public HousingUnitRepository getHousingUnitRepository() {
		return housingUnitRepository;
	}
	public void setHousingUnitRepository(HousingUnitRepository housingUnitRepository) {
		this.housingUnitRepository = housingUnitRepository;
	}
	public BedOccupantRepository getBedOccupantRepository() {
		return bedOccupantRepository;
	}
	public void setBedOccupantRepository(BedOccupantRepository bedOccupantRepository) {
		this.bedOccupantRepository = bedOccupantRepository;
	}
	public HousingUnitOccupantRepository getHousingUnitOccupantRepository() {
		return housingUnitOccupantRepository;
	}
	public void setHousingUnitOccupantRepository(HousingUnitOccupantRepository housingUnitOccupantRepository) {
		this.housingUnitOccupantRepository = housingUnitOccupantRepository;
	}
	public RoomReservationRepository getRoomReservationRepository() {
		return roomReservationRepository;
	}
	public void setRoomReservationRepository(RoomReservationRepository roomReservationRepository) {
		this.roomReservationRepository = roomReservationRepository;
	}
	public BedUnitReservationRepository getBedUnitReservationRepository() {
		return bedUnitReservationRepository;
	}
	public void setBedUnitReservationRepository(BedUnitReservationRepository bedUnitReservationRepository) {
		this.bedUnitReservationRepository = bedUnitReservationRepository;
	}
	public HousingUnitReservationRepository getHousingUnitReservationRepository() {
		return housingUnitReservationRepository;
	}
	public void setHousingUnitReservationRepository(HousingUnitReservationRepository housingUnitReservationRepository) {
		this.housingUnitReservationRepository = housingUnitReservationRepository;
	}
	public ShelterDao getShelterDao() {
		return shelterDao;
	}
	public void setShelterDao(ShelterDao shelterDao) {
		this.shelterDao = shelterDao;
	}	
	
}
