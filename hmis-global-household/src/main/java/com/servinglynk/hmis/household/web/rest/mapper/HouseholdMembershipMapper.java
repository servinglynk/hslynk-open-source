package com.servinglynk.hmis.household.web.rest.mapper;

import com.servinglynk.hmis.household.domain.*;
import com.servinglynk.hmis.household.web.rest.dto.HouseholdMembershipDTO;

import org.mapstruct.*;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;
import java.util.UUID;

/**
 * Mapper for the entity HouseholdMembership and its DTO HouseholdMembershipDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface HouseholdMembershipMapper {

    @Mapping(source = "globalHousehold.globalHouseholdId", target = "globalHouseholdId")
    HouseholdMembershipDTO householdMembershipToHouseholdMembershipDTO(HouseholdMembership householdMembership);

    List<HouseholdMembershipDTO> householdMembershipsToHouseholdMembershipDTOs(List<HouseholdMembership> householdMemberships);

    @Mapping(source = "globalHouseholdId", target = "globalHousehold")
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
