package com.servinglynk.hmis.dao;

import java.util.UUID;

public interface SummaryDao {
	Long getBedCount(UUID roomId,UUID areaId,UUID shelterId);
	Long getRoomCount(UUID areaId,UUID shelterId);
	Long getAreaCount(UUID shelterId);
	Long getShelterCount(UUID shelterId);
	Long getReservedBeds(UUID bedId,UUID roomId,UUID areaId,UUID shelterId);
	Long getOccupiedBeds(UUID bedId,UUID roomId,UUID areaId,UUID shelterId);
	Long getReservedRooms(UUID roomId,UUID areaId,UUID shelterId);
}
