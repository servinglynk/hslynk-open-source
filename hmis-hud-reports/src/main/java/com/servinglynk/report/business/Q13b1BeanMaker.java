package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13b1BeanMaker extends BaseBeanMaker {
	
	public static List<Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean> getQ13b1PhysicalAndMentalHealthConditionsAtExitList(ReportData data){
		
		Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean q13b1Bean = new Q13b1PhysicalAndMentalHealthConditionsAtExitDataBean();
		if(data.isLiveMode()) {
		try {
		List<String> projectsHHWithOutChildren = data.getProjectsHHWithOutChildren();
		List<String> projectsHHWithOneAdultChild = data.getProjectsHHWithOneAdultChild();
		List<String> projectsHHWithChildren = data.getProjectsHHWithChildren();
		List<String> projectsUnknownHouseHold = data.getProjectsUnknownHouseHold();
		
		// mental health -- select enrollment_id from disabilities where datacollectionstage =1 and disabilitytype='9'
				// alcohol --select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='1'
				// drug -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='2'
				// alcohol and drug -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='3'
				// Chronic Health Condition -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='7'
				// HIV/AIDS -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='8'
				// Physical Disability -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='5'
				// Developmental Disability -- select project_entry_id from disabilities where datacollectionstage = '1' and disabilitytype='6'
				
				String query = " select e.dedup_client_id from %s.disabilities d, %s.enrollment e,%s.exit ext where e.id =d.enrollmentid  and e.id=ext.enrollmentid  and information_date<=:endDate and datacollectionstage = '3' and TO_DATE(ext.exitdate)= TO_DATE(d.information_date) ";
		
				Set<String> mentalHealthList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='9' ");
				List<EnrollmentModel> enrollments = data.getEnrollments();   
				List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsHHWithOneAdults = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() > 18 ).collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsHHWithOneChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID()) && enrollment.getAgeatentry() < 18 ).collect(Collectors.toList());
				List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

				if(CollectionUtils.isNotEmpty(mentalHealthList)) {
					List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					
					q13b1Bean.setQ13b1MentalIllnessTotal(BigInteger.valueOf(mentalHealthList.size()));
			    	q13b1Bean.setQ13b1MentalIllnessWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
			    	q13b1Bean.setQ13b1AlcoholAbuseWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
			    	q13b1Bean.setQ13b1AlcoholAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
			    	q13b1Bean.setQ13b1MentalIllnessWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
			    	q13b1Bean.setQ13b1MentalIllnessUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
				}
				
		    	Set<String> alcoholList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='10' and  disabilityresponse='1' ");
		    	if(CollectionUtils.isNotEmpty(alcoholList)) {
		    		
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					
		    		q13b1Bean.setQ13b1AlcoholAbuseTotal(BigInteger.valueOf(alcoholList.size()));
		        	q13b1Bean.setQ13b1AlcoholAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1AlcoholAbuseWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1AlcoholAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	q13b1Bean.setQ13b1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	
		        	q13b1Bean.setQ13b1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
		     	Set<String> drugList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='10' and  disabilityresponse='2' ");
		    	if(CollectionUtils.isNotEmpty(drugList)) {
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> drugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
					
		    		q13b1Bean.setQ13b1DrugAbuseTotal(BigInteger.valueOf(drugList.size()));
		        	q13b1Bean.setQ13b1DrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1DrugAbuseWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1DrugAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	q13b1Bean.setQ13b1DrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1DrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
		    	
		    	
		    	Set<String> alcoholAndDrugList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='10' and  disabilityresponse='3' ");
		    	if(CollectionUtils.isNotEmpty(alcoholAndDrugList)) {
		     		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		
		    		q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(alcoholAndDrugList.size()));
		        	q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	
		        	q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		        	
		    	}
		    	Set<String> chronicHealthConditionList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='7' ");
		    	if(CollectionUtils.isNotEmpty(chronicHealthConditionList)) {	
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    				
		    		q13b1Bean.setQ13b1ChronicHealthConditionTotal(BigInteger.valueOf(chronicHealthConditionList.size()));
		        	q13b1Bean.setQ13b1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1ChronicHealthConditionWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1ChronicHealthConditionWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	q13b1Bean.setQ13b1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
		    	
		    	Set<String> hivaidsList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='8' ");
		    	if(CollectionUtils.isNotEmpty(hivaidsList)) {
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    			
		    		q13b1Bean.setQ13b1HIVRelatedDiseasesTotal(BigInteger.valueOf(hivaidsList.size()));
		        	q13b1Bean.setQ13b1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1HIVRelatedDiseasesWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1HIVRelatedDiseasesWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	
		        	q13b1Bean.setQ13b1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
		    	
		    	Set<String> developmentDisabilityList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='6' ");
		    	if(CollectionUtils.isNotEmpty(developmentDisabilityList)) {
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    			
		    		q13b1Bean.setQ13b1DevelopmentalDisabilityTotal(BigInteger.valueOf(developmentDisabilityList.size()));
		        	q13b1Bean.setQ13b1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1DevelopmentalDisabilityWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1DevelopmentalDisabilityWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	
		        	q13b1Bean.setQ13b1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
		    
		    	
		    	Set<String> physicalDisabilitiyList = getEnrollmentFromDisabilitiesForLeavers(data.getSchema(),data, query+" and disabilitytype='5' ");
		    	if(CollectionUtils.isNotEmpty(physicalDisabilitiyList)) {
		    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneAdults = enrollmentsHHWithOneAdults.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    		List<EnrollmentModel> withOneChildren = enrollmentsHHWithOneChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getDedupClientId())).collect(Collectors.toList());
		    			
		    	   	q13b1Bean.setQ13b1PhysicalDisabilityTotal(BigInteger.valueOf(physicalDisabilitiyList.size()));
		        	q13b1Bean.setQ13b1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
		        	q13b1Bean.setQ13b1PhysicalDisabilityWithAdults(BigInteger.valueOf(withOneAdults != null ? withOneAdults.size() : 0));
		        	q13b1Bean.setQ13b1PhysicalDisabilityWithChildren(BigInteger.valueOf(withOneChildren != null ? withOneChildren.size() : 0));
		        	
		        	q13b1Bean.setQ13b1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
		        	q13b1Bean.setQ13b1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		    	}
			} catch (Exception e) {
				logger.error("Error in q13b1BeanMaker:" + e);
			}
			}
				return Arrays.asList(q13b1Bean);
			}

		}
