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
public interface ClientElasticRepository  extends ElasticsearchRepository<Client, String> , ClientCustomRepository { 
//	List<Client> findByFirstName(String name);
	
	List<Client> findByNameAndProjectgroupcode(String dedupClientId,String projecrGroupCode,Sort sort);
	
	List<Client> findByDedupclientid(String dedupClientId);

	List<Client> findDistinctDedupclientidByDedupclientid(String freeText);

	Page<Client> findByDedupclientidOrId(String freeText, String string, Pageable page);
	List<Client> findByDedupclientidAndProjectgroupcode(String freeText, String string);
	List<Client> findByIdAndProjectgroupcode(String freeText, String string);

	Page<Client> findByDedupclientidAndProjectgroupcode(String freeText, String string, Pageable page);
	Page<Client> findByIdAndProjectgroupcode(String freeText, String string, Pageable page);

	
	List<Client> findByFullnameOrNameOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string);

	List<Client> findByFullnameLikeOrNameLikeOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string);

	List<Client> findByFullnameContainsOrNameContainsOrSsnOrSourcesystemidAndProjectgroupcode(String freeText, String freeText2,
			String freeText3, String freeText4, String string, Sort sort);

	List<Client> findByDobBetween(Long date, Long date2, Sort sort);

	Page<Client> findByDedupclientidOrIdAndProjectgroupcode(String freeText, String freeText2, String string,
			Pageable page);

	List<Client> findByDobBetweenAndProjectgroupcode(long time, long l, String string, Sort sort);
	

	List<Client> findByProjectgroupcodeAndFullnameContainsOrNameContainsOrSsnOrSourcesystemid(String freeText,
			String freeText2, String freeText3, String freeText4, String string, Sort sort);
}
