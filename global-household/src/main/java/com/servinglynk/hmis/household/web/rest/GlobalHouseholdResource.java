package com.servinglynk.hmis.household.web.rest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.service.GlobalHouseholdService;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdsDTO;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapper;
import com.servinglynk.hmis.household.web.rest.util.HeaderUtil;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

/**
 * REST controller for managing GlobalHousehold.
 */
@RestController
@RequestMapping("/generic-households")
public class GlobalHouseholdResource extends BaseResource  {

    private final Logger log = LoggerFactory.getLogger(GlobalHouseholdResource.class);
        
    //@Inject
    @Autowired
    private GlobalHouseholdService globalHouseholdService;
    
   // @Inject
    @Autowired
    private GlobalHouseholdMapper globalHouseholdMapper;
    
    
    
	@Autowired
	private PagedResourcesAssembler assembler;
	

	private ResourceAssembler<GlobalHousehold, Resource<GlobalHouseholdDTO>> globalHouseholdAssembler = new GlobalHouseholdResource.GlobalHouseholdAssembler();
	
	private class GlobalHouseholdAssembler implements ResourceAssembler<GlobalHousehold, Resource<GlobalHouseholdDTO>> {

		@Override
		public Resource<GlobalHouseholdDTO> toResource(GlobalHousehold arg0) {
			
			Resource<GlobalHouseholdDTO> resource=null;
				resource = new Resource<GlobalHouseholdDTO>(globalHouseholdMapper.globalHouseholdToGlobalHouseholdDTO(arg0));
				if(resource.getContent().getLink()!=null){
					resource.add(new Link("client", resource.getContent().getLink()));
				}
			return resource;
		}
	}
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_CREATE_UNITS")
        public ResponseEntity<List<GlobalHouseholdDTO>> createGlobalHouseholds(@Valid @RequestBody GlobalHouseholdsDTO globalHouseholdDTOs) throws Exception {
            log.debug("REST request to save GlobalHousehold : {}", globalHouseholdDTOs);
            List<GlobalHouseholdDTO> result = globalHouseholdService.save(globalHouseholdDTOs.getGlobalHouseholds());
            return new ResponseEntity<List<GlobalHouseholdDTO>>(result, HttpStatus.OK);
        }
    
    
    @RequestMapping(
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_UNITS")
    public ResponseEntity<List<GlobalHouseholdDTO>> updateGlobalHousehold(@Valid @RequestBody GlobalHouseholdsDTO globalHouseholdDTOs) throws Exception {
        log.debug("REST request to save GlobalHousehold : {}", globalHouseholdDTOs);
        /*if (globalHouseholdDTO.getGlobalHouseholdId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("globalHousehold", "idexists", "A new globalHousehold cannot already have an ID")).body(null);
        }*/
        List<GlobalHouseholdDTO> result = globalHouseholdService.update(globalHouseholdDTOs.getGlobalHouseholds());
        return new ResponseEntity<List<GlobalHouseholdDTO>>(result, HttpStatus.OK);
    }
    
    
    
    @RequestMapping(value="/{householdid}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_UNITS")
        public ResponseEntity<Void> updateGlobalHousehold(@PathVariable UUID householdid ,@Valid @RequestBody GlobalHouseholdDTO globalHouseholdDTO) throws Exception {
            log.debug("REST request to save GlobalHousehold : {}", globalHouseholdDTO);
            globalHouseholdDTO.setGlobalHouseholdId(householdid);
            List<GlobalHouseholdDTO> globalHouseholdDTOs = new ArrayList<>();
            globalHouseholdDTOs.add(globalHouseholdDTO);
            GlobalHouseholdDTO result = globalHouseholdService.update(globalHouseholdDTO);
            return ResponseEntity.ok().headers(HeaderUtil.createEntityUpdateAlert("globalHousehold",globalHouseholdDTO.getGlobalHouseholdId().toString())).build();
        }

    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_GET_UNITS")
    @Transactional(readOnly = true)
    public ResponseEntity<Resources<Resource>> getAllGlobalHouseholds(Pageable pageable) throws Exception{
        log.debug("REST request to get all GlobalHouseholds");
        return new ResponseEntity<>(assembler.toResource(globalHouseholdService.findAll(pageable),globalHouseholdAssembler),
				HttpStatus.OK);
    }

    
    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_GET_UNIT_BY_ID")
    public ResponseEntity<Resource> getGlobalHousehold(@PathVariable UUID id) throws Exception{
        log.debug("REST request to get GlobalHousehold : {}", id);
        GlobalHouseholdDTO globalHouseholdDTO = globalHouseholdService.findOne(id);
        Resource<GlobalHouseholdDTO> resource=null;
       if(globalHouseholdDTO.getLink()!=null)
    	    resource = new Resource<GlobalHouseholdDTO>(globalHouseholdDTO, new Link("client", globalHouseholdDTO.getLink()));
       else
    	   resource = new Resource<GlobalHouseholdDTO>(globalHouseholdDTO);
        return new ResponseEntity<Resource>(resource,HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
	@APIMapping(value="GLOBAL_HOUSE_HOLD_DELETE_UNIT_BY_ID")
    public ResponseEntity<Void> deleteGlobalHousehold(@PathVariable UUID id) throws Exception{
        log.debug("REST request to delete GlobalHousehold : {}", id);
        globalHouseholdService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("globalHousehold", id.toString())).build();
    }
}