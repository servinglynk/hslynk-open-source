package com.servinglynk.hmis.household.web.rest.mapper;

import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.domain.HouseholdMembership;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;

/**
 * Mapper for the entity HouseholdMembership and its DTO HouseholdMembershipDTO.
 */
public interface HouseholdMembershipMapper {
	
    HouseholdMembershipDTO householdMembershipToHouseholdMembershipDTO(HouseholdMembership householdMembership);

    List<HouseholdMembershipDTO> householdMembershipsToHouseholdMembershipDTOs(List<HouseholdMembership> householdMemberships);

    HouseholdMembership householdMembershipDTOToHouseholdMembership(HouseholdMembershipDTO householdMembershipDTO);

    List<HouseholdMembership> householdMembershipDTOsToHouseholdMemberships(List<HouseholdMembershipDTO> householdMembershipDTOs);

    default GlobalHousehold globalHouseholdFromId(UUID globalHouseholdId) {
        if (globalHouseholdId == null) {
            return null;
        }
        GlobalHousehold globalHousehold = new GlobalHousehold();
        globalHousehold.setGlobalHouseholdId(globalHouseholdId);
        return globalHousehold;
    }
}
