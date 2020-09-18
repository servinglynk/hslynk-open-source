package com.servinglynk.hmis.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.HousingUnitReservationEntity;

public interface HousingUnitReservationRepository extends JpaRepository<HousingUnitReservationEntity, Serializable> {

}
