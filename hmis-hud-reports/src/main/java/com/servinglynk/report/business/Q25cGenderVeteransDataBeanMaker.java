package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q25cGenderVeteransDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q25cGenderVeteransDataBeanMaker {
	
	public static List<Q25cGenderVeteransDataBean> getQ25cGenderVeteransList(ReportData data){
		
				List<ClientModel> clients = data.getClients();
				List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());

		
				Q25cGenderVeteransDataBean q25cGenderVeteranTable = new Q25cGenderVeteransDataBean();
		
				q25cGenderVeteranTable.setQ25cMaleTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cMaleWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cMaleWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cMaleUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cFemaleTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cFemaleWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cFemaleWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cFemaleUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgenderMaleToFemaleUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTransgendereFemaleToMaleUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cOtherTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cOtherWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cOtherWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cOtherUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cDKRTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cDKRWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cDKRWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cDKRUnknownHouseHold(BigInteger.valueOf(0));

				q25cGenderVeteranTable.setQ25cInformationMissingTotal(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cInformationMissingWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cInformationMissingUnknownHouseHold(BigInteger.valueOf(0));
							
				q25cGenderVeteranTable.setQ25cTotTotal(BigInteger.valueOf(veterans !=null ? veterans.size() : 0));
				q25cGenderVeteranTable.setQ25cTotWithoutChildren(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTotWithChildAndAdults(BigInteger.valueOf(0));
				q25cGenderVeteranTable.setQ25cTotUnknownHouseHold(BigInteger.valueOf(0));

		
		return Arrays.asList(q25cGenderVeteranTable);
	}

}
