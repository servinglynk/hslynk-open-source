package com.servinglynk.hmis.household.web.rest;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import com.servinglynk.hmis.household.service.HouseholdMembershipService;
import com.servinglynk.hmis.household.web.rest.dto.HouseHodMembersDto;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapper;
import com.servinglynk.hmis.household.web.rest.util.HeaderUtil;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

/**
 * REST controller for managing HouseholdMembership.
 */
@RestController
@RequestMapping("/global-households")
public class HouseholdMembershipResource  extends BaseResource {

    private final Logger log = LoggerFactory.getLogger(HouseholdMembershipResource.class);
        
   // @Inject
    @Autowired
    private HouseholdMembershipService householdMembershipService;
    
   // @Inject
    @Autowired
    private HouseholdMembershipMapper householdMembershipMapper;
    
    
	@Autowired
	private PagedResourcesAssembler assembler;
	

	private ResourceAssembler<HouseholdMembership, Resource<HouseholdMembershipDTO>> householdMembershipAssembler = new HouseholdMembershipResource.HouseholdMembershipAssembler();
	
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

    
    
    
    /**
     * POST  /household-memberships : Create a new householdMembership.
     *
     * @param householdMembershipDTO the householdMembershipDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new householdMembershipDTO, or with status 400 (Bad Request) if the householdMembership has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
   /* @RequestMapping(value = "/household-memberships",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    //@Timed
    public ResponseEntity<HouseholdMembershipDTO> createHouseholdMembership(@RequestBody HouseholdMembershipDTO householdMembershipDTO) throws URISyntaxException {
        log.debug("REST request to save HouseholdMembership : {}", householdMembershipDTO);
        if (householdMembershipDTO.getHouseholdMembershipId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("householdMembership", "idexists", "A new householdMembership cannot already have an ID")).body(null);
        }
        HouseholdMembershipDTO result = householdMembershipService.save(householdMembershipDTO);
        return ResponseEntity.created(new URI("/api/household-memberships/" + result.getHouseholdMembershipId()))
            .headers(HeaderUtil.createEntityCreationAlert("householdMembership", result.getHouseholdMembershipId().toString()))
            .body(result);
    }*/
    @RequestMapping(value = "{householdId}/members",
            method = RequestMethod.POST
         //   produces = MediaType.APPLICATION_JSON_VALUE,
         //   consumes= MediaType.APPLICATION_JSON_VALUE
            )
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_CREATE_MEMBERS")
        public ResponseEntity<List<HouseholdMembershipDTO>> createHouseholdMembership(
        		@PathVariable UUID householdId, @Valid @RequestBody HouseHodMembersDto householdMembershipDTOs) throws Exception {
            log.debug("REST request to save HouseholdMembership : {}", householdMembershipDTOs);
            List<HouseholdMembershipDTO> result = householdMembershipService.save(householdId,householdMembershipDTOs.getMembers());
            return new ResponseEntity<List<HouseholdMembershipDTO>>(result,HttpStatus.OK);
        }

    /**
     * PUT  /household-memberships : Updates an existing householdMembership.
     *
     * @param householdMembershipDTO the householdMembershipDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated householdMembershipDTO,
     * or with status 400 (Bad Request) if the householdMembershipDTO is not valid,
     * or with status 500 (Internal Server Error) if the householdMembershipDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    
   /* @RequestMapping(value = "/household-memberships",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
   // @Timed
    public ResponseEntity<HouseholdMembershipDTO> updateHouseholdMembership(@RequestBody HouseholdMembershipDTO householdMembershipDTO) throws URISyntaxException {
        log.debug("REST request to update HouseholdMembership : {}", householdMembershipDTO);
        if (householdMembershipDTO.getHouseholdMembershipId() == null) {
            return createHouseholdMembership(householdMembershipDTO);
        }
        HouseholdMembershipDTO result = householdMembershipService.save(householdMembershipDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("householdMembership", householdMembershipDTO.getHouseholdMembershipId().toString()))
            .body(result);
    }*/

    /**
     * GET  /household-memberships : get all the householdMemberships.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of householdMemberships in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
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

    /**
     * GET  /household-memberships/:id : get the "id" householdMembership.
     *
     * @param id the id of the householdMembershipDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the householdMembershipDTO, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/{householdId}/members/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_GET_MEMBERS_ID")
    public ResponseEntity<Resource> getHouseholdMembership(@PathVariable UUID householdId, @PathVariable UUID id) throws Exception {
        log.debug("REST request to get HouseholdMembership : {}", id);
        HouseholdMembershipDTO householdMembershipDTO = householdMembershipService.findOne(id);
        
        Resource<HouseholdMembershipDTO> resource=null;
        if(householdMembershipDTO.getLink()!=null)
        	resource = new Resource<HouseholdMembershipDTO>(householdMembershipDTO, new Link("client",householdMembershipDTO.getLink()));
        else
        	resource = new Resource<HouseholdMembershipDTO>(householdMembershipDTO);
        
        householdMembershipDTO.setLink(null);
        
        return new ResponseEntity<Resource>(resource,HttpStatus.OK);
    }
   
    // for updte
    @RequestMapping(value = "{householdId}/members/{memberId}",
            method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_MEMBER_BY_ID")
        public ResponseEntity<HouseholdMembershipDTO> updateHouseholdMembership(
        		@PathVariable UUID householdId,@Valid @RequestBody HouseholdMembershipDTO householdMembershipDTO, @PathVariable UUID memberId) throws Exception {
            log.debug("REST request to update HouseholdMembership : {}", householdMembershipDTO);
            householdMembershipDTO.setHouseholdMembershipId(memberId);
            HouseholdMembershipDTO result = householdMembershipService.update(householdId, householdMembershipDTO);
            return new ResponseEntity<HouseholdMembershipDTO>(result,HttpStatus.OK);
        }
    
    
    // for updte
    @RequestMapping(value = "{householdId}/members",
            method = RequestMethod.PUT,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_MEMBERS")
        public ResponseEntity<HouseholdMembershipDTO> updateHouseholdMemberships(
        		@PathVariable UUID householdId,@Valid @RequestBody HouseHodMembersDto householdMembershipDTOs) throws Exception {
            log.debug("REST request to update HouseholdMembership : {}", householdMembershipDTOs);
            for(HouseholdMembershipDTO householdMembershipDTO : householdMembershipDTOs.getMembers()) {
            	HouseholdMembershipDTO result = householdMembershipService.update(householdId, householdMembershipDTO);
            }
            return new ResponseEntity<HouseholdMembershipDTO>(HttpStatus.OK);
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
