package com.servinglynk.hmis.warehouse.test.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.mock.web.MockMultipartHttpServletRequest;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.tags.Param;

import com.servinglynk.hmis.warehouse.core.model.JSONObjectMapper;

public class WebserviceTestExecutor {
	
	public static final String MEDIA_TYPE_APPLICATION_XML = "application/xml";
	public static final String MEDIA_TYPE_APPLICATION_JSON = "application/json";
	public static final String MEDIA_TYPE_APPLICATION_PLAIN = "text/plain";
	public static final String MEDIA_TYPE_MULTIPART_FORM_DATA = "multipart/form-data";
	public static final String MEDIA_TYPE_APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded;charset=UTF-8";

	public static final String CHARSET_UTF_8 = "UTF-8";

	public static final String HTTP_METHOD_POST = "POST";
	public static final String HTTP_METHOD_PUT = "PUT";
	public static final String HTTP_METHOD_DELETE = "DELETE";
	public static final String HTTP_METHOD_GET = "GET";
	
	protected Map<String, String> headers = new HashMap<String, String>();
	protected Map<String, String> requestparams = new HashMap<String, String>();
	protected Cookie cookies[] = null;
	protected ArrayList<Cookie> cookieList = new ArrayList<Cookie>();
	protected String contentTypeHeaderName = "Content-Type";
	protected String acceptHeaderName = "Accept";
	protected String acceptLanguageHeaderName = "Accept-Language";
	protected ThreadLocal<Integer> responseCodeThreadLocal;
	
	protected final Log LOG = LogFactory.getLog(getClass());
	
	
	 WebApplicationContext wac;
	
	public WebserviceTestExecutor(WebApplicationContext wac){
		this.wac=wac;
	}
	
	
	public String toJson(Object contentObject) throws Exception {
		String jsonString="";
		try{
		JSONObjectMapper objectMapper = new JSONObjectMapper();
		 jsonString = objectMapper.writeValueAsString(contentObject);
		}catch(Exception e){
			jsonString = ToStringBuilder.reflectionToString(contentObject);
		}
		return jsonString;
	}
	
	public String toXml(Object contentObject) throws Exception {
		return "";
	}
	
	
	public Object executeGet(String requestUri, Param... params) throws Exception {
		return execute(HTTP_METHOD_GET, requestUri, null, null, params);
	}

