package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;

import com.servinglynk.hmis.warehouse.SearchRequest;

public interface SearchDao
{
  public List<?> search(SearchRequest searchVO,boolean isIndexSearch);
  
  public abstract boolean indexing(String indexClassList);

}
