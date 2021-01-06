package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.RoomOccupantEntity;

public interface RoomOccupantRepository extends JpaRepository<RoomOccupantEntity, Serializable> {

	RoomOccupantEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	
	Page<RoomOccupantEntity> findByRoomAndDeleted(RoomEntity roomEntity, boolean deleted,Pageable pageable);

}
