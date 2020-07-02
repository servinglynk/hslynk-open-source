package com.servinglynk.hmis.warehouse.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;

public interface ClientMetaDataElasticRepository extends ElasticsearchRepository<ClientMetaData, String> {

}
