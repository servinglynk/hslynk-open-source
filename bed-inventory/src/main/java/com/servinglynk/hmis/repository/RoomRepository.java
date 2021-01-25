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
import com.servinglynk.hmis.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Serializable> {
	Page<RoomEntity> findByArea(AreaEntity areaEntity,Pageable pageable);

	RoomEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);

	Page<RoomEntity> findByAreaAndDeleted(AreaEntity areaEntity, boolean deleted, Pageable pageable);
	
	
	@Modifying
	@Query(value = "update RoomEntity set deleted = true, dateUpdated = CURRENT_TIMESTAMP   where id= :#{#entity.id}")
	void delete(@Param("entity") RoomEntity entity) ;
}
