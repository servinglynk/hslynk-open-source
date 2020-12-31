package com.servinglynk.hmis.warehouse.core.web.interceptor;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.servinglynk.hmis.warehouse.common.Constants;
import com.servinglynk.hmis.warehouse.common.GeneralUtil;
import com.servinglynk.hmis.warehouse.common.util.TraceUtil;

public class HslynkTraceFilter  extends org.springframework.web.filter.OncePerRequestFilter {

	
	  private static final Logger logger = LoggerFactory.getLogger(HslynkTraceFilter.class);

	  @Autowired
	  private SessionHelper sessionHelper;
	  
	  private boolean logHttpRequests=true;
	  
	  private boolean logHttpResponses=true;
/*
	
	  private String[] inputRemoveHttpRequestHeaders;
	  private Set<String> removeHttpRequestHeaders;

	
	  private String[] inputRemoveHttpResponseHeaders;
	  private Set<String> removeHttpResponseHeaders;

		  private String[] inputRemoveHttpBodyContentTypes= {"application/octet-stream","multipart/octet-stream"};
	  private Set<String> removeHttpBodyContentTypes;

	  @PostConstruct
	  public void init() {
	    removeHttpRequestHeaders = Arrays.stream(inputRemoveHttpRequestHeaders)
	      .filter(s -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toSet());
	    removeHttpResponseHeaders = Arrays.stream(inputRemoveHttpResponseHeaders)
	      .filter(s -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toSet());
	    removeHttpBodyContentTypes = Arrays.stream(inputRemoveHttpBodyContentTypes)
	      .filter(s -> !s.isEmpty()).map(String::toUpperCase).collect(Collectors.toSet());
	  }
*/
	  public String initTraceId(HttpServletRequest request, HttpServletResponse response) {
		    TraceUtil.clearTrace();

		    long startTime = System.currentTimeMillis();
		    request.setAttribute("startTime", startTime);
		    
		    ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
		    ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

		    //String accessToken = this.sessionHelper.retrieveSessionToken(request);
		    String traceId = TraceUtil.PutTraceIdInTreadContext(requestWrapper);
		    return traceId;
	  }
	 

	  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    throws ServletException, IOException {
		  logger.debug("====================================================================================================================");
		  logger.debug("inside doFilterInternal ");
		  logger.debug("====================================================================================================================");
	    TraceUtil.clearTrace();

	    long startTime = System.currentTimeMillis();
	    request.setAttribute("startTime", startTime);

	    ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
	    ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

	    //String accessToken = this.sessionHelper.retrieveSessionToken(request);
	    String traceId = TraceUtil.PutTraceIdInTreadContext(requestWrapper);
	    response.setHeader("HSLNK_TRACE_ID_HEADER", traceId);

	    try {
	      filterChain.doFilter(requestWrapper, responseWrapper);
	    } finally {

	      long endTime = System.currentTimeMillis();
	      long executeTime = endTime - startTime;

	      if (logHttpRequests) {
	        //String requestBody = new String(requestWrapper.getContentAsByteArray()).replaceAll("(\\r|\\n)", "");
	        //log.debug("\\/\\/\\/\\/\\/\\/ Request body: {}", requestBody);
	        logHttpRequest(requestWrapper);
	      }

	      if (logHttpResponses) {
	        //String responseBody = new String(responseWrapper.getContentAsByteArray()).replaceAll("(\\r|\\n)", "");
	        //log.debug("\\/\\/\\/\\/\\/\\/ Response body: {}", responseBody);
	        logHttpResponse(responseWrapper, executeTime);
	        responseWrapper.copyBodyToResponse();
	      }
	    }
	  }

	  private String logBody(ContentCachingRequestWrapper req) {
	    String body = "NO_PAYLOAD";
	    if (Objects.nonNull(req.getContentType())) {
	     // if (removeHttpBodyContentTypes.contains(req.getContentType().toUpperCase())) {
	      //  return "REMOVED";
	      // } else
	    	if (req.getContentLength() <= 0) {
	        return body;
	      }
	    }

	    if (req.getContentLength() > 0) {
	      body = new String(req.getContentAsByteArray());
	    }
	    return body.replaceAll("(\\r|\\n)", "");
	  }

	  private String logBody(ContentCachingResponseWrapper res) {
	    String body = "NO_PAYLOAD";
	    if (Objects.nonNull(res.getContentType())) {
	      //if (removeHttpBodyContentTypes.contains(res.getContentType().toUpperCase())) {
	       // return "REMOVED";
	     // } else 
	    	if (res.getContentSize() <= 0) {
	        return body;
	      }
	    }

	    if (res.getContentSize() > 0) {
	      body = new String(res.getContentAsByteArray());
	    }
	    return body.replaceAll("(\\r|\\n)", "");
	  }

	  public void logHttpRequest(ContentCachingRequestWrapper req) {
	    try {
	      StringBuilder stringBuilder = new StringBuilder("[to: " + req.getMethod() + " " + req.getRequestURI() + "]")
	        .append("[query: " + req.getQueryString() + "]")
	        .append("[remoteAddr: " + req.getRemoteAddr() + "]");

	      Enumeration<String> enumHeaderNames = req.getHeaderNames();
	      if (enumHeaderNames != null) {
	        while (enumHeaderNames.hasMoreElements()) {
	          String headerName = (String) enumHeaderNames.nextElement();
	          //if (removeHttpRequestHeaders.contains(headerName.toUpperCase())) {
	           // continue;
	          //}
	          stringBuilder.append("[headers: " + headerName + ": " + req.getHeader(headerName) + "]");
	        }
	      }

	      String requestBody = logBody(req);
	      stringBuilder.append("[[requestBody: " + requestBody + "]]");
	        //.append("[resTime: " + execTime + "ms]. ");
	      logger.debug(stringBuilder.toString());
	    } catch (Exception e) {
	      logger.debug("Exception logging http request:" + e);
	    }
	  }

	  public void logHttpResponse(ContentCachingResponseWrapper res, long execTime) {
	    try {
	      StringBuilder stringBuilder = new StringBuilder("[status: " + res.getStatus() + "]")
	        .append("[ContentType: " + res.getContentType() + "]")
	        .append("[ContentSize: " + res.getContentSize() + "]");

	      @SuppressWarnings("unchecked")
	      Collection<String> enumHeaderNames = res.getHeaderNames();
	      if (enumHeaderNames != null) {
	        for (String headerName : enumHeaderNames) {
	        //  if (removeHttpResponseHeaders.contains(headerName.toUpperCase())) {
	         //   continue;
	         // }
	          stringBuilder.append("[" + headerName + ": " + res.getHeader(headerName) + "]");
	        }
	      }

	      String responseBody = logBody(res);
	      stringBuilder.append("[[" + responseBody + "]]")
	        .append("[resTime: " + execTime + "ms]. ");
	      logger.debug(stringBuilder.toString());
	    } catch (Exception e) {
	      logger.debug("Exception logging http response:" + e);
	    }
	  }
}
