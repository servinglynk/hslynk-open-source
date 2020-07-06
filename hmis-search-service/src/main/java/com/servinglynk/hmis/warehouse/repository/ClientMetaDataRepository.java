package com.servinglynk.hmis.warehouse.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;

public interface ClientMetaDataRepository  extends ElasticsearchRepository<ClientMetaData, String> {
	
	List<ClientMetaData> findByClientdedupid(String clientDedupId);
	List<ClientMetaData> findByClientdedupidAndProjectgroupcode(String clientDedupId,String projectgroupcode);
}
