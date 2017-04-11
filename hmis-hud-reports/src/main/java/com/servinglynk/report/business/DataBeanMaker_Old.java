package com.servinglynk.report.business;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.servinglynk.report.bean.DataBean_Old;

public class DataBeanMaker_Old {
	
        public static ArrayList<DataBean_Old> getDataBeanList() {
        		
        		ArrayList<DataBean_Old> dataBeanList = new ArrayList<DataBean_Old>();

                DataBean_Old bean =(firstPage("1/1/2015",
                		" ",
                		"APR - Services Only",
                		"Everyone",
                		"all grants",
                		"Aggregate / summary",
                		"All Practical Reporting, Inc.",
                		"APR",
                		"APR - Services Only",
                		BigInteger.valueOf(240),
                		BigInteger.valueOf(6),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		/*BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),*/
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0)
    	        		));
                
                /** 
        		 * Q05A HMIS or Comparable Database Data Quality Table -- Starts
        		 **/  
                q05ACDDQ(
	                BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(0),
	        		BigInteger.valueOf(11),
	        		BigInteger.valueOf(10),
	        		BigInteger.valueOf(1),
	        		BigInteger.valueOf(4),
	        		BigInteger.valueOf(1),
	        		BigInteger.valueOf(16),
	        		BigInteger.valueOf(3),
	        		BigInteger.valueOf(2),
	        		BigInteger.valueOf(0),
            		BigInteger.valueOf(1),
            		BigInteger.valueOf(0),
            		BigInteger.valueOf(1),
            		BigInteger.valueOf(0),
            		BigInteger.valueOf(1),
            		BigInteger.valueOf(1),
            		BigInteger.valueOf(0),
            		BigInteger.valueOf(0),
            		BigInteger.valueOf(0),
            		BigInteger.valueOf(0),
            		bean
	        		);
	        
                /** 
        		 * Q06A Report Validations Table -- Starts
        		 **/  
                q06AReportValidations(
                "16","11","4","3",
        		"3","4","2","11",
        		"1","1","2","1","13",
        		"8",bean);
                

                /** 
        		 * Q06B Number of Persons Served Table -- Starts
        		 **/  
                q06BNumberOfPersonsServed(
                		BigInteger.valueOf(11),BigInteger.valueOf(4),
                		BigInteger.valueOf(0),BigInteger.valueOf(1),
                		BigInteger.valueOf(16),BigInteger.valueOf(10),
                		BigInteger.valueOf(1),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(2),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(1),
                		BigInteger.valueOf(10),BigInteger.valueOf(0),
                		BigInteger.valueOf(3),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(1),bean);
                
                /** 
        		 * Q06C Point-in-Time Count of Persons on the Last Wednesday Table -- Starts
        		 **/  
                q06CPCPLastWednesday(
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
               		 	bean);
                
            	/** 
        		 * Q07a HouseholdsServed Table -- Starts
        		 **/  
                q07AHouseHoldsServed( BigInteger.valueOf(13),
	              		 BigInteger.valueOf(10),
	              		 BigInteger.valueOf(1),
	              		 BigInteger.valueOf(1),
	              		 BigInteger.valueOf(1),
	              		 bean);
                /** 
     	     	 * Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Starts
     	     	 **/
                q07BPointinTimeCountHHLastWednesday(BigInteger.valueOf(2),
	         	     	BigInteger.valueOf(4),BigInteger.valueOf(7),
	         	     	BigInteger.valueOf(9),BigInteger.valueOf(2),
	         	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
	         	     	BigInteger.valueOf(0),BigInteger.valueOf(3),
	         	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
	         	     	BigInteger.valueOf(1),BigInteger.valueOf(6),
	         	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
	         	     	BigInteger.valueOf(1),BigInteger.valueOf(6),
	         	     	BigInteger.valueOf(1),BigInteger.valueOf(1),
	         	     	BigInteger.valueOf(1),
	         	     	bean);
                
            	/** 
     	     	 * Q09a: Number of Persons Contacted Table -- Starts
     	     	 **/
                q09ANumberOfPersonsContacted(BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	BigInteger.valueOf(0),BigInteger.valueOf(0),
     	     	bean
     	     );
                
            	/**
       	    	 * "Q09b: Number of Persons Engaged"  Table -- Starts
       	    	*/
                q09BNumberOfPersonsEngaged(
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    bean
               	    );
                
                /**
       	    	 * "Q10a: Gender of Adults"  Table -- Starts
       	    	*/             
                q10AGenderOfAdults(BigInteger.valueOf(5),
                   	    BigInteger.valueOf(4),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(1),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(11),
                   	    BigInteger.valueOf(5),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(3),
                   	    BigInteger.valueOf(1),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(1),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(10),BigInteger.valueOf(1),
                   	    BigInteger.valueOf(0),BigInteger.valueOf(1),
                   	    BigInteger.valueOf(1),BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    bean
                		);
                
