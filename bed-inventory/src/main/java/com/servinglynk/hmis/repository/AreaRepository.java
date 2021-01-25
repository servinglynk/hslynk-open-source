package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.entity.ShelterEntity;

public interface AreaRepository extends JpaRepository<AreaEntity, Serializable> {
	
	Page<AreaEntity>	findByShelter(ShelterEntity entity,Pageable pageable);

	AreaEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	
	
	@Modifying
	@Query(value = "update AreaEntity set deleted = true, dateUpdated = CURRENT_TIMESTAMP   where id= :#{#entity.id}")
	void delete(@Param("entity") AreaEntity entity) ;

}
