package com.servinglynk.hmis.warehouse.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.model.base.Client;

@Component("clientElasticRepositoryImpl")
public class ClientCustomRepositoryImpl implements ClientCustomRepository {

//	@Autowired ElasticsearchTemplate elasticsearchTemplate;
	
@Autowired	ElasticsearchOperations elasticsearchOperations;
	
	public List<Client> findByNameAndProjectgroupcode(String freeText, String projectGroupCode, Sort sort){
		
		System.out.println(" inside custome implementation");
		Criteria fullnameCriteria = new Criteria("fullname").contains(freeText);
		Criteria nameCriteria = new Criteria("name").contains(freeText);
		Criteria ssnCriteria = new Criteria("ssn").contains(freeText);
		Criteria sourcesystemidCriteria = new Criteria("sourcesystemid").contains(freeText);
		Criteria pgcodeCriteria = new Criteria("projectgroupcode").is(projectGroupCode);		
		Criteria criteria = fullnameCriteria.or(nameCriteria).or(ssnCriteria).or(sourcesystemidCriteria);
		Criteria finalCriteria = criteria.and(pgcodeCriteria);
		
		return elasticsearchOperations.queryForList(new CriteriaQuery(finalCriteria), Client.class);
	}

	@Override
	public Page<Client> findByDedupclientidOrIdAndProjectgroupcode(String freeText, String freeText2, String projectGroupCode,
			Pageable page) {
		Criteria idCriteria = new Criteria("id").is(freeText);
		Criteria dedupIdCriteria = new Criteria("dedupclientid").is(freeText);
		Criteria pgcodeCriteria = new Criteria("projectgroupcode").is(projectGroupCode);		
		Criteria criteria = idCriteria.or(dedupIdCriteria);
		Criteria finalCriteria = criteria.and(pgcodeCriteria);
		
		return elasticsearchOperations.queryForPage(new CriteriaQuery(finalCriteria,page), Client.class);

	}

	@Override
	public List<Client> findByDobBetweenAndProjectgroupcode(long startTime, long endTime, String projectgroupcode, Sort sort) {
	Criteria startCriteria = new Criteria("dob").greaterThanEqual(startTime);
	Criteria enddCriteria = new Criteria("dob").lessThanEqual(endTime);
	Criteria pgcodeCriteria = new Criteria("projectgroupcode").is(projectgroupcode);		
	Criteria criteria = startCriteria.and(enddCriteria);
	Criteria finalCriteria = criteria.and(pgcodeCriteria);
	
	return elasticsearchOperations.queryForList(new CriteriaQuery(finalCriteria), Client.class);
	}
	
	
	
}