                /**
               	 * "Q10b: Gender of Children"  Table -- Starts
               	 **/
                q10bGenderOfChildren(BigInteger.valueOf(2),
               	    BigInteger.valueOf(2),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(4),
               	    BigInteger.valueOf(1),BigInteger.valueOf(1),
               	    BigInteger.valueOf(0),BigInteger.valueOf(1),
               	    BigInteger.valueOf(1),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(2),BigInteger.valueOf(2),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),BigInteger.valueOf(0),
               	    BigInteger.valueOf(0),
               	    bean
               	  );
                
                /**
       	    	 * "Q10c: Gender of Persons Missing Age Information"  Table -- Starts
       	    	*/
                q10CGPMI(BigInteger.valueOf(1),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(1), 
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(1),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    BigInteger.valueOf(0),
                   	    	bean);
                /**
       	    	 * "Q11: Age"  Table -- Starts
       	    	*/
                q11AgeTableBean(BigInteger.valueOf(1), BigInteger.valueOf(2),
                		BigInteger.valueOf(1), BigInteger.valueOf(2),
            			BigInteger.valueOf(4), BigInteger.valueOf(1),
            			BigInteger.valueOf(2), BigInteger.valueOf(1),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(16),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(2),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(1),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(4), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(2), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(1), BigInteger.valueOf(10),
            			BigInteger.valueOf(3),
            			BigInteger.valueOf(2),
            			BigInteger.valueOf(1),bean);
                
                /**
       	    	 * "Q12a: Race"  Table -- Starts
       	    	*/
                q12aRaceTableBean(BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0), 
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		bean);
               
                /**
       	    	 * "Q12b: Ethnicity"  Table -- Starts
       	    	*/
                q12bEthnicityTableBean(BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),        
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),        
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                   		bean);
                
                /**
       	    	 * "Q13a1: Physical Mental Health Condition"  Table -- Starts
       	    	*/
                q13a1PhysicalMntlHealthCondTableBean(
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			bean);
        		        
                /**
       	    	 * "Q13a2: Number of Conditions"  Table -- Starts
       	    	*/
                q13a2NumberofConditioinsTableBean(BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0), 
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
            			bean);
                	
                q13b1PhysicalAndMentalHealthConditionsAtExitTableBean(
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			bean);

        q13b2NumberOfConditionsAtExitTableBean(
        				BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0), BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			BigInteger.valueOf(0),
            			bean);
        
        			q13c1PhysicalAndMentalHealthConditionsForStayerTableBean(
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			bean);

        			q13c2NumberOfConditionForStayersTableBean(
						BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0), BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			BigInteger.valueOf(0),
		    			bean);
        			
        			q14aDomesticViolenceHistoryTableBean(BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0), 
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0), 
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        	    			bean);
        	    		
        			q14bPersonsFleeingDomesticViolenceTableBean(BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0), 
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0), 
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0), 
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        					BigInteger.valueOf(0),
        	    			bean); 
        			
        	q15ResidencePriorToProgramEntryBeanPublic(
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			bean);
        
        	q16CashIncomeRangesTableBean(
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			BigInteger.valueOf(0),
        			bean);
        
                dataBeanList.add(bean);
        		return dataBeanList;
        }
        
        

		private static DataBean_Old firstPage(String homePageStartDate,
				 String homePageEndDate,
        		 String homePageProjects,
        		 String homePageHomeLess,
        		 String homePageGrants,
        		 String homePageView,
        		 String q04aOrgName,
        		 String q04aOrgId,
        		 String q04aProjectName,
        		 BigInteger q04aHmisProjectIdService,
        		 BigInteger q04aHmisProjectType,
        		 BigInteger q04aIdentityProjectId,
        		 BigInteger q04aMethodOfTracking,
        		 BigInteger q04aProjectId,
        		 BigInteger countJanTotal,
        		 BigInteger countAprTotal,
        		 BigInteger countJulTotal,
        		 BigInteger countOctTotal,
        		 BigInteger npDkrTot,
        		 BigInteger npMiTot,
        		 BigInteger npAdultsTot,
        		 BigInteger npChildTot,
        		 BigInteger npTotSum,
        		 BigInteger npWcSum,
        		 BigInteger npWCASum,
        		 BigInteger npWOCSum,
        		 BigInteger npUHTSum
        		 
        		 //twenty seven
        		 ) {
    	
                DataBean_Old dataBean = new DataBean_Old();
                
                
                dataBean.setCountAprTotal(countAprTotal);
                dataBean.setCountJanTotal(countJanTotal);
                dataBean.setCountJulTotal(countJulTotal);
                dataBean.setCountOctTotal(countOctTotal);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                dataBean.setHomePageEndDate(dateFormat.format(date));
                dataBean.setHomePageGrants(homePageGrants);
                dataBean.setQ04aHmisProjectIdService(q04aHmisProjectIdService);
                dataBean.setQ04aHmisProjectType(q04aHmisProjectType);
                dataBean.setHomePageHomeLess(homePageHomeLess);
                dataBean.setQ04aIdentityProjectId(q04aIdentityProjectId);
                dataBean.setQ04aMethodOfTracking(q04aMethodOfTracking);
                dataBean.setQ04aOrgId(q04aOrgId);
                dataBean.setQ04aOrgName(q04aOrgName);
                dataBean.setQ04aProjectId(q04aProjectId);
                dataBean.setQ04aProjectName(q04aProjectName);
                dataBean.setHomePageProjects(homePageProjects);
                dataBean.setHomePageStartDate(homePageStartDate);
                dataBean.setHomePageView(homePageView);
                dataBean.setNpAdultsTot(npAdultsTot);
                dataBean.setNpChildTot(npChildTot);
                dataBean.setNpDkrTot(npDkrTot);
                dataBean.setNpMiTot(npMiTot);
                dataBean.setNpTotSum(npTotSum);
                dataBean.setNpUHTSum(npUHTSum);
                dataBean.setNpWCASum(npWCASum);
                dataBean.setNpWcSum(npWcSum);
                dataBean.setNpWOCSum(npWOCSum);
                
                return  dataBean;
        }
		
		/** 
		 * Q05A HMIS or Comparable Database Data Quality Table -- Starts
		 **/
		private static DataBean_Old q05ACDDQ(
		 BigInteger clientlocationForPe,
		 BigInteger destination,
		 BigInteger disablingCond,
		 BigInteger dob,
		 BigInteger ethnicity,
		 BigInteger firstName,
		 BigInteger gender,
		 BigInteger lastName,
		 BigInteger ltsInEs,
		 BigInteger race,
		 BigInteger relationshiptToHh,
		 BigInteger residencePriorToEntry,
		 BigInteger ssn,
		 BigInteger veteranStatus,
		 BigInteger mdClientlocationForPe,
		 BigInteger mdDestination,
		 BigInteger mdDisablingCond,
		 BigInteger mdDob,
		 BigInteger mdEthnicity,
		 BigInteger mdFirstName,
		 BigInteger mdGender,
		 BigInteger mdLastName,
		 BigInteger mdLtsInEsSh,
		 BigInteger mdRace,
		 BigInteger mdRelationshipToHh,
		 BigInteger mdSsn,
		 BigInteger mdVeteranStatus,
		 BigInteger mdresidencepriortoentry,
		 DataBean_Old q05ACDDQ){
			
			q05ACDDQ.setClientlocationForPe(clientlocationForPe);
            q05ACDDQ.setDestination(destination);
            q05ACDDQ.setDisablingCond(disablingCond);
            q05ACDDQ.setDob(dob);
            q05ACDDQ.setEthnicity(ethnicity);
            q05ACDDQ.setFirstName(firstName);
            q05ACDDQ.setGender(gender);
            q05ACDDQ.setLastName(lastName);
            q05ACDDQ.setLtsInEs(ltsInEs);
            q05ACDDQ.setMdClientlocationForPe(mdClientlocationForPe);
            q05ACDDQ.setMdDestination(mdDestination);
            q05ACDDQ.setMdDisablingCond(mdDisablingCond);
            q05ACDDQ.setMdDob(mdDob);
            q05ACDDQ.setMdEthnicity(mdEthnicity);
            q05ACDDQ.setMdFirstName(mdFirstName);
            q05ACDDQ.setMdGender(mdGender);
            q05ACDDQ.setMdLastName(mdLastName);
            q05ACDDQ.setMdLtsInEsSh(mdLtsInEsSh);
            q05ACDDQ.setMdRace(mdRace);
            q05ACDDQ.setMdRelationshipToHh(mdRelationshipToHh);
            q05ACDDQ.setMdresidencepriortoentry(mdresidencepriortoentry);
            q05ACDDQ.setMdSsn(mdSsn);
            q05ACDDQ.setMdVeteranStatus(mdVeteranStatus);
            q05ACDDQ.setRace(race);
            q05ACDDQ.setRelationshiptToHh(relationshiptToHh);
            q05ACDDQ.setResidencePriorToEntry(residencePriorToEntry);
            q05ACDDQ.setSsn(ssn);
            q05ACDDQ.setVeteranStatus(veteranStatus);
            
			return q05ACDDQ;
		}
		 
		/** 
		 * Q06A Report Validations Table -- Starts
		 **/
		private static DataBean_Old q06AReportValidations(
				 String totNumOfPersonServed,
	       		 String numOfAdults,
	       		 String numOfChildren,
	       		 String numOfPersonsWithUnknownAge,
	       		 String totNoOfLeavers,
	       		 String totNoOfAdultLeavers,
	       		 String noOfVeterans,
	       		 String noOfChronicallyHomelessPersons,
	       		 String noOfAdultHeadsOfHousehold,
	       		 String noOfChildHeadsOfHousehold,
	       		 String numOfUnaccompaniedYouthUnderAge25,
	       		 String numOfParentingYouthUnderAge25WithChildren,
	       		 String totNoOfStayers,
	       		 String totNoOfAdultStayers,
       			 DataBean_Old q06AReportValidations){
			 
			 q06AReportValidations.setNoOfAdultHeadsOfHousehold(noOfAdultHeadsOfHousehold);
			 q06AReportValidations.setNoOfChildHeadsOfHousehold(noOfChildHeadsOfHousehold);
			 q06AReportValidations.setNoOfChronicallyHomelessPersons(noOfChronicallyHomelessPersons);
			 q06AReportValidations.setNoOfVeterans(noOfVeterans);
			 q06AReportValidations.setNumOfAdults(numOfAdults);
			 q06AReportValidations.setNumOfChildren(numOfChildren);
			 q06AReportValidations.setNumOfParentingYouthUnderAge25WithChildren(numOfParentingYouthUnderAge25WithChildren);
			 q06AReportValidations.setNumOfPersonsWithUnknownAge(numOfPersonsWithUnknownAge);
			 q06AReportValidations.setNumOfUnaccompaniedYouthUnderAge25(numOfUnaccompaniedYouthUnderAge25);
			 q06AReportValidations.setTotNoOfAdultLeavers(totNoOfAdultLeavers);
			 q06AReportValidations.setTotNoOfLeavers(totNoOfLeavers);
			 q06AReportValidations.setTotNumOfPersonServed(totNumOfPersonServed);
			 q06AReportValidations.setTotNoOfAdultStayers(totNoOfAdultStayers);
			 q06AReportValidations.setTotNoOfStayers(totNoOfStayers);
			 
			return q06AReportValidations;
		}
		
		/** 
		 * Q06B Number of Persons Served Table -- Starts
		 **/
		private static DataBean_Old q06BNumberOfPersonsServed(
		

		 BigInteger npTotalAdults,
		 BigInteger npTotalChildren,
		 BigInteger npTotalDKR,
		 BigInteger npTotalMI,
         BigInteger npOverallTotal,
		 
		 BigInteger npAdultsUhtTot,
		 BigInteger npAdultsWcTot,
		 BigInteger npAdultsWcaTot,
		 BigInteger npAdultsWocTot,
		 
		 BigInteger npChildUhtTot,
		 BigInteger npChildWcTot,
		 BigInteger npChildWcaTot,
		 BigInteger npChildWocTot,
		 BigInteger npDkrUhtTot,
		 BigInteger npDkrWcTot,
		 BigInteger npDkrWcsTot,
		 BigInteger npDkrWocTot,
		 BigInteger npMiUhtTot,
		 BigInteger npMiWcTot,
		 BigInteger npMiWcaTot,
		 BigInteger npMiWocTot,
         BigInteger npTotalWC,
         BigInteger npWCATotal,
         BigInteger npWOCTotal,
         BigInteger npUHTTotal, DataBean_Old q06BNumberOfPersonsServed){
			
			
            q06BNumberOfPersonsServed.setNpAdultsUhtTot(npAdultsUhtTot);
            q06BNumberOfPersonsServed.setNpAdultsWcaTot(npAdultsWcaTot);
            q06BNumberOfPersonsServed.setNpAdultsWcTot(npAdultsWcTot);
            q06BNumberOfPersonsServed.setNpAdultsWocTot(npAdultsWocTot);
            q06BNumberOfPersonsServed.setNpChildUhtTot(npChildUhtTot);
            q06BNumberOfPersonsServed.setNpChildWcaTot(npChildWcaTot);
            q06BNumberOfPersonsServed.setNpChildWcTot(npChildWcTot);
            q06BNumberOfPersonsServed.setNpChildWocTot(npChildWocTot);
            q06BNumberOfPersonsServed.setNpDkrUhtTot(npDkrUhtTot);
            q06BNumberOfPersonsServed.setNpDkrWcsTot(npDkrWcsTot);
            q06BNumberOfPersonsServed.setNpDkrWcTot(npDkrWcTot);
            q06BNumberOfPersonsServed.setNpDkrWocTot(npDkrWocTot);
            q06BNumberOfPersonsServed.setNpMiUhtTot(npMiUhtTot);
            q06BNumberOfPersonsServed.setNpMiWcTot(npMiWcTot);
            q06BNumberOfPersonsServed.setNpMiWcaTot(npMiWcaTot);
            q06BNumberOfPersonsServed.setNpMiWocTot(npMiWocTot);
            q06BNumberOfPersonsServed.setNpOverallTotal(npOverallTotal);
            q06BNumberOfPersonsServed.setNpTotalAdults(npTotalAdults);
            q06BNumberOfPersonsServed.setNpTotalChildren(npTotalChildren);
            q06BNumberOfPersonsServed.setNpTotalDKR(npTotalDKR);
            q06BNumberOfPersonsServed.setNpTotalMI(npTotalMI);
            q06BNumberOfPersonsServed.setNpTotalWC(npTotalWC);
            q06BNumberOfPersonsServed.setNpUHTTotal(npUHTTotal);
            q06BNumberOfPersonsServed.setNpWCATotal(npWCATotal);
            q06BNumberOfPersonsServed.setNpWOCTotal(npWOCTotal);
            
			return q06BNumberOfPersonsServed;
		}

		/** 
		 * Q06C Point-in-Time Count of Persons on the Last Wednesday Table -- Starts
		 **/
		private static DataBean_Old q06CPCPLastWednesday(
         BigInteger janTotal, BigInteger aprTotal,
         BigInteger julyTotal,BigInteger octTotal,
         BigInteger countAprUht,BigInteger countAprWc,
		 BigInteger countAprWca,BigInteger countAprWoc,
		 BigInteger countJanUht,BigInteger countJanWc,
		 BigInteger countJanWca,BigInteger countJanWoc,
		 BigInteger countJulUht,BigInteger countJulWc,
		 BigInteger countJulWca, BigInteger countJulWoc,
		 BigInteger countOctUht,BigInteger countOctWc,
		 BigInteger countOctWca,BigInteger countOctWoc,
		 DataBean_Old q06CPCPLastWednesday){
			
			q06CPCPLastWednesday.setAprTotal(aprTotal);
			q06CPCPLastWednesday.setCountAprUht(countAprUht);
			q06CPCPLastWednesday.setCountAprWc(countAprWc);
			q06CPCPLastWednesday.setCountAprWca(countAprWca);
			q06CPCPLastWednesday.setCountAprWoc(countAprWoc);
			q06CPCPLastWednesday.setCountJanUht(countJanUht);
			q06CPCPLastWednesday.setCountJanWc(countJanWc);
			q06CPCPLastWednesday.setCountJanWca(countJanWca);
			q06CPCPLastWednesday.setCountJanWoc(countJanWoc);
            q06CPCPLastWednesday.setCountJulUht(countJulUht);
			q06CPCPLastWednesday.setCountJulWc(countJulWc);
			q06CPCPLastWednesday.setCountJulWca(countJulWca);
			q06CPCPLastWednesday.setCountJulWoc(countJulWoc);
            q06CPCPLastWednesday.setCountOctUht(countOctUht);
			q06CPCPLastWednesday.setCountOctWc(countOctWc);
			q06CPCPLastWednesday.setCountOctWca(countOctWca);
			q06CPCPLastWednesday.setCountOctWoc(countOctWoc);
            q06CPCPLastWednesday.setJanTotal(janTotal);
			q06CPCPLastWednesday.setJulyTotal(julyTotal);
            q06CPCPLastWednesday.setOctTotal(octTotal);
            
			
			return q06CPCPLastWednesday;		
		}
		
		/** 
		 * Q07a _HouseholdsServed Table -- Starts
		 **/
		private static DataBean_Old q07AHouseHoldsServed(BigInteger overAllTot,
   	         BigInteger totHhWithoutChild,
   	         BigInteger totHhWithChildAndAdults,
   	     	 BigInteger totHhWithOnlyChild,
   	     	 BigInteger totHhUnknowHhType, DataBean_Old q07AHouseHoldsServed){
			
			q07AHouseHoldsServed.setOverAllTotHouseHolds(overAllTot);
            q07AHouseHoldsServed.setTotHhWithoutChild(totHhWithoutChild);
            q07AHouseHoldsServed.setTotHhUnknownHhType(totHhUnknowHhType);
            q07AHouseHoldsServed.setTotHhWothOnlyChild(totHhWithOnlyChild);
         	q07AHouseHoldsServed.setTotHhWithChildAndAdults(totHhWithChildAndAdults);
         	
         	return q07AHouseHoldsServed;
		}
		
		/** 
     	 * Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Starts
     	 **/
     	
		private static DataBean_Old q07BPointinTimeCountHHLastWednesday(BigInteger hhJanTotal,
    	     	BigInteger hhAprTotal,
    	     	BigInteger hhJulTotal,
    	     	BigInteger hhOctTotal,
    	     	BigInteger hhCountJanWc,
    	     	BigInteger hhCountJanWca,
    	     	BigInteger hhCountJanWoc,
    	     	BigInteger hhCountJanUht,
    	     	BigInteger hhCountAprWc,
    	     	BigInteger hhCountAprWca,
    	     	BigInteger hhCountAprWoc,
    	     	BigInteger hhCountAprUht,
    	     	BigInteger hhCountJulWc,
    	     	BigInteger hhCountJulWca,
    	     	BigInteger hhCountJulWoc,
    	     	BigInteger hhCountJulUht,
    	     	BigInteger hhCountOctWc,
    	     	BigInteger hhCountOctWca,
    	     	BigInteger hhCountOctWoc,
    	     	BigInteger hhCountOctUht,
    	     	DataBean_Old q07BPointinTimeCountHHLastWednesday
    	){
			
			q07BPointinTimeCountHHLastWednesday.setHhJanTotal(hhJanTotal);
	     	q07BPointinTimeCountHHLastWednesday.setHhAprTotal(hhAprTotal);
	     	q07BPointinTimeCountHHLastWednesday.setHhJulTotal(hhJulTotal);
	     	q07BPointinTimeCountHHLastWednesday.setHhOctTotal(hhOctTotal);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJanWc(hhCountJanWc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJanWca(hhCountJanWca);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJanWoc(hhCountJanWoc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJanUht(hhCountJanUht);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountAprWc(hhCountAprWc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountAprWca(hhCountAprWca);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountAprWoc(hhCountAprWoc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountAprUht(hhCountAprUht);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJulWc(hhCountJulWc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJulWca(hhCountJulWca);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJulWoc(hhCountJulWoc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountJulUht(hhCountJulUht);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountOctWc(hhCountOctWc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountOctWca(hhCountOctWca);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountOctWoc(hhCountOctWoc);
	     	q07BPointinTimeCountHHLastWednesday.setHhCountOctUht(hhCountOctUht);
	     	
	     	return q07BPointinTimeCountHHLastWednesday;
		}
		/**
		 * "Q09a: Number of Persons Contact"  Table -- Starts
	     **/
		private static DataBean_Old q09ANumberOfPersonsContacted(BigInteger totContactedOnce,
    	     	BigInteger totContacted2to5Times,BigInteger totContacted6to9Times,
    	     	BigInteger totContacted10orMore,BigInteger totPersonsContacted,
    	     	BigInteger coFirstContactHumanHabitation,BigInteger coFirstContactNRSS,
    	     	BigInteger coFirstContactRSS,BigInteger coFirstContactPlaceMissing,
    	     	BigInteger c2to5FirstContactedHumanHabitation,BigInteger c2to5FirstContactedNRSS,
    	     	BigInteger c2to5FirstContactedRSS,BigInteger c2to5FirstContactedPlaceMissing,
    	     	BigInteger c6to9FirstContactedHumanHabitation,BigInteger c6to9FirstContactedNRSS,
    	     	BigInteger c6to9FirstContactedRSS,BigInteger c6to9FirstContactedPlaceMissing,
    	     	BigInteger c10orMoreFirstContactedHumanHabitation,BigInteger c10orMoreFirstContactedNRSS,
    	     	BigInteger c10orMoreFirstContactedRSS,BigInteger c10orMoreFirstContactedPlaceMissing,
    	     	BigInteger tpcFirstContactedHumanHabitation,BigInteger tpcFirstContactedNRSS,
    	     	BigInteger tpcFirstContacteRSS,BigInteger tpcFirstContactedPlaceMissing,
    	     	DataBean_Old q09ANumberOfPersonsContacted){
			
			q09ANumberOfPersonsContacted.setTotContactedOnce(totContactedOnce);
	     	q09ANumberOfPersonsContacted.setTotContacted2to5Times(totContacted2to5Times);
	     	q09ANumberOfPersonsContacted.setTotContacted6to9Times(totContacted6to9Times);
	     	q09ANumberOfPersonsContacted.setTotContacted10orMore(totContacted10orMore);
	     	q09ANumberOfPersonsContacted.setTotPersonsContacted(totPersonsContacted);
	     	q09ANumberOfPersonsContacted.setCoFirstContactHumanHabitation(coFirstContactHumanHabitation);
	     	q09ANumberOfPersonsContacted.setCoFirstContactNRSS(coFirstContactNRSS);
	     	q09ANumberOfPersonsContacted.setCoFirstContactRSS(coFirstContactRSS);
	     	q09ANumberOfPersonsContacted.setCoFirstContactPlaceMissing(coFirstContactPlaceMissing);
	     	q09ANumberOfPersonsContacted.setC2to5FirstContactedHumanHabitation(c2to5FirstContactedHumanHabitation);
	     	q09ANumberOfPersonsContacted.setC2to5FirstContactedNRSS(c2to5FirstContactedNRSS);
	     	q09ANumberOfPersonsContacted.setC2to5FirstContactedRSS(c2to5FirstContactedRSS);
	     	q09ANumberOfPersonsContacted.setC2to5FirstContactedPlaceMissing(c2to5FirstContactedPlaceMissing);
	     	q09ANumberOfPersonsContacted.setC6to9FirstContactedHumanHabitation(c6to9FirstContactedHumanHabitation);
	     	q09ANumberOfPersonsContacted.setC6to9FirstContactedNRSS(c6to9FirstContactedNRSS);
	     	q09ANumberOfPersonsContacted.setC6to9FirstContactedRSS(c6to9FirstContactedRSS);
	     	q09ANumberOfPersonsContacted.setC6to9FirstContactedPlaceMissing(c6to9FirstContactedPlaceMissing);
	     	q09ANumberOfPersonsContacted.setC10orMoreFirstContactedHumanHabitation(c10orMoreFirstContactedHumanHabitation);
	     	q09ANumberOfPersonsContacted.setC10orMoreFirstContactedNRSS(c10orMoreFirstContactedNRSS);
	     	q09ANumberOfPersonsContacted.setC10orMoreFirstContactedRSS(c10orMoreFirstContactedRSS);
	     	q09ANumberOfPersonsContacted.setC10orMoreFirstContactedPlaceMissing(c10orMoreFirstContactedPlaceMissing);
	     	q09ANumberOfPersonsContacted.setTpcFirstContactedHumanHabitation(tpcFirstContactedHumanHabitation);
	     	q09ANumberOfPersonsContacted.setTpcFirstContactedNRSS(tpcFirstContactedNRSS);
	     	q09ANumberOfPersonsContacted.setTpcFirstContacteRSS(tpcFirstContacteRSS);
	     	q09ANumberOfPersonsContacted.setTpcFirstContactedPlaceMissing(tpcFirstContactedPlaceMissing);
	     	
			
			return q09ANumberOfPersonsContacted;
		}
		
		/**
		 * "Q09b: Number of Persons Engaged"  Table -- Starts
	     **/
		private static DataBean_Old q09BNumberOfPersonsEngaged(
        BigInteger totEngagedAfter1Contract,
   	    BigInteger totEngagedAfter2to5Contract,
   	    BigInteger totEngagedAfter6to9Contract,
   	    BigInteger totEngagedAfter10orMoreContract,
   	    BigInteger totPersonsEngaged,
   	    BigInteger totRateOfEngagement,
   	    BigInteger engFirstContactHumanHabitation,
   	    BigInteger engFirstContactNRSS,
   	    BigInteger engFirstContactRSS,
   	    BigInteger engFirstContactPlaceMissing,
   	    BigInteger eng2to5FirstContactHumanHabitation,
   	    BigInteger eng2to5FirstContactNRSS,
   	    BigInteger eng2to5FirstContactRSS,
   	    BigInteger eng2to5FirstContactPlaceMissing,
   	    BigInteger eng6to9FirstContactHumanHabitation,
   	    BigInteger eng6to9FirstContactNRSS,
   	    BigInteger eng6to9FirstContactRSS,
   	    BigInteger eng6to9FirstContactPlaceMissing,
   	    BigInteger eng10FirstContactHumanHabitation,
   	    BigInteger eng10FirstContactNRSS,
   	    BigInteger eng10FirstContactRSS,
   	    BigInteger eng10FirstContactPlaceMissing,
   	    BigInteger tpeFirstContactHumanHabitation,
   	    BigInteger tpeFirstContactNRSS,
   	    BigInteger tpeFirstContactRSS,
   	    BigInteger tpeFirstContactPlaceMissing,
   	    BigInteger roeFirstContactHumanHabitation,
   	    BigInteger roeFirstContactNRSS,
   	    BigInteger roeFirstContactRSS,
   	    BigInteger roeFirstContactPlaceMissing,
   	    DataBean_Old q09BNumberOfPersonsEngaged
   	  ) {
   	
				q09BNumberOfPersonsEngaged.setTotEngagedAfter1Contract(totEngagedAfter1Contract);
				q09BNumberOfPersonsEngaged.setTotEngagedAfter2to5Contract(totEngagedAfter2to5Contract);
				q09BNumberOfPersonsEngaged.setTotEngagedAfter6to9Contract(totEngagedAfter6to9Contract);
				q09BNumberOfPersonsEngaged.setTotEngagedAfter10orMoreContract(totEngagedAfter10orMoreContract);
				q09BNumberOfPersonsEngaged.setTotPersonsEngaged(totPersonsEngaged);
				q09BNumberOfPersonsEngaged.setTotRateOfEngagement(totRateOfEngagement);
				q09BNumberOfPersonsEngaged.setEngFirstContactHumanHabitation(engFirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setEngFirstContactNRSS(engFirstContactNRSS);
				q09BNumberOfPersonsEngaged.setEngFirstContactRSS(engFirstContactRSS);
				q09BNumberOfPersonsEngaged.setEngFirstContactPlaceMissing(engFirstContactPlaceMissing);
				q09BNumberOfPersonsEngaged.setEng2to5FirstContactHumanHabitation(eng2to5FirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setEng2to5FirstContactNRSS(eng2to5FirstContactNRSS);
				q09BNumberOfPersonsEngaged.setEng2to5FirstContactRSS(eng2to5FirstContactRSS);
				q09BNumberOfPersonsEngaged.setEng2to5FirstContactPlaceMissing(eng2to5FirstContactPlaceMissing);
				q09BNumberOfPersonsEngaged.setEng6to9FirstContactHumanHabitation(eng6to9FirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setEng6to9FirstContactNRSS(eng6to9FirstContactNRSS);
				q09BNumberOfPersonsEngaged.setEng6to9FirstContactRSS(eng6to9FirstContactRSS);
				q09BNumberOfPersonsEngaged.setEng6to9FirstContactPlaceMissing(eng6to9FirstContactPlaceMissing);
				q09BNumberOfPersonsEngaged.setEng10FirstContactHumanHabitation(eng10FirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setEng10FirstContactNRSS(eng10FirstContactNRSS);
				q09BNumberOfPersonsEngaged.setEng10FirstContactRSS(eng10FirstContactRSS);
				q09BNumberOfPersonsEngaged.setEng10FirstContactPlaceMissing(eng10FirstContactPlaceMissing);
				q09BNumberOfPersonsEngaged.setTpeFirstContactHumanHabitation(tpeFirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setTpeFirstContactNRSS(tpeFirstContactNRSS);
				q09BNumberOfPersonsEngaged.setTpeFirstContactRSS(tpeFirstContactRSS);
				q09BNumberOfPersonsEngaged.setTpeFirstContactPlaceMissing(tpeFirstContactPlaceMissing);
				q09BNumberOfPersonsEngaged.setRoeFirstContactHumanHabitation(roeFirstContactHumanHabitation);
				q09BNumberOfPersonsEngaged.setRoeFirstContactNRSS(roeFirstContactNRSS);
				q09BNumberOfPersonsEngaged.setRoeFirstContactRSS(roeFirstContactRSS);
				q09BNumberOfPersonsEngaged.setRoeFirstContactPlaceMissing(roeFirstContactPlaceMissing);
				
				
		        return  q09BNumberOfPersonsEngaged;
       }
        
        /** 
		 * "Q10a: Gender of Adults" Table -- Ends
		 **/
        
        private static DataBean_Old q10AGenderOfAdults(BigInteger totMale,
        	   	    BigInteger totFemale,
        	   	    BigInteger totTransgenderMF,
        	   	    BigInteger totOther,
        	   	    BigInteger totDontKnowRefused,
        	   	    BigInteger totInfoMissing,
        	   	    BigInteger totSubtotal,
        	   	    BigInteger maleWOC,
        	   	    BigInteger maleWCA,
        	   	    BigInteger maleUHHT,
        	   	    BigInteger femaleWOC,
        	   	    BigInteger femaleWCA,
        	   	    BigInteger femaleUHHT,
        	   	    BigInteger transgenderMFWOC,
        	   	    BigInteger transgenderMFWCA,
        	   	    BigInteger transgenderMFUHHT,
        	   	    BigInteger otherWOC,
        	   	    BigInteger otherWCA,
        	   	    BigInteger otherUHHT,
        	   	    BigInteger dkrWOC,
        	   	    BigInteger dkrWCA,
        	   	    BigInteger dkrUHHT,
        	   	    BigInteger infomiisingWOC,
        	   	    BigInteger infomiisingWCA,
        	   	    BigInteger infomiisingUHHT,
        	   	    BigInteger subtotalWOC,
        	   	    BigInteger subtotalWCA,
        	   	    BigInteger subtotalUHHT,
        	   	    BigInteger totTransgenderFM,
        	   	    BigInteger transgenderFMWOC,
        	   	    BigInteger transgenderFMWCA,
        	   	    BigInteger transgenderFMUHHT,
        	   	    DataBean_Old q10AGenderOfAdults
        	   	    ){
        	
        	q10AGenderOfAdults.setTotMale(totMale);
			q10AGenderOfAdults.setTotFemale(totFemale);
			q10AGenderOfAdults.setTotTransgenderMF(totTransgenderMF);
			q10AGenderOfAdults.setTotOther(totOther);
			q10AGenderOfAdults.setTotDontKnowRefused(totDontKnowRefused);
			q10AGenderOfAdults.setTotInfoMissing(totInfoMissing);
			q10AGenderOfAdults.setTotSubtotal(totSubtotal);
			q10AGenderOfAdults.setMaleWOC(maleWOC);
			q10AGenderOfAdults.setMaleWCA(maleWCA);
			q10AGenderOfAdults.setMaleUHHT(maleUHHT);
			q10AGenderOfAdults.setFemaleWOC(femaleWOC);
			q10AGenderOfAdults.setFemaleWCA(femaleWCA);
			q10AGenderOfAdults.setFemaleUHHT(femaleUHHT);
			q10AGenderOfAdults.setTransgenderMFWOC(transgenderMFWOC);
			q10AGenderOfAdults.setTransgenderMFWCA(transgenderMFWCA);
			q10AGenderOfAdults.setTransgenderMFUHHT(transgenderMFUHHT);
			q10AGenderOfAdults.setOtherWOC(otherWOC);
			q10AGenderOfAdults.setOtherWCA(otherWCA);
			q10AGenderOfAdults.setOtherUHHT(otherUHHT);
			q10AGenderOfAdults.setDkrWOC(dkrWOC);
			q10AGenderOfAdults.setDkrWCA(dkrWCA);
			q10AGenderOfAdults.setDkrUHHT(dkrUHHT);
			q10AGenderOfAdults.setInfomiisingWOC(infomiisingWOC);
			q10AGenderOfAdults.setInfomiisingWCA(infomiisingWCA);
			q10AGenderOfAdults.setInfomiisingUHHT(infomiisingUHHT);
			q10AGenderOfAdults.setSubtotalWOC(subtotalWOC);
			q10AGenderOfAdults.setSubtotalWCA(subtotalWCA);
			q10AGenderOfAdults.setSubtotalUHHT(subtotalUHHT);
			q10AGenderOfAdults.setTotTransgenderFM(totTransgenderFM);
			q10AGenderOfAdults.setTransgenderFMWOC(transgenderFMWOC);
			q10AGenderOfAdults.setTransgenderFMWCA(transgenderFMWCA);
			q10AGenderOfAdults.setTransgenderFMUHHT(transgenderFMUHHT);
			
			return q10AGenderOfAdults;
        }
        
        /** 
		 * "Q10b: Gender of Children" Table -- Starts
		 **/
        private static DataBean_Old q10bGenderOfChildren( BigInteger totChildMale,
           	    BigInteger totChildFemale,BigInteger totChildTransgenderMF,
           	    BigInteger totChildOther,BigInteger totChildDontKnowRefused,
           	    BigInteger totChildInfoMissing,BigInteger totChildSubtotal,
           	    BigInteger childMaleWOC,BigInteger childMaleWCA,
           	    BigInteger childMaleUHHT,BigInteger childFemaleWOC,
           	    BigInteger childFemaleWCA,BigInteger childFemaleUHHT,
           	    BigInteger childTransgenderMFWOC,BigInteger childTransgenderMFWCA,
           	    BigInteger childTransgenderMFUHHT,BigInteger childOtherWOC,
           	    BigInteger childOtherWCA,BigInteger childOtherUHHT,
           	    BigInteger childDkrWOC,BigInteger childDkrWCA,
           	    BigInteger childDkrUHHT,BigInteger childInfomiisingWOC,
           	    BigInteger childInfomiisingWCA,BigInteger childInfomiisingUHHT,
           	    BigInteger childSubtotalWOC,BigInteger childSubtotalWCA,
           	    BigInteger childSubtotalUHHT,BigInteger totChildTransgenderFM,
           	    BigInteger childTransgenderFMWOC,BigInteger childTransgenderFMWCA,
           	    BigInteger childTransgenderFMUHHT,DataBean_Old q10bGenderOfChildren){
        	
			q10bGenderOfChildren.setTotChildMale(totChildMale);
			q10bGenderOfChildren.setTotChildFemale(totChildFemale);
			q10bGenderOfChildren.setTotChildTransgenderMF(totChildTransgenderMF);
			q10bGenderOfChildren.setTotChildOther(totChildOther);
			q10bGenderOfChildren.setTotChildDontKnowRefused(totChildDontKnowRefused);
			q10bGenderOfChildren.setTotChildInfoMissing(totChildInfoMissing);
			q10bGenderOfChildren.setTotChildSubtotal(totChildSubtotal);
			q10bGenderOfChildren.setChildMaleWOC(childMaleWOC);
			q10bGenderOfChildren.setChildMaleWCA(childMaleWCA);
			q10bGenderOfChildren.setChildMaleUHHT(childMaleUHHT);
			q10bGenderOfChildren.setChildFemaleWOC(childFemaleWOC);
			q10bGenderOfChildren.setChildFemaleWCA(childFemaleWCA);
			q10bGenderOfChildren.setChildFemaleUHHT(childFemaleUHHT);
			q10bGenderOfChildren.setChildTransgenderMFWOC(childTransgenderMFWOC);
			q10bGenderOfChildren.setChildTransgenderMFWCA(childTransgenderMFWCA);
			q10bGenderOfChildren.setChildTransgenderMFUHHT(childTransgenderMFUHHT);
			q10bGenderOfChildren.setChildOtherWOC(childOtherWOC);
			q10bGenderOfChildren.setChildOtherWCA(childOtherWCA);
			q10bGenderOfChildren.setChildOtherUHHT(childOtherUHHT);
			q10bGenderOfChildren.setChildDkrWOC(childDkrWOC);
			q10bGenderOfChildren.setChildDkrWCA(childDkrWCA);
			q10bGenderOfChildren.setChildDkrUHHT(childDkrUHHT);
			q10bGenderOfChildren.setChildInfomiisingWOC(childInfomiisingWOC);
			q10bGenderOfChildren.setChildInfomiisingWCA(childInfomiisingWCA);
			q10bGenderOfChildren.setChildInfomiisingUHHT(childInfomiisingUHHT);
			q10bGenderOfChildren.setChildSubtotalWOC(childSubtotalWOC);
			q10bGenderOfChildren.setChildSubtotalWCA(childSubtotalWCA);
			q10bGenderOfChildren.setChildSubtotalUHHT(childSubtotalUHHT);
			q10bGenderOfChildren.setTotChildTransgenderFM(totChildTransgenderFM);
			q10bGenderOfChildren.setChildTransgenderFMWOC(childTransgenderFMWOC);
			q10bGenderOfChildren.setChildTransgenderFMWCA(childTransgenderFMWCA);
			q10bGenderOfChildren.setChildTransgenderFMUHHT(childTransgenderFMUHHT);
        	return q10bGenderOfChildren;
        	
        }
        
        /**
   	     * "Q10c: Gender of Persons Missing Age Information"  Table -- Starts
	   	 */  
        private static DataBean_Old q10CGPMI( 
        	   	    BigInteger totMAIMale,BigInteger totMAIFemale,
        	   	    BigInteger totMAITransgenderMF,BigInteger totMAIOther,
        	   	    BigInteger totMAIDontKnowRefused,BigInteger totMAIInfoMissing,
        	   	    BigInteger totMAISubtotal,BigInteger maleMAIWOC,
        	   	    BigInteger maleMAIWCA,BigInteger maleMAIUHHT,
        	   	    BigInteger femaleMAIWOC,BigInteger femaleMAIWCA,
        	   	    BigInteger femaleMAIUHHT,BigInteger transgenderMFMAIWOC,
        	   	    BigInteger transgenderMFMAIWCA,BigInteger transgenderMFMAIUHHT,
        	   	    BigInteger otherMAIWOC,BigInteger otherMAIWCA,
        	   	    BigInteger otherMAIUHHT,BigInteger dkrMAIWOC,
        	   	    BigInteger dkrMAIWCA,BigInteger dkrMAIUHHT,
        	   	    BigInteger infomissingMAIWOC,BigInteger infomissingMAIWCA,
        	   	    BigInteger infomissingMAIUHHT,BigInteger subtotalMAIWOC,
        	   	    BigInteger subtotalMAIWCA,BigInteger subtotalMAIUHHT,
        	   	    BigInteger totMAITransgenderFM,BigInteger transgenderFMMAIWOC,
        	   	    BigInteger transgenderFMMAIWCA,BigInteger transgenderFMMAIUHHT,
        	   	    BigInteger transgenderFMMAIWithOnlyChild,BigInteger subtotalMAIWithOnlyChild,
        	   	    BigInteger infomissingMAIWithOnlyChild,BigInteger dkrMAIWithOnlyChild,
        	   	    BigInteger transgenderMFMAIWithOnlyChild,BigInteger otherMAIWithOnlyChild,
        	   	    BigInteger maleMAIWithOnlyChild,BigInteger femaleMAIWithOnlyChild,
        	   	    DataBean_Old q10cGenderofPersonsMissingAgeInformation
        	   	    ){
        	
			q10cGenderofPersonsMissingAgeInformation.setTotMAIMale(totMAIMale);
			q10cGenderofPersonsMissingAgeInformation.setTotMAIFemale(totMAIFemale);
			q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderMF(totMAITransgenderMF);
			q10cGenderofPersonsMissingAgeInformation.setTotMAIOther(totMAIOther);
			q10cGenderofPersonsMissingAgeInformation.setTotMAIDontKnowRefused(totMAIDontKnowRefused);
			q10cGenderofPersonsMissingAgeInformation.setTotMAIInfoMissing(totMAIInfoMissing);
			q10cGenderofPersonsMissingAgeInformation.setTotMAISubtotal(totMAISubtotal);
			q10cGenderofPersonsMissingAgeInformation.setMaleMAIWOC(maleMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setMaleMAIWCA(maleMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setMaleMAIUHHT(maleMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWOC(femaleMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWCA(femaleMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setFemaleMAIUHHT(femaleMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWOC(transgenderMFMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWCA(transgenderMFMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIUHHT(transgenderMFMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setOtherMAIWOC(otherMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setOtherMAIWCA(otherMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setOtherMAIUHHT(otherMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setDkrMAIWOC(dkrMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setDkrMAIWCA(dkrMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setDkrMAIUHHT(dkrMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWOC(infomissingMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWCA(infomissingMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIUHHT(infomissingMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWOC(subtotalMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWCA(subtotalMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIUHHT(subtotalMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setTotMAITransgenderFM(totMAITransgenderFM);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWOC(transgenderFMMAIWOC);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWCA(transgenderFMMAIWCA);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIUHHT(transgenderFMMAIUHHT);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderFMMAIWithOnlyChild(transgenderFMMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setSubtotalMAIWithOnlyChild(subtotalMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setInfomissingMAIWithOnlyChild(infomissingMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setDkrMAIWithOnlyChild(dkrMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setTransgenderMFMAIWithOnlyChild(transgenderMFMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setOtherMAIWithOnlyChild(otherMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setMaleMAIWithOnlyChild(maleMAIWithOnlyChild);
			q10cGenderofPersonsMissingAgeInformation.setFemaleMAIWithOnlyChild(femaleMAIWithOnlyChild);
			
			return q10cGenderofPersonsMissingAgeInformation;
        	
        }
        /**
   	     * "Q10c: Gender of Persons Missing Age Information"  Table -- Ends
   	    */ 
        
        
        /**
   	     * "Q11: Age"  Table -- Starts
   	    */
        private static DataBean_Old q11AgeTableBean(BigInteger totAgeUnder5, BigInteger totAge5to12,
    			BigInteger totAge13to17, BigInteger totAge18to24,
    			BigInteger totAge25to34, BigInteger totAge35to44,
    			BigInteger totAge45to54, BigInteger totAge55to61,
    			BigInteger totAge62Plus, BigInteger totAgeDKR,
    			BigInteger totAgeInfoMissing, BigInteger totOverallTotal,
    			BigInteger ageUnder5WOC, BigInteger ageUnder5WCA,
    			BigInteger ageUnder5WithOnlyChild, BigInteger ageUnder5UHHT,
    			BigInteger age5to12woc, BigInteger age5to12wca,
    			BigInteger age5to12WithOnlyChild, BigInteger age5to12uhht,
    			BigInteger age13to17woc, BigInteger age13to17wca,
    			BigInteger age13to17WithOnlyChild, BigInteger age13to17uhht,
    			BigInteger age18to24woc, BigInteger age18to24wca,
    			BigInteger age18to24WithOnlyChild, BigInteger age18to24uhht,
    			BigInteger age25to34woc, BigInteger age25to34wca,
    			BigInteger age25to34WithOnlyChild, BigInteger age25to34uhht,
    			BigInteger age35to44woc, BigInteger age35to44wca,
    			BigInteger age35to44WithOnlyChild, BigInteger age35to44uhht,
    			BigInteger age45to54woc, BigInteger age45to54wca,
    			BigInteger age45to54WithOnlyChild, BigInteger age45to54uhht,
    			BigInteger age55to61woc, BigInteger age55to61wca,
    			BigInteger age55to61WithOnlyChild, BigInteger age55to61uhht,
    			BigInteger age62PlusWOC, BigInteger age62PlusWCA,
    			BigInteger age62PlusWithOnlyChild, BigInteger age62PlusUHHT,
    			BigInteger ageDKRWOC, BigInteger ageDKRWCA,
    			BigInteger ageDKRWithOnlyChild, BigInteger ageDKRUHHT,
    			BigInteger ageInfoMissingWOC, BigInteger ageInfoMissingWCA,
    			BigInteger ageInfoMissingWithOnlyChild,
    			BigInteger ageInfoMissingUHHT, BigInteger ageOverallTotalWOC,
    			BigInteger ageOverallTotalWCA,
    			BigInteger ageOverallTotalWithOnlyChild,
    			BigInteger ageOverallTotalUHHT,
    			DataBean_Old q11AgeTableBean) {
     	
    		q11AgeTableBean.setAge13to17UHHT(age13to17uhht);
    		q11AgeTableBean.setAge13to17WCA(age13to17wca);
    		q11AgeTableBean.setAge13to17WithOnlyChild(age13to17WithOnlyChild);
    		q11AgeTableBean.setAge13to17WOC(age13to17woc);
    		q11AgeTableBean.setAge18to24UHHT(age18to24uhht);
    		q11AgeTableBean.setAge18to24WCA(age18to24wca);
    		q11AgeTableBean.setAge18to24WithOnlyChild(age18to24WithOnlyChild);
    		q11AgeTableBean.setAge18to24WOC(age18to24woc);
    		q11AgeTableBean.setAge25to34UHHT(age25to34uhht);
    		q11AgeTableBean.setAge25to34WCA(age25to34wca);
    		q11AgeTableBean.setAge25to34WithOnlyChild(age25to34WithOnlyChild);
    		q11AgeTableBean.setAge25to34WOC(age25to34woc);
    		q11AgeTableBean.setAge35to44UHHT(age35to44uhht);
    		q11AgeTableBean.setAge35to44WCA(age35to44wca);
    		q11AgeTableBean.setAge35to44WithOnlyChild(age35to44WithOnlyChild);
    		q11AgeTableBean.setAge35to44WOC(age35to44woc);
    		q11AgeTableBean.setAge45to54UHHT(age45to54uhht);
    		q11AgeTableBean.setAge45to54WCA(age45to54wca);
    		q11AgeTableBean.setAge45to54WithOnlyChild(age45to54WithOnlyChild);
    		q11AgeTableBean.setAge45to54WOC(age45to54woc);
    		q11AgeTableBean.setAge55to61UHHT(age55to61uhht);
    		q11AgeTableBean.setAge55to61WCA(age55to61wca);
    		q11AgeTableBean.setAge55to61WithOnlyChild(age55to61WithOnlyChild);
    		q11AgeTableBean.setAge55to61WOC(age55to61woc);
    		q11AgeTableBean.setAge62PlusUHHT(age62PlusUHHT);
    		q11AgeTableBean.setAge62PlusWCA(age62PlusWCA);
    		q11AgeTableBean.setAge62PlusWithOnlyChild(age62PlusWithOnlyChild);
    		q11AgeTableBean.setAge62PlusWOC(age62PlusWOC);
    		q11AgeTableBean.setAgeDKRUHHT(ageDKRUHHT);
    		q11AgeTableBean.setAgeDKRWCA(ageDKRWCA);
    		q11AgeTableBean.setAgeDKRWithOnlyChild(ageDKRWithOnlyChild);
    		q11AgeTableBean.setAgeDKRWOC(ageDKRWOC);
    		q11AgeTableBean.setAgeInfoMissingUHHT(ageInfoMissingUHHT);
    		q11AgeTableBean.setAgeInfoMissingWCA(ageInfoMissingWCA);
    		q11AgeTableBean.setAgeInfoMissingWithOnlyChild(ageInfoMissingWithOnlyChild);
    		q11AgeTableBean.setAgeInfoMissingWOC(ageInfoMissingWOC);
    		q11AgeTableBean.setAgeUnder5UHHT(ageUnder5UHHT);
    		q11AgeTableBean.setAgeUnder5WCA(ageUnder5WCA);
    		q11AgeTableBean.setAgeUnder5WithOnlyChild(ageUnder5WithOnlyChild);
    		q11AgeTableBean.setAgeUnder5WOC(ageUnder5WOC);
    		q11AgeTableBean.setAgeOverallTotalUHHT(ageOverallTotalUHHT);
    		q11AgeTableBean.setAgeOverallTotalWCA(ageOverallTotalWCA);
    		q11AgeTableBean.setAgeOverallTotalWithOnlyChild(ageOverallTotalWithOnlyChild);
    		q11AgeTableBean.setAgeOverallTotalWOC(ageOverallTotalWOC);
    		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
    		q11AgeTableBean.setTotAge13to17(totAge13to17);
    		q11AgeTableBean.setTotAge18to24(totAge18to24);
    		q11AgeTableBean.setTotAge25to34(totAge25to34);
    		q11AgeTableBean.setTotAge35to44(totAge35to44);
    		q11AgeTableBean.setTotAge45to54(totAge45to54);
    		q11AgeTableBean.setTotAge55to61(totAge55to61);
    		q11AgeTableBean.setTotAge5to12(totAge5to12);
    		q11AgeTableBean.setTotAge62Plus(totAge62Plus);
    		q11AgeTableBean.setTotAgeDKR(totAgeDKR);
    		q11AgeTableBean.setTotAgeInfoMissing(totAgeInfoMissing);
    		q11AgeTableBean.setTotAgeUnder5(totAgeUnder5);
    		q11AgeTableBean.setTotOverallTotal(totOverallTotal);
    		q11AgeTableBean.setAge5to12UHHT(age5to12uhht);
    		q11AgeTableBean.setAge5to12WCA(age5to12wca);
    		q11AgeTableBean.setAge5to12WithOnlyChild(age5to12WithOnlyChild);
    		q11AgeTableBean.setAge5to12WOC(age5to12woc);
    		
         	
         	return q11AgeTableBean;
         }
        /**
   	     * "Q11: Age"  Table -- Ends
   	    */
        
        
        /**
   	     * "Q12a: Race"  Table -- Starts
   	    */
        private static DataBean_Old q12aRaceTableBean(BigInteger q12aWhiteTotal,
        		BigInteger q12aWhiteWithoutChildren,
        		BigInteger q12aWhiteWithChildrenAndAdults,
        		BigInteger q12aWhiteWithOnlyChildren,
        		BigInteger q12aWhiteWithUnkownhouseholdtype,
        		BigInteger q12aBlckAfrnAmrnTotal,
        		BigInteger q12aBlckAfrnAmrnWithoutChildren,
        		BigInteger q12aBlckAfrnAmrnWithChildrenAndAdults,
        		BigInteger q12aBlckAfrnAmrnWithOnlyChildren,
        		BigInteger q12aBlckAfrnAmrnWithUnkownhouseholdtype,
        		BigInteger q12aAsianTotal, BigInteger q12aAsianWithoutChildren,
        		BigInteger q12aAsianWithChildrenAndAdults,
        		BigInteger q12aAsianWithOnlyChildren,
        		BigInteger q12aAsianUnkownhouseholdtype,
        		BigInteger q12aAmericanIndianTotal,
        		BigInteger q12aAmericanIndianWithoutChildren,
        		BigInteger q12aAmericanIndianWithChildrenAndAdults,
        		BigInteger q12aAmericanIndianWithOnlyChildren,
        		BigInteger q12aAmericanIndianUnkownhouseholdtype,
        		BigInteger q12aNativeHawalianTotal,
        		BigInteger q12aNativeHawalianWithoutChildren,
        		BigInteger q12aNativeHawalianWithChildrenAndAdults,
        		BigInteger q12aNativeHawalianWithOnlyChildren,
        		BigInteger q12aNativeHawalianUnkownhouseholdtype,
        		BigInteger q12aMultipleRacesTotal,
        		BigInteger q12aMultipleRacesWithoutChildren,
        		BigInteger q12aMultipleRacesWithChildrenAndAdults,
        		BigInteger q12aMultipleRacesWithOnlyChildren,
        		BigInteger q12aMultipleRacesUnkownhouseholdtype,
        		BigInteger q12aDontKnowRacesTotal,
        		BigInteger q12aDontKnowRacesWithoutChildren,
        		BigInteger q12aDontKnowRacesWithChildrenAndAdults,
        		BigInteger q12aDontKnowRacesWithOnlyChildren,
        		BigInteger q12aDontKnowRacesUnkownhouseholdtype,
        		BigInteger q12aInformationMissingTotal,
        		BigInteger q12aInformationMissingWithoutChildren,
        		BigInteger q12aInformationMissingWithChildrenAndAdults,
        		BigInteger q12aInformationMissingWithOnlyChildren,
        		BigInteger q12aInformationMissingUnkownhouseholdtype,
        		BigInteger q12aTotalSummed, BigInteger q12aTotalWithoutChildren,
        		BigInteger q12aTotalWithChildrenAndAdults,
        		BigInteger q12aTotalWithOnlyChildren,
        		BigInteger q12aTotalUnkownhouseholdtype,
        		DataBean_Old q12aRaceTableBean) {
        	
        	q12aRaceTableBean.setQ12aWhiteTotal(q12aWhiteTotal);
        	q12aRaceTableBean.setQ12aWhiteWithChildrenAndAdults(q12aWhiteWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aWhiteWithOnlyChildren(q12aWhiteWithOnlyChildren);
        	q12aRaceTableBean.setQ12aWhiteWithoutChildren(q12aWhiteWithoutChildren);
        	q12aRaceTableBean.setQ12aWhiteWithUnkownhouseholdtype(q12aWhiteWithUnkownhouseholdtype);
        	
        	q12aRaceTableBean.setQ12aBlckAfrnAmrnTotal(q12aBlckAfrnAmrnTotal);
        	q12aRaceTableBean.setQ12aBlckAfrnAmrnWithChildrenAndAdults(q12aBlckAfrnAmrnWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aBlckAfrnAmrnWithOnlyChildren(q12aBlckAfrnAmrnWithOnlyChildren);
        	q12aRaceTableBean.setQ12aBlckAfrnAmrnWithoutChildren(q12aBlckAfrnAmrnWithoutChildren);
        	q12aRaceTableBean.setQ12aBlckAfrnAmrnWithUnkownhouseholdtype(q12aBlckAfrnAmrnWithUnkownhouseholdtype);
        	
        	q12aRaceTableBean.setQ12aAsianTotal(q12aAsianTotal);
        	q12aRaceTableBean.setQ12aAsianUnkownhouseholdtype(q12aAsianUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aAsianWithChildrenAndAdults(q12aAsianWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aAsianWithOnlyChildren(q12aAsianWithOnlyChildren);
        	q12aRaceTableBean.setQ12aAsianWithoutChildren(q12aAsianWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aAmericanIndianTotal(q12aAmericanIndianTotal);
        	q12aRaceTableBean.setQ12aAmericanIndianUnkownhouseholdtype(q12aAmericanIndianUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aAmericanIndianWithChildrenAndAdults(q12aAmericanIndianWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aAmericanIndianWithOnlyChildren(q12aAmericanIndianWithOnlyChildren);
        	q12aRaceTableBean.setQ12aAmericanIndianWithoutChildren(q12aAmericanIndianWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aNativeHawalianTotal(q12aNativeHawalianTotal);
        	q12aRaceTableBean.setQ12aNativeHawalianUnkownhouseholdtype(q12aNativeHawalianUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aNativeHawalianWithChildrenAndAdults(q12aNativeHawalianWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aNativeHawalianWithOnlyChildren(q12aNativeHawalianWithOnlyChildren);
        	q12aRaceTableBean.setQ12aNativeHawalianWithoutChildren(q12aNativeHawalianWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aMultipleRacesTotal(q12aMultipleRacesTotal);
        	q12aRaceTableBean.setQ12aMultipleRacesUnkownhouseholdtype(q12aMultipleRacesUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aMultipleRacesWithChildrenAndAdults(q12aMultipleRacesWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aMultipleRacesWithOnlyChildren(q12aMultipleRacesWithOnlyChildren);
        	q12aRaceTableBean.setQ12aMultipleRacesWithoutChildren(q12aMultipleRacesWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aDontKnowRacesTotal(q12aDontKnowRacesTotal);
        	q12aRaceTableBean.setQ12aDontKnowRacesUnkownhouseholdtype(q12aDontKnowRacesUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aDontKnowRacesWithChildrenAndAdults(q12aDontKnowRacesWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aDontKnowRacesWithOnlyChildren(q12aDontKnowRacesWithOnlyChildren);
        	q12aRaceTableBean.setQ12aDontKnowRacesWithoutChildren(q12aDontKnowRacesWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aInformationMissingTotal(q12aInformationMissingTotal);
        	q12aRaceTableBean.setQ12aInformationMissingUnkownhouseholdtype(q12aInformationMissingUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aInformationMissingWithChildrenAndAdults(q12aInformationMissingWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aInformationMissingWithOnlyChildren(q12aInformationMissingWithOnlyChildren);
        	q12aRaceTableBean.setQ12aInformationMissingWithoutChildren(q12aInformationMissingWithoutChildren);
        	
        	q12aRaceTableBean.setQ12aTotalSummed(q12aTotalSummed);
        	q12aRaceTableBean.setQ12aTotalUnkownhouseholdtype(q12aTotalUnkownhouseholdtype);
        	q12aRaceTableBean.setQ12aTotalWithChildrenAndAdults(q12aTotalWithChildrenAndAdults);
        	q12aRaceTableBean.setQ12aTotalWithOnlyChildren(q12aTotalWithOnlyChildren);
        	q12aRaceTableBean.setQ12aTotalWithoutChildren(q12aTotalWithoutChildren);
        	
        	       	
         	return q12aRaceTableBean;
        }

        /**
   	     * "Q12a: Race"  Table -- Ends
   	    */
        
        public static DataBean_Old q12bEthnicityTableBean(BigInteger q12bNonHispanicTotal,
    			BigInteger q12bNonHispanicWithoutChildren,
    			BigInteger q12bNonHispanicWithChildrenAndAdults,
    			BigInteger q12bNonHispanicWithOnlyChildren,
    			BigInteger q12bNonHispanicUnknownhouseholdtype,
    			BigInteger q12bHispanicTotal,
    			BigInteger q12bHispanicWithoutChildren,
    			BigInteger q12bHispanicWithChildrenAndAdults,
    			BigInteger q12bHispanicWithOnlyChildren,
    			BigInteger q12bHispanicUnknownhouseholdtype,
    			BigInteger q12bDontKnowRacesTotal,
    			BigInteger q12bDontKnowRacesWithoutChildren,
    			BigInteger q12bDontKnowRacesWithChildrenAndAdults,
    			BigInteger q12bDontKnowRacesWithOnlyChildren,
    			BigInteger q12bDontKnowRacesUnkownhouseholdtype,
    			BigInteger q12bInformationMissingTotal,
    			BigInteger q12bInformationMissingWithoutChildren,
    			BigInteger q12bInformationMissingWithChildrenAndAdults,
    			BigInteger q12bInformationMissingWithOnlyChildren,
    			BigInteger q12bInformationMissingUnkownhouseholdtype,
    			BigInteger q12bTotalSummed, BigInteger q12bTotalWithoutChildren,
    			BigInteger q12bTotalWithChildrenAndAdults,
    			BigInteger q12bTotalWithOnlyChildren,
    			BigInteger q12bTotalUnkownhouseholdtype,
    			DataBean_Old q12bEthnicityTableBean) {
        		
        		q12bEthnicityTableBean.setQ12bNonHispanicTotal(q12bNonHispanicTotal);
        		q12bEthnicityTableBean.setQ12bNonHispanicWithoutChildren(q12bNonHispanicWithoutChildren);
        		q12bEthnicityTableBean.setQ12bNonHispanicWithChildrenAndAdults(q12bNonHispanicWithChildrenAndAdults);
        		q12bEthnicityTableBean.setQ12bNonHispanicWithOnlyChildren(q12bNonHispanicWithOnlyChildren);
        		q12bEthnicityTableBean.setQ12bNonHispanicUnknownhouseholdtype(q12bNonHispanicUnknownhouseholdtype);
        
        		q12bEthnicityTableBean.setQ12bHispanicTotal(q12bHispanicTotal);
        		q12bEthnicityTableBean.setQ12bHispanicWithoutChildren(q12bHispanicWithoutChildren);
        		q12bEthnicityTableBean.setQ12bHispanicWithChildrenAndAdults(q12bHispanicWithChildrenAndAdults);
        		q12bEthnicityTableBean.setQ12bHispanicWithOnlyChildren(q12bHispanicWithOnlyChildren);
        		q12bEthnicityTableBean.setQ12bHispanicUnknownhouseholdtype(q12bHispanicUnknownhouseholdtype);
        
        		q12bEthnicityTableBean.setQ12bDontKnowRacesTotal(q12bDontKnowRacesTotal);
        		q12bEthnicityTableBean.setQ12bDontKnowRacesWithoutChildren(q12bDontKnowRacesWithoutChildren);
        		q12bEthnicityTableBean.setQ12bDontKnowRacesWithChildrenAndAdults(q12bDontKnowRacesWithChildrenAndAdults);
        		q12bEthnicityTableBean.setQ12bDontKnowRacesWithOnlyChildren(q12bDontKnowRacesWithOnlyChildren);
        		q12bEthnicityTableBean.setQ12bDontKnowRacesUnkownhouseholdtype(q12bDontKnowRacesUnkownhouseholdtype);
        
        		q12bEthnicityTableBean.setQ12bInformationMissingTotal(q12bInformationMissingTotal);
        		q12bEthnicityTableBean.setQ12bInformationMissingWithoutChildren(q12bInformationMissingWithoutChildren);
        		q12bEthnicityTableBean.setQ12bInformationMissingWithChildrenAndAdults(q12bInformationMissingWithChildrenAndAdults);
        		q12bEthnicityTableBean.setQ12bInformationMissingWithOnlyChildren(q12bInformationMissingWithOnlyChildren);
        		q12bEthnicityTableBean.setQ12bInformationMissingUnkownhouseholdtype(q12bInformationMissingUnkownhouseholdtype);
        
        		q12bEthnicityTableBean.setQ12bTotalSummed(q12bTotalSummed);
        		q12bEthnicityTableBean.setQ12bTotalWithoutChildren(q12bTotalWithoutChildren);
        		q12bEthnicityTableBean.setQ12bTotalWithChildrenAndAdults(q12bTotalWithChildrenAndAdults);
        		q12bEthnicityTableBean.setQ12bTotalWithOnlyChildren(q12bTotalWithOnlyChildren);
        		q12bEthnicityTableBean.setQ12bTotalUnkownhouseholdtype(q12bTotalUnkownhouseholdtype);
        
        return q12bEthnicityTableBean;
        }
        
        /**
    	 *  "Q13a1: Physical and Mental Health Conditions at Entry" Table -- Starts
    	 * */
        public static DataBean_Old q13a1PhysicalMntlHealthCondTableBean(
    			BigInteger q13a1MentalIllnessTotal,
    			BigInteger q13a1MentalIllnessWithoutChildren,
    			BigInteger q13a1MentalIllnessWithChildAndAdults,
    			BigInteger q13a1MentalIllnessWithOnlychildren,
    			BigInteger q13a1MentalIllnessUnknowHousehold,
    			BigInteger q13a1AlcoholAbuseTotal,
    			BigInteger q13a1AlcoholAbuseWithoutChildren,
    			BigInteger q13a1AlcoholAbuseWithChildAndAdults,
    			BigInteger q13a1AlcoholAbuseWithOnlychildren,
    			BigInteger q13a1AlcoholAbuseUnknowHousehold,
    			BigInteger q13a1DrugAbuseTotal,
    			BigInteger q13a1DrugAbuseWithoutChildren,
    			BigInteger q13a1DrugAbuseWithChildAndAdults,
    			BigInteger q13a1DrugAbuseWithOnlychildren,
    			BigInteger q13a1DrugAbuseUnknowHousehold,
    			BigInteger q13a1BothAlcoholAndDrugAbuseTotal,
    			BigInteger q13a1BothAlcoholAndDrugAbuseWithoutChildren,
    			BigInteger q13a1BothAlcoholAndDrugAbuseWithChildAndAdults,
    			BigInteger q13a1BothAlcoholAndDrugAbuseWithOnlychildren,
    			BigInteger q13a1BothAlcoholAndDrugAbuseUnknowHousehold,
    			BigInteger q13a1ChronicHealthConditionTotal,
    			BigInteger q13a1ChronicHealthConditionWithoutChildren,
    			BigInteger q13a1ChronicHealthConditionWithChildAndAdults,
    			BigInteger q13a1ChronicHealthConditionWithOnlychildren,
    			BigInteger q13a1ChronicHealthConditionUnknowHousehold,
    			BigInteger q13a1HIVRelatedDiseasesTotal,
    			BigInteger q13a1HIVRelatedDiseasesWithoutChildren,
    			BigInteger q13a1HIVRelatedDiseasesWithChildAndAdults,
    			BigInteger q13a1HIVRelatedDiseasesWithOnlychildren,
    			BigInteger q13a1HIVRelatedDiseasesUnknowHousehold,
    			BigInteger q13a1DevelopmentalDisabilityTotal,
    			BigInteger q13a1DevelopmentalDisabilityWithoutChildren,
    			BigInteger q13a1DevelopmentalDisabilityWithChildAndAdults,
    			BigInteger q13a1DevelopmentalDisabilityWithOnlychildren,
    			BigInteger q13a1DevelopmentalDisabilityUnknowHousehold,
    			BigInteger q13a1PhysicalDisabilityTotal,
    			BigInteger q13a1PhysicalDisabilityWithoutChildren,
    			BigInteger q13a1PhysicalDisabilityWithChildAndAdults,
    			BigInteger q13a1PhysicalDisabilityWithOnlychildren,
    			BigInteger q13a1PhysicalDisabilityUnknowHousehold,
    			DataBean_Old q13a1PhysicalMntlHealthCondTableBean) {
    		
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessTotal(q13a1MentalIllnessTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithoutChildren(q13a1MentalIllnessWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithChildAndAdults(q13a1MentalIllnessWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessWithOnlychildren(q13a1MentalIllnessWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1MentalIllnessUnknowHousehold(q13a1MentalIllnessUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseTotal(q13a1AlcoholAbuseTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithoutChildren(q13a1AlcoholAbuseWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithChildAndAdults(q13a1AlcoholAbuseWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseWithOnlychildren(q13a1AlcoholAbuseWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1AlcoholAbuseUnknowHousehold(q13a1AlcoholAbuseUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseTotal(q13a1DrugAbuseTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithoutChildren(q13a1DrugAbuseWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithChildAndAdults(q13a1DrugAbuseWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseWithOnlychildren(q13a1DrugAbuseWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DrugAbuseUnknowHousehold(q13a1DrugAbuseUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseTotal(q13a1BothAlcoholAndDrugAbuseTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithoutChildren(q13a1BothAlcoholAndDrugAbuseWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults(q13a1BothAlcoholAndDrugAbuseWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseWithOnlychildren(q13a1BothAlcoholAndDrugAbuseWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1BothAlcoholAndDrugAbuseUnknowHousehold(q13a1BothAlcoholAndDrugAbuseUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionTotal(q13a1ChronicHealthConditionTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithoutChildren(q13a1ChronicHealthConditionWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithChildAndAdults(q13a1ChronicHealthConditionWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionWithOnlychildren(q13a1ChronicHealthConditionWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1ChronicHealthConditionUnknowHousehold(q13a1ChronicHealthConditionUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesTotal(q13a1HIVRelatedDiseasesTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithoutChildren(q13a1HIVRelatedDiseasesWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithOnlychildren(q13a1HIVRelatedDiseasesWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesWithChildAndAdults(q13a1HIVRelatedDiseasesWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1HIVRelatedDiseasesUnknowHousehold(q13a1HIVRelatedDiseasesUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityTotal(q13a1DevelopmentalDisabilityTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithoutChildren(q13a1DevelopmentalDisabilityWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithChildAndAdults(q13a1DevelopmentalDisabilityWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityWithOnlychildren(q13a1DevelopmentalDisabilityWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1DevelopmentalDisabilityUnknowHousehold(q13a1DevelopmentalDisabilityUnknowHousehold);
        	
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityTotal(q13a1PhysicalDisabilityTotal);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithoutChildren(q13a1PhysicalDisabilityWithoutChildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithChildAndAdults(q13a1PhysicalDisabilityWithChildAndAdults);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityWithOnlychildren(q13a1PhysicalDisabilityWithOnlychildren);
        	q13a1PhysicalMntlHealthCondTableBean.setQ13a1PhysicalDisabilityUnknowHousehold(q13a1PhysicalDisabilityUnknowHousehold);
        	
        	return q13a1PhysicalMntlHealthCondTableBean;
        }
    	
        public static DataBean_Old q13a2NumberofConditioinsTableBean(BigInteger q13a2NoneTotal,
    			BigInteger q13a2NoneWithoutChildren,
    			BigInteger q13a2NoneWithChildAndAdults,
    			BigInteger q13a2NoneWithOnlychildren,
    			BigInteger q13a2NoneUnknowHousehold,
    			BigInteger q13a2Condition1Total,
    			BigInteger q13a2Condition1WithoutChildren,
    			BigInteger q13a2Condition1WithChildAndAdults,
    			BigInteger q13a2Condition1WithOnlychildren,
    			BigInteger q13a2Condition1UnknowHousehold,
    			BigInteger q13a2Condition2Total,
    			BigInteger q13a2Condition2WithoutChildren,
    			BigInteger q13a2Condition2WithChildAndAdults,
    			BigInteger q13a2Condition2WithOnlychildren,
    			BigInteger q13a2Condition2UnknowHousehold,
    			BigInteger q13a2Condition3PlusTotal,
    			BigInteger q13a2Condition3PlusWithoutChildren,
    			BigInteger q13a2Condition3PlusWithChildAndAdults,
    			BigInteger q13a2Condition3PlusWithOnlychildren,
    			BigInteger q13a2Condition3PlusUnknowHousehold,
    			BigInteger q13a2ConditionUnknownTotal,
    			BigInteger q13a2ConditionUnknownWithoutChildren,
    			BigInteger q13a2ConditionUnknownWithChildAndAdults,
    			BigInteger q13a2ConditionUnknownWithOnlychildren,
    			BigInteger q13a2ConditionUnknownUnknowHousehold,
    			BigInteger q13a2DontKnowRefusedTotal,
    			BigInteger q13a2DontKnowRefusedWithoutChildren,
    			BigInteger q13a2DontKnowRefusedWithChildAndAdults,
    			BigInteger q13a2DontKnowRefusedWithOnlychildren,
    			BigInteger q13a2DontKnowRefusedUnknowHousehold,
    			BigInteger q13a2InformationmissingTotal,
    			BigInteger q13a2InformationmissingWithoutChildren,
    			BigInteger q13a2InformationmissingWithChildAndAdults,
    			BigInteger q13a2InformationmissingWithOnlychildren,
    			BigInteger q13a2InformationmissingUnknowHousehold,
    			BigInteger q13a2TotalSummed, BigInteger q13a2TotalWithoutChildren,
    			BigInteger q13a2TotalWithChildAndAdults,
    			BigInteger q13a2TotalWithOnlychildren,
    			BigInteger q13a2TotalUnknowHousehold,
    			DataBean_Old q13a2NumberofConditioinsTableBean) {
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2NoneTotal(q13a2NoneTotal);
        	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithoutChildren(q13a2NoneWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithChildAndAdults(q13a2NoneWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2NoneWithOnlychildren(q13a2NoneWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2NoneUnknowHousehold(q13a2NoneUnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition1Total(q13a2Condition1Total);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithoutChildren(q13a2Condition1WithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithChildAndAdults(q13a2Condition1WithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition1WithOnlychildren(q13a2Condition1WithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition1UnknowHousehold(q13a2Condition1UnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition2Total(q13a2Condition2Total);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithoutChildren(q13a2Condition2WithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithChildAndAdults(q13a2Condition2WithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition2WithOnlychildren(q13a2Condition2WithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition2UnknowHousehold(q13a2Condition2UnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusTotal(q13a2Condition3PlusTotal);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithoutChildren(q13a2Condition3PlusWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithChildAndAdults(q13a2Condition3PlusWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusWithOnlychildren(q13a2Condition3PlusWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2Condition3PlusUnknowHousehold(q13a2Condition3PlusUnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownTotal(q13a2ConditionUnknownTotal);
        	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithoutChildren(q13a2ConditionUnknownWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithChildAndAdults(q13a2ConditionUnknownWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownWithOnlychildren(q13a2ConditionUnknownWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2ConditionUnknownUnknowHousehold(q13a2ConditionUnknownUnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedTotal(q13a2DontKnowRefusedTotal);
        	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithoutChildren(q13a2DontKnowRefusedWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithChildAndAdults(q13a2DontKnowRefusedWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedWithOnlychildren(q13a2DontKnowRefusedWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2DontKnowRefusedUnknowHousehold(q13a2DontKnowRefusedUnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingTotal(q13a2InformationmissingTotal);
        	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithoutChildren(q13a2InformationmissingWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithChildAndAdults(q13a2InformationmissingWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingWithOnlychildren(q13a2InformationmissingWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2InformationmissingUnknowHousehold(q13a2InformationmissingUnknowHousehold);
        	
        	q13a2NumberofConditioinsTableBean.setQ13a2TotalSummed(q13a2TotalSummed);
        	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithoutChildren(q13a2TotalWithoutChildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithChildAndAdults(q13a2TotalWithChildAndAdults);
        	q13a2NumberofConditioinsTableBean.setQ13a2TotalWithOnlychildren(q13a2TotalWithOnlychildren);
        	q13a2NumberofConditioinsTableBean.setQ13a2TotalUnknowHousehold(q13a2TotalUnknowHousehold);
        	
        	return q13a2NumberofConditioinsTableBean;
    		
    	}
        
        
        public static DataBean_Old q13b1PhysicalAndMentalHealthConditionsAtExitTableBean(
    			BigInteger q13b1MentalIllnessTotal,
    			BigInteger q13b1MentalIllnessWithoutChildren,
    			BigInteger q13b1MentalIllnessWithChildAndAdults,
    			BigInteger q13b1MentalIllnessWithOnlychildren,
    			BigInteger q13b1MentalIllnessUnknowHousehold,
    			BigInteger q13b1AlcoholAbuseTotal,
    			BigInteger q13b1AlcoholAbuseWithoutChildren,
    			BigInteger q13b1AlcoholAbuseWithChildAndAdults,
    			BigInteger q13b1AlcoholAbuseWithOnlychildren,
    			BigInteger q13b1AlcoholAbuseUnknowHousehold,
    			BigInteger q13b1DrugAbuseTotal,
    			BigInteger q13b1DrugAbuseWithoutChildren,
    			BigInteger q13b1DrugAbuseWithChildAndAdults,
    			BigInteger q13b1DrugAbuseWithOnlychildren,
    			BigInteger q13b1DrugAbuseUnknowHousehold,
    			BigInteger q13b1BothAlcoholAndDrugAbuseTotal,
    			BigInteger q13b1BothAlcoholAndDrugAbuseWithoutChildren,
    			BigInteger q13b1BothAlcoholAndDrugAbuseWithChildAndAdults,
    			BigInteger q13b1BothAlcoholAndDrugAbuseWithOnlychildren,
    			BigInteger q13b1BothAlcoholAndDrugAbuseUnknowHousehold,
    			BigInteger q13b1ChronicHealthConditionTotal,
    			BigInteger q13b1ChronicHealthConditionWithoutChildren,
    			BigInteger q13b1ChronicHealthConditionWithChildAndAdults,
    			BigInteger q13b1ChronicHealthConditionWithOnlychildren,
    			BigInteger q13b1ChronicHealthConditionUnknowHousehold,
    			BigInteger q13b1hivRelatedDiseasesTotal,
    			BigInteger q13b1hivRelatedDiseasesWithoutChildren,
    			BigInteger q13b1hivRelatedDiseasesWithChildAndAdults,
    			BigInteger q13b1hivRelatedDiseasesWithOnlychildren,
    			BigInteger q13b1hivRelatedDiseasesUnknowHousehold,
    			BigInteger q13b1DevelopmentalDisabilityTotal,
    			BigInteger q13b1DevelopmentalDisabilityWithoutChildren,
    			BigInteger q13b1DevelopmentalDisabilityWithChildAndAdults,
    			BigInteger q13b1DevelopmentalDisabilityWithOnlychildren,
    			BigInteger q13b1DevelopmentalDisabilityUnknowHousehold,
    			BigInteger q13b1PhysicalDisabilityTotal,
    			BigInteger q13b1PhysicalDisabilityWithoutChildren,
    			BigInteger q13b1PhysicalDisabilityWithChildAndAdults,
    			BigInteger q13b1PhysicalDisabilityWithOnlychildren,
    			BigInteger q13b1PhysicalDisabilityUnknowHousehold,
    			DataBean_Old q13b1PhysicalAndMentalHealthConditionsAtExitTableBean) {
    	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessTotal(q13b1MentalIllnessTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithoutChildren(q13b1MentalIllnessWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithChildAndAdults(q13b1MentalIllnessWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessWithChildAndAdults(q13b1MentalIllnessWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1MentalIllnessUnknowHousehold(q13b1MentalIllnessUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseTotal(q13b1AlcoholAbuseTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithoutChildren(q13b1AlcoholAbuseWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithChildAndAdults(q13b1AlcoholAbuseWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseWithOnlychildren(q13b1AlcoholAbuseWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1AlcoholAbuseUnknowHousehold(q13b1AlcoholAbuseUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseTotal(q13b1DrugAbuseTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithoutChildren(q13b1DrugAbuseWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithChildAndAdults(q13b1DrugAbuseWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseWithOnlychildren(q13b1DrugAbuseWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DrugAbuseUnknowHousehold(q13b1DrugAbuseUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseTotal(q13b1BothAlcoholAndDrugAbuseTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithoutChildren(q13b1BothAlcoholAndDrugAbuseWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithChildAndAdults(q13b1BothAlcoholAndDrugAbuseWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseWithOnlychildren(q13b1BothAlcoholAndDrugAbuseWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1BothAlcoholAndDrugAbuseUnknowHousehold(q13b1BothAlcoholAndDrugAbuseUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionTotal(q13b1ChronicHealthConditionTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithoutChildren(q13b1ChronicHealthConditionWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithChildAndAdults(q13b1ChronicHealthConditionWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionWithOnlychildren(q13b1ChronicHealthConditionWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1ChronicHealthConditionUnknowHousehold(q13b1ChronicHealthConditionUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesTotal(q13b1hivRelatedDiseasesTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithoutChildren(q13b1hivRelatedDiseasesWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithChildAndAdults(q13b1hivRelatedDiseasesWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesWithOnlychildren(q13b1hivRelatedDiseasesWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1HIVRelatedDiseasesUnknowHousehold(q13b1hivRelatedDiseasesUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityTotal(q13b1DevelopmentalDisabilityTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithoutChildren(q13b1DevelopmentalDisabilityWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithChildAndAdults(q13b1DevelopmentalDisabilityWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityWithOnlychildren(q13b1DevelopmentalDisabilityWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1DevelopmentalDisabilityUnknowHousehold(q13b1DevelopmentalDisabilityUnknowHousehold);
        	
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityTotal(q13b1PhysicalDisabilityTotal);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithoutChildren(q13b1PhysicalDisabilityWithoutChildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithChildAndAdults(q13b1PhysicalDisabilityWithChildAndAdults);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityWithOnlychildren(q13b1PhysicalDisabilityWithOnlychildren);
        	q13b1PhysicalAndMentalHealthConditionsAtExitTableBean.setQ13b1PhysicalDisabilityUnknowHousehold(q13b1PhysicalDisabilityUnknowHousehold);
        	
        	return q13b1PhysicalAndMentalHealthConditionsAtExitTableBean;
    	}
        
        public static DataBean_Old q13b2NumberOfConditionsAtExitTableBean(BigInteger q13b2NoneTotal,
    			BigInteger q13b2NoneWithoutChildren,
    			BigInteger q13b2NoneWithChildAndAdults,
    			BigInteger q13b2NoneWithOnlychildren,
    			BigInteger q13b2NoneUnknowHousehold,
    			BigInteger q13b2Condition1Total,
    			BigInteger q13b2Condition1WithoutChildren,
    			BigInteger q13b2Condition1WithChildAndAdults,
    			BigInteger q13b2Condition1WithOnlychildren,
    			BigInteger q13b2Condition1UnknowHousehold,
    			BigInteger q13b2Condition2Total,
    			BigInteger q13b2Condition2WithoutChildren,
    			BigInteger q13b2Condition2WithChildAndAdults,
    			BigInteger q13b2Condition2WithOnlychildren,
    			BigInteger q13b2Condition2UnknowHousehold,
    			BigInteger q13b2Condition3PlusTotal,
    			BigInteger q13b2Condition3PlusWithoutChildren,
    			BigInteger q13b2Condition3PlusWithChildAndAdults,
    			BigInteger q13b2Condition3PlusWithOnlychildren,
    			BigInteger q13b2Condition3PlusUnknowHousehold,
    			BigInteger q13b2ConditionUnknownTotal,
    			BigInteger q13b2ConditionUnknownWithoutChildren,
    			BigInteger q13b2ConditionUnknownWithChildAndAdults,
    			BigInteger q13b2ConditionUnknownWithOnlychildren,
    			BigInteger q13b2ConditionUnknownUnknowHousehold,
    			BigInteger q13b2DontKnowRefusedTotal,
    			BigInteger q13b2DontKnowRefusedWithoutChildren,
    			BigInteger q13b2DontKnowRefusedWithChildAndAdults,
    			BigInteger q13b2DontKnowRefusedWithOnlychildren,
    			BigInteger q13b2DontKnowRefusedUnknowHousehold,
    			BigInteger q13b2InformationmissingTotal,
    			BigInteger q13b2InformationmissingWithoutChildren,
    			BigInteger q13b2InformationmissingWithChildAndAdults,
    			BigInteger q13b2InformationmissingWithOnlychildren,
    			BigInteger q13b2InformationmissingUnknowHousehold,
    			BigInteger q13b2TotalSummed, BigInteger q13b2TotalWithoutChildren,
    			BigInteger q13b2TotalWithChildAndAdults,
    			BigInteger q13b2TotalWithOnlychildren,
    			BigInteger q13b2TotalUnknowHousehold,
    			DataBean_Old q13b2NumberOfConditionsAtExitTableBean) {
    		
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneTotal(q13b2NoneTotal);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithoutChildren(q13b2NoneWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithChildAndAdults(q13b2NoneWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneWithOnlychildren(q13b2NoneWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2NoneUnknowHousehold(q13b2NoneUnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1Total(q13b2Condition1Total);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithoutChildren(q13b2Condition1WithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithChildAndAdults(q13b2Condition1WithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1WithOnlychildren(q13b2Condition1WithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition1UnknowHousehold(q13b2Condition1UnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2Total(q13b2Condition2Total);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithoutChildren(q13b2Condition2WithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithChildAndAdults(q13b2Condition2WithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2WithOnlychildren(q13b2Condition2WithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition2UnknowHousehold(q13b2Condition2UnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusTotal(q13b2Condition3PlusTotal);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithoutChildren(q13b2Condition3PlusWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithChildAndAdults(q13b2Condition3PlusWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusWithOnlychildren(q13b2Condition3PlusWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2Condition3PlusUnknowHousehold(q13b2Condition3PlusUnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownTotal(q13b2ConditionUnknownTotal);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithoutChildren(q13b2ConditionUnknownWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithChildAndAdults(q13b2ConditionUnknownWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownWithOnlychildren(q13b2ConditionUnknownWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2ConditionUnknownUnknowHousehold(q13b2ConditionUnknownUnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedTotal(q13b2DontKnowRefusedTotal);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithoutChildren(q13b2DontKnowRefusedWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithChildAndAdults(q13b2DontKnowRefusedWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedWithOnlychildren(q13b2DontKnowRefusedWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2DontKnowRefusedUnknowHousehold(q13b2DontKnowRefusedUnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingTotal(q13b2InformationmissingTotal);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithoutChildren(q13b2InformationmissingWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithChildAndAdults(q13b2InformationmissingWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingWithOnlychildren(q13b2InformationmissingWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2InformationmissingUnknowHousehold(q13b2InformationmissingUnknowHousehold);
        	
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalSummed(q13b2TotalSummed);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithoutChildren(q13b2TotalWithoutChildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithChildAndAdults(q13b2TotalWithChildAndAdults);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalWithOnlychildren(q13b2TotalWithOnlychildren);
        	q13b2NumberOfConditionsAtExitTableBean.setQ13b2TotalUnknowHousehold(q13b2TotalUnknowHousehold);
        	        	
        	
        	return q13b2NumberOfConditionsAtExitTableBean;
    	}
        
        public static DataBean_Old q13c1PhysicalAndMentalHealthConditionsForStayerTableBean(
    			BigInteger q13c1MentalIllnessTotal,
    			BigInteger q13c1MentalIllnessWithoutChildren,
    			BigInteger q13c1MentalIllnessWithChildAndAdults,
    			BigInteger q13c1MentalIllnessWithOnlychildren,
    			BigInteger q13c1MentalIllnessUnknowHousehold,
    			BigInteger q13c1AlcoholAbuseTotal,
    			BigInteger q13c1AlcoholAbuseWithoutChildren,
    			BigInteger q13c1AlcoholAbuseWithChildAndAdults,
    			BigInteger q13c1AlcoholAbuseWithOnlychildren,
    			BigInteger q13c1AlcoholAbuseUnknowHousehold,
    			BigInteger q13c1DrugAbuseTotal,
    			BigInteger q13c1DrugAbuseWithoutChildren,
    			BigInteger q13c1DrugAbuseWithChildAndAdults,
    			BigInteger q13c1DrugAbuseWithOnlychildren,
    			BigInteger q13c1DrugAbuseUnknowHousehold,
    			BigInteger q13c1BothAlcoholAndDrugAbuseTotal,
    			BigInteger q13c1BothAlcoholAndDrugAbuseWithoutChildren,
    			BigInteger q13c1BothAlcoholAndDrugAbuseWithChildAndAdults,
    			BigInteger q13c1BothAlcoholAndDrugAbuseWithOnlychildren,
    			BigInteger q13c1BothAlcoholAndDrugAbuseUnknowHousehold,
    			BigInteger q13c1ChronicHealthConditionTotal,
    			BigInteger q13c1ChronicHealthConditionWithoutChildren,
    			BigInteger q13c1ChronicHealthConditionWithChildAndAdults,
    			BigInteger q13c1ChronicHealthConditionWithOnlychildren,
    			BigInteger q13c1ChronicHealthConditionUnknowHousehold,
    			BigInteger q13c1hivRelatedDiseasesTotal,
    			BigInteger q13c1hivRelatedDiseasesWithoutChildren,
    			BigInteger q13c1hivRelatedDiseasesWithChildAndAdults,
    			BigInteger q13c1hivRelatedDiseasesWithOnlychildren,
    			BigInteger q13c1hivRelatedDiseasesUnknowHousehold,
    			BigInteger q13c1DevelopmentalDisabilityTotal,
    			BigInteger q13c1DevelopmentalDisabilityWithoutChildren,
    			BigInteger q13c1DevelopmentalDisabilityWithChildAndAdults,
    			BigInteger q13c1DevelopmentalDisabilityWithOnlychildren,
    			BigInteger q13c1DevelopmentalDisabilityUnknowHousehold,
    			BigInteger q13c1PhysicalDisabilityTotal,
    			BigInteger q13c1PhysicalDisabilityWithoutChildren,
    			BigInteger q13c1PhysicalDisabilityWithChildAndAdults,
    			BigInteger q13c1PhysicalDisabilityWithOnlychildren,
    			BigInteger q13c1PhysicalDisabilityUnknowHousehold,
    			DataBean_Old q13c1PhysicalAndMentalHealthConditionsForStayerTableBean) {
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1MentalIllnessTotal(q13c1MentalIllnessTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1MentalIllnessWithoutChildren(q13c1MentalIllnessWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1MentalIllnessWithChildAndAdults(q13c1MentalIllnessWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1MentalIllnessWithOnlychildren(q13c1MentalIllnessWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1MentalIllnessUnknowHousehold(q13c1MentalIllnessUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1AlcoholAbuseTotal(q13c1AlcoholAbuseTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1AlcoholAbuseWithoutChildren(q13c1AlcoholAbuseWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1AlcoholAbuseWithChildAndAdults(q13c1AlcoholAbuseWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1AlcoholAbuseWithOnlychildren(q13c1AlcoholAbuseWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1AlcoholAbuseUnknowHousehold(q13c1AlcoholAbuseUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DrugAbuseTotal(q13c1DrugAbuseTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DrugAbuseWithoutChildren(q13c1DrugAbuseWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DrugAbuseWithChildAndAdults(q13c1DrugAbuseWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DrugAbuseWithOnlychildren(q13c1DrugAbuseWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DrugAbuseUnknowHousehold(q13c1DrugAbuseUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1BothAlcoholAndDrugAbuseTotal(q13c1BothAlcoholAndDrugAbuseTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1BothAlcoholAndDrugAbuseWithoutChildren(q13c1BothAlcoholAndDrugAbuseWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1BothAlcoholAndDrugAbuseWithChildAndAdults(q13c1BothAlcoholAndDrugAbuseWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1BothAlcoholAndDrugAbuseWithOnlychildren(q13c1BothAlcoholAndDrugAbuseWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1BothAlcoholAndDrugAbuseUnknowHousehold(q13c1BothAlcoholAndDrugAbuseUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1ChronicHealthConditionTotal(q13c1ChronicHealthConditionTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1ChronicHealthConditionWithoutChildren(q13c1ChronicHealthConditionWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1ChronicHealthConditionWithChildAndAdults(q13c1ChronicHealthConditionWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1ChronicHealthConditionWithOnlychildren(q13c1ChronicHealthConditionWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1ChronicHealthConditionUnknowHousehold(q13c1ChronicHealthConditionUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1HIVRelatedDiseasesTotal(q13c1hivRelatedDiseasesTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1HIVRelatedDiseasesWithoutChildren(q13c1hivRelatedDiseasesWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1HIVRelatedDiseasesWithChildAndAdults(q13c1hivRelatedDiseasesWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1HIVRelatedDiseasesWithOnlychildren(q13c1hivRelatedDiseasesWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1HIVRelatedDiseasesUnknowHousehold(q13c1hivRelatedDiseasesUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DevelopmentalDisabilityTotal(q13c1DevelopmentalDisabilityTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DevelopmentalDisabilityWithoutChildren(q13c1DevelopmentalDisabilityWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DevelopmentalDisabilityWithChildAndAdults(q13c1DevelopmentalDisabilityWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DevelopmentalDisabilityWithOnlychildren(q13c1DevelopmentalDisabilityWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1DevelopmentalDisabilityUnknowHousehold(q13c1DevelopmentalDisabilityUnknowHousehold);
        	
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1PhysicalDisabilityTotal(q13c1PhysicalDisabilityTotal);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1PhysicalDisabilityWithoutChildren(q13c1PhysicalDisabilityWithoutChildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1PhysicalDisabilityWithChildAndAdults(q13c1PhysicalDisabilityWithChildAndAdults);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1PhysicalDisabilityWithOnlychildren(q13c1PhysicalDisabilityWithOnlychildren);
        	q13c1PhysicalAndMentalHealthConditionsForStayerTableBean.setQ13c1PhysicalDisabilityUnknowHousehold(q13c1PhysicalDisabilityUnknowHousehold);
        	
    		
        	return q13c1PhysicalAndMentalHealthConditionsForStayerTableBean;
    	}
    	
    	
    	public static DataBean_Old q13c2NumberOfConditionForStayersTableBean(BigInteger q13c2NoneTotal,
    			BigInteger q13c2NoneWithoutChildren,
    			BigInteger q13c2NoneWithChildAndAdults,
    			BigInteger q13c2NoneWithOnlychildren,
    			BigInteger q13c2NoneUnknowHousehold,
    			BigInteger q13c2Condition1Total,
    			BigInteger q13c2Condition1WithoutChildren,
    			BigInteger q13c2Condition1WithChildAndAdults,
    			BigInteger q13c2Condition1WithOnlychildren,
    			BigInteger q13c2Condition1UnknowHousehold,
    			BigInteger q13c2Condition2Total,
    			BigInteger q13c2Condition2WithoutChildren,
    			BigInteger q13c2Condition2WithChildAndAdults,
    			BigInteger q13c2Condition2WithOnlychildren,
    			BigInteger q13c2Condition2UnknowHousehold,
    			BigInteger q13c2Condition3PlusTotal,
    			BigInteger q13c2Condition3PlusWithoutChildren,
    			BigInteger q13c2Condition3PlusWithChildAndAdults,
    			BigInteger q13c2Condition3PlusWithOnlychildren,
    			BigInteger q13c2Condition3PlusUnknowHousehold,
    			BigInteger q13c2ConditionUnknownTotal,
    			BigInteger q13c2ConditionUnknownWithoutChildren,
    			BigInteger q13c2ConditionUnknownWithChildAndAdults,
    			BigInteger q13c2ConditionUnknownWithOnlychildren,
    			BigInteger q13c2ConditionUnknownUnknowHousehold,
    			BigInteger q13c2DontKnowRefusedTotal,
    			BigInteger q13c2DontKnowRefusedWithoutChildren,
    			BigInteger q13c2DontKnowRefusedWithChildAndAdults,
    			BigInteger q13c2DontKnowRefusedWithOnlychildren,
    			BigInteger q13c2DontKnowRefusedUnknowHousehold,
    			BigInteger q13c2InformationmissingTotal,
    			BigInteger q13c2InformationmissingWithoutChildren,
    			BigInteger q13c2InformationmissingWithChildAndAdults,
    			BigInteger q13c2InformationmissingWithOnlychildren,
    			BigInteger q13c2InformationmissingUnknowHousehold,
    			BigInteger q13c2TotalSummed, BigInteger q13c2TotalWithoutChildren,
    			BigInteger q13c2TotalWithChildAndAdults,
    			BigInteger q13c2TotalWithOnlychildren,
    			BigInteger q13c2TotalUnknowHousehold,
    			DataBean_Old q13c2NumberOfConditionsForStayersTableBean) {
    		
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2NoneTotal(q13c2NoneTotal);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2NoneWithoutChildren(q13c2NoneWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2NoneWithChildAndAdults(q13c2NoneWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2NoneWithOnlychildren(q13c2NoneWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2NoneUnknowHousehold(q13c2NoneUnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition1Total(q13c2Condition1Total);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition1WithoutChildren(q13c2Condition1WithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition1WithChildAndAdults(q13c2Condition1WithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition1WithOnlychildren(q13c2Condition1WithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition1UnknowHousehold(q13c2Condition1UnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition2Total(q13c2Condition2Total);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition2WithoutChildren(q13c2Condition2WithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition2WithChildAndAdults(q13c2Condition2WithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition2WithOnlychildren(q13c2Condition2WithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition2UnknowHousehold(q13c2Condition2UnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition3PlusTotal(q13c2Condition3PlusTotal);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition3PlusWithoutChildren(q13c2Condition3PlusWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition3PlusWithChildAndAdults(q13c2Condition3PlusWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition3PlusWithOnlychildren(q13c2Condition3PlusWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2Condition3PlusUnknowHousehold(q13c2Condition3PlusUnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2ConditionUnknownTotal(q13c2ConditionUnknownTotal);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2ConditionUnknownWithoutChildren(q13c2ConditionUnknownWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2ConditionUnknownWithChildAndAdults(q13c2ConditionUnknownWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2ConditionUnknownWithOnlychildren(q13c2ConditionUnknownWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2ConditionUnknownUnknowHousehold(q13c2ConditionUnknownUnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2DontKnowRefusedTotal(q13c2DontKnowRefusedTotal);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2DontKnowRefusedWithoutChildren(q13c2DontKnowRefusedWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2DontKnowRefusedWithChildAndAdults(q13c2DontKnowRefusedWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2DontKnowRefusedWithOnlychildren(q13c2DontKnowRefusedWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2DontKnowRefusedUnknowHousehold(q13c2DontKnowRefusedUnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2InformationmissingTotal(q13c2InformationmissingTotal);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2InformationmissingWithoutChildren(q13c2InformationmissingWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2InformationmissingWithChildAndAdults(q13c2InformationmissingWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2InformationmissingWithOnlychildren(q13c2InformationmissingWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2InformationmissingUnknowHousehold(q13c2InformationmissingUnknowHousehold);
    		
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2TotalSummed(q13c2TotalSummed);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2TotalWithoutChildren(q13c2TotalWithoutChildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2TotalWithChildAndAdults(q13c2TotalWithChildAndAdults);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2TotalWithOnlychildren(q13c2TotalWithOnlychildren);
    		q13c2NumberOfConditionsForStayersTableBean.setQ13c2TotalUnknowHousehold(q13c2TotalUnknowHousehold);
    		
    		return q13c2NumberOfConditionsForStayersTableBean;
    		
    	}
    	
    	public static DataBean_Old q14aDomesticViolenceHistoryTableBean(BigInteger q14aYesTotal,
    			BigInteger q14aYesWithoutChildren,
    			BigInteger q14aYesWithChildAndAdults,
    			BigInteger q14aYesWithOnlyChildren,
    			BigInteger q14aYesUnknownHouseholdType, BigInteger q14aNoTotal,
    			BigInteger q14aNoWithoutChildren,
    			BigInteger q14aNoWithChildAndAdults,
    			BigInteger q14aNoWithOnlyChildren,
    			BigInteger q14aNoUnknownHouseholdType, BigInteger q14aDKRTotal,
    			BigInteger q14aDKRWithoutChildren,
    			BigInteger q14aDKRWithChildAndAdults,
    			BigInteger q14aDKRWithOnlyChildren,
    			BigInteger q14aDKRUnknownHouseholdType,
    			BigInteger q14aInformationMissingTotal,
    			BigInteger q14aInformationMissingWithoutChildren,
    			BigInteger q14aInformationMissingWithChildAndAdults,
    			BigInteger q14aInformationMissingWithOnlyChildren,
    			BigInteger q14aInformationMissingUnknownHouseholdType,
    			BigInteger q14aTotalSummed, BigInteger q14aTotalWithoutChildren,
    			BigInteger q14aTotalWithChildAndAdults,
    			BigInteger q14aTotalWithOnlychildren,
    			BigInteger q14aTotalUnknowHousehold,
    			DataBean_Old q14aDomesticViolenceHistoryTableBean) {
    		
    		q14aDomesticViolenceHistoryTableBean.setQ14aYesTotal(q14aYesTotal);
    		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithoutChildren(q14aYesWithoutChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithChildAndAdults(q14aYesWithChildAndAdults);
    		q14aDomesticViolenceHistoryTableBean.setQ14aYesWithOnlyChildren(q14aYesWithOnlyChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aYesUnknownHouseholdType(q14aYesUnknownHouseholdType);
    		
    		q14aDomesticViolenceHistoryTableBean.setQ14aNoTotal(q14aNoTotal);
    		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithoutChildren(q14aNoWithoutChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithChildAndAdults(q14aNoWithChildAndAdults);
    		q14aDomesticViolenceHistoryTableBean.setQ14aNoWithOnlyChildren(q14aNoWithOnlyChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aNoUnknownHouseholdType(q14aNoUnknownHouseholdType);
    		
    		q14aDomesticViolenceHistoryTableBean.setQ14aDKRTotal(q14aDKRTotal);
    		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithoutChildren(q14aDKRWithoutChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithChildAndAdults(q14aDKRWithChildAndAdults);
    		q14aDomesticViolenceHistoryTableBean.setQ14aDKRWithOnlyChildren(q14aDKRWithOnlyChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aDKRUnknownHouseholdType(q14aDKRUnknownHouseholdType);
    		
    		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingTotal(q14aInformationMissingTotal);
    		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithoutChildren(q14aInformationMissingWithoutChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithChildAndAdults(q14aInformationMissingWithChildAndAdults);
    		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingWithOnlyChildren(q14aInformationMissingWithOnlyChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aInformationMissingUnknownHouseholdType(q14aInformationMissingUnknownHouseholdType);
      		
    		q14aDomesticViolenceHistoryTableBean.setQ14aTotalSummed(q14aTotalSummed);
    		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithoutChildren(q14aTotalWithoutChildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithChildAndAdults(q14aTotalWithChildAndAdults);
    		q14aDomesticViolenceHistoryTableBean.setQ14aTotalWithOnlychildren(q14aTotalWithOnlychildren);
    		q14aDomesticViolenceHistoryTableBean.setQ14aTotalUnknowHousehold(q14aTotalUnknowHousehold);
    		
       		return q14aDomesticViolenceHistoryTableBean;
    	}
    	
    	public static DataBean_Old q14bPersonsFleeingDomesticViolenceTableBean(BigInteger q14bYesTotal,
    			BigInteger q14bYesWithoutChildren,
    			BigInteger q14bYesWithChildAndAdults,
    			BigInteger q14bYesWithOnlyChildren,
    			BigInteger q14bYesUnknownHouseholdType, BigInteger q14bNoTotal,
    			BigInteger q14bNoWithoutChildren,
    			BigInteger q14bNoWithChildAndAdults,
    			BigInteger q14bNoWithOnlyChildren,
    			BigInteger q14bNoUnknownHouseholdType, BigInteger q14bDKRTotal,
    			BigInteger q14bDKRWithoutChildren,
    			BigInteger q14bDKRWithChildAndAdults,
    			BigInteger q14bDKRWithOnlyChildren,
    			BigInteger q14bDKRUnknownHouseholdType,
    			BigInteger q14bInformationMissingTotal,
    			BigInteger q14bInformationMissingWithoutChildren,
    			BigInteger q14bInformationMissingWithChildAndAdults,
    			BigInteger q14bInformationMissingWithOnlyChildren,
    			BigInteger q14bInformationMissingUnknownHouseholdType,
    			BigInteger q14bTotalSummed, BigInteger q14bTotalWithoutChildren,
    			BigInteger q14bTotalWithChildAndAdults,
    			BigInteger q14bTotalWithOnlychildren,
    			BigInteger q14bTotalUnknowHousehold,
    			DataBean_Old q14bPersonsFleeingDomesticViolenceTableBean) {
    		
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesTotal(q14bYesTotal);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithoutChildren(q14bYesWithoutChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithChildAndAdults(q14bYesWithChildAndAdults);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesWithOnlyChildren(q14bYesWithOnlyChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bYesUnknownHouseholdType(q14bYesUnknownHouseholdType);
    		
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoTotal(q14bNoTotal);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithoutChildren(q14bNoWithoutChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithChildAndAdults(q14bNoWithChildAndAdults);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoWithOnlyChildren(q14bNoWithOnlyChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bNoUnknownHouseholdType(q14bNoUnknownHouseholdType);
    		
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRTotal(q14bDKRTotal);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithoutChildren(q14bDKRWithoutChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithChildAndAdults(q14bDKRWithChildAndAdults);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRWithOnlyChildren(q14bDKRWithOnlyChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bDKRUnknownHouseholdType(q14bDKRUnknownHouseholdType);
    	
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingTotal(q14bInformationMissingTotal);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithoutChildren(q14bInformationMissingWithoutChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithChildAndAdults(q14bInformationMissingWithChildAndAdults);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingWithOnlyChildren(q14bInformationMissingWithOnlyChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bInformationMissingUnknownHouseholdType(q14bInformationMissingUnknownHouseholdType);
      		
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalSummed(q14bTotalSummed);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithoutChildren(q14bTotalWithoutChildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithChildAndAdults(q14bTotalWithChildAndAdults);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalWithOnlychildren(q14bTotalWithOnlychildren);
    		q14bPersonsFleeingDomesticViolenceTableBean.setQ14bTotalUnknowHousehold(q14bTotalUnknowHousehold);
    		
    		return q14bPersonsFleeingDomesticViolenceTableBean;
    	}
    
    	public static DataBean_Old q15ResidencePriorToProgramEntryBeanPublic(
    			BigInteger q15HomeLessSituationsTotal,
    			BigInteger q15HomeLessSituationsWithoutChildren,
    			BigInteger q15HomeLessSituationWithChildAndAdult,
    			BigInteger q15HomeLessSituationsWithChildOnly,
    			BigInteger q15HomeLessSituationsUnknownHouseHold,
    			BigInteger q15EmergencyShelterTotal,
    			BigInteger q15EmergencyShelterWithoutChildren,
    			BigInteger q15EmergencyShelterWithChildAndAdult,
    			BigInteger q15EmergencyShelterWithChildOnly,
    			BigInteger q15EmergencyShelterUnknownHouseHold,
    			BigInteger q15TransitionalHousingForhomelessTotal,
    			BigInteger q15TransitionalHousingForhomelessWithoutChildren,
    			BigInteger q15TransitionalHousingForhomelessWithChildAndAdult,
    			BigInteger q15TransitionalHousingForhomelessWithChildOnly,
    			BigInteger q15TransitionalHousingForhomelessUnknownHouseHold,
    			BigInteger q15PlaceNotMeantTotal,
    			BigInteger q15PlaceNotMeantWithoutChildren,
    			BigInteger q15PlaceNotMeantWithChildAndAdult,
    			BigInteger q15PlaceNotMeantWithChildOnly,
    			BigInteger q15PlaceNotMeantsUnknownHouseHold,
    			BigInteger q15SafeHeavenTotal,
    			BigInteger q15SafeHeavenWithoutChildren,
    			BigInteger q15SafeHeavenWithChildAndAdult,
    			BigInteger q15SafeHeavenWithChildOnly,
    			BigInteger q15SafeHeavenUnknownHouseHold,
    			BigInteger q15AzTotalSummed, BigInteger q15AzTotalWithoutChildren,
    			BigInteger q15AzTotalWithChildAndAdult,
    			BigInteger q15AzTotalWithChildOnly,
    			BigInteger q15AzTotalUnknownHouseHold,
    			BigInteger q15InstitutionalSettingsTotal,
    			BigInteger q15InstitutionalSettingsWithoutChildren,
    			BigInteger q15InstitutionalSettingsWithChildandAdult,
    			BigInteger q15InstitutionalSettingsWithChildOnly,
    			BigInteger q15InstitutionalSettingsUnknowHouseHold,
    			BigInteger q15PsychiatricFacilityTotal,
    			BigInteger q15PsychiatricFacilityWithoutChildren,
    			BigInteger q15PsychiatricFacilityWithChildandAdult,
    			BigInteger q15PsychiatricFacilityWithChildOnly,
    			BigInteger q15PsychiatricFacilityUnknownhouseHold,
    			BigInteger q15SubstanceAbuseTotal,
    			BigInteger q15SubstanceAbuseWithoutChildren,
    			BigInteger q15SubstanceAbuseWithChildandAdult,
    			BigInteger q15SubstanceAbuseWithChildOnly,
    			BigInteger q15SubstanceAbuseUnknowHouseHold,
    			BigInteger q15HospitalNonPhychiatricTotal,
    			BigInteger q15HospitalNonPhychiatricWithoutChild,
    			BigInteger q15HospitalNonPhychiatricWithChildandAdult,
    			BigInteger q15HospitalNonPhychiatricWithChildOnly,
    			BigInteger q15HospitalNonPhychiatricUnknownHouseHold,
    			BigInteger q15JailPrisonTotal,
    			BigInteger q15JailPrisonWithoutChild,
    			BigInteger q15JailPrisonWithChildandAdult,
    			BigInteger q15JailPrisonWithChildOnly,
    			BigInteger q15JailPrisonUnknowHouseHold,
    			BigInteger q15FosterCarehomeTotal,
    			BigInteger q15FosterCarehomeWithoutChild,
    			BigInteger q15FosterCarehomeWithChildandAdult,
    			BigInteger q15FosterCarehomeWithChildOnly,
    			BigInteger q15FosterCarehomeUnknownHouseHold,
    			BigInteger q15LongTermCareFacilityTotal,
    			BigInteger q15LongTermCareFacilityWithoutChild,
    			BigInteger q15LongTermCareFacilityWithChildandAdult,
    			BigInteger q15LongTermCareFacilityWithChildOnly,
    			BigInteger q15LongTermCareFacilityUnknowHouseHold,
    			BigInteger q15ResidentialProjectTotal,
    			BigInteger q15ResidentialProjectWithoutChild,
    			BigInteger q15ResidentialProjectWithChildandAdult,
    			BigInteger q15ResidentialProjectWithChildOnly,
    			BigInteger q15ResidentialProjectUnknownHouseHold,
    			BigInteger q15BzTotalSummed, BigInteger q15BzTotalWithoutChild,
    			BigInteger q15BzTotalWithChildandAdult,
    			BigInteger q15BzTotalWithChildOnly,
    			BigInteger q15BzTotalUnknowHousehold,
    			BigInteger q15OtherLocationTotal,
    			BigInteger q15OtherLocationWithoutChild,
    			BigInteger q15OtherLocationWithChildandAdult,
    			BigInteger q15OtherLocationWithChildOnly,
    			BigInteger q15OtherLocationUnkownHousehold,
    			BigInteger q15PSHforHomelessPersonsTotal,
    			BigInteger q15PSHforHomelessPersonsWithoutChild,
    			BigInteger q15PSHforHomelessPersonsWithChilandAdult,
    			BigInteger q15PSHforHomelessPersonsWithChildOnly,
    			BigInteger q15PSHforHomelessPersonsUnknowHousehold,
    			BigInteger q15OwnedByclientNoSubsidyTotal,
    			BigInteger q15OwnedByclientNoSubsidyWithoutchild,
    			BigInteger q15OwnedByclientNoSubsidyWithChildandAdult,
    			BigInteger q15OwnedByclientNoSubsidyWithChildOnly,
    			BigInteger q15OwnedByclientNoSubsidyUnknowHousehold,
    			BigInteger q15OwnedByclientWithSubsidyTotal,
    			BigInteger q15OwnedByclientWithSubsidyWithoutchild,
    			BigInteger q15OwnedByclientWithSubsidyWithChildandAdult,
    			BigInteger q15OwnedByclientWithSubsidyWithChildOnly,
    			BigInteger q15OwnedByclientWithSubsidyUnknowHousehold,
    			BigInteger q15RentalByClientNoSubsidyTotal,
    			BigInteger q15RentalByClientNoSubsidyWithoutChild,
    			BigInteger q15RentalByClientNoSubsidyWithChildandAdult,
    			BigInteger q15RentalByClientNoSubsidyWithchildOnly,
    			BigInteger q15RentalByClientNoSubsidyUnknownHousehold,
    			BigInteger q15RentalByClientWithVASHSubsidyTotal,
    			BigInteger q15RentalByClientWithVASHSubsidyWithoutChild,
    			BigInteger q15RentalByClientWithVASHSubsidyWithchildandAdult,
    			BigInteger q15RentalByClientWithVASHSubsidyWithChildOnly,
    			BigInteger q15RentalByClientWithVASHSubsidyUnknownHousehold,
    			BigInteger q15RentalByClientWithGPDTIPSubsidyTotal,
    			BigInteger q15RentalByClientWithGPDTIPSubsidyWithoutChild,
    			BigInteger q15RentalByClientWithGPDTIPSubsidyWithchildandAdult,
    			BigInteger q15RentalByClientWithGPDTIPSubsidyWithChildOnly,
    			BigInteger q15RentalByClientWithGPDTIPSubsidyUnknownHousehold,
    			BigInteger q15RentalByClientWithOtherSubsidyTotal,
    			BigInteger q15RentalByClientWithOtherSubsidyWithoutChild,
    			BigInteger q15RentalByClientWithOtherSubsidyWithChildandAdult,
    			BigInteger q15RentalByClientWithOtherSubsidyWithChildOnly,
    			BigInteger q15RentalByClientWithOtherSubsidyUnknowHousehold,
    			BigInteger q15HotelOrMotelTotal,
    			BigInteger q15HotelOrMotelWithoutChild,
    			BigInteger q15HotelOrMotelWithChidandAdult,
    			BigInteger q15HotelOrMotelWithChildOnly,
    			BigInteger q15HotelOrMotelUnkownHousehold,
    			BigInteger q15StayingOrLivingWithFriendsTotal,
    			BigInteger q15StayingOrLivingWithFriendsWithoutChild,
    			BigInteger q15StayingOrLivingWithFriendsWithChildandAdult,
    			BigInteger q15StayingOrLivingWithFriendsWithChildOnly,
    			BigInteger q15StayingOrLivingWithFriendsUnknownHousehold,
    			BigInteger q15StayingOrLivingWithFamilyTotal,
    			BigInteger q15StayingOrLivingWithFamilyWithoutChild,
    			BigInteger q15StayingOrLivingWithFamilyWithChildandAdult,
    			BigInteger q15StayingOrLivingWithFamilyWithChildOnly,
    			BigInteger q15StayingOrLivingWithFamilyUnknownHousehold,
    			BigInteger q15OtherTotal, BigInteger q15OtherWithoutChild,
    			BigInteger q15OtherWithChildandAdult,
    			BigInteger q15OtherWithChildOnly,
    			BigInteger q15OtherUnknownHousehold,
    			BigInteger q15DontRefusedTotal,
    			BigInteger q15DontRefusedWithoutChild,
    			BigInteger q15DontRefusedWithChildandAdult,
    			BigInteger q15DontRefusedWithChildOnly,
    			BigInteger q15DontRefusedUnknownHousehold,
    			BigInteger q15InformationMissingTotal,
    			BigInteger q15InformationMissingWithoutChild,
    			BigInteger q15InformationMissingWithChildandAdult,
    			BigInteger q15InformationMissingwithChildOnly,
    			BigInteger q15InformationMissingUnknownHousehold,
    			BigInteger q15CzTotalSummed, BigInteger q15CzTotalWithoutChild,
    			BigInteger q15CzTotalWithChildandAdult,
    			BigInteger q15CzTotalWithChildOnly,
    			BigInteger q15CzTotalUnknownHousehold, BigInteger q15dTotalSummed,
    			BigInteger q15dTotalWithoutChild,
    			BigInteger q15dTotalWithChildandAdult,
    			BigInteger q15dTotalWithChildOnly,
    			BigInteger q15dTotalUnknownHousehold,
    			DataBean_Old q15ResidencePriorToProgramEntrTableBean) {
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsTotal(q15HomeLessSituationsTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsWithoutChildren(q15HomeLessSituationsWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationWithChildAndAdult(q15HomeLessSituationWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsWithChildOnly(q15HomeLessSituationsWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HomeLessSituationsUnknownHouseHold(q15HomeLessSituationsUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterTotal(q15EmergencyShelterTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithoutChildren(q15EmergencyShelterWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithChildAndAdult(q15EmergencyShelterWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterWithChildOnly(q15EmergencyShelterWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15EmergencyShelterUnknownHouseHold(q15EmergencyShelterUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessTotal(q15TransitionalHousingForhomelessTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithoutChildren(q15TransitionalHousingForhomelessWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithChildAndAdult(q15TransitionalHousingForhomelessWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessWithChildOnly(q15TransitionalHousingForhomelessWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15TransitionalHousingForhomelessUnknownHouseHold(q15TransitionalHousingForhomelessUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantTotal(q15PlaceNotMeantTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithoutChildren(q15PlaceNotMeantWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithChildAndAdult(q15PlaceNotMeantWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantWithChildOnly(q15PlaceNotMeantWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PlaceNotMeantsUnknownHouseHold(q15PlaceNotMeantsUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenTotal(q15SafeHeavenTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithoutChildren(q15SafeHeavenWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithChildAndAdult(q15SafeHeavenWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenWithChildOnly(q15SafeHeavenWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SafeHeavenUnknownHouseHold(q15SafeHeavenUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalSummed(q15AzTotalSummed);
    		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithoutChildren(q15AzTotalWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithChildAndAdult(q15AzTotalWithChildAndAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalWithChildOnly(q15AzTotalWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15AzTotalUnknownHouseHold(q15AzTotalUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsTotal(q15InstitutionalSettingsTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithoutChildren(q15InstitutionalSettingsWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithChildandAdult(q15InstitutionalSettingsWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsWithChildOnly(q15InstitutionalSettingsWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InstitutionalSettingsUnknowHouseHold(q15InstitutionalSettingsUnknowHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityTotal(q15PsychiatricFacilityTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithoutChildren(q15PsychiatricFacilityWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithChildandAdult(q15PsychiatricFacilityWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityWithChildOnly(q15PsychiatricFacilityWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PsychiatricFacilityUnknownhouseHold(q15PsychiatricFacilityUnknownhouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseTotal(q15SubstanceAbuseTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithoutChildren(q15SubstanceAbuseWithoutChildren);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithChildandAdult(q15SubstanceAbuseWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseWithChildOnly(q15SubstanceAbuseWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15SubstanceAbuseUnknowHouseHold(q15SubstanceAbuseUnknowHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricTotal(q15HospitalNonPhychiatricTotal);    	
    		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithoutChild(q15HospitalNonPhychiatricWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithChildOnly(q15HospitalNonPhychiatricWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricWithChildandAdult(q15HospitalNonPhychiatricWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HospitalNonPhychiatricUnknownHouseHold(q15HospitalNonPhychiatricUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonTotal(q15JailPrisonTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithoutChild(q15JailPrisonWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithChildandAdult(q15JailPrisonWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonWithChildOnly(q15JailPrisonWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15JailPrisonUnknowHouseHold(q15JailPrisonUnknowHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeTotal(q15FosterCarehomeTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithoutChild(q15FosterCarehomeWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithChildandAdult(q15FosterCarehomeWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeWithChildOnly(q15FosterCarehomeWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15FosterCarehomeUnknownHouseHold(q15FosterCarehomeUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityTotal(q15LongTermCareFacilityTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithoutChild(q15LongTermCareFacilityWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithChildandAdult(q15LongTermCareFacilityWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityWithChildOnly(q15LongTermCareFacilityWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15LongTermCareFacilityUnknowHouseHold(q15LongTermCareFacilityUnknowHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectTotal(q15ResidentialProjectTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithoutChild(q15ResidentialProjectWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithChildandAdult(q15ResidentialProjectWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectWithChildOnly(q15ResidentialProjectWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15ResidentialProjectUnknownHouseHold(q15ResidentialProjectUnknownHouseHold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalSummed(q15BzTotalSummed);
    		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithoutChild(q15BzTotalWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithChildandAdult(q15BzTotalWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalWithChildOnly(q15BzTotalWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15BzTotalUnknowHousehold(q15BzTotalUnknowHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationTotal(q15OtherLocationTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithoutChild(q15OtherLocationWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithChildandAdult(q15OtherLocationWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationWithChildOnly(q15OtherLocationWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherLocationUnkownHousehold(q15OtherLocationUnkownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsTotal(q15PSHforHomelessPersonsTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithoutChild(q15PSHforHomelessPersonsWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithChilandAdult(q15PSHforHomelessPersonsWithChilandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsWithChildOnly(q15PSHforHomelessPersonsWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15PSHforHomelessPersonsUnknowHousehold(q15PSHforHomelessPersonsUnknowHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyTotal(q15OwnedByclientNoSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithoutchild(q15OwnedByclientNoSubsidyWithoutchild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithChildandAdult(q15OwnedByclientNoSubsidyWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyWithChildOnly(q15OwnedByclientNoSubsidyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientNoSubsidyUnknowHousehold(q15OwnedByclientNoSubsidyUnknowHousehold);
    		    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyTotal(q15OwnedByclientWithSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithoutchild(q15OwnedByclientWithSubsidyWithoutchild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithChildandAdult(q15OwnedByclientWithSubsidyWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyWithChildOnly(q15OwnedByclientWithSubsidyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OwnedByclientWithSubsidyUnknowHousehold(q15OwnedByclientWithSubsidyUnknowHousehold);

    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyTotal(q15RentalByClientNoSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithoutChild(q15RentalByClientNoSubsidyWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithChildandAdult(q15RentalByClientNoSubsidyWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyWithchildOnly(q15RentalByClientNoSubsidyWithchildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientNoSubsidyUnknownHousehold(q15RentalByClientNoSubsidyUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyTotal(q15RentalByClientWithVASHSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithoutChild(q15RentalByClientWithVASHSubsidyWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithChildOnly(q15RentalByClientWithVASHSubsidyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyWithchildandAdult(q15RentalByClientWithVASHSubsidyWithchildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithVASHSubsidyUnknownHousehold(q15RentalByClientWithVASHSubsidyUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyTotal(q15RentalByClientWithGPDTIPSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(q15RentalByClientWithGPDTIPSubsidyWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(q15RentalByClientWithGPDTIPSubsidyWithchildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(q15RentalByClientWithGPDTIPSubsidyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(q15RentalByClientWithGPDTIPSubsidyUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyTotal(q15RentalByClientWithOtherSubsidyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithoutChild(q15RentalByClientWithOtherSubsidyWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithChildandAdult(q15RentalByClientWithOtherSubsidyWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyWithChildOnly(q15RentalByClientWithOtherSubsidyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15RentalByClientWithOtherSubsidyUnknowHousehold(q15RentalByClientWithOtherSubsidyUnknowHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelTotal(q15HotelOrMotelTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithoutChild(q15HotelOrMotelWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithChildOnly(q15HotelOrMotelWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelWithChidandAdult(q15HotelOrMotelWithChidandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15HotelOrMotelUnkownHousehold(q15HotelOrMotelUnkownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsTotal(q15StayingOrLivingWithFriendsTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithoutChild(q15StayingOrLivingWithFriendsWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithChildandAdult(q15StayingOrLivingWithFriendsWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsWithChildOnly(q15StayingOrLivingWithFriendsWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFriendsUnknownHousehold(q15StayingOrLivingWithFriendsUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyTotal(q15StayingOrLivingWithFamilyTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithoutChild(q15StayingOrLivingWithFamilyWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithChildandAdult(q15StayingOrLivingWithFamilyWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyWithChildOnly(q15StayingOrLivingWithFamilyWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15StayingOrLivingWithFamilyUnknownHousehold(q15StayingOrLivingWithFamilyUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherTotal(q15OtherTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithoutChild(q15OtherWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithChildandAdult(q15OtherWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherWithChildOnly(q15OtherWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15OtherUnknownHousehold(q15OtherUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedTotal(q15DontRefusedTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithoutChild(q15DontRefusedWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithChildandAdult(q15DontRefusedWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedWithChildOnly(q15DontRefusedWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DontRefusedUnknownHousehold(q15DontRefusedUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingTotal(q15InformationMissingTotal);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingWithoutChild(q15InformationMissingWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingUnknownHousehold(q15InformationMissingUnknownHousehold);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingWithChildandAdult(q15InformationMissingWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15InformationMissingwithChildOnly(q15InformationMissingwithChildOnly);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalSummed(q15CzTotalSummed);
    		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithoutChild(q15CzTotalWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithChildOnly(q15CzTotalWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalWithChildandAdult(q15CzTotalWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15CzTotalUnknownHousehold(q15CzTotalUnknownHousehold);
    		
    		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalSummed(q15dTotalSummed);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithoutChild(q15dTotalWithoutChild);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithChildandAdult(q15dTotalWithChildandAdult);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalWithChildOnly(q15dTotalWithChildOnly);
    		q15ResidencePriorToProgramEntrTableBean.setQ15DTotalUnknownHousehold(q15dTotalUnknownHousehold);
    		
    		
    	return q15ResidencePriorToProgramEntrTableBean;
    	}
    	
    	public static DataBean_Old q16CashIncomeRangesTableBean(
    			BigInteger q16NoIncomeIncomeAtEntry,
    			BigInteger q16NoIncomeIncomeAtLatestFollowupforStayers,
    			BigInteger q16NoIncomeIncomeAtExitforLeavers,
    			BigInteger q161To150IncomeAtEntry,
    			BigInteger q161To150IncomeAtLatestFollowupforStayers,
    			BigInteger q161To150IncomeAtExitforLeavers,
    			BigInteger q16151To250IncomeAtEntry,
    			BigInteger q16151To250IncomeAtLatestFollowupforStayers,
    			BigInteger q16151To250IncomeAtExitforLeavers,
    			BigInteger q16251To500IncomeAtEntry,
    			BigInteger q16251To500IncomeAtLatestFollowupforStayers,
    			BigInteger q16251To500IncomeAtExitforLeavers,
    			BigInteger q16501To1000IncomeAtEntry,
    			BigInteger q16501To1000IncomeAtLatestFollowupforStayers,
    			BigInteger q16501To1000IncomeAtExitforLeavers,
    			BigInteger q161001To1500IncomeAtEntry,
    			BigInteger q161001To1500IncomeAtLatestFollowupforStayers,
    			BigInteger q161001To1500IncomeAtExitforLeavers,
    			BigInteger q161501To2000IncomeAtEntry,
    			BigInteger q161501To2000IncomeAtLatestFollowupforStayers,
    			BigInteger q161501To2000IncomeAtExitforLeavers,
    			BigInteger q162000PlusIncomeAtEntry,
    			BigInteger q162000PlusIncomeAtLatestFollowupforStayers,
    			BigInteger q162000PlusIncomeAtExitforLeavers,
    			BigInteger q16ClientDoesntKnowIncomeAtEntry,
    			BigInteger q16ClientDoesntKnowIncomeAtLatestFollowupforStayers,
    			BigInteger q16ClientDoesntKnowIncomeAtExitforLeavers,
    			BigInteger q16DataNotCollectedIncomeAtEntry,
    			BigInteger q16DataNotCollectedIncomeAtLatestFollowupforStayers,
    			BigInteger q16DataNotCollectedIncomeAtExitforLeavers,
    			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry,
    			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers,
    			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers,
    			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry,
    			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers,
    			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers,
    			BigInteger q16TotalAdultsIncomeAtEntry,
    			BigInteger q16TotalAdultsIncomeAtLatestFollowupforStayers,
    			BigInteger q16TotalAdultsIncomeAtExitforLeavers,
    			DataBean_Old q16CashIncomeRangesTableBean) {
    		
    		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtEntry(q16NoIncomeIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtExitforLeavers(q16NoIncomeIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16NoIncomeIncomeAtLatestFollowupforStayers(q16NoIncomeIncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ161To150IncomeAtEntry(q161To150IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ161To150IncomeAtExitforLeavers(q161To150IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ161To150IncomeAtLatestFollowupforStayers(q161To150IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtEntry(q16151To250IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtExitforLeavers(q16151To250IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16151To250IncomeAtLatestFollowupforStayers(q16151To250IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtEntry(q16251To500IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtExitforLeavers(q16251To500IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16251To500IncomeAtLatestFollowupforStayers(q16251To500IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtEntry(q16501To1000IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtExitforLeavers(q16501To1000IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16501To1000IncomeAtLatestFollowupforStayers(q16501To1000IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtEntry(q161001To1500IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtExitforLeavers(q161001To1500IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ161001To1500IncomeAtLatestFollowupforStayers(q161001To1500IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtEntry(q161501To2000IncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtExitforLeavers(q161501To2000IncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ161501To2000IncomeAtLatestFollowupforStayers(q161501To2000IncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtEntry(q162000PlusIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtExitforLeavers(q162000PlusIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ162000PlusIncomeAtLatestFollowupforStayers(q162000PlusIncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtEntry(q16ClientDoesntKnowIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtExitforLeavers(q16ClientDoesntKnowIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(q16ClientDoesntKnowIncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtEntry(q16DataNotCollectedIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtExitforLeavers(q16DataNotCollectedIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(q16DataNotCollectedIncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers);
    		
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers);

    		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtEntry(q16TotalAdultsIncomeAtEntry);
    		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtExitforLeavers(q16TotalAdultsIncomeAtExitforLeavers);
    		q16CashIncomeRangesTableBean.setQ16TotalAdultsIncomeAtLatestFollowupforStayers(q16TotalAdultsIncomeAtLatestFollowupforStayers);
    		
    		return q16CashIncomeRangesTableBean;
    	
    	}

}




/*public class ContactFactory {

    public static List<ContactBean> create() {
        ContactBean stub = new ContactBean();
        stub.setFirstName("John");
        stub.setLastName("Smith");

        AddressBean address1 = new AddressBean();
        address1.setType("Home");
        address1.setAddress("123 Fake St\nFaketown\nFK 12345");
        AddressBean address2 = new AddressBean();
        address2.setType("Work");
        address2.setAddress("321 Bogus St\nFaketown\nFK 12345");
        stub.setAddresses(Arrays.asList(address1, address2));

        PhoneBean phone1 = new PhoneBean();
        phone1.setType("Home");
        phone1.setNumber("03 9876 1234");
        PhoneBean phone2 = new PhoneBean();
        phone2.setType("Work");
        phone2.setNumber("03 1234 9876");
        PhoneBean phone3 = new PhoneBean();
        phone3.setType("Mobile");
        phone3.setNumber("0432 123 456");
        stub.setPhones(Arrays.asList(phone1, phone2, phone3));

        return Arrays.asList(stub);
    }
    
    
    
}

*/        

/*        public ArrayList<Q07a_HouseholdsServed> getQ7aHouseHoldsDataBeanMakerList() {
    ArrayList<Q07a_HouseholdsServed> q7aHouseHoldsDataBeanMakerList = new ArrayList<Q07a_HouseholdsServed>();
    
    q7aHouseHoldsDataBeanMakerList.add(q07aHouseholdsServe(BigInteger.valueOf(13),BigInteger.valueOf(10),BigInteger.valueOf(1),BigInteger.valueOf(1),
 		   BigInteger.valueOf(1)));
    
    return q7aHouseHoldsDataBeanMakerList;
}

private Q07a_HouseholdsServed q07aHouseholdsServe(BigInteger overAllTot,BigInteger totHhWithoutChild,BigInteger totHhWithChildAndAdults,
		BigInteger totHhWithOnlyChild,BigInteger totHhUnknowHhType) {

	Q07a_HouseholdsServed q07aHouseholdsServed = new Q07a_HouseholdsServed();
     
	q07aHouseholdsServed.setOverAllTotHouseHolds(overAllTot);
	q07aHouseholdsServed.setTotHhWithoutChild(totHhWithoutChild);
	q07aHouseholdsServed.setTotHhUnknownHhType(totHhUnknowHhType);
	q07aHouseholdsServed.setTotHhWothOnlyChild(totHhWithOnlyChild);
	q07aHouseholdsServed.setTotHhWithChildAndAdults(totHhWithChildAndAdults);
	
	return q07aHouseholdsServed;
}*/