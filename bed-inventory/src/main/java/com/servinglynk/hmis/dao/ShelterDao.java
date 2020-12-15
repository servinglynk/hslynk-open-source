package com.servinglynk.hmis.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.entity.ShelterEntity;

public interface ShelterDao {
	
	Page<ShelterEntity> getAllShelters(String q,Pageable pageable);

}
