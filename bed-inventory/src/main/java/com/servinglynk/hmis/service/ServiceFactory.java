package com.servinglynk.hmis.service;

public interface ServiceFactory {
	public AreaService getAreaService();
	public BedUnitService getBedUnitService() ;
	public BedReservationService getBedReservationService() ;
	public BedOccupantService getBedOccupantService() ;
	public HousingUnitOccupantService getHousingUnitOccupantService() ;
	public HousingUnitService getHousingUnitService();
	public HousingUnitReservationService getHousingUnitReservationService();
	public RoomService getRoomService();
	public RoomReservationService getRoomReservationService();
	public ShelterService getShelterService();
}
