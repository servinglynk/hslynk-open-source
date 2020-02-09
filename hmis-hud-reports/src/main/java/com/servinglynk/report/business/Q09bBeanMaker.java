package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q09bNumberofPersonsEngagedDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.CurrentLivingSituationModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;

public class Q09bBeanMaker extends BaseBeanMaker {
	
	public static List<Q09bNumberofPersonsEngagedDataBean> getQ09bNumberofPersonsEngagedList(ReportData data){
		Q09bNumberofPersonsEngagedDataBean q09BNumberOfPersonsEngaged = new Q09bNumberofPersonsEngagedDataBean();
		if(data.isLiveMode()) {
		try {
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<ContactModel> contacts = getContacts(data.getSchema());
		List<String> enrollmentIds = data.getEnrollmentIds();
		List<CurrentLivingSituationModel> currentLivingSituations = getCurrentLivingSituationModel(data.getSchema(),data);
		List<ContactModel> filteredContacts = contacts.parallelStream().filter(contact -> enrollmentIds.contains(contact.getEnrollmentId())).collect(Collectors.toList());
		List<DateOfEngagementModel> dateOfEngagements = getDateOfEngagements(data.getSchema());
		data.setContacts(filteredContacts);
		List<DateOfEngagementModel> filteredDOE = dateOfEngagements.parallelStream().filter(doe -> enrollmentIds.contains(doe.getEnrollmentId())).collect(Collectors.toList());
		data.setDateOfEngagements(filteredDOE);

		if(CollectionUtils.isNotEmpty(filteredContacts)) {
			   Map<String, Long> totalContacts = filteredContacts.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				  Collection<Long> values = totalContacts.values();
				   List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
				   List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
				   List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
				   List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
					 
					q09BNumberOfPersonsEngaged.setTotEngagedAfter1Contract(BigInteger.valueOf(totalOnce != null ?totalOnce.size() :0));
					q09BNumberOfPersonsEngaged.setTotEngagedAfter2to5Contract(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09BNumberOfPersonsEngaged.setTotEngagedAfter6to9Contract(BigInteger.valueOf(total6and9 != null ? total6and9.size() : 0));
					q09BNumberOfPersonsEngaged.setTotEngagedAfter10orMoreContract(BigInteger.valueOf(total10up != null ? total10up.size() : 0));
					q09BNumberOfPersonsEngaged.setTotPersonsEngaged(BigInteger.valueOf(totalContacts != null ? totalContacts.size() : 0));
					BigInteger totPersonsContacted = data.getTotPersonsContacted();
					if(totPersonsContacted != BigInteger.ZERO && totalContacts.size() !=0) {
						q09BNumberOfPersonsEngaged.setTotRateOfEngagement(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTotPersonsEngaged()));
					}
			   }
			   
		}
		
		
		
		Map<String,Date> notStayingOnStreetsEnrollmentMap = new HashMap<>();
//		a.	Column C = anything other than 16, 1, 18, 37, 8, 9, 99
		List<String> notStayingOnStreetsExcludeList = Arrays.asList("16", "1", "18", "37", "8", "9", "99");
		enrollments.forEach(enrollment->    filterEnrollmentsByLivingSitation(notStayingOnStreetsEnrollmentMap, enrollment, currentLivingSituations,null,notStayingOnStreetsExcludeList)   );
		
//		b.	Column D = 16, 1, 18
		Map<String,Date> stayingOnStreetsEnrollmentMap = new HashMap<>();
		List<String> stayingOnStreetsIncludeList = Arrays.asList("16", "1", "18");
		enrollments.forEach(enrollment->    filterEnrollmentsByLivingSitation(stayingOnStreetsEnrollmentMap, enrollment, currentLivingSituations,stayingOnStreetsIncludeList,null)   );
//		c.	Column E = 37, 8, 9, 99		
		Map<String,Date> unabletoDetermineEnrollmentMap = new HashMap<>();
		List<String> unabletoDetermineIncludeList = Arrays.asList("37", "8", "9", "99");
		enrollments.forEach(enrollment->    filterEnrollmentsByLivingSitation(unabletoDetermineEnrollmentMap, enrollment, currentLivingSituations,unabletoDetermineIncludeList,null)   );
		
		
		
		Map<String,Date> dateOfEngagementMap = new HashMap<>();
		dateOfEngagements.forEach(doe-> dateOfEngagementMap.put(doe.getEnrollmentId(), doe.getDateOfEngagement()));
		List<ExitModel> exits = data.getExits();
		Map<String,Date> exitMap = new HashMap<>();
		exits.forEach(exit-> exitMap.put(exit.getProjectEntryID(), exit.getExitdate()));

		List<ContactModel> notStayingOnStreetSseperatedContacts = new ArrayList<>();
		filteredContacts.forEach(
				contact ->  { filterContacts(contact, notStayingOnStreetSseperatedContacts,notStayingOnStreetsEnrollmentMap,dateOfEngagementMap,exitMap,data); }
				);
		List<ContactModel> stayingOnStreetsseperatedContacts = new ArrayList<>();
		filteredContacts.forEach(
				contact ->  { filterContacts(contact, stayingOnStreetsseperatedContacts,stayingOnStreetsEnrollmentMap,dateOfEngagementMap,exitMap,data); }
				);
		List<ContactModel> unabletoDetermineSeperatedContacts = new ArrayList<>();
		filteredContacts.forEach(
				contact ->  { filterContacts(contact, unabletoDetermineSeperatedContacts,unabletoDetermineEnrollmentMap,dateOfEngagementMap,exitMap,data); }
				);
		List<ContactModel> notStayingOnStreets = notStayingOnStreetSseperatedContacts.parallelStream().filter(contact -> StringUtils.equals("0", contact.getContactLocation())).collect(Collectors.toList());
		List<ContactModel> stayingOnStreets = stayingOnStreetsseperatedContacts.parallelStream().filter(contact ->StringUtils.equals("1", contact.getContactLocation())).collect(Collectors.toList());
		List<ContactModel> unabletoDetermine = unabletoDetermineSeperatedContacts.parallelStream().filter(contact -> contact.getContactLocation() == null || StringUtils.equals("2", contact.getContactLocation())).collect(Collectors.toList());
		
		
		if(CollectionUtils.isNotEmpty(stayingOnStreets)) {
			 Map<String, Long> totalContacts = stayingOnStreets.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				   Collection<Long> values = totalContacts.values();
					List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
					List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
					List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
					List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
					
					q09BNumberOfPersonsEngaged.setEngFirstContactNotStaying(BigInteger.valueOf(totalOnce != null ?totalOnce.size() :0));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactNotStaying(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactNotStaying(BigInteger.valueOf(total6and9 != null ? total6and9.size() : 0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactNotStaying(BigInteger.valueOf(total10up != null ? total10up.size() : 0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactNotStaying(BigInteger.valueOf(stayingOnStreets.size()));
					
					BigInteger totPersonsContacted = data.getTpcFirstContactedHumanHabitation();
					if(totPersonsContacted != BigInteger.ZERO && stayingOnStreets.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactNotStaying(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactNotStaying()));
					}
			   }
		}
	
		
		if(CollectionUtils.isNotEmpty(notStayingOnStreets)) {
			 Map<String, Long> totalContacts = notStayingOnStreets.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				   Collection<Long> values = totalContacts.values();
					List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
					List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
					List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
					List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
				
					q09BNumberOfPersonsEngaged.setEngFirstContactStaying(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0 ));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactStaying(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactStaying(BigInteger.valueOf(total6and9 != null ? total6and9.size() :0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactStaying(BigInteger.valueOf(total10up != null ? total10up.size() :0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactStaying(BigInteger.valueOf(notStayingOnStreets.size()));
					BigInteger totPersonsContacted = data.getTpcFirstContactedNRSS();
					if(totPersonsContacted != BigInteger.ZERO && notStayingOnStreets.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactStaying(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactStaying()));
					}
			   	}
		}
		
		if(CollectionUtils.isNotEmpty(unabletoDetermine)) {
			 Map<String, Long> totalContacts = unabletoDetermine.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				   Collection<Long> values = totalContacts.values();
					List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
					List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
					List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
					List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
				
					q09BNumberOfPersonsEngaged.setEngFirstContactWorkerUnableToDetermine(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactWorkerUnableToDetermine(BigInteger.valueOf(total2and5 != null ?total2and5.size() :0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactWorkerUnableToDetermine(BigInteger.valueOf(total6and9 != null ?total6and9.size() :0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactWorkerUnableToDetermine(BigInteger.valueOf(total10up != null ? total10up.size() :0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactWorkerUnableToDetermine(BigInteger.valueOf(unabletoDetermine.size()));
					BigInteger totPersonsContacted = data.getTpcFirstContactedPlaceMissing();
					if(totPersonsContacted != BigInteger.ZERO && unabletoDetermine.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactWorkerUnableToDetermine(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactWorkerUnableToDetermine()));
					}
				   }
		}
	} catch (Exception e) {
		logger.error("Error in Q09bDataBeanMaker:" + e);
	}
	}
		return Arrays.asList(q09BNumberOfPersonsEngaged);
	}
	
	/** a. [date of contact] >= [project start date]   == get all the enrollments where date of contact is greater than project start date
	b. [project exit date] is null or [date of contact] <= [project exit date]   == 
	c. [date of contact] <= [date of engagement] (or the [date of engagement] is null)
	d. [date of contact] <= [report end date]
	**/
	private static void filterContacts(ContactModel contact, List<ContactModel> seperatedContacts,
			Map<String, Date> enrollmentMap, Map<String, Date> dateOfEngagementMap, Map<String, Date> exitMap,ReportData data) {
		Date contactDate = contact.getContactDate();
		Date projectStartDate = enrollmentMap.get(contact.getEnrollmentId());
		if(contactDate != null && projectStartDate !=null) {
			if(contactDate.compareTo(projectStartDate) >= 0 && contactDate.compareTo(data.getReportEndDate()) <=0)  {
				Date dateOfEngagement = dateOfEngagementMap.get(contact.getEnrollmentId());
				Date dateOfExit = exitMap.get(contact.getEnrollmentId());
				if((dateOfEngagement != null && contactDate.compareTo(dateOfEngagement) <=0  
						&& dateOfEngagement.compareTo(data.getReportEndDate()) <= 0 
						&& dateOfEngagement.compareTo(data.getReportStartDate()) >= 0 ) 
						&& ((dateOfExit == null) && contactDate.compareTo(dateOfExit) <= 0))  {
					seperatedContacts.add(contact);
				}
			}
		}
	}
	
	/***
	 * Filter enrollments via their current living situation: I'm also adding the enrollmentMap if the currentliving sitation is 
	 * a.	Column C = anything other than 16, 1, 18, 37, 8, 9, 99
		b.	Column D = 16, 1, 18
		c.	Column E = 37, 8, 9, 99
	 * @param enrollmentMap
	 * @param enrollment
	 * @param currentLivingSituations
	 * @param includeList
	 * @param excludeList
	 */
	private static void filterEnrollmentsByLivingSitation(Map<String, Date> enrollmentMap, EnrollmentModel enrollment, List<CurrentLivingSituationModel>  currentLivingSituations, List<String> includeList, List<String> excludeList) {
		if(CollectionUtils.isNotEmpty(currentLivingSituations)) {
			List<CurrentLivingSituationModel> currentLivingSituation = currentLivingSituations.parallelStream().filter(currentLivingSitation -> StringUtils.equals(currentLivingSitation.getEnrollmentId(), enrollment.getProjectEntryID()) &&  ((includeList!=null && includeList.contains(currentLivingSitation.getLivingsituation()))  || (excludeList!=null && !excludeList.contains(currentLivingSitation.getLivingsituation()) ))).collect(Collectors.toList());
			if(CollectionUtils.isNotEmpty(currentLivingSituation)) {
				enrollmentMap.put(enrollment.getProjectEntryID(), enrollment.getEntrydate());
			}
		}else {
			enrollmentMap.put(enrollment.getProjectEntryID(), enrollment.getEntrydate());
		}
	}
	public static void main(String args[]) {
		List<ContactModel> filteredContacts = new ArrayList<ContactModel>();
		ContactModel contact1 = new ContactModel("contactID", "enrollmentId", new Date(), "1", "sourceSystemId");
		ContactModel contact2 = new ContactModel("contactID", "enrollmentI1", new Date(), "1", "sourceSystemId");
		ContactModel contact3 = new ContactModel("contactID", "enrollmentId", new Date(), "2", "sourceSystemId");
		ContactModel contact4 = new ContactModel("contactID", "enrollmentI2", new Date(), "3", "sourceSystemId");
		ContactModel contact5 = new ContactModel("contactID", "enrollmentId", new Date(), "1", "sourceSystemId");
		ContactModel contact6 = new ContactModel("contactID", "enrollmentId", new Date(), "0", "sourceSystemId");
		
		filteredContacts.add(contact1);
		filteredContacts.add(contact2);
		filteredContacts.add(contact3);
		filteredContacts.add(contact4);
		filteredContacts.add(contact5);
		filteredContacts.add(contact6);
		
		Map<String, Long> collect = filteredContacts.stream().collect(Collectors.groupingBy(ContactModel::getContactLocation, Collectors.counting()));
		List<Long> totalOnce = collect.values().parallelStream().filter(count -> count == 1).collect(Collectors.toList());
		System.out.println(totalOnce.toString());	
	}

}
