package com.servinglynk.hmis.household.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.repository.HouseholdMembershipRepository;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;
import com.servinglynk.hmis.household.web.rest.mapper.GlobalHouseholdMapper;
import com.servinglynk.hmis.household.web.rest.util.SecurityContextUtil;

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
    
    @Autowired
    private HouseholdMembershipRepository householdMembershipRepository;
    
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
        	lgolobalHouseholdDTOs.add(globalHouseholdDTO);
        }
        List<GlobalHousehold> globalHouseholds = globalHouseholdMapper.globalHouseholdDTOsToGlobalHouseholds(lgolobalHouseholdDTOs);
        globalHouseholdRepository.save(globalHouseholds);
       List<GlobalHouseholdDTO> result = globalHouseholdMapper.globalHouseholdsToGlobalHouseholdDTOs(globalHouseholds);
        return result;
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
    
    
    @Transactional
    public GlobalHouseholdDTO update(GlobalHouseholdDTO globalHouseholdDTO) {
        log.debug("Request to save GlobalHousehold : {}", globalHouseholdDTO);
        GlobalHousehold globalHousehold = globalHouseholdRepository.findOne(globalHouseholdDTO.getGlobalHouseholdId());
        if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+globalHouseholdDTO.getGlobalHouseholdId());
        
        globalHousehold = globalHouseholdMapper.globalHouseholdDTOToGlobalHousehold(globalHouseholdDTO);
        globalHouseholdRepository.save(globalHousehold);
    //    List<GlobalHouseholdDTO> result = globalHouseholdMapper.globalHouseholdsToGlobalHouseholdDTOs(globalHouseholds);
        return globalHouseholdDTO;
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
    public Page<GlobalHousehold> findAll(Pageable pageable) {
        log.debug("Request to get all GlobalHouseholds");
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
        Page<GlobalHousehold> result = globalHouseholdRepository.findByProjectGroupCodeAndDeleted(projectGroup,pageable,false);
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
        String projectGroup = SecurityContextUtil.getUserProjectGroup();
        GlobalHousehold globalHousehold = globalHouseholdRepository.findByGlobalHouseholdIdAndProjectGroupCodeAndDeleted(id,projectGroup,false);
        if(globalHousehold==null) throw new ResourceNotFoundException("Global household not found "+id);
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
        if(globalHouseHold==null) throw new ResourceNotFoundException("Global household not found "+id);
        List<HouseholdMembership> members = householdMembershipRepository.findByGlobalHouseholdAndDeleted(globalHouseHold, false);
        globalHouseholdRepository.delete(globalHouseHold);
        householdMembershipRepository.delete(members);
    }
}
