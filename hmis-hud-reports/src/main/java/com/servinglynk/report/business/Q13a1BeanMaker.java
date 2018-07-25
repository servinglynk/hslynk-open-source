package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13a1DataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13a1BeanMaker extends BaseBeanMaker {
	
	
	public static List<Q13a1DataBean> getQ13a1PhysicalAndMentalHealthConditionsAtEntryList(ReportData data){
		Q13a1DataBean q13a1Bean = new Q13a1DataBean();
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
		
		String mentalHealthQuery = " select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='9' ";
		
		List<String> mentalHealthList = getEnrollmentFromDisabilities(data.getSchema(), mentalHealthQuery);
		List<EnrollmentModel> enrollments = data.getEnrollments();   
		List<EnrollmentModel> enrollmentsHHWithChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOutChildren = enrollments.parallelStream().filter(enrollment -> projectsHHWithOutChildren.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsHHWithOneAdultChild = enrollments.parallelStream().filter(enrollment -> projectsHHWithOneAdultChild.contains(enrollment.getProjectID())).collect(Collectors.toList());
		List<EnrollmentModel> enrollmentsUnknownHouseHold = enrollments.parallelStream().filter(enrollment -> projectsUnknownHouseHold.contains(enrollment.getProjectID())).collect(Collectors.toList());

		if(CollectionUtils.isNotEmpty(mentalHealthList)) {
			List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> mentalHealthList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
				
			q13a1Bean.setQ13a1MentalIllnessTotal(BigInteger.valueOf(mentalHealthList.size()));
	    	q13a1Bean.setQ13a1MentalIllnessWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
	    	q13a1Bean.setQ13a1MentalIllnessWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
	    	q13a1Bean.setQ13a1MentalIllnessWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
	    	q13a1Bean.setQ13a1MentalIllnessUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
		}
		
    	String alcoholQuery = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='1' ";
    	List<String> alcoholList = getEnrollmentFromDisabilities(data.getSchema(), alcoholQuery);
    	if(CollectionUtils.isNotEmpty(alcoholList)) {
    		
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
    		q13a1Bean.setQ13a1AlcoholAbuseTotal(BigInteger.valueOf(alcoholList.size()));
        	q13a1Bean.setQ13a1AlcoholAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1AlcoholAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
    	String drugQuery = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='2'";
     	List<String> drugList = getEnrollmentFromDisabilities(data.getSchema(), drugQuery);
    	if(CollectionUtils.isNotEmpty(drugList)) {
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
    		q13a1Bean.setQ13a1DrugAbuseTotal(BigInteger.valueOf(drugList.size()));
        	q13a1Bean.setQ13a1DrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1DrugAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1DrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1DrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
    	
    	
    	String alcoholAndDrugQuery = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='10' and disabilityresponse='3' ";
    	List<String> alcoholAndDrugList = getEnrollmentFromDisabilities(data.getSchema(), alcoholAndDrugQuery);
    	if(CollectionUtils.isNotEmpty(alcoholAndDrugList)) {
     		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    			
    		q13a1Bean.setQ13a1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(alcoholAndDrugList.size()));
        	q13a1Bean.setQ13a1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
        	
    	}
    	String chronicHealthCondition = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='7' ";
    	List<String> chronicHealthConditionList = getEnrollmentFromDisabilities(data.getSchema(), chronicHealthCondition);
    	if(CollectionUtils.isNotEmpty(chronicHealthConditionList)) {	
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    			
    		q13a1Bean.setQ13a1ChronicHealthConditionTotal(BigInteger.valueOf(chronicHealthConditionList.size()));
        	q13a1Bean.setQ13a1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1ChronicHealthConditionWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
    	
    	String hivaids = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='8' ";
    	List<String> hivaidsList = getEnrollmentFromDisabilities(data.getSchema(), hivaids);
    	if(CollectionUtils.isNotEmpty(hivaidsList)) {
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    			
    		q13a1Bean.setQ13a1HIVRelatedDiseasesTotal(BigInteger.valueOf(hivaidsList.size()));
        	q13a1Bean.setQ13a1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1HIVRelatedDiseasesWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
    	
    	String developmentDisability = "select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='6' ";
    	List<String> developmentDisabilityList = getEnrollmentFromDisabilities(data.getSchema(), developmentDisability);
    	if(CollectionUtils.isNotEmpty(developmentDisabilityList)) {
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    			
    		q13a1Bean.setQ13a1DevelopmentalDisabilityTotal(BigInteger.valueOf(developmentDisabilityList.size()));
        	q13a1Bean.setQ13a1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1DevelopmentalDisabilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
    
    	
    	String physicalDisabilitiy = " select enrollmentid from %s.disabilities where datacollectionstage = '1' and disabilitytype='5' ";
    	List<String> physicalDisabilitiyList = getEnrollmentFromDisabilities(data.getSchema(), physicalDisabilitiy);
    	if(CollectionUtils.isNotEmpty(physicalDisabilitiyList)) {
    		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
    			
    	   	q13a1Bean.setQ13a1PhysicalDisabilityTotal(BigInteger.valueOf(physicalDisabilitiyList.size()));
        	q13a1Bean.setQ13a1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
        	q13a1Bean.setQ13a1PhysicalDisabilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
        	q13a1Bean.setQ13a1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
        	q13a1Bean.setQ13a1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	}
	} catch (Exception e) {
		logger.error("Error in Q13a1BeanMaker:" + e);
	}
		return Arrays.asList(q13a1Bean);
	}

}
