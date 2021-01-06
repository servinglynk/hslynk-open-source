package com.servinglynk.hmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceFactoryImpl extends BaseService implements ServiceFactory {

	@Autowired AreaService areaService;
	@Autowired BedUnitService bedUnitService;
	@Autowired BedReservationService bedReservationService;
	@Autowired BedOccupantService bedOccupantService;
	@Autowired HousingUnitOccupantService housingUnitOccupantService;
	@Autowired HousingUnitService housingUnitService;
	@Autowired HousingUnitReservationService housingUnitReservationService;
	@Autowired RoomService roomService;
	@Autowired RoomReservationService roomReservationService;
	@Autowired ShelterService shelterService;
	@Autowired RoomOccupantService roomOccupantService;
	
	public AreaService getAreaService() {
		return areaService;
	}
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}
	public BedUnitService getBedUnitService() {
		return bedUnitService;
	}
	public void setBedUnitService(BedUnitService bedUnitService) {
		this.bedUnitService = bedUnitService;
	}
	public BedReservationService getBedReservationService() {
		return bedReservationService;
	}
	public void setBedReservationService(BedReservationService bedReservationService) {
		this.bedReservationService = bedReservationService;
	}
	public BedOccupantService getBedOccupantService() {
		return bedOccupantService;
	}
	public void setBedOccupantService(BedOccupantService bedOccupantService) {
		this.bedOccupantService = bedOccupantService;
	}
	public HousingUnitOccupantService getHousingUnitOccupantService() {
		return housingUnitOccupantService;
	}
	public void setHousingUnitOccupantService(HousingUnitOccupantService housingUnitOccupantService) {
		this.housingUnitOccupantService = housingUnitOccupantService;
	}
	public HousingUnitService getHousingUnitService() {
		return housingUnitService;
	}
	public void setHousingUnitService(HousingUnitService housingUnitService) {
		this.housingUnitService = housingUnitService;
	}
	public HousingUnitReservationService getHousingUnitReservationService() {
		return housingUnitReservationService;
	}
	public void setHousingUnitReservationService(HousingUnitReservationService housingUnitReservationService) {
		this.housingUnitReservationService = housingUnitReservationService;
	}
	public RoomService getRoomService() {
		return roomService;
	}
	public void setRoomService(RoomService roomService) {
		this.roomService = roomService;
	}
	public RoomReservationService getRoomReservationService() {
		return roomReservationService;
	}
	public void setRoomReservationService(RoomReservationService roomReservationService) {
		this.roomReservationService = roomReservationService;
	}
	public ShelterService getShelterService() {
		return shelterService;
	}
	public void setShelterService(ShelterService shelterService) {
		this.shelterService = shelterService;
	}
	public RoomOccupantService getRoomOccupantService() {
		return roomOccupantService;
	}
	public void setRoomOccupantService(RoomOccupantService roomOccupantService) {
		this.roomOccupantService = roomOccupantService;
	}
	
	
}
