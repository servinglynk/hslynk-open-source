package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.entity.HousingUnitOccupantEntity;
import com.servinglynk.hmis.entity.HousingUnitReservationEntity;

public interface HousingUnitOccupantRepository extends JpaRepository<HousingUnitOccupantEntity, Serializable>{

	HousingUnitOccupantEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	
	
	 Page<HousingUnitOccupantEntity> findByHousingUnitAndProjectGroupCodeAndDeleted(HousingUnitEntity entity, String userProjectGroup, boolean deleted,Pageable pageable);

}
