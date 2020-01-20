package com.servinglynk.hmis.household.web.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.service.HouseholdMembershipServiceV3;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipModel;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipModels;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapperImplV3;
import com.servinglynk.hmis.household.web.rest.util.HeaderUtil;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Session;

/**
 * REST controller for managing HouseholdMembership.
 */
@RestController
@RequestMapping({"/v3/generic-households","/v3/generichouseholds"})
public class HouseholdMembershipV3Resource  extends BaseResource {

    private final Logger log = LoggerFactory.getLogger(HouseholdMembershipV3Resource.class);
        
   // @Inject
    @Autowired
    private HouseholdMembershipServiceV3 householdMembershipService;
    
   // @Inject
    @Autowired
    private HouseholdMembershipMapperImplV3 householdMembershipMapper;
    
    
	@Autowired
	private PagedResourcesAssembler assembler;
	

	private ResourceAssembler<HouseholdMembership, Resource<HouseholdMembershipModel>> householdMembershipAssembler = new HouseholdMembershipV3Resource.HouseholdMembershipAssembler();
	
	private class HouseholdMembershipAssembler implements ResourceAssembler<HouseholdMembership, Resource<HouseholdMembershipModel>> {

		@Override
		public Resource<HouseholdMembershipModel> toResource(HouseholdMembership arg0) {
			
			Resource<HouseholdMembershipModel> resource=null;
				resource = new Resource<HouseholdMembershipModel>(householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(arg0));
				if(resource.getContent().getLink()!=null)
					resource.add(new Link("client",resource.getContent().getLink()));
				return resource;
		}
	}

    
    @RequestMapping(value = "{householdId}/members",
            method = RequestMethod.POST
         //   produces = MediaType.APPLICATION_JSON_VALUE,
         //   consumes= MediaType.APPLICATION_JSON_VALUE
            )
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_CREATE_MEMBERS")
        public ResponseEntity<List<HouseholdMembershipModel>> createHouseholdMembership(
        		@PathVariable UUID householdId, @Valid @RequestBody HouseholdMembershipModels householdMembershipDTOs,HttpServletRequest request) throws Exception {
    			Session session = sessionHelper.getSession(request);

            log.debug("REST request to save HouseholdMembership : {}", householdMembershipDTOs);
            List<HouseholdMembershipModel> result = householdMembershipService.save(householdId,householdMembershipDTOs.getMembers(),session);
            return new ResponseEntity<List<HouseholdMembershipModel>>(result,HttpStatus.OK);
        }


    @RequestMapping(value = "/{householdId}/members",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_GET_MEMBERS")
    @Transactional(readOnly = true)
    public ResponseEntity<Resources<Resource>> getAllHouseholdMemberships(@PathVariable UUID householdId, Pageable pageable)
    		throws Exception {
        log.debug("REST request to get a page of HouseholdMemberships");
        return new ResponseEntity<>(assembler.toResource(householdMembershipService.getAllHouseholdMembersByHouseholdId(householdId,pageable),householdMembershipAssembler),
				HttpStatus.OK);
    }


    @RequestMapping(value = "/{householdId}/members/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_GET_MEMBERS_ID")
    public ResponseEntity<Resource> getHouseholdMembership(@PathVariable UUID householdId, @PathVariable UUID id) throws Exception {
        log.debug("REST request to get HouseholdMembership : {}", id);
        HouseholdMembershipModel householdMembershipDTO = householdMembershipService.findOne(id);
        Resource<HouseholdMembershipModel> resource=null;
        if(householdMembershipDTO.getLink()!=null)
        	resource = new Resource<HouseholdMembershipModel>(householdMembershipDTO, new Link("client",householdMembershipDTO.getLink()));
        else
        	resource = new Resource<HouseholdMembershipModel>(householdMembershipDTO);
                
        return new ResponseEntity<Resource>(resource,HttpStatus.OK);
    }
   
    // for updte
    @RequestMapping(value = "{householdId}/members/{memberId}",
            method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_MEMBER_BY_ID")
        public ResponseEntity<HouseholdMembershipModel> updateHouseholdMembership(
        		@PathVariable UUID householdId,@Valid @RequestBody HouseholdMembershipModel householdMembershipDTO, @PathVariable UUID memberId,HttpServletRequest request) throws Exception {
            log.debug("REST request to update HouseholdMembership : {}", householdMembershipDTO);
            Session session = sessionHelper.getSession(request);
            householdMembershipDTO.setHouseholdMembershipId(memberId);
            HouseholdMembershipModel result = householdMembershipService.update(householdId, householdMembershipDTO,session);
            return new ResponseEntity<HouseholdMembershipModel>(result,HttpStatus.OK);
        }
        

    /**
     * DELETE  /household-memberships/:id : delete the "id" householdMembership.
     *
     * @param id the id of the householdMembershipDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/{householdId}/members/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_DELETE_MEMBER_BY_ID")
    public ResponseEntity<Void> deleteHouseholdMembership(@PathVariable UUID householdId, @PathVariable UUID id) throws Exception {
        log.debug("REST request to delete HouseholdMembership : {}", id);
        householdMembershipService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("householdMembership", id.toString())).build();
    }

}
