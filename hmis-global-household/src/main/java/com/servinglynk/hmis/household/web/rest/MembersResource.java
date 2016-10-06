package com.servinglynk.hmis.household.web.rest;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.service.HouseholdMembershipService;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapper;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RequestMapping("/members")
@RestController
public class MembersResource extends BaseResource {

	@Autowired
	HouseholdMembershipService householdMembershipService;
	
	@Autowired
	private PagedResourcesAssembler assembler;
	
    @Autowired
    private HouseholdMembershipMapper householdMembershipMapper;

	private ResourceAssembler<HouseholdMembership, Resource<HouseholdMembershipDTO>> householdMembershipAssembler = new MembersResource.HouseholdMembershipAssembler();
	
	private class HouseholdMembershipAssembler implements ResourceAssembler<HouseholdMembership, Resource<HouseholdMembershipDTO>> {

		@Override
		public Resource<HouseholdMembershipDTO> toResource(HouseholdMembership arg0) {
			
			Resource<HouseholdMembershipDTO> resource=null;
				resource = new Resource<HouseholdMembershipDTO>(householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(arg0));
				if(arg0.getClientLink()!=null)
					resource.add(new Link("client",arg0.getClientLink()));
				return resource;
		}
	}

	
	@RequestMapping(method=RequestMethod.GET)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_DELETE_MEMBER_BY_ID")
	public ResponseEntity<Resources<Resource>> getHouseholdMemberByClientId(@RequestParam(name="clientid",required=true) UUID clientId,Pageable pageable,
			HttpServletRequest request) throws Exception {
		//return new ResponseEntity<HouseholdMembershipDTO>(householdMembershipService.getMemberShipByclientid(clientId),HttpStatus.OK);
		
		 return new ResponseEntity<>(assembler.toResource(householdMembershipService.getMemberShipByclientid(clientId,pageable),householdMembershipAssembler),
					HttpStatus.OK);
	}
	
}
