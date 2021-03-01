package com.servinglynk.hmis.warehouse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.servinglynk.hmis.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, UUID> {
	
	ClientEntity findByIdAndDeleted(UUID id,Boolean deleted);

}
