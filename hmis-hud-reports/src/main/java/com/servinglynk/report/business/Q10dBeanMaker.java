package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q10dGenderByAgeRangesDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q10dBeanMaker extends BaseBeanMaker {

	public static List<Q10dGenderByAgeRangesDataBean> getQ10DGARList(ReportData data){
		Q10dGenderByAgeRangesDataBean q10dGenderByAgeRanges= new Q10dGenderByAgeRangesDataBean();
		if(data.isLiveMode()) {
		try {
		List<ClientModel> clients = data.getClients();
		List<ClientModel> female = clients.parallelStream().filter(client->StringUtils.equals("1",client.getGender())).collect(Collectors.toList());
		List<ClientModel> male = clients.parallelStream().filter(client->StringUtils.equals("0",client.getGender())).collect(Collectors.toList());
		List<ClientModel> transMale = clients.parallelStream().filter(client->StringUtils.equals("2",client.getGender())).collect(Collectors.toList());
		List<ClientModel> transFemale = clients.parallelStream().filter(client->StringUtils.equals("3",client.getGender())).collect(Collectors.toList());
		List<ClientModel> others = clients.parallelStream().filter(client->StringUtils.equals("4",client.getGender())).collect(Collectors.toList());
		List<ClientModel> clientDk = clients.parallelStream().filter(client->StringUtils.equals("8",client.getGender()) || StringUtils.equals("9",client.getGender())).collect(Collectors.toList());
		List<ClientModel> clientMissing = clients.parallelStream().filter(client->StringUtils.equals("99",client.getGender())).collect(Collectors.toList());

		
		BigInteger totSubTotal = BigInteger.ZERO;
		BigInteger ageU18SubTotal = BigInteger.ZERO;
		BigInteger age18to24SubTotal = BigInteger.ZERO;
		BigInteger age25to61SubTotal = BigInteger.ZERO;
		BigInteger age62OverSubTotal = BigInteger.ZERO;
		BigInteger cdrSubTotal = BigInteger.ZERO;
		BigInteger dncSubTotal = BigInteger.ZERO;
		
		if(CollectionUtils.isNotEmpty(male)) {
			q10dGenderByAgeRanges.setQ10dTotMale(BigInteger.valueOf(male.size()));
			List<ClientModel> clientsUnder18 = male.parallelStream().filter(client-> client.getAge() < 18 && client.getAge()!=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = male.parallelStream().filter(client-> client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = male.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = male.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = male.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = male.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;
			
			totSubTotal.add(BigInteger.valueOf(male.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dU18Male(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24Male(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61Male(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverMale(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRMale(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCMale(BigInteger.valueOf(clientsDNCSize));
		}
	
		if(CollectionUtils.isNotEmpty(female)) {
			List<ClientModel> clientsUnder18 = female.parallelStream().filter(client->  client.getAge() < 18 && client.getAge() !=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = female.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = female.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = female.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = female.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = female.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(female.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotFemale(BigInteger.valueOf(female.size()));
			q10dGenderByAgeRanges.setQ10dAgeU18Female(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18TO24Female(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25TO61Female(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverFemale(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRFemale(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCFemale(BigInteger.valueOf(clientsDNCSize));
			
		}
		
		if(CollectionUtils.isNotEmpty(transFemale)) {
			
			List<ClientModel> clientsUnder18 = transFemale.parallelStream().filter(client->  client.getAge() < 18 && client.getAge()!=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = transFemale.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = transFemale.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = transFemale.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = transFemale.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = transFemale.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(transFemale.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotMTF(BigInteger.valueOf(transFemale.size())); 
			q10dGenderByAgeRanges.setQ10dAgeU18MTF(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24MTF(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61MTF(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverMTF(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRMTF(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCMTF(BigInteger.valueOf(clientsDNCSize));
		}
		
		if(CollectionUtils.isNotEmpty(transMale)) {
			
			List<ClientModel> clientsUnder18 = transMale.parallelStream().filter(client->  client.getAge() < 18 && client.getAge() !=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = transMale.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = transMale.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = transMale.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = transMale.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = transMale.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(transMale.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotFTM(BigInteger.valueOf(transMale.size()));
			q10dGenderByAgeRanges.setQ10dAgeU18FTM(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24FTM(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61FTM(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverFTM(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRFTM(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCFTM(BigInteger.valueOf(clientsDNCSize));
		}
		
		if(CollectionUtils.isNotEmpty(others)) {
			
			List<ClientModel> clientsUnder18 = others.parallelStream().filter(client->  client.getAge() < 18 && client.getAge() !=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = others.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = others.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = others.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = others.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = others.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(others.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotGNC(BigInteger.valueOf(others.size()));
			q10dGenderByAgeRanges.setQ10dAgeU18GNC(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24GNC(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61GNC(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverGNC(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRGNC(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCGNC(BigInteger.valueOf(clientsDNCSize));
		}
		if(CollectionUtils.isNotEmpty(clientDk)) {
			
			List<ClientModel> clientsUnder18 = clientDk.parallelStream().filter(client->  client.getAge() < 18  && client.getAge() !=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = clientDk.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = clientDk.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = clientDk.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			List<ClientModel> clientsCDR = clientDk.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = clientDk.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(clientDk.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotCDR(BigInteger.valueOf(clientDk.size()));
			q10dGenderByAgeRanges.setQ10dAgeU18CDR(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24CDR(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61CDR(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverCDR(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dClientCDR(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDNCCDR(BigInteger.valueOf(clientsDNCSize));
		}
		
		if(CollectionUtils.isNotEmpty(clientMissing)) {
			
			List<ClientModel> clientsUnder18 = clientMissing.parallelStream().filter(client->  client.getAge() < 18 && client.getAge() !=0).collect(Collectors.toList());
			List<ClientModel> clients18to24 = clientMissing.parallelStream().filter(client->  client.getAge() >= 18 && client.getAge() <= 24).collect(Collectors.toList());
			List<ClientModel> clients25to61 = clientMissing.parallelStream().filter(client->  client.getAge() >= 25 && client.getAge() <= 61).collect(Collectors.toList());
			List<ClientModel> clients62Over = clientMissing.parallelStream().filter(client->  client.getAge() >= 62).collect(Collectors.toList());
			
			List<ClientModel> clientsCDR = clientMissing.parallelStream().filter(client -> StringUtils.equals("8", client.getDob_data_quality()) && StringUtils.equals("9", client.getDob_data_quality()) ).collect(Collectors.toList());
			List<ClientModel> clientsDNC = clientMissing.parallelStream().filter(client -> StringUtils.equals("99", client.getDob_data_quality())).collect(Collectors.toList());
			
			
			int clientsUnder18Size = clientsUnder18 != null ? clientsUnder18.size() : 0;
			int clients18to24Size =clients18to24 != null ? clients18to24.size() : 0;
			int clients25to61Size =clients25to61 != null ? clients25to61.size() : 0;
			int clients62OverSize =clients62Over != null ? clients62Over.size() : 0;
			int clientsCDRSize =clientsCDR != null ? clientsCDR.size() : 0;
			int clientsDNCSize = clientsDNC != null ? clientsDNC.size() : 0;

			totSubTotal.add(BigInteger.valueOf(clientMissing.size()));
			ageU18SubTotal.add(BigInteger.valueOf(clientsUnder18Size));
			age18to24SubTotal.add(BigInteger.valueOf(clients18to24Size));
			age25to61SubTotal.add(BigInteger.valueOf(clients25to61Size));
			age62OverSubTotal.add(BigInteger.valueOf(clients62OverSize));
			cdrSubTotal.add(BigInteger.valueOf(clientsCDRSize));
			dncSubTotal.add(BigInteger.valueOf(clientsDNCSize));
			
			q10dGenderByAgeRanges.setQ10dTotDNC(BigInteger.valueOf(clientMissing.size()));
			q10dGenderByAgeRanges.setQ10dAgeU18DNC(BigInteger.valueOf(clientsUnder18Size));
			q10dGenderByAgeRanges.setQ10dAge18to24DNC(BigInteger.valueOf(clients18to24Size));
			q10dGenderByAgeRanges.setQ10dAge25to61DNC(BigInteger.valueOf(clients25to61Size));
			q10dGenderByAgeRanges.setQ10dAge62OverDNC(BigInteger.valueOf(clients62OverSize));
			q10dGenderByAgeRanges.setQ10dCDRDNC(BigInteger.valueOf(clientsCDRSize));
			q10dGenderByAgeRanges.setQ10dDataDNC(BigInteger.valueOf(clientsDNCSize));
		}
		
		q10dGenderByAgeRanges.setQ10dTotSubTotal(totSubTotal);
		q10dGenderByAgeRanges.setQ10dAgeU18SubTotal(ageU18SubTotal);
		q10dGenderByAgeRanges.setQ10dAge18to24SubTotal(age18to24SubTotal);
		q10dGenderByAgeRanges.setQ10dAge25to61SubTotal(age25to61SubTotal);
		q10dGenderByAgeRanges.setQ10dAge62OverSubTotal(age62OverSubTotal);
		q10dGenderByAgeRanges.setQ10dCDRSubTotal(cdrSubTotal);
		q10dGenderByAgeRanges.setQ10dDNCSubTotal(dncSubTotal);
			
	} catch (Exception e) {
		logger.error("Error in Q10dDataBeanMaker:" + e);
	}
	}
	return Arrays.asList(q10dGenderByAgeRanges);
	
}


	
	
}
