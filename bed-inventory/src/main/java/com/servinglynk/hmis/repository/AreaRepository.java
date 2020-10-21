package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.entity.ShelterEntity;

public interface AreaRepository extends JpaRepository<AreaEntity, Serializable> {
	
	Page<AreaEntity>	findByShelterEntity(ShelterEntity entity,Pageable pageable);

	AreaEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);

}
