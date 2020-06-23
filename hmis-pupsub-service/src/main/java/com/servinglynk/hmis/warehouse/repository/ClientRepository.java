package com.servinglynk.hmis.warehouse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.servinglynk.hmis.warehouse.model.base.Client;

public interface ClientRepository{

	void save(Client client); // extends JpaRepository<Client, UUID>, PagingAndSortingRepository<Client, UUID>,
	//	JpaSpecificationExecutor<Client> {

}
