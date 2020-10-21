package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedOccupantEntity;

public interface BedOccupantRepository extends JpaRepository<BedOccupantEntity, Serializable> {

	BedOccupantEntity findByIdAndProjectGroupCodeAndDeleted(UUID bedUnitId, String userProjectGroup, boolean deleted);

}
