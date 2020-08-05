package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q06aReportValidationsTableDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q06aBeanMaker extends BaseBeanMaker {
	public static int nameCDK = 0;
	public static  int nameInfoMissing = 0;
	public static  int nameDataIssue = 0;
	public static  int namePercentageErrorRate = 0;
	public static  int nameTotal = 0;
	public static  int ssnCDK = 0;
	public static  int ssnInfoMissing = 0;
	public static  int ssnDataIssue = 0;
	public static  int ssnPercentageErrorRate = 0;
	public static  int ssnTotal= 0;
	public static  int dobCDK = 0;
	public static  int dobInfoMissing = 0;
	public static  int dobDataIssue = 0;
	public static  int dobPercentageErrorRate = 0;
	public static  int dobTotal= 0;
	public static  int raceCDK = 0;
	public static  int raceInfoMissing = 0;
	public static  int raceDataIssue = 0;
	public static int racePercentageErrorRate = 0;
	public static int raceTotal = 0;
	public static int ethnicityCDK = 0;
	public static int ethnicityInfoMissing = 0;
	public static int ethnicityDataIssue = 0;
	public static int ethnicityPercentageErrorRate = 0;
	public static int ethnicityTotal = 0;
	public static int genderCDK = 0;
	public static int genderInfoMissing = 0;
	public static int genderPercentageErrorRate = 0;
	public static int genderTotal = 0;
	public static int overAllPercentage = 0;
	public static int overAllTotal = 0;
	
	/***
	 *  Sandeep TODO: Need to determine the value for DataIssue and PercentageErrorRate field.
	 * @param data
	 * @return
	 */
	public static List<Q06aReportValidationsTableDataBean> getBeanData(ReportData data){
		Q06aReportValidationsTableDataBean q06aBean = new Q06aReportValidationsTableDataBean();
		if(data.isLiveMode()) {
		try {
			int numOfClients = 0;
			List<ClientModel> clients = data.getClients();
			if(CollectionUtils.isNotEmpty(clients)) {
				numOfClients = clients.size();
			clients.forEach(client -> { 
				
				if(StringUtils.equals("8", client.getName_data_quality()) || StringUtils.equals("9", client.getName_data_quality()))  {
					nameCDK++;
				}
				if(StringUtils.equals("99", client.getName_data_quality())) {
					nameInfoMissing++;
				}
				if(StringUtils.equals("2", client.getName_data_quality())) {
					nameDataIssue++;
				}
				//Sandeept TODO: What is a name data issue and what is % Error rate.
				if(StringUtils.equals("8", client.getSsn_data_quality()) || StringUtils.equals("9", client.getSsn_data_quality()))  {
					ssnCDK++;
				}
				if(StringUtils.equals("99", client.getSsn_data_quality())) {
					ssnInfoMissing++;
				}
				/* TODO Sandeep
				 *  Cannot contain a non-numeric character.
					o Must be 9 digits long.
					o First three digits cannot be “000,” “666,” or in the 900 series.
					o The second group / 5th and 6th digits cannot be “00”.
					o The third group / last four digits cannot be “0000”.
					o There cannot be repetitive (e.g. “333333333”) or sequential (e.g. “345678901” “987654321”)
					numbers for all 9 digits.
					• Column B Row 4 – count of clients 
				 */
				if(StringUtils.equals("2", client.getSsn_data_quality()) ) {
					ssnDataIssue++;
				}
				if(StringUtils.equals("8", client.getDob_data_quality()) || StringUtils.equals("9", client.getDob_data_quality()))  {
					dobCDK++;
				}
				if(StringUtils.equals("99", client.getDob_data_quality())) {
					dobInfoMissing++;
				}
				/* TODO: Sandeep
				 * Prior to 1/1/1915.
					o After the [date created] for the record.
					o Equal to or after the [project entry date]. 
				 */
				if(StringUtils.equals("2", client.getDob_data_quality())) {
					dobDataIssue++;
				}
				if(StringUtils.equals("8", client.getRace()) || StringUtils.equals("9", client.getRace()))  {
					raceCDK++;
				}
				if(StringUtils.equals("99", client.getRace())) {
					raceInfoMissing++;
				}
				if(StringUtils.equals("2", client.getRace())) {
					raceDataIssue++;
				}
				if(StringUtils.equals("8", client.getEthnicity()) || StringUtils.equals("9", client.getEthnicity()))  {
					ethnicityCDK++;
				}
				if(StringUtils.equals("99", client.getEthnicity())) {
					ethnicityInfoMissing++;
				}
				if(StringUtils.equals("2", client.getRace())) {
					ethnicityDataIssue++;
				}
				if(StringUtils.equals("8", client.getGender()) || StringUtils.equals("9", client.getGender()))  {
					genderCDK++;
				}
				if(StringUtils.equals("99", client.getGender())) {
					genderInfoMissing++;
				}
			}
			);
			}
			
			nameTotal = nameCDK + nameInfoMissing + nameDataIssue;
			ssnTotal = ssnCDK+ssnInfoMissing+ssnDataIssue;
			dobTotal = dobCDK+dobInfoMissing+dobDataIssue;
			raceTotal = raceCDK+raceInfoMissing+raceDataIssue;
			ethnicityTotal = ethnicityCDK+ethnicityInfoMissing+ethnicityDataIssue;
			genderTotal = genderCDK+genderInfoMissing;
			overAllTotal = nameTotal + ssnTotal + dobTotal + raceTotal + ethnicityTotal + genderTotal;
			q06aBean.setNameCDK(BigInteger.valueOf(nameCDK));
			q06aBean.setNameInfoMissing(BigInteger.valueOf(nameInfoMissing));
			q06aBean.setNameDataIssue(BigInteger.valueOf(nameDataIssue));
			q06aBean.setNameTotal(BigInteger.valueOf(nameTotal));
			q06aBean.setNamePercentageErrorRate(BigInteger.valueOf(nameTotal/numOfClients));
			q06aBean.setSsnCDK(BigInteger.valueOf(ssnCDK));
			q06aBean.setSsnInfoMissing(BigInteger.valueOf(ssnInfoMissing));
			q06aBean.setSsnDataIssue(BigInteger.valueOf(ssnDataIssue));
			q06aBean.setSsnTotal(BigInteger.valueOf(ssnTotal));
			q06aBean.setSsnPercentageErrorRate(BigInteger.valueOf(ssnTotal/numOfClients));
			q06aBean.setDobCDK(BigInteger.valueOf(ssnCDK));
			q06aBean.setDobInfoMissing(BigInteger.valueOf(ssnInfoMissing));
			q06aBean.setDobDataIssue(BigInteger.valueOf(dobDataIssue));
			q06aBean.setDobPercentageErrorRate(BigInteger.valueOf(dobTotal/numOfClients)); 
			q06aBean.setDobTotal(BigInteger.valueOf(dobTotal));
			q06aBean.setRaceCDK(BigInteger.valueOf(raceCDK));
			q06aBean.setRaceInfoMissing(BigInteger.valueOf(raceInfoMissing));
			q06aBean.setRaceDataIssue(BigInteger.valueOf(raceDataIssue));
			q06aBean.setRaceTotal(BigInteger.valueOf(raceTotal));
			
			q06aBean.setRacePercentageErrorRate(BigInteger.valueOf(raceTotal/numOfClients));
			q06aBean.setEthnicityCDK(BigInteger.valueOf(ethnicityCDK));
			q06aBean.setEthnicityInfoMissing(BigInteger.valueOf(ethnicityInfoMissing));
			q06aBean.setEthnicityDataIssue(BigInteger.valueOf(ethnicityDataIssue));
			q06aBean.setEthnicityTotal(BigInteger.valueOf(ethnicityTotal));
			q06aBean.setEthnicityPercentageErrorRate(BigInteger.valueOf(ethnicityTotal/numOfClients));
			q06aBean.setGenderTotal(BigInteger.valueOf(genderTotal));
			q06aBean.setGenderCDK(BigInteger.valueOf(genderCDK));
			q06aBean.setGenderInfoMissing(BigInteger.valueOf(genderInfoMissing));
			
			q06aBean.setGenderPercentageErrorRate(BigInteger.valueOf(genderTotal/numOfClients));
			q06aBean.setOverAllPercentage(BigInteger.valueOf(0));
			q06aBean.setOverAllTotal(BigInteger.valueOf(overAllTotal));
		}catch(Exception e) {
			logger.error("Error in Q06aBeanMaker:"+e);
		}
		}
        return Arrays.asList(q06aBean);
    }
}
