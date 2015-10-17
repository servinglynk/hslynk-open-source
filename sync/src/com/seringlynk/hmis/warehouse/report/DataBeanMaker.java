package com.seringlynk.hmis.warehouse.report;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DataBeanMaker {
        public ArrayList<DataBean> getDataBeanList() {
                ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();
                dataBeanList.add(produce("1/1/2015",
                		" ",
                		"APR - Services Only",
                		"Everyone",
                		"all grants",
                		"Aggregate / summary",
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(6),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		"APR",
                		"All Practical Reporting, Inc.",
                		BigInteger.valueOf(240),
                		"APR - Services Only",
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
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
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
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		"16",
                		"11",
                		"4",
                		"3",
                		"3",
                		"4",
                		"2",
                		"11",
                		"1",
                		"1",
                		"2",
                		"1",
                		"13",
                		"8",
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
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
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(10),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(4),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(16),
                		BigInteger.valueOf(10),
                		BigInteger.valueOf(3),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(11),
                		BigInteger.valueOf(4),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(16),
                		BigInteger.valueOf(10),
                		BigInteger.valueOf(3),
                		BigInteger.valueOf(2),
                		BigInteger.valueOf(1),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0),
                		BigInteger.valueOf(0)));
                return dataBeanList;
        }
        
        private DataBean produce(String startDate,
        		 String endDate,
        		 String projects,
        		 String homeLess,
        		 String grants,
        		 String view,
        		 BigInteger hmisProjectIdService,
        		 BigInteger hmisProjectType,
        		 BigInteger identityProjectId,
        		 BigInteger methodOfTracking,
        		 String orgId,
        		 String orgName,
        		 BigInteger projectId,
        		 String projectName,
        		 BigInteger clientlocationForPe,
        		 BigInteger destination,
        		 BigInteger disablingCond,
        		 BigInteger dob,
        		 BigInteger ethnicity,
        		 BigInteger firstName,
        		 BigInteger gender,
        		 BigInteger lastName,
        		 BigInteger ltsInEs,
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
        		 BigInteger race,
        		 BigInteger relationshiptToHh,
        		 BigInteger residencePriorToEntry,
        		 BigInteger ssn,
        		 BigInteger veteranStatus,
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
        		 BigInteger countAprUht,
        		 BigInteger countAprWc,
        		 BigInteger countAprWca,
        		 BigInteger countAprWoc,
        		 BigInteger countJanUht,
        		 BigInteger countJanWc,
        		 BigInteger countJanWca,
        		 BigInteger countJanWoc,
        		 BigInteger countJulUht,
        		 BigInteger countJulWc,
        		 BigInteger countJulWca,
        		 BigInteger countJulWoc,
        		 BigInteger countOctUht,
        		 BigInteger countOctWc,
        		 BigInteger countOctWca,
        		 BigInteger countOctWoc,
        		 BigInteger npAdultsTot,
        		 BigInteger npAdultsUhtTot,
        		 BigInteger npAdultsWcTot,
        		 BigInteger npAdultsWcaTot,
        		 BigInteger npAdultsWocTot,
        		 BigInteger npChildTot,
        		 BigInteger npChildUhtTot,
        		 BigInteger npChildWcTot,
        		 BigInteger npChildWcaTot,
        		 BigInteger npChildWocTot,
        		 BigInteger npDkrTot,
        		 BigInteger npDkrUhtTot,
        		 BigInteger npDkrWcTot,
        		 BigInteger npDkrWcsTot,
        		 BigInteger npDkrWocTot,
        		 BigInteger npMiTot,
        		 BigInteger npMiUhtTot,
        		 BigInteger npMiWcTot,
        		 BigInteger npMiWcaTot,
        		 BigInteger npMiWocTot,
        		 BigInteger npTotSum,
        		 BigInteger npWcSum,
        		 BigInteger npWCASum,
        		 BigInteger npWOCSum,
        		 BigInteger npUHTSum,
        		 BigInteger countJanTotal,
        		 BigInteger countAprTotal,
        		 BigInteger countJulTotal,
        		 BigInteger countOctTotal,
        		 BigInteger npTotalAdults,
        		 BigInteger npTotalChildren,
        		 BigInteger npTotalDKR,
    	 		 BigInteger npTotalMI,
    	         BigInteger npOverallTotal,
    	         BigInteger npTotalWC,
    	         BigInteger npWCATotal,
    	         BigInteger npWOCTotal,
    	         BigInteger npUHTTotal,
    	         BigInteger janTotal,
    	         BigInteger aprTotal,
    	         BigInteger julyTotal,
    	         BigInteger octTotal) {
    	
                DataBean dataBean = new DataBean();
                
                dataBean.setAprTotal(aprTotal);
                dataBean.setClientlocationForPe(clientlocationForPe);
                dataBean.setCountAprTotal(countAprTotal);
                dataBean.setCountAprUht(countAprUht);
                dataBean.setCountAprWc(countAprWc);
                dataBean.setCountAprWca(countAprWca);
                dataBean.setCountAprWoc(countAprWoc);
                dataBean.setCountJanTotal(countJanTotal);
                dataBean.setCountJanUht(countJanUht);
                dataBean.setCountJanWc(countJanWc);
                dataBean.setCountJanWca(countJanWca);
                dataBean.setCountJanWoc(countJanWoc);
                dataBean.setCountJulTotal(countJulTotal);
                dataBean.setCountJulUht(countJulUht);
                dataBean.setCountJulWc(countJulWc);
                dataBean.setCountJulWca(countJulWca);
                dataBean.setCountJulWoc(countJulWoc);
                dataBean.setCountOctTotal(countOctTotal);
                dataBean.setCountOctUht(countOctUht);
                dataBean.setCountOctWc(countOctWc);
                dataBean.setCountOctWca(countOctWca);
                dataBean.setCountOctWoc(countOctWoc);
                dataBean.setDestination(destination);
                dataBean.setDisablingCond(disablingCond);
                dataBean.setDob(dob);
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date();
                dataBean.setEndDate(dateFormat.format(date));
                dataBean.setEthnicity(ethnicity);
                dataBean.setFirstName(firstName);
                dataBean.setGender(gender);
                dataBean.setGrants(grants);
                dataBean.setHmisProjectIdService(hmisProjectIdService);
                dataBean.setHmisProjectType(hmisProjectType);
                dataBean.setHomeLess(homeLess);
                dataBean.setIdentityProjectId(identityProjectId);
                dataBean.setJanTotal(janTotal);
                dataBean.setJulyTotal(julyTotal);
                dataBean.setLastName(lastName);
                dataBean.setLtsInEs(ltsInEs);
                dataBean.setMdClientlocationForPe(mdClientlocationForPe);
                dataBean.setMdDestination(mdDestination);
                dataBean.setMdDisablingCond(mdDisablingCond);
                dataBean.setMdDob(mdDob);
                dataBean.setMdEthnicity(mdEthnicity);
                dataBean.setMdFirstName(mdFirstName);
                dataBean.setMdGender(mdGender);
                dataBean.setMdLastName(mdLastName);
                dataBean.setMdLtsInEsSh(mdLtsInEsSh);
                dataBean.setMdRace(mdRace);
                dataBean.setMdRelationshipToHh(mdRelationshipToHh);
                dataBean.setMdresidencepriortoentry(mdresidencepriortoentry);
                dataBean.setMdSsn(mdSsn);
                dataBean.setMdVeteranStatus(mdVeteranStatus);
                dataBean.setMethodOfTracking(methodOfTracking);
                dataBean.setNoOfAdultHeadsOfHousehold(noOfAdultHeadsOfHousehold);
                dataBean.setNoOfChildHeadsOfHousehold(noOfChildHeadsOfHousehold);
                dataBean.setNoOfChronicallyHomelessPersons(noOfChronicallyHomelessPersons);
                dataBean.setNoOfVeterans(noOfVeterans);
                dataBean.setNpAdultsTot(npAdultsTot);
                dataBean.setNpAdultsUhtTot(npAdultsUhtTot);
                dataBean.setNpAdultsWcaTot(npAdultsWcaTot);
                dataBean.setNpAdultsWcTot(npAdultsWcTot);
                dataBean.setNpAdultsWocTot(npAdultsWocTot);
                dataBean.setNpChildTot(npChildTot);
                dataBean.setNpChildUhtTot(npChildUhtTot);
                dataBean.setNpChildWcaTot(npChildWcaTot);
                dataBean.setNpChildWcTot(npChildWcTot);
                dataBean.setNpChildWocTot(npChildWocTot);
                dataBean.setNpDkrTot(npDkrTot);
                dataBean.setNpDkrUhtTot(npDkrUhtTot);
                dataBean.setNpDkrWcsTot(npDkrWcsTot);
                dataBean.setNpDkrWcTot(npDkrWcTot);
                dataBean.setNpDkrWocTot(npDkrWocTot);
                dataBean.setNpMiTot(npMiTot);
                dataBean.setNpMiUhtTot(npMiUhtTot);
                dataBean.setNpMiWcTot(npMiWcTot);
                dataBean.setNpMiWcaTot(npMiWcaTot);
                dataBean.setNpMiWocTot(npMiWocTot);
                dataBean.setNpOverallTotal(npOverallTotal);
                dataBean.setNpTotalAdults(npTotalAdults);
                dataBean.setNpTotalChildren(npTotalChildren);
                dataBean.setNpTotalDKR(npTotalDKR);
                dataBean.setNpTotalMI(npTotalMI);
                dataBean.setNpTotalWC(npTotalWC);
                dataBean.setNpTotSum(npTotSum);
                dataBean.setNpUHTSum(npUHTSum);
                dataBean.setNpUHTTotal(npUHTTotal);
                dataBean.setNpWCASum(npWCASum);
                dataBean.setNpWCATotal(npWCATotal);
                dataBean.setNpWcSum(npWcSum);
                dataBean.setNpWOCSum(npWOCSum);
                dataBean.setNpWOCTotal(npWOCTotal);
                dataBean.setNumOfAdults(numOfAdults);
                dataBean.setNumOfChildren(numOfChildren);
                dataBean.setNumOfParentingYouthUnderAge25WithChildren(numOfParentingYouthUnderAge25WithChildren);
                dataBean.setNumOfPersonsWithUnknownAge(numOfPersonsWithUnknownAge);
                dataBean.setNumOfUnaccompaniedYouthUnderAge25(numOfUnaccompaniedYouthUnderAge25);
                dataBean.setOctTotal(octTotal);
                dataBean.setOrgId(orgId);
                dataBean.setOrgName(orgName);
                dataBean.setProjectId(projectId);
                dataBean.setProjectName(projectName);
                dataBean.setProjects(projects);
                dataBean.setRace(race);
                dataBean.setRelationshiptToHh(relationshiptToHh);
                dataBean.setResidencePriorToEntry(residencePriorToEntry);
                dataBean.setSsn(ssn);
                dataBean.setStartDate(startDate);
                dataBean.setTotNoOfAdultLeavers(totNoOfAdultLeavers);
                dataBean.setTotNoOfAdultStayers(totNoOfAdultStayers);
                dataBean.setTotNoOfLeavers(totNoOfLeavers);
                dataBean.setTotNoOfStayers(totNoOfStayers);
                dataBean.setTotNumOfPersonServed(totNumOfPersonServed);
                dataBean.setVeteranStatus(veteranStatus);
                dataBean.setView(view);

                return dataBean;
        }
}