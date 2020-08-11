package com.servinglynk.hmis.warehouse.base.service;

import java.util.Map;

import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.core.model.ActionLinks;
import com.servinglynk.hmis.warehouse.core.model.SearchResults;
import com.servinglynk.hmis.warehouse.core.model.Session;
import com.servinglynk.hmis.warehouse.model.base.Client;

public abstract interface SearchService
{
  public  void indexing();
  
  public  SearchResults performSearch(SearchRequest searchVo,String freeText, String sort, String order, Integer startIndex, Integer maxItems,String exclude, Session session);

  Map<String, ActionLinks> getActionLinks(Client client);
}