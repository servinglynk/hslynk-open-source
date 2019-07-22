package com.servinglynk.hmis.warehouse.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.servinglynk.hmis.warehouse.entity.ClientMetaDataEntity;

@Repository
public interface ClientMetaDataRepository extends JpaRepository<ClientMetaDataEntity, UUID>, PagingAndSortingRepository<ClientMetaDataEntity, UUID>
					, JpaSpecificationExecutor<ClientMetaDataEntity>{ 
	
		ClientMetaDataEntity	findFirstByMetaDataIdentifier(UUID metaDataIdentifier);

}
