package com.servinglynk.hmis.household.web.rest.mapper;

import com.servinglynk.hmis.household.domain.*;
import com.servinglynk.hmis.household.web.rest.dto.GlobalHouseholdDTO;

import org.mapstruct.*;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Mapper for the entity GlobalHousehold and its DTO GlobalHouseholdDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GlobalHouseholdMapper {

    GlobalHouseholdDTO globalHouseholdToGlobalHouseholdDTO(GlobalHousehold globalHousehold);

    List<GlobalHouseholdDTO> globalHouseholdsToGlobalHouseholdDTOs(List<GlobalHousehold> globalHouseholds);

    @Mapping(target = "members", ignore = true)
    GlobalHousehold globalHouseholdDTOToGlobalHousehold(GlobalHouseholdDTO globalHouseholdDTO);

    List<GlobalHousehold> globalHouseholdDTOsToGlobalHouseholds(List<GlobalHouseholdDTO> globalHouseholdDTOs);
}
