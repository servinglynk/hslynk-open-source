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

import com.servinglynk.report.bean.Q09aDataBean;
import com.servinglynk.report.bean.Q09bDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;

public class Q09bBeanMaker extends BaseBeanMaker {
	
	public static List<Q09bDataBean> getQ09bNumberofPersonsEngagedList(ReportData data){
		Q09bDataBean q09BNumberOfPersonsEngaged = new Q09bDataBean();
		try {
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<ContactModel> contacts = getContacts(data.getSchema());
		List<String> enrollmentIds = data.getEnrollmentIds();
		List<ContactModel> filteredContacts = contacts.parallelStream().filter(contact -> enrollmentIds.contains(contact.getEnrollmentId())).collect(Collectors.toList());
		List<DateOfEngagementModel> dateOfEngagements = getDateOfEngagements(data.getSchema());
		data.setContacts(filteredContacts);
		List<DateOfEngagementModel> filteredDOE = dateOfEngagements.parallelStream().filter(doe -> enrollmentIds.contains(doe.getEnrollmentId())).collect(Collectors.toList());
		data.setDateOfEngagements(filteredDOE);

		
//		q09BNumberOfPersonsEngaged.setEngFirstContactRSS(BigInteger.valueOf(0));
//		q09BNumberOfPersonsEngaged.setEng2to5FirstContactRSS(BigInteger.valueOf(0));
//		q09BNumberOfPersonsEngaged.setEng6to9FirstContactRSS(BigInteger.valueOf(0));
//		q09BNumberOfPersonsEngaged.setEng10FirstContactRSS(BigInteger.valueOf(0));
//		q09BNumberOfPersonsEngaged.setRoeFirstContactRSS(BigInteger.valueOf(0));
		
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
		Map<String,Date> enrollmentMap = new HashMap<>();
		enrollments.parallelStream().forEach(enrollment-> enrollmentMap.put(enrollment.getProjectEntryID(), enrollment.getEntrydate()));
		Map<String,Date> dateOfEngagementMap = new HashMap<>();
		dateOfEngagements.parallelStream().forEach(doe-> dateOfEngagementMap.put(doe.getEnrollmentId(), doe.getDateOfEngagement()));
		List<ExitModel> exits = data.getExits();
		Map<String,Date> exitMap = new HashMap<>();
		exits.parallelStream().forEach(exit-> exitMap.put(exit.getProjectEntryID(), exit.getExitdate()));
		
		List<ContactModel> seperatedContacts = new ArrayList<>();
		filteredContacts.parallelStream().forEach(
				contact ->  { filterContacts(contact, seperatedContacts,enrollmentMap,dateOfEngagementMap,exitMap,data); }
				);
		
		List<ContactModel> notStayingOnStreets = seperatedContacts.parallelStream().filter(contact -> StringUtils.equals("0", contact.getContactLocation())).collect(Collectors.toList());
		List<ContactModel> stayingOnStreets = seperatedContacts.parallelStream().filter(contact ->StringUtils.equals("1", contact.getContactLocation())).collect(Collectors.toList());
		List<ContactModel> unabletoDetermine = seperatedContacts.parallelStream().filter(contact -> contact.getContactLocation() == null || StringUtils.equals("2", contact.getContactLocation())).collect(Collectors.toList());
		
		if(CollectionUtils.isNotEmpty(stayingOnStreets)) {
			 Map<String, Long> totalContacts = stayingOnStreets.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				   Collection<Long> values = totalContacts.values();
					List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
					List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
					List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
					List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
					
					q09BNumberOfPersonsEngaged.setEngFirstContactHumanHabitation(BigInteger.valueOf(totalOnce != null ?totalOnce.size() :0));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactHumanHabitation(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactHumanHabitation(BigInteger.valueOf(total6and9 != null ? total6and9.size() : 0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactHumanHabitation(BigInteger.valueOf(total10up != null ? total10up.size() : 0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactHumanHabitation(BigInteger.valueOf(stayingOnStreets.size()));
					
					BigInteger totPersonsContacted = data.getTpcFirstContactedHumanHabitation();
					if(totPersonsContacted != BigInteger.ZERO && stayingOnStreets.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactHumanHabitation(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactHumanHabitation()));
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
				
					q09BNumberOfPersonsEngaged.setEngFirstContactNRSS(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0 ));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactNRSS(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactNRSS(BigInteger.valueOf(total6and9 != null ? total6and9.size() :0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactNRSS(BigInteger.valueOf(total10up != null ? total10up.size() :0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactNRSS(BigInteger.valueOf(notStayingOnStreets.size()));
					BigInteger totPersonsContacted = data.getTpcFirstContactedNRSS();
					if(totPersonsContacted != BigInteger.ZERO && notStayingOnStreets.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactNRSS(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactNRSS()));
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
				
					q09BNumberOfPersonsEngaged.setEngFirstContactPlaceMissing(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0));
					q09BNumberOfPersonsEngaged.setEng2to5FirstContactPlaceMissing(BigInteger.valueOf(total2and5 != null ?total2and5.size() :0));
					q09BNumberOfPersonsEngaged.setEng6to9FirstContactPlaceMissing(BigInteger.valueOf(total6and9 != null ?total6and9.size() :0));
					q09BNumberOfPersonsEngaged.setEng10FirstContactPlaceMissing(BigInteger.valueOf(total10up != null ? total10up.size() :0));
					q09BNumberOfPersonsEngaged.setTpeFirstContactPlaceMissing(BigInteger.valueOf(unabletoDetermine.size()));
					BigInteger totPersonsContacted = data.getTpcFirstContactedPlaceMissing();
					if(totPersonsContacted != BigInteger.ZERO && unabletoDetermine.size() !=0) {
						q09BNumberOfPersonsEngaged.setRoeFirstContactPlaceMissing(totPersonsContacted.divide(q09BNumberOfPersonsEngaged.getTpeFirstContactPlaceMissing()));
					}
				   }
		}
	} catch (Exception e) {
		logger.error("Error in Q09bDataBeanMaker:" + e);
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
