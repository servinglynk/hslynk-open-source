package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.SearchRequest;
import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.SearchResults;
import com.servinglynk.hmis.warehouse.core.model.Session;

@RestController
public class SearchController
  extends ControllerBase
{
  @RequestMapping(method=RequestMethod.GET,value="/search/{searchentity}")
  @APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
  public SearchResults searchClients(
		  @PathVariable("searchentity") String searchentity,
		  @RequestParam(value="q", required=true) String searchterm, 
		  @RequestParam(value="sort", required=false,defaultValue="firstName") String sort, 
		  @RequestParam(value="order", required=false,defaultValue="asc") String order, 
		  @RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex, 
		  @RequestParam(value="maxItems", required=false,defaultValue="50") Integer maxItems,
		  @RequestParam(value="exclude",required=false) String exclude,
		  HttpServletRequest request)
    throws Exception
  {
	  
	  Session session = sessionHelper.getSession(request);
	  
/*    if (startIndex == null) {
      startIndex = Integer.valueOf(0);
    }
    if (maxItems == null) {
      maxItems = Integer.valueOf(50);
    }*/

	  if(maxItems>50) maxItems =50;
	  
	  return this.serviceFactory.getSearchService().performSearch(new SearchRequest(),searchterm, sort, order, startIndex, maxItems,exclude,session);
  }
  
  @RequestMapping(method=RequestMethod.GET,value="/searchall/{searchentity}")
  @APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	  public SearchResults baseSearch( @PathVariable("searchentity") String searchentity,
			  @RequestParam(value="q", required=false,defaultValue="") String searchterm, 
			  @RequestParam(value="consentGroupId",required=false) String consentGroupId,
			  @RequestParam(value="sort", required=false,defaultValue="id") String sort, 
			  @RequestParam(value="order", required=false,defaultValue="asc") String order, 
			  @RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex, 
			  @RequestParam(value="maxItems", required=false,defaultValue="50") Integer maxItems,
			  @RequestParam(value="exclude",required=false) String exclude,
			  HttpServletRequest request)
					  	throws Exception
					  {
					   if( maxItems >50 )  maxItems = 50;
				
						  Session session = sessionHelper.getSession(request);
						  SearchRequest searchRequest = new SearchRequest();
						  searchRequest.addSearchParam("consentGroupId",consentGroupId);
		if(searchentity.equalsIgnoreCase("projects")){
			return serviceFactory.getBaseSearchService().performProjectSearch(searchterm, sort, order, startIndex, maxItems, exclude, session);
		}
		return this.serviceFactory.getBaseSearchService().performSearch(searchRequest,searchterm, sort, order, startIndex, maxItems,exclude,session);
		
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
