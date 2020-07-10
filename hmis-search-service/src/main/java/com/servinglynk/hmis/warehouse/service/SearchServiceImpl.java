package com.servinglynk.hmis.warehouse.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;

import org.apache.catalina.security.SecurityUtil;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.common.JsonUtil;
import com.servinglynk.hmis.warehouse.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.ActionLinks;
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.listener.ClientCreationListener;
import com.servinglynk.hmis.warehouse.model.SearchRequest;
import com.servinglynk.hmis.warehouse.model.SearchResults;
import com.servinglynk.hmis.warehouse.model.SortedPagination;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaData;
import com.servinglynk.hmis.warehouse.repository.ClientElasticRepository;
import com.servinglynk.hmis.warehouse.repository.ClientMetaDataRepository;
import com.servinglynk.hmis.warehouse.util.SecurityContextUtil;

@Service
public class SearchServiceImpl extends BaseService implements SearchService {

	@Autowired Environment environment;
	
	@Autowired 
	ClientMetaDataRepository clientMetaDataRepository;
	@Autowired ClientElasticRepository clientRepository;
	
	public SearchResults searcClients(SearchRequest searchRequest) {
		SearchResults results = new SearchResults();
		 DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		   boolean dedupIdFilter = true;
		   boolean queryExecuted= false;
		   Integer total=0;
		   
		   List<Client> filterClients = new ArrayList<Client>();
		   List<Client> returnClients = new ArrayList<Client>();
		   // filter by dedupClientId , Id
		   try {
			   UUID.fromString(searchRequest.getFreeText());
			   Sort sort = Sort.by("dedupclientid").descending();
			   Pageable page = PageRequest.of(this.getPageNumber(searchRequest.getStartIndex(), searchRequest.getMaxItems()), searchRequest.getMaxItems(),sort);
				Page<Client>  clients = clientRepository.findByDedupclientidOrIdAndProjectgroupcode(searchRequest.getFreeText(),searchRequest.getFreeText(),SecurityContextUtil.getUserProjectGroup(),page);
				dedupIdFilter = false;
				queryExecuted = true;
				total = clients.getContent().size();
				returnClients = new ArrayList<Client>(clients.getContent());
		   }catch (Exception e) {
			   e.printStackTrace();
			   // filter by date of birth day
			   
			   try {
					 Date date = formatter.parse(searchRequest.getFreeText());
					  Calendar calStart = new GregorianCalendar();
					   calStart.setTime(date);
					   calStart.set(Calendar.HOUR_OF_DAY, 0);
					   calStart.set(Calendar.MINUTE, 0);
					   calStart.set(Calendar.SECOND, 0);
					   calStart.set(Calendar.MILLISECOND, 0);
					   Sort sort = Sort.by("dedupclientid").descending();
					   if(!queryExecuted) {
					 List<Client> clients = clientRepository.findByDobBetweenAndProjectgroupcode(calStart.getTime().getTime(),(calStart.getTime().getTime()+86399000),SecurityContextUtil.getUserProjectGroup(),sort);
					 dedupIdFilter = true;
						queryExecuted = true;
						
						filterClients = new ArrayList<Client>(clients);
					   }
				  }catch (Exception ex) {
					  ex.printStackTrace();
				}
		}
		   

	   
	   // filter by name , ssn , sourceSystemId
		   if(!queryExecuted) {
			   Sort sort = Sort.by("dedupclientid").descending();
				List<Client> clients = clientRepository.findByNameAndProjectgroupcode(searchRequest.getFreeText(),SecurityContextUtil.getUserProjectGroup(),sort);
				dedupIdFilter = true;
				queryExecuted = true;
				filterClients = new ArrayList<Client>(clients);
		   }
		   List<Client> clients = new ArrayList<Client>();
		   if(dedupIdFilter) {
			   Collections.sort(filterClients, Comparator.comparing(client ->
				  client.getDedupclientid()+""));
				  
				  Collections.sort(filterClients, Comparator.comparing(client ->
				  client.getDateupdated()));
			    List<Client> distinctClients = filterClients.stream()
	                     .filter( distinctByDedupId( client -> client.getDedupclientid()) )
	                     .collect( Collectors.toList() );
			    returnClients = this.sort(distinctClients);
			    clients = getPage(returnClients, searchRequest.getStartIndex(), searchRequest.getMaxItems());
			    total = distinctClients.size();
		   }else {
			   clients = this.sort(returnClients);
		   }
		   for(Client client : clients) {
			   BaseClient baseClient = ClientConverter.entityToModel(client);
			   baseClient.setLinks(this.addActionLinks(client));
			   results.addItem(baseClient);
		   }
		   SortedPagination pagination = new SortedPagination();
		    pagination.setFrom(searchRequest.getStartIndex());
		    pagination.setMaximum(searchRequest.getMaxItems());
		    pagination.setSort(searchRequest.getSort());
		    pagination.setTotal(total);
		    results.setPagination(pagination);
		   
		return results;
	}
	
	
	
	


