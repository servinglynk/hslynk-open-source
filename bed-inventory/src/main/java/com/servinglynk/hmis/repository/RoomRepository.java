package com.servinglynk.hmis.repository;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.AreaEntity;
import com.servinglynk.hmis.entity.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity, Serializable> {
	Page<RoomEntity> findByAreaEntity(AreaEntity areaEntity,Pageable pageable);
}
