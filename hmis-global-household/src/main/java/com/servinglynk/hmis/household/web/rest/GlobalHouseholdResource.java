package com.servinglynk.hmis.household.web.rest;
import com.servinglynk.hmis.household.service.GlobalHouseholdService;
import com.servinglynk.hmis.household.web.rest.util.HeaderUtil;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * REST controller for managing GlobalHousehold.
 */
@RestController
@RequestMapping("/global-households")
public class GlobalHouseholdResource {

    private final Logger log = LoggerFactory.getLogger(GlobalHouseholdResource.class);
        
    //@Inject
    @Autowired
    private GlobalHouseholdService globalHouseholdService;
    
   // @Inject
    @Autowired
    private GlobalHouseholdMapper globalHouseholdMapper;
    
    /**
     * POST  /global-households : Create a new globalHousehold.
     *
     * @param globalHouseholdDTO the globalHouseholdDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new globalHouseholdDTO, or with status 400 (Bad Request) if the globalHousehold has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
       // @Timed
        public ResponseEntity<List<GlobalHouseholdDTO>> createGlobalHouseholds(@RequestBody List<GlobalHouseholdDTO> globalHouseholdDTOs) throws URISyntaxException {
            log.debug("REST request to save GlobalHousehold : {}", globalHouseholdDTOs);
           /* if (globalHouseholdDTO.getGlobalHouseholdId() != null) {
                return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("globalHousehold", "idexists", "A new globalHousehold cannot already have an ID")).body(null);
            }*/
           
            List<GlobalHouseholdDTO> result = globalHouseholdService.save(globalHouseholdDTOs);
            return new ResponseEntity<List<GlobalHouseholdDTO>>(result, HttpStatus.OK);
        }
    
    
    @RequestMapping(
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
   // @Timed
    public ResponseEntity<List<GlobalHouseholdDTO>> createGlobalHousehold(@RequestBody List<GlobalHouseholdDTO> globalHouseholdDTOs) throws URISyntaxException {
        log.debug("REST request to save GlobalHousehold : {}", globalHouseholdDTOs);
        /*if (globalHouseholdDTO.getGlobalHouseholdId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("globalHousehold", "idexists", "A new globalHousehold cannot already have an ID")).body(null);
        }*/
        List<GlobalHouseholdDTO> result = globalHouseholdService.update(globalHouseholdDTOs);
        return new ResponseEntity<List<GlobalHouseholdDTO>>(result, HttpStatus.OK);
    }

    /**
     * PUT  /global-households : Updates an existing globalHousehold.
     *
     * @param globalHouseholdDTO the globalHouseholdDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated globalHouseholdDTO,
     * or with status 400 (Bad Request) if the globalHouseholdDTO is not valid,
     * or with status 500 (Internal Server Error) if the globalHouseholdDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    /*@RequestMapping(value = "/global-households",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    //@Timed
    public ResponseEntity<GlobalHouseholdDTO> updateGlobalHousehold(@RequestBody List<GlobalHouseholdDTO globalHouseholdDTO) throws URISyntaxException {
        log.debug("REST request to update GlobalHousehold : {}", globalHouseholdDTO);
        if (globalHouseholdDTO.getGlobalHouseholdId() == null) {
            return createGlobalHousehold(globalHouseholdDTO);
        }
        GlobalHouseholdDTO result = globalHouseholdService.save(globalHouseholdDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("globalHousehold", globalHouseholdDTO.getGlobalHouseholdId().toString()))
            .body(result);
    }*/

    /**
     * GET  /global-households : get all the globalHouseholds.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of globalHouseholds in body
     */
    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    //@Timed
    @Transactional(readOnly = true)
    public List<GlobalHouseholdDTO> getAllGlobalHouseholds() {
        log.debug("REST request to get all GlobalHouseholds");
        return globalHouseholdService.findAll();
    }

    /**
     * GET  /global-households/:id : get the "id" globalHousehold.
     *
     * @param id the id of the globalHouseholdDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the globalHouseholdDTO, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    //@Timed
    public ResponseEntity<GlobalHouseholdDTO> getGlobalHousehold(@PathVariable UUID id) {
        log.debug("REST request to get GlobalHousehold : {}", id);
        GlobalHouseholdDTO globalHouseholdDTO = globalHouseholdService.findOne(id);
        return Optional.ofNullable(globalHouseholdDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /global-households/:id : delete the "id" globalHousehold.
     *
     * @param id the id of the globalHouseholdDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    //@Timed
    public ResponseEntity<Void> deleteGlobalHousehold(@PathVariable UUID id) {
        log.debug("REST request to delete GlobalHousehold : {}", id);
        globalHouseholdService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("globalHousehold", id.toString())).build();
    }

}
