package com.servinglynk.report.business;

import javax.xml.bind.DatatypeConverter;

public class Sample {

	       public static void main(String a[]){

	          String str = new String(DatatypeConverter.parseBase64Binary("adsadf!"));
	          String res = DatatypeConverter.printBase64Binary(str.getBytes());
	          System.out.println(res);
	       }
	    }
