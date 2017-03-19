package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Timestamp;

public class DataBean_Old {

	private String homePageStartDate;
	private String homePageEndDate;
	private String homePageProjects;
	private String homePageHomeLess;
	private String homePageGrants;
	private String homePageView;
	
	private Timestamp crtdUpdtdDate;
	private Boolean delFlag;
	private BigInteger q04aHmisProjectIdService;
	private BigInteger q04aHmisProjectType;
	private BigInteger q04aIdentityProjectId;
	private BigInteger q04aMethodOfTracking;
	private String q04aOrgId;
	private String q04aOrgName;
	private BigInteger q04aProjectId;
	private String q04aProjectName;
	
	private BigInteger clientlocationForPe;
	private BigInteger destination;
	private BigInteger disablingCond;
	private BigInteger dob;
	private BigInteger ethnicity;
	private BigInteger firstName;
	private BigInteger gender;
	private BigInteger lastName;
	private BigInteger ltsInEs;
	private BigInteger mdClientlocationForPe;
	private BigInteger mdDestination;
	private BigInteger mdDisablingCond;
	private BigInteger mdDob;
	private BigInteger mdEthnicity;
	private BigInteger mdFirstName;
	private BigInteger mdGender;
	private BigInteger mdLastName;
	private BigInteger mdLtsInEsSh;
	private BigInteger mdRace;
	private BigInteger mdRelationshipToHh;
	private BigInteger mdSsn;
	private BigInteger mdVeteranStatus;
	private BigInteger mdresidencepriortoentry;
	private BigInteger race;
	private BigInteger relationshiptToHh;
	private BigInteger residencePriorToEntry;
	private BigInteger ssn;
	private BigInteger veteranStatus;
	
	private String totNumOfPersonServed;
	private String numOfAdults;
	private String numOfChildren;
	private String numOfPersonsWithUnknownAge;
	private String totNoOfLeavers;
	private String totNoOfAdultLeavers;
	private String noOfVeterans;
	private String noOfChronicallyHomelessPersons;
	private String noOfAdultHeadsOfHousehold;
	private String noOfChildHeadsOfHousehold;
	private String numOfUnaccompaniedYouthUnderAge25;
	private String numOfParentingYouthUnderAge25WithChildren;
	private String totNoOfStayers;
	private String totNoOfAdultStayers;
	
	private BigInteger countAprUht;
	private BigInteger countAprWc;
	private BigInteger countAprWca;
	private BigInteger countAprWoc;
	private BigInteger countJanUht;
	private BigInteger countJanWc;
	private BigInteger countJanWca;
	private BigInteger countJanWoc;
	private BigInteger countJulUht;
	private BigInteger countJulWc;
	private BigInteger countJulWca;
	private BigInteger countJulWoc;
	private BigInteger countOctUht;
	private BigInteger countOctWc;
	private BigInteger countOctWca;
	private BigInteger countOctWoc;
	private BigInteger npAdultsTot;
	private BigInteger npAdultsUhtTot;
	private BigInteger npAdultsWcTot;
	private BigInteger npAdultsWcaTot;
	private BigInteger npAdultsWocTot;
	private BigInteger npChildTot;
	private BigInteger npChildUhtTot;
	private BigInteger npChildWcTot;
	private BigInteger npChildWcaTot;
	private BigInteger npChildWocTot;
	private BigInteger npDkrTot;
	private BigInteger npDkrUhtTot;
	private BigInteger npDkrWcTot;
	private BigInteger npDkrWcsTot;
	private BigInteger npDkrWocTot;
	private BigInteger npMiTot;
	private BigInteger npMiUhtTot;
	private BigInteger npMiWcTot;
	private BigInteger npMiWcaTot;
	private BigInteger npMiWocTot;
	private BigInteger npTotSum;
	private BigInteger npWcSum;
	private BigInteger npWCASum;
	private BigInteger npWOCSum;
	private BigInteger npUHTSum;
	private BigInteger countJanTotal;
	private BigInteger countAprTotal;
	private BigInteger countJulTotal;
	private BigInteger countOctTotal;
	private BigInteger npTotalAdults;
	private BigInteger npTotalChildren;
	private BigInteger npTotalDKR;
	private BigInteger npTotalMI;
	private BigInteger npOverallTotal;
	private BigInteger npTotalWC;
	private BigInteger npWCATotal;
	private BigInteger npWOCTotal;
	private BigInteger npUHTTotal;
	private BigInteger janTotal;
	private BigInteger aprTotal;
	private BigInteger julyTotal;
	private BigInteger octTotal;
	
//	private List<Q07a_HouseholdsServed> q07aHouseholdsServed;
	/** 
	 * Variables for Q07a_HouseholdsServed Table -- Starts
	 **/	
	private BigInteger overAllTotHouseHolds;
	private BigInteger totHhWithoutChild;
	private BigInteger totHhWithChildAndAdults;
	private BigInteger totHhWothOnlyChild;
	private BigInteger totHhUnknownHhType;
	/** 
	 * Variables for Q07a_HouseholdsServed Table -- Ends
	 **/
	
	/** 
	 * Variables for Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Starts
	 **/
	private BigInteger hhJanTotal;
	private BigInteger hhAprTotal;
	private BigInteger hhJulTotal;
	private BigInteger hhOctTotal;
	private BigInteger hhCountJanWc;
	private BigInteger hhCountJanWca;
	private BigInteger hhCountJanWoc;
	private BigInteger hhCountJanUht;
	private BigInteger hhCountAprWc;
	private BigInteger hhCountAprWca;
	private BigInteger hhCountAprWoc;
	private BigInteger hhCountAprUht;
	private BigInteger hhCountJulWc;
	private BigInteger hhCountJulWca;
	private BigInteger hhCountJulWoc;
	private BigInteger hhCountJulUht;
	private BigInteger hhCountOctWc;
	private BigInteger hhCountOctWca;
	private BigInteger hhCountOctWoc;
	private BigInteger hhCountOctUht;
	/** 
	 * Variables for Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Ends
	 **/
	
	/** 
	 * Variables for Q09a: Number of Persons Contacted Table -- Starts
	 **/
	private BigInteger totContactedOnce;
	private BigInteger totContacted2to5Times;
	private BigInteger totContacted6to9Times;
	private BigInteger totContacted10orMore;
	private BigInteger totPersonsContacted;
	private BigInteger coFirstContactHumanHabitation;
	private BigInteger coFirstContactNRSS;
	private BigInteger coFirstContactRSS;
	private BigInteger coFirstContactPlaceMissing;
	private BigInteger c2to5FirstContactedHumanHabitation;
	private BigInteger c2to5FirstContactedNRSS;
	private BigInteger c2to5FirstContactedRSS;
	private BigInteger c2to5FirstContactedPlaceMissing;
	private BigInteger c6to9FirstContactedHumanHabitation;
	private BigInteger c6to9FirstContactedNRSS;
	private BigInteger c6to9FirstContactedRSS;
	private BigInteger c6to9FirstContactedPlaceMissing;
	private BigInteger c10orMoreFirstContactedHumanHabitation;
	private BigInteger c10orMoreFirstContactedNRSS;
	private BigInteger c10orMoreFirstContactedRSS;
	private BigInteger c10orMoreFirstContactedPlaceMissing;
	private BigInteger tpcFirstContactedHumanHabitation;
	private BigInteger tpcFirstContactedNRSS;
	private BigInteger tpcFirstContacteRSS;
	private BigInteger tpcFirstContactedPlaceMissing;
	/** 
	 * Variables for Q09a: Number of Persons Contacted Table -- Ends
	 **/
	
	/**
	 * "Q09b: Number of Persons Engaged"  Table -- Starts
	*/
	private BigInteger totEngagedAfter1Contract;
	private BigInteger totEngagedAfter2to5Contract;
	private BigInteger totEngagedAfter6to9Contract;
	private BigInteger totEngagedAfter10orMoreContract;
	private BigInteger totPersonsEngaged;
	private BigInteger totRateOfEngagement;
	private BigInteger engFirstContactHumanHabitation;
	private BigInteger engFirstContactNRSS;
	private BigInteger engFirstContactRSS;
	private BigInteger engFirstContactPlaceMissing;
	private BigInteger eng2to5FirstContactHumanHabitation;
	private BigInteger eng2to5FirstContactNRSS;
	private BigInteger eng2to5FirstContactRSS;
	private BigInteger eng2to5FirstContactPlaceMissing;
	private BigInteger eng6to9FirstContactHumanHabitation;
	private BigInteger eng6to9FirstContactNRSS;
	private BigInteger eng6to9FirstContactRSS;
	private BigInteger eng6to9FirstContactPlaceMissing;
	private BigInteger eng10FirstContactHumanHabitation;
	private BigInteger eng10FirstContactNRSS;
	private BigInteger eng10FirstContactRSS;
	private BigInteger eng10FirstContactPlaceMissing;
	private BigInteger tpeFirstContactHumanHabitation;
	private BigInteger tpeFirstContactNRSS;
	private BigInteger tpeFirstContactRSS;
	private BigInteger tpeFirstContactPlaceMissing;
	private BigInteger roeFirstContactHumanHabitation;
	private BigInteger roeFirstContactNRSS;
	private BigInteger roeFirstContactRSS;
	private BigInteger roeFirstContactPlaceMissing;
	/**
	 * "Q09b: Number of Persons Engaged"  Table -- Ends
	*/
	
	/**
	 * "Q10a: Gender of Adults"  Table -- Starts
	*/
	private BigInteger totMale;
	private BigInteger totFemale;
	private BigInteger totTransgenderMF;
	private BigInteger totOther;
	private BigInteger totDontKnowRefused;
	private BigInteger totInfoMissing;
	private BigInteger totSubtotal;
	private BigInteger maleWOC;
	private BigInteger maleWCA;
	private BigInteger maleUHHT;
	private BigInteger femaleWOC;
	private BigInteger femaleWCA;
	private BigInteger femaleUHHT;
	private BigInteger transgenderMFWOC;
	private BigInteger transgenderMFWCA;
	private BigInteger transgenderMFUHHT;
	private BigInteger otherWOC;
	private BigInteger otherWCA;
	private BigInteger otherUHHT;
	private BigInteger dkrWOC;
	private BigInteger dkrWCA;
	private BigInteger dkrUHHT;
	private BigInteger infomiisingWOC;
	private BigInteger infomiisingWCA;
	private BigInteger infomiisingUHHT;
	private BigInteger subtotalWOC;
	private BigInteger subtotalWCA;
	private BigInteger subtotalUHHT;
	private BigInteger totTransgenderFM;
	private BigInteger transgenderFMWOC;
	private BigInteger transgenderFMWCA;
	private BigInteger transgenderFMUHHT;
	/**
	 * "Q10a: Gender of Adults"  Table -- Ends
	*/
	
	/**
	 * "Q10b: Gender of Children"  Table -- Starts
	*/
	private BigInteger totChildMale;
	private BigInteger totChildFemale;
	private BigInteger totChildTransgenderMF;
	private BigInteger totChildOther;
	private BigInteger totChildDontKnowRefused;
	private BigInteger totChildInfoMissing;
	private BigInteger totChildSubtotal;
	private BigInteger childMaleWOC;
	private BigInteger childMaleWCA;
	private BigInteger childMaleUHHT;
	private BigInteger childFemaleWOC;
	private BigInteger childFemaleWCA;
	private BigInteger childFemaleUHHT;
	private BigInteger childTransgenderMFWOC;
	private BigInteger childTransgenderMFWCA;
	private BigInteger childTransgenderMFUHHT;
	private BigInteger childOtherWOC;
	private BigInteger childOtherWCA;
	private BigInteger childOtherUHHT;
	private BigInteger childDkrWOC;
	private BigInteger childDkrWCA;
	private BigInteger childDkrUHHT;
	private BigInteger childInfomiisingWOC;
	private BigInteger childInfomiisingWCA;
	private BigInteger childInfomiisingUHHT;
	private BigInteger childSubtotalWOC;
	private BigInteger childSubtotalWCA;
	private BigInteger childSubtotalUHHT;
	private BigInteger totChildTransgenderFM;
	private BigInteger childTransgenderFMWOC;
	private BigInteger childTransgenderFMWCA;
	private BigInteger childTransgenderFMUHHT;
	
	/**
	 * "Q10b: Gender of Children"  Table -- Ends
	*/
	
	/**
	 * "Q10c: Gender of Persons Missing Age Information"  Table -- Starts
	*/
	private BigInteger totMAIMale;
	private BigInteger totMAIFemale;
	private BigInteger totMAITransgenderMF;
	private BigInteger totMAIOther;
	private BigInteger totMAIDontKnowRefused;
	private BigInteger totMAIInfoMissing;
	private BigInteger totMAISubtotal;
	private BigInteger maleMAIWOC;
	private BigInteger maleMAIWCA;
	private BigInteger maleMAIUHHT;
	private BigInteger femaleMAIWOC;
	private BigInteger femaleMAIWCA;
	private BigInteger femaleMAIUHHT;
	private BigInteger transgenderMFMAIWOC;
	private BigInteger transgenderMFMAIWCA;
	private BigInteger transgenderMFMAIUHHT;
	private BigInteger otherMAIWOC;
	private BigInteger otherMAIWCA;
	private BigInteger otherMAIUHHT;
	private BigInteger dkrMAIWOC;
	private BigInteger dkrMAIWCA;
	private BigInteger dkrMAIUHHT;
	private BigInteger infomissingMAIWOC;
	private BigInteger infomissingMAIWCA;
	private BigInteger infomissingMAIUHHT;
	private BigInteger subtotalMAIWOC;
	private BigInteger subtotalMAIWCA;
	private BigInteger subtotalMAIUHHT;
	private BigInteger totMAITransgenderFM;
	private BigInteger transgenderFMMAIWOC;
	private BigInteger transgenderFMMAIWCA;
	private BigInteger transgenderFMMAIUHHT;
	private BigInteger transgenderFMMAIWithOnlyChild;
	private BigInteger subtotalMAIWithOnlyChild;
	private BigInteger infomissingMAIWithOnlyChild;
	private BigInteger dkrMAIWithOnlyChild;
	private BigInteger transgenderMFMAIWithOnlyChild;
	private BigInteger otherMAIWithOnlyChild;
	private BigInteger maleMAIWithOnlyChild;
	private BigInteger femaleMAIWithOnlyChild;
	/**
	 * "Q10c: Gender of Persons Missing Age Information"  Table -- Ends
	*/
	
	/**
	 * "Q11: Age" Table -- Starts
	 * */	
	private BigInteger totAgeUnder5;
	private BigInteger totAge5to12;
	private BigInteger totAge13to17;
	private BigInteger totAge18to24;
	private BigInteger totAge25to34;
	private BigInteger totAge35to44;
	private BigInteger totAge45to54;
	private BigInteger totAge55to61;
	private BigInteger totAge62Plus;
	private BigInteger totAgeDKR;
	private BigInteger totAgeInfoMissing;
	private BigInteger totOverallTotal;
	private BigInteger ageUnder5WOC;
	private BigInteger ageUnder5WCA;
	private BigInteger ageUnder5WithOnlyChild;
	private BigInteger ageUnder5UHHT;
	private BigInteger age5to12WOC;
	private BigInteger age5to12WCA;
	private BigInteger age5to12WithOnlyChild;
	private BigInteger age5to12UHHT;
	private BigInteger age13to17WOC;
	private BigInteger age13to17WCA;
	private BigInteger age13to17WithOnlyChild;
	private BigInteger age13to17UHHT;
	private BigInteger age18to24WOC;
	private BigInteger age18to24WCA;
	private BigInteger age18to24WithOnlyChild;
	private BigInteger age18to24UHHT;
	private BigInteger age25to34WOC;
	private BigInteger age25to34WCA;
	private BigInteger age25to34WithOnlyChild;
	private BigInteger age25to34UHHT;
	private BigInteger age35to44WOC;
	private BigInteger age35to44WCA;
	private BigInteger age35to44WithOnlyChild;
	private BigInteger age35to44UHHT;
	private BigInteger age45to54WOC;
	private BigInteger age45to54WCA;
	private BigInteger age45to54WithOnlyChild;
	private BigInteger age45to54UHHT;
	private BigInteger age55to61WOC;
	private BigInteger age55to61WCA;
	private BigInteger age55to61WithOnlyChild;
	private BigInteger age55to61UHHT;
	private BigInteger age62PlusWOC;
	private BigInteger age62PlusWCA;
	private BigInteger age62PlusWithOnlyChild;
	private BigInteger age62PlusUHHT;
	private BigInteger ageDKRWOC;
	private BigInteger ageDKRWCA;
	private BigInteger ageDKRWithOnlyChild;
	private BigInteger ageDKRUHHT;
	private BigInteger ageInfoMissingWOC;
	private BigInteger ageInfoMissingWCA;
	private BigInteger ageInfoMissingWithOnlyChild;
	private BigInteger ageInfoMissingUHHT;
	private BigInteger ageOverallTotalWOC;
	private BigInteger ageOverallTotalWCA;
	private BigInteger ageOverallTotalWithOnlyChild;
	private BigInteger ageOverallTotalUHHT;
	
	/**
	 *  "Q11: Age" Table -- Ends
	 * */
	
	/**
	 *  "Q12a: Race" Table -- Starts
	 * */
	
	private BigInteger q12aWhiteTotal;
	private BigInteger q12aWhiteWithoutChildren;
	private BigInteger q12aWhiteWithChildrenAndAdults;
	private BigInteger q12aWhiteWithOnlyChildren;
	private BigInteger q12aWhiteWithUnkownhouseholdtype;
	
	private BigInteger q12aBlckAfrnAmrnTotal;
	private BigInteger q12aBlckAfrnAmrnWithoutChildren;
	private BigInteger q12aBlckAfrnAmrnWithChildrenAndAdults;
	private BigInteger q12aBlckAfrnAmrnWithOnlyChildren;
	private BigInteger q12aBlckAfrnAmrnWithUnkownhouseholdtype;
	
	private BigInteger q12aAsianTotal;
	private BigInteger q12aAsianWithoutChildren;
	private BigInteger q12aAsianWithChildrenAndAdults;
	private BigInteger q12aAsianWithOnlyChildren;
	private BigInteger q12aAsianUnkownhouseholdtype;
	
	private BigInteger q12aAmericanIndianTotal;
	private BigInteger q12aAmericanIndianWithoutChildren;
	private BigInteger q12aAmericanIndianWithChildrenAndAdults;
	private BigInteger q12aAmericanIndianWithOnlyChildren;
	private BigInteger q12aAmericanIndianUnkownhouseholdtype;
	
	private BigInteger q12aNativeHawalianTotal;
	private BigInteger q12aNativeHawalianWithoutChildren;
	private BigInteger q12aNativeHawalianWithChildrenAndAdults;
	private BigInteger q12aNativeHawalianWithOnlyChildren;
	private BigInteger q12aNativeHawalianUnkownhouseholdtype;
	
	private BigInteger q12aMultipleRacesTotal;
	private BigInteger q12aMultipleRacesWithoutChildren;
	private BigInteger q12aMultipleRacesWithChildrenAndAdults;
	private BigInteger q12aMultipleRacesWithOnlyChildren;
	private BigInteger q12aMultipleRacesUnkownhouseholdtype;
	
	private BigInteger q12aDontKnowRacesTotal;
	private BigInteger q12aDontKnowRacesWithoutChildren;
	private BigInteger q12aDontKnowRacesWithChildrenAndAdults;
	private BigInteger q12aDontKnowRacesWithOnlyChildren;
	private BigInteger q12aDontKnowRacesUnkownhouseholdtype;
	
	private BigInteger q12aInformationMissingTotal;
	private BigInteger q12aInformationMissingWithoutChildren;
	private BigInteger q12aInformationMissingWithChildrenAndAdults;
	private BigInteger q12aInformationMissingWithOnlyChildren;
	private BigInteger q12aInformationMissingUnkownhouseholdtype;
	
	private BigInteger q12aTotalSummed;
	private BigInteger q12aTotalWithoutChildren;
	private BigInteger q12aTotalWithChildrenAndAdults;
	private BigInteger q12aTotalWithOnlyChildren;
	private BigInteger q12aTotalUnkownhouseholdtype;
	
	/**
	 *  "Q12a: Race" Table -- Ends
	 * */
	
	/**
	 *  "Q12b: Ethnicity" Table -- Starts
	 * */
	
	private BigInteger q12bNonHispanicTotal;
	private BigInteger q12bNonHispanicWithoutChildren;
	private BigInteger q12bNonHispanicWithChildrenAndAdults;
	private BigInteger q12bNonHispanicWithOnlyChildren;
	private BigInteger q12bNonHispanicUnknownhouseholdtype;
	
	private BigInteger q12bHispanicTotal;
	private BigInteger q12bHispanicWithoutChildren;
	private BigInteger q12bHispanicWithChildrenAndAdults;
	private BigInteger q12bHispanicWithOnlyChildren;
	private BigInteger q12bHispanicUnknownhouseholdtype;
	
	private BigInteger q12bDontKnowRacesTotal;
	private BigInteger q12bDontKnowRacesWithoutChildren;
	private BigInteger q12bDontKnowRacesWithChildrenAndAdults;
	private BigInteger q12bDontKnowRacesWithOnlyChildren;
	private BigInteger q12bDontKnowRacesUnkownhouseholdtype;
	
	private BigInteger q12bInformationMissingTotal;
	private BigInteger q12bInformationMissingWithoutChildren;
	private BigInteger q12bInformationMissingWithChildrenAndAdults;
	private BigInteger q12bInformationMissingWithOnlyChildren;
	private BigInteger q12bInformationMissingUnkownhouseholdtype;
	
	private BigInteger q12bTotalSummed;
	private BigInteger q12bTotalWithoutChildren;
	private BigInteger q12bTotalWithChildrenAndAdults;
	private BigInteger q12bTotalWithOnlyChildren;
	private BigInteger q12bTotalUnkownhouseholdtype;
	
	/**
	 *  "Q12b: Ethnicity" Table -- Ends
	 * */
	
	/**
	 *  "Q13a1: Physical and Mental Health Conditions at Entry" Table -- Starts
	 * */
	private BigInteger q13a1MentalIllnessTotal;
	private BigInteger q13a1MentalIllnessWithoutChildren;
	private BigInteger q13a1MentalIllnessWithChildAndAdults;
	private BigInteger q13a1MentalIllnessWithOnlychildren;
	private BigInteger q13a1MentalIllnessUnknowHousehold;
	
	private BigInteger q13a1AlcoholAbuseTotal;
	private BigInteger q13a1AlcoholAbuseWithoutChildren;
	private BigInteger q13a1AlcoholAbuseWithChildAndAdults;
	private BigInteger q13a1AlcoholAbuseWithOnlychildren;
	private BigInteger q13a1AlcoholAbuseUnknowHousehold;
	
	private BigInteger q13a1DrugAbuseTotal;
	private BigInteger q13a1DrugAbuseWithoutChildren;
	private BigInteger q13a1DrugAbuseWithChildAndAdults;
	private BigInteger q13a1DrugAbuseWithOnlychildren;
	private BigInteger q13a1DrugAbuseUnknowHousehold;
	
	private BigInteger q13a1BothAlcoholAndDrugAbuseTotal;
	private BigInteger q13a1BothAlcoholAndDrugAbuseWithoutChildren;
	private BigInteger q13a1BothAlcoholAndDrugAbuseWithChildAndAdults;
	private BigInteger q13a1BothAlcoholAndDrugAbuseWithOnlychildren;
	private BigInteger q13a1BothAlcoholAndDrugAbuseUnknowHousehold;
	
	private BigInteger q13a1ChronicHealthConditionTotal;
	private BigInteger q13a1ChronicHealthConditionWithoutChildren;
	private BigInteger q13a1ChronicHealthConditionWithChildAndAdults;
	private BigInteger q13a1ChronicHealthConditionWithOnlychildren;
	private BigInteger q13a1ChronicHealthConditionUnknowHousehold;
	
	private BigInteger q13a1HIVRelatedDiseasesTotal;
	private BigInteger q13a1HIVRelatedDiseasesWithoutChildren;
	private BigInteger q13a1HIVRelatedDiseasesWithChildAndAdults;
	private BigInteger q13a1HIVRelatedDiseasesWithOnlychildren;
	private BigInteger q13a1HIVRelatedDiseasesUnknowHousehold;
	
	private BigInteger q13a1DevelopmentalDisabilityTotal;
	private BigInteger q13a1DevelopmentalDisabilityWithoutChildren;
	private BigInteger q13a1DevelopmentalDisabilityWithChildAndAdults;
	private BigInteger q13a1DevelopmentalDisabilityWithOnlychildren;
	private BigInteger q13a1DevelopmentalDisabilityUnknowHousehold;
	
	private BigInteger q13a1PhysicalDisabilityTotal;
	private BigInteger q13a1PhysicalDisabilityWithoutChildren;
	private BigInteger q13a1PhysicalDisabilityWithChildAndAdults;
	private BigInteger q13a1PhysicalDisabilityWithOnlychildren;
	private BigInteger q13a1PhysicalDisabilityUnknowHousehold;
	
	/**
	 *  "Q13a1: Physical and Mental Health Conditions at Entry" Table -- Ends
	 * */
	
	/**
	 *  "Q13a2: Number of Conditions at Entry" Table -- Starts
	 * */
	private BigInteger q13a2NoneTotal;
	private BigInteger q13a2NoneWithoutChildren;
	private BigInteger q13a2NoneWithChildAndAdults;
	private BigInteger q13a2NoneWithOnlychildren;
	private BigInteger q13a2NoneUnknowHousehold;
	
	private BigInteger q13a2Condition1Total;
	private BigInteger q13a2Condition1WithoutChildren;
	private BigInteger q13a2Condition1WithChildAndAdults;
	private BigInteger q13a2Condition1WithOnlychildren;
	private BigInteger q13a2Condition1UnknowHousehold;
	
	private BigInteger q13a2Condition2Total;
	private BigInteger q13a2Condition2WithoutChildren;
	private BigInteger q13a2Condition2WithChildAndAdults;
	private BigInteger q13a2Condition2WithOnlychildren;
	private BigInteger q13a2Condition2UnknowHousehold;
	
	private BigInteger q13a2Condition3PlusTotal;
	private BigInteger q13a2Condition3PlusWithoutChildren;
	private BigInteger q13a2Condition3PlusWithChildAndAdults;
	private BigInteger q13a2Condition3PlusWithOnlychildren;
	private BigInteger q13a2Condition3PlusUnknowHousehold;
	
	private BigInteger q13a2ConditionUnknownTotal;
	private BigInteger q13a2ConditionUnknownWithoutChildren;
	private BigInteger q13a2ConditionUnknownWithChildAndAdults;
	private BigInteger q13a2ConditionUnknownWithOnlychildren;
	private BigInteger q13a2ConditionUnknownUnknowHousehold;
	
	private BigInteger q13a2DontKnowRefusedTotal;
	private BigInteger q13a2DontKnowRefusedWithoutChildren;
	private BigInteger q13a2DontKnowRefusedWithChildAndAdults;
	private BigInteger q13a2DontKnowRefusedWithOnlychildren;
	private BigInteger q13a2DontKnowRefusedUnknowHousehold;
	
	private BigInteger q13a2InformationmissingTotal;
	private BigInteger q13a2InformationmissingWithoutChildren;
	private BigInteger q13a2InformationmissingWithChildAndAdults;
	private BigInteger q13a2InformationmissingWithOnlychildren;
	private BigInteger q13a2InformationmissingUnknowHousehold;
	
	private BigInteger q13a2TotalSummed;
	private BigInteger q13a2TotalWithoutChildren;
	private BigInteger q13a2TotalWithChildAndAdults;
	private BigInteger q13a2TotalWithOnlychildren;
	private BigInteger q13a2TotalUnknowHousehold;
	
	/**
	 *  "Q13a2: Number of Conditions at Entry" Table -- Ends
	 * */
	
	
	/**
	 *  "Q13b1: Physical and Mental Health Conditions at Exit" Table -- Starts
	 * */
	private BigInteger q13b1MentalIllnessTotal;
	private BigInteger q13b1MentalIllnessWithoutChildren;
	private BigInteger q13b1MentalIllnessWithChildAndAdults;
	private BigInteger q13b1MentalIllnessWithOnlychildren;
	private BigInteger q13b1MentalIllnessUnknowHousehold;
	
	private BigInteger q13b1AlcoholAbuseTotal;
	private BigInteger q13b1AlcoholAbuseWithoutChildren;
	private BigInteger q13b1AlcoholAbuseWithChildAndAdults;
	private BigInteger q13b1AlcoholAbuseWithOnlychildren;
	private BigInteger q13b1AlcoholAbuseUnknowHousehold;
	
	private BigInteger q13b1DrugAbuseTotal;
	private BigInteger q13b1DrugAbuseWithoutChildren;
	private BigInteger q13b1DrugAbuseWithChildAndAdults;
	private BigInteger q13b1DrugAbuseWithOnlychildren;
	private BigInteger q13b1DrugAbuseUnknowHousehold;
	
	private BigInteger q13b1BothAlcoholAndDrugAbuseTotal;
	private BigInteger q13b1BothAlcoholAndDrugAbuseWithoutChildren;
	private BigInteger q13b1BothAlcoholAndDrugAbuseWithChildAndAdults;
	private BigInteger q13b1BothAlcoholAndDrugAbuseWithOnlychildren;
	private BigInteger q13b1BothAlcoholAndDrugAbuseUnknowHousehold;
	
	private BigInteger q13b1ChronicHealthConditionTotal;
	private BigInteger q13b1ChronicHealthConditionWithoutChildren;
	private BigInteger q13b1ChronicHealthConditionWithChildAndAdults;
	private BigInteger q13b1ChronicHealthConditionWithOnlychildren;
	private BigInteger q13b1ChronicHealthConditionUnknowHousehold;
	
	private BigInteger q13b1HIVRelatedDiseasesTotal;
	private BigInteger q13b1HIVRelatedDiseasesWithoutChildren;
	private BigInteger q13b1HIVRelatedDiseasesWithChildAndAdults;
	private BigInteger q13b1HIVRelatedDiseasesWithOnlychildren;
	private BigInteger q13b1HIVRelatedDiseasesUnknowHousehold;

	private BigInteger q13b1DevelopmentalDisabilityTotal;
	private BigInteger q13b1DevelopmentalDisabilityWithoutChildren;
	private BigInteger q13b1DevelopmentalDisabilityWithChildAndAdults;
	private BigInteger q13b1DevelopmentalDisabilityWithOnlychildren;
	private BigInteger q13b1DevelopmentalDisabilityUnknowHousehold;
	
	private BigInteger q13b1PhysicalDisabilityTotal;
	private BigInteger q13b1PhysicalDisabilityWithoutChildren;
	private BigInteger q13b1PhysicalDisabilityWithChildAndAdults;
	private BigInteger q13b1PhysicalDisabilityWithOnlychildren;
	private BigInteger q13b1PhysicalDisabilityUnknowHousehold;
	
	/**
	 *  "Q13b1: Physical and Mental Health Conditions at Exit" Table -- Ends
	 * */
	
	/**
	 *  "Q13b2: Number of Conditions at Exit" Table -- Starts
	 * */
	private BigInteger q13b2NoneTotal;
	private BigInteger q13b2NoneWithoutChildren;
	private BigInteger q13b2NoneWithChildAndAdults;
	private BigInteger q13b2NoneWithOnlychildren;
	private BigInteger q13b2NoneUnknowHousehold;
	
	private BigInteger q13b2Condition1Total;
	private BigInteger q13b2Condition1WithoutChildren;
	private BigInteger q13b2Condition1WithChildAndAdults;
	private BigInteger q13b2Condition1WithOnlychildren;
	private BigInteger q13b2Condition1UnknowHousehold;
	
	private BigInteger q13b2Condition2Total;
	private BigInteger q13b2Condition2WithoutChildren;
	private BigInteger q13b2Condition2WithChildAndAdults;
	private BigInteger q13b2Condition2WithOnlychildren;
	private BigInteger q13b2Condition2UnknowHousehold;
	
	private BigInteger q13b2Condition3PlusTotal;
	private BigInteger q13b2Condition3PlusWithoutChildren;
	private BigInteger q13b2Condition3PlusWithChildAndAdults;
	private BigInteger q13b2Condition3PlusWithOnlychildren;
	private BigInteger q13b2Condition3PlusUnknowHousehold;
	
	private BigInteger q13b2ConditionUnknownTotal;
	private BigInteger q13b2ConditionUnknownWithoutChildren;
	private BigInteger q13b2ConditionUnknownWithChildAndAdults;
	private BigInteger q13b2ConditionUnknownWithOnlychildren;
	private BigInteger q13b2ConditionUnknownUnknowHousehold;
	
	private BigInteger q13b2DontKnowRefusedTotal;
	private BigInteger q13b2DontKnowRefusedWithoutChildren;
	private BigInteger q13b2DontKnowRefusedWithChildAndAdults;
	private BigInteger q13b2DontKnowRefusedWithOnlychildren;
	private BigInteger q13b2DontKnowRefusedUnknowHousehold;

	private BigInteger q13b2InformationmissingTotal;
	private BigInteger q13b2InformationmissingWithoutChildren;
	private BigInteger q13b2InformationmissingWithChildAndAdults;
	private BigInteger q13b2InformationmissingWithOnlychildren;
	private BigInteger q13b2InformationmissingUnknowHousehold;
	
	private BigInteger q13b2TotalSummed;
	private BigInteger q13b2TotalWithoutChildren;
	private BigInteger q13b2TotalWithChildAndAdults;
	private BigInteger q13b2TotalWithOnlychildren;
	private BigInteger q13b2TotalUnknowHousehold;
	
	/**
	 *  "Q13b2: Number of Conditions at Exit" Table -- Ends
	 * */

	/**
	 *  "Q13c1: Physical and Mental Health Conditions for Stayers" Table -- Starts
	 * */
	private BigInteger q13c1MentalIllnessTotal;
	private BigInteger q13c1MentalIllnessWithoutChildren;
	private BigInteger q13c1MentalIllnessWithChildAndAdults;
	private BigInteger q13c1MentalIllnessWithOnlychildren;
	private BigInteger q13c1MentalIllnessUnknowHousehold;
	
	private BigInteger q13c1AlcoholAbuseTotal;
	private BigInteger q13c1AlcoholAbuseWithoutChildren;
	private BigInteger q13c1AlcoholAbuseWithChildAndAdults;
	private BigInteger q13c1AlcoholAbuseWithOnlychildren;
	private BigInteger q13c1AlcoholAbuseUnknowHousehold;
	
	private BigInteger q13c1DrugAbuseTotal;
	private BigInteger q13c1DrugAbuseWithoutChildren;
	private BigInteger q13c1DrugAbuseWithChildAndAdults;
	private BigInteger q13c1DrugAbuseWithOnlychildren;
	private BigInteger q13c1DrugAbuseUnknowHousehold;
	
	private BigInteger q13c1BothAlcoholAndDrugAbuseTotal;
	private BigInteger q13c1BothAlcoholAndDrugAbuseWithoutChildren;
	private BigInteger q13c1BothAlcoholAndDrugAbuseWithChildAndAdults;
	private BigInteger q13c1BothAlcoholAndDrugAbuseWithOnlychildren;
	private BigInteger q13c1BothAlcoholAndDrugAbuseUnknowHousehold;
	
	private BigInteger q13c1ChronicHealthConditionTotal;
	private BigInteger q13c1ChronicHealthConditionWithoutChildren;
	private BigInteger q13c1ChronicHealthConditionWithChildAndAdults;
	private BigInteger q13c1ChronicHealthConditionWithOnlychildren;
	private BigInteger q13c1ChronicHealthConditionUnknowHousehold;
	
	private BigInteger q13c1HIVRelatedDiseasesTotal;
	private BigInteger q13c1HIVRelatedDiseasesWithoutChildren;
	private BigInteger q13c1HIVRelatedDiseasesWithChildAndAdults;
	private BigInteger q13c1HIVRelatedDiseasesWithOnlychildren;
	private BigInteger q13c1HIVRelatedDiseasesUnknowHousehold;

	private BigInteger q13c1DevelopmentalDisabilityTotal;
	private BigInteger q13c1DevelopmentalDisabilityWithoutChildren;
	private BigInteger q13c1DevelopmentalDisabilityWithChildAndAdults;
	private BigInteger q13c1DevelopmentalDisabilityWithOnlychildren;
	private BigInteger q13c1DevelopmentalDisabilityUnknowHousehold;
	
	private BigInteger q13c1PhysicalDisabilityTotal;
	private BigInteger q13c1PhysicalDisabilityWithoutChildren;
	private BigInteger q13c1PhysicalDisabilityWithChildAndAdults;
	private BigInteger q13c1PhysicalDisabilityWithOnlychildren;
	private BigInteger q13c1PhysicalDisabilityUnknowHousehold;
	
	/**
	 *  "Q13c1: Physical and Mental Health Conditions for Stayers" Table -- Ends
	 * */
	
	/**	
	 *  "Q13c2: Number of Conditions for Stayers" Table -- Starts
	 * */
	private BigInteger q13c2NoneTotal;
	private BigInteger q13c2NoneWithoutChildren;
	private BigInteger q13c2NoneWithChildAndAdults;
	private BigInteger q13c2NoneWithOnlychildren;
	private BigInteger q13c2NoneUnknowHousehold;
	
	private BigInteger q13c2Condition1Total;
	private BigInteger q13c2Condition1WithoutChildren;
	private BigInteger q13c2Condition1WithChildAndAdults;
	private BigInteger q13c2Condition1WithOnlychildren;
	private BigInteger q13c2Condition1UnknowHousehold;
	
	private BigInteger q13c2Condition2Total;
	private BigInteger q13c2Condition2WithoutChildren;
	private BigInteger q13c2Condition2WithChildAndAdults;
	private BigInteger q13c2Condition2WithOnlychildren;
	private BigInteger q13c2Condition2UnknowHousehold;
	
	private BigInteger q13c2Condition3PlusTotal;
	private BigInteger q13c2Condition3PlusWithoutChildren;
	private BigInteger q13c2Condition3PlusWithChildAndAdults;
	private BigInteger q13c2Condition3PlusWithOnlychildren;
	private BigInteger q13c2Condition3PlusUnknowHousehold;
	
	private BigInteger q13c2ConditionUnknownTotal;
	private BigInteger q13c2ConditionUnknownWithoutChildren;
	private BigInteger q13c2ConditionUnknownWithChildAndAdults;
	private BigInteger q13c2ConditionUnknownWithOnlychildren;
	private BigInteger q13c2ConditionUnknownUnknowHousehold;
	
	private BigInteger q13c2DontKnowRefusedTotal;
	private BigInteger q13c2DontKnowRefusedWithoutChildren;
	private BigInteger q13c2DontKnowRefusedWithChildAndAdults;
	private BigInteger q13c2DontKnowRefusedWithOnlychildren;
	private BigInteger q13c2DontKnowRefusedUnknowHousehold;

	private BigInteger q13c2InformationmissingTotal;
	private BigInteger q13c2InformationmissingWithoutChildren;
	private BigInteger q13c2InformationmissingWithChildAndAdults;
	private BigInteger q13c2InformationmissingWithOnlychildren;
	private BigInteger q13c2InformationmissingUnknowHousehold;
	
	private BigInteger q13c2TotalSummed;
	private BigInteger q13c2TotalWithoutChildren;
	private BigInteger q13c2TotalWithChildAndAdults;
	private BigInteger q13c2TotalWithOnlychildren;
	private BigInteger q13c2TotalUnknowHousehold;
	
	/**
	 *  "Q13c2: Number of Conditions for Stayers" Table -- Ends
	 * */
	
	/**
	 *  "Q14a: Q14a: Domestic Violence History" Table -- Starts
	 * */
	private BigInteger q14aYesTotal;
	private BigInteger q14aYesWithoutChildren;
	private BigInteger q14aYesWithChildAndAdults;
	private BigInteger q14aYesWithOnlyChildren;
	private BigInteger q14aYesUnknownHouseholdType;
	
	private BigInteger q14aNoTotal;
	private BigInteger q14aNoWithoutChildren;
	private BigInteger q14aNoWithChildAndAdults;
	private BigInteger q14aNoWithOnlyChildren;
	private BigInteger q14aNoUnknownHouseholdType;
	
	private BigInteger q14aDKRTotal;
	private BigInteger q14aDKRWithoutChildren;
	private BigInteger q14aDKRWithChildAndAdults;
	private BigInteger q14aDKRWithOnlyChildren;
	private BigInteger q14aDKRUnknownHouseholdType;
	
	private BigInteger q14aInformationMissingTotal;
	private BigInteger q14aInformationMissingWithoutChildren;
	private BigInteger q14aInformationMissingWithChildAndAdults;
	private BigInteger q14aInformationMissingWithOnlyChildren;
	private BigInteger q14aInformationMissingUnknownHouseholdType;
	
	private BigInteger q14aTotalSummed;
	private BigInteger q14aTotalWithoutChildren;
	private BigInteger q14aTotalWithChildAndAdults;
	private BigInteger q14aTotalWithOnlychildren;
	private BigInteger q14aTotalUnknowHousehold;
	
	/**
	 *  "Q14a: Q14a: Domestic Violence History" Table -- Ends
	 * */
	
	/**
	 *  "Q14b: Persons Fleeing Domestic Violence" Table -- Starts
	 * */
	private BigInteger q14bYesTotal;
	private BigInteger q14bYesWithoutChildren;
	private BigInteger q14bYesWithChildAndAdults;
	private BigInteger q14bYesWithOnlyChildren;
	private BigInteger q14bYesUnknownHouseholdType;
	
	private BigInteger q14bNoTotal;
	private BigInteger q14bNoWithoutChildren;
	private BigInteger q14bNoWithChildAndAdults;
	private BigInteger q14bNoWithOnlyChildren;
	private BigInteger q14bNoUnknownHouseholdType;
	
	private BigInteger q14bDKRTotal;
	private BigInteger q14bDKRWithoutChildren;
	private BigInteger q14bDKRWithChildAndAdults;
	private BigInteger q14bDKRWithOnlyChildren;
	private BigInteger q14bDKRUnknownHouseholdType;

	private BigInteger q14bInformationMissingTotal;
	private BigInteger q14bInformationMissingWithoutChildren;
	private BigInteger q14bInformationMissingWithChildAndAdults;
	private BigInteger q14bInformationMissingWithOnlyChildren;
	private BigInteger q14bInformationMissingUnknownHouseholdType;
	
	private BigInteger q14bTotalSummed;
	private BigInteger q14bTotalWithoutChildren;
	private BigInteger q14bTotalWithChildAndAdults;
	private BigInteger q14bTotalWithOnlychildren;
	private BigInteger q14bTotalUnknowHousehold;
	
	/**
	 *  "Q14b: Persons Fleeing Domestic Violence" Table -- Ends
	 * */
	
	/**
	 *  "Q15: Residence Prior to Program Entry" Table -- Starts
	 * */
	private BigInteger q15HomeLessSituationsTotal;
	private BigInteger q15HomeLessSituationsWithoutChildren;
	private BigInteger q15HomeLessSituationWithChildAndAdult;
	private BigInteger q15HomeLessSituationsWithChildOnly;
	private BigInteger q15HomeLessSituationsUnknownHouseHold;
	
	private BigInteger q15EmergencyShelterTotal;
	private BigInteger q15EmergencyShelterWithoutChildren;
	private BigInteger q15EmergencyShelterWithChildAndAdult;
	private BigInteger q15EmergencyShelterWithChildOnly;
	private BigInteger q15EmergencyShelterUnknownHouseHold;
	
	private BigInteger q15TransitionalHousingForhomelessTotal;
	private BigInteger q15TransitionalHousingForhomelessWithoutChildren;
	private BigInteger q15TransitionalHousingForhomelessWithChildAndAdult;
	private BigInteger q15TransitionalHousingForhomelessWithChildOnly;
	private BigInteger q15TransitionalHousingForhomelessUnknownHouseHold;
	
	private BigInteger q15PlaceNotMeantTotal;
	private BigInteger q15PlaceNotMeantWithoutChildren;
	private BigInteger q15PlaceNotMeantWithChildAndAdult;
	private BigInteger q15PlaceNotMeantWithChildOnly;
	private BigInteger q15PlaceNotMeantsUnknownHouseHold;
	
	private BigInteger q15SafeHeavenTotal;
	private BigInteger q15SafeHeavenWithoutChildren;
	private BigInteger q15SafeHeavenWithChildAndAdult;
	private BigInteger q15SafeHeavenWithChildOnly;
	private BigInteger q15SafeHeavenUnknownHouseHold;
	
	private BigInteger q15AzTotalSummed;
	private BigInteger q15AzTotalWithoutChildren;
	private BigInteger q15AzTotalWithChildAndAdult;
	private BigInteger q15AzTotalWithChildOnly;
	private BigInteger q15AzTotalUnknownHouseHold;
	
	private BigInteger q15InstitutionalSettingsTotal;
	private BigInteger q15InstitutionalSettingsWithoutChildren;
	private BigInteger q15InstitutionalSettingsWithChildandAdult;
	private BigInteger q15InstitutionalSettingsWithChildOnly;
	private BigInteger q15InstitutionalSettingsUnknowHouseHold;
	
	private BigInteger q15PsychiatricFacilityTotal;
	private BigInteger q15PsychiatricFacilityWithoutChildren;
	private BigInteger q15PsychiatricFacilityWithChildandAdult;
	private BigInteger q15PsychiatricFacilityWithChildOnly;
	private BigInteger q15PsychiatricFacilityUnknownhouseHold;
	
	private BigInteger q15SubstanceAbuseTotal;
	private BigInteger q15SubstanceAbuseWithoutChildren;
	private BigInteger q15SubstanceAbuseWithChildandAdult;
	private BigInteger q15SubstanceAbuseWithChildOnly;
	private BigInteger q15SubstanceAbuseUnknowHouseHold;
	
	private BigInteger q15HospitalNonPhychiatricTotal;
	private BigInteger q15HospitalNonPhychiatricWithoutChild;
	private BigInteger q15HospitalNonPhychiatricWithChildandAdult;
	private BigInteger q15HospitalNonPhychiatricWithChildOnly;
	private BigInteger q15HospitalNonPhychiatricUnknownHouseHold;
	
	private BigInteger q15JailPrisonTotal;
	private BigInteger q15JailPrisonWithoutChild;
	private BigInteger q15JailPrisonWithChildandAdult;
	private BigInteger q15JailPrisonWithChildOnly;
	private BigInteger q15JailPrisonUnknowHouseHold;
	
	private BigInteger q15FosterCarehomeTotal;
	private BigInteger q15FosterCarehomeWithoutChild;
	private BigInteger q15FosterCarehomeWithChildandAdult;
	private BigInteger q15FosterCarehomeWithChildOnly;
	private BigInteger q15FosterCarehomeUnknownHouseHold;
	
	private BigInteger q15LongTermCareFacilityTotal;
	private BigInteger q15LongTermCareFacilityWithoutChild;
	private BigInteger q15LongTermCareFacilityWithChildandAdult;
	private BigInteger q15LongTermCareFacilityWithChildOnly;
	private BigInteger q15LongTermCareFacilityUnknowHouseHold;
	
	private BigInteger q15ResidentialProjectTotal;
	private BigInteger q15ResidentialProjectWithoutChild;
	private BigInteger q15ResidentialProjectWithChildandAdult;
	private BigInteger q15ResidentialProjectWithChildOnly;
	private BigInteger q15ResidentialProjectUnknownHouseHold;
	
	private BigInteger q15BzTotalSummed;
	private BigInteger q15BzTotalWithoutChild;
	private BigInteger q15BzTotalWithChildandAdult;
	private BigInteger q15BzTotalWithChildOnly;
	private BigInteger q15BzTotalUnknowHousehold;
	
	private BigInteger q15OtherLocationTotal;
	private BigInteger q15OtherLocationWithoutChild;
	private BigInteger q15OtherLocationWithChildandAdult;
	private BigInteger q15OtherLocationWithChildOnly;
	private BigInteger q15OtherLocationUnkownHousehold;
	
	private BigInteger q15PSHforHomelessPersonsTotal;
	private BigInteger q15PSHforHomelessPersonsWithoutChild;
	private BigInteger q15PSHforHomelessPersonsWithChilandAdult;
	private BigInteger q15PSHforHomelessPersonsWithChildOnly;
	private BigInteger q15PSHforHomelessPersonsUnknowHousehold;
	
	private BigInteger q15OwnedByclientNoSubsidyTotal;
	private BigInteger q15OwnedByclientNoSubsidyWithoutchild;
	private BigInteger q15OwnedByclientNoSubsidyWithChildandAdult;
	private BigInteger q15OwnedByclientNoSubsidyWithChildOnly;
	private BigInteger q15OwnedByclientNoSubsidyUnknowHousehold;
	
	private BigInteger q15OwnedByclientWithSubsidyTotal;
	private BigInteger q15OwnedByclientWithSubsidyWithoutchild;
	private BigInteger q15OwnedByclientWithSubsidyWithChildandAdult;
	private BigInteger q15OwnedByclientWithSubsidyWithChildOnly;
	private BigInteger q15OwnedByclientWithSubsidyUnknowHousehold;
	
	private BigInteger q15RentalByClientNoSubsidyTotal;
	private BigInteger q15RentalByClientNoSubsidyWithoutChild;
	private BigInteger q15RentalByClientNoSubsidyWithChildandAdult;
	private BigInteger q15RentalByClientNoSubsidyWithchildOnly;
	private BigInteger q15RentalByClientNoSubsidyUnknownHousehold;
	
	private BigInteger q15RentalByClientWithVASHSubsidyTotal;
	private BigInteger q15RentalByClientWithVASHSubsidyWithoutChild;
	private BigInteger q15RentalByClientWithVASHSubsidyWithchildandAdult;
	private BigInteger q15RentalByClientWithVASHSubsidyWithChildOnly;
	private BigInteger q15RentalByClientWithVASHSubsidyUnknownHousehold;
	
	private BigInteger q15RentalByClientWithGPDTIPSubsidyTotal;
	private BigInteger q15RentalByClientWithGPDTIPSubsidyWithoutChild;
	private BigInteger q15RentalByClientWithGPDTIPSubsidyWithchildandAdult;
	private BigInteger q15RentalByClientWithGPDTIPSubsidyWithChildOnly;
	private BigInteger q15RentalByClientWithGPDTIPSubsidyUnknownHousehold;
	
	private BigInteger q15RentalByClientWithOtherSubsidyTotal;
	private BigInteger q15RentalByClientWithOtherSubsidyWithoutChild;
	private BigInteger q15RentalByClientWithOtherSubsidyWithChildandAdult;
	private BigInteger q15RentalByClientWithOtherSubsidyWithChildOnly;
	private BigInteger q15RentalByClientWithOtherSubsidyUnknowHousehold;
	
	private BigInteger q15HotelOrMotelTotal;
	private BigInteger q15HotelOrMotelWithoutChild;
	private BigInteger q15HotelOrMotelWithChidandAdult;
	private BigInteger q15HotelOrMotelWithChildOnly;
	private BigInteger q15HotelOrMotelUnkownHousehold;
	
	private BigInteger q15StayingOrLivingWithFriendsTotal;
	private BigInteger q15StayingOrLivingWithFriendsWithoutChild;
	private BigInteger q15StayingOrLivingWithFriendsWithChildandAdult;
	private BigInteger q15StayingOrLivingWithFriendsWithChildOnly;
	private BigInteger q15StayingOrLivingWithFriendsUnknownHousehold;
	
	private BigInteger q15StayingOrLivingWithFamilyTotal;
	private BigInteger q15StayingOrLivingWithFamilyWithoutChild;
	private BigInteger q15StayingOrLivingWithFamilyWithChildandAdult;
	private BigInteger q15StayingOrLivingWithFamilyWithChildOnly;
	private BigInteger q15StayingOrLivingWithFamilyUnknownHousehold;
	
	private BigInteger q15OtherTotal;
	private BigInteger q15OtherWithoutChild;
	private BigInteger q15OtherWithChildandAdult;
	private BigInteger q15OtherWithChildOnly;
	private BigInteger q15OtherUnknownHousehold;
	
	private BigInteger q15DontRefusedTotal;
	private BigInteger q15DontRefusedWithoutChild;
	private BigInteger q15DontRefusedWithChildandAdult;
	private BigInteger q15DontRefusedWithChildOnly;
	private BigInteger q15DontRefusedUnknownHousehold;
	
	private BigInteger q15InformationMissingTotal;
	private BigInteger q15InformationMissingWithoutChild;
	private BigInteger q15InformationMissingWithChildandAdult;
	private BigInteger q15InformationMissingwithChildOnly;
	private BigInteger q15InformationMissingUnknownHousehold;
	
	private BigInteger q15CzTotalSummed;
	private BigInteger q15CzTotalWithoutChild;
	private BigInteger q15CzTotalWithChildandAdult;
	private BigInteger q15CzTotalWithChildOnly;
	private BigInteger q15CzTotalUnknownHousehold;
	
	private BigInteger q15DTotalSummed;
	private BigInteger q15DTotalWithoutChild;
	private BigInteger q15DTotalWithChildandAdult;
	private BigInteger q15DTotalWithChildOnly;
	private BigInteger q15DTotalUnknownHousehold;
	
	/**
	 *  "Q15: Residence Prior to Program Entry" Table -- Ends
	 * */
	
	/**
	 *  "Q16: Cash Income - Ranges" Table -- Starts
	 * */
	
	private BigInteger q16NoIncomeIncomeAtEntry;
	private BigInteger q16NoIncomeIncomeAtLatestFollowupforStayers;
	private BigInteger q16NoIncomeIncomeAtExitforLeavers;
	
	private BigInteger q161To150IncomeAtEntry;
	private BigInteger q161To150IncomeAtLatestFollowupforStayers;
	private BigInteger q161To150IncomeAtExitforLeavers;
	
	private BigInteger q16151To250IncomeAtEntry;
	private BigInteger q16151To250IncomeAtLatestFollowupforStayers;
	private BigInteger q16151To250IncomeAtExitforLeavers;
	
	private BigInteger q16251To500IncomeAtEntry;
	private BigInteger q16251To500IncomeAtLatestFollowupforStayers;
	private BigInteger q16251To500IncomeAtExitforLeavers;
	
	private BigInteger q16501To1000IncomeAtEntry;
	private BigInteger q16501To1000IncomeAtLatestFollowupforStayers;
	private BigInteger q16501To1000IncomeAtExitforLeavers;
	
	private BigInteger q161001To1500IncomeAtEntry;
	private BigInteger q161001To1500IncomeAtLatestFollowupforStayers;
	private BigInteger q161001To1500IncomeAtExitforLeavers;
	
	private BigInteger q161501To2000IncomeAtEntry;
	private BigInteger q161501To2000IncomeAtLatestFollowupforStayers;
	private BigInteger q161501To2000IncomeAtExitforLeavers;
	
	private BigInteger q162000PlusIncomeAtEntry;
	private BigInteger q162000PlusIncomeAtLatestFollowupforStayers;
	private BigInteger q162000PlusIncomeAtExitforLeavers;
	
	private BigInteger q16ClientDoesntKnowIncomeAtEntry;
	private BigInteger q16ClientDoesntKnowIncomeAtLatestFollowupforStayers;
	private BigInteger q16ClientDoesntKnowIncomeAtExitforLeavers;
	
	private BigInteger q16DataNotCollectedIncomeAtEntry;
	private BigInteger q16DataNotCollectedIncomeAtLatestFollowupforStayers;
	private BigInteger q16DataNotCollectedIncomeAtExitforLeavers;
	
	private BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry;
	private BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers;
	private BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers;
	
	private BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry;
	private BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers;
	private BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers;
	
	private BigInteger q16TotalAdultsIncomeAtEntry;
	private BigInteger q16TotalAdultsIncomeAtLatestFollowupforStayers;
	private BigInteger q16TotalAdultsIncomeAtExitforLeavers;
	
	/**
	 *  "Q16: Cash Income - Ranges" Table -- Ends
	 * */
	
	
	
	
	
	public String getTotNumOfPersonServed() {
		return totNumOfPersonServed;
	}
	public String getHomePageStartDate() {
		return homePageStartDate;
	}
	public void setHomePageStartDate(String homePageStartDate) {
		this.homePageStartDate = homePageStartDate;
	}
	public String getHomePageEndDate() {
		return homePageEndDate;
	}
	public void setHomePageEndDate(String homePageEndDate) {
		this.homePageEndDate = homePageEndDate;
	}
	public String getHomePageProjects() {
		return homePageProjects;
	}
	public void setHomePageProjects(String homePageProjects) {
		this.homePageProjects = homePageProjects;
	}
	public String getHomePageHomeLess() {
		return homePageHomeLess;
	}
	public void setHomePageHomeLess(String homePageHomeLess) {
		this.homePageHomeLess = homePageHomeLess;
	}
	public String getHomePageGrants() {
		return homePageGrants;
	}
	public void setHomePageGrants(String homePageGrants) {
		this.homePageGrants = homePageGrants;
	}
	public String getHomePageView() {
		return homePageView;
	}
	public void setHomePageView(String homePageView) {
		this.homePageView = homePageView;
	}
	public BigInteger getQ04aHmisProjectIdService() {
		return q04aHmisProjectIdService;
	}
	public void setQ04aHmisProjectIdService(BigInteger q04aHmisProjectIdService) {
		this.q04aHmisProjectIdService = q04aHmisProjectIdService;
	}
	public BigInteger getQ04aHmisProjectType() {
		return q04aHmisProjectType;
	}
	public void setQ04aHmisProjectType(BigInteger q04aHmisProjectType) {
		this.q04aHmisProjectType = q04aHmisProjectType;
	}
	public BigInteger getQ04aIdentityProjectId() {
		return q04aIdentityProjectId;
	}
	public void setQ04aIdentityProjectId(BigInteger q04aIdentityProjectId) {
		this.q04aIdentityProjectId = q04aIdentityProjectId;
	}
	public BigInteger getQ04aMethodOfTracking() {
		return q04aMethodOfTracking;
	}
	public void setQ04aMethodOfTracking(BigInteger q04aMethodOfTracking) {
		this.q04aMethodOfTracking = q04aMethodOfTracking;
	}
	public String getQ04aOrgId() {
		return q04aOrgId;
	}
	public void setQ04aOrgId(String q04aOrgId) {
		this.q04aOrgId = q04aOrgId;
	}
	public String getQ04aOrgName() {
		return q04aOrgName;
	}
	public void setQ04aOrgName(String q04aOrgName) {
		this.q04aOrgName = q04aOrgName;
	}
	public BigInteger getQ04aProjectId() {
		return q04aProjectId;
	}
	public void setQ04aProjectId(BigInteger q04aProjectId) {
		this.q04aProjectId = q04aProjectId;
	}
	public String getQ04aProjectName() {
		return q04aProjectName;
	}
	public void setQ04aProjectName(String q04aProjectName) {
		this.q04aProjectName = q04aProjectName;
	}
	public BigInteger getQ16NoIncomeIncomeAtEntry() {
		return q16NoIncomeIncomeAtEntry;
	}
	public void setQ16NoIncomeIncomeAtEntry(BigInteger q16NoIncomeIncomeAtEntry) {
		this.q16NoIncomeIncomeAtEntry = q16NoIncomeIncomeAtEntry;
	}
	public BigInteger getQ16NoIncomeIncomeAtLatestFollowupforStayers() {
		return q16NoIncomeIncomeAtLatestFollowupforStayers;
	}
	public void setQ16NoIncomeIncomeAtLatestFollowupforStayers(
			BigInteger q16NoIncomeIncomeAtLatestFollowupforStayers) {
		this.q16NoIncomeIncomeAtLatestFollowupforStayers = q16NoIncomeIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16NoIncomeIncomeAtExitforLeavers() {
		return q16NoIncomeIncomeAtExitforLeavers;
	}
	public void setQ16NoIncomeIncomeAtExitforLeavers(
			BigInteger q16NoIncomeIncomeAtExitforLeavers) {
		this.q16NoIncomeIncomeAtExitforLeavers = q16NoIncomeIncomeAtExitforLeavers;
	}
	public BigInteger getQ161To150IncomeAtEntry() {
		return q161To150IncomeAtEntry;
	}
	public void setQ161To150IncomeAtEntry(BigInteger q161To150IncomeAtEntry) {
		this.q161To150IncomeAtEntry = q161To150IncomeAtEntry;
	}
	public BigInteger getQ161To150IncomeAtLatestFollowupforStayers() {
		return q161To150IncomeAtLatestFollowupforStayers;
	}
	public void setQ161To150IncomeAtLatestFollowupforStayers(
			BigInteger q161To150IncomeAtLatestFollowupforStayers) {
		this.q161To150IncomeAtLatestFollowupforStayers = q161To150IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ161To150IncomeAtExitforLeavers() {
		return q161To150IncomeAtExitforLeavers;
	}
	public void setQ161To150IncomeAtExitforLeavers(
			BigInteger q161To150IncomeAtExitforLeavers) {
		this.q161To150IncomeAtExitforLeavers = q161To150IncomeAtExitforLeavers;
	}
	public BigInteger getQ16151To250IncomeAtEntry() {
		return q16151To250IncomeAtEntry;
	}
	public void setQ16151To250IncomeAtEntry(BigInteger q16151To250IncomeAtEntry) {
		this.q16151To250IncomeAtEntry = q16151To250IncomeAtEntry;
	}
	public BigInteger getQ16151To250IncomeAtLatestFollowupforStayers() {
		return q16151To250IncomeAtLatestFollowupforStayers;
	}
	public void setQ16151To250IncomeAtLatestFollowupforStayers(
			BigInteger q16151To250IncomeAtLatestFollowupforStayers) {
		this.q16151To250IncomeAtLatestFollowupforStayers = q16151To250IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16151To250IncomeAtExitforLeavers() {
		return q16151To250IncomeAtExitforLeavers;
	}
	public void setQ16151To250IncomeAtExitforLeavers(
			BigInteger q16151To250IncomeAtExitforLeavers) {
		this.q16151To250IncomeAtExitforLeavers = q16151To250IncomeAtExitforLeavers;
	}
	public BigInteger getQ16251To500IncomeAtEntry() {
		return q16251To500IncomeAtEntry;
	}
	public void setQ16251To500IncomeAtEntry(BigInteger q16251To500IncomeAtEntry) {
		this.q16251To500IncomeAtEntry = q16251To500IncomeAtEntry;
	}
	public BigInteger getQ16251To500IncomeAtLatestFollowupforStayers() {
		return q16251To500IncomeAtLatestFollowupforStayers;
	}
	public void setQ16251To500IncomeAtLatestFollowupforStayers(
			BigInteger q16251To500IncomeAtLatestFollowupforStayers) {
		this.q16251To500IncomeAtLatestFollowupforStayers = q16251To500IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16251To500IncomeAtExitforLeavers() {
		return q16251To500IncomeAtExitforLeavers;
	}
	public void setQ16251To500IncomeAtExitforLeavers(
			BigInteger q16251To500IncomeAtExitforLeavers) {
		this.q16251To500IncomeAtExitforLeavers = q16251To500IncomeAtExitforLeavers;
	}
	public BigInteger getQ16501To1000IncomeAtEntry() {
		return q16501To1000IncomeAtEntry;
	}
	public void setQ16501To1000IncomeAtEntry(
			BigInteger q16501To1000IncomeAtEntry) {
		this.q16501To1000IncomeAtEntry = q16501To1000IncomeAtEntry;
	}
	public BigInteger getQ16501To1000IncomeAtLatestFollowupforStayers() {
		return q16501To1000IncomeAtLatestFollowupforStayers;
	}
	public void setQ16501To1000IncomeAtLatestFollowupforStayers(
			BigInteger q16501To1000IncomeAtLatestFollowupforStayers) {
		this.q16501To1000IncomeAtLatestFollowupforStayers = q16501To1000IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16501To1000IncomeAtExitforLeavers() {
		return q16501To1000IncomeAtExitforLeavers;
	}
	public void setQ16501To1000IncomeAtExitforLeavers(
			BigInteger q16501To1000IncomeAtExitforLeavers) {
		this.q16501To1000IncomeAtExitforLeavers = q16501To1000IncomeAtExitforLeavers;
	}
	public BigInteger getQ161001To1500IncomeAtEntry() {
		return q161001To1500IncomeAtEntry;
	}
	public void setQ161001To1500IncomeAtEntry(
			BigInteger q161001To1500IncomeAtEntry) {
		this.q161001To1500IncomeAtEntry = q161001To1500IncomeAtEntry;
	}
	public BigInteger getQ161001To1500IncomeAtLatestFollowupforStayers() {
		return q161001To1500IncomeAtLatestFollowupforStayers;
	}
	public void setQ161001To1500IncomeAtLatestFollowupforStayers(
			BigInteger q161001To1500IncomeAtLatestFollowupforStayers) {
		this.q161001To1500IncomeAtLatestFollowupforStayers = q161001To1500IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ161001To1500IncomeAtExitforLeavers() {
		return q161001To1500IncomeAtExitforLeavers;
	}
	public void setQ161001To1500IncomeAtExitforLeavers(
			BigInteger q161001To1500IncomeAtExitforLeavers) {
		this.q161001To1500IncomeAtExitforLeavers = q161001To1500IncomeAtExitforLeavers;
	}
	public BigInteger getQ161501To2000IncomeAtEntry() {
		return q161501To2000IncomeAtEntry;
	}
	public void setQ161501To2000IncomeAtEntry(
			BigInteger q161501To2000IncomeAtEntry) {
		this.q161501To2000IncomeAtEntry = q161501To2000IncomeAtEntry;
	}
	public BigInteger getQ161501To2000IncomeAtLatestFollowupforStayers() {
		return q161501To2000IncomeAtLatestFollowupforStayers;
	}
	public void setQ161501To2000IncomeAtLatestFollowupforStayers(
			BigInteger q161501To2000IncomeAtLatestFollowupforStayers) {
		this.q161501To2000IncomeAtLatestFollowupforStayers = q161501To2000IncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ161501To2000IncomeAtExitforLeavers() {
		return q161501To2000IncomeAtExitforLeavers;
	}
	public void setQ161501To2000IncomeAtExitforLeavers(
			BigInteger q161501To2000IncomeAtExitforLeavers) {
		this.q161501To2000IncomeAtExitforLeavers = q161501To2000IncomeAtExitforLeavers;
	}
	public BigInteger getQ162000PlusIncomeAtEntry() {
		return q162000PlusIncomeAtEntry;
	}
	public void setQ162000PlusIncomeAtEntry(BigInteger q162000PlusIncomeAtEntry) {
		this.q162000PlusIncomeAtEntry = q162000PlusIncomeAtEntry;
	}
	public BigInteger getQ162000PlusIncomeAtLatestFollowupforStayers() {
		return q162000PlusIncomeAtLatestFollowupforStayers;
	}
	public void setQ162000PlusIncomeAtLatestFollowupforStayers(
			BigInteger q162000PlusIncomeAtLatestFollowupforStayers) {
		this.q162000PlusIncomeAtLatestFollowupforStayers = q162000PlusIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ162000PlusIncomeAtExitforLeavers() {
		return q162000PlusIncomeAtExitforLeavers;
	}
	public void setQ162000PlusIncomeAtExitforLeavers(
			BigInteger q162000PlusIncomeAtExitforLeavers) {
		this.q162000PlusIncomeAtExitforLeavers = q162000PlusIncomeAtExitforLeavers;
	}
	public BigInteger getQ16ClientDoesntKnowIncomeAtEntry() {
		return q16ClientDoesntKnowIncomeAtEntry;
	}
	public void setQ16ClientDoesntKnowIncomeAtEntry(
			BigInteger q16ClientDoesntKnowIncomeAtEntry) {
		this.q16ClientDoesntKnowIncomeAtEntry = q16ClientDoesntKnowIncomeAtEntry;
	}
	public BigInteger getQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers() {
		return q16ClientDoesntKnowIncomeAtLatestFollowupforStayers;
	}
	public void setQ16ClientDoesntKnowIncomeAtLatestFollowupforStayers(
			BigInteger q16ClientDoesntKnowIncomeAtLatestFollowupforStayers) {
		this.q16ClientDoesntKnowIncomeAtLatestFollowupforStayers = q16ClientDoesntKnowIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16ClientDoesntKnowIncomeAtExitforLeavers() {
		return q16ClientDoesntKnowIncomeAtExitforLeavers;
	}
	public void setQ16ClientDoesntKnowIncomeAtExitforLeavers(
			BigInteger q16ClientDoesntKnowIncomeAtExitforLeavers) {
		this.q16ClientDoesntKnowIncomeAtExitforLeavers = q16ClientDoesntKnowIncomeAtExitforLeavers;
	}
	public BigInteger getQ16DataNotCollectedIncomeAtEntry() {
		return q16DataNotCollectedIncomeAtEntry;
	}
	public void setQ16DataNotCollectedIncomeAtEntry(
			BigInteger q16DataNotCollectedIncomeAtEntry) {
		this.q16DataNotCollectedIncomeAtEntry = q16DataNotCollectedIncomeAtEntry;
	}
	public BigInteger getQ16DataNotCollectedIncomeAtLatestFollowupforStayers() {
		return q16DataNotCollectedIncomeAtLatestFollowupforStayers;
	}
	public void setQ16DataNotCollectedIncomeAtLatestFollowupforStayers(
			BigInteger q16DataNotCollectedIncomeAtLatestFollowupforStayers) {
		this.q16DataNotCollectedIncomeAtLatestFollowupforStayers = q16DataNotCollectedIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16DataNotCollectedIncomeAtExitforLeavers() {
		return q16DataNotCollectedIncomeAtExitforLeavers;
	}
	public void setQ16DataNotCollectedIncomeAtExitforLeavers(
			BigInteger q16DataNotCollectedIncomeAtExitforLeavers) {
		this.q16DataNotCollectedIncomeAtExitforLeavers = q16DataNotCollectedIncomeAtExitforLeavers;
	}
	public BigInteger getQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry() {
		return q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry;
	}
	public void setQ16NumberOfAdultStayersNotYetRequiredIncomeAtEntry(
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry) {
		this.q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry = q16NumberOfAdultStayersNotYetRequiredIncomeAtEntry;
	}
	public BigInteger getQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers() {
		return q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers;
	}
	public void setQ16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers(
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers) {
		this.q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers = q16NumberOfAdultStayersNotYetRequiredIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers() {
		return q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers;
	}
	public void setQ16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers(
			BigInteger q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers) {
		this.q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers = q16NumberOfAdultStayersNotYetRequiredIncomeAtExitforLeavers;
	}
	public BigInteger getQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry() {
		return q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry;
	}
	public void setQ16NumberOfAdultStayersWithoutRequiredIncomeAtEntry(
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry) {
		this.q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry = q16NumberOfAdultStayersWithoutRequiredIncomeAtEntry;
	}
	public BigInteger getQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers() {
		return q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers;
	}
	public void setQ16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers(
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers) {
		this.q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers = q16NumberOfAdultStayersWithoutRequiredIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers() {
		return q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers;
	}
	public void setQ16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers(
			BigInteger q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers) {
		this.q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers = q16NumberOfAdultStayersWithoutRequiredIncomeAtExitforLeavers;
	}
	public BigInteger getQ16TotalAdultsIncomeAtEntry() {
		return q16TotalAdultsIncomeAtEntry;
	}
	public void setQ16TotalAdultsIncomeAtEntry(
			BigInteger q16TotalAdultsIncomeAtEntry) {
		this.q16TotalAdultsIncomeAtEntry = q16TotalAdultsIncomeAtEntry;
	}
	public BigInteger getQ16TotalAdultsIncomeAtLatestFollowupforStayers() {
		return q16TotalAdultsIncomeAtLatestFollowupforStayers;
	}
	public void setQ16TotalAdultsIncomeAtLatestFollowupforStayers(
			BigInteger q16TotalAdultsIncomeAtLatestFollowupforStayers) {
		this.q16TotalAdultsIncomeAtLatestFollowupforStayers = q16TotalAdultsIncomeAtLatestFollowupforStayers;
	}
	public BigInteger getQ16TotalAdultsIncomeAtExitforLeavers() {
		return q16TotalAdultsIncomeAtExitforLeavers;
	}
	public void setQ16TotalAdultsIncomeAtExitforLeavers(
			BigInteger q16TotalAdultsIncomeAtExitforLeavers) {
		this.q16TotalAdultsIncomeAtExitforLeavers = q16TotalAdultsIncomeAtExitforLeavers;
	}
	public BigInteger getQ15PSHforHomelessPersonsTotal() {
		return q15PSHforHomelessPersonsTotal;
	}
	public void setQ15PSHforHomelessPersonsTotal(
			BigInteger q15psHforHomelessPersonsTotal) {
		q15PSHforHomelessPersonsTotal = q15psHforHomelessPersonsTotal;
	}
	public BigInteger getQ15RentalByClientWithGPDTIPSubsidyTotal() {
		return q15RentalByClientWithGPDTIPSubsidyTotal;
	}
	public void setQ15RentalByClientWithGPDTIPSubsidyTotal(
			BigInteger q15RentalByClientWithGPDTIPSubsidyTotal) {
		this.q15RentalByClientWithGPDTIPSubsidyTotal = q15RentalByClientWithGPDTIPSubsidyTotal;
	}
	public BigInteger getQ15RentalByClientWithGPDTIPSubsidyWithoutChild() {
		return q15RentalByClientWithGPDTIPSubsidyWithoutChild;
	}
	public void setQ15RentalByClientWithGPDTIPSubsidyWithoutChild(
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithoutChild) {
		this.q15RentalByClientWithGPDTIPSubsidyWithoutChild = q15RentalByClientWithGPDTIPSubsidyWithoutChild;
	}
	public BigInteger getQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult() {
		return q15RentalByClientWithGPDTIPSubsidyWithchildandAdult;
	}
	public void setQ15RentalByClientWithGPDTIPSubsidyWithchildandAdult(
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithchildandAdult) {
		this.q15RentalByClientWithGPDTIPSubsidyWithchildandAdult = q15RentalByClientWithGPDTIPSubsidyWithchildandAdult;
	}
	public BigInteger getQ15RentalByClientWithGPDTIPSubsidyWithChildOnly() {
		return q15RentalByClientWithGPDTIPSubsidyWithChildOnly;
	}
	public void setQ15RentalByClientWithGPDTIPSubsidyWithChildOnly(
			BigInteger q15RentalByClientWithGPDTIPSubsidyWithChildOnly) {
		this.q15RentalByClientWithGPDTIPSubsidyWithChildOnly = q15RentalByClientWithGPDTIPSubsidyWithChildOnly;
	}
	public BigInteger getQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold() {
		return q15RentalByClientWithGPDTIPSubsidyUnknownHousehold;
	}
	public void setQ15RentalByClientWithGPDTIPSubsidyUnknownHousehold(
			BigInteger q15RentalByClientWithGPDTIPSubsidyUnknownHousehold) {
		this.q15RentalByClientWithGPDTIPSubsidyUnknownHousehold = q15RentalByClientWithGPDTIPSubsidyUnknownHousehold;
	}
	public BigInteger getQ15OwnedByclientNoSubsidyTotal() {
		return q15OwnedByclientNoSubsidyTotal;
	}
	public void setQ15OwnedByclientNoSubsidyTotal(
			BigInteger q15OwnedByclientNoSubsidyTotal) {
		this.q15OwnedByclientNoSubsidyTotal = q15OwnedByclientNoSubsidyTotal;
	}
	public BigInteger getQ15OwnedByclientNoSubsidyWithoutchild() {
		return q15OwnedByclientNoSubsidyWithoutchild;
	}
	public void setQ15OwnedByclientNoSubsidyWithoutchild(
			BigInteger q15OwnedByclientNoSubsidyWithoutchild) {
		this.q15OwnedByclientNoSubsidyWithoutchild = q15OwnedByclientNoSubsidyWithoutchild;
	}
	public BigInteger getQ15OwnedByclientNoSubsidyWithChildandAdult() {
		return q15OwnedByclientNoSubsidyWithChildandAdult;
	}
	public void setQ15OwnedByclientNoSubsidyWithChildandAdult(
			BigInteger q15OwnedByclientNoSubsidyWithChildandAdult) {
		this.q15OwnedByclientNoSubsidyWithChildandAdult = q15OwnedByclientNoSubsidyWithChildandAdult;
	}
	public BigInteger getQ15OwnedByclientNoSubsidyWithChildOnly() {
		return q15OwnedByclientNoSubsidyWithChildOnly;
	}
	public void setQ15OwnedByclientNoSubsidyWithChildOnly(
			BigInteger q15OwnedByclientNoSubsidyWithChildOnly) {
		this.q15OwnedByclientNoSubsidyWithChildOnly = q15OwnedByclientNoSubsidyWithChildOnly;
	}
	public BigInteger getQ15OwnedByclientNoSubsidyUnknowHousehold() {
		return q15OwnedByclientNoSubsidyUnknowHousehold;
	}
	public void setQ15OwnedByclientNoSubsidyUnknowHousehold(
			BigInteger q15OwnedByclientNoSubsidyUnknowHousehold) {
		this.q15OwnedByclientNoSubsidyUnknowHousehold = q15OwnedByclientNoSubsidyUnknowHousehold;
	}
	public BigInteger getQ15InstitutionalSettingsTotal() {
		return q15InstitutionalSettingsTotal;
	}
	public void setQ15InstitutionalSettingsTotal(
			BigInteger q15InstitutionalSettingsTotal) {
		this.q15InstitutionalSettingsTotal = q15InstitutionalSettingsTotal;
	}
	public BigInteger getQ15InstitutionalSettingsWithoutChildren() {
		return q15InstitutionalSettingsWithoutChildren;
	}
	public void setQ15InstitutionalSettingsWithoutChildren(
			BigInteger q15InstitutionalSettingsWithoutChildren) {
		this.q15InstitutionalSettingsWithoutChildren = q15InstitutionalSettingsWithoutChildren;
	}
	public BigInteger getQ15InstitutionalSettingsWithChildandAdult() {
		return q15InstitutionalSettingsWithChildandAdult;
	}
	public void setQ15InstitutionalSettingsWithChildandAdult(
			BigInteger q15InstitutionalSettingsWithChildandAdult) {
		this.q15InstitutionalSettingsWithChildandAdult = q15InstitutionalSettingsWithChildandAdult;
	}
	public BigInteger getQ15InstitutionalSettingsWithChildOnly() {
		return q15InstitutionalSettingsWithChildOnly;
	}
	public void setQ15InstitutionalSettingsWithChildOnly(
			BigInteger q15InstitutionalSettingsWithChildOnly) {
		this.q15InstitutionalSettingsWithChildOnly = q15InstitutionalSettingsWithChildOnly;
	}
	public BigInteger getQ15InstitutionalSettingsUnknowHouseHold() {
		return q15InstitutionalSettingsUnknowHouseHold;
	}
	public void setQ15InstitutionalSettingsUnknowHouseHold(
			BigInteger q15InstitutionalSettingsUnknowHouseHold) {
		this.q15InstitutionalSettingsUnknowHouseHold = q15InstitutionalSettingsUnknowHouseHold;
	}
	public BigInteger getQ15PsychiatricFacilityTotal() {
		return q15PsychiatricFacilityTotal;
	}
	public void setQ15PsychiatricFacilityTotal(
			BigInteger q15PsychiatricFacilityTotal) {
		this.q15PsychiatricFacilityTotal = q15PsychiatricFacilityTotal;
	}
	public BigInteger getQ15PsychiatricFacilityWithoutChildren() {
		return q15PsychiatricFacilityWithoutChildren;
	}
	public void setQ15PsychiatricFacilityWithoutChildren(
			BigInteger q15PsychiatricFacilityWithoutChildren) {
		this.q15PsychiatricFacilityWithoutChildren = q15PsychiatricFacilityWithoutChildren;
	}
	public BigInteger getQ15PsychiatricFacilityWithChildandAdult() {
		return q15PsychiatricFacilityWithChildandAdult;
	}
	public void setQ15PsychiatricFacilityWithChildandAdult(
			BigInteger q15PsychiatricFacilityWithChildandAdult) {
		this.q15PsychiatricFacilityWithChildandAdult = q15PsychiatricFacilityWithChildandAdult;
	}
	public BigInteger getQ15PsychiatricFacilityWithChildOnly() {
		return q15PsychiatricFacilityWithChildOnly;
	}
	public void setQ15PsychiatricFacilityWithChildOnly(
			BigInteger q15PsychiatricFacilityWithChildOnly) {
		this.q15PsychiatricFacilityWithChildOnly = q15PsychiatricFacilityWithChildOnly;
	}
	public BigInteger getQ15PsychiatricFacilityUnknownhouseHold() {
		return q15PsychiatricFacilityUnknownhouseHold;
	}
	public void setQ15PsychiatricFacilityUnknownhouseHold(
			BigInteger q15PsychiatricFacilityUnknownhouseHold) {
		this.q15PsychiatricFacilityUnknownhouseHold = q15PsychiatricFacilityUnknownhouseHold;
	}
	public BigInteger getQ15SubstanceAbuseTotal() {
		return q15SubstanceAbuseTotal;
	}
	public void setQ15SubstanceAbuseTotal(BigInteger q15SubstanceAbuseTotal) {
		this.q15SubstanceAbuseTotal = q15SubstanceAbuseTotal;
	}
	public BigInteger getQ15SubstanceAbuseWithoutChildren() {
		return q15SubstanceAbuseWithoutChildren;
	}
	public void setQ15SubstanceAbuseWithoutChildren(
			BigInteger q15SubstanceAbuseWithoutChildren) {
		this.q15SubstanceAbuseWithoutChildren = q15SubstanceAbuseWithoutChildren;
	}
	public BigInteger getQ15SubstanceAbuseWithChildandAdult() {
		return q15SubstanceAbuseWithChildandAdult;
	}
	public void setQ15SubstanceAbuseWithChildandAdult(
			BigInteger q15SubstanceAbuseWithChildandAdult) {
		this.q15SubstanceAbuseWithChildandAdult = q15SubstanceAbuseWithChildandAdult;
	}
	public BigInteger getQ15SubstanceAbuseWithChildOnly() {
		return q15SubstanceAbuseWithChildOnly;
	}
	public void setQ15SubstanceAbuseWithChildOnly(
			BigInteger q15SubstanceAbuseWithChildOnly) {
		this.q15SubstanceAbuseWithChildOnly = q15SubstanceAbuseWithChildOnly;
	}
	public BigInteger getQ15SubstanceAbuseUnknowHouseHold() {
		return q15SubstanceAbuseUnknowHouseHold;
	}
	public void setQ15SubstanceAbuseUnknowHouseHold(
			BigInteger q15SubstanceAbuseUnknowHouseHold) {
		this.q15SubstanceAbuseUnknowHouseHold = q15SubstanceAbuseUnknowHouseHold;
	}
	public BigInteger getQ15HospitalNonPhychiatricTotal() {
		return q15HospitalNonPhychiatricTotal;
	}
	public void setQ15HospitalNonPhychiatricTotal(
			BigInteger q15HospitalNonPhychiatricTotal) {
		this.q15HospitalNonPhychiatricTotal = q15HospitalNonPhychiatricTotal;
	}
	public BigInteger getQ15HospitalNonPhychiatricWithoutChild() {
		return q15HospitalNonPhychiatricWithoutChild;
	}
	public void setQ15HospitalNonPhychiatricWithoutChild(
			BigInteger q15HospitalNonPhychiatricWithoutChild) {
		this.q15HospitalNonPhychiatricWithoutChild = q15HospitalNonPhychiatricWithoutChild;
	}
	public BigInteger getQ15HospitalNonPhychiatricWithChildandAdult() {
		return q15HospitalNonPhychiatricWithChildandAdult;
	}
	public void setQ15HospitalNonPhychiatricWithChildandAdult(
			BigInteger q15HospitalNonPhychiatricWithChildandAdult) {
		this.q15HospitalNonPhychiatricWithChildandAdult = q15HospitalNonPhychiatricWithChildandAdult;
	}
	public BigInteger getQ15HospitalNonPhychiatricWithChildOnly() {
		return q15HospitalNonPhychiatricWithChildOnly;
	}
	public void setQ15HospitalNonPhychiatricWithChildOnly(
			BigInteger q15HospitalNonPhychiatricWithChildOnly) {
		this.q15HospitalNonPhychiatricWithChildOnly = q15HospitalNonPhychiatricWithChildOnly;
	}
	public BigInteger getQ15HospitalNonPhychiatricUnknownHouseHold() {
		return q15HospitalNonPhychiatricUnknownHouseHold;
	}
	public void setQ15HospitalNonPhychiatricUnknownHouseHold(
			BigInteger q15HospitalNonPhychiatricUnknownHouseHold) {
		this.q15HospitalNonPhychiatricUnknownHouseHold = q15HospitalNonPhychiatricUnknownHouseHold;
	}
	public BigInteger getQ15JailPrisonTotal() {
		return q15JailPrisonTotal;
	}
	public void setQ15JailPrisonTotal(BigInteger q15JailPrisonTotal) {
		this.q15JailPrisonTotal = q15JailPrisonTotal;
	}
	public BigInteger getQ15JailPrisonWithoutChild() {
		return q15JailPrisonWithoutChild;
	}
	public void setQ15JailPrisonWithoutChild(BigInteger q15JailPrisonWithoutChild) {
		this.q15JailPrisonWithoutChild = q15JailPrisonWithoutChild;
	}
	public BigInteger getQ15JailPrisonWithChildandAdult() {
		return q15JailPrisonWithChildandAdult;
	}
	public void setQ15JailPrisonWithChildandAdult(
			BigInteger q15JailPrisonWithChildandAdult) {
		this.q15JailPrisonWithChildandAdult = q15JailPrisonWithChildandAdult;
	}
	public BigInteger getQ15JailPrisonWithChildOnly() {
		return q15JailPrisonWithChildOnly;
	}
	public void setQ15JailPrisonWithChildOnly(BigInteger q15JailPrisonWithChildOnly) {
		this.q15JailPrisonWithChildOnly = q15JailPrisonWithChildOnly;
	}
	public BigInteger getQ15JailPrisonUnknowHouseHold() {
		return q15JailPrisonUnknowHouseHold;
	}
	public void setQ15JailPrisonUnknowHouseHold(
			BigInteger q15JailPrisonUnknowHouseHold) {
		this.q15JailPrisonUnknowHouseHold = q15JailPrisonUnknowHouseHold;
	}
	public BigInteger getQ15FosterCarehomeTotal() {
		return q15FosterCarehomeTotal;
	}
	public void setQ15FosterCarehomeTotal(BigInteger q15FosterCarehomeTotal) {
		this.q15FosterCarehomeTotal = q15FosterCarehomeTotal;
	}
	public BigInteger getQ15FosterCarehomeWithoutChild() {
		return q15FosterCarehomeWithoutChild;
	}
	public void setQ15FosterCarehomeWithoutChild(
			BigInteger q15FosterCarehomeWithoutChild) {
		this.q15FosterCarehomeWithoutChild = q15FosterCarehomeWithoutChild;
	}
	public BigInteger getQ15FosterCarehomeWithChildandAdult() {
		return q15FosterCarehomeWithChildandAdult;
	}
	public void setQ15FosterCarehomeWithChildandAdult(
			BigInteger q15FosterCarehomeWithChildandAdult) {
		this.q15FosterCarehomeWithChildandAdult = q15FosterCarehomeWithChildandAdult;
	}
	public BigInteger getQ15FosterCarehomeWithChildOnly() {
		return q15FosterCarehomeWithChildOnly;
	}
	public void setQ15FosterCarehomeWithChildOnly(
			BigInteger q15FosterCarehomeWithChildOnly) {
		this.q15FosterCarehomeWithChildOnly = q15FosterCarehomeWithChildOnly;
	}
	public BigInteger getQ15FosterCarehomeUnknownHouseHold() {
		return q15FosterCarehomeUnknownHouseHold;
	}
	public void setQ15FosterCarehomeUnknownHouseHold(
			BigInteger q15FosterCarehomeUnknownHouseHold) {
		this.q15FosterCarehomeUnknownHouseHold = q15FosterCarehomeUnknownHouseHold;
	}
	public BigInteger getQ15LongTermCareFacilityTotal() {
		return q15LongTermCareFacilityTotal;
	}
	public void setQ15LongTermCareFacilityTotal(
			BigInteger q15LongTermCareFacilityTotal) {
		this.q15LongTermCareFacilityTotal = q15LongTermCareFacilityTotal;
	}
	public BigInteger getQ15LongTermCareFacilityWithoutChild() {
		return q15LongTermCareFacilityWithoutChild;
	}
	public void setQ15LongTermCareFacilityWithoutChild(
			BigInteger q15LongTermCareFacilityWithoutChild) {
		this.q15LongTermCareFacilityWithoutChild = q15LongTermCareFacilityWithoutChild;
	}
	public BigInteger getQ15LongTermCareFacilityWithChildandAdult() {
		return q15LongTermCareFacilityWithChildandAdult;
	}
	public void setQ15LongTermCareFacilityWithChildandAdult(
			BigInteger q15LongTermCareFacilityWithChildandAdult) {
		this.q15LongTermCareFacilityWithChildandAdult = q15LongTermCareFacilityWithChildandAdult;
	}
	public BigInteger getQ15LongTermCareFacilityWithChildOnly() {
		return q15LongTermCareFacilityWithChildOnly;
	}
	public void setQ15LongTermCareFacilityWithChildOnly(
			BigInteger q15LongTermCareFacilityWithChildOnly) {
		this.q15LongTermCareFacilityWithChildOnly = q15LongTermCareFacilityWithChildOnly;
	}
	public BigInteger getQ15LongTermCareFacilityUnknowHouseHold() {
		return q15LongTermCareFacilityUnknowHouseHold;
	}
	public void setQ15LongTermCareFacilityUnknowHouseHold(
			BigInteger q15LongTermCareFacilityUnknowHouseHold) {
		this.q15LongTermCareFacilityUnknowHouseHold = q15LongTermCareFacilityUnknowHouseHold;
	}
	public BigInteger getQ15ResidentialProjectTotal() {
		return q15ResidentialProjectTotal;
	}
	public void setQ15ResidentialProjectTotal(BigInteger q15ResidentialProjectTotal) {
		this.q15ResidentialProjectTotal = q15ResidentialProjectTotal;
	}
	public BigInteger getQ15ResidentialProjectWithoutChild() {
		return q15ResidentialProjectWithoutChild;
	}
	public void setQ15ResidentialProjectWithoutChild(
			BigInteger q15ResidentialProjectWithoutChild) {
		this.q15ResidentialProjectWithoutChild = q15ResidentialProjectWithoutChild;
	}
	public BigInteger getQ15ResidentialProjectWithChildandAdult() {
		return q15ResidentialProjectWithChildandAdult;
	}
	public void setQ15ResidentialProjectWithChildandAdult(
			BigInteger q15ResidentialProjectWithChildandAdult) {
		this.q15ResidentialProjectWithChildandAdult = q15ResidentialProjectWithChildandAdult;
	}
	public BigInteger getQ15ResidentialProjectWithChildOnly() {
		return q15ResidentialProjectWithChildOnly;
	}
	public void setQ15ResidentialProjectWithChildOnly(
			BigInteger q15ResidentialProjectWithChildOnly) {
		this.q15ResidentialProjectWithChildOnly = q15ResidentialProjectWithChildOnly;
	}
	public BigInteger getQ15ResidentialProjectUnknownHouseHold() {
		return q15ResidentialProjectUnknownHouseHold;
	}
	public void setQ15ResidentialProjectUnknownHouseHold(
			BigInteger q15ResidentialProjectUnknownHouseHold) {
		this.q15ResidentialProjectUnknownHouseHold = q15ResidentialProjectUnknownHouseHold;
	}
	public BigInteger getQ15BzTotalSummed() {
		return q15BzTotalSummed;
	}
	public void setQ15BzTotalSummed(BigInteger q15BzTotalSummed) {
		this.q15BzTotalSummed = q15BzTotalSummed;
	}
	public BigInteger getQ15BzTotalWithoutChild() {
		return q15BzTotalWithoutChild;
	}
	public void setQ15BzTotalWithoutChild(BigInteger q15BzTotalWithoutChild) {
		this.q15BzTotalWithoutChild = q15BzTotalWithoutChild;
	}
	public BigInteger getQ15BzTotalWithChildandAdult() {
		return q15BzTotalWithChildandAdult;
	}
	public void setQ15BzTotalWithChildandAdult(
			BigInteger q15BzTotalWithChildandAdult) {
		this.q15BzTotalWithChildandAdult = q15BzTotalWithChildandAdult;
	}
	public BigInteger getQ15BzTotalWithChildOnly() {
		return q15BzTotalWithChildOnly;
	}
	public void setQ15BzTotalWithChildOnly(BigInteger q15BzTotalWithChildOnly) {
		this.q15BzTotalWithChildOnly = q15BzTotalWithChildOnly;
	}
	public BigInteger getQ15BzTotalUnknowHousehold() {
		return q15BzTotalUnknowHousehold;
	}
	public void setQ15BzTotalUnknowHousehold(BigInteger q15BzTotalUnknowHousehold) {
		this.q15BzTotalUnknowHousehold = q15BzTotalUnknowHousehold;
	}
	public BigInteger getQ15OtherLocationTotal() {
		return q15OtherLocationTotal;
	}
	public void setQ15OtherLocationTotal(BigInteger q15OtherLocationTotal) {
		this.q15OtherLocationTotal = q15OtherLocationTotal;
	}
	public BigInteger getQ15OtherLocationWithoutChild() {
		return q15OtherLocationWithoutChild;
	}
	public void setQ15OtherLocationWithoutChild(
			BigInteger q15OtherLocationWithoutChild) {
		this.q15OtherLocationWithoutChild = q15OtherLocationWithoutChild;
	}
	public BigInteger getQ15OtherLocationWithChildandAdult() {
		return q15OtherLocationWithChildandAdult;
	}
	public void setQ15OtherLocationWithChildandAdult(
			BigInteger q15OtherLocationWithChildandAdult) {
		this.q15OtherLocationWithChildandAdult = q15OtherLocationWithChildandAdult;
	}
	public BigInteger getQ15OtherLocationWithChildOnly() {
		return q15OtherLocationWithChildOnly;
	}
	public void setQ15OtherLocationWithChildOnly(
			BigInteger q15OtherLocationWithChildOnly) {
		this.q15OtherLocationWithChildOnly = q15OtherLocationWithChildOnly;
	}
	public BigInteger getQ15OtherLocationUnkownHousehold() {
		return q15OtherLocationUnkownHousehold;
	}
	public void setQ15OtherLocationUnkownHousehold(
			BigInteger q15OtherLocationUnkownHousehold) {
		this.q15OtherLocationUnkownHousehold = q15OtherLocationUnkownHousehold;
	}
	
	public BigInteger getQ15PSHforHomelessPersonsWithoutChild() {
		return q15PSHforHomelessPersonsWithoutChild;
	}
	public void setQ15PSHforHomelessPersonsWithoutChild(
			BigInteger q15psHforHomelessPersonsWithoutChild) {
		q15PSHforHomelessPersonsWithoutChild = q15psHforHomelessPersonsWithoutChild;
	}
	public BigInteger getQ15PSHforHomelessPersonsWithChilandAdult() {
		return q15PSHforHomelessPersonsWithChilandAdult;
	}
	public void setQ15PSHforHomelessPersonsWithChilandAdult(
			BigInteger q15psHforHomelessPersonsWithChilandAdult) {
		q15PSHforHomelessPersonsWithChilandAdult = q15psHforHomelessPersonsWithChilandAdult;
	}
	public BigInteger getQ15PSHforHomelessPersonsWithChildOnly() {
		return q15PSHforHomelessPersonsWithChildOnly;
	}
	public void setQ15PSHforHomelessPersonsWithChildOnly(
			BigInteger q15psHforHomelessPersonsWithChildOnly) {
		q15PSHforHomelessPersonsWithChildOnly = q15psHforHomelessPersonsWithChildOnly;
	}
	public BigInteger getQ15PSHforHomelessPersonsUnknowHousehold() {
		return q15PSHforHomelessPersonsUnknowHousehold;
	}
	public void setQ15PSHforHomelessPersonsUnknowHousehold(
			BigInteger q15psHforHomelessPersonsUnknowHousehold) {
		q15PSHforHomelessPersonsUnknowHousehold = q15psHforHomelessPersonsUnknowHousehold;
	}
	public BigInteger getQ15OwnedByclientWithSubsidyTotal() {
		return q15OwnedByclientWithSubsidyTotal;
	}
	public void setQ15OwnedByclientWithSubsidyTotal(
			BigInteger q15OwnedByclientWithSubsidyTotal) {
		this.q15OwnedByclientWithSubsidyTotal = q15OwnedByclientWithSubsidyTotal;
	}
	public BigInteger getQ15OwnedByclientWithSubsidyWithoutchild() {
		return q15OwnedByclientWithSubsidyWithoutchild;
	}
	public void setQ15OwnedByclientWithSubsidyWithoutchild(
			BigInteger q15OwnedByclientWithSubsidyWithoutchild) {
		this.q15OwnedByclientWithSubsidyWithoutchild = q15OwnedByclientWithSubsidyWithoutchild;
	}
	public BigInteger getQ15OwnedByclientWithSubsidyWithChildandAdult() {
		return q15OwnedByclientWithSubsidyWithChildandAdult;
	}
	public void setQ15OwnedByclientWithSubsidyWithChildandAdult(
			BigInteger q15OwnedByclientWithSubsidyWithChildandAdult) {
		this.q15OwnedByclientWithSubsidyWithChildandAdult = q15OwnedByclientWithSubsidyWithChildandAdult;
	}
	public BigInteger getQ15OwnedByclientWithSubsidyWithChildOnly() {
		return q15OwnedByclientWithSubsidyWithChildOnly;
	}
	public void setQ15OwnedByclientWithSubsidyWithChildOnly(
			BigInteger q15OwnedByclientWithSubsidyWithChildOnly) {
		this.q15OwnedByclientWithSubsidyWithChildOnly = q15OwnedByclientWithSubsidyWithChildOnly;
	}
	public BigInteger getQ15OwnedByclientWithSubsidyUnknowHousehold() {
		return q15OwnedByclientWithSubsidyUnknowHousehold;
	}
	public void setQ15OwnedByclientWithSubsidyUnknowHousehold(
			BigInteger q15OwnedByclientWithSubsidyUnknowHousehold) {
		this.q15OwnedByclientWithSubsidyUnknowHousehold = q15OwnedByclientWithSubsidyUnknowHousehold;
	}
	public BigInteger getQ15RentalByClientNoSubsidyTotal() {
		return q15RentalByClientNoSubsidyTotal;
	}
	public void setQ15RentalByClientNoSubsidyTotal(
			BigInteger q15RentalByClientNoSubsidyTotal) {
		this.q15RentalByClientNoSubsidyTotal = q15RentalByClientNoSubsidyTotal;
	}
	public BigInteger getQ15RentalByClientNoSubsidyWithoutChild() {
		return q15RentalByClientNoSubsidyWithoutChild;
	}
	public void setQ15RentalByClientNoSubsidyWithoutChild(
			BigInteger q15RentalByClientNoSubsidyWithoutChild) {
		this.q15RentalByClientNoSubsidyWithoutChild = q15RentalByClientNoSubsidyWithoutChild;
	}
	public BigInteger getQ15RentalByClientNoSubsidyWithChildandAdult() {
		return q15RentalByClientNoSubsidyWithChildandAdult;
	}
	public void setQ15RentalByClientNoSubsidyWithChildandAdult(
			BigInteger q15RentalByClientNoSubsidyWithChildandAdult) {
		this.q15RentalByClientNoSubsidyWithChildandAdult = q15RentalByClientNoSubsidyWithChildandAdult;
	}
	public BigInteger getQ15RentalByClientNoSubsidyWithchildOnly() {
		return q15RentalByClientNoSubsidyWithchildOnly;
	}
	public void setQ15RentalByClientNoSubsidyWithchildOnly(
			BigInteger q15RentalByClientNoSubsidyWithchildOnly) {
		this.q15RentalByClientNoSubsidyWithchildOnly = q15RentalByClientNoSubsidyWithchildOnly;
	}
	public BigInteger getQ15RentalByClientNoSubsidyUnknownHousehold() {
		return q15RentalByClientNoSubsidyUnknownHousehold;
	}
	public void setQ15RentalByClientNoSubsidyUnknownHousehold(
			BigInteger q15RentalByClientNoSubsidyUnknownHousehold) {
		this.q15RentalByClientNoSubsidyUnknownHousehold = q15RentalByClientNoSubsidyUnknownHousehold;
	}
	public BigInteger getQ15RentalByClientWithVASHSubsidyTotal() {
		return q15RentalByClientWithVASHSubsidyTotal;
	}
	public void setQ15RentalByClientWithVASHSubsidyTotal(
			BigInteger q15RentalByClientWithVASHSubsidyTotal) {
		this.q15RentalByClientWithVASHSubsidyTotal = q15RentalByClientWithVASHSubsidyTotal;
	}
	public BigInteger getQ15RentalByClientWithVASHSubsidyWithoutChild() {
		return q15RentalByClientWithVASHSubsidyWithoutChild;
	}
	public void setQ15RentalByClientWithVASHSubsidyWithoutChild(
			BigInteger q15RentalByClientWithVASHSubsidyWithoutChild) {
		this.q15RentalByClientWithVASHSubsidyWithoutChild = q15RentalByClientWithVASHSubsidyWithoutChild;
	}
	public BigInteger getQ15RentalByClientWithVASHSubsidyWithchildandAdult() {
		return q15RentalByClientWithVASHSubsidyWithchildandAdult;
	}
	public void setQ15RentalByClientWithVASHSubsidyWithchildandAdult(
			BigInteger q15RentalByClientWithVASHSubsidyWithchildandAdult) {
		this.q15RentalByClientWithVASHSubsidyWithchildandAdult = q15RentalByClientWithVASHSubsidyWithchildandAdult;
	}
	public BigInteger getQ15RentalByClientWithVASHSubsidyWithChildOnly() {
		return q15RentalByClientWithVASHSubsidyWithChildOnly;
	}
	public void setQ15RentalByClientWithVASHSubsidyWithChildOnly(
			BigInteger q15RentalByClientWithVASHSubsidyWithChildOnly) {
		this.q15RentalByClientWithVASHSubsidyWithChildOnly = q15RentalByClientWithVASHSubsidyWithChildOnly;
	}
	public BigInteger getQ15RentalByClientWithVASHSubsidyUnknownHousehold() {
		return q15RentalByClientWithVASHSubsidyUnknownHousehold;
	}
	public void setQ15RentalByClientWithVASHSubsidyUnknownHousehold(
			BigInteger q15RentalByClientWithVASHSubsidyUnknownHousehold) {
		this.q15RentalByClientWithVASHSubsidyUnknownHousehold = q15RentalByClientWithVASHSubsidyUnknownHousehold;
	}
	public BigInteger getQ15RentalByClientWithOtherSubsidyTotal() {
		return q15RentalByClientWithOtherSubsidyTotal;
	}
	public void setQ15RentalByClientWithOtherSubsidyTotal(
			BigInteger q15RentalByClientWithOtherSubsidyTotal) {
		this.q15RentalByClientWithOtherSubsidyTotal = q15RentalByClientWithOtherSubsidyTotal;
	}
	public BigInteger getQ15RentalByClientWithOtherSubsidyWithoutChild() {
		return q15RentalByClientWithOtherSubsidyWithoutChild;
	}
	public void setQ15RentalByClientWithOtherSubsidyWithoutChild(
			BigInteger q15RentalByClientWithOtherSubsidyWithoutChild) {
		this.q15RentalByClientWithOtherSubsidyWithoutChild = q15RentalByClientWithOtherSubsidyWithoutChild;
	}
	public BigInteger getQ15RentalByClientWithOtherSubsidyWithChildandAdult() {
		return q15RentalByClientWithOtherSubsidyWithChildandAdult;
	}
	public void setQ15RentalByClientWithOtherSubsidyWithChildandAdult(
			BigInteger q15RentalByClientWithOtherSubsidyWithChildandAdult) {
		this.q15RentalByClientWithOtherSubsidyWithChildandAdult = q15RentalByClientWithOtherSubsidyWithChildandAdult;
	}
	public BigInteger getQ15RentalByClientWithOtherSubsidyWithChildOnly() {
		return q15RentalByClientWithOtherSubsidyWithChildOnly;
	}
	public void setQ15RentalByClientWithOtherSubsidyWithChildOnly(
			BigInteger q15RentalByClientWithOtherSubsidyWithChildOnly) {
		this.q15RentalByClientWithOtherSubsidyWithChildOnly = q15RentalByClientWithOtherSubsidyWithChildOnly;
	}
	public BigInteger getQ15RentalByClientWithOtherSubsidyUnknowHousehold() {
		return q15RentalByClientWithOtherSubsidyUnknowHousehold;
	}
	public void setQ15RentalByClientWithOtherSubsidyUnknowHousehold(
			BigInteger q15RentalByClientWithOtherSubsidyUnknowHousehold) {
		this.q15RentalByClientWithOtherSubsidyUnknowHousehold = q15RentalByClientWithOtherSubsidyUnknowHousehold;
	}
	public BigInteger getQ15HotelOrMotelTotal() {
		return q15HotelOrMotelTotal;
	}
	public void setQ15HotelOrMotelTotal(BigInteger q15HotelOrMotelTotal) {
		this.q15HotelOrMotelTotal = q15HotelOrMotelTotal;
	}
	public BigInteger getQ15HotelOrMotelWithoutChild() {
		return q15HotelOrMotelWithoutChild;
	}
	public void setQ15HotelOrMotelWithoutChild(
			BigInteger q15HotelOrMotelWithoutChild) {
		this.q15HotelOrMotelWithoutChild = q15HotelOrMotelWithoutChild;
	}
	public BigInteger getQ15HotelOrMotelWithChidandAdult() {
		return q15HotelOrMotelWithChidandAdult;
	}
	public void setQ15HotelOrMotelWithChidandAdult(
			BigInteger q15HotelOrMotelWithChidandAdult) {
		this.q15HotelOrMotelWithChidandAdult = q15HotelOrMotelWithChidandAdult;
	}
	public BigInteger getQ15HotelOrMotelWithChildOnly() {
		return q15HotelOrMotelWithChildOnly;
	}
	public void setQ15HotelOrMotelWithChildOnly(
			BigInteger q15HotelOrMotelWithChildOnly) {
		this.q15HotelOrMotelWithChildOnly = q15HotelOrMotelWithChildOnly;
	}
	public BigInteger getQ15HotelOrMotelUnkownHousehold() {
		return q15HotelOrMotelUnkownHousehold;
	}
	public void setQ15HotelOrMotelUnkownHousehold(
			BigInteger q15HotelOrMotelUnkownHousehold) {
		this.q15HotelOrMotelUnkownHousehold = q15HotelOrMotelUnkownHousehold;
	}
	public BigInteger getQ15StayingOrLivingWithFriendsTotal() {
		return q15StayingOrLivingWithFriendsTotal;
	}
	public void setQ15StayingOrLivingWithFriendsTotal(
			BigInteger q15StayingOrLivingWithFriendsTotal) {
		this.q15StayingOrLivingWithFriendsTotal = q15StayingOrLivingWithFriendsTotal;
	}
	public BigInteger getQ15StayingOrLivingWithFriendsWithoutChild() {
		return q15StayingOrLivingWithFriendsWithoutChild;
	}
	public void setQ15StayingOrLivingWithFriendsWithoutChild(
			BigInteger q15StayingOrLivingWithFriendsWithoutChild) {
		this.q15StayingOrLivingWithFriendsWithoutChild = q15StayingOrLivingWithFriendsWithoutChild;
	}
	public BigInteger getQ15StayingOrLivingWithFriendsWithChildandAdult() {
		return q15StayingOrLivingWithFriendsWithChildandAdult;
	}
	public void setQ15StayingOrLivingWithFriendsWithChildandAdult(
			BigInteger q15StayingOrLivingWithFriendsWithChildandAdult) {
		this.q15StayingOrLivingWithFriendsWithChildandAdult = q15StayingOrLivingWithFriendsWithChildandAdult;
	}
	public BigInteger getQ15StayingOrLivingWithFriendsWithChildOnly() {
		return q15StayingOrLivingWithFriendsWithChildOnly;
	}
	public void setQ15StayingOrLivingWithFriendsWithChildOnly(
			BigInteger q15StayingOrLivingWithFriendsWithChildOnly) {
		this.q15StayingOrLivingWithFriendsWithChildOnly = q15StayingOrLivingWithFriendsWithChildOnly;
	}
	public BigInteger getQ15StayingOrLivingWithFriendsUnknownHousehold() {
		return q15StayingOrLivingWithFriendsUnknownHousehold;
	}
	public void setQ15StayingOrLivingWithFriendsUnknownHousehold(
			BigInteger q15StayingOrLivingWithFriendsUnknownHousehold) {
		this.q15StayingOrLivingWithFriendsUnknownHousehold = q15StayingOrLivingWithFriendsUnknownHousehold;
	}
	public BigInteger getQ15StayingOrLivingWithFamilyTotal() {
		return q15StayingOrLivingWithFamilyTotal;
	}
	public void setQ15StayingOrLivingWithFamilyTotal(
			BigInteger q15StayingOrLivingWithFamilyTotal) {
		this.q15StayingOrLivingWithFamilyTotal = q15StayingOrLivingWithFamilyTotal;
	}
	public BigInteger getQ15StayingOrLivingWithFamilyWithoutChild() {
		return q15StayingOrLivingWithFamilyWithoutChild;
	}
	public void setQ15StayingOrLivingWithFamilyWithoutChild(
			BigInteger q15StayingOrLivingWithFamilyWithoutChild) {
		this.q15StayingOrLivingWithFamilyWithoutChild = q15StayingOrLivingWithFamilyWithoutChild;
	}
	public BigInteger getQ15StayingOrLivingWithFamilyWithChildandAdult() {
		return q15StayingOrLivingWithFamilyWithChildandAdult;
	}
	public void setQ15StayingOrLivingWithFamilyWithChildandAdult(
			BigInteger q15StayingOrLivingWithFamilyWithChildandAdult) {
		this.q15StayingOrLivingWithFamilyWithChildandAdult = q15StayingOrLivingWithFamilyWithChildandAdult;
	}
	public BigInteger getQ15StayingOrLivingWithFamilyWithChildOnly() {
		return q15StayingOrLivingWithFamilyWithChildOnly;
	}
	public void setQ15StayingOrLivingWithFamilyWithChildOnly(
			BigInteger q15StayingOrLivingWithFamilyWithChildOnly) {
		this.q15StayingOrLivingWithFamilyWithChildOnly = q15StayingOrLivingWithFamilyWithChildOnly;
	}
	public BigInteger getQ15StayingOrLivingWithFamilyUnknownHousehold() {
		return q15StayingOrLivingWithFamilyUnknownHousehold;
	}
	public void setQ15StayingOrLivingWithFamilyUnknownHousehold(
			BigInteger q15StayingOrLivingWithFamilyUnknownHousehold) {
		this.q15StayingOrLivingWithFamilyUnknownHousehold = q15StayingOrLivingWithFamilyUnknownHousehold;
	}
	public BigInteger getQ15OtherTotal() {
		return q15OtherTotal;
	}
	public void setQ15OtherTotal(BigInteger q15OtherTotal) {
		this.q15OtherTotal = q15OtherTotal;
	}
	public BigInteger getQ15OtherWithoutChild() {
		return q15OtherWithoutChild;
	}
	public void setQ15OtherWithoutChild(BigInteger q15OtherWithoutChild) {
		this.q15OtherWithoutChild = q15OtherWithoutChild;
	}
	public BigInteger getQ15OtherWithChildandAdult() {
		return q15OtherWithChildandAdult;
	}
	public void setQ15OtherWithChildandAdult(BigInteger q15OtherWithChildandAdult) {
		this.q15OtherWithChildandAdult = q15OtherWithChildandAdult;
	}
	public BigInteger getQ15OtherWithChildOnly() {
		return q15OtherWithChildOnly;
	}
	public void setQ15OtherWithChildOnly(BigInteger q15OtherWithChildOnly) {
		this.q15OtherWithChildOnly = q15OtherWithChildOnly;
	}
	public BigInteger getQ15OtherUnknownHousehold() {
		return q15OtherUnknownHousehold;
	}
	public void setQ15OtherUnknownHousehold(BigInteger q15OtherUnknownHousehold) {
		this.q15OtherUnknownHousehold = q15OtherUnknownHousehold;
	}
	public BigInteger getQ15DontRefusedTotal() {
		return q15DontRefusedTotal;
	}
	public void setQ15DontRefusedTotal(BigInteger q15DontRefusedTotal) {
		this.q15DontRefusedTotal = q15DontRefusedTotal;
	}
	public BigInteger getQ15DontRefusedWithoutChild() {
		return q15DontRefusedWithoutChild;
	}
	public void setQ15DontRefusedWithoutChild(BigInteger q15DontRefusedWithoutChild) {
		this.q15DontRefusedWithoutChild = q15DontRefusedWithoutChild;
	}
	public BigInteger getQ15DontRefusedWithChildandAdult() {
		return q15DontRefusedWithChildandAdult;
	}
	public void setQ15DontRefusedWithChildandAdult(
			BigInteger q15DontRefusedWithChildandAdult) {
		this.q15DontRefusedWithChildandAdult = q15DontRefusedWithChildandAdult;
	}
	public BigInteger getQ15DontRefusedWithChildOnly() {
		return q15DontRefusedWithChildOnly;
	}
	public void setQ15DontRefusedWithChildOnly(
			BigInteger q15DontRefusedWithChildOnly) {
		this.q15DontRefusedWithChildOnly = q15DontRefusedWithChildOnly;
	}
	public BigInteger getQ15DontRefusedUnknownHousehold() {
		return q15DontRefusedUnknownHousehold;
	}
	public void setQ15DontRefusedUnknownHousehold(
			BigInteger q15DontRefusedUnknownHousehold) {
		this.q15DontRefusedUnknownHousehold = q15DontRefusedUnknownHousehold;
	}
	public BigInteger getQ15InformationMissingTotal() {
		return q15InformationMissingTotal;
	}
	public void setQ15InformationMissingTotal(BigInteger q15InformationMissingTotal) {
		this.q15InformationMissingTotal = q15InformationMissingTotal;
	}
	public BigInteger getQ15InformationMissingWithoutChild() {
		return q15InformationMissingWithoutChild;
	}
	public void setQ15InformationMissingWithoutChild(
			BigInteger q15InformationMissingWithoutChild) {
		this.q15InformationMissingWithoutChild = q15InformationMissingWithoutChild;
	}
	public BigInteger getQ15InformationMissingWithChildandAdult() {
		return q15InformationMissingWithChildandAdult;
	}
	public void setQ15InformationMissingWithChildandAdult(
			BigInteger q15InformationMissingWithChildandAdult) {
		this.q15InformationMissingWithChildandAdult = q15InformationMissingWithChildandAdult;
	}
	public BigInteger getQ15InformationMissingwithChildOnly() {
		return q15InformationMissingwithChildOnly;
	}
	public void setQ15InformationMissingwithChildOnly(
			BigInteger q15InformationMissingwithChildOnly) {
		this.q15InformationMissingwithChildOnly = q15InformationMissingwithChildOnly;
	}
	public BigInteger getQ15InformationMissingUnknownHousehold() {
		return q15InformationMissingUnknownHousehold;
	}
	public void setQ15InformationMissingUnknownHousehold(
			BigInteger q15InformationMissingUnknownHousehold) {
		this.q15InformationMissingUnknownHousehold = q15InformationMissingUnknownHousehold;
	}
	public BigInteger getQ15CzTotalSummed() {
		return q15CzTotalSummed;
	}
	public void setQ15CzTotalSummed(BigInteger q15CzTotalSummed) {
		this.q15CzTotalSummed = q15CzTotalSummed;
	}
	public BigInteger getQ15CzTotalWithoutChild() {
		return q15CzTotalWithoutChild;
	}
	public void setQ15CzTotalWithoutChild(BigInteger q15CzTotalWithoutChild) {
		this.q15CzTotalWithoutChild = q15CzTotalWithoutChild;
	}
	public BigInteger getQ15CzTotalWithChildandAdult() {
		return q15CzTotalWithChildandAdult;
	}
	public void setQ15CzTotalWithChildandAdult(
			BigInteger q15CzTotalWithChildandAdult) {
		this.q15CzTotalWithChildandAdult = q15CzTotalWithChildandAdult;
	}
	public BigInteger getQ15CzTotalWithChildOnly() {
		return q15CzTotalWithChildOnly;
	}
	public void setQ15CzTotalWithChildOnly(BigInteger q15CzTotalWithChildOnly) {
		this.q15CzTotalWithChildOnly = q15CzTotalWithChildOnly;
	}
	public BigInteger getQ15CzTotalUnknownHousehold() {
		return q15CzTotalUnknownHousehold;
	}
	public void setQ15CzTotalUnknownHousehold(BigInteger q15CzTotalUnknownHousehold) {
		this.q15CzTotalUnknownHousehold = q15CzTotalUnknownHousehold;
	}
	
	public BigInteger getQ15DTotalSummed() {
		return q15DTotalSummed;
	}
	public void setQ15DTotalSummed(BigInteger q15DTotalSummed) {
		this.q15DTotalSummed = q15DTotalSummed;
	}
	public BigInteger getQ15DTotalWithoutChild() {
		return q15DTotalWithoutChild;
	}
	public void setQ15DTotalWithoutChild(BigInteger q15dTotalWithoutChild) {
		q15DTotalWithoutChild = q15dTotalWithoutChild;
	}
	public BigInteger getQ15DTotalWithChildandAdult() {
		return q15DTotalWithChildandAdult;
	}
	public void setQ15DTotalWithChildandAdult(BigInteger q15dTotalWithChildandAdult) {
		q15DTotalWithChildandAdult = q15dTotalWithChildandAdult;
	}
	public BigInteger getQ15DTotalWithChildOnly() {
		return q15DTotalWithChildOnly;
	}
	public void setQ15DTotalWithChildOnly(BigInteger q15dTotalWithChildOnly) {
		q15DTotalWithChildOnly = q15dTotalWithChildOnly;
	}
	public BigInteger getQ15DTotalUnknownHousehold() {
		return q15DTotalUnknownHousehold;
	}
	public void setQ15DTotalUnknownHousehold(BigInteger q15dTotalUnknownHousehold) {
		q15DTotalUnknownHousehold = q15dTotalUnknownHousehold;
	}
	public BigInteger getQ15HomeLessSituationsTotal() {
		return q15HomeLessSituationsTotal;
	}
	public void setQ15HomeLessSituationsTotal(BigInteger q15HomeLessSituationsTotal) {
		this.q15HomeLessSituationsTotal = q15HomeLessSituationsTotal;
	}
	public BigInteger getQ15HomeLessSituationsWithoutChildren() {
		return q15HomeLessSituationsWithoutChildren;
	}
	public void setQ15HomeLessSituationsWithoutChildren(
			BigInteger q15HomeLessSituationsWithoutChildren) {
		this.q15HomeLessSituationsWithoutChildren = q15HomeLessSituationsWithoutChildren;
	}
	public BigInteger getQ15HomeLessSituationWithChildAndAdult() {
		return q15HomeLessSituationWithChildAndAdult;
	}
	public void setQ15HomeLessSituationWithChildAndAdult(
			BigInteger q15HomeLessSituationWithChildAndAdult) {
		this.q15HomeLessSituationWithChildAndAdult = q15HomeLessSituationWithChildAndAdult;
	}
	public BigInteger getQ15HomeLessSituationsWithChildOnly() {
		return q15HomeLessSituationsWithChildOnly;
	}
	public void setQ15HomeLessSituationsWithChildOnly(
			BigInteger q15HomeLessSituationsWithChildOnly) {
		this.q15HomeLessSituationsWithChildOnly = q15HomeLessSituationsWithChildOnly;
	}
	public BigInteger getQ15HomeLessSituationsUnknownHouseHold() {
		return q15HomeLessSituationsUnknownHouseHold;
	}
	public void setQ15HomeLessSituationsUnknownHouseHold(
			BigInteger q15HomeLessSituationsUnknownHouseHold) {
		this.q15HomeLessSituationsUnknownHouseHold = q15HomeLessSituationsUnknownHouseHold;
	}
	public BigInteger getQ15EmergencyShelterTotal() {
		return q15EmergencyShelterTotal;
	}
	public void setQ15EmergencyShelterTotal(BigInteger q15EmergencyShelterTotal) {
		this.q15EmergencyShelterTotal = q15EmergencyShelterTotal;
	}
	public BigInteger getQ15EmergencyShelterWithoutChildren() {
		return q15EmergencyShelterWithoutChildren;
	}
	public void setQ15EmergencyShelterWithoutChildren(
			BigInteger q15EmergencyShelterWithoutChildren) {
		this.q15EmergencyShelterWithoutChildren = q15EmergencyShelterWithoutChildren;
	}
	public BigInteger getQ15EmergencyShelterWithChildAndAdult() {
		return q15EmergencyShelterWithChildAndAdult;
	}
	public void setQ15EmergencyShelterWithChildAndAdult(
			BigInteger q15EmergencyShelterWithChildAndAdult) {
		this.q15EmergencyShelterWithChildAndAdult = q15EmergencyShelterWithChildAndAdult;
	}
	public BigInteger getQ15EmergencyShelterWithChildOnly() {
		return q15EmergencyShelterWithChildOnly;
	}
	public void setQ15EmergencyShelterWithChildOnly(
			BigInteger q15EmergencyShelterWithChildOnly) {
		this.q15EmergencyShelterWithChildOnly = q15EmergencyShelterWithChildOnly;
	}
	public BigInteger getQ15EmergencyShelterUnknownHouseHold() {
		return q15EmergencyShelterUnknownHouseHold;
	}
	public void setQ15EmergencyShelterUnknownHouseHold(
			BigInteger q15EmergencyShelterUnknownHouseHold) {
		this.q15EmergencyShelterUnknownHouseHold = q15EmergencyShelterUnknownHouseHold;
	}
	public BigInteger getQ15TransitionalHousingForhomelessTotal() {
		return q15TransitionalHousingForhomelessTotal;
	}
	public void setQ15TransitionalHousingForhomelessTotal(
			BigInteger q15TransitionalHousingForhomelessTotal) {
		this.q15TransitionalHousingForhomelessTotal = q15TransitionalHousingForhomelessTotal;
	}
	public BigInteger getQ15TransitionalHousingForhomelessWithoutChildren() {
		return q15TransitionalHousingForhomelessWithoutChildren;
	}
	public void setQ15TransitionalHousingForhomelessWithoutChildren(
			BigInteger q15TransitionalHousingForhomelessWithoutChildren) {
		this.q15TransitionalHousingForhomelessWithoutChildren = q15TransitionalHousingForhomelessWithoutChildren;
	}
	public BigInteger getQ15TransitionalHousingForhomelessWithChildAndAdult() {
		return q15TransitionalHousingForhomelessWithChildAndAdult;
	}
	public void setQ15TransitionalHousingForhomelessWithChildAndAdult(
			BigInteger q15TransitionalHousingForhomelessWithChildAndAdult) {
		this.q15TransitionalHousingForhomelessWithChildAndAdult = q15TransitionalHousingForhomelessWithChildAndAdult;
	}
	public BigInteger getQ15TransitionalHousingForhomelessWithChildOnly() {
		return q15TransitionalHousingForhomelessWithChildOnly;
	}
	public void setQ15TransitionalHousingForhomelessWithChildOnly(
			BigInteger q15TransitionalHousingForhomelessWithChildOnly) {
		this.q15TransitionalHousingForhomelessWithChildOnly = q15TransitionalHousingForhomelessWithChildOnly;
	}
	public BigInteger getQ15TransitionalHousingForhomelessUnknownHouseHold() {
		return q15TransitionalHousingForhomelessUnknownHouseHold;
	}
	public void setQ15TransitionalHousingForhomelessUnknownHouseHold(
			BigInteger q15TransitionalHousingForhomelessUnknownHouseHold) {
		this.q15TransitionalHousingForhomelessUnknownHouseHold = q15TransitionalHousingForhomelessUnknownHouseHold;
	}
	public BigInteger getQ15PlaceNotMeantTotal() {
		return q15PlaceNotMeantTotal;
	}
	public void setQ15PlaceNotMeantTotal(BigInteger q15PlaceNotMeantTotal) {
		this.q15PlaceNotMeantTotal = q15PlaceNotMeantTotal;
	}
	public BigInteger getQ15PlaceNotMeantWithoutChildren() {
		return q15PlaceNotMeantWithoutChildren;
	}
	public void setQ15PlaceNotMeantWithoutChildren(
			BigInteger q15PlaceNotMeantWithoutChildren) {
		this.q15PlaceNotMeantWithoutChildren = q15PlaceNotMeantWithoutChildren;
	}
	public BigInteger getQ15PlaceNotMeantWithChildAndAdult() {
		return q15PlaceNotMeantWithChildAndAdult;
	}
	public void setQ15PlaceNotMeantWithChildAndAdult(
			BigInteger q15PlaceNotMeantWithChildAndAdult) {
		this.q15PlaceNotMeantWithChildAndAdult = q15PlaceNotMeantWithChildAndAdult;
	}
	public BigInteger getQ15PlaceNotMeantWithChildOnly() {
		return q15PlaceNotMeantWithChildOnly;
	}
	public void setQ15PlaceNotMeantWithChildOnly(
			BigInteger q15PlaceNotMeantWithChildOnly) {
		this.q15PlaceNotMeantWithChildOnly = q15PlaceNotMeantWithChildOnly;
	}
	public BigInteger getQ15PlaceNotMeantsUnknownHouseHold() {
		return q15PlaceNotMeantsUnknownHouseHold;
	}
	public void setQ15PlaceNotMeantsUnknownHouseHold(
			BigInteger q15PlaceNotMeantsUnknownHouseHold) {
		this.q15PlaceNotMeantsUnknownHouseHold = q15PlaceNotMeantsUnknownHouseHold;
	}
	public BigInteger getQ15SafeHeavenTotal() {
		return q15SafeHeavenTotal;
	}
	public void setQ15SafeHeavenTotal(BigInteger q15SafeHeavenTotal) {
		this.q15SafeHeavenTotal = q15SafeHeavenTotal;
	}
	public BigInteger getQ15SafeHeavenWithoutChildren() {
		return q15SafeHeavenWithoutChildren;
	}
	public void setQ15SafeHeavenWithoutChildren(
			BigInteger q15SafeHeavenWithoutChildren) {
		this.q15SafeHeavenWithoutChildren = q15SafeHeavenWithoutChildren;
	}
	public BigInteger getQ15SafeHeavenWithChildAndAdult() {
		return q15SafeHeavenWithChildAndAdult;
	}
	public void setQ15SafeHeavenWithChildAndAdult(
			BigInteger q15SafeHeavenWithChildAndAdult) {
		this.q15SafeHeavenWithChildAndAdult = q15SafeHeavenWithChildAndAdult;
	}
	public BigInteger getQ15SafeHeavenWithChildOnly() {
		return q15SafeHeavenWithChildOnly;
	}
	public void setQ15SafeHeavenWithChildOnly(BigInteger q15SafeHeavenWithChildOnly) {
		this.q15SafeHeavenWithChildOnly = q15SafeHeavenWithChildOnly;
	}
	public BigInteger getQ15SafeHeavenUnknownHouseHold() {
		return q15SafeHeavenUnknownHouseHold;
	}
	public void setQ15SafeHeavenUnknownHouseHold(
			BigInteger q15SafeHeavenUnknownHouseHold) {
		this.q15SafeHeavenUnknownHouseHold = q15SafeHeavenUnknownHouseHold;
	}
	public BigInteger getQ15AzTotalSummed() {
		return q15AzTotalSummed;
	}
	public void setQ15AzTotalSummed(BigInteger q15AzTotalSummed) {
		this.q15AzTotalSummed = q15AzTotalSummed;
	}
	public BigInteger getQ15AzTotalWithoutChildren() {
		return q15AzTotalWithoutChildren;
	}
	public void setQ15AzTotalWithoutChildren(BigInteger q15AzTotalWithoutChildren) {
		this.q15AzTotalWithoutChildren = q15AzTotalWithoutChildren;
	}
	public BigInteger getQ15AzTotalWithChildAndAdult() {
		return q15AzTotalWithChildAndAdult;
	}
	public void setQ15AzTotalWithChildAndAdult(
			BigInteger q15AzTotalWithChildAndAdult) {
		this.q15AzTotalWithChildAndAdult = q15AzTotalWithChildAndAdult;
	}
	public BigInteger getQ15AzTotalWithChildOnly() {
		return q15AzTotalWithChildOnly;
	}
	public void setQ15AzTotalWithChildOnly(BigInteger q15AzTotalWithChildOnly) {
		this.q15AzTotalWithChildOnly = q15AzTotalWithChildOnly;
	}
	public BigInteger getQ15AzTotalUnknownHouseHold() {
		return q15AzTotalUnknownHouseHold;
	}
	public void setQ15AzTotalUnknownHouseHold(BigInteger q15AzTotalUnknownHouseHold) {
		this.q15AzTotalUnknownHouseHold = q15AzTotalUnknownHouseHold;
	}
	public BigInteger getQ14bYesTotal() {
		return q14bYesTotal;
	}
	public void setQ14bYesTotal(BigInteger q14bYesTotal) {
		this.q14bYesTotal = q14bYesTotal;
	}
	public BigInteger getQ14bYesWithoutChildren() {
		return q14bYesWithoutChildren;
	}
	public void setQ14bYesWithoutChildren(BigInteger q14bYesWithoutChildren) {
		this.q14bYesWithoutChildren = q14bYesWithoutChildren;
	}
	public BigInteger getQ14bYesWithChildAndAdults() {
		return q14bYesWithChildAndAdults;
	}
	public void setQ14bYesWithChildAndAdults(BigInteger q14bYesWithChildAndAdults) {
		this.q14bYesWithChildAndAdults = q14bYesWithChildAndAdults;
	}
	public BigInteger getQ14bYesWithOnlyChildren() {
		return q14bYesWithOnlyChildren;
	}
	public void setQ14bYesWithOnlyChildren(BigInteger q14bYesWithOnlyChildren) {
		this.q14bYesWithOnlyChildren = q14bYesWithOnlyChildren;
	}
	public BigInteger getQ14bYesUnknownHouseholdType() {
		return q14bYesUnknownHouseholdType;
	}
	public void setQ14bYesUnknownHouseholdType(
			BigInteger q14bYesUnknownHouseholdType) {
		this.q14bYesUnknownHouseholdType = q14bYesUnknownHouseholdType;
	}
	public BigInteger getQ14bNoTotal() {
		return q14bNoTotal;
	}
	public void setQ14bNoTotal(BigInteger q14bNoTotal) {
		this.q14bNoTotal = q14bNoTotal;
	}
	public BigInteger getQ14bNoWithoutChildren() {
		return q14bNoWithoutChildren;
	}
	public void setQ14bNoWithoutChildren(BigInteger q14bNoWithoutChildren) {
		this.q14bNoWithoutChildren = q14bNoWithoutChildren;
	}
	public BigInteger getQ14bNoWithChildAndAdults() {
		return q14bNoWithChildAndAdults;
	}
	public void setQ14bNoWithChildAndAdults(BigInteger q14bNoWithChildAndAdults) {
		this.q14bNoWithChildAndAdults = q14bNoWithChildAndAdults;
	}
	public BigInteger getQ14bNoWithOnlyChildren() {
		return q14bNoWithOnlyChildren;
	}
	public void setQ14bNoWithOnlyChildren(BigInteger q14bNoWithOnlyChildren) {
		this.q14bNoWithOnlyChildren = q14bNoWithOnlyChildren;
	}
	public BigInteger getQ14bNoUnknownHouseholdType() {
		return q14bNoUnknownHouseholdType;
	}
	public void setQ14bNoUnknownHouseholdType(BigInteger q14bNoUnknownHouseholdType) {
		this.q14bNoUnknownHouseholdType = q14bNoUnknownHouseholdType;
	}
	public BigInteger getQ14bDKRTotal() {
		return q14bDKRTotal;
	}
	public void setQ14bDKRTotal(BigInteger q14bDKRTotal) {
		this.q14bDKRTotal = q14bDKRTotal;
	}
	public BigInteger getQ14bDKRWithoutChildren() {
		return q14bDKRWithoutChildren;
	}
	public void setQ14bDKRWithoutChildren(BigInteger q14bDKRWithoutChildren) {
		this.q14bDKRWithoutChildren = q14bDKRWithoutChildren;
	}
	public BigInteger getQ14bDKRWithChildAndAdults() {
		return q14bDKRWithChildAndAdults;
	}
	public void setQ14bDKRWithChildAndAdults(BigInteger q14bDKRWithChildAndAdults) {
		this.q14bDKRWithChildAndAdults = q14bDKRWithChildAndAdults;
	}
	public BigInteger getQ14bDKRWithOnlyChildren() {
		return q14bDKRWithOnlyChildren;
	}
	public void setQ14bDKRWithOnlyChildren(BigInteger q14bDKRWithOnlyChildren) {
		this.q14bDKRWithOnlyChildren = q14bDKRWithOnlyChildren;
	}
	public BigInteger getQ14bDKRUnknownHouseholdType() {
		return q14bDKRUnknownHouseholdType;
	}
	public void setQ14bDKRUnknownHouseholdType(
			BigInteger q14bDKRUnknownHouseholdType) {
		this.q14bDKRUnknownHouseholdType = q14bDKRUnknownHouseholdType;
	}
	public BigInteger getQ14bInformationMissingTotal() {
		return q14bInformationMissingTotal;
	}
	public void setQ14bInformationMissingTotal(
			BigInteger q14bInformationMissingTotal) {
		this.q14bInformationMissingTotal = q14bInformationMissingTotal;
	}
	public BigInteger getQ14bInformationMissingWithoutChildren() {
		return q14bInformationMissingWithoutChildren;
	}
	public void setQ14bInformationMissingWithoutChildren(
			BigInteger q14bInformationMissingWithoutChildren) {
		this.q14bInformationMissingWithoutChildren = q14bInformationMissingWithoutChildren;
	}
	public BigInteger getQ14bInformationMissingWithChildAndAdults() {
		return q14bInformationMissingWithChildAndAdults;
	}
	public void setQ14bInformationMissingWithChildAndAdults(
			BigInteger q14bInformationMissingWithChildAndAdults) {
		this.q14bInformationMissingWithChildAndAdults = q14bInformationMissingWithChildAndAdults;
	}
	public BigInteger getQ14bInformationMissingWithOnlyChildren() {
		return q14bInformationMissingWithOnlyChildren;
	}
	public void setQ14bInformationMissingWithOnlyChildren(
			BigInteger q14bInformationMissingWithOnlyChildren) {
		this.q14bInformationMissingWithOnlyChildren = q14bInformationMissingWithOnlyChildren;
	}
	public BigInteger getQ14bInformationMissingUnknownHouseholdType() {
		return q14bInformationMissingUnknownHouseholdType;
	}
	public void setQ14bInformationMissingUnknownHouseholdType(
			BigInteger q14bInformationMissingUnknownHouseholdType) {
		this.q14bInformationMissingUnknownHouseholdType = q14bInformationMissingUnknownHouseholdType;
	}
	public BigInteger getQ14bTotalSummed() {
		return q14bTotalSummed;
	}
	public void setQ14bTotalSummed(BigInteger q14bTotalSummed) {
		this.q14bTotalSummed = q14bTotalSummed;
	}
	public BigInteger getQ14bTotalWithoutChildren() {
		return q14bTotalWithoutChildren;
	}
	public void setQ14bTotalWithoutChildren(BigInteger q14bTotalWithoutChildren) {
		this.q14bTotalWithoutChildren = q14bTotalWithoutChildren;
	}
	public BigInteger getQ14bTotalWithChildAndAdults() {
		return q14bTotalWithChildAndAdults;
	}
	public void setQ14bTotalWithChildAndAdults(
			BigInteger q14bTotalWithChildAndAdults) {
		this.q14bTotalWithChildAndAdults = q14bTotalWithChildAndAdults;
	}
	public BigInteger getQ14bTotalWithOnlychildren() {
		return q14bTotalWithOnlychildren;
	}
	public void setQ14bTotalWithOnlychildren(BigInteger q14bTotalWithOnlychildren) {
		this.q14bTotalWithOnlychildren = q14bTotalWithOnlychildren;
	}
	public BigInteger getQ14bTotalUnknowHousehold() {
		return q14bTotalUnknowHousehold;
	}
	public void setQ14bTotalUnknowHousehold(BigInteger q14bTotalUnknowHousehold) {
		this.q14bTotalUnknowHousehold = q14bTotalUnknowHousehold;
	}
	public BigInteger getQ14aYesTotal() {
		return q14aYesTotal;
	}
	public void setQ14aYesTotal(BigInteger q14aYesTotal) {
		this.q14aYesTotal = q14aYesTotal;
	}
	public BigInteger getQ14aYesWithoutChildren() {
		return q14aYesWithoutChildren;
	}
	public void setQ14aYesWithoutChildren(BigInteger q14aYesWithoutChildren) {
		this.q14aYesWithoutChildren = q14aYesWithoutChildren;
	}
	public BigInteger getQ14aYesWithChildAndAdults() {
		return q14aYesWithChildAndAdults;
	}
	public void setQ14aYesWithChildAndAdults(BigInteger q14aYesWithChildAndAdults) {
		this.q14aYesWithChildAndAdults = q14aYesWithChildAndAdults;
	}
	public BigInteger getQ14aYesWithOnlyChildren() {
		return q14aYesWithOnlyChildren;
	}
	public void setQ14aYesWithOnlyChildren(BigInteger q14aYesWithOnlyChildren) {
		this.q14aYesWithOnlyChildren = q14aYesWithOnlyChildren;
	}
	public BigInteger getQ14aYesUnknownHouseholdType() {
		return q14aYesUnknownHouseholdType;
	}
	public void setQ14aYesUnknownHouseholdType(
			BigInteger q14aYesUnknownHouseholdType) {
		this.q14aYesUnknownHouseholdType = q14aYesUnknownHouseholdType;
	}
	public BigInteger getQ14aNoTotal() {
		return q14aNoTotal;
	}
	public void setQ14aNoTotal(BigInteger q14aNoTotal) {
		this.q14aNoTotal = q14aNoTotal;
	}
	public BigInteger getQ14aNoWithoutChildren() {
		return q14aNoWithoutChildren;
	}
	public void setQ14aNoWithoutChildren(BigInteger q14aNoWithoutChildren) {
		this.q14aNoWithoutChildren = q14aNoWithoutChildren;
	}
	public BigInteger getQ14aNoWithChildAndAdults() {
		return q14aNoWithChildAndAdults;
	}
	public void setQ14aNoWithChildAndAdults(BigInteger q14aNoWithChildAndAdults) {
		this.q14aNoWithChildAndAdults = q14aNoWithChildAndAdults;
	}
	public BigInteger getQ14aNoWithOnlyChildren() {
		return q14aNoWithOnlyChildren;
	}
	public void setQ14aNoWithOnlyChildren(BigInteger q14aNoWithOnlyChildren) {
		this.q14aNoWithOnlyChildren = q14aNoWithOnlyChildren;
	}
	public BigInteger getQ14aNoUnknownHouseholdType() {
		return q14aNoUnknownHouseholdType;
	}
	public void setQ14aNoUnknownHouseholdType(BigInteger q14aNoUnknownHouseholdType) {
		this.q14aNoUnknownHouseholdType = q14aNoUnknownHouseholdType;
	}
	public BigInteger getQ14aDKRTotal() {
		return q14aDKRTotal;
	}
	public void setQ14aDKRTotal(BigInteger q14aDKRTotal) {
		this.q14aDKRTotal = q14aDKRTotal;
	}
	public BigInteger getQ14aDKRWithoutChildren() {
		return q14aDKRWithoutChildren;
	}
	public void setQ14aDKRWithoutChildren(BigInteger q14aDKRWithoutChildren) {
		this.q14aDKRWithoutChildren = q14aDKRWithoutChildren;
	}
	public BigInteger getQ14aDKRWithChildAndAdults() {
		return q14aDKRWithChildAndAdults;
	}
	public void setQ14aDKRWithChildAndAdults(BigInteger q14aDKRWithChildAndAdults) {
		this.q14aDKRWithChildAndAdults = q14aDKRWithChildAndAdults;
	}
	public BigInteger getQ14aDKRWithOnlyChildren() {
		return q14aDKRWithOnlyChildren;
	}
	public void setQ14aDKRWithOnlyChildren(BigInteger q14aDKRWithOnlyChildren) {
		this.q14aDKRWithOnlyChildren = q14aDKRWithOnlyChildren;
	}
	public BigInteger getQ14aDKRUnknownHouseholdType() {
		return q14aDKRUnknownHouseholdType;
	}
	public void setQ14aDKRUnknownHouseholdType(
			BigInteger q14aDKRUnknownHouseholdType) {
		this.q14aDKRUnknownHouseholdType = q14aDKRUnknownHouseholdType;
	}
	public BigInteger getQ14aInformationMissingTotal() {
		return q14aInformationMissingTotal;
	}
	public void setQ14aInformationMissingTotal(
			BigInteger q14aInformationMissingTotal) {
		this.q14aInformationMissingTotal = q14aInformationMissingTotal;
	}
	public BigInteger getQ14aInformationMissingWithoutChildren() {
		return q14aInformationMissingWithoutChildren;
	}
	public void setQ14aInformationMissingWithoutChildren(
			BigInteger q14aInformationMissingWithoutChildren) {
		this.q14aInformationMissingWithoutChildren = q14aInformationMissingWithoutChildren;
	}
	public BigInteger getQ14aInformationMissingWithChildAndAdults() {
		return q14aInformationMissingWithChildAndAdults;
	}
	public void setQ14aInformationMissingWithChildAndAdults(
			BigInteger q14aInformationMissingWithChildAndAdults) {
		this.q14aInformationMissingWithChildAndAdults = q14aInformationMissingWithChildAndAdults;
	}
	public BigInteger getQ14aInformationMissingWithOnlyChildren() {
		return q14aInformationMissingWithOnlyChildren;
	}
	public void setQ14aInformationMissingWithOnlyChildren(
			BigInteger q14aInformationMissingWithOnlyChildren) {
		this.q14aInformationMissingWithOnlyChildren = q14aInformationMissingWithOnlyChildren;
	}
	public BigInteger getQ14aInformationMissingUnknownHouseholdType() {
		return q14aInformationMissingUnknownHouseholdType;
	}
	public void setQ14aInformationMissingUnknownHouseholdType(
			BigInteger q14aInformationMissingUnknownHouseholdType) {
		this.q14aInformationMissingUnknownHouseholdType = q14aInformationMissingUnknownHouseholdType;
	}
	public BigInteger getQ14aTotalSummed() {
		return q14aTotalSummed;
	}
	public void setQ14aTotalSummed(BigInteger q14aTotalSummed) {
		this.q14aTotalSummed = q14aTotalSummed;
	}
	public BigInteger getQ14aTotalWithoutChildren() {
		return q14aTotalWithoutChildren;
	}
	public void setQ14aTotalWithoutChildren(BigInteger q14aTotalWithoutChildren) {
		this.q14aTotalWithoutChildren = q14aTotalWithoutChildren;
	}
	public BigInteger getQ14aTotalWithChildAndAdults() {
		return q14aTotalWithChildAndAdults;
	}
	public void setQ14aTotalWithChildAndAdults(
			BigInteger q14aTotalWithChildAndAdults) {
		this.q14aTotalWithChildAndAdults = q14aTotalWithChildAndAdults;
	}
	public BigInteger getQ14aTotalWithOnlychildren() {
		return q14aTotalWithOnlychildren;
	}
	public void setQ14aTotalWithOnlychildren(BigInteger q14aTotalWithOnlychildren) {
		this.q14aTotalWithOnlychildren = q14aTotalWithOnlychildren;
	}
	public BigInteger getQ14aTotalUnknowHousehold() {
		return q14aTotalUnknowHousehold;
	}
	public void setQ14aTotalUnknowHousehold(BigInteger q14aTotalUnknowHousehold) {
		this.q14aTotalUnknowHousehold = q14aTotalUnknowHousehold;
	}
	public BigInteger getQ13b1MentalIllnessTotal() {
		return q13b1MentalIllnessTotal;
	}
	public void setQ13b1MentalIllnessTotal(BigInteger q13b1MentalIllnessTotal) {
		this.q13b1MentalIllnessTotal = q13b1MentalIllnessTotal;
	}
	public BigInteger getQ13b1MentalIllnessWithoutChildren() {
		return q13b1MentalIllnessWithoutChildren;
	}
	public void setQ13b1MentalIllnessWithoutChildren(
			BigInteger q13b1MentalIllnessWithoutChildren) {
		this.q13b1MentalIllnessWithoutChildren = q13b1MentalIllnessWithoutChildren;
	}
	public BigInteger getQ13b1MentalIllnessWithChildAndAdults() {
		return q13b1MentalIllnessWithChildAndAdults;
	}
	public void setQ13b1MentalIllnessWithChildAndAdults(
			BigInteger q13b1MentalIllnessWithChildAndAdults) {
		this.q13b1MentalIllnessWithChildAndAdults = q13b1MentalIllnessWithChildAndAdults;
	}
	public BigInteger getQ13b1MentalIllnessWithOnlychildren() {
		return q13b1MentalIllnessWithOnlychildren;
	}
	public void setQ13b1MentalIllnessWithOnlychildren(
			BigInteger q13b1MentalIllnessWithOnlychildren) {
		this.q13b1MentalIllnessWithOnlychildren = q13b1MentalIllnessWithOnlychildren;
	}
	public BigInteger getQ13b1MentalIllnessUnknowHousehold() {
		return q13b1MentalIllnessUnknowHousehold;
	}
	public void setQ13b1MentalIllnessUnknowHousehold(
			BigInteger q13b1MentalIllnessUnknowHousehold) {
		this.q13b1MentalIllnessUnknowHousehold = q13b1MentalIllnessUnknowHousehold;
	}
	public BigInteger getQ13b1AlcoholAbuseTotal() {
		return q13b1AlcoholAbuseTotal;
	}
	public void setQ13b1AlcoholAbuseTotal(BigInteger q13b1AlcoholAbuseTotal) {
		this.q13b1AlcoholAbuseTotal = q13b1AlcoholAbuseTotal;
	}
	public BigInteger getQ13b1AlcoholAbuseWithoutChildren() {
		return q13b1AlcoholAbuseWithoutChildren;
	}
	public void setQ13b1AlcoholAbuseWithoutChildren(
			BigInteger q13b1AlcoholAbuseWithoutChildren) {
		this.q13b1AlcoholAbuseWithoutChildren = q13b1AlcoholAbuseWithoutChildren;
	}
	public BigInteger getQ13b1AlcoholAbuseWithChildAndAdults() {
		return q13b1AlcoholAbuseWithChildAndAdults;
	}
	public void setQ13b1AlcoholAbuseWithChildAndAdults(
			BigInteger q13b1AlcoholAbuseWithChildAndAdults) {
		this.q13b1AlcoholAbuseWithChildAndAdults = q13b1AlcoholAbuseWithChildAndAdults;
	}
	public BigInteger getQ13b1AlcoholAbuseWithOnlychildren() {
		return q13b1AlcoholAbuseWithOnlychildren;
	}
	public void setQ13b1AlcoholAbuseWithOnlychildren(
			BigInteger q13b1AlcoholAbuseWithOnlychildren) {
		this.q13b1AlcoholAbuseWithOnlychildren = q13b1AlcoholAbuseWithOnlychildren;
	}
	public BigInteger getQ13b1AlcoholAbuseUnknowHousehold() {
		return q13b1AlcoholAbuseUnknowHousehold;
	}
	public void setQ13b1AlcoholAbuseUnknowHousehold(
			BigInteger q13b1AlcoholAbuseUnknowHousehold) {
		this.q13b1AlcoholAbuseUnknowHousehold = q13b1AlcoholAbuseUnknowHousehold;
	}
	public BigInteger getQ13b1DrugAbuseTotal() {
		return q13b1DrugAbuseTotal;
	}
	public void setQ13b1DrugAbuseTotal(BigInteger q13b1DrugAbuseTotal) {
		this.q13b1DrugAbuseTotal = q13b1DrugAbuseTotal;
	}
	public BigInteger getQ13b1DrugAbuseWithoutChildren() {
		return q13b1DrugAbuseWithoutChildren;
	}
	public void setQ13b1DrugAbuseWithoutChildren(
			BigInteger q13b1DrugAbuseWithoutChildren) {
		this.q13b1DrugAbuseWithoutChildren = q13b1DrugAbuseWithoutChildren;
	}
	public BigInteger getQ13b1DrugAbuseWithChildAndAdults() {
		return q13b1DrugAbuseWithChildAndAdults;
	}
	public void setQ13b1DrugAbuseWithChildAndAdults(
			BigInteger q13b1DrugAbuseWithChildAndAdults) {
		this.q13b1DrugAbuseWithChildAndAdults = q13b1DrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13b1DrugAbuseWithOnlychildren() {
		return q13b1DrugAbuseWithOnlychildren;
	}
	public void setQ13b1DrugAbuseWithOnlychildren(
			BigInteger q13b1DrugAbuseWithOnlychildren) {
		this.q13b1DrugAbuseWithOnlychildren = q13b1DrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13b1DrugAbuseUnknowHousehold() {
		return q13b1DrugAbuseUnknowHousehold;
	}
	public void setQ13b1DrugAbuseUnknowHousehold(
			BigInteger q13b1DrugAbuseUnknowHousehold) {
		this.q13b1DrugAbuseUnknowHousehold = q13b1DrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13b1BothAlcoholAndDrugAbuseTotal() {
		return q13b1BothAlcoholAndDrugAbuseTotal;
	}
	public void setQ13b1BothAlcoholAndDrugAbuseTotal(
			BigInteger q13b1BothAlcoholAndDrugAbuseTotal) {
		this.q13b1BothAlcoholAndDrugAbuseTotal = q13b1BothAlcoholAndDrugAbuseTotal;
	}
	public BigInteger getQ13b1BothAlcoholAndDrugAbuseWithoutChildren() {
		return q13b1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public void setQ13b1BothAlcoholAndDrugAbuseWithoutChildren(
			BigInteger q13b1BothAlcoholAndDrugAbuseWithoutChildren) {
		this.q13b1BothAlcoholAndDrugAbuseWithoutChildren = q13b1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public BigInteger getQ13b1BothAlcoholAndDrugAbuseWithChildAndAdults() {
		return q13b1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public void setQ13b1BothAlcoholAndDrugAbuseWithChildAndAdults(
			BigInteger q13b1BothAlcoholAndDrugAbuseWithChildAndAdults) {
		this.q13b1BothAlcoholAndDrugAbuseWithChildAndAdults = q13b1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13b1BothAlcoholAndDrugAbuseWithOnlychildren() {
		return q13b1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public void setQ13b1BothAlcoholAndDrugAbuseWithOnlychildren(
			BigInteger q13b1BothAlcoholAndDrugAbuseWithOnlychildren) {
		this.q13b1BothAlcoholAndDrugAbuseWithOnlychildren = q13b1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13b1BothAlcoholAndDrugAbuseUnknowHousehold() {
		return q13b1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public void setQ13b1BothAlcoholAndDrugAbuseUnknowHousehold(
			BigInteger q13b1BothAlcoholAndDrugAbuseUnknowHousehold) {
		this.q13b1BothAlcoholAndDrugAbuseUnknowHousehold = q13b1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13b1ChronicHealthConditionTotal() {
		return q13b1ChronicHealthConditionTotal;
	}
	public void setQ13b1ChronicHealthConditionTotal(
			BigInteger q13b1ChronicHealthConditionTotal) {
		this.q13b1ChronicHealthConditionTotal = q13b1ChronicHealthConditionTotal;
	}
	public BigInteger getQ13b1ChronicHealthConditionWithoutChildren() {
		return q13b1ChronicHealthConditionWithoutChildren;
	}
	public void setQ13b1ChronicHealthConditionWithoutChildren(
			BigInteger q13b1ChronicHealthConditionWithoutChildren) {
		this.q13b1ChronicHealthConditionWithoutChildren = q13b1ChronicHealthConditionWithoutChildren;
	}
	public BigInteger getQ13b1ChronicHealthConditionWithChildAndAdults() {
		return q13b1ChronicHealthConditionWithChildAndAdults;
	}
	public void setQ13b1ChronicHealthConditionWithChildAndAdults(
			BigInteger q13b1ChronicHealthConditionWithChildAndAdults) {
		this.q13b1ChronicHealthConditionWithChildAndAdults = q13b1ChronicHealthConditionWithChildAndAdults;
	}
	public BigInteger getQ13b1ChronicHealthConditionWithOnlychildren() {
		return q13b1ChronicHealthConditionWithOnlychildren;
	}
	public void setQ13b1ChronicHealthConditionWithOnlychildren(
			BigInteger q13b1ChronicHealthConditionWithOnlychildren) {
		this.q13b1ChronicHealthConditionWithOnlychildren = q13b1ChronicHealthConditionWithOnlychildren;
	}
	public BigInteger getQ13b1ChronicHealthConditionUnknowHousehold() {
		return q13b1ChronicHealthConditionUnknowHousehold;
	}
	public void setQ13b1ChronicHealthConditionUnknowHousehold(
			BigInteger q13b1ChronicHealthConditionUnknowHousehold) {
		this.q13b1ChronicHealthConditionUnknowHousehold = q13b1ChronicHealthConditionUnknowHousehold;
	}
	public BigInteger getQ13b1HIVRelatedDiseasesTotal() {
		return q13b1HIVRelatedDiseasesTotal;
	}
	public void setQ13b1HIVRelatedDiseasesTotal(
			BigInteger q13b1hivRelatedDiseasesTotal) {
		q13b1HIVRelatedDiseasesTotal = q13b1hivRelatedDiseasesTotal;
	}
	public BigInteger getQ13b1HIVRelatedDiseasesWithoutChildren() {
		return q13b1HIVRelatedDiseasesWithoutChildren;
	}
	public void setQ13b1HIVRelatedDiseasesWithoutChildren(
			BigInteger q13b1hivRelatedDiseasesWithoutChildren) {
		q13b1HIVRelatedDiseasesWithoutChildren = q13b1hivRelatedDiseasesWithoutChildren;
	}
	public BigInteger getQ13b1HIVRelatedDiseasesWithChildAndAdults() {
		return q13b1HIVRelatedDiseasesWithChildAndAdults;
	}
	public void setQ13b1HIVRelatedDiseasesWithChildAndAdults(
			BigInteger q13b1hivRelatedDiseasesWithChildAndAdults) {
		q13b1HIVRelatedDiseasesWithChildAndAdults = q13b1hivRelatedDiseasesWithChildAndAdults;
	}
	public BigInteger getQ13b1HIVRelatedDiseasesWithOnlychildren() {
		return q13b1HIVRelatedDiseasesWithOnlychildren;
	}
	public void setQ13b1HIVRelatedDiseasesWithOnlychildren(
			BigInteger q13b1hivRelatedDiseasesWithOnlychildren) {
		q13b1HIVRelatedDiseasesWithOnlychildren = q13b1hivRelatedDiseasesWithOnlychildren;
	}
	public BigInteger getQ13b1HIVRelatedDiseasesUnknowHousehold() {
		return q13b1HIVRelatedDiseasesUnknowHousehold;
	}
	public void setQ13b1HIVRelatedDiseasesUnknowHousehold(
			BigInteger q13b1hivRelatedDiseasesUnknowHousehold) {
		q13b1HIVRelatedDiseasesUnknowHousehold = q13b1hivRelatedDiseasesUnknowHousehold;
	}
	public BigInteger getQ13b1DevelopmentalDisabilityTotal() {
		return q13b1DevelopmentalDisabilityTotal;
	}
	public void setQ13b1DevelopmentalDisabilityTotal(
			BigInteger q13b1DevelopmentalDisabilityTotal) {
		this.q13b1DevelopmentalDisabilityTotal = q13b1DevelopmentalDisabilityTotal;
	}
	public BigInteger getQ13b1DevelopmentalDisabilityWithoutChildren() {
		return q13b1DevelopmentalDisabilityWithoutChildren;
	}
	public void setQ13b1DevelopmentalDisabilityWithoutChildren(
			BigInteger q13b1DevelopmentalDisabilityWithoutChildren) {
		this.q13b1DevelopmentalDisabilityWithoutChildren = q13b1DevelopmentalDisabilityWithoutChildren;
	}
	public BigInteger getQ13b1DevelopmentalDisabilityWithChildAndAdults() {
		return q13b1DevelopmentalDisabilityWithChildAndAdults;
	}
	public void setQ13b1DevelopmentalDisabilityWithChildAndAdults(
			BigInteger q13b1DevelopmentalDisabilityWithChildAndAdults) {
		this.q13b1DevelopmentalDisabilityWithChildAndAdults = q13b1DevelopmentalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13b1DevelopmentalDisabilityWithOnlychildren() {
		return q13b1DevelopmentalDisabilityWithOnlychildren;
	}
	public void setQ13b1DevelopmentalDisabilityWithOnlychildren(
			BigInteger q13b1DevelopmentalDisabilityWithOnlychildren) {
		this.q13b1DevelopmentalDisabilityWithOnlychildren = q13b1DevelopmentalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13b1DevelopmentalDisabilityUnknowHousehold() {
		return q13b1DevelopmentalDisabilityUnknowHousehold;
	}
	public void setQ13b1DevelopmentalDisabilityUnknowHousehold(
			BigInteger q13b1DevelopmentalDisabilityUnknowHousehold) {
		this.q13b1DevelopmentalDisabilityUnknowHousehold = q13b1DevelopmentalDisabilityUnknowHousehold;
	}
	public BigInteger getQ13b1PhysicalDisabilityTotal() {
		return q13b1PhysicalDisabilityTotal;
	}
	public void setQ13b1PhysicalDisabilityTotal(
			BigInteger q13b1PhysicalDisabilityTotal) {
		this.q13b1PhysicalDisabilityTotal = q13b1PhysicalDisabilityTotal;
	}
	public BigInteger getQ13b1PhysicalDisabilityWithoutChildren() {
		return q13b1PhysicalDisabilityWithoutChildren;
	}
	public void setQ13b1PhysicalDisabilityWithoutChildren(
			BigInteger q13b1PhysicalDisabilityWithoutChildren) {
		this.q13b1PhysicalDisabilityWithoutChildren = q13b1PhysicalDisabilityWithoutChildren;
	}
	public BigInteger getQ13b1PhysicalDisabilityWithChildAndAdults() {
		return q13b1PhysicalDisabilityWithChildAndAdults;
	}
	public void setQ13b1PhysicalDisabilityWithChildAndAdults(
			BigInteger q13b1PhysicalDisabilityWithChildAndAdults) {
		this.q13b1PhysicalDisabilityWithChildAndAdults = q13b1PhysicalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13b1PhysicalDisabilityWithOnlychildren() {
		return q13b1PhysicalDisabilityWithOnlychildren;
	}
	public void setQ13b1PhysicalDisabilityWithOnlychildren(
			BigInteger q13b1PhysicalDisabilityWithOnlychildren) {
		this.q13b1PhysicalDisabilityWithOnlychildren = q13b1PhysicalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13b1PhysicalDisabilityUnknowHousehold() {
		return q13b1PhysicalDisabilityUnknowHousehold;
	}
	public void setQ13b1PhysicalDisabilityUnknowHousehold(
			BigInteger q13b1PhysicalDisabilityUnknowHousehold) {
		this.q13b1PhysicalDisabilityUnknowHousehold = q13b1PhysicalDisabilityUnknowHousehold;
	}
	public BigInteger getQ13b2NoneTotal() {
		return q13b2NoneTotal;
	}
	public void setQ13b2NoneTotal(BigInteger q13b2NoneTotal) {
		this.q13b2NoneTotal = q13b2NoneTotal;
	}
	public BigInteger getQ13b2NoneWithoutChildren() {
		return q13b2NoneWithoutChildren;
	}
	public void setQ13b2NoneWithoutChildren(BigInteger q13b2NoneWithoutChildren) {
		this.q13b2NoneWithoutChildren = q13b2NoneWithoutChildren;
	}
	public BigInteger getQ13b2NoneWithChildAndAdults() {
		return q13b2NoneWithChildAndAdults;
	}
	public void setQ13b2NoneWithChildAndAdults(
			BigInteger q13b2NoneWithChildAndAdults) {
		this.q13b2NoneWithChildAndAdults = q13b2NoneWithChildAndAdults;
	}
	public BigInteger getQ13b2NoneWithOnlychildren() {
		return q13b2NoneWithOnlychildren;
	}
	public void setQ13b2NoneWithOnlychildren(BigInteger q13b2NoneWithOnlychildren) {
		this.q13b2NoneWithOnlychildren = q13b2NoneWithOnlychildren;
	}
	public BigInteger getQ13b2NoneUnknowHousehold() {
		return q13b2NoneUnknowHousehold;
	}
	public void setQ13b2NoneUnknowHousehold(BigInteger q13b2NoneUnknowHousehold) {
		this.q13b2NoneUnknowHousehold = q13b2NoneUnknowHousehold;
	}
	public BigInteger getQ13b2Condition1Total() {
		return q13b2Condition1Total;
	}
	public void setQ13b2Condition1Total(BigInteger q13b2Condition1Total) {
		this.q13b2Condition1Total = q13b2Condition1Total;
	}
	public BigInteger getQ13b2Condition1WithoutChildren() {
		return q13b2Condition1WithoutChildren;
	}
	public void setQ13b2Condition1WithoutChildren(
			BigInteger q13b2Condition1WithoutChildren) {
		this.q13b2Condition1WithoutChildren = q13b2Condition1WithoutChildren;
	}
	public BigInteger getQ13b2Condition1WithChildAndAdults() {
		return q13b2Condition1WithChildAndAdults;
	}
	public void setQ13b2Condition1WithChildAndAdults(
			BigInteger q13b2Condition1WithChildAndAdults) {
		this.q13b2Condition1WithChildAndAdults = q13b2Condition1WithChildAndAdults;
	}
	public BigInteger getQ13b2Condition1WithOnlychildren() {
		return q13b2Condition1WithOnlychildren;
	}
	public void setQ13b2Condition1WithOnlychildren(
			BigInteger q13b2Condition1WithOnlychildren) {
		this.q13b2Condition1WithOnlychildren = q13b2Condition1WithOnlychildren;
	}
	public BigInteger getQ13b2Condition1UnknowHousehold() {
		return q13b2Condition1UnknowHousehold;
	}
	public void setQ13b2Condition1UnknowHousehold(
			BigInteger q13b2Condition1UnknowHousehold) {
		this.q13b2Condition1UnknowHousehold = q13b2Condition1UnknowHousehold;
	}
	public BigInteger getQ13b2Condition2Total() {
		return q13b2Condition2Total;
	}
	public void setQ13b2Condition2Total(BigInteger q13b2Condition2Total) {
		this.q13b2Condition2Total = q13b2Condition2Total;
	}
	public BigInteger getQ13b2Condition2WithoutChildren() {
		return q13b2Condition2WithoutChildren;
	}
	public void setQ13b2Condition2WithoutChildren(
			BigInteger q13b2Condition2WithoutChildren) {
		this.q13b2Condition2WithoutChildren = q13b2Condition2WithoutChildren;
	}
	public BigInteger getQ13b2Condition2WithChildAndAdults() {
		return q13b2Condition2WithChildAndAdults;
	}
	public void setQ13b2Condition2WithChildAndAdults(
			BigInteger q13b2Condition2WithChildAndAdults) {
		this.q13b2Condition2WithChildAndAdults = q13b2Condition2WithChildAndAdults;
	}
	public BigInteger getQ13b2Condition2WithOnlychildren() {
		return q13b2Condition2WithOnlychildren;
	}
	public void setQ13b2Condition2WithOnlychildren(
			BigInteger q13b2Condition2WithOnlychildren) {
		this.q13b2Condition2WithOnlychildren = q13b2Condition2WithOnlychildren;
	}
	public BigInteger getQ13b2Condition2UnknowHousehold() {
		return q13b2Condition2UnknowHousehold;
	}
	public void setQ13b2Condition2UnknowHousehold(
			BigInteger q13b2Condition2UnknowHousehold) {
		this.q13b2Condition2UnknowHousehold = q13b2Condition2UnknowHousehold;
	}
	public BigInteger getQ13b2Condition3PlusTotal() {
		return q13b2Condition3PlusTotal;
	}
	public void setQ13b2Condition3PlusTotal(BigInteger q13b2Condition3PlusTotal) {
		this.q13b2Condition3PlusTotal = q13b2Condition3PlusTotal;
	}
	public BigInteger getQ13b2Condition3PlusWithoutChildren() {
		return q13b2Condition3PlusWithoutChildren;
	}
	public void setQ13b2Condition3PlusWithoutChildren(
			BigInteger q13b2Condition3PlusWithoutChildren) {
		this.q13b2Condition3PlusWithoutChildren = q13b2Condition3PlusWithoutChildren;
	}
	public BigInteger getQ13b2Condition3PlusWithChildAndAdults() {
		return q13b2Condition3PlusWithChildAndAdults;
	}
	public void setQ13b2Condition3PlusWithChildAndAdults(
			BigInteger q13b2Condition3PlusWithChildAndAdults) {
		this.q13b2Condition3PlusWithChildAndAdults = q13b2Condition3PlusWithChildAndAdults;
	}
	public BigInteger getQ13b2Condition3PlusWithOnlychildren() {
		return q13b2Condition3PlusWithOnlychildren;
	}
	public void setQ13b2Condition3PlusWithOnlychildren(
			BigInteger q13b2Condition3PlusWithOnlychildren) {
		this.q13b2Condition3PlusWithOnlychildren = q13b2Condition3PlusWithOnlychildren;
	}
	public BigInteger getQ13b2Condition3PlusUnknowHousehold() {
		return q13b2Condition3PlusUnknowHousehold;
	}
	public void setQ13b2Condition3PlusUnknowHousehold(
			BigInteger q13b2Condition3PlusUnknowHousehold) {
		this.q13b2Condition3PlusUnknowHousehold = q13b2Condition3PlusUnknowHousehold;
	}
	public BigInteger getQ13b2ConditionUnknownTotal() {
		return q13b2ConditionUnknownTotal;
	}
	public void setQ13b2ConditionUnknownTotal(BigInteger q13b2ConditionUnknownTotal) {
		this.q13b2ConditionUnknownTotal = q13b2ConditionUnknownTotal;
	}
	public BigInteger getQ13b2ConditionUnknownWithoutChildren() {
		return q13b2ConditionUnknownWithoutChildren;
	}
	public void setQ13b2ConditionUnknownWithoutChildren(
			BigInteger q13b2ConditionUnknownWithoutChildren) {
		this.q13b2ConditionUnknownWithoutChildren = q13b2ConditionUnknownWithoutChildren;
	}
	public BigInteger getQ13b2ConditionUnknownWithChildAndAdults() {
		return q13b2ConditionUnknownWithChildAndAdults;
	}
	public void setQ13b2ConditionUnknownWithChildAndAdults(
			BigInteger q13b2ConditionUnknownWithChildAndAdults) {
		this.q13b2ConditionUnknownWithChildAndAdults = q13b2ConditionUnknownWithChildAndAdults;
	}
	public BigInteger getQ13b2ConditionUnknownWithOnlychildren() {
		return q13b2ConditionUnknownWithOnlychildren;
	}
	public void setQ13b2ConditionUnknownWithOnlychildren(
			BigInteger q13b2ConditionUnknownWithOnlychildren) {
		this.q13b2ConditionUnknownWithOnlychildren = q13b2ConditionUnknownWithOnlychildren;
	}
	public BigInteger getQ13b2ConditionUnknownUnknowHousehold() {
		return q13b2ConditionUnknownUnknowHousehold;
	}
	public void setQ13b2ConditionUnknownUnknowHousehold(
			BigInteger q13b2ConditionUnknownUnknowHousehold) {
		this.q13b2ConditionUnknownUnknowHousehold = q13b2ConditionUnknownUnknowHousehold;
	}
	public BigInteger getQ13b2DontKnowRefusedTotal() {
		return q13b2DontKnowRefusedTotal;
	}
	public void setQ13b2DontKnowRefusedTotal(BigInteger q13b2DontKnowRefusedTotal) {
		this.q13b2DontKnowRefusedTotal = q13b2DontKnowRefusedTotal;
	}
	public BigInteger getQ13b2DontKnowRefusedWithoutChildren() {
		return q13b2DontKnowRefusedWithoutChildren;
	}
	public void setQ13b2DontKnowRefusedWithoutChildren(
			BigInteger q13b2DontKnowRefusedWithoutChildren) {
		this.q13b2DontKnowRefusedWithoutChildren = q13b2DontKnowRefusedWithoutChildren;
	}
	public BigInteger getQ13b2DontKnowRefusedWithChildAndAdults() {
		return q13b2DontKnowRefusedWithChildAndAdults;
	}
	public void setQ13b2DontKnowRefusedWithChildAndAdults(
			BigInteger q13b2DontKnowRefusedWithChildAndAdults) {
		this.q13b2DontKnowRefusedWithChildAndAdults = q13b2DontKnowRefusedWithChildAndAdults;
	}
	public BigInteger getQ13b2DontKnowRefusedWithOnlychildren() {
		return q13b2DontKnowRefusedWithOnlychildren;
	}
	public void setQ13b2DontKnowRefusedWithOnlychildren(
			BigInteger q13b2DontKnowRefusedWithOnlychildren) {
		this.q13b2DontKnowRefusedWithOnlychildren = q13b2DontKnowRefusedWithOnlychildren;
	}
	public BigInteger getQ13b2DontKnowRefusedUnknowHousehold() {
		return q13b2DontKnowRefusedUnknowHousehold;
	}
	public void setQ13b2DontKnowRefusedUnknowHousehold(
			BigInteger q13b2DontKnowRefusedUnknowHousehold) {
		this.q13b2DontKnowRefusedUnknowHousehold = q13b2DontKnowRefusedUnknowHousehold;
	}
	public BigInteger getQ13b2InformationmissingTotal() {
		return q13b2InformationmissingTotal;
	}
	public void setQ13b2InformationmissingTotal(
			BigInteger q13b2InformationmissingTotal) {
		this.q13b2InformationmissingTotal = q13b2InformationmissingTotal;
	}
	public BigInteger getQ13b2InformationmissingWithoutChildren() {
		return q13b2InformationmissingWithoutChildren;
	}
	public void setQ13b2InformationmissingWithoutChildren(
			BigInteger q13b2InformationmissingWithoutChildren) {
		this.q13b2InformationmissingWithoutChildren = q13b2InformationmissingWithoutChildren;
	}
	public BigInteger getQ13b2InformationmissingWithChildAndAdults() {
		return q13b2InformationmissingWithChildAndAdults;
	}
	public void setQ13b2InformationmissingWithChildAndAdults(
			BigInteger q13b2InformationmissingWithChildAndAdults) {
		this.q13b2InformationmissingWithChildAndAdults = q13b2InformationmissingWithChildAndAdults;
	}
	public BigInteger getQ13b2InformationmissingWithOnlychildren() {
		return q13b2InformationmissingWithOnlychildren;
	}
	public void setQ13b2InformationmissingWithOnlychildren(
			BigInteger q13b2InformationmissingWithOnlychildren) {
		this.q13b2InformationmissingWithOnlychildren = q13b2InformationmissingWithOnlychildren;
	}
	public BigInteger getQ13b2InformationmissingUnknowHousehold() {
		return q13b2InformationmissingUnknowHousehold;
	}
	public void setQ13b2InformationmissingUnknowHousehold(
			BigInteger q13b2InformationmissingUnknowHousehold) {
		this.q13b2InformationmissingUnknowHousehold = q13b2InformationmissingUnknowHousehold;
	}
	public BigInteger getQ13b2TotalSummed() {
		return q13b2TotalSummed;
	}
	public void setQ13b2TotalSummed(BigInteger q13b2TotalSummed) {
		this.q13b2TotalSummed = q13b2TotalSummed;
	}
	public BigInteger getQ13b2TotalWithoutChildren() {
		return q13b2TotalWithoutChildren;
	}
	public void setQ13b2TotalWithoutChildren(BigInteger q13b2TotalWithoutChildren) {
		this.q13b2TotalWithoutChildren = q13b2TotalWithoutChildren;
	}
	public BigInteger getQ13b2TotalWithChildAndAdults() {
		return q13b2TotalWithChildAndAdults;
	}
	public void setQ13b2TotalWithChildAndAdults(
			BigInteger q13b2TotalWithChildAndAdults) {
		this.q13b2TotalWithChildAndAdults = q13b2TotalWithChildAndAdults;
	}
	public BigInteger getQ13b2TotalWithOnlychildren() {
		return q13b2TotalWithOnlychildren;
	}
	public void setQ13b2TotalWithOnlychildren(BigInteger q13b2TotalWithOnlychildren) {
		this.q13b2TotalWithOnlychildren = q13b2TotalWithOnlychildren;
	}
	public BigInteger getQ13b2TotalUnknowHousehold() {
		return q13b2TotalUnknowHousehold;
	}
	public void setQ13b2TotalUnknowHousehold(BigInteger q13b2TotalUnknowHousehold) {
		this.q13b2TotalUnknowHousehold = q13b2TotalUnknowHousehold;
	}
	public BigInteger getQ13c1MentalIllnessTotal() {
		return q13c1MentalIllnessTotal;
	}
	public void setQ13c1MentalIllnessTotal(BigInteger q13c1MentalIllnessTotal) {
		this.q13c1MentalIllnessTotal = q13c1MentalIllnessTotal;
	}
	public BigInteger getQ13c1MentalIllnessWithoutChildren() {
		return q13c1MentalIllnessWithoutChildren;
	}
	public void setQ13c1MentalIllnessWithoutChildren(
			BigInteger q13c1MentalIllnessWithoutChildren) {
		this.q13c1MentalIllnessWithoutChildren = q13c1MentalIllnessWithoutChildren;
	}
	public BigInteger getQ13c1MentalIllnessWithChildAndAdults() {
		return q13c1MentalIllnessWithChildAndAdults;
	}
	public void setQ13c1MentalIllnessWithChildAndAdults(
			BigInteger q13c1MentalIllnessWithChildAndAdults) {
		this.q13c1MentalIllnessWithChildAndAdults = q13c1MentalIllnessWithChildAndAdults;
	}
	public BigInteger getQ13c1MentalIllnessWithOnlychildren() {
		return q13c1MentalIllnessWithOnlychildren;
	}
	public void setQ13c1MentalIllnessWithOnlychildren(
			BigInteger q13c1MentalIllnessWithOnlychildren) {
		this.q13c1MentalIllnessWithOnlychildren = q13c1MentalIllnessWithOnlychildren;
	}
	public BigInteger getQ13c1MentalIllnessUnknowHousehold() {
		return q13c1MentalIllnessUnknowHousehold;
	}
	public void setQ13c1MentalIllnessUnknowHousehold(
			BigInteger q13c1MentalIllnessUnknowHousehold) {
		this.q13c1MentalIllnessUnknowHousehold = q13c1MentalIllnessUnknowHousehold;
	}
	public BigInteger getQ13c1AlcoholAbuseTotal() {
		return q13c1AlcoholAbuseTotal;
	}
	public void setQ13c1AlcoholAbuseTotal(BigInteger q13c1AlcoholAbuseTotal) {
		this.q13c1AlcoholAbuseTotal = q13c1AlcoholAbuseTotal;
	}
	public BigInteger getQ13c1AlcoholAbuseWithoutChildren() {
		return q13c1AlcoholAbuseWithoutChildren;
	}
	public void setQ13c1AlcoholAbuseWithoutChildren(
			BigInteger q13c1AlcoholAbuseWithoutChildren) {
		this.q13c1AlcoholAbuseWithoutChildren = q13c1AlcoholAbuseWithoutChildren;
	}
	public BigInteger getQ13c1AlcoholAbuseWithChildAndAdults() {
		return q13c1AlcoholAbuseWithChildAndAdults;
	}
	public void setQ13c1AlcoholAbuseWithChildAndAdults(
			BigInteger q13c1AlcoholAbuseWithChildAndAdults) {
		this.q13c1AlcoholAbuseWithChildAndAdults = q13c1AlcoholAbuseWithChildAndAdults;
	}
	public BigInteger getQ13c1AlcoholAbuseWithOnlychildren() {
		return q13c1AlcoholAbuseWithOnlychildren;
	}
	public void setQ13c1AlcoholAbuseWithOnlychildren(
			BigInteger q13c1AlcoholAbuseWithOnlychildren) {
		this.q13c1AlcoholAbuseWithOnlychildren = q13c1AlcoholAbuseWithOnlychildren;
	}
	public BigInteger getQ13c1AlcoholAbuseUnknowHousehold() {
		return q13c1AlcoholAbuseUnknowHousehold;
	}
	public void setQ13c1AlcoholAbuseUnknowHousehold(
			BigInteger q13c1AlcoholAbuseUnknowHousehold) {
		this.q13c1AlcoholAbuseUnknowHousehold = q13c1AlcoholAbuseUnknowHousehold;
	}
	public BigInteger getQ13c1DrugAbuseTotal() {
		return q13c1DrugAbuseTotal;
	}
	public void setQ13c1DrugAbuseTotal(BigInteger q13c1DrugAbuseTotal) {
		this.q13c1DrugAbuseTotal = q13c1DrugAbuseTotal;
	}
	public BigInteger getQ13c1DrugAbuseWithoutChildren() {
		return q13c1DrugAbuseWithoutChildren;
	}
	public void setQ13c1DrugAbuseWithoutChildren(
			BigInteger q13c1DrugAbuseWithoutChildren) {
		this.q13c1DrugAbuseWithoutChildren = q13c1DrugAbuseWithoutChildren;
	}
	public BigInteger getQ13c1DrugAbuseWithChildAndAdults() {
		return q13c1DrugAbuseWithChildAndAdults;
	}
	public void setQ13c1DrugAbuseWithChildAndAdults(
			BigInteger q13c1DrugAbuseWithChildAndAdults) {
		this.q13c1DrugAbuseWithChildAndAdults = q13c1DrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13c1DrugAbuseWithOnlychildren() {
		return q13c1DrugAbuseWithOnlychildren;
	}
	public void setQ13c1DrugAbuseWithOnlychildren(
			BigInteger q13c1DrugAbuseWithOnlychildren) {
		this.q13c1DrugAbuseWithOnlychildren = q13c1DrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13c1DrugAbuseUnknowHousehold() {
		return q13c1DrugAbuseUnknowHousehold;
	}
	public void setQ13c1DrugAbuseUnknowHousehold(
			BigInteger q13c1DrugAbuseUnknowHousehold) {
		this.q13c1DrugAbuseUnknowHousehold = q13c1DrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13c1BothAlcoholAndDrugAbuseTotal() {
		return q13c1BothAlcoholAndDrugAbuseTotal;
	}
	public void setQ13c1BothAlcoholAndDrugAbuseTotal(
			BigInteger q13c1BothAlcoholAndDrugAbuseTotal) {
		this.q13c1BothAlcoholAndDrugAbuseTotal = q13c1BothAlcoholAndDrugAbuseTotal;
	}
	public BigInteger getQ13c1BothAlcoholAndDrugAbuseWithoutChildren() {
		return q13c1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public void setQ13c1BothAlcoholAndDrugAbuseWithoutChildren(
			BigInteger q13c1BothAlcoholAndDrugAbuseWithoutChildren) {
		this.q13c1BothAlcoholAndDrugAbuseWithoutChildren = q13c1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public BigInteger getQ13c1BothAlcoholAndDrugAbuseWithChildAndAdults() {
		return q13c1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public void setQ13c1BothAlcoholAndDrugAbuseWithChildAndAdults(
			BigInteger q13c1BothAlcoholAndDrugAbuseWithChildAndAdults) {
		this.q13c1BothAlcoholAndDrugAbuseWithChildAndAdults = q13c1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13c1BothAlcoholAndDrugAbuseWithOnlychildren() {
		return q13c1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public void setQ13c1BothAlcoholAndDrugAbuseWithOnlychildren(
			BigInteger q13c1BothAlcoholAndDrugAbuseWithOnlychildren) {
		this.q13c1BothAlcoholAndDrugAbuseWithOnlychildren = q13c1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13c1BothAlcoholAndDrugAbuseUnknowHousehold() {
		return q13c1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public void setQ13c1BothAlcoholAndDrugAbuseUnknowHousehold(
			BigInteger q13c1BothAlcoholAndDrugAbuseUnknowHousehold) {
		this.q13c1BothAlcoholAndDrugAbuseUnknowHousehold = q13c1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13c1ChronicHealthConditionTotal() {
		return q13c1ChronicHealthConditionTotal;
	}
	public void setQ13c1ChronicHealthConditionTotal(
			BigInteger q13c1ChronicHealthConditionTotal) {
		this.q13c1ChronicHealthConditionTotal = q13c1ChronicHealthConditionTotal;
	}
	public BigInteger getQ13c1ChronicHealthConditionWithoutChildren() {
		return q13c1ChronicHealthConditionWithoutChildren;
	}
	public void setQ13c1ChronicHealthConditionWithoutChildren(
			BigInteger q13c1ChronicHealthConditionWithoutChildren) {
		this.q13c1ChronicHealthConditionWithoutChildren = q13c1ChronicHealthConditionWithoutChildren;
	}
	public BigInteger getQ13c1ChronicHealthConditionWithChildAndAdults() {
		return q13c1ChronicHealthConditionWithChildAndAdults;
	}
	public void setQ13c1ChronicHealthConditionWithChildAndAdults(
			BigInteger q13c1ChronicHealthConditionWithChildAndAdults) {
		this.q13c1ChronicHealthConditionWithChildAndAdults = q13c1ChronicHealthConditionWithChildAndAdults;
	}
	public BigInteger getQ13c1ChronicHealthConditionWithOnlychildren() {
		return q13c1ChronicHealthConditionWithOnlychildren;
	}
	public void setQ13c1ChronicHealthConditionWithOnlychildren(
			BigInteger q13c1ChronicHealthConditionWithOnlychildren) {
		this.q13c1ChronicHealthConditionWithOnlychildren = q13c1ChronicHealthConditionWithOnlychildren;
	}
	public BigInteger getQ13c1ChronicHealthConditionUnknowHousehold() {
		return q13c1ChronicHealthConditionUnknowHousehold;
	}
	public void setQ13c1ChronicHealthConditionUnknowHousehold(
			BigInteger q13c1ChronicHealthConditionUnknowHousehold) {
		this.q13c1ChronicHealthConditionUnknowHousehold = q13c1ChronicHealthConditionUnknowHousehold;
	}
	public BigInteger getQ13c1HIVRelatedDiseasesTotal() {
		return q13c1HIVRelatedDiseasesTotal;
	}
	public void setQ13c1HIVRelatedDiseasesTotal(
			BigInteger q13c1hivRelatedDiseasesTotal) {
		q13c1HIVRelatedDiseasesTotal = q13c1hivRelatedDiseasesTotal;
	}
	public BigInteger getQ13c1HIVRelatedDiseasesWithoutChildren() {
		return q13c1HIVRelatedDiseasesWithoutChildren;
	}
	public void setQ13c1HIVRelatedDiseasesWithoutChildren(
			BigInteger q13c1hivRelatedDiseasesWithoutChildren) {
		q13c1HIVRelatedDiseasesWithoutChildren = q13c1hivRelatedDiseasesWithoutChildren;
	}
	public BigInteger getQ13c1HIVRelatedDiseasesWithChildAndAdults() {
		return q13c1HIVRelatedDiseasesWithChildAndAdults;
	}
	public void setQ13c1HIVRelatedDiseasesWithChildAndAdults(
			BigInteger q13c1hivRelatedDiseasesWithChildAndAdults) {
		q13c1HIVRelatedDiseasesWithChildAndAdults = q13c1hivRelatedDiseasesWithChildAndAdults;
	}
	public BigInteger getQ13c1HIVRelatedDiseasesWithOnlychildren() {
		return q13c1HIVRelatedDiseasesWithOnlychildren;
	}
	public void setQ13c1HIVRelatedDiseasesWithOnlychildren(
			BigInteger q13c1hivRelatedDiseasesWithOnlychildren) {
		q13c1HIVRelatedDiseasesWithOnlychildren = q13c1hivRelatedDiseasesWithOnlychildren;
	}
	public BigInteger getQ13c1HIVRelatedDiseasesUnknowHousehold() {
		return q13c1HIVRelatedDiseasesUnknowHousehold;
	}
	public void setQ13c1HIVRelatedDiseasesUnknowHousehold(
			BigInteger q13c1hivRelatedDiseasesUnknowHousehold) {
		q13c1HIVRelatedDiseasesUnknowHousehold = q13c1hivRelatedDiseasesUnknowHousehold;
	}
	public BigInteger getQ13c1DevelopmentalDisabilityTotal() {
		return q13c1DevelopmentalDisabilityTotal;
	}
	public void setQ13c1DevelopmentalDisabilityTotal(
			BigInteger q13c1DevelopmentalDisabilityTotal) {
		this.q13c1DevelopmentalDisabilityTotal = q13c1DevelopmentalDisabilityTotal;
	}
	public BigInteger getQ13c1DevelopmentalDisabilityWithoutChildren() {
		return q13c1DevelopmentalDisabilityWithoutChildren;
	}
	public void setQ13c1DevelopmentalDisabilityWithoutChildren(
			BigInteger q13c1DevelopmentalDisabilityWithoutChildren) {
		this.q13c1DevelopmentalDisabilityWithoutChildren = q13c1DevelopmentalDisabilityWithoutChildren;
	}
	public BigInteger getQ13c1DevelopmentalDisabilityWithChildAndAdults() {
		return q13c1DevelopmentalDisabilityWithChildAndAdults;
	}
	public void setQ13c1DevelopmentalDisabilityWithChildAndAdults(
			BigInteger q13c1DevelopmentalDisabilityWithChildAndAdults) {
		this.q13c1DevelopmentalDisabilityWithChildAndAdults = q13c1DevelopmentalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13c1DevelopmentalDisabilityWithOnlychildren() {
		return q13c1DevelopmentalDisabilityWithOnlychildren;
	}
	public void setQ13c1DevelopmentalDisabilityWithOnlychildren(
			BigInteger q13c1DevelopmentalDisabilityWithOnlychildren) {
		this.q13c1DevelopmentalDisabilityWithOnlychildren = q13c1DevelopmentalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13c1DevelopmentalDisabilityUnknowHousehold() {
		return q13c1DevelopmentalDisabilityUnknowHousehold;
	}
	public void setQ13c1DevelopmentalDisabilityUnknowHousehold(
			BigInteger q13c1DevelopmentalDisabilityUnknowHousehold) {
		this.q13c1DevelopmentalDisabilityUnknowHousehold = q13c1DevelopmentalDisabilityUnknowHousehold;
	}
	public BigInteger getQ13c1PhysicalDisabilityTotal() {
		return q13c1PhysicalDisabilityTotal;
	}
	public void setQ13c1PhysicalDisabilityTotal(
			BigInteger q13c1PhysicalDisabilityTotal) {
		this.q13c1PhysicalDisabilityTotal = q13c1PhysicalDisabilityTotal;
	}
	public BigInteger getQ13c1PhysicalDisabilityWithoutChildren() {
		return q13c1PhysicalDisabilityWithoutChildren;
	}
	public void setQ13c1PhysicalDisabilityWithoutChildren(
			BigInteger q13c1PhysicalDisabilityWithoutChildren) {
		this.q13c1PhysicalDisabilityWithoutChildren = q13c1PhysicalDisabilityWithoutChildren;
	}
	public BigInteger getQ13c1PhysicalDisabilityWithChildAndAdults() {
		return q13c1PhysicalDisabilityWithChildAndAdults;
	}
	public void setQ13c1PhysicalDisabilityWithChildAndAdults(
			BigInteger q13c1PhysicalDisabilityWithChildAndAdults) {
		this.q13c1PhysicalDisabilityWithChildAndAdults = q13c1PhysicalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13c1PhysicalDisabilityWithOnlychildren() {
		return q13c1PhysicalDisabilityWithOnlychildren;
	}
	public void setQ13c1PhysicalDisabilityWithOnlychildren(
			BigInteger q13c1PhysicalDisabilityWithOnlychildren) {
		this.q13c1PhysicalDisabilityWithOnlychildren = q13c1PhysicalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13c1PhysicalDisabilityUnknowHousehold() {
		return q13c1PhysicalDisabilityUnknowHousehold;
	}
	public void setQ13c1PhysicalDisabilityUnknowHousehold(
			BigInteger q13c1PhysicalDisabilityUnknowHousehold) {
		this.q13c1PhysicalDisabilityUnknowHousehold = q13c1PhysicalDisabilityUnknowHousehold;
	}
	public BigInteger getQ13c2NoneTotal() {
		return q13c2NoneTotal;
	}
	public void setQ13c2NoneTotal(BigInteger q13c2NoneTotal) {
		this.q13c2NoneTotal = q13c2NoneTotal;
	}
	public BigInteger getQ13c2NoneWithoutChildren() {
		return q13c2NoneWithoutChildren;
	}
	public void setQ13c2NoneWithoutChildren(BigInteger q13c2NoneWithoutChildren) {
		this.q13c2NoneWithoutChildren = q13c2NoneWithoutChildren;
	}
	public BigInteger getQ13c2NoneWithChildAndAdults() {
		return q13c2NoneWithChildAndAdults;
	}
	public void setQ13c2NoneWithChildAndAdults(
			BigInteger q13c2NoneWithChildAndAdults) {
		this.q13c2NoneWithChildAndAdults = q13c2NoneWithChildAndAdults;
	}
	public BigInteger getQ13c2NoneWithOnlychildren() {
		return q13c2NoneWithOnlychildren;
	}
	public void setQ13c2NoneWithOnlychildren(BigInteger q13c2NoneWithOnlychildren) {
		this.q13c2NoneWithOnlychildren = q13c2NoneWithOnlychildren;
	}
	public BigInteger getQ13c2NoneUnknowHousehold() {
		return q13c2NoneUnknowHousehold;
	}
	public void setQ13c2NoneUnknowHousehold(BigInteger q13c2NoneUnknowHousehold) {
		this.q13c2NoneUnknowHousehold = q13c2NoneUnknowHousehold;
	}
	public BigInteger getQ13c2Condition1Total() {
		return q13c2Condition1Total;
	}
	public void setQ13c2Condition1Total(BigInteger q13c2Condition1Total) {
		this.q13c2Condition1Total = q13c2Condition1Total;
	}
	public BigInteger getQ13c2Condition1WithoutChildren() {
		return q13c2Condition1WithoutChildren;
	}
	public void setQ13c2Condition1WithoutChildren(
			BigInteger q13c2Condition1WithoutChildren) {
		this.q13c2Condition1WithoutChildren = q13c2Condition1WithoutChildren;
	}
	public BigInteger getQ13c2Condition1WithChildAndAdults() {
		return q13c2Condition1WithChildAndAdults;
	}
	public void setQ13c2Condition1WithChildAndAdults(
			BigInteger q13c2Condition1WithChildAndAdults) {
		this.q13c2Condition1WithChildAndAdults = q13c2Condition1WithChildAndAdults;
	}
	public BigInteger getQ13c2Condition1WithOnlychildren() {
		return q13c2Condition1WithOnlychildren;
	}
	public void setQ13c2Condition1WithOnlychildren(
			BigInteger q13c2Condition1WithOnlychildren) {
		this.q13c2Condition1WithOnlychildren = q13c2Condition1WithOnlychildren;
	}
	public BigInteger getQ13c2Condition1UnknowHousehold() {
		return q13c2Condition1UnknowHousehold;
	}
	public void setQ13c2Condition1UnknowHousehold(
			BigInteger q13c2Condition1UnknowHousehold) {
		this.q13c2Condition1UnknowHousehold = q13c2Condition1UnknowHousehold;
	}
	public BigInteger getQ13c2Condition2Total() {
		return q13c2Condition2Total;
	}
	public void setQ13c2Condition2Total(BigInteger q13c2Condition2Total) {
		this.q13c2Condition2Total = q13c2Condition2Total;
	}
	public BigInteger getQ13c2Condition2WithoutChildren() {
		return q13c2Condition2WithoutChildren;
	}
	public void setQ13c2Condition2WithoutChildren(
			BigInteger q13c2Condition2WithoutChildren) {
		this.q13c2Condition2WithoutChildren = q13c2Condition2WithoutChildren;
	}
	public BigInteger getQ13c2Condition2WithChildAndAdults() {
		return q13c2Condition2WithChildAndAdults;
	}
	public void setQ13c2Condition2WithChildAndAdults(
			BigInteger q13c2Condition2WithChildAndAdults) {
		this.q13c2Condition2WithChildAndAdults = q13c2Condition2WithChildAndAdults;
	}
	public BigInteger getQ13c2Condition2WithOnlychildren() {
		return q13c2Condition2WithOnlychildren;
	}
	public void setQ13c2Condition2WithOnlychildren(
			BigInteger q13c2Condition2WithOnlychildren) {
		this.q13c2Condition2WithOnlychildren = q13c2Condition2WithOnlychildren;
	}
	public BigInteger getQ13c2Condition2UnknowHousehold() {
		return q13c2Condition2UnknowHousehold;
	}
	public void setQ13c2Condition2UnknowHousehold(
			BigInteger q13c2Condition2UnknowHousehold) {
		this.q13c2Condition2UnknowHousehold = q13c2Condition2UnknowHousehold;
	}
	public BigInteger getQ13c2Condition3PlusTotal() {
		return q13c2Condition3PlusTotal;
	}
	public void setQ13c2Condition3PlusTotal(BigInteger q13c2Condition3PlusTotal) {
		this.q13c2Condition3PlusTotal = q13c2Condition3PlusTotal;
	}
	public BigInteger getQ13c2Condition3PlusWithoutChildren() {
		return q13c2Condition3PlusWithoutChildren;
	}
	public void setQ13c2Condition3PlusWithoutChildren(
			BigInteger q13c2Condition3PlusWithoutChildren) {
		this.q13c2Condition3PlusWithoutChildren = q13c2Condition3PlusWithoutChildren;
	}
	public BigInteger getQ13c2Condition3PlusWithChildAndAdults() {
		return q13c2Condition3PlusWithChildAndAdults;
	}
	public void setQ13c2Condition3PlusWithChildAndAdults(
			BigInteger q13c2Condition3PlusWithChildAndAdults) {
		this.q13c2Condition3PlusWithChildAndAdults = q13c2Condition3PlusWithChildAndAdults;
	}
	public BigInteger getQ13c2Condition3PlusWithOnlychildren() {
		return q13c2Condition3PlusWithOnlychildren;
	}
	public void setQ13c2Condition3PlusWithOnlychildren(
			BigInteger q13c2Condition3PlusWithOnlychildren) {
		this.q13c2Condition3PlusWithOnlychildren = q13c2Condition3PlusWithOnlychildren;
	}
	public BigInteger getQ13c2Condition3PlusUnknowHousehold() {
		return q13c2Condition3PlusUnknowHousehold;
	}
	public void setQ13c2Condition3PlusUnknowHousehold(
			BigInteger q13c2Condition3PlusUnknowHousehold) {
		this.q13c2Condition3PlusUnknowHousehold = q13c2Condition3PlusUnknowHousehold;
	}
	public BigInteger getQ13c2ConditionUnknownTotal() {
		return q13c2ConditionUnknownTotal;
	}
	public void setQ13c2ConditionUnknownTotal(BigInteger q13c2ConditionUnknownTotal) {
		this.q13c2ConditionUnknownTotal = q13c2ConditionUnknownTotal;
	}
	public BigInteger getQ13c2ConditionUnknownWithoutChildren() {
		return q13c2ConditionUnknownWithoutChildren;
	}
	public void setQ13c2ConditionUnknownWithoutChildren(
			BigInteger q13c2ConditionUnknownWithoutChildren) {
		this.q13c2ConditionUnknownWithoutChildren = q13c2ConditionUnknownWithoutChildren;
	}
	public BigInteger getQ13c2ConditionUnknownWithChildAndAdults() {
		return q13c2ConditionUnknownWithChildAndAdults;
	}
	public void setQ13c2ConditionUnknownWithChildAndAdults(
			BigInteger q13c2ConditionUnknownWithChildAndAdults) {
		this.q13c2ConditionUnknownWithChildAndAdults = q13c2ConditionUnknownWithChildAndAdults;
	}
	public BigInteger getQ13c2ConditionUnknownWithOnlychildren() {
		return q13c2ConditionUnknownWithOnlychildren;
	}
	public void setQ13c2ConditionUnknownWithOnlychildren(
			BigInteger q13c2ConditionUnknownWithOnlychildren) {
		this.q13c2ConditionUnknownWithOnlychildren = q13c2ConditionUnknownWithOnlychildren;
	}
	public BigInteger getQ13c2ConditionUnknownUnknowHousehold() {
		return q13c2ConditionUnknownUnknowHousehold;
	}
	public void setQ13c2ConditionUnknownUnknowHousehold(
			BigInteger q13c2ConditionUnknownUnknowHousehold) {
		this.q13c2ConditionUnknownUnknowHousehold = q13c2ConditionUnknownUnknowHousehold;
	}
	public BigInteger getQ13c2DontKnowRefusedTotal() {
		return q13c2DontKnowRefusedTotal;
	}
	public void setQ13c2DontKnowRefusedTotal(BigInteger q13c2DontKnowRefusedTotal) {
		this.q13c2DontKnowRefusedTotal = q13c2DontKnowRefusedTotal;
	}
	public BigInteger getQ13c2DontKnowRefusedWithoutChildren() {
		return q13c2DontKnowRefusedWithoutChildren;
	}
	public void setQ13c2DontKnowRefusedWithoutChildren(
			BigInteger q13c2DontKnowRefusedWithoutChildren) {
		this.q13c2DontKnowRefusedWithoutChildren = q13c2DontKnowRefusedWithoutChildren;
	}
	public BigInteger getQ13c2DontKnowRefusedWithChildAndAdults() {
		return q13c2DontKnowRefusedWithChildAndAdults;
	}
	public void setQ13c2DontKnowRefusedWithChildAndAdults(
			BigInteger q13c2DontKnowRefusedWithChildAndAdults) {
		this.q13c2DontKnowRefusedWithChildAndAdults = q13c2DontKnowRefusedWithChildAndAdults;
	}
	public BigInteger getQ13c2DontKnowRefusedWithOnlychildren() {
		return q13c2DontKnowRefusedWithOnlychildren;
	}
	public void setQ13c2DontKnowRefusedWithOnlychildren(
			BigInteger q13c2DontKnowRefusedWithOnlychildren) {
		this.q13c2DontKnowRefusedWithOnlychildren = q13c2DontKnowRefusedWithOnlychildren;
	}
	public BigInteger getQ13c2DontKnowRefusedUnknowHousehold() {
		return q13c2DontKnowRefusedUnknowHousehold;
	}
	public void setQ13c2DontKnowRefusedUnknowHousehold(
			BigInteger q13c2DontKnowRefusedUnknowHousehold) {
		this.q13c2DontKnowRefusedUnknowHousehold = q13c2DontKnowRefusedUnknowHousehold;
	}
	public BigInteger getQ13c2InformationmissingTotal() {
		return q13c2InformationmissingTotal;
	}
	public void setQ13c2InformationmissingTotal(
			BigInteger q13c2InformationmissingTotal) {
		this.q13c2InformationmissingTotal = q13c2InformationmissingTotal;
	}
	public BigInteger getQ13c2InformationmissingWithoutChildren() {
		return q13c2InformationmissingWithoutChildren;
	}
	public void setQ13c2InformationmissingWithoutChildren(
			BigInteger q13c2InformationmissingWithoutChildren) {
		this.q13c2InformationmissingWithoutChildren = q13c2InformationmissingWithoutChildren;
	}
	public BigInteger getQ13c2InformationmissingWithChildAndAdults() {
		return q13c2InformationmissingWithChildAndAdults;
	}
	public void setQ13c2InformationmissingWithChildAndAdults(
			BigInteger q13c2InformationmissingWithChildAndAdults) {
		this.q13c2InformationmissingWithChildAndAdults = q13c2InformationmissingWithChildAndAdults;
	}
	public BigInteger getQ13c2InformationmissingWithOnlychildren() {
		return q13c2InformationmissingWithOnlychildren;
	}
	public void setQ13c2InformationmissingWithOnlychildren(
			BigInteger q13c2InformationmissingWithOnlychildren) {
		this.q13c2InformationmissingWithOnlychildren = q13c2InformationmissingWithOnlychildren;
	}
	public BigInteger getQ13c2InformationmissingUnknowHousehold() {
		return q13c2InformationmissingUnknowHousehold;
	}
	public void setQ13c2InformationmissingUnknowHousehold(
			BigInteger q13c2InformationmissingUnknowHousehold) {
		this.q13c2InformationmissingUnknowHousehold = q13c2InformationmissingUnknowHousehold;
	}
	public BigInteger getQ13c2TotalSummed() {
		return q13c2TotalSummed;
	}
	public void setQ13c2TotalSummed(BigInteger q13c2TotalSummed) {
		this.q13c2TotalSummed = q13c2TotalSummed;
	}
	public BigInteger getQ13c2TotalWithoutChildren() {
		return q13c2TotalWithoutChildren;
	}
	public void setQ13c2TotalWithoutChildren(BigInteger q13c2TotalWithoutChildren) {
		this.q13c2TotalWithoutChildren = q13c2TotalWithoutChildren;
	}
	public BigInteger getQ13c2TotalWithChildAndAdults() {
		return q13c2TotalWithChildAndAdults;
	}
	public void setQ13c2TotalWithChildAndAdults(
			BigInteger q13c2TotalWithChildAndAdults) {
		this.q13c2TotalWithChildAndAdults = q13c2TotalWithChildAndAdults;
	}
	public BigInteger getQ13c2TotalWithOnlychildren() {
		return q13c2TotalWithOnlychildren;
	}
	public void setQ13c2TotalWithOnlychildren(BigInteger q13c2TotalWithOnlychildren) {
		this.q13c2TotalWithOnlychildren = q13c2TotalWithOnlychildren;
	}
	public BigInteger getQ13c2TotalUnknowHousehold() {
		return q13c2TotalUnknowHousehold;
	}
	public void setQ13c2TotalUnknowHousehold(BigInteger q13c2TotalUnknowHousehold) {
		this.q13c2TotalUnknowHousehold = q13c2TotalUnknowHousehold;
	}
	public BigInteger getQ13a2NoneTotal() {
		return q13a2NoneTotal;
	}
	public void setQ13a2NoneTotal(BigInteger q13a2NoneTotal) {
		this.q13a2NoneTotal = q13a2NoneTotal;
	}
	public BigInteger getQ13a2NoneWithoutChildren() {
		return q13a2NoneWithoutChildren;
	}
	public void setQ13a2NoneWithoutChildren(BigInteger q13a2NoneWithoutChildren) {
		this.q13a2NoneWithoutChildren = q13a2NoneWithoutChildren;
	}
	public BigInteger getQ13a2NoneWithChildAndAdults() {
		return q13a2NoneWithChildAndAdults;
	}
	public void setQ13a2NoneWithChildAndAdults(
			BigInteger q13a2NoneWithChildAndAdults) {
		this.q13a2NoneWithChildAndAdults = q13a2NoneWithChildAndAdults;
	}
	public BigInteger getQ13a2NoneWithOnlychildren() {
		return q13a2NoneWithOnlychildren;
	}
	public void setQ13a2NoneWithOnlychildren(BigInteger q13a2NoneWithOnlychildren) {
		this.q13a2NoneWithOnlychildren = q13a2NoneWithOnlychildren;
	}
	public BigInteger getQ13a2NoneUnknowHousehold() {
		return q13a2NoneUnknowHousehold;
	}
	public void setQ13a2NoneUnknowHousehold(BigInteger q13a2NoneUnknowHousehold) {
		this.q13a2NoneUnknowHousehold = q13a2NoneUnknowHousehold;
	}
	public BigInteger getQ13a2Condition1Total() {
		return q13a2Condition1Total;
	}
	public void setQ13a2Condition1Total(BigInteger q13a2Condition1Total) {
		this.q13a2Condition1Total = q13a2Condition1Total;
	}
	public BigInteger getQ13a2Condition1WithoutChildren() {
		return q13a2Condition1WithoutChildren;
	}
	public void setQ13a2Condition1WithoutChildren(
			BigInteger q13a2Condition1WithoutChildren) {
		this.q13a2Condition1WithoutChildren = q13a2Condition1WithoutChildren;
	}
	public BigInteger getQ13a2Condition1WithChildAndAdults() {
		return q13a2Condition1WithChildAndAdults;
	}
	public void setQ13a2Condition1WithChildAndAdults(
			BigInteger q13a2Condition1WithChildAndAdults) {
		this.q13a2Condition1WithChildAndAdults = q13a2Condition1WithChildAndAdults;
	}
	public BigInteger getQ13a2Condition1WithOnlychildren() {
		return q13a2Condition1WithOnlychildren;
	}
	public void setQ13a2Condition1WithOnlychildren(
			BigInteger q13a2Condition1WithOnlychildren) {
		this.q13a2Condition1WithOnlychildren = q13a2Condition1WithOnlychildren;
	}
	public BigInteger getQ13a2Condition1UnknowHousehold() {
		return q13a2Condition1UnknowHousehold;
	}
	public void setQ13a2Condition1UnknowHousehold(
			BigInteger q13a2Condition1UnknowHousehold) {
		this.q13a2Condition1UnknowHousehold = q13a2Condition1UnknowHousehold;
	}
	public BigInteger getQ13a2Condition2Total() {
		return q13a2Condition2Total;
	}
	public void setQ13a2Condition2Total(BigInteger q13a2Condition2Total) {
		this.q13a2Condition2Total = q13a2Condition2Total;
	}
	public BigInteger getQ13a2Condition2WithoutChildren() {
		return q13a2Condition2WithoutChildren;
	}
	public void setQ13a2Condition2WithoutChildren(
			BigInteger q13a2Condition2WithoutChildren) {
		this.q13a2Condition2WithoutChildren = q13a2Condition2WithoutChildren;
	}
	public BigInteger getQ13a2Condition2WithChildAndAdults() {
		return q13a2Condition2WithChildAndAdults;
	}
	public void setQ13a2Condition2WithChildAndAdults(
			BigInteger q13a2Condition2WithChildAndAdults) {
		this.q13a2Condition2WithChildAndAdults = q13a2Condition2WithChildAndAdults;
	}
	public BigInteger getQ13a2Condition2WithOnlychildren() {
		return q13a2Condition2WithOnlychildren;
	}
	public void setQ13a2Condition2WithOnlychildren(
			BigInteger q13a2Condition2WithOnlychildren) {
		this.q13a2Condition2WithOnlychildren = q13a2Condition2WithOnlychildren;
	}
	public BigInteger getQ13a2Condition2UnknowHousehold() {
		return q13a2Condition2UnknowHousehold;
	}
	public void setQ13a2Condition2UnknowHousehold(
			BigInteger q13a2Condition2UnknowHousehold) {
		this.q13a2Condition2UnknowHousehold = q13a2Condition2UnknowHousehold;
	}
	public BigInteger getQ13a2Condition3PlusTotal() {
		return q13a2Condition3PlusTotal;
	}
	public void setQ13a2Condition3PlusTotal(BigInteger q13a2Condition3PlusTotal) {
		this.q13a2Condition3PlusTotal = q13a2Condition3PlusTotal;
	}
	public BigInteger getQ13a2Condition3PlusWithoutChildren() {
		return q13a2Condition3PlusWithoutChildren;
	}
	public void setQ13a2Condition3PlusWithoutChildren(
			BigInteger q13a2Condition3PlusWithoutChildren) {
		this.q13a2Condition3PlusWithoutChildren = q13a2Condition3PlusWithoutChildren;
	}
	public BigInteger getQ13a2Condition3PlusWithChildAndAdults() {
		return q13a2Condition3PlusWithChildAndAdults;
	}
	public void setQ13a2Condition3PlusWithChildAndAdults(
			BigInteger q13a2Condition3PlusWithChildAndAdults) {
		this.q13a2Condition3PlusWithChildAndAdults = q13a2Condition3PlusWithChildAndAdults;
	}
	public BigInteger getQ13a2Condition3PlusWithOnlychildren() {
		return q13a2Condition3PlusWithOnlychildren;
	}
	public void setQ13a2Condition3PlusWithOnlychildren(
			BigInteger q13a2Condition3PlusWithOnlychildren) {
		this.q13a2Condition3PlusWithOnlychildren = q13a2Condition3PlusWithOnlychildren;
	}
	public BigInteger getQ13a2Condition3PlusUnknowHousehold() {
		return q13a2Condition3PlusUnknowHousehold;
	}
	public void setQ13a2Condition3PlusUnknowHousehold(
			BigInteger q13a2Condition3PlusUnknowHousehold) {
		this.q13a2Condition3PlusUnknowHousehold = q13a2Condition3PlusUnknowHousehold;
	}
	public BigInteger getQ13a2ConditionUnknownTotal() {
		return q13a2ConditionUnknownTotal;
	}
	public void setQ13a2ConditionUnknownTotal(BigInteger q13a2ConditionUnknownTotal) {
		this.q13a2ConditionUnknownTotal = q13a2ConditionUnknownTotal;
	}
	public BigInteger getQ13a2ConditionUnknownWithoutChildren() {
		return q13a2ConditionUnknownWithoutChildren;
	}
	public void setQ13a2ConditionUnknownWithoutChildren(
			BigInteger q13a2ConditionUnknownWithoutChildren) {
		this.q13a2ConditionUnknownWithoutChildren = q13a2ConditionUnknownWithoutChildren;
	}
	
	public BigInteger getQ13a2ConditionUnknownWithChildAndAdults() {
		return q13a2ConditionUnknownWithChildAndAdults;
	}
	public void setQ13a2ConditionUnknownWithChildAndAdults(
			BigInteger q13a2ConditionUnknownWithChildAndAdults) {
		this.q13a2ConditionUnknownWithChildAndAdults = q13a2ConditionUnknownWithChildAndAdults;
	}
	public BigInteger getQ13a2ConditionUnknownWithOnlychildren() {
		return q13a2ConditionUnknownWithOnlychildren;
	}
	public void setQ13a2ConditionUnknownWithOnlychildren(
			BigInteger q13a2ConditionUnknownWithOnlychildren) {
		this.q13a2ConditionUnknownWithOnlychildren = q13a2ConditionUnknownWithOnlychildren;
	}
	public BigInteger getQ13a2ConditionUnknownUnknowHousehold() {
		return q13a2ConditionUnknownUnknowHousehold;
	}
	public void setQ13a2ConditionUnknownUnknowHousehold(
			BigInteger q13a2ConditionUnknownUnknowHousehold) {
		this.q13a2ConditionUnknownUnknowHousehold = q13a2ConditionUnknownUnknowHousehold;
	}
	public BigInteger getQ13a2DontKnowRefusedTotal() {
		return q13a2DontKnowRefusedTotal;
	}
	public void setQ13a2DontKnowRefusedTotal(BigInteger q13a2DontKnowRefusedTotal) {
		this.q13a2DontKnowRefusedTotal = q13a2DontKnowRefusedTotal;
	}
	public BigInteger getQ13a2DontKnowRefusedWithoutChildren() {
		return q13a2DontKnowRefusedWithoutChildren;
	}
	public void setQ13a2DontKnowRefusedWithoutChildren(
			BigInteger q13a2DontKnowRefusedWithoutChildren) {
		this.q13a2DontKnowRefusedWithoutChildren = q13a2DontKnowRefusedWithoutChildren;
	}
	public BigInteger getQ13a2DontKnowRefusedWithChildAndAdults() {
		return q13a2DontKnowRefusedWithChildAndAdults;
	}
	public void setQ13a2DontKnowRefusedWithChildAndAdults(
			BigInteger q13a2DontKnowRefusedWithChildAndAdults) {
		this.q13a2DontKnowRefusedWithChildAndAdults = q13a2DontKnowRefusedWithChildAndAdults;
	}
	public BigInteger getQ13a2DontKnowRefusedWithOnlychildren() {
		return q13a2DontKnowRefusedWithOnlychildren;
	}
	public void setQ13a2DontKnowRefusedWithOnlychildren(
			BigInteger q13a2DontKnowRefusedWithOnlychildren) {
		this.q13a2DontKnowRefusedWithOnlychildren = q13a2DontKnowRefusedWithOnlychildren;
	}
	public BigInteger getQ13a2DontKnowRefusedUnknowHousehold() {
		return q13a2DontKnowRefusedUnknowHousehold;
	}
	public void setQ13a2DontKnowRefusedUnknowHousehold(
			BigInteger q13a2DontKnowRefusedUnknowHousehold) {
		this.q13a2DontKnowRefusedUnknowHousehold = q13a2DontKnowRefusedUnknowHousehold;
	}
	public BigInteger getQ13a2InformationmissingTotal() {
		return q13a2InformationmissingTotal;
	}
	public void setQ13a2InformationmissingTotal(
			BigInteger q13a2InformationmissingTotal) {
		this.q13a2InformationmissingTotal = q13a2InformationmissingTotal;
	}
	public BigInteger getQ13a2InformationmissingWithoutChildren() {
		return q13a2InformationmissingWithoutChildren;
	}
	public void setQ13a2InformationmissingWithoutChildren(
			BigInteger q13a2InformationmissingWithoutChildren) {
		this.q13a2InformationmissingWithoutChildren = q13a2InformationmissingWithoutChildren;
	}
	public BigInteger getQ13a2InformationmissingWithChildAndAdults() {
		return q13a2InformationmissingWithChildAndAdults;
	}
	public void setQ13a2InformationmissingWithChildAndAdults(
			BigInteger q13a2InformationmissingWithChildAndAdults) {
		this.q13a2InformationmissingWithChildAndAdults = q13a2InformationmissingWithChildAndAdults;
	}
	public BigInteger getQ13a2InformationmissingWithOnlychildren() {
		return q13a2InformationmissingWithOnlychildren;
	}
	public void setQ13a2InformationmissingWithOnlychildren(
			BigInteger q13a2InformationmissingWithOnlychildren) {
		this.q13a2InformationmissingWithOnlychildren = q13a2InformationmissingWithOnlychildren;
	}
	public BigInteger getQ13a2InformationmissingUnknowHousehold() {
		return q13a2InformationmissingUnknowHousehold;
	}
	public void setQ13a2InformationmissingUnknowHousehold(
			BigInteger q13a2InformationmissingUnknowHousehold) {
		this.q13a2InformationmissingUnknowHousehold = q13a2InformationmissingUnknowHousehold;
	}
	public BigInteger getQ13a2TotalSummed() {
		return q13a2TotalSummed;
	}
	public void setQ13a2TotalSummed(BigInteger q13a2TotalSummed) {
		this.q13a2TotalSummed = q13a2TotalSummed;
	}
	public BigInteger getQ13a2TotalWithoutChildren() {
		return q13a2TotalWithoutChildren;
	}
	public void setQ13a2TotalWithoutChildren(BigInteger q13a2TotalWithoutChildren) {
		this.q13a2TotalWithoutChildren = q13a2TotalWithoutChildren;
	}
	public BigInteger getQ13a2TotalWithChildAndAdults() {
		return q13a2TotalWithChildAndAdults;
	}
	public void setQ13a2TotalWithChildAndAdults(
			BigInteger q13a2TotalWithChildAndAdults) {
		this.q13a2TotalWithChildAndAdults = q13a2TotalWithChildAndAdults;
	}
	public BigInteger getQ13a2TotalWithOnlychildren() {
		return q13a2TotalWithOnlychildren;
	}
	public void setQ13a2TotalWithOnlychildren(BigInteger q13a2TotalWithOnlychildren) {
		this.q13a2TotalWithOnlychildren = q13a2TotalWithOnlychildren;
	}
	public BigInteger getQ13a2TotalUnknowHousehold() {
		return q13a2TotalUnknowHousehold;
	}
	public void setQ13a2TotalUnknowHousehold(BigInteger q13a2TotalUnknowHousehold) {
		this.q13a2TotalUnknowHousehold = q13a2TotalUnknowHousehold;
	}
	public BigInteger getQ13a1MentalIllnessTotal() {
		return q13a1MentalIllnessTotal;
	}
	public void setQ13a1MentalIllnessTotal(BigInteger q13a1MentalIllnessTotal) {
		this.q13a1MentalIllnessTotal = q13a1MentalIllnessTotal;
	}
	public BigInteger getQ13a1MentalIllnessWithoutChildren() {
		return q13a1MentalIllnessWithoutChildren;
	}
	public void setQ13a1MentalIllnessWithoutChildren(
			BigInteger q13a1MentalIllnessWithoutChildren) {
		this.q13a1MentalIllnessWithoutChildren = q13a1MentalIllnessWithoutChildren;
	}
	public BigInteger getQ13a1MentalIllnessWithChildAndAdults() {
		return q13a1MentalIllnessWithChildAndAdults;
	}
	public void setQ13a1MentalIllnessWithChildAndAdults(
			BigInteger q13a1MentalIllnessWithChildAndAdults) {
		this.q13a1MentalIllnessWithChildAndAdults = q13a1MentalIllnessWithChildAndAdults;
	}
	public BigInteger getQ13a1MentalIllnessWithOnlychildren() {
		return q13a1MentalIllnessWithOnlychildren;
	}
	public void setQ13a1MentalIllnessWithOnlychildren(
			BigInteger q13a1MentalIllnessWithOnlychildren) {
		this.q13a1MentalIllnessWithOnlychildren = q13a1MentalIllnessWithOnlychildren;
	}
	public BigInteger getQ13a1MentalIllnessUnknowHousehold() {
		return q13a1MentalIllnessUnknowHousehold;
	}
	public void setQ13a1MentalIllnessUnknowHousehold(
			BigInteger q13a1MentalIllnessUnknowHousehold) {
		this.q13a1MentalIllnessUnknowHousehold = q13a1MentalIllnessUnknowHousehold;
	}
	public BigInteger getQ13a1AlcoholAbuseTotal() {
		return q13a1AlcoholAbuseTotal;
	}
	public void setQ13a1AlcoholAbuseTotal(BigInteger q13a1AlcoholAbuseTotal) {
		this.q13a1AlcoholAbuseTotal = q13a1AlcoholAbuseTotal;
	}
	public BigInteger getQ13a1AlcoholAbuseWithoutChildren() {
		return q13a1AlcoholAbuseWithoutChildren;
	}
	public void setQ13a1AlcoholAbuseWithoutChildren(
			BigInteger q13a1AlcoholAbuseWithoutChildren) {
		this.q13a1AlcoholAbuseWithoutChildren = q13a1AlcoholAbuseWithoutChildren;
	}
	public BigInteger getQ13a1AlcoholAbuseWithChildAndAdults() {
		return q13a1AlcoholAbuseWithChildAndAdults;
	}
	public void setQ13a1AlcoholAbuseWithChildAndAdults(
			BigInteger q13a1AlcoholAbuseWithChildAndAdults) {
		this.q13a1AlcoholAbuseWithChildAndAdults = q13a1AlcoholAbuseWithChildAndAdults;
	}
	public BigInteger getQ13a1AlcoholAbuseWithOnlychildren() {
		return q13a1AlcoholAbuseWithOnlychildren;
	}
	public void setQ13a1AlcoholAbuseWithOnlychildren(
			BigInteger q13a1AlcoholAbuseWithOnlychildren) {
		this.q13a1AlcoholAbuseWithOnlychildren = q13a1AlcoholAbuseWithOnlychildren;
	}
	public BigInteger getQ13a1AlcoholAbuseUnknowHousehold() {
		return q13a1AlcoholAbuseUnknowHousehold;
	}
	public void setQ13a1AlcoholAbuseUnknowHousehold(
			BigInteger q13a1AlcoholAbuseUnknowHousehold) {
		this.q13a1AlcoholAbuseUnknowHousehold = q13a1AlcoholAbuseUnknowHousehold;
	}
	public BigInteger getQ13a1DrugAbuseTotal() {
		return q13a1DrugAbuseTotal;
	}
	public void setQ13a1DrugAbuseTotal(BigInteger q13a1DrugAbuseTotal) {
		this.q13a1DrugAbuseTotal = q13a1DrugAbuseTotal;
	}
	public BigInteger getQ13a1DrugAbuseWithoutChildren() {
		return q13a1DrugAbuseWithoutChildren;
	}
	public void setQ13a1DrugAbuseWithoutChildren(
			BigInteger q13a1DrugAbuseWithoutChildren) {
		this.q13a1DrugAbuseWithoutChildren = q13a1DrugAbuseWithoutChildren;
	}
	public BigInteger getQ13a1DrugAbuseWithChildAndAdults() {
		return q13a1DrugAbuseWithChildAndAdults;
	}
	public void setQ13a1DrugAbuseWithChildAndAdults(
			BigInteger q13a1DrugAbuseWithChildAndAdults) {
		this.q13a1DrugAbuseWithChildAndAdults = q13a1DrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13a1DrugAbuseWithOnlychildren() {
		return q13a1DrugAbuseWithOnlychildren;
	}
	public void setQ13a1DrugAbuseWithOnlychildren(
			BigInteger q13a1DrugAbuseWithOnlychildren) {
		this.q13a1DrugAbuseWithOnlychildren = q13a1DrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13a1DrugAbuseUnknowHousehold() {
		return q13a1DrugAbuseUnknowHousehold;
	}
	public void setQ13a1DrugAbuseUnknowHousehold(
			BigInteger q13a1DrugAbuseUnknowHousehold) {
		this.q13a1DrugAbuseUnknowHousehold = q13a1DrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13a1BothAlcoholAndDrugAbuseTotal() {
		return q13a1BothAlcoholAndDrugAbuseTotal;
	}
	public void setQ13a1BothAlcoholAndDrugAbuseTotal(
			BigInteger q13a1BothAlcoholAndDrugAbuseTotal) {
		this.q13a1BothAlcoholAndDrugAbuseTotal = q13a1BothAlcoholAndDrugAbuseTotal;
	}
	public BigInteger getQ13a1BothAlcoholAndDrugAbuseWithoutChildren() {
		return q13a1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public void setQ13a1BothAlcoholAndDrugAbuseWithoutChildren(
			BigInteger q13a1BothAlcoholAndDrugAbuseWithoutChildren) {
		this.q13a1BothAlcoholAndDrugAbuseWithoutChildren = q13a1BothAlcoholAndDrugAbuseWithoutChildren;
	}
	public BigInteger getQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults() {
		return q13a1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public void setQ13a1BothAlcoholAndDrugAbuseWithChildAndAdults(
			BigInteger q13a1BothAlcoholAndDrugAbuseWithChildAndAdults) {
		this.q13a1BothAlcoholAndDrugAbuseWithChildAndAdults = q13a1BothAlcoholAndDrugAbuseWithChildAndAdults;
	}
	public BigInteger getQ13a1BothAlcoholAndDrugAbuseWithOnlychildren() {
		return q13a1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public void setQ13a1BothAlcoholAndDrugAbuseWithOnlychildren(
			BigInteger q13a1BothAlcoholAndDrugAbuseWithOnlychildren) {
		this.q13a1BothAlcoholAndDrugAbuseWithOnlychildren = q13a1BothAlcoholAndDrugAbuseWithOnlychildren;
	}
	public BigInteger getQ13a1BothAlcoholAndDrugAbuseUnknowHousehold() {
		return q13a1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public void setQ13a1BothAlcoholAndDrugAbuseUnknowHousehold(
			BigInteger q13a1BothAlcoholAndDrugAbuseUnknowHousehold) {
		this.q13a1BothAlcoholAndDrugAbuseUnknowHousehold = q13a1BothAlcoholAndDrugAbuseUnknowHousehold;
	}
	public BigInteger getQ13a1ChronicHealthConditionTotal() {
		return q13a1ChronicHealthConditionTotal;
	}
	public void setQ13a1ChronicHealthConditionTotal(
			BigInteger q13a1ChronicHealthConditionTotal) {
		this.q13a1ChronicHealthConditionTotal = q13a1ChronicHealthConditionTotal;
	}
	public BigInteger getQ13a1ChronicHealthConditionWithoutChildren() {
		return q13a1ChronicHealthConditionWithoutChildren;
	}
	public void setQ13a1ChronicHealthConditionWithoutChildren(
			BigInteger q13a1ChronicHealthConditionWithoutChildren) {
		this.q13a1ChronicHealthConditionWithoutChildren = q13a1ChronicHealthConditionWithoutChildren;
	}
	public BigInteger getQ13a1ChronicHealthConditionWithChildAndAdults() {
		return q13a1ChronicHealthConditionWithChildAndAdults;
	}
	public void setQ13a1ChronicHealthConditionWithChildAndAdults(
			BigInteger q13a1ChronicHealthConditionWithChildAndAdults) {
		this.q13a1ChronicHealthConditionWithChildAndAdults = q13a1ChronicHealthConditionWithChildAndAdults;
	}
	public BigInteger getQ13a1ChronicHealthConditionWithOnlychildren() {
		return q13a1ChronicHealthConditionWithOnlychildren;
	}
	public void setQ13a1ChronicHealthConditionWithOnlychildren(
			BigInteger q13a1ChronicHealthConditionWithOnlychildren) {
		this.q13a1ChronicHealthConditionWithOnlychildren = q13a1ChronicHealthConditionWithOnlychildren;
	}
	public BigInteger getQ13a1ChronicHealthConditionUnknowHousehold() {
		return q13a1ChronicHealthConditionUnknowHousehold;
	}
	public void setQ13a1ChronicHealthConditionUnknowHousehold(
			BigInteger q13a1ChronicHealthConditionUnknowHousehold) {
		this.q13a1ChronicHealthConditionUnknowHousehold = q13a1ChronicHealthConditionUnknowHousehold;
	}
	
	public BigInteger getQ13a1HIVRelatedDiseasesTotal() {
		return q13a1HIVRelatedDiseasesTotal;
	}
	public void setQ13a1HIVRelatedDiseasesTotal(
			BigInteger q13a1HIVRelatedDiseasesTotal) {
		this.q13a1HIVRelatedDiseasesTotal = q13a1HIVRelatedDiseasesTotal;
	}
	public BigInteger getQ13a1HIVRelatedDiseasesWithoutChildren() {
		return q13a1HIVRelatedDiseasesWithoutChildren;
	}
	public void setQ13a1HIVRelatedDiseasesWithoutChildren(BigInteger q13a1HIVRelatedDiseasesWithoutChildren) {
		this.q13a1HIVRelatedDiseasesWithoutChildren = q13a1HIVRelatedDiseasesWithoutChildren;
	}
	public BigInteger getQ13a1HIVRelatedDiseasesWithChildAndAdults() {
		return q13a1HIVRelatedDiseasesWithChildAndAdults;
	}
	public void setQ13a1HIVRelatedDiseasesWithChildAndAdults(
			BigInteger q13a1HIVRelatedDiseasesWithChildAndAdults) {
		this.q13a1HIVRelatedDiseasesWithChildAndAdults = q13a1HIVRelatedDiseasesWithChildAndAdults;
	}
	public BigInteger getQ13a1HIVRelatedDiseasesWithOnlychildren() {
		return q13a1HIVRelatedDiseasesWithOnlychildren;
	}
	public void setQ13a1HIVRelatedDiseasesWithOnlychildren(
			BigInteger q13a1HIVRelatedDiseasesWithOnlychildren) {
		this.q13a1HIVRelatedDiseasesWithOnlychildren = q13a1HIVRelatedDiseasesWithOnlychildren;
	}
	public BigInteger getQ13a1HIVRelatedDiseasesUnknowHousehold() {
		return q13a1HIVRelatedDiseasesUnknowHousehold;
	}
	public void setQ13a1HIVRelatedDiseasesUnknowHousehold(
			BigInteger q13a1HIVRelatedDiseasesUnknowHousehold) {
		this.q13a1HIVRelatedDiseasesUnknowHousehold = q13a1HIVRelatedDiseasesUnknowHousehold;
	}
	public BigInteger getQ13a1DevelopmentalDisabilityTotal() {
		return q13a1DevelopmentalDisabilityTotal;
	}
	public void setQ13a1DevelopmentalDisabilityTotal(
			BigInteger q13a1DevelopmentalDisabilityTotal) {
		this.q13a1DevelopmentalDisabilityTotal = q13a1DevelopmentalDisabilityTotal;
	}
	public BigInteger getQ13a1DevelopmentalDisabilityWithoutChildren() {
		return q13a1DevelopmentalDisabilityWithoutChildren;
	}
	public void setQ13a1DevelopmentalDisabilityWithoutChildren(
			BigInteger q13a1DevelopmentalDisabilityWithoutChildren) {
		this.q13a1DevelopmentalDisabilityWithoutChildren = q13a1DevelopmentalDisabilityWithoutChildren;
	}
	public BigInteger getQ13a1DevelopmentalDisabilityWithChildAndAdults() {
		return q13a1DevelopmentalDisabilityWithChildAndAdults;
	}
	public void setQ13a1DevelopmentalDisabilityWithChildAndAdults(
			BigInteger q13a1DevelopmentalDisabilityWithChildAndAdults) {
		this.q13a1DevelopmentalDisabilityWithChildAndAdults = q13a1DevelopmentalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13a1DevelopmentalDisabilityWithOnlychildren() {
		return q13a1DevelopmentalDisabilityWithOnlychildren;
	}
	public void setQ13a1DevelopmentalDisabilityWithOnlychildren(
			BigInteger q13a1DevelopmentalDisabilityWithOnlychildren) {
		this.q13a1DevelopmentalDisabilityWithOnlychildren = q13a1DevelopmentalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13a1DevelopmentalDisabilityUnknowHousehold() {
		return q13a1DevelopmentalDisabilityUnknowHousehold;
	}
	public void setQ13a1DevelopmentalDisabilityUnknowHousehold(
			BigInteger q13a1DevelopmentalDisabilityUnknowHousehold) {
		this.q13a1DevelopmentalDisabilityUnknowHousehold = q13a1DevelopmentalDisabilityUnknowHousehold;
	}
	public BigInteger getQ13a1PhysicalDisabilityTotal() {
		return q13a1PhysicalDisabilityTotal;
	}
	public void setQ13a1PhysicalDisabilityTotal(
			BigInteger q13a1PhysicalDisabilityTotal) {
		this.q13a1PhysicalDisabilityTotal = q13a1PhysicalDisabilityTotal;
	}
	public BigInteger getQ13a1PhysicalDisabilityWithoutChildren() {
		return q13a1PhysicalDisabilityWithoutChildren;
	}
	public void setQ13a1PhysicalDisabilityWithoutChildren(
			BigInteger q13a1PhysicalDisabilityWithoutChildren) {
		this.q13a1PhysicalDisabilityWithoutChildren = q13a1PhysicalDisabilityWithoutChildren;
	}
	public BigInteger getQ13a1PhysicalDisabilityWithChildAndAdults() {
		return q13a1PhysicalDisabilityWithChildAndAdults;
	}
	public void setQ13a1PhysicalDisabilityWithChildAndAdults(
			BigInteger q13a1PhysicalDisabilityWithChildAndAdults) {
		this.q13a1PhysicalDisabilityWithChildAndAdults = q13a1PhysicalDisabilityWithChildAndAdults;
	}
	public BigInteger getQ13a1PhysicalDisabilityWithOnlychildren() {
		return q13a1PhysicalDisabilityWithOnlychildren;
	}
	public void setQ13a1PhysicalDisabilityWithOnlychildren(
			BigInteger q13a1PhysicalDisabilityWithOnlychildren) {
		this.q13a1PhysicalDisabilityWithOnlychildren = q13a1PhysicalDisabilityWithOnlychildren;
	}
	public BigInteger getQ13a1PhysicalDisabilityUnknowHousehold() {
		return q13a1PhysicalDisabilityUnknowHousehold;
	}
	public void setQ13a1PhysicalDisabilityUnknowHousehold(
			BigInteger q13a1PhysicalDisabilityUnknowHousehold) {
		this.q13a1PhysicalDisabilityUnknowHousehold = q13a1PhysicalDisabilityUnknowHousehold;
	}
	public BigInteger getQ12bNonHispanicTotal() {
		return q12bNonHispanicTotal;
	}
	public void setQ12bNonHispanicTotal(BigInteger q12bNonHispanicTotal) {
		this.q12bNonHispanicTotal = q12bNonHispanicTotal;
	}
	public BigInteger getQ12bNonHispanicWithoutChildren() {
		return q12bNonHispanicWithoutChildren;
	}
	public void setQ12bNonHispanicWithoutChildren(
			BigInteger q12bNonHispanicWithoutChildren) {
		this.q12bNonHispanicWithoutChildren = q12bNonHispanicWithoutChildren;
	}
	public BigInteger getQ12bNonHispanicWithChildrenAndAdults() {
		return q12bNonHispanicWithChildrenAndAdults;
	}
	public void setQ12bNonHispanicWithChildrenAndAdults(
			BigInteger q12bNonHispanicWithChildrenAndAdults) {
		this.q12bNonHispanicWithChildrenAndAdults = q12bNonHispanicWithChildrenAndAdults;
	}
	public BigInteger getQ12bNonHispanicWithOnlyChildren() {
		return q12bNonHispanicWithOnlyChildren;
	}
	public void setQ12bNonHispanicWithOnlyChildren(
			BigInteger q12bNonHispanicWithOnlyChildren) {
		this.q12bNonHispanicWithOnlyChildren = q12bNonHispanicWithOnlyChildren;
	}
	public BigInteger getQ12bNonHispanicUnknownhouseholdtype() {
		return q12bNonHispanicUnknownhouseholdtype;
	}
	public void setQ12bNonHispanicUnknownhouseholdtype(
			BigInteger q12bNonHispanicUnknownhouseholdtype) {
		this.q12bNonHispanicUnknownhouseholdtype = q12bNonHispanicUnknownhouseholdtype;
	}
	public BigInteger getQ12bHispanicTotal() {
		return q12bHispanicTotal;
	}
	public void setQ12bHispanicTotal(BigInteger q12bHispanicTotal) {
		this.q12bHispanicTotal = q12bHispanicTotal;
	}
	public BigInteger getQ12bHispanicWithoutChildren() {
		return q12bHispanicWithoutChildren;
	}
	public void setQ12bHispanicWithoutChildren(
			BigInteger q12bHispanicWithoutChildren) {
		this.q12bHispanicWithoutChildren = q12bHispanicWithoutChildren;
	}
	public BigInteger getQ12bHispanicWithChildrenAndAdults() {
		return q12bHispanicWithChildrenAndAdults;
	}
	public void setQ12bHispanicWithChildrenAndAdults(
			BigInteger q12bHispanicWithChildrenAndAdults) {
		this.q12bHispanicWithChildrenAndAdults = q12bHispanicWithChildrenAndAdults;
	}
	public BigInteger getQ12bHispanicWithOnlyChildren() {
		return q12bHispanicWithOnlyChildren;
	}
	public void setQ12bHispanicWithOnlyChildren(
			BigInteger q12bHispanicWithOnlyChildren) {
		this.q12bHispanicWithOnlyChildren = q12bHispanicWithOnlyChildren;
	}
	public BigInteger getQ12bHispanicUnknownhouseholdtype() {
		return q12bHispanicUnknownhouseholdtype;
	}
	public void setQ12bHispanicUnknownhouseholdtype(
			BigInteger q12bHispanicUnknownhouseholdtype) {
		this.q12bHispanicUnknownhouseholdtype = q12bHispanicUnknownhouseholdtype;
	}
	public BigInteger getQ12bDontKnowRacesTotal() {
		return q12bDontKnowRacesTotal;
	}
	public void setQ12bDontKnowRacesTotal(BigInteger q12bDontKnowRacesTotal) {
		this.q12bDontKnowRacesTotal = q12bDontKnowRacesTotal;
	}
	public BigInteger getQ12bDontKnowRacesWithoutChildren() {
		return q12bDontKnowRacesWithoutChildren;
	}
	public void setQ12bDontKnowRacesWithoutChildren(
			BigInteger q12bDontKnowRacesWithoutChildren) {
		this.q12bDontKnowRacesWithoutChildren = q12bDontKnowRacesWithoutChildren;
	}
	public BigInteger getQ12bDontKnowRacesWithChildrenAndAdults() {
		return q12bDontKnowRacesWithChildrenAndAdults;
	}
	public void setQ12bDontKnowRacesWithChildrenAndAdults(
			BigInteger q12bDontKnowRacesWithChildrenAndAdults) {
		this.q12bDontKnowRacesWithChildrenAndAdults = q12bDontKnowRacesWithChildrenAndAdults;
	}
	public BigInteger getQ12bDontKnowRacesWithOnlyChildren() {
		return q12bDontKnowRacesWithOnlyChildren;
	}
	public void setQ12bDontKnowRacesWithOnlyChildren(
			BigInteger q12bDontKnowRacesWithOnlyChildren) {
		this.q12bDontKnowRacesWithOnlyChildren = q12bDontKnowRacesWithOnlyChildren;
	}
	public BigInteger getQ12bDontKnowRacesUnkownhouseholdtype() {
		return q12bDontKnowRacesUnkownhouseholdtype;
	}
	public void setQ12bDontKnowRacesUnkownhouseholdtype(
			BigInteger q12bDontKnowRacesUnkownhouseholdtype) {
		this.q12bDontKnowRacesUnkownhouseholdtype = q12bDontKnowRacesUnkownhouseholdtype;
	}
	public BigInteger getQ12bInformationMissingTotal() {
		return q12bInformationMissingTotal;
	}
	public void setQ12bInformationMissingTotal(
			BigInteger q12bInformationMissingTotal) {
		this.q12bInformationMissingTotal = q12bInformationMissingTotal;
	}
	public BigInteger getQ12bInformationMissingWithoutChildren() {
		return q12bInformationMissingWithoutChildren;
	}
	public void setQ12bInformationMissingWithoutChildren(
			BigInteger q12bInformationMissingWithoutChildren) {
		this.q12bInformationMissingWithoutChildren = q12bInformationMissingWithoutChildren;
	}
	public BigInteger getQ12bInformationMissingWithChildrenAndAdults() {
		return q12bInformationMissingWithChildrenAndAdults;
	}
	public void setQ12bInformationMissingWithChildrenAndAdults(
			BigInteger q12bInformationMissingWithChildrenAndAdults) {
		this.q12bInformationMissingWithChildrenAndAdults = q12bInformationMissingWithChildrenAndAdults;
	}
	public BigInteger getQ12bInformationMissingWithOnlyChildren() {
		return q12bInformationMissingWithOnlyChildren;
	}
	public void setQ12bInformationMissingWithOnlyChildren(
			BigInteger q12bInformationMissingWithOnlyChildren) {
		this.q12bInformationMissingWithOnlyChildren = q12bInformationMissingWithOnlyChildren;
	}
	public BigInteger getQ12bInformationMissingUnkownhouseholdtype() {
		return q12bInformationMissingUnkownhouseholdtype;
	}
	public void setQ12bInformationMissingUnkownhouseholdtype(
			BigInteger q12bInformationMissingUnkownhouseholdtype) {
		this.q12bInformationMissingUnkownhouseholdtype = q12bInformationMissingUnkownhouseholdtype;
	}
	public BigInteger getQ12bTotalSummed() {
		return q12bTotalSummed;
	}
	public void setQ12bTotalSummed(BigInteger q12bTotalSummed) {
		this.q12bTotalSummed = q12bTotalSummed;
	}
	public BigInteger getQ12bTotalWithoutChildren() {
		return q12bTotalWithoutChildren;
	}
	public void setQ12bTotalWithoutChildren(BigInteger q12bTotalWithoutChildren) {
		this.q12bTotalWithoutChildren = q12bTotalWithoutChildren;
	}
	public BigInteger getQ12bTotalWithChildrenAndAdults() {
		return q12bTotalWithChildrenAndAdults;
	}
	public void setQ12bTotalWithChildrenAndAdults(
			BigInteger q12bTotalWithChildrenAndAdults) {
		this.q12bTotalWithChildrenAndAdults = q12bTotalWithChildrenAndAdults;
	}
	public BigInteger getQ12bTotalWithOnlyChildren() {
		return q12bTotalWithOnlyChildren;
	}
	public void setQ12bTotalWithOnlyChildren(BigInteger q12bTotalWithOnlyChildren) {
		this.q12bTotalWithOnlyChildren = q12bTotalWithOnlyChildren;
	}
	public BigInteger getQ12bTotalUnkownhouseholdtype() {
		return q12bTotalUnkownhouseholdtype;
	}
	public void setQ12bTotalUnkownhouseholdtype(
			BigInteger q12bTotalUnkownhouseholdtype) {
		this.q12bTotalUnkownhouseholdtype = q12bTotalUnkownhouseholdtype;
	}
	public BigInteger getQ12aWhiteTotal() {
		return q12aWhiteTotal;
	}
	public void setQ12aWhiteTotal(BigInteger q12aWhiteTotal) {
		this.q12aWhiteTotal = q12aWhiteTotal;
	}
	public BigInteger getQ12aWhiteWithoutChildren() {
		return q12aWhiteWithoutChildren;
	}
	public void setQ12aWhiteWithoutChildren(BigInteger q12aWhiteWithoutChildren) {
		this.q12aWhiteWithoutChildren = q12aWhiteWithoutChildren;
	}
	public BigInteger getQ12aWhiteWithChildrenAndAdults() {
		return q12aWhiteWithChildrenAndAdults;
	}
	public void setQ12aWhiteWithChildrenAndAdults(
			BigInteger q12aWhiteWithChildrenAndAdults) {
		this.q12aWhiteWithChildrenAndAdults = q12aWhiteWithChildrenAndAdults;
	}
	public BigInteger getQ12aWhiteWithOnlyChildren() {
		return q12aWhiteWithOnlyChildren;
	}
	public void setQ12aWhiteWithOnlyChildren(BigInteger q12aWhiteWithOnlyChildren) {
		this.q12aWhiteWithOnlyChildren = q12aWhiteWithOnlyChildren;
	}
	public BigInteger getQ12aWhiteWithUnkownhouseholdtype() {
		return q12aWhiteWithUnkownhouseholdtype;
	}
	public void setQ12aWhiteWithUnkownhouseholdtype(
			BigInteger q12aWhiteWithUnkownhouseholdtype) {
		this.q12aWhiteWithUnkownhouseholdtype = q12aWhiteWithUnkownhouseholdtype;
	}
	public BigInteger getQ12aBlckAfrnAmrnTotal() {
		return q12aBlckAfrnAmrnTotal;
	}
	public void setQ12aBlckAfrnAmrnTotal(BigInteger q12aBlckAfrnAmrnTotal) {
		this.q12aBlckAfrnAmrnTotal = q12aBlckAfrnAmrnTotal;
	}
	public BigInteger getQ12aBlckAfrnAmrnWithoutChildren() {
		return q12aBlckAfrnAmrnWithoutChildren;
	}
	public void setQ12aBlckAfrnAmrnWithoutChildren(
			BigInteger q12aBlckAfrnAmrnWithoutChildren) {
		this.q12aBlckAfrnAmrnWithoutChildren = q12aBlckAfrnAmrnWithoutChildren;
	}
	public BigInteger getQ12aBlckAfrnAmrnWithChildrenAndAdults() {
		return q12aBlckAfrnAmrnWithChildrenAndAdults;
	}
	public void setQ12aBlckAfrnAmrnWithChildrenAndAdults(
			BigInteger q12aBlckAfrnAmrnWithChildrenAndAdults) {
		this.q12aBlckAfrnAmrnWithChildrenAndAdults = q12aBlckAfrnAmrnWithChildrenAndAdults;
	}
	public BigInteger getQ12aBlckAfrnAmrnWithOnlyChildren() {
		return q12aBlckAfrnAmrnWithOnlyChildren;
	}
	public void setQ12aBlckAfrnAmrnWithOnlyChildren(
			BigInteger q12aBlckAfrnAmrnWithOnlyChildren) {
		this.q12aBlckAfrnAmrnWithOnlyChildren = q12aBlckAfrnAmrnWithOnlyChildren;
	}
	public BigInteger getQ12aBlckAfrnAmrnWithUnkownhouseholdtype() {
		return q12aBlckAfrnAmrnWithUnkownhouseholdtype;
	}
	public void setQ12aBlckAfrnAmrnWithUnkownhouseholdtype(
			BigInteger q12aBlckAfrnAmrnWithUnkownhouseholdtype) {
		this.q12aBlckAfrnAmrnWithUnkownhouseholdtype = q12aBlckAfrnAmrnWithUnkownhouseholdtype;
	}
	public BigInteger getQ12aAsianTotal() {
		return q12aAsianTotal;
	}
	public void setQ12aAsianTotal(BigInteger q12aAsianTotal) {
		this.q12aAsianTotal = q12aAsianTotal;
	}
	public BigInteger getQ12aAsianWithoutChildren() {
		return q12aAsianWithoutChildren;
	}
	public void setQ12aAsianWithoutChildren(BigInteger q12aAsianWithoutChildren) {
		this.q12aAsianWithoutChildren = q12aAsianWithoutChildren;
	}
	public BigInteger getQ12aAsianWithChildrenAndAdults() {
		return q12aAsianWithChildrenAndAdults;
	}
	public void setQ12aAsianWithChildrenAndAdults(
			BigInteger q12aAsianWithChildrenAndAdults) {
		this.q12aAsianWithChildrenAndAdults = q12aAsianWithChildrenAndAdults;
	}
	public BigInteger getQ12aAsianWithOnlyChildren() {
		return q12aAsianWithOnlyChildren;
	}
	public void setQ12aAsianWithOnlyChildren(BigInteger q12aAsianWithOnlyChildren) {
		this.q12aAsianWithOnlyChildren = q12aAsianWithOnlyChildren;
	}
	public BigInteger getQ12aAsianUnkownhouseholdtype() {
		return q12aAsianUnkownhouseholdtype;
	}
	public void setQ12aAsianUnkownhouseholdtype(
			BigInteger q12aAsianUnkownhouseholdtype) {
		this.q12aAsianUnkownhouseholdtype = q12aAsianUnkownhouseholdtype;
	}
	public BigInteger getQ12aAmericanIndianTotal() {
		return q12aAmericanIndianTotal;
	}
	public void setQ12aAmericanIndianTotal(BigInteger q12aAmericanIndianTotal) {
		this.q12aAmericanIndianTotal = q12aAmericanIndianTotal;
	}
	public BigInteger getQ12aAmericanIndianWithoutChildren() {
		return q12aAmericanIndianWithoutChildren;
	}
	public void setQ12aAmericanIndianWithoutChildren(
			BigInteger q12aAmericanIndianWithoutChildren) {
		this.q12aAmericanIndianWithoutChildren = q12aAmericanIndianWithoutChildren;
	}
	public BigInteger getQ12aAmericanIndianWithChildrenAndAdults() {
		return q12aAmericanIndianWithChildrenAndAdults;
	}
	public void setQ12aAmericanIndianWithChildrenAndAdults(
			BigInteger q12aAmericanIndianWithChildrenAndAdults) {
		this.q12aAmericanIndianWithChildrenAndAdults = q12aAmericanIndianWithChildrenAndAdults;
	}
	public BigInteger getQ12aAmericanIndianWithOnlyChildren() {
		return q12aAmericanIndianWithOnlyChildren;
	}
	public void setQ12aAmericanIndianWithOnlyChildren(
			BigInteger q12aAmericanIndianWithOnlyChildren) {
		this.q12aAmericanIndianWithOnlyChildren = q12aAmericanIndianWithOnlyChildren;
	}
	public BigInteger getQ12aAmericanIndianUnkownhouseholdtype() {
		return q12aAmericanIndianUnkownhouseholdtype;
	}
	public void setQ12aAmericanIndianUnkownhouseholdtype(
			BigInteger q12aAmericanIndianUnkownhouseholdtype) {
		this.q12aAmericanIndianUnkownhouseholdtype = q12aAmericanIndianUnkownhouseholdtype;
	}
	public BigInteger getQ12aNativeHawalianTotal() {
		return q12aNativeHawalianTotal;
	}
	public void setQ12aNativeHawalianTotal(BigInteger q12aNativeHawalianTotal) {
		this.q12aNativeHawalianTotal = q12aNativeHawalianTotal;
	}
	public BigInteger getQ12aNativeHawalianWithoutChildren() {
		return q12aNativeHawalianWithoutChildren;
	}
	public void setQ12aNativeHawalianWithoutChildren(
			BigInteger q12aNativeHawalianWithoutChildren) {
		this.q12aNativeHawalianWithoutChildren = q12aNativeHawalianWithoutChildren;
	}
	public BigInteger getQ12aNativeHawalianWithChildrenAndAdults() {
		return q12aNativeHawalianWithChildrenAndAdults;
	}
	public void setQ12aNativeHawalianWithChildrenAndAdults(
			BigInteger q12aNativeHawalianWithChildrenAndAdults) {
		this.q12aNativeHawalianWithChildrenAndAdults = q12aNativeHawalianWithChildrenAndAdults;
	}
	public BigInteger getQ12aNativeHawalianWithOnlyChildren() {
		return q12aNativeHawalianWithOnlyChildren;
	}
	public void setQ12aNativeHawalianWithOnlyChildren(
			BigInteger q12aNativeHawalianWithOnlyChildren) {
		this.q12aNativeHawalianWithOnlyChildren = q12aNativeHawalianWithOnlyChildren;
	}
	public BigInteger getQ12aNativeHawalianUnkownhouseholdtype() {
		return q12aNativeHawalianUnkownhouseholdtype;
	}
	public void setQ12aNativeHawalianUnkownhouseholdtype(
			BigInteger q12aNativeHawalianUnkownhouseholdtype) {
		this.q12aNativeHawalianUnkownhouseholdtype = q12aNativeHawalianUnkownhouseholdtype;
	}
	public BigInteger getQ12aMultipleRacesTotal() {
		return q12aMultipleRacesTotal;
	}
	public void setQ12aMultipleRacesTotal(BigInteger q12aMultipleRacesTotal) {
		this.q12aMultipleRacesTotal = q12aMultipleRacesTotal;
	}
	public BigInteger getQ12aMultipleRacesWithoutChildren() {
		return q12aMultipleRacesWithoutChildren;
	}
	public void setQ12aMultipleRacesWithoutChildren(
			BigInteger q12aMultipleRacesWithoutChildren) {
		this.q12aMultipleRacesWithoutChildren = q12aMultipleRacesWithoutChildren;
	}
	public BigInteger getQ12aMultipleRacesWithChildrenAndAdults() {
		return q12aMultipleRacesWithChildrenAndAdults;
	}
	public void setQ12aMultipleRacesWithChildrenAndAdults(
			BigInteger q12aMultipleRacesWithChildrenAndAdults) {
		this.q12aMultipleRacesWithChildrenAndAdults = q12aMultipleRacesWithChildrenAndAdults;
	}
	public BigInteger getQ12aMultipleRacesWithOnlyChildren() {
		return q12aMultipleRacesWithOnlyChildren;
	}
	public void setQ12aMultipleRacesWithOnlyChildren(
			BigInteger q12aMultipleRacesWithOnlyChildren) {
		this.q12aMultipleRacesWithOnlyChildren = q12aMultipleRacesWithOnlyChildren;
	}
	public BigInteger getQ12aMultipleRacesUnkownhouseholdtype() {
		return q12aMultipleRacesUnkownhouseholdtype;
	}
	public void setQ12aMultipleRacesUnkownhouseholdtype(
			BigInteger q12aMultipleRacesUnkownhouseholdtype) {
		this.q12aMultipleRacesUnkownhouseholdtype = q12aMultipleRacesUnkownhouseholdtype;
	}
	public BigInteger getQ12aDontKnowRacesTotal() {
		return q12aDontKnowRacesTotal;
	}
	public void setQ12aDontKnowRacesTotal(BigInteger q12aDontKnowRacesTotal) {
		this.q12aDontKnowRacesTotal = q12aDontKnowRacesTotal;
	}
	public BigInteger getQ12aDontKnowRacesWithoutChildren() {
		return q12aDontKnowRacesWithoutChildren;
	}
	public void setQ12aDontKnowRacesWithoutChildren(
			BigInteger q12aDontKnowRacesWithoutChildren) {
		this.q12aDontKnowRacesWithoutChildren = q12aDontKnowRacesWithoutChildren;
	}
	public BigInteger getQ12aDontKnowRacesWithChildrenAndAdults() {
		return q12aDontKnowRacesWithChildrenAndAdults;
	}
	public void setQ12aDontKnowRacesWithChildrenAndAdults(
			BigInteger q12aDontKnowRacesWithChildrenAndAdults) {
		this.q12aDontKnowRacesWithChildrenAndAdults = q12aDontKnowRacesWithChildrenAndAdults;
	}
	public BigInteger getQ12aDontKnowRacesWithOnlyChildren() {
		return q12aDontKnowRacesWithOnlyChildren;
	}
	public void setQ12aDontKnowRacesWithOnlyChildren(
			BigInteger q12aDontKnowRacesWithOnlyChildren) {
		this.q12aDontKnowRacesWithOnlyChildren = q12aDontKnowRacesWithOnlyChildren;
	}
	public BigInteger getQ12aDontKnowRacesUnkownhouseholdtype() {
		return q12aDontKnowRacesUnkownhouseholdtype;
	}
	public void setQ12aDontKnowRacesUnkownhouseholdtype(
			BigInteger q12aDontKnowRacesUnkownhouseholdtype) {
		this.q12aDontKnowRacesUnkownhouseholdtype = q12aDontKnowRacesUnkownhouseholdtype;
	}
	public BigInteger getQ12aInformationMissingTotal() {
		return q12aInformationMissingTotal;
	}
	public void setQ12aInformationMissingTotal(
			BigInteger q12aInformationMissingTotal) {
		this.q12aInformationMissingTotal = q12aInformationMissingTotal;
	}
	public BigInteger getQ12aInformationMissingWithoutChildren() {
		return q12aInformationMissingWithoutChildren;
	}
	public void setQ12aInformationMissingWithoutChildren(
			BigInteger q12aInformationMissingWithoutChildren) {
		this.q12aInformationMissingWithoutChildren = q12aInformationMissingWithoutChildren;
	}
	public BigInteger getQ12aInformationMissingWithChildrenAndAdults() {
		return q12aInformationMissingWithChildrenAndAdults;
	}
	public void setQ12aInformationMissingWithChildrenAndAdults(
			BigInteger q12aInformationMissingWithChildrenAndAdults) {
		this.q12aInformationMissingWithChildrenAndAdults = q12aInformationMissingWithChildrenAndAdults;
	}
	public BigInteger getQ12aInformationMissingWithOnlyChildren() {
		return q12aInformationMissingWithOnlyChildren;
	}
	public void setQ12aInformationMissingWithOnlyChildren(
			BigInteger q12aInformationMissingWithOnlyChildren) {
		this.q12aInformationMissingWithOnlyChildren = q12aInformationMissingWithOnlyChildren;
	}
	public BigInteger getQ12aInformationMissingUnkownhouseholdtype() {
		return q12aInformationMissingUnkownhouseholdtype;
	}
	public void setQ12aInformationMissingUnkownhouseholdtype(
			BigInteger q12aInformationMissingUnkownhouseholdtype) {
		this.q12aInformationMissingUnkownhouseholdtype = q12aInformationMissingUnkownhouseholdtype;
	}
	public BigInteger getQ12aTotalSummed() {
		return q12aTotalSummed;
	}
	public void setQ12aTotalSummed(BigInteger q12aTotalSummed) {
		this.q12aTotalSummed = q12aTotalSummed;
	}
	public BigInteger getQ12aTotalWithoutChildren() {
		return q12aTotalWithoutChildren;
	}
	public void setQ12aTotalWithoutChildren(BigInteger q12aTotalWithoutChildren) {
		this.q12aTotalWithoutChildren = q12aTotalWithoutChildren;
	}
	public BigInteger getQ12aTotalWithChildrenAndAdults() {
		return q12aTotalWithChildrenAndAdults;
	}
	public void setQ12aTotalWithChildrenAndAdults(
			BigInteger q12aTotalWithChildrenAndAdults) {
		this.q12aTotalWithChildrenAndAdults = q12aTotalWithChildrenAndAdults;
	}
	public BigInteger getQ12aTotalWithOnlyChildren() {
		return q12aTotalWithOnlyChildren;
	}
	public void setQ12aTotalWithOnlyChildren(BigInteger q12aTotalWithOnlyChildren) {
		this.q12aTotalWithOnlyChildren = q12aTotalWithOnlyChildren;
	}
	public BigInteger getQ12aTotalUnkownhouseholdtype() {
		return q12aTotalUnkownhouseholdtype;
	}
	public void setQ12aTotalUnkownhouseholdtype(
			BigInteger q12aTotalUnkownhouseholdtype) {
		this.q12aTotalUnkownhouseholdtype = q12aTotalUnkownhouseholdtype;
	}
	public void setTotNumOfPersonServed(String totNumOfPersonServed) {
		this.totNumOfPersonServed = totNumOfPersonServed;
	}
	
	public BigInteger getNpTotalDKR() {
		return npTotalDKR;
	}
	public void setNpTotalDKR(BigInteger npTotalDKR) {
		this.npTotalDKR = npTotalDKR;
	}
	public BigInteger getNpTotalMI() {
		return npTotalMI;
	}
	public void setNpTotalMI(BigInteger npTotalMI) {
		this.npTotalMI = npTotalMI;
	}
	public BigInteger getNpOverallTotal() {
		return npOverallTotal;
	}
	public void setNpOverallTotal(BigInteger npOverallTotal) {
		this.npOverallTotal = npOverallTotal;
	}
	public BigInteger getNpTotalWC() {
		return npTotalWC;
	}
	public void setNpTotalWC(BigInteger npTotalWC) {
		this.npTotalWC = npTotalWC;
	}
	public BigInteger getNpWCATotal() {
		return npWCATotal;
	}
	public void setNpWCATotal(BigInteger npWCATotal) {
		this.npWCATotal = npWCATotal;
	}
	public BigInteger getNpWOCTotal() {
		return npWOCTotal;
	}
	public void setNpWOCTotal(BigInteger npWOCTotal) {
		this.npWOCTotal = npWOCTotal;
	}
	public BigInteger getNpUHTTotal() {
		return npUHTTotal;
	}
	public void setNpUHTTotal(BigInteger npUHTTotal) {
		this.npUHTTotal = npUHTTotal;
	}
	public BigInteger getJanTotal() {
		return janTotal;
	}
	public void setJanTotal(BigInteger janTotal) {
		this.janTotal = janTotal;
	}
	public BigInteger getAprTotal() {
		return aprTotal;
	}
	public void setAprTotal(BigInteger aprTotal) {
		this.aprTotal = aprTotal;
	}
	public BigInteger getJulyTotal() {
		return julyTotal;
	}
	public void setJulyTotal(BigInteger julyTotal) {
		this.julyTotal = julyTotal;
	}
	public BigInteger getOctTotal() {
		return octTotal;
	}
	public void setOctTotal(BigInteger octTotal) {
		this.octTotal = octTotal;
	}
	public BigInteger getNpTotalAdults() {
		return npTotalAdults;
	}
	public void setNpTotalAdults(BigInteger npTotalAdults) {
		this.npTotalAdults = npTotalAdults;
	}
	public BigInteger getNpTotalChildren() {
		return npTotalChildren;
	}
	public void setNpTotalChildren(BigInteger npTotalChildren) {
		this.npTotalChildren = npTotalChildren;
	}
	
	public Timestamp getCrtdUpdtdDate() {
		return crtdUpdtdDate;
	}
	public void setCrtdUpdtdDate(Timestamp crtdUpdtdDate) {
		this.crtdUpdtdDate = crtdUpdtdDate;
	}
	public Boolean getDelFlag() {
		return delFlag;
	}
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	public BigInteger getClientlocationForPe() {
		return clientlocationForPe;
	}
	public void setClientlocationForPe(BigInteger clientlocationForPe) {
		this.clientlocationForPe = clientlocationForPe;
	}
	public BigInteger getDestination() {
		return destination;
	}
	public void setDestination(BigInteger destination) {
		this.destination = destination;
	}
	public BigInteger getDisablingCond() {
		return disablingCond;
	}
	public void setDisablingCond(BigInteger disablingCond) {
		this.disablingCond = disablingCond;
	}
	public BigInteger getDob() {
		return dob;
	}
	public void setDob(BigInteger dob) {
		this.dob = dob;
	}
	public BigInteger getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(BigInteger ethnicity) {
		this.ethnicity = ethnicity;
	}
	public BigInteger getFirstName() {
		return firstName;
	}
	public void setFirstName(BigInteger firstName) {
		this.firstName = firstName;
	}
	public BigInteger getGender() {
		return gender;
	}
	public void setGender(BigInteger gender) {
		this.gender = gender;
	}
	public BigInteger getLastName() {
		return lastName;
	}
	public void setLastName(BigInteger lastName) {
		this.lastName = lastName;
	}
	public BigInteger getLtsInEs() {
		return ltsInEs;
	}
	public void setLtsInEs(BigInteger ltsInEs) {
		this.ltsInEs = ltsInEs;
	}
	public BigInteger getMdClientlocationForPe() {
		return mdClientlocationForPe;
	}
	public void setMdClientlocationForPe(BigInteger mdClientlocationForPe) {
		this.mdClientlocationForPe = mdClientlocationForPe;
	}
	public BigInteger getMdDestination() {
		return mdDestination;
	}
	public void setMdDestination(BigInteger mdDestination) {
		this.mdDestination = mdDestination;
	}
	public BigInteger getMdDisablingCond() {
		return mdDisablingCond;
	}
	public void setMdDisablingCond(BigInteger mdDisablingCond) {
		this.mdDisablingCond = mdDisablingCond;
	}
	public BigInteger getMdDob() {
		return mdDob;
	}
	public void setMdDob(BigInteger mdDob) {
		this.mdDob = mdDob;
	}
	public BigInteger getMdEthnicity() {
		return mdEthnicity;
	}
	public void setMdEthnicity(BigInteger mdEthnicity) {
		this.mdEthnicity = mdEthnicity;
	}
	public BigInteger getMdFirstName() {
		return mdFirstName;
	}
	public void setMdFirstName(BigInteger mdFirstName) {
		this.mdFirstName = mdFirstName;
	}
	public BigInteger getMdGender() {
		return mdGender;
	}
	public void setMdGender(BigInteger mdGender) {
		this.mdGender = mdGender;
	}
	public BigInteger getMdLastName() {
		return mdLastName;
	}
	public void setMdLastName(BigInteger mdLastName) {
		this.mdLastName = mdLastName;
	}
	public BigInteger getMdLtsInEsSh() {
		return mdLtsInEsSh;
	}
	public void setMdLtsInEsSh(BigInteger mdLtsInEsSh) {
		this.mdLtsInEsSh = mdLtsInEsSh;
	}
	public BigInteger getMdRace() {
		return mdRace;
	}
	public void setMdRace(BigInteger mdRace) {
		this.mdRace = mdRace;
	}
	public BigInteger getMdRelationshipToHh() {
		return mdRelationshipToHh;
	}
	public void setMdRelationshipToHh(BigInteger mdRelationshipToHh) {
		this.mdRelationshipToHh = mdRelationshipToHh;
	}
	public BigInteger getMdSsn() {
		return mdSsn;
	}
	public void setMdSsn(BigInteger mdSsn) {
		this.mdSsn = mdSsn;
	}
	public BigInteger getMdVeteranStatus() {
		return mdVeteranStatus;
	}
	public void setMdVeteranStatus(BigInteger mdVeteranStatus) {
		this.mdVeteranStatus = mdVeteranStatus;
	}
	public BigInteger getMdresidencepriortoentry() {
		return mdresidencepriortoentry;
	}
	public void setMdresidencepriortoentry(BigInteger mdresidencepriortoentry) {
		this.mdresidencepriortoentry = mdresidencepriortoentry;
	}
	public BigInteger getRace() {
		return race;
	}
	public void setRace(BigInteger race) {
		this.race = race;
	}
	public BigInteger getRelationshiptToHh() {
		return relationshiptToHh;
	}
	public void setRelationshiptToHh(BigInteger relationshiptToHh) {
		this.relationshiptToHh = relationshiptToHh;
	}
	public BigInteger getResidencePriorToEntry() {
		return residencePriorToEntry;
	}
	public void setResidencePriorToEntry(BigInteger residencePriorToEntry) {
		this.residencePriorToEntry = residencePriorToEntry;
	}
	public BigInteger getSsn() {
		return ssn;
	}
	public void setSsn(BigInteger ssn) {
		this.ssn = ssn;
	}
	public BigInteger getVeteranStatus() {
		return veteranStatus;
	}
	public void setVeteranStatus(BigInteger veteranStatus) {
		this.veteranStatus = veteranStatus;
	}
	public BigInteger getCountAprUht() {
		return countAprUht;
	}
	public void setCountAprUht(BigInteger countAprUht) {
		this.countAprUht = countAprUht;
	}
	

	public String getNumOfAdults() {
		return numOfAdults;
	}
	public void setNumOfAdults(String numOfAdults) {
		this.numOfAdults = numOfAdults;
	}
	public String getNumOfChildren() {
		return numOfChildren;
	}
	public void setNumOfChildren(String numOfChildren) {
		this.numOfChildren = numOfChildren;
	}
	public String getTotNoOfLeavers() {
		return totNoOfLeavers;
	}
	public void setTotNoOfLeavers(String totNoOfLeavers) {
		this.totNoOfLeavers = totNoOfLeavers;
	}
	public String getTotNoOfAdultLeavers() {
		return totNoOfAdultLeavers;
	}
	public void setTotNoOfAdultLeavers(String totNoOfAdultLeavers) {
		this.totNoOfAdultLeavers = totNoOfAdultLeavers;
	}
	public String getNoOfVeterans() {
		return noOfVeterans;
	}
	public void setNoOfVeterans(String noOfVeterans) {
		this.noOfVeterans = noOfVeterans;
	}
	public String getNoOfChronicallyHomelessPersons() {
		return noOfChronicallyHomelessPersons;
	}
	public void setNoOfChronicallyHomelessPersons(
			String noOfChronicallyHomelessPersons) {
		this.noOfChronicallyHomelessPersons = noOfChronicallyHomelessPersons;
	}
	public String getNoOfAdultHeadsOfHousehold() {
		return noOfAdultHeadsOfHousehold;
	}
	public void setNoOfAdultHeadsOfHousehold(String noOfAdultHeadsOfHousehold) {
		this.noOfAdultHeadsOfHousehold = noOfAdultHeadsOfHousehold;
	}
	public String getNoOfChildHeadsOfHousehold() {
		return noOfChildHeadsOfHousehold;
	}
	public void setNoOfChildHeadsOfHousehold(String noOfChildHeadsOfHousehold) {
		this.noOfChildHeadsOfHousehold = noOfChildHeadsOfHousehold;
	}
	public String getNumOfUnaccompaniedYouthUnderAge25() {
		return numOfUnaccompaniedYouthUnderAge25;
	}
	public void setNumOfUnaccompaniedYouthUnderAge25(
			String numOfUnaccompaniedYouthUnderAge25) {
		this.numOfUnaccompaniedYouthUnderAge25 = numOfUnaccompaniedYouthUnderAge25;
	}
	public String getNumOfParentingYouthUnderAge25WithChildren() {
		return numOfParentingYouthUnderAge25WithChildren;
	}
	public void setNumOfParentingYouthUnderAge25WithChildren(
			String numOfParentingYouthUnderAge25WithChildren) {
		this.numOfParentingYouthUnderAge25WithChildren = numOfParentingYouthUnderAge25WithChildren;
	}
	
	public String getNumOfPersonsWithUnknownAge() {
		return numOfPersonsWithUnknownAge;
	}
	public void setNumOfPersonsWithUnknownAge(String numOfPersonsWithUnknownAge) {
		this.numOfPersonsWithUnknownAge = numOfPersonsWithUnknownAge;
	}
	public String getTotNoOfStayers() {
		return totNoOfStayers;
	}
	public void setTotNoOfStayers(String totNoOfStayers) {
		this.totNoOfStayers = totNoOfStayers;
	}
	public String getTotNoOfAdultStayers() {
		return totNoOfAdultStayers;
	}
	public void setTotNoOfAdultStayers(String totNoOfAdultStayers) {
		this.totNoOfAdultStayers = totNoOfAdultStayers;
	}
	public BigInteger getCountAprWc() {
		return countAprWc;
	}
	public void setCountAprWc(BigInteger countAprWc) {
		this.countAprWc = countAprWc;
	}
	public BigInteger getCountAprWca() {
		return countAprWca;
	}
	public void setCountAprWca(BigInteger countAprWca) {
		this.countAprWca = countAprWca;
	}
	public BigInteger getCountAprWoc() {
		return countAprWoc;
	}
	public void setCountAprWoc(BigInteger countAprWoc) {
		this.countAprWoc = countAprWoc;
	}
	public BigInteger getCountJanUht() {
		return countJanUht;
	}
	public void setCountJanUht(BigInteger countJanUht) {
		this.countJanUht = countJanUht;
	}
	public BigInteger getCountJanWc() {
		return countJanWc;
	}
	public void setCountJanWc(BigInteger countJanWc) {
		this.countJanWc = countJanWc;
	}
	public BigInteger getCountJanWca() {
		return countJanWca;
	}
	public void setCountJanWca(BigInteger countJanWca) {
		this.countJanWca = countJanWca;
	}
	public BigInteger getCountJanWoc() {
		return countJanWoc;
	}
	public void setCountJanWoc(BigInteger countJanWoc) {
		this.countJanWoc = countJanWoc;
	}
	public BigInteger getCountJulUht() {
		return countJulUht;
	}
	public void setCountJulUht(BigInteger countJulUht) {
		this.countJulUht = countJulUht;
	}
	public BigInteger getCountJulWc() {
		return countJulWc;
	}
	public void setCountJulWc(BigInteger countJulWc) {
		this.countJulWc = countJulWc;
	}
	public BigInteger getCountJulWca() {
		return countJulWca;
	}
	public void setCountJulWca(BigInteger countJulWca) {
		this.countJulWca = countJulWca;
	}
	public BigInteger getCountJulWoc() {
		return countJulWoc;
	}
	public void setCountJulWoc(BigInteger countJulWoc) {
		this.countJulWoc = countJulWoc;
	}
	public BigInteger getCountOctUht() {
		return countOctUht;
	}
	public void setCountOctUht(BigInteger countOctUht) {
		this.countOctUht = countOctUht;
	}
	public BigInteger getCountOctWc() {
		return countOctWc;
	}
	public void setCountOctWc(BigInteger countOctWc) {
		this.countOctWc = countOctWc;
	}
	public BigInteger getCountOctWca() {
		return countOctWca;
	}
	public void setCountOctWca(BigInteger countOctWca) {
		this.countOctWca = countOctWca;
	}
	public BigInteger getCountOctWoc() {
		return countOctWoc;
	}
	public void setCountOctWoc(BigInteger countOctWoc) {
		this.countOctWoc = countOctWoc;
	}
	public BigInteger getNpAdultsTot() {
		return npAdultsTot;
	}
	public void setNpAdultsTot(BigInteger npAdultsTot) {
		this.npAdultsTot = npAdultsTot;
	}
	public BigInteger getNpAdultsUhtTot() {
		return npAdultsUhtTot;
	}
	public void setNpAdultsUhtTot(BigInteger npAdultsUhtTot) {
		this.npAdultsUhtTot = npAdultsUhtTot;
	}
	public BigInteger getNpAdultsWcTot() {
		return npAdultsWcTot;
	}
	public void setNpAdultsWcTot(BigInteger npAdultsWcTot) {
		this.npAdultsWcTot = npAdultsWcTot;
	}
	public BigInteger getNpAdultsWcaTot() {
		return npAdultsWcaTot;
	}
	public void setNpAdultsWcaTot(BigInteger npAdultsWcaTot) {
		this.npAdultsWcaTot = npAdultsWcaTot;
	}
	public BigInteger getNpAdultsWocTot() {
		return npAdultsWocTot;
	}
	public void setNpAdultsWocTot(BigInteger npAdultsWocTot) {
		this.npAdultsWocTot = npAdultsWocTot;
	}
	public BigInteger getNpChildTot() {
		return npChildTot;
	}
	public void setNpChildTot(BigInteger npChildTot) {
		this.npChildTot = npChildTot;
	}
	public BigInteger getNpChildUhtTot() {
		return npChildUhtTot;
	}
	public void setNpChildUhtTot(BigInteger npChildUhtTot) {
		this.npChildUhtTot = npChildUhtTot;
	}
	public BigInteger getNpChildWcTot() {
		return npChildWcTot;
	}
	public void setNpChildWcTot(BigInteger npChildWcTot) {
		this.npChildWcTot = npChildWcTot;
	}
	public BigInteger getNpChildWcaTot() {
		return npChildWcaTot;
	}
	public void setNpChildWcaTot(BigInteger npChildWcaTot) {
		this.npChildWcaTot = npChildWcaTot;
	}
	public BigInteger getNpChildWocTot() {
		return npChildWocTot;
	}
	public void setNpChildWocTot(BigInteger npChildWocTot) {
		this.npChildWocTot = npChildWocTot;
	}
	public BigInteger getNpDkrTot() {
		return npDkrTot;
	}
	public void setNpDkrTot(BigInteger npDkrTot) {
		this.npDkrTot = npDkrTot;
	}
	public BigInteger getNpDkrUhtTot() {
		return npDkrUhtTot;
	}
	public void setNpDkrUhtTot(BigInteger npDkrUhtTot) {
		this.npDkrUhtTot = npDkrUhtTot;
	}
	public BigInteger getNpDkrWcTot() {
		return npDkrWcTot;
	}
	public void setNpDkrWcTot(BigInteger npDkrWcTot) {
		this.npDkrWcTot = npDkrWcTot;
	}
	public BigInteger getNpDkrWcsTot() {
		return npDkrWcsTot;
	}
	public void setNpDkrWcsTot(BigInteger npDkrWcsTot) {
		this.npDkrWcsTot = npDkrWcsTot;
	}
	public BigInteger getNpDkrWocTot() {
		return npDkrWocTot;
	}
	public void setNpDkrWocTot(BigInteger npDkrWocTot) {
		this.npDkrWocTot = npDkrWocTot;
	}
	public BigInteger getNpMiTot() {
		return npMiTot;
	}
	public void setNpMiTot(BigInteger npMiTot) {
		this.npMiTot = npMiTot;
	}
	public BigInteger getNpMiUhtTot() {
		return npMiUhtTot;
	}
	public void setNpMiUhtTot(BigInteger npMiUhtTot) {
		this.npMiUhtTot = npMiUhtTot;
	}
	public BigInteger getNpMiWcTot() {
		return npMiWcTot;
	}
	public void setNpMiWcTot(BigInteger npMiWcTot) {
		this.npMiWcTot = npMiWcTot;
	}
	public BigInteger getNpMiWcaTot() {
		return npMiWcaTot;
	}
	public void setNpMiWcaTot(BigInteger npMiWcaTot) {
		this.npMiWcaTot = npMiWcaTot;
	}
	public BigInteger getNpMiWocTot() {
		return npMiWocTot;
	}
	public void setNpMiWocTot(BigInteger npMiWocTot) {
		this.npMiWocTot = npMiWocTot;
	}
	public BigInteger getNpTotSum() {
		return npTotSum;
	}
	public void setNpTotSum(BigInteger npTotSum) {
		this.npTotSum = npTotSum;
	}
	public BigInteger getNpWcSum() {
		return npWcSum;
	}
	public void setNpWcSum(BigInteger npWcSum) {
		this.npWcSum = npWcSum;
	}
	public BigInteger getNpWCASum() {
		return npWCASum;
	}
	public void setNpWCASum(BigInteger npWCASum) {
		this.npWCASum = npWCASum;
	}
	public BigInteger getNpWOCSum() {
		return npWOCSum;
	}
	public void setNpWOCSum(BigInteger npWOCSum) {
		this.npWOCSum = npWOCSum;
	}
	public BigInteger getNpUHTSum() {
		return npUHTSum;
	}
	public void setNpUHTSum(BigInteger npUHTSum) {
		this.npUHTSum = npUHTSum;
	}
	
	public BigInteger getCountJanTotal() {
		return countJanTotal;
	}
	public void setCountJanTotal(BigInteger countJanTotal) {
		this.countJanTotal = countJanTotal;
	}
	public BigInteger getCountAprTotal() {
		return countAprTotal;
	}
	public void setCountAprTotal(BigInteger countAprTotal) {
		this.countAprTotal = countAprTotal;
	}
	public BigInteger getCountJulTotal() {
		return countJulTotal;
	}
	public void setCountJulTotal(BigInteger countJulTotal) {
		this.countJulTotal = countJulTotal;
	}
	public BigInteger getCountOctTotal() {
		return countOctTotal;
	}
	public void setCountOctTotal(BigInteger countOctTotal) {
		this.countOctTotal = countOctTotal;
	}
	/*public List<Q07a_HouseholdsServed> getQ07aHouseholdsServed() {
		return q07aHouseholdsServed;
	}
	public void setQ07aHouseholdsServed(
			List<Q07a_HouseholdsServed> q07aHouseholdsServed) {
		this.q07aHouseholdsServed = q07aHouseholdsServed;
	}*/
	
	/** 
	 * Getter Setter for Q07a_HouseholdsServed Table -- Starts
	 **/
	public BigInteger getOverAllTotHouseHolds() {
		return overAllTotHouseHolds;
	}
	public void setOverAllTotHouseHolds(BigInteger overAllTotHouseHolds) {
		this.overAllTotHouseHolds = overAllTotHouseHolds;
	}
	public BigInteger getTotHhWithoutChild() {
		return totHhWithoutChild;
	}
	public void setTotHhWithoutChild(BigInteger totHhWithoutChild) {
		this.totHhWithoutChild = totHhWithoutChild;
	}
	public BigInteger getTotHhWithChildAndAdults() {
		return totHhWithChildAndAdults;
	}
	public void setTotHhWithChildAndAdults(BigInteger totHhWithChildAndAdults) {
		this.totHhWithChildAndAdults = totHhWithChildAndAdults;
	}
	public BigInteger getTotHhWothOnlyChild() {
		return totHhWothOnlyChild;
	}
	public void setTotHhWothOnlyChild(BigInteger totHhWothOnlyChild) {
		this.totHhWothOnlyChild = totHhWothOnlyChild;
	}
	public BigInteger getTotHhUnknownHhType() {
		return totHhUnknownHhType;
	}
	public void setTotHhUnknownHhType(BigInteger totHhUnknownHhType) {
		this.totHhUnknownHhType = totHhUnknownHhType;
	}
	/** 
	 * Getter Setter for Q07a_HouseholdsServed Table -- Ends
	 **/
	
	/** 
	 * Getter Setter for Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Starts
	 **/
	
	public BigInteger getHhJanTotal() {
		return hhJanTotal;
	}
	public void setHhJanTotal(BigInteger hhJanTotal) {
		this.hhJanTotal = hhJanTotal;
	}
	public BigInteger getHhAprTotal() {
		return hhAprTotal;
	}
	public void setHhAprTotal(BigInteger hhAprTotal) {
		this.hhAprTotal = hhAprTotal;
	}
	public BigInteger getHhJulTotal() {
		return hhJulTotal;
	}
	public void setHhJulTotal(BigInteger hhJulTotal) {
		this.hhJulTotal = hhJulTotal;
	}
	public BigInteger getHhOctTotal() {
		return hhOctTotal;
	}
	public void setHhOctTotal(BigInteger hhOctTotal) {
		this.hhOctTotal = hhOctTotal;
	}
	public BigInteger getHhCountJanWc() {
		return hhCountJanWc;
	}
	public void setHhCountJanWc(BigInteger hhCountJanWc) {
		this.hhCountJanWc = hhCountJanWc;
	}
	public BigInteger getHhCountJanWca() {
		return hhCountJanWca;
	}
	public void setHhCountJanWca(BigInteger hhCountJanWca) {
		this.hhCountJanWca = hhCountJanWca;
	}
	public BigInteger getHhCountJanWoc() {
		return hhCountJanWoc;
	}
	public void setHhCountJanWoc(BigInteger hhCountJanWoc) {
		this.hhCountJanWoc = hhCountJanWoc;
	}
	public BigInteger getHhCountJanUht() {
		return hhCountJanUht;
	}
	public void setHhCountJanUht(BigInteger hhCountJanUht) {
		this.hhCountJanUht = hhCountJanUht;
	}
	public BigInteger getHhCountAprWc() {
		return hhCountAprWc;
	}
	public void setHhCountAprWc(BigInteger hhCountAprWc) {
		this.hhCountAprWc = hhCountAprWc;
	}
	public BigInteger getHhCountAprWca() {
		return hhCountAprWca;
	}
	public void setHhCountAprWca(BigInteger hhCountAprWca) {
		this.hhCountAprWca = hhCountAprWca;
	}
	public BigInteger getHhCountAprWoc() {
		return hhCountAprWoc;
	}
	public void setHhCountAprWoc(BigInteger hhCountAprWoc) {
		this.hhCountAprWoc = hhCountAprWoc;
	}
	public BigInteger getHhCountAprUht() {
		return hhCountAprUht;
	}
	public void setHhCountAprUht(BigInteger hhCountAprUht) {
		this.hhCountAprUht = hhCountAprUht;
	}
	public BigInteger getHhCountJulWc() {
		return hhCountJulWc;
	}
	public void setHhCountJulWc(BigInteger hhCountJulWc) {
		this.hhCountJulWc = hhCountJulWc;
	}
	public BigInteger getHhCountJulWca() {
		return hhCountJulWca;
	}
	public void setHhCountJulWca(BigInteger hhCountJulWca) {
		this.hhCountJulWca = hhCountJulWca;
	}
	public BigInteger getHhCountJulWoc() {
		return hhCountJulWoc;
	}
	public void setHhCountJulWoc(BigInteger hhCountJulWoc) {
		this.hhCountJulWoc = hhCountJulWoc;
	}
	public BigInteger getHhCountJulUht() {
		return hhCountJulUht;
	}
	public void setHhCountJulUht(BigInteger hhCountJulUht) {
		this.hhCountJulUht = hhCountJulUht;
	}
	public BigInteger getHhCountOctWc() {
		return hhCountOctWc;
	}
	public void setHhCountOctWc(BigInteger hhCountOctWc) {
		this.hhCountOctWc = hhCountOctWc;
	}
	public BigInteger getHhCountOctWca() {
		return hhCountOctWca;
	}
	public void setHhCountOctWca(BigInteger hhCountOctWca) {
		this.hhCountOctWca = hhCountOctWca;
	}
	public BigInteger getHhCountOctWoc() {
		return hhCountOctWoc;
	}
	public void setHhCountOctWoc(BigInteger hhCountOctWoc) {
		this.hhCountOctWoc = hhCountOctWoc;
	}
	public BigInteger getHhCountOctUht() {
		return hhCountOctUht;
	}
	public void setHhCountOctUht(BigInteger hhCountOctUht) {
		this.hhCountOctUht = hhCountOctUht;
	}
	/** 
	 * Getter Setter for Q07b: Point-in-Time Count of Households on the Last Wednesday Table -- Ends
	 **/
	
	/** 
	 * Getter Setter for Q09a: Number of Persons Contacted Table -- Starts
	 **/
	public BigInteger getTotContactedOnce() {
		return totContactedOnce;
	}
	public void setTotContactedOnce(BigInteger totContactedOnce) {
		this.totContactedOnce = totContactedOnce;
	}
	public BigInteger getTotContacted2to5Times() {
		return totContacted2to5Times;
	}
	public void setTotContacted2to5Times(BigInteger totContacted2to5Times) {
		this.totContacted2to5Times = totContacted2to5Times;
	}
	public BigInteger getTotContacted6to9Times() {
		return totContacted6to9Times;
	}
	public void setTotContacted6to9Times(BigInteger totContacted6to9Times) {
		this.totContacted6to9Times = totContacted6to9Times;
	}
	public BigInteger getTotContacted10orMore() {
		return totContacted10orMore;
	}
	public void setTotContacted10orMore(BigInteger totContacted10orMore) {
		this.totContacted10orMore = totContacted10orMore;
	}
	public BigInteger getTotPersonsContacted() {
		return totPersonsContacted;
	}
	public void setTotPersonsContacted(BigInteger totPersonsContacted) {
		this.totPersonsContacted = totPersonsContacted;
	}
	public BigInteger getCoFirstContactHumanHabitation() {
		return coFirstContactHumanHabitation;
	}
	public void setCoFirstContactHumanHabitation(
			BigInteger coFirstContactHumanHabitation) {
		this.coFirstContactHumanHabitation = coFirstContactHumanHabitation;
	}
	public BigInteger getCoFirstContactNRSS() {
		return coFirstContactNRSS;
	}
	public void setCoFirstContactNRSS(BigInteger coFirstContactNRSS) {
		this.coFirstContactNRSS = coFirstContactNRSS;
	}
	public BigInteger getCoFirstContactRSS() {
		return coFirstContactRSS;
	}
	public void setCoFirstContactRSS(BigInteger coFirstContactRSS) {
		this.coFirstContactRSS = coFirstContactRSS;
	}
	public BigInteger getCoFirstContactPlaceMissing() {
		return coFirstContactPlaceMissing;
	}
	public void setCoFirstContactPlaceMissing(BigInteger coFirstContactPlaceMissing) {
		this.coFirstContactPlaceMissing = coFirstContactPlaceMissing;
	}
	public BigInteger getC2to5FirstContactedHumanHabitation() {
		return c2to5FirstContactedHumanHabitation;
	}
	public void setC2to5FirstContactedHumanHabitation(
			BigInteger c2to5FirstContactedHumanHabitation) {
		this.c2to5FirstContactedHumanHabitation = c2to5FirstContactedHumanHabitation;
	}
	public BigInteger getC2to5FirstContactedNRSS() {
		return c2to5FirstContactedNRSS;
	}
	public void setC2to5FirstContactedNRSS(BigInteger c2to5FirstContactedNRSS) {
		this.c2to5FirstContactedNRSS = c2to5FirstContactedNRSS;
	}
	public BigInteger getC2to5FirstContactedRSS() {
		return c2to5FirstContactedRSS;
	}
	public void setC2to5FirstContactedRSS(BigInteger c2to5FirstContactedRSS) {
		this.c2to5FirstContactedRSS = c2to5FirstContactedRSS;
	}
	public BigInteger getC2to5FirstContactedPlaceMissing() {
		return c2to5FirstContactedPlaceMissing;
	}
	public void setC2to5FirstContactedPlaceMissing(
			BigInteger c2to5FirstContactedPlaceMissing) {
		this.c2to5FirstContactedPlaceMissing = c2to5FirstContactedPlaceMissing;
	}
	public BigInteger getC6to9FirstContactedHumanHabitation() {
		return c6to9FirstContactedHumanHabitation;
	}
	public void setC6to9FirstContactedHumanHabitation(
			BigInteger c6to9FirstContactedHumanHabitation) {
		this.c6to9FirstContactedHumanHabitation = c6to9FirstContactedHumanHabitation;
	}
	public BigInteger getC6to9FirstContactedNRSS() {
		return c6to9FirstContactedNRSS;
	}
	public void setC6to9FirstContactedNRSS(BigInteger c6to9FirstContactedNRSS) {
		this.c6to9FirstContactedNRSS = c6to9FirstContactedNRSS;
	}
	public BigInteger getC6to9FirstContactedRSS() {
		return c6to9FirstContactedRSS;
	}
	public void setC6to9FirstContactedRSS(BigInteger c6to9FirstContactedRSS) {
		this.c6to9FirstContactedRSS = c6to9FirstContactedRSS;
	}
	public BigInteger getC6to9FirstContactedPlaceMissing() {
		return c6to9FirstContactedPlaceMissing;
	}
	public void setC6to9FirstContactedPlaceMissing(
			BigInteger c6to9FirstContactedPlaceMissing) {
		this.c6to9FirstContactedPlaceMissing = c6to9FirstContactedPlaceMissing;
	}
	public BigInteger getC10orMoreFirstContactedHumanHabitation() {
		return c10orMoreFirstContactedHumanHabitation;
	}
	public void setC10orMoreFirstContactedHumanHabitation(
			BigInteger c10orMoreFirstContactedHumanHabitation) {
		this.c10orMoreFirstContactedHumanHabitation = c10orMoreFirstContactedHumanHabitation;
	}
	public BigInteger getC10orMoreFirstContactedNRSS() {
		return c10orMoreFirstContactedNRSS;
	}
	public void setC10orMoreFirstContactedNRSS(
			BigInteger c10orMoreFirstContactedNRSS) {
		this.c10orMoreFirstContactedNRSS = c10orMoreFirstContactedNRSS;
	}
	public BigInteger getC10orMoreFirstContactedRSS() {
		return c10orMoreFirstContactedRSS;
	}
	public void setC10orMoreFirstContactedRSS(BigInteger c10orMoreFirstContactedRSS) {
		this.c10orMoreFirstContactedRSS = c10orMoreFirstContactedRSS;
	}
	public BigInteger getC10orMoreFirstContactedPlaceMissing() {
		return c10orMoreFirstContactedPlaceMissing;
	}
	public void setC10orMoreFirstContactedPlaceMissing(
			BigInteger c10orMoreFirstContactedPlaceMissing) {
		this.c10orMoreFirstContactedPlaceMissing = c10orMoreFirstContactedPlaceMissing;
	}
	public BigInteger getTpcFirstContactedHumanHabitation() {
		return tpcFirstContactedHumanHabitation;
	}
	public void setTpcFirstContactedHumanHabitation(
			BigInteger tpcFirstContactedHumanHabitation) {
		this.tpcFirstContactedHumanHabitation = tpcFirstContactedHumanHabitation;
	}
	public BigInteger getTpcFirstContactedNRSS() {
		return tpcFirstContactedNRSS;
	}
	public void setTpcFirstContactedNRSS(BigInteger tpcFirstContactedNRSS) {
		this.tpcFirstContactedNRSS = tpcFirstContactedNRSS;
	}
	public BigInteger getTpcFirstContacteRSS() {
		return tpcFirstContacteRSS;
	}
	public void setTpcFirstContacteRSS(BigInteger tpcFirstContacteRSS) {
		this.tpcFirstContacteRSS = tpcFirstContacteRSS;
	}
	public BigInteger getTpcFirstContactedPlaceMissing() {
		return tpcFirstContactedPlaceMissing;
	}
	public void setTpcFirstContactedPlaceMissing(
			BigInteger tpcFirstContactedPlaceMissing) {
		this.tpcFirstContactedPlaceMissing = tpcFirstContactedPlaceMissing;
	}	
	/** 
	 * Getter Setter for "Q09b: Number of Persons Engaged" Table -- Starts
	 **/
		
	public BigInteger getTotEngagedAfter1Contract() {
		return totEngagedAfter1Contract;
	}
	public void setTotEngagedAfter1Contract(BigInteger totEngagedAfter1Contract) {
		this.totEngagedAfter1Contract = totEngagedAfter1Contract;
	}
	public BigInteger getTotEngagedAfter2to5Contract() {
		return totEngagedAfter2to5Contract;
	}
	public void setTotEngagedAfter2to5Contract(
			BigInteger totEngagedAfter2to5Contract) {
		this.totEngagedAfter2to5Contract = totEngagedAfter2to5Contract;
	}
	public BigInteger getTotEngagedAfter6to9Contract() {
		return totEngagedAfter6to9Contract;
	}
	public void setTotEngagedAfter6to9Contract(
			BigInteger totEngagedAfter6to9Contract) {
		this.totEngagedAfter6to9Contract = totEngagedAfter6to9Contract;
	}
	public BigInteger getTotEngagedAfter10orMoreContract() {
		return totEngagedAfter10orMoreContract;
	}
	public void setTotEngagedAfter10orMoreContract(
			BigInteger totEngagedAfter10orMoreContract) {
		this.totEngagedAfter10orMoreContract = totEngagedAfter10orMoreContract;
	}
	public BigInteger getTotPersonsEngaged() {
		return totPersonsEngaged;
	}
	public void setTotPersonsEngaged(BigInteger totPersonsEngaged) {
		this.totPersonsEngaged = totPersonsEngaged;
	}
	public BigInteger getTotRateOfEngagement() {
		return totRateOfEngagement;
	}
	public void setTotRateOfEngagement(BigInteger totRateOfEngagement) {
		this.totRateOfEngagement = totRateOfEngagement;
	}
	public BigInteger getEngFirstContactHumanHabitation() {
		return engFirstContactHumanHabitation;
	}
	public void setEngFirstContactHumanHabitation(
			BigInteger engFirstContactHumanHabitation) {
		this.engFirstContactHumanHabitation = engFirstContactHumanHabitation;
	}
	public BigInteger getEngFirstContactNRSS() {
		return engFirstContactNRSS;
	}
	public void setEngFirstContactNRSS(BigInteger engFirstContactNRSS) {
		this.engFirstContactNRSS = engFirstContactNRSS;
	}
	public BigInteger getEngFirstContactRSS() {
		return engFirstContactRSS;
	}
	public void setEngFirstContactRSS(BigInteger engFirstContactRSS) {
		this.engFirstContactRSS = engFirstContactRSS;
	}
	public BigInteger getEngFirstContactPlaceMissing() {
		return engFirstContactPlaceMissing;
	}
	public void setEngFirstContactPlaceMissing(
			BigInteger engFirstContactPlaceMissing) {
		this.engFirstContactPlaceMissing = engFirstContactPlaceMissing;
	}
	public BigInteger getEng2to5FirstContactHumanHabitation() {
		return eng2to5FirstContactHumanHabitation;
	}
	public void setEng2to5FirstContactHumanHabitation(
			BigInteger eng2to5FirstContactHumanHabitation) {
		this.eng2to5FirstContactHumanHabitation = eng2to5FirstContactHumanHabitation;
	}
	public BigInteger getEng2to5FirstContactNRSS() {
		return eng2to5FirstContactNRSS;
	}
	public void setEng2to5FirstContactNRSS(BigInteger eng2to5FirstContactNRSS) {
		this.eng2to5FirstContactNRSS = eng2to5FirstContactNRSS;
	}
	public BigInteger getEng2to5FirstContactRSS() {
		return eng2to5FirstContactRSS;
	}
	public void setEng2to5FirstContactRSS(BigInteger eng2to5FirstContactRSS) {
		this.eng2to5FirstContactRSS = eng2to5FirstContactRSS;
	}
	public BigInteger getEng2to5FirstContactPlaceMissing() {
		return eng2to5FirstContactPlaceMissing;
	}
	public void setEng2to5FirstContactPlaceMissing(
			BigInteger eng2to5FirstContactPlaceMissing) {
		this.eng2to5FirstContactPlaceMissing = eng2to5FirstContactPlaceMissing;
	}
	public BigInteger getEng6to9FirstContactHumanHabitation() {
		return eng6to9FirstContactHumanHabitation;
	}
	public void setEng6to9FirstContactHumanHabitation(
			BigInteger eng6to9FirstContactHumanHabitation) {
		this.eng6to9FirstContactHumanHabitation = eng6to9FirstContactHumanHabitation;
	}
	public BigInteger getEng6to9FirstContactNRSS() {
		return eng6to9FirstContactNRSS;
	}
	public void setEng6to9FirstContactNRSS(BigInteger eng6to9FirstContactNRSS) {
		this.eng6to9FirstContactNRSS = eng6to9FirstContactNRSS;
	}
	public BigInteger getEng6to9FirstContactRSS() {
		return eng6to9FirstContactRSS;
	}
	public void setEng6to9FirstContactRSS(BigInteger eng6to9FirstContactRSS) {
		this.eng6to9FirstContactRSS = eng6to9FirstContactRSS;
	}
	public BigInteger getEng6to9FirstContactPlaceMissing() {
		return eng6to9FirstContactPlaceMissing;
	}
	public void setEng6to9FirstContactPlaceMissing(
			BigInteger eng6to9FirstContactPlaceMissing) {
		this.eng6to9FirstContactPlaceMissing = eng6to9FirstContactPlaceMissing;
	}
	public BigInteger getEng10FirstContactHumanHabitation() {
		return eng10FirstContactHumanHabitation;
	}
	public void setEng10FirstContactHumanHabitation(
			BigInteger eng10FirstContactHumanHabitation) {
		this.eng10FirstContactHumanHabitation = eng10FirstContactHumanHabitation;
	}
	public BigInteger getEng10FirstContactNRSS() {
		return eng10FirstContactNRSS;
	}
	public void setEng10FirstContactNRSS(BigInteger eng10FirstContactNRSS) {
		this.eng10FirstContactNRSS = eng10FirstContactNRSS;
	}
	public BigInteger getEng10FirstContactRSS() {
		return eng10FirstContactRSS;
	}
	public void setEng10FirstContactRSS(BigInteger eng10FirstContactRSS) {
		this.eng10FirstContactRSS = eng10FirstContactRSS;
	}
	public BigInteger getEng10FirstContactPlaceMissing() {
		return eng10FirstContactPlaceMissing;
	}
	public void setEng10FirstContactPlaceMissing(
			BigInteger eng10FirstContactPlaceMissing) {
		this.eng10FirstContactPlaceMissing = eng10FirstContactPlaceMissing;
	}
	public BigInteger getTpeFirstContactHumanHabitation() {
		return tpeFirstContactHumanHabitation;
	}
	public void setTpeFirstContactHumanHabitation(
			BigInteger tpeFirstContactHumanHabitation) {
		this.tpeFirstContactHumanHabitation = tpeFirstContactHumanHabitation;
	}
	public BigInteger getTpeFirstContactNRSS() {
		return tpeFirstContactNRSS;
	}
	public void setTpeFirstContactNRSS(BigInteger tpeFirstContactNRSS) {
		this.tpeFirstContactNRSS = tpeFirstContactNRSS;
	}
	public BigInteger getTpeFirstContactRSS() {
		return tpeFirstContactRSS;
	}
	public void setTpeFirstContactRSS(BigInteger tpeFirstContactRSS) {
		this.tpeFirstContactRSS = tpeFirstContactRSS;
	}
	public BigInteger getTpeFirstContactPlaceMissing() {
		return tpeFirstContactPlaceMissing;
	}
	public void setTpeFirstContactPlaceMissing(
			BigInteger tpeFirstContactPlaceMissing) {
		this.tpeFirstContactPlaceMissing = tpeFirstContactPlaceMissing;
	}
	public BigInteger getRoeFirstContactHumanHabitation() {
		return roeFirstContactHumanHabitation;
	}
	public void setRoeFirstContactHumanHabitation(
			BigInteger roeFirstContactHumanHabitation) {
		this.roeFirstContactHumanHabitation = roeFirstContactHumanHabitation;
	}
	public BigInteger getRoeFirstContactNRSS() {
		return roeFirstContactNRSS;
	}
	public void setRoeFirstContactNRSS(BigInteger roeFirstContactNRSS) {
		this.roeFirstContactNRSS = roeFirstContactNRSS;
	}
	public BigInteger getRoeFirstContactRSS() {
		return roeFirstContactRSS;
	}
	public void setRoeFirstContactRSS(BigInteger roeFirstContactRSS) {
		this.roeFirstContactRSS = roeFirstContactRSS;
	}
	public BigInteger getRoeFirstContactPlaceMissing() {
		return roeFirstContactPlaceMissing;
	}
	public void setRoeFirstContactPlaceMissing(
			BigInteger roeFirstContactPlaceMissing) {
		this.roeFirstContactPlaceMissing = roeFirstContactPlaceMissing;
	}
	/** 
	 * Getter Setter for "Q09b: Number of Persons Engaged" Table --Ends 
	 **/
	/** 
	 * Getter Setter for "Q10a: Gender of Adults" Table -- Starts
	 **/
	public BigInteger getTotMale() {
		return totMale;
	}
	public void setTotMale(BigInteger totMale) {
		this.totMale = totMale;
	}
	public BigInteger getTotFemale() {
		return totFemale;
	}
	public void setTotFemale(BigInteger totFemale) {
		this.totFemale = totFemale;
	}
	public BigInteger getTotTransgenderMF() {
		return totTransgenderMF;
	}
	public void setTotTransgenderMF(BigInteger totTransgenderMF) {
		this.totTransgenderMF = totTransgenderMF;
	}
	public BigInteger getTotOther() {
		return totOther;
	}
	public void setTotOther(BigInteger totOther) {
		this.totOther = totOther;
	}
	public BigInteger getTotDontKnowRefused() {
		return totDontKnowRefused;
	}
	public void setTotDontKnowRefused(BigInteger totDontKnowRefused) {
		this.totDontKnowRefused = totDontKnowRefused;
	}
	public BigInteger getTotInfoMissing() {
		return totInfoMissing;
	}
	public void setTotInfoMissing(BigInteger totInfoMissing) {
		this.totInfoMissing = totInfoMissing;
	}
	public BigInteger getTotSubtotal() {
		return totSubtotal;
	}
	public void setTotSubtotal(BigInteger totSubtotal) {
		this.totSubtotal = totSubtotal;
	}
	public BigInteger getMaleWOC() {
		return maleWOC;
	}
	public void setMaleWOC(BigInteger maleWOC) {
		this.maleWOC = maleWOC;
	}
	public BigInteger getMaleWCA() {
		return maleWCA;
	}
	public void setMaleWCA(BigInteger maleWCA) {
		this.maleWCA = maleWCA;
	}
	public BigInteger getMaleUHHT() {
		return maleUHHT;
	}
	public void setMaleUHHT(BigInteger maleUHHT) {
		this.maleUHHT = maleUHHT;
	}
	public BigInteger getFemaleWOC() {
		return femaleWOC;
	}
	public void setFemaleWOC(BigInteger femaleWOC) {
		this.femaleWOC = femaleWOC;
	}
	public BigInteger getFemaleWCA() {
		return femaleWCA;
	}
	public void setFemaleWCA(BigInteger femaleWCA) {
		this.femaleWCA = femaleWCA;
	}
	public BigInteger getFemaleUHHT() {
		return femaleUHHT;
	}
	public void setFemaleUHHT(BigInteger femaleUHHT) {
		this.femaleUHHT = femaleUHHT;
	}
	public BigInteger getTransgenderMFWOC() {
		return transgenderMFWOC;
	}
	public void setTransgenderMFWOC(BigInteger transgenderMFWOC) {
		this.transgenderMFWOC = transgenderMFWOC;
	}
	public BigInteger getTransgenderMFWCA() {
		return transgenderMFWCA;
	}
	public void setTransgenderMFWCA(BigInteger transgenderMFWCA) {
		this.transgenderMFWCA = transgenderMFWCA;
	}
	public BigInteger getTransgenderMFUHHT() {
		return transgenderMFUHHT;
	}
	public void setTransgenderMFUHHT(BigInteger transgenderMFUHHT) {
		this.transgenderMFUHHT = transgenderMFUHHT;
	}
	public BigInteger getOtherWOC() {
		return otherWOC;
	}
	public void setOtherWOC(BigInteger otherWOC) {
		this.otherWOC = otherWOC;
	}
	public BigInteger getOtherWCA() {
		return otherWCA;
	}
	public void setOtherWCA(BigInteger otherWCA) {
		this.otherWCA = otherWCA;
	}
	public BigInteger getOtherUHHT() {
		return otherUHHT;
	}
	public void setOtherUHHT(BigInteger otherUHHT) {
		this.otherUHHT = otherUHHT;
	}
	public BigInteger getDkrWOC() {
		return dkrWOC;
	}
	public void setDkrWOC(BigInteger dkrWOC) {
		this.dkrWOC = dkrWOC;
	}
	public BigInteger getDkrWCA() {
		return dkrWCA;
	}
	public void setDkrWCA(BigInteger dkrWCA) {
		this.dkrWCA = dkrWCA;
	}
	public BigInteger getDkrUHHT() {
		return dkrUHHT;
	}
	public void setDkrUHHT(BigInteger dkrUHHT) {
		this.dkrUHHT = dkrUHHT;
	}
	public BigInteger getInfomiisingWOC() {
		return infomiisingWOC;
	}
	public void setInfomiisingWOC(BigInteger infomiisingWOC) {
		this.infomiisingWOC = infomiisingWOC;
	}
	public BigInteger getInfomiisingWCA() {
		return infomiisingWCA;
	}
	public void setInfomiisingWCA(BigInteger infomiisingWCA) {
		this.infomiisingWCA = infomiisingWCA;
	}
	public BigInteger getInfomiisingUHHT() {
		return infomiisingUHHT;
	}
	public void setInfomiisingUHHT(BigInteger infomiisingUHHT) {
		this.infomiisingUHHT = infomiisingUHHT;
	}
	public BigInteger getSubtotalWOC() {
		return subtotalWOC;
	}
	public void setSubtotalWOC(BigInteger subtotalWOC) {
		this.subtotalWOC = subtotalWOC;
	}
	public BigInteger getSubtotalWCA() {
		return subtotalWCA;
	}
	public void setSubtotalWCA(BigInteger subtotalWCA) {
		this.subtotalWCA = subtotalWCA;
	}
	public BigInteger getSubtotalUHHT() {
		return subtotalUHHT;
	}
	public void setSubtotalUHHT(BigInteger subtotalUHHT) {
		this.subtotalUHHT = subtotalUHHT;
	}
	public BigInteger getTotTransgenderFM() {
		return totTransgenderFM;
	}
	public void setTotTransgenderFM(BigInteger totTransgenderFM) {
		this.totTransgenderFM = totTransgenderFM;
	}
	public BigInteger getTransgenderFMWOC() {
		return transgenderFMWOC;
	}
	public void setTransgenderFMWOC(BigInteger transgenderFMWOC) {
		this.transgenderFMWOC = transgenderFMWOC;
	}
	public BigInteger getTransgenderFMWCA() {
		return transgenderFMWCA;
	}
	public void setTransgenderFMWCA(BigInteger transgenderFMWCA) {
		this.transgenderFMWCA = transgenderFMWCA;
	}
	public BigInteger getTransgenderFMUHHT() {
		return transgenderFMUHHT;
	}
	public void setTransgenderFMUHHT(BigInteger transgenderFMUHHT) {
		this.transgenderFMUHHT = transgenderFMUHHT;
	}
	/** 
	 * Getter Setter for "Q10a: Gender of Adults" Table -- Ends
	 **/
	
	/** 
	 * Getter Setter for "Q10b: Gender of Children" Table -- Starts
	 **/
	public BigInteger getTotChildMale() {
		return totChildMale;
	}
	public void setTotChildMale(BigInteger totChildMale) {
		this.totChildMale = totChildMale;
	}
	public BigInteger getTotChildFemale() {
		return totChildFemale;
	}
	public void setTotChildFemale(BigInteger totChildFemale) {
		this.totChildFemale = totChildFemale;
	}
	public BigInteger getTotChildTransgenderMF() {
		return totChildTransgenderMF;
	}
	public void setTotChildTransgenderMF(BigInteger totChildTransgenderMF) {
		this.totChildTransgenderMF = totChildTransgenderMF;
	}
	public BigInteger getTotChildOther() {
		return totChildOther;
	}
	public void setTotChildOther(BigInteger totChildOther) {
		this.totChildOther = totChildOther;
	}
	public BigInteger getTotChildDontKnowRefused() {
		return totChildDontKnowRefused;
	}
	public void setTotChildDontKnowRefused(BigInteger totChildDontKnowRefused) {
		this.totChildDontKnowRefused = totChildDontKnowRefused;
	}
	public BigInteger getTotChildInfoMissing() {
		return totChildInfoMissing;
	}
	public void setTotChildInfoMissing(BigInteger totChildInfoMissing) {
		this.totChildInfoMissing = totChildInfoMissing;
	}
	public BigInteger getTotChildSubtotal() {
		return totChildSubtotal;
	}
	public void setTotChildSubtotal(BigInteger totChildSubtotal) {
		this.totChildSubtotal = totChildSubtotal;
	}
	public BigInteger getChildMaleWOC() {
		return childMaleWOC;
	}
	public void setChildMaleWOC(BigInteger childMaleWOC) {
		this.childMaleWOC = childMaleWOC;
	}
	public BigInteger getChildMaleWCA() {
		return childMaleWCA;
	}
	public void setChildMaleWCA(BigInteger childMaleWCA) {
		this.childMaleWCA = childMaleWCA;
	}
	public BigInteger getChildMaleUHHT() {
		return childMaleUHHT;
	}
	public void setChildMaleUHHT(BigInteger childMaleUHHT) {
		this.childMaleUHHT = childMaleUHHT;
	}
	public BigInteger getChildFemaleWOC() {
		return childFemaleWOC;
	}
	public void setChildFemaleWOC(BigInteger childFemaleWOC) {
		this.childFemaleWOC = childFemaleWOC;
	}
	public BigInteger getChildFemaleWCA() {
		return childFemaleWCA;
	}
	public void setChildFemaleWCA(BigInteger childFemaleWCA) {
		this.childFemaleWCA = childFemaleWCA;
	}
	public BigInteger getChildFemaleUHHT() {
		return childFemaleUHHT;
	}
	public void setChildFemaleUHHT(BigInteger childFemaleUHHT) {
		this.childFemaleUHHT = childFemaleUHHT;
	}
	public BigInteger getChildTransgenderMFWOC() {
		return childTransgenderMFWOC;
	}
	public void setChildTransgenderMFWOC(BigInteger childTransgenderMFWOC) {
		this.childTransgenderMFWOC = childTransgenderMFWOC;
	}
	public BigInteger getChildTransgenderMFWCA() {
		return childTransgenderMFWCA;
	}
	public void setChildTransgenderMFWCA(BigInteger childTransgenderMFWCA) {
		this.childTransgenderMFWCA = childTransgenderMFWCA;
	}
	public BigInteger getChildTransgenderMFUHHT() {
		return childTransgenderMFUHHT;
	}
	public void setChildTransgenderMFUHHT(BigInteger childTransgenderMFUHHT) {
		this.childTransgenderMFUHHT = childTransgenderMFUHHT;
	}
	public BigInteger getChildOtherWOC() {
		return childOtherWOC;
	}
	public void setChildOtherWOC(BigInteger childOtherWOC) {
		this.childOtherWOC = childOtherWOC;
	}
	public BigInteger getChildOtherWCA() {
		return childOtherWCA;
	}
	public void setChildOtherWCA(BigInteger childOtherWCA) {
		this.childOtherWCA = childOtherWCA;
	}
	public BigInteger getChildOtherUHHT() {
		return childOtherUHHT;
	}
	public void setChildOtherUHHT(BigInteger childOtherUHHT) {
		this.childOtherUHHT = childOtherUHHT;
	}
	public BigInteger getChildDkrWOC() {
		return childDkrWOC;
	}
	public void setChildDkrWOC(BigInteger childDkrWOC) {
		this.childDkrWOC = childDkrWOC;
	}
	public BigInteger getChildDkrWCA() {
		return childDkrWCA;
	}
	public void setChildDkrWCA(BigInteger childDkrWCA) {
		this.childDkrWCA = childDkrWCA;
	}
	public BigInteger getChildDkrUHHT() {
		return childDkrUHHT;
	}
	public void setChildDkrUHHT(BigInteger childDkrUHHT) {
		this.childDkrUHHT = childDkrUHHT;
	}
	public BigInteger getChildInfomiisingWOC() {
		return childInfomiisingWOC;
	}
	public void setChildInfomiisingWOC(BigInteger childInfomiisingWOC) {
		this.childInfomiisingWOC = childInfomiisingWOC;
	}
	public BigInteger getChildInfomiisingWCA() {
		return childInfomiisingWCA;
	}
	public void setChildInfomiisingWCA(BigInteger childInfomiisingWCA) {
		this.childInfomiisingWCA = childInfomiisingWCA;
	}
	public BigInteger getChildInfomiisingUHHT() {
		return childInfomiisingUHHT;
	}
	public void setChildInfomiisingUHHT(BigInteger childInfomiisingUHHT) {
		this.childInfomiisingUHHT = childInfomiisingUHHT;
	}
	public BigInteger getChildSubtotalWOC() {
		return childSubtotalWOC;
	}
	public void setChildSubtotalWOC(BigInteger childSubtotalWOC) {
		this.childSubtotalWOC = childSubtotalWOC;
	}
	public BigInteger getChildSubtotalWCA() {
		return childSubtotalWCA;
	}
	public void setChildSubtotalWCA(BigInteger childSubtotalWCA) {
		this.childSubtotalWCA = childSubtotalWCA;
	}
	public BigInteger getChildSubtotalUHHT() {
		return childSubtotalUHHT;
	}
	public void setChildSubtotalUHHT(BigInteger childSubtotalUHHT) {
		this.childSubtotalUHHT = childSubtotalUHHT;
	}
	public BigInteger getTotChildTransgenderFM() {
		return totChildTransgenderFM;
	}
	public void setTotChildTransgenderFM(BigInteger totChildTransgenderFM) {
		this.totChildTransgenderFM = totChildTransgenderFM;
	}
	public BigInteger getChildTransgenderFMWOC() {
		return childTransgenderFMWOC;
	}
	public void setChildTransgenderFMWOC(BigInteger childTransgenderFMWOC) {
		this.childTransgenderFMWOC = childTransgenderFMWOC;
	}
	public BigInteger getChildTransgenderFMWCA() {
		return childTransgenderFMWCA;
	}
	public void setChildTransgenderFMWCA(BigInteger childTransgenderFMWCA) {
		this.childTransgenderFMWCA = childTransgenderFMWCA;
	}
	public BigInteger getChildTransgenderFMUHHT() {
		return childTransgenderFMUHHT;
	}
	public void setChildTransgenderFMUHHT(BigInteger childTransgenderFMUHHT) {
		this.childTransgenderFMUHHT = childTransgenderFMUHHT;
	}
	/** 
	 * Getter Setter for "Q10b: Gender of Children" Table -- Ends
	 **/
	
	/** 
	 * Getter Setter for "Q10c: Gender of Persons Missing Age Information" Table -- Starts
	 **/
	public BigInteger getTotMAIMale() {
		return totMAIMale;
	}
	public void setTotMAIMale(BigInteger totMAIMale) {
		this.totMAIMale = totMAIMale;
	}
	public BigInteger getTotMAIFemale() {
		return totMAIFemale;
	}
	public void setTotMAIFemale(BigInteger totMAIFemale) {
		this.totMAIFemale = totMAIFemale;
	}
	public BigInteger getTotMAITransgenderMF() {
		return totMAITransgenderMF;
	}
	public void setTotMAITransgenderMF(BigInteger totMAITransgenderMF) {
		this.totMAITransgenderMF = totMAITransgenderMF;
	}
	public BigInteger getTotMAIOther() {
		return totMAIOther;
	}
	public void setTotMAIOther(BigInteger totMAIOther) {
		this.totMAIOther = totMAIOther;
	}
	public BigInteger getTotMAIDontKnowRefused() {
		return totMAIDontKnowRefused;
	}
	public void setTotMAIDontKnowRefused(BigInteger totMAIDontKnowRefused) {
		this.totMAIDontKnowRefused = totMAIDontKnowRefused;
	}
	public BigInteger getTotMAIInfoMissing() {
		return totMAIInfoMissing;
	}
	public void setTotMAIInfoMissing(BigInteger totMAIInfoMissing) {
		this.totMAIInfoMissing = totMAIInfoMissing;
	}
	public BigInteger getTotMAISubtotal() {
		return totMAISubtotal;
	}
	public void setTotMAISubtotal(BigInteger totMAISubtotal) {
		this.totMAISubtotal = totMAISubtotal;
	}
	public BigInteger getMaleMAIWOC() {
		return maleMAIWOC;
	}
	public void setMaleMAIWOC(BigInteger maleMAIWOC) {
		this.maleMAIWOC = maleMAIWOC;
	}
	public BigInteger getMaleMAIWCA() {
		return maleMAIWCA;
	}
	public void setMaleMAIWCA(BigInteger maleMAIWCA) {
		this.maleMAIWCA = maleMAIWCA;
	}
	public BigInteger getMaleMAIUHHT() {
		return maleMAIUHHT;
	}
	public void setMaleMAIUHHT(BigInteger maleMAIUHHT) {
		this.maleMAIUHHT = maleMAIUHHT;
	}
	public BigInteger getFemaleMAIWOC() {
		return femaleMAIWOC;
	}
	public void setFemaleMAIWOC(BigInteger femaleMAIWOC) {
		this.femaleMAIWOC = femaleMAIWOC;
	}
	public BigInteger getFemaleMAIWCA() {
		return femaleMAIWCA;
	}
	public void setFemaleMAIWCA(BigInteger femaleMAIWCA) {
		this.femaleMAIWCA = femaleMAIWCA;
	}
	public BigInteger getFemaleMAIUHHT() {
		return femaleMAIUHHT;
	}
	public void setFemaleMAIUHHT(BigInteger femaleMAIUHHT) {
		this.femaleMAIUHHT = femaleMAIUHHT;
	}
	public BigInteger getTransgenderMFMAIWOC() {
		return transgenderMFMAIWOC;
	}
	public void setTransgenderMFMAIWOC(BigInteger transgenderMFMAIWOC) {
		this.transgenderMFMAIWOC = transgenderMFMAIWOC;
	}
	public BigInteger getTransgenderMFMAIWCA() {
		return transgenderMFMAIWCA;
	}
	public void setTransgenderMFMAIWCA(BigInteger transgenderMFMAIWCA) {
		this.transgenderMFMAIWCA = transgenderMFMAIWCA;
	}
	public BigInteger getTransgenderMFMAIUHHT() {
		return transgenderMFMAIUHHT;
	}
	public void setTransgenderMFMAIUHHT(BigInteger transgenderMFMAIUHHT) {
		this.transgenderMFMAIUHHT = transgenderMFMAIUHHT;
	}
	public BigInteger getOtherMAIWOC() {
		return otherMAIWOC;
	}
	public void setOtherMAIWOC(BigInteger otherMAIWOC) {
		this.otherMAIWOC = otherMAIWOC;
	}
	public BigInteger getOtherMAIWCA() {
		return otherMAIWCA;
	}
	public void setOtherMAIWCA(BigInteger otherMAIWCA) {
		this.otherMAIWCA = otherMAIWCA;
	}
	public BigInteger getOtherMAIUHHT() {
		return otherMAIUHHT;
	}
	public void setOtherMAIUHHT(BigInteger otherMAIUHHT) {
		this.otherMAIUHHT = otherMAIUHHT;
	}
	public BigInteger getDkrMAIWOC() {
		return dkrMAIWOC;
	}
	public void setDkrMAIWOC(BigInteger dkrMAIWOC) {
		this.dkrMAIWOC = dkrMAIWOC;
	}
	public BigInteger getDkrMAIWCA() {
		return dkrMAIWCA;
	}
	public void setDkrMAIWCA(BigInteger dkrMAIWCA) {
		this.dkrMAIWCA = dkrMAIWCA;
	}
	public BigInteger getDkrMAIUHHT() {
		return dkrMAIUHHT;
	}
	public void setDkrMAIUHHT(BigInteger dkrMAIUHHT) {
		this.dkrMAIUHHT = dkrMAIUHHT;
	}
	public BigInteger getInfomissingMAIWOC() {
		return infomissingMAIWOC;
	}
	public void setInfomissingMAIWOC(BigInteger infomissingMAIWOC) {
		this.infomissingMAIWOC = infomissingMAIWOC;
	}
	public BigInteger getInfomissingMAIWCA() {
		return infomissingMAIWCA;
	}
	public void setInfomissingMAIWCA(BigInteger infomissingMAIWCA) {
		this.infomissingMAIWCA = infomissingMAIWCA;
	}
	public BigInteger getInfomissingMAIUHHT() {
		return infomissingMAIUHHT;
	}
	public void setInfomissingMAIUHHT(BigInteger infomissingMAIUHHT) {
		this.infomissingMAIUHHT = infomissingMAIUHHT;
	}
	public BigInteger getSubtotalMAIWOC() {
		return subtotalMAIWOC;
	}
	public void setSubtotalMAIWOC(BigInteger subtotalMAIWOC) {
		this.subtotalMAIWOC = subtotalMAIWOC;
	}
	public BigInteger getSubtotalMAIWCA() {
		return subtotalMAIWCA;
	}
	public void setSubtotalMAIWCA(BigInteger subtotalMAIWCA) {
		this.subtotalMAIWCA = subtotalMAIWCA;
	}
	public BigInteger getSubtotalMAIUHHT() {
		return subtotalMAIUHHT;
	}
	public void setSubtotalMAIUHHT(BigInteger subtotalMAIUHHT) {
		this.subtotalMAIUHHT = subtotalMAIUHHT;
	}
	public BigInteger getTotMAITransgenderFM() {
		return totMAITransgenderFM;
	}
	public void setTotMAITransgenderFM(BigInteger totMAITransgenderFM) {
		this.totMAITransgenderFM = totMAITransgenderFM;
	}
	public BigInteger getTransgenderFMMAIWOC() {
		return transgenderFMMAIWOC;
	}
	public void setTransgenderFMMAIWOC(BigInteger transgenderFMMAIWOC) {
		this.transgenderFMMAIWOC = transgenderFMMAIWOC;
	}
	public BigInteger getTransgenderFMMAIWCA() {
		return transgenderFMMAIWCA;
	}
	public void setTransgenderFMMAIWCA(BigInteger transgenderFMMAIWCA) {
		this.transgenderFMMAIWCA = transgenderFMMAIWCA;
	}
	public BigInteger getTransgenderFMMAIUHHT() {
		return transgenderFMMAIUHHT;
	}
	public void setTransgenderFMMAIUHHT(BigInteger transgenderFMMAIUHHT) {
		this.transgenderFMMAIUHHT = transgenderFMMAIUHHT;
	}
	public BigInteger getTransgenderFMMAIWithOnlyChild() {
		return transgenderFMMAIWithOnlyChild;
	}
	public void setTransgenderFMMAIWithOnlyChild(
			BigInteger transgenderFMMAIWithOnlyChild) {
		this.transgenderFMMAIWithOnlyChild = transgenderFMMAIWithOnlyChild;
	}
	public BigInteger getSubtotalMAIWithOnlyChild() {
		return subtotalMAIWithOnlyChild;
	}
	public void setSubtotalMAIWithOnlyChild(BigInteger subtotalMAIWithOnlyChild) {
		this.subtotalMAIWithOnlyChild = subtotalMAIWithOnlyChild;
	}
	public BigInteger getInfomissingMAIWithOnlyChild() {
		return infomissingMAIWithOnlyChild;
	}
	public void setInfomissingMAIWithOnlyChild(
			BigInteger infomissingMAIWithOnlyChild) {
		this.infomissingMAIWithOnlyChild = infomissingMAIWithOnlyChild;
	}
	public BigInteger getDkrMAIWithOnlyChild() {
		return dkrMAIWithOnlyChild;
	}
	public void setDkrMAIWithOnlyChild(BigInteger dkrMAIWithOnlyChild) {
		this.dkrMAIWithOnlyChild = dkrMAIWithOnlyChild;
	}
	public BigInteger getTransgenderMFMAIWithOnlyChild() {
		return transgenderMFMAIWithOnlyChild;
	}
	public void setTransgenderMFMAIWithOnlyChild(
			BigInteger transgenderMFMAIWithOnlyChild) {
		this.transgenderMFMAIWithOnlyChild = transgenderMFMAIWithOnlyChild;
	}
	public BigInteger getOtherMAIWithOnlyChild() {
		return otherMAIWithOnlyChild;
	}
	public void setOtherMAIWithOnlyChild(BigInteger otherMAIWithOnlyChild) {
		this.otherMAIWithOnlyChild = otherMAIWithOnlyChild;
	}
	public BigInteger getMaleMAIWithOnlyChild() {
		return maleMAIWithOnlyChild;
	}
	public void setMaleMAIWithOnlyChild(BigInteger maleMAIWithOnlyChild) {
		this.maleMAIWithOnlyChild = maleMAIWithOnlyChild;
	}
	public BigInteger getFemaleMAIWithOnlyChild() {
		return femaleMAIWithOnlyChild;
	}
	public void setFemaleMAIWithOnlyChild(BigInteger femaleMAIWithOnlyChild) {
		this.femaleMAIWithOnlyChild = femaleMAIWithOnlyChild;
	}

	/** 
	 * Getter Setter for "Q10c: Gender of Persons Missing Age Information" Table -- Starts
	 **/
	/**
	 * Getter Setter for "Q11: Age" Table -- Starts
	 * */
	public BigInteger getTotAgeUnder5() {
		return totAgeUnder5;
	}
	public void setTotAgeUnder5(BigInteger totAgeUnder5) {
		this.totAgeUnder5 = totAgeUnder5;
	}
	public BigInteger getTotAge5to12() {
		return totAge5to12;
	}
	public void setTotAge5to12(BigInteger totAge5to12) {
		this.totAge5to12 = totAge5to12;
	}
	public BigInteger getTotAge13to17() {
		return totAge13to17;
	}
	public void setTotAge13to17(BigInteger totAge13to17) {
		this.totAge13to17 = totAge13to17;
	}
	public BigInteger getTotAge18to24() {
		return totAge18to24;
	}
	public void setTotAge18to24(BigInteger totAge18to24) {
		this.totAge18to24 = totAge18to24;
	}
	public BigInteger getTotAge25to34() {
		return totAge25to34;
	}
	public void setTotAge25to34(BigInteger totAge25to34) {
		this.totAge25to34 = totAge25to34;
	}
	public BigInteger getTotAge35to44() {
		return totAge35to44;
	}
	public void setTotAge35to44(BigInteger totAge35to44) {
		this.totAge35to44 = totAge35to44;
	}
	public BigInteger getTotAge45to54() {
		return totAge45to54;
	}
	public void setTotAge45to54(BigInteger totAge45to54) {
		this.totAge45to54 = totAge45to54;
	}
	public BigInteger getTotAge55to61() {
		return totAge55to61;
	}
	public void setTotAge55to61(BigInteger totAge55to61) {
		this.totAge55to61 = totAge55to61;
	}
	public BigInteger getTotAge62Plus() {
		return totAge62Plus;
	}
	public void setTotAge62Plus(BigInteger totAge62Plus) {
		this.totAge62Plus = totAge62Plus;
	}
	public BigInteger getTotAgeDKR() {
		return totAgeDKR;
	}
	public void setTotAgeDKR(BigInteger totAgeDKR) {
		this.totAgeDKR = totAgeDKR;
	}
	public BigInteger getTotAgeInfoMissing() {
		return totAgeInfoMissing;
	}
	public void setTotAgeInfoMissing(BigInteger totAgeInfoMissing) {
		this.totAgeInfoMissing = totAgeInfoMissing;
	}
	public BigInteger getTotOverallTotal() {
		return totOverallTotal;
	}
	public void setTotOverallTotal(BigInteger totOverallTotal) {
		this.totOverallTotal = totOverallTotal;
	}
	public BigInteger getAgeUnder5WOC() {
		return ageUnder5WOC;
	}
	public void setAgeUnder5WOC(BigInteger ageUnder5WOC) {
		this.ageUnder5WOC = ageUnder5WOC;
	}
	public BigInteger getAgeUnder5WCA() {
		return ageUnder5WCA;
	}
	public void setAgeUnder5WCA(BigInteger ageUnder5WCA) {
		this.ageUnder5WCA = ageUnder5WCA;
	}
	public BigInteger getAgeUnder5WithOnlyChild() {
		return ageUnder5WithOnlyChild;
	}
	public void setAgeUnder5WithOnlyChild(BigInteger ageUnder5WithOnlyChild) {
		this.ageUnder5WithOnlyChild = ageUnder5WithOnlyChild;
	}
	public BigInteger getAgeUnder5UHHT() {
		return ageUnder5UHHT;
	}
	public void setAgeUnder5UHHT(BigInteger ageUnder5UHHT) {
		this.ageUnder5UHHT = ageUnder5UHHT;
	}
	public BigInteger getAge5to12WOC() {
		return age5to12WOC;
	}
	public void setAge5to12WOC(BigInteger age5to12woc) {
		age5to12WOC = age5to12woc;
	}
	public BigInteger getAge5to12WCA() {
		return age5to12WCA;
	}
	public void setAge5to12WCA(BigInteger age5to12wca) {
		age5to12WCA = age5to12wca;
	}
	public BigInteger getAge5to12WithOnlyChild() {
		return age5to12WithOnlyChild;
	}
	public void setAge5to12WithOnlyChild(BigInteger age5to12WithOnlyChild) {
		this.age5to12WithOnlyChild = age5to12WithOnlyChild;
	}
	public BigInteger getAge5to12UHHT() {
		return age5to12UHHT;
	}
	public void setAge5to12UHHT(BigInteger age5to12uhht) {
		age5to12UHHT = age5to12uhht;
	}
	public BigInteger getAge13to17WOC() {
		return age13to17WOC;
	}
	public void setAge13to17WOC(BigInteger age13to17woc) {
		age13to17WOC = age13to17woc;
	}
	public BigInteger getAge13to17WCA() {
		return age13to17WCA;
	}
	public void setAge13to17WCA(BigInteger age13to17wca) {
		age13to17WCA = age13to17wca;
	}
	public BigInteger getAge13to17WithOnlyChild() {
		return age13to17WithOnlyChild;
	}
	public void setAge13to17WithOnlyChild(BigInteger age13to17WithOnlyChild) {
		this.age13to17WithOnlyChild = age13to17WithOnlyChild;
	}
	public BigInteger getAge13to17UHHT() {
		return age13to17UHHT;
	}
	public void setAge13to17UHHT(BigInteger age13to17uhht) {
		age13to17UHHT = age13to17uhht;
	}
	public BigInteger getAge18to24WOC() {
		return age18to24WOC;
	}
	public void setAge18to24WOC(BigInteger age18to24woc) {
		age18to24WOC = age18to24woc;
	}
	public BigInteger getAge18to24WCA() {
		return age18to24WCA;
	}
	public void setAge18to24WCA(BigInteger age18to24wca) {
		age18to24WCA = age18to24wca;
	}
	public BigInteger getAge18to24WithOnlyChild() {
		return age18to24WithOnlyChild;
	}
	public void setAge18to24WithOnlyChild(BigInteger age18to24WithOnlyChild) {
		this.age18to24WithOnlyChild = age18to24WithOnlyChild;
	}
	public BigInteger getAge18to24UHHT() {
		return age18to24UHHT;
	}
	public void setAge18to24UHHT(BigInteger age18to24uhht) {
		age18to24UHHT = age18to24uhht;
	}
	public BigInteger getAge25to34WOC() {
		return age25to34WOC;
	}
	public void setAge25to34WOC(BigInteger age25to34woc) {
		age25to34WOC = age25to34woc;
	}
	public BigInteger getAge25to34WCA() {
		return age25to34WCA;
	}
	public void setAge25to34WCA(BigInteger age25to34wca) {
		age25to34WCA = age25to34wca;
	}
	public BigInteger getAge25to34WithOnlyChild() {
		return age25to34WithOnlyChild;
	}
	public void setAge25to34WithOnlyChild(BigInteger age25to34WithOnlyChild) {
		this.age25to34WithOnlyChild = age25to34WithOnlyChild;
	}
	public BigInteger getAge25to34UHHT() {
		return age25to34UHHT;
	}
	public void setAge25to34UHHT(BigInteger age25to34uhht) {
		age25to34UHHT = age25to34uhht;
	}
	public BigInteger getAge35to44WOC() {
		return age35to44WOC;
	}
	public void setAge35to44WOC(BigInteger age35to44woc) {
		age35to44WOC = age35to44woc;
	}
	public BigInteger getAge35to44WCA() {
		return age35to44WCA;
	}
	public void setAge35to44WCA(BigInteger age35to44wca) {
		age35to44WCA = age35to44wca;
	}
	public BigInteger getAge35to44WithOnlyChild() {
		return age35to44WithOnlyChild;
	}
	public void setAge35to44WithOnlyChild(BigInteger age35to44WithOnlyChild) {
		this.age35to44WithOnlyChild = age35to44WithOnlyChild;
	}
	public BigInteger getAge35to44UHHT() {
		return age35to44UHHT;
	}
	public void setAge35to44UHHT(BigInteger age35to44uhht) {
		age35to44UHHT = age35to44uhht;
	}
	public BigInteger getAge45to54WOC() {
		return age45to54WOC;
	}
	public void setAge45to54WOC(BigInteger age45to54woc) {
		age45to54WOC = age45to54woc;
	}
	public BigInteger getAge45to54WCA() {
		return age45to54WCA;
	}
	public void setAge45to54WCA(BigInteger age45to54wca) {
		age45to54WCA = age45to54wca;
	}
	public BigInteger getAge45to54WithOnlyChild() {
		return age45to54WithOnlyChild;
	}
	public void setAge45to54WithOnlyChild(BigInteger age45to54WithOnlyChild) {
		this.age45to54WithOnlyChild = age45to54WithOnlyChild;
	}
	public BigInteger getAge45to54UHHT() {
		return age45to54UHHT;
	}
	public void setAge45to54UHHT(BigInteger age45to54uhht) {
		age45to54UHHT = age45to54uhht;
	}
	public BigInteger getAge55to61WOC() {
		return age55to61WOC;
	}
	public void setAge55to61WOC(BigInteger age55to61woc) {
		age55to61WOC = age55to61woc;
	}
	public BigInteger getAge55to61WCA() {
		return age55to61WCA;
	}
	public void setAge55to61WCA(BigInteger age55to61wca) {
		age55to61WCA = age55to61wca;
	}
	public BigInteger getAge55to61WithOnlyChild() {
		return age55to61WithOnlyChild;
	}
	public void setAge55to61WithOnlyChild(BigInteger age55to61WithOnlyChild) {
		this.age55to61WithOnlyChild = age55to61WithOnlyChild;
	}
	public BigInteger getAge55to61UHHT() {
		return age55to61UHHT;
	}
	public void setAge55to61UHHT(BigInteger age55to61uhht) {
		age55to61UHHT = age55to61uhht;
	}
	public BigInteger getAge62PlusWOC() {
		return age62PlusWOC;
	}
	public void setAge62PlusWOC(BigInteger age62PlusWOC) {
		this.age62PlusWOC = age62PlusWOC;
	}
	public BigInteger getAge62PlusWCA() {
		return age62PlusWCA;
	}
	public void setAge62PlusWCA(BigInteger age62PlusWCA) {
		this.age62PlusWCA = age62PlusWCA;
	}
	public BigInteger getAge62PlusWithOnlyChild() {
		return age62PlusWithOnlyChild;
	}
	public void setAge62PlusWithOnlyChild(BigInteger age62PlusWithOnlyChild) {
		this.age62PlusWithOnlyChild = age62PlusWithOnlyChild;
	}
	public BigInteger getAge62PlusUHHT() {
		return age62PlusUHHT;
	}
	public void setAge62PlusUHHT(BigInteger age62PlusUHHT) {
		this.age62PlusUHHT = age62PlusUHHT;
	}
	public BigInteger getAgeDKRWOC() {
		return ageDKRWOC;
	}
	public void setAgeDKRWOC(BigInteger ageDKRWOC) {
		this.ageDKRWOC = ageDKRWOC;
	}
	public BigInteger getAgeDKRWCA() {
		return ageDKRWCA;
	}
	public void setAgeDKRWCA(BigInteger ageDKRWCA) {
		this.ageDKRWCA = ageDKRWCA;
	}
	public BigInteger getAgeDKRWithOnlyChild() {
		return ageDKRWithOnlyChild;
	}
	public void setAgeDKRWithOnlyChild(BigInteger ageDKRWithOnlyChild) {
		this.ageDKRWithOnlyChild = ageDKRWithOnlyChild;
	}
	public BigInteger getAgeDKRUHHT() {
		return ageDKRUHHT;
	}
	public void setAgeDKRUHHT(BigInteger ageDKRUHHT) {
		this.ageDKRUHHT = ageDKRUHHT;
	}
	public BigInteger getAgeInfoMissingWOC() {
		return ageInfoMissingWOC;
	}
	public void setAgeInfoMissingWOC(BigInteger ageInfoMissingWOC) {
		this.ageInfoMissingWOC = ageInfoMissingWOC;
	}
	public BigInteger getAgeInfoMissingWCA() {
		return ageInfoMissingWCA;
	}
	public void setAgeInfoMissingWCA(BigInteger ageInfoMissingWCA) {
		this.ageInfoMissingWCA = ageInfoMissingWCA;
	}
	public BigInteger getAgeInfoMissingWithOnlyChild() {
		return ageInfoMissingWithOnlyChild;
	}
	public void setAgeInfoMissingWithOnlyChild(
			BigInteger ageInfoMissingWithOnlyChild) {
		this.ageInfoMissingWithOnlyChild = ageInfoMissingWithOnlyChild;
	}
	public BigInteger getAgeInfoMissingUHHT() {
		return ageInfoMissingUHHT;
	}
	public void setAgeInfoMissingUHHT(BigInteger ageInfoMissingUHHT) {
		this.ageInfoMissingUHHT = ageInfoMissingUHHT;
	}
	public BigInteger getAgeOverallTotalWOC() {
		return ageOverallTotalWOC;
	}
	public void setAgeOverallTotalWOC(BigInteger ageOverallTotalWOC) {
		this.ageOverallTotalWOC = ageOverallTotalWOC;
	}
	public BigInteger getAgeOverallTotalWCA() {
		return ageOverallTotalWCA;
	}
	public void setAgeOverallTotalWCA(BigInteger ageOverallTotalWCA) {
		this.ageOverallTotalWCA = ageOverallTotalWCA;
	}
	public BigInteger getAgeOverallTotalWithOnlyChild() {
		return ageOverallTotalWithOnlyChild;
	}
	public void setAgeOverallTotalWithOnlyChild(
			BigInteger ageOverallTotalWithOnlyChild) {
		this.ageOverallTotalWithOnlyChild = ageOverallTotalWithOnlyChild;
	}
	public BigInteger getAgeOverallTotalUHHT() {
		return ageOverallTotalUHHT;
	}
	public void setAgeOverallTotalUHHT(BigInteger ageOverallTotalUHHT) {
		this.ageOverallTotalUHHT = ageOverallTotalUHHT;
	}
	/**
	 * Getter Setter for "Q11: Age" Table -- Ends
	 * */
}