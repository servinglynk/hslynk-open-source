package com.servinglynk.hmis.warehouse.rest;

import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;

@RestController
public class HistoryController extends ControllerBase {

	@RequestMapping(value="/**/history",method=RequestMethod.GET)
	  @APIMapping(value="CLIENT_API_SEARCH", checkSessionToken=false, checkTrustedApp=true)
	public void getHistory(HttpServletRequest request,HttpServletResponse response,
			@RequestParam(value="startIndex", required=false,defaultValue="0") Integer startIndex, 
            @RequestParam(value="maxItems", required=false,defaultValue="30") Integer maxItems) throws Exception{
		
			String uri = request.getRequestURI().replace("/history","").replaceAll("//","/");
			String entityId = uri.substring(uri.lastIndexOf("/"));
			String parentUri = uri.replace(entityId, "");
			String entityName = parentUri.substring(parentUri.lastIndexOf("/"));
		String data = serviceFactory.getHistoryService().getEntityHistory(UUID.fromString(entityId.replace("/", "")),entityName.replace("/", ""),startIndex,maxItems);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(data);
		out.flush();
	}
	
	
	public static void main(String args[]) {
		String urL = "/clients/58edef37-d19c-4774-8d6a-bec410cd400d/enrollments/1fc8fe36-adae-4c9f-a8de-3cfe6b7d791b/medicalassistances/f8ad12e5-2e2a-427f-963b-135822031aa3/history";
		String uri = urL.replace("/history","").replaceAll("//","/");
		String entityId = uri.substring(uri.lastIndexOf("/"));
		String parentUri = uri.replace(entityId, "");
		String entityName = parentUri.substring(parentUri.lastIndexOf("/"));
		System.out.println("entityId "+entityId.replace("/", "")+" entity Name "+entityName.replace("/", ""));
	}
}