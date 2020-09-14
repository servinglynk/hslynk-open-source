package com.servinglynk.hmis.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.BedUnitReservationEntity;

public interface BedUnitReservationRepository extends JpaRepository<BedUnitReservationEntity, Serializable> {

}
