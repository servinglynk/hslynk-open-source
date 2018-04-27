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
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ContactModel;
import com.servinglynk.report.model.DateOfEngagementModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.ExitModel;

public class Q09aDataBeanMaker extends BaseBeanMaker {
	
	public static List<Q09aDataBean> getQ09aNumberPersonsContactedList(ReportData data){
		
		List<EnrollmentModel> enrollments = data.getEnrollments();
		List<ContactModel> contacts = getContacts(data.getSchema());
		List<String> enrollmentIds = data.getEnrollmentIds();
		List<ContactModel> filteredContacts = contacts.parallelStream().filter(contact -> enrollmentIds.contains(contact.getEnrollmentId())).collect(Collectors.toList());
		List<DateOfEngagementModel> dateOfEngagements = getDateOfEngagements(data.getSchema());
		data.setContacts(filteredContacts);
		List<DateOfEngagementModel> filteredDOE = dateOfEngagements.parallelStream().filter(doe -> enrollmentIds.contains(doe.getEnrollmentId())).collect(Collectors.toList());
		data.setDateOfEngagements(filteredDOE);
		Q09aDataBean q09aNumberPersonsContactedDataBean=new Q09aDataBean();
		if(CollectionUtils.isNotEmpty(filteredContacts)) {
			   Map<String, Long> totalContacts = filteredContacts.stream().collect(Collectors.groupingBy(ContactModel::getEnrollmentId, Collectors.counting()));
			   if(totalContacts != null) {
				  Collection<Long> values = totalContacts.values();
				   List<Long> totalOnce = values.parallelStream().filter(count -> count == 1).collect(Collectors.toList());
				   List<Long> total2and5 = values.parallelStream().filter(count -> count >= 2 && count <=5).collect(Collectors.toList());
				   List<Long> total6and9 = values.parallelStream().filter(count -> count >= 6 && count <=9).collect(Collectors.toList());
				   List<Long> total10up = values.parallelStream().filter(count -> count >= 10).collect(Collectors.toList());
					 
				   q09aNumberPersonsContactedDataBean.setTotContactedOnce(BigInteger.valueOf(totalOnce != null ?totalOnce.size() :0));
				   q09aNumberPersonsContactedDataBean.setTotContacted2to5Times(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
				   q09aNumberPersonsContactedDataBean.setTotContacted6to9Times(BigInteger.valueOf(total6and9 != null ? total6and9.size() : 0));
				   q09aNumberPersonsContactedDataBean.setTotContacted10orMore(BigInteger.valueOf(total10up != null ? total10up.size() : 0));
				   q09aNumberPersonsContactedDataBean.setTotPersonsContacted(BigInteger.valueOf(totalContacts != null ? totalContacts.size() : 0));
				   data.setTotPersonsContacted(BigInteger.valueOf(totalContacts != null ? totalContacts.size() : 0));
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
					q09aNumberPersonsContactedDataBean.setCoFirstContactHumanHabitation(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0 ));
					q09aNumberPersonsContactedDataBean.setC2to5FirstContactedHumanHabitation(BigInteger.valueOf(total2and5 != null ? total2and5.size() :0));
					q09aNumberPersonsContactedDataBean.setC6to9FirstContactedHumanHabitation(BigInteger.valueOf(total6and9 != null ?total6and9.size() : 0));
					q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedHumanHabitation(BigInteger.valueOf(total10up != null ? total10up.size() : 0));
					q09aNumberPersonsContactedDataBean.setTpcFirstContactedHumanHabitation(BigInteger.valueOf(stayingOnStreets.size()));
					data.setTpcFirstContactedHumanHabitation(BigInteger.valueOf(stayingOnStreets.size()));
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
				
					q09aNumberPersonsContactedDataBean.setCoFirstContactNRSS(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0 ));
					q09aNumberPersonsContactedDataBean.setC2to5FirstContactedNRSS(BigInteger.valueOf(total2and5 != null ? total2and5.size() : 0));
					q09aNumberPersonsContactedDataBean.setC6to9FirstContactedNRSS(BigInteger.valueOf(total6and9 != null ? total6and9.size() :0 ));
					q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedNRSS(BigInteger.valueOf(total10up != null ? total10up.size() :0 ));
					q09aNumberPersonsContactedDataBean.setTpcFirstContactedNRSS(BigInteger.valueOf(notStayingOnStreets.size()));
					data.setTpcFirstContactedNRSS(BigInteger.valueOf(notStayingOnStreets.size()));
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
				
					q09aNumberPersonsContactedDataBean.setCoFirstContactPlaceMissing(BigInteger.valueOf(totalOnce != null ? totalOnce.size() :0));
					q09aNumberPersonsContactedDataBean.setC2to5FirstContactedPlaceMissing(BigInteger.valueOf(total2and5 != null ?total2and5.size() :0));
					q09aNumberPersonsContactedDataBean.setC6to9FirstContactedPlaceMissing(BigInteger.valueOf(total6and9 != null ?total6and9.size() :0));
					q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedPlaceMissing(BigInteger.valueOf(total10up != null ? total10up.size() :0));
					q09aNumberPersonsContactedDataBean.setTpcFirstContactedPlaceMissing(BigInteger.valueOf(unabletoDetermine.size()));
					data.setTpcFirstContactedPlaceMissing(q09aNumberPersonsContactedDataBean.getTpcFirstContactedPlaceMissing());
				   }
		}
	
//		q09aNumberPersonsContactedDataBean.setC2to5FirstContactedRSS(BigInteger.valueOf(0));
//		q09aNumberPersonsContactedDataBean.setC6to9FirstContactedRSS(BigInteger.valueOf(0));
//		q09aNumberPersonsContactedDataBean.setC10orMoreFirstContactedRSS(BigInteger.valueOf(0));
//		q09aNumberPersonsContactedDataBean.setCoFirstContactRSS(BigInteger.valueOf(0));
//		q09aNumberPersonsContactedDataBean.setTpcFirstContacteRSS(BigInteger.valueOf(0));
		
		return Arrays.asList(q09aNumberPersonsContactedDataBean);
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
				if((dateOfEngagement == null) || (dateOfEngagement != null && contactDate.compareTo(dateOfEngagement) <=0) 
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
