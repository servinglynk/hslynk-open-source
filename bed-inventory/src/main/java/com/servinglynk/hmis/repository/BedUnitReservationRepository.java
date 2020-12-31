package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.BedUnitReservationEntity;

public interface BedUnitReservationRepository extends JpaRepository<BedUnitReservationEntity, Serializable> {

	BedUnitReservationEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	
	Page<BedUnitReservationEntity> findByBedUnitAndDeleted(BedUnitEntity bedUnitEntity,  boolean deleted,Pageable pageable);

}
