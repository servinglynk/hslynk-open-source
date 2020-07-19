package com.servinglynk.hmis.warehouse.repository;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
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
		
		List<Client> clients = elasticsearchOperations.queryForList(new CriteriaQuery(finalCriteria), Client.class);
		Criteria SourceCriteria = sourcesystemidCriteria.and(pgcodeCriteria);
		List<Client> sourceClients = elasticsearchOperations.queryForList(new CriteriaQuery(SourceCriteria), Client.class);
		//clients.addAll(sourceClients);
		List<Client> returnClients = new ArrayList<Client>();
		returnClients.addAll(clients);
		returnClients.addAll(sourceClients);
		return returnClients;
	}

		/*public List<Client> findByNameAndProjectgroupcode(String freeText, String projectGroupCode, Sort sort) {
			Pageable page = PageRequest.of(0, 9999, sort);
			BoolQueryBuilder nameQuery = QueryBuilders.boolQuery();
			nameQuery.should(QueryBuilders.matchQuery("fullname", freeText).operator(Operator.OR))
			//.should(QueryBuilders.matchQuery("sourcesystemid", freeText).operator(Operator.OR))
			.should(QueryBuilders.matchQuery("name", freeText).operator(Operator.OR))
			.should(QueryBuilders.matchQuery("ssn", freeText));
		
			BoolQueryBuilder pgQuery = QueryBuilders.boolQuery();
			pgQuery.should(QueryBuilders.matchQuery("projectgroupcode", projectGroupCode));
			BoolQueryBuilder finalBoolQuery = new BoolQueryBuilder();
			finalBoolQuery.must(nameQuery);
			finalBoolQuery.must(pgQuery);
			SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(page).withQuery(finalBoolQuery).build();
			return elasticsearchOperations.queryForList(searchQuery, Client.class);
		
		}*/

	@Override
	public Page<Client> findByDedupclientidOrIdAndProjectgroupcode(String freeText, String freeText2, String projectGroupCode,
			Pageable page) {
		System.out.println(" inside custome implementation");
		Criteria fullnameCriteria = new Criteria("id").contains(freeText);
		Criteria nameCriteria = new Criteria("dedupclientid").contains(freeText);
		Criteria pgcodeCriteria = new Criteria("projectgroupcode").is(projectGroupCode);	
	
		//Criteria criteria = fullnameCriteria.or(nameCriteria);
		Criteria finalCriteria = fullnameCriteria.and(pgcodeCriteria);
		
		Page<Client> clients = elasticsearchOperations.queryForPage(new CriteriaQuery(finalCriteria,page), Client.class);
		if(clients.getContent().isEmpty()) {
			Criteria finalCriteria1 = nameCriteria.and(pgcodeCriteria);
			return elasticsearchOperations.queryForPage(new CriteriaQuery(finalCriteria1,page), Client.class);
		}
		return clients;
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
