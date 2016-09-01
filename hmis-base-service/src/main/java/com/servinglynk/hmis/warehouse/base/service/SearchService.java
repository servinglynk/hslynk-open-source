package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.SearchResults;
import com.servinglynk.hmis.warehouse.core.model.Session;

public abstract interface SearchService
{
  public  void indexing();
  
  public  SearchResults performSearch(String freeText, String sort, String order, Integer startIndex, Integer maxItems,String exclude, Session session);

 SearchResults performProjectSearch(String searchterm, String sort, String order, Integer startIndex,
		Integer maxItems, String exclude, Session session);
}
