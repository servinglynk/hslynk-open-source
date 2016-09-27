package com.servinglynk.hmis.household.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.repository.GlobalHouseholdRepository;
import com.servinglynk.hmis.household.repository.HouseholdMembershipRepository;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;
import com.servinglynk.hmis.household.web.rest.mapper.HouseholdMembershipMapper;

/**
 * Service Implementation for managing HouseholdMembership.
 */
@Service
@Transactional
public class HouseholdMembershipService {

    private final Logger log = LoggerFactory.getLogger(HouseholdMembershipService.class);
    
    @Inject
    private HouseholdMembershipRepository householdMembershipRepository;
    
    @Autowired
    private GlobalHouseholdRepository globalHouseholdRepository;
    
    @Autowired
    private HouseholdMembershipMapper householdMembershipMapper;
    
    @Autowired
    HibernateTemplate hibernateTemplate;
    
    /**
     * Save a householdMembership.
     * 
     * @param householdMembershipDTO the entity to save
     * @return the persisted entity
     */
    @Transactional
    public List<HouseholdMembershipDTO> save(UUID householdId,List<HouseholdMembershipDTO> householdMembershipDTOs) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTOs);
        List<HouseholdMembershipDTO> lhouseholdmembersDTOs=new ArrayList<HouseholdMembershipDTO>(); 
        for(HouseholdMembershipDTO dto: householdMembershipDTOs){
        	dto.setDateCreated(LocalDateTime.now());
        	dto.setDateUpdated(LocalDateTime.now());
        	dto.setGlobalHouseholdId(householdId);
        	dto.setInactive(false);
        	dto.setHouseholdMembershipId(UUID.randomUUID());
        	lhouseholdmembersDTOs.add(dto);
        }
        List<HouseholdMembership> householdMembers = householdMembershipMapper.householdMembershipDTOsToHouseholdMemberships(lhouseholdmembersDTOs);
        householdMembers = householdMembershipRepository.save(householdMembers);
    //    List<HouseholdMembershipDTO> result = householdMembershipMapper.householdMembershipsToHouseholdMembershipDTOs(householdMembers);
        return lhouseholdmembersDTOs;
    }
    
    @Transactional
    public HouseholdMembershipDTO update(UUID householdId, HouseholdMembershipDTO householdMembershipDTO) {
        log.debug("Request to save HouseholdMembership : {}", householdMembershipDTO);
        householdMembershipDTO.setDateUpdated(LocalDateTime.now());
        householdMembershipDTO.setGlobalHouseholdId(householdId);
        HouseholdMembership householdMember = householdMembershipMapper.householdMembershipDTOToHouseholdMembership(householdMembershipDTO);
        householdMember = householdMembershipRepository.save(householdMember);
      //  HouseholdMembershipDTO result = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMember);
        return householdMembershipDTO;
    }

    /**
     *  Get all the householdMemberships.
     *  
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public Page<HouseholdMembership> getAllHouseholdMembersByHouseholdId(UUID householdId, Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
    	GlobalHousehold globalHousehold =		globalHouseholdRepository.findOne(householdId);
    	Page<HouseholdMembership> members = householdMembershipRepository.findByGlobalHousehold(globalHousehold, pageable);
        return members;
    }
    
    @Transactional(readOnly = true) 
    public Page<HouseholdMembership> findAll(Pageable pageable) {
        log.debug("Request to get all HouseholdMemberships");
        Page<HouseholdMembership> result = householdMembershipRepository.findAll(pageable); 
        return result;
    }

    /**
     *  Get one householdMembership by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public HouseholdMembershipDTO findOne(UUID id) {
        log.debug("Request to get HouseholdMembership : {}", id);
        HouseholdMembership householdMembership = householdMembershipRepository.findOne(id);
        HouseholdMembershipDTO householdMembershipDTO = householdMembershipMapper.householdMembershipToHouseholdMembershipDTO(householdMembership);
        return householdMembershipDTO;
    }

    /**
     *  Delete the  householdMembership by id.
     *  
     *  @param id the id of the entity
     */
    public void delete(UUID id) {
        log.debug("Request to delete HouseholdMembership : {}", id);
        HouseholdMembership householdMembership=householdMembershipRepository.findOne(id);
        householdMembershipRepository.delete(householdMembership);
    }
}
