package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.servinglynk.hmis.entity.HousingUnitEntity;
import com.servinglynk.hmis.entity.HousingUnitReservationEntity;

public interface HousingUnitReservationRepository extends JpaRepository<HousingUnitReservationEntity, Serializable> {

	HousingUnitReservationEntity findByIdAndProjectGroupCodeAndDeleted(UUID housingUnitReservationId,
			String userProjectGroup, boolean deleted);
	
	  Page<HousingUnitReservationEntity> findByHousingUnitAndProjectGroupCodeAndDeleted(HousingUnitEntity entity,	String userProjectGroup, boolean deleted,Pageable pageable);

	  
	  @Modifying
		@Query(value = "update HousingUnitReservationEntity set deleted = true, dateUpdated = CURRENT_TIMESTAMP   where id= :#{#entity.id}")
		void delete(@Param("entity") HousingUnitReservationEntity entity) ;
}
