package com.servinglynk.hmis.warehouse.common;

import java.util.Random;
import java.util.UUID;

public class GeneralUtil {

	public static String getNewGuid() {		return UUID.randomUUID().toString().toUpperCase();	}		public static String getAlphaNumericGuid() {		String str =  getNewGuid();		return str.replaceAll("-","");	}
	public static String getUniqueToken(int length) {
		StringBuffer buffer = new StringBuffer();
		while(buffer.length() < length) {
			buffer.append(getNewGuid().replace("-", ""));
		}
		return buffer.substring(0, length);
	}		public static String convertBooleanToString(Integer booleanValue){		if(booleanValue!=null) 		return (booleanValue==1)?"true":"false";			return null;	}
	
    private static int getNextIndex(Random rnd, int len, char[] pswd) {
        int index = rnd.nextInt(len);
        while(pswd[index = rnd.nextInt(len)] != 0);
        return index;
    }
	
	public static String randomPassword(){
		
		 Random rnd = new Random();
	        int len = 9;
	        char[] pswd = new char[len];
	        int index = 0;
	            index = getNextIndex(rnd, len, pswd);
	            pswd[index] = Constants.ALPHA_CAPS.charAt(rnd.nextInt(Constants.ALPHA_CAPS.length()));
	            index = getNextIndex(rnd, len, pswd);
	            pswd[index] = Constants.NUM.charAt(rnd.nextInt(Constants.NUM.length()));
	            index = getNextIndex(rnd, len, pswd);
	            pswd[index] = Constants.SPL_CHARS.charAt(rnd.nextInt(Constants.SPL_CHARS.length()));
	        
	        for(int i = 0; i < len; i++) {
	            if(pswd[i] == 0) {
	                pswd[i] = Constants.ALPHA.charAt(rnd.nextInt(Constants.ALPHA.length()));
	            }
	        }
		return new String(pswd);
	}
	
	
	public static void main(String args[]){
		GeneralUtil util = new GeneralUtil();
		System.out.println(util.randomPassword());
	}
}
