package com.servinglynk.hmis.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.servinglynk.hmis.entity.BedUnitEntity;
import com.servinglynk.hmis.entity.RoomEntity;

public interface BedUnitRepository extends JpaRepository<BedUnitEntity, Serializable>, BaseRepository<BedUnitEntity, Serializable> {

	BedUnitEntity findByIdAndProjectGroupCodeAndDeleted(UUID id, String userProjectGroup, boolean deleted);
	List<BedUnitEntity> findByRoomAndDeleted(RoomEntity roomEntity, boolean deleted);
	Page<BedUnitEntity> findByRoomAndDeleted(RoomEntity roomEntity, boolean deleted,Pageable pageable);
	
	@Modifying
	@Query(value = "update BedUnitEntity set deleted = true, dateUpdated = CURRENT_TIMESTAMP   where id= :#{#entity.id}")
	void delete(@Param("entity") BedUnitEntity entity) ;

}
