package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.report.bean.Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.EnrollmentModel;

public class Q13c1BeanMaker extends BaseBeanMaker{
	
	public static List<Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean> getQ13c1PhysicalAndMentalHealthConditionsForStayersList(ReportData data){
	
	Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean q13c1Bean= new Q13c1PhysicalAndMentalHealthConditionsForStayersDataBean();
	if(data.isLiveMode()) {
	try{
	
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
	
	String mentalHealthQuery = "   select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and  datacollectionstage in ('1','2','5') and disabilitytype='9' ";
	List<String> mentalHealthList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(), data, mentalHealthQuery);
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
			
		q13c1Bean.setQ13c1MentalIllnessTotal(BigInteger.valueOf(mentalHealthList.size()));
    	q13c1Bean.setQ13c1MentalIllnessWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1MentalIllnessWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1MentalIllnessWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1MentalIllnessUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String alcoholQuery = "  select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and  datacollectionstage in ('1','2','5')   and disabilitytype='10' and disabilityresponse='1' ";
	List<String> alcoholList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data,alcoholQuery);
	if(CollectionUtils.isNotEmpty(alcoholList)) {
		
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> alcoholList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		
		q13c1Bean.setQ13c1AlcoholAbuseTotal(BigInteger.valueOf(alcoholList.size()));
    	q13c1Bean.setQ13c1AlcoholAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1AlcoholAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1AlcoholAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1AlcoholAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	String drugQuery = "  select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and  datacollectionstage in ('1','2','5')   and disabilitytype='10' and disabilityresponse='2'";
 	List<String> drugList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, drugQuery);
	if(CollectionUtils.isNotEmpty(drugList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> drugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		
		q13c1Bean.setQ13c1DrugAbuseTotal(BigInteger.valueOf(drugList.size()));
    	q13c1Bean.setQ13c1DrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1DrugAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1DrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1DrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	
	String alcoholAndDrugQuery = "  select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5')  and disabilitytype='10' and disabilityresponse='3' ";
	List<String> alcoholAndDrugList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, alcoholAndDrugQuery);
	if(CollectionUtils.isNotEmpty(alcoholAndDrugList)) {
 		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> alcoholAndDrugList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseTotal(BigInteger.valueOf(alcoholAndDrugList.size()));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1BothAlcoholAndDrugAbuseUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
    	
	}
	String chronicHealthCondition = " select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5')   and disabilitytype='7' ";
	List<String> chronicHealthConditionList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, chronicHealthCondition);
	if(CollectionUtils.isNotEmpty(chronicHealthConditionList)) {	
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> chronicHealthConditionList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1ChronicHealthConditionTotal(BigInteger.valueOf(chronicHealthConditionList.size()));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1ChronicHealthConditionWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1ChronicHealthConditionUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String hivaids = "select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5')   and disabilitytype='8' ";
	List<String> hivaidsList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, hivaids);
	if(CollectionUtils.isNotEmpty(hivaidsList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> hivaidsList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1HIVRelatedDiseasesTotal(BigInteger.valueOf(hivaidsList.size()));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1HIVRelatedDiseasesUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	
	String developmentDisability =   "select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5')   and disabilitytype='6' ";
	List<String> developmentDisabilityList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, developmentDisability);
	if(CollectionUtils.isNotEmpty(developmentDisabilityList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> developmentDisabilityList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
		q13c1Bean.setQ13c1DevelopmentalDisabilityTotal(BigInteger.valueOf(developmentDisabilityList.size()));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1DevelopmentalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}

	
	String physicalDisabilitiy = "   select distinct(e.id) from %s.disabilities d, %s.enrollment e where e.id =d.enrollmentid and   datacollectionstage in ('1','2','5')   and disabilitytype='5' ";
	List<String> physicalDisabilitiyList = getEnrollmentFromDisabilitiesWithInformationDate(data.getSchema(),data, physicalDisabilitiy);
	if(CollectionUtils.isNotEmpty(physicalDisabilitiyList)) {
		List<EnrollmentModel> withChildren = enrollmentsHHWithChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOutChildren = enrollmentsHHWithOutChildren.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> unknownHouseHold = enrollmentsUnknownHouseHold.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
		List<EnrollmentModel> withOneAdultChild = enrollmentsHHWithOneAdultChild.parallelStream().filter(enrollment -> physicalDisabilitiyList.contains(enrollment.getProjectEntryID())).collect(Collectors.toList());
			
	   	q13c1Bean.setQ13c1PhysicalDisabilityTotal(BigInteger.valueOf(physicalDisabilitiyList.size()));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithoutChildren(BigInteger.valueOf(withOutChildren != null ?withOutChildren.size() :0));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithChildAndAdults(BigInteger.valueOf(withOneAdultChild != null ? withOneAdultChild.size() : 0));
    	q13c1Bean.setQ13c1PhysicalDisabilityWithOnlychildren(BigInteger.valueOf(withChildren != null ?withChildren.size():0));
    	q13c1Bean.setQ13c1PhysicalDisabilityUnknowHousehold(BigInteger.valueOf(unknownHouseHold != null ?unknownHouseHold.size() :0));
	}
	} catch (Exception e) {
		logger.error("Error in Q13c1BeanMaker:" + e);
	}
	}
	return Arrays.asList(q13c1Bean);
	
	}


}
