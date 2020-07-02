package com.servinglynk.hmis.warehouse.rest;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.model.SearchRequest;
import com.servinglynk.hmis.warehouse.model.SearchResults;
import com.servinglynk.hmis.warehouse.service.SearchService;

@RestController
@RequestMapping("/el/search")
public class SearchController {

	@Autowired SearchService searchService;
	
		@RequestMapping(method = RequestMethod.GET,value =  "/{searchentity}")
		@APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=true, checkTrustedApp=true)
	  public SearchResults baseSearch( @PathVariable("searchentity") String searchentity,
			  @RequestParam(value="q", required=false,defaultValue="") String searchterm, 
			  @RequestParam(value="consentGroupId",required=false) String consentGroupId,
			  @RequestParam(value="sort", required=false,defaultValue="id") String sort, 
			  @RequestParam(value="order", required=false,defaultValue="asc") String order, 
			  @RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex, 
			  @RequestParam(value="maxItems", required=false,defaultValue="50") Integer maxItems,
			  @RequestParam(value="exclude",required=false) String exclude,
			  @RequestParam(value="procSearch",required=false,defaultValue="true") Boolean procSearch,
			  HttpServletRequest request)
					  	throws Exception
					  {
						SearchRequest searchRequest = new SearchRequest();
						  searchRequest.addSearchParam("consentGroupId",consentGroupId);
						  searchRequest.setIsProcSearch(procSearch);
						  searchRequest.setFreeText(searchterm);
						  searchRequest.setStartIndex(startIndex);
						  searchRequest.setMaxItems(maxItems);
						 return searchService.searcClients(searchRequest);						 
	  }
		
		@RequestMapping(method =  RequestMethod.POST)
		public void cacheClients() throws Exception  {
			searchService.cacheClients();
		}
}
