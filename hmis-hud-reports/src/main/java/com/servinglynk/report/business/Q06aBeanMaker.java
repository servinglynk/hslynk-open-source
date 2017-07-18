package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q06aDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

import jodd.util.StringUtil;

public class Q06aBeanMaker {
	public static Long nameCDK = 0L;
	public static  Long nameInfoMissing = 0L;
	public static  Long nameDataIssue = 0L;
	public static  Long namePercentageErrorRate = 0L;
	public static  Long ssnCDK = 0L;
	public static  Long ssnInfoMissing = 0L;
	public static  Long ssnDataIssue = 0L;
	public static  Long ssnPercentageErrorRate = 0L;
	public static  Long dobCDK = 0L;
	public static  Long dobInfoMissing = 0L;
	public static  Long dobDataIssue = 0L;
	public static  Long dobPercentageErrorRate = 0L;
	public static  Long raceCDK = 0L;
	public static  Long raceInfoMissing = 0L;
	public static  Long raceDataIssue = 0L;
	public static Long racePercentageErrorRate = 0L;
	public static Long ethnicityCDK = 0L;
	public static Long ethnicityInfoMissing = 0L;
	public static Long ethnicityDataIssue = 0L;
	public static Long ethnicityPercentageErrorRate = 0L;
	public static Long genderCDK = 0L;
	public static Long genderInfoMissing = 0L;
	public static Long genderPercentageErrorRate = 0L;
	public static Long overAllPercentage = 0L;
	
	/***
	 *  Sandeep TODO: Need to determine the value for DataIssue and PercentageErrorRate field.
	 * @param data
	 * @return
	 */
	public static List<Q06aDataBean> getBeanData(ReportData data){
		Q06aDataBean q06aBean = new Q06aDataBean();
		
		List<ClientModel> clients = data.getClients();
		Long numOfClients = Long.valueOf(clients.size());
		clients.parallelStream().forEach(client -> { 
			
			if(StringUtil.equals("8", client.getName_data_quality()) || StringUtil.equals("9", client.getName_data_quality()))  {
				nameCDK++;
			}
			if(StringUtil.equals("99", client.getName_data_quality())) {
				nameInfoMissing++;
			}
			if(StringUtil.equals("2", client.getName_data_quality())) {
				nameDataIssue++;
			}
			//Sandeept TODO: What is a name data issue and what is % Error rate.
			if(StringUtil.equals("8", client.getSsn_data_quality()) || StringUtil.equals("9", client.getSsn_data_quality()))  {
				ssnCDK++;
			}
			if(StringUtil.equals("99", client.getSsn_data_quality())) {
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
			if(StringUtil.equals("2", client.getSsn_data_quality()) ) {
				ssnDataIssue++;
			}
			if(StringUtil.equals("8", client.getDob_data_quality()) || StringUtil.equals("9", client.getDob_data_quality()))  {
				dobCDK++;
			}
			if(StringUtil.equals("99", client.getDob_data_quality())) {
				dobInfoMissing++;
			}
			/* TODO: Sandeep
			 * Prior to 1/1/1915.
				o After the [date created] for the record.
				o Equal to or after the [project entry date]. 
			 */
			if(StringUtil.equals("2", client.getDob_data_quality())) {
				dobDataIssue++;
			}
			if(StringUtil.equals("8", client.getRace()) || StringUtil.equals("9", client.getRace()))  {
				raceCDK++;
			}
			if(StringUtil.equals("99", client.getRace())) {
				raceInfoMissing++;
			}
			if(StringUtil.equals("2", client.getRace())) {
				raceDataIssue++;
			}
			if(StringUtil.equals("8", client.getEthnicity()) || StringUtil.equals("9", client.getEthnicity()))  {
				ethnicityCDK++;
			}
			if(StringUtil.equals("99", client.getEthnicity())) {
				ethnicityInfoMissing++;
			}
			if(StringUtil.equals("2", client.getRace())) {
				ethnicityDataIssue++;
			}
			if(StringUtil.equals("8", client.getGender()) || StringUtil.equals("9", client.getGender()))  {
				genderCDK++;
			}
			if(StringUtil.equals("99", client.getGender())) {
				genderInfoMissing++;
			}
		}
		);
		q06aBean.setNameCDK(BigInteger.valueOf(nameCDK));
		q06aBean.setNameInfoMissing(BigInteger.valueOf(nameInfoMissing));
		q06aBean.setNameDataIssue(BigInteger.valueOf(nameDataIssue));
		q06aBean.setNamePercentageErrorRate(BigInteger.valueOf((nameCDK+nameInfoMissing+nameDataIssue)/numOfClients));
		q06aBean.setSsnCDK(BigInteger.valueOf(ssnCDK));
		q06aBean.setSsnInfoMissing(BigInteger.valueOf(ssnInfoMissing));
		q06aBean.setSsnDataIssue(BigInteger.valueOf(ssnDataIssue));
		q06aBean.setSsnPercentageErrorRate(BigInteger.valueOf((ssnCDK+ssnInfoMissing+ssnDataIssue)/numOfClients));
		q06aBean.setDobCDK(BigInteger.valueOf(ssnCDK));
		q06aBean.setDobInfoMissing(BigInteger.valueOf(ssnInfoMissing));
		q06aBean.setDobDataIssue(BigInteger.valueOf(dobDataIssue));
		q06aBean.setDobPercentageErrorRate(BigInteger.valueOf((ssnCDK+ssnInfoMissing+dobDataIssue)/numOfClients)); 
		q06aBean.setRaceCDK(BigInteger.valueOf(raceCDK));
		q06aBean.setRaceInfoMissing(BigInteger.valueOf(raceInfoMissing));
		q06aBean.setRaceDataIssue(BigInteger.valueOf(raceDataIssue));
		q06aBean.setRacePercentageErrorRate(BigInteger.valueOf((raceCDK+raceInfoMissing+raceDataIssue)/numOfClients));
		q06aBean.setEthnicityCDK(BigInteger.valueOf(ethnicityCDK));
		q06aBean.setEthnicityInfoMissing(BigInteger.valueOf(ethnicityInfoMissing));
		q06aBean.setEthnicityDataIssue(BigInteger.valueOf(ethnicityDataIssue));
		q06aBean.setEthnicityPercentageErrorRate(BigInteger.valueOf((ethnicityCDK+ethnicityInfoMissing+ethnicityDataIssue)/numOfClients));
		q06aBean.setGenderCDK(BigInteger.valueOf(genderCDK));
		q06aBean.setGenderInfoMissing(BigInteger.valueOf(genderInfoMissing));
		q06aBean.setGenderPercentageErrorRate(BigInteger.valueOf((genderCDK+genderInfoMissing)/numOfClients));
		q06aBean.setOverAllPercentage(BigInteger.valueOf(1));


		
        return Arrays.asList(q06aBean);
    }
}