	@SuppressWarnings("unchecked")
	public <T> T executeGet(String requestUri, Class<T> responseValueType, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_GET, requestUri, null, responseValueType, params);
	}

	public Object executePost(String requestUri, Object contentObject, Param... params) throws Exception {
		return execute(HTTP_METHOD_POST, requestUri, contentObject, null, params);
	}

	@SuppressWarnings("unchecked")
	public <T> T executePost(String requestUri, Object contentObject, Class<T> responseValueType, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_POST, requestUri, contentObject, responseValueType, params);
	}

	public Object executePut(String requestUri, Object contentObject, Param... params) throws Exception {
		return execute(HTTP_METHOD_PUT, requestUri, contentObject, null, params);
	}

	@SuppressWarnings("unchecked")
	public <T> T executePut(String requestUri, Object contentObject, Class<T> responseValueType, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_PUT, requestUri, contentObject, responseValueType, params);
	}

	public Object executeDelete(String requestUri, Param... params) throws Exception {
		return execute(HTTP_METHOD_DELETE, requestUri, null, null, params);
	}

	@SuppressWarnings("unchecked")
	public <T> T executeDelete(String requestUri, Object contentObject, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_DELETE, requestUri, contentObject, null, params);
	}

	@SuppressWarnings("unchecked")
	public <T> T executeDelete(String requestUri, Class<T> responseValueType, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_DELETE, requestUri, null, responseValueType, params);
	}
	@SuppressWarnings("unchecked")
	public <T> T executeDelete(String requestUri,Object contentObject, Class<T> responseValueType, Param... params) throws Exception {
		return (T) execute(HTTP_METHOD_DELETE, requestUri, contentObject, responseValueType, params);
	}


	private Object execute(String httpMethod, String requestUri, Object contentObject, Class<?> responseValueType, Param... params) throws Exception {
		Object responseObject = null;
		
		MockHttpServletRequest request = createRequest(httpMethod, requestUri, contentObject, params);
		
		MockHttpServletResponse response = invokeDispatcherServlet(request);
	
		// get the response content
		String responseContentAsString = response.getContentAsString();

		

		if ((response.getRedirectedUrl() != null) || (response.getStatus() == 302)) {
			responseContentAsString = response.getRedirectedUrl();
			return responseContentAsString;
		}

		// convert responseContent to object
		if (getAcceptHeaderValue() != null && (getAcceptHeaderValue().contains(MEDIA_TYPE_APPLICATION_JSON))) {

			if (responseValueType == null) {
				// defaults to Object, so that json response is parsed into map
				responseValueType = Object.class;
			}

			// convert responseContent to object
			responseObject = toObjectFromJson(responseContentAsString, responseValueType);

		} else if (getAcceptHeaderValue() != null && getAcceptHeaderValue().contains(MEDIA_TYPE_APPLICATION_PLAIN)) {
			responseObject = responseContentAsString;
		} else {
			responseObject = toObjectFromXml(responseContentAsString);
		}

		
		return responseObject;
	}
	
	protected MockHttpServletRequest createRequest(String httpMethod, String requestUri, Object contentObject, Param... params) throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		
		if (getContentTypeHeaderName() != null && getContentTypeHeaderValue() != null && getContentTypeHeaderValue().contains(MEDIA_TYPE_MULTIPART_FORM_DATA)) {
			request = new MockMultipartHttpServletRequest();
		}
		//
		request.setMethod(httpMethod);
		request.setRequestURI(requestUri);
		request.setPathInfo(requestUri);
		// add request headers
		Set<Map.Entry<String, String>> headerEntrySet = headers.entrySet();
		for (Map.Entry<String, String> entry : headerEntrySet) {
			request.addHeader(entry.getKey(), entry.getValue());
		}

		// add cookies - added for localization
		if (getCookies() != null)
			request.setCookies(getCookies());

		// add request parameters
		for (Param param : params) {
			request.addParameter(param.getName(), String.valueOf(param.getValue()));
		}
		
		Set<Map.Entry<String, String>> paramEntrySet = requestparams.entrySet();
		for (Map.Entry<String, String> entry : paramEntrySet) {
			request.addParameter(entry.getKey(), entry.getValue());
		}

		// set request body/content
		if (contentObject != null) {
			String requestContentAsString = null;
			if (getContentTypeHeaderValue() != null && getContentTypeHeaderValue().contains(MEDIA_TYPE_APPLICATION_JSON)) {
				requestContentAsString = toJson(contentObject);
			} else if (getContentTypeHeaderValue() != null && getContentTypeHeaderValue().contains(MEDIA_TYPE_APPLICATION_PLAIN)) {
				requestContentAsString = contentObject.toString();
			} else if (getContentTypeHeaderValue() != null && getContentTypeHeaderValue().contains(MEDIA_TYPE_MULTIPART_FORM_DATA)) {
				((MockMultipartHttpServletRequest) request).addFile(new MockMultipartFile("file", (byte[]) contentObject));
				return request;
			} else {
				requestContentAsString = toXml(contentObject);
			}

			request.setContent(requestContentAsString.getBytes(CHARSET_UTF_8));
		}

		return request;
	}
	
	
	protected MockHttpServletResponse invokeDispatcherServlet(HttpServletRequest request) throws Exception {
		// create dispatcher servlet
		DispatcherServlet servlet = createDispatcherServlet();
		// create response
		MockHttpServletResponse response = new MockHttpServletResponse();
		// invoke servlet
		servlet.service(request, response);
		// return the response
		return response;
	}
	
	
	@SuppressWarnings("serial")
	protected DispatcherServlet createDispatcherServlet() throws Exception {
		DispatcherServlet servlet = new DispatcherServlet() {
			@Override
			protected WebApplicationContext createWebApplicationContext(WebApplicationContext parent) throws BeansException {
				GenericWebApplicationContext genericContext = new GenericWebApplicationContext();
				genericContext.setParent(wac);
				genericContext.refresh();
				return genericContext;
			}
		};
		MockServletConfig servletConfig = new MockServletConfig();
		servlet.init(servletConfig);
		return servlet;
	}
	

	protected Object toObjectFromXml(String xml) {
		return null;
	}


	protected <T> T toObjectFromJson(String json, Class<T> valueType) throws Exception {
		JSONObjectMapper mapper = new JSONObjectMapper();
		return	mapper.readValue(json, valueType);	
	}

	
	
	
	
	public String getContentTypeHeaderName() {
		return contentTypeHeaderName;
	}

	public void setContentTypeHeaderName(String contentTypeHeaderName) {
		this.contentTypeHeaderName = contentTypeHeaderName;
	}

	public String getAcceptHeaderName() {
		return acceptHeaderName;
	}

	public void setAcceptHeaderName(String acceptHeaderName) {
		this.acceptHeaderName = acceptHeaderName;
	}

	public String getContentTypeHeaderValue() {
		return getHeaderValue(contentTypeHeaderName);
	}

	public void setContentTypeHeaderValue(String mediaType) {
		setContentTypeHeaderValue(mediaType, CHARSET_UTF_8);
	}

	public void setContentTypeHeaderValue(String mediaType, String charset) {
		setHeaderValue(contentTypeHeaderName, mediaType + "; charset=" + charset);
	}

	public void setContentTypeHeaderAsXml() {
		setContentTypeHeaderValue(MEDIA_TYPE_APPLICATION_XML, CHARSET_UTF_8);
	}

	public void setContentTypeHeaderAsJson() {
		setContentTypeHeaderValue(MEDIA_TYPE_APPLICATION_JSON, CHARSET_UTF_8);
	}

	public void setContentTypeHeaderAsPlain() {
		setContentTypeHeaderValue(MEDIA_TYPE_APPLICATION_PLAIN, CHARSET_UTF_8);
	}

	public void setContentTypeHeaderAsMultipart(String boundary) {
		setHeaderValue(contentTypeHeaderName, MEDIA_TYPE_MULTIPART_FORM_DATA + "; boundary=" + boundary);
	}

	public void removeContentTypeHeader() {
		removeHeader(contentTypeHeaderName);
	}

	public String getAcceptHeaderValue() {
		return getHeaderValue(acceptHeaderName);
	}

	public void setAcceptHeaderValue(String value) {
		setHeaderValue(acceptHeaderName, value);
	}

	public String getAcceptLanguageHeaderValue() {
		return getHeaderValue(acceptLanguageHeaderName);
	}

	public void setAcceptLanguageHeaderValue(String value) {
		setHeaderValue(acceptLanguageHeaderName, value);
	}

	public void setAcceptHeaderAsXml() {
		setAcceptHeaderValue(MEDIA_TYPE_APPLICATION_XML);
	}

	public void setAcceptHeaderAsJson() {
		setAcceptHeaderValue(MEDIA_TYPE_APPLICATION_JSON);
	}

	public void removeAcceptHeader() {
		removeHeader(acceptHeaderName);
	}

	public String getAcceptLanguageHeaderName() {
		return acceptLanguageHeaderName;
	}

	public void setAcceptLanguageHeaderName(String acceptLanguageHeaderName) {
		this.acceptLanguageHeaderName = acceptLanguageHeaderName;
	}

	public String getHeaderValue(String headerName) {
		return headers.get(headerName);
	}

	public void setHeaderValue(String headerName, String headerValue) {
		headers.put(headerName, headerValue);
	}

	public void removeHeader(String headerName) {
		headers.remove(headerName);
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Cookie[] getCookies() {
		if (!cookieList.isEmpty())
			return cookieList.toArray(new Cookie[cookieList.size()]);
		return null;
	}

	public void removeAllCookies() {
		cookieList = new ArrayList<Cookie>();
	}

	public void addCookie(String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookieList.add(cookie);
	}

	public Integer getCurrentResponseCode() {
		return responseCodeThreadLocal.get();
	}
	
	public void addRequestParameter(String key, String value) {
		requestparams.put(key, value);
	}
	
	
	
	

}
