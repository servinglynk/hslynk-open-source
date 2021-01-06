package com.servinglynk.hmis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.repository.AreaRepository;
import com.servinglynk.hmis.repository.BedOccupantRepository;
import com.servinglynk.hmis.repository.BedUnitRepository;
import com.servinglynk.hmis.repository.BedUnitReservationRepository;
import com.servinglynk.hmis.repository.ClientRepository;
import com.servinglynk.hmis.repository.HousingUnitOccupantRepository;
import com.servinglynk.hmis.repository.HousingUnitRepository;
import com.servinglynk.hmis.repository.HousingUnitReservationRepository;
import com.servinglynk.hmis.repository.RoomOccupantRepository;
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
	@Autowired private SummaryDao summaryDao;
	@Autowired private BedUnitReservationDao bedUnitReservationDao;
	@Autowired private BedOccupantDao bedOccupantDao;
	@Autowired private RoomReservationDao roomReservationDao;
	@Autowired private ClientRepository clientRepository;
	@Autowired private HousingUnitOccupantDao housingUnitOccupantDao;
	@Autowired private HousingUnitReservationDao housingUnitReservationDao;
	@Autowired private RoomOccupantRepository roomOccupantRepository;
	@Autowired private RoomOccupantDao roomOccupantDao;
	@Autowired private BedUnitDao bedUnitDao;
	@Autowired private HousingUnitDao housingUnitDao;
	
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
	public SummaryDao getSummaryDao() {
		return summaryDao;
	}
	public void setSummaryDao(SummaryDao summaryDao) {
		this.summaryDao = summaryDao;
	}
	public BedUnitReservationDao getBedUnitReservationDao() {
		return bedUnitReservationDao;
	}
	public void setBedUnitReservationDao(BedUnitReservationDao bedUnitReservationDao) {
		this.bedUnitReservationDao = bedUnitReservationDao;
	}
	public BedOccupantDao getBedOccupantDao() {
		return bedOccupantDao;
	}
	public void setBedOccupantDao(BedOccupantDao bedOccupantDao) {
		this.bedOccupantDao = bedOccupantDao;
	}
	public RoomReservationDao getRoomReservationDao() {
		return roomReservationDao;
	}
	public void setRoomReservationDao(RoomReservationDao roomReservationDao) {
		this.roomReservationDao = roomReservationDao;
	}
	public ClientRepository getClientRepository() {
		return clientRepository;
	}
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}
	public HousingUnitOccupantDao getHousingUnitOccupantDao() {
		return housingUnitOccupantDao;
	}
	public void setHousingUnitOccupantDao(HousingUnitOccupantDao housingUnitOccupantDao) {
		this.housingUnitOccupantDao = housingUnitOccupantDao;
	}
	public HousingUnitReservationDao getHousingUnitReservationDao() {
		return housingUnitReservationDao;
	}
	public void setHousingUnitReservationDao(HousingUnitReservationDao housingUnitReservationDao) {
		this.housingUnitReservationDao = housingUnitReservationDao;
	}
	public RoomOccupantRepository getRoomOccupantRepository() {
		return roomOccupantRepository;
	}
	public void setRoomOccupantRepository(RoomOccupantRepository roomOccupantRepository) {
		this.roomOccupantRepository = roomOccupantRepository;
	}
	public RoomOccupantDao getRoomOccupantDao() {
		return roomOccupantDao;
	}
	public void setRoomOccupantDao(RoomOccupantDao roomOccupantDao) {
		this.roomOccupantDao = roomOccupantDao;
	}
	public BedUnitDao getBedUnitDao() {
		return bedUnitDao;
	}
	public void setBedUnitDao(BedUnitDao bedUnitDao) {
		this.bedUnitDao = bedUnitDao;
	}
	public HousingUnitDao getHousingUnitDao() {
		return housingUnitDao;
	}
	public void setHousingUnitDao(HousingUnitDao housingUnitDao) {
		this.housingUnitDao = housingUnitDao;
	}
}