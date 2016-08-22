package com.servinglynk.hmis.household.repository;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.web.PagedResourcesAssembler;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Spring Data JPA repository for the HouseholdMembership entity.
 */
public interface HouseholdMembershipRepository extends JpaRepository<HouseholdMembership,Serializable> {
	
   Page<HouseholdMembership> fidByGlobalHousehold(GlobalHousehold globalHousehold,Pageable pageable);

}
