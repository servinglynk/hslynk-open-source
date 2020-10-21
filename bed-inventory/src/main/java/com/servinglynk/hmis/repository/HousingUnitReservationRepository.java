package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.HousingUnitReservationEntity;

public interface HousingUnitReservationRepository extends JpaRepository<HousingUnitReservationEntity, Serializable> {

	HousingUnitReservationEntity findByIdAndProjectGroupCodeAndDeleted(UUID housingUnitReservationId,
			String userProjectGroup, boolean deleted);

}
