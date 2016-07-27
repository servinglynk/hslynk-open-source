package com.servinglynk.hmis.household.service;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing GlobalHousehold.
 */
@Service
@Transactional
public class GlobalHouseholdService {

    private final Logger log = LoggerFactory.getLogger(GlobalHouseholdService.class);
    
    //@Inject
    @Autowired
    private GlobalHouseholdRepository globalHouseholdRepository;
    
    //@Inject
    @Autowired
    private GlobalHouseholdMapper globalHouseholdMapper;
    
    /**
     * Save a globalHousehold.
     * 
     * @param globalHouseholdDTO the entity to save
     * @return the persisted entity
     */
    
    @Transactional
    public List<GlobalHouseholdDTO> save(List<GlobalHouseholdDTO> globalHouseholdDTOs) {
        log.debug("Request to save GlobalHousehold : {}", globalHouseholdDTOs);
        List<GlobalHouseholdDTO> lgolobalHouseholdDTOs=new ArrayList<GlobalHouseholdDTO>();
        for(GlobalHouseholdDTO globalHouseholdDTO: globalHouseholdDTOs){
        	globalHouseholdDTO.setDateCreated(LocalDateTime.now());
        	globalHouseholdDTO.setDateUpdated(LocalDateTime.now());
        	globalHouseholdDTO.setInactive(false);
        	globalHouseholdDTO.setGlobalHouseholdId(UUID.randomUUID());
        	lgolobalHouseholdDTOs.add(globalHouseholdDTO);
        }
        List<GlobalHousehold> globalHouseholds = globalHouseholdMapper.globalHouseholdDTOsToGlobalHouseholds(lgolobalHouseholdDTOs);
        globalHouseholdRepository.save(globalHouseholds);
//        List<GlobalHouseholdDTO> result = globalHouseholdMapper.globalHouseholdsToGlobalHouseholdDTOs(globalHouseholds);
        return lgolobalHouseholdDTOs;
    }
    
    @Transactional
    public List<GlobalHouseholdDTO> update(List<GlobalHouseholdDTO> globalHouseholdDTOs) {
        log.debug("Request to save GlobalHousehold : {}", globalHouseholdDTOs);
        List<GlobalHouseholdDTO> lgolobalHouseholdDTOs=new ArrayList<GlobalHouseholdDTO>();
        for(GlobalHouseholdDTO globalHouseholdDTO: globalHouseholdDTOs){
        	globalHouseholdDTO.setDateUpdated(LocalDateTime.now());
        	lgolobalHouseholdDTOs.add(globalHouseholdDTO);
        }
        List<GlobalHousehold> globalHouseholds = globalHouseholdMapper.globalHouseholdDTOsToGlobalHouseholds(lgolobalHouseholdDTOs);
        globalHouseholdRepository.save(globalHouseholds);
    //    List<GlobalHouseholdDTO> result = globalHouseholdMapper.globalHouseholdsToGlobalHouseholdDTOs(globalHouseholds);
        return lgolobalHouseholdDTOs;
    }
    
    
    
    /*@Transactional
    public GlobalHouseholdDTO save(GlobalHouseholdDTO globalHouseholdDTO) {
        log.debug("Request to save GlobalHousehold : {}", globalHouseholdDTO);
        GlobalHousehold globalHousehold = globalHouseholdMapper.globalHouseholdDTOToGlobalHousehold(globalHouseholdDTO);
        globalHouseholdRepository.save(globalHousehold);
        GlobalHouseholdDTO result = globalHouseholdMapper.globalHouseholdToGlobalHouseholdDTO(globalHousehold);
        return result;
    }*/

    /**
     *  Get all the globalHouseholds.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<GlobalHouseholdDTO> findAll() {
        log.debug("Request to get all GlobalHouseholds");
        List<GlobalHouseholdDTO> result = globalHouseholdRepository.findAll().stream()
            .map(globalHouseholdMapper::globalHouseholdToGlobalHouseholdDTO)
            .collect(Collectors.toCollection(LinkedList::new));
        return result;
    }

    /**
     *  Get one globalHousehold by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public GlobalHouseholdDTO findOne(UUID id) {
        log.debug("Request to get GlobalHousehold : {}", id);
        GlobalHousehold globalHousehold = globalHouseholdRepository.findOne(id);
        GlobalHouseholdDTO globalHouseholdDTO = globalHouseholdMapper.globalHouseholdToGlobalHouseholdDTO(globalHousehold);
        return globalHouseholdDTO;
    }

    /**
     *  Delete the  globalHousehold by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(UUID id) {
        log.debug("Request to delete GlobalHousehold : {}", id);
        GlobalHousehold globalHouseHold=globalHouseholdRepository.findOne(id);
        globalHouseholdRepository.delete(globalHouseHold);
    }
}
