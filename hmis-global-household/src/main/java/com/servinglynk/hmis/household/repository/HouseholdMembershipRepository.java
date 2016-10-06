package com.servinglynk.hmis.household.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;

/**
 * Spring Data JPA repository for the HouseholdMembership entity.
 */
public interface HouseholdMembershipRepository extends JpaRepository<HouseholdMembership,Serializable> {
	
   Page<HouseholdMembership> findByGlobalHousehold(GlobalHousehold globalHousehold,Pageable pageable);
   Page<HouseholdMembership> findByGlobalClientId(UUID globalClientId,Pageable pageable);

}