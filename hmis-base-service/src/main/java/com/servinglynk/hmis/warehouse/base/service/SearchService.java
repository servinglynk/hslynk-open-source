package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.SearchResults;

public abstract interface SearchService
{
  public  void indexing();
  
  public  SearchResults performSearch(String freeText, String sort, String order, Integer startIndex, Integer maxItems,String exclude);
}
