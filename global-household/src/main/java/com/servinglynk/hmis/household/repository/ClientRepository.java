package com.servinglynk.hmis.household.repository;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.household.domain.Client;

public interface ClientRepository extends JpaRepository<Client,Serializable> {
	
	List<Client> findByDedupClientIdOrderBySchemaYearDesc(UUID dedupClientId);
	List<Client> findByDedupClientIdAndProjectGroupCodeOrderBySchemaYearDesc(UUID dedupClientId,String projectGroupCode);

}
