package com.servinglynk.hmis.household.web.rest;

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

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.service.GlobalHouseHoldServiveV3;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdModel;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapperV3;
import com.servinglynk.hmis.household.web.rest.util.HeaderUtil;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
@RequestMapping("/v3/generic-households")
public class GlobalHouseholdsV3Resource extends BaseResource {
	
    private final Logger log = LoggerFactory.getLogger(GlobalHouseholdsV3Resource.class);
    
    @Autowired
    private GlobalHouseHoldServiveV3 globalHouseholdService;
    
    @Autowired
    private GlobalHouseholdMapperV3 globalHouseholdMapper;
    
    
	@Autowired
	private PagedResourcesAssembler assembler;

	
	
	private ResourceAssembler<GlobalHousehold, Resource<GlobalHouseholdModel>> globalHouseholdAssembler = new GlobalHouseholdsV3Resource.GlobalHouseholdAssembler();
	
	private class GlobalHouseholdAssembler implements ResourceAssembler<GlobalHousehold, Resource<GlobalHouseholdModel>> {

		@Override
		public Resource<GlobalHouseholdModel> toResource(GlobalHousehold arg0) {
			
			Resource<GlobalHouseholdModel> resource=null;
				resource = new Resource<GlobalHouseholdModel>(globalHouseholdMapper.entityToModel(arg0));
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
        public ResponseEntity<GlobalHouseholdModel> createGlobalHouseholds(@Valid @RequestBody GlobalHouseholdModel globalHousehold) throws Exception {
            log.debug("REST request to save GlobalHousehold : {}", globalHousehold);
            GlobalHouseholdModel result = globalHouseholdService.save(globalHousehold);
            return new ResponseEntity<GlobalHouseholdModel>(result, HttpStatus.OK);
        }
    
    
    
    @RequestMapping(value="/{id}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    	@APIMapping(value="GLOBAL_HOUSE_HOLD_UPDATE_UNITS")
        public ResponseEntity<GlobalHouseholdModel> updateGlobalHousehold(@PathVariable("id") UUID  id,@Valid @RequestBody GlobalHouseholdModel globalHousehold) throws Exception {
            log.debug("REST request to save GlobalHousehold : {}", globalHousehold);
            globalHousehold.setGlobalHouseholdId(id);
           GlobalHouseholdModel result = globalHouseholdService.update(globalHousehold);
            return new ResponseEntity<GlobalHouseholdModel>(result, HttpStatus.OK);
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
            GlobalHouseholdModel globalHouseholdModel = globalHouseholdService.findOne(id);
            Resource<GlobalHouseholdModel> resource=null;
           if(globalHouseholdModel.getLink()!=null)
        	    resource = new Resource<GlobalHouseholdModel>(globalHouseholdModel, new Link("client", globalHouseholdModel.getLink()));
           else
        	   resource = new Resource<GlobalHouseholdModel>(globalHouseholdModel);
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