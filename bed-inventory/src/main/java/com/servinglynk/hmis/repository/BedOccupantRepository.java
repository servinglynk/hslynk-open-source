package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedOccupantEntity;
import com.servinglynk.hmis.entity.BedUnitEntity;

public interface BedOccupantRepository extends JpaRepository<BedOccupantEntity, Serializable> {

	BedOccupantEntity findByIdAndProjectGroupCodeAndDeleted(UUID bedUnitId, String userProjectGroup, boolean deleted);
	
	Page<BedOccupantEntity> findByBedUnitAndDeleted(BedUnitEntity bedUnitEntity, boolean deleted,Pageable pageable);

}
