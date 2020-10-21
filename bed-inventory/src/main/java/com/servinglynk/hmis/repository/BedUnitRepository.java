package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedUnitEntity;

public interface BedUnitRepository extends JpaRepository<BedUnitEntity, Serializable> {

	BedUnitEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);

}
