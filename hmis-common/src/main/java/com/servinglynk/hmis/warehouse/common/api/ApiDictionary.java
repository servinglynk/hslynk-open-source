package com.servinglynk.hmis.warehouse.common.api;

import java.util.Map;

public class ApiDictionary {
	
	private Map<String, String> dictionary;
	
	public void setDictionary(Map<String, String> dictionary)	{
		this.dictionary = dictionary;
	}
	
	public String mapToApiMethod(String methodName)	{
		String apiMethodId = dictionary.get(methodName);
		if (apiMethodId == null)	{
			return methodName;
		}
		
		return apiMethodId;
		
		/*
		StringBuilder sb = new StringBuilder();
		for(char c : methodName.toCharArray())	{
			if (Character.isUpperCase(c))	{
				sb.append("_").append(c);
			}
			else	{
				sb.append(Character.toUpperCase(c));
			}
		}
		
		return sb.toString();
		*/
	}
}
