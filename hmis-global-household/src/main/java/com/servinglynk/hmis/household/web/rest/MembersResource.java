package com.servinglynk.hmis.household.web.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.household.service.HouseholdMembershipService;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RequestMapping("/members")
@RestController
public class MembersResource extends BaseResource {

	@Autowired
	HouseholdMembershipService householdMembershipService;
	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_DELETE_MEMBER_BY_ID")
	public ResponseEntity<HouseholdMembershipDTO> getHouseholdMemberByClientId(@RequestParam(name="clientid",required=true) UUID clientId,
			HttpServletRequest request) throws Exception {
		return new ResponseEntity<HouseholdMembershipDTO>(householdMembershipService.getMemberShipByclientid(clientId),HttpStatus.OK);
	}
	
}
