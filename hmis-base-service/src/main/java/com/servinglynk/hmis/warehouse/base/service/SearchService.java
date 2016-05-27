package com.servinglynk.hmis.warehouse.base.service;

import com.servinglynk.hmis.warehouse.core.model.SearchResults;

public abstract interface SearchService
{
  public  void indexing();
  
  public  SearchResults performSearch(String paramString1, String paramString2, String paramString3, Integer paramInteger1, Integer paramInteger2);
}
