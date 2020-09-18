package com.servinglynk.hmis.rest;

import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.model.ShelterModel;
import com.servinglynk.hmis.model.Shelters;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/shelters")
public class ShelterController extends BaseController{
	
	@RequestMapping(method = RequestMethod.POST)
	@APIMapping(value = "CREATE_SHELTER",checkSessionToken = true,checkTrustedApp = true)
	ShelterModel createShelter(@RequestBody ShelterModel shelter) {
		return serviceFactory.getShelterService().createShelter(shelter);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/{shelterid}")
	@APIMapping(value = "UPDATE_SHELTER",checkSessionToken = true,checkTrustedApp = true)
	void updateShelter(@RequestBody ShelterModel shelter,@PathVariable("shelterid") UUID shelterid) {
		shelter.setId(shelterid);
		serviceFactory.getShelterService().updateShelter(shelter);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/{shelterid}")
	@APIMapping(value = "DELETE_SHELTER",checkSessionToken = true,checkTrustedApp = true)
	void deleteShelter(@PathVariable("shelterid") UUID shelterId) {
		serviceFactory.getShelterService().deleteShelter(shelterId);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/{shelterid}")
	@APIMapping(value = "GET_SHELTER",checkSessionToken = true,checkTrustedApp = true)
	ShelterModel getShelter(@PathVariable("shelterid") UUID shelterId) {
		return serviceFactory.getShelterService().getShelter(shelterId);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@APIMapping(value = "GET_SHELTERS",checkSessionToken = true,checkTrustedApp = true)
	Shelters getAreas(Pageable pageable) {
		return serviceFactory.getShelterService().getShelters(pageable);
	}
}
