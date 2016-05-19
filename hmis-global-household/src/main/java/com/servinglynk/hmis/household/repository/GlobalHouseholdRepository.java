package com.servinglynk.hmis.household.repository;
import com.servinglynk.hmis.household.domain.GlobalHousehold;
import org.springframework.data.jpa.repository.*;
import java.io.Serializable;


/**
 * Spring Data JPA repository for the GlobalHousehold entity.
 */
public interface GlobalHouseholdRepository extends JpaRepository<GlobalHousehold,Serializable> {

}
