package com.servinglynk.report.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
public class testArrayList{
public static void retrieveValuesFromListMethod1(List list){
		Iterator itr = list.iterator();
		while(itr.hasNext()){
		System.out.println(itr.next());
			}
		}
public static void retrieveValuesFromListMethod2(List list)
{
	int size = list.size();
	for(int i=0;i<size;i++)
	{
		System.out.println(list.get(i));
	}
}
/*This method retrieves values from ArrayList using Enumeration */

public static void retrieveValuesFromListMethod3(List list){
	Enumeration e = Collections.enumeration(list);
	while(e.hasMoreElements())
	{
		System.out.println(e.nextElement());
	}
}
public static void main(String[] args){
	List list = new ArrayList();
	list.add("test1");
	list.add("test2");
	list.add("test3");
	System.out.println("Retrieving values from ArrayList using Iterator");
	retrieveValuesFromListMethod1(list);
	System.out.println("**********************\n\n");

	System.out.println("Retrieving values from ArrayList using get method");
	retrieveValuesFromListMethod2(list);
	System.out.println("**********************\n\n");

	System.out.println("Retrieving values from ArrayList using Enumeration");
	retrieveValuesFromListMethod3(list);
	System.out.println("**********************\n\n");
	}

}