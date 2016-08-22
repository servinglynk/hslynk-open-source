package com.servinglynk.hmis.household.web.rest.mapper;


import java.util.List;

import com.servinglynk.hmis.household.domain.GlobalHousehold;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;

/**
 * Mapper for the entity GlobalHousehold and its DTO GlobalHouseholdDTO.
 */
public interface GlobalHouseholdMapper {

    GlobalHouseholdDTO globalHouseholdToGlobalHouseholdDTO(GlobalHousehold globalHousehold);

    List<GlobalHouseholdDTO> globalHouseholdsToGlobalHouseholdDTOs(List<GlobalHousehold> globalHouseholds);

    GlobalHousehold globalHouseholdDTOToGlobalHousehold(GlobalHouseholdDTO globalHouseholdDTO);

    List<GlobalHousehold> globalHouseholdDTOsToGlobalHouseholds(List<GlobalHouseholdDTO> globalHouseholdDTOs);
}
