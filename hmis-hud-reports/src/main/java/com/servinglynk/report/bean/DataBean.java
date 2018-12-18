package com.servinglynk.report.bean;

import java.math.BigInteger;
import java.sql.Timestamp;


public class DataBean {

	private String /*homePageStartDate*/startDate;
	private String /*homePageEndDate*/endDate;
	private String /*homePageProjects*/projects;
	private String /*homePageHomeLess*/homeLess;
	private String /*homePageGrants*/grants;
	private String /*homePageView*/view;
	
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
	private BigInteger coFirstContactNotStaying;
	private BigInteger coFirstContactStaying;
	private BigInteger coFirstContactWorkerUnableToDetermine;
	private BigInteger totContacted2to5Times;
	private BigInteger c2to5FirstContactedNotStaying;
	private BigInteger c2to5FirstContactStaying;
	private BigInteger c2to5FirstContactedWorkerUnableToDetermine;
	private BigInteger totContacted6to9Times;
	private BigInteger c6to9FirstContactedNotStaying;
	private BigInteger c6to9FirstContactedWorkerUnableToDetermine;
	private BigInteger totContacted10orMore;
	private BigInteger c6to9FirstContactStaying;
	private BigInteger c10orMoreFirstContactedNotStaying;
	private BigInteger c10orMoreFirstContactStaying;
	private BigInteger c10orMoreFirstContactedWorkerUnableToDetermine;
	private BigInteger totPersonsContacted;
	private BigInteger tpcFirstContactedNotStaying;
	private BigInteger tpcFirstContactStaying;
	private BigInteger tpcFirstContactedWorkerUnableToDetermine;
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
	
	/*
	 * "Q19a1 Table Starts
	 *  
	 * */
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomeTotalAdult;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures;
	private BigInteger q19a1NoOfAdltsWithEarnedIncomePercent;
	private BigInteger q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1AverageChangeInEarnedIncomeTotalAdult;
	private BigInteger q19a1AverageChangeInEarnedIncomePerformanceMeasures;
	private BigInteger q19a1AverageChangeInEarnedIncomePercent;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1NoOfAdultsWithOtherIncomeTotalAdult;
	private BigInteger q19a1NoOfAdultsWithOtherIncomePerformanceMeasures;
	private BigInteger q19a1NoOfAdultsWithOtherIncomePercent;
	private BigInteger q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1AverageChangeInOtherIncomeTotalAdult;
	private BigInteger q19a1AverageChangeInOtherIncomePerformanceMeasures;
	private BigInteger q19a1AverageChangeInOtherIncomePercent;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomeTotalAdult;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures;
	private BigInteger q19a1NumberOfAdultsWithAnyIncomePercent;
	private BigInteger q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	private BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar;
	private BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar;
	private BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar;
	private BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	private BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	private BigInteger q19a1AverageChangeInOverallIncomeTotalAdult;
	private BigInteger q19a1AverageChangeInOverallIncomePerformanceMeasures;
	private BigInteger q19a1AverageChangeInOverallIncomePercent;
	
	/*
	 * "Q19a1 Table Ends
	 *  
	 * */
	
	/*
	 * "Q19a2 Table Starts 
	 *  
	 * */
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomeTotalAdult;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures;
	private BigInteger q19a2NoOfAdltsWithEarnedIncomePercent;
		
	private BigInteger q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2AverageChangeInEarnedIncomeTotalAdult;
	private BigInteger q19a2AverageChangeInEarnedIncomePerformanceMeasures;
	private BigInteger q19a2AverageChangeInEarnedIncomePercent;
		
	private BigInteger q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2NoOfAdultsWithOtherIncomeTotalAdult;
	private BigInteger q19a2NoOfAdultsWithOtherIncomePerformanceMeasures;
	private BigInteger q19a2NoOfAdultsWithOtherIncomePercent;
		
	private BigInteger q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2AverageChangeInOtherIncomeTotalAdult;
	private BigInteger q19a2AverageChangeInOtherIncomePerformanceMeasures;
	private BigInteger q19a2AverageChangeInOtherIncomePercent;
		
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomeTotalAdult;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures;
	private BigInteger q19a2NumberOfAdultsWithAnyIncomePercent;
		
	private BigInteger q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	private BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	private BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	private BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	private BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	private BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	private BigInteger q19a2AverageChangeInOverallIncomeTotalAdult;
	private BigInteger q19a2AverageChangeInOverallIncomePerformanceMeasures;
	private BigInteger q19a2AverageChangeInOverallIncomePercent;
	
	/*
	 * "Q19a2 Table Ends
	 *  
	 * */
	
	/*
	 * "Q19a3 Table Starts
	 *  
	 * */
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomeTotalAdult;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures;
	private BigInteger q19a3NoOfAdltsWithEarnedIncomePercent;
		
	private BigInteger q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3AverageChangeInEarnedIncomeTotalAdult;
	private BigInteger q19a3AverageChangeInEarnedIncomePerformanceMeasures;
	private BigInteger q19a3AverageChangeInEarnedIncomePercent;
		
	private BigInteger q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3NoOfAdultsWithOtherIncomeTotalAdult;
	private BigInteger q19a3NoOfAdultsWithOtherIncomePerformanceMeasures;
	private BigInteger q19a3NoOfAdultsWithOtherIncomePercent;
		
	private BigInteger q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3AverageChangeInOtherIncomeTotalAdult;
	private BigInteger q19a3AverageChangeInOtherIncomePerformanceMeasures;
	private BigInteger q19a3AverageChangeInOtherIncomePercent;

	private BigInteger q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomeTotalAdult;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures;
	private BigInteger q19a3NumberOfAdultsWithAnyIncomePercent;
		
	private BigInteger q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	private BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	private BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	private BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	private BigInteger q19a3AverageChangeInOverallIncomeTotalAdult;
	private BigInteger q19a3AverageChangeInOverallIncomePerformanceMeasures;
	private BigInteger q19a3AverageChangeInOverallIncomePercent;

	/*
	 * "Q19a3 Table Ends
	 *  
	 * */
	
	/*
	 * "Q20a Table Starts
	 *  
	 * */
	
	private BigInteger q20aSupplementalNutritionalAssistanceAtEntry;
	private BigInteger q20aSupplementalNutritionalAssistanceAtLatestStayers;
	private BigInteger q20aSupplementalNutritionalAssistanceAtExitLeavers;
		
	private BigInteger q20aWICAtEntry;
	private BigInteger q20aWICAtLatestStayers;
	private BigInteger q20aWICAtExitLeavers;
		
	private BigInteger q20aTANFChildCareAtEntry;
	private BigInteger q20aTANFChildCareAtLatestStayers;
	private BigInteger q20aTANFChildCareAtExitLeavers;
		
	private BigInteger q20aTANFTransportationAtEntry;
	private BigInteger q20aTANFTransportationAtLatestStayers;
	private BigInteger q20aTANFTransportationAtExitLeavers;

	private BigInteger q20aOtherTANFAtEntry;
	private BigInteger q20aOtherTANFAtLatestStayers;
	private BigInteger q20aOtherTANFAtExitLeavers;
		
	private BigInteger q20aOtherSourcesAtEntry;
	private BigInteger q20aOtherSourcesAtLatestStayers;
	private BigInteger q20aOtherSourcesAtExitLeavers;
	
	/*
	 * "Q20a Table Ends
	 *  
	 * */
	
	/*
	 * "Q20b Table Starts
	 *  
	 * */
	private BigInteger q20bNosourcesAtEntry;
	private BigInteger q20bNosourcesAtLatestStayers;
	private BigInteger q20bNosourcesAtExitLeavers;
		
	private BigInteger q20b1PlusSourcesAtEntry;
	private BigInteger q20b1PlusSourcesAtLatestStayers;
	private BigInteger q20b1PlusSourcesAtExitLeavers;
		
	private BigInteger q20bDKRAtEntry;
	private BigInteger q20bDKRAtLatestStayers;
	private BigInteger q20bDKRAtExitLeavers;
		
	private BigInteger q20bMissingInfoAtEntry;
	private BigInteger q20bMissingInfoAtLatestStayers;
	private BigInteger q20bMissingInfoAtExitLeavers;
		
	private BigInteger q20bTotalClientsAtEntry;
	private BigInteger q20bTotalClientsAtLatestStayers;
	private BigInteger q20bTotalClientsAtExitLeavers;
		
	/*
	 * "Q20b Table Ends
	 *  
	 * */
	
	/*
	 * "Q21 Table Starts
	 *  
	 * */
	private BigInteger q21AMedicaidHealthInsuranceAtEntry;
	private BigInteger q21AMedicaidHealthInsuranceAtLatestStayers;
	private BigInteger q21AMedicaidHealthInsuranceAtExitLeavers;
		
	private BigInteger q21BMedicaidHealthInsuranceAtEntry;
	private BigInteger q21BMedicaidHealthInsuranceAtLatestStayers;
	private BigInteger q21BMedicaidHealthInsuranceAtExitLeavers;
		
	private BigInteger q21CStateChildHealthInsuranceAtEntry;
	private BigInteger q21CStateChildHealthInsuranceAtLatestStayers;
	private BigInteger q21CStateChildHealthInsuranceAtExitLeavers;
		
	private BigInteger q21DVAMedicalServicesAtEntry;
	private BigInteger q21DVAMedicalServicesAtLatestStayers;
	private BigInteger q21DVAMedicalServicesAtExitLeavers;
		
	private BigInteger q21EEmployerProvidedHealthInsuranceAtEntry;
	private BigInteger q21EEmployerProvidedHealthInsuranceAtLatestStayers;
	private BigInteger q21EEmployerProvidedHealthInsuranceAtExitLeavers;
		
	private BigInteger q21FHealthInsuranceThroughCobraAtEntry;
	private BigInteger q21FHealthInsuranceThroughCobraAtLatestStayers;
	private BigInteger q21FHealthInsuranceThroughCobraAtExitLeavers;
		
	private BigInteger q21GPrivatePayHealthInsuranceAtEntry;
	private BigInteger q21GPrivatePayHealthInsuranceAtLatestStayers;
	private BigInteger q21GPrivatePayHealthInsuranceAtExitLeavers;
		
	private BigInteger q21HStateHealthInsuranceForAdultsAtEntry;
	private BigInteger q21HStateHealthInsuranceForAdultsAtLatestStayers;
	private BigInteger q21HStateHealthInsuranceForAdultsAtExitLeavers;
		
	private BigInteger q21INoHealthInsuranceAtEntry;
	private BigInteger q21INoHealthInsuranceAtLatestStayers;
	private BigInteger q21INoHealthInsuranceAtExitLeavers;
		
	private BigInteger q21JClientRefusedAtEntry;
	private BigInteger q21JClientRefusedAtLatestStayers;
	private BigInteger q21JClientRefusedAtExitLeavers;
		
	private BigInteger q21KDataNotCollectedAtEntry;
	private BigInteger q21KDataNotCollectedAtLatestStayers;
	private BigInteger q21KDataNotCollectedAtExitLeavers;
			
	private BigInteger q21LNoOfAdultStayersNotRequiredAtEntry;
	private BigInteger q21LNoOfAdultStayersNotRequiredAtLatestStayers;
	private BigInteger q21LNoOfAdultStayersNotRequiredAtExitLeavers;
			
	private BigInteger q21M1SourceOfHealthInsuranceAtEntry;
	private BigInteger q21M1SourceOfHealthInsuranceAtLatestStayers;
	private BigInteger q21M1SourceOfHealthInsuranceAtExitLeavers;
		
	private BigInteger q21NMoreThan1SourceOfHealthInsuranceAtEntry;
	private BigInteger q21NMoreThan1SourceOfHealthInsuranceAtLatestStayers;
	private BigInteger q21NMoreThan1SourceOfHealthInsuranceAtExitLeavers;
	
	/*
	 * "Q21 Table Ends
	 *  
	 * */
	
	/*
	 * "Q22a1 Table Starts
	 *  
	 * */
	private BigInteger q22a1A30DaysOrLessTotal;
	private BigInteger q22a1A30DaysOrLessLeavers;
	private BigInteger q22a1A30DaysOrLessStayers;
		
	private BigInteger q22a1B31To60DaysTotal;
	private BigInteger q22a1B31To60DaysLeavers;
	private BigInteger q22a1B31To60DaysStayers;
		
	private BigInteger q22a1C61To180DaysTotal;
	private BigInteger q22a1C61To180DaysLeavers;
	private BigInteger q22a1C61To180DaysStayers;
		
	private BigInteger q22a1D181To365DaysTotal;
	private BigInteger q22a1D181To365DaysLeavers;
	private BigInteger q22a1D181To365DaysStayers;
		
	private BigInteger q22a1E366To730DaysTotal;
	private BigInteger q22a1E366To730DaysLeavers;
	private BigInteger q22a1E366To730DaysStayers;
			
	private BigInteger q22a1F731To1095DaysTotal;
	private BigInteger q22a1F731To1095DaysLeavers;
	private BigInteger q22a1F731To1095DaysStayers;
		
	private BigInteger q22a1G1096To1460DaysTotal;
	private BigInteger q22a1G1096To1460DaysLeavers;
	private BigInteger q22a1G1096To1460DaysStayers;
		
	private BigInteger q22a1H1461To1825DaysTotal;
	private BigInteger q22a1H1461To1825DaysLeavers;
	private BigInteger q22a1H1461To1825DaysStayers;
		
	private BigInteger q22a1IMoreThan1825DaysTotal;
	private BigInteger q22a1IMoreThan1825DaysLeavers;
	private BigInteger q22a1IMoreThan1825DaysStayers;
		
	private BigInteger q22a1JInfoMissingTotal;
	private BigInteger q22a1JInfoMissingLeavers;
	private BigInteger q22a1JInfoMissingStayers;
		
	private BigInteger q22a1KTotTotal;
	private BigInteger q22a1KTotLeavers;
	private BigInteger q22a1KTotStayers;
	/*
	 * "Q22a1 Table Ends
	 *  
	 * */
	
	/*
	 * "Q22b Table Starts
	 *  
	 * */
	private BigInteger q22bAverageLengthInDaysTotal;
	private BigInteger q22bAverageLengthInDaysLeavers;
	private BigInteger q22bAverageLengthInDaysStayers;
		
	private BigInteger q22bMedianLengthInDaysTotal;
	private BigInteger q22bMedianLengthInDaysLeavers;
	private BigInteger q22bMedianLengthInDaysStayers;
	/*
	 * "Q22b Table Ends
	 *  
	 * */
	
	/*
	 * "Q23a Table Starts
	 *  
	 * */
	
	private BigInteger q23APermanentDestinationsTotal;
	private BigInteger q23APermanentDestinationsWithoutChild;
	private BigInteger q23APermanentDestinationsWithChildAndAdults;
	private BigInteger q23APermanentDestinationsWithOnlyChild;
	private BigInteger q23APermanentDestinationsUnknownHouseHold;
		
	private BigInteger q23A01MovedFromOneHOPWATotal;
	private BigInteger q23A01MovedFromOneHOPWAWithoutChild;
	private BigInteger q23A01MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q23A01MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q23A01MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q23A02OwnedByClientNoOngoingSubsidyTotal;
	private BigInteger q23A02OwnedByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q23A02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23A03OwnedByClientWithOngoingSubsidyTotal;
	private BigInteger q23A03OwnedByClientWithOngoingSubsidyWithoutChild;
	private BigInteger q23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	private BigInteger q23A03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	private BigInteger q23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23A04RentalByClientNoOngoingSubsidyTotal;
	private BigInteger q23A04RentalByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q23A04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q23A04RentalByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q23A04RentalByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23A05RentalByClientVASHSubsidyTotal;
	private BigInteger q23A05RentalByClientVASHSubsidyWithoutChild;
	private BigInteger q23A05RentalByClientVASHSubsidyWithChildAndAdults;
	private BigInteger q23A05RentalByClientVASHSubsidyWithOnlyChild;
	private BigInteger q23A05RentalByClientVASHSubsidyUnknownHouseHold;
		
	private BigInteger q23A06RentalByClientwithGPDTIPHousingTotal;
	private BigInteger q23A06RentalByClientwithGPDTIPHousingWithoutChild;
	private BigInteger q23A06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	private BigInteger q23A06RentalByClientwithGPDTIPHousingWithOnlyChild;
	private BigInteger q23A06RentalByClientwithGPDTIPHousingUnknownHouseHold;
		
	private BigInteger q23A07RentalByClientOtherOngoingSubsidyTotal;
	private BigInteger q23A07RentalByClientOtherOngoingSubsidyWithoutChild;
	private BigInteger q23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	private BigInteger q23A07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	private BigInteger q23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23A08PermanentHousingForHomelessTotal;
	private BigInteger q23A08PermanentHousingForHomelessWithoutChild;
	private BigInteger q23A08PermanentHousingForHomelessWithChildAndAdults;
	private BigInteger q23A08PermanentHousingForHomelessWithOnlyChild;
	private BigInteger q23A08PermanentHousingForHomelessUnknownHouseHold;
		
	private BigInteger q23A09StayingOrLivingWithFamilyPermanentTotal;
	private BigInteger q23A09StayingOrLivingWithFamilyPermanentWithoutChild;
	private BigInteger q23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	private BigInteger q23A09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	private BigInteger q23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
		
	private BigInteger q23A10StayingOrLivingWithFriendsPermanentTotal;
	private BigInteger q23A10StayingOrLivingWithFriendsPermanentWithoutChild;
	private BigInteger q23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	private BigInteger q23A10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	private BigInteger q23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
		
	private BigInteger q23AzTotTotal;
	private BigInteger q23AzTotWithoutChild;
	private BigInteger q23AzTotWithChildAndAdults;
	private BigInteger q23AzTotWithOnlyChild;
	private BigInteger q23AzTotUnknownHouseHold;
		
	private BigInteger q23BTemporaryDestinationsTotal;
	private BigInteger q23BTemporaryDestinationsWithoutChild;
	private BigInteger q23BTemporaryDestinationsWithChildAndAdults;
	private BigInteger q23BTemporaryDestinationsWithOnlyChild;
	private BigInteger q23BTemporaryDestinationsUnknownHouseHold;
		
	private BigInteger q23B1EmergencyShelterTotal;
	private BigInteger q23B1EmergencyShelterWithoutChild;
	private BigInteger q23B1EmergencyShelterWithChildAndAdults;
	private BigInteger q23B1EmergencyShelterWithOnlyChild;
	private BigInteger q23B1EmergencyShelterUnknownHouseHold;
		
	private BigInteger q23B2MovedFromOneHOPWATotal;
	private BigInteger q23B2MovedFromOneHOPWAWithoutChild;
	private BigInteger q23B2MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q23B2MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q23B2MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q23B3TransitionalHousingForHomeLessTotal;
	private BigInteger q23B3TransitionalHousingForHomeLessWithoutChild;
	private BigInteger q23B3TransitionalHousingForHomeLessWithChildAndAdults;
	private BigInteger q23B3TransitionalHousingForHomeLessWithOnlyChild;
	private BigInteger q23B3TransitionalHousingForHomeLessUnknownHouseHold;
		
	private BigInteger q23B4StayingWithFamilyTemporaryTenureTotal;
	private BigInteger q23B4StayingWithFamilyTemporaryTenureWithoutChild;
	private BigInteger q23B4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	private BigInteger q23B4StayingWithFamilyTemporaryTenureWithOnlyChild;
	private BigInteger q23B4StayingWithFamilyTemporaryTenureUnknownHouseHold;
		
	private BigInteger q23B5StayingWithFriendsTemporaryTenureTotal;
	private BigInteger q23B5StayingWithFriendsTemporaryTenureWithoutChild;
	private BigInteger q23B5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	private BigInteger q23B5StayingWithFriendsTemporaryTenureWithOnlyChild;
	private BigInteger q23B5StayingWithFriendsTemporaryTenureUnknownHouseHold;
		
	private BigInteger q23B6PlaceNotMeantForHumanHabitationTotal;
	private BigInteger q23B6PlaceNotMeantForHumanHabitationWithoutChild;
	private BigInteger q23B6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	private BigInteger q23B6PlaceNotMeantForHumanHabitationWithOnlyChild;
	private BigInteger q23B6PlaceNotMeantForHumanHabitationUnknownHouseHold;
		
	private BigInteger q23B7SafeHavenTotal;
	private BigInteger q23B7SafeHavenWithoutChild;
	private BigInteger q23B7SafeHavenWithChildAndAdults;
	private BigInteger q23B7SafeHavenWithOnlyChild;
	private BigInteger q23B7SafeHavenUnknownHouseHold;
		
	private BigInteger q23B8HotelOrMotelPaidByClientTotal;
	private BigInteger q23B8HotelOrMotelPaidByClientWithoutChild;
	private BigInteger q23B8HotelOrMotelPaidByClientWithChildAndAdults;
	private BigInteger q23B8HotelOrMotelPaidByClientWithOnlyChild;
	private BigInteger q23B8HotelOrMotelPaidByClientUnknownHouseHold;
		
	private BigInteger q23BzTotTotal;
	private BigInteger q23BzTotWithoutChild;
	private BigInteger q23BzTotWithChildAndAdults;
	private BigInteger q23BzTotWithOnlyChild;
	private BigInteger q23BzTotUnknownHouseHold;
		
	private BigInteger q23CInstitutionalSettingsTotal;
	private BigInteger q23CInstitutionalSettingsWithoutChild;
	private BigInteger q23CInstitutionalSettingsWithChildAndAdults;
	private BigInteger q23CInstitutionalSettingsWithOnlyChild;
	private BigInteger q23CInstitutionalSettingsUnknownHouseHold;
		
	private BigInteger q23C1FosterCareHomeOrGroupFosterCareTotal;
	private BigInteger q23C1FosterCareHomeOrGroupFosterCareWithoutChild;
	private BigInteger q23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	private BigInteger q23C1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	private BigInteger q23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
		
	private BigInteger q23C2PsychiatricHospitalOrOtherTotal;
	private BigInteger q23C2PsychiatricHospitalOrOtherWithoutChild;
	private BigInteger q23C2PsychiatricHospitalOrOtherWithChildAndAdults;
	private BigInteger q23C2PsychiatricHospitalOrOtherWithOnlyChild;
	private BigInteger q23C2PsychiatricHospitalOrOtherUnknownHouseHold;
			
	private BigInteger q23C3SubstanceAbuseTreatmentFacilityTotal;
	private BigInteger q23C3SubstanceAbuseTreatmentFacilityWithoutChild;
	private BigInteger q23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	private BigInteger q23C3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	private BigInteger q23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
		
	private BigInteger q23C4HospitalOrOtherTotal;
	private BigInteger q23C4HospitalOrOtherWithoutChild;
	private BigInteger q23C4HospitalOrOtherWithChildAndAdults;
	private BigInteger q23C4HospitalOrOtherWithOnlyChild;
	private BigInteger q23C4HospitalOrOtherUnknownHouseHold;
		
	private BigInteger q23C5JailPrisonOrJuvenileDetentionTotal;
	private BigInteger q23C5JailPrisonOrJuvenileDetentionWithoutChild;
	private BigInteger q23C5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	private BigInteger q23C5JailPrisonOrJuvenileDetentionWithOnlyChild;
	private BigInteger q23C5JailPrisonOrJuvenileDetentionUnknownHouseHold;
		
	private BigInteger q23C6LongTermCareFacilityOrNursingHomeTotal;
	private BigInteger q23C6LongTermCareFacilityOrNursingHomeWithoutChild;
	private BigInteger q23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	private BigInteger q23C6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	private BigInteger q23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
		
	private BigInteger q23CzTotTotal;
	private BigInteger q23CzTotWithoutChild;
	private BigInteger q23CzTotWithChildAndAdults;
	private BigInteger q23CzTotWithOnlyChild;
	private BigInteger q23CzTotUnknownHouseHold;
		
	private BigInteger q23DOtherDestinationsTotal;
	private BigInteger q23DOtherDestinationsWithoutChild;
	private BigInteger q23DOtherDestinationsWithChildAndAdults;
	private BigInteger q23DOtherDestinationsWithOnlyChild;
	private BigInteger q23DOtherDestinationsUnknownHouseHold;
		
	private BigInteger q23D1ResidentialProjectorHalfwayHouseTotal;
	private BigInteger q23D1ResidentialProjectorHalfwayHouseWithoutChild;
	private BigInteger q23D1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	private BigInteger q23D1ResidentialProjectorHalfwayHouseWithOnlyChild;
	private BigInteger q23D1ResidentialProjectorHalfwayHouseUnknownHouseHold;
		
	private BigInteger q23D2DeceasedTotal;
	private BigInteger q23D2DeceasedWithoutChild;
	private BigInteger q23D2DeceasedWithChildAndAdults;
	private BigInteger q23D2DeceasedWithOnlyChild;
	private BigInteger q23D2DeceasedUnknownHouseHold;
		
	private BigInteger q23D3OtherTotal;
	private BigInteger q23D3OtherWithoutChild;
	private BigInteger q23D3OtherWithChildAndAdults;
	private BigInteger q23D3OtherWithOnlyChild;
	private BigInteger q23D3OtherUnknownHouseHold;
		
	private BigInteger q23D4DKRTotal;
	private BigInteger q23D4DKRWithoutChild;
	private BigInteger q23D4DKRWithChildAndAdults;
	private BigInteger q23D4DKRWithOnlyChild;
	private BigInteger q23D4DKRUnknownHouseHold;
		
	private BigInteger q23D5InfoMissingTotal;
	private BigInteger q23D5InfoMissingWithoutChild;
	private BigInteger q23D5InfoMissingWithChildAndAdults;
	private BigInteger q23D5InfoMissingWithOnlyChild;
	private BigInteger q23D5InfoMissingUnknownHouseHold;
		
	private BigInteger q23DzTotTotal;
	private BigInteger q23DzTotWithoutChild;
	private BigInteger q23DzTotWithChildAndAdults;
	private BigInteger q23DzTotWithOnlyChild;
	private BigInteger q23DzTotUnknownHouseHold;
		
	private BigInteger q23ETotTotal;
	private BigInteger q23ETotWithoutChild;
	private BigInteger q23ETotWithChildAndAdults;
	private BigInteger q23ETotWithOnlyChild;
	private BigInteger q23ETotUnknownHouseHold;
	
	private BigInteger q23PercentageWithChildAndAdults;
	private BigInteger q23PercentageUnknownHouseHold;
	private BigInteger q23PercentageWithOnlyChild;
	private BigInteger q23PercentageWithoutChild;
	private BigInteger q23PercentageTotal;

	private BigInteger q23TotPersonsDstnsWithoutChild;
	private BigInteger q23TotPersonsDstnsTotal;
	private BigInteger q23TotPersonsDstnsUnknownHouseHold;
	private BigInteger q23TotPersonsDstnsWithOnlyChild;
	private BigInteger q23TotPersonsDstnsWithChildAndAdults;

	private BigInteger q23TotPersonsExistTotal;
	private BigInteger q23TotPersonsExistWithoutChild;
	private BigInteger q23TotPersonsExistWithChildAndAdults;
	private BigInteger q23TotPersonsExistWithOnlyChild;
	private BigInteger q23TotPersonsExistUnknownHouseHold;
	
	/*
	 * "Q23a Table Ends
	 *  
	 * */
	
	/*
	 * "q23B Table Starts
	 *  
	 * */
	
	private BigInteger q23BAPermanentDestinationsTotal;
	private BigInteger q23BAPermanentDestinationsWithoutChild;
	private BigInteger q23BAPermanentDestinationsWithChildAndAdults;
	private BigInteger q23BAPermanentDestinationsWithOnlyChild;
	private BigInteger q23BAPermanentDestinationsUnknownHouseHold;
		
	private BigInteger q23BA01MovedFromOneHOPWATotal;
	private BigInteger q23BA01MovedFromOneHOPWAWithoutChild;
	private BigInteger q23BA01MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q23BA01MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q23BA01MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q23BA02OwnedByClientNoOngoingSubsidyTotal;
	private BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23BA03OwnedByClientWithOngoingSubsidyTotal;
	private BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithoutChild;
	private BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	private BigInteger q23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	private BigInteger q23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23BA04RentalByClientNoOngoingSubsidyTotal;
	private BigInteger q23BA04RentalByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q23BA04RentalByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23BA05RentalByClientVASHSubsidyTotal;
	private BigInteger q23BA05RentalByClientVASHSubsidyWithoutChild;
	private BigInteger q23BA05RentalByClientVASHSubsidyWithChildAndAdults;
	private BigInteger q23BA05RentalByClientVASHSubsidyWithOnlyChild;
	private BigInteger q23BA05RentalByClientVASHSubsidyUnknownHouseHold;
		
	private BigInteger q23BA06RentalByClientwithGPDTIPHousingTotal;
	private BigInteger q23BA06RentalByClientwithGPDTIPHousingWithoutChild;
	private BigInteger q23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	private BigInteger q23BA06RentalByClientwithGPDTIPHousingWithOnlyChild;
	private BigInteger q23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold;
		
	private BigInteger q23BA07RentalByClientOtherOngoingSubsidyTotal;
	private BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithoutChild;
	private BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	private BigInteger q23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	private BigInteger q23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q23BA08PermanentHousingForHomelessTotal;
	private BigInteger q23BA08PermanentHousingForHomelessWithoutChild;
	private BigInteger q23BA08PermanentHousingForHomelessWithChildAndAdults;
	private BigInteger q23BA08PermanentHousingForHomelessWithOnlyChild;
	private BigInteger q23BA08PermanentHousingForHomelessUnknownHouseHold;
		
	private BigInteger q23BA09StayingOrLivingWithFamilyPermanentTotal;
	private BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithoutChild;
	private BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	private BigInteger q23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	private BigInteger q23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
		
	private BigInteger q23BA10StayingOrLivingWithFriendsPermanentTotal;
	private BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithoutChild;
	private BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	private BigInteger q23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	private BigInteger q23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
		
	private BigInteger q23BAzTotTotal;
	private BigInteger q23BAzTotWithoutChild;
	private BigInteger q23BAzTotWithChildAndAdults;
	private BigInteger q23BAzTotWithOnlyChild;
	private BigInteger q23BAzTotUnknownHouseHold;
		
	private BigInteger q23BBTemporaryDestinationsTotal;
	private BigInteger q23BBTemporaryDestinationsWithoutChild;
	private BigInteger q23BBTemporaryDestinationsWithChildAndAdults;
	private BigInteger q23BBTemporaryDestinationsWithOnlyChild;
	private BigInteger q23BBTemporaryDestinationsUnknownHouseHold;
		
	private BigInteger q23BB1EmergencyShelterTotal;
	private BigInteger q23BB1EmergencyShelterWithoutChild;
	private BigInteger q23BB1EmergencyShelterWithChildAndAdults;
	private BigInteger q23BB1EmergencyShelterWithOnlyChild;
	private BigInteger q23BB1EmergencyShelterUnknownHouseHold;
		
	private BigInteger q23BB2MovedFromOneHOPWATotal;
	private BigInteger q23BB2MovedFromOneHOPWAWithoutChild;
	private BigInteger q23BB2MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q23BB2MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q23BB2MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q23BB3TransitionalHousingForHomeLessTotal;
	private BigInteger q23BB3TransitionalHousingForHomeLessWithoutChild;
	private BigInteger q23BB3TransitionalHousingForHomeLessWithChildAndAdults;
	private BigInteger q23BB3TransitionalHousingForHomeLessWithOnlyChild;
	private BigInteger q23BB3TransitionalHousingForHomeLessUnknownHouseHold;
		
	private BigInteger q23BB4StayingWithFamilyTemporaryTenureTotal;
	private BigInteger q23BB4StayingWithFamilyTemporaryTenureWithoutChild;
	private BigInteger q23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	private BigInteger q23BB4StayingWithFamilyTemporaryTenureWithOnlyChild;
	private BigInteger q23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold;
		
	private BigInteger q23BB5StayingWithFriendsTemporaryTenureTotal;
	private BigInteger q23BB5StayingWithFriendsTemporaryTenureWithoutChild;
	private BigInteger q23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	private BigInteger q23BB5StayingWithFriendsTemporaryTenureWithOnlyChild;
	private BigInteger q23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold;
		
	private BigInteger q23BB6PlaceNotMeantForHumanHabitationTotal;
	private BigInteger q23BB6PlaceNotMeantForHumanHabitationWithoutChild;
	private BigInteger q23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	private BigInteger q23BB6PlaceNotMeantForHumanHabitationWithOnlyChild;
	private BigInteger q23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold;
		
	private BigInteger q23BB7SafeHavenTotal;
	private BigInteger q23BB7SafeHavenWithoutChild;
	private BigInteger q23BB7SafeHavenWithChildAndAdults;
	private BigInteger q23BB7SafeHavenWithOnlyChild;
	private BigInteger q23BB7SafeHavenUnknownHouseHold;
		
	private BigInteger q23BB8HotelOrMotelPaidByClientTotal;
	private BigInteger q23BB8HotelOrMotelPaidByClientWithoutChild;
	private BigInteger q23BB8HotelOrMotelPaidByClientWithChildAndAdults;
	private BigInteger q23BB8HotelOrMotelPaidByClientWithOnlyChild;
	private BigInteger q23BB8HotelOrMotelPaidByClientUnknownHouseHold;
		
	private BigInteger q23BBzTotTotal;
	private BigInteger q23BBzTotWithoutChild;
	private BigInteger q23BBzTotWithChildAndAdults;
	private BigInteger q23BBzTotWithOnlyChild;
	private BigInteger q23BBzTotUnknownHouseHold;
		
	private BigInteger q23BCInstitutionalSettingsTotal;
	private BigInteger q23BCInstitutionalSettingsWithoutChild;
	private BigInteger q23BCInstitutionalSettingsWithChildAndAdults;
	private BigInteger q23BCInstitutionalSettingsWithOnlyChild;
	private BigInteger q23BCInstitutionalSettingsUnknownHouseHold;
		
	private BigInteger q23BC1FosterCareHomeOrGroupFosterCareTotal;
	private BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithoutChild;
	private BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	private BigInteger q23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	private BigInteger q23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
		
	private BigInteger q23BC2PsychiatricHospitalOrOtherTotal;
	private BigInteger q23BC2PsychiatricHospitalOrOtherWithoutChild;
	private BigInteger q23BC2PsychiatricHospitalOrOtherWithChildAndAdults;
	private BigInteger q23BC2PsychiatricHospitalOrOtherWithOnlyChild;
	private BigInteger q23BC2PsychiatricHospitalOrOtherUnknownHouseHold;
			
	private BigInteger q23BC3SubstanceAbuseTreatmentFacilityTotal;
	private BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithoutChild;
	private BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	private BigInteger q23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	private BigInteger q23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
		
	private BigInteger q23BC4HospitalOrOtherTotal;
	private BigInteger q23BC4HospitalOrOtherWithoutChild;
	private BigInteger q23BC4HospitalOrOtherWithChildAndAdults;
	private BigInteger q23BC4HospitalOrOtherWithOnlyChild;
	private BigInteger q23BC4HospitalOrOtherUnknownHouseHold;
		
	private BigInteger q23BC5JailPrisonOrJuvenileDetentionTotal;
	private BigInteger q23BC5JailPrisonOrJuvenileDetentionWithoutChild;
	private BigInteger q23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	private BigInteger q23BC5JailPrisonOrJuvenileDetentionWithOnlyChild;
	private BigInteger q23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold;
		
	private BigInteger q23BC6LongTermCareFacilityOrNursingHomeTotal;
	private BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithoutChild;
	private BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	private BigInteger q23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	private BigInteger q23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
		
	private BigInteger q23BCzTotTotal;
	private BigInteger q23BCzTotWithoutChild;
	private BigInteger q23BCzTotWithChildAndAdults;
	private BigInteger q23BCzTotWithOnlyChild;
	private BigInteger q23BCzTotUnknownHouseHold;
		
	private BigInteger q23BDOtherDestinationsTotal;
	private BigInteger q23BDOtherDestinationsWithoutChild;
	private BigInteger q23BDOtherDestinationsWithChildAndAdults;
	private BigInteger q23BDOtherDestinationsWithOnlyChild;
	private BigInteger q23BDOtherDestinationsUnknownHouseHold;
		
	private BigInteger q23BD1ResidentialProjectorHalfwayHouseTotal;
	private BigInteger q23BD1ResidentialProjectorHalfwayHouseWithoutChild;
	private BigInteger q23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	private BigInteger q23BD1ResidentialProjectorHalfwayHouseWithOnlyChild;
	private BigInteger q23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold;
		
	private BigInteger q23BD2DeceasedTotal;
	private BigInteger q23BD2DeceasedWithoutChild;
	private BigInteger q23BD2DeceasedWithChildAndAdults;
	private BigInteger q23BD2DeceasedWithOnlyChild;
	private BigInteger q23BD2DeceasedUnknownHouseHold;
		
	private BigInteger q23BD3OtherTotal;
	private BigInteger q23BD3OtherWithoutChild;
	private BigInteger q23BD3OtherWithChildAndAdults;
	private BigInteger q23BD3OtherWithOnlyChild;
	private BigInteger q23BD3OtherUnknownHouseHold;
		
	private BigInteger q23BD4DKRTotal;
	private BigInteger q23BD4DKRWithoutChild;
	private BigInteger q23BD4DKRWithChildAndAdults;
	private BigInteger q23BD4DKRWithOnlyChild;
	private BigInteger q23BD4DKRUnknownHouseHold;
		
	private BigInteger q23BD5InfoMissingTotal;
	private BigInteger q23BD5InfoMissingWithoutChild;
	private BigInteger q23BD5InfoMissingWithChildAndAdults;
	private BigInteger q23BD5InfoMissingWithOnlyChild;
	private BigInteger q23BD5InfoMissingUnknownHouseHold;
		
	private BigInteger q23BDzTotTotal;
	private BigInteger q23BDzTotWithoutChild;
	private BigInteger q23BDzTotWithChildAndAdults;
	private BigInteger q23BDzTotWithOnlyChild;
	private BigInteger q23BDzTotUnknownHouseHold;
		
	private BigInteger q23BETotTotal;
	private BigInteger q23BETotWithoutChild;
	private BigInteger q23BETotWithChildAndAdults;
	private BigInteger q23BETotWithOnlyChild;
	private BigInteger q23BETotUnknownHouseHold;
	
	private BigInteger q23BPercentageWithChildAndAdults;
	private BigInteger q23BPercentageUnknownHouseHold;
	private BigInteger q23BPercentageWithOnlyChild;
	private BigInteger q23BPercentageWithoutChild;
	private BigInteger q23BPercentageTotal;

	private BigInteger q23BTotPersonsDstnsWithoutChild;
	private BigInteger q23BTotPersonsDstnsTotal;
	private BigInteger q23BTotPersonsDstnsUnknownHouseHold;
	private BigInteger q23BTotPersonsDstnsWithOnlyChild;
	private BigInteger q23BTotPersonsDstnsWithChildAndAdults;

	private BigInteger q23BTotPersonsExistTotal;
	private BigInteger q23BTotPersonsExistWithoutChild;
	private BigInteger q23BTotPersonsExistWithChildAndAdults;
	private BigInteger q23BTotPersonsExistWithOnlyChild;
	private BigInteger q23BTotPersonsExistUnknownHouseHold;
	
	/*
	 * "q23B Table Ends
	 *  
	 * */
	
	/*
	 * "q25A Table Starts
	 *  
	 * */
	private BigInteger q25aChronicallyHomelessVeteranTotal;
	private BigInteger q25aChronicallyHomelessVeteranWithoutChildren;
	private BigInteger q25aChronicallyHomelessVeteranWithChildAndAdults;
	private BigInteger q25aChronicallyHomelessVeteranUnknownHouseHold;
			
	private BigInteger q25aNonChronicallyHomelessVeteranTotal;
	private BigInteger q25aNonChronicallyHomelessVeteranWithoutChildren;
	private BigInteger q25aNonChronicallyHomelessVeteranWithChildAndAdults;
	private BigInteger q25aNonChronicallyHomelessVeteranUnknownHouseHold;
		
	private BigInteger q25aNotVeteranTotal;
	private BigInteger q25aNotVeteranWithoutChildren;
	private BigInteger q25aNotVeteranWithChildAndAdults;
	private BigInteger q25aNotVeteranUnknownHouseHold;
		
	private BigInteger q25aClientRefusedTotal;
	private BigInteger q25aClientRefusedWithoutChildren;
	private BigInteger q25aClientRefusedWithChildAndAdults;
	private BigInteger q25aClientRefusedUnknownHouseHold;
		
	private BigInteger q25aDataNotCollectedTotal;
	private BigInteger q25aDataNotCollectedWithoutChildren;
	private BigInteger q25aDataNotCollectedWithChildAndAdults;
	private BigInteger q25aDataNotCollectedUnknownHouseHold;
		
	private BigInteger q25aTotTotal;
	private BigInteger q25aTotWithoutChildren;
	private BigInteger q25aTotWithChildAndAdults;
	private BigInteger q25aTotUnknownHouseHold;
	/*
	 * "q25A Table Ends
	 *  
	 * */
	
	/*
	 * "q25B Table Starts
	 *  
	 * */
	private BigInteger q25bChronicallyHomelessVeteranTotal;
	private BigInteger q25bChronicallyHomelessVeteranWithoutChildren;
	private BigInteger q25bChronicallyHomelessVeteranWithChildAndAdults;
	private BigInteger q25bChronicallyHomelessVeteranUnknownHouseHold;
		
	private BigInteger q25bNonChronicallyHomelessVeteranTotal;
	private BigInteger q25bNonChronicallyHomelessVeteranWithoutChildren;
	private BigInteger q25bNonChronicallyHomelessVeteranWithChildAndAdults;
	private BigInteger q25bNonChronicallyHomelessVeteranUnknownHouseHold;
		
	private BigInteger q25bNotVeteranTotal;
	private BigInteger q25bNotVeteranWithoutChildren;
	private BigInteger q25bNotVeteranWithChildAndAdults;
	private BigInteger q25bNotVeteranUnknownHouseHold;
		
	private BigInteger q25bClientRefusedTotal;
	private BigInteger q25bClientRefusedWithoutChildren;
	private BigInteger q25bClientRefusedWithChildAndAdults;
	private BigInteger q25bClientRefusedUnknownHouseHold;
		
	private BigInteger q25bDataNotCollectedTotal;
	private BigInteger q25bDataNotCollectedWithoutChildren;
	private BigInteger q25bDataNotCollectedWithChildAndAdults;
	private BigInteger q25bDataNotCollectedUnknownHouseHold;
		
	private BigInteger q25bTotTotal;
	private BigInteger q25bTotWithoutChildren;
	private BigInteger q25bTotWithChildAndAdults;
	private BigInteger q25bTotUnknownHouseHold;
	
	/*
	 * "q25B Table Ends
	 *  
	 * */
	
	/*
	 * "q25C Table Starts
	 *  
	 * */
	private BigInteger q25cMaleTotal;
	private BigInteger q25cMaleWithoutChildren;
	private BigInteger q25cMaleWithChildAndAdults;
	private BigInteger q25cMaleUnknownHouseHold;
		
	private BigInteger q25cFemaleTotal;
	private BigInteger q25cFemaleWithoutChildren;
	private BigInteger q25cFemaleWithChildAndAdults;
	private BigInteger q25cFemaleUnknownHouseHold;
		
	private BigInteger q25cTransgenderMaleToFemaleTotal;
	private BigInteger q25cTransgenderMaleToFemaleWithoutChildren;
	private BigInteger q25cTransgenderMaleToFemaleWithChildAndAdults;
	private BigInteger q25cTransgenderMaleToFemaleUnknownHouseHold;
		
	private BigInteger q25cTransgendereFemaleToMaleTotal;
	private BigInteger q25cTransgendereFemaleToMaleWithoutChildren;
	private BigInteger q25cTransgendereFemaleToMaleWithChildAndAdults;
	private BigInteger q25cTransgendereFemaleToMaleUnknownHouseHold;
		
	private BigInteger q25cOtherTotal;
	private BigInteger q25cOtherWithoutChildren;
	private BigInteger q25cOtherWithChildAndAdults;
	private BigInteger q25cOtherUnknownHouseHold;
		
	private BigInteger q25cDKRTotal;
	private BigInteger q25cDKRWithoutChildren;
	private BigInteger q25cDKRWithChildAndAdults;
	private BigInteger q25cDKRUnknownHouseHold;
		
	private BigInteger q25cInformationMissingTotal;
	private BigInteger q25cInformationMissingWithoutChildren;
	private BigInteger q25cInformationMissingWithChildAndAdults;
	private BigInteger q25cInformationMissingUnknownHouseHold;
		
	private BigInteger q25cTotTotal;
	private BigInteger q25cTotWithoutChildren;
	private BigInteger q25cTotWithChildAndAdults;
	private BigInteger q25cTotUnknownHouseHold;
	/*
	 * "q25C Table Ends
	 *  
	 * */
	
	/*
	 * "q25D Table Starts
	 *  
	 * */
	private BigInteger q25d18To24Total;
	private BigInteger q25d18To24WithoutChildren;
	private BigInteger q25d18To24WithChildAndAdults;
	private BigInteger q25d18To24UnknownHouseHold;

	private BigInteger q25d25To34Total;
	private BigInteger q25d25To34WithoutChildren;
	private BigInteger q25d25To34WithChildAndAdults;
	private BigInteger q25d25To34UnknownHouseHold;
		
	private BigInteger q25d35To44Total;
	private BigInteger q25d35To44WithoutChildren;
	private BigInteger q25d35To44WithChildAndAdults;
	private BigInteger q25d35To44UnknownHouseHold;
		
	private BigInteger q25d45To54Total;
	private BigInteger q25d45To54WithoutChildren;
	private BigInteger q25d45To54WithChildAndAdults;
	private BigInteger q25d45To54UnknownHouseHold;
		
	private BigInteger q25d55To61Total;
	private BigInteger q25d55To61WithoutChildren;
	private BigInteger q25d55To61WithChildAndAdults;
	private BigInteger q25d55To61UnknownHouseHold;
		
	private BigInteger q25d62PlusTotal;
	private BigInteger q25d62PlusWithoutChildren;
	private BigInteger q25d62PlusWithChildAndAdults;
	private BigInteger q25d62PlusUnknownHouseHold;
		
	private BigInteger q25dDKRTotal;
	private BigInteger q25dDKRWithoutChildren;
	private BigInteger q25dDKRWithChildAndAdults;
	private BigInteger q25dDKRUnknownHouseHold;
		
	private BigInteger q25dInformationMissingTotal;
	private BigInteger q25dInformationMissingWithoutChildren;
	private BigInteger q25dInformationMissingWithChildAndAdults;
	private BigInteger q25dInformationMissingUnknownHouseHold;
		
	private BigInteger q25dTotTotal;
	private BigInteger q25dTotWithoutChildren;
	private BigInteger q25dTotWithChildAndAdults;
	private BigInteger q25dTotUnknownHouseHold;

	/*
	 * "q25D Table Ends
	 *  
	 * */
	
	/*
	 * "q25E Table Starts
	 *  
	 * */
	private BigInteger q25eMentalIllnessAtEntry;
	private BigInteger q25eMentalIllnessStayers;
	private BigInteger q25eMentalIllnessLeavers;

	private BigInteger q25eAlcoholAbuseAtEntry;
	private BigInteger q25eAlcoholAbuseStayers;
	private BigInteger q25eAlcoholAbuseLeavers;

	private BigInteger q25eDrugAbuseAtEntry;
	private BigInteger q25eDrugAbuseStayers;
	private BigInteger q25eDrugAbuseLeavers;

	private BigInteger q25eBothAlcoholAndDrugAbuseAtEntry;
	private BigInteger q25eBothAlcoholAndDrugAbuseStayers;
	private BigInteger q25eBothAlcoholAndDrugAbuseLeavers;

	private BigInteger q25eChronicHealthConditionAtEntry;
	private BigInteger q25eChronicHealthConditionStayers;
	private BigInteger q25eChronicHealthConditionLeavers;

	private BigInteger q25eHIVandRelatedDiseaseAtEntry;
	private BigInteger q25eHIVandRelatedDiseaseStayers;
	private BigInteger q25eHIVandRelatedDiseaseLeavers;

	private BigInteger q25eDevelopmentalDisabilityAtEntry;
	private BigInteger q25eDevelopmentalDisabilityStayers;
	private BigInteger q25eDevelopmentalDisabilityLeavers;

	private BigInteger q25ePhysicalDisabilityAtEntry;
	private BigInteger q25ePhysicalDisabilityStayers;
	private BigInteger q25ePhysicalDisabilityLeavers;
	/*
	 * "q25E Table Ends
	 *  
	 * */
	
	
	/*
	 * "q25F Table Starts
	 *  
	 * */
	private BigInteger q25fAdultsWithOnlyEarnedIncomeAtEntry;
	private BigInteger q25fAdultsWithOnlyEarnedIncomeStayers;
	private BigInteger q25fAdultsWithOnlyEarnedIncomeLeavers;
		
	private BigInteger q25fAdultsWithOnlyOtherIncomeAtEntry;
	private BigInteger q25fAdultsWithOnlyOtherIncomeStayers;
	private BigInteger q25fAdultsWithOnlyOtherIncomeLeavers;
		
	private BigInteger q25fAdultsWithBothEarnedAndOtherAtEntry;
	private BigInteger q25fAdultsWithBothEarnedAndOtherStayers;
	private BigInteger q25fAdultsWithBothEarnedAndOtherLeavers;
		
	private BigInteger q25fAdultsWithNoIncomeAtEntry;
	private BigInteger q25fAdultsWithNoIncomeStayers;
	private BigInteger q25fAdultsWithNoIncomeLeavers;
		
	private BigInteger q25fAdultsWithDontRefusedIncomeAtEntry;
	private BigInteger q25fAdultsWithDontRefusedIncomeStayers;
	private BigInteger q25fAdultsWithDontRefusedIncomeLeavers;
		
	private BigInteger q25fAdultsWithMissingInomeInfoAtEntry;
	private BigInteger q25fAdultsWithMissingInomeInfoStayers;
	private BigInteger q25fAdultsWithMissingInomeInfoLeavers;
		
	private BigInteger q25fNumberOfAdultStayersNotYetRequiredAtEntry;
	private BigInteger q25fNumberOfAdultStayersNotYetRequiredStayers;
	private BigInteger q25fNumberOfAdultStayersNotYetRequiredLeavers;
		
	private BigInteger q25fNumberOfAdultStayersWithoutRequiredAtEntry;
	private BigInteger q25fNumberOfAdultStayersWithoutRequiredStayers;
	private BigInteger q25fNumberOfAdultStayersWithoutRequiredLeavers;
		
	private BigInteger q25fTotalAdultsAtEntry;
	private BigInteger q25fTotalAdultsStayers;
	private BigInteger q25fTotalAdultsLeavers;
	/*
	 * "q25F Table Ends
	 *  
	 * */

	/*
	 * "q25G Table Starts
	 *  
	 * */
	private BigInteger q25gEarnedIncomeAtEntry;
	private BigInteger q25gEarnedIncomeStayers;
	private BigInteger q25gEarnedIncomeLeavers;
		
	private BigInteger q25gUnemploymentInsuranceAtEntry;
	private BigInteger q25gUnemploymentInsuranceStayers;
	private BigInteger q25gUnemploymentInsuranceLeavers;
		
	private BigInteger q25gSSIAtEntry;
	private BigInteger q25gSSIStayers;
	private BigInteger q25gSSILeavers;
		
	private BigInteger q25gSSDIAtEntry;
	private BigInteger q25gSSDIStayers;
	private BigInteger q25gSSDILeavers;
		
	private BigInteger q25gVAServiceConnectedDisabilityAtEntry;
	private BigInteger q25gVAServiceConnectedDisabilityStayers;
	private BigInteger q25gVAServiceConnectedDisabilityLeavers;
		
	private BigInteger q25gVANonServiceConnectedDisabilityAtEntry;
	private BigInteger q25gVANonServiceConnectedDisabilityStayers;
	private BigInteger q25gVANonServiceConnectedDisabilityLeavers;
		
	private BigInteger q25gPrivateDisabilityInsuranceAtEntry;
	private BigInteger q25gPrivateDisabilityInsuranceStayers;
	private BigInteger q25gPrivateDisabilityInsuranceLeavers;
		
	private BigInteger q25gWorkersCompensationAtEntry;
	private BigInteger q25gWorkersCompensationStayers;
	private BigInteger q25gWorkersCompensationLeavers;
		
	private BigInteger q25gTANFAtEntry;
	private BigInteger q25gTANFStayers;
	private BigInteger q25gTANFLeavers;
		
	private BigInteger q25gGeneralAssistanceAtEntry;
	private BigInteger q25gGeneralAssistanceStayers;
	private BigInteger q25gGeneralAssistanceLeavers;
		
	private BigInteger q25gRetirementAtEntry;
	private BigInteger q25gRetirementStayers;
	private BigInteger q25gRetirementLeavers;
		
	private BigInteger q25gPensionFromFormerJobAtEntry;
	private BigInteger q25gPensionFromFormerJobStayers;
	private BigInteger q25gPensionFromFormerJobLeavers;
		
	private BigInteger q25gChildSupportAtEntry;
	private BigInteger q25gChildSupportStayers;
	private BigInteger q25gChildSupportLeavers;
		
	private BigInteger q25gAlimonyAtEntry;
	private BigInteger q25gAlimonyStayers;
	private BigInteger q25gAlimonyLeavers;
		
	private BigInteger q25gOtherSourceAtEntry;
	private BigInteger q25gOtherSourceStayers;
	private BigInteger q25gOtherSourceLeavers;
		
	private BigInteger q25gAdultsWithIncomeInfoAtEntryAtEntry;
	private BigInteger q25gAdultsWithIncomeInfoAtEntryStayers;
	private BigInteger q25gAdultsWithIncomeInfoAtEntryLeavers;
	
	/*
	 * "q25G Table Ends
	 *  
	 * */

	/*
	 * "q25H Table Starts
	 *  
	 * */
	private BigInteger q25hSupplementalNutritionalAssistanceAtEntry;
	private BigInteger q25hSupplementalNutritionalAssistanceStayers;
	private BigInteger q25hSupplementalNutritionalAssistanceLeavers;

	private BigInteger q25hWICAtEntry;
	private BigInteger q25hWICStayers;
	private BigInteger q25hWICLeavers;
		
	private BigInteger q25hTANFChildCareServicesAtEntry;
	private BigInteger q25hTANFChildCareServicesStayers;
	private BigInteger q25hTANFChildCareServicesLeavers;
		
	private BigInteger q25hTANFTransportationServicesAtEntry;
	private BigInteger q25hTANFTransportationServicesStayers;
	private BigInteger q25hTANFTransportationServicesLeavers;
		
	private BigInteger q25hOtherTANFFundedServicesAtEntry;
	private BigInteger q25hOtherTANFFundedServicesStayers;
	private BigInteger q25hOtherTANFFundedServicesLeavers;
		
	private BigInteger q25hOtherSourceAtEntry;
	private BigInteger q25hOtherSourceStayers;
	private BigInteger q25hOtherSourceLeavers;
	/*
	 * "q25H Table Ends
	 *  
	 * */

	/*
	 * "q25I Table Starts
	 *  
	 * */
	private BigInteger q25iA01MovedFromOneHOPWATotal;
	private BigInteger q25iA01MovedFromOneHOPWAWithoutChild;
	private BigInteger q25iA01MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q25iA01MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q25iA01MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q25iA02OwnedByClientNoOngoingSubsidyTotal;
	private BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q25iA03OwnedByClientWithOngoingSubsidyTotal;
	private BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithoutChild;
	private BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	private BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	private BigInteger q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q25iA04RentalByClientNoOngoingSubsidyTotal;
	private BigInteger q25iA04RentalByClientNoOngoingSubsidyWithoutChild;
	private BigInteger q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	private BigInteger q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild;
	private BigInteger q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q25iA05RentalByClientVASHSubsidyTotal;
	private BigInteger q25iA05RentalByClientVASHSubsidyWithoutChild;
	private BigInteger q25iA05RentalByClientVASHSubsidyWithChildAndAdults;
	private BigInteger q25iA05RentalByClientVASHSubsidyWithOnlyChild;
	private BigInteger q25iA05RentalByClientVASHSubsidyUnknownHouseHold;
		
	private BigInteger q25iA06RentalByClientwithGPDTIPHousingTotal;
	private BigInteger q25iA06RentalByClientwithGPDTIPHousingWithoutChild;
	private BigInteger q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	private BigInteger q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild;
	private BigInteger q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold;
		
	private BigInteger q25iA07RentalByClientOtherOngoingSubsidyTotal;
	private BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithoutChild;
	private BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	private BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	private BigInteger q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
		
	private BigInteger q25iA08PermanentHousingForHomelessTotal;
	private BigInteger q25iA08PermanentHousingForHomelessWithoutChild;
	private BigInteger q25iA08PermanentHousingForHomelessWithChildAndAdults;
	private BigInteger q25iA08PermanentHousingForHomelessWithOnlyChild;
	private BigInteger q25iA08PermanentHousingForHomelessUnknownHouseHold;
		
	private BigInteger q25iA09StayingOrLivingWithFamilyPermanentTotal;
	private BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithoutChild;
	private BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	private BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	private BigInteger q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
		
	private BigInteger q25iA10StayingOrLivingWithFriendsPermanentTotal;
	private BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithoutChild;
	private BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	private BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	private BigInteger q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
		
	private BigInteger q25iAzTotTotal;
	private BigInteger q25iAzTotWithoutChild;
	private BigInteger q25iAzTotWithChildAndAdults;
	private BigInteger q25iAzTotWithOnlyChild;
	private BigInteger q25iAzTotUnknownHouseHold;
		
	private BigInteger q25iB1EmergencyShelterTotal;
	private BigInteger q25iB1EmergencyShelterWithoutChild;
	private BigInteger q25iB1EmergencyShelterWithChildAndAdults;
	private BigInteger q25iB1EmergencyShelterWithOnlyChild;
	private BigInteger q25iB1EmergencyShelterUnknownHouseHold;
		
	private BigInteger q25iB2MovedFromOneHOPWATotal;
	private BigInteger q25iB2MovedFromOneHOPWAWithoutChild;
	private BigInteger q25iB2MovedFromOneHOPWAWithChildAndAdults;
	private BigInteger q25iB2MovedFromOneHOPWAWithOnlyChild;
	private BigInteger q25iB2MovedFromOneHOPWAUnknownHouseHold;
		
	private BigInteger q25iB3TransitionalHousingForHomelessTotal;
	private BigInteger q25iB3TransitionalHousingForHomelessWithoutChild;
	private BigInteger q25iB3TransitionalHousingForHomelessWithChildAndAdults;
	private BigInteger q25iB3TransitionalHousingForHomelessWithOnlyChild;
	private BigInteger q25iB3TransitionalHousingForHomelessUnknownHouseHold;
		
	private BigInteger q25iB4StayingWithFamilyTemporaryTenureTotal;
	private BigInteger q25iB4StayingWithFamilyTemporaryTenureWithoutChild;
	private BigInteger q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	private BigInteger q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild;
	private BigInteger q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold;
		
	private BigInteger q25iB5StayingWithFriendsTemporaryTenureTotal;
	private BigInteger q25iB5StayingWithFriendsTemporaryTenureWithoutChild;
	private BigInteger q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	private BigInteger q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild;
	private BigInteger q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold;
		
	private BigInteger q25iB6PlaceNotMeantForHumanHabitationTotal;
	private BigInteger q25iB6PlaceNotMeantForHumanHabitationWithoutChild;
	private BigInteger q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	private BigInteger q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild;
	private BigInteger q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold;
		
	private BigInteger q25iB7SafeHavenTotal;
	private BigInteger q25iB7SafeHavenWithoutChild;
	private BigInteger q25iB7SafeHavenWithChildAndAdults;
	private BigInteger q25iB7SafeHavenWithOnlyChild;
	private BigInteger q25iB7SafeHavenUnknownHouseHold;
		
	private BigInteger q25iB8HotelOrMotelPaidbyClientTotal;
	private BigInteger q25iB8HotelOrMotelPaidbyClientWithoutChild;
	private BigInteger q25iB8HotelOrMotelPaidbyClientWithChildAndAdults;
	private BigInteger q25iB8HotelOrMotelPaidbyClientWithOnlyChild;
	private BigInteger q25iB8HotelOrMotelPaidbyClientUnknownHouseHold;
		
	private BigInteger q25iBzTotTotal;
	private BigInteger q25iBzTotWithoutChild;
	private BigInteger q25iBzTotWithChildAndAdults;
	private BigInteger q25iBzTotWithOnlyChild;
	private BigInteger q25iBzTotUnknownHouseHold;
		
	private BigInteger q25iC1FosterCareHomeOrGroupFosterCareTotal;
	private BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithoutChild;
	private BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	private BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	private BigInteger q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
		
	private BigInteger q25iC2PsychiatricHospitalOrOtherTotal;
	private BigInteger q25iC2PsychiatricHospitalOrOtherWithoutChild;
	private BigInteger q25iC2PsychiatricHospitalOrOtherWithChildAndAdults;
	private BigInteger q25iC2PsychiatricHospitalOrOtherWithOnlyChild;
	private BigInteger q25iC2PsychiatricHospitalOrOtherUnknownHouseHold;
		
	private BigInteger q25iC3SubstanceAbuseTreatmentFacilityTotal;
	private BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithoutChild;
	private BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	private BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	private BigInteger q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
		
	private BigInteger q25iC4HospitalOrOtherResidentialTotal;
	private BigInteger q25iC4HospitalOrOtherResidentialWithoutChild;
	private BigInteger q25iC4HospitalOrOtherResidentialWithChildAndAdults;
	private BigInteger q25iC4HospitalOrOtherResidentialWithOnlyChild;
	private BigInteger q25iC4HospitalOrOtherResidentialUnknownHouseHold;
		
	private BigInteger q25iC5JailPrisonOrUvenileDetentionTotal;
	private BigInteger q25iC5JailPrisonOrUvenileDetentionWithoutChild;
	private BigInteger q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults;
	private BigInteger q25iC5JailPrisonOrUvenileDetentionWithOnlyChild;
	private BigInteger q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold;
		
	private BigInteger q25iC6LongTermCareFacilityTotal;
	private BigInteger q25iC6LongTermCareFacilityWithoutChild;
	private BigInteger q25iC6LongTermCareFacilityWithChildAndAdults;
	private BigInteger q25iC6LongTermCareFacilityWithOnlyChild;
	private BigInteger q25iC6LongTermCareFacilityUnknownHouseHold;
		
	private BigInteger q25iCzTotTotal;
	private BigInteger q25iCzTotWithoutChild;
	private BigInteger q25iCzTotWithChildAndAdults;
	private BigInteger q25iCzTotWithOnlyChild;
	private BigInteger q25iCzTotUnknownHouseHold;
		
	private BigInteger q25iD1ResidentialProjectTotal;
	private BigInteger q25iD1ResidentialProjectWithoutChild;
	private BigInteger q25iD1ResidentialProjectWithChildAndAdults;
	private BigInteger q25iD1ResidentialProjectWithOnlyChild;
	private BigInteger q25iD1ResidentialProjectUnknownHouseHold;
		
	private BigInteger q25iD2DeceasedTotal;
	private BigInteger q25iD2DeceasedWithoutChild;
	private BigInteger q25iD2DeceasedWithChildAndAdults;
	private BigInteger q25iD2DeceasedWithOnlyChild;
	private BigInteger q25iD2DeceasedUnknownHouseHold;
		
	private BigInteger q25iD3OtherTotal;
	private BigInteger q25iD3OtherWithoutChild;
	private BigInteger q25iD3OtherWithChildAndAdults;
	private BigInteger q25iD3OtherWithOnlyChild;
	private BigInteger q25iD3OtherUnknownHouseHold;
		
	private BigInteger q25iD4DontKnowRefusedTotal;
	private BigInteger q25iD4DontKnowRefusedWithoutChild;
	private BigInteger q25iD4DontKnowRefusedWithChildAndAdults;
	private BigInteger q25iD4DontKnowRefusedWithOnlyChild;
	private BigInteger q25iD4DontKnowRefusedUnknownHouseHold;
		
	private BigInteger q25iD5InformationMissingTotal;
	private BigInteger q25iD5InformationMissingWithoutChild;
	private BigInteger q25iD5InformationMissingWithChildAndAdults;
	private BigInteger q25iD5InformationMissingWithOnlyChild;
	private BigInteger q25iD5InformationMissingUnknownHouseHold;
		
	private BigInteger q25iDzTotTotal;
	private BigInteger q25iDzTotWithoutChild;
	private BigInteger q25iDzTotWithChildAndAdults;
	private BigInteger q25iDzTotWithOnlyChild;
	private BigInteger q25iDzTotUnknownHouseHold;
		
	private BigInteger q25iETotTotal;
	private BigInteger q25iETotWithoutChild;
	private BigInteger q25iETotWithChildAndAdults;
	private BigInteger q25iETotWithOnlyChild;
	private BigInteger q25iETotUnknownHouseHold;
	
	private BigInteger q25iTotPersonsExistTotal;
	private BigInteger q25iTotPersonsExistWithoutChild;
	private BigInteger q25iTotPersonsExistWithChildAndAdults;
	private BigInteger q25iTotPersonsExistWithOnlyChild;
	private BigInteger q25iTotPersonsExistUnknownHouseHold;
	
	private BigInteger q25iTotPersonsDstnTotal;
	private BigInteger q25iTotPersonsDstnWithoutChild;
	private BigInteger q25iTotPersonsDstnWithChildAndAdults;
	private BigInteger q25iTotPersonsDstnWithOnlyChild;
	private BigInteger q25iTotPersonsDstnUnknownHouseHold;
	
	private BigInteger q25iPercentageTotal;
	private BigInteger q25iPercentageWithoutChild;
	private BigInteger q25iPercentageWithChildAndAdults;
	private BigInteger q25iPercentageWithOnlyChild;
	private BigInteger q25iPercentageUnknownHouseHold;
	/*
	 * "q25I Table Ends
	 *  
	 * */

	/*
	 * Q26A Table Starts
	 * 
	 * */
	private BigInteger q26aChronicallyHomelessTotal;
	private BigInteger q26aChronicallyHomelessWithoutChild;
	private BigInteger q26aChronicallyHomelessWithChildAndAdults;
	private BigInteger q26aChronicallyHomelessWithOnlyChild;
	private BigInteger q26aChronicallyHomelessUnknownHouseholdType;

	private BigInteger q26aNotChronicallyHomelessTotal;
	private BigInteger q26aNotChronicallyHomelessWithoutChild;
	private BigInteger q26aNotChronicallyHomelessWithChildAndAdults;
	private BigInteger q26aNotChronicallyHomelessWithOnlyChild;
	private BigInteger q26aNotChronicallyHomelessUnknownHouseholdType;

	private BigInteger q26aClientRefusedTotal;
	private BigInteger q26aClientRefusedWithoutChild;
	private BigInteger q26aClientRefusedWithChildAndAdults;
	private BigInteger q26aClientRefusedWithOnlyChild;
	private BigInteger q26aClientRefusedUnknownHouseholdType;

	private BigInteger q26aDataNotCollectedTotal;
	private BigInteger q26aDataNotCollectedWithoutChild;
	private BigInteger q26aDataNotCollectedWithChildAndAdults;
	private BigInteger q26aDataNotCollectedWithOnlyChild;
	private BigInteger q26aDataNotCollectedUnknownHouseholdType;

	private BigInteger q26aTotTotal;
	private BigInteger q26aTotWithoutChild;
	private BigInteger q26aTotWithChildAndAdults;
	private BigInteger q26aTotWithOnlyChild;
	private BigInteger q26aTotUnknownHouseholdType;
	/*
	 * Q26A Table Ends
	 * 
	 * */
	/*
	 * Q26B Table Starts
	 * 
	 * */
	private BigInteger q26bChronicallyHomelessTotal;
	private BigInteger q26bChronicallyHomelessWithoutChild;
	private BigInteger q26bChronicallyHomelessWithChildAndAdults;
	private BigInteger q26bChronicallyHomelessWithOnlyChild;
	private BigInteger q26bChronicallyHomelessUnknownHouseholdType;

	private BigInteger q26bNotChronicallyHomelessTotal;
	private BigInteger q26bNotChronicallyHomelessWithoutChild;
	private BigInteger q26bNotChronicallyHomelessWithChildAndAdults;
	private BigInteger q26bNotChronicallyHomelessWithOnlyChild;
	private BigInteger q26bNotChronicallyHomelessUnknownHouseholdType;

	private BigInteger q26bClientRefusedTotal;
	private BigInteger q26bClientRefusedWithoutChild;
	private BigInteger q26bClientRefusedWithChildAndAdults;
	private BigInteger q26bClientRefusedWithOnlyChild;
	private BigInteger q26bClientRefusedUnknownHouseholdType;

	private BigInteger q26bDataNotCollectedTotal;
	private BigInteger q26bDataNotCollectedWithoutChild;
	private BigInteger q26bDataNotCollectedWithChildAndAdults;
	private BigInteger q26bDataNotCollectedWithOnlyChild;
	private BigInteger q26bDataNotCollectedUnknownHouseholdType;

	private BigInteger q26bTotTotal;
	private BigInteger q26bTotWithoutChild;
	private BigInteger q26bTotWithChildAndAdults;
	private BigInteger q26bTotWithOnlyChild;
	private BigInteger q26bTotUnknownHouseholdType;
	/*
	 * Q26B Table Ends
	 * 
	 * */
	
	/*
	 * Q26C Table Starts
	 * 
	 * */
	private BigInteger q26cMaleTotal;
	private BigInteger q26cMaleWithoutChild;
	private BigInteger q26cMaleWithChildAndAdults;
	private BigInteger q26cMaleWithOnlyChild;
	private BigInteger q26cMaleUnknownHouseholdType;
		
	private BigInteger q26cFemaleTotal;
	private BigInteger q26cFemaleWithoutChild;
	private BigInteger q26cFemaleWithChildAndAdults;
	private BigInteger q26cFemaleWithOnlyChild;
	private BigInteger q26cFemaleUnknownHouseholdType;
		
	private BigInteger q26cTransgenderMaleToFemaleTotal;
	private BigInteger q26cTransgenderMaleToFemaleWithoutChild;
	private BigInteger q26cTransgenderMaleToFemaleWithChildAndAdults;
	private BigInteger q26cTransgenderMaleToFemaleWithOnlyChild;
	private BigInteger q26cTransgenderMaleToFemaleUnknownHouseholdType;
		
	private BigInteger q26cTransgenderFemaleToMaleTotal;
	private BigInteger q26cTransgenderFemaleToMaleWithoutChild;
	private BigInteger q26cTransgenderFemaleToMaleWithChildAndAdults;
	private BigInteger q26cTransgenderFemaleToMaleWithOnlyChild;
	private BigInteger q26cTransgenderFemaleToMaleUnknownHouseholdType;
		
	private BigInteger q26cOtherTotal;
	private BigInteger q26cOtherWithoutChild;
	private BigInteger q26cOtherWithChildAndAdults;
	private BigInteger q26cOtherWithOnlyChild;
	private BigInteger q26cOtherUnknownHouseholdType;
		
	private BigInteger q26cDKRTotal;
	private BigInteger q26cDKRWithoutChild;
	private BigInteger q26cDKRWithChildAndAdults;
	private BigInteger q26cDKRWithOnlyChild;
	private BigInteger q26cDKRUnknownHouseholdType;
		
	private BigInteger q26cInformationMissingTotal;
	private BigInteger q26cInformationMissingWithoutChild;
	private BigInteger q26cInformationMissingWithChildAndAdults;
	private BigInteger q26cInformationMissingWithOnlyChild;
	private BigInteger q26cInformationMissingUnknownHouseholdType;
		
	private BigInteger q26cSubtotalTotal;
	private BigInteger q26cSubtotalWithoutChild;
	private BigInteger q26cSubtotalWithChildAndAdults;
	private BigInteger q26cSubtotalWithOnlyChild;
	private BigInteger q26cSubtotalUnknownHouseholdType;
	/*
	 * Q26C Table Ends
	 * 
	 * */
	
	/*
	 * Q26D Table Starts
	 * 
	 * */
	private BigInteger q26d0To17Total;
	private BigInteger q26d0To17WithoutChild;
	private BigInteger q26d0To17WithChildAndAdults;
	private BigInteger q26d0To17WithOnlyChild;
	private BigInteger q26d0To17UnknownHouseholdType;
		
	private BigInteger q26d18To24Total;
	private BigInteger q26d18To24WithoutChild;
	private BigInteger q26d18To24WithChildAndAdults;
	private BigInteger q26d18To24WithOnlyChild;
	private BigInteger q26d18To24UnknownHouseholdType;
		
	private BigInteger q26d25To34Total;
	private BigInteger q26d25To34WithoutChild;
	private BigInteger q26d25To34WithChildAndAdults;
	private BigInteger q26d25To34WithOnlyChild;
	private BigInteger q26d25To34UnknownHouseholdType;
		
	private BigInteger q26d35To44Total;
	private BigInteger q26d35To44WithoutChild;
	private BigInteger q26d35To44WithChildAndAdults;
	private BigInteger q26d35To44WithOnlyChild;
	private BigInteger q26d35To44UnknownHouseholdType;
		
	private BigInteger q26d45To54Total;
	private BigInteger q26d45To54WithoutChild;
	private BigInteger q26d45To54WithChildAndAdults;
	private BigInteger q26d45To54WithOnlyChild;
	private BigInteger q26d45To54UnknownHouseholdType;
		
	private BigInteger q26d55To61Total;
	private BigInteger q26d55To61WithoutChild;
	private BigInteger q26d55To61WithChildAndAdults;
	private BigInteger q26d55To61WithOnlyChild;
	private BigInteger q26d55To61UnknownHouseholdType;
		
	private BigInteger q26d62PlusTotal;
	private BigInteger q26d62PlusWithoutChild;
	private BigInteger q26d62PlusWithChildAndAdults;
	private BigInteger q26d62PlusWithOnlyChild;
	private BigInteger q26d62PlusUnknownHouseholdType;
		
	private BigInteger q26dDKRTotal;
	private BigInteger q26dDKRWithoutChild;
	private BigInteger q26dDKRWithChildAndAdults;
	private BigInteger q26dDKRWithOnlyChild;
	private BigInteger q26dDKRUnknownHouseholdType;
		
	private BigInteger q26dInformationMissingTotal;
	private BigInteger q26dInformationMissingWithoutChild;
	private BigInteger q26dInformationMissingWithChildAndAdults;
	private BigInteger q26dInformationMissingWithOnlyChild;
	private BigInteger q26dInformationMissingUnknownHouseholdType;
		
	private BigInteger q26dSubtotalTotal;
	private BigInteger q26dSubtotalWithoutChild;
	private BigInteger q26dSubtotalWithChildAndAdults;
	private BigInteger q26dSubtotalWithOnlyChild;
	private BigInteger q26dSubtotalUnknownHouseholdType;
	
	/*
	 * Q26D Table Ends
	 * 
	 * */
	
	/*
	 * Q26E Table Starts
	 * 
	 * */
	private BigInteger q26eMentalIllnessAtEntry;
	private BigInteger q26eMentalIllnessStayers;
	private BigInteger q26eMentalIllnessLeavers;
		
	private BigInteger q26eAlcoholAbuseAtEntry;
	private BigInteger q26eAlcoholAbuseStayers;
	private BigInteger q26eAlcoholAbuseLeavers;
		
	private BigInteger q26eDrugAbuseAtEntry;
	private BigInteger q26eDrugAbuseStayers;
	private BigInteger q26eDrugAbuseLeavers;
		
	private BigInteger q26eBothAlcoholAndDrugAbuseAtEntry;
	private BigInteger q26eBothAlcoholAndDrugAbuseStayers;
	private BigInteger q26eBothAlcoholAndDrugAbuseLeavers;
		
	private BigInteger q26eChronicHealthConditionAtEntry;
	private BigInteger q26eChronicHealthConditionStayers;
	private BigInteger q26eChronicHealthConditionLeavers;
		
	private BigInteger q26eHIVAIDSAndRelatedDiseasesAtEntry;
	private BigInteger q26eHIVAIDSAndRelatedDiseasesStayers;
	private BigInteger q26eHIVAIDSAndRelatedDiseasesLeavers;
		
	private BigInteger q26eDevelopmentalDisabilityAtEntry;
	private BigInteger q26eDevelopmentalDisabilityStayers;
	private BigInteger q26eDevelopmentalDisabilityLeavers;
		
	private BigInteger q26ePhysicalDisabilityAtEntry;
	private BigInteger q26ePhysicalDisabilityStayers;
	private BigInteger q26ePhysicalDisabilityLeavers;
	
	/*
	 * Q26E Table Ends
	 * 
	 * */
	
	/*
	 * Q26F Table Starts
	 * 
	 * */
	private BigInteger q26fAdultsWithOnlyEarnedIncomeAtEntry;
	private BigInteger q26fAdultsWithOnlyEarnedIncomeStayers;
	private BigInteger q26fAdultsWithOnlyEarnedIncomeLeavers;
		
	private BigInteger q26fAdultsWithOnlyOtherIncomeAtEntry;
	private BigInteger q26fAdultsWithOnlyOtherIncomeStayers;
	private BigInteger q26fAdultsWithOnlyOtherIncomeLeavers;
		
	private BigInteger q26fAdultsWithBothEarnedAndOtherIncomeAtEntry;
	private BigInteger q26fAdultsWithBothEarnedAndOtherIncomeStayers;
	private BigInteger q26fAdultsWithBothEarnedAndOtherIncomeLeavers;
		
	private BigInteger q26fAdultsWithNoIncomeAtEntry;
	private BigInteger q26fAdultsWithNoIncomeStayers;
	private BigInteger q26fAdultsWithNoIncomeLeavers;
		
	private BigInteger q26fAdultsWithDontRefusedIncomeAtEntry;
	private BigInteger q26fAdultsWithDontRefusedIncomeStayers;
	private BigInteger q26fAdultsWithDontRefusedIncomeLeavers;
		
	private BigInteger q26fAdultsWithMissingIncomeInfoAtEntry;
	private BigInteger q26fAdultsWithMissingIncomeInfoStayers;
	private BigInteger q26fAdultsWithMissingIncomeInfoLeavers;
		
	private BigInteger q26fNumberOfAdultStayersNotYetRequiredAtEntry;
	private BigInteger q26fNumberOfAdultStayersNotYetRequiredStayers;
	private BigInteger q26fNumberOfAdultStayersNotYetRequiredLeavers;
		
	private BigInteger q26fNumberOfAdultStayersWithoutRequiredAtEntry;
	private BigInteger q26fNumberOfAdultStayersWithoutRequiredStayers;
	private BigInteger q26fNumberOfAdultStayersWithoutRequiredLeavers;
		
	private BigInteger q26fTotalAdultsAtEntry;
	private BigInteger q26fTotalAdultsStayers;
	private BigInteger q26fTotalAdultsLeavers;
	
	/*
	 * Q26F Table Ends
	 * 
	 * */
	
	/*
	 * Q26G Table Starts
	 * 
	 * */
	private BigInteger q26gEarnedIncomeAtEntry;
	private BigInteger q26gEarnedIncomeStayers;
	private BigInteger q26gEarnedIncomeLeavers;
		
	private BigInteger q26gUnemploymentInsuranceAtEntry;
	private BigInteger q26gUnemploymentInsuranceStayers;
	private BigInteger q26gUnemploymentInsuranceLeavers;
		
	private BigInteger q26gSSIAtEntry;
	private BigInteger q26gSSIStayers;
	private BigInteger q26gSSILeavers;
		
	private BigInteger q26gSSDIAtEntry;
	private BigInteger q26gSSDIStayers;
	private BigInteger q26gSSDILeavers;
		
	private BigInteger q26gVAServiceConnectedDisabilityAtEntry;
	private BigInteger q26gVAServiceConnectedDisabilityStayers;
	private BigInteger q26gVAServiceConnectedDisabilityLeavers;
		
	private BigInteger q26gVANonServiceConnectedDisabilityAtEntry;
	private BigInteger q26gVANonServiceConnectedDisabilityStayers;
	private BigInteger q26gVANonServiceConnectedDisabilityLeavers;
		
	private BigInteger q26gPrivateDisabilityInsuranceAtEntry;
	private BigInteger q26gPrivateDisabilityInsuranceStayers;
	private BigInteger q26gPrivateDisabilityInsuranceLeavers;
		
	private BigInteger q26gWorkerCompensationAtEntry;
	private BigInteger q26gWorkerCompensationStayers;
	private BigInteger q26gWorkerCompensationLeavers;
		
	private BigInteger q26gTANFAtEntry;
	private BigInteger q26gTANFStayers;
	private BigInteger q26gTANFLeavers;
		
	private BigInteger q26gGeneralAssistanceAtEntry;
	private BigInteger q26gGeneralAssistanceStayers;
	private BigInteger q26gGeneralAssistanceLeavers;
		
	private BigInteger q26gRetirementAtEntry;
	private BigInteger q26gRetirementStayers;
	private BigInteger q26gRetirementLeavers;
		
	private BigInteger q26gPensionFromFormerJobAtEntry;
	private BigInteger q26gPensionFromFormerJobStayers;
	private BigInteger q26gPensionFromFormerJobLeavers;
		
	private BigInteger q26gChildSupportAtEntry;
	private BigInteger q26gChildSupportStayers;
	private BigInteger q26gChildSupportLeavers;
		
	private BigInteger q26gAlimonyAtEntry;
	private BigInteger q26gAlimonyStayers;
	private BigInteger q26gAlimonyLeavers;
		
	private BigInteger q26gOtherSourceAtEntry;
	private BigInteger q26gOtherSourceStayers;
	private BigInteger q26gOtherSourceLeavers;
		
	private BigInteger q26gAdultsWithIncomeInfoAtEntry;
	private BigInteger q26gAdultsWithIncomeInfoStayers;
	private BigInteger q26gAdultsWithIncomeInfoLeavers;
	
	/*
	 * Q26G Table Ends
	 * 
	 * */
	
	/*
	 * Q26H Table Starts
	 * 
	 * */
	private BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry;
	private BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceStayers;
	private BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers;
		
	private BigInteger q26hWICAtEntry;
	private BigInteger q26hWICStayers;
	private BigInteger q26hWICLeavers;
		
	private BigInteger q26hTANFChildCareServicesAtEntry;
	private BigInteger q26hTANFChildCareServicesStayers;
	private BigInteger q26hTANFChildCareServicesLeavers;
		
	private BigInteger q26hTANFTransportationServicesAtEntry;
	private BigInteger q26hTANFTransportationServicesStayers;
	private BigInteger q26hTANFTransportationServicesLeavers;
		
	private BigInteger q26hOtherTANFFundedServicesAtEntry;
	private BigInteger q26hOtherTANFFundedServicesStayers;
	private BigInteger q26hOtherTANFFundedServicesLeavers;
		
	private BigInteger q26hOtherSourceAtEntry;
	private BigInteger q26hOtherSourceStayers;
	private BigInteger q26hOtherSourceLeavers;
	/*
	 * Q26H Table Ends
	 * 
	 * */
	
	/*
	 * Q27A Table Starts
	 * 
	 * */
	private BigInteger q27a12To17Total;
	private BigInteger q27a12To17WithoutChild;
	private BigInteger q27a12To17WithChildAndAdults;
	private BigInteger q27a12To17WithChildOnly;
	private BigInteger q27a12To17UnknownHouseHoldtype;
		
	private BigInteger q27a18To24Total;
	private BigInteger q27a18To24WithoutChild;
	private BigInteger q27a18To24WithChildAndAdults;
	private BigInteger q27a18To24WithChildOnly;
	private BigInteger q27a18To24UnknownHouseHoldtype;
		
	private BigInteger q27aDKRTotal;
	private BigInteger q27aDKRWithoutChild;
	private BigInteger q27aDKRWithChildAndAdults;
	private BigInteger q27aDKRWithChildOnly;
	private BigInteger q27aDKRUnknownHouseHoldtype;
		
	private BigInteger q27aInformationMissingTotal;
	private BigInteger q27aInformationMissingWithoutChild;
	private BigInteger q27aInformationMissingWithChildAndAdults;
	private BigInteger q27aInformationMissingWithChildOnly;
	private BigInteger q27aInformationMissingUnknownHouseHoldtype;
		
	private BigInteger q27aTotTotal;
	private BigInteger q27aTotWithoutChild;
	private BigInteger q27aTotWithChildAndAdults;
	private BigInteger q27aTotWithChildOnly;
	private BigInteger q27aTotUnknownHouseHoldtype;
	/*
	 * Q27A Table Ends
	 * 
	 * */
	/*
	 * Q27B Table Starts
	 * 
	 * */
	private BigInteger q27bParentYouthLeassThan18TotalParentingYouth;
	private BigInteger q27bParentYouthLeassThan18TotalChildrenOfParentingYouth;
	private BigInteger q27bParentYouthLeassThan18TotalPersons;
	private BigInteger q27bParentYouthLeassThan18TotalHouseholds;

	private BigInteger q27bParentYouth18To24TotalParentingYouth;
	private BigInteger q27bParentYouth18To24TotalChildrenOfParentingYouth;
	private BigInteger q27bParentYouth18To24TotalPersons;
	private BigInteger q27bParentYouth18To24TotalHouseholds;
	/*
	 * Q27B Table Ends
	 * 
	 * */
	/*
	 * Q27C Table Starts
	 * 
	 * */
	private BigInteger q27cMaleTotal;
	private BigInteger q27cMaleWithoutChild;
	private BigInteger q27cMaleWithChildAndAdults;
	private BigInteger q27cMaleWithChildOnly;
	private BigInteger q27cMaleUnknownHouseHoldtype;
		
	private BigInteger q27cFemaleTotal;
	private BigInteger q27cFemaleWithoutChild;
	private BigInteger q27cFemaleWithChildAndAdults;
	private BigInteger q27cFemaleWithChildOnly;
	private BigInteger q27cFemaleUnknownHouseHoldtype;
		
	private BigInteger q27cTransgenderMaleToFemaleTotal;
	private BigInteger q27cTransgenderMaleToFemaleWithoutChild;
	private BigInteger q27cTransgenderMaleToFemaleWithChildAndAdults;
	private BigInteger q27cTransgenderMaleToFemaleWithChildOnly;
	private BigInteger q27cTransgenderMaleToFemaleUnknownHouseHoldtype;
		
	private BigInteger q27cTransgenderFemaleToMaleTotal;
	private BigInteger q27cTransgenderFemaleToMaleWithoutChild;
	private BigInteger q27cTransgenderFemaleToMaleWithChildAndAdults;
	private BigInteger q27cTransgenderFemaleToMaleWithChildOnly;
	private BigInteger q27cTransgenderFemaleToMaleUnknownHouseHoldtype;
		
	private BigInteger q27cOtherTotal;
	private BigInteger q27cOtherWithoutChild;
	private BigInteger q27cOtherWithChildAndAdults;
	private BigInteger q27cOtherWithChildOnly;
	private BigInteger q27cOtherUnknownHouseHoldtype;
		
	private BigInteger q27cDKRTotal;
	private BigInteger q27cDKRWithoutChild;
	private BigInteger q27cDKRWithChildAndAdults;
	private BigInteger q27cDKRWithChildOnly;
	private BigInteger q27cDKRUnknownHouseHoldtype;
		
	private BigInteger q27cInformationMissingTotal;
	private BigInteger q27cInformationMissingWithoutChild;
	private BigInteger q27cInformationMissingWithChildAndAdults;
	private BigInteger q27cInformationMissingWithChildOnly;
	private BigInteger q27cInformationMissingUnknownHouseHoldtype;
		
	private BigInteger q27cTotTotal;
	private BigInteger q27cTotWithoutChild;
	private BigInteger q27cTotWithChildAndAdults;
	private BigInteger q27cTotWithChildOnly;
	private BigInteger q27cTotUnknownHouseHoldtype;
	/*
	 * Q27C Table Ends
	 * 
	 * */
	
	public BigInteger getQ23APermanentDestinationsTotal() {
		return q23APermanentDestinationsTotal;
	}

	

	public BigInteger getQ27cMaleTotal() {
		return q27cMaleTotal;
	}

	public void setQ27cMaleTotal(BigInteger q27cMaleTotal) {
		this.q27cMaleTotal = q27cMaleTotal;
	}

	public BigInteger getQ27cMaleWithoutChild() {
		return q27cMaleWithoutChild;
	}

	public void setQ27cMaleWithoutChild(BigInteger q27cMaleWithoutChild) {
		this.q27cMaleWithoutChild = q27cMaleWithoutChild;
	}

	public BigInteger getQ27cMaleWithChildAndAdults() {
		return q27cMaleWithChildAndAdults;
	}

	public void setQ27cMaleWithChildAndAdults(BigInteger q27cMaleWithChildAndAdults) {
		this.q27cMaleWithChildAndAdults = q27cMaleWithChildAndAdults;
	}

	public BigInteger getQ27cMaleWithChildOnly() {
		return q27cMaleWithChildOnly;
	}

	public void setQ27cMaleWithChildOnly(BigInteger q27cMaleWithChildOnly) {
		this.q27cMaleWithChildOnly = q27cMaleWithChildOnly;
	}

	public BigInteger getQ27cMaleUnknownHouseHoldtype() {
		return q27cMaleUnknownHouseHoldtype;
	}

	public void setQ27cMaleUnknownHouseHoldtype(
			BigInteger q27cMaleUnknownHouseHoldtype) {
		this.q27cMaleUnknownHouseHoldtype = q27cMaleUnknownHouseHoldtype;
	}

	public BigInteger getQ27cFemaleTotal() {
		return q27cFemaleTotal;
	}

	public void setQ27cFemaleTotal(BigInteger q27cFemaleTotal) {
		this.q27cFemaleTotal = q27cFemaleTotal;
	}

	public BigInteger getQ27cFemaleWithoutChild() {
		return q27cFemaleWithoutChild;
	}

	public void setQ27cFemaleWithoutChild(BigInteger q27cFemaleWithoutChild) {
		this.q27cFemaleWithoutChild = q27cFemaleWithoutChild;
	}

	public BigInteger getQ27cFemaleWithChildAndAdults() {
		return q27cFemaleWithChildAndAdults;
	}

	public void setQ27cFemaleWithChildAndAdults(
			BigInteger q27cFemaleWithChildAndAdults) {
		this.q27cFemaleWithChildAndAdults = q27cFemaleWithChildAndAdults;
	}

	public BigInteger getQ27cFemaleWithChildOnly() {
		return q27cFemaleWithChildOnly;
	}

	public void setQ27cFemaleWithChildOnly(BigInteger q27cFemaleWithChildOnly) {
		this.q27cFemaleWithChildOnly = q27cFemaleWithChildOnly;
	}

	public BigInteger getQ27cFemaleUnknownHouseHoldtype() {
		return q27cFemaleUnknownHouseHoldtype;
	}

	public void setQ27cFemaleUnknownHouseHoldtype(
			BigInteger q27cFemaleUnknownHouseHoldtype) {
		this.q27cFemaleUnknownHouseHoldtype = q27cFemaleUnknownHouseHoldtype;
	}

	public BigInteger getQ27cTransgenderMaleToFemaleTotal() {
		return q27cTransgenderMaleToFemaleTotal;
	}

	public void setQ27cTransgenderMaleToFemaleTotal(
			BigInteger q27cTransgenderMaleToFemaleTotal) {
		this.q27cTransgenderMaleToFemaleTotal = q27cTransgenderMaleToFemaleTotal;
	}

	public BigInteger getQ27cTransgenderMaleToFemaleWithoutChild() {
		return q27cTransgenderMaleToFemaleWithoutChild;
	}

	public void setQ27cTransgenderMaleToFemaleWithoutChild(
			BigInteger q27cTransgenderMaleToFemaleWithoutChild) {
		this.q27cTransgenderMaleToFemaleWithoutChild = q27cTransgenderMaleToFemaleWithoutChild;
	}

	public BigInteger getQ27cTransgenderMaleToFemaleWithChildAndAdults() {
		return q27cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public void setQ27cTransgenderMaleToFemaleWithChildAndAdults(
			BigInteger q27cTransgenderMaleToFemaleWithChildAndAdults) {
		this.q27cTransgenderMaleToFemaleWithChildAndAdults = q27cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public BigInteger getQ27cTransgenderMaleToFemaleWithChildOnly() {
		return q27cTransgenderMaleToFemaleWithChildOnly;
	}

	public void setQ27cTransgenderMaleToFemaleWithChildOnly(
			BigInteger q27cTransgenderMaleToFemaleWithChildOnly) {
		this.q27cTransgenderMaleToFemaleWithChildOnly = q27cTransgenderMaleToFemaleWithChildOnly;
	}

	public BigInteger getQ27cTransgenderMaleToFemaleUnknownHouseHoldtype() {
		return q27cTransgenderMaleToFemaleUnknownHouseHoldtype;
	}

	public void setQ27cTransgenderMaleToFemaleUnknownHouseHoldtype(
			BigInteger q27cTransgenderMaleToFemaleUnknownHouseHoldtype) {
		this.q27cTransgenderMaleToFemaleUnknownHouseHoldtype = q27cTransgenderMaleToFemaleUnknownHouseHoldtype;
	}

	public BigInteger getQ27cTransgenderFemaleToMaleTotal() {
		return q27cTransgenderFemaleToMaleTotal;
	}

	public void setQ27cTransgenderFemaleToMaleTotal(
			BigInteger q27cTransgenderFemaleToMaleTotal) {
		this.q27cTransgenderFemaleToMaleTotal = q27cTransgenderFemaleToMaleTotal;
	}

	public BigInteger getQ27cTransgenderFemaleToMaleWithoutChild() {
		return q27cTransgenderFemaleToMaleWithoutChild;
	}

	public void setQ27cTransgenderFemaleToMaleWithoutChild(
			BigInteger q27cTransgenderFemaleToMaleWithoutChild) {
		this.q27cTransgenderFemaleToMaleWithoutChild = q27cTransgenderFemaleToMaleWithoutChild;
	}

	public BigInteger getQ27cTransgenderFemaleToMaleWithChildAndAdults() {
		return q27cTransgenderFemaleToMaleWithChildAndAdults;
	}

	public void setQ27cTransgenderFemaleToMaleWithChildAndAdults(
			BigInteger q27cTransgenderFemaleToMaleWithChildAndAdults) {
		this.q27cTransgenderFemaleToMaleWithChildAndAdults = q27cTransgenderFemaleToMaleWithChildAndAdults;
	}

	public BigInteger getQ27cTransgenderFemaleToMaleWithChildOnly() {
		return q27cTransgenderFemaleToMaleWithChildOnly;
	}

	public void setQ27cTransgenderFemaleToMaleWithChildOnly(
			BigInteger q27cTransgenderFemaleToMaleWithChildOnly) {
		this.q27cTransgenderFemaleToMaleWithChildOnly = q27cTransgenderFemaleToMaleWithChildOnly;
	}

	public BigInteger getQ27cTransgenderFemaleToMaleUnknownHouseHoldtype() {
		return q27cTransgenderFemaleToMaleUnknownHouseHoldtype;
	}

	public void setQ27cTransgenderFemaleToMaleUnknownHouseHoldtype(
			BigInteger q27cTransgenderFemaleToMaleUnknownHouseHoldtype) {
		this.q27cTransgenderFemaleToMaleUnknownHouseHoldtype = q27cTransgenderFemaleToMaleUnknownHouseHoldtype;
	}

	public BigInteger getQ27cOtherTotal() {
		return q27cOtherTotal;
	}

	public void setQ27cOtherTotal(BigInteger q27cOtherTotal) {
		this.q27cOtherTotal = q27cOtherTotal;
	}

	public BigInteger getQ27cOtherWithoutChild() {
		return q27cOtherWithoutChild;
	}

	public void setQ27cOtherWithoutChild(BigInteger q27cOtherWithoutChild) {
		this.q27cOtherWithoutChild = q27cOtherWithoutChild;
	}

	public BigInteger getQ27cOtherWithChildAndAdults() {
		return q27cOtherWithChildAndAdults;
	}

	public void setQ27cOtherWithChildAndAdults(
			BigInteger q27cOtherWithChildAndAdults) {
		this.q27cOtherWithChildAndAdults = q27cOtherWithChildAndAdults;
	}

	public BigInteger getQ27cOtherWithChildOnly() {
		return q27cOtherWithChildOnly;
	}

	public void setQ27cOtherWithChildOnly(BigInteger q27cOtherWithChildOnly) {
		this.q27cOtherWithChildOnly = q27cOtherWithChildOnly;
	}

	public BigInteger getQ27cOtherUnknownHouseHoldtype() {
		return q27cOtherUnknownHouseHoldtype;
	}

	public void setQ27cOtherUnknownHouseHoldtype(
			BigInteger q27cOtherUnknownHouseHoldtype) {
		this.q27cOtherUnknownHouseHoldtype = q27cOtherUnknownHouseHoldtype;
	}

	public BigInteger getQ27cDKRTotal() {
		return q27cDKRTotal;
	}

	public void setQ27cDKRTotal(BigInteger q27cDKRTotal) {
		this.q27cDKRTotal = q27cDKRTotal;
	}

	public BigInteger getQ27cDKRWithoutChild() {
		return q27cDKRWithoutChild;
	}

	public void setQ27cDKRWithoutChild(BigInteger q27cDKRWithoutChild) {
		this.q27cDKRWithoutChild = q27cDKRWithoutChild;
	}

	public BigInteger getQ27cDKRWithChildAndAdults() {
		return q27cDKRWithChildAndAdults;
	}

	public void setQ27cDKRWithChildAndAdults(BigInteger q27cDKRWithChildAndAdults) {
		this.q27cDKRWithChildAndAdults = q27cDKRWithChildAndAdults;
	}

	public BigInteger getQ27cDKRWithChildOnly() {
		return q27cDKRWithChildOnly;
	}

	public void setQ27cDKRWithChildOnly(BigInteger q27cDKRWithChildOnly) {
		this.q27cDKRWithChildOnly = q27cDKRWithChildOnly;
	}

	public BigInteger getQ27cDKRUnknownHouseHoldtype() {
		return q27cDKRUnknownHouseHoldtype;
	}

	public void setQ27cDKRUnknownHouseHoldtype(
			BigInteger q27cDKRUnknownHouseHoldtype) {
		this.q27cDKRUnknownHouseHoldtype = q27cDKRUnknownHouseHoldtype;
	}

	public BigInteger getQ27cInformationMissingTotal() {
		return q27cInformationMissingTotal;
	}

	public void setQ27cInformationMissingTotal(
			BigInteger q27cInformationMissingTotal) {
		this.q27cInformationMissingTotal = q27cInformationMissingTotal;
	}

	public BigInteger getQ27cInformationMissingWithoutChild() {
		return q27cInformationMissingWithoutChild;
	}

	public void setQ27cInformationMissingWithoutChild(
			BigInteger q27cInformationMissingWithoutChild) {
		this.q27cInformationMissingWithoutChild = q27cInformationMissingWithoutChild;
	}

	public BigInteger getQ27cInformationMissingWithChildAndAdults() {
		return q27cInformationMissingWithChildAndAdults;
	}

	public void setQ27cInformationMissingWithChildAndAdults(
			BigInteger q27cInformationMissingWithChildAndAdults) {
		this.q27cInformationMissingWithChildAndAdults = q27cInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ27cInformationMissingWithChildOnly() {
		return q27cInformationMissingWithChildOnly;
	}

	public void setQ27cInformationMissingWithChildOnly(
			BigInteger q27cInformationMissingWithChildOnly) {
		this.q27cInformationMissingWithChildOnly = q27cInformationMissingWithChildOnly;
	}

	public BigInteger getQ27cInformationMissingUnknownHouseHoldtype() {
		return q27cInformationMissingUnknownHouseHoldtype;
	}

	public void setQ27cInformationMissingUnknownHouseHoldtype(
			BigInteger q27cInformationMissingUnknownHouseHoldtype) {
		this.q27cInformationMissingUnknownHouseHoldtype = q27cInformationMissingUnknownHouseHoldtype;
	}

	public BigInteger getQ27cTotTotal() {
		return q27cTotTotal;
	}

	public void setQ27cTotTotal(BigInteger q27cTotTotal) {
		this.q27cTotTotal = q27cTotTotal;
	}

	public BigInteger getQ27cTotWithoutChild() {
		return q27cTotWithoutChild;
	}

	public void setQ27cTotWithoutChild(BigInteger q27cTotWithoutChild) {
		this.q27cTotWithoutChild = q27cTotWithoutChild;
	}

	public BigInteger getQ27cTotWithChildAndAdults() {
		return q27cTotWithChildAndAdults;
	}

	public void setQ27cTotWithChildAndAdults(BigInteger q27cTotWithChildAndAdults) {
		this.q27cTotWithChildAndAdults = q27cTotWithChildAndAdults;
	}

	public BigInteger getQ27cTotWithChildOnly() {
		return q27cTotWithChildOnly;
	}

	public void setQ27cTotWithChildOnly(BigInteger q27cTotWithChildOnly) {
		this.q27cTotWithChildOnly = q27cTotWithChildOnly;
	}

	public BigInteger getQ27cTotUnknownHouseHoldtype() {
		return q27cTotUnknownHouseHoldtype;
	}

	public void setQ27cTotUnknownHouseHoldtype(
			BigInteger q27cTotUnknownHouseHoldtype) {
		this.q27cTotUnknownHouseHoldtype = q27cTotUnknownHouseHoldtype;
	}

	public BigInteger getQ27bParentYouthLeassThan18TotalParentingYouth() {
		return q27bParentYouthLeassThan18TotalParentingYouth;
	}

	public void setQ27bParentYouthLeassThan18TotalParentingYouth(
			BigInteger q27bParentYouthLeassThan18TotalParentingYouth) {
		this.q27bParentYouthLeassThan18TotalParentingYouth = q27bParentYouthLeassThan18TotalParentingYouth;
	}

	public BigInteger getQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth() {
		return q27bParentYouthLeassThan18TotalChildrenOfParentingYouth;
	}

	public void setQ27bParentYouthLeassThan18TotalChildrenOfParentingYouth(
			BigInteger q27bParentYouthLeassThan18TotalChildrenOfParentingYouth) {
		this.q27bParentYouthLeassThan18TotalChildrenOfParentingYouth = q27bParentYouthLeassThan18TotalChildrenOfParentingYouth;
	}

	public BigInteger getQ27bParentYouthLeassThan18TotalPersons() {
		return q27bParentYouthLeassThan18TotalPersons;
	}

	public void setQ27bParentYouthLeassThan18TotalPersons(
			BigInteger q27bParentYouthLeassThan18TotalPersons) {
		this.q27bParentYouthLeassThan18TotalPersons = q27bParentYouthLeassThan18TotalPersons;
	}

	public BigInteger getQ27bParentYouthLeassThan18TotalHouseholds() {
		return q27bParentYouthLeassThan18TotalHouseholds;
	}

	public void setQ27bParentYouthLeassThan18TotalHouseholds(
			BigInteger q27bParentYouthLeassThan18TotalHouseholds) {
		this.q27bParentYouthLeassThan18TotalHouseholds = q27bParentYouthLeassThan18TotalHouseholds;
	}

	public BigInteger getQ27bParentYouth18To24TotalParentingYouth() {
		return q27bParentYouth18To24TotalParentingYouth;
	}

	public void setQ27bParentYouth18To24TotalParentingYouth(
			BigInteger q27bParentYouth18To24TotalParentingYouth) {
		this.q27bParentYouth18To24TotalParentingYouth = q27bParentYouth18To24TotalParentingYouth;
	}

	public BigInteger getQ27bParentYouth18To24TotalChildrenOfParentingYouth() {
		return q27bParentYouth18To24TotalChildrenOfParentingYouth;
	}

	public void setQ27bParentYouth18To24TotalChildrenOfParentingYouth(
			BigInteger q27bParentYouth18To24TotalChildrenOfParentingYouth) {
		this.q27bParentYouth18To24TotalChildrenOfParentingYouth = q27bParentYouth18To24TotalChildrenOfParentingYouth;
	}

	public BigInteger getQ27bParentYouth18To24TotalPersons() {
		return q27bParentYouth18To24TotalPersons;
	}

	public void setQ27bParentYouth18To24TotalPersons(
			BigInteger q27bParentYouth18To24TotalPersons) {
		this.q27bParentYouth18To24TotalPersons = q27bParentYouth18To24TotalPersons;
	}

	public BigInteger getQ27bParentYouth18To24TotalHouseholds() {
		return q27bParentYouth18To24TotalHouseholds;
	}

	public void setQ27bParentYouth18To24TotalHouseholds(
			BigInteger q27bParentYouth18To24TotalHouseholds) {
		this.q27bParentYouth18To24TotalHouseholds = q27bParentYouth18To24TotalHouseholds;
	}

	public BigInteger getQ27a12To17Total() {
		return q27a12To17Total;
	}

	public void setQ27a12To17Total(BigInteger q27a12To17Total) {
		this.q27a12To17Total = q27a12To17Total;
	}

	public BigInteger getQ27a12To17WithoutChild() {
		return q27a12To17WithoutChild;
	}

	public void setQ27a12To17WithoutChild(BigInteger q27a12To17WithoutChild) {
		this.q27a12To17WithoutChild = q27a12To17WithoutChild;
	}

	public BigInteger getQ27a12To17WithChildAndAdults() {
		return q27a12To17WithChildAndAdults;
	}

	public void setQ27a12To17WithChildAndAdults(
			BigInteger q27a12To17WithChildAndAdults) {
		this.q27a12To17WithChildAndAdults = q27a12To17WithChildAndAdults;
	}

	public BigInteger getQ27a12To17WithChildOnly() {
		return q27a12To17WithChildOnly;
	}

	public void setQ27a12To17WithChildOnly(BigInteger q27a12To17WithChildOnly) {
		this.q27a12To17WithChildOnly = q27a12To17WithChildOnly;
	}

	public BigInteger getQ27a12To17UnknownHouseHoldtype() {
		return q27a12To17UnknownHouseHoldtype;
	}

	public void setQ27a12To17UnknownHouseHoldtype(
			BigInteger q27a12To17UnknownHouseHoldtype) {
		this.q27a12To17UnknownHouseHoldtype = q27a12To17UnknownHouseHoldtype;
	}

	public BigInteger getQ27a18To24Total() {
		return q27a18To24Total;
	}

	public void setQ27a18To24Total(BigInteger q27a18To24Total) {
		this.q27a18To24Total = q27a18To24Total;
	}

	public BigInteger getQ27a18To24WithoutChild() {
		return q27a18To24WithoutChild;
	}

	public void setQ27a18To24WithoutChild(BigInteger q27a18To24WithoutChild) {
		this.q27a18To24WithoutChild = q27a18To24WithoutChild;
	}

	public BigInteger getQ27a18To24WithChildAndAdults() {
		return q27a18To24WithChildAndAdults;
	}

	public void setQ27a18To24WithChildAndAdults(
			BigInteger q27a18To24WithChildAndAdults) {
		this.q27a18To24WithChildAndAdults = q27a18To24WithChildAndAdults;
	}

	public BigInteger getQ27a18To24WithChildOnly() {
		return q27a18To24WithChildOnly;
	}

	public void setQ27a18To24WithChildOnly(BigInteger q27a18To24WithChildOnly) {
		this.q27a18To24WithChildOnly = q27a18To24WithChildOnly;
	}

	public BigInteger getQ27a18To24UnknownHouseHoldtype() {
		return q27a18To24UnknownHouseHoldtype;
	}

	public void setQ27a18To24UnknownHouseHoldtype(
			BigInteger q27a18To24UnknownHouseHoldtype) {
		this.q27a18To24UnknownHouseHoldtype = q27a18To24UnknownHouseHoldtype;
	}

	public BigInteger getQ27aDKRTotal() {
		return q27aDKRTotal;
	}

	public void setQ27aDKRTotal(BigInteger q27aDKRTotal) {
		this.q27aDKRTotal = q27aDKRTotal;
	}

	public BigInteger getQ27aDKRWithoutChild() {
		return q27aDKRWithoutChild;
	}

	public void setQ27aDKRWithoutChild(BigInteger q27aDKRWithoutChild) {
		this.q27aDKRWithoutChild = q27aDKRWithoutChild;
	}

	public BigInteger getQ27aDKRWithChildAndAdults() {
		return q27aDKRWithChildAndAdults;
	}

	public void setQ27aDKRWithChildAndAdults(BigInteger q27aDKRWithChildAndAdults) {
		this.q27aDKRWithChildAndAdults = q27aDKRWithChildAndAdults;
	}

	public BigInteger getQ27aDKRWithChildOnly() {
		return q27aDKRWithChildOnly;
	}

	public void setQ27aDKRWithChildOnly(BigInteger q27aDKRWithChildOnly) {
		this.q27aDKRWithChildOnly = q27aDKRWithChildOnly;
	}

	public BigInteger getQ27aDKRUnknownHouseHoldtype() {
		return q27aDKRUnknownHouseHoldtype;
	}

	public void setQ27aDKRUnknownHouseHoldtype(
			BigInteger q27aDKRUnknownHouseHoldtype) {
		this.q27aDKRUnknownHouseHoldtype = q27aDKRUnknownHouseHoldtype;
	}

	public BigInteger getQ27aInformationMissingTotal() {
		return q27aInformationMissingTotal;
	}

	public void setQ27aInformationMissingTotal(
			BigInteger q27aInformationMissingTotal) {
		this.q27aInformationMissingTotal = q27aInformationMissingTotal;
	}

	public BigInteger getQ27aInformationMissingWithoutChild() {
		return q27aInformationMissingWithoutChild;
	}

	public void setQ27aInformationMissingWithoutChild(
			BigInteger q27aInformationMissingWithoutChild) {
		this.q27aInformationMissingWithoutChild = q27aInformationMissingWithoutChild;
	}

	public BigInteger getQ27aInformationMissingWithChildAndAdults() {
		return q27aInformationMissingWithChildAndAdults;
	}

	public void setQ27aInformationMissingWithChildAndAdults(
			BigInteger q27aInformationMissingWithChildAndAdults) {
		this.q27aInformationMissingWithChildAndAdults = q27aInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ27aInformationMissingWithChildOnly() {
		return q27aInformationMissingWithChildOnly;
	}

	public void setQ27aInformationMissingWithChildOnly(
			BigInteger q27aInformationMissingWithChildOnly) {
		this.q27aInformationMissingWithChildOnly = q27aInformationMissingWithChildOnly;
	}

	public BigInteger getQ27aInformationMissingUnknownHouseHoldtype() {
		return q27aInformationMissingUnknownHouseHoldtype;
	}

	public void setQ27aInformationMissingUnknownHouseHoldtype(
			BigInteger q27aInformationMissingUnknownHouseHoldtype) {
		this.q27aInformationMissingUnknownHouseHoldtype = q27aInformationMissingUnknownHouseHoldtype;
	}

	public BigInteger getQ27aTotTotal() {
		return q27aTotTotal;
	}

	public void setQ27aTotTotal(BigInteger q27aTotTotal) {
		this.q27aTotTotal = q27aTotTotal;
	}

	public BigInteger getQ27aTotWithoutChild() {
		return q27aTotWithoutChild;
	}

	public void setQ27aTotWithoutChild(BigInteger q27aTotWithoutChild) {
		this.q27aTotWithoutChild = q27aTotWithoutChild;
	}

	public BigInteger getQ27aTotWithChildAndAdults() {
		return q27aTotWithChildAndAdults;
	}

	public void setQ27aTotWithChildAndAdults(BigInteger q27aTotWithChildAndAdults) {
		this.q27aTotWithChildAndAdults = q27aTotWithChildAndAdults;
	}

	public BigInteger getQ27aTotWithChildOnly() {
		return q27aTotWithChildOnly;
	}

	public void setQ27aTotWithChildOnly(BigInteger q27aTotWithChildOnly) {
		this.q27aTotWithChildOnly = q27aTotWithChildOnly;
	}

	public BigInteger getQ27aTotUnknownHouseHoldtype() {
		return q27aTotUnknownHouseHoldtype;
	}

	public void setQ27aTotUnknownHouseHoldtype(
			BigInteger q27aTotUnknownHouseHoldtype) {
		this.q27aTotUnknownHouseHoldtype = q27aTotUnknownHouseHoldtype;
	}

	public BigInteger getQ26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry() {
		return q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry;
	}

	public void setQ26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry(
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry) {
		this.q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry = q26hSupplementalNutritionalATANFChildCareServicesstanceAtEntry;
	}

	public BigInteger getQ26hSupplementalNutritionalATANFChildCareServicesstanceStayers() {
		return q26hSupplementalNutritionalATANFChildCareServicesstanceStayers;
	}

	public void setQ26hSupplementalNutritionalATANFChildCareServicesstanceStayers(
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceStayers) {
		this.q26hSupplementalNutritionalATANFChildCareServicesstanceStayers = q26hSupplementalNutritionalATANFChildCareServicesstanceStayers;
	}

	public BigInteger getQ26hSupplementalNutritionalATANFChildCareServicesstanceLeavers() {
		return q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers;
	}

	public void setQ26hSupplementalNutritionalATANFChildCareServicesstanceLeavers(
			BigInteger q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers) {
		this.q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers = q26hSupplementalNutritionalATANFChildCareServicesstanceLeavers;
	}

	public BigInteger getQ26hWICAtEntry() {
		return q26hWICAtEntry;
	}

	public void setQ26hWICAtEntry(BigInteger q26hWICAtEntry) {
		this.q26hWICAtEntry = q26hWICAtEntry;
	}

	public BigInteger getQ26hWICStayers() {
		return q26hWICStayers;
	}

	public void setQ26hWICStayers(BigInteger q26hWICStayers) {
		this.q26hWICStayers = q26hWICStayers;
	}

	public BigInteger getQ26hWICLeavers() {
		return q26hWICLeavers;
	}

	public void setQ26hWICLeavers(BigInteger q26hWICLeavers) {
		this.q26hWICLeavers = q26hWICLeavers;
	}

	public BigInteger getQ26hTANFChildCareServicesAtEntry() {
		return q26hTANFChildCareServicesAtEntry;
	}

	public void setQ26hTANFChildCareServicesAtEntry(
			BigInteger q26hTANFChildCareServicesAtEntry) {
		this.q26hTANFChildCareServicesAtEntry = q26hTANFChildCareServicesAtEntry;
	}

	public BigInteger getQ26hTANFChildCareServicesStayers() {
		return q26hTANFChildCareServicesStayers;
	}

	public void setQ26hTANFChildCareServicesStayers(
			BigInteger q26hTANFChildCareServicesStayers) {
		this.q26hTANFChildCareServicesStayers = q26hTANFChildCareServicesStayers;
	}

	public BigInteger getQ26hTANFChildCareServicesLeavers() {
		return q26hTANFChildCareServicesLeavers;
	}

	public void setQ26hTANFChildCareServicesLeavers(
			BigInteger q26hTANFChildCareServicesLeavers) {
		this.q26hTANFChildCareServicesLeavers = q26hTANFChildCareServicesLeavers;
	}

	public BigInteger getQ26hTANFTransportationServicesAtEntry() {
		return q26hTANFTransportationServicesAtEntry;
	}

	public void setQ26hTANFTransportationServicesAtEntry(
			BigInteger q26hTANFTransportationServicesAtEntry) {
		this.q26hTANFTransportationServicesAtEntry = q26hTANFTransportationServicesAtEntry;
	}

	public BigInteger getQ26hTANFTransportationServicesStayers() {
		return q26hTANFTransportationServicesStayers;
	}

	public void setQ26hTANFTransportationServicesStayers(
			BigInteger q26hTANFTransportationServicesStayers) {
		this.q26hTANFTransportationServicesStayers = q26hTANFTransportationServicesStayers;
	}

	public BigInteger getQ26hTANFTransportationServicesLeavers() {
		return q26hTANFTransportationServicesLeavers;
	}

	public void setQ26hTANFTransportationServicesLeavers(
			BigInteger q26hTANFTransportationServicesLeavers) {
		this.q26hTANFTransportationServicesLeavers = q26hTANFTransportationServicesLeavers;
	}

	public BigInteger getQ26hOtherTANFFundedServicesAtEntry() {
		return q26hOtherTANFFundedServicesAtEntry;
	}

	public void setQ26hOtherTANFFundedServicesAtEntry(
			BigInteger q26hOtherTANFFundedServicesAtEntry) {
		this.q26hOtherTANFFundedServicesAtEntry = q26hOtherTANFFundedServicesAtEntry;
	}

	public BigInteger getQ26hOtherTANFFundedServicesStayers() {
		return q26hOtherTANFFundedServicesStayers;
	}

	public void setQ26hOtherTANFFundedServicesStayers(
			BigInteger q26hOtherTANFFundedServicesStayers) {
		this.q26hOtherTANFFundedServicesStayers = q26hOtherTANFFundedServicesStayers;
	}

	public BigInteger getQ26hOtherTANFFundedServicesLeavers() {
		return q26hOtherTANFFundedServicesLeavers;
	}

	public void setQ26hOtherTANFFundedServicesLeavers(
			BigInteger q26hOtherTANFFundedServicesLeavers) {
		this.q26hOtherTANFFundedServicesLeavers = q26hOtherTANFFundedServicesLeavers;
	}

	public BigInteger getQ26hOtherSourceAtEntry() {
		return q26hOtherSourceAtEntry;
	}

	public void setQ26hOtherSourceAtEntry(BigInteger q26hOtherSourceAtEntry) {
		this.q26hOtherSourceAtEntry = q26hOtherSourceAtEntry;
	}

	public BigInteger getQ26hOtherSourceStayers() {
		return q26hOtherSourceStayers;
	}

	public void setQ26hOtherSourceStayers(BigInteger q26hOtherSourceStayers) {
		this.q26hOtherSourceStayers = q26hOtherSourceStayers;
	}

	public BigInteger getQ26hOtherSourceLeavers() {
		return q26hOtherSourceLeavers;
	}

	public void setQ26hOtherSourceLeavers(BigInteger q26hOtherSourceLeavers) {
		this.q26hOtherSourceLeavers = q26hOtherSourceLeavers;
	}

	public BigInteger getQ26gEarnedIncomeAtEntry() {
		return q26gEarnedIncomeAtEntry;
	}

	public void setQ26gEarnedIncomeAtEntry(BigInteger q26gEarnedIncomeAtEntry) {
		this.q26gEarnedIncomeAtEntry = q26gEarnedIncomeAtEntry;
	}

	public BigInteger getQ26gEarnedIncomeStayers() {
		return q26gEarnedIncomeStayers;
	}

	public void setQ26gEarnedIncomeStayers(BigInteger q26gEarnedIncomeStayers) {
		this.q26gEarnedIncomeStayers = q26gEarnedIncomeStayers;
	}

	public BigInteger getQ26gEarnedIncomeLeavers() {
		return q26gEarnedIncomeLeavers;
	}

	public void setQ26gEarnedIncomeLeavers(BigInteger q26gEarnedIncomeLeavers) {
		this.q26gEarnedIncomeLeavers = q26gEarnedIncomeLeavers;
	}

	public BigInteger getQ26gUnemploymentInsuranceAtEntry() {
		return q26gUnemploymentInsuranceAtEntry;
	}

	public void setQ26gUnemploymentInsuranceAtEntry(
			BigInteger q26gUnemploymentInsuranceAtEntry) {
		this.q26gUnemploymentInsuranceAtEntry = q26gUnemploymentInsuranceAtEntry;
	}

	public BigInteger getQ26gUnemploymentInsuranceStayers() {
		return q26gUnemploymentInsuranceStayers;
	}

	public void setQ26gUnemploymentInsuranceStayers(
			BigInteger q26gUnemploymentInsuranceStayers) {
		this.q26gUnemploymentInsuranceStayers = q26gUnemploymentInsuranceStayers;
	}

	public BigInteger getQ26gUnemploymentInsuranceLeavers() {
		return q26gUnemploymentInsuranceLeavers;
	}

	public void setQ26gUnemploymentInsuranceLeavers(
			BigInteger q26gUnemploymentInsuranceLeavers) {
		this.q26gUnemploymentInsuranceLeavers = q26gUnemploymentInsuranceLeavers;
	}

	public BigInteger getQ26gSSIAtEntry() {
		return q26gSSIAtEntry;
	}

	public void setQ26gSSIAtEntry(BigInteger q26gSSIAtEntry) {
		this.q26gSSIAtEntry = q26gSSIAtEntry;
	}

	public BigInteger getQ26gSSIStayers() {
		return q26gSSIStayers;
	}

	public void setQ26gSSIStayers(BigInteger q26gSSIStayers) {
		this.q26gSSIStayers = q26gSSIStayers;
	}

	public BigInteger getQ26gSSILeavers() {
		return q26gSSILeavers;
	}

	public void setQ26gSSILeavers(BigInteger q26gSSILeavers) {
		this.q26gSSILeavers = q26gSSILeavers;
	}

	public BigInteger getQ26gSSDIAtEntry() {
		return q26gSSDIAtEntry;
	}

	public void setQ26gSSDIAtEntry(BigInteger q26gSSDIAtEntry) {
		this.q26gSSDIAtEntry = q26gSSDIAtEntry;
	}

	public BigInteger getQ26gSSDIStayers() {
		return q26gSSDIStayers;
	}

	public void setQ26gSSDIStayers(BigInteger q26gSSDIStayers) {
		this.q26gSSDIStayers = q26gSSDIStayers;
	}

	public BigInteger getQ26gSSDILeavers() {
		return q26gSSDILeavers;
	}

	public void setQ26gSSDILeavers(BigInteger q26gSSDILeavers) {
		this.q26gSSDILeavers = q26gSSDILeavers;
	}

	public BigInteger getQ26gVAServiceConnectedDisabilityAtEntry() {
		return q26gVAServiceConnectedDisabilityAtEntry;
	}

	public void setQ26gVAServiceConnectedDisabilityAtEntry(
			BigInteger q26gVAServiceConnectedDisabilityAtEntry) {
		this.q26gVAServiceConnectedDisabilityAtEntry = q26gVAServiceConnectedDisabilityAtEntry;
	}

	public BigInteger getQ26gVAServiceConnectedDisabilityStayers() {
		return q26gVAServiceConnectedDisabilityStayers;
	}

	public void setQ26gVAServiceConnectedDisabilityStayers(
			BigInteger q26gVAServiceConnectedDisabilityStayers) {
		this.q26gVAServiceConnectedDisabilityStayers = q26gVAServiceConnectedDisabilityStayers;
	}

	public BigInteger getQ26gVAServiceConnectedDisabilityLeavers() {
		return q26gVAServiceConnectedDisabilityLeavers;
	}

	public void setQ26gVAServiceConnectedDisabilityLeavers(
			BigInteger q26gVAServiceConnectedDisabilityLeavers) {
		this.q26gVAServiceConnectedDisabilityLeavers = q26gVAServiceConnectedDisabilityLeavers;
	}

	public BigInteger getQ26gVANonServiceConnectedDisabilityAtEntry() {
		return q26gVANonServiceConnectedDisabilityAtEntry;
	}

	public void setQ26gVANonServiceConnectedDisabilityAtEntry(
			BigInteger q26gVANonServiceConnectedDisabilityAtEntry) {
		this.q26gVANonServiceConnectedDisabilityAtEntry = q26gVANonServiceConnectedDisabilityAtEntry;
	}

	public BigInteger getQ26gVANonServiceConnectedDisabilityStayers() {
		return q26gVANonServiceConnectedDisabilityStayers;
	}

	public void setQ26gVANonServiceConnectedDisabilityStayers(
			BigInteger q26gVANonServiceConnectedDisabilityStayers) {
		this.q26gVANonServiceConnectedDisabilityStayers = q26gVANonServiceConnectedDisabilityStayers;
	}

	public BigInteger getQ26gVANonServiceConnectedDisabilityLeavers() {
		return q26gVANonServiceConnectedDisabilityLeavers;
	}

	public void setQ26gVANonServiceConnectedDisabilityLeavers(
			BigInteger q26gVANonServiceConnectedDisabilityLeavers) {
		this.q26gVANonServiceConnectedDisabilityLeavers = q26gVANonServiceConnectedDisabilityLeavers;
	}

	public BigInteger getQ26gPrivateDisabilityInsuranceAtEntry() {
		return q26gPrivateDisabilityInsuranceAtEntry;
	}

	public void setQ26gPrivateDisabilityInsuranceAtEntry(
			BigInteger q26gPrivateDisabilityInsuranceAtEntry) {
		this.q26gPrivateDisabilityInsuranceAtEntry = q26gPrivateDisabilityInsuranceAtEntry;
	}

	public BigInteger getQ26gPrivateDisabilityInsuranceStayers() {
		return q26gPrivateDisabilityInsuranceStayers;
	}

	public void setQ26gPrivateDisabilityInsuranceStayers(
			BigInteger q26gPrivateDisabilityInsuranceStayers) {
		this.q26gPrivateDisabilityInsuranceStayers = q26gPrivateDisabilityInsuranceStayers;
	}

	public BigInteger getQ26gPrivateDisabilityInsuranceLeavers() {
		return q26gPrivateDisabilityInsuranceLeavers;
	}

	public void setQ26gPrivateDisabilityInsuranceLeavers(
			BigInteger q26gPrivateDisabilityInsuranceLeavers) {
		this.q26gPrivateDisabilityInsuranceLeavers = q26gPrivateDisabilityInsuranceLeavers;
	}

	public BigInteger getQ26gWorkerCompensationAtEntry() {
		return q26gWorkerCompensationAtEntry;
	}

	public void setQ26gWorkerCompensationAtEntry(
			BigInteger q26gWorkerCompensationAtEntry) {
		this.q26gWorkerCompensationAtEntry = q26gWorkerCompensationAtEntry;
	}

	public BigInteger getQ26gWorkerCompensationStayers() {
		return q26gWorkerCompensationStayers;
	}

	public void setQ26gWorkerCompensationStayers(
			BigInteger q26gWorkerCompensationStayers) {
		this.q26gWorkerCompensationStayers = q26gWorkerCompensationStayers;
	}

	public BigInteger getQ26gWorkerCompensationLeavers() {
		return q26gWorkerCompensationLeavers;
	}

	public void setQ26gWorkerCompensationLeavers(
			BigInteger q26gWorkerCompensationLeavers) {
		this.q26gWorkerCompensationLeavers = q26gWorkerCompensationLeavers;
	}

	public BigInteger getQ26gTANFAtEntry() {
		return q26gTANFAtEntry;
	}

	public void setQ26gTANFAtEntry(BigInteger q26gTANFAtEntry) {
		this.q26gTANFAtEntry = q26gTANFAtEntry;
	}

	public BigInteger getQ26gTANFStayers() {
		return q26gTANFStayers;
	}

	public void setQ26gTANFStayers(BigInteger q26gTANFStayers) {
		this.q26gTANFStayers = q26gTANFStayers;
	}

	public BigInteger getQ26gTANFLeavers() {
		return q26gTANFLeavers;
	}

	public void setQ26gTANFLeavers(BigInteger q26gTANFLeavers) {
		this.q26gTANFLeavers = q26gTANFLeavers;
	}

	public BigInteger getQ26gGeneralAssistanceAtEntry() {
		return q26gGeneralAssistanceAtEntry;
	}

	public void setQ26gGeneralAssistanceAtEntry(
			BigInteger q26gGeneralAssistanceAtEntry) {
		this.q26gGeneralAssistanceAtEntry = q26gGeneralAssistanceAtEntry;
	}

	public BigInteger getQ26gGeneralAssistanceStayers() {
		return q26gGeneralAssistanceStayers;
	}

	public void setQ26gGeneralAssistanceStayers(
			BigInteger q26gGeneralAssistanceStayers) {
		this.q26gGeneralAssistanceStayers = q26gGeneralAssistanceStayers;
	}

	public BigInteger getQ26gGeneralAssistanceLeavers() {
		return q26gGeneralAssistanceLeavers;
	}

	public void setQ26gGeneralAssistanceLeavers(
			BigInteger q26gGeneralAssistanceLeavers) {
		this.q26gGeneralAssistanceLeavers = q26gGeneralAssistanceLeavers;
	}

	public BigInteger getQ26gRetirementAtEntry() {
		return q26gRetirementAtEntry;
	}

	public void setQ26gRetirementAtEntry(BigInteger q26gRetirementAtEntry) {
		this.q26gRetirementAtEntry = q26gRetirementAtEntry;
	}

	public BigInteger getQ26gRetirementStayers() {
		return q26gRetirementStayers;
	}

	public void setQ26gRetirementStayers(BigInteger q26gRetirementStayers) {
		this.q26gRetirementStayers = q26gRetirementStayers;
	}

	public BigInteger getQ26gRetirementLeavers() {
		return q26gRetirementLeavers;
	}

	public void setQ26gRetirementLeavers(BigInteger q26gRetirementLeavers) {
		this.q26gRetirementLeavers = q26gRetirementLeavers;
	}

	public BigInteger getQ26gPensionFromFormerJobAtEntry() {
		return q26gPensionFromFormerJobAtEntry;
	}

	public void setQ26gPensionFromFormerJobAtEntry(
			BigInteger q26gPensionFromFormerJobAtEntry) {
		this.q26gPensionFromFormerJobAtEntry = q26gPensionFromFormerJobAtEntry;
	}

	public BigInteger getQ26gPensionFromFormerJobStayers() {
		return q26gPensionFromFormerJobStayers;
	}

	public void setQ26gPensionFromFormerJobStayers(
			BigInteger q26gPensionFromFormerJobStayers) {
		this.q26gPensionFromFormerJobStayers = q26gPensionFromFormerJobStayers;
	}

	public BigInteger getQ26gPensionFromFormerJobLeavers() {
		return q26gPensionFromFormerJobLeavers;
	}

	public void setQ26gPensionFromFormerJobLeavers(
			BigInteger q26gPensionFromFormerJobLeavers) {
		this.q26gPensionFromFormerJobLeavers = q26gPensionFromFormerJobLeavers;
	}

	public BigInteger getQ26gChildSupportAtEntry() {
		return q26gChildSupportAtEntry;
	}

	public void setQ26gChildSupportAtEntry(BigInteger q26gChildSupportAtEntry) {
		this.q26gChildSupportAtEntry = q26gChildSupportAtEntry;
	}

	public BigInteger getQ26gChildSupportStayers() {
		return q26gChildSupportStayers;
	}

	public void setQ26gChildSupportStayers(BigInteger q26gChildSupportStayers) {
		this.q26gChildSupportStayers = q26gChildSupportStayers;
	}

	public BigInteger getQ26gChildSupportLeavers() {
		return q26gChildSupportLeavers;
	}

	public void setQ26gChildSupportLeavers(BigInteger q26gChildSupportLeavers) {
		this.q26gChildSupportLeavers = q26gChildSupportLeavers;
	}

	public BigInteger getQ26gAlimonyAtEntry() {
		return q26gAlimonyAtEntry;
	}

	public void setQ26gAlimonyAtEntry(BigInteger q26gAlimonyAtEntry) {
		this.q26gAlimonyAtEntry = q26gAlimonyAtEntry;
	}

	public BigInteger getQ26gAlimonyStayers() {
		return q26gAlimonyStayers;
	}

	public void setQ26gAlimonyStayers(BigInteger q26gAlimonyStayers) {
		this.q26gAlimonyStayers = q26gAlimonyStayers;
	}

	public BigInteger getQ26gAlimonyLeavers() {
		return q26gAlimonyLeavers;
	}

	public void setQ26gAlimonyLeavers(BigInteger q26gAlimonyLeavers) {
		this.q26gAlimonyLeavers = q26gAlimonyLeavers;
	}

	public BigInteger getQ26gOtherSourceAtEntry() {
		return q26gOtherSourceAtEntry;
	}

	public void setQ26gOtherSourceAtEntry(BigInteger q26gOtherSourceAtEntry) {
		this.q26gOtherSourceAtEntry = q26gOtherSourceAtEntry;
	}

	public BigInteger getQ26gOtherSourceStayers() {
		return q26gOtherSourceStayers;
	}

	public void setQ26gOtherSourceStayers(BigInteger q26gOtherSourceStayers) {
		this.q26gOtherSourceStayers = q26gOtherSourceStayers;
	}

	public BigInteger getQ26gOtherSourceLeavers() {
		return q26gOtherSourceLeavers;
	}

	public void setQ26gOtherSourceLeavers(BigInteger q26gOtherSourceLeavers) {
		this.q26gOtherSourceLeavers = q26gOtherSourceLeavers;
	}

	public BigInteger getQ26gAdultsWithIncomeInfoAtEntry() {
		return q26gAdultsWithIncomeInfoAtEntry;
	}

	public void setQ26gAdultsWithIncomeInfoAtEntry(
			BigInteger q26gAdultsWithIncomeInfoAtEntry) {
		this.q26gAdultsWithIncomeInfoAtEntry = q26gAdultsWithIncomeInfoAtEntry;
	}

	public BigInteger getQ26gAdultsWithIncomeInfoStayers() {
		return q26gAdultsWithIncomeInfoStayers;
	}

	public void setQ26gAdultsWithIncomeInfoStayers(
			BigInteger q26gAdultsWithIncomeInfoStayers) {
		this.q26gAdultsWithIncomeInfoStayers = q26gAdultsWithIncomeInfoStayers;
	}

	public BigInteger getQ26gAdultsWithIncomeInfoLeavers() {
		return q26gAdultsWithIncomeInfoLeavers;
	}

	public void setQ26gAdultsWithIncomeInfoLeavers(
			BigInteger q26gAdultsWithIncomeInfoLeavers) {
		this.q26gAdultsWithIncomeInfoLeavers = q26gAdultsWithIncomeInfoLeavers;
	}

	public BigInteger getQ26fAdultsWithOnlyEarnedIncomeAtEntry() {
		return q26fAdultsWithOnlyEarnedIncomeAtEntry;
	}

	public void setQ26fAdultsWithOnlyEarnedIncomeAtEntry(
			BigInteger q26fAdultsWithOnlyEarnedIncomeAtEntry) {
		this.q26fAdultsWithOnlyEarnedIncomeAtEntry = q26fAdultsWithOnlyEarnedIncomeAtEntry;
	}

	public BigInteger getQ26fAdultsWithOnlyEarnedIncomeStayers() {
		return q26fAdultsWithOnlyEarnedIncomeStayers;
	}

	public void setQ26fAdultsWithOnlyEarnedIncomeStayers(
			BigInteger q26fAdultsWithOnlyEarnedIncomeStayers) {
		this.q26fAdultsWithOnlyEarnedIncomeStayers = q26fAdultsWithOnlyEarnedIncomeStayers;
	}

	public BigInteger getQ26fAdultsWithOnlyEarnedIncomeLeavers() {
		return q26fAdultsWithOnlyEarnedIncomeLeavers;
	}

	public void setQ26fAdultsWithOnlyEarnedIncomeLeavers(
			BigInteger q26fAdultsWithOnlyEarnedIncomeLeavers) {
		this.q26fAdultsWithOnlyEarnedIncomeLeavers = q26fAdultsWithOnlyEarnedIncomeLeavers;
	}

	public BigInteger getQ26fAdultsWithOnlyOtherIncomeAtEntry() {
		return q26fAdultsWithOnlyOtherIncomeAtEntry;
	}

	public void setQ26fAdultsWithOnlyOtherIncomeAtEntry(
			BigInteger q26fAdultsWithOnlyOtherIncomeAtEntry) {
		this.q26fAdultsWithOnlyOtherIncomeAtEntry = q26fAdultsWithOnlyOtherIncomeAtEntry;
	}

	public BigInteger getQ26fAdultsWithOnlyOtherIncomeStayers() {
		return q26fAdultsWithOnlyOtherIncomeStayers;
	}

	public void setQ26fAdultsWithOnlyOtherIncomeStayers(
			BigInteger q26fAdultsWithOnlyOtherIncomeStayers) {
		this.q26fAdultsWithOnlyOtherIncomeStayers = q26fAdultsWithOnlyOtherIncomeStayers;
	}

	public BigInteger getQ26fAdultsWithOnlyOtherIncomeLeavers() {
		return q26fAdultsWithOnlyOtherIncomeLeavers;
	}

	public void setQ26fAdultsWithOnlyOtherIncomeLeavers(
			BigInteger q26fAdultsWithOnlyOtherIncomeLeavers) {
		this.q26fAdultsWithOnlyOtherIncomeLeavers = q26fAdultsWithOnlyOtherIncomeLeavers;
	}

	public BigInteger getQ26fAdultsWithBothEarnedAndOtherIncomeAtEntry() {
		return q26fAdultsWithBothEarnedAndOtherIncomeAtEntry;
	}

	public void setQ26fAdultsWithBothEarnedAndOtherIncomeAtEntry(
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeAtEntry) {
		this.q26fAdultsWithBothEarnedAndOtherIncomeAtEntry = q26fAdultsWithBothEarnedAndOtherIncomeAtEntry;
	}

	public BigInteger getQ26fAdultsWithBothEarnedAndOtherIncomeStayers() {
		return q26fAdultsWithBothEarnedAndOtherIncomeStayers;
	}

	public void setQ26fAdultsWithBothEarnedAndOtherIncomeStayers(
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeStayers) {
		this.q26fAdultsWithBothEarnedAndOtherIncomeStayers = q26fAdultsWithBothEarnedAndOtherIncomeStayers;
	}

	public BigInteger getQ26fAdultsWithBothEarnedAndOtherIncomeLeavers() {
		return q26fAdultsWithBothEarnedAndOtherIncomeLeavers;
	}

	public void setQ26fAdultsWithBothEarnedAndOtherIncomeLeavers(
			BigInteger q26fAdultsWithBothEarnedAndOtherIncomeLeavers) {
		this.q26fAdultsWithBothEarnedAndOtherIncomeLeavers = q26fAdultsWithBothEarnedAndOtherIncomeLeavers;
	}

	public BigInteger getQ26fAdultsWithNoIncomeAtEntry() {
		return q26fAdultsWithNoIncomeAtEntry;
	}

	public void setQ26fAdultsWithNoIncomeAtEntry(
			BigInteger q26fAdultsWithNoIncomeAtEntry) {
		this.q26fAdultsWithNoIncomeAtEntry = q26fAdultsWithNoIncomeAtEntry;
	}

	public BigInteger getQ26fAdultsWithNoIncomeStayers() {
		return q26fAdultsWithNoIncomeStayers;
	}

	public void setQ26fAdultsWithNoIncomeStayers(
			BigInteger q26fAdultsWithNoIncomeStayers) {
		this.q26fAdultsWithNoIncomeStayers = q26fAdultsWithNoIncomeStayers;
	}

	public BigInteger getQ26fAdultsWithNoIncomeLeavers() {
		return q26fAdultsWithNoIncomeLeavers;
	}

	public void setQ26fAdultsWithNoIncomeLeavers(
			BigInteger q26fAdultsWithNoIncomeLeavers) {
		this.q26fAdultsWithNoIncomeLeavers = q26fAdultsWithNoIncomeLeavers;
	}

	public BigInteger getQ26fAdultsWithDontRefusedIncomeAtEntry() {
		return q26fAdultsWithDontRefusedIncomeAtEntry;
	}

	public void setQ26fAdultsWithDontRefusedIncomeAtEntry(
			BigInteger q26fAdultsWithDontRefusedIncomeAtEntry) {
		this.q26fAdultsWithDontRefusedIncomeAtEntry = q26fAdultsWithDontRefusedIncomeAtEntry;
	}

	public BigInteger getQ26fAdultsWithDontRefusedIncomeStayers() {
		return q26fAdultsWithDontRefusedIncomeStayers;
	}

	public void setQ26fAdultsWithDontRefusedIncomeStayers(
			BigInteger q26fAdultsWithDontRefusedIncomeStayers) {
		this.q26fAdultsWithDontRefusedIncomeStayers = q26fAdultsWithDontRefusedIncomeStayers;
	}

	public BigInteger getQ26fAdultsWithDontRefusedIncomeLeavers() {
		return q26fAdultsWithDontRefusedIncomeLeavers;
	}

	public void setQ26fAdultsWithDontRefusedIncomeLeavers(
			BigInteger q26fAdultsWithDontRefusedIncomeLeavers) {
		this.q26fAdultsWithDontRefusedIncomeLeavers = q26fAdultsWithDontRefusedIncomeLeavers;
	}

	public BigInteger getQ26fAdultsWithMissingIncomeInfoAtEntry() {
		return q26fAdultsWithMissingIncomeInfoAtEntry;
	}

	public void setQ26fAdultsWithMissingIncomeInfoAtEntry(
			BigInteger q26fAdultsWithMissingIncomeInfoAtEntry) {
		this.q26fAdultsWithMissingIncomeInfoAtEntry = q26fAdultsWithMissingIncomeInfoAtEntry;
	}

	public BigInteger getQ26fAdultsWithMissingIncomeInfoStayers() {
		return q26fAdultsWithMissingIncomeInfoStayers;
	}

	public void setQ26fAdultsWithMissingIncomeInfoStayers(
			BigInteger q26fAdultsWithMissingIncomeInfoStayers) {
		this.q26fAdultsWithMissingIncomeInfoStayers = q26fAdultsWithMissingIncomeInfoStayers;
	}

	public BigInteger getQ26fAdultsWithMissingIncomeInfoLeavers() {
		return q26fAdultsWithMissingIncomeInfoLeavers;
	}

	public void setQ26fAdultsWithMissingIncomeInfoLeavers(
			BigInteger q26fAdultsWithMissingIncomeInfoLeavers) {
		this.q26fAdultsWithMissingIncomeInfoLeavers = q26fAdultsWithMissingIncomeInfoLeavers;
	}

	public BigInteger getQ26fNumberOfAdultStayersNotYetRequiredAtEntry() {
		return q26fNumberOfAdultStayersNotYetRequiredAtEntry;
	}

	public void setQ26fNumberOfAdultStayersNotYetRequiredAtEntry(
			BigInteger q26fNumberOfAdultStayersNotYetRequiredAtEntry) {
		this.q26fNumberOfAdultStayersNotYetRequiredAtEntry = q26fNumberOfAdultStayersNotYetRequiredAtEntry;
	}

	public BigInteger getQ26fNumberOfAdultStayersNotYetRequiredStayers() {
		return q26fNumberOfAdultStayersNotYetRequiredStayers;
	}

	public void setQ26fNumberOfAdultStayersNotYetRequiredStayers(
			BigInteger q26fNumberOfAdultStayersNotYetRequiredStayers) {
		this.q26fNumberOfAdultStayersNotYetRequiredStayers = q26fNumberOfAdultStayersNotYetRequiredStayers;
	}

	public BigInteger getQ26fNumberOfAdultStayersNotYetRequiredLeavers() {
		return q26fNumberOfAdultStayersNotYetRequiredLeavers;
	}

	public void setQ26fNumberOfAdultStayersNotYetRequiredLeavers(
			BigInteger q26fNumberOfAdultStayersNotYetRequiredLeavers) {
		this.q26fNumberOfAdultStayersNotYetRequiredLeavers = q26fNumberOfAdultStayersNotYetRequiredLeavers;
	}

	public BigInteger getQ26fNumberOfAdultStayersWithoutRequiredAtEntry() {
		return q26fNumberOfAdultStayersWithoutRequiredAtEntry;
	}

	public void setQ26fNumberOfAdultStayersWithoutRequiredAtEntry(
			BigInteger q26fNumberOfAdultStayersWithoutRequiredAtEntry) {
		this.q26fNumberOfAdultStayersWithoutRequiredAtEntry = q26fNumberOfAdultStayersWithoutRequiredAtEntry;
	}

	public BigInteger getQ26fNumberOfAdultStayersWithoutRequiredStayers() {
		return q26fNumberOfAdultStayersWithoutRequiredStayers;
	}

	public void setQ26fNumberOfAdultStayersWithoutRequiredStayers(
			BigInteger q26fNumberOfAdultStayersWithoutRequiredStayers) {
		this.q26fNumberOfAdultStayersWithoutRequiredStayers = q26fNumberOfAdultStayersWithoutRequiredStayers;
	}

	public BigInteger getQ26fNumberOfAdultStayersWithoutRequiredLeavers() {
		return q26fNumberOfAdultStayersWithoutRequiredLeavers;
	}

	public void setQ26fNumberOfAdultStayersWithoutRequiredLeavers(
			BigInteger q26fNumberOfAdultStayersWithoutRequiredLeavers) {
		this.q26fNumberOfAdultStayersWithoutRequiredLeavers = q26fNumberOfAdultStayersWithoutRequiredLeavers;
	}

	public BigInteger getQ26fTotalAdultsAtEntry() {
		return q26fTotalAdultsAtEntry;
	}

	public void setQ26fTotalAdultsAtEntry(BigInteger q26fTotalAdultsAtEntry) {
		this.q26fTotalAdultsAtEntry = q26fTotalAdultsAtEntry;
	}

	public BigInteger getQ26fTotalAdultsStayers() {
		return q26fTotalAdultsStayers;
	}

	public void setQ26fTotalAdultsStayers(BigInteger q26fTotalAdultsStayers) {
		this.q26fTotalAdultsStayers = q26fTotalAdultsStayers;
	}

	public BigInteger getQ26fTotalAdultsLeavers() {
		return q26fTotalAdultsLeavers;
	}

	public void setQ26fTotalAdultsLeavers(BigInteger q26fTotalAdultsLeavers) {
		this.q26fTotalAdultsLeavers = q26fTotalAdultsLeavers;
	}

		public BigInteger getQ26eMentalIllnessAtEntry() {
		return q26eMentalIllnessAtEntry;
	}

	public void setQ26eMentalIllnessAtEntry(BigInteger q26eMentalIllnessAtEntry) {
		this.q26eMentalIllnessAtEntry = q26eMentalIllnessAtEntry;
	}

	public BigInteger getQ26eMentalIllnessStayers() {
		return q26eMentalIllnessStayers;
	}

	public void setQ26eMentalIllnessStayers(BigInteger q26eMentalIllnessStayers) {
		this.q26eMentalIllnessStayers = q26eMentalIllnessStayers;
	}

	public BigInteger getQ26eMentalIllnessLeavers() {
		return q26eMentalIllnessLeavers;
	}

	public void setQ26eMentalIllnessLeavers(BigInteger q26eMentalIllnessLeavers) {
		this.q26eMentalIllnessLeavers = q26eMentalIllnessLeavers;
	}

	public BigInteger getQ26eAlcoholAbuseAtEntry() {
		return q26eAlcoholAbuseAtEntry;
	}

	public void setQ26eAlcoholAbuseAtEntry(BigInteger q26eAlcoholAbuseAtEntry) {
		this.q26eAlcoholAbuseAtEntry = q26eAlcoholAbuseAtEntry;
	}

	public BigInteger getQ26eAlcoholAbuseStayers() {
		return q26eAlcoholAbuseStayers;
	}

	public void setQ26eAlcoholAbuseStayers(BigInteger q26eAlcoholAbuseStayers) {
		this.q26eAlcoholAbuseStayers = q26eAlcoholAbuseStayers;
	}

	public BigInteger getQ26eAlcoholAbuseLeavers() {
		return q26eAlcoholAbuseLeavers;
	}

	public void setQ26eAlcoholAbuseLeavers(BigInteger q26eAlcoholAbuseLeavers) {
		this.q26eAlcoholAbuseLeavers = q26eAlcoholAbuseLeavers;
	}

	public BigInteger getQ26eDrugAbuseAtEntry() {
		return q26eDrugAbuseAtEntry;
	}

	public void setQ26eDrugAbuseAtEntry(BigInteger q26eDrugAbuseAtEntry) {
		this.q26eDrugAbuseAtEntry = q26eDrugAbuseAtEntry;
	}

	public BigInteger getQ26eDrugAbuseStayers() {
		return q26eDrugAbuseStayers;
	}

	public void setQ26eDrugAbuseStayers(BigInteger q26eDrugAbuseStayers) {
		this.q26eDrugAbuseStayers = q26eDrugAbuseStayers;
	}

	public BigInteger getQ26eDrugAbuseLeavers() {
		return q26eDrugAbuseLeavers;
	}

	public void setQ26eDrugAbuseLeavers(BigInteger q26eDrugAbuseLeavers) {
		this.q26eDrugAbuseLeavers = q26eDrugAbuseLeavers;
	}

	public BigInteger getQ26eBothAlcoholAndDrugAbuseAtEntry() {
		return q26eBothAlcoholAndDrugAbuseAtEntry;
	}

	public void setQ26eBothAlcoholAndDrugAbuseAtEntry(
			BigInteger q26eBothAlcoholAndDrugAbuseAtEntry) {
		this.q26eBothAlcoholAndDrugAbuseAtEntry = q26eBothAlcoholAndDrugAbuseAtEntry;
	}

	public BigInteger getQ26eBothAlcoholAndDrugAbuseStayers() {
		return q26eBothAlcoholAndDrugAbuseStayers;
	}

	public void setQ26eBothAlcoholAndDrugAbuseStayers(
			BigInteger q26eBothAlcoholAndDrugAbuseStayers) {
		this.q26eBothAlcoholAndDrugAbuseStayers = q26eBothAlcoholAndDrugAbuseStayers;
	}

	public BigInteger getQ26eBothAlcoholAndDrugAbuseLeavers() {
		return q26eBothAlcoholAndDrugAbuseLeavers;
	}

	public void setQ26eBothAlcoholAndDrugAbuseLeavers(
			BigInteger q26eBothAlcoholAndDrugAbuseLeavers) {
		this.q26eBothAlcoholAndDrugAbuseLeavers = q26eBothAlcoholAndDrugAbuseLeavers;
	}

	public BigInteger getQ26eChronicHealthConditionAtEntry() {
		return q26eChronicHealthConditionAtEntry;
	}

	public void setQ26eChronicHealthConditionAtEntry(
			BigInteger q26eChronicHealthConditionAtEntry) {
		this.q26eChronicHealthConditionAtEntry = q26eChronicHealthConditionAtEntry;
	}

	public BigInteger getQ26eChronicHealthConditionStayers() {
		return q26eChronicHealthConditionStayers;
	}

	public void setQ26eChronicHealthConditionStayers(
			BigInteger q26eChronicHealthConditionStayers) {
		this.q26eChronicHealthConditionStayers = q26eChronicHealthConditionStayers;
	}

	public BigInteger getQ26eChronicHealthConditionLeavers() {
		return q26eChronicHealthConditionLeavers;
	}

	public void setQ26eChronicHealthConditionLeavers(
			BigInteger q26eChronicHealthConditionLeavers) {
		this.q26eChronicHealthConditionLeavers = q26eChronicHealthConditionLeavers;
	}

	public BigInteger getQ26eHIVAIDSAndRelatedDiseasesAtEntry() {
		return q26eHIVAIDSAndRelatedDiseasesAtEntry;
	}

	public void setQ26eHIVAIDSAndRelatedDiseasesAtEntry(
			BigInteger q26eHIVAIDSAndRelatedDiseasesAtEntry) {
		this.q26eHIVAIDSAndRelatedDiseasesAtEntry = q26eHIVAIDSAndRelatedDiseasesAtEntry;
	}

	public BigInteger getQ26eHIVAIDSAndRelatedDiseasesStayers() {
		return q26eHIVAIDSAndRelatedDiseasesStayers;
	}

	public void setQ26eHIVAIDSAndRelatedDiseasesStayers(
			BigInteger q26eHIVAIDSAndRelatedDiseasesStayers) {
		this.q26eHIVAIDSAndRelatedDiseasesStayers = q26eHIVAIDSAndRelatedDiseasesStayers;
	}

	public BigInteger getQ26eHIVAIDSAndRelatedDiseasesLeavers() {
		return q26eHIVAIDSAndRelatedDiseasesLeavers;
	}

	public void setQ26eHIVAIDSAndRelatedDiseasesLeavers(
			BigInteger q26eHIVAIDSAndRelatedDiseasesLeavers) {
		this.q26eHIVAIDSAndRelatedDiseasesLeavers = q26eHIVAIDSAndRelatedDiseasesLeavers;
	}

	public BigInteger getQ26eDevelopmentalDisabilityAtEntry() {
		return q26eDevelopmentalDisabilityAtEntry;
	}

	public void setQ26eDevelopmentalDisabilityAtEntry(
			BigInteger q26eDevelopmentalDisabilityAtEntry) {
		this.q26eDevelopmentalDisabilityAtEntry = q26eDevelopmentalDisabilityAtEntry;
	}

	public BigInteger getQ26eDevelopmentalDisabilityStayers() {
		return q26eDevelopmentalDisabilityStayers;
	}

	public void setQ26eDevelopmentalDisabilityStayers(
			BigInteger q26eDevelopmentalDisabilityStayers) {
		this.q26eDevelopmentalDisabilityStayers = q26eDevelopmentalDisabilityStayers;
	}

	public BigInteger getQ26eDevelopmentalDisabilityLeavers() {
		return q26eDevelopmentalDisabilityLeavers;
	}

	public void setQ26eDevelopmentalDisabilityLeavers(
			BigInteger q26eDevelopmentalDisabilityLeavers) {
		this.q26eDevelopmentalDisabilityLeavers = q26eDevelopmentalDisabilityLeavers;
	}

	public BigInteger getQ26ePhysicalDisabilityAtEntry() {
		return q26ePhysicalDisabilityAtEntry;
	}

	public void setQ26ePhysicalDisabilityAtEntry(
			BigInteger q26ePhysicalDisabilityAtEntry) {
		this.q26ePhysicalDisabilityAtEntry = q26ePhysicalDisabilityAtEntry;
	}

	public BigInteger getQ26ePhysicalDisabilityStayers() {
		return q26ePhysicalDisabilityStayers;
	}

	public void setQ26ePhysicalDisabilityStayers(
			BigInteger q26ePhysicalDisabilityStayers) {
		this.q26ePhysicalDisabilityStayers = q26ePhysicalDisabilityStayers;
	}

	public BigInteger getQ26ePhysicalDisabilityLeavers() {
		return q26ePhysicalDisabilityLeavers;
	}

	public void setQ26ePhysicalDisabilityLeavers(
			BigInteger q26ePhysicalDisabilityLeavers) {
		this.q26ePhysicalDisabilityLeavers = q26ePhysicalDisabilityLeavers;
	}

	public BigInteger getQ26d0To17Total() {
		return q26d0To17Total;
	}

	public void setQ26d0To17Total(BigInteger q26d0To17Total) {
		this.q26d0To17Total = q26d0To17Total;
	}

	public BigInteger getQ26d0To17WithoutChild() {
		return q26d0To17WithoutChild;
	}

	public void setQ26d0To17WithoutChild(BigInteger q26d0To17WithoutChild) {
		this.q26d0To17WithoutChild = q26d0To17WithoutChild;
	}

	public BigInteger getQ26d0To17WithChildAndAdults() {
		return q26d0To17WithChildAndAdults;
	}

	public void setQ26d0To17WithChildAndAdults(
			BigInteger q26d0To17WithChildAndAdults) {
		this.q26d0To17WithChildAndAdults = q26d0To17WithChildAndAdults;
	}

	public BigInteger getQ26d0To17WithOnlyChild() {
		return q26d0To17WithOnlyChild;
	}

	public void setQ26d0To17WithOnlyChild(BigInteger q26d0To17WithOnlyChild) {
		this.q26d0To17WithOnlyChild = q26d0To17WithOnlyChild;
	}

	public BigInteger getQ26d0To17UnknownHouseholdType() {
		return q26d0To17UnknownHouseholdType;
	}

	public void setQ26d0To17UnknownHouseholdType(
			BigInteger q26d0To17UnknownHouseholdType) {
		this.q26d0To17UnknownHouseholdType = q26d0To17UnknownHouseholdType;
	}

	public BigInteger getQ26d18To24Total() {
		return q26d18To24Total;
	}

	public void setQ26d18To24Total(BigInteger q26d18To24Total) {
		this.q26d18To24Total = q26d18To24Total;
	}

	public BigInteger getQ26d18To24WithoutChild() {
		return q26d18To24WithoutChild;
	}

	public void setQ26d18To24WithoutChild(BigInteger q26d18To24WithoutChild) {
		this.q26d18To24WithoutChild = q26d18To24WithoutChild;
	}

	public BigInteger getQ26d18To24WithChildAndAdults() {
		return q26d18To24WithChildAndAdults;
	}

	public void setQ26d18To24WithChildAndAdults(
			BigInteger q26d18To24WithChildAndAdults) {
		this.q26d18To24WithChildAndAdults = q26d18To24WithChildAndAdults;
	}

	public BigInteger getQ26d18To24WithOnlyChild() {
		return q26d18To24WithOnlyChild;
	}

	public void setQ26d18To24WithOnlyChild(BigInteger q26d18To24WithOnlyChild) {
		this.q26d18To24WithOnlyChild = q26d18To24WithOnlyChild;
	}

	public BigInteger getQ26d18To24UnknownHouseholdType() {
		return q26d18To24UnknownHouseholdType;
	}

	public void setQ26d18To24UnknownHouseholdType(
			BigInteger q26d18To24UnknownHouseholdType) {
		this.q26d18To24UnknownHouseholdType = q26d18To24UnknownHouseholdType;
	}

	public BigInteger getQ26d25To34Total() {
		return q26d25To34Total;
	}

	public void setQ26d25To34Total(BigInteger q26d25To34Total) {
		this.q26d25To34Total = q26d25To34Total;
	}

	public BigInteger getQ26d25To34WithoutChild() {
		return q26d25To34WithoutChild;
	}

	public void setQ26d25To34WithoutChild(BigInteger q26d25To34WithoutChild) {
		this.q26d25To34WithoutChild = q26d25To34WithoutChild;
	}

	public BigInteger getQ26d25To34WithChildAndAdults() {
		return q26d25To34WithChildAndAdults;
	}

	public void setQ26d25To34WithChildAndAdults(
			BigInteger q26d25To34WithChildAndAdults) {
		this.q26d25To34WithChildAndAdults = q26d25To34WithChildAndAdults;
	}

	public BigInteger getQ26d25To34WithOnlyChild() {
		return q26d25To34WithOnlyChild;
	}

	public void setQ26d25To34WithOnlyChild(BigInteger q26d25To34WithOnlyChild) {
		this.q26d25To34WithOnlyChild = q26d25To34WithOnlyChild;
	}

	public BigInteger getQ26d25To34UnknownHouseholdType() {
		return q26d25To34UnknownHouseholdType;
	}

	public void setQ26d25To34UnknownHouseholdType(
			BigInteger q26d25To34UnknownHouseholdType) {
		this.q26d25To34UnknownHouseholdType = q26d25To34UnknownHouseholdType;
	}

	public BigInteger getQ26d35To44Total() {
		return q26d35To44Total;
	}

	public void setQ26d35To44Total(BigInteger q26d35To44Total) {
		this.q26d35To44Total = q26d35To44Total;
	}

	public BigInteger getQ26d35To44WithoutChild() {
		return q26d35To44WithoutChild;
	}

	public void setQ26d35To44WithoutChild(BigInteger q26d35To44WithoutChild) {
		this.q26d35To44WithoutChild = q26d35To44WithoutChild;
	}

	public BigInteger getQ26d35To44WithChildAndAdults() {
		return q26d35To44WithChildAndAdults;
	}

	public void setQ26d35To44WithChildAndAdults(
			BigInteger q26d35To44WithChildAndAdults) {
		this.q26d35To44WithChildAndAdults = q26d35To44WithChildAndAdults;
	}

	public BigInteger getQ26d35To44WithOnlyChild() {
		return q26d35To44WithOnlyChild;
	}

	public void setQ26d35To44WithOnlyChild(BigInteger q26d35To44WithOnlyChild) {
		this.q26d35To44WithOnlyChild = q26d35To44WithOnlyChild;
	}

	public BigInteger getQ26d35To44UnknownHouseholdType() {
		return q26d35To44UnknownHouseholdType;
	}

	public void setQ26d35To44UnknownHouseholdType(
			BigInteger q26d35To44UnknownHouseholdType) {
		this.q26d35To44UnknownHouseholdType = q26d35To44UnknownHouseholdType;
	}

	public BigInteger getQ26d45To54Total() {
		return q26d45To54Total;
	}

	public void setQ26d45To54Total(BigInteger q26d45To54Total) {
		this.q26d45To54Total = q26d45To54Total;
	}

	public BigInteger getQ26d45To54WithoutChild() {
		return q26d45To54WithoutChild;
	}

	public void setQ26d45To54WithoutChild(BigInteger q26d45To54WithoutChild) {
		this.q26d45To54WithoutChild = q26d45To54WithoutChild;
	}

	public BigInteger getQ26d45To54WithChildAndAdults() {
		return q26d45To54WithChildAndAdults;
	}

	public void setQ26d45To54WithChildAndAdults(
			BigInteger q26d45To54WithChildAndAdults) {
		this.q26d45To54WithChildAndAdults = q26d45To54WithChildAndAdults;
	}

	public BigInteger getQ26d45To54WithOnlyChild() {
		return q26d45To54WithOnlyChild;
	}

	public void setQ26d45To54WithOnlyChild(BigInteger q26d45To54WithOnlyChild) {
		this.q26d45To54WithOnlyChild = q26d45To54WithOnlyChild;
	}

	public BigInteger getQ26d45To54UnknownHouseholdType() {
		return q26d45To54UnknownHouseholdType;
	}

	public void setQ26d45To54UnknownHouseholdType(
			BigInteger q26d45To54UnknownHouseholdType) {
		this.q26d45To54UnknownHouseholdType = q26d45To54UnknownHouseholdType;
	}

	public BigInteger getQ26d55To61Total() {
		return q26d55To61Total;
	}

	public void setQ26d55To61Total(BigInteger q26d55To61Total) {
		this.q26d55To61Total = q26d55To61Total;
	}

	public BigInteger getQ26d55To61WithoutChild() {
		return q26d55To61WithoutChild;
	}

	public void setQ26d55To61WithoutChild(BigInteger q26d55To61WithoutChild) {
		this.q26d55To61WithoutChild = q26d55To61WithoutChild;
	}

	public BigInteger getQ26d55To61WithChildAndAdults() {
		return q26d55To61WithChildAndAdults;
	}

	public void setQ26d55To61WithChildAndAdults(
			BigInteger q26d55To61WithChildAndAdults) {
		this.q26d55To61WithChildAndAdults = q26d55To61WithChildAndAdults;
	}

	public BigInteger getQ26d55To61WithOnlyChild() {
		return q26d55To61WithOnlyChild;
	}

	public void setQ26d55To61WithOnlyChild(BigInteger q26d55To61WithOnlyChild) {
		this.q26d55To61WithOnlyChild = q26d55To61WithOnlyChild;
	}

	public BigInteger getQ26d55To61UnknownHouseholdType() {
		return q26d55To61UnknownHouseholdType;
	}

	public void setQ26d55To61UnknownHouseholdType(
			BigInteger q26d55To61UnknownHouseholdType) {
		this.q26d55To61UnknownHouseholdType = q26d55To61UnknownHouseholdType;
	}

	public BigInteger getQ26d62PlusTotal() {
		return q26d62PlusTotal;
	}

	public void setQ26d62PlusTotal(BigInteger q26d62PlusTotal) {
		this.q26d62PlusTotal = q26d62PlusTotal;
	}

	public BigInteger getQ26d62PlusWithoutChild() {
		return q26d62PlusWithoutChild;
	}

	public void setQ26d62PlusWithoutChild(BigInteger q26d62PlusWithoutChild) {
		this.q26d62PlusWithoutChild = q26d62PlusWithoutChild;
	}

	public BigInteger getQ26d62PlusWithChildAndAdults() {
		return q26d62PlusWithChildAndAdults;
	}

	public void setQ26d62PlusWithChildAndAdults(
			BigInteger q26d62PlusWithChildAndAdults) {
		this.q26d62PlusWithChildAndAdults = q26d62PlusWithChildAndAdults;
	}

	public BigInteger getQ26d62PlusWithOnlyChild() {
		return q26d62PlusWithOnlyChild;
	}

	public void setQ26d62PlusWithOnlyChild(BigInteger q26d62PlusWithOnlyChild) {
		this.q26d62PlusWithOnlyChild = q26d62PlusWithOnlyChild;
	}

	public BigInteger getQ26d62PlusUnknownHouseholdType() {
		return q26d62PlusUnknownHouseholdType;
	}

	public void setQ26d62PlusUnknownHouseholdType(
			BigInteger q26d62PlusUnknownHouseholdType) {
		this.q26d62PlusUnknownHouseholdType = q26d62PlusUnknownHouseholdType;
	}

	public BigInteger getQ26dDKRTotal() {
		return q26dDKRTotal;
	}

	public void setQ26dDKRTotal(BigInteger q26dDKRTotal) {
		this.q26dDKRTotal = q26dDKRTotal;
	}

	public BigInteger getQ26dDKRWithoutChild() {
		return q26dDKRWithoutChild;
	}

	public void setQ26dDKRWithoutChild(BigInteger q26dDKRWithoutChild) {
		this.q26dDKRWithoutChild = q26dDKRWithoutChild;
	}

	public BigInteger getQ26dDKRWithChildAndAdults() {
		return q26dDKRWithChildAndAdults;
	}

	public void setQ26dDKRWithChildAndAdults(BigInteger q26dDKRWithChildAndAdults) {
		this.q26dDKRWithChildAndAdults = q26dDKRWithChildAndAdults;
	}

	public BigInteger getQ26dDKRWithOnlyChild() {
		return q26dDKRWithOnlyChild;
	}

	public void setQ26dDKRWithOnlyChild(BigInteger q26dDKRWithOnlyChild) {
		this.q26dDKRWithOnlyChild = q26dDKRWithOnlyChild;
	}

	public BigInteger getQ26dDKRUnknownHouseholdType() {
		return q26dDKRUnknownHouseholdType;
	}

	public void setQ26dDKRUnknownHouseholdType(
			BigInteger q26dDKRUnknownHouseholdType) {
		this.q26dDKRUnknownHouseholdType = q26dDKRUnknownHouseholdType;
	}

	public BigInteger getQ26dInformationMissingTotal() {
		return q26dInformationMissingTotal;
	}

	public void setQ26dInformationMissingTotal(
			BigInteger q26dInformationMissingTotal) {
		this.q26dInformationMissingTotal = q26dInformationMissingTotal;
	}

	public BigInteger getQ26dInformationMissingWithoutChild() {
		return q26dInformationMissingWithoutChild;
	}

	public void setQ26dInformationMissingWithoutChild(
			BigInteger q26dInformationMissingWithoutChild) {
		this.q26dInformationMissingWithoutChild = q26dInformationMissingWithoutChild;
	}

	public BigInteger getQ26dInformationMissingWithChildAndAdults() {
		return q26dInformationMissingWithChildAndAdults;
	}

	public void setQ26dInformationMissingWithChildAndAdults(
			BigInteger q26dInformationMissingWithChildAndAdults) {
		this.q26dInformationMissingWithChildAndAdults = q26dInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ26dInformationMissingWithOnlyChild() {
		return q26dInformationMissingWithOnlyChild;
	}

	public void setQ26dInformationMissingWithOnlyChild(
			BigInteger q26dInformationMissingWithOnlyChild) {
		this.q26dInformationMissingWithOnlyChild = q26dInformationMissingWithOnlyChild;
	}

	public BigInteger getQ26dInformationMissingUnknownHouseholdType() {
		return q26dInformationMissingUnknownHouseholdType;
	}

	public void setQ26dInformationMissingUnknownHouseholdType(
			BigInteger q26dInformationMissingUnknownHouseholdType) {
		this.q26dInformationMissingUnknownHouseholdType = q26dInformationMissingUnknownHouseholdType;
	}

	public BigInteger getQ26dSubtotalTotal() {
		return q26dSubtotalTotal;
	}

	public void setQ26dSubtotalTotal(BigInteger q26dSubtotalTotal) {
		this.q26dSubtotalTotal = q26dSubtotalTotal;
	}

	public BigInteger getQ26dSubtotalWithoutChild() {
		return q26dSubtotalWithoutChild;
	}

	public void setQ26dSubtotalWithoutChild(BigInteger q26dSubtotalWithoutChild) {
		this.q26dSubtotalWithoutChild = q26dSubtotalWithoutChild;
	}

	public BigInteger getQ26dSubtotalWithChildAndAdults() {
		return q26dSubtotalWithChildAndAdults;
	}

	public void setQ26dSubtotalWithChildAndAdults(
			BigInteger q26dSubtotalWithChildAndAdults) {
		this.q26dSubtotalWithChildAndAdults = q26dSubtotalWithChildAndAdults;
	}

	public BigInteger getQ26dSubtotalWithOnlyChild() {
		return q26dSubtotalWithOnlyChild;
	}

	public void setQ26dSubtotalWithOnlyChild(BigInteger q26dSubtotalWithOnlyChild) {
		this.q26dSubtotalWithOnlyChild = q26dSubtotalWithOnlyChild;
	}

	public BigInteger getQ26dSubtotalUnknownHouseholdType() {
		return q26dSubtotalUnknownHouseholdType;
	}

	public void setQ26dSubtotalUnknownHouseholdType(
			BigInteger q26dSubtotalUnknownHouseholdType) {
		this.q26dSubtotalUnknownHouseholdType = q26dSubtotalUnknownHouseholdType;
	}

	public BigInteger getQ26cMaleTotal() {
		return q26cMaleTotal;
	}

	public void setQ26cMaleTotal(BigInteger q26cMaleTotal) {
		this.q26cMaleTotal = q26cMaleTotal;
	}

	public BigInteger getQ26cMaleWithoutChild() {
		return q26cMaleWithoutChild;
	}

	public void setQ26cMaleWithoutChild(BigInteger q26cMaleWithoutChild) {
		this.q26cMaleWithoutChild = q26cMaleWithoutChild;
	}

	public BigInteger getQ26cMaleWithChildAndAdults() {
		return q26cMaleWithChildAndAdults;
	}

	public void setQ26cMaleWithChildAndAdults(BigInteger q26cMaleWithChildAndAdults) {
		this.q26cMaleWithChildAndAdults = q26cMaleWithChildAndAdults;
	}

	public BigInteger getQ26cMaleWithOnlyChild() {
		return q26cMaleWithOnlyChild;
	}

	public void setQ26cMaleWithOnlyChild(BigInteger q26cMaleWithOnlyChild) {
		this.q26cMaleWithOnlyChild = q26cMaleWithOnlyChild;
	}

	public BigInteger getQ26cMaleUnknownHouseholdType() {
		return q26cMaleUnknownHouseholdType;
	}

	public void setQ26cMaleUnknownHouseholdType(
			BigInteger q26cMaleUnknownHouseholdType) {
		this.q26cMaleUnknownHouseholdType = q26cMaleUnknownHouseholdType;
	}

	public BigInteger getQ26cFemaleTotal() {
		return q26cFemaleTotal;
	}

	public void setQ26cFemaleTotal(BigInteger q26cFemaleTotal) {
		this.q26cFemaleTotal = q26cFemaleTotal;
	}

	public BigInteger getQ26cFemaleWithoutChild() {
		return q26cFemaleWithoutChild;
	}

	public void setQ26cFemaleWithoutChild(BigInteger q26cFemaleWithoutChild) {
		this.q26cFemaleWithoutChild = q26cFemaleWithoutChild;
	}

	public BigInteger getQ26cFemaleWithChildAndAdults() {
		return q26cFemaleWithChildAndAdults;
	}

	public void setQ26cFemaleWithChildAndAdults(
			BigInteger q26cFemaleWithChildAndAdults) {
		this.q26cFemaleWithChildAndAdults = q26cFemaleWithChildAndAdults;
	}

	public BigInteger getQ26cFemaleWithOnlyChild() {
		return q26cFemaleWithOnlyChild;
	}

	public void setQ26cFemaleWithOnlyChild(BigInteger q26cFemaleWithOnlyChild) {
		this.q26cFemaleWithOnlyChild = q26cFemaleWithOnlyChild;
	}

	public BigInteger getQ26cFemaleUnknownHouseholdType() {
		return q26cFemaleUnknownHouseholdType;
	}

	public void setQ26cFemaleUnknownHouseholdType(
			BigInteger q26cFemaleUnknownHouseholdType) {
		this.q26cFemaleUnknownHouseholdType = q26cFemaleUnknownHouseholdType;
	}

	public BigInteger getQ26cTransgenderMaleToFemaleTotal() {
		return q26cTransgenderMaleToFemaleTotal;
	}

	public void setQ26cTransgenderMaleToFemaleTotal(
			BigInteger q26cTransgenderMaleToFemaleTotal) {
		this.q26cTransgenderMaleToFemaleTotal = q26cTransgenderMaleToFemaleTotal;
	}

	public BigInteger getQ26cTransgenderMaleToFemaleWithoutChild() {
		return q26cTransgenderMaleToFemaleWithoutChild;
	}

	public void setQ26cTransgenderMaleToFemaleWithoutChild(
			BigInteger q26cTransgenderMaleToFemaleWithoutChild) {
		this.q26cTransgenderMaleToFemaleWithoutChild = q26cTransgenderMaleToFemaleWithoutChild;
	}

	public BigInteger getQ26cTransgenderMaleToFemaleWithChildAndAdults() {
		return q26cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public void setQ26cTransgenderMaleToFemaleWithChildAndAdults(
			BigInteger q26cTransgenderMaleToFemaleWithChildAndAdults) {
		this.q26cTransgenderMaleToFemaleWithChildAndAdults = q26cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public BigInteger getQ26cTransgenderMaleToFemaleWithOnlyChild() {
		return q26cTransgenderMaleToFemaleWithOnlyChild;
	}

	public void setQ26cTransgenderMaleToFemaleWithOnlyChild(
			BigInteger q26cTransgenderMaleToFemaleWithOnlyChild) {
		this.q26cTransgenderMaleToFemaleWithOnlyChild = q26cTransgenderMaleToFemaleWithOnlyChild;
	}

	public BigInteger getQ26cTransgenderMaleToFemaleUnknownHouseholdType() {
		return q26cTransgenderMaleToFemaleUnknownHouseholdType;
	}

	public void setQ26cTransgenderMaleToFemaleUnknownHouseholdType(
			BigInteger q26cTransgenderMaleToFemaleUnknownHouseholdType) {
		this.q26cTransgenderMaleToFemaleUnknownHouseholdType = q26cTransgenderMaleToFemaleUnknownHouseholdType;
	}

	public BigInteger getQ26cTransgenderFemaleToMaleTotal() {
		return q26cTransgenderFemaleToMaleTotal;
	}

	public void setQ26cTransgenderFemaleToMaleTotal(
			BigInteger q26cTransgenderFemaleToMaleTotal) {
		this.q26cTransgenderFemaleToMaleTotal = q26cTransgenderFemaleToMaleTotal;
	}

	public BigInteger getQ26cTransgenderFemaleToMaleWithoutChild() {
		return q26cTransgenderFemaleToMaleWithoutChild;
	}

	public void setQ26cTransgenderFemaleToMaleWithoutChild(
			BigInteger q26cTransgenderFemaleToMaleWithoutChild) {
		this.q26cTransgenderFemaleToMaleWithoutChild = q26cTransgenderFemaleToMaleWithoutChild;
	}

	public BigInteger getQ26cTransgenderFemaleToMaleWithChildAndAdults() {
		return q26cTransgenderFemaleToMaleWithChildAndAdults;
	}

	public void setQ26cTransgenderFemaleToMaleWithChildAndAdults(
			BigInteger q26cTransgenderFemaleToMaleWithChildAndAdults) {
		this.q26cTransgenderFemaleToMaleWithChildAndAdults = q26cTransgenderFemaleToMaleWithChildAndAdults;
	}

	public BigInteger getQ26cTransgenderFemaleToMaleWithOnlyChild() {
		return q26cTransgenderFemaleToMaleWithOnlyChild;
	}

	public void setQ26cTransgenderFemaleToMaleWithOnlyChild(
			BigInteger q26cTransgenderFemaleToMaleWithOnlyChild) {
		this.q26cTransgenderFemaleToMaleWithOnlyChild = q26cTransgenderFemaleToMaleWithOnlyChild;
	}

	public BigInteger getQ26cTransgenderFemaleToMaleUnknownHouseholdType() {
		return q26cTransgenderFemaleToMaleUnknownHouseholdType;
	}

	public void setQ26cTransgenderFemaleToMaleUnknownHouseholdType(
			BigInteger q26cTransgenderFemaleToMaleUnknownHouseholdType) {
		this.q26cTransgenderFemaleToMaleUnknownHouseholdType = q26cTransgenderFemaleToMaleUnknownHouseholdType;
	}

	public BigInteger getQ26cOtherTotal() {
		return q26cOtherTotal;
	}

	public void setQ26cOtherTotal(BigInteger q26cOtherTotal) {
		this.q26cOtherTotal = q26cOtherTotal;
	}

	public BigInteger getQ26cOtherWithoutChild() {
		return q26cOtherWithoutChild;
	}

	public void setQ26cOtherWithoutChild(BigInteger q26cOtherWithoutChild) {
		this.q26cOtherWithoutChild = q26cOtherWithoutChild;
	}

	public BigInteger getQ26cOtherWithChildAndAdults() {
		return q26cOtherWithChildAndAdults;
	}

	public void setQ26cOtherWithChildAndAdults(
			BigInteger q26cOtherWithChildAndAdults) {
		this.q26cOtherWithChildAndAdults = q26cOtherWithChildAndAdults;
	}

	public BigInteger getQ26cOtherWithOnlyChild() {
		return q26cOtherWithOnlyChild;
	}

	public void setQ26cOtherWithOnlyChild(BigInteger q26cOtherWithOnlyChild) {
		this.q26cOtherWithOnlyChild = q26cOtherWithOnlyChild;
	}

	public BigInteger getQ26cOtherUnknownHouseholdType() {
		return q26cOtherUnknownHouseholdType;
	}

	public void setQ26cOtherUnknownHouseholdType(
			BigInteger q26cOtherUnknownHouseholdType) {
		this.q26cOtherUnknownHouseholdType = q26cOtherUnknownHouseholdType;
	}

	public BigInteger getQ26cDKRTotal() {
		return q26cDKRTotal;
	}

	public void setQ26cDKRTotal(BigInteger q26cDKRTotal) {
		this.q26cDKRTotal = q26cDKRTotal;
	}

	public BigInteger getQ26cDKRWithoutChild() {
		return q26cDKRWithoutChild;
	}

	public void setQ26cDKRWithoutChild(BigInteger q26cDKRWithoutChild) {
		this.q26cDKRWithoutChild = q26cDKRWithoutChild;
	}

	public BigInteger getQ26cDKRWithChildAndAdults() {
		return q26cDKRWithChildAndAdults;
	}

	public void setQ26cDKRWithChildAndAdults(BigInteger q26cDKRWithChildAndAdults) {
		this.q26cDKRWithChildAndAdults = q26cDKRWithChildAndAdults;
	}

	public BigInteger getQ26cDKRWithOnlyChild() {
		return q26cDKRWithOnlyChild;
	}

	public void setQ26cDKRWithOnlyChild(BigInteger q26cDKRWithOnlyChild) {
		this.q26cDKRWithOnlyChild = q26cDKRWithOnlyChild;
	}

	public BigInteger getQ26cDKRUnknownHouseholdType() {
		return q26cDKRUnknownHouseholdType;
	}

	public void setQ26cDKRUnknownHouseholdType(
			BigInteger q26cDKRUnknownHouseholdType) {
		this.q26cDKRUnknownHouseholdType = q26cDKRUnknownHouseholdType;
	}

	public BigInteger getQ26cInformationMissingTotal() {
		return q26cInformationMissingTotal;
	}

	public void setQ26cInformationMissingTotal(
			BigInteger q26cInformationMissingTotal) {
		this.q26cInformationMissingTotal = q26cInformationMissingTotal;
	}

	public BigInteger getQ26cInformationMissingWithoutChild() {
		return q26cInformationMissingWithoutChild;
	}

	public void setQ26cInformationMissingWithoutChild(
			BigInteger q26cInformationMissingWithoutChild) {
		this.q26cInformationMissingWithoutChild = q26cInformationMissingWithoutChild;
	}

	public BigInteger getQ26cInformationMissingWithChildAndAdults() {
		return q26cInformationMissingWithChildAndAdults;
	}

	public void setQ26cInformationMissingWithChildAndAdults(
			BigInteger q26cInformationMissingWithChildAndAdults) {
		this.q26cInformationMissingWithChildAndAdults = q26cInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ26cInformationMissingWithOnlyChild() {
		return q26cInformationMissingWithOnlyChild;
	}

	public void setQ26cInformationMissingWithOnlyChild(
			BigInteger q26cInformationMissingWithOnlyChild) {
		this.q26cInformationMissingWithOnlyChild = q26cInformationMissingWithOnlyChild;
	}

	public BigInteger getQ26cInformationMissingUnknownHouseholdType() {
		return q26cInformationMissingUnknownHouseholdType;
	}

	public void setQ26cInformationMissingUnknownHouseholdType(
			BigInteger q26cInformationMissingUnknownHouseholdType) {
		this.q26cInformationMissingUnknownHouseholdType = q26cInformationMissingUnknownHouseholdType;
	}

	public BigInteger getQ26cSubtotalTotal() {
		return q26cSubtotalTotal;
	}

	public void setQ26cSubtotalTotal(BigInteger q26cSubtotalTotal) {
		this.q26cSubtotalTotal = q26cSubtotalTotal;
	}

	public BigInteger getQ26cSubtotalWithoutChild() {
		return q26cSubtotalWithoutChild;
	}

	public void setQ26cSubtotalWithoutChild(BigInteger q26cSubtotalWithoutChild) {
		this.q26cSubtotalWithoutChild = q26cSubtotalWithoutChild;
	}

	public BigInteger getQ26cSubtotalWithChildAndAdults() {
		return q26cSubtotalWithChildAndAdults;
	}

	public void setQ26cSubtotalWithChildAndAdults(
			BigInteger q26cSubtotalWithChildAndAdults) {
		this.q26cSubtotalWithChildAndAdults = q26cSubtotalWithChildAndAdults;
	}

	public BigInteger getQ26cSubtotalWithOnlyChild() {
		return q26cSubtotalWithOnlyChild;
	}

	public void setQ26cSubtotalWithOnlyChild(BigInteger q26cSubtotalWithOnlyChild) {
		this.q26cSubtotalWithOnlyChild = q26cSubtotalWithOnlyChild;
	}

	public BigInteger getQ26cSubtotalUnknownHouseholdType() {
		return q26cSubtotalUnknownHouseholdType;
	}

	public void setQ26cSubtotalUnknownHouseholdType(
			BigInteger q26cSubtotalUnknownHouseholdType) {
		this.q26cSubtotalUnknownHouseholdType = q26cSubtotalUnknownHouseholdType;
	}

	public BigInteger getQ26aChronicallyHomelessTotal() {
		return q26aChronicallyHomelessTotal;
	}

	public BigInteger getQ26bChronicallyHomelessTotal() {
		return q26bChronicallyHomelessTotal;
	}

	public void setQ26bChronicallyHomelessTotal(
			BigInteger q26bChronicallyHomelessTotal) {
		this.q26bChronicallyHomelessTotal = q26bChronicallyHomelessTotal;
	}

	public BigInteger getQ26bChronicallyHomelessWithoutChild() {
		return q26bChronicallyHomelessWithoutChild;
	}

	public void setQ26bChronicallyHomelessWithoutChild(
			BigInteger q26bChronicallyHomelessWithoutChild) {
		this.q26bChronicallyHomelessWithoutChild = q26bChronicallyHomelessWithoutChild;
	}

	public BigInteger getQ26bChronicallyHomelessWithChildAndAdults() {
		return q26bChronicallyHomelessWithChildAndAdults;
	}

	public void setQ26bChronicallyHomelessWithChildAndAdults(
			BigInteger q26bChronicallyHomelessWithChildAndAdults) {
		this.q26bChronicallyHomelessWithChildAndAdults = q26bChronicallyHomelessWithChildAndAdults;
	}

	public BigInteger getQ26bChronicallyHomelessWithOnlyChild() {
		return q26bChronicallyHomelessWithOnlyChild;
	}

	public void setQ26bChronicallyHomelessWithOnlyChild(
			BigInteger q26bChronicallyHomelessWithOnlyChild) {
		this.q26bChronicallyHomelessWithOnlyChild = q26bChronicallyHomelessWithOnlyChild;
	}

	public BigInteger getQ26bChronicallyHomelessUnknownHouseholdType() {
		return q26bChronicallyHomelessUnknownHouseholdType;
	}

	public void setQ26bChronicallyHomelessUnknownHouseholdType(
			BigInteger q26bChronicallyHomelessUnknownHouseholdType) {
		this.q26bChronicallyHomelessUnknownHouseholdType = q26bChronicallyHomelessUnknownHouseholdType;
	}

	public BigInteger getQ26bNotChronicallyHomelessTotal() {
		return q26bNotChronicallyHomelessTotal;
	}

	public void setQ26bNotChronicallyHomelessTotal(
			BigInteger q26bNotChronicallyHomelessTotal) {
		this.q26bNotChronicallyHomelessTotal = q26bNotChronicallyHomelessTotal;
	}

	public BigInteger getQ26bNotChronicallyHomelessWithoutChild() {
		return q26bNotChronicallyHomelessWithoutChild;
	}

	public void setQ26bNotChronicallyHomelessWithoutChild(
			BigInteger q26bNotChronicallyHomelessWithoutChild) {
		this.q26bNotChronicallyHomelessWithoutChild = q26bNotChronicallyHomelessWithoutChild;
	}

	public BigInteger getQ26bNotChronicallyHomelessWithChildAndAdults() {
		return q26bNotChronicallyHomelessWithChildAndAdults;
	}

	public void setQ26bNotChronicallyHomelessWithChildAndAdults(
			BigInteger q26bNotChronicallyHomelessWithChildAndAdults) {
		this.q26bNotChronicallyHomelessWithChildAndAdults = q26bNotChronicallyHomelessWithChildAndAdults;
	}

	public BigInteger getQ26bNotChronicallyHomelessWithOnlyChild() {
		return q26bNotChronicallyHomelessWithOnlyChild;
	}

	public void setQ26bNotChronicallyHomelessWithOnlyChild(
			BigInteger q26bNotChronicallyHomelessWithOnlyChild) {
		this.q26bNotChronicallyHomelessWithOnlyChild = q26bNotChronicallyHomelessWithOnlyChild;
	}

	public BigInteger getQ26bNotChronicallyHomelessUnknownHouseholdType() {
		return q26bNotChronicallyHomelessUnknownHouseholdType;
	}

	public void setQ26bNotChronicallyHomelessUnknownHouseholdType(
			BigInteger q26bNotChronicallyHomelessUnknownHouseholdType) {
		this.q26bNotChronicallyHomelessUnknownHouseholdType = q26bNotChronicallyHomelessUnknownHouseholdType;
	}

	public BigInteger getQ26bClientRefusedTotal() {
		return q26bClientRefusedTotal;
	}

	public void setQ26bClientRefusedTotal(BigInteger q26bClientRefusedTotal) {
		this.q26bClientRefusedTotal = q26bClientRefusedTotal;
	}

	public BigInteger getQ26bClientRefusedWithoutChild() {
		return q26bClientRefusedWithoutChild;
	}

	public void setQ26bClientRefusedWithoutChild(
			BigInteger q26bClientRefusedWithoutChild) {
		this.q26bClientRefusedWithoutChild = q26bClientRefusedWithoutChild;
	}

	public BigInteger getQ26bClientRefusedWithChildAndAdults() {
		return q26bClientRefusedWithChildAndAdults;
	}

	public void setQ26bClientRefusedWithChildAndAdults(
			BigInteger q26bClientRefusedWithChildAndAdults) {
		this.q26bClientRefusedWithChildAndAdults = q26bClientRefusedWithChildAndAdults;
	}

	public BigInteger getQ26bClientRefusedWithOnlyChild() {
		return q26bClientRefusedWithOnlyChild;
	}

	public void setQ26bClientRefusedWithOnlyChild(
			BigInteger q26bClientRefusedWithOnlyChild) {
		this.q26bClientRefusedWithOnlyChild = q26bClientRefusedWithOnlyChild;
	}

	public BigInteger getQ26bClientRefusedUnknownHouseholdType() {
		return q26bClientRefusedUnknownHouseholdType;
	}

	public void setQ26bClientRefusedUnknownHouseholdType(
			BigInteger q26bClientRefusedUnknownHouseholdType) {
		this.q26bClientRefusedUnknownHouseholdType = q26bClientRefusedUnknownHouseholdType;
	}

	public BigInteger getQ26bDataNotCollectedTotal() {
		return q26bDataNotCollectedTotal;
	}

	public void setQ26bDataNotCollectedTotal(BigInteger q26bDataNotCollectedTotal) {
		this.q26bDataNotCollectedTotal = q26bDataNotCollectedTotal;
	}

	public BigInteger getQ26bDataNotCollectedWithoutChild() {
		return q26bDataNotCollectedWithoutChild;
	}

	public void setQ26bDataNotCollectedWithoutChild(
			BigInteger q26bDataNotCollectedWithoutChild) {
		this.q26bDataNotCollectedWithoutChild = q26bDataNotCollectedWithoutChild;
	}

	public BigInteger getQ26bDataNotCollectedWithChildAndAdults() {
		return q26bDataNotCollectedWithChildAndAdults;
	}

	public void setQ26bDataNotCollectedWithChildAndAdults(
			BigInteger q26bDataNotCollectedWithChildAndAdults) {
		this.q26bDataNotCollectedWithChildAndAdults = q26bDataNotCollectedWithChildAndAdults;
	}

	public BigInteger getQ26bDataNotCollectedWithOnlyChild() {
		return q26bDataNotCollectedWithOnlyChild;
	}

	public void setQ26bDataNotCollectedWithOnlyChild(
			BigInteger q26bDataNotCollectedWithOnlyChild) {
		this.q26bDataNotCollectedWithOnlyChild = q26bDataNotCollectedWithOnlyChild;
	}

	public BigInteger getQ26bDataNotCollectedUnknownHouseholdType() {
		return q26bDataNotCollectedUnknownHouseholdType;
	}

	public void setQ26bDataNotCollectedUnknownHouseholdType(
			BigInteger q26bDataNotCollectedUnknownHouseholdType) {
		this.q26bDataNotCollectedUnknownHouseholdType = q26bDataNotCollectedUnknownHouseholdType;
	}

	public BigInteger getQ26bTotTotal() {
		return q26bTotTotal;
	}

	public void setQ26bTotTotal(BigInteger q26bTotTotal) {
		this.q26bTotTotal = q26bTotTotal;
	}

	public BigInteger getQ26bTotWithoutChild() {
		return q26bTotWithoutChild;
	}

	public void setQ26bTotWithoutChild(BigInteger q26bTotWithoutChild) {
		this.q26bTotWithoutChild = q26bTotWithoutChild;
	}

	public BigInteger getQ26bTotWithChildAndAdults() {
		return q26bTotWithChildAndAdults;
	}

	public void setQ26bTotWithChildAndAdults(BigInteger q26bTotWithChildAndAdults) {
		this.q26bTotWithChildAndAdults = q26bTotWithChildAndAdults;
	}

	public BigInteger getQ26bTotWithOnlyChild() {
		return q26bTotWithOnlyChild;
	}

	public void setQ26bTotWithOnlyChild(BigInteger q26bTotWithOnlyChild) {
		this.q26bTotWithOnlyChild = q26bTotWithOnlyChild;
	}

	public BigInteger getQ26bTotUnknownHouseholdType() {
		return q26bTotUnknownHouseholdType;
	}

	public void setQ26bTotUnknownHouseholdType(
			BigInteger q26bTotUnknownHouseholdType) {
		this.q26bTotUnknownHouseholdType = q26bTotUnknownHouseholdType;
	}

	public void setQ26aChronicallyHomelessTotal(
			BigInteger q26aChronicallyHomelessTotal) {
		this.q26aChronicallyHomelessTotal = q26aChronicallyHomelessTotal;
	}

	public BigInteger getQ26aChronicallyHomelessWithoutChild() {
		return q26aChronicallyHomelessWithoutChild;
	}

	public void setQ26aChronicallyHomelessWithoutChild(
			BigInteger q26aChronicallyHomelessWithoutChild) {
		this.q26aChronicallyHomelessWithoutChild = q26aChronicallyHomelessWithoutChild;
	}

	public BigInteger getQ26aChronicallyHomelessWithChildAndAdults() {
		return q26aChronicallyHomelessWithChildAndAdults;
	}

	public void setQ26aChronicallyHomelessWithChildAndAdults(
			BigInteger q26aChronicallyHomelessWithChildAndAdults) {
		this.q26aChronicallyHomelessWithChildAndAdults = q26aChronicallyHomelessWithChildAndAdults;
	}

	public BigInteger getQ26aChronicallyHomelessWithOnlyChild() {
		return q26aChronicallyHomelessWithOnlyChild;
	}

	public void setQ26aChronicallyHomelessWithOnlyChild(
			BigInteger q26aChronicallyHomelessWithOnlyChild) {
		this.q26aChronicallyHomelessWithOnlyChild = q26aChronicallyHomelessWithOnlyChild;
	}

	public BigInteger getQ26aChronicallyHomelessUnknownHouseholdType() {
		return q26aChronicallyHomelessUnknownHouseholdType;
	}

	public void setQ26aChronicallyHomelessUnknownHouseholdType(
			BigInteger q26aChronicallyHomelessUnknownHouseholdType) {
		this.q26aChronicallyHomelessUnknownHouseholdType = q26aChronicallyHomelessUnknownHouseholdType;
	}

	public BigInteger getQ26aNotChronicallyHomelessTotal() {
		return q26aNotChronicallyHomelessTotal;
	}

	public void setQ26aNotChronicallyHomelessTotal(
			BigInteger q26aNotChronicallyHomelessTotal) {
		this.q26aNotChronicallyHomelessTotal = q26aNotChronicallyHomelessTotal;
	}

	public BigInteger getQ26aNotChronicallyHomelessWithoutChild() {
		return q26aNotChronicallyHomelessWithoutChild;
	}

	public void setQ26aNotChronicallyHomelessWithoutChild(
			BigInteger q26aNotChronicallyHomelessWithoutChild) {
		this.q26aNotChronicallyHomelessWithoutChild = q26aNotChronicallyHomelessWithoutChild;
	}

	public BigInteger getQ26aNotChronicallyHomelessWithChildAndAdults() {
		return q26aNotChronicallyHomelessWithChildAndAdults;
	}

	public void setQ26aNotChronicallyHomelessWithChildAndAdults(
			BigInteger q26aNotChronicallyHomelessWithChildAndAdults) {
		this.q26aNotChronicallyHomelessWithChildAndAdults = q26aNotChronicallyHomelessWithChildAndAdults;
	}

	public BigInteger getQ26aNotChronicallyHomelessWithOnlyChild() {
		return q26aNotChronicallyHomelessWithOnlyChild;
	}

	public void setQ26aNotChronicallyHomelessWithOnlyChild(
			BigInteger q26aNotChronicallyHomelessWithOnlyChild) {
		this.q26aNotChronicallyHomelessWithOnlyChild = q26aNotChronicallyHomelessWithOnlyChild;
	}

	public BigInteger getQ26aNotChronicallyHomelessUnknownHouseholdType() {
		return q26aNotChronicallyHomelessUnknownHouseholdType;
	}

	public void setQ26aNotChronicallyHomelessUnknownHouseholdType(
			BigInteger q26aNotChronicallyHomelessUnknownHouseholdType) {
		this.q26aNotChronicallyHomelessUnknownHouseholdType = q26aNotChronicallyHomelessUnknownHouseholdType;
	}

	public BigInteger getQ26aClientRefusedTotal() {
		return q26aClientRefusedTotal;
	}

	public void setQ26aClientRefusedTotal(BigInteger q26aClientRefusedTotal) {
		this.q26aClientRefusedTotal = q26aClientRefusedTotal;
	}

	public BigInteger getQ26aClientRefusedWithoutChild() {
		return q26aClientRefusedWithoutChild;
	}

	public void setQ26aClientRefusedWithoutChild(
			BigInteger q26aClientRefusedWithoutChild) {
		this.q26aClientRefusedWithoutChild = q26aClientRefusedWithoutChild;
	}

	public BigInteger getQ26aClientRefusedWithChildAndAdults() {
		return q26aClientRefusedWithChildAndAdults;
	}

	public void setQ26aClientRefusedWithChildAndAdults(
			BigInteger q26aClientRefusedWithChildAndAdults) {
		this.q26aClientRefusedWithChildAndAdults = q26aClientRefusedWithChildAndAdults;
	}

	public BigInteger getQ26aClientRefusedWithOnlyChild() {
		return q26aClientRefusedWithOnlyChild;
	}

	public void setQ26aClientRefusedWithOnlyChild(
			BigInteger q26aClientRefusedWithOnlyChild) {
		this.q26aClientRefusedWithOnlyChild = q26aClientRefusedWithOnlyChild;
	}

	public BigInteger getQ26aClientRefusedUnknownHouseholdType() {
		return q26aClientRefusedUnknownHouseholdType;
	}

	public void setQ26aClientRefusedUnknownHouseholdType(
			BigInteger q26aClientRefusedUnknownHouseholdType) {
		this.q26aClientRefusedUnknownHouseholdType = q26aClientRefusedUnknownHouseholdType;
	}

	public BigInteger getQ26aDataNotCollectedTotal() {
		return q26aDataNotCollectedTotal;
	}

	public void setQ26aDataNotCollectedTotal(BigInteger q26aDataNotCollectedTotal) {
		this.q26aDataNotCollectedTotal = q26aDataNotCollectedTotal;
	}

	public BigInteger getQ26aDataNotCollectedWithoutChild() {
		return q26aDataNotCollectedWithoutChild;
	}

	public void setQ26aDataNotCollectedWithoutChild(
			BigInteger q26aDataNotCollectedWithoutChild) {
		this.q26aDataNotCollectedWithoutChild = q26aDataNotCollectedWithoutChild;
	}

	public BigInteger getQ26aDataNotCollectedWithChildAndAdults() {
		return q26aDataNotCollectedWithChildAndAdults;
	}

	public void setQ26aDataNotCollectedWithChildAndAdults(
			BigInteger q26aDataNotCollectedWithChildAndAdults) {
		this.q26aDataNotCollectedWithChildAndAdults = q26aDataNotCollectedWithChildAndAdults;
	}

	public BigInteger getQ26aDataNotCollectedWithOnlyChild() {
		return q26aDataNotCollectedWithOnlyChild;
	}

	public void setQ26aDataNotCollectedWithOnlyChild(
			BigInteger q26aDataNotCollectedWithOnlyChild) {
		this.q26aDataNotCollectedWithOnlyChild = q26aDataNotCollectedWithOnlyChild;
	}

	public BigInteger getQ26aDataNotCollectedUnknownHouseholdType() {
		return q26aDataNotCollectedUnknownHouseholdType;
	}

	public void setQ26aDataNotCollectedUnknownHouseholdType(
			BigInteger q26aDataNotCollectedUnknownHouseholdType) {
		this.q26aDataNotCollectedUnknownHouseholdType = q26aDataNotCollectedUnknownHouseholdType;
	}

	public BigInteger getQ26aTotTotal() {
		return q26aTotTotal;
	}

	public void setQ26aTotTotal(BigInteger q26aTotTotal) {
		this.q26aTotTotal = q26aTotTotal;
	}

	public BigInteger getQ26aTotWithoutChild() {
		return q26aTotWithoutChild;
	}

	public void setQ26aTotWithoutChild(BigInteger q26aTotWithoutChild) {
		this.q26aTotWithoutChild = q26aTotWithoutChild;
	}

	public BigInteger getQ26aTotWithChildAndAdults() {
		return q26aTotWithChildAndAdults;
	}

	public void setQ26aTotWithChildAndAdults(BigInteger q26aTotWithChildAndAdults) {
		this.q26aTotWithChildAndAdults = q26aTotWithChildAndAdults;
	}

	public BigInteger getQ26aTotWithOnlyChild() {
		return q26aTotWithOnlyChild;
	}

	public void setQ26aTotWithOnlyChild(BigInteger q26aTotWithOnlyChild) {
		this.q26aTotWithOnlyChild = q26aTotWithOnlyChild;
	}

	public BigInteger getQ26aTotUnknownHouseholdType() {
		return q26aTotUnknownHouseholdType;
	}

	public void setQ26aTotUnknownHouseholdType(
			BigInteger q26aTotUnknownHouseholdType) {
		this.q26aTotUnknownHouseholdType = q26aTotUnknownHouseholdType;
	}

	public BigInteger getQ25iA01MovedFromOneHOPWATotal() {
		return q25iA01MovedFromOneHOPWATotal;
	}

	public void setQ25iA01MovedFromOneHOPWATotal(
			BigInteger q25iA01MovedFromOneHOPWATotal) {
		this.q25iA01MovedFromOneHOPWATotal = q25iA01MovedFromOneHOPWATotal;
	}

	public BigInteger getQ25iA01MovedFromOneHOPWAWithoutChild() {
		return q25iA01MovedFromOneHOPWAWithoutChild;
	}

	public void setQ25iA01MovedFromOneHOPWAWithoutChild(
			BigInteger q25iA01MovedFromOneHOPWAWithoutChild) {
		this.q25iA01MovedFromOneHOPWAWithoutChild = q25iA01MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ25iA01MovedFromOneHOPWAWithChildAndAdults() {
		return q25iA01MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ25iA01MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q25iA01MovedFromOneHOPWAWithChildAndAdults) {
		this.q25iA01MovedFromOneHOPWAWithChildAndAdults = q25iA01MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ25iA01MovedFromOneHOPWAWithOnlyChild() {
		return q25iA01MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ25iA01MovedFromOneHOPWAWithOnlyChild(
			BigInteger q25iA01MovedFromOneHOPWAWithOnlyChild) {
		this.q25iA01MovedFromOneHOPWAWithOnlyChild = q25iA01MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ25iA01MovedFromOneHOPWAUnknownHouseHold() {
		return q25iA01MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ25iA01MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q25iA01MovedFromOneHOPWAUnknownHouseHold) {
		this.q25iA01MovedFromOneHOPWAUnknownHouseHold = q25iA01MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ25iA02OwnedByClientNoOngoingSubsidyTotal() {
		return q25iA02OwnedByClientNoOngoingSubsidyTotal;
	}

	public void setQ25iA02OwnedByClientNoOngoingSubsidyTotal(
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyTotal) {
		this.q25iA02OwnedByClientNoOngoingSubsidyTotal = q25iA02OwnedByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ25iA02OwnedByClientNoOngoingSubsidyWithoutChild() {
		return q25iA02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ25iA02OwnedByClientNoOngoingSubsidyWithoutChild(
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithoutChild) {
		this.q25iA02OwnedByClientNoOngoingSubsidyWithoutChild = q25iA02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults() {
		return q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults) {
		this.q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults = q25iA02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild() {
		return q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild) {
		this.q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild = q25iA02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold() {
		return q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold) {
		this.q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold = q25iA02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ25iA03OwnedByClientWithOngoingSubsidyTotal() {
		return q25iA03OwnedByClientWithOngoingSubsidyTotal;
	}

	public void setQ25iA03OwnedByClientWithOngoingSubsidyTotal(
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyTotal) {
		this.q25iA03OwnedByClientWithOngoingSubsidyTotal = q25iA03OwnedByClientWithOngoingSubsidyTotal;
	}

	public BigInteger getQ25iA03OwnedByClientWithOngoingSubsidyWithoutChild() {
		return q25iA03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public void setQ25iA03OwnedByClientWithOngoingSubsidyWithoutChild(
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithoutChild) {
		this.q25iA03OwnedByClientWithOngoingSubsidyWithoutChild = q25iA03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults() {
		return q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public void setQ25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults) {
		this.q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults = q25iA03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild() {
		return q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public void setQ25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild(
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild) {
		this.q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild = q25iA03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold() {
		return q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public void setQ25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(
			BigInteger q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold) {
		this.q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold = q25iA03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ25iA04RentalByClientNoOngoingSubsidyTotal() {
		return q25iA04RentalByClientNoOngoingSubsidyTotal;
	}

	public void setQ25iA04RentalByClientNoOngoingSubsidyTotal(
			BigInteger q25iA04RentalByClientNoOngoingSubsidyTotal) {
		this.q25iA04RentalByClientNoOngoingSubsidyTotal = q25iA04RentalByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ25iA04RentalByClientNoOngoingSubsidyWithoutChild() {
		return q25iA04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ25iA04RentalByClientNoOngoingSubsidyWithoutChild(
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithoutChild) {
		this.q25iA04RentalByClientNoOngoingSubsidyWithoutChild = q25iA04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults() {
		return q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults) {
		this.q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults = q25iA04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ25iA04RentalByClientNoOngoingSubsidyWithOnlyChild() {
		return q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ25iA04RentalByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild) {
		this.q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild = q25iA04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold() {
		return q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold) {
		this.q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold = q25iA04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ25iA05RentalByClientVASHSubsidyTotal() {
		return q25iA05RentalByClientVASHSubsidyTotal;
	}

	public void setQ25iA05RentalByClientVASHSubsidyTotal(
			BigInteger q25iA05RentalByClientVASHSubsidyTotal) {
		this.q25iA05RentalByClientVASHSubsidyTotal = q25iA05RentalByClientVASHSubsidyTotal;
	}

	public BigInteger getQ25iA05RentalByClientVASHSubsidyWithoutChild() {
		return q25iA05RentalByClientVASHSubsidyWithoutChild;
	}

	public void setQ25iA05RentalByClientVASHSubsidyWithoutChild(
			BigInteger q25iA05RentalByClientVASHSubsidyWithoutChild) {
		this.q25iA05RentalByClientVASHSubsidyWithoutChild = q25iA05RentalByClientVASHSubsidyWithoutChild;
	}

	public BigInteger getQ25iA05RentalByClientVASHSubsidyWithChildAndAdults() {
		return q25iA05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public void setQ25iA05RentalByClientVASHSubsidyWithChildAndAdults(
			BigInteger q25iA05RentalByClientVASHSubsidyWithChildAndAdults) {
		this.q25iA05RentalByClientVASHSubsidyWithChildAndAdults = q25iA05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public BigInteger getQ25iA05RentalByClientVASHSubsidyWithOnlyChild() {
		return q25iA05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public void setQ25iA05RentalByClientVASHSubsidyWithOnlyChild(
			BigInteger q25iA05RentalByClientVASHSubsidyWithOnlyChild) {
		this.q25iA05RentalByClientVASHSubsidyWithOnlyChild = q25iA05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public BigInteger getQ25iA05RentalByClientVASHSubsidyUnknownHouseHold() {
		return q25iA05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public void setQ25iA05RentalByClientVASHSubsidyUnknownHouseHold(
			BigInteger q25iA05RentalByClientVASHSubsidyUnknownHouseHold) {
		this.q25iA05RentalByClientVASHSubsidyUnknownHouseHold = q25iA05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public BigInteger getQ25iA06RentalByClientwithGPDTIPHousingTotal() {
		return q25iA06RentalByClientwithGPDTIPHousingTotal;
	}

	public void setQ25iA06RentalByClientwithGPDTIPHousingTotal(
			BigInteger q25iA06RentalByClientwithGPDTIPHousingTotal) {
		this.q25iA06RentalByClientwithGPDTIPHousingTotal = q25iA06RentalByClientwithGPDTIPHousingTotal;
	}

	public BigInteger getQ25iA06RentalByClientwithGPDTIPHousingWithoutChild() {
		return q25iA06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public void setQ25iA06RentalByClientwithGPDTIPHousingWithoutChild(
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithoutChild) {
		this.q25iA06RentalByClientwithGPDTIPHousingWithoutChild = q25iA06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public BigInteger getQ25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults() {
		return q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public void setQ25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults(
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults) {
		this.q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults = q25iA06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public BigInteger getQ25iA06RentalByClientwithGPDTIPHousingWithOnlyChild() {
		return q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public void setQ25iA06RentalByClientwithGPDTIPHousingWithOnlyChild(
			BigInteger q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild) {
		this.q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild = q25iA06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public BigInteger getQ25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold() {
		return q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public void setQ25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold(
			BigInteger q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold) {
		this.q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold = q25iA06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public BigInteger getQ25iA07RentalByClientOtherOngoingSubsidyTotal() {
		return q25iA07RentalByClientOtherOngoingSubsidyTotal;
	}

	public void setQ25iA07RentalByClientOtherOngoingSubsidyTotal(
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyTotal) {
		this.q25iA07RentalByClientOtherOngoingSubsidyTotal = q25iA07RentalByClientOtherOngoingSubsidyTotal;
	}

	public BigInteger getQ25iA07RentalByClientOtherOngoingSubsidyWithoutChild() {
		return q25iA07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public void setQ25iA07RentalByClientOtherOngoingSubsidyWithoutChild(
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithoutChild) {
		this.q25iA07RentalByClientOtherOngoingSubsidyWithoutChild = q25iA07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults() {
		return q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public void setQ25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults) {
		this.q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults = q25iA07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild() {
		return q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public void setQ25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild(
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild) {
		this.q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild = q25iA07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold() {
		return q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public void setQ25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(
			BigInteger q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold) {
		this.q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold = q25iA07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ25iA08PermanentHousingForHomelessTotal() {
		return q25iA08PermanentHousingForHomelessTotal;
	}

	public void setQ25iA08PermanentHousingForHomelessTotal(
			BigInteger q25iA08PermanentHousingForHomelessTotal) {
		this.q25iA08PermanentHousingForHomelessTotal = q25iA08PermanentHousingForHomelessTotal;
	}

	public BigInteger getQ25iA08PermanentHousingForHomelessWithoutChild() {
		return q25iA08PermanentHousingForHomelessWithoutChild;
	}

	public void setQ25iA08PermanentHousingForHomelessWithoutChild(
			BigInteger q25iA08PermanentHousingForHomelessWithoutChild) {
		this.q25iA08PermanentHousingForHomelessWithoutChild = q25iA08PermanentHousingForHomelessWithoutChild;
	}

	public BigInteger getQ25iA08PermanentHousingForHomelessWithChildAndAdults() {
		return q25iA08PermanentHousingForHomelessWithChildAndAdults;
	}

	public void setQ25iA08PermanentHousingForHomelessWithChildAndAdults(
			BigInteger q25iA08PermanentHousingForHomelessWithChildAndAdults) {
		this.q25iA08PermanentHousingForHomelessWithChildAndAdults = q25iA08PermanentHousingForHomelessWithChildAndAdults;
	}

	public BigInteger getQ25iA08PermanentHousingForHomelessWithOnlyChild() {
		return q25iA08PermanentHousingForHomelessWithOnlyChild;
	}

	public void setQ25iA08PermanentHousingForHomelessWithOnlyChild(
			BigInteger q25iA08PermanentHousingForHomelessWithOnlyChild) {
		this.q25iA08PermanentHousingForHomelessWithOnlyChild = q25iA08PermanentHousingForHomelessWithOnlyChild;
	}

	public BigInteger getQ25iA08PermanentHousingForHomelessUnknownHouseHold() {
		return q25iA08PermanentHousingForHomelessUnknownHouseHold;
	}

	public void setQ25iA08PermanentHousingForHomelessUnknownHouseHold(
			BigInteger q25iA08PermanentHousingForHomelessUnknownHouseHold) {
		this.q25iA08PermanentHousingForHomelessUnknownHouseHold = q25iA08PermanentHousingForHomelessUnknownHouseHold;
	}

	public BigInteger getQ25iA09StayingOrLivingWithFamilyPermanentTotal() {
		return q25iA09StayingOrLivingWithFamilyPermanentTotal;
	}

	public void setQ25iA09StayingOrLivingWithFamilyPermanentTotal(
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentTotal) {
		this.q25iA09StayingOrLivingWithFamilyPermanentTotal = q25iA09StayingOrLivingWithFamilyPermanentTotal;
	}

	public BigInteger getQ25iA09StayingOrLivingWithFamilyPermanentWithoutChild() {
		return q25iA09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public void setQ25iA09StayingOrLivingWithFamilyPermanentWithoutChild(
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithoutChild) {
		this.q25iA09StayingOrLivingWithFamilyPermanentWithoutChild = q25iA09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public BigInteger getQ25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults() {
		return q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public void setQ25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults) {
		this.q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults = q25iA09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public BigInteger getQ25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild() {
		return q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public void setQ25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild(
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild) {
		this.q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild = q25iA09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public BigInteger getQ25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold() {
		return q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public void setQ25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(
			BigInteger q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold) {
		this.q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold = q25iA09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public BigInteger getQ25iA10StayingOrLivingWithFriendsPermanentTotal() {
		return q25iA10StayingOrLivingWithFriendsPermanentTotal;
	}

	public void setQ25iA10StayingOrLivingWithFriendsPermanentTotal(
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentTotal) {
		this.q25iA10StayingOrLivingWithFriendsPermanentTotal = q25iA10StayingOrLivingWithFriendsPermanentTotal;
	}

	public BigInteger getQ25iA10StayingOrLivingWithFriendsPermanentWithoutChild() {
		return q25iA10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public void setQ25iA10StayingOrLivingWithFriendsPermanentWithoutChild(
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithoutChild) {
		this.q25iA10StayingOrLivingWithFriendsPermanentWithoutChild = q25iA10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public BigInteger getQ25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults() {
		return q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public void setQ25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults) {
		this.q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults = q25iA10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public BigInteger getQ25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild() {
		return q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public void setQ25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild(
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild) {
		this.q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild = q25iA10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public BigInteger getQ25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold() {
		return q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public void setQ25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(
			BigInteger q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold) {
		this.q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold = q25iA10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public BigInteger getQ25iAzTotTotal() {
		return q25iAzTotTotal;
	}

	public void setQ25iAzTotTotal(BigInteger q25iAzTotTotal) {
		this.q25iAzTotTotal = q25iAzTotTotal;
	}

	public BigInteger getQ25iAzTotWithoutChild() {
		return q25iAzTotWithoutChild;
	}

	public void setQ25iAzTotWithoutChild(BigInteger q25iAzTotWithoutChild) {
		this.q25iAzTotWithoutChild = q25iAzTotWithoutChild;
	}

	public BigInteger getQ25iAzTotWithChildAndAdults() {
		return q25iAzTotWithChildAndAdults;
	}

	public void setQ25iAzTotWithChildAndAdults(
			BigInteger q25iAzTotWithChildAndAdults) {
		this.q25iAzTotWithChildAndAdults = q25iAzTotWithChildAndAdults;
	}

	public BigInteger getQ25iAzTotWithOnlyChild() {
		return q25iAzTotWithOnlyChild;
	}

	public void setQ25iAzTotWithOnlyChild(BigInteger q25iAzTotWithOnlyChild) {
		this.q25iAzTotWithOnlyChild = q25iAzTotWithOnlyChild;
	}

	public BigInteger getQ25iAzTotUnknownHouseHold() {
		return q25iAzTotUnknownHouseHold;
	}

	public void setQ25iAzTotUnknownHouseHold(BigInteger q25iAzTotUnknownHouseHold) {
		this.q25iAzTotUnknownHouseHold = q25iAzTotUnknownHouseHold;
	}

	public BigInteger getQ25iB1EmergencyShelterTotal() {
		return q25iB1EmergencyShelterTotal;
	}

	public void setQ25iB1EmergencyShelterTotal(
			BigInteger q25iB1EmergencyShelterTotal) {
		this.q25iB1EmergencyShelterTotal = q25iB1EmergencyShelterTotal;
	}

	public BigInteger getQ25iB1EmergencyShelterWithoutChild() {
		return q25iB1EmergencyShelterWithoutChild;
	}

	public void setQ25iB1EmergencyShelterWithoutChild(
			BigInteger q25iB1EmergencyShelterWithoutChild) {
		this.q25iB1EmergencyShelterWithoutChild = q25iB1EmergencyShelterWithoutChild;
	}

	public BigInteger getQ25iB1EmergencyShelterWithChildAndAdults() {
		return q25iB1EmergencyShelterWithChildAndAdults;
	}

	public void setQ25iB1EmergencyShelterWithChildAndAdults(
			BigInteger q25iB1EmergencyShelterWithChildAndAdults) {
		this.q25iB1EmergencyShelterWithChildAndAdults = q25iB1EmergencyShelterWithChildAndAdults;
	}

	public BigInteger getQ25iB1EmergencyShelterWithOnlyChild() {
		return q25iB1EmergencyShelterWithOnlyChild;
	}

	public void setQ25iB1EmergencyShelterWithOnlyChild(
			BigInteger q25iB1EmergencyShelterWithOnlyChild) {
		this.q25iB1EmergencyShelterWithOnlyChild = q25iB1EmergencyShelterWithOnlyChild;
	}

	public BigInteger getQ25iB1EmergencyShelterUnknownHouseHold() {
		return q25iB1EmergencyShelterUnknownHouseHold;
	}

	public void setQ25iB1EmergencyShelterUnknownHouseHold(
			BigInteger q25iB1EmergencyShelterUnknownHouseHold) {
		this.q25iB1EmergencyShelterUnknownHouseHold = q25iB1EmergencyShelterUnknownHouseHold;
	}

	public BigInteger getQ25iB2MovedFromOneHOPWATotal() {
		return q25iB2MovedFromOneHOPWATotal;
	}

	public void setQ25iB2MovedFromOneHOPWATotal(
			BigInteger q25iB2MovedFromOneHOPWATotal) {
		this.q25iB2MovedFromOneHOPWATotal = q25iB2MovedFromOneHOPWATotal;
	}

	public BigInteger getQ25iB2MovedFromOneHOPWAWithoutChild() {
		return q25iB2MovedFromOneHOPWAWithoutChild;
	}

	public void setQ25iB2MovedFromOneHOPWAWithoutChild(
			BigInteger q25iB2MovedFromOneHOPWAWithoutChild) {
		this.q25iB2MovedFromOneHOPWAWithoutChild = q25iB2MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ25iB2MovedFromOneHOPWAWithChildAndAdults() {
		return q25iB2MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ25iB2MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q25iB2MovedFromOneHOPWAWithChildAndAdults) {
		this.q25iB2MovedFromOneHOPWAWithChildAndAdults = q25iB2MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ25iB2MovedFromOneHOPWAWithOnlyChild() {
		return q25iB2MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ25iB2MovedFromOneHOPWAWithOnlyChild(
			BigInteger q25iB2MovedFromOneHOPWAWithOnlyChild) {
		this.q25iB2MovedFromOneHOPWAWithOnlyChild = q25iB2MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ25iB2MovedFromOneHOPWAUnknownHouseHold() {
		return q25iB2MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ25iB2MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q25iB2MovedFromOneHOPWAUnknownHouseHold) {
		this.q25iB2MovedFromOneHOPWAUnknownHouseHold = q25iB2MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ25iB3TransitionalHousingForHomelessTotal() {
		return q25iB3TransitionalHousingForHomelessTotal;
	}

	public void setQ25iB3TransitionalHousingForHomelessTotal(
			BigInteger q25iB3TransitionalHousingForHomelessTotal) {
		this.q25iB3TransitionalHousingForHomelessTotal = q25iB3TransitionalHousingForHomelessTotal;
	}

	public BigInteger getQ25iB3TransitionalHousingForHomelessWithoutChild() {
		return q25iB3TransitionalHousingForHomelessWithoutChild;
	}

	public void setQ25iB3TransitionalHousingForHomelessWithoutChild(
			BigInteger q25iB3TransitionalHousingForHomelessWithoutChild) {
		this.q25iB3TransitionalHousingForHomelessWithoutChild = q25iB3TransitionalHousingForHomelessWithoutChild;
	}

	public BigInteger getQ25iB3TransitionalHousingForHomelessWithChildAndAdults() {
		return q25iB3TransitionalHousingForHomelessWithChildAndAdults;
	}

	public void setQ25iB3TransitionalHousingForHomelessWithChildAndAdults(
			BigInteger q25iB3TransitionalHousingForHomelessWithChildAndAdults) {
		this.q25iB3TransitionalHousingForHomelessWithChildAndAdults = q25iB3TransitionalHousingForHomelessWithChildAndAdults;
	}

	public BigInteger getQ25iB3TransitionalHousingForHomelessWithOnlyChild() {
		return q25iB3TransitionalHousingForHomelessWithOnlyChild;
	}

	public void setQ25iB3TransitionalHousingForHomelessWithOnlyChild(
			BigInteger q25iB3TransitionalHousingForHomelessWithOnlyChild) {
		this.q25iB3TransitionalHousingForHomelessWithOnlyChild = q25iB3TransitionalHousingForHomelessWithOnlyChild;
	}

	public BigInteger getQ25iB3TransitionalHousingForHomelessUnknownHouseHold() {
		return q25iB3TransitionalHousingForHomelessUnknownHouseHold;
	}

	public void setQ25iB3TransitionalHousingForHomelessUnknownHouseHold(
			BigInteger q25iB3TransitionalHousingForHomelessUnknownHouseHold) {
		this.q25iB3TransitionalHousingForHomelessUnknownHouseHold = q25iB3TransitionalHousingForHomelessUnknownHouseHold;
	}

	public BigInteger getQ25iB4StayingWithFamilyTemporaryTenureTotal() {
		return q25iB4StayingWithFamilyTemporaryTenureTotal;
	}

	public void setQ25iB4StayingWithFamilyTemporaryTenureTotal(
			BigInteger q25iB4StayingWithFamilyTemporaryTenureTotal) {
		this.q25iB4StayingWithFamilyTemporaryTenureTotal = q25iB4StayingWithFamilyTemporaryTenureTotal;
	}

	public BigInteger getQ25iB4StayingWithFamilyTemporaryTenureWithoutChild() {
		return q25iB4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public void setQ25iB4StayingWithFamilyTemporaryTenureWithoutChild(
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithoutChild) {
		this.q25iB4StayingWithFamilyTemporaryTenureWithoutChild = q25iB4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public BigInteger getQ25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults() {
		return q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public void setQ25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults(
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults) {
		this.q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults = q25iB4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ25iB4StayingWithFamilyTemporaryTenureWithOnlyChild() {
		return q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public void setQ25iB4StayingWithFamilyTemporaryTenureWithOnlyChild(
			BigInteger q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild) {
		this.q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild = q25iB4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold() {
		return q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public void setQ25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold(
			BigInteger q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold) {
		this.q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold = q25iB4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ25iB5StayingWithFriendsTemporaryTenureTotal() {
		return q25iB5StayingWithFriendsTemporaryTenureTotal;
	}

	public void setQ25iB5StayingWithFriendsTemporaryTenureTotal(
			BigInteger q25iB5StayingWithFriendsTemporaryTenureTotal) {
		this.q25iB5StayingWithFriendsTemporaryTenureTotal = q25iB5StayingWithFriendsTemporaryTenureTotal;
	}

	public BigInteger getQ25iB5StayingWithFriendsTemporaryTenureWithoutChild() {
		return q25iB5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public void setQ25iB5StayingWithFriendsTemporaryTenureWithoutChild(
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithoutChild) {
		this.q25iB5StayingWithFriendsTemporaryTenureWithoutChild = q25iB5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public BigInteger getQ25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults() {
		return q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public void setQ25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults(
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults) {
		this.q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults = q25iB5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ25iB5StayingWithFriendsTemporaryTenureWithOnlyChild() {
		return q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public void setQ25iB5StayingWithFriendsTemporaryTenureWithOnlyChild(
			BigInteger q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild) {
		this.q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild = q25iB5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold() {
		return q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public void setQ25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold(
			BigInteger q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold) {
		this.q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold = q25iB5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ25iB6PlaceNotMeantForHumanHabitationTotal() {
		return q25iB6PlaceNotMeantForHumanHabitationTotal;
	}

	public void setQ25iB6PlaceNotMeantForHumanHabitationTotal(
			BigInteger q25iB6PlaceNotMeantForHumanHabitationTotal) {
		this.q25iB6PlaceNotMeantForHumanHabitationTotal = q25iB6PlaceNotMeantForHumanHabitationTotal;
	}

	public BigInteger getQ25iB6PlaceNotMeantForHumanHabitationWithoutChild() {
		return q25iB6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public void setQ25iB6PlaceNotMeantForHumanHabitationWithoutChild(
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithoutChild) {
		this.q25iB6PlaceNotMeantForHumanHabitationWithoutChild = q25iB6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public BigInteger getQ25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults() {
		return q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public void setQ25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults(
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults) {
		this.q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults = q25iB6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public BigInteger getQ25iB6PlaceNotMeantForHumanHabitationWithOnlyChild() {
		return q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public void setQ25iB6PlaceNotMeantForHumanHabitationWithOnlyChild(
			BigInteger q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild) {
		this.q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild = q25iB6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public BigInteger getQ25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold() {
		return q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public void setQ25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold(
			BigInteger q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold) {
		this.q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold = q25iB6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public BigInteger getQ25iB7SafeHavenTotal() {
		return q25iB7SafeHavenTotal;
	}

	public void setQ25iB7SafeHavenTotal(BigInteger q25iB7SafeHavenTotal) {
		this.q25iB7SafeHavenTotal = q25iB7SafeHavenTotal;
	}

	public BigInteger getQ25iB7SafeHavenWithoutChild() {
		return q25iB7SafeHavenWithoutChild;
	}

	public void setQ25iB7SafeHavenWithoutChild(
			BigInteger q25iB7SafeHavenWithoutChild) {
		this.q25iB7SafeHavenWithoutChild = q25iB7SafeHavenWithoutChild;
	}

	public BigInteger getQ25iB7SafeHavenWithChildAndAdults() {
		return q25iB7SafeHavenWithChildAndAdults;
	}

	public void setQ25iB7SafeHavenWithChildAndAdults(
			BigInteger q25iB7SafeHavenWithChildAndAdults) {
		this.q25iB7SafeHavenWithChildAndAdults = q25iB7SafeHavenWithChildAndAdults;
	}

	public BigInteger getQ25iB7SafeHavenWithOnlyChild() {
		return q25iB7SafeHavenWithOnlyChild;
	}

	public void setQ25iB7SafeHavenWithOnlyChild(
			BigInteger q25iB7SafeHavenWithOnlyChild) {
		this.q25iB7SafeHavenWithOnlyChild = q25iB7SafeHavenWithOnlyChild;
	}

	public BigInteger getQ25iB7SafeHavenUnknownHouseHold() {
		return q25iB7SafeHavenUnknownHouseHold;
	}

	public void setQ25iB7SafeHavenUnknownHouseHold(
			BigInteger q25iB7SafeHavenUnknownHouseHold) {
		this.q25iB7SafeHavenUnknownHouseHold = q25iB7SafeHavenUnknownHouseHold;
	}

	public BigInteger getQ25iB8HotelOrMotelPaidbyClientTotal() {
		return q25iB8HotelOrMotelPaidbyClientTotal;
	}

	public void setQ25iB8HotelOrMotelPaidbyClientTotal(
			BigInteger q25iB8HotelOrMotelPaidbyClientTotal) {
		this.q25iB8HotelOrMotelPaidbyClientTotal = q25iB8HotelOrMotelPaidbyClientTotal;
	}

	public BigInteger getQ25iB8HotelOrMotelPaidbyClientWithoutChild() {
		return q25iB8HotelOrMotelPaidbyClientWithoutChild;
	}

	public void setQ25iB8HotelOrMotelPaidbyClientWithoutChild(
			BigInteger q25iB8HotelOrMotelPaidbyClientWithoutChild) {
		this.q25iB8HotelOrMotelPaidbyClientWithoutChild = q25iB8HotelOrMotelPaidbyClientWithoutChild;
	}

	public BigInteger getQ25iB8HotelOrMotelPaidbyClientWithChildAndAdults() {
		return q25iB8HotelOrMotelPaidbyClientWithChildAndAdults;
	}

	public void setQ25iB8HotelOrMotelPaidbyClientWithChildAndAdults(
			BigInteger q25iB8HotelOrMotelPaidbyClientWithChildAndAdults) {
		this.q25iB8HotelOrMotelPaidbyClientWithChildAndAdults = q25iB8HotelOrMotelPaidbyClientWithChildAndAdults;
	}

	public BigInteger getQ25iB8HotelOrMotelPaidbyClientWithOnlyChild() {
		return q25iB8HotelOrMotelPaidbyClientWithOnlyChild;
	}

	public void setQ25iB8HotelOrMotelPaidbyClientWithOnlyChild(
			BigInteger q25iB8HotelOrMotelPaidbyClientWithOnlyChild) {
		this.q25iB8HotelOrMotelPaidbyClientWithOnlyChild = q25iB8HotelOrMotelPaidbyClientWithOnlyChild;
	}

	public BigInteger getQ25iB8HotelOrMotelPaidbyClientUnknownHouseHold() {
		return q25iB8HotelOrMotelPaidbyClientUnknownHouseHold;
	}

	public void setQ25iB8HotelOrMotelPaidbyClientUnknownHouseHold(
			BigInteger q25iB8HotelOrMotelPaidbyClientUnknownHouseHold) {
		this.q25iB8HotelOrMotelPaidbyClientUnknownHouseHold = q25iB8HotelOrMotelPaidbyClientUnknownHouseHold;
	}

	public BigInteger getQ25iBzTotTotal() {
		return q25iBzTotTotal;
	}

	public void setQ25iBzTotTotal(BigInteger q25iBzTotTotal) {
		this.q25iBzTotTotal = q25iBzTotTotal;
	}

	public BigInteger getQ25iBzTotWithoutChild() {
		return q25iBzTotWithoutChild;
	}

	public void setQ25iBzTotWithoutChild(BigInteger q25iBzTotWithoutChild) {
		this.q25iBzTotWithoutChild = q25iBzTotWithoutChild;
	}

	public BigInteger getQ25iBzTotWithChildAndAdults() {
		return q25iBzTotWithChildAndAdults;
	}

	public void setQ25iBzTotWithChildAndAdults(
			BigInteger q25iBzTotWithChildAndAdults) {
		this.q25iBzTotWithChildAndAdults = q25iBzTotWithChildAndAdults;
	}

	public BigInteger getQ25iBzTotWithOnlyChild() {
		return q25iBzTotWithOnlyChild;
	}

	public void setQ25iBzTotWithOnlyChild(BigInteger q25iBzTotWithOnlyChild) {
		this.q25iBzTotWithOnlyChild = q25iBzTotWithOnlyChild;
	}

	public BigInteger getQ25iBzTotUnknownHouseHold() {
		return q25iBzTotUnknownHouseHold;
	}

	public void setQ25iBzTotUnknownHouseHold(BigInteger q25iBzTotUnknownHouseHold) {
		this.q25iBzTotUnknownHouseHold = q25iBzTotUnknownHouseHold;
	}

	public BigInteger getQ25iC1FosterCareHomeOrGroupFosterCareTotal() {
		return q25iC1FosterCareHomeOrGroupFosterCareTotal;
	}

	public void setQ25iC1FosterCareHomeOrGroupFosterCareTotal(
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareTotal) {
		this.q25iC1FosterCareHomeOrGroupFosterCareTotal = q25iC1FosterCareHomeOrGroupFosterCareTotal;
	}

	public BigInteger getQ25iC1FosterCareHomeOrGroupFosterCareWithoutChild() {
		return q25iC1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public void setQ25iC1FosterCareHomeOrGroupFosterCareWithoutChild(
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithoutChild) {
		this.q25iC1FosterCareHomeOrGroupFosterCareWithoutChild = q25iC1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public BigInteger getQ25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults() {
		return q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public void setQ25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults) {
		this.q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults = q25iC1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public BigInteger getQ25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild() {
		return q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public void setQ25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild(
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild) {
		this.q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild = q25iC1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public BigInteger getQ25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold() {
		return q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public void setQ25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(
			BigInteger q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold) {
		this.q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold = q25iC1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public BigInteger getQ25iC2PsychiatricHospitalOrOtherTotal() {
		return q25iC2PsychiatricHospitalOrOtherTotal;
	}

	public void setQ25iC2PsychiatricHospitalOrOtherTotal(
			BigInteger q25iC2PsychiatricHospitalOrOtherTotal) {
		this.q25iC2PsychiatricHospitalOrOtherTotal = q25iC2PsychiatricHospitalOrOtherTotal;
	}

	public BigInteger getQ25iC2PsychiatricHospitalOrOtherWithoutChild() {
		return q25iC2PsychiatricHospitalOrOtherWithoutChild;
	}

	public void setQ25iC2PsychiatricHospitalOrOtherWithoutChild(
			BigInteger q25iC2PsychiatricHospitalOrOtherWithoutChild) {
		this.q25iC2PsychiatricHospitalOrOtherWithoutChild = q25iC2PsychiatricHospitalOrOtherWithoutChild;
	}

	public BigInteger getQ25iC2PsychiatricHospitalOrOtherWithChildAndAdults() {
		return q25iC2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public void setQ25iC2PsychiatricHospitalOrOtherWithChildAndAdults(
			BigInteger q25iC2PsychiatricHospitalOrOtherWithChildAndAdults) {
		this.q25iC2PsychiatricHospitalOrOtherWithChildAndAdults = q25iC2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public BigInteger getQ25iC2PsychiatricHospitalOrOtherWithOnlyChild() {
		return q25iC2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public void setQ25iC2PsychiatricHospitalOrOtherWithOnlyChild(
			BigInteger q25iC2PsychiatricHospitalOrOtherWithOnlyChild) {
		this.q25iC2PsychiatricHospitalOrOtherWithOnlyChild = q25iC2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public BigInteger getQ25iC2PsychiatricHospitalOrOtherUnknownHouseHold() {
		return q25iC2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public void setQ25iC2PsychiatricHospitalOrOtherUnknownHouseHold(
			BigInteger q25iC2PsychiatricHospitalOrOtherUnknownHouseHold) {
		this.q25iC2PsychiatricHospitalOrOtherUnknownHouseHold = q25iC2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public BigInteger getQ25iC3SubstanceAbuseTreatmentFacilityTotal() {
		return q25iC3SubstanceAbuseTreatmentFacilityTotal;
	}

	public void setQ25iC3SubstanceAbuseTreatmentFacilityTotal(
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityTotal) {
		this.q25iC3SubstanceAbuseTreatmentFacilityTotal = q25iC3SubstanceAbuseTreatmentFacilityTotal;
	}

	public BigInteger getQ25iC3SubstanceAbuseTreatmentFacilityWithoutChild() {
		return q25iC3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public void setQ25iC3SubstanceAbuseTreatmentFacilityWithoutChild(
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithoutChild) {
		this.q25iC3SubstanceAbuseTreatmentFacilityWithoutChild = q25iC3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public BigInteger getQ25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults() {
		return q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public void setQ25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults) {
		this.q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults = q25iC3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public BigInteger getQ25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild() {
		return q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public void setQ25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild(
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild) {
		this.q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild = q25iC3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public BigInteger getQ25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold() {
		return q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public void setQ25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(
			BigInteger q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold) {
		this.q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold = q25iC3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public BigInteger getQ25iC4HospitalOrOtherResidentialTotal() {
		return q25iC4HospitalOrOtherResidentialTotal;
	}

	public void setQ25iC4HospitalOrOtherResidentialTotal(
			BigInteger q25iC4HospitalOrOtherResidentialTotal) {
		this.q25iC4HospitalOrOtherResidentialTotal = q25iC4HospitalOrOtherResidentialTotal;
	}

	public BigInteger getQ25iC4HospitalOrOtherResidentialWithoutChild() {
		return q25iC4HospitalOrOtherResidentialWithoutChild;
	}

	public void setQ25iC4HospitalOrOtherResidentialWithoutChild(
			BigInteger q25iC4HospitalOrOtherResidentialWithoutChild) {
		this.q25iC4HospitalOrOtherResidentialWithoutChild = q25iC4HospitalOrOtherResidentialWithoutChild;
	}

	public BigInteger getQ25iC4HospitalOrOtherResidentialWithChildAndAdults() {
		return q25iC4HospitalOrOtherResidentialWithChildAndAdults;
	}

	public void setQ25iC4HospitalOrOtherResidentialWithChildAndAdults(
			BigInteger q25iC4HospitalOrOtherResidentialWithChildAndAdults) {
		this.q25iC4HospitalOrOtherResidentialWithChildAndAdults = q25iC4HospitalOrOtherResidentialWithChildAndAdults;
	}

	public BigInteger getQ25iC4HospitalOrOtherResidentialWithOnlyChild() {
		return q25iC4HospitalOrOtherResidentialWithOnlyChild;
	}

	public void setQ25iC4HospitalOrOtherResidentialWithOnlyChild(
			BigInteger q25iC4HospitalOrOtherResidentialWithOnlyChild) {
		this.q25iC4HospitalOrOtherResidentialWithOnlyChild = q25iC4HospitalOrOtherResidentialWithOnlyChild;
	}

	public BigInteger getQ25iC4HospitalOrOtherResidentialUnknownHouseHold() {
		return q25iC4HospitalOrOtherResidentialUnknownHouseHold;
	}

	public void setQ25iC4HospitalOrOtherResidentialUnknownHouseHold(
			BigInteger q25iC4HospitalOrOtherResidentialUnknownHouseHold) {
		this.q25iC4HospitalOrOtherResidentialUnknownHouseHold = q25iC4HospitalOrOtherResidentialUnknownHouseHold;
	}

	public BigInteger getQ25iC5JailPrisonOrUvenileDetentionTotal() {
		return q25iC5JailPrisonOrUvenileDetentionTotal;
	}

	public void setQ25iC5JailPrisonOrUvenileDetentionTotal(
			BigInteger q25iC5JailPrisonOrUvenileDetentionTotal) {
		this.q25iC5JailPrisonOrUvenileDetentionTotal = q25iC5JailPrisonOrUvenileDetentionTotal;
	}

	public BigInteger getQ25iC5JailPrisonOrUvenileDetentionWithoutChild() {
		return q25iC5JailPrisonOrUvenileDetentionWithoutChild;
	}

	public void setQ25iC5JailPrisonOrUvenileDetentionWithoutChild(
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithoutChild) {
		this.q25iC5JailPrisonOrUvenileDetentionWithoutChild = q25iC5JailPrisonOrUvenileDetentionWithoutChild;
	}

	public BigInteger getQ25iC5JailPrisonOrUvenileDetentionWithChildAndAdults() {
		return q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults;
	}

	public void setQ25iC5JailPrisonOrUvenileDetentionWithChildAndAdults(
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults) {
		this.q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults = q25iC5JailPrisonOrUvenileDetentionWithChildAndAdults;
	}

	public BigInteger getQ25iC5JailPrisonOrUvenileDetentionWithOnlyChild() {
		return q25iC5JailPrisonOrUvenileDetentionWithOnlyChild;
	}

	public void setQ25iC5JailPrisonOrUvenileDetentionWithOnlyChild(
			BigInteger q25iC5JailPrisonOrUvenileDetentionWithOnlyChild) {
		this.q25iC5JailPrisonOrUvenileDetentionWithOnlyChild = q25iC5JailPrisonOrUvenileDetentionWithOnlyChild;
	}

	public BigInteger getQ25iC5JailPrisonOrUvenileDetentionUnknownHouseHold() {
		return q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold;
	}

	public void setQ25iC5JailPrisonOrUvenileDetentionUnknownHouseHold(
			BigInteger q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold) {
		this.q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold = q25iC5JailPrisonOrUvenileDetentionUnknownHouseHold;
	}

	public BigInteger getQ25iC6LongTermCareFacilityTotal() {
		return q25iC6LongTermCareFacilityTotal;
	}

	public void setQ25iC6LongTermCareFacilityTotal(
			BigInteger q25iC6LongTermCareFacilityTotal) {
		this.q25iC6LongTermCareFacilityTotal = q25iC6LongTermCareFacilityTotal;
	}

	public BigInteger getQ25iC6LongTermCareFacilityWithoutChild() {
		return q25iC6LongTermCareFacilityWithoutChild;
	}

	public void setQ25iC6LongTermCareFacilityWithoutChild(
			BigInteger q25iC6LongTermCareFacilityWithoutChild) {
		this.q25iC6LongTermCareFacilityWithoutChild = q25iC6LongTermCareFacilityWithoutChild;
	}

	public BigInteger getQ25iC6LongTermCareFacilityWithChildAndAdults() {
		return q25iC6LongTermCareFacilityWithChildAndAdults;
	}

	public void setQ25iC6LongTermCareFacilityWithChildAndAdults(
			BigInteger q25iC6LongTermCareFacilityWithChildAndAdults) {
		this.q25iC6LongTermCareFacilityWithChildAndAdults = q25iC6LongTermCareFacilityWithChildAndAdults;
	}

	public BigInteger getQ25iC6LongTermCareFacilityWithOnlyChild() {
		return q25iC6LongTermCareFacilityWithOnlyChild;
	}

	public void setQ25iC6LongTermCareFacilityWithOnlyChild(
			BigInteger q25iC6LongTermCareFacilityWithOnlyChild) {
		this.q25iC6LongTermCareFacilityWithOnlyChild = q25iC6LongTermCareFacilityWithOnlyChild;
	}

	public BigInteger getQ25iC6LongTermCareFacilityUnknownHouseHold() {
		return q25iC6LongTermCareFacilityUnknownHouseHold;
	}

	public void setQ25iC6LongTermCareFacilityUnknownHouseHold(
			BigInteger q25iC6LongTermCareFacilityUnknownHouseHold) {
		this.q25iC6LongTermCareFacilityUnknownHouseHold = q25iC6LongTermCareFacilityUnknownHouseHold;
	}

	public BigInteger getQ25iCzTotTotal() {
		return q25iCzTotTotal;
	}

	public void setQ25iCzTotTotal(BigInteger q25iCzTotTotal) {
		this.q25iCzTotTotal = q25iCzTotTotal;
	}

	public BigInteger getQ25iCzTotWithoutChild() {
		return q25iCzTotWithoutChild;
	}

	public void setQ25iCzTotWithoutChild(BigInteger q25iCzTotWithoutChild) {
		this.q25iCzTotWithoutChild = q25iCzTotWithoutChild;
	}

	public BigInteger getQ25iCzTotWithChildAndAdults() {
		return q25iCzTotWithChildAndAdults;
	}

	public void setQ25iCzTotWithChildAndAdults(
			BigInteger q25iCzTotWithChildAndAdults) {
		this.q25iCzTotWithChildAndAdults = q25iCzTotWithChildAndAdults;
	}

	public BigInteger getQ25iCzTotWithOnlyChild() {
		return q25iCzTotWithOnlyChild;
	}

	public void setQ25iCzTotWithOnlyChild(BigInteger q25iCzTotWithOnlyChild) {
		this.q25iCzTotWithOnlyChild = q25iCzTotWithOnlyChild;
	}

	public BigInteger getQ25iCzTotUnknownHouseHold() {
		return q25iCzTotUnknownHouseHold;
	}

	public void setQ25iCzTotUnknownHouseHold(BigInteger q25iCzTotUnknownHouseHold) {
		this.q25iCzTotUnknownHouseHold = q25iCzTotUnknownHouseHold;
	}

	public BigInteger getQ25iD1ResidentialProjectTotal() {
		return q25iD1ResidentialProjectTotal;
	}

	public void setQ25iD1ResidentialProjectTotal(
			BigInteger q25iD1ResidentialProjectTotal) {
		this.q25iD1ResidentialProjectTotal = q25iD1ResidentialProjectTotal;
	}

	public BigInteger getQ25iD1ResidentialProjectWithoutChild() {
		return q25iD1ResidentialProjectWithoutChild;
	}

	public void setQ25iD1ResidentialProjectWithoutChild(
			BigInteger q25iD1ResidentialProjectWithoutChild) {
		this.q25iD1ResidentialProjectWithoutChild = q25iD1ResidentialProjectWithoutChild;
	}

	public BigInteger getQ25iD1ResidentialProjectWithChildAndAdults() {
		return q25iD1ResidentialProjectWithChildAndAdults;
	}

	public void setQ25iD1ResidentialProjectWithChildAndAdults(
			BigInteger q25iD1ResidentialProjectWithChildAndAdults) {
		this.q25iD1ResidentialProjectWithChildAndAdults = q25iD1ResidentialProjectWithChildAndAdults;
	}

	public BigInteger getQ25iD1ResidentialProjectWithOnlyChild() {
		return q25iD1ResidentialProjectWithOnlyChild;
	}

	public void setQ25iD1ResidentialProjectWithOnlyChild(
			BigInteger q25iD1ResidentialProjectWithOnlyChild) {
		this.q25iD1ResidentialProjectWithOnlyChild = q25iD1ResidentialProjectWithOnlyChild;
	}

	public BigInteger getQ25iD1ResidentialProjectUnknownHouseHold() {
		return q25iD1ResidentialProjectUnknownHouseHold;
	}

	public void setQ25iD1ResidentialProjectUnknownHouseHold(
			BigInteger q25iD1ResidentialProjectUnknownHouseHold) {
		this.q25iD1ResidentialProjectUnknownHouseHold = q25iD1ResidentialProjectUnknownHouseHold;
	}

	public BigInteger getQ25iD2DeceasedTotal() {
		return q25iD2DeceasedTotal;
	}

	public void setQ25iD2DeceasedTotal(BigInteger q25iD2DeceasedTotal) {
		this.q25iD2DeceasedTotal = q25iD2DeceasedTotal;
	}

	public BigInteger getQ25iD2DeceasedWithoutChild() {
		return q25iD2DeceasedWithoutChild;
	}

	public void setQ25iD2DeceasedWithoutChild(BigInteger q25iD2DeceasedWithoutChild) {
		this.q25iD2DeceasedWithoutChild = q25iD2DeceasedWithoutChild;
	}

	public BigInteger getQ25iD2DeceasedWithChildAndAdults() {
		return q25iD2DeceasedWithChildAndAdults;
	}

	public void setQ25iD2DeceasedWithChildAndAdults(
			BigInteger q25iD2DeceasedWithChildAndAdults) {
		this.q25iD2DeceasedWithChildAndAdults = q25iD2DeceasedWithChildAndAdults;
	}

	public BigInteger getQ25iD2DeceasedWithOnlyChild() {
		return q25iD2DeceasedWithOnlyChild;
	}

	public void setQ25iD2DeceasedWithOnlyChild(
			BigInteger q25iD2DeceasedWithOnlyChild) {
		this.q25iD2DeceasedWithOnlyChild = q25iD2DeceasedWithOnlyChild;
	}

	public BigInteger getQ25iD2DeceasedUnknownHouseHold() {
		return q25iD2DeceasedUnknownHouseHold;
	}

	public void setQ25iD2DeceasedUnknownHouseHold(
			BigInteger q25iD2DeceasedUnknownHouseHold) {
		this.q25iD2DeceasedUnknownHouseHold = q25iD2DeceasedUnknownHouseHold;
	}

	public BigInteger getQ25iD3OtherTotal() {
		return q25iD3OtherTotal;
	}

	public void setQ25iD3OtherTotal(BigInteger q25iD3OtherTotal) {
		this.q25iD3OtherTotal = q25iD3OtherTotal;
	}

	public BigInteger getQ25iD3OtherWithoutChild() {
		return q25iD3OtherWithoutChild;
	}

	public void setQ25iD3OtherWithoutChild(BigInteger q25iD3OtherWithoutChild) {
		this.q25iD3OtherWithoutChild = q25iD3OtherWithoutChild;
	}

	public BigInteger getQ25iD3OtherWithChildAndAdults() {
		return q25iD3OtherWithChildAndAdults;
	}

	public void setQ25iD3OtherWithChildAndAdults(
			BigInteger q25iD3OtherWithChildAndAdults) {
		this.q25iD3OtherWithChildAndAdults = q25iD3OtherWithChildAndAdults;
	}

	public BigInteger getQ25iD3OtherWithOnlyChild() {
		return q25iD3OtherWithOnlyChild;
	}

	public void setQ25iD3OtherWithOnlyChild(BigInteger q25iD3OtherWithOnlyChild) {
		this.q25iD3OtherWithOnlyChild = q25iD3OtherWithOnlyChild;
	}

	public BigInteger getQ25iD3OtherUnknownHouseHold() {
		return q25iD3OtherUnknownHouseHold;
	}

	public void setQ25iD3OtherUnknownHouseHold(
			BigInteger q25iD3OtherUnknownHouseHold) {
		this.q25iD3OtherUnknownHouseHold = q25iD3OtherUnknownHouseHold;
	}

	public BigInteger getQ25iD4DontKnowRefusedTotal() {
		return q25iD4DontKnowRefusedTotal;
	}

	public void setQ25iD4DontKnowRefusedTotal(BigInteger q25iD4DontKnowRefusedTotal) {
		this.q25iD4DontKnowRefusedTotal = q25iD4DontKnowRefusedTotal;
	}

	public BigInteger getQ25iD4DontKnowRefusedWithoutChild() {
		return q25iD4DontKnowRefusedWithoutChild;
	}

	public void setQ25iD4DontKnowRefusedWithoutChild(
			BigInteger q25iD4DontKnowRefusedWithoutChild) {
		this.q25iD4DontKnowRefusedWithoutChild = q25iD4DontKnowRefusedWithoutChild;
	}

	public BigInteger getQ25iD4DontKnowRefusedWithChildAndAdults() {
		return q25iD4DontKnowRefusedWithChildAndAdults;
	}

	public void setQ25iD4DontKnowRefusedWithChildAndAdults(
			BigInteger q25iD4DontKnowRefusedWithChildAndAdults) {
		this.q25iD4DontKnowRefusedWithChildAndAdults = q25iD4DontKnowRefusedWithChildAndAdults;
	}

	public BigInteger getQ25iD4DontKnowRefusedWithOnlyChild() {
		return q25iD4DontKnowRefusedWithOnlyChild;
	}

	public void setQ25iD4DontKnowRefusedWithOnlyChild(
			BigInteger q25iD4DontKnowRefusedWithOnlyChild) {
		this.q25iD4DontKnowRefusedWithOnlyChild = q25iD4DontKnowRefusedWithOnlyChild;
	}

	public BigInteger getQ25iD4DontKnowRefusedUnknownHouseHold() {
		return q25iD4DontKnowRefusedUnknownHouseHold;
	}

	public void setQ25iD4DontKnowRefusedUnknownHouseHold(
			BigInteger q25iD4DontKnowRefusedUnknownHouseHold) {
		this.q25iD4DontKnowRefusedUnknownHouseHold = q25iD4DontKnowRefusedUnknownHouseHold;
	}

	public BigInteger getQ25iD5InformationMissingTotal() {
		return q25iD5InformationMissingTotal;
	}

	public void setQ25iD5InformationMissingTotal(
			BigInteger q25iD5InformationMissingTotal) {
		this.q25iD5InformationMissingTotal = q25iD5InformationMissingTotal;
	}

	public BigInteger getQ25iD5InformationMissingWithoutChild() {
		return q25iD5InformationMissingWithoutChild;
	}

	public void setQ25iD5InformationMissingWithoutChild(
			BigInteger q25iD5InformationMissingWithoutChild) {
		this.q25iD5InformationMissingWithoutChild = q25iD5InformationMissingWithoutChild;
	}

	public BigInteger getQ25iD5InformationMissingWithChildAndAdults() {
		return q25iD5InformationMissingWithChildAndAdults;
	}

	public void setQ25iD5InformationMissingWithChildAndAdults(
			BigInteger q25iD5InformationMissingWithChildAndAdults) {
		this.q25iD5InformationMissingWithChildAndAdults = q25iD5InformationMissingWithChildAndAdults;
	}

	public BigInteger getQ25iD5InformationMissingWithOnlyChild() {
		return q25iD5InformationMissingWithOnlyChild;
	}

	public void setQ25iD5InformationMissingWithOnlyChild(
			BigInteger q25iD5InformationMissingWithOnlyChild) {
		this.q25iD5InformationMissingWithOnlyChild = q25iD5InformationMissingWithOnlyChild;
	}

	public BigInteger getQ25iD5InformationMissingUnknownHouseHold() {
		return q25iD5InformationMissingUnknownHouseHold;
	}

	public void setQ25iD5InformationMissingUnknownHouseHold(
			BigInteger q25iD5InformationMissingUnknownHouseHold) {
		this.q25iD5InformationMissingUnknownHouseHold = q25iD5InformationMissingUnknownHouseHold;
	}

	public BigInteger getQ25iDzTotTotal() {
		return q25iDzTotTotal;
	}

	public void setQ25iDzTotTotal(BigInteger q25iDzTotTotal) {
		this.q25iDzTotTotal = q25iDzTotTotal;
	}

	public BigInteger getQ25iDzTotWithoutChild() {
		return q25iDzTotWithoutChild;
	}

	public void setQ25iDzTotWithoutChild(BigInteger q25iDzTotWithoutChild) {
		this.q25iDzTotWithoutChild = q25iDzTotWithoutChild;
	}

	public BigInteger getQ25iDzTotWithChildAndAdults() {
		return q25iDzTotWithChildAndAdults;
	}

	public void setQ25iDzTotWithChildAndAdults(
			BigInteger q25iDzTotWithChildAndAdults) {
		this.q25iDzTotWithChildAndAdults = q25iDzTotWithChildAndAdults;
	}

	public BigInteger getQ25iDzTotWithOnlyChild() {
		return q25iDzTotWithOnlyChild;
	}

	public void setQ25iDzTotWithOnlyChild(BigInteger q25iDzTotWithOnlyChild) {
		this.q25iDzTotWithOnlyChild = q25iDzTotWithOnlyChild;
	}

	public BigInteger getQ25iDzTotUnknownHouseHold() {
		return q25iDzTotUnknownHouseHold;
	}

	public void setQ25iDzTotUnknownHouseHold(BigInteger q25iDzTotUnknownHouseHold) {
		this.q25iDzTotUnknownHouseHold = q25iDzTotUnknownHouseHold;
	}

	public BigInteger getQ25iETotTotal() {
		return q25iETotTotal;
	}

	public void setQ25iETotTotal(BigInteger q25iETotTotal) {
		this.q25iETotTotal = q25iETotTotal;
	}

	public BigInteger getQ25iETotWithoutChild() {
		return q25iETotWithoutChild;
	}

	public void setQ25iETotWithoutChild(BigInteger q25iETotWithoutChild) {
		this.q25iETotWithoutChild = q25iETotWithoutChild;
	}

	public BigInteger getQ25iETotWithChildAndAdults() {
		return q25iETotWithChildAndAdults;
	}

	public void setQ25iETotWithChildAndAdults(BigInteger q25iETotWithChildAndAdults) {
		this.q25iETotWithChildAndAdults = q25iETotWithChildAndAdults;
	}

	public BigInteger getQ25iETotWithOnlyChild() {
		return q25iETotWithOnlyChild;
	}

	public void setQ25iETotWithOnlyChild(BigInteger q25iETotWithOnlyChild) {
		this.q25iETotWithOnlyChild = q25iETotWithOnlyChild;
	}

	public BigInteger getQ25iETotUnknownHouseHold() {
		return q25iETotUnknownHouseHold;
	}

	public void setQ25iETotUnknownHouseHold(BigInteger q25iETotUnknownHouseHold) {
		this.q25iETotUnknownHouseHold = q25iETotUnknownHouseHold;
	}

	public BigInteger getQ25iTotPersonsExistTotal() {
		return q25iTotPersonsExistTotal;
	}

	public void setQ25iTotPersonsExistTotal(BigInteger q25iTotPersonsExistTotal) {
		this.q25iTotPersonsExistTotal = q25iTotPersonsExistTotal;
	}

	public BigInteger getQ25iTotPersonsExistWithoutChild() {
		return q25iTotPersonsExistWithoutChild;
	}

	public void setQ25iTotPersonsExistWithoutChild(
			BigInteger q25iTotPersonsExistWithoutChild) {
		this.q25iTotPersonsExistWithoutChild = q25iTotPersonsExistWithoutChild;
	}

	public BigInteger getQ25iTotPersonsExistWithChildAndAdults() {
		return q25iTotPersonsExistWithChildAndAdults;
	}

	public void setQ25iTotPersonsExistWithChildAndAdults(
			BigInteger q25iTotPersonsExistWithChildAndAdults) {
		this.q25iTotPersonsExistWithChildAndAdults = q25iTotPersonsExistWithChildAndAdults;
	}

	public BigInteger getQ25iTotPersonsExistWithOnlyChild() {
		return q25iTotPersonsExistWithOnlyChild;
	}

	public void setQ25iTotPersonsExistWithOnlyChild(
			BigInteger q25iTotPersonsExistWithOnlyChild) {
		this.q25iTotPersonsExistWithOnlyChild = q25iTotPersonsExistWithOnlyChild;
	}

	public BigInteger getQ25iTotPersonsExistUnknownHouseHold() {
		return q25iTotPersonsExistUnknownHouseHold;
	}

	public void setQ25iTotPersonsExistUnknownHouseHold(
			BigInteger q25iTotPersonsExistUnknownHouseHold) {
		this.q25iTotPersonsExistUnknownHouseHold = q25iTotPersonsExistUnknownHouseHold;
	}

	public BigInteger getQ25iTotPersonsDstnTotal() {
		return q25iTotPersonsDstnTotal;
	}

	public void setQ25iTotPersonsDstnTotal(BigInteger q25iTotPersonsDstnTotal) {
		this.q25iTotPersonsDstnTotal = q25iTotPersonsDstnTotal;
	}

	public BigInteger getQ25iTotPersonsDstnWithoutChild() {
		return q25iTotPersonsDstnWithoutChild;
	}

	public void setQ25iTotPersonsDstnWithoutChild(
			BigInteger q25iTotPersonsDstnWithoutChild) {
		this.q25iTotPersonsDstnWithoutChild = q25iTotPersonsDstnWithoutChild;
	}

	public BigInteger getQ25iTotPersonsDstnWithChildAndAdults() {
		return q25iTotPersonsDstnWithChildAndAdults;
	}

	public void setQ25iTotPersonsDstnWithChildAndAdults(
			BigInteger q25iTotPersonsDstnWithChildAndAdults) {
		this.q25iTotPersonsDstnWithChildAndAdults = q25iTotPersonsDstnWithChildAndAdults;
	}

	public BigInteger getQ25iTotPersonsDstnWithOnlyChild() {
		return q25iTotPersonsDstnWithOnlyChild;
	}

	public void setQ25iTotPersonsDstnWithOnlyChild(
			BigInteger q25iTotPersonsDstnWithOnlyChild) {
		this.q25iTotPersonsDstnWithOnlyChild = q25iTotPersonsDstnWithOnlyChild;
	}

	public BigInteger getQ25iTotPersonsDstnUnknownHouseHold() {
		return q25iTotPersonsDstnUnknownHouseHold;
	}

	public void setQ25iTotPersonsDstnUnknownHouseHold(
			BigInteger q25iTotPersonsDstnUnknownHouseHold) {
		this.q25iTotPersonsDstnUnknownHouseHold = q25iTotPersonsDstnUnknownHouseHold;
	}

	public BigInteger getQ25iPercentageTotal() {
		return q25iPercentageTotal;
	}

	public void setQ25iPercentageTotal(BigInteger q25iPercentageTotal) {
		this.q25iPercentageTotal = q25iPercentageTotal;
	}

	public BigInteger getQ25iPercentageWithoutChild() {
		return q25iPercentageWithoutChild;
	}

	public void setQ25iPercentageWithoutChild(BigInteger q25iPercentageWithoutChild) {
		this.q25iPercentageWithoutChild = q25iPercentageWithoutChild;
	}

	public BigInteger getQ25iPercentageWithChildAndAdults() {
		return q25iPercentageWithChildAndAdults;
	}

	public void setQ25iPercentageWithChildAndAdults(
			BigInteger q25iPercentageWithChildAndAdults) {
		this.q25iPercentageWithChildAndAdults = q25iPercentageWithChildAndAdults;
	}

	public BigInteger getQ25iPercentageWithOnlyChild() {
		return q25iPercentageWithOnlyChild;
	}

	public void setQ25iPercentageWithOnlyChild(
			BigInteger q25iPercentageWithOnlyChild) {
		this.q25iPercentageWithOnlyChild = q25iPercentageWithOnlyChild;
	}

	public BigInteger getQ25iPercentageUnknownHouseHold() {
		return q25iPercentageUnknownHouseHold;
	}

	public void setQ25iPercentageUnknownHouseHold(
			BigInteger q25iPercentageUnknownHouseHold) {
		this.q25iPercentageUnknownHouseHold = q25iPercentageUnknownHouseHold;
	}

	public BigInteger getQ25hSupplementalNutritionalAssistanceAtEntry() {
		return q25hSupplementalNutritionalAssistanceAtEntry;
	}

	public void setQ25hSupplementalNutritionalAssistanceAtEntry(
			BigInteger q25hSupplementalNutritionalAssistanceAtEntry) {
		this.q25hSupplementalNutritionalAssistanceAtEntry = q25hSupplementalNutritionalAssistanceAtEntry;
	}

	public BigInteger getQ25hSupplementalNutritionalAssistanceStayers() {
		return q25hSupplementalNutritionalAssistanceStayers;
	}

	public void setQ25hSupplementalNutritionalAssistanceStayers(
			BigInteger q25hSupplementalNutritionalAssistanceStayers) {
		this.q25hSupplementalNutritionalAssistanceStayers = q25hSupplementalNutritionalAssistanceStayers;
	}

	public BigInteger getQ25hSupplementalNutritionalAssistanceLeavers() {
		return q25hSupplementalNutritionalAssistanceLeavers;
	}

	public void setQ25hSupplementalNutritionalAssistanceLeavers(
			BigInteger q25hSupplementalNutritionalAssistanceLeavers) {
		this.q25hSupplementalNutritionalAssistanceLeavers = q25hSupplementalNutritionalAssistanceLeavers;
	}

	public BigInteger getQ25hWICAtEntry() {
		return q25hWICAtEntry;
	}

	public void setQ25hWICAtEntry(BigInteger q25hWICAtEntry) {
		this.q25hWICAtEntry = q25hWICAtEntry;
	}

	public BigInteger getQ25hWICStayers() {
		return q25hWICStayers;
	}

	public void setQ25hWICStayers(BigInteger q25hWICStayers) {
		this.q25hWICStayers = q25hWICStayers;
	}

	public BigInteger getQ25hWICLeavers() {
		return q25hWICLeavers;
	}

	public void setQ25hWICLeavers(BigInteger q25hWICLeavers) {
		this.q25hWICLeavers = q25hWICLeavers;
	}

	public BigInteger getQ25hTANFChildCareServicesAtEntry() {
		return q25hTANFChildCareServicesAtEntry;
	}

	public void setQ25hTANFChildCareServicesAtEntry(
			BigInteger q25hTANFChildCareServicesAtEntry) {
		this.q25hTANFChildCareServicesAtEntry = q25hTANFChildCareServicesAtEntry;
	}

	public BigInteger getQ25hTANFChildCareServicesStayers() {
		return q25hTANFChildCareServicesStayers;
	}

	public void setQ25hTANFChildCareServicesStayers(
			BigInteger q25hTANFChildCareServicesStayers) {
		this.q25hTANFChildCareServicesStayers = q25hTANFChildCareServicesStayers;
	}

	public BigInteger getQ25hTANFChildCareServicesLeavers() {
		return q25hTANFChildCareServicesLeavers;
	}

	public void setQ25hTANFChildCareServicesLeavers(
			BigInteger q25hTANFChildCareServicesLeavers) {
		this.q25hTANFChildCareServicesLeavers = q25hTANFChildCareServicesLeavers;
	}

	public BigInteger getQ25hTANFTransportationServicesAtEntry() {
		return q25hTANFTransportationServicesAtEntry;
	}

	public void setQ25hTANFTransportationServicesAtEntry(
			BigInteger q25hTANFTransportationServicesAtEntry) {
		this.q25hTANFTransportationServicesAtEntry = q25hTANFTransportationServicesAtEntry;
	}

	public BigInteger getQ25hTANFTransportationServicesStayers() {
		return q25hTANFTransportationServicesStayers;
	}

	public void setQ25hTANFTransportationServicesStayers(
			BigInteger q25hTANFTransportationServicesStayers) {
		this.q25hTANFTransportationServicesStayers = q25hTANFTransportationServicesStayers;
	}

	public BigInteger getQ25hTANFTransportationServicesLeavers() {
		return q25hTANFTransportationServicesLeavers;
	}

	public void setQ25hTANFTransportationServicesLeavers(
			BigInteger q25hTANFTransportationServicesLeavers) {
		this.q25hTANFTransportationServicesLeavers = q25hTANFTransportationServicesLeavers;
	}

	public BigInteger getQ25hOtherTANFFundedServicesAtEntry() {
		return q25hOtherTANFFundedServicesAtEntry;
	}

	public void setQ25hOtherTANFFundedServicesAtEntry(
			BigInteger q25hOtherTANFFundedServicesAtEntry) {
		this.q25hOtherTANFFundedServicesAtEntry = q25hOtherTANFFundedServicesAtEntry;
	}

	public BigInteger getQ25hOtherTANFFundedServicesStayers() {
		return q25hOtherTANFFundedServicesStayers;
	}

	public void setQ25hOtherTANFFundedServicesStayers(
			BigInteger q25hOtherTANFFundedServicesStayers) {
		this.q25hOtherTANFFundedServicesStayers = q25hOtherTANFFundedServicesStayers;
	}

	public BigInteger getQ25hOtherTANFFundedServicesLeavers() {
		return q25hOtherTANFFundedServicesLeavers;
	}

	public void setQ25hOtherTANFFundedServicesLeavers(
			BigInteger q25hOtherTANFFundedServicesLeavers) {
		this.q25hOtherTANFFundedServicesLeavers = q25hOtherTANFFundedServicesLeavers;
	}

	public BigInteger getQ25hOtherSourceAtEntry() {
		return q25hOtherSourceAtEntry;
	}

	public void setQ25hOtherSourceAtEntry(BigInteger q25hOtherSourceAtEntry) {
		this.q25hOtherSourceAtEntry = q25hOtherSourceAtEntry;
	}

	public BigInteger getQ25hOtherSourceStayers() {
		return q25hOtherSourceStayers;
	}

	public void setQ25hOtherSourceStayers(BigInteger q25hOtherSourceStayers) {
		this.q25hOtherSourceStayers = q25hOtherSourceStayers;
	}

	public BigInteger getQ25hOtherSourceLeavers() {
		return q25hOtherSourceLeavers;
	}

	public void setQ25hOtherSourceLeavers(BigInteger q25hOtherSourceLeavers) {
		this.q25hOtherSourceLeavers = q25hOtherSourceLeavers;
	}

	public BigInteger getQ25gEarnedIncomeAtEntry() {
		return q25gEarnedIncomeAtEntry;
	}

	public void setQ25gEarnedIncomeAtEntry(BigInteger q25gEarnedIncomeAtEntry) {
		this.q25gEarnedIncomeAtEntry = q25gEarnedIncomeAtEntry;
	}

	public BigInteger getQ25gEarnedIncomeStayers() {
		return q25gEarnedIncomeStayers;
	}

	public void setQ25gEarnedIncomeStayers(BigInteger q25gEarnedIncomeStayers) {
		this.q25gEarnedIncomeStayers = q25gEarnedIncomeStayers;
	}

	public BigInteger getQ25gEarnedIncomeLeavers() {
		return q25gEarnedIncomeLeavers;
	}

	public void setQ25gEarnedIncomeLeavers(BigInteger q25gEarnedIncomeLeavers) {
		this.q25gEarnedIncomeLeavers = q25gEarnedIncomeLeavers;
	}

	public BigInteger getQ25gUnemploymentInsuranceAtEntry() {
		return q25gUnemploymentInsuranceAtEntry;
	}

	public void setQ25gUnemploymentInsuranceAtEntry(
			BigInteger q25gUnemploymentInsuranceAtEntry) {
		this.q25gUnemploymentInsuranceAtEntry = q25gUnemploymentInsuranceAtEntry;
	}

	public BigInteger getQ25gUnemploymentInsuranceStayers() {
		return q25gUnemploymentInsuranceStayers;
	}

	public void setQ25gUnemploymentInsuranceStayers(
			BigInteger q25gUnemploymentInsuranceStayers) {
		this.q25gUnemploymentInsuranceStayers = q25gUnemploymentInsuranceStayers;
	}

	public BigInteger getQ25gUnemploymentInsuranceLeavers() {
		return q25gUnemploymentInsuranceLeavers;
	}

	public void setQ25gUnemploymentInsuranceLeavers(
			BigInteger q25gUnemploymentInsuranceLeavers) {
		this.q25gUnemploymentInsuranceLeavers = q25gUnemploymentInsuranceLeavers;
	}

	public BigInteger getQ25gSSIAtEntry() {
		return q25gSSIAtEntry;
	}

	public void setQ25gSSIAtEntry(BigInteger q25gSSIAtEntry) {
		this.q25gSSIAtEntry = q25gSSIAtEntry;
	}

	public BigInteger getQ25gSSIStayers() {
		return q25gSSIStayers;
	}

	public void setQ25gSSIStayers(BigInteger q25gSSIStayers) {
		this.q25gSSIStayers = q25gSSIStayers;
	}

	public BigInteger getQ25gSSILeavers() {
		return q25gSSILeavers;
	}

	public void setQ25gSSILeavers(BigInteger q25gSSILeavers) {
		this.q25gSSILeavers = q25gSSILeavers;
	}

	public BigInteger getQ25gSSDIAtEntry() {
		return q25gSSDIAtEntry;
	}

	public void setQ25gSSDIAtEntry(BigInteger q25gSSDIAtEntry) {
		this.q25gSSDIAtEntry = q25gSSDIAtEntry;
	}

	public BigInteger getQ25gSSDIStayers() {
		return q25gSSDIStayers;
	}

	public void setQ25gSSDIStayers(BigInteger q25gSSDIStayers) {
		this.q25gSSDIStayers = q25gSSDIStayers;
	}

	public BigInteger getQ25gSSDILeavers() {
		return q25gSSDILeavers;
	}

	public void setQ25gSSDILeavers(BigInteger q25gSSDILeavers) {
		this.q25gSSDILeavers = q25gSSDILeavers;
	}

	public BigInteger getQ25gVAServiceConnectedDisabilityAtEntry() {
		return q25gVAServiceConnectedDisabilityAtEntry;
	}

	public void setQ25gVAServiceConnectedDisabilityAtEntry(
			BigInteger q25gVAServiceConnectedDisabilityAtEntry) {
		this.q25gVAServiceConnectedDisabilityAtEntry = q25gVAServiceConnectedDisabilityAtEntry;
	}

	public BigInteger getQ25gVAServiceConnectedDisabilityStayers() {
		return q25gVAServiceConnectedDisabilityStayers;
	}

	public void setQ25gVAServiceConnectedDisabilityStayers(
			BigInteger q25gVAServiceConnectedDisabilityStayers) {
		this.q25gVAServiceConnectedDisabilityStayers = q25gVAServiceConnectedDisabilityStayers;
	}

	public BigInteger getQ25gVAServiceConnectedDisabilityLeavers() {
		return q25gVAServiceConnectedDisabilityLeavers;
	}

	public void setQ25gVAServiceConnectedDisabilityLeavers(
			BigInteger q25gVAServiceConnectedDisabilityLeavers) {
		this.q25gVAServiceConnectedDisabilityLeavers = q25gVAServiceConnectedDisabilityLeavers;
	}

	public BigInteger getQ25gVANonServiceConnectedDisabilityAtEntry() {
		return q25gVANonServiceConnectedDisabilityAtEntry;
	}

	public void setQ25gVANonServiceConnectedDisabilityAtEntry(
			BigInteger q25gVANonServiceConnectedDisabilityAtEntry) {
		this.q25gVANonServiceConnectedDisabilityAtEntry = q25gVANonServiceConnectedDisabilityAtEntry;
	}

	public BigInteger getQ25gVANonServiceConnectedDisabilityStayers() {
		return q25gVANonServiceConnectedDisabilityStayers;
	}

	public void setQ25gVANonServiceConnectedDisabilityStayers(
			BigInteger q25gVANonServiceConnectedDisabilityStayers) {
		this.q25gVANonServiceConnectedDisabilityStayers = q25gVANonServiceConnectedDisabilityStayers;
	}

	public BigInteger getQ25gVANonServiceConnectedDisabilityLeavers() {
		return q25gVANonServiceConnectedDisabilityLeavers;
	}

	public void setQ25gVANonServiceConnectedDisabilityLeavers(
			BigInteger q25gVANonServiceConnectedDisabilityLeavers) {
		this.q25gVANonServiceConnectedDisabilityLeavers = q25gVANonServiceConnectedDisabilityLeavers;
	}

	public BigInteger getQ25gPrivateDisabilityInsuranceAtEntry() {
		return q25gPrivateDisabilityInsuranceAtEntry;
	}

	public void setQ25gPrivateDisabilityInsuranceAtEntry(
			BigInteger q25gPrivateDisabilityInsuranceAtEntry) {
		this.q25gPrivateDisabilityInsuranceAtEntry = q25gPrivateDisabilityInsuranceAtEntry;
	}

	public BigInteger getQ25gPrivateDisabilityInsuranceStayers() {
		return q25gPrivateDisabilityInsuranceStayers;
	}

	public void setQ25gPrivateDisabilityInsuranceStayers(
			BigInteger q25gPrivateDisabilityInsuranceStayers) {
		this.q25gPrivateDisabilityInsuranceStayers = q25gPrivateDisabilityInsuranceStayers;
	}

	public BigInteger getQ25gPrivateDisabilityInsuranceLeavers() {
		return q25gPrivateDisabilityInsuranceLeavers;
	}

	public void setQ25gPrivateDisabilityInsuranceLeavers(
			BigInteger q25gPrivateDisabilityInsuranceLeavers) {
		this.q25gPrivateDisabilityInsuranceLeavers = q25gPrivateDisabilityInsuranceLeavers;
	}

	public BigInteger getQ25gWorkersCompensationAtEntry() {
		return q25gWorkersCompensationAtEntry;
	}

	public void setQ25gWorkersCompensationAtEntry(
			BigInteger q25gWorkersCompensationAtEntry) {
		this.q25gWorkersCompensationAtEntry = q25gWorkersCompensationAtEntry;
	}

	public BigInteger getQ25gWorkersCompensationStayers() {
		return q25gWorkersCompensationStayers;
	}

	public void setQ25gWorkersCompensationStayers(
			BigInteger q25gWorkersCompensationStayers) {
		this.q25gWorkersCompensationStayers = q25gWorkersCompensationStayers;
	}

	public BigInteger getQ25gWorkersCompensationLeavers() {
		return q25gWorkersCompensationLeavers;
	}

	public void setQ25gWorkersCompensationLeavers(
			BigInteger q25gWorkersCompensationLeavers) {
		this.q25gWorkersCompensationLeavers = q25gWorkersCompensationLeavers;
	}

	public BigInteger getQ25gTANFAtEntry() {
		return q25gTANFAtEntry;
	}

	public void setQ25gTANFAtEntry(BigInteger q25gTANFAtEntry) {
		this.q25gTANFAtEntry = q25gTANFAtEntry;
	}

	public BigInteger getQ25gTANFStayers() {
		return q25gTANFStayers;
	}

	public void setQ25gTANFStayers(BigInteger q25gTANFStayers) {
		this.q25gTANFStayers = q25gTANFStayers;
	}

	public BigInteger getQ25gTANFLeavers() {
		return q25gTANFLeavers;
	}

	public void setQ25gTANFLeavers(BigInteger q25gTANFLeavers) {
		this.q25gTANFLeavers = q25gTANFLeavers;
	}

	public BigInteger getQ25gGeneralAssistanceAtEntry() {
		return q25gGeneralAssistanceAtEntry;
	}

	public void setQ25gGeneralAssistanceAtEntry(
			BigInteger q25gGeneralAssistanceAtEntry) {
		this.q25gGeneralAssistanceAtEntry = q25gGeneralAssistanceAtEntry;
	}

	public BigInteger getQ25gGeneralAssistanceStayers() {
		return q25gGeneralAssistanceStayers;
	}

	public void setQ25gGeneralAssistanceStayers(
			BigInteger q25gGeneralAssistanceStayers) {
		this.q25gGeneralAssistanceStayers = q25gGeneralAssistanceStayers;
	}

	public BigInteger getQ25gGeneralAssistanceLeavers() {
		return q25gGeneralAssistanceLeavers;
	}

	public void setQ25gGeneralAssistanceLeavers(
			BigInteger q25gGeneralAssistanceLeavers) {
		this.q25gGeneralAssistanceLeavers = q25gGeneralAssistanceLeavers;
	}

	public BigInteger getQ25gRetirementAtEntry() {
		return q25gRetirementAtEntry;
	}

	public void setQ25gRetirementAtEntry(BigInteger q25gRetirementAtEntry) {
		this.q25gRetirementAtEntry = q25gRetirementAtEntry;
	}

	public BigInteger getQ25gRetirementStayers() {
		return q25gRetirementStayers;
	}

	public void setQ25gRetirementStayers(BigInteger q25gRetirementStayers) {
		this.q25gRetirementStayers = q25gRetirementStayers;
	}

	public BigInteger getQ25gRetirementLeavers() {
		return q25gRetirementLeavers;
	}

	public void setQ25gRetirementLeavers(BigInteger q25gRetirementLeavers) {
		this.q25gRetirementLeavers = q25gRetirementLeavers;
	}

	public BigInteger getQ25gPensionFromFormerJobAtEntry() {
		return q25gPensionFromFormerJobAtEntry;
	}

	public void setQ25gPensionFromFormerJobAtEntry(
			BigInteger q25gPensionFromFormerJobAtEntry) {
		this.q25gPensionFromFormerJobAtEntry = q25gPensionFromFormerJobAtEntry;
	}

	public BigInteger getQ25gPensionFromFormerJobStayers() {
		return q25gPensionFromFormerJobStayers;
	}

	public void setQ25gPensionFromFormerJobStayers(
			BigInteger q25gPensionFromFormerJobStayers) {
		this.q25gPensionFromFormerJobStayers = q25gPensionFromFormerJobStayers;
	}

	public BigInteger getQ25gPensionFromFormerJobLeavers() {
		return q25gPensionFromFormerJobLeavers;
	}

	public void setQ25gPensionFromFormerJobLeavers(
			BigInteger q25gPensionFromFormerJobLeavers) {
		this.q25gPensionFromFormerJobLeavers = q25gPensionFromFormerJobLeavers;
	}

	public BigInteger getQ25gChildSupportAtEntry() {
		return q25gChildSupportAtEntry;
	}

	public void setQ25gChildSupportAtEntry(BigInteger q25gChildSupportAtEntry) {
		this.q25gChildSupportAtEntry = q25gChildSupportAtEntry;
	}

	public BigInteger getQ25gChildSupportStayers() {
		return q25gChildSupportStayers;
	}

	public void setQ25gChildSupportStayers(BigInteger q25gChildSupportStayers) {
		this.q25gChildSupportStayers = q25gChildSupportStayers;
	}

	public BigInteger getQ25gChildSupportLeavers() {
		return q25gChildSupportLeavers;
	}

	public void setQ25gChildSupportLeavers(BigInteger q25gChildSupportLeavers) {
		this.q25gChildSupportLeavers = q25gChildSupportLeavers;
	}

	public BigInteger getQ25gAlimonyAtEntry() {
		return q25gAlimonyAtEntry;
	}

	public void setQ25gAlimonyAtEntry(BigInteger q25gAlimonyAtEntry) {
		this.q25gAlimonyAtEntry = q25gAlimonyAtEntry;
	}

	public BigInteger getQ25gAlimonyStayers() {
		return q25gAlimonyStayers;
	}

	public void setQ25gAlimonyStayers(BigInteger q25gAlimonyStayers) {
		this.q25gAlimonyStayers = q25gAlimonyStayers;
	}

	public BigInteger getQ25gAlimonyLeavers() {
		return q25gAlimonyLeavers;
	}

	public void setQ25gAlimonyLeavers(BigInteger q25gAlimonyLeavers) {
		this.q25gAlimonyLeavers = q25gAlimonyLeavers;
	}

	public BigInteger getQ25gOtherSourceAtEntry() {
		return q25gOtherSourceAtEntry;
	}

	public void setQ25gOtherSourceAtEntry(BigInteger q25gOtherSourceAtEntry) {
		this.q25gOtherSourceAtEntry = q25gOtherSourceAtEntry;
	}

	public BigInteger getQ25gOtherSourceStayers() {
		return q25gOtherSourceStayers;
	}

	public void setQ25gOtherSourceStayers(BigInteger q25gOtherSourceStayers) {
		this.q25gOtherSourceStayers = q25gOtherSourceStayers;
	}

	public BigInteger getQ25gOtherSourceLeavers() {
		return q25gOtherSourceLeavers;
	}

	public void setQ25gOtherSourceLeavers(BigInteger q25gOtherSourceLeavers) {
		this.q25gOtherSourceLeavers = q25gOtherSourceLeavers;
	}

	public BigInteger getQ25gAdultsWithIncomeInfoAtEntryAtEntry() {
		return q25gAdultsWithIncomeInfoAtEntryAtEntry;
	}

	public void setQ25gAdultsWithIncomeInfoAtEntryAtEntry(
			BigInteger q25gAdultsWithIncomeInfoAtEntryAtEntry) {
		this.q25gAdultsWithIncomeInfoAtEntryAtEntry = q25gAdultsWithIncomeInfoAtEntryAtEntry;
	}

	public BigInteger getQ25gAdultsWithIncomeInfoAtEntryStayers() {
		return q25gAdultsWithIncomeInfoAtEntryStayers;
	}

	public void setQ25gAdultsWithIncomeInfoAtEntryStayers(
			BigInteger q25gAdultsWithIncomeInfoAtEntryStayers) {
		this.q25gAdultsWithIncomeInfoAtEntryStayers = q25gAdultsWithIncomeInfoAtEntryStayers;
	}

	public BigInteger getQ25gAdultsWithIncomeInfoAtEntryLeavers() {
		return q25gAdultsWithIncomeInfoAtEntryLeavers;
	}

	public void setQ25gAdultsWithIncomeInfoAtEntryLeavers(
			BigInteger q25gAdultsWithIncomeInfoAtEntryLeavers) {
		this.q25gAdultsWithIncomeInfoAtEntryLeavers = q25gAdultsWithIncomeInfoAtEntryLeavers;
	}

	public BigInteger getQ25fAdultsWithOnlyEarnedIncomeAtEntry() {
		return q25fAdultsWithOnlyEarnedIncomeAtEntry;
	}

	public void setQ25fAdultsWithOnlyEarnedIncomeAtEntry(
			BigInteger q25fAdultsWithOnlyEarnedIncomeAtEntry) {
		this.q25fAdultsWithOnlyEarnedIncomeAtEntry = q25fAdultsWithOnlyEarnedIncomeAtEntry;
	}

	public BigInteger getQ25fAdultsWithOnlyEarnedIncomeStayers() {
		return q25fAdultsWithOnlyEarnedIncomeStayers;
	}

	public void setQ25fAdultsWithOnlyEarnedIncomeStayers(
			BigInteger q25fAdultsWithOnlyEarnedIncomeStayers) {
		this.q25fAdultsWithOnlyEarnedIncomeStayers = q25fAdultsWithOnlyEarnedIncomeStayers;
	}

	public BigInteger getQ25fAdultsWithOnlyEarnedIncomeLeavers() {
		return q25fAdultsWithOnlyEarnedIncomeLeavers;
	}

	public void setQ25fAdultsWithOnlyEarnedIncomeLeavers(
			BigInteger q25fAdultsWithOnlyEarnedIncomeLeavers) {
		this.q25fAdultsWithOnlyEarnedIncomeLeavers = q25fAdultsWithOnlyEarnedIncomeLeavers;
	}

	public BigInteger getQ25fAdultsWithOnlyOtherIncomeAtEntry() {
		return q25fAdultsWithOnlyOtherIncomeAtEntry;
	}

	public void setQ25fAdultsWithOnlyOtherIncomeAtEntry(
			BigInteger q25fAdultsWithOnlyOtherIncomeAtEntry) {
		this.q25fAdultsWithOnlyOtherIncomeAtEntry = q25fAdultsWithOnlyOtherIncomeAtEntry;
	}

	public BigInteger getQ25fAdultsWithOnlyOtherIncomeStayers() {
		return q25fAdultsWithOnlyOtherIncomeStayers;
	}

	public void setQ25fAdultsWithOnlyOtherIncomeStayers(
			BigInteger q25fAdultsWithOnlyOtherIncomeStayers) {
		this.q25fAdultsWithOnlyOtherIncomeStayers = q25fAdultsWithOnlyOtherIncomeStayers;
	}

	public BigInteger getQ25fAdultsWithOnlyOtherIncomeLeavers() {
		return q25fAdultsWithOnlyOtherIncomeLeavers;
	}

	public void setQ25fAdultsWithOnlyOtherIncomeLeavers(
			BigInteger q25fAdultsWithOnlyOtherIncomeLeavers) {
		this.q25fAdultsWithOnlyOtherIncomeLeavers = q25fAdultsWithOnlyOtherIncomeLeavers;
	}

	public BigInteger getQ25fAdultsWithBothEarnedAndOtherAtEntry() {
		return q25fAdultsWithBothEarnedAndOtherAtEntry;
	}

	public void setQ25fAdultsWithBothEarnedAndOtherAtEntry(
			BigInteger q25fAdultsWithBothEarnedAndOtherAtEntry) {
		this.q25fAdultsWithBothEarnedAndOtherAtEntry = q25fAdultsWithBothEarnedAndOtherAtEntry;
	}

	public BigInteger getQ25fAdultsWithBothEarnedAndOtherStayers() {
		return q25fAdultsWithBothEarnedAndOtherStayers;
	}

	public void setQ25fAdultsWithBothEarnedAndOtherStayers(
			BigInteger q25fAdultsWithBothEarnedAndOtherStayers) {
		this.q25fAdultsWithBothEarnedAndOtherStayers = q25fAdultsWithBothEarnedAndOtherStayers;
	}

	public BigInteger getQ25fAdultsWithBothEarnedAndOtherLeavers() {
		return q25fAdultsWithBothEarnedAndOtherLeavers;
	}

	public void setQ25fAdultsWithBothEarnedAndOtherLeavers(
			BigInteger q25fAdultsWithBothEarnedAndOtherLeavers) {
		this.q25fAdultsWithBothEarnedAndOtherLeavers = q25fAdultsWithBothEarnedAndOtherLeavers;
	}

	public BigInteger getQ25fAdultsWithNoIncomeAtEntry() {
		return q25fAdultsWithNoIncomeAtEntry;
	}

	public void setQ25fAdultsWithNoIncomeAtEntry(
			BigInteger q25fAdultsWithNoIncomeAtEntry) {
		this.q25fAdultsWithNoIncomeAtEntry = q25fAdultsWithNoIncomeAtEntry;
	}

	public BigInteger getQ25fAdultsWithNoIncomeStayers() {
		return q25fAdultsWithNoIncomeStayers;
	}

	public void setQ25fAdultsWithNoIncomeStayers(
			BigInteger q25fAdultsWithNoIncomeStayers) {
		this.q25fAdultsWithNoIncomeStayers = q25fAdultsWithNoIncomeStayers;
	}

	public BigInteger getQ25fAdultsWithNoIncomeLeavers() {
		return q25fAdultsWithNoIncomeLeavers;
	}

	public void setQ25fAdultsWithNoIncomeLeavers(
			BigInteger q25fAdultsWithNoIncomeLeavers) {
		this.q25fAdultsWithNoIncomeLeavers = q25fAdultsWithNoIncomeLeavers;
	}

	public BigInteger getQ25fAdultsWithDontRefusedIncomeAtEntry() {
		return q25fAdultsWithDontRefusedIncomeAtEntry;
	}

	public void setQ25fAdultsWithDontRefusedIncomeAtEntry(
			BigInteger q25fAdultsWithDontRefusedIncomeAtEntry) {
		this.q25fAdultsWithDontRefusedIncomeAtEntry = q25fAdultsWithDontRefusedIncomeAtEntry;
	}

	public BigInteger getQ25fAdultsWithDontRefusedIncomeStayers() {
		return q25fAdultsWithDontRefusedIncomeStayers;
	}

	public void setQ25fAdultsWithDontRefusedIncomeStayers(
			BigInteger q25fAdultsWithDontRefusedIncomeStayers) {
		this.q25fAdultsWithDontRefusedIncomeStayers = q25fAdultsWithDontRefusedIncomeStayers;
	}

	public BigInteger getQ25fAdultsWithDontRefusedIncomeLeavers() {
		return q25fAdultsWithDontRefusedIncomeLeavers;
	}

	public void setQ25fAdultsWithDontRefusedIncomeLeavers(
			BigInteger q25fAdultsWithDontRefusedIncomeLeavers) {
		this.q25fAdultsWithDontRefusedIncomeLeavers = q25fAdultsWithDontRefusedIncomeLeavers;
	}

	public BigInteger getQ25fAdultsWithMissingInomeInfoAtEntry() {
		return q25fAdultsWithMissingInomeInfoAtEntry;
	}

	public void setQ25fAdultsWithMissingInomeInfoAtEntry(
			BigInteger q25fAdultsWithMissingInomeInfoAtEntry) {
		this.q25fAdultsWithMissingInomeInfoAtEntry = q25fAdultsWithMissingInomeInfoAtEntry;
	}

	public BigInteger getQ25fAdultsWithMissingInomeInfoStayers() {
		return q25fAdultsWithMissingInomeInfoStayers;
	}

	public void setQ25fAdultsWithMissingInomeInfoStayers(
			BigInteger q25fAdultsWithMissingInomeInfoStayers) {
		this.q25fAdultsWithMissingInomeInfoStayers = q25fAdultsWithMissingInomeInfoStayers;
	}

	public BigInteger getQ25fAdultsWithMissingInomeInfoLeavers() {
		return q25fAdultsWithMissingInomeInfoLeavers;
	}

	public void setQ25fAdultsWithMissingInomeInfoLeavers(
			BigInteger q25fAdultsWithMissingInomeInfoLeavers) {
		this.q25fAdultsWithMissingInomeInfoLeavers = q25fAdultsWithMissingInomeInfoLeavers;
	}

	public BigInteger getQ25fNumberOfAdultStayersNotYetRequiredAtEntry() {
		return q25fNumberOfAdultStayersNotYetRequiredAtEntry;
	}

	public void setQ25fNumberOfAdultStayersNotYetRequiredAtEntry(
			BigInteger q25fNumberOfAdultStayersNotYetRequiredAtEntry) {
		this.q25fNumberOfAdultStayersNotYetRequiredAtEntry = q25fNumberOfAdultStayersNotYetRequiredAtEntry;
	}

	public BigInteger getQ25fNumberOfAdultStayersNotYetRequiredStayers() {
		return q25fNumberOfAdultStayersNotYetRequiredStayers;
	}

	public void setQ25fNumberOfAdultStayersNotYetRequiredStayers(
			BigInteger q25fNumberOfAdultStayersNotYetRequiredStayers) {
		this.q25fNumberOfAdultStayersNotYetRequiredStayers = q25fNumberOfAdultStayersNotYetRequiredStayers;
	}

	public BigInteger getQ25fNumberOfAdultStayersNotYetRequiredLeavers() {
		return q25fNumberOfAdultStayersNotYetRequiredLeavers;
	}

	public void setQ25fNumberOfAdultStayersNotYetRequiredLeavers(
			BigInteger q25fNumberOfAdultStayersNotYetRequiredLeavers) {
		this.q25fNumberOfAdultStayersNotYetRequiredLeavers = q25fNumberOfAdultStayersNotYetRequiredLeavers;
	}

	public BigInteger getQ25fNumberOfAdultStayersWithoutRequiredAtEntry() {
		return q25fNumberOfAdultStayersWithoutRequiredAtEntry;
	}

	public void setQ25fNumberOfAdultStayersWithoutRequiredAtEntry(
			BigInteger q25fNumberOfAdultStayersWithoutRequiredAtEntry) {
		this.q25fNumberOfAdultStayersWithoutRequiredAtEntry = q25fNumberOfAdultStayersWithoutRequiredAtEntry;
	}

	public BigInteger getQ25fNumberOfAdultStayersWithoutRequiredStayers() {
		return q25fNumberOfAdultStayersWithoutRequiredStayers;
	}

	public void setQ25fNumberOfAdultStayersWithoutRequiredStayers(
			BigInteger q25fNumberOfAdultStayersWithoutRequiredStayers) {
		this.q25fNumberOfAdultStayersWithoutRequiredStayers = q25fNumberOfAdultStayersWithoutRequiredStayers;
	}

	public BigInteger getQ25fNumberOfAdultStayersWithoutRequiredLeavers() {
		return q25fNumberOfAdultStayersWithoutRequiredLeavers;
	}

	public void setQ25fNumberOfAdultStayersWithoutRequiredLeavers(
			BigInteger q25fNumberOfAdultStayersWithoutRequiredLeavers) {
		this.q25fNumberOfAdultStayersWithoutRequiredLeavers = q25fNumberOfAdultStayersWithoutRequiredLeavers;
	}

	public BigInteger getQ25fTotalAdultsAtEntry() {
		return q25fTotalAdultsAtEntry;
	}

	public void setQ25fTotalAdultsAtEntry(BigInteger q25fTotalAdultsAtEntry) {
		this.q25fTotalAdultsAtEntry = q25fTotalAdultsAtEntry;
	}

	public BigInteger getQ25fTotalAdultsStayers() {
		return q25fTotalAdultsStayers;
	}

	public void setQ25fTotalAdultsStayers(BigInteger q25fTotalAdultsStayers) {
		this.q25fTotalAdultsStayers = q25fTotalAdultsStayers;
	}

	public BigInteger getQ25fTotalAdultsLeavers() {
		return q25fTotalAdultsLeavers;
	}

	public void setQ25fTotalAdultsLeavers(BigInteger q25fTotalAdultsLeavers) {
		this.q25fTotalAdultsLeavers = q25fTotalAdultsLeavers;
	}

	public BigInteger getQ25eMentalIllnessAtEntry() {
		return q25eMentalIllnessAtEntry;
	}

	public void setQ25eMentalIllnessAtEntry(BigInteger q25eMentalIllnessAtEntry) {
		this.q25eMentalIllnessAtEntry = q25eMentalIllnessAtEntry;
	}

	public BigInteger getQ25eMentalIllnessStayers() {
		return q25eMentalIllnessStayers;
	}

	public void setQ25eMentalIllnessStayers(BigInteger q25eMentalIllnessStayers) {
		this.q25eMentalIllnessStayers = q25eMentalIllnessStayers;
	}

	public BigInteger getQ25eMentalIllnessLeavers() {
		return q25eMentalIllnessLeavers;
	}

	public void setQ25eMentalIllnessLeavers(BigInteger q25eMentalIllnessLeavers) {
		this.q25eMentalIllnessLeavers = q25eMentalIllnessLeavers;
	}

	public BigInteger getQ25eAlcoholAbuseAtEntry() {
		return q25eAlcoholAbuseAtEntry;
	}

	public void setQ25eAlcoholAbuseAtEntry(BigInteger q25eAlcoholAbuseAtEntry) {
		this.q25eAlcoholAbuseAtEntry = q25eAlcoholAbuseAtEntry;
	}

	public BigInteger getQ25eAlcoholAbuseStayers() {
		return q25eAlcoholAbuseStayers;
	}

	public void setQ25eAlcoholAbuseStayers(BigInteger q25eAlcoholAbuseStayers) {
		this.q25eAlcoholAbuseStayers = q25eAlcoholAbuseStayers;
	}

	public BigInteger getQ25eAlcoholAbuseLeavers() {
		return q25eAlcoholAbuseLeavers;
	}

	public void setQ25eAlcoholAbuseLeavers(BigInteger q25eAlcoholAbuseLeavers) {
		this.q25eAlcoholAbuseLeavers = q25eAlcoholAbuseLeavers;
	}

	public BigInteger getQ25eDrugAbuseAtEntry() {
		return q25eDrugAbuseAtEntry;
	}

	public void setQ25eDrugAbuseAtEntry(BigInteger q25eDrugAbuseAtEntry) {
		this.q25eDrugAbuseAtEntry = q25eDrugAbuseAtEntry;
	}

	public BigInteger getQ25eDrugAbuseStayers() {
		return q25eDrugAbuseStayers;
	}

	public void setQ25eDrugAbuseStayers(BigInteger q25eDrugAbuseStayers) {
		this.q25eDrugAbuseStayers = q25eDrugAbuseStayers;
	}

	public BigInteger getQ25eDrugAbuseLeavers() {
		return q25eDrugAbuseLeavers;
	}

	public void setQ25eDrugAbuseLeavers(BigInteger q25eDrugAbuseLeavers) {
		this.q25eDrugAbuseLeavers = q25eDrugAbuseLeavers;
	}

	public BigInteger getQ25eBothAlcoholAndDrugAbuseAtEntry() {
		return q25eBothAlcoholAndDrugAbuseAtEntry;
	}

	public void setQ25eBothAlcoholAndDrugAbuseAtEntry(
			BigInteger q25eBothAlcoholAndDrugAbuseAtEntry) {
		this.q25eBothAlcoholAndDrugAbuseAtEntry = q25eBothAlcoholAndDrugAbuseAtEntry;
	}

	public BigInteger getQ25eBothAlcoholAndDrugAbuseStayers() {
		return q25eBothAlcoholAndDrugAbuseStayers;
	}

	public void setQ25eBothAlcoholAndDrugAbuseStayers(
			BigInteger q25eBothAlcoholAndDrugAbuseStayers) {
		this.q25eBothAlcoholAndDrugAbuseStayers = q25eBothAlcoholAndDrugAbuseStayers;
	}

	public BigInteger getQ25eBothAlcoholAndDrugAbuseLeavers() {
		return q25eBothAlcoholAndDrugAbuseLeavers;
	}

	public void setQ25eBothAlcoholAndDrugAbuseLeavers(
			BigInteger q25eBothAlcoholAndDrugAbuseLeavers) {
		this.q25eBothAlcoholAndDrugAbuseLeavers = q25eBothAlcoholAndDrugAbuseLeavers;
	}

	public BigInteger getQ25eChronicHealthConditionAtEntry() {
		return q25eChronicHealthConditionAtEntry;
	}

	public void setQ25eChronicHealthConditionAtEntry(
			BigInteger q25eChronicHealthConditionAtEntry) {
		this.q25eChronicHealthConditionAtEntry = q25eChronicHealthConditionAtEntry;
	}

	public BigInteger getQ25eChronicHealthConditionStayers() {
		return q25eChronicHealthConditionStayers;
	}

	public void setQ25eChronicHealthConditionStayers(
			BigInteger q25eChronicHealthConditionStayers) {
		this.q25eChronicHealthConditionStayers = q25eChronicHealthConditionStayers;
	}

	public BigInteger getQ25eChronicHealthConditionLeavers() {
		return q25eChronicHealthConditionLeavers;
	}

	public void setQ25eChronicHealthConditionLeavers(
			BigInteger q25eChronicHealthConditionLeavers) {
		this.q25eChronicHealthConditionLeavers = q25eChronicHealthConditionLeavers;
	}

	public BigInteger getQ25eHIVandRelatedDiseaseAtEntry() {
		return q25eHIVandRelatedDiseaseAtEntry;
	}

	public void setQ25eHIVandRelatedDiseaseAtEntry(
			BigInteger q25eHIVandRelatedDiseaseAtEntry) {
		this.q25eHIVandRelatedDiseaseAtEntry = q25eHIVandRelatedDiseaseAtEntry;
	}

	public BigInteger getQ25eHIVandRelatedDiseaseStayers() {
		return q25eHIVandRelatedDiseaseStayers;
	}

	public void setQ25eHIVandRelatedDiseaseStayers(
			BigInteger q25eHIVandRelatedDiseaseStayers) {
		this.q25eHIVandRelatedDiseaseStayers = q25eHIVandRelatedDiseaseStayers;
	}

	public BigInteger getQ25eHIVandRelatedDiseaseLeavers() {
		return q25eHIVandRelatedDiseaseLeavers;
	}

	public void setQ25eHIVandRelatedDiseaseLeavers(
			BigInteger q25eHIVandRelatedDiseaseLeavers) {
		this.q25eHIVandRelatedDiseaseLeavers = q25eHIVandRelatedDiseaseLeavers;
	}

	public BigInteger getQ25eDevelopmentalDisabilityAtEntry() {
		return q25eDevelopmentalDisabilityAtEntry;
	}

	public void setQ25eDevelopmentalDisabilityAtEntry(
			BigInteger q25eDevelopmentalDisabilityAtEntry) {
		this.q25eDevelopmentalDisabilityAtEntry = q25eDevelopmentalDisabilityAtEntry;
	}

	public BigInteger getQ25eDevelopmentalDisabilityStayers() {
		return q25eDevelopmentalDisabilityStayers;
	}

	public void setQ25eDevelopmentalDisabilityStayers(
			BigInteger q25eDevelopmentalDisabilityStayers) {
		this.q25eDevelopmentalDisabilityStayers = q25eDevelopmentalDisabilityStayers;
	}

	public BigInteger getQ25eDevelopmentalDisabilityLeavers() {
		return q25eDevelopmentalDisabilityLeavers;
	}

	public void setQ25eDevelopmentalDisabilityLeavers(
			BigInteger q25eDevelopmentalDisabilityLeavers) {
		this.q25eDevelopmentalDisabilityLeavers = q25eDevelopmentalDisabilityLeavers;
	}

	public BigInteger getQ25ePhysicalDisabilityAtEntry() {
		return q25ePhysicalDisabilityAtEntry;
	}

	public void setQ25ePhysicalDisabilityAtEntry(
			BigInteger q25ePhysicalDisabilityAtEntry) {
		this.q25ePhysicalDisabilityAtEntry = q25ePhysicalDisabilityAtEntry;
	}

	public BigInteger getQ25ePhysicalDisabilityStayers() {
		return q25ePhysicalDisabilityStayers;
	}

	public void setQ25ePhysicalDisabilityStayers(
			BigInteger q25ePhysicalDisabilityStayers) {
		this.q25ePhysicalDisabilityStayers = q25ePhysicalDisabilityStayers;
	}

	public BigInteger getQ25ePhysicalDisabilityLeavers() {
		return q25ePhysicalDisabilityLeavers;
	}

	public void setQ25ePhysicalDisabilityLeavers(
			BigInteger q25ePhysicalDisabilityLeavers) {
		this.q25ePhysicalDisabilityLeavers = q25ePhysicalDisabilityLeavers;
	}

	public BigInteger getQ25d18To24Total() {
		return q25d18To24Total;
	}

	public void setQ25d18To24Total(BigInteger q25d18To24Total) {
		this.q25d18To24Total = q25d18To24Total;
	}

	public BigInteger getQ25d18To24WithoutChildren() {
		return q25d18To24WithoutChildren;
	}

	public void setQ25d18To24WithoutChildren(BigInteger q25d18To24WithoutChildren) {
		this.q25d18To24WithoutChildren = q25d18To24WithoutChildren;
	}

	public BigInteger getQ25d18To24WithChildAndAdults() {
		return q25d18To24WithChildAndAdults;
	}

	public void setQ25d18To24WithChildAndAdults(
			BigInteger q25d18To24WithChildAndAdults) {
		this.q25d18To24WithChildAndAdults = q25d18To24WithChildAndAdults;
	}

	public BigInteger getQ25d18To24UnknownHouseHold() {
		return q25d18To24UnknownHouseHold;
	}

	public void setQ25d18To24UnknownHouseHold(BigInteger q25d18To24UnknownHouseHold) {
		this.q25d18To24UnknownHouseHold = q25d18To24UnknownHouseHold;
	}

	public BigInteger getQ25d25To34Total() {
		return q25d25To34Total;
	}

	public void setQ25d25To34Total(BigInteger q25d25To34Total) {
		this.q25d25To34Total = q25d25To34Total;
	}

	public BigInteger getQ25d25To34WithoutChildren() {
		return q25d25To34WithoutChildren;
	}

	public void setQ25d25To34WithoutChildren(BigInteger q25d25To34WithoutChildren) {
		this.q25d25To34WithoutChildren = q25d25To34WithoutChildren;
	}

	public BigInteger getQ25d25To34WithChildAndAdults() {
		return q25d25To34WithChildAndAdults;
	}

	public void setQ25d25To34WithChildAndAdults(
			BigInteger q25d25To34WithChildAndAdults) {
		this.q25d25To34WithChildAndAdults = q25d25To34WithChildAndAdults;
	}

	public BigInteger getQ25d25To34UnknownHouseHold() {
		return q25d25To34UnknownHouseHold;
	}

	public void setQ25d25To34UnknownHouseHold(BigInteger q25d25To34UnknownHouseHold) {
		this.q25d25To34UnknownHouseHold = q25d25To34UnknownHouseHold;
	}

	public BigInteger getQ25d35To44Total() {
		return q25d35To44Total;
	}

	public void setQ25d35To44Total(BigInteger q25d35To44Total) {
		this.q25d35To44Total = q25d35To44Total;
	}

	public BigInteger getQ25d35To44WithoutChildren() {
		return q25d35To44WithoutChildren;
	}

	public void setQ25d35To44WithoutChildren(BigInteger q25d35To44WithoutChildren) {
		this.q25d35To44WithoutChildren = q25d35To44WithoutChildren;
	}

	public BigInteger getQ25d35To44WithChildAndAdults() {
		return q25d35To44WithChildAndAdults;
	}

	public void setQ25d35To44WithChildAndAdults(
			BigInteger q25d35To44WithChildAndAdults) {
		this.q25d35To44WithChildAndAdults = q25d35To44WithChildAndAdults;
	}

	public BigInteger getQ25d35To44UnknownHouseHold() {
		return q25d35To44UnknownHouseHold;
	}

	public void setQ25d35To44UnknownHouseHold(BigInteger q25d35To44UnknownHouseHold) {
		this.q25d35To44UnknownHouseHold = q25d35To44UnknownHouseHold;
	}

	public BigInteger getQ25d45To54Total() {
		return q25d45To54Total;
	}

	public void setQ25d45To54Total(BigInteger q25d45To54Total) {
		this.q25d45To54Total = q25d45To54Total;
	}

	public BigInteger getQ25d45To54WithoutChildren() {
		return q25d45To54WithoutChildren;
	}

	public void setQ25d45To54WithoutChildren(BigInteger q25d45To54WithoutChildren) {
		this.q25d45To54WithoutChildren = q25d45To54WithoutChildren;
	}

	public BigInteger getQ25d45To54WithChildAndAdults() {
		return q25d45To54WithChildAndAdults;
	}

	public void setQ25d45To54WithChildAndAdults(
			BigInteger q25d45To54WithChildAndAdults) {
		this.q25d45To54WithChildAndAdults = q25d45To54WithChildAndAdults;
	}

	public BigInteger getQ25d45To54UnknownHouseHold() {
		return q25d45To54UnknownHouseHold;
	}

	public void setQ25d45To54UnknownHouseHold(BigInteger q25d45To54UnknownHouseHold) {
		this.q25d45To54UnknownHouseHold = q25d45To54UnknownHouseHold;
	}

	public BigInteger getQ25d55To61Total() {
		return q25d55To61Total;
	}

	public void setQ25d55To61Total(BigInteger q25d55To61Total) {
		this.q25d55To61Total = q25d55To61Total;
	}

	public BigInteger getQ25d55To61WithoutChildren() {
		return q25d55To61WithoutChildren;
	}

	public void setQ25d55To61WithoutChildren(BigInteger q25d55To61WithoutChildren) {
		this.q25d55To61WithoutChildren = q25d55To61WithoutChildren;
	}

	public BigInteger getQ25d55To61WithChildAndAdults() {
		return q25d55To61WithChildAndAdults;
	}

	public void setQ25d55To61WithChildAndAdults(
			BigInteger q25d55To61WithChildAndAdults) {
		this.q25d55To61WithChildAndAdults = q25d55To61WithChildAndAdults;
	}

	public BigInteger getQ25d55To61UnknownHouseHold() {
		return q25d55To61UnknownHouseHold;
	}

	public void setQ25d55To61UnknownHouseHold(BigInteger q25d55To61UnknownHouseHold) {
		this.q25d55To61UnknownHouseHold = q25d55To61UnknownHouseHold;
	}

	public BigInteger getQ25d62PlusTotal() {
		return q25d62PlusTotal;
	}

	public void setQ25d62PlusTotal(BigInteger q25d62PlusTotal) {
		this.q25d62PlusTotal = q25d62PlusTotal;
	}

	public BigInteger getQ25d62PlusWithoutChildren() {
		return q25d62PlusWithoutChildren;
	}

	public void setQ25d62PlusWithoutChildren(BigInteger q25d62PlusWithoutChildren) {
		this.q25d62PlusWithoutChildren = q25d62PlusWithoutChildren;
	}

	public BigInteger getQ25d62PlusWithChildAndAdults() {
		return q25d62PlusWithChildAndAdults;
	}

	public void setQ25d62PlusWithChildAndAdults(
			BigInteger q25d62PlusWithChildAndAdults) {
		this.q25d62PlusWithChildAndAdults = q25d62PlusWithChildAndAdults;
	}

	public BigInteger getQ25d62PlusUnknownHouseHold() {
		return q25d62PlusUnknownHouseHold;
	}

	public void setQ25d62PlusUnknownHouseHold(BigInteger q25d62PlusUnknownHouseHold) {
		this.q25d62PlusUnknownHouseHold = q25d62PlusUnknownHouseHold;
	}

	public BigInteger getQ25dDKRTotal() {
		return q25dDKRTotal;
	}

	public void setQ25dDKRTotal(BigInteger q25dDKRTotal) {
		this.q25dDKRTotal = q25dDKRTotal;
	}

	public BigInteger getQ25dDKRWithoutChildren() {
		return q25dDKRWithoutChildren;
	}

	public void setQ25dDKRWithoutChildren(BigInteger q25dDKRWithoutChildren) {
		this.q25dDKRWithoutChildren = q25dDKRWithoutChildren;
	}

	public BigInteger getQ25dDKRWithChildAndAdults() {
		return q25dDKRWithChildAndAdults;
	}

	public void setQ25dDKRWithChildAndAdults(BigInteger q25dDKRWithChildAndAdults) {
		this.q25dDKRWithChildAndAdults = q25dDKRWithChildAndAdults;
	}

	public BigInteger getQ25dDKRUnknownHouseHold() {
		return q25dDKRUnknownHouseHold;
	}

	public void setQ25dDKRUnknownHouseHold(BigInteger q25dDKRUnknownHouseHold) {
		this.q25dDKRUnknownHouseHold = q25dDKRUnknownHouseHold;
	}

	public BigInteger getQ25dInformationMissingTotal() {
		return q25dInformationMissingTotal;
	}

	public void setQ25dInformationMissingTotal(
			BigInteger q25dInformationMissingTotal) {
		this.q25dInformationMissingTotal = q25dInformationMissingTotal;
	}

	public BigInteger getQ25dInformationMissingWithoutChildren() {
		return q25dInformationMissingWithoutChildren;
	}

	public void setQ25dInformationMissingWithoutChildren(
			BigInteger q25dInformationMissingWithoutChildren) {
		this.q25dInformationMissingWithoutChildren = q25dInformationMissingWithoutChildren;
	}

	public BigInteger getQ25dInformationMissingWithChildAndAdults() {
		return q25dInformationMissingWithChildAndAdults;
	}

	public void setQ25dInformationMissingWithChildAndAdults(
			BigInteger q25dInformationMissingWithChildAndAdults) {
		this.q25dInformationMissingWithChildAndAdults = q25dInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ25dInformationMissingUnknownHouseHold() {
		return q25dInformationMissingUnknownHouseHold;
	}

	public void setQ25dInformationMissingUnknownHouseHold(
			BigInteger q25dInformationMissingUnknownHouseHold) {
		this.q25dInformationMissingUnknownHouseHold = q25dInformationMissingUnknownHouseHold;
	}

	public BigInteger getQ25dTotTotal() {
		return q25dTotTotal;
	}

	public void setQ25dTotTotal(BigInteger q25dTotTotal) {
		this.q25dTotTotal = q25dTotTotal;
	}

	public BigInteger getQ25dTotWithoutChildren() {
		return q25dTotWithoutChildren;
	}

	public void setQ25dTotWithoutChildren(BigInteger q25dTotWithoutChildren) {
		this.q25dTotWithoutChildren = q25dTotWithoutChildren;
	}

	public BigInteger getQ25dTotWithChildAndAdults() {
		return q25dTotWithChildAndAdults;
	}

	public void setQ25dTotWithChildAndAdults(BigInteger q25dTotWithChildAndAdults) {
		this.q25dTotWithChildAndAdults = q25dTotWithChildAndAdults;
	}

	public BigInteger getQ25dTotUnknownHouseHold() {
		return q25dTotUnknownHouseHold;
	}

	public void setQ25dTotUnknownHouseHold(BigInteger q25dTotUnknownHouseHold) {
		this.q25dTotUnknownHouseHold = q25dTotUnknownHouseHold;
	}

	public BigInteger getQ25cMaleTotal() {
		return q25cMaleTotal;
	}

	public void setQ25cMaleTotal(BigInteger q25cMaleTotal) {
		this.q25cMaleTotal = q25cMaleTotal;
	}

	public BigInteger getQ25cMaleWithoutChildren() {
		return q25cMaleWithoutChildren;
	}

	public void setQ25cMaleWithoutChildren(BigInteger q25cMaleWithoutChildren) {
		this.q25cMaleWithoutChildren = q25cMaleWithoutChildren;
	}

	public BigInteger getQ25cMaleWithChildAndAdults() {
		return q25cMaleWithChildAndAdults;
	}

	public void setQ25cMaleWithChildAndAdults(BigInteger q25cMaleWithChildAndAdults) {
		this.q25cMaleWithChildAndAdults = q25cMaleWithChildAndAdults;
	}

	public BigInteger getQ25cMaleUnknownHouseHold() {
		return q25cMaleUnknownHouseHold;
	}

	public void setQ25cMaleUnknownHouseHold(BigInteger q25cMaleUnknownHouseHold) {
		this.q25cMaleUnknownHouseHold = q25cMaleUnknownHouseHold;
	}

	public BigInteger getQ25cFemaleTotal() {
		return q25cFemaleTotal;
	}

	public void setQ25cFemaleTotal(BigInteger q25cFemaleTotal) {
		this.q25cFemaleTotal = q25cFemaleTotal;
	}

	public BigInteger getQ25cFemaleWithoutChildren() {
		return q25cFemaleWithoutChildren;
	}

	public void setQ25cFemaleWithoutChildren(BigInteger q25cFemaleWithoutChildren) {
		this.q25cFemaleWithoutChildren = q25cFemaleWithoutChildren;
	}

	public BigInteger getQ25cFemaleWithChildAndAdults() {
		return q25cFemaleWithChildAndAdults;
	}

	public void setQ25cFemaleWithChildAndAdults(
			BigInteger q25cFemaleWithChildAndAdults) {
		this.q25cFemaleWithChildAndAdults = q25cFemaleWithChildAndAdults;
	}

	public BigInteger getQ25cFemaleUnknownHouseHold() {
		return q25cFemaleUnknownHouseHold;
	}

	public void setQ25cFemaleUnknownHouseHold(BigInteger q25cFemaleUnknownHouseHold) {
		this.q25cFemaleUnknownHouseHold = q25cFemaleUnknownHouseHold;
	}

	public BigInteger getQ25cTransgenderMaleToFemaleTotal() {
		return q25cTransgenderMaleToFemaleTotal;
	}

	public void setQ25cTransgenderMaleToFemaleTotal(
			BigInteger q25cTransgenderMaleToFemaleTotal) {
		this.q25cTransgenderMaleToFemaleTotal = q25cTransgenderMaleToFemaleTotal;
	}

	public BigInteger getQ25cTransgenderMaleToFemaleWithoutChildren() {
		return q25cTransgenderMaleToFemaleWithoutChildren;
	}

	public void setQ25cTransgenderMaleToFemaleWithoutChildren(
			BigInteger q25cTransgenderMaleToFemaleWithoutChildren) {
		this.q25cTransgenderMaleToFemaleWithoutChildren = q25cTransgenderMaleToFemaleWithoutChildren;
	}

	public BigInteger getQ25cTransgenderMaleToFemaleWithChildAndAdults() {
		return q25cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public void setQ25cTransgenderMaleToFemaleWithChildAndAdults(
			BigInteger q25cTransgenderMaleToFemaleWithChildAndAdults) {
		this.q25cTransgenderMaleToFemaleWithChildAndAdults = q25cTransgenderMaleToFemaleWithChildAndAdults;
	}

	public BigInteger getQ25cTransgenderMaleToFemaleUnknownHouseHold() {
		return q25cTransgenderMaleToFemaleUnknownHouseHold;
	}

	public void setQ25cTransgenderMaleToFemaleUnknownHouseHold(
			BigInteger q25cTransgenderMaleToFemaleUnknownHouseHold) {
		this.q25cTransgenderMaleToFemaleUnknownHouseHold = q25cTransgenderMaleToFemaleUnknownHouseHold;
	}

	public BigInteger getQ25cTransgendereFemaleToMaleTotal() {
		return q25cTransgendereFemaleToMaleTotal;
	}

	public void setQ25cTransgendereFemaleToMaleTotal(
			BigInteger q25cTransgendereFemaleToMaleTotal) {
		this.q25cTransgendereFemaleToMaleTotal = q25cTransgendereFemaleToMaleTotal;
	}

	public BigInteger getQ25cTransgendereFemaleToMaleWithoutChildren() {
		return q25cTransgendereFemaleToMaleWithoutChildren;
	}

	public void setQ25cTransgendereFemaleToMaleWithoutChildren(
			BigInteger q25cTransgendereFemaleToMaleWithoutChildren) {
		this.q25cTransgendereFemaleToMaleWithoutChildren = q25cTransgendereFemaleToMaleWithoutChildren;
	}

	public BigInteger getQ25cTransgendereFemaleToMaleWithChildAndAdults() {
		return q25cTransgendereFemaleToMaleWithChildAndAdults;
	}

	public void setQ25cTransgendereFemaleToMaleWithChildAndAdults(
			BigInteger q25cTransgendereFemaleToMaleWithChildAndAdults) {
		this.q25cTransgendereFemaleToMaleWithChildAndAdults = q25cTransgendereFemaleToMaleWithChildAndAdults;
	}

	public BigInteger getQ25cTransgendereFemaleToMaleUnknownHouseHold() {
		return q25cTransgendereFemaleToMaleUnknownHouseHold;
	}

	public void setQ25cTransgendereFemaleToMaleUnknownHouseHold(
			BigInteger q25cTransgendereFemaleToMaleUnknownHouseHold) {
		this.q25cTransgendereFemaleToMaleUnknownHouseHold = q25cTransgendereFemaleToMaleUnknownHouseHold;
	}

	public BigInteger getQ25cOtherTotal() {
		return q25cOtherTotal;
	}

	public void setQ25cOtherTotal(BigInteger q25cOtherTotal) {
		this.q25cOtherTotal = q25cOtherTotal;
	}

	public BigInteger getQ25cOtherWithoutChildren() {
		return q25cOtherWithoutChildren;
	}

	public void setQ25cOtherWithoutChildren(BigInteger q25cOtherWithoutChildren) {
		this.q25cOtherWithoutChildren = q25cOtherWithoutChildren;
	}

	public BigInteger getQ25cOtherWithChildAndAdults() {
		return q25cOtherWithChildAndAdults;
	}

	public void setQ25cOtherWithChildAndAdults(
			BigInteger q25cOtherWithChildAndAdults) {
		this.q25cOtherWithChildAndAdults = q25cOtherWithChildAndAdults;
	}

	public BigInteger getQ25cOtherUnknownHouseHold() {
		return q25cOtherUnknownHouseHold;
	}

	public void setQ25cOtherUnknownHouseHold(BigInteger q25cOtherUnknownHouseHold) {
		this.q25cOtherUnknownHouseHold = q25cOtherUnknownHouseHold;
	}

	public BigInteger getQ25cDKRTotal() {
		return q25cDKRTotal;
	}

	public void setQ25cDKRTotal(BigInteger q25cDKRTotal) {
		this.q25cDKRTotal = q25cDKRTotal;
	}

	public BigInteger getQ25cDKRWithoutChildren() {
		return q25cDKRWithoutChildren;
	}

	public void setQ25cDKRWithoutChildren(BigInteger q25cDKRWithoutChildren) {
		this.q25cDKRWithoutChildren = q25cDKRWithoutChildren;
	}

	public BigInteger getQ25cDKRWithChildAndAdults() {
		return q25cDKRWithChildAndAdults;
	}

	public void setQ25cDKRWithChildAndAdults(BigInteger q25cDKRWithChildAndAdults) {
		this.q25cDKRWithChildAndAdults = q25cDKRWithChildAndAdults;
	}

	public BigInteger getQ25cDKRUnknownHouseHold() {
		return q25cDKRUnknownHouseHold;
	}

	public void setQ25cDKRUnknownHouseHold(BigInteger q25cDKRUnknownHouseHold) {
		this.q25cDKRUnknownHouseHold = q25cDKRUnknownHouseHold;
	}

	public BigInteger getQ25cInformationMissingTotal() {
		return q25cInformationMissingTotal;
	}

	public void setQ25cInformationMissingTotal(
			BigInteger q25cInformationMissingTotal) {
		this.q25cInformationMissingTotal = q25cInformationMissingTotal;
	}

	public BigInteger getQ25cInformationMissingWithoutChildren() {
		return q25cInformationMissingWithoutChildren;
	}

	public void setQ25cInformationMissingWithoutChildren(
			BigInteger q25cInformationMissingWithoutChildren) {
		this.q25cInformationMissingWithoutChildren = q25cInformationMissingWithoutChildren;
	}

	public BigInteger getQ25cInformationMissingWithChildAndAdults() {
		return q25cInformationMissingWithChildAndAdults;
	}

	public void setQ25cInformationMissingWithChildAndAdults(
			BigInteger q25cInformationMissingWithChildAndAdults) {
		this.q25cInformationMissingWithChildAndAdults = q25cInformationMissingWithChildAndAdults;
	}

	public BigInteger getQ25cInformationMissingUnknownHouseHold() {
		return q25cInformationMissingUnknownHouseHold;
	}

	public void setQ25cInformationMissingUnknownHouseHold(
			BigInteger q25cInformationMissingUnknownHouseHold) {
		this.q25cInformationMissingUnknownHouseHold = q25cInformationMissingUnknownHouseHold;
	}

	public BigInteger getQ25cTotTotal() {
		return q25cTotTotal;
	}

	public void setQ25cTotTotal(BigInteger q25cTotTotal) {
		this.q25cTotTotal = q25cTotTotal;
	}

	public BigInteger getQ25cTotWithoutChildren() {
		return q25cTotWithoutChildren;
	}

	public void setQ25cTotWithoutChildren(BigInteger q25cTotWithoutChildren) {
		this.q25cTotWithoutChildren = q25cTotWithoutChildren;
	}

	public BigInteger getQ25cTotWithChildAndAdults() {
		return q25cTotWithChildAndAdults;
	}

	public void setQ25cTotWithChildAndAdults(BigInteger q25cTotWithChildAndAdults) {
		this.q25cTotWithChildAndAdults = q25cTotWithChildAndAdults;
	}

	public BigInteger getQ25cTotUnknownHouseHold() {
		return q25cTotUnknownHouseHold;
	}

	public void setQ25cTotUnknownHouseHold(BigInteger q25cTotUnknownHouseHold) {
		this.q25cTotUnknownHouseHold = q25cTotUnknownHouseHold;
	}

	public BigInteger getQ25bChronicallyHomelessVeteranTotal() {
		return q25bChronicallyHomelessVeteranTotal;
	}

	public void setQ25bChronicallyHomelessVeteranTotal(
			BigInteger q25bChronicallyHomelessVeteranTotal) {
		this.q25bChronicallyHomelessVeteranTotal = q25bChronicallyHomelessVeteranTotal;
	}

	public BigInteger getQ25bChronicallyHomelessVeteranWithoutChildren() {
		return q25bChronicallyHomelessVeteranWithoutChildren;
	}

	public void setQ25bChronicallyHomelessVeteranWithoutChildren(
			BigInteger q25bChronicallyHomelessVeteranWithoutChildren) {
		this.q25bChronicallyHomelessVeteranWithoutChildren = q25bChronicallyHomelessVeteranWithoutChildren;
	}

	public BigInteger getQ25bChronicallyHomelessVeteranWithChildAndAdults() {
		return q25bChronicallyHomelessVeteranWithChildAndAdults;
	}

	public void setQ25bChronicallyHomelessVeteranWithChildAndAdults(
			BigInteger q25bChronicallyHomelessVeteranWithChildAndAdults) {
		this.q25bChronicallyHomelessVeteranWithChildAndAdults = q25bChronicallyHomelessVeteranWithChildAndAdults;
	}

	public BigInteger getQ25bChronicallyHomelessVeteranUnknownHouseHold() {
		return q25bChronicallyHomelessVeteranUnknownHouseHold;
	}

	public void setQ25bChronicallyHomelessVeteranUnknownHouseHold(
			BigInteger q25bChronicallyHomelessVeteranUnknownHouseHold) {
		this.q25bChronicallyHomelessVeteranUnknownHouseHold = q25bChronicallyHomelessVeteranUnknownHouseHold;
	}

	public BigInteger getQ25bNonChronicallyHomelessVeteranTotal() {
		return q25bNonChronicallyHomelessVeteranTotal;
	}

	public void setQ25bNonChronicallyHomelessVeteranTotal(
			BigInteger q25bNonChronicallyHomelessVeteranTotal) {
		this.q25bNonChronicallyHomelessVeteranTotal = q25bNonChronicallyHomelessVeteranTotal;
	}

	public BigInteger getQ25bNonChronicallyHomelessVeteranWithoutChildren() {
		return q25bNonChronicallyHomelessVeteranWithoutChildren;
	}

	public void setQ25bNonChronicallyHomelessVeteranWithoutChildren(
			BigInteger q25bNonChronicallyHomelessVeteranWithoutChildren) {
		this.q25bNonChronicallyHomelessVeteranWithoutChildren = q25bNonChronicallyHomelessVeteranWithoutChildren;
	}

	public BigInteger getQ25bNonChronicallyHomelessVeteranWithChildAndAdults() {
		return q25bNonChronicallyHomelessVeteranWithChildAndAdults;
	}

	public void setQ25bNonChronicallyHomelessVeteranWithChildAndAdults(
			BigInteger q25bNonChronicallyHomelessVeteranWithChildAndAdults) {
		this.q25bNonChronicallyHomelessVeteranWithChildAndAdults = q25bNonChronicallyHomelessVeteranWithChildAndAdults;
	}

	public BigInteger getQ25bNonChronicallyHomelessVeteranUnknownHouseHold() {
		return q25bNonChronicallyHomelessVeteranUnknownHouseHold;
	}

	public void setQ25bNonChronicallyHomelessVeteranUnknownHouseHold(
			BigInteger q25bNonChronicallyHomelessVeteranUnknownHouseHold) {
		this.q25bNonChronicallyHomelessVeteranUnknownHouseHold = q25bNonChronicallyHomelessVeteranUnknownHouseHold;
	}

	public BigInteger getQ25bNotVeteranTotal() {
		return q25bNotVeteranTotal;
	}

	public void setQ25bNotVeteranTotal(BigInteger q25bNotVeteranTotal) {
		this.q25bNotVeteranTotal = q25bNotVeteranTotal;
	}

	public BigInteger getQ25bNotVeteranWithoutChildren() {
		return q25bNotVeteranWithoutChildren;
	}

	public void setQ25bNotVeteranWithoutChildren(
			BigInteger q25bNotVeteranWithoutChildren) {
		this.q25bNotVeteranWithoutChildren = q25bNotVeteranWithoutChildren;
	}

	public BigInteger getQ25bNotVeteranWithChildAndAdults() {
		return q25bNotVeteranWithChildAndAdults;
	}

	public void setQ25bNotVeteranWithChildAndAdults(
			BigInteger q25bNotVeteranWithChildAndAdults) {
		this.q25bNotVeteranWithChildAndAdults = q25bNotVeteranWithChildAndAdults;
	}

	public BigInteger getQ25bNotVeteranUnknownHouseHold() {
		return q25bNotVeteranUnknownHouseHold;
	}

	public void setQ25bNotVeteranUnknownHouseHold(
			BigInteger q25bNotVeteranUnknownHouseHold) {
		this.q25bNotVeteranUnknownHouseHold = q25bNotVeteranUnknownHouseHold;
	}

	public BigInteger getQ25bClientRefusedTotal() {
		return q25bClientRefusedTotal;
	}

	public void setQ25bClientRefusedTotal(BigInteger q25bClientRefusedTotal) {
		this.q25bClientRefusedTotal = q25bClientRefusedTotal;
	}

	public BigInteger getQ25bClientRefusedWithoutChildren() {
		return q25bClientRefusedWithoutChildren;
	}

	public void setQ25bClientRefusedWithoutChildren(
			BigInteger q25bClientRefusedWithoutChildren) {
		this.q25bClientRefusedWithoutChildren = q25bClientRefusedWithoutChildren;
	}

	public BigInteger getQ25bClientRefusedWithChildAndAdults() {
		return q25bClientRefusedWithChildAndAdults;
	}

	public void setQ25bClientRefusedWithChildAndAdults(
			BigInteger q25bClientRefusedWithChildAndAdults) {
		this.q25bClientRefusedWithChildAndAdults = q25bClientRefusedWithChildAndAdults;
	}

	public BigInteger getQ25bClientRefusedUnknownHouseHold() {
		return q25bClientRefusedUnknownHouseHold;
	}

	public void setQ25bClientRefusedUnknownHouseHold(
			BigInteger q25bClientRefusedUnknownHouseHold) {
		this.q25bClientRefusedUnknownHouseHold = q25bClientRefusedUnknownHouseHold;
	}

	public BigInteger getQ25bDataNotCollectedTotal() {
		return q25bDataNotCollectedTotal;
	}

	public void setQ25bDataNotCollectedTotal(BigInteger q25bDataNotCollectedTotal) {
		this.q25bDataNotCollectedTotal = q25bDataNotCollectedTotal;
	}

	public BigInteger getQ25bDataNotCollectedWithoutChildren() {
		return q25bDataNotCollectedWithoutChildren;
	}

	public void setQ25bDataNotCollectedWithoutChildren(
			BigInteger q25bDataNotCollectedWithoutChildren) {
		this.q25bDataNotCollectedWithoutChildren = q25bDataNotCollectedWithoutChildren;
	}

	public BigInteger getQ25bDataNotCollectedWithChildAndAdults() {
		return q25bDataNotCollectedWithChildAndAdults;
	}

	public void setQ25bDataNotCollectedWithChildAndAdults(
			BigInteger q25bDataNotCollectedWithChildAndAdults) {
		this.q25bDataNotCollectedWithChildAndAdults = q25bDataNotCollectedWithChildAndAdults;
	}

	public BigInteger getQ25bDataNotCollectedUnknownHouseHold() {
		return q25bDataNotCollectedUnknownHouseHold;
	}

	public void setQ25bDataNotCollectedUnknownHouseHold(
			BigInteger q25bDataNotCollectedUnknownHouseHold) {
		this.q25bDataNotCollectedUnknownHouseHold = q25bDataNotCollectedUnknownHouseHold;
	}

	public BigInteger getQ25bTotTotal() {
		return q25bTotTotal;
	}

	public void setQ25bTotTotal(BigInteger q25bTotTotal) {
		this.q25bTotTotal = q25bTotTotal;
	}

	public BigInteger getQ25bTotWithoutChildren() {
		return q25bTotWithoutChildren;
	}

	public void setQ25bTotWithoutChildren(BigInteger q25bTotWithoutChildren) {
		this.q25bTotWithoutChildren = q25bTotWithoutChildren;
	}

	public BigInteger getQ25bTotWithChildAndAdults() {
		return q25bTotWithChildAndAdults;
	}

	public void setQ25bTotWithChildAndAdults(BigInteger q25bTotWithChildAndAdults) {
		this.q25bTotWithChildAndAdults = q25bTotWithChildAndAdults;
	}

	public BigInteger getQ25bTotUnknownHouseHold() {
		return q25bTotUnknownHouseHold;
	}

	public void setQ25bTotUnknownHouseHold(BigInteger q25bTotUnknownHouseHold) {
		this.q25bTotUnknownHouseHold = q25bTotUnknownHouseHold;
	}

	public BigInteger getQ25aChronicallyHomelessVeteranTotal() {
		return q25aChronicallyHomelessVeteranTotal;
	}

	public void setQ25aChronicallyHomelessVeteranTotal(
			BigInteger q25aChronicallyHomelessVeteranTotal) {
		this.q25aChronicallyHomelessVeteranTotal = q25aChronicallyHomelessVeteranTotal;
	}

	public BigInteger getQ25aChronicallyHomelessVeteranWithoutChildren() {
		return q25aChronicallyHomelessVeteranWithoutChildren;
	}

	public void setQ25aChronicallyHomelessVeteranWithoutChildren(
			BigInteger q25aChronicallyHomelessVeteranWithoutChildren) {
		this.q25aChronicallyHomelessVeteranWithoutChildren = q25aChronicallyHomelessVeteranWithoutChildren;
	}

	public BigInteger getQ25aChronicallyHomelessVeteranWithChildAndAdults() {
		return q25aChronicallyHomelessVeteranWithChildAndAdults;
	}

	public void setQ25aChronicallyHomelessVeteranWithChildAndAdults(
			BigInteger q25aChronicallyHomelessVeteranWithChildAndAdults) {
		this.q25aChronicallyHomelessVeteranWithChildAndAdults = q25aChronicallyHomelessVeteranWithChildAndAdults;
	}

	public BigInteger getQ25aChronicallyHomelessVeteranUnknownHouseHold() {
		return q25aChronicallyHomelessVeteranUnknownHouseHold;
	}

	public void setQ25aChronicallyHomelessVeteranUnknownHouseHold(
			BigInteger q25aChronicallyHomelessVeteranUnknownHouseHold) {
		this.q25aChronicallyHomelessVeteranUnknownHouseHold = q25aChronicallyHomelessVeteranUnknownHouseHold;
	}

	public BigInteger getQ25aNonChronicallyHomelessVeteranTotal() {
		return q25aNonChronicallyHomelessVeteranTotal;
	}

	public void setQ25aNonChronicallyHomelessVeteranTotal(
			BigInteger q25aNonChronicallyHomelessVeteranTotal) {
		this.q25aNonChronicallyHomelessVeteranTotal = q25aNonChronicallyHomelessVeteranTotal;
	}

	public BigInteger getQ25aNonChronicallyHomelessVeteranWithoutChildren() {
		return q25aNonChronicallyHomelessVeteranWithoutChildren;
	}

	public void setQ25aNonChronicallyHomelessVeteranWithoutChildren(
			BigInteger q25aNonChronicallyHomelessVeteranWithoutChildren) {
		this.q25aNonChronicallyHomelessVeteranWithoutChildren = q25aNonChronicallyHomelessVeteranWithoutChildren;
	}

	public BigInteger getQ25aNonChronicallyHomelessVeteranWithChildAndAdults() {
		return q25aNonChronicallyHomelessVeteranWithChildAndAdults;
	}

	public void setQ25aNonChronicallyHomelessVeteranWithChildAndAdults(
			BigInteger q25aNonChronicallyHomelessVeteranWithChildAndAdults) {
		this.q25aNonChronicallyHomelessVeteranWithChildAndAdults = q25aNonChronicallyHomelessVeteranWithChildAndAdults;
	}

	public BigInteger getQ25aNonChronicallyHomelessVeteranUnknownHouseHold() {
		return q25aNonChronicallyHomelessVeteranUnknownHouseHold;
	}

	public void setQ25aNonChronicallyHomelessVeteranUnknownHouseHold(
			BigInteger q25aNonChronicallyHomelessVeteranUnknownHouseHold) {
		this.q25aNonChronicallyHomelessVeteranUnknownHouseHold = q25aNonChronicallyHomelessVeteranUnknownHouseHold;
	}

	public BigInteger getQ25aNotVeteranTotal() {
		return q25aNotVeteranTotal;
	}

	public void setQ25aNotVeteranTotal(BigInteger q25aNotVeteranTotal) {
		this.q25aNotVeteranTotal = q25aNotVeteranTotal;
	}

	public BigInteger getQ25aNotVeteranWithoutChildren() {
		return q25aNotVeteranWithoutChildren;
	}

	public void setQ25aNotVeteranWithoutChildren(
			BigInteger q25aNotVeteranWithoutChildren) {
		this.q25aNotVeteranWithoutChildren = q25aNotVeteranWithoutChildren;
	}

	public BigInteger getQ25aNotVeteranWithChildAndAdults() {
		return q25aNotVeteranWithChildAndAdults;
	}

	public void setQ25aNotVeteranWithChildAndAdults(
			BigInteger q25aNotVeteranWithChildAndAdults) {
		this.q25aNotVeteranWithChildAndAdults = q25aNotVeteranWithChildAndAdults;
	}

	public BigInteger getQ25aNotVeteranUnknownHouseHold() {
		return q25aNotVeteranUnknownHouseHold;
	}

	public void setQ25aNotVeteranUnknownHouseHold(
			BigInteger q25aNotVeteranUnknownHouseHold) {
		this.q25aNotVeteranUnknownHouseHold = q25aNotVeteranUnknownHouseHold;
	}

	public BigInteger getQ25aClientRefusedTotal() {
		return q25aClientRefusedTotal;
	}

	public void setQ25aClientRefusedTotal(BigInteger q25aClientRefusedTotal) {
		this.q25aClientRefusedTotal = q25aClientRefusedTotal;
	}

	public BigInteger getQ25aClientRefusedWithoutChildren() {
		return q25aClientRefusedWithoutChildren;
	}

	public void setQ25aClientRefusedWithoutChildren(
			BigInteger q25aClientRefusedWithoutChildren) {
		this.q25aClientRefusedWithoutChildren = q25aClientRefusedWithoutChildren;
	}

	public BigInteger getQ25aClientRefusedWithChildAndAdults() {
		return q25aClientRefusedWithChildAndAdults;
	}

	public void setQ25aClientRefusedWithChildAndAdults(
			BigInteger q25aClientRefusedWithChildAndAdults) {
		this.q25aClientRefusedWithChildAndAdults = q25aClientRefusedWithChildAndAdults;
	}

	public BigInteger getQ25aClientRefusedUnknownHouseHold() {
		return q25aClientRefusedUnknownHouseHold;
	}

	public void setQ25aClientRefusedUnknownHouseHold(
			BigInteger q25aClientRefusedUnknownHouseHold) {
		this.q25aClientRefusedUnknownHouseHold = q25aClientRefusedUnknownHouseHold;
	}

	public BigInteger getQ25aDataNotCollectedTotal() {
		return q25aDataNotCollectedTotal;
	}

	public void setQ25aDataNotCollectedTotal(BigInteger q25aDataNotCollectedTotal) {
		this.q25aDataNotCollectedTotal = q25aDataNotCollectedTotal;
	}

	public BigInteger getQ25aDataNotCollectedWithoutChildren() {
		return q25aDataNotCollectedWithoutChildren;
	}

	public void setQ25aDataNotCollectedWithoutChildren(
			BigInteger q25aDataNotCollectedWithoutChildren) {
		this.q25aDataNotCollectedWithoutChildren = q25aDataNotCollectedWithoutChildren;
	}

	public BigInteger getQ25aDataNotCollectedWithChildAndAdults() {
		return q25aDataNotCollectedWithChildAndAdults;
	}

	public void setQ25aDataNotCollectedWithChildAndAdults(
			BigInteger q25aDataNotCollectedWithChildAndAdults) {
		this.q25aDataNotCollectedWithChildAndAdults = q25aDataNotCollectedWithChildAndAdults;
	}

	public BigInteger getQ25aDataNotCollectedUnknownHouseHold() {
		return q25aDataNotCollectedUnknownHouseHold;
	}

	public void setQ25aDataNotCollectedUnknownHouseHold(
			BigInteger q25aDataNotCollectedUnknownHouseHold) {
		this.q25aDataNotCollectedUnknownHouseHold = q25aDataNotCollectedUnknownHouseHold;
	}

	public BigInteger getQ25aTotTotal() {
		return q25aTotTotal;
	}

	public void setQ25aTotTotal(BigInteger q25aTotTotal) {
		this.q25aTotTotal = q25aTotTotal;
	}

	public BigInteger getQ25aTotWithoutChildren() {
		return q25aTotWithoutChildren;
	}

	public void setQ25aTotWithoutChildren(BigInteger q25aTotWithoutChildren) {
		this.q25aTotWithoutChildren = q25aTotWithoutChildren;
	}

	public BigInteger getQ25aTotWithChildAndAdults() {
		return q25aTotWithChildAndAdults;
	}

	public void setQ25aTotWithChildAndAdults(BigInteger q25aTotWithChildAndAdults) {
		this.q25aTotWithChildAndAdults = q25aTotWithChildAndAdults;
	}

	public BigInteger getQ25aTotUnknownHouseHold() {
		return q25aTotUnknownHouseHold;
	}

	public void setQ25aTotUnknownHouseHold(BigInteger q25aTotUnknownHouseHold) {
		this.q25aTotUnknownHouseHold = q25aTotUnknownHouseHold;
	}

	public BigInteger getQ23BAPermanentDestinationsTotal() {
		return q23BAPermanentDestinationsTotal;
	}

	public void setQ23BAPermanentDestinationsTotal(
			BigInteger q23baPermanentDestinationsTotal) {
		q23BAPermanentDestinationsTotal = q23baPermanentDestinationsTotal;
	}

	public BigInteger getQ23BAPermanentDestinationsWithoutChild() {
		return q23BAPermanentDestinationsWithoutChild;
	}

	public void setQ23BAPermanentDestinationsWithoutChild(
			BigInteger q23baPermanentDestinationsWithoutChild) {
		q23BAPermanentDestinationsWithoutChild = q23baPermanentDestinationsWithoutChild;
	}

	public BigInteger getQ23BAPermanentDestinationsWithChildAndAdults() {
		return q23BAPermanentDestinationsWithChildAndAdults;
	}

	public void setQ23BAPermanentDestinationsWithChildAndAdults(
			BigInteger q23baPermanentDestinationsWithChildAndAdults) {
		q23BAPermanentDestinationsWithChildAndAdults = q23baPermanentDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23BAPermanentDestinationsWithOnlyChild() {
		return q23BAPermanentDestinationsWithOnlyChild;
	}

	public void setQ23BAPermanentDestinationsWithOnlyChild(
			BigInteger q23baPermanentDestinationsWithOnlyChild) {
		q23BAPermanentDestinationsWithOnlyChild = q23baPermanentDestinationsWithOnlyChild;
	}

	public BigInteger getQ23BAPermanentDestinationsUnknownHouseHold() {
		return q23BAPermanentDestinationsUnknownHouseHold;
	}

	public void setQ23BAPermanentDestinationsUnknownHouseHold(
			BigInteger q23baPermanentDestinationsUnknownHouseHold) {
		q23BAPermanentDestinationsUnknownHouseHold = q23baPermanentDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23BA01MovedFromOneHOPWATotal() {
		return q23BA01MovedFromOneHOPWATotal;
	}

	public void setQ23BA01MovedFromOneHOPWATotal(
			BigInteger q23ba01MovedFromOneHOPWATotal) {
		q23BA01MovedFromOneHOPWATotal = q23ba01MovedFromOneHOPWATotal;
	}

	public BigInteger getQ23BA01MovedFromOneHOPWAWithoutChild() {
		return q23BA01MovedFromOneHOPWAWithoutChild;
	}

	public void setQ23BA01MovedFromOneHOPWAWithoutChild(
			BigInteger q23ba01MovedFromOneHOPWAWithoutChild) {
		q23BA01MovedFromOneHOPWAWithoutChild = q23ba01MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ23BA01MovedFromOneHOPWAWithChildAndAdults() {
		return q23BA01MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ23BA01MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q23ba01MovedFromOneHOPWAWithChildAndAdults) {
		q23BA01MovedFromOneHOPWAWithChildAndAdults = q23ba01MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ23BA01MovedFromOneHOPWAWithOnlyChild() {
		return q23BA01MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ23BA01MovedFromOneHOPWAWithOnlyChild(
			BigInteger q23ba01MovedFromOneHOPWAWithOnlyChild) {
		q23BA01MovedFromOneHOPWAWithOnlyChild = q23ba01MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ23BA01MovedFromOneHOPWAUnknownHouseHold() {
		return q23BA01MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ23BA01MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q23ba01MovedFromOneHOPWAUnknownHouseHold) {
		q23BA01MovedFromOneHOPWAUnknownHouseHold = q23ba01MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ23BA02OwnedByClientNoOngoingSubsidyTotal() {
		return q23BA02OwnedByClientNoOngoingSubsidyTotal;
	}

	public void setQ23BA02OwnedByClientNoOngoingSubsidyTotal(
			BigInteger q23ba02OwnedByClientNoOngoingSubsidyTotal) {
		q23BA02OwnedByClientNoOngoingSubsidyTotal = q23ba02OwnedByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ23BA02OwnedByClientNoOngoingSubsidyWithoutChild() {
		return q23BA02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ23BA02OwnedByClientNoOngoingSubsidyWithoutChild(
			BigInteger q23ba02OwnedByClientNoOngoingSubsidyWithoutChild) {
		q23BA02OwnedByClientNoOngoingSubsidyWithoutChild = q23ba02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults() {
		return q23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q23ba02OwnedByClientNoOngoingSubsidyWithChildAndAdults) {
		q23BA02OwnedByClientNoOngoingSubsidyWithChildAndAdults = q23ba02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild() {
		return q23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q23ba02OwnedByClientNoOngoingSubsidyWithOnlyChild) {
		q23BA02OwnedByClientNoOngoingSubsidyWithOnlyChild = q23ba02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold() {
		return q23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q23ba02OwnedByClientNoOngoingSubsidyUnknownHouseHold) {
		q23BA02OwnedByClientNoOngoingSubsidyUnknownHouseHold = q23ba02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23BA03OwnedByClientWithOngoingSubsidyTotal() {
		return q23BA03OwnedByClientWithOngoingSubsidyTotal;
	}

	public void setQ23BA03OwnedByClientWithOngoingSubsidyTotal(
			BigInteger q23ba03OwnedByClientWithOngoingSubsidyTotal) {
		q23BA03OwnedByClientWithOngoingSubsidyTotal = q23ba03OwnedByClientWithOngoingSubsidyTotal;
	}

	public BigInteger getQ23BA03OwnedByClientWithOngoingSubsidyWithoutChild() {
		return q23BA03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public void setQ23BA03OwnedByClientWithOngoingSubsidyWithoutChild(
			BigInteger q23ba03OwnedByClientWithOngoingSubsidyWithoutChild) {
		q23BA03OwnedByClientWithOngoingSubsidyWithoutChild = q23ba03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults() {
		return q23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults(
			BigInteger q23ba03OwnedByClientWithOngoingSubsidyWithChildAndAdults) {
		q23BA03OwnedByClientWithOngoingSubsidyWithChildAndAdults = q23ba03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild() {
		return q23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public void setQ23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild(
			BigInteger q23ba03OwnedByClientWithOngoingSubsidyWithOnlyChild) {
		q23BA03OwnedByClientWithOngoingSubsidyWithOnlyChild = q23ba03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold() {
		return q23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold(
			BigInteger q23ba03OwnedByClientWithOngoingSubsidyUnknownHouseHold) {
		q23BA03OwnedByClientWithOngoingSubsidyUnknownHouseHold = q23ba03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23BA04RentalByClientNoOngoingSubsidyTotal() {
		return q23BA04RentalByClientNoOngoingSubsidyTotal;
	}

	public void setQ23BA04RentalByClientNoOngoingSubsidyTotal(
			BigInteger q23ba04RentalByClientNoOngoingSubsidyTotal) {
		q23BA04RentalByClientNoOngoingSubsidyTotal = q23ba04RentalByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ23BA04RentalByClientNoOngoingSubsidyWithoutChild() {
		return q23BA04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ23BA04RentalByClientNoOngoingSubsidyWithoutChild(
			BigInteger q23ba04RentalByClientNoOngoingSubsidyWithoutChild) {
		q23BA04RentalByClientNoOngoingSubsidyWithoutChild = q23ba04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults() {
		return q23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q23ba04RentalByClientNoOngoingSubsidyWithChildAndAdults) {
		q23BA04RentalByClientNoOngoingSubsidyWithChildAndAdults = q23ba04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23BA04RentalByClientNoOngoingSubsidyWithOnlyChild() {
		return q23BA04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ23BA04RentalByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q23ba04RentalByClientNoOngoingSubsidyWithOnlyChild) {
		q23BA04RentalByClientNoOngoingSubsidyWithOnlyChild = q23ba04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold() {
		return q23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q23ba04RentalByClientNoOngoingSubsidyUnknownHouseHold) {
		q23BA04RentalByClientNoOngoingSubsidyUnknownHouseHold = q23ba04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23BA05RentalByClientVASHSubsidyTotal() {
		return q23BA05RentalByClientVASHSubsidyTotal;
	}

	public void setQ23BA05RentalByClientVASHSubsidyTotal(
			BigInteger q23ba05RentalByClientVASHSubsidyTotal) {
		q23BA05RentalByClientVASHSubsidyTotal = q23ba05RentalByClientVASHSubsidyTotal;
	}

	public BigInteger getQ23BA05RentalByClientVASHSubsidyWithoutChild() {
		return q23BA05RentalByClientVASHSubsidyWithoutChild;
	}

	public void setQ23BA05RentalByClientVASHSubsidyWithoutChild(
			BigInteger q23ba05RentalByClientVASHSubsidyWithoutChild) {
		q23BA05RentalByClientVASHSubsidyWithoutChild = q23ba05RentalByClientVASHSubsidyWithoutChild;
	}

	public BigInteger getQ23BA05RentalByClientVASHSubsidyWithChildAndAdults() {
		return q23BA05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public void setQ23BA05RentalByClientVASHSubsidyWithChildAndAdults(
			BigInteger q23ba05RentalByClientVASHSubsidyWithChildAndAdults) {
		q23BA05RentalByClientVASHSubsidyWithChildAndAdults = q23ba05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23BA05RentalByClientVASHSubsidyWithOnlyChild() {
		return q23BA05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public void setQ23BA05RentalByClientVASHSubsidyWithOnlyChild(
			BigInteger q23ba05RentalByClientVASHSubsidyWithOnlyChild) {
		q23BA05RentalByClientVASHSubsidyWithOnlyChild = q23ba05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public BigInteger getQ23BA05RentalByClientVASHSubsidyUnknownHouseHold() {
		return q23BA05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public void setQ23BA05RentalByClientVASHSubsidyUnknownHouseHold(
			BigInteger q23ba05RentalByClientVASHSubsidyUnknownHouseHold) {
		q23BA05RentalByClientVASHSubsidyUnknownHouseHold = q23ba05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23BA06RentalByClientwithGPDTIPHousingTotal() {
		return q23BA06RentalByClientwithGPDTIPHousingTotal;
	}

	public void setQ23BA06RentalByClientwithGPDTIPHousingTotal(
			BigInteger q23ba06RentalByClientwithGPDTIPHousingTotal) {
		q23BA06RentalByClientwithGPDTIPHousingTotal = q23ba06RentalByClientwithGPDTIPHousingTotal;
	}

	public BigInteger getQ23BA06RentalByClientwithGPDTIPHousingWithoutChild() {
		return q23BA06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public void setQ23BA06RentalByClientwithGPDTIPHousingWithoutChild(
			BigInteger q23ba06RentalByClientwithGPDTIPHousingWithoutChild) {
		q23BA06RentalByClientwithGPDTIPHousingWithoutChild = q23ba06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public BigInteger getQ23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults() {
		return q23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public void setQ23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults(
			BigInteger q23ba06RentalByClientwithGPDTIPHousingWithChildAndAdults) {
		q23BA06RentalByClientwithGPDTIPHousingWithChildAndAdults = q23ba06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public BigInteger getQ23BA06RentalByClientwithGPDTIPHousingWithOnlyChild() {
		return q23BA06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public void setQ23BA06RentalByClientwithGPDTIPHousingWithOnlyChild(
			BigInteger q23ba06RentalByClientwithGPDTIPHousingWithOnlyChild) {
		q23BA06RentalByClientwithGPDTIPHousingWithOnlyChild = q23ba06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public BigInteger getQ23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold() {
		return q23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public void setQ23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold(
			BigInteger q23ba06RentalByClientwithGPDTIPHousingUnknownHouseHold) {
		q23BA06RentalByClientwithGPDTIPHousingUnknownHouseHold = q23ba06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public BigInteger getQ23BA07RentalByClientOtherOngoingSubsidyTotal() {
		return q23BA07RentalByClientOtherOngoingSubsidyTotal;
	}

	public void setQ23BA07RentalByClientOtherOngoingSubsidyTotal(
			BigInteger q23ba07RentalByClientOtherOngoingSubsidyTotal) {
		q23BA07RentalByClientOtherOngoingSubsidyTotal = q23ba07RentalByClientOtherOngoingSubsidyTotal;
	}

	public BigInteger getQ23BA07RentalByClientOtherOngoingSubsidyWithoutChild() {
		return q23BA07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public void setQ23BA07RentalByClientOtherOngoingSubsidyWithoutChild(
			BigInteger q23ba07RentalByClientOtherOngoingSubsidyWithoutChild) {
		q23BA07RentalByClientOtherOngoingSubsidyWithoutChild = q23ba07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults() {
		return q23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults(
			BigInteger q23ba07RentalByClientOtherOngoingSubsidyWithChildAndAdults) {
		q23BA07RentalByClientOtherOngoingSubsidyWithChildAndAdults = q23ba07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild() {
		return q23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public void setQ23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild(
			BigInteger q23ba07RentalByClientOtherOngoingSubsidyWithOnlyChild) {
		q23BA07RentalByClientOtherOngoingSubsidyWithOnlyChild = q23ba07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold() {
		return q23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold(
			BigInteger q23ba07RentalByClientOtherOngoingSubsidyUnknownHouseHold) {
		q23BA07RentalByClientOtherOngoingSubsidyUnknownHouseHold = q23ba07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23BA08PermanentHousingForHomelessTotal() {
		return q23BA08PermanentHousingForHomelessTotal;
	}

	public void setQ23BA08PermanentHousingForHomelessTotal(
			BigInteger q23ba08PermanentHousingForHomelessTotal) {
		q23BA08PermanentHousingForHomelessTotal = q23ba08PermanentHousingForHomelessTotal;
	}

	public BigInteger getQ23BA08PermanentHousingForHomelessWithoutChild() {
		return q23BA08PermanentHousingForHomelessWithoutChild;
	}

	public void setQ23BA08PermanentHousingForHomelessWithoutChild(
			BigInteger q23ba08PermanentHousingForHomelessWithoutChild) {
		q23BA08PermanentHousingForHomelessWithoutChild = q23ba08PermanentHousingForHomelessWithoutChild;
	}

	public BigInteger getQ23BA08PermanentHousingForHomelessWithChildAndAdults() {
		return q23BA08PermanentHousingForHomelessWithChildAndAdults;
	}

	public void setQ23BA08PermanentHousingForHomelessWithChildAndAdults(
			BigInteger q23ba08PermanentHousingForHomelessWithChildAndAdults) {
		q23BA08PermanentHousingForHomelessWithChildAndAdults = q23ba08PermanentHousingForHomelessWithChildAndAdults;
	}

	public BigInteger getQ23BA08PermanentHousingForHomelessWithOnlyChild() {
		return q23BA08PermanentHousingForHomelessWithOnlyChild;
	}

	public void setQ23BA08PermanentHousingForHomelessWithOnlyChild(
			BigInteger q23ba08PermanentHousingForHomelessWithOnlyChild) {
		q23BA08PermanentHousingForHomelessWithOnlyChild = q23ba08PermanentHousingForHomelessWithOnlyChild;
	}

	public BigInteger getQ23BA08PermanentHousingForHomelessUnknownHouseHold() {
		return q23BA08PermanentHousingForHomelessUnknownHouseHold;
	}

	public void setQ23BA08PermanentHousingForHomelessUnknownHouseHold(
			BigInteger q23ba08PermanentHousingForHomelessUnknownHouseHold) {
		q23BA08PermanentHousingForHomelessUnknownHouseHold = q23ba08PermanentHousingForHomelessUnknownHouseHold;
	}

	public BigInteger getQ23BA09StayingOrLivingWithFamilyPermanentTotal() {
		return q23BA09StayingOrLivingWithFamilyPermanentTotal;
	}

	public void setQ23BA09StayingOrLivingWithFamilyPermanentTotal(
			BigInteger q23ba09StayingOrLivingWithFamilyPermanentTotal) {
		q23BA09StayingOrLivingWithFamilyPermanentTotal = q23ba09StayingOrLivingWithFamilyPermanentTotal;
	}

	public BigInteger getQ23BA09StayingOrLivingWithFamilyPermanentWithoutChild() {
		return q23BA09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public void setQ23BA09StayingOrLivingWithFamilyPermanentWithoutChild(
			BigInteger q23ba09StayingOrLivingWithFamilyPermanentWithoutChild) {
		q23BA09StayingOrLivingWithFamilyPermanentWithoutChild = q23ba09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public BigInteger getQ23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults() {
		return q23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public void setQ23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults(
			BigInteger q23ba09StayingOrLivingWithFamilyPermanentWithChildAndAdults) {
		q23BA09StayingOrLivingWithFamilyPermanentWithChildAndAdults = q23ba09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public BigInteger getQ23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild() {
		return q23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public void setQ23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild(
			BigInteger q23ba09StayingOrLivingWithFamilyPermanentWithOnlyChild) {
		q23BA09StayingOrLivingWithFamilyPermanentWithOnlyChild = q23ba09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public BigInteger getQ23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold() {
		return q23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public void setQ23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold(
			BigInteger q23ba09StayingOrLivingWithFamilyPermanentUnknownHouseHold) {
		q23BA09StayingOrLivingWithFamilyPermanentUnknownHouseHold = q23ba09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public BigInteger getQ23BA10StayingOrLivingWithFriendsPermanentTotal() {
		return q23BA10StayingOrLivingWithFriendsPermanentTotal;
	}

	public void setQ23BA10StayingOrLivingWithFriendsPermanentTotal(
			BigInteger q23ba10StayingOrLivingWithFriendsPermanentTotal) {
		q23BA10StayingOrLivingWithFriendsPermanentTotal = q23ba10StayingOrLivingWithFriendsPermanentTotal;
	}

	public BigInteger getQ23BA10StayingOrLivingWithFriendsPermanentWithoutChild() {
		return q23BA10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public void setQ23BA10StayingOrLivingWithFriendsPermanentWithoutChild(
			BigInteger q23ba10StayingOrLivingWithFriendsPermanentWithoutChild) {
		q23BA10StayingOrLivingWithFriendsPermanentWithoutChild = q23ba10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public BigInteger getQ23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults() {
		return q23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public void setQ23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults(
			BigInteger q23ba10StayingOrLivingWithFriendsPermanentWithChildAndAdults) {
		q23BA10StayingOrLivingWithFriendsPermanentWithChildAndAdults = q23ba10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public BigInteger getQ23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild() {
		return q23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public void setQ23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild(
			BigInteger q23ba10StayingOrLivingWithFriendsPermanentWithOnlyChild) {
		q23BA10StayingOrLivingWithFriendsPermanentWithOnlyChild = q23ba10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public BigInteger getQ23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold() {
		return q23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public void setQ23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold(
			BigInteger q23ba10StayingOrLivingWithFriendsPermanentUnknownHouseHold) {
		q23BA10StayingOrLivingWithFriendsPermanentUnknownHouseHold = q23ba10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public BigInteger getQ23BAzTotTotal() {
		return q23BAzTotTotal;
	}

	public void setQ23BAzTotTotal(BigInteger q23bAzTotTotal) {
		q23BAzTotTotal = q23bAzTotTotal;
	}

	public BigInteger getQ23BAzTotWithoutChild() {
		return q23BAzTotWithoutChild;
	}

	public void setQ23BAzTotWithoutChild(BigInteger q23bAzTotWithoutChild) {
		q23BAzTotWithoutChild = q23bAzTotWithoutChild;
	}

	public BigInteger getQ23BAzTotWithChildAndAdults() {
		return q23BAzTotWithChildAndAdults;
	}

	public void setQ23BAzTotWithChildAndAdults(
			BigInteger q23bAzTotWithChildAndAdults) {
		q23BAzTotWithChildAndAdults = q23bAzTotWithChildAndAdults;
	}

	public BigInteger getQ23BAzTotWithOnlyChild() {
		return q23BAzTotWithOnlyChild;
	}

	public void setQ23BAzTotWithOnlyChild(BigInteger q23bAzTotWithOnlyChild) {
		q23BAzTotWithOnlyChild = q23bAzTotWithOnlyChild;
	}

	public BigInteger getQ23BAzTotUnknownHouseHold() {
		return q23BAzTotUnknownHouseHold;
	}

	public void setQ23BAzTotUnknownHouseHold(BigInteger q23bAzTotUnknownHouseHold) {
		q23BAzTotUnknownHouseHold = q23bAzTotUnknownHouseHold;
	}

	public BigInteger getQ23BBTemporaryDestinationsTotal() {
		return q23BBTemporaryDestinationsTotal;
	}

	public void setQ23BBTemporaryDestinationsTotal(
			BigInteger q23bbTemporaryDestinationsTotal) {
		q23BBTemporaryDestinationsTotal = q23bbTemporaryDestinationsTotal;
	}

	public BigInteger getQ23BBTemporaryDestinationsWithoutChild() {
		return q23BBTemporaryDestinationsWithoutChild;
	}

	public void setQ23BBTemporaryDestinationsWithoutChild(
			BigInteger q23bbTemporaryDestinationsWithoutChild) {
		q23BBTemporaryDestinationsWithoutChild = q23bbTemporaryDestinationsWithoutChild;
	}

	public BigInteger getQ23BBTemporaryDestinationsWithChildAndAdults() {
		return q23BBTemporaryDestinationsWithChildAndAdults;
	}

	public void setQ23BBTemporaryDestinationsWithChildAndAdults(
			BigInteger q23bbTemporaryDestinationsWithChildAndAdults) {
		q23BBTemporaryDestinationsWithChildAndAdults = q23bbTemporaryDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23BBTemporaryDestinationsWithOnlyChild() {
		return q23BBTemporaryDestinationsWithOnlyChild;
	}

	public void setQ23BBTemporaryDestinationsWithOnlyChild(
			BigInteger q23bbTemporaryDestinationsWithOnlyChild) {
		q23BBTemporaryDestinationsWithOnlyChild = q23bbTemporaryDestinationsWithOnlyChild;
	}

	public BigInteger getQ23BBTemporaryDestinationsUnknownHouseHold() {
		return q23BBTemporaryDestinationsUnknownHouseHold;
	}

	public void setQ23BBTemporaryDestinationsUnknownHouseHold(
			BigInteger q23bbTemporaryDestinationsUnknownHouseHold) {
		q23BBTemporaryDestinationsUnknownHouseHold = q23bbTemporaryDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23BB1EmergencyShelterTotal() {
		return q23BB1EmergencyShelterTotal;
	}

	public void setQ23BB1EmergencyShelterTotal(
			BigInteger q23bb1EmergencyShelterTotal) {
		q23BB1EmergencyShelterTotal = q23bb1EmergencyShelterTotal;
	}

	public BigInteger getQ23BB1EmergencyShelterWithoutChild() {
		return q23BB1EmergencyShelterWithoutChild;
	}

	public void setQ23BB1EmergencyShelterWithoutChild(
			BigInteger q23bb1EmergencyShelterWithoutChild) {
		q23BB1EmergencyShelterWithoutChild = q23bb1EmergencyShelterWithoutChild;
	}

	public BigInteger getQ23BB1EmergencyShelterWithChildAndAdults() {
		return q23BB1EmergencyShelterWithChildAndAdults;
	}

	public void setQ23BB1EmergencyShelterWithChildAndAdults(
			BigInteger q23bb1EmergencyShelterWithChildAndAdults) {
		q23BB1EmergencyShelterWithChildAndAdults = q23bb1EmergencyShelterWithChildAndAdults;
	}

	public BigInteger getQ23BB1EmergencyShelterWithOnlyChild() {
		return q23BB1EmergencyShelterWithOnlyChild;
	}

	public void setQ23BB1EmergencyShelterWithOnlyChild(
			BigInteger q23bb1EmergencyShelterWithOnlyChild) {
		q23BB1EmergencyShelterWithOnlyChild = q23bb1EmergencyShelterWithOnlyChild;
	}

	public BigInteger getQ23BB1EmergencyShelterUnknownHouseHold() {
		return q23BB1EmergencyShelterUnknownHouseHold;
	}

	public void setQ23BB1EmergencyShelterUnknownHouseHold(
			BigInteger q23bb1EmergencyShelterUnknownHouseHold) {
		q23BB1EmergencyShelterUnknownHouseHold = q23bb1EmergencyShelterUnknownHouseHold;
	}

	public BigInteger getQ23BB2MovedFromOneHOPWATotal() {
		return q23BB2MovedFromOneHOPWATotal;
	}

	public void setQ23BB2MovedFromOneHOPWATotal(
			BigInteger q23bb2MovedFromOneHOPWATotal) {
		q23BB2MovedFromOneHOPWATotal = q23bb2MovedFromOneHOPWATotal;
	}

	public BigInteger getQ23BB2MovedFromOneHOPWAWithoutChild() {
		return q23BB2MovedFromOneHOPWAWithoutChild;
	}

	public void setQ23BB2MovedFromOneHOPWAWithoutChild(
			BigInteger q23bb2MovedFromOneHOPWAWithoutChild) {
		q23BB2MovedFromOneHOPWAWithoutChild = q23bb2MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ23BB2MovedFromOneHOPWAWithChildAndAdults() {
		return q23BB2MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ23BB2MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q23bb2MovedFromOneHOPWAWithChildAndAdults) {
		q23BB2MovedFromOneHOPWAWithChildAndAdults = q23bb2MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ23BB2MovedFromOneHOPWAWithOnlyChild() {
		return q23BB2MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ23BB2MovedFromOneHOPWAWithOnlyChild(
			BigInteger q23bb2MovedFromOneHOPWAWithOnlyChild) {
		q23BB2MovedFromOneHOPWAWithOnlyChild = q23bb2MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ23BB2MovedFromOneHOPWAUnknownHouseHold() {
		return q23BB2MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ23BB2MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q23bb2MovedFromOneHOPWAUnknownHouseHold) {
		q23BB2MovedFromOneHOPWAUnknownHouseHold = q23bb2MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ23BB3TransitionalHousingForHomeLessTotal() {
		return q23BB3TransitionalHousingForHomeLessTotal;
	}

	public void setQ23BB3TransitionalHousingForHomeLessTotal(
			BigInteger q23bb3TransitionalHousingForHomeLessTotal) {
		q23BB3TransitionalHousingForHomeLessTotal = q23bb3TransitionalHousingForHomeLessTotal;
	}

	public BigInteger getQ23BB3TransitionalHousingForHomeLessWithoutChild() {
		return q23BB3TransitionalHousingForHomeLessWithoutChild;
	}

	public void setQ23BB3TransitionalHousingForHomeLessWithoutChild(
			BigInteger q23bb3TransitionalHousingForHomeLessWithoutChild) {
		q23BB3TransitionalHousingForHomeLessWithoutChild = q23bb3TransitionalHousingForHomeLessWithoutChild;
	}

	public BigInteger getQ23BB3TransitionalHousingForHomeLessWithChildAndAdults() {
		return q23BB3TransitionalHousingForHomeLessWithChildAndAdults;
	}

	public void setQ23BB3TransitionalHousingForHomeLessWithChildAndAdults(
			BigInteger q23bb3TransitionalHousingForHomeLessWithChildAndAdults) {
		q23BB3TransitionalHousingForHomeLessWithChildAndAdults = q23bb3TransitionalHousingForHomeLessWithChildAndAdults;
	}

	public BigInteger getQ23BB3TransitionalHousingForHomeLessWithOnlyChild() {
		return q23BB3TransitionalHousingForHomeLessWithOnlyChild;
	}

	public void setQ23BB3TransitionalHousingForHomeLessWithOnlyChild(
			BigInteger q23bb3TransitionalHousingForHomeLessWithOnlyChild) {
		q23BB3TransitionalHousingForHomeLessWithOnlyChild = q23bb3TransitionalHousingForHomeLessWithOnlyChild;
	}

	public BigInteger getQ23BB3TransitionalHousingForHomeLessUnknownHouseHold() {
		return q23BB3TransitionalHousingForHomeLessUnknownHouseHold;
	}

	public void setQ23BB3TransitionalHousingForHomeLessUnknownHouseHold(
			BigInteger q23bb3TransitionalHousingForHomeLessUnknownHouseHold) {
		q23BB3TransitionalHousingForHomeLessUnknownHouseHold = q23bb3TransitionalHousingForHomeLessUnknownHouseHold;
	}

	public BigInteger getQ23BB4StayingWithFamilyTemporaryTenureTotal() {
		return q23BB4StayingWithFamilyTemporaryTenureTotal;
	}

	public void setQ23BB4StayingWithFamilyTemporaryTenureTotal(
			BigInteger q23bb4StayingWithFamilyTemporaryTenureTotal) {
		q23BB4StayingWithFamilyTemporaryTenureTotal = q23bb4StayingWithFamilyTemporaryTenureTotal;
	}

	public BigInteger getQ23BB4StayingWithFamilyTemporaryTenureWithoutChild() {
		return q23BB4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public void setQ23BB4StayingWithFamilyTemporaryTenureWithoutChild(
			BigInteger q23bb4StayingWithFamilyTemporaryTenureWithoutChild) {
		q23BB4StayingWithFamilyTemporaryTenureWithoutChild = q23bb4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public BigInteger getQ23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults() {
		return q23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public void setQ23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults(
			BigInteger q23bb4StayingWithFamilyTemporaryTenureWithChildAndAdults) {
		q23BB4StayingWithFamilyTemporaryTenureWithChildAndAdults = q23bb4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ23BB4StayingWithFamilyTemporaryTenureWithOnlyChild() {
		return q23BB4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public void setQ23BB4StayingWithFamilyTemporaryTenureWithOnlyChild(
			BigInteger q23bb4StayingWithFamilyTemporaryTenureWithOnlyChild) {
		q23BB4StayingWithFamilyTemporaryTenureWithOnlyChild = q23bb4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold() {
		return q23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public void setQ23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold(
			BigInteger q23bb4StayingWithFamilyTemporaryTenureUnknownHouseHold) {
		q23BB4StayingWithFamilyTemporaryTenureUnknownHouseHold = q23bb4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ23BB5StayingWithFriendsTemporaryTenureTotal() {
		return q23BB5StayingWithFriendsTemporaryTenureTotal;
	}

	public void setQ23BB5StayingWithFriendsTemporaryTenureTotal(
			BigInteger q23bb5StayingWithFriendsTemporaryTenureTotal) {
		q23BB5StayingWithFriendsTemporaryTenureTotal = q23bb5StayingWithFriendsTemporaryTenureTotal;
	}

	public BigInteger getQ23BB5StayingWithFriendsTemporaryTenureWithoutChild() {
		return q23BB5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public void setQ23BB5StayingWithFriendsTemporaryTenureWithoutChild(
			BigInteger q23bb5StayingWithFriendsTemporaryTenureWithoutChild) {
		q23BB5StayingWithFriendsTemporaryTenureWithoutChild = q23bb5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public BigInteger getQ23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults() {
		return q23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public void setQ23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults(
			BigInteger q23bb5StayingWithFriendsTemporaryTenureWithChildAndAdults) {
		q23BB5StayingWithFriendsTemporaryTenureWithChildAndAdults = q23bb5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ23BB5StayingWithFriendsTemporaryTenureWithOnlyChild() {
		return q23BB5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public void setQ23BB5StayingWithFriendsTemporaryTenureWithOnlyChild(
			BigInteger q23bb5StayingWithFriendsTemporaryTenureWithOnlyChild) {
		q23BB5StayingWithFriendsTemporaryTenureWithOnlyChild = q23bb5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold() {
		return q23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public void setQ23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold(
			BigInteger q23bb5StayingWithFriendsTemporaryTenureUnknownHouseHold) {
		q23BB5StayingWithFriendsTemporaryTenureUnknownHouseHold = q23bb5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ23BB6PlaceNotMeantForHumanHabitationTotal() {
		return q23BB6PlaceNotMeantForHumanHabitationTotal;
	}

	public void setQ23BB6PlaceNotMeantForHumanHabitationTotal(
			BigInteger q23bb6PlaceNotMeantForHumanHabitationTotal) {
		q23BB6PlaceNotMeantForHumanHabitationTotal = q23bb6PlaceNotMeantForHumanHabitationTotal;
	}

	public BigInteger getQ23BB6PlaceNotMeantForHumanHabitationWithoutChild() {
		return q23BB6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public void setQ23BB6PlaceNotMeantForHumanHabitationWithoutChild(
			BigInteger q23bb6PlaceNotMeantForHumanHabitationWithoutChild) {
		q23BB6PlaceNotMeantForHumanHabitationWithoutChild = q23bb6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public BigInteger getQ23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults() {
		return q23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public void setQ23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults(
			BigInteger q23bb6PlaceNotMeantForHumanHabitationWithChildAndAdults) {
		q23BB6PlaceNotMeantForHumanHabitationWithChildAndAdults = q23bb6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public BigInteger getQ23BB6PlaceNotMeantForHumanHabitationWithOnlyChild() {
		return q23BB6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public void setQ23BB6PlaceNotMeantForHumanHabitationWithOnlyChild(
			BigInteger q23bb6PlaceNotMeantForHumanHabitationWithOnlyChild) {
		q23BB6PlaceNotMeantForHumanHabitationWithOnlyChild = q23bb6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public BigInteger getQ23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold() {
		return q23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public void setQ23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold(
			BigInteger q23bb6PlaceNotMeantForHumanHabitationUnknownHouseHold) {
		q23BB6PlaceNotMeantForHumanHabitationUnknownHouseHold = q23bb6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public BigInteger getQ23BB7SafeHavenTotal() {
		return q23BB7SafeHavenTotal;
	}

	public void setQ23BB7SafeHavenTotal(BigInteger q23bb7SafeHavenTotal) {
		q23BB7SafeHavenTotal = q23bb7SafeHavenTotal;
	}

	public BigInteger getQ23BB7SafeHavenWithoutChild() {
		return q23BB7SafeHavenWithoutChild;
	}

	public void setQ23BB7SafeHavenWithoutChild(
			BigInteger q23bb7SafeHavenWithoutChild) {
		q23BB7SafeHavenWithoutChild = q23bb7SafeHavenWithoutChild;
	}

	public BigInteger getQ23BB7SafeHavenWithChildAndAdults() {
		return q23BB7SafeHavenWithChildAndAdults;
	}

	public void setQ23BB7SafeHavenWithChildAndAdults(
			BigInteger q23bb7SafeHavenWithChildAndAdults) {
		q23BB7SafeHavenWithChildAndAdults = q23bb7SafeHavenWithChildAndAdults;
	}

	public BigInteger getQ23BB7SafeHavenWithOnlyChild() {
		return q23BB7SafeHavenWithOnlyChild;
	}

	public void setQ23BB7SafeHavenWithOnlyChild(
			BigInteger q23bb7SafeHavenWithOnlyChild) {
		q23BB7SafeHavenWithOnlyChild = q23bb7SafeHavenWithOnlyChild;
	}

	public BigInteger getQ23BB7SafeHavenUnknownHouseHold() {
		return q23BB7SafeHavenUnknownHouseHold;
	}

	public void setQ23BB7SafeHavenUnknownHouseHold(
			BigInteger q23bb7SafeHavenUnknownHouseHold) {
		q23BB7SafeHavenUnknownHouseHold = q23bb7SafeHavenUnknownHouseHold;
	}

	public BigInteger getQ23BB8HotelOrMotelPaidByClientTotal() {
		return q23BB8HotelOrMotelPaidByClientTotal;
	}

	public void setQ23BB8HotelOrMotelPaidByClientTotal(
			BigInteger q23bb8HotelOrMotelPaidByClientTotal) {
		q23BB8HotelOrMotelPaidByClientTotal = q23bb8HotelOrMotelPaidByClientTotal;
	}

	public BigInteger getQ23BB8HotelOrMotelPaidByClientWithoutChild() {
		return q23BB8HotelOrMotelPaidByClientWithoutChild;
	}

	public void setQ23BB8HotelOrMotelPaidByClientWithoutChild(
			BigInteger q23bb8HotelOrMotelPaidByClientWithoutChild) {
		q23BB8HotelOrMotelPaidByClientWithoutChild = q23bb8HotelOrMotelPaidByClientWithoutChild;
	}

	public BigInteger getQ23BB8HotelOrMotelPaidByClientWithChildAndAdults() {
		return q23BB8HotelOrMotelPaidByClientWithChildAndAdults;
	}

	public void setQ23BB8HotelOrMotelPaidByClientWithChildAndAdults(
			BigInteger q23bb8HotelOrMotelPaidByClientWithChildAndAdults) {
		q23BB8HotelOrMotelPaidByClientWithChildAndAdults = q23bb8HotelOrMotelPaidByClientWithChildAndAdults;
	}

	public BigInteger getQ23BB8HotelOrMotelPaidByClientWithOnlyChild() {
		return q23BB8HotelOrMotelPaidByClientWithOnlyChild;
	}

	public void setQ23BB8HotelOrMotelPaidByClientWithOnlyChild(
			BigInteger q23bb8HotelOrMotelPaidByClientWithOnlyChild) {
		q23BB8HotelOrMotelPaidByClientWithOnlyChild = q23bb8HotelOrMotelPaidByClientWithOnlyChild;
	}

	public BigInteger getQ23BB8HotelOrMotelPaidByClientUnknownHouseHold() {
		return q23BB8HotelOrMotelPaidByClientUnknownHouseHold;
	}

	public void setQ23BB8HotelOrMotelPaidByClientUnknownHouseHold(
			BigInteger q23bb8HotelOrMotelPaidByClientUnknownHouseHold) {
		q23BB8HotelOrMotelPaidByClientUnknownHouseHold = q23bb8HotelOrMotelPaidByClientUnknownHouseHold;
	}

	public BigInteger getQ23BBzTotTotal() {
		return q23BBzTotTotal;
	}

	public void setQ23BBzTotTotal(BigInteger q23bBzTotTotal) {
		q23BBzTotTotal = q23bBzTotTotal;
	}

	public BigInteger getQ23BBzTotWithoutChild() {
		return q23BBzTotWithoutChild;
	}

	public void setQ23BBzTotWithoutChild(BigInteger q23bBzTotWithoutChild) {
		q23BBzTotWithoutChild = q23bBzTotWithoutChild;
	}

	public BigInteger getQ23BBzTotWithChildAndAdults() {
		return q23BBzTotWithChildAndAdults;
	}

	public void setQ23BBzTotWithChildAndAdults(
			BigInteger q23bBzTotWithChildAndAdults) {
		q23BBzTotWithChildAndAdults = q23bBzTotWithChildAndAdults;
	}

	public BigInteger getQ23BBzTotWithOnlyChild() {
		return q23BBzTotWithOnlyChild;
	}

	public void setQ23BBzTotWithOnlyChild(BigInteger q23bBzTotWithOnlyChild) {
		q23BBzTotWithOnlyChild = q23bBzTotWithOnlyChild;
	}

	public BigInteger getQ23BBzTotUnknownHouseHold() {
		return q23BBzTotUnknownHouseHold;
	}

	public void setQ23BBzTotUnknownHouseHold(BigInteger q23bBzTotUnknownHouseHold) {
		q23BBzTotUnknownHouseHold = q23bBzTotUnknownHouseHold;
	}

	public BigInteger getQ23BCInstitutionalSettingsTotal() {
		return q23BCInstitutionalSettingsTotal;
	}

	public void setQ23BCInstitutionalSettingsTotal(
			BigInteger q23bcInstitutionalSettingsTotal) {
		q23BCInstitutionalSettingsTotal = q23bcInstitutionalSettingsTotal;
	}

	public BigInteger getQ23BCInstitutionalSettingsWithoutChild() {
		return q23BCInstitutionalSettingsWithoutChild;
	}

	public void setQ23BCInstitutionalSettingsWithoutChild(
			BigInteger q23bcInstitutionalSettingsWithoutChild) {
		q23BCInstitutionalSettingsWithoutChild = q23bcInstitutionalSettingsWithoutChild;
	}

	public BigInteger getQ23BCInstitutionalSettingsWithChildAndAdults() {
		return q23BCInstitutionalSettingsWithChildAndAdults;
	}

	public void setQ23BCInstitutionalSettingsWithChildAndAdults(
			BigInteger q23bcInstitutionalSettingsWithChildAndAdults) {
		q23BCInstitutionalSettingsWithChildAndAdults = q23bcInstitutionalSettingsWithChildAndAdults;
	}

	public BigInteger getQ23BCInstitutionalSettingsWithOnlyChild() {
		return q23BCInstitutionalSettingsWithOnlyChild;
	}

	public void setQ23BCInstitutionalSettingsWithOnlyChild(
			BigInteger q23bcInstitutionalSettingsWithOnlyChild) {
		q23BCInstitutionalSettingsWithOnlyChild = q23bcInstitutionalSettingsWithOnlyChild;
	}

	public BigInteger getQ23BCInstitutionalSettingsUnknownHouseHold() {
		return q23BCInstitutionalSettingsUnknownHouseHold;
	}

	public void setQ23BCInstitutionalSettingsUnknownHouseHold(
			BigInteger q23bcInstitutionalSettingsUnknownHouseHold) {
		q23BCInstitutionalSettingsUnknownHouseHold = q23bcInstitutionalSettingsUnknownHouseHold;
	}

	public BigInteger getQ23BC1FosterCareHomeOrGroupFosterCareTotal() {
		return q23BC1FosterCareHomeOrGroupFosterCareTotal;
	}

	public void setQ23BC1FosterCareHomeOrGroupFosterCareTotal(
			BigInteger q23bc1FosterCareHomeOrGroupFosterCareTotal) {
		q23BC1FosterCareHomeOrGroupFosterCareTotal = q23bc1FosterCareHomeOrGroupFosterCareTotal;
	}

	public BigInteger getQ23BC1FosterCareHomeOrGroupFosterCareWithoutChild() {
		return q23BC1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public void setQ23BC1FosterCareHomeOrGroupFosterCareWithoutChild(
			BigInteger q23bc1FosterCareHomeOrGroupFosterCareWithoutChild) {
		q23BC1FosterCareHomeOrGroupFosterCareWithoutChild = q23bc1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public BigInteger getQ23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults() {
		return q23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public void setQ23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults(
			BigInteger q23bc1FosterCareHomeOrGroupFosterCareWithChildAndAdults) {
		q23BC1FosterCareHomeOrGroupFosterCareWithChildAndAdults = q23bc1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public BigInteger getQ23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild() {
		return q23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public void setQ23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild(
			BigInteger q23bc1FosterCareHomeOrGroupFosterCareWithOnlyChild) {
		q23BC1FosterCareHomeOrGroupFosterCareWithOnlyChild = q23bc1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public BigInteger getQ23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold() {
		return q23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public void setQ23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold(
			BigInteger q23bc1FosterCareHomeOrGroupFosterCareUnknownHouseHold) {
		q23BC1FosterCareHomeOrGroupFosterCareUnknownHouseHold = q23bc1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public BigInteger getQ23BC2PsychiatricHospitalOrOtherTotal() {
		return q23BC2PsychiatricHospitalOrOtherTotal;
	}

	public void setQ23BC2PsychiatricHospitalOrOtherTotal(
			BigInteger q23bc2PsychiatricHospitalOrOtherTotal) {
		q23BC2PsychiatricHospitalOrOtherTotal = q23bc2PsychiatricHospitalOrOtherTotal;
	}

	public BigInteger getQ23BC2PsychiatricHospitalOrOtherWithoutChild() {
		return q23BC2PsychiatricHospitalOrOtherWithoutChild;
	}

	public void setQ23BC2PsychiatricHospitalOrOtherWithoutChild(
			BigInteger q23bc2PsychiatricHospitalOrOtherWithoutChild) {
		q23BC2PsychiatricHospitalOrOtherWithoutChild = q23bc2PsychiatricHospitalOrOtherWithoutChild;
	}

	public BigInteger getQ23BC2PsychiatricHospitalOrOtherWithChildAndAdults() {
		return q23BC2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public void setQ23BC2PsychiatricHospitalOrOtherWithChildAndAdults(
			BigInteger q23bc2PsychiatricHospitalOrOtherWithChildAndAdults) {
		q23BC2PsychiatricHospitalOrOtherWithChildAndAdults = q23bc2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public BigInteger getQ23BC2PsychiatricHospitalOrOtherWithOnlyChild() {
		return q23BC2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public void setQ23BC2PsychiatricHospitalOrOtherWithOnlyChild(
			BigInteger q23bc2PsychiatricHospitalOrOtherWithOnlyChild) {
		q23BC2PsychiatricHospitalOrOtherWithOnlyChild = q23bc2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public BigInteger getQ23BC2PsychiatricHospitalOrOtherUnknownHouseHold() {
		return q23BC2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public void setQ23BC2PsychiatricHospitalOrOtherUnknownHouseHold(
			BigInteger q23bc2PsychiatricHospitalOrOtherUnknownHouseHold) {
		q23BC2PsychiatricHospitalOrOtherUnknownHouseHold = q23bc2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public BigInteger getQ23BC3SubstanceAbuseTreatmentFacilityTotal() {
		return q23BC3SubstanceAbuseTreatmentFacilityTotal;
	}

	public void setQ23BC3SubstanceAbuseTreatmentFacilityTotal(
			BigInteger q23bc3SubstanceAbuseTreatmentFacilityTotal) {
		q23BC3SubstanceAbuseTreatmentFacilityTotal = q23bc3SubstanceAbuseTreatmentFacilityTotal;
	}

	public BigInteger getQ23BC3SubstanceAbuseTreatmentFacilityWithoutChild() {
		return q23BC3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public void setQ23BC3SubstanceAbuseTreatmentFacilityWithoutChild(
			BigInteger q23bc3SubstanceAbuseTreatmentFacilityWithoutChild) {
		q23BC3SubstanceAbuseTreatmentFacilityWithoutChild = q23bc3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public BigInteger getQ23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults() {
		return q23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public void setQ23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults(
			BigInteger q23bc3SubstanceAbuseTreatmentFacilityWithChildAndAdults) {
		q23BC3SubstanceAbuseTreatmentFacilityWithChildAndAdults = q23bc3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public BigInteger getQ23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild() {
		return q23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public void setQ23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild(
			BigInteger q23bc3SubstanceAbuseTreatmentFacilityWithOnlyChild) {
		q23BC3SubstanceAbuseTreatmentFacilityWithOnlyChild = q23bc3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public BigInteger getQ23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold() {
		return q23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public void setQ23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold(
			BigInteger q23bc3SubstanceAbuseTreatmentFacilityUnknownHouseHold) {
		q23BC3SubstanceAbuseTreatmentFacilityUnknownHouseHold = q23bc3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public BigInteger getQ23BC4HospitalOrOtherTotal() {
		return q23BC4HospitalOrOtherTotal;
	}

	public void setQ23BC4HospitalOrOtherTotal(BigInteger q23bc4HospitalOrOtherTotal) {
		q23BC4HospitalOrOtherTotal = q23bc4HospitalOrOtherTotal;
	}

	public BigInteger getQ23BC4HospitalOrOtherWithoutChild() {
		return q23BC4HospitalOrOtherWithoutChild;
	}

	public void setQ23BC4HospitalOrOtherWithoutChild(
			BigInteger q23bc4HospitalOrOtherWithoutChild) {
		q23BC4HospitalOrOtherWithoutChild = q23bc4HospitalOrOtherWithoutChild;
	}

	public BigInteger getQ23BC4HospitalOrOtherWithChildAndAdults() {
		return q23BC4HospitalOrOtherWithChildAndAdults;
	}

	public void setQ23BC4HospitalOrOtherWithChildAndAdults(
			BigInteger q23bc4HospitalOrOtherWithChildAndAdults) {
		q23BC4HospitalOrOtherWithChildAndAdults = q23bc4HospitalOrOtherWithChildAndAdults;
	}

	public BigInteger getQ23BC4HospitalOrOtherWithOnlyChild() {
		return q23BC4HospitalOrOtherWithOnlyChild;
	}

	public void setQ23BC4HospitalOrOtherWithOnlyChild(
			BigInteger q23bc4HospitalOrOtherWithOnlyChild) {
		q23BC4HospitalOrOtherWithOnlyChild = q23bc4HospitalOrOtherWithOnlyChild;
	}

	public BigInteger getQ23BC4HospitalOrOtherUnknownHouseHold() {
		return q23BC4HospitalOrOtherUnknownHouseHold;
	}

	public void setQ23BC4HospitalOrOtherUnknownHouseHold(
			BigInteger q23bc4HospitalOrOtherUnknownHouseHold) {
		q23BC4HospitalOrOtherUnknownHouseHold = q23bc4HospitalOrOtherUnknownHouseHold;
	}

	public BigInteger getQ23BC5JailPrisonOrJuvenileDetentionTotal() {
		return q23BC5JailPrisonOrJuvenileDetentionTotal;
	}

	public void setQ23BC5JailPrisonOrJuvenileDetentionTotal(
			BigInteger q23bc5JailPrisonOrJuvenileDetentionTotal) {
		q23BC5JailPrisonOrJuvenileDetentionTotal = q23bc5JailPrisonOrJuvenileDetentionTotal;
	}

	public BigInteger getQ23BC5JailPrisonOrJuvenileDetentionWithoutChild() {
		return q23BC5JailPrisonOrJuvenileDetentionWithoutChild;
	}

	public void setQ23BC5JailPrisonOrJuvenileDetentionWithoutChild(
			BigInteger q23bc5JailPrisonOrJuvenileDetentionWithoutChild) {
		q23BC5JailPrisonOrJuvenileDetentionWithoutChild = q23bc5JailPrisonOrJuvenileDetentionWithoutChild;
	}

	public BigInteger getQ23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults() {
		return q23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	}

	public void setQ23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults(
			BigInteger q23bc5JailPrisonOrJuvenileDetentionWithChildAndAdults) {
		q23BC5JailPrisonOrJuvenileDetentionWithChildAndAdults = q23bc5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	}

	public BigInteger getQ23BC5JailPrisonOrJuvenileDetentionWithOnlyChild() {
		return q23BC5JailPrisonOrJuvenileDetentionWithOnlyChild;
	}

	public void setQ23BC5JailPrisonOrJuvenileDetentionWithOnlyChild(
			BigInteger q23bc5JailPrisonOrJuvenileDetentionWithOnlyChild) {
		q23BC5JailPrisonOrJuvenileDetentionWithOnlyChild = q23bc5JailPrisonOrJuvenileDetentionWithOnlyChild;
	}

	public BigInteger getQ23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold() {
		return q23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold;
	}

	public void setQ23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold(
			BigInteger q23bc5JailPrisonOrJuvenileDetentionUnknownHouseHold) {
		q23BC5JailPrisonOrJuvenileDetentionUnknownHouseHold = q23bc5JailPrisonOrJuvenileDetentionUnknownHouseHold;
	}

	public BigInteger getQ23BC6LongTermCareFacilityOrNursingHomeTotal() {
		return q23BC6LongTermCareFacilityOrNursingHomeTotal;
	}

	public void setQ23BC6LongTermCareFacilityOrNursingHomeTotal(
			BigInteger q23bc6LongTermCareFacilityOrNursingHomeTotal) {
		q23BC6LongTermCareFacilityOrNursingHomeTotal = q23bc6LongTermCareFacilityOrNursingHomeTotal;
	}

	public BigInteger getQ23BC6LongTermCareFacilityOrNursingHomeWithoutChild() {
		return q23BC6LongTermCareFacilityOrNursingHomeWithoutChild;
	}

	public void setQ23BC6LongTermCareFacilityOrNursingHomeWithoutChild(
			BigInteger q23bc6LongTermCareFacilityOrNursingHomeWithoutChild) {
		q23BC6LongTermCareFacilityOrNursingHomeWithoutChild = q23bc6LongTermCareFacilityOrNursingHomeWithoutChild;
	}

	public BigInteger getQ23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults() {
		return q23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	}

	public void setQ23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults(
			BigInteger q23bc6LongTermCareFacilityOrNursingHomeWithChildAndAdults) {
		q23BC6LongTermCareFacilityOrNursingHomeWithChildAndAdults = q23bc6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	}

	public BigInteger getQ23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild() {
		return q23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	}

	public void setQ23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild(
			BigInteger q23bc6LongTermCareFacilityOrNursingHomeWithOnlyChild) {
		q23BC6LongTermCareFacilityOrNursingHomeWithOnlyChild = q23bc6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	}

	public BigInteger getQ23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold() {
		return q23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
	}

	public void setQ23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold(
			BigInteger q23bc6LongTermCareFacilityOrNursingHomeUnknownHouseHold) {
		q23BC6LongTermCareFacilityOrNursingHomeUnknownHouseHold = q23bc6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
	}

	public BigInteger getQ23BCzTotTotal() {
		return q23BCzTotTotal;
	}

	public void setQ23BCzTotTotal(BigInteger q23bCzTotTotal) {
		q23BCzTotTotal = q23bCzTotTotal;
	}

	public BigInteger getQ23BCzTotWithoutChild() {
		return q23BCzTotWithoutChild;
	}

	public void setQ23BCzTotWithoutChild(BigInteger q23bCzTotWithoutChild) {
		q23BCzTotWithoutChild = q23bCzTotWithoutChild;
	}

	public BigInteger getQ23BCzTotWithChildAndAdults() {
		return q23BCzTotWithChildAndAdults;
	}

	public void setQ23BCzTotWithChildAndAdults(
			BigInteger q23bCzTotWithChildAndAdults) {
		q23BCzTotWithChildAndAdults = q23bCzTotWithChildAndAdults;
	}

	public BigInteger getQ23BCzTotWithOnlyChild() {
		return q23BCzTotWithOnlyChild;
	}

	public void setQ23BCzTotWithOnlyChild(BigInteger q23bCzTotWithOnlyChild) {
		q23BCzTotWithOnlyChild = q23bCzTotWithOnlyChild;
	}

	public BigInteger getQ23BCzTotUnknownHouseHold() {
		return q23BCzTotUnknownHouseHold;
	}

	public void setQ23BCzTotUnknownHouseHold(BigInteger q23bCzTotUnknownHouseHold) {
		q23BCzTotUnknownHouseHold = q23bCzTotUnknownHouseHold;
	}

	public BigInteger getQ23BDOtherDestinationsTotal() {
		return q23BDOtherDestinationsTotal;
	}

	public void setQ23BDOtherDestinationsTotal(
			BigInteger q23bdOtherDestinationsTotal) {
		q23BDOtherDestinationsTotal = q23bdOtherDestinationsTotal;
	}

	public BigInteger getQ23BDOtherDestinationsWithoutChild() {
		return q23BDOtherDestinationsWithoutChild;
	}

	public void setQ23BDOtherDestinationsWithoutChild(
			BigInteger q23bdOtherDestinationsWithoutChild) {
		q23BDOtherDestinationsWithoutChild = q23bdOtherDestinationsWithoutChild;
	}

	public BigInteger getQ23BDOtherDestinationsWithChildAndAdults() {
		return q23BDOtherDestinationsWithChildAndAdults;
	}

	public void setQ23BDOtherDestinationsWithChildAndAdults(
			BigInteger q23bdOtherDestinationsWithChildAndAdults) {
		q23BDOtherDestinationsWithChildAndAdults = q23bdOtherDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23BDOtherDestinationsWithOnlyChild() {
		return q23BDOtherDestinationsWithOnlyChild;
	}

	public void setQ23BDOtherDestinationsWithOnlyChild(
			BigInteger q23bdOtherDestinationsWithOnlyChild) {
		q23BDOtherDestinationsWithOnlyChild = q23bdOtherDestinationsWithOnlyChild;
	}

	public BigInteger getQ23BDOtherDestinationsUnknownHouseHold() {
		return q23BDOtherDestinationsUnknownHouseHold;
	}

	public void setQ23BDOtherDestinationsUnknownHouseHold(
			BigInteger q23bdOtherDestinationsUnknownHouseHold) {
		q23BDOtherDestinationsUnknownHouseHold = q23bdOtherDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23BD1ResidentialProjectorHalfwayHouseTotal() {
		return q23BD1ResidentialProjectorHalfwayHouseTotal;
	}

	public void setQ23BD1ResidentialProjectorHalfwayHouseTotal(
			BigInteger q23bd1ResidentialProjectorHalfwayHouseTotal) {
		q23BD1ResidentialProjectorHalfwayHouseTotal = q23bd1ResidentialProjectorHalfwayHouseTotal;
	}

	public BigInteger getQ23BD1ResidentialProjectorHalfwayHouseWithoutChild() {
		return q23BD1ResidentialProjectorHalfwayHouseWithoutChild;
	}

	public void setQ23BD1ResidentialProjectorHalfwayHouseWithoutChild(
			BigInteger q23bd1ResidentialProjectorHalfwayHouseWithoutChild) {
		q23BD1ResidentialProjectorHalfwayHouseWithoutChild = q23bd1ResidentialProjectorHalfwayHouseWithoutChild;
	}

	public BigInteger getQ23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults() {
		return q23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	}

	public void setQ23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults(
			BigInteger q23bd1ResidentialProjectorHalfwayHouseWithChildAndAdults) {
		q23BD1ResidentialProjectorHalfwayHouseWithChildAndAdults = q23bd1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	}

	public BigInteger getQ23BD1ResidentialProjectorHalfwayHouseWithOnlyChild() {
		return q23BD1ResidentialProjectorHalfwayHouseWithOnlyChild;
	}

	public void setQ23BD1ResidentialProjectorHalfwayHouseWithOnlyChild(
			BigInteger q23bd1ResidentialProjectorHalfwayHouseWithOnlyChild) {
		q23BD1ResidentialProjectorHalfwayHouseWithOnlyChild = q23bd1ResidentialProjectorHalfwayHouseWithOnlyChild;
	}

	public BigInteger getQ23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold() {
		return q23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold;
	}

	public void setQ23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold(
			BigInteger q23bd1ResidentialProjectorHalfwayHouseUnknownHouseHold) {
		q23BD1ResidentialProjectorHalfwayHouseUnknownHouseHold = q23bd1ResidentialProjectorHalfwayHouseUnknownHouseHold;
	}

	public BigInteger getQ23BD2DeceasedTotal() {
		return q23BD2DeceasedTotal;
	}

	public void setQ23BD2DeceasedTotal(BigInteger q23bd2DeceasedTotal) {
		q23BD2DeceasedTotal = q23bd2DeceasedTotal;
	}

	public BigInteger getQ23BD2DeceasedWithoutChild() {
		return q23BD2DeceasedWithoutChild;
	}

	public void setQ23BD2DeceasedWithoutChild(BigInteger q23bd2DeceasedWithoutChild) {
		q23BD2DeceasedWithoutChild = q23bd2DeceasedWithoutChild;
	}

	public BigInteger getQ23BD2DeceasedWithChildAndAdults() {
		return q23BD2DeceasedWithChildAndAdults;
	}

	public void setQ23BD2DeceasedWithChildAndAdults(
			BigInteger q23bd2DeceasedWithChildAndAdults) {
		q23BD2DeceasedWithChildAndAdults = q23bd2DeceasedWithChildAndAdults;
	}

	public BigInteger getQ23BD2DeceasedWithOnlyChild() {
		return q23BD2DeceasedWithOnlyChild;
	}

	public void setQ23BD2DeceasedWithOnlyChild(
			BigInteger q23bd2DeceasedWithOnlyChild) {
		q23BD2DeceasedWithOnlyChild = q23bd2DeceasedWithOnlyChild;
	}

	public BigInteger getQ23BD2DeceasedUnknownHouseHold() {
		return q23BD2DeceasedUnknownHouseHold;
	}

	public void setQ23BD2DeceasedUnknownHouseHold(
			BigInteger q23bd2DeceasedUnknownHouseHold) {
		q23BD2DeceasedUnknownHouseHold = q23bd2DeceasedUnknownHouseHold;
	}

	public BigInteger getQ23BD3OtherTotal() {
		return q23BD3OtherTotal;
	}

	public void setQ23BD3OtherTotal(BigInteger q23bd3OtherTotal) {
		q23BD3OtherTotal = q23bd3OtherTotal;
	}

	public BigInteger getQ23BD3OtherWithoutChild() {
		return q23BD3OtherWithoutChild;
	}

	public void setQ23BD3OtherWithoutChild(BigInteger q23bd3OtherWithoutChild) {
		q23BD3OtherWithoutChild = q23bd3OtherWithoutChild;
	}

	public BigInteger getQ23BD3OtherWithChildAndAdults() {
		return q23BD3OtherWithChildAndAdults;
	}

	public void setQ23BD3OtherWithChildAndAdults(
			BigInteger q23bd3OtherWithChildAndAdults) {
		q23BD3OtherWithChildAndAdults = q23bd3OtherWithChildAndAdults;
	}

	public BigInteger getQ23BD3OtherWithOnlyChild() {
		return q23BD3OtherWithOnlyChild;
	}

	public void setQ23BD3OtherWithOnlyChild(BigInteger q23bd3OtherWithOnlyChild) {
		q23BD3OtherWithOnlyChild = q23bd3OtherWithOnlyChild;
	}

	public BigInteger getQ23BD3OtherUnknownHouseHold() {
		return q23BD3OtherUnknownHouseHold;
	}

	public void setQ23BD3OtherUnknownHouseHold(
			BigInteger q23bd3OtherUnknownHouseHold) {
		q23BD3OtherUnknownHouseHold = q23bd3OtherUnknownHouseHold;
	}

	public BigInteger getQ23BD4DKRTotal() {
		return q23BD4DKRTotal;
	}

	public void setQ23BD4DKRTotal(BigInteger q23bd4dkrTotal) {
		q23BD4DKRTotal = q23bd4dkrTotal;
	}

	public BigInteger getQ23BD4DKRWithoutChild() {
		return q23BD4DKRWithoutChild;
	}

	public void setQ23BD4DKRWithoutChild(BigInteger q23bd4dkrWithoutChild) {
		q23BD4DKRWithoutChild = q23bd4dkrWithoutChild;
	}

	public BigInteger getQ23BD4DKRWithChildAndAdults() {
		return q23BD4DKRWithChildAndAdults;
	}

	public void setQ23BD4DKRWithChildAndAdults(
			BigInteger q23bd4dkrWithChildAndAdults) {
		q23BD4DKRWithChildAndAdults = q23bd4dkrWithChildAndAdults;
	}

	public BigInteger getQ23BD4DKRWithOnlyChild() {
		return q23BD4DKRWithOnlyChild;
	}

	public void setQ23BD4DKRWithOnlyChild(BigInteger q23bd4dkrWithOnlyChild) {
		q23BD4DKRWithOnlyChild = q23bd4dkrWithOnlyChild;
	}

	public BigInteger getQ23BD4DKRUnknownHouseHold() {
		return q23BD4DKRUnknownHouseHold;
	}

	public void setQ23BD4DKRUnknownHouseHold(BigInteger q23bd4dkrUnknownHouseHold) {
		q23BD4DKRUnknownHouseHold = q23bd4dkrUnknownHouseHold;
	}

	public BigInteger getQ23BD5InfoMissingTotal() {
		return q23BD5InfoMissingTotal;
	}

	public void setQ23BD5InfoMissingTotal(BigInteger q23bd5InfoMissingTotal) {
		q23BD5InfoMissingTotal = q23bd5InfoMissingTotal;
	}

	public BigInteger getQ23BD5InfoMissingWithoutChild() {
		return q23BD5InfoMissingWithoutChild;
	}

	public void setQ23BD5InfoMissingWithoutChild(
			BigInteger q23bd5InfoMissingWithoutChild) {
		q23BD5InfoMissingWithoutChild = q23bd5InfoMissingWithoutChild;
	}

	public BigInteger getQ23BD5InfoMissingWithChildAndAdults() {
		return q23BD5InfoMissingWithChildAndAdults;
	}

	public void setQ23BD5InfoMissingWithChildAndAdults(
			BigInteger q23bd5InfoMissingWithChildAndAdults) {
		q23BD5InfoMissingWithChildAndAdults = q23bd5InfoMissingWithChildAndAdults;
	}

	public BigInteger getQ23BD5InfoMissingWithOnlyChild() {
		return q23BD5InfoMissingWithOnlyChild;
	}

	public void setQ23BD5InfoMissingWithOnlyChild(
			BigInteger q23bd5InfoMissingWithOnlyChild) {
		q23BD5InfoMissingWithOnlyChild = q23bd5InfoMissingWithOnlyChild;
	}

	public BigInteger getQ23BD5InfoMissingUnknownHouseHold() {
		return q23BD5InfoMissingUnknownHouseHold;
	}

	public void setQ23BD5InfoMissingUnknownHouseHold(
			BigInteger q23bd5InfoMissingUnknownHouseHold) {
		q23BD5InfoMissingUnknownHouseHold = q23bd5InfoMissingUnknownHouseHold;
	}

	public BigInteger getQ23BDzTotTotal() {
		return q23BDzTotTotal;
	}

	public void setQ23BDzTotTotal(BigInteger q23bDzTotTotal) {
		q23BDzTotTotal = q23bDzTotTotal;
	}

	public BigInteger getQ23BDzTotWithoutChild() {
		return q23BDzTotWithoutChild;
	}

	public void setQ23BDzTotWithoutChild(BigInteger q23bDzTotWithoutChild) {
		q23BDzTotWithoutChild = q23bDzTotWithoutChild;
	}

	public BigInteger getQ23BDzTotWithChildAndAdults() {
		return q23BDzTotWithChildAndAdults;
	}

	public void setQ23BDzTotWithChildAndAdults(
			BigInteger q23bDzTotWithChildAndAdults) {
		q23BDzTotWithChildAndAdults = q23bDzTotWithChildAndAdults;
	}

	public BigInteger getQ23BDzTotWithOnlyChild() {
		return q23BDzTotWithOnlyChild;
	}

	public void setQ23BDzTotWithOnlyChild(BigInteger q23bDzTotWithOnlyChild) {
		q23BDzTotWithOnlyChild = q23bDzTotWithOnlyChild;
	}

	public BigInteger getQ23BDzTotUnknownHouseHold() {
		return q23BDzTotUnknownHouseHold;
	}

	public void setQ23BDzTotUnknownHouseHold(BigInteger q23bDzTotUnknownHouseHold) {
		q23BDzTotUnknownHouseHold = q23bDzTotUnknownHouseHold;
	}

	public BigInteger getQ23BETotTotal() {
		return q23BETotTotal;
	}

	public void setQ23BETotTotal(BigInteger q23beTotTotal) {
		q23BETotTotal = q23beTotTotal;
	}

	public BigInteger getQ23BETotWithoutChild() {
		return q23BETotWithoutChild;
	}

	public void setQ23BETotWithoutChild(BigInteger q23beTotWithoutChild) {
		q23BETotWithoutChild = q23beTotWithoutChild;
	}

	public BigInteger getQ23BETotWithChildAndAdults() {
		return q23BETotWithChildAndAdults;
	}

	public void setQ23BETotWithChildAndAdults(BigInteger q23beTotWithChildAndAdults) {
		q23BETotWithChildAndAdults = q23beTotWithChildAndAdults;
	}

	public BigInteger getQ23BETotWithOnlyChild() {
		return q23BETotWithOnlyChild;
	}

	public void setQ23BETotWithOnlyChild(BigInteger q23beTotWithOnlyChild) {
		q23BETotWithOnlyChild = q23beTotWithOnlyChild;
	}

	public BigInteger getQ23BETotUnknownHouseHold() {
		return q23BETotUnknownHouseHold;
	}

	public void setQ23BETotUnknownHouseHold(BigInteger q23beTotUnknownHouseHold) {
		q23BETotUnknownHouseHold = q23beTotUnknownHouseHold;
	}

	public BigInteger getQ23BPercentageWithChildAndAdults() {
		return q23BPercentageWithChildAndAdults;
	}

	public void setQ23BPercentageWithChildAndAdults(
			BigInteger q23bPercentageWithChildAndAdults) {
		q23BPercentageWithChildAndAdults = q23bPercentageWithChildAndAdults;
	}

	public BigInteger getQ23BPercentageUnknownHouseHold() {
		return q23BPercentageUnknownHouseHold;
	}

	public void setQ23BPercentageUnknownHouseHold(
			BigInteger q23bPercentageUnknownHouseHold) {
		q23BPercentageUnknownHouseHold = q23bPercentageUnknownHouseHold;
	}

	public BigInteger getQ23BPercentageWithOnlyChild() {
		return q23BPercentageWithOnlyChild;
	}

	public void setQ23BPercentageWithOnlyChild(
			BigInteger q23bPercentageWithOnlyChild) {
		q23BPercentageWithOnlyChild = q23bPercentageWithOnlyChild;
	}

	public BigInteger getQ23BPercentageWithoutChild() {
		return q23BPercentageWithoutChild;
	}

	public void setQ23BPercentageWithoutChild(BigInteger q23bPercentageWithoutChild) {
		q23BPercentageWithoutChild = q23bPercentageWithoutChild;
	}

	public BigInteger getQ23BPercentageTotal() {
		return q23BPercentageTotal;
	}

	public void setQ23BPercentageTotal(BigInteger q23bPercentageTotal) {
		q23BPercentageTotal = q23bPercentageTotal;
	}

	public BigInteger getQ23BTotPersonsDstnsWithoutChild() {
		return q23BTotPersonsDstnsWithoutChild;
	}

	public void setQ23BTotPersonsDstnsWithoutChild(
			BigInteger q23bTotPersonsDstnsWithoutChild) {
		q23BTotPersonsDstnsWithoutChild = q23bTotPersonsDstnsWithoutChild;
	}

	public BigInteger getQ23BTotPersonsDstnsTotal() {
		return q23BTotPersonsDstnsTotal;
	}

	public void setQ23BTotPersonsDstnsTotal(BigInteger q23bTotPersonsDstnsTotal) {
		q23BTotPersonsDstnsTotal = q23bTotPersonsDstnsTotal;
	}

	public BigInteger getQ23BTotPersonsDstnsUnknownHouseHold() {
		return q23BTotPersonsDstnsUnknownHouseHold;
	}

	public void setQ23BTotPersonsDstnsUnknownHouseHold(
			BigInteger q23bTotPersonsDstnsUnknownHouseHold) {
		q23BTotPersonsDstnsUnknownHouseHold = q23bTotPersonsDstnsUnknownHouseHold;
	}

	public BigInteger getQ23BTotPersonsDstnsWithOnlyChild() {
		return q23BTotPersonsDstnsWithOnlyChild;
	}

	public void setQ23BTotPersonsDstnsWithOnlyChild(
			BigInteger q23bTotPersonsDstnsWithOnlyChild) {
		q23BTotPersonsDstnsWithOnlyChild = q23bTotPersonsDstnsWithOnlyChild;
	}

	public BigInteger getQ23BTotPersonsDstnsWithChildAndAdults() {
		return q23BTotPersonsDstnsWithChildAndAdults;
	}

	public void setQ23BTotPersonsDstnsWithChildAndAdults(
			BigInteger q23bTotPersonsDstnsWithChildAndAdults) {
		q23BTotPersonsDstnsWithChildAndAdults = q23bTotPersonsDstnsWithChildAndAdults;
	}

	public BigInteger getQ23BTotPersonsExistTotal() {
		return q23BTotPersonsExistTotal;
	}

	public void setQ23BTotPersonsExistTotal(BigInteger q23bTotPersonsExistTotal) {
		q23BTotPersonsExistTotal = q23bTotPersonsExistTotal;
	}

	public BigInteger getQ23BTotPersonsExistWithoutChild() {
		return q23BTotPersonsExistWithoutChild;
	}

	public void setQ23BTotPersonsExistWithoutChild(
			BigInteger q23bTotPersonsExistWithoutChild) {
		q23BTotPersonsExistWithoutChild = q23bTotPersonsExistWithoutChild;
	}

	public BigInteger getQ23BTotPersonsExistWithChildAndAdults() {
		return q23BTotPersonsExistWithChildAndAdults;
	}

	public void setQ23BTotPersonsExistWithChildAndAdults(
			BigInteger q23bTotPersonsExistWithChildAndAdults) {
		q23BTotPersonsExistWithChildAndAdults = q23bTotPersonsExistWithChildAndAdults;
	}

	public BigInteger getQ23BTotPersonsExistWithOnlyChild() {
		return q23BTotPersonsExistWithOnlyChild;
	}

	public void setQ23BTotPersonsExistWithOnlyChild(
			BigInteger q23bTotPersonsExistWithOnlyChild) {
		q23BTotPersonsExistWithOnlyChild = q23bTotPersonsExistWithOnlyChild;
	}

	public BigInteger getQ23BTotPersonsExistUnknownHouseHold() {
		return q23BTotPersonsExistUnknownHouseHold;
	}

	public void setQ23BTotPersonsExistUnknownHouseHold(
			BigInteger q23bTotPersonsExistUnknownHouseHold) {
		q23BTotPersonsExistUnknownHouseHold = q23bTotPersonsExistUnknownHouseHold;
	}

	public void setQ23APermanentDestinationsTotal(
			BigInteger q23aPermanentDestinationsTotal) {
		q23APermanentDestinationsTotal = q23aPermanentDestinationsTotal;
	}

	public BigInteger getQ23APermanentDestinationsWithoutChild() {
		return q23APermanentDestinationsWithoutChild;
	}

	public void setQ23APermanentDestinationsWithoutChild(
			BigInteger q23aPermanentDestinationsWithoutChild) {
		q23APermanentDestinationsWithoutChild = q23aPermanentDestinationsWithoutChild;
	}

	public BigInteger getQ23APermanentDestinationsWithChildAndAdults() {
		return q23APermanentDestinationsWithChildAndAdults;
	}

	public void setQ23APermanentDestinationsWithChildAndAdults(
			BigInteger q23aPermanentDestinationsWithChildAndAdults) {
		q23APermanentDestinationsWithChildAndAdults = q23aPermanentDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23APermanentDestinationsWithOnlyChild() {
		return q23APermanentDestinationsWithOnlyChild;
	}

	public void setQ23APermanentDestinationsWithOnlyChild(
			BigInteger q23aPermanentDestinationsWithOnlyChild) {
		q23APermanentDestinationsWithOnlyChild = q23aPermanentDestinationsWithOnlyChild;
	}

	public BigInteger getQ23APermanentDestinationsUnknownHouseHold() {
		return q23APermanentDestinationsUnknownHouseHold;
	}

	public void setQ23APermanentDestinationsUnknownHouseHold(
			BigInteger q23aPermanentDestinationsUnknownHouseHold) {
		q23APermanentDestinationsUnknownHouseHold = q23aPermanentDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23A01MovedFromOneHOPWATotal() {
		return q23A01MovedFromOneHOPWATotal;
	}

	public void setQ23A01MovedFromOneHOPWATotal(
			BigInteger q23a01MovedFromOneHOPWATotal) {
		q23A01MovedFromOneHOPWATotal = q23a01MovedFromOneHOPWATotal;
	}

	public BigInteger getQ23A01MovedFromOneHOPWAWithoutChild() {
		return q23A01MovedFromOneHOPWAWithoutChild;
	}

	public void setQ23A01MovedFromOneHOPWAWithoutChild(
			BigInteger q23a01MovedFromOneHOPWAWithoutChild) {
		q23A01MovedFromOneHOPWAWithoutChild = q23a01MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ23A01MovedFromOneHOPWAWithChildAndAdults() {
		return q23A01MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ23A01MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q23a01MovedFromOneHOPWAWithChildAndAdults) {
		q23A01MovedFromOneHOPWAWithChildAndAdults = q23a01MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ23A01MovedFromOneHOPWAWithOnlyChild() {
		return q23A01MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ23A01MovedFromOneHOPWAWithOnlyChild(
			BigInteger q23a01MovedFromOneHOPWAWithOnlyChild) {
		q23A01MovedFromOneHOPWAWithOnlyChild = q23a01MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ23A01MovedFromOneHOPWAUnknownHouseHold() {
		return q23A01MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ23A01MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q23a01MovedFromOneHOPWAUnknownHouseHold) {
		q23A01MovedFromOneHOPWAUnknownHouseHold = q23a01MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ23A02OwnedByClientNoOngoingSubsidyTotal() {
		return q23A02OwnedByClientNoOngoingSubsidyTotal;
	}

	public void setQ23A02OwnedByClientNoOngoingSubsidyTotal(
			BigInteger q23a02OwnedByClientNoOngoingSubsidyTotal) {
		q23A02OwnedByClientNoOngoingSubsidyTotal = q23a02OwnedByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ23A02OwnedByClientNoOngoingSubsidyWithoutChild() {
		return q23A02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ23A02OwnedByClientNoOngoingSubsidyWithoutChild(
			BigInteger q23a02OwnedByClientNoOngoingSubsidyWithoutChild) {
		q23A02OwnedByClientNoOngoingSubsidyWithoutChild = q23a02OwnedByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults() {
		return q23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q23a02OwnedByClientNoOngoingSubsidyWithChildAndAdults) {
		q23A02OwnedByClientNoOngoingSubsidyWithChildAndAdults = q23a02OwnedByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23A02OwnedByClientNoOngoingSubsidyWithOnlyChild() {
		return q23A02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ23A02OwnedByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q23a02OwnedByClientNoOngoingSubsidyWithOnlyChild) {
		q23A02OwnedByClientNoOngoingSubsidyWithOnlyChild = q23a02OwnedByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold() {
		return q23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q23a02OwnedByClientNoOngoingSubsidyUnknownHouseHold) {
		q23A02OwnedByClientNoOngoingSubsidyUnknownHouseHold = q23a02OwnedByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23A03OwnedByClientWithOngoingSubsidyTotal() {
		return q23A03OwnedByClientWithOngoingSubsidyTotal;
	}

	public void setQ23A03OwnedByClientWithOngoingSubsidyTotal(
			BigInteger q23a03OwnedByClientWithOngoingSubsidyTotal) {
		q23A03OwnedByClientWithOngoingSubsidyTotal = q23a03OwnedByClientWithOngoingSubsidyTotal;
	}

	public BigInteger getQ23A03OwnedByClientWithOngoingSubsidyWithoutChild() {
		return q23A03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public void setQ23A03OwnedByClientWithOngoingSubsidyWithoutChild(
			BigInteger q23a03OwnedByClientWithOngoingSubsidyWithoutChild) {
		q23A03OwnedByClientWithOngoingSubsidyWithoutChild = q23a03OwnedByClientWithOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults() {
		return q23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults(
			BigInteger q23a03OwnedByClientWithOngoingSubsidyWithChildAndAdults) {
		q23A03OwnedByClientWithOngoingSubsidyWithChildAndAdults = q23a03OwnedByClientWithOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23A03OwnedByClientWithOngoingSubsidyWithOnlyChild() {
		return q23A03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public void setQ23A03OwnedByClientWithOngoingSubsidyWithOnlyChild(
			BigInteger q23a03OwnedByClientWithOngoingSubsidyWithOnlyChild) {
		q23A03OwnedByClientWithOngoingSubsidyWithOnlyChild = q23a03OwnedByClientWithOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold() {
		return q23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold(
			BigInteger q23a03OwnedByClientWithOngoingSubsidyUnknownHouseHold) {
		q23A03OwnedByClientWithOngoingSubsidyUnknownHouseHold = q23a03OwnedByClientWithOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23A04RentalByClientNoOngoingSubsidyTotal() {
		return q23A04RentalByClientNoOngoingSubsidyTotal;
	}

	public void setQ23A04RentalByClientNoOngoingSubsidyTotal(
			BigInteger q23a04RentalByClientNoOngoingSubsidyTotal) {
		q23A04RentalByClientNoOngoingSubsidyTotal = q23a04RentalByClientNoOngoingSubsidyTotal;
	}

	public BigInteger getQ23A04RentalByClientNoOngoingSubsidyWithoutChild() {
		return q23A04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public void setQ23A04RentalByClientNoOngoingSubsidyWithoutChild(
			BigInteger q23a04RentalByClientNoOngoingSubsidyWithoutChild) {
		q23A04RentalByClientNoOngoingSubsidyWithoutChild = q23a04RentalByClientNoOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23A04RentalByClientNoOngoingSubsidyWithChildAndAdults() {
		return q23A04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23A04RentalByClientNoOngoingSubsidyWithChildAndAdults(
			BigInteger q23a04RentalByClientNoOngoingSubsidyWithChildAndAdults) {
		q23A04RentalByClientNoOngoingSubsidyWithChildAndAdults = q23a04RentalByClientNoOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23A04RentalByClientNoOngoingSubsidyWithOnlyChild() {
		return q23A04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public void setQ23A04RentalByClientNoOngoingSubsidyWithOnlyChild(
			BigInteger q23a04RentalByClientNoOngoingSubsidyWithOnlyChild) {
		q23A04RentalByClientNoOngoingSubsidyWithOnlyChild = q23a04RentalByClientNoOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23A04RentalByClientNoOngoingSubsidyUnknownHouseHold() {
		return q23A04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23A04RentalByClientNoOngoingSubsidyUnknownHouseHold(
			BigInteger q23a04RentalByClientNoOngoingSubsidyUnknownHouseHold) {
		q23A04RentalByClientNoOngoingSubsidyUnknownHouseHold = q23a04RentalByClientNoOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23A05RentalByClientVASHSubsidyTotal() {
		return q23A05RentalByClientVASHSubsidyTotal;
	}

	public void setQ23A05RentalByClientVASHSubsidyTotal(
			BigInteger q23a05RentalByClientVASHSubsidyTotal) {
		q23A05RentalByClientVASHSubsidyTotal = q23a05RentalByClientVASHSubsidyTotal;
	}

	public BigInteger getQ23A05RentalByClientVASHSubsidyWithoutChild() {
		return q23A05RentalByClientVASHSubsidyWithoutChild;
	}

	public void setQ23A05RentalByClientVASHSubsidyWithoutChild(
			BigInteger q23a05RentalByClientVASHSubsidyWithoutChild) {
		q23A05RentalByClientVASHSubsidyWithoutChild = q23a05RentalByClientVASHSubsidyWithoutChild;
	}

	public BigInteger getQ23A05RentalByClientVASHSubsidyWithChildAndAdults() {
		return q23A05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public void setQ23A05RentalByClientVASHSubsidyWithChildAndAdults(
			BigInteger q23a05RentalByClientVASHSubsidyWithChildAndAdults) {
		q23A05RentalByClientVASHSubsidyWithChildAndAdults = q23a05RentalByClientVASHSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23A05RentalByClientVASHSubsidyWithOnlyChild() {
		return q23A05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public void setQ23A05RentalByClientVASHSubsidyWithOnlyChild(
			BigInteger q23a05RentalByClientVASHSubsidyWithOnlyChild) {
		q23A05RentalByClientVASHSubsidyWithOnlyChild = q23a05RentalByClientVASHSubsidyWithOnlyChild;
	}

	public BigInteger getQ23A05RentalByClientVASHSubsidyUnknownHouseHold() {
		return q23A05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public void setQ23A05RentalByClientVASHSubsidyUnknownHouseHold(
			BigInteger q23a05RentalByClientVASHSubsidyUnknownHouseHold) {
		q23A05RentalByClientVASHSubsidyUnknownHouseHold = q23a05RentalByClientVASHSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23A06RentalByClientwithGPDTIPHousingTotal() {
		return q23A06RentalByClientwithGPDTIPHousingTotal;
	}

	public void setQ23A06RentalByClientwithGPDTIPHousingTotal(
			BigInteger q23a06RentalByClientwithGPDTIPHousingTotal) {
		q23A06RentalByClientwithGPDTIPHousingTotal = q23a06RentalByClientwithGPDTIPHousingTotal;
	}

	public BigInteger getQ23A06RentalByClientwithGPDTIPHousingWithoutChild() {
		return q23A06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public void setQ23A06RentalByClientwithGPDTIPHousingWithoutChild(
			BigInteger q23a06RentalByClientwithGPDTIPHousingWithoutChild) {
		q23A06RentalByClientwithGPDTIPHousingWithoutChild = q23a06RentalByClientwithGPDTIPHousingWithoutChild;
	}

	public BigInteger getQ23A06RentalByClientwithGPDTIPHousingWithChildAndAdults() {
		return q23A06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public void setQ23A06RentalByClientwithGPDTIPHousingWithChildAndAdults(
			BigInteger q23a06RentalByClientwithGPDTIPHousingWithChildAndAdults) {
		q23A06RentalByClientwithGPDTIPHousingWithChildAndAdults = q23a06RentalByClientwithGPDTIPHousingWithChildAndAdults;
	}

	public BigInteger getQ23A06RentalByClientwithGPDTIPHousingWithOnlyChild() {
		return q23A06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public void setQ23A06RentalByClientwithGPDTIPHousingWithOnlyChild(
			BigInteger q23a06RentalByClientwithGPDTIPHousingWithOnlyChild) {
		q23A06RentalByClientwithGPDTIPHousingWithOnlyChild = q23a06RentalByClientwithGPDTIPHousingWithOnlyChild;
	}

	public BigInteger getQ23A06RentalByClientwithGPDTIPHousingUnknownHouseHold() {
		return q23A06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public void setQ23A06RentalByClientwithGPDTIPHousingUnknownHouseHold(
			BigInteger q23a06RentalByClientwithGPDTIPHousingUnknownHouseHold) {
		q23A06RentalByClientwithGPDTIPHousingUnknownHouseHold = q23a06RentalByClientwithGPDTIPHousingUnknownHouseHold;
	}

	public BigInteger getQ23A07RentalByClientOtherOngoingSubsidyTotal() {
		return q23A07RentalByClientOtherOngoingSubsidyTotal;
	}

	public void setQ23A07RentalByClientOtherOngoingSubsidyTotal(
			BigInteger q23a07RentalByClientOtherOngoingSubsidyTotal) {
		q23A07RentalByClientOtherOngoingSubsidyTotal = q23a07RentalByClientOtherOngoingSubsidyTotal;
	}

	public BigInteger getQ23A07RentalByClientOtherOngoingSubsidyWithoutChild() {
		return q23A07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public void setQ23A07RentalByClientOtherOngoingSubsidyWithoutChild(
			BigInteger q23a07RentalByClientOtherOngoingSubsidyWithoutChild) {
		q23A07RentalByClientOtherOngoingSubsidyWithoutChild = q23a07RentalByClientOtherOngoingSubsidyWithoutChild;
	}

	public BigInteger getQ23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults() {
		return q23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public void setQ23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults(
			BigInteger q23a07RentalByClientOtherOngoingSubsidyWithChildAndAdults) {
		q23A07RentalByClientOtherOngoingSubsidyWithChildAndAdults = q23a07RentalByClientOtherOngoingSubsidyWithChildAndAdults;
	}

	public BigInteger getQ23A07RentalByClientOtherOngoingSubsidyWithOnlyChild() {
		return q23A07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public void setQ23A07RentalByClientOtherOngoingSubsidyWithOnlyChild(
			BigInteger q23a07RentalByClientOtherOngoingSubsidyWithOnlyChild) {
		q23A07RentalByClientOtherOngoingSubsidyWithOnlyChild = q23a07RentalByClientOtherOngoingSubsidyWithOnlyChild;
	}

	public BigInteger getQ23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold() {
		return q23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public void setQ23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold(
			BigInteger q23a07RentalByClientOtherOngoingSubsidyUnknownHouseHold) {
		q23A07RentalByClientOtherOngoingSubsidyUnknownHouseHold = q23a07RentalByClientOtherOngoingSubsidyUnknownHouseHold;
	}

	public BigInteger getQ23A08PermanentHousingForHomelessTotal() {
		return q23A08PermanentHousingForHomelessTotal;
	}

	public void setQ23A08PermanentHousingForHomelessTotal(
			BigInteger q23a08PermanentHousingForHomelessTotal) {
		q23A08PermanentHousingForHomelessTotal = q23a08PermanentHousingForHomelessTotal;
	}

	public BigInteger getQ23A08PermanentHousingForHomelessWithoutChild() {
		return q23A08PermanentHousingForHomelessWithoutChild;
	}

	public void setQ23A08PermanentHousingForHomelessWithoutChild(
			BigInteger q23a08PermanentHousingForHomelessWithoutChild) {
		q23A08PermanentHousingForHomelessWithoutChild = q23a08PermanentHousingForHomelessWithoutChild;
	}

	public BigInteger getQ23A08PermanentHousingForHomelessWithChildAndAdults() {
		return q23A08PermanentHousingForHomelessWithChildAndAdults;
	}

	public void setQ23A08PermanentHousingForHomelessWithChildAndAdults(
			BigInteger q23a08PermanentHousingForHomelessWithChildAndAdults) {
		q23A08PermanentHousingForHomelessWithChildAndAdults = q23a08PermanentHousingForHomelessWithChildAndAdults;
	}

	public BigInteger getQ23A08PermanentHousingForHomelessWithOnlyChild() {
		return q23A08PermanentHousingForHomelessWithOnlyChild;
	}

	public void setQ23A08PermanentHousingForHomelessWithOnlyChild(
			BigInteger q23a08PermanentHousingForHomelessWithOnlyChild) {
		q23A08PermanentHousingForHomelessWithOnlyChild = q23a08PermanentHousingForHomelessWithOnlyChild;
	}

	public BigInteger getQ23A08PermanentHousingForHomelessUnknownHouseHold() {
		return q23A08PermanentHousingForHomelessUnknownHouseHold;
	}

	public void setQ23A08PermanentHousingForHomelessUnknownHouseHold(
			BigInteger q23a08PermanentHousingForHomelessUnknownHouseHold) {
		q23A08PermanentHousingForHomelessUnknownHouseHold = q23a08PermanentHousingForHomelessUnknownHouseHold;
	}

	public BigInteger getQ23A09StayingOrLivingWithFamilyPermanentTotal() {
		return q23A09StayingOrLivingWithFamilyPermanentTotal;
	}

	public void setQ23A09StayingOrLivingWithFamilyPermanentTotal(
			BigInteger q23a09StayingOrLivingWithFamilyPermanentTotal) {
		q23A09StayingOrLivingWithFamilyPermanentTotal = q23a09StayingOrLivingWithFamilyPermanentTotal;
	}

	public BigInteger getQ23A09StayingOrLivingWithFamilyPermanentWithoutChild() {
		return q23A09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public void setQ23A09StayingOrLivingWithFamilyPermanentWithoutChild(
			BigInteger q23a09StayingOrLivingWithFamilyPermanentWithoutChild) {
		q23A09StayingOrLivingWithFamilyPermanentWithoutChild = q23a09StayingOrLivingWithFamilyPermanentWithoutChild;
	}

	public BigInteger getQ23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults() {
		return q23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public void setQ23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults(
			BigInteger q23a09StayingOrLivingWithFamilyPermanentWithChildAndAdults) {
		q23A09StayingOrLivingWithFamilyPermanentWithChildAndAdults = q23a09StayingOrLivingWithFamilyPermanentWithChildAndAdults;
	}

	public BigInteger getQ23A09StayingOrLivingWithFamilyPermanentWithOnlyChild() {
		return q23A09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public void setQ23A09StayingOrLivingWithFamilyPermanentWithOnlyChild(
			BigInteger q23a09StayingOrLivingWithFamilyPermanentWithOnlyChild) {
		q23A09StayingOrLivingWithFamilyPermanentWithOnlyChild = q23a09StayingOrLivingWithFamilyPermanentWithOnlyChild;
	}

	public BigInteger getQ23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold() {
		return q23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public void setQ23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold(
			BigInteger q23a09StayingOrLivingWithFamilyPermanentUnknownHouseHold) {
		q23A09StayingOrLivingWithFamilyPermanentUnknownHouseHold = q23a09StayingOrLivingWithFamilyPermanentUnknownHouseHold;
	}

	public BigInteger getQ23A10StayingOrLivingWithFriendsPermanentTotal() {
		return q23A10StayingOrLivingWithFriendsPermanentTotal;
	}

	public void setQ23A10StayingOrLivingWithFriendsPermanentTotal(
			BigInteger q23a10StayingOrLivingWithFriendsPermanentTotal) {
		q23A10StayingOrLivingWithFriendsPermanentTotal = q23a10StayingOrLivingWithFriendsPermanentTotal;
	}

	public BigInteger getQ23A10StayingOrLivingWithFriendsPermanentWithoutChild() {
		return q23A10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public void setQ23A10StayingOrLivingWithFriendsPermanentWithoutChild(
			BigInteger q23a10StayingOrLivingWithFriendsPermanentWithoutChild) {
		q23A10StayingOrLivingWithFriendsPermanentWithoutChild = q23a10StayingOrLivingWithFriendsPermanentWithoutChild;
	}

	public BigInteger getQ23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults() {
		return q23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public void setQ23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults(
			BigInteger q23a10StayingOrLivingWithFriendsPermanentWithChildAndAdults) {
		q23A10StayingOrLivingWithFriendsPermanentWithChildAndAdults = q23a10StayingOrLivingWithFriendsPermanentWithChildAndAdults;
	}

	public BigInteger getQ23A10StayingOrLivingWithFriendsPermanentWithOnlyChild() {
		return q23A10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public void setQ23A10StayingOrLivingWithFriendsPermanentWithOnlyChild(
			BigInteger q23a10StayingOrLivingWithFriendsPermanentWithOnlyChild) {
		q23A10StayingOrLivingWithFriendsPermanentWithOnlyChild = q23a10StayingOrLivingWithFriendsPermanentWithOnlyChild;
	}

	public BigInteger getQ23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold() {
		return q23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public void setQ23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold(
			BigInteger q23a10StayingOrLivingWithFriendsPermanentUnknownHouseHold) {
		q23A10StayingOrLivingWithFriendsPermanentUnknownHouseHold = q23a10StayingOrLivingWithFriendsPermanentUnknownHouseHold;
	}

	public BigInteger getQ23AzTotTotal() {
		return q23AzTotTotal;
	}

	public void setQ23AzTotTotal(BigInteger q23AzTotTotal) {
		this.q23AzTotTotal = q23AzTotTotal;
	}

	public BigInteger getQ23AzTotWithoutChild() {
		return q23AzTotWithoutChild;
	}

	public void setQ23AzTotWithoutChild(BigInteger q23AzTotWithoutChild) {
		this.q23AzTotWithoutChild = q23AzTotWithoutChild;
	}

	public BigInteger getQ23AzTotWithChildAndAdults() {
		return q23AzTotWithChildAndAdults;
	}

	public void setQ23AzTotWithChildAndAdults(BigInteger q23AzTotWithChildAndAdults) {
		this.q23AzTotWithChildAndAdults = q23AzTotWithChildAndAdults;
	}

	public BigInteger getQ23AzTotWithOnlyChild() {
		return q23AzTotWithOnlyChild;
	}

	public void setQ23AzTotWithOnlyChild(BigInteger q23AzTotWithOnlyChild) {
		this.q23AzTotWithOnlyChild = q23AzTotWithOnlyChild;
	}

	public BigInteger getQ23AzTotUnknownHouseHold() {
		return q23AzTotUnknownHouseHold;
	}

	public void setQ23AzTotUnknownHouseHold(BigInteger q23AzTotUnknownHouseHold) {
		this.q23AzTotUnknownHouseHold = q23AzTotUnknownHouseHold;
	}

	public BigInteger getQ23BTemporaryDestinationsTotal() {
		return q23BTemporaryDestinationsTotal;
	}

	public void setQ23BTemporaryDestinationsTotal(
			BigInteger q23bTemporaryDestinationsTotal) {
		q23BTemporaryDestinationsTotal = q23bTemporaryDestinationsTotal;
	}

	public BigInteger getQ23BTemporaryDestinationsWithoutChild() {
		return q23BTemporaryDestinationsWithoutChild;
	}

	public void setQ23BTemporaryDestinationsWithoutChild(
			BigInteger q23bTemporaryDestinationsWithoutChild) {
		q23BTemporaryDestinationsWithoutChild = q23bTemporaryDestinationsWithoutChild;
	}

	public BigInteger getQ23BTemporaryDestinationsWithChildAndAdults() {
		return q23BTemporaryDestinationsWithChildAndAdults;
	}

	public void setQ23BTemporaryDestinationsWithChildAndAdults(
			BigInteger q23bTemporaryDestinationsWithChildAndAdults) {
		q23BTemporaryDestinationsWithChildAndAdults = q23bTemporaryDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23BTemporaryDestinationsWithOnlyChild() {
		return q23BTemporaryDestinationsWithOnlyChild;
	}

	public void setQ23BTemporaryDestinationsWithOnlyChild(
			BigInteger q23bTemporaryDestinationsWithOnlyChild) {
		q23BTemporaryDestinationsWithOnlyChild = q23bTemporaryDestinationsWithOnlyChild;
	}

	public BigInteger getQ23BTemporaryDestinationsUnknownHouseHold() {
		return q23BTemporaryDestinationsUnknownHouseHold;
	}

	public void setQ23BTemporaryDestinationsUnknownHouseHold(
			BigInteger q23bTemporaryDestinationsUnknownHouseHold) {
		q23BTemporaryDestinationsUnknownHouseHold = q23bTemporaryDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23B1EmergencyShelterTotal() {
		return q23B1EmergencyShelterTotal;
	}

	public void setQ23B1EmergencyShelterTotal(BigInteger q23b1EmergencyShelterTotal) {
		q23B1EmergencyShelterTotal = q23b1EmergencyShelterTotal;
	}

	public BigInteger getQ23B1EmergencyShelterWithoutChild() {
		return q23B1EmergencyShelterWithoutChild;
	}

	public void setQ23B1EmergencyShelterWithoutChild(
			BigInteger q23b1EmergencyShelterWithoutChild) {
		q23B1EmergencyShelterWithoutChild = q23b1EmergencyShelterWithoutChild;
	}

	public BigInteger getQ23B1EmergencyShelterWithChildAndAdults() {
		return q23B1EmergencyShelterWithChildAndAdults;
	}

	public void setQ23B1EmergencyShelterWithChildAndAdults(
			BigInteger q23b1EmergencyShelterWithChildAndAdults) {
		q23B1EmergencyShelterWithChildAndAdults = q23b1EmergencyShelterWithChildAndAdults;
	}

	public BigInteger getQ23B1EmergencyShelterWithOnlyChild() {
		return q23B1EmergencyShelterWithOnlyChild;
	}

	public void setQ23B1EmergencyShelterWithOnlyChild(
			BigInteger q23b1EmergencyShelterWithOnlyChild) {
		q23B1EmergencyShelterWithOnlyChild = q23b1EmergencyShelterWithOnlyChild;
	}

	public BigInteger getQ23B1EmergencyShelterUnknownHouseHold() {
		return q23B1EmergencyShelterUnknownHouseHold;
	}

	public void setQ23B1EmergencyShelterUnknownHouseHold(
			BigInteger q23b1EmergencyShelterUnknownHouseHold) {
		q23B1EmergencyShelterUnknownHouseHold = q23b1EmergencyShelterUnknownHouseHold;
	}

	public BigInteger getQ23B2MovedFromOneHOPWATotal() {
		return q23B2MovedFromOneHOPWATotal;
	}

	public void setQ23B2MovedFromOneHOPWATotal(
			BigInteger q23b2MovedFromOneHOPWATotal) {
		q23B2MovedFromOneHOPWATotal = q23b2MovedFromOneHOPWATotal;
	}

	public BigInteger getQ23B2MovedFromOneHOPWAWithoutChild() {
		return q23B2MovedFromOneHOPWAWithoutChild;
	}

	public void setQ23B2MovedFromOneHOPWAWithoutChild(
			BigInteger q23b2MovedFromOneHOPWAWithoutChild) {
		q23B2MovedFromOneHOPWAWithoutChild = q23b2MovedFromOneHOPWAWithoutChild;
	}

	public BigInteger getQ23B2MovedFromOneHOPWAWithChildAndAdults() {
		return q23B2MovedFromOneHOPWAWithChildAndAdults;
	}

	public void setQ23B2MovedFromOneHOPWAWithChildAndAdults(
			BigInteger q23b2MovedFromOneHOPWAWithChildAndAdults) {
		q23B2MovedFromOneHOPWAWithChildAndAdults = q23b2MovedFromOneHOPWAWithChildAndAdults;
	}

	public BigInteger getQ23B2MovedFromOneHOPWAWithOnlyChild() {
		return q23B2MovedFromOneHOPWAWithOnlyChild;
	}

	public void setQ23B2MovedFromOneHOPWAWithOnlyChild(
			BigInteger q23b2MovedFromOneHOPWAWithOnlyChild) {
		q23B2MovedFromOneHOPWAWithOnlyChild = q23b2MovedFromOneHOPWAWithOnlyChild;
	}

	public BigInteger getQ23B2MovedFromOneHOPWAUnknownHouseHold() {
		return q23B2MovedFromOneHOPWAUnknownHouseHold;
	}

	public void setQ23B2MovedFromOneHOPWAUnknownHouseHold(
			BigInteger q23b2MovedFromOneHOPWAUnknownHouseHold) {
		q23B2MovedFromOneHOPWAUnknownHouseHold = q23b2MovedFromOneHOPWAUnknownHouseHold;
	}

	public BigInteger getQ23B3TransitionalHousingForHomeLessTotal() {
		return q23B3TransitionalHousingForHomeLessTotal;
	}

	public void setQ23B3TransitionalHousingForHomeLessTotal(
			BigInteger q23b3TransitionalHousingForHomeLessTotal) {
		q23B3TransitionalHousingForHomeLessTotal = q23b3TransitionalHousingForHomeLessTotal;
	}

	public BigInteger getQ23B3TransitionalHousingForHomeLessWithoutChild() {
		return q23B3TransitionalHousingForHomeLessWithoutChild;
	}

	public void setQ23B3TransitionalHousingForHomeLessWithoutChild(
			BigInteger q23b3TransitionalHousingForHomeLessWithoutChild) {
		q23B3TransitionalHousingForHomeLessWithoutChild = q23b3TransitionalHousingForHomeLessWithoutChild;
	}

	public BigInteger getQ23B3TransitionalHousingForHomeLessWithChildAndAdults() {
		return q23B3TransitionalHousingForHomeLessWithChildAndAdults;
	}

	public void setQ23B3TransitionalHousingForHomeLessWithChildAndAdults(
			BigInteger q23b3TransitionalHousingForHomeLessWithChildAndAdults) {
		q23B3TransitionalHousingForHomeLessWithChildAndAdults = q23b3TransitionalHousingForHomeLessWithChildAndAdults;
	}

	public BigInteger getQ23B3TransitionalHousingForHomeLessWithOnlyChild() {
		return q23B3TransitionalHousingForHomeLessWithOnlyChild;
	}

	public void setQ23B3TransitionalHousingForHomeLessWithOnlyChild(
			BigInteger q23b3TransitionalHousingForHomeLessWithOnlyChild) {
		q23B3TransitionalHousingForHomeLessWithOnlyChild = q23b3TransitionalHousingForHomeLessWithOnlyChild;
	}

	public BigInteger getQ23B3TransitionalHousingForHomeLessUnknownHouseHold() {
		return q23B3TransitionalHousingForHomeLessUnknownHouseHold;
	}

	public void setQ23B3TransitionalHousingForHomeLessUnknownHouseHold(
			BigInteger q23b3TransitionalHousingForHomeLessUnknownHouseHold) {
		q23B3TransitionalHousingForHomeLessUnknownHouseHold = q23b3TransitionalHousingForHomeLessUnknownHouseHold;
	}

	public BigInteger getQ23B4StayingWithFamilyTemporaryTenureTotal() {
		return q23B4StayingWithFamilyTemporaryTenureTotal;
	}

	public void setQ23B4StayingWithFamilyTemporaryTenureTotal(
			BigInteger q23b4StayingWithFamilyTemporaryTenureTotal) {
		q23B4StayingWithFamilyTemporaryTenureTotal = q23b4StayingWithFamilyTemporaryTenureTotal;
	}

	public BigInteger getQ23B4StayingWithFamilyTemporaryTenureWithoutChild() {
		return q23B4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public void setQ23B4StayingWithFamilyTemporaryTenureWithoutChild(
			BigInteger q23b4StayingWithFamilyTemporaryTenureWithoutChild) {
		q23B4StayingWithFamilyTemporaryTenureWithoutChild = q23b4StayingWithFamilyTemporaryTenureWithoutChild;
	}

	public BigInteger getQ23B4StayingWithFamilyTemporaryTenureWithChildAndAdults() {
		return q23B4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public void setQ23B4StayingWithFamilyTemporaryTenureWithChildAndAdults(
			BigInteger q23b4StayingWithFamilyTemporaryTenureWithChildAndAdults) {
		q23B4StayingWithFamilyTemporaryTenureWithChildAndAdults = q23b4StayingWithFamilyTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ23B4StayingWithFamilyTemporaryTenureWithOnlyChild() {
		return q23B4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public void setQ23B4StayingWithFamilyTemporaryTenureWithOnlyChild(
			BigInteger q23b4StayingWithFamilyTemporaryTenureWithOnlyChild) {
		q23B4StayingWithFamilyTemporaryTenureWithOnlyChild = q23b4StayingWithFamilyTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ23B4StayingWithFamilyTemporaryTenureUnknownHouseHold() {
		return q23B4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public void setQ23B4StayingWithFamilyTemporaryTenureUnknownHouseHold(
			BigInteger q23b4StayingWithFamilyTemporaryTenureUnknownHouseHold) {
		q23B4StayingWithFamilyTemporaryTenureUnknownHouseHold = q23b4StayingWithFamilyTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ23B5StayingWithFriendsTemporaryTenureTotal() {
		return q23B5StayingWithFriendsTemporaryTenureTotal;
	}

	public void setQ23B5StayingWithFriendsTemporaryTenureTotal(
			BigInteger q23b5StayingWithFriendsTemporaryTenureTotal) {
		q23B5StayingWithFriendsTemporaryTenureTotal = q23b5StayingWithFriendsTemporaryTenureTotal;
	}

	public BigInteger getQ23B5StayingWithFriendsTemporaryTenureWithoutChild() {
		return q23B5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public void setQ23B5StayingWithFriendsTemporaryTenureWithoutChild(
			BigInteger q23b5StayingWithFriendsTemporaryTenureWithoutChild) {
		q23B5StayingWithFriendsTemporaryTenureWithoutChild = q23b5StayingWithFriendsTemporaryTenureWithoutChild;
	}

	public BigInteger getQ23B5StayingWithFriendsTemporaryTenureWithChildAndAdults() {
		return q23B5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public void setQ23B5StayingWithFriendsTemporaryTenureWithChildAndAdults(
			BigInteger q23b5StayingWithFriendsTemporaryTenureWithChildAndAdults) {
		q23B5StayingWithFriendsTemporaryTenureWithChildAndAdults = q23b5StayingWithFriendsTemporaryTenureWithChildAndAdults;
	}

	public BigInteger getQ23B5StayingWithFriendsTemporaryTenureWithOnlyChild() {
		return q23B5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public void setQ23B5StayingWithFriendsTemporaryTenureWithOnlyChild(
			BigInteger q23b5StayingWithFriendsTemporaryTenureWithOnlyChild) {
		q23B5StayingWithFriendsTemporaryTenureWithOnlyChild = q23b5StayingWithFriendsTemporaryTenureWithOnlyChild;
	}

	public BigInteger getQ23B5StayingWithFriendsTemporaryTenureUnknownHouseHold() {
		return q23B5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public void setQ23B5StayingWithFriendsTemporaryTenureUnknownHouseHold(
			BigInteger q23b5StayingWithFriendsTemporaryTenureUnknownHouseHold) {
		q23B5StayingWithFriendsTemporaryTenureUnknownHouseHold = q23b5StayingWithFriendsTemporaryTenureUnknownHouseHold;
	}

	public BigInteger getQ23B6PlaceNotMeantForHumanHabitationTotal() {
		return q23B6PlaceNotMeantForHumanHabitationTotal;
	}

	public void setQ23B6PlaceNotMeantForHumanHabitationTotal(
			BigInteger q23b6PlaceNotMeantForHumanHabitationTotal) {
		q23B6PlaceNotMeantForHumanHabitationTotal = q23b6PlaceNotMeantForHumanHabitationTotal;
	}

	public BigInteger getQ23B6PlaceNotMeantForHumanHabitationWithoutChild() {
		return q23B6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public void setQ23B6PlaceNotMeantForHumanHabitationWithoutChild(
			BigInteger q23b6PlaceNotMeantForHumanHabitationWithoutChild) {
		q23B6PlaceNotMeantForHumanHabitationWithoutChild = q23b6PlaceNotMeantForHumanHabitationWithoutChild;
	}

	public BigInteger getQ23B6PlaceNotMeantForHumanHabitationWithChildAndAdults() {
		return q23B6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public void setQ23B6PlaceNotMeantForHumanHabitationWithChildAndAdults(
			BigInteger q23b6PlaceNotMeantForHumanHabitationWithChildAndAdults) {
		q23B6PlaceNotMeantForHumanHabitationWithChildAndAdults = q23b6PlaceNotMeantForHumanHabitationWithChildAndAdults;
	}

	public BigInteger getQ23B6PlaceNotMeantForHumanHabitationWithOnlyChild() {
		return q23B6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public void setQ23B6PlaceNotMeantForHumanHabitationWithOnlyChild(
			BigInteger q23b6PlaceNotMeantForHumanHabitationWithOnlyChild) {
		q23B6PlaceNotMeantForHumanHabitationWithOnlyChild = q23b6PlaceNotMeantForHumanHabitationWithOnlyChild;
	}

	public BigInteger getQ23B6PlaceNotMeantForHumanHabitationUnknownHouseHold() {
		return q23B6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public void setQ23B6PlaceNotMeantForHumanHabitationUnknownHouseHold(
			BigInteger q23b6PlaceNotMeantForHumanHabitationUnknownHouseHold) {
		q23B6PlaceNotMeantForHumanHabitationUnknownHouseHold = q23b6PlaceNotMeantForHumanHabitationUnknownHouseHold;
	}

	public BigInteger getQ23B7SafeHavenTotal() {
		return q23B7SafeHavenTotal;
	}

	public void setQ23B7SafeHavenTotal(BigInteger q23b7SafeHavenTotal) {
		q23B7SafeHavenTotal = q23b7SafeHavenTotal;
	}

	public BigInteger getQ23B7SafeHavenWithoutChild() {
		return q23B7SafeHavenWithoutChild;
	}

	public void setQ23B7SafeHavenWithoutChild(BigInteger q23b7SafeHavenWithoutChild) {
		q23B7SafeHavenWithoutChild = q23b7SafeHavenWithoutChild;
	}

	public BigInteger getQ23B7SafeHavenWithChildAndAdults() {
		return q23B7SafeHavenWithChildAndAdults;
	}

	public void setQ23B7SafeHavenWithChildAndAdults(
			BigInteger q23b7SafeHavenWithChildAndAdults) {
		q23B7SafeHavenWithChildAndAdults = q23b7SafeHavenWithChildAndAdults;
	}

	public BigInteger getQ23B7SafeHavenWithOnlyChild() {
		return q23B7SafeHavenWithOnlyChild;
	}

	public void setQ23B7SafeHavenWithOnlyChild(
			BigInteger q23b7SafeHavenWithOnlyChild) {
		q23B7SafeHavenWithOnlyChild = q23b7SafeHavenWithOnlyChild;
	}

	public BigInteger getQ23B7SafeHavenUnknownHouseHold() {
		return q23B7SafeHavenUnknownHouseHold;
	}

	public void setQ23B7SafeHavenUnknownHouseHold(
			BigInteger q23b7SafeHavenUnknownHouseHold) {
		q23B7SafeHavenUnknownHouseHold = q23b7SafeHavenUnknownHouseHold;
	}

	public BigInteger getQ23B8HotelOrMotelPaidByClientTotal() {
		return q23B8HotelOrMotelPaidByClientTotal;
	}

	public void setQ23B8HotelOrMotelPaidByClientTotal(
			BigInteger q23b8HotelOrMotelPaidByClientTotal) {
		q23B8HotelOrMotelPaidByClientTotal = q23b8HotelOrMotelPaidByClientTotal;
	}

	public BigInteger getQ23B8HotelOrMotelPaidByClientWithoutChild() {
		return q23B8HotelOrMotelPaidByClientWithoutChild;
	}

	public void setQ23B8HotelOrMotelPaidByClientWithoutChild(
			BigInteger q23b8HotelOrMotelPaidByClientWithoutChild) {
		q23B8HotelOrMotelPaidByClientWithoutChild = q23b8HotelOrMotelPaidByClientWithoutChild;
	}

	public BigInteger getQ23B8HotelOrMotelPaidByClientWithChildAndAdults() {
		return q23B8HotelOrMotelPaidByClientWithChildAndAdults;
	}

	public void setQ23B8HotelOrMotelPaidByClientWithChildAndAdults(
			BigInteger q23b8HotelOrMotelPaidByClientWithChildAndAdults) {
		q23B8HotelOrMotelPaidByClientWithChildAndAdults = q23b8HotelOrMotelPaidByClientWithChildAndAdults;
	}

	public BigInteger getQ23B8HotelOrMotelPaidByClientWithOnlyChild() {
		return q23B8HotelOrMotelPaidByClientWithOnlyChild;
	}

	public void setQ23B8HotelOrMotelPaidByClientWithOnlyChild(
			BigInteger q23b8HotelOrMotelPaidByClientWithOnlyChild) {
		q23B8HotelOrMotelPaidByClientWithOnlyChild = q23b8HotelOrMotelPaidByClientWithOnlyChild;
	}

	public BigInteger getQ23B8HotelOrMotelPaidByClientUnknownHouseHold() {
		return q23B8HotelOrMotelPaidByClientUnknownHouseHold;
	}

	public void setQ23B8HotelOrMotelPaidByClientUnknownHouseHold(
			BigInteger q23b8HotelOrMotelPaidByClientUnknownHouseHold) {
		q23B8HotelOrMotelPaidByClientUnknownHouseHold = q23b8HotelOrMotelPaidByClientUnknownHouseHold;
	}

	public BigInteger getQ23BzTotTotal() {
		return q23BzTotTotal;
	}

	public void setQ23BzTotTotal(BigInteger q23BzTotTotal) {
		this.q23BzTotTotal = q23BzTotTotal;
	}

	public BigInteger getQ23BzTotWithoutChild() {
		return q23BzTotWithoutChild;
	}

	public void setQ23BzTotWithoutChild(BigInteger q23BzTotWithoutChild) {
		this.q23BzTotWithoutChild = q23BzTotWithoutChild;
	}

	public BigInteger getQ23BzTotWithChildAndAdults() {
		return q23BzTotWithChildAndAdults;
	}

	public void setQ23BzTotWithChildAndAdults(BigInteger q23BzTotWithChildAndAdults) {
		this.q23BzTotWithChildAndAdults = q23BzTotWithChildAndAdults;
	}

	public BigInteger getQ23BzTotWithOnlyChild() {
		return q23BzTotWithOnlyChild;
	}

	public void setQ23BzTotWithOnlyChild(BigInteger q23BzTotWithOnlyChild) {
		this.q23BzTotWithOnlyChild = q23BzTotWithOnlyChild;
	}

	public BigInteger getQ23BzTotUnknownHouseHold() {
		return q23BzTotUnknownHouseHold;
	}

	public void setQ23BzTotUnknownHouseHold(BigInteger q23BzTotUnknownHouseHold) {
		this.q23BzTotUnknownHouseHold = q23BzTotUnknownHouseHold;
	}

	public BigInteger getQ23CInstitutionalSettingsTotal() {
		return q23CInstitutionalSettingsTotal;
	}

	public void setQ23CInstitutionalSettingsTotal(
			BigInteger q23cInstitutionalSettingsTotal) {
		q23CInstitutionalSettingsTotal = q23cInstitutionalSettingsTotal;
	}

	public BigInteger getQ23CInstitutionalSettingsWithoutChild() {
		return q23CInstitutionalSettingsWithoutChild;
	}

	public void setQ23CInstitutionalSettingsWithoutChild(
			BigInteger q23cInstitutionalSettingsWithoutChild) {
		q23CInstitutionalSettingsWithoutChild = q23cInstitutionalSettingsWithoutChild;
	}

	public BigInteger getQ23CInstitutionalSettingsWithChildAndAdults() {
		return q23CInstitutionalSettingsWithChildAndAdults;
	}

	public void setQ23CInstitutionalSettingsWithChildAndAdults(
			BigInteger q23cInstitutionalSettingsWithChildAndAdults) {
		q23CInstitutionalSettingsWithChildAndAdults = q23cInstitutionalSettingsWithChildAndAdults;
	}

	public BigInteger getQ23CInstitutionalSettingsWithOnlyChild() {
		return q23CInstitutionalSettingsWithOnlyChild;
	}

	public void setQ23CInstitutionalSettingsWithOnlyChild(
			BigInteger q23cInstitutionalSettingsWithOnlyChild) {
		q23CInstitutionalSettingsWithOnlyChild = q23cInstitutionalSettingsWithOnlyChild;
	}

	public BigInteger getQ23CInstitutionalSettingsUnknownHouseHold() {
		return q23CInstitutionalSettingsUnknownHouseHold;
	}

	public void setQ23CInstitutionalSettingsUnknownHouseHold(
			BigInteger q23cInstitutionalSettingsUnknownHouseHold) {
		q23CInstitutionalSettingsUnknownHouseHold = q23cInstitutionalSettingsUnknownHouseHold;
	}

	public BigInteger getQ23C1FosterCareHomeOrGroupFosterCareTotal() {
		return q23C1FosterCareHomeOrGroupFosterCareTotal;
	}

	public void setQ23C1FosterCareHomeOrGroupFosterCareTotal(
			BigInteger q23c1FosterCareHomeOrGroupFosterCareTotal) {
		q23C1FosterCareHomeOrGroupFosterCareTotal = q23c1FosterCareHomeOrGroupFosterCareTotal;
	}

	public BigInteger getQ23C1FosterCareHomeOrGroupFosterCareWithoutChild() {
		return q23C1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public void setQ23C1FosterCareHomeOrGroupFosterCareWithoutChild(
			BigInteger q23c1FosterCareHomeOrGroupFosterCareWithoutChild) {
		q23C1FosterCareHomeOrGroupFosterCareWithoutChild = q23c1FosterCareHomeOrGroupFosterCareWithoutChild;
	}

	public BigInteger getQ23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults() {
		return q23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public void setQ23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults(
			BigInteger q23c1FosterCareHomeOrGroupFosterCareWithChildAndAdults) {
		q23C1FosterCareHomeOrGroupFosterCareWithChildAndAdults = q23c1FosterCareHomeOrGroupFosterCareWithChildAndAdults;
	}

	public BigInteger getQ23C1FosterCareHomeOrGroupFosterCareWithOnlyChild() {
		return q23C1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public void setQ23C1FosterCareHomeOrGroupFosterCareWithOnlyChild(
			BigInteger q23c1FosterCareHomeOrGroupFosterCareWithOnlyChild) {
		q23C1FosterCareHomeOrGroupFosterCareWithOnlyChild = q23c1FosterCareHomeOrGroupFosterCareWithOnlyChild;
	}

	public BigInteger getQ23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold() {
		return q23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public void setQ23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold(
			BigInteger q23c1FosterCareHomeOrGroupFosterCareUnknownHouseHold) {
		q23C1FosterCareHomeOrGroupFosterCareUnknownHouseHold = q23c1FosterCareHomeOrGroupFosterCareUnknownHouseHold;
	}

	public BigInteger getQ23C2PsychiatricHospitalOrOtherTotal() {
		return q23C2PsychiatricHospitalOrOtherTotal;
	}

	public void setQ23C2PsychiatricHospitalOrOtherTotal(
			BigInteger q23c2PsychiatricHospitalOrOtherTotal) {
		q23C2PsychiatricHospitalOrOtherTotal = q23c2PsychiatricHospitalOrOtherTotal;
	}

	public BigInteger getQ23C2PsychiatricHospitalOrOtherWithoutChild() {
		return q23C2PsychiatricHospitalOrOtherWithoutChild;
	}

	public void setQ23C2PsychiatricHospitalOrOtherWithoutChild(
			BigInteger q23c2PsychiatricHospitalOrOtherWithoutChild) {
		q23C2PsychiatricHospitalOrOtherWithoutChild = q23c2PsychiatricHospitalOrOtherWithoutChild;
	}

	public BigInteger getQ23C2PsychiatricHospitalOrOtherWithChildAndAdults() {
		return q23C2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public void setQ23C2PsychiatricHospitalOrOtherWithChildAndAdults(
			BigInteger q23c2PsychiatricHospitalOrOtherWithChildAndAdults) {
		q23C2PsychiatricHospitalOrOtherWithChildAndAdults = q23c2PsychiatricHospitalOrOtherWithChildAndAdults;
	}

	public BigInteger getQ23C2PsychiatricHospitalOrOtherWithOnlyChild() {
		return q23C2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public void setQ23C2PsychiatricHospitalOrOtherWithOnlyChild(
			BigInteger q23c2PsychiatricHospitalOrOtherWithOnlyChild) {
		q23C2PsychiatricHospitalOrOtherWithOnlyChild = q23c2PsychiatricHospitalOrOtherWithOnlyChild;
	}

	public BigInteger getQ23C2PsychiatricHospitalOrOtherUnknownHouseHold() {
		return q23C2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public void setQ23C2PsychiatricHospitalOrOtherUnknownHouseHold(
			BigInteger q23c2PsychiatricHospitalOrOtherUnknownHouseHold) {
		q23C2PsychiatricHospitalOrOtherUnknownHouseHold = q23c2PsychiatricHospitalOrOtherUnknownHouseHold;
	}

	public BigInteger getQ23C3SubstanceAbuseTreatmentFacilityTotal() {
		return q23C3SubstanceAbuseTreatmentFacilityTotal;
	}

	public void setQ23C3SubstanceAbuseTreatmentFacilityTotal(
			BigInteger q23c3SubstanceAbuseTreatmentFacilityTotal) {
		q23C3SubstanceAbuseTreatmentFacilityTotal = q23c3SubstanceAbuseTreatmentFacilityTotal;
	}

	public BigInteger getQ23C3SubstanceAbuseTreatmentFacilityWithoutChild() {
		return q23C3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public void setQ23C3SubstanceAbuseTreatmentFacilityWithoutChild(
			BigInteger q23c3SubstanceAbuseTreatmentFacilityWithoutChild) {
		q23C3SubstanceAbuseTreatmentFacilityWithoutChild = q23c3SubstanceAbuseTreatmentFacilityWithoutChild;
	}

	public BigInteger getQ23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults() {
		return q23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public void setQ23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults(
			BigInteger q23c3SubstanceAbuseTreatmentFacilityWithChildAndAdults) {
		q23C3SubstanceAbuseTreatmentFacilityWithChildAndAdults = q23c3SubstanceAbuseTreatmentFacilityWithChildAndAdults;
	}

	public BigInteger getQ23C3SubstanceAbuseTreatmentFacilityWithOnlyChild() {
		return q23C3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public void setQ23C3SubstanceAbuseTreatmentFacilityWithOnlyChild(
			BigInteger q23c3SubstanceAbuseTreatmentFacilityWithOnlyChild) {
		q23C3SubstanceAbuseTreatmentFacilityWithOnlyChild = q23c3SubstanceAbuseTreatmentFacilityWithOnlyChild;
	}

	public BigInteger getQ23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold() {
		return q23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public void setQ23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold(
			BigInteger q23c3SubstanceAbuseTreatmentFacilityUnknownHouseHold) {
		q23C3SubstanceAbuseTreatmentFacilityUnknownHouseHold = q23c3SubstanceAbuseTreatmentFacilityUnknownHouseHold;
	}

	public BigInteger getQ23C4HospitalOrOtherTotal() {
		return q23C4HospitalOrOtherTotal;
	}

	public void setQ23C4HospitalOrOtherTotal(BigInteger q23c4HospitalOrOtherTotal) {
		q23C4HospitalOrOtherTotal = q23c4HospitalOrOtherTotal;
	}

	public BigInteger getQ23C4HospitalOrOtherWithoutChild() {
		return q23C4HospitalOrOtherWithoutChild;
	}

	public void setQ23C4HospitalOrOtherWithoutChild(
			BigInteger q23c4HospitalOrOtherWithoutChild) {
		q23C4HospitalOrOtherWithoutChild = q23c4HospitalOrOtherWithoutChild;
	}

	public BigInteger getQ23C4HospitalOrOtherWithChildAndAdults() {
		return q23C4HospitalOrOtherWithChildAndAdults;
	}

	public void setQ23C4HospitalOrOtherWithChildAndAdults(
			BigInteger q23c4HospitalOrOtherWithChildAndAdults) {
		q23C4HospitalOrOtherWithChildAndAdults = q23c4HospitalOrOtherWithChildAndAdults;
	}

	public BigInteger getQ23C4HospitalOrOtherWithOnlyChild() {
		return q23C4HospitalOrOtherWithOnlyChild;
	}

	public void setQ23C4HospitalOrOtherWithOnlyChild(
			BigInteger q23c4HospitalOrOtherWithOnlyChild) {
		q23C4HospitalOrOtherWithOnlyChild = q23c4HospitalOrOtherWithOnlyChild;
	}

	public BigInteger getQ23C4HospitalOrOtherUnknownHouseHold() {
		return q23C4HospitalOrOtherUnknownHouseHold;
	}

	public void setQ23C4HospitalOrOtherUnknownHouseHold(
			BigInteger q23c4HospitalOrOtherUnknownHouseHold) {
		q23C4HospitalOrOtherUnknownHouseHold = q23c4HospitalOrOtherUnknownHouseHold;
	}

	public BigInteger getQ23C5JailPrisonOrJuvenileDetentionTotal() {
		return q23C5JailPrisonOrJuvenileDetentionTotal;
	}

	public void setQ23C5JailPrisonOrJuvenileDetentionTotal(
			BigInteger q23c5JailPrisonOrJuvenileDetentionTotal) {
		q23C5JailPrisonOrJuvenileDetentionTotal = q23c5JailPrisonOrJuvenileDetentionTotal;
	}

	public BigInteger getQ23C5JailPrisonOrJuvenileDetentionWithoutChild() {
		return q23C5JailPrisonOrJuvenileDetentionWithoutChild;
	}

	public void setQ23C5JailPrisonOrJuvenileDetentionWithoutChild(
			BigInteger q23c5JailPrisonOrJuvenileDetentionWithoutChild) {
		q23C5JailPrisonOrJuvenileDetentionWithoutChild = q23c5JailPrisonOrJuvenileDetentionWithoutChild;
	}

	public BigInteger getQ23C5JailPrisonOrJuvenileDetentionWithChildAndAdults() {
		return q23C5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	}

	public void setQ23C5JailPrisonOrJuvenileDetentionWithChildAndAdults(
			BigInteger q23c5JailPrisonOrJuvenileDetentionWithChildAndAdults) {
		q23C5JailPrisonOrJuvenileDetentionWithChildAndAdults = q23c5JailPrisonOrJuvenileDetentionWithChildAndAdults;
	}

	public BigInteger getQ23C5JailPrisonOrJuvenileDetentionWithOnlyChild() {
		return q23C5JailPrisonOrJuvenileDetentionWithOnlyChild;
	}

	public void setQ23C5JailPrisonOrJuvenileDetentionWithOnlyChild(
			BigInteger q23c5JailPrisonOrJuvenileDetentionWithOnlyChild) {
		q23C5JailPrisonOrJuvenileDetentionWithOnlyChild = q23c5JailPrisonOrJuvenileDetentionWithOnlyChild;
	}

	public BigInteger getQ23C5JailPrisonOrJuvenileDetentionUnknownHouseHold() {
		return q23C5JailPrisonOrJuvenileDetentionUnknownHouseHold;
	}

	public void setQ23C5JailPrisonOrJuvenileDetentionUnknownHouseHold(
			BigInteger q23c5JailPrisonOrJuvenileDetentionUnknownHouseHold) {
		q23C5JailPrisonOrJuvenileDetentionUnknownHouseHold = q23c5JailPrisonOrJuvenileDetentionUnknownHouseHold;
	}

	public BigInteger getQ23C6LongTermCareFacilityOrNursingHomeTotal() {
		return q23C6LongTermCareFacilityOrNursingHomeTotal;
	}

	public void setQ23C6LongTermCareFacilityOrNursingHomeTotal(
			BigInteger q23c6LongTermCareFacilityOrNursingHomeTotal) {
		q23C6LongTermCareFacilityOrNursingHomeTotal = q23c6LongTermCareFacilityOrNursingHomeTotal;
	}

	public BigInteger getQ23C6LongTermCareFacilityOrNursingHomeWithoutChild() {
		return q23C6LongTermCareFacilityOrNursingHomeWithoutChild;
	}

	public void setQ23C6LongTermCareFacilityOrNursingHomeWithoutChild(
			BigInteger q23c6LongTermCareFacilityOrNursingHomeWithoutChild) {
		q23C6LongTermCareFacilityOrNursingHomeWithoutChild = q23c6LongTermCareFacilityOrNursingHomeWithoutChild;
	}

	public BigInteger getQ23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults() {
		return q23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	}

	public void setQ23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults(
			BigInteger q23c6LongTermCareFacilityOrNursingHomeWithChildAndAdults) {
		q23C6LongTermCareFacilityOrNursingHomeWithChildAndAdults = q23c6LongTermCareFacilityOrNursingHomeWithChildAndAdults;
	}

	public BigInteger getQ23C6LongTermCareFacilityOrNursingHomeWithOnlyChild() {
		return q23C6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	}

	public void setQ23C6LongTermCareFacilityOrNursingHomeWithOnlyChild(
			BigInteger q23c6LongTermCareFacilityOrNursingHomeWithOnlyChild) {
		q23C6LongTermCareFacilityOrNursingHomeWithOnlyChild = q23c6LongTermCareFacilityOrNursingHomeWithOnlyChild;
	}

	public BigInteger getQ23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold() {
		return q23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
	}

	public void setQ23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold(
			BigInteger q23c6LongTermCareFacilityOrNursingHomeUnknownHouseHold) {
		q23C6LongTermCareFacilityOrNursingHomeUnknownHouseHold = q23c6LongTermCareFacilityOrNursingHomeUnknownHouseHold;
	}

	public BigInteger getQ23CzTotTotal() {
		return q23CzTotTotal;
	}

	public void setQ23CzTotTotal(BigInteger q23CzTotTotal) {
		this.q23CzTotTotal = q23CzTotTotal;
	}

	public BigInteger getQ23CzTotWithoutChild() {
		return q23CzTotWithoutChild;
	}

	public void setQ23CzTotWithoutChild(BigInteger q23CzTotWithoutChild) {
		this.q23CzTotWithoutChild = q23CzTotWithoutChild;
	}

	public BigInteger getQ23CzTotWithChildAndAdults() {
		return q23CzTotWithChildAndAdults;
	}

	public void setQ23CzTotWithChildAndAdults(BigInteger q23CzTotWithChildAndAdults) {
		this.q23CzTotWithChildAndAdults = q23CzTotWithChildAndAdults;
	}

	public BigInteger getQ23CzTotWithOnlyChild() {
		return q23CzTotWithOnlyChild;
	}

	public void setQ23CzTotWithOnlyChild(BigInteger q23CzTotWithOnlyChild) {
		this.q23CzTotWithOnlyChild = q23CzTotWithOnlyChild;
	}

	public BigInteger getQ23CzTotUnknownHouseHold() {
		return q23CzTotUnknownHouseHold;
	}

	public void setQ23CzTotUnknownHouseHold(BigInteger q23CzTotUnknownHouseHold) {
		this.q23CzTotUnknownHouseHold = q23CzTotUnknownHouseHold;
	}

	public BigInteger getQ23DOtherDestinationsTotal() {
		return q23DOtherDestinationsTotal;
	}

	public void setQ23DOtherDestinationsTotal(BigInteger q23dOtherDestinationsTotal) {
		q23DOtherDestinationsTotal = q23dOtherDestinationsTotal;
	}

	public BigInteger getQ23DOtherDestinationsWithoutChild() {
		return q23DOtherDestinationsWithoutChild;
	}

	public void setQ23DOtherDestinationsWithoutChild(
			BigInteger q23dOtherDestinationsWithoutChild) {
		q23DOtherDestinationsWithoutChild = q23dOtherDestinationsWithoutChild;
	}

	public BigInteger getQ23DOtherDestinationsWithChildAndAdults() {
		return q23DOtherDestinationsWithChildAndAdults;
	}

	public void setQ23DOtherDestinationsWithChildAndAdults(
			BigInteger q23dOtherDestinationsWithChildAndAdults) {
		q23DOtherDestinationsWithChildAndAdults = q23dOtherDestinationsWithChildAndAdults;
	}

	public BigInteger getQ23DOtherDestinationsWithOnlyChild() {
		return q23DOtherDestinationsWithOnlyChild;
	}

	public void setQ23DOtherDestinationsWithOnlyChild(
			BigInteger q23dOtherDestinationsWithOnlyChild) {
		q23DOtherDestinationsWithOnlyChild = q23dOtherDestinationsWithOnlyChild;
	}

	public BigInteger getQ23DOtherDestinationsUnknownHouseHold() {
		return q23DOtherDestinationsUnknownHouseHold;
	}

	public void setQ23DOtherDestinationsUnknownHouseHold(
			BigInteger q23dOtherDestinationsUnknownHouseHold) {
		q23DOtherDestinationsUnknownHouseHold = q23dOtherDestinationsUnknownHouseHold;
	}

	public BigInteger getQ23D1ResidentialProjectorHalfwayHouseTotal() {
		return q23D1ResidentialProjectorHalfwayHouseTotal;
	}

	public void setQ23D1ResidentialProjectorHalfwayHouseTotal(
			BigInteger q23d1ResidentialProjectorHalfwayHouseTotal) {
		q23D1ResidentialProjectorHalfwayHouseTotal = q23d1ResidentialProjectorHalfwayHouseTotal;
	}

	public BigInteger getQ23D1ResidentialProjectorHalfwayHouseWithoutChild() {
		return q23D1ResidentialProjectorHalfwayHouseWithoutChild;
	}

	public void setQ23D1ResidentialProjectorHalfwayHouseWithoutChild(
			BigInteger q23d1ResidentialProjectorHalfwayHouseWithoutChild) {
		q23D1ResidentialProjectorHalfwayHouseWithoutChild = q23d1ResidentialProjectorHalfwayHouseWithoutChild;
	}

	public BigInteger getQ23D1ResidentialProjectorHalfwayHouseWithChildAndAdults() {
		return q23D1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	}

	public void setQ23D1ResidentialProjectorHalfwayHouseWithChildAndAdults(
			BigInteger q23d1ResidentialProjectorHalfwayHouseWithChildAndAdults) {
		q23D1ResidentialProjectorHalfwayHouseWithChildAndAdults = q23d1ResidentialProjectorHalfwayHouseWithChildAndAdults;
	}

	public BigInteger getQ23D1ResidentialProjectorHalfwayHouseWithOnlyChild() {
		return q23D1ResidentialProjectorHalfwayHouseWithOnlyChild;
	}

	public void setQ23D1ResidentialProjectorHalfwayHouseWithOnlyChild(
			BigInteger q23d1ResidentialProjectorHalfwayHouseWithOnlyChild) {
		q23D1ResidentialProjectorHalfwayHouseWithOnlyChild = q23d1ResidentialProjectorHalfwayHouseWithOnlyChild;
	}

	public BigInteger getQ23D1ResidentialProjectorHalfwayHouseUnknownHouseHold() {
		return q23D1ResidentialProjectorHalfwayHouseUnknownHouseHold;
	}

	public void setQ23D1ResidentialProjectorHalfwayHouseUnknownHouseHold(
			BigInteger q23d1ResidentialProjectorHalfwayHouseUnknownHouseHold) {
		q23D1ResidentialProjectorHalfwayHouseUnknownHouseHold = q23d1ResidentialProjectorHalfwayHouseUnknownHouseHold;
	}

	public BigInteger getQ23D2DeceasedTotal() {
		return q23D2DeceasedTotal;
	}

	public void setQ23D2DeceasedTotal(BigInteger q23d2DeceasedTotal) {
		q23D2DeceasedTotal = q23d2DeceasedTotal;
	}

	public BigInteger getQ23D2DeceasedWithoutChild() {
		return q23D2DeceasedWithoutChild;
	}

	public void setQ23D2DeceasedWithoutChild(BigInteger q23d2DeceasedWithoutChild) {
		q23D2DeceasedWithoutChild = q23d2DeceasedWithoutChild;
	}

	public BigInteger getQ23D2DeceasedWithChildAndAdults() {
		return q23D2DeceasedWithChildAndAdults;
	}

	public void setQ23D2DeceasedWithChildAndAdults(
			BigInteger q23d2DeceasedWithChildAndAdults) {
		q23D2DeceasedWithChildAndAdults = q23d2DeceasedWithChildAndAdults;
	}

	public BigInteger getQ23D2DeceasedWithOnlyChild() {
		return q23D2DeceasedWithOnlyChild;
	}

	public void setQ23D2DeceasedWithOnlyChild(BigInteger q23d2DeceasedWithOnlyChild) {
		q23D2DeceasedWithOnlyChild = q23d2DeceasedWithOnlyChild;
	}

	public BigInteger getQ23D2DeceasedUnknownHouseHold() {
		return q23D2DeceasedUnknownHouseHold;
	}

	public void setQ23D2DeceasedUnknownHouseHold(
			BigInteger q23d2DeceasedUnknownHouseHold) {
		q23D2DeceasedUnknownHouseHold = q23d2DeceasedUnknownHouseHold;
	}

	public BigInteger getQ23D3OtherTotal() {
		return q23D3OtherTotal;
	}

	public void setQ23D3OtherTotal(BigInteger q23d3OtherTotal) {
		q23D3OtherTotal = q23d3OtherTotal;
	}

	public BigInteger getQ23D3OtherWithoutChild() {
		return q23D3OtherWithoutChild;
	}

	public void setQ23D3OtherWithoutChild(BigInteger q23d3OtherWithoutChild) {
		q23D3OtherWithoutChild = q23d3OtherWithoutChild;
	}

	public BigInteger getQ23D3OtherWithChildAndAdults() {
		return q23D3OtherWithChildAndAdults;
	}

	public void setQ23D3OtherWithChildAndAdults(
			BigInteger q23d3OtherWithChildAndAdults) {
		q23D3OtherWithChildAndAdults = q23d3OtherWithChildAndAdults;
	}

	public BigInteger getQ23D3OtherWithOnlyChild() {
		return q23D3OtherWithOnlyChild;
	}

	public void setQ23D3OtherWithOnlyChild(BigInteger q23d3OtherWithOnlyChild) {
		q23D3OtherWithOnlyChild = q23d3OtherWithOnlyChild;
	}

	public BigInteger getQ23D3OtherUnknownHouseHold() {
		return q23D3OtherUnknownHouseHold;
	}

	public void setQ23D3OtherUnknownHouseHold(BigInteger q23d3OtherUnknownHouseHold) {
		q23D3OtherUnknownHouseHold = q23d3OtherUnknownHouseHold;
	}

	public BigInteger getQ23D4DKRTotal() {
		return q23D4DKRTotal;
	}

	public void setQ23D4DKRTotal(BigInteger q23d4dkrTotal) {
		q23D4DKRTotal = q23d4dkrTotal;
	}

	public BigInteger getQ23D4DKRWithoutChild() {
		return q23D4DKRWithoutChild;
	}

	public void setQ23D4DKRWithoutChild(BigInteger q23d4dkrWithoutChild) {
		q23D4DKRWithoutChild = q23d4dkrWithoutChild;
	}

	public BigInteger getQ23D4DKRWithChildAndAdults() {
		return q23D4DKRWithChildAndAdults;
	}

	public void setQ23D4DKRWithChildAndAdults(BigInteger q23d4dkrWithChildAndAdults) {
		q23D4DKRWithChildAndAdults = q23d4dkrWithChildAndAdults;
	}

	public BigInteger getQ23D4DKRWithOnlyChild() {
		return q23D4DKRWithOnlyChild;
	}

	public void setQ23D4DKRWithOnlyChild(BigInteger q23d4dkrWithOnlyChild) {
		q23D4DKRWithOnlyChild = q23d4dkrWithOnlyChild;
	}

	public BigInteger getQ23D4DKRUnknownHouseHold() {
		return q23D4DKRUnknownHouseHold;
	}

	public void setQ23D4DKRUnknownHouseHold(BigInteger q23d4dkrUnknownHouseHold) {
		q23D4DKRUnknownHouseHold = q23d4dkrUnknownHouseHold;
	}

	public BigInteger getQ23D5InfoMissingTotal() {
		return q23D5InfoMissingTotal;
	}

	public void setQ23D5InfoMissingTotal(BigInteger q23d5InfoMissingTotal) {
		q23D5InfoMissingTotal = q23d5InfoMissingTotal;
	}

	public BigInteger getQ23D5InfoMissingWithoutChild() {
		return q23D5InfoMissingWithoutChild;
	}

	public void setQ23D5InfoMissingWithoutChild(
			BigInteger q23d5InfoMissingWithoutChild) {
		q23D5InfoMissingWithoutChild = q23d5InfoMissingWithoutChild;
	}

	public BigInteger getQ23D5InfoMissingWithChildAndAdults() {
		return q23D5InfoMissingWithChildAndAdults;
	}

	public void setQ23D5InfoMissingWithChildAndAdults(
			BigInteger q23d5InfoMissingWithChildAndAdults) {
		q23D5InfoMissingWithChildAndAdults = q23d5InfoMissingWithChildAndAdults;
	}

	public BigInteger getQ23D5InfoMissingWithOnlyChild() {
		return q23D5InfoMissingWithOnlyChild;
	}

	public void setQ23D5InfoMissingWithOnlyChild(
			BigInteger q23d5InfoMissingWithOnlyChild) {
		q23D5InfoMissingWithOnlyChild = q23d5InfoMissingWithOnlyChild;
	}

	public BigInteger getQ23D5InfoMissingUnknownHouseHold() {
		return q23D5InfoMissingUnknownHouseHold;
	}

	public void setQ23D5InfoMissingUnknownHouseHold(
			BigInteger q23d5InfoMissingUnknownHouseHold) {
		q23D5InfoMissingUnknownHouseHold = q23d5InfoMissingUnknownHouseHold;
	}

	public BigInteger getQ23DzTotTotal() {
		return q23DzTotTotal;
	}

	public void setQ23DzTotTotal(BigInteger q23DzTotTotal) {
		this.q23DzTotTotal = q23DzTotTotal;
	}

	public BigInteger getQ23DzTotWithoutChild() {
		return q23DzTotWithoutChild;
	}

	public void setQ23DzTotWithoutChild(BigInteger q23DzTotWithoutChild) {
		this.q23DzTotWithoutChild = q23DzTotWithoutChild;
	}

	public BigInteger getQ23DzTotWithChildAndAdults() {
		return q23DzTotWithChildAndAdults;
	}

	public void setQ23DzTotWithChildAndAdults(BigInteger q23DzTotWithChildAndAdults) {
		this.q23DzTotWithChildAndAdults = q23DzTotWithChildAndAdults;
	}

	public BigInteger getQ23DzTotWithOnlyChild() {
		return q23DzTotWithOnlyChild;
	}

	public void setQ23DzTotWithOnlyChild(BigInteger q23DzTotWithOnlyChild) {
		this.q23DzTotWithOnlyChild = q23DzTotWithOnlyChild;
	}

	public BigInteger getQ23DzTotUnknownHouseHold() {
		return q23DzTotUnknownHouseHold;
	}

	public void setQ23DzTotUnknownHouseHold(BigInteger q23DzTotUnknownHouseHold) {
		this.q23DzTotUnknownHouseHold = q23DzTotUnknownHouseHold;
	}

	public BigInteger getQ23ETotTotal() {
		return q23ETotTotal;
	}

	public void setQ23ETotTotal(BigInteger q23eTotTotal) {
		q23ETotTotal = q23eTotTotal;
	}

	public BigInteger getQ23ETotWithoutChild() {
		return q23ETotWithoutChild;
	}

	public void setQ23ETotWithoutChild(BigInteger q23eTotWithoutChild) {
		q23ETotWithoutChild = q23eTotWithoutChild;
	}

	public BigInteger getQ23ETotWithChildAndAdults() {
		return q23ETotWithChildAndAdults;
	}

	public void setQ23ETotWithChildAndAdults(BigInteger q23eTotWithChildAndAdults) {
		q23ETotWithChildAndAdults = q23eTotWithChildAndAdults;
	}

	public BigInteger getQ23ETotWithOnlyChild() {
		return q23ETotWithOnlyChild;
	}

	public void setQ23ETotWithOnlyChild(BigInteger q23eTotWithOnlyChild) {
		q23ETotWithOnlyChild = q23eTotWithOnlyChild;
	}

	public BigInteger getQ23ETotUnknownHouseHold() {
		return q23ETotUnknownHouseHold;
	}

	public void setQ23ETotUnknownHouseHold(BigInteger q23eTotUnknownHouseHold) {
		q23ETotUnknownHouseHold = q23eTotUnknownHouseHold;
	}

	public BigInteger getQ23PercentageWithChildAndAdults() {
		return q23PercentageWithChildAndAdults;
	}

	public void setQ23PercentageWithChildAndAdults(
			BigInteger q23PercentageWithChildAndAdults) {
		this.q23PercentageWithChildAndAdults = q23PercentageWithChildAndAdults;
	}

	public BigInteger getQ23PercentageUnknownHouseHold() {
		return q23PercentageUnknownHouseHold;
	}

	public void setQ23PercentageUnknownHouseHold(
			BigInteger q23PercentageUnknownHouseHold) {
		this.q23PercentageUnknownHouseHold = q23PercentageUnknownHouseHold;
	}

	public BigInteger getQ23PercentageWithOnlyChild() {
		return q23PercentageWithOnlyChild;
	}

	public void setQ23PercentageWithOnlyChild(BigInteger q23PercentageWithOnlyChild) {
		this.q23PercentageWithOnlyChild = q23PercentageWithOnlyChild;
	}

	public BigInteger getQ23PercentageWithoutChild() {
		return q23PercentageWithoutChild;
	}

	public void setQ23PercentageWithoutChild(BigInteger q23PercentageWithoutChild) {
		this.q23PercentageWithoutChild = q23PercentageWithoutChild;
	}

	public BigInteger getQ23PercentageTotal() {
		return q23PercentageTotal;
	}

	public void setQ23PercentageTotal(BigInteger q23PercentageTotal) {
		this.q23PercentageTotal = q23PercentageTotal;
	}

	public BigInteger getQ23TotPersonsDstnsWithoutChild() {
		return q23TotPersonsDstnsWithoutChild;
	}

	public void setQ23TotPersonsDstnsWithoutChild(
			BigInteger q23TotPersonsDstnsWithoutChild) {
		this.q23TotPersonsDstnsWithoutChild = q23TotPersonsDstnsWithoutChild;
	}

	public BigInteger getQ23TotPersonsDstnsTotal() {
		return q23TotPersonsDstnsTotal;
	}

	public void setQ23TotPersonsDstnsTotal(BigInteger q23TotPersonsDstnsTotal) {
		this.q23TotPersonsDstnsTotal = q23TotPersonsDstnsTotal;
	}

	public BigInteger getQ23TotPersonsDstnsUnknownHouseHold() {
		return q23TotPersonsDstnsUnknownHouseHold;
	}

	public void setQ23TotPersonsDstnsUnknownHouseHold(
			BigInteger q23TotPersonsDstnsUnknownHouseHold) {
		this.q23TotPersonsDstnsUnknownHouseHold = q23TotPersonsDstnsUnknownHouseHold;
	}

	public BigInteger getQ23TotPersonsDstnsWithOnlyChild() {
		return q23TotPersonsDstnsWithOnlyChild;
	}

	public void setQ23TotPersonsDstnsWithOnlyChild(
			BigInteger q23TotPersonsDstnsWithOnlyChild) {
		this.q23TotPersonsDstnsWithOnlyChild = q23TotPersonsDstnsWithOnlyChild;
	}

	public BigInteger getQ23TotPersonsDstnsWithChildAndAdults() {
		return q23TotPersonsDstnsWithChildAndAdults;
	}

	public void setQ23TotPersonsDstnsWithChildAndAdults(
			BigInteger q23TotPersonsDstnsWithChildAndAdults) {
		this.q23TotPersonsDstnsWithChildAndAdults = q23TotPersonsDstnsWithChildAndAdults;
	}

	public BigInteger getQ23TotPersonsExistTotal() {
		return q23TotPersonsExistTotal;
	}

	public void setQ23TotPersonsExistTotal(BigInteger q23TotPersonsExistTotal) {
		this.q23TotPersonsExistTotal = q23TotPersonsExistTotal;
	}

	public BigInteger getQ23TotPersonsExistWithoutChild() {
		return q23TotPersonsExistWithoutChild;
	}

	public void setQ23TotPersonsExistWithoutChild(
			BigInteger q23TotPersonsExistWithoutChild) {
		this.q23TotPersonsExistWithoutChild = q23TotPersonsExistWithoutChild;
	}

	public BigInteger getQ23TotPersonsExistWithChildAndAdults() {
		return q23TotPersonsExistWithChildAndAdults;
	}

	public void setQ23TotPersonsExistWithChildAndAdults(
			BigInteger q23TotPersonsExistWithChildAndAdults) {
		this.q23TotPersonsExistWithChildAndAdults = q23TotPersonsExistWithChildAndAdults;
	}

	public BigInteger getQ23TotPersonsExistWithOnlyChild() {
		return q23TotPersonsExistWithOnlyChild;
	}

	public void setQ23TotPersonsExistWithOnlyChild(
			BigInteger q23TotPersonsExistWithOnlyChild) {
		this.q23TotPersonsExistWithOnlyChild = q23TotPersonsExistWithOnlyChild;
	}

	public BigInteger getQ23TotPersonsExistUnknownHouseHold() {
		return q23TotPersonsExistUnknownHouseHold;
	}

	public void setQ23TotPersonsExistUnknownHouseHold(
			BigInteger q23TotPersonsExistUnknownHouseHold) {
		this.q23TotPersonsExistUnknownHouseHold = q23TotPersonsExistUnknownHouseHold;
	}

	public String getTotNumOfPersonServed() {
		return totNumOfPersonServed;
	}
	/*public String getHomePageStartDate() {
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
	}*/
	
	public BigInteger getQ22bAverageLengthInDaysTotal() {
		return q22bAverageLengthInDaysTotal;
	}

	public void setQ22bAverageLengthInDaysTotal(
			BigInteger q22bAverageLengthInDaysTotal) {
		this.q22bAverageLengthInDaysTotal = q22bAverageLengthInDaysTotal;
	}

	public BigInteger getQ22bAverageLengthInDaysLeavers() {
		return q22bAverageLengthInDaysLeavers;
	}

	public void setQ22bAverageLengthInDaysLeavers(
			BigInteger q22bAverageLengthInDaysLeavers) {
		this.q22bAverageLengthInDaysLeavers = q22bAverageLengthInDaysLeavers;
	}

	public BigInteger getQ22bAverageLengthInDaysStayers() {
		return q22bAverageLengthInDaysStayers;
	}

	public void setQ22bAverageLengthInDaysStayers(
			BigInteger q22bAverageLengthInDaysStayers) {
		this.q22bAverageLengthInDaysStayers = q22bAverageLengthInDaysStayers;
	}

	public BigInteger getQ22bMedianLengthInDaysTotal() {
		return q22bMedianLengthInDaysTotal;
	}

	public void setQ22bMedianLengthInDaysTotal(
			BigInteger q22bMedianLengthInDaysTotal) {
		this.q22bMedianLengthInDaysTotal = q22bMedianLengthInDaysTotal;
	}

	public BigInteger getQ22bMedianLengthInDaysLeavers() {
		return q22bMedianLengthInDaysLeavers;
	}

	public void setQ22bMedianLengthInDaysLeavers(
			BigInteger q22bMedianLengthInDaysLeavers) {
		this.q22bMedianLengthInDaysLeavers = q22bMedianLengthInDaysLeavers;
	}

	public BigInteger getQ22bMedianLengthInDaysStayers() {
		return q22bMedianLengthInDaysStayers;
	}

	public void setQ22bMedianLengthInDaysStayers(
			BigInteger q22bMedianLengthInDaysStayers) {
		this.q22bMedianLengthInDaysStayers = q22bMedianLengthInDaysStayers;
	}

	public BigInteger getQ22a1A30DaysOrLessTotal() {
		return q22a1A30DaysOrLessTotal;
	}

	public void setQ22a1A30DaysOrLessTotal(BigInteger q22a1a30DaysOrLessTotal) {
		q22a1A30DaysOrLessTotal = q22a1a30DaysOrLessTotal;
	}

	public BigInteger getQ22a1A30DaysOrLessLeavers() {
		return q22a1A30DaysOrLessLeavers;
	}

	public void setQ22a1A30DaysOrLessLeavers(BigInteger q22a1a30DaysOrLessLeavers) {
		q22a1A30DaysOrLessLeavers = q22a1a30DaysOrLessLeavers;
	}

	public BigInteger getQ22a1A30DaysOrLessStayers() {
		return q22a1A30DaysOrLessStayers;
	}

	public void setQ22a1A30DaysOrLessStayers(BigInteger q22a1a30DaysOrLessStayers) {
		q22a1A30DaysOrLessStayers = q22a1a30DaysOrLessStayers;
	}

	public BigInteger getQ22a1B31To60DaysTotal() {
		return q22a1B31To60DaysTotal;
	}

	public void setQ22a1B31To60DaysTotal(BigInteger q22a1b31To60DaysTotal) {
		q22a1B31To60DaysTotal = q22a1b31To60DaysTotal;
	}

	public BigInteger getQ22a1B31To60DaysLeavers() {
		return q22a1B31To60DaysLeavers;
	}

	public void setQ22a1B31To60DaysLeavers(BigInteger q22a1b31To60DaysLeavers) {
		q22a1B31To60DaysLeavers = q22a1b31To60DaysLeavers;
	}

	public BigInteger getQ22a1B31To60DaysStayers() {
		return q22a1B31To60DaysStayers;
	}

	public void setQ22a1B31To60DaysStayers(BigInteger q22a1b31To60DaysStayers) {
		q22a1B31To60DaysStayers = q22a1b31To60DaysStayers;
	}

	public BigInteger getQ22a1C61To180DaysTotal() {
		return q22a1C61To180DaysTotal;
	}

	public void setQ22a1C61To180DaysTotal(BigInteger q22a1c61To180DaysTotal) {
		q22a1C61To180DaysTotal = q22a1c61To180DaysTotal;
	}

	public BigInteger getQ22a1C61To180DaysLeavers() {
		return q22a1C61To180DaysLeavers;
	}

	public void setQ22a1C61To180DaysLeavers(BigInteger q22a1c61To180DaysLeavers) {
		q22a1C61To180DaysLeavers = q22a1c61To180DaysLeavers;
	}

	public BigInteger getQ22a1C61To180DaysStayers() {
		return q22a1C61To180DaysStayers;
	}

	public void setQ22a1C61To180DaysStayers(BigInteger q22a1c61To180DaysStayers) {
		q22a1C61To180DaysStayers = q22a1c61To180DaysStayers;
	}

	public BigInteger getQ22a1D181To365DaysTotal() {
		return q22a1D181To365DaysTotal;
	}

	public void setQ22a1D181To365DaysTotal(BigInteger q22a1d181To365DaysTotal) {
		q22a1D181To365DaysTotal = q22a1d181To365DaysTotal;
	}

	public BigInteger getQ22a1D181To365DaysLeavers() {
		return q22a1D181To365DaysLeavers;
	}

	public void setQ22a1D181To365DaysLeavers(BigInteger q22a1d181To365DaysLeavers) {
		q22a1D181To365DaysLeavers = q22a1d181To365DaysLeavers;
	}

	public BigInteger getQ22a1D181To365DaysStayers() {
		return q22a1D181To365DaysStayers;
	}

	public void setQ22a1D181To365DaysStayers(BigInteger q22a1d181To365DaysStayers) {
		q22a1D181To365DaysStayers = q22a1d181To365DaysStayers;
	}

	public BigInteger getQ22a1E366To730DaysTotal() {
		return q22a1E366To730DaysTotal;
	}

	public void setQ22a1E366To730DaysTotal(BigInteger q22a1e366To730DaysTotal) {
		q22a1E366To730DaysTotal = q22a1e366To730DaysTotal;
	}

	public BigInteger getQ22a1E366To730DaysLeavers() {
		return q22a1E366To730DaysLeavers;
	}

	public void setQ22a1E366To730DaysLeavers(BigInteger q22a1e366To730DaysLeavers) {
		q22a1E366To730DaysLeavers = q22a1e366To730DaysLeavers;
	}

	public BigInteger getQ22a1E366To730DaysStayers() {
		return q22a1E366To730DaysStayers;
	}

	public void setQ22a1E366To730DaysStayers(BigInteger q22a1e366To730DaysStayers) {
		q22a1E366To730DaysStayers = q22a1e366To730DaysStayers;
	}

	public BigInteger getQ22a1F731To1095DaysTotal() {
		return q22a1F731To1095DaysTotal;
	}

	public void setQ22a1F731To1095DaysTotal(BigInteger q22a1f731To1095DaysTotal) {
		q22a1F731To1095DaysTotal = q22a1f731To1095DaysTotal;
	}

	public BigInteger getQ22a1F731To1095DaysLeavers() {
		return q22a1F731To1095DaysLeavers;
	}

	public void setQ22a1F731To1095DaysLeavers(BigInteger q22a1f731To1095DaysLeavers) {
		q22a1F731To1095DaysLeavers = q22a1f731To1095DaysLeavers;
	}

	public BigInteger getQ22a1F731To1095DaysStayers() {
		return q22a1F731To1095DaysStayers;
	}

	public void setQ22a1F731To1095DaysStayers(BigInteger q22a1f731To1095DaysStayers) {
		q22a1F731To1095DaysStayers = q22a1f731To1095DaysStayers;
	}

	public BigInteger getQ22a1G1096To1460DaysTotal() {
		return q22a1G1096To1460DaysTotal;
	}

	public void setQ22a1G1096To1460DaysTotal(BigInteger q22a1g1096To1460DaysTotal) {
		q22a1G1096To1460DaysTotal = q22a1g1096To1460DaysTotal;
	}

	public BigInteger getQ22a1G1096To1460DaysLeavers() {
		return q22a1G1096To1460DaysLeavers;
	}

	public void setQ22a1G1096To1460DaysLeavers(
			BigInteger q22a1g1096To1460DaysLeavers) {
		q22a1G1096To1460DaysLeavers = q22a1g1096To1460DaysLeavers;
	}

	public BigInteger getQ22a1G1096To1460DaysStayers() {
		return q22a1G1096To1460DaysStayers;
	}

	public void setQ22a1G1096To1460DaysStayers(
			BigInteger q22a1g1096To1460DaysStayers) {
		q22a1G1096To1460DaysStayers = q22a1g1096To1460DaysStayers;
	}

	public BigInteger getQ22a1H1461To1825DaysTotal() {
		return q22a1H1461To1825DaysTotal;
	}

	public void setQ22a1H1461To1825DaysTotal(BigInteger q22a1h1461To1825DaysTotal) {
		q22a1H1461To1825DaysTotal = q22a1h1461To1825DaysTotal;
	}

	public BigInteger getQ22a1H1461To1825DaysLeavers() {
		return q22a1H1461To1825DaysLeavers;
	}

	public void setQ22a1H1461To1825DaysLeavers(
			BigInteger q22a1h1461To1825DaysLeavers) {
		q22a1H1461To1825DaysLeavers = q22a1h1461To1825DaysLeavers;
	}

	public BigInteger getQ22a1H1461To1825DaysStayers() {
		return q22a1H1461To1825DaysStayers;
	}

	public void setQ22a1H1461To1825DaysStayers(
			BigInteger q22a1h1461To1825DaysStayers) {
		q22a1H1461To1825DaysStayers = q22a1h1461To1825DaysStayers;
	}

	public BigInteger getQ22a1IMoreThan1825DaysTotal() {
		return q22a1IMoreThan1825DaysTotal;
	}

	public void setQ22a1IMoreThan1825DaysTotal(
			BigInteger q22a1iMoreThan1825DaysTotal) {
		q22a1IMoreThan1825DaysTotal = q22a1iMoreThan1825DaysTotal;
	}

	public BigInteger getQ22a1IMoreThan1825DaysLeavers() {
		return q22a1IMoreThan1825DaysLeavers;
	}

	public void setQ22a1IMoreThan1825DaysLeavers(
			BigInteger q22a1iMoreThan1825DaysLeavers) {
		q22a1IMoreThan1825DaysLeavers = q22a1iMoreThan1825DaysLeavers;
	}

	public BigInteger getQ22a1IMoreThan1825DaysStayers() {
		return q22a1IMoreThan1825DaysStayers;
	}

	public void setQ22a1IMoreThan1825DaysStayers(
			BigInteger q22a1iMoreThan1825DaysStayers) {
		q22a1IMoreThan1825DaysStayers = q22a1iMoreThan1825DaysStayers;
	}

	public BigInteger getQ22a1JInfoMissingTotal() {
		return q22a1JInfoMissingTotal;
	}

	public void setQ22a1JInfoMissingTotal(BigInteger q22a1jInfoMissingTotal) {
		q22a1JInfoMissingTotal = q22a1jInfoMissingTotal;
	}

	public BigInteger getQ22a1JInfoMissingLeavers() {
		return q22a1JInfoMissingLeavers;
	}

	public void setQ22a1JInfoMissingLeavers(BigInteger q22a1jInfoMissingLeavers) {
		q22a1JInfoMissingLeavers = q22a1jInfoMissingLeavers;
	}

	public BigInteger getQ22a1JInfoMissingStayers() {
		return q22a1JInfoMissingStayers;
	}

	public void setQ22a1JInfoMissingStayers(BigInteger q22a1jInfoMissingStayers) {
		q22a1JInfoMissingStayers = q22a1jInfoMissingStayers;
	}

	public BigInteger getQ22a1KTotTotal() {
		return q22a1KTotTotal;
	}

	public void setQ22a1KTotTotal(BigInteger q22a1kTotTotal) {
		q22a1KTotTotal = q22a1kTotTotal;
	}

	public BigInteger getQ22a1KTotLeavers() {
		return q22a1KTotLeavers;
	}

	public void setQ22a1KTotLeavers(BigInteger q22a1kTotLeavers) {
		q22a1KTotLeavers = q22a1kTotLeavers;
	}

	public BigInteger getQ22a1KTotStayers() {
		return q22a1KTotStayers;
	}

	public void setQ22a1KTotStayers(BigInteger q22a1kTotStayers) {
		q22a1KTotStayers = q22a1kTotStayers;
	}

	public BigInteger getQ21AMedicaidHealthInsuranceAtEntry() {
		return q21AMedicaidHealthInsuranceAtEntry;
	}

	public void setQ21AMedicaidHealthInsuranceAtEntry(
			BigInteger q21aMedicaidHealthInsuranceAtEntry) {
		q21AMedicaidHealthInsuranceAtEntry = q21aMedicaidHealthInsuranceAtEntry;
	}

	public BigInteger getQ21AMedicaidHealthInsuranceAtLatestStayers() {
		return q21AMedicaidHealthInsuranceAtLatestStayers;
	}

	public void setQ21AMedicaidHealthInsuranceAtLatestStayers(
			BigInteger q21aMedicaidHealthInsuranceAtLatestStayers) {
		q21AMedicaidHealthInsuranceAtLatestStayers = q21aMedicaidHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21AMedicaidHealthInsuranceAtExitLeavers() {
		return q21AMedicaidHealthInsuranceAtExitLeavers;
	}

	public void setQ21AMedicaidHealthInsuranceAtExitLeavers(
			BigInteger q21aMedicaidHealthInsuranceAtExitLeavers) {
		q21AMedicaidHealthInsuranceAtExitLeavers = q21aMedicaidHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21BMedicaidHealthInsuranceAtEntry() {
		return q21BMedicaidHealthInsuranceAtEntry;
	}

	public void setQ21BMedicaidHealthInsuranceAtEntry(
			BigInteger q21bMedicaidHealthInsuranceAtEntry) {
		q21BMedicaidHealthInsuranceAtEntry = q21bMedicaidHealthInsuranceAtEntry;
	}

	public BigInteger getQ21BMedicaidHealthInsuranceAtLatestStayers() {
		return q21BMedicaidHealthInsuranceAtLatestStayers;
	}

	public void setQ21BMedicaidHealthInsuranceAtLatestStayers(
			BigInteger q21bMedicaidHealthInsuranceAtLatestStayers) {
		q21BMedicaidHealthInsuranceAtLatestStayers = q21bMedicaidHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21BMedicaidHealthInsuranceAtExitLeavers() {
		return q21BMedicaidHealthInsuranceAtExitLeavers;
	}

	public void setQ21BMedicaidHealthInsuranceAtExitLeavers(
			BigInteger q21bMedicaidHealthInsuranceAtExitLeavers) {
		q21BMedicaidHealthInsuranceAtExitLeavers = q21bMedicaidHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21CStateChildHealthInsuranceAtEntry() {
		return q21CStateChildHealthInsuranceAtEntry;
	}

	public void setQ21CStateChildHealthInsuranceAtEntry(
			BigInteger q21cStateChildHealthInsuranceAtEntry) {
		q21CStateChildHealthInsuranceAtEntry = q21cStateChildHealthInsuranceAtEntry;
	}

	public BigInteger getQ21CStateChildHealthInsuranceAtLatestStayers() {
		return q21CStateChildHealthInsuranceAtLatestStayers;
	}

	public void setQ21CStateChildHealthInsuranceAtLatestStayers(
			BigInteger q21cStateChildHealthInsuranceAtLatestStayers) {
		q21CStateChildHealthInsuranceAtLatestStayers = q21cStateChildHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21CStateChildHealthInsuranceAtExitLeavers() {
		return q21CStateChildHealthInsuranceAtExitLeavers;
	}

	public void setQ21CStateChildHealthInsuranceAtExitLeavers(
			BigInteger q21cStateChildHealthInsuranceAtExitLeavers) {
		q21CStateChildHealthInsuranceAtExitLeavers = q21cStateChildHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21DVAMedicalServicesAtEntry() {
		return q21DVAMedicalServicesAtEntry;
	}

	public void setQ21DVAMedicalServicesAtEntry(
			BigInteger q21dvaMedicalServicesAtEntry) {
		q21DVAMedicalServicesAtEntry = q21dvaMedicalServicesAtEntry;
	}

	public BigInteger getQ21DVAMedicalServicesAtLatestStayers() {
		return q21DVAMedicalServicesAtLatestStayers;
	}

	public void setQ21DVAMedicalServicesAtLatestStayers(
			BigInteger q21dvaMedicalServicesAtLatestStayers) {
		q21DVAMedicalServicesAtLatestStayers = q21dvaMedicalServicesAtLatestStayers;
	}

	public BigInteger getQ21DVAMedicalServicesAtExitLeavers() {
		return q21DVAMedicalServicesAtExitLeavers;
	}

	public void setQ21DVAMedicalServicesAtExitLeavers(
			BigInteger q21dvaMedicalServicesAtExitLeavers) {
		q21DVAMedicalServicesAtExitLeavers = q21dvaMedicalServicesAtExitLeavers;
	}

	public BigInteger getQ21EEmployerProvidedHealthInsuranceAtEntry() {
		return q21EEmployerProvidedHealthInsuranceAtEntry;
	}

	public void setQ21EEmployerProvidedHealthInsuranceAtEntry(
			BigInteger q21eEmployerProvidedHealthInsuranceAtEntry) {
		q21EEmployerProvidedHealthInsuranceAtEntry = q21eEmployerProvidedHealthInsuranceAtEntry;
	}

	public BigInteger getQ21EEmployerProvidedHealthInsuranceAtLatestStayers() {
		return q21EEmployerProvidedHealthInsuranceAtLatestStayers;
	}

	public void setQ21EEmployerProvidedHealthInsuranceAtLatestStayers(
			BigInteger q21eEmployerProvidedHealthInsuranceAtLatestStayers) {
		q21EEmployerProvidedHealthInsuranceAtLatestStayers = q21eEmployerProvidedHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21EEmployerProvidedHealthInsuranceAtExitLeavers() {
		return q21EEmployerProvidedHealthInsuranceAtExitLeavers;
	}

	public void setQ21EEmployerProvidedHealthInsuranceAtExitLeavers(
			BigInteger q21eEmployerProvidedHealthInsuranceAtExitLeavers) {
		q21EEmployerProvidedHealthInsuranceAtExitLeavers = q21eEmployerProvidedHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21FHealthInsuranceThroughCobraAtEntry() {
		return q21FHealthInsuranceThroughCobraAtEntry;
	}

	public void setQ21FHealthInsuranceThroughCobraAtEntry(
			BigInteger q21fHealthInsuranceThroughCobraAtEntry) {
		q21FHealthInsuranceThroughCobraAtEntry = q21fHealthInsuranceThroughCobraAtEntry;
	}

	public BigInteger getQ21FHealthInsuranceThroughCobraAtLatestStayers() {
		return q21FHealthInsuranceThroughCobraAtLatestStayers;
	}

	public void setQ21FHealthInsuranceThroughCobraAtLatestStayers(
			BigInteger q21fHealthInsuranceThroughCobraAtLatestStayers) {
		q21FHealthInsuranceThroughCobraAtLatestStayers = q21fHealthInsuranceThroughCobraAtLatestStayers;
	}

	public BigInteger getQ21FHealthInsuranceThroughCobraAtExitLeavers() {
		return q21FHealthInsuranceThroughCobraAtExitLeavers;
	}

	public void setQ21FHealthInsuranceThroughCobraAtExitLeavers(
			BigInteger q21fHealthInsuranceThroughCobraAtExitLeavers) {
		q21FHealthInsuranceThroughCobraAtExitLeavers = q21fHealthInsuranceThroughCobraAtExitLeavers;
	}

	public BigInteger getQ21GPrivatePayHealthInsuranceAtEntry() {
		return q21GPrivatePayHealthInsuranceAtEntry;
	}

	public void setQ21GPrivatePayHealthInsuranceAtEntry(
			BigInteger q21gPrivatePayHealthInsuranceAtEntry) {
		q21GPrivatePayHealthInsuranceAtEntry = q21gPrivatePayHealthInsuranceAtEntry;
	}

	public BigInteger getQ21GPrivatePayHealthInsuranceAtLatestStayers() {
		return q21GPrivatePayHealthInsuranceAtLatestStayers;
	}

	public void setQ21GPrivatePayHealthInsuranceAtLatestStayers(
			BigInteger q21gPrivatePayHealthInsuranceAtLatestStayers) {
		q21GPrivatePayHealthInsuranceAtLatestStayers = q21gPrivatePayHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21GPrivatePayHealthInsuranceAtExitLeavers() {
		return q21GPrivatePayHealthInsuranceAtExitLeavers;
	}

	public void setQ21GPrivatePayHealthInsuranceAtExitLeavers(
			BigInteger q21gPrivatePayHealthInsuranceAtExitLeavers) {
		q21GPrivatePayHealthInsuranceAtExitLeavers = q21gPrivatePayHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21HStateHealthInsuranceForAdultsAtEntry() {
		return q21HStateHealthInsuranceForAdultsAtEntry;
	}

	public void setQ21HStateHealthInsuranceForAdultsAtEntry(
			BigInteger q21hStateHealthInsuranceForAdultsAtEntry) {
		q21HStateHealthInsuranceForAdultsAtEntry = q21hStateHealthInsuranceForAdultsAtEntry;
	}

	public BigInteger getQ21HStateHealthInsuranceForAdultsAtLatestStayers() {
		return q21HStateHealthInsuranceForAdultsAtLatestStayers;
	}

	public void setQ21HStateHealthInsuranceForAdultsAtLatestStayers(
			BigInteger q21hStateHealthInsuranceForAdultsAtLatestStayers) {
		q21HStateHealthInsuranceForAdultsAtLatestStayers = q21hStateHealthInsuranceForAdultsAtLatestStayers;
	}

	public BigInteger getQ21HStateHealthInsuranceForAdultsAtExitLeavers() {
		return q21HStateHealthInsuranceForAdultsAtExitLeavers;
	}

	public void setQ21HStateHealthInsuranceForAdultsAtExitLeavers(
			BigInteger q21hStateHealthInsuranceForAdultsAtExitLeavers) {
		q21HStateHealthInsuranceForAdultsAtExitLeavers = q21hStateHealthInsuranceForAdultsAtExitLeavers;
	}

	public BigInteger getQ21INoHealthInsuranceAtEntry() {
		return q21INoHealthInsuranceAtEntry;
	}

	public void setQ21INoHealthInsuranceAtEntry(
			BigInteger q21iNoHealthInsuranceAtEntry) {
		q21INoHealthInsuranceAtEntry = q21iNoHealthInsuranceAtEntry;
	}

	public BigInteger getQ21INoHealthInsuranceAtLatestStayers() {
		return q21INoHealthInsuranceAtLatestStayers;
	}

	public void setQ21INoHealthInsuranceAtLatestStayers(
			BigInteger q21iNoHealthInsuranceAtLatestStayers) {
		q21INoHealthInsuranceAtLatestStayers = q21iNoHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21INoHealthInsuranceAtExitLeavers() {
		return q21INoHealthInsuranceAtExitLeavers;
	}

	public void setQ21INoHealthInsuranceAtExitLeavers(
			BigInteger q21iNoHealthInsuranceAtExitLeavers) {
		q21INoHealthInsuranceAtExitLeavers = q21iNoHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21JClientRefusedAtEntry() {
		return q21JClientRefusedAtEntry;
	}

	public void setQ21JClientRefusedAtEntry(BigInteger q21jClientRefusedAtEntry) {
		q21JClientRefusedAtEntry = q21jClientRefusedAtEntry;
	}

	public BigInteger getQ21JClientRefusedAtLatestStayers() {
		return q21JClientRefusedAtLatestStayers;
	}

	public void setQ21JClientRefusedAtLatestStayers(
			BigInteger q21jClientRefusedAtLatestStayers) {
		q21JClientRefusedAtLatestStayers = q21jClientRefusedAtLatestStayers;
	}

	public BigInteger getQ21JClientRefusedAtExitLeavers() {
		return q21JClientRefusedAtExitLeavers;
	}

	public void setQ21JClientRefusedAtExitLeavers(
			BigInteger q21jClientRefusedAtExitLeavers) {
		q21JClientRefusedAtExitLeavers = q21jClientRefusedAtExitLeavers;
	}

	public BigInteger getQ21KDataNotCollectedAtEntry() {
		return q21KDataNotCollectedAtEntry;
	}

	public void setQ21KDataNotCollectedAtEntry(
			BigInteger q21kDataNotCollectedAtEntry) {
		q21KDataNotCollectedAtEntry = q21kDataNotCollectedAtEntry;
	}

	public BigInteger getQ21KDataNotCollectedAtLatestStayers() {
		return q21KDataNotCollectedAtLatestStayers;
	}

	public void setQ21KDataNotCollectedAtLatestStayers(
			BigInteger q21kDataNotCollectedAtLatestStayers) {
		q21KDataNotCollectedAtLatestStayers = q21kDataNotCollectedAtLatestStayers;
	}

	public BigInteger getQ21KDataNotCollectedAtExitLeavers() {
		return q21KDataNotCollectedAtExitLeavers;
	}

	public void setQ21KDataNotCollectedAtExitLeavers(
			BigInteger q21kDataNotCollectedAtExitLeavers) {
		q21KDataNotCollectedAtExitLeavers = q21kDataNotCollectedAtExitLeavers;
	}

	public BigInteger getQ21LNoOfAdultStayersNotRequiredAtEntry() {
		return q21LNoOfAdultStayersNotRequiredAtEntry;
	}

	public void setQ21LNoOfAdultStayersNotRequiredAtEntry(
			BigInteger q21lNoOfAdultStayersNotRequiredAtEntry) {
		q21LNoOfAdultStayersNotRequiredAtEntry = q21lNoOfAdultStayersNotRequiredAtEntry;
	}

	public BigInteger getQ21LNoOfAdultStayersNotRequiredAtLatestStayers() {
		return q21LNoOfAdultStayersNotRequiredAtLatestStayers;
	}

	public void setQ21LNoOfAdultStayersNotRequiredAtLatestStayers(
			BigInteger q21lNoOfAdultStayersNotRequiredAtLatestStayers) {
		q21LNoOfAdultStayersNotRequiredAtLatestStayers = q21lNoOfAdultStayersNotRequiredAtLatestStayers;
	}

	public BigInteger getQ21LNoOfAdultStayersNotRequiredAtExitLeavers() {
		return q21LNoOfAdultStayersNotRequiredAtExitLeavers;
	}

	public void setQ21LNoOfAdultStayersNotRequiredAtExitLeavers(
			BigInteger q21lNoOfAdultStayersNotRequiredAtExitLeavers) {
		q21LNoOfAdultStayersNotRequiredAtExitLeavers = q21lNoOfAdultStayersNotRequiredAtExitLeavers;
	}

	public BigInteger getQ21M1SourceOfHealthInsuranceAtEntry() {
		return q21M1SourceOfHealthInsuranceAtEntry;
	}

	public void setQ21M1SourceOfHealthInsuranceAtEntry(
			BigInteger q21m1SourceOfHealthInsuranceAtEntry) {
		q21M1SourceOfHealthInsuranceAtEntry = q21m1SourceOfHealthInsuranceAtEntry;
	}

	public BigInteger getQ21M1SourceOfHealthInsuranceAtLatestStayers() {
		return q21M1SourceOfHealthInsuranceAtLatestStayers;
	}

	public void setQ21M1SourceOfHealthInsuranceAtLatestStayers(
			BigInteger q21m1SourceOfHealthInsuranceAtLatestStayers) {
		q21M1SourceOfHealthInsuranceAtLatestStayers = q21m1SourceOfHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21M1SourceOfHealthInsuranceAtExitLeavers() {
		return q21M1SourceOfHealthInsuranceAtExitLeavers;
	}

	public void setQ21M1SourceOfHealthInsuranceAtExitLeavers(
			BigInteger q21m1SourceOfHealthInsuranceAtExitLeavers) {
		q21M1SourceOfHealthInsuranceAtExitLeavers = q21m1SourceOfHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ21NMoreThan1SourceOfHealthInsuranceAtEntry() {
		return q21NMoreThan1SourceOfHealthInsuranceAtEntry;
	}

	public void setQ21NMoreThan1SourceOfHealthInsuranceAtEntry(
			BigInteger q21nMoreThan1SourceOfHealthInsuranceAtEntry) {
		q21NMoreThan1SourceOfHealthInsuranceAtEntry = q21nMoreThan1SourceOfHealthInsuranceAtEntry;
	}

	public BigInteger getQ21NMoreThan1SourceOfHealthInsuranceAtLatestStayers() {
		return q21NMoreThan1SourceOfHealthInsuranceAtLatestStayers;
	}

	public void setQ21NMoreThan1SourceOfHealthInsuranceAtLatestStayers(
			BigInteger q21nMoreThan1SourceOfHealthInsuranceAtLatestStayers) {
		q21NMoreThan1SourceOfHealthInsuranceAtLatestStayers = q21nMoreThan1SourceOfHealthInsuranceAtLatestStayers;
	}

	public BigInteger getQ21NMoreThan1SourceOfHealthInsuranceAtExitLeavers() {
		return q21NMoreThan1SourceOfHealthInsuranceAtExitLeavers;
	}

	public void setQ21NMoreThan1SourceOfHealthInsuranceAtExitLeavers(
			BigInteger q21nMoreThan1SourceOfHealthInsuranceAtExitLeavers) {
		q21NMoreThan1SourceOfHealthInsuranceAtExitLeavers = q21nMoreThan1SourceOfHealthInsuranceAtExitLeavers;
	}

	public BigInteger getQ20bNosourcesAtEntry() {
		return q20bNosourcesAtEntry;
	}

	public void setQ20bNosourcesAtEntry(BigInteger q20bNosourcesAtEntry) {
		this.q20bNosourcesAtEntry = q20bNosourcesAtEntry;
	}

	public BigInteger getQ20bNosourcesAtLatestStayers() {
		return q20bNosourcesAtLatestStayers;
	}

	public void setQ20bNosourcesAtLatestStayers(
			BigInteger q20bNosourcesAtLatestStayers) {
		this.q20bNosourcesAtLatestStayers = q20bNosourcesAtLatestStayers;
	}

	public BigInteger getQ20bNosourcesAtExitLeavers() {
		return q20bNosourcesAtExitLeavers;
	}

	public void setQ20bNosourcesAtExitLeavers(BigInteger q20bNosourcesAtExitLeavers) {
		this.q20bNosourcesAtExitLeavers = q20bNosourcesAtExitLeavers;
	}

	public BigInteger getQ20b1PlusSourcesAtEntry() {
		return q20b1PlusSourcesAtEntry;
	}

	public void setQ20b1PlusSourcesAtEntry(BigInteger q20b1PlusSourcesAtEntry) {
		this.q20b1PlusSourcesAtEntry = q20b1PlusSourcesAtEntry;
	}

	public BigInteger getQ20b1PlusSourcesAtLatestStayers() {
		return q20b1PlusSourcesAtLatestStayers;
	}

	public void setQ20b1PlusSourcesAtLatestStayers(
			BigInteger q20b1PlusSourcesAtLatestStayers) {
		this.q20b1PlusSourcesAtLatestStayers = q20b1PlusSourcesAtLatestStayers;
	}

	public BigInteger getQ20b1PlusSourcesAtExitLeavers() {
		return q20b1PlusSourcesAtExitLeavers;
	}

	public void setQ20b1PlusSourcesAtExitLeavers(
			BigInteger q20b1PlusSourcesAtExitLeavers) {
		this.q20b1PlusSourcesAtExitLeavers = q20b1PlusSourcesAtExitLeavers;
	}

	public BigInteger getQ20bDKRAtEntry() {
		return q20bDKRAtEntry;
	}

	public void setQ20bDKRAtEntry(BigInteger q20bDKRAtEntry) {
		this.q20bDKRAtEntry = q20bDKRAtEntry;
	}

	public BigInteger getQ20bDKRAtLatestStayers() {
		return q20bDKRAtLatestStayers;
	}

	public void setQ20bDKRAtLatestStayers(BigInteger q20bDKRAtLatestStayers) {
		this.q20bDKRAtLatestStayers = q20bDKRAtLatestStayers;
	}

	public BigInteger getQ20bDKRAtExitLeavers() {
		return q20bDKRAtExitLeavers;
	}

	public void setQ20bDKRAtExitLeavers(BigInteger q20bDKRAtExitLeavers) {
		this.q20bDKRAtExitLeavers = q20bDKRAtExitLeavers;
	}

	public BigInteger getQ20bMissingInfoAtEntry() {
		return q20bMissingInfoAtEntry;
	}

	public void setQ20bMissingInfoAtEntry(BigInteger q20bMissingInfoAtEntry) {
		this.q20bMissingInfoAtEntry = q20bMissingInfoAtEntry;
	}

	public BigInteger getQ20bMissingInfoAtLatestStayers() {
		return q20bMissingInfoAtLatestStayers;
	}

	public void setQ20bMissingInfoAtLatestStayers(
			BigInteger q20bMissingInfoAtLatestStayers) {
		this.q20bMissingInfoAtLatestStayers = q20bMissingInfoAtLatestStayers;
	}

	public BigInteger getQ20bMissingInfoAtExitLeavers() {
		return q20bMissingInfoAtExitLeavers;
	}

	public void setQ20bMissingInfoAtExitLeavers(
			BigInteger q20bMissingInfoAtExitLeavers) {
		this.q20bMissingInfoAtExitLeavers = q20bMissingInfoAtExitLeavers;
	}

	public BigInteger getQ20bTotalClientsAtEntry() {
		return q20bTotalClientsAtEntry;
	}

	public void setQ20bTotalClientsAtEntry(BigInteger q20bTotalClientsAtEntry) {
		this.q20bTotalClientsAtEntry = q20bTotalClientsAtEntry;
	}

	public BigInteger getQ20bTotalClientsAtLatestStayers() {
		return q20bTotalClientsAtLatestStayers;
	}

	public void setQ20bTotalClientsAtLatestStayers(
			BigInteger q20bTotalClientsAtLatestStayers) {
		this.q20bTotalClientsAtLatestStayers = q20bTotalClientsAtLatestStayers;
	}

	public BigInteger getQ20bTotalClientsAtExitLeavers() {
		return q20bTotalClientsAtExitLeavers;
	}

	public void setQ20bTotalClientsAtExitLeavers(
			BigInteger q20bTotalClientsAtExitLeavers) {
		this.q20bTotalClientsAtExitLeavers = q20bTotalClientsAtExitLeavers;
	}

	public BigInteger getQ20aSupplementalNutritionalAssistanceAtEntry() {
		return q20aSupplementalNutritionalAssistanceAtEntry;
	}

	public void setQ20aSupplementalNutritionalAssistanceAtEntry(
			BigInteger q20aSupplementalNutritionalAssistanceAtEntry) {
		this.q20aSupplementalNutritionalAssistanceAtEntry = q20aSupplementalNutritionalAssistanceAtEntry;
	}

	public BigInteger getQ20aSupplementalNutritionalAssistanceAtLatestStayers() {
		return q20aSupplementalNutritionalAssistanceAtLatestStayers;
	}

	public void setQ20aSupplementalNutritionalAssistanceAtLatestStayers(
			BigInteger q20aSupplementalNutritionalAssistanceAtLatestStayers) {
		this.q20aSupplementalNutritionalAssistanceAtLatestStayers = q20aSupplementalNutritionalAssistanceAtLatestStayers;
	}

	public BigInteger getQ20aSupplementalNutritionalAssistanceAtExitLeavers() {
		return q20aSupplementalNutritionalAssistanceAtExitLeavers;
	}

	public void setQ20aSupplementalNutritionalAssistanceAtExitLeavers(
			BigInteger q20aSupplementalNutritionalAssistanceAtExitLeavers) {
		this.q20aSupplementalNutritionalAssistanceAtExitLeavers = q20aSupplementalNutritionalAssistanceAtExitLeavers;
	}

	public BigInteger getQ20aWICAtEntry() {
		return q20aWICAtEntry;
	}

	public void setQ20aWICAtEntry(BigInteger q20aWICAtEntry) {
		this.q20aWICAtEntry = q20aWICAtEntry;
	}

	public BigInteger getQ20aWICAtLatestStayers() {
		return q20aWICAtLatestStayers;
	}

	public void setQ20aWICAtLatestStayers(BigInteger q20aWICAtLatestStayers) {
		this.q20aWICAtLatestStayers = q20aWICAtLatestStayers;
	}

	public BigInteger getQ20aWICAtExitLeavers() {
		return q20aWICAtExitLeavers;
	}

	public void setQ20aWICAtExitLeavers(BigInteger q20aWICAtExitLeavers) {
		this.q20aWICAtExitLeavers = q20aWICAtExitLeavers;
	}

	public BigInteger getQ20aTANFChildCareAtEntry() {
		return q20aTANFChildCareAtEntry;
	}

	public void setQ20aTANFChildCareAtEntry(BigInteger q20aTANFChildCareAtEntry) {
		this.q20aTANFChildCareAtEntry = q20aTANFChildCareAtEntry;
	}

	public BigInteger getQ20aTANFChildCareAtLatestStayers() {
		return q20aTANFChildCareAtLatestStayers;
	}

	public void setQ20aTANFChildCareAtLatestStayers(
			BigInteger q20aTANFChildCareAtLatestStayers) {
		this.q20aTANFChildCareAtLatestStayers = q20aTANFChildCareAtLatestStayers;
	}

	public BigInteger getQ20aTANFChildCareAtExitLeavers() {
		return q20aTANFChildCareAtExitLeavers;
	}

	public void setQ20aTANFChildCareAtExitLeavers(
			BigInteger q20aTANFChildCareAtExitLeavers) {
		this.q20aTANFChildCareAtExitLeavers = q20aTANFChildCareAtExitLeavers;
	}

	public BigInteger getQ20aTANFTransportationAtEntry() {
		return q20aTANFTransportationAtEntry;
	}

	public void setQ20aTANFTransportationAtEntry(
			BigInteger q20aTANFTransportationAtEntry) {
		this.q20aTANFTransportationAtEntry = q20aTANFTransportationAtEntry;
	}

	public BigInteger getQ20aTANFTransportationAtLatestStayers() {
		return q20aTANFTransportationAtLatestStayers;
	}

	public void setQ20aTANFTransportationAtLatestStayers(
			BigInteger q20aTANFTransportationAtLatestStayers) {
		this.q20aTANFTransportationAtLatestStayers = q20aTANFTransportationAtLatestStayers;
	}

	public BigInteger getQ20aTANFTransportationAtExitLeavers() {
		return q20aTANFTransportationAtExitLeavers;
	}

	public void setQ20aTANFTransportationAtExitLeavers(
			BigInteger q20aTANFTransportationAtExitLeavers) {
		this.q20aTANFTransportationAtExitLeavers = q20aTANFTransportationAtExitLeavers;
	}

	public BigInteger getQ20aOtherTANFAtEntry() {
		return q20aOtherTANFAtEntry;
	}

	public void setQ20aOtherTANFAtEntry(BigInteger q20aOtherTANFAtEntry) {
		this.q20aOtherTANFAtEntry = q20aOtherTANFAtEntry;
	}

	public BigInteger getQ20aOtherTANFAtLatestStayers() {
		return q20aOtherTANFAtLatestStayers;
	}

	public void setQ20aOtherTANFAtLatestStayers(
			BigInteger q20aOtherTANFAtLatestStayers) {
		this.q20aOtherTANFAtLatestStayers = q20aOtherTANFAtLatestStayers;
	}

	public BigInteger getQ20aOtherTANFAtExitLeavers() {
		return q20aOtherTANFAtExitLeavers;
	}

	public void setQ20aOtherTANFAtExitLeavers(BigInteger q20aOtherTANFAtExitLeavers) {
		this.q20aOtherTANFAtExitLeavers = q20aOtherTANFAtExitLeavers;
	}

	public BigInteger getQ20aOtherSourcesAtEntry() {
		return q20aOtherSourcesAtEntry;
	}

	public void setQ20aOtherSourcesAtEntry(BigInteger q20aOtherSourcesAtEntry) {
		this.q20aOtherSourcesAtEntry = q20aOtherSourcesAtEntry;
	}

	public BigInteger getQ20aOtherSourcesAtLatestStayers() {
		return q20aOtherSourcesAtLatestStayers;
	}

	public void setQ20aOtherSourcesAtLatestStayers(
			BigInteger q20aOtherSourcesAtLatestStayers) {
		this.q20aOtherSourcesAtLatestStayers = q20aOtherSourcesAtLatestStayers;
	}

	public BigInteger getQ20aOtherSourcesAtExitLeavers() {
		return q20aOtherSourcesAtExitLeavers;
	}

	public void setQ20aOtherSourcesAtExitLeavers(
			BigInteger q20aOtherSourcesAtExitLeavers) {
		this.q20aOtherSourcesAtExitLeavers = q20aOtherSourcesAtExitLeavers;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomeTotalAdult() {
		return q19a3NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomeTotalAdult(
			BigInteger q19a3NoOfAdltsWithEarnedIncomeTotalAdult) {
		this.q19a3NoOfAdltsWithEarnedIncomeTotalAdult = q19a3NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomePerformanceMeasures() {
		return q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomePerformanceMeasures(
			BigInteger q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures) {
		this.q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures = q19a3NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3NoOfAdltsWithEarnedIncomePercent() {
		return q19a3NoOfAdltsWithEarnedIncomePercent;
	}

	public void setQ19a3NoOfAdltsWithEarnedIncomePercent(
			BigInteger q19a3NoOfAdltsWithEarnedIncomePercent) {
		this.q19a3NoOfAdltsWithEarnedIncomePercent = q19a3NoOfAdltsWithEarnedIncomePercent;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomeTotalAdult() {
		return q19a3AverageChangeInEarnedIncomeTotalAdult;
	}

	public void setQ19a3AverageChangeInEarnedIncomeTotalAdult(
			BigInteger q19a3AverageChangeInEarnedIncomeTotalAdult) {
		this.q19a3AverageChangeInEarnedIncomeTotalAdult = q19a3AverageChangeInEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomePerformanceMeasures() {
		return q19a3AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public void setQ19a3AverageChangeInEarnedIncomePerformanceMeasures(
			BigInteger q19a3AverageChangeInEarnedIncomePerformanceMeasures) {
		this.q19a3AverageChangeInEarnedIncomePerformanceMeasures = q19a3AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3AverageChangeInEarnedIncomePercent() {
		return q19a3AverageChangeInEarnedIncomePercent;
	}

	public void setQ19a3AverageChangeInEarnedIncomePercent(
			BigInteger q19a3AverageChangeInEarnedIncomePercent) {
		this.q19a3AverageChangeInEarnedIncomePercent = q19a3AverageChangeInEarnedIncomePercent;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomeTotalAdult() {
		return q19a3NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomeTotalAdult(
			BigInteger q19a3NoOfAdultsWithOtherIncomeTotalAdult) {
		this.q19a3NoOfAdultsWithOtherIncomeTotalAdult = q19a3NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomePerformanceMeasures() {
		return q19a3NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomePerformanceMeasures(
			BigInteger q19a3NoOfAdultsWithOtherIncomePerformanceMeasures) {
		this.q19a3NoOfAdultsWithOtherIncomePerformanceMeasures = q19a3NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3NoOfAdultsWithOtherIncomePercent() {
		return q19a3NoOfAdultsWithOtherIncomePercent;
	}

	public void setQ19a3NoOfAdultsWithOtherIncomePercent(
			BigInteger q19a3NoOfAdultsWithOtherIncomePercent) {
		this.q19a3NoOfAdultsWithOtherIncomePercent = q19a3NoOfAdultsWithOtherIncomePercent;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomeTotalAdult() {
		return q19a3AverageChangeInOtherIncomeTotalAdult;
	}

	public void setQ19a3AverageChangeInOtherIncomeTotalAdult(
			BigInteger q19a3AverageChangeInOtherIncomeTotalAdult) {
		this.q19a3AverageChangeInOtherIncomeTotalAdult = q19a3AverageChangeInOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomePerformanceMeasures() {
		return q19a3AverageChangeInOtherIncomePerformanceMeasures;
	}

	public void setQ19a3AverageChangeInOtherIncomePerformanceMeasures(
			BigInteger q19a3AverageChangeInOtherIncomePerformanceMeasures) {
		this.q19a3AverageChangeInOtherIncomePerformanceMeasures = q19a3AverageChangeInOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3AverageChangeInOtherIncomePercent() {
		return q19a3AverageChangeInOtherIncomePercent;
	}

	public void setQ19a3AverageChangeInOtherIncomePercent(
			BigInteger q19a3AverageChangeInOtherIncomePercent) {
		this.q19a3AverageChangeInOtherIncomePercent = q19a3AverageChangeInOtherIncomePercent;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomeTotalAdult() {
		return q19a3NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomeTotalAdult(
			BigInteger q19a3NumberOfAdultsWithAnyIncomeTotalAdult) {
		this.q19a3NumberOfAdultsWithAnyIncomeTotalAdult = q19a3NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomePerformanceMeasures() {
		return q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomePerformanceMeasures(
			BigInteger q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures) {
		this.q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures = q19a3NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3NumberOfAdultsWithAnyIncomePercent() {
		return q19a3NumberOfAdultsWithAnyIncomePercent;
	}

	public void setQ19a3NumberOfAdultsWithAnyIncomePercent(
			BigInteger q19a3NumberOfAdultsWithAnyIncomePercent) {
		this.q19a3NumberOfAdultsWithAnyIncomePercent = q19a3NumberOfAdultsWithAnyIncomePercent;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit() {
		return q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public void setQ19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit(
			BigInteger q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit) {
		this.q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit = q19a3AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHavefollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry() {
		return q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry = q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry() {
		return q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public void setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry(
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry) {
		this.q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry = q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollartFollowupOrExitAtEntry;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit() {
		return q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit(
			BigInteger q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit) {
		this.q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit = q19a3AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit() {
		return q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit(
			BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit) {
		this.q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit = q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryEntryAndGainedIncomeCategoryAtFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit() {
		return q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public void setQ19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit(
			BigInteger q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit) {
		this.q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit = q19a3AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrFollowupOrExit;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomeTotalAdult() {
		return q19a3AverageChangeInOverallIncomeTotalAdult;
	}

	public void setQ19a3AverageChangeInOverallIncomeTotalAdult(
			BigInteger q19a3AverageChangeInOverallIncomeTotalAdult) {
		this.q19a3AverageChangeInOverallIncomeTotalAdult = q19a3AverageChangeInOverallIncomeTotalAdult;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomePerformanceMeasures() {
		return q19a3AverageChangeInOverallIncomePerformanceMeasures;
	}

	public void setQ19a3AverageChangeInOverallIncomePerformanceMeasures(
			BigInteger q19a3AverageChangeInOverallIncomePerformanceMeasures) {
		this.q19a3AverageChangeInOverallIncomePerformanceMeasures = q19a3AverageChangeInOverallIncomePerformanceMeasures;
	}

	public BigInteger getQ19a3AverageChangeInOverallIncomePercent() {
		return q19a3AverageChangeInOverallIncomePercent;
	}

	public void setQ19a3AverageChangeInOverallIncomePercent(
			BigInteger q19a3AverageChangeInOverallIncomePercent) {
		this.q19a3AverageChangeInOverallIncomePercent = q19a3AverageChangeInOverallIncomePercent;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar = q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar = q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomeTotalAdult() {
		return q19a1NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomeTotalAdult(
			BigInteger q19a1NoOfAdltsWithEarnedIncomeTotalAdult) {
		this.q19a1NoOfAdltsWithEarnedIncomeTotalAdult = q19a1NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomePerformanceMeasures() {
		return q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomePerformanceMeasures(
			BigInteger q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures) {
		this.q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures = q19a1NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1NoOfAdltsWithEarnedIncomePercent() {
		return q19a1NoOfAdltsWithEarnedIncomePercent;
	}

	public void setQ19a1NoOfAdltsWithEarnedIncomePercent(
			BigInteger q19a1NoOfAdltsWithEarnedIncomePercent) {
		this.q19a1NoOfAdltsWithEarnedIncomePercent = q19a1NoOfAdltsWithEarnedIncomePercent;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar = q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar = q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomeTotalAdult() {
		return q19a1AverageChangeInEarnedIncomeTotalAdult;
	}

	public void setQ19a1AverageChangeInEarnedIncomeTotalAdult(
			BigInteger q19a1AverageChangeInEarnedIncomeTotalAdult) {
		this.q19a1AverageChangeInEarnedIncomeTotalAdult = q19a1AverageChangeInEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomePerformanceMeasures() {
		return q19a1AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public void setQ19a1AverageChangeInEarnedIncomePerformanceMeasures(
			BigInteger q19a1AverageChangeInEarnedIncomePerformanceMeasures) {
		this.q19a1AverageChangeInEarnedIncomePerformanceMeasures = q19a1AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1AverageChangeInEarnedIncomePercent() {
		return q19a1AverageChangeInEarnedIncomePercent;
	}

	public void setQ19a1AverageChangeInEarnedIncomePercent(
			BigInteger q19a1AverageChangeInEarnedIncomePercent) {
		this.q19a1AverageChangeInEarnedIncomePercent = q19a1AverageChangeInEarnedIncomePercent;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar = q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar = q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomeTotalAdult() {
		return q19a1NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomeTotalAdult(
			BigInteger q19a1NoOfAdultsWithOtherIncomeTotalAdult) {
		this.q19a1NoOfAdultsWithOtherIncomeTotalAdult = q19a1NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomePerformanceMeasures() {
		return q19a1NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomePerformanceMeasures(
			BigInteger q19a1NoOfAdultsWithOtherIncomePerformanceMeasures) {
		this.q19a1NoOfAdultsWithOtherIncomePerformanceMeasures = q19a1NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1NoOfAdultsWithOtherIncomePercent() {
		return q19a1NoOfAdultsWithOtherIncomePercent;
	}

	public void setQ19a1NoOfAdultsWithOtherIncomePercent(
			BigInteger q19a1NoOfAdultsWithOtherIncomePercent) {
		this.q19a1NoOfAdultsWithOtherIncomePercent = q19a1NoOfAdultsWithOtherIncomePercent;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar = q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar = q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomeTotalAdult() {
		return q19a1AverageChangeInOtherIncomeTotalAdult;
	}

	public void setQ19a1AverageChangeInOtherIncomeTotalAdult(
			BigInteger q19a1AverageChangeInOtherIncomeTotalAdult) {
		this.q19a1AverageChangeInOtherIncomeTotalAdult = q19a1AverageChangeInOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomePerformanceMeasures() {
		return q19a1AverageChangeInOtherIncomePerformanceMeasures;
	}

	public void setQ19a1AverageChangeInOtherIncomePerformanceMeasures(
			BigInteger q19a1AverageChangeInOtherIncomePerformanceMeasures) {
		this.q19a1AverageChangeInOtherIncomePerformanceMeasures = q19a1AverageChangeInOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1AverageChangeInOtherIncomePercent() {
		return q19a1AverageChangeInOtherIncomePercent;
	}

	public void setQ19a1AverageChangeInOtherIncomePercent(
			BigInteger q19a1AverageChangeInOtherIncomePercent) {
		this.q19a1AverageChangeInOtherIncomePercent = q19a1AverageChangeInOtherIncomePercent;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar = q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar = q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomeTotalAdult() {
		return q19a1NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomeTotalAdult(
			BigInteger q19a1NumberOfAdultsWithAnyIncomeTotalAdult) {
		this.q19a1NumberOfAdultsWithAnyIncomeTotalAdult = q19a1NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomePerformanceMeasures() {
		return q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomePerformanceMeasures(
			BigInteger q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures) {
		this.q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures = q19a1NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1NumberOfAdultsWithAnyIncomePercent() {
		return q19a1NumberOfAdultsWithAnyIncomePercent;
	}

	public void setQ19a1NumberOfAdultsWithAnyIncomePercent(
			BigInteger q19a1NumberOfAdultsWithAnyIncomePercent) {
		this.q19a1NumberOfAdultsWithAnyIncomePercent = q19a1NumberOfAdultsWithAnyIncomePercent;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup() {
		return q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public void setQ19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup(
			BigInteger q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup) {
		this.q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup = q19a1AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndNotHaveFollowup;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar() {
		return q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public void setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar(
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar) {
		this.q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar = q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollar;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar() {
		return q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public void setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar(
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar) {
		this.q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar = q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollar;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar() {
		return q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public void setQ19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar(
			BigInteger q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar) {
		this.q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar = q19a1AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollar;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome() {
		return q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public void setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome(
			BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome) {
		this.q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome = q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedTheIncome;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup() {
		return q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public void setQ19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup(
			BigInteger q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup) {
		this.q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup = q19a1AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryOrFollowup;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomeTotalAdult() {
		return q19a1AverageChangeInOverallIncomeTotalAdult;
	}

	public void setQ19a1AverageChangeInOverallIncomeTotalAdult(
			BigInteger q19a1AverageChangeInOverallIncomeTotalAdult) {
		this.q19a1AverageChangeInOverallIncomeTotalAdult = q19a1AverageChangeInOverallIncomeTotalAdult;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomePerformanceMeasures() {
		return q19a1AverageChangeInOverallIncomePerformanceMeasures;
	}

	public void setQ19a1AverageChangeInOverallIncomePerformanceMeasures(
			BigInteger q19a1AverageChangeInOverallIncomePerformanceMeasures) {
		this.q19a1AverageChangeInOverallIncomePerformanceMeasures = q19a1AverageChangeInOverallIncomePerformanceMeasures;
	}

	public BigInteger getQ19a1AverageChangeInOverallIncomePercent() {
		return q19a1AverageChangeInOverallIncomePercent;
	}

	public void setQ19a1AverageChangeInOverallIncomePercent(
			BigInteger q19a1AverageChangeInOverallIncomePercent) {
		this.q19a1AverageChangeInOverallIncomePercent = q19a1AverageChangeInOverallIncomePercent;
	}

	public BigInteger getQ04aHmisProjectIdService() {
		return q04aHmisProjectIdService;
	}
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getProjects() {
		return projects;
	}

	public void setProjects(String projects) {
		this.projects = projects;
	}

	public String getHomeLess() {
		return homeLess;
	}

	public void setHomeLess(String homeLess) {
		this.homeLess = homeLess;
	}

	public String getGrants() {
		return grants;
	}

	public void setGrants(String grants) {
		this.grants = grants;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
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
	
	
	
	
	/** 
	 * Getter Setter for "Q09b: Number of Persons Engaged" Table -- Starts
	 **/
		
	public BigInteger getTotEngagedAfter1Contract() {
		return totEngagedAfter1Contract;
	}
	/**
	 * @return the totContactedOnce
	 */
	public BigInteger getTotContactedOnce() {
		return totContactedOnce;
	}



	/**
	 * @param totContactedOnce the totContactedOnce to set
	 */
	public void setTotContactedOnce(BigInteger totContactedOnce) {
		this.totContactedOnce = totContactedOnce;
	}



	/**
	 * @return the coFirstContactNotStaying
	 */
	public BigInteger getCoFirstContactNotStaying() {
		return coFirstContactNotStaying;
	}



	/**
	 * @param coFirstContactNotStaying the coFirstContactNotStaying to set
	 */
	public void setCoFirstContactNotStaying(BigInteger coFirstContactNotStaying) {
		this.coFirstContactNotStaying = coFirstContactNotStaying;
	}



	/**
	 * @return the coFirstContactStaying
	 */
	public BigInteger getCoFirstContactStaying() {
		return coFirstContactStaying;
	}



	/**
	 * @param coFirstContactStaying the coFirstContactStaying to set
	 */
	public void setCoFirstContactStaying(BigInteger coFirstContactStaying) {
		this.coFirstContactStaying = coFirstContactStaying;
	}



	/**
	 * @return the coFirstContactWorkerUnableToDetermine
	 */
	public BigInteger getCoFirstContactWorkerUnableToDetermine() {
		return coFirstContactWorkerUnableToDetermine;
	}



	/**
	 * @param coFirstContactWorkerUnableToDetermine the coFirstContactWorkerUnableToDetermine to set
	 */
	public void setCoFirstContactWorkerUnableToDetermine(
			BigInteger coFirstContactWorkerUnableToDetermine) {
		this.coFirstContactWorkerUnableToDetermine = coFirstContactWorkerUnableToDetermine;
	}



	/**
	 * @return the totContacted2to5Times
	 */
	public BigInteger getTotContacted2to5Times() {
		return totContacted2to5Times;
	}



	/**
	 * @param totContacted2to5Times the totContacted2to5Times to set
	 */
	public void setTotContacted2to5Times(BigInteger totContacted2to5Times) {
		this.totContacted2to5Times = totContacted2to5Times;
	}



	/**
	 * @return the c2to5FirstContactedNotStaying
	 */
	public BigInteger getC2to5FirstContactedNotStaying() {
		return c2to5FirstContactedNotStaying;
	}



	/**
	 * @param c2to5FirstContactedNotStaying the c2to5FirstContactedNotStaying to set
	 */
	public void setC2to5FirstContactedNotStaying(
			BigInteger c2to5FirstContactedNotStaying) {
		this.c2to5FirstContactedNotStaying = c2to5FirstContactedNotStaying;
	}



	/**
	 * @return the c2to5FirstContactStaying
	 */
	public BigInteger getC2to5FirstContactStaying() {
		return c2to5FirstContactStaying;
	}



	/**
	 * @param c2to5FirstContactStaying the c2to5FirstContactStaying to set
	 */
	public void setC2to5FirstContactStaying(BigInteger c2to5FirstContactStaying) {
		this.c2to5FirstContactStaying = c2to5FirstContactStaying;
	}



	/**
	 * @return the c2to5FirstContactedWorkerUnableToDetermine
	 */
	public BigInteger getC2to5FirstContactedWorkerUnableToDetermine() {
		return c2to5FirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @param c2to5FirstContactedWorkerUnableToDetermine the c2to5FirstContactedWorkerUnableToDetermine to set
	 */
	public void setC2to5FirstContactedWorkerUnableToDetermine(
			BigInteger c2to5FirstContactedWorkerUnableToDetermine) {
		this.c2to5FirstContactedWorkerUnableToDetermine = c2to5FirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @return the totContacted6to9Times
	 */
	public BigInteger getTotContacted6to9Times() {
		return totContacted6to9Times;
	}



	/**
	 * @param totContacted6to9Times the totContacted6to9Times to set
	 */
	public void setTotContacted6to9Times(BigInteger totContacted6to9Times) {
		this.totContacted6to9Times = totContacted6to9Times;
	}



	/**
	 * @return the c6to9FirstContactedNotStaying
	 */
	public BigInteger getC6to9FirstContactedNotStaying() {
		return c6to9FirstContactedNotStaying;
	}



	/**
	 * @param c6to9FirstContactedNotStaying the c6to9FirstContactedNotStaying to set
	 */
	public void setC6to9FirstContactedNotStaying(
			BigInteger c6to9FirstContactedNotStaying) {
		this.c6to9FirstContactedNotStaying = c6to9FirstContactedNotStaying;
	}



	/**
	 * @return the c6to9FirstContactedWorkerUnableToDetermine
	 */
	public BigInteger getC6to9FirstContactedWorkerUnableToDetermine() {
		return c6to9FirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @param c6to9FirstContactedWorkerUnableToDetermine the c6to9FirstContactedWorkerUnableToDetermine to set
	 */
	public void setC6to9FirstContactedWorkerUnableToDetermine(
			BigInteger c6to9FirstContactedWorkerUnableToDetermine) {
		this.c6to9FirstContactedWorkerUnableToDetermine = c6to9FirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @return the totContacted10orMore
	 */
	public BigInteger getTotContacted10orMore() {
		return totContacted10orMore;
	}



	/**
	 * @param totContacted10orMore the totContacted10orMore to set
	 */
	public void setTotContacted10orMore(BigInteger totContacted10orMore) {
		this.totContacted10orMore = totContacted10orMore;
	}



	/**
	 * @return the c6to9FirstContactStaying
	 */
	public BigInteger getC6to9FirstContactStaying() {
		return c6to9FirstContactStaying;
	}



	/**
	 * @param c6to9FirstContactStaying the c6to9FirstContactStaying to set
	 */
	public void setC6to9FirstContactStaying(BigInteger c6to9FirstContactStaying) {
		this.c6to9FirstContactStaying = c6to9FirstContactStaying;
	}



	/**
	 * @return the c10orMoreFirstContactedNotStaying
	 */
	public BigInteger getC10orMoreFirstContactedNotStaying() {
		return c10orMoreFirstContactedNotStaying;
	}



	/**
	 * @param c10orMoreFirstContactedNotStaying the c10orMoreFirstContactedNotStaying to set
	 */
	public void setC10orMoreFirstContactedNotStaying(
			BigInteger c10orMoreFirstContactedNotStaying) {
		this.c10orMoreFirstContactedNotStaying = c10orMoreFirstContactedNotStaying;
	}



	/**
	 * @return the c10orMoreFirstContactStaying
	 */
	public BigInteger getC10orMoreFirstContactStaying() {
		return c10orMoreFirstContactStaying;
	}



	/**
	 * @param c10orMoreFirstContactStaying the c10orMoreFirstContactStaying to set
	 */
	public void setC10orMoreFirstContactStaying(
			BigInteger c10orMoreFirstContactStaying) {
		this.c10orMoreFirstContactStaying = c10orMoreFirstContactStaying;
	}



	/**
	 * @return the c10orMoreFirstContactedWorkerUnableToDetermine
	 */
	public BigInteger getC10orMoreFirstContactedWorkerUnableToDetermine() {
		return c10orMoreFirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @param c10orMoreFirstContactedWorkerUnableToDetermine the c10orMoreFirstContactedWorkerUnableToDetermine to set
	 */
	public void setC10orMoreFirstContactedWorkerUnableToDetermine(
			BigInteger c10orMoreFirstContactedWorkerUnableToDetermine) {
		this.c10orMoreFirstContactedWorkerUnableToDetermine = c10orMoreFirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @return the totPersonsContacted
	 */
	public BigInteger getTotPersonsContacted() {
		return totPersonsContacted;
	}



	/**
	 * @param totPersonsContacted the totPersonsContacted to set
	 */
	public void setTotPersonsContacted(BigInteger totPersonsContacted) {
		this.totPersonsContacted = totPersonsContacted;
	}



	/**
	 * @return the tpcFirstContactedNotStaying
	 */
	public BigInteger getTpcFirstContactedNotStaying() {
		return tpcFirstContactedNotStaying;
	}



	/**
	 * @param tpcFirstContactedNotStaying the tpcFirstContactedNotStaying to set
	 */
	public void setTpcFirstContactedNotStaying(
			BigInteger tpcFirstContactedNotStaying) {
		this.tpcFirstContactedNotStaying = tpcFirstContactedNotStaying;
	}



	/**
	 * @return the tpcFirstContactStaying
	 */
	public BigInteger getTpcFirstContactStaying() {
		return tpcFirstContactStaying;
	}



	/**
	 * @param tpcFirstContactStaying the tpcFirstContactStaying to set
	 */
	public void setTpcFirstContactStaying(BigInteger tpcFirstContactStaying) {
		this.tpcFirstContactStaying = tpcFirstContactStaying;
	}



	/**
	 * @return the tpcFirstContactedWorkerUnableToDetermine
	 */
	public BigInteger getTpcFirstContactedWorkerUnableToDetermine() {
		return tpcFirstContactedWorkerUnableToDetermine;
	}



	/**
	 * @param tpcFirstContactedWorkerUnableToDetermine the tpcFirstContactedWorkerUnableToDetermine to set
	 */
	public void setTpcFirstContactedWorkerUnableToDetermine(
			BigInteger tpcFirstContactedWorkerUnableToDetermine) {
		this.tpcFirstContactedWorkerUnableToDetermine = tpcFirstContactedWorkerUnableToDetermine;
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

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2NoOfAdltsWithEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2NoOfAdltsWithEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2NoOfAdltsWithEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2NoOfAdltsWithEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomeTotalAdult() {
		return q19a2NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomeTotalAdult(
			BigInteger q19a2NoOfAdltsWithEarnedIncomeTotalAdult) {
		this.q19a2NoOfAdltsWithEarnedIncomeTotalAdult = q19a2NoOfAdltsWithEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomePerformanceMeasures() {
		return q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomePerformanceMeasures(
			BigInteger q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures) {
		this.q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures = q19a2NoOfAdltsWithEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2NoOfAdltsWithEarnedIncomePercent() {
		return q19a2NoOfAdltsWithEarnedIncomePercent;
	}

	public void setQ19a2NoOfAdltsWithEarnedIncomePercent(
			BigInteger q19a2NoOfAdltsWithEarnedIncomePercent) {
		this.q19a2NoOfAdltsWithEarnedIncomePercent = q19a2NoOfAdltsWithEarnedIncomePercent;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2AverageChangeInEarnedIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2AverageChangeInEarnedIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2AverageChangeInEarnedIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2AverageChangeInEarnedIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomeTotalAdult() {
		return q19a2AverageChangeInEarnedIncomeTotalAdult;
	}

	public void setQ19a2AverageChangeInEarnedIncomeTotalAdult(
			BigInteger q19a2AverageChangeInEarnedIncomeTotalAdult) {
		this.q19a2AverageChangeInEarnedIncomeTotalAdult = q19a2AverageChangeInEarnedIncomeTotalAdult;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomePerformanceMeasures() {
		return q19a2AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public void setQ19a2AverageChangeInEarnedIncomePerformanceMeasures(
			BigInteger q19a2AverageChangeInEarnedIncomePerformanceMeasures) {
		this.q19a2AverageChangeInEarnedIncomePerformanceMeasures = q19a2AverageChangeInEarnedIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2AverageChangeInEarnedIncomePercent() {
		return q19a2AverageChangeInEarnedIncomePercent;
	}

	public void setQ19a2AverageChangeInEarnedIncomePercent(
			BigInteger q19a2AverageChangeInEarnedIncomePercent) {
		this.q19a2AverageChangeInEarnedIncomePercent = q19a2AverageChangeInEarnedIncomePercent;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2NoOfAdultsWithOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2NoOfAdultsWithOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2NoOfAdultsWithOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2NoOfAdultsWithOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomeTotalAdult() {
		return q19a2NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomeTotalAdult(
			BigInteger q19a2NoOfAdultsWithOtherIncomeTotalAdult) {
		this.q19a2NoOfAdultsWithOtherIncomeTotalAdult = q19a2NoOfAdultsWithOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomePerformanceMeasures() {
		return q19a2NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomePerformanceMeasures(
			BigInteger q19a2NoOfAdultsWithOtherIncomePerformanceMeasures) {
		this.q19a2NoOfAdultsWithOtherIncomePerformanceMeasures = q19a2NoOfAdultsWithOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2NoOfAdultsWithOtherIncomePercent() {
		return q19a2NoOfAdultsWithOtherIncomePercent;
	}

	public void setQ19a2NoOfAdultsWithOtherIncomePercent(
			BigInteger q19a2NoOfAdultsWithOtherIncomePercent) {
		this.q19a2NoOfAdultsWithOtherIncomePercent = q19a2NoOfAdultsWithOtherIncomePercent;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2AverageChangeInOtherIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2AverageChangeInOtherIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2AverageChangeInOtherIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2AverageChangeInOtherIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomeTotalAdult() {
		return q19a2AverageChangeInOtherIncomeTotalAdult;
	}

	public void setQ19a2AverageChangeInOtherIncomeTotalAdult(
			BigInteger q19a2AverageChangeInOtherIncomeTotalAdult) {
		this.q19a2AverageChangeInOtherIncomeTotalAdult = q19a2AverageChangeInOtherIncomeTotalAdult;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomePerformanceMeasures() {
		return q19a2AverageChangeInOtherIncomePerformanceMeasures;
	}

	public void setQ19a2AverageChangeInOtherIncomePerformanceMeasures(
			BigInteger q19a2AverageChangeInOtherIncomePerformanceMeasures) {
		this.q19a2AverageChangeInOtherIncomePerformanceMeasures = q19a2AverageChangeInOtherIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2AverageChangeInOtherIncomePercent() {
		return q19a2AverageChangeInOtherIncomePercent;
	}

	public void setQ19a2AverageChangeInOtherIncomePercent(
			BigInteger q19a2AverageChangeInOtherIncomePercent) {
		this.q19a2AverageChangeInOtherIncomePercent = q19a2AverageChangeInOtherIncomePercent;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2NumberOfAdultsWithAnyIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2NumberOfAdultsWithAnyIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2NumberOfAdultsWithAnyIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2NumberOfAdultsWithAnyIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomeTotalAdult() {
		return q19a2NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomeTotalAdult(
			BigInteger q19a2NumberOfAdultsWithAnyIncomeTotalAdult) {
		this.q19a2NumberOfAdultsWithAnyIncomeTotalAdult = q19a2NumberOfAdultsWithAnyIncomeTotalAdult;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomePerformanceMeasures() {
		return q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomePerformanceMeasures(
			BigInteger q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures) {
		this.q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures = q19a2NumberOfAdultsWithAnyIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2NumberOfAdultsWithAnyIncomePercent() {
		return q19a2NumberOfAdultsWithAnyIncomePercent;
	}

	public void setQ19a2NumberOfAdultsWithAnyIncomePercent(
			BigInteger q19a2NumberOfAdultsWithAnyIncomePercent) {
		this.q19a2NumberOfAdultsWithAnyIncomePercent = q19a2NumberOfAdultsWithAnyIncomePercent;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit() {
		return q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public void setQ19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit(
			BigInteger q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit) {
		this.q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit = q19a2AverageChangeInOverallIncomeHadIncomeCategoryAtEntryAndDidNotHaveAtExit;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry() {
		return q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public void setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry(
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry) {
		this.q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry = q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryButHadLessDollarAtExitThanAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry() {
		return q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public void setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry(
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry) {
		this.q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry = q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndSameDollarAtExitAsAtEntry;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit() {
		return q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public void setQ19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit(
			BigInteger q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit) {
		this.q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit = q19a2AverageChangeInOverallIncomeRetainedIncomeCategoryAndIncreasedDollarAtExit;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit() {
		return q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public void setQ19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit(
			BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit) {
		this.q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit = q19a2AverageChangeInOverallIncomeDidNotHaveTheIncomeCategoryAtEntryAndGainedIncomeCategoryExit;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit() {
		return q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public void setQ19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit(
			BigInteger q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit) {
		this.q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit = q19a2AverageChangeInOverallIncomeDidNotHaveIncomeCategoryAtEntryOrExit;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomeTotalAdult() {
		return q19a2AverageChangeInOverallIncomeTotalAdult;
	}

	public void setQ19a2AverageChangeInOverallIncomeTotalAdult(
			BigInteger q19a2AverageChangeInOverallIncomeTotalAdult) {
		this.q19a2AverageChangeInOverallIncomeTotalAdult = q19a2AverageChangeInOverallIncomeTotalAdult;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomePerformanceMeasures() {
		return q19a2AverageChangeInOverallIncomePerformanceMeasures;
	}

	public void setQ19a2AverageChangeInOverallIncomePerformanceMeasures(
			BigInteger q19a2AverageChangeInOverallIncomePerformanceMeasures) {
		this.q19a2AverageChangeInOverallIncomePerformanceMeasures = q19a2AverageChangeInOverallIncomePerformanceMeasures;
	}

	public BigInteger getQ19a2AverageChangeInOverallIncomePercent() {
		return q19a2AverageChangeInOverallIncomePercent;
	}

	public void setQ19a2AverageChangeInOverallIncomePercent(
			BigInteger q19a2AverageChangeInOverallIncomePercent) {
		this.q19a2AverageChangeInOverallIncomePercent = q19a2AverageChangeInOverallIncomePercent;
	}
	
}