package com.servinglynk.hmis.warehouse.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName("searchResults")
public class SearchResults  extends PaginatedModel {
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
