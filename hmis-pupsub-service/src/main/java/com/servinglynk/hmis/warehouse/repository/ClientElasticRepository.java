package com.servinglynk.hmis.warehouse.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.servinglynk.hmis.warehouse.model.base.Client;

//@Repository
public interface ClientElasticRepository  extends ElasticsearchRepository<Client, String>{ 
//	List<Client> findByFirstName(String name);
	
	@Query(value = "{\"match\": {\"dedupclientid\": {\"query\": \"?0\"}}}")
	List<Client> findByDedupClientId(String dedupClientId);
	
	List<Client> findByDedupclientid(String dedupClientId);

	List<Client> findDistinctDedupclientidByDedupclientid(String freeText);

	Page<Client> findByDedupclientidOrId(String freeText, String string, Pageable page);

	List<Client> findByFullnameOrNameOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string);

	List<Client> findByFullnameLikeOrNameLikeOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string);

	List<Client> findByFullnameContainsOrNameContainsOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string, Sort sort);

	List<Client> findByDobBetween(Long date, Long date2, Sort sort);
}
