package com.servinglynk.hmis.warehouse.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.SearchResults;

@RestController
public class SearchController
  extends ControllerBase
{
  @RequestMapping(method=RequestMethod.GET,value="/search/{searchentity}")
  @APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
  public SearchResults searchClients(
		  @PathVariable("searchentity") String searchentity,
		  @RequestParam(value="q", required=true) String searchterm, 
		  @RequestParam(value="sort", required=false) String sort, @RequestParam(value="order", required=false) String order, @RequestParam(value="startIndex", required=false) Integer startIndex, @RequestParam(value="maxItems", required=false) Integer maxItems)
    throws Exception
  {
    if (startIndex == null) {
      startIndex = Integer.valueOf(0);
    }
    if (maxItems == null) {
      maxItems = Integer.valueOf(50);
    }
    return this.serviceFactory.getSearchService().performSearch(searchterm, sort, order, startIndex, maxItems);
  }
  
  @RequestMapping(method=RequestMethod.GET,value="/searchall/{searchentity}")
  @APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	  public SearchResults baseSearch( @PathVariable("searchentity") String searchentity,
			  @RequestParam(value="q", required=true) String searchterm, 
			  @RequestParam(value="sort", required=false) String sort, @RequestParam(value="order", required=false) String order, 
			  @RequestParam(value="startIndex", required=false) Integer startIndex, @RequestParam(value="maxItems", required=false) Integer maxItems)
					  	throws Exception
					  {
					    if (startIndex == null) {
					      startIndex = Integer.valueOf(0);
					    }
					    if (maxItems == null || maxItems >50 ) {
					      maxItems = Integer.valueOf(50);
					    }
	    return this.serviceFactory.getBaseSearchService().performSearch(searchterm, sort, order, startIndex, maxItems);
	  }
  
  @RequestMapping(method=RequestMethod.POST, value="/searchall/index")
  @APIMapping(value="CLIENT_API_INDEX", checkSessionToken=false, checkTrustedApp=false)
  public void baseIndexing()
  {
    this.serviceFactory.getBaseSearchService().indexing();
  }
  
  @RequestMapping(method=RequestMethod.POST, value="/search/index")
  @APIMapping(value="CLIENT_API_INDEX", checkSessionToken=false, checkTrustedApp=false)
  public void indexing()
  {
    this.serviceFactory.getSearchService().indexing();
  }
}
