package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.SearchRequest;
import java.util.List;

public interface SearchDao
{
  public List<?> search(SearchRequest searchVO,boolean isIndexSearch);
  
  public abstract boolean indexing(String indexClassList);
}
