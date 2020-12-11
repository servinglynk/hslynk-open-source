package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;

public interface BedUnitRepository extends JpaRepository<BedUnitEntity, Serializable> {

	BedUnitEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	List<BedUnitEntity> findByRoomAndDeleted(RoomEntity roomEntity, boolean deleted);

}
