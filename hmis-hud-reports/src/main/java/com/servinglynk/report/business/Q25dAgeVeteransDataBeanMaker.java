package com.servinglynk.report.business;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.servinglynk.report.bean.Q25dAgeVeteransDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;

public class Q25dAgeVeteransDataBeanMaker {

	public static List<Q25dAgeVeteransDataBean> getQ25dAgeVeteransList(ReportData data){
		
		List<ClientModel> clients = data.getClients();
		List<ClientModel> veterans = clients.parallelStream().filter(client -> StringUtils.equals("1",client.getVeteran_status())).collect(Collectors.toList());

		Q25dAgeVeteransDataBean q25dAgeVeteransTable = new Q25dAgeVeteransDataBean();
		
				q25dAgeVeteransTable.setQ25d18To24Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d18To24UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d25To34Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d25To34UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d35To44Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d35To44UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d45To54Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d45To54UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d55To61Total(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61WithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61WithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d55To61UnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25d62PlusTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25d62PlusUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dDKRTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dDKRUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dInformationMissingTotal(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dInformationMissingUnknownHouseHold(BigInteger.valueOf(0));

				q25dAgeVeteransTable.setQ25dTotTotal(BigInteger.valueOf(veterans !=null ? veterans.size() : 0));
				q25dAgeVeteransTable.setQ25dTotWithoutChildren(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dTotWithChildAndAdults(BigInteger.valueOf(0));
				q25dAgeVeteransTable.setQ25dTotUnknownHouseHold(BigInteger.valueOf(0));
						
		
		return Arrays.asList(q25dAgeVeteransTable);
	}
	
}
