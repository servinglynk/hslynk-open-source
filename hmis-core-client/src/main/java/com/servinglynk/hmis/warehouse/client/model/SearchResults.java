package com.servinglynk.hmis.warehouse.client.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import java.util.ArrayList;
import java.util.List;

@JsonRootName("searchResults")
public class SearchResults
  extends PaginatedModel
{
  List items = new ArrayList();
  
  public List getItems()
  {
    return this.items;
  }
  
  public void setItems(List items)
  {
    this.items = items;
  }
  
  public void addItems(List items)
  {
    this.items.addAll(items);
  }
  
  public void addItem(Object item)
  {
    this.items.add(item);
  }
}