	public int getPageNumber(Integer startIndex,Integer maxItems) {
		if(startIndex==0) return 0;
		return Math.round(maxItems / startIndex);
	}
	
	
	public List<Client> sort(List<Client> clients) {
		List<Client> data = new ArrayList<Client>(clients);
		 Collections.sort(data, Comparator.comparing(client ->
		  client.getDedupclientid()+""));
		  
		  Collections.sort(data, Comparator.comparing(client ->
		  client.getDateupdated()));
		
		 		
		Collections.sort(data,
				Comparator.comparing(client -> client.getId()+""));
		//Collections.reverse(data);
		return data;
	}
	
	public static <T> Predicate<T> distinctByDedupId(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
	
	public List<Client> getPage(List<Client> totalClients,Integer startIndex,Integer pagesize) {
			if(totalClients.size() < pagesize) return totalClients;
			if(totalClients.size() ==0) return new ArrayList<Client>();
			if((startIndex+pagesize)<= totalClients.size()) return totalClients.subList(startIndex,(startIndex+pagesize));
			return totalClients.subList(startIndex,totalClients.size()-1);
	}

	  public Map<String, ActionLinks> addActionLinks(Client client) {
		  Map<String,Map<String, ActionLink>> links = new HashMap<>();
		  Map<String, ActionLinks> typeLinks = new HashMap<>();
		  ActionLinks actionLinks = new ActionLinks();
		  ObjectMapper mapper = new ObjectMapper();
		  
		  	
		  List<ClientMetaData> entities = clientMetaDataRepository.findByClientdedupid(client.getDedupclientid());
		  for(ClientMetaData entity : entities) {
			  try {
				  	Map<String,String> addInfo = mapper.readValue(entity.getAdditionalinfo(), Map.class);
				  	ActionLinks actionlinks = typeLinks.get(entity.getType());
				  	if(actionlinks ==null ) actionlinks = new ActionLinks();
				  		
				  		if(environment.getProperty("linksTo."+entity.getType())!=null) {
				  				
				  				ActionLink link = new ActionLink();
				  				link.setHref(this.buildURL(environment.getProperty("linksTo."+entity.getType()),addInfo));
				  				link.setRel(entity.getMetadataidentifier().toString());
				  				actionlinks.addLink(link);
				  				typeLinks.put(entity.getType(), actionlinks);
				  		
				  			}
				  	
			  }catch (Exception e) {
				  e.printStackTrace();
			  }

		  }
		  
		  return typeLinks;
	  }

	  
		public  String buildURL(String urlString, Map<String,String> params) {
			MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
		    for (Entry<String, String> entry : params.entrySet()) {
		    	try {
		    	queryParams.add(entry.getKey(), entry.getValue());
		    	}catch (Exception e) {
				}
		    }
			UriComponents uriComponents = null;
			uriComponents = UriComponentsBuilder.newInstance().fromHttpUrl(urlString)
					.buildAndExpand(params);
			
			return uriComponents.toUriString();
		}
	
	@Autowired EntityManager entityManager;
	@Autowired ClientCreationListener listener;
	public void cacheClients() throws Exception  {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(Client.class);
		criteria.add(Restrictions.eq("deleted", false));
		criteria.add(Restrictions.isNull("parentId"));
	//	criteria.add(Restrictions.eq("projectGroupCode", "HO0002"));
		List<Client> clients =	criteria.getExecutableCriteria(session).list();
		for(Client client : clients) {
			listener.cacheClient(JsonUtil.coneveterObejctToString(client));
		}
		
	}
	/*
	public void cacheClientMetadatas() throws Exception  {
		Session session = entityManager.unwrap(Session.class);
		DetachedCriteria criteria = DetachedCriteria.forClass(ClientMetaDataEntity.class);
		criteria.add(Restrictions.eq("deleted", false));
	//	criteria.add(Restrictions.eq("projectGroupCode", "HO0002"));
		List<Client> clients =	criteria.getExecutableCriteria(session).list();
		for(Client client : clients) {
			listener.cacheClient(JsonUtil.coneveterObejctToString(client));
		}
	
	} */
}
