package com.servinglynk.hmis.warehouse.base.dao;

import com.servinglynk.hmis.warehouse.SearchRequest;
import java.util.List;

public interface SearchDao
{
  public abstract List<?> search(SearchRequest paramSearchRequest);
  
  public abstract boolean indexing();
}
