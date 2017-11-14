package com.servinglynk.hmis.household.repository;
import com.servinglynk.hmis.household.domain.GlobalHousehold;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import java.io.Serializable;
import java.util.UUID;


/**
 * Spring Data JPA repository for the GlobalHousehold entity.
 */
public interface GlobalHouseholdRepository extends JpaRepository<GlobalHousehold,Serializable> {

	Page<GlobalHousehold> findByProjectGroupCode(String projectGroup, Pageable pageable);

	GlobalHousehold findByGlobalHouseholdIdAndProjectGroupCode(UUID id, String projectGroup);

	Page<GlobalHousehold> findByProjectGroupCodeAndDeletedOrderBySchemaYearDesc(String projectGroup, Pageable pageable, boolean deleted);

	GlobalHousehold findByGlobalHouseholdIdAndProjectGroupCodeAndDeleted(UUID id, String projectGroup, boolean deleted);

	GlobalHousehold findByDedupClientIdAndProjectGroupCodeAndDeleted(UUID id, String projectGroup, boolean deleted);

	GlobalHousehold findFirstByDedupClientIdAndProjectGroupCodeAndDeletedOrderBySchemaYearDesc(UUID id, String projectGroup,
			boolean deleted);

}
