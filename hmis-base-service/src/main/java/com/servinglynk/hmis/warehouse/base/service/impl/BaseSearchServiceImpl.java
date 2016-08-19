package com.servinglynk.hmis.warehouse.base.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.Sort;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.base.service.SearchService;
import com.servinglynk.hmis.warehouse.base.service.converter.ClientConverter;
import com.servinglynk.hmis.warehouse.core.model.Account;
import com.servinglynk.hmis.warehouse.core.model.BaseClients;
import com.servinglynk.hmis.warehouse.core.model.BaseProject;
import com.servinglynk.hmis.warehouse.core.model.SearchResults;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.Project;


public class BaseSearchServiceImpl extends ServiceBase implements SearchService {

	  @Transactional
	  public void indexing()
	  {
		  
		  String indexClassList = "com.servinglynk.hmis.warehouse.model.base.Client";
	    this.daoFactory.getSearchDao().indexing(indexClassList);
	  }
	  
	  @Transactional
	  public SearchResults performSearch(String freeText, String sort, String order, Integer startIndex,
			  Integer maxItems,String exclude,Session session)
	  {
	    SearchRequest searchVo = new SearchRequest();
	    Account account = serviceFactory.getAccountService().loadAccountBasicInfoByUsername(session.getAccount().getEmailAddress());
	    
	    	searchVo.setProjectGroupCode(account.getProjectGroup().getProjectGroupCode());
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
	    
	    List<Client> searchItems = (List<Client>) this.daoFactory.getSearchDao().search(searchVo,false);
	    
	    BaseClients clients = new BaseClients();
	    for (Client pClient : searchItems) {
	      clients.addClient(ClientConverter.entityToModel(pClient));
	    }
	    pagination.setFrom(startIndex);
	    pagination.setReturned(Integer.valueOf(clients.getClients().size()));
	    pagination.setTotal(Integer.valueOf(searchVo.getPagination().getTotal().intValue()));
	    
	    SearchResults result = new SearchResults();
	    result.setPagination(pagination);
	    result.addItems(clients.getClients());
	    
	    return result;
	  }

}
