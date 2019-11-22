package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;


import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.tags.EvalTag;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.Sort;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.ActionLinks;
import com.servinglynk.hmis.warehouse.core.model.BaseClient;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.core.model.ClientModel;
import com.servinglynk.hmis.warehouse.core.model.SearchResults;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.SearchClient;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.ClientMetaDataEntity;


public class BaseSearchServiceImpl extends ServiceBase implements SearchService {

	  @Transactional
	  public void indexing()
	  {
		  
		  String indexClassList = "com.servinglynk.hmis.warehouse.model.base.Client";
	    this.daoFactory.getSearchDao().indexing(indexClassList);
	  }
	  
	  @Transactional
	  public SearchResults performSearch(SearchRequest searchVo,String freeText, String sort, String order, Integer startIndex,
			  Integer maxItems,String exclude,Session session)
	  {
	    // searchVo = new SearchRequest();
	    boolean dedupIdFilter = false;
	    try{
	    	UUID.fromString(freeText);
	    	dedupIdFilter = false;
	    }catch (IllegalArgumentException e) {
	    		dedupIdFilter = true;
		}
	    Account account = serviceFactory.getAccountService().getAccount(session.getAccount(),false);
	    
	    	searchVo.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
	    	searchVo.setUserId(account.getAccountId());
	    Sort sorting = new Sort();
	    sorting.setOrder(order);
	    sorting.setField(sort);
	    searchVo.setSort(sorting);
	    if(exclude!=null)
	    	searchVo.setExcludeFields(exclude.toLowerCase().split(","));
	    
	    searchVo.setDbfileds(new String[] { "firstName","lastName","middleName","sourceSystemId","ssn"});
	    searchVo.setFreeText(freeText);
	    searchVo.setSearchEntity(Client.class);
	    
	    SortedPagination pagination = new SortedPagination();
	    pagination.setFrom(startIndex);
	    pagination.setMaximum(maxItems);
	    pagination.setSort(sorting);
	    searchVo.setPagination(pagination);

	    BaseClients clients = new BaseClients();
	    if(searchVo.getIsProcSearch())
	    	clients = searchClients(searchVo);
	    else
	    	clients = searchClients(searchVo, dedupIdFilter);
	    
	    pagination.setFrom(startIndex);
	    pagination.setReturned(Integer.valueOf(clients.getClients().size()));
//	    pagination.setTotal(Integer.valueOf(searchVo.getPagination().getTotal().intValue()-skipCount));
	    
	    SearchResults result = new SearchResults();
	    result.setPagination(pagination);
	    result.addItems(clients.getClients());
	    
	    return result;
	  }
	  
	  public BaseClients searchClients(SearchRequest searchVo,boolean dedupIdFilter) {
		    List<Client> searchItems = (List<Client>) this.daoFactory.getSearchDao().search(searchVo,false);
		    List<UUID> distinctDedupIds = new ArrayList<UUID>();
		    BaseClients clients = new BaseClients();
		    int skipCount=0;
		    for (Client pClient : searchItems) {
		    	
		    	if(dedupIdFilter) {
				    	if(pClient!=null && pClient.getDedupClientId()!=null && !distinctDedupIds.contains(pClient.getDedupClientId())) {
				    		clients.addClient(ClientConverter.entityToModel(pClient));
				    	}else {
				    		skipCount++;
				    	}
				    		
				    	if(pClient.getDedupClientId()!=null) {
				    		distinctDedupIds.add(pClient.getDedupClientId());
				    	}
		    	}else{
		    		clients.addClient(ClientConverter.entityToModel(pClient));
		    	}
		    }
		    return clients;
	  }
	  
	  public BaseClients searchClients(SearchRequest searchVo) {
		    BaseClients clients = new BaseClients();
		    List<SearchClient> searchItems = (List<SearchClient>) this.daoFactory.getSearchDao().search(searchVo,true);
		    for (SearchClient pClient : searchItems) {
		    	// clients.addClient(ClientConverter.entityToModel(pClient));
		    	BaseClient baseClient = ClientConverter.entityToModel(pClient);
//		    	baseClient.setActionLinks(this.addActionLinks(pClient));
		    	baseClient.setLinks(addActionLinks(pClient));
		    	clients.addClient(baseClient);
		    }
		    return clients;
	  }
	  
	  @Transactional
	  public Map<String, ActionLinks> addActionLinks(SearchClient client) {
		  Map<String,Map<String, ActionLink>> links = new HashMap<>();
		  Map<String, ActionLinks> typeLinks = new HashMap<>();
		  ActionLinks actionLinks = new ActionLinks();
		  ObjectMapper mapper = new ObjectMapper();
		  List<ClientMetaDataEntity> entities = daoFactory.getClientMetaDataDao().findClientMetaData(client.getrDedupClientId());
		  for(ClientMetaDataEntity entity : entities) {
			  try {
				  	Map<String,String> addInfo = mapper.readValue(entity.getAdditionalInfo(), Map.class);
				  	ActionLinks actionlinks = typeLinks.get(entity.getType());
				  	if(actionlinks ==null) actionlinks = new ActionLinks();
				  			ActionLink link = new ActionLink();
				  			link.setHref(this.buildURL(environment.getProperty("linksTo."+entity.getType()),addInfo));
				  			link.setRel(entity.getMetaDataIdentifier().toString());
				  			actionlinks.addLink(link);
				  	typeLinks.put(entity.getType(), actionlinks);
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

}