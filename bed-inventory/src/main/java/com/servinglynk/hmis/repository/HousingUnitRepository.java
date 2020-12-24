package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.HousingUnitEntity;

public interface HousingUnitRepository  extends JpaRepository<HousingUnitEntity, Serializable> {

	HousingUnitEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);

}
