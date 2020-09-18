package com.servinglynk.hmis.service;

import java.util.UUID;

import org.springframework.data.domain.Pageable;

import com.servinglynk.hmis.model.ShelterModel;
import com.servinglynk.hmis.model.Shelters;

public interface ShelterService {
	ShelterModel createShelter(ShelterModel shelter);
	void updateShelter(ShelterModel shelter);
	void deleteShelter(UUID shelterId);
	ShelterModel getShelter(UUID shelterId);
	Shelters getShelters(Pageable pageable);
}