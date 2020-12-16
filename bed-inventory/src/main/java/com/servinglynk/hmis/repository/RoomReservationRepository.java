package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.RoomEntity;
import com.servinglynk.hmis.entity.RoomReservationEntity;

public interface RoomReservationRepository extends JpaRepository<RoomReservationEntity, Serializable> {

	RoomReservationEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);

	Page<RoomReservationEntity> findByRoomAndDeleted(RoomEntity roomEntity, boolean deleted, Pageable pageable);

}
