package com.servinglynk.hmis.warehouse;

public class SearchRequest
{
  SortedPagination pagination;
  String[] dbfileds;
  String[] excludeFields=new String[]{};
  Sort sort;
  Class<?> searchEntity;
  String freeText;
  
  public SortedPagination getPagination()
  {
    return this.pagination;
  }
  
  public void setPagination(SortedPagination pagination)
  {
    this.pagination = pagination;
  }
  
  public String[] getDbfileds()
  {
    return this.dbfileds;
  }
  
  public void setDbfileds(String[] dbfileds)
  {
    this.dbfileds = dbfileds;
  }
  
  public Sort getSort()
  {
    return this.sort;
  }
  
  public void setSort(Sort sort)
  {
    this.sort = sort;
  }
  
  public Class<?> getSearchEntity()
  {
    return this.searchEntity;
  }
  
  public void setSearchEntity(Class<?> searchEntity)
  {
    this.searchEntity = searchEntity;
  }
  
  public String getFreeText()
  {
    return this.freeText;
  }
  
  public void setFreeText(String freeText)
  {
    this.freeText = freeText;
  }

public String[] getExcludeFields() {
	return excludeFields;
}

public void setExcludeFields(String[] excludeFields) {
	this.excludeFields = excludeFields;
} 
}