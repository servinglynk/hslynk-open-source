package com.servinglynk.hmis.warehouse.notification.business.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.servinglynk.hmis.warehouse.report.model.ExhibitOne;
import com.servinglynk.hmis.warehouse.report.model.ExhibitTwo;

public class TestData {

	public static List<ExhibitOne> getPointinTimeCounts(){
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("273");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("427");
		exhibitOne.setIndividualsInTransitionalHousing("895");
		exhibitOne.setPersonsInEmergenceShelters("130");
		exhibitOne.setPersonsInPermanentSupportiveHousing("956");
		exhibitOne.setPersonsInTransitionalHousing("527");
		exhibitOne.setTitle("Estimated Total on an Average Night");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("3208");
		data.add(exhibitOne);
		return data;
	}
	
	public static List<ExhibitOne>  getEstimatedData(){
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("2819");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("1152");
		exhibitOne.setIndividualsInTransitionalHousing("1030");
		exhibitOne.setPersonsInEmergenceShelters("583");
		exhibitOne.setPersonsInPermanentSupportiveHousing("646");
		exhibitOne.setPersonsInTransitionalHousing("2509");
		exhibitOne.setTitle("Estimated Total Count for Period");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("8739");
		data.add(exhibitOne);
		return data;
	}

	public static List<ExhibitOne> getOnSingleNightIn() {
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("136");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("416");
		exhibitOne.setIndividualsInTransitionalHousing("837");
		exhibitOne.setPersonsInEmergenceShelters("4");
		exhibitOne.setPersonsInPermanentSupportiveHousing("1044");
		exhibitOne.setPersonsInTransitionalHousing("506");
		exhibitOne.setTitle("October 2011");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("2943");
		data.add(exhibitOne);
		
		ExhibitOne exhibitOne1 = new ExhibitOne();
		
		exhibitOne1.setIndividualsInEmergenceShelters("602");
		exhibitOne1.setIndividualsInPermanentSupportiveHousing("386");
		exhibitOne1.setIndividualsInTransitionalHousing("853");
		exhibitOne1.setPersonsInEmergenceShelters("203");
		exhibitOne1.setPersonsInPermanentSupportiveHousing("941");
		exhibitOne1.setPersonsInTransitionalHousing("502");
		exhibitOne1.setTitle("January 2012");
		exhibitOne1.setTotalHomelessPersonsInAllReportCategories("2985");
		data.add(exhibitOne1);
		
		
		ExhibitOne exhibitOne2 = new ExhibitOne();
		
		exhibitOne2.setIndividualsInEmergenceShelters("135");
		exhibitOne2.setIndividualsInPermanentSupportiveHousing("445");
		exhibitOne2.setIndividualsInTransitionalHousing("897");
		exhibitOne2.setPersonsInEmergenceShelters("279");
		exhibitOne2.setPersonsInPermanentSupportiveHousing("967");
		exhibitOne2.setPersonsInTransitionalHousing("514");
		exhibitOne2.setTitle("April 2012");
		exhibitOne2.setTotalHomelessPersonsInAllReportCategories("3237");
		data.add(exhibitOne2);
		
		ExhibitOne exhibitOne3 = new ExhibitOne();
		
		exhibitOne3.setIndividualsInEmergenceShelters("135");
		exhibitOne3.setIndividualsInPermanentSupportiveHousing("457");
		exhibitOne3.setIndividualsInTransitionalHousing("949");
		exhibitOne3.setPersonsInEmergenceShelters("78");
		exhibitOne3.setPersonsInPermanentSupportiveHousing("886");
		exhibitOne3.setPersonsInTransitionalHousing("555");
		exhibitOne3.setTitle("July 2012");
		exhibitOne3.setTotalHomelessPersonsInAllReportCategories("3060");
		data.add(exhibitOne3);
		return data;
	}

	public static List<ExhibitOne> getNumberOfFamilies() {
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("");
		exhibitOne.setIndividualsInTransitionalHousing("");
		exhibitOne.setPersonsInEmergenceShelters("184");
		exhibitOne.setPersonsInPermanentSupportiveHousing("841");
		exhibitOne.setPersonsInTransitionalHousing("219");
		exhibitOne.setTitle("1 year count (October 1- September 30)");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("");
		data.add(exhibitOne);
		return data;
	}

	public static List<ExhibitOne> getNumberOfFamiliesNF() {
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("136");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("416");
		exhibitOne.setIndividualsInTransitionalHousing("837");
		exhibitOne.setPersonsInEmergenceShelters("4");
		exhibitOne.setPersonsInPermanentSupportiveHousing("1044");
		exhibitOne.setPersonsInTransitionalHousing("506");
		exhibitOne.setTitle("October 2011");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("2943");
		data.add(exhibitOne);
		
		ExhibitOne exhibitOne1 = new ExhibitOne();
		
		exhibitOne1.setIndividualsInEmergenceShelters("602");
		exhibitOne1.setIndividualsInPermanentSupportiveHousing("386");
		exhibitOne1.setIndividualsInTransitionalHousing("853");
		exhibitOne1.setPersonsInEmergenceShelters("203");
		exhibitOne1.setPersonsInPermanentSupportiveHousing("941");
		exhibitOne1.setPersonsInTransitionalHousing("502");
		exhibitOne1.setTitle("January 2012");
		exhibitOne1.setTotalHomelessPersonsInAllReportCategories("2985");
		data.add(exhibitOne1);
		
		
		ExhibitOne exhibitOne2 = new ExhibitOne();
		
		exhibitOne2.setIndividualsInEmergenceShelters("135");
		exhibitOne2.setIndividualsInPermanentSupportiveHousing("445");
		exhibitOne2.setIndividualsInTransitionalHousing("897");
		exhibitOne2.setPersonsInEmergenceShelters("279");
		exhibitOne2.setPersonsInPermanentSupportiveHousing("967");
		exhibitOne2.setPersonsInTransitionalHousing("514");
		exhibitOne2.setTitle("April 2012");
		exhibitOne2.setTotalHomelessPersonsInAllReportCategories("3237");
		data.add(exhibitOne2);
		
		ExhibitOne exhibitOne3 = new ExhibitOne();
		
		exhibitOne3.setIndividualsInEmergenceShelters("135");
		exhibitOne3.setIndividualsInPermanentSupportiveHousing("457");
		exhibitOne3.setIndividualsInTransitionalHousing("949");
		exhibitOne3.setPersonsInEmergenceShelters("78");
		exhibitOne3.setPersonsInPermanentSupportiveHousing("886");
		exhibitOne3.setPersonsInTransitionalHousing("555");
		exhibitOne3.setTitle("July 2012");
		exhibitOne3.setTotalHomelessPersonsInAllReportCategories("3060");
		data.add(exhibitOne3);
		return data;
	}

	public static List<ExhibitOne> getEstimatedUtilizationAndTurnoverRates() {
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("136");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("416");
		exhibitOne.setIndividualsInTransitionalHousing("837");
		exhibitOne.setPersonsInEmergenceShelters("4");
		exhibitOne.setPersonsInPermanentSupportiveHousing("1044");
		exhibitOne.setPersonsInTransitionalHousing("506");
		exhibitOne.setTitle("October 2011");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("2943");
		data.add(exhibitOne);
		
		ExhibitOne exhibitOne1 = new ExhibitOne();
		
		exhibitOne1.setIndividualsInEmergenceShelters("602");
		exhibitOne1.setIndividualsInPermanentSupportiveHousing("386");
		exhibitOne1.setIndividualsInTransitionalHousing("853");
		exhibitOne1.setPersonsInEmergenceShelters("203");
		exhibitOne1.setPersonsInPermanentSupportiveHousing("941");
		exhibitOne1.setPersonsInTransitionalHousing("502");
		exhibitOne1.setTitle("January 2012");
		exhibitOne1.setTotalHomelessPersonsInAllReportCategories("2985");
		data.add(exhibitOne1);
		
		
		ExhibitOne exhibitOne2 = new ExhibitOne();
		
		exhibitOne2.setIndividualsInEmergenceShelters("135");
		exhibitOne2.setIndividualsInPermanentSupportiveHousing("445");
		exhibitOne2.setIndividualsInTransitionalHousing("897");
		exhibitOne2.setPersonsInEmergenceShelters("279");
		exhibitOne2.setPersonsInPermanentSupportiveHousing("967");
		exhibitOne2.setPersonsInTransitionalHousing("514");
		exhibitOne2.setTitle("April 2012");
		exhibitOne2.setTotalHomelessPersonsInAllReportCategories("3237");
		data.add(exhibitOne2);
		
		ExhibitOne exhibitOne3 = new ExhibitOne();
		
		exhibitOne3.setIndividualsInEmergenceShelters("135");
		exhibitOne3.setIndividualsInPermanentSupportiveHousing("457");
		exhibitOne3.setIndividualsInTransitionalHousing("949");
		exhibitOne3.setPersonsInEmergenceShelters("78");
		exhibitOne3.setPersonsInPermanentSupportiveHousing("886");
		exhibitOne3.setPersonsInTransitionalHousing("555");
		exhibitOne3.setTitle("July 2012");
		exhibitOne3.setTotalHomelessPersonsInAllReportCategories("3060");
		data.add(exhibitOne3);
		return data;
	}

	public static List<ExhibitOne> getEstimatedCountsByHouseholdType() {
		List<ExhibitOne> data = new ArrayList<ExhibitOne>();
		ExhibitOne exhibitOne = new ExhibitOne();
		
		exhibitOne.setIndividualsInEmergenceShelters("136");
		exhibitOne.setIndividualsInPermanentSupportiveHousing("416");
		exhibitOne.setIndividualsInTransitionalHousing("837");
		exhibitOne.setPersonsInEmergenceShelters("4");
		exhibitOne.setPersonsInPermanentSupportiveHousing("1044");
		exhibitOne.setPersonsInTransitionalHousing("506");
		exhibitOne.setTitle("October 2011");
		exhibitOne.setTotalHomelessPersonsInAllReportCategories("2943");
		data.add(exhibitOne);
		
		ExhibitOne exhibitOne1 = new ExhibitOne();
		
		exhibitOne1.setIndividualsInEmergenceShelters("602");
		exhibitOne1.setIndividualsInPermanentSupportiveHousing("386");
		exhibitOne1.setIndividualsInTransitionalHousing("853");
		exhibitOne1.setPersonsInEmergenceShelters("203");
		exhibitOne1.setPersonsInPermanentSupportiveHousing("941");
		exhibitOne1.setPersonsInTransitionalHousing("502");
		exhibitOne1.setTitle("January 2012");
		exhibitOne1.setTotalHomelessPersonsInAllReportCategories("2985");
		data.add(exhibitOne1);
		
		
		ExhibitOne exhibitOne2 = new ExhibitOne();
		
		exhibitOne2.setIndividualsInEmergenceShelters("135");
		exhibitOne2.setIndividualsInPermanentSupportiveHousing("445");
		exhibitOne2.setIndividualsInTransitionalHousing("897");
		exhibitOne2.setPersonsInEmergenceShelters("279");
		exhibitOne2.setPersonsInPermanentSupportiveHousing("967");
		exhibitOne2.setPersonsInTransitionalHousing("514");
		exhibitOne2.setTitle("April 2012");
		exhibitOne2.setTotalHomelessPersonsInAllReportCategories("3237");
		data.add(exhibitOne2);
		
		ExhibitOne exhibitOne3 = new ExhibitOne();
		
		exhibitOne3.setIndividualsInEmergenceShelters("135");
		exhibitOne3.setIndividualsInPermanentSupportiveHousing("457");
		exhibitOne3.setIndividualsInTransitionalHousing("949");
		exhibitOne3.setPersonsInEmergenceShelters("78");
		exhibitOne3.setPersonsInPermanentSupportiveHousing("886");
		exhibitOne3.setPersonsInTransitionalHousing("555");
		exhibitOne3.setTitle("July 2012");
		exhibitOne3.setTotalHomelessPersonsInAllReportCategories("3060");
		data.add(exhibitOne3);
		return data;
	}
	
	
	public static List<ExhibitTwo> getExhibitTwoData(){
		List<ExhibitTwo> data = new ArrayList<ExhibitTwo>();
		
		Random random = new Random();
		
		for(int i=0;i<10;i++){
			ExhibitTwo two = new ExhibitTwo();
			two.setDescription("Description__"+System.currentTimeMillis());
			two.setIndividualsInEmergenceShelters(""+random.nextInt());
			two.setIndividualsInPermanentSupportiveHousing(random.nextInt()+"");
			two.setIndividualsInTransitionalHousing(random.nextInt()+"");
			two.setPersonsInEmergenceShelters(random.nextInt()+"");
			two.setPersonsInPermanentSupportiveHousing(random.nextInt()+"");
			two.setPersonsInTransitionalHousing(random.nextInt()+"");
			two.setSource("Source_____"+System.currentTimeMillis());
			two.setStep("Step___________"+System.currentTimeMillis());
			two.setType("TYPE_________________"+System.currentTimeMillis());
			data.add(two);
		}
				
		return data;
	}
	
}
