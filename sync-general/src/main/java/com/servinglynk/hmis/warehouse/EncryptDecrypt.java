package com.servinglynk.hmis.warehouse;

import org.apache.commons.net.util.Base64;

public class EncryptDecrypt {

	public static void main(String args[]){
		String str ="test";
		byte[] encodeBase64 = Base64.encodeBase64(str.getBytes());
		System.out.println(encodeBase64.toString());
	}
}
