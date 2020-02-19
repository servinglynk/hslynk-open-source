package com.servinglynk.report.business;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.DisabIncomeAndSourceDataBean;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.HouseHoldType;

public class DisabIncomeAndSourceDataBeanMaker extends BaseBeanMaker {

public static List<DisabIncomeAndSourceDataBean> getDisabIncomeAndSourceDataBean(ReportData data,String query){
		
		DisabIncomeAndSourceDataBean disabIncomeAndSourceDataBean = new DisabIncomeAndSourceDataBean();
		
		if(data.isLiveMode()) {
			try{
			
			String exitQuery = " select count(e.dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e ,%s.client c,%s.exit ext where  e.client_id = c.id and   e.id=i.enrollmentid  and   e.id=ext.enrollmentid "+ 
					" and TO_DATE(i.information_date) = TO_DATE(ext.exitdate)  and i.information_date <= :endDate  and i.datacollectionstage='3' and e.ageatentry >= 18 and i.incomefromanysource is not null and i.incomefromanysource not in ('8','9','99') and e.disablingcondition is not null and e.disablingcondition not in ('8','9','99')  ";
			if(StringUtils.isNotBlank(query) && !StringUtils.equals("null", query)) {
				exitQuery =  exitQuery + query ;
			}
			
			int earnedAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.AO, data);
			int earnedAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalAOEarned = earnedAOWithDisab + earnedAOWithOutDisab;
			double earnedAODisabPercentage = earnedAOWithDisab/totalAOEarned ;
			
			disabIncomeAndSourceDataBean.setEarnedAOWithDisab(BigInteger.valueOf(earnedAOWithDisab));
			disabIncomeAndSourceDataBean.setEarnedAOWithOutDisab(BigInteger.valueOf(earnedAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalAOEarned(BigInteger.valueOf(totalAOEarned));
			disabIncomeAndSourceDataBean.setEarnedAODisabPercentage(BigDecimal.valueOf(earnedAODisabPercentage).toBigInteger());
			
			
			int earnedACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.AC, data);
			int earnedACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalACEarned = earnedACWithDisab + earnedACWithOutDisab;
			double earnedACDisabPercentage = earnedACWithDisab/totalACEarned ;
			
			
			disabIncomeAndSourceDataBean.setEarnedACWithDisab(BigInteger.valueOf(earnedACWithDisab));
			disabIncomeAndSourceDataBean.setEarnedACWithOutDisab(BigInteger.valueOf(earnedACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalACEarned(BigInteger.valueOf(totalACEarned));
			disabIncomeAndSourceDataBean.setEarnedACDisabPercentage(BigDecimal.valueOf(earnedACDisabPercentage).toBigInteger());
			
			int earnedUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.UK, data);
			int earnedUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalUKEarned = earnedUKWithDisab + earnedUKWithOutDisab;
			double earnedUKDisabPercentage = earnedUKWithDisab/totalUKEarned ;
			
			disabIncomeAndSourceDataBean.setEarnedUKWithDisab(BigInteger.valueOf(earnedUKWithDisab));
			disabIncomeAndSourceDataBean.setEarnedUKWithOutDisab(BigInteger.valueOf(earnedUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalUKEarned(BigInteger.valueOf(totalUKEarned));
			disabIncomeAndSourceDataBean.setEarnedUKDisabPercentage(BigDecimal.valueOf(earnedUKDisabPercentage).toBigInteger());
			
			int ssiAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int ssiAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalssiAO = ssiAOWithOutDisab + ssiAOWithDisab;
			double ssiAODisabPercentage = ssiAOWithDisab/ssiAOWithDisab ;

			disabIncomeAndSourceDataBean.setSsiAOWithDisab(BigInteger.valueOf(ssiAOWithDisab));
			disabIncomeAndSourceDataBean.setSsiAOWithOutDisab(BigInteger.valueOf(ssiAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssiAO(BigInteger.valueOf(totalssiAO));
			disabIncomeAndSourceDataBean.setSsiAODisabPercentage(BigDecimal.valueOf(ssiAODisabPercentage).toBigInteger());
			
			
			int ssiACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.AC ,data);
			int ssiACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalssiAC = ssiACWithOutDisab + ssiACWithDisab;
			double ssiACDisabPercentage = ssiACWithDisab/totalssiAC ;
			
			disabIncomeAndSourceDataBean.setSsiACWithDisab(BigInteger.valueOf(ssiACWithDisab));
			disabIncomeAndSourceDataBean.setSsiACWithOutDisab(BigInteger.valueOf(ssiACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssiAC(BigInteger.valueOf(totalssiAC));
			disabIncomeAndSourceDataBean.setSsiACDisabPercentage(BigDecimal.valueOf(ssiACDisabPercentage).toBigInteger());
			
			
			int ssiUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int ssiUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalssiUK = ssiUKWithDisab + ssiUKWithOutDisab;
			double ssiUKDisabPercentage = ssiUKWithDisab/totalssiUK ;
			
			disabIncomeAndSourceDataBean.setSsiACWithDisab(BigInteger.valueOf(ssiUKWithDisab));
			disabIncomeAndSourceDataBean.setSsiACWithOutDisab(BigInteger.valueOf(ssiUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssiAC(BigInteger.valueOf(totalssiUK));
			disabIncomeAndSourceDataBean.setSsiACDisabPercentage(BigDecimal.valueOf(ssiUKDisabPercentage).toBigInteger());
			
			int ssdiAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int ssdiAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalssdiAO = ssdiAOWithDisab + ssdiAOWithOutDisab;
			double ssdiAODisabPercentage = ssdiAOWithDisab/totalssdiAO ;
			
			disabIncomeAndSourceDataBean.setSsdiAOWithDisab(BigInteger.valueOf(ssdiAOWithDisab));
			disabIncomeAndSourceDataBean.setSsdiAOWithOutDisab(BigInteger.valueOf(ssdiAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssdiAO(BigInteger.valueOf(totalssdiAO));
			disabIncomeAndSourceDataBean.setSsdiAODisabPercentage(BigDecimal.valueOf(ssdiAODisabPercentage).toBigInteger());
		
			int ssdiACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int ssdiACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalssdiAC = ssdiACWithDisab + ssdiACWithOutDisab;
			double ssdiACDisabPercentage = ssdiACWithDisab/totalssdiAC ;
			
			disabIncomeAndSourceDataBean.setSsdiACWithDisab(BigInteger.valueOf(ssdiACWithDisab));
			disabIncomeAndSourceDataBean.setSsdiACWithOutDisab(BigInteger.valueOf(ssdiACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssdiAC(BigInteger.valueOf(totalssdiAC));
			disabIncomeAndSourceDataBean.setSsdiACDisabPercentage(BigDecimal.valueOf(ssdiACDisabPercentage).toBigInteger());
		
			int ssdiUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int ssdiUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalssdiUK = ssdiUKWithDisab + ssdiUKWithOutDisab;
			double ssdiUKDisabPercentage = ssdiUKWithDisab/totalssdiUK ;
			
			disabIncomeAndSourceDataBean.setSsdiUKWithDisab(BigInteger.valueOf(ssdiUKWithDisab));
			disabIncomeAndSourceDataBean.setSsdiUKWithOutDisab(BigInteger.valueOf(ssdiUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalssdiUK(BigInteger.valueOf(totalssdiUK));
			disabIncomeAndSourceDataBean.setSsdiUKDisabPercentage(BigDecimal.valueOf(ssdiUKDisabPercentage).toBigInteger());
			
			int vadisabilityserviceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int vadisabilityserviceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalvadisabilityserviceAO = ssdiAOWithDisab + vadisabilityserviceAOWithOutDisab;
			double vadisabilityserviceAODisabPercentage = vadisabilityserviceAOWithDisab/totalvadisabilityserviceAO ;

			disabIncomeAndSourceDataBean.setVadisabilityserviceAOWithDisab(BigInteger.valueOf(vadisabilityserviceAOWithDisab));
			disabIncomeAndSourceDataBean.setVadisabilityserviceAOWithOutDisab(BigInteger.valueOf(vadisabilityserviceAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalvadisabilityserviceAO(BigInteger.valueOf(totalvadisabilityserviceAO));
			disabIncomeAndSourceDataBean.setVadisabilityserviceAODisabPercentage(BigDecimal.valueOf(vadisabilityserviceAODisabPercentage).toBigInteger());
			
			int vadisabilityserviceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int vadisabilityserviceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalvadisabilityserviceAC = vadisabilityserviceACWithDisab + vadisabilityserviceACWithOutDisab;
			double vadisabilityserviceACDisabPercentage = vadisabilityserviceACWithDisab/totalvadisabilityserviceAC ;
			
			disabIncomeAndSourceDataBean.setVadisabilityserviceACWithDisab(BigInteger.valueOf(vadisabilityserviceACWithDisab));
			disabIncomeAndSourceDataBean.setVadisabilityserviceACWithOutDisab(BigInteger.valueOf(vadisabilityserviceACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalvadisabilityserviceAC(BigInteger.valueOf(totalvadisabilityserviceAC));
			disabIncomeAndSourceDataBean.setVadisabilityserviceACDisabPercentage(BigDecimal.valueOf(vadisabilityserviceACDisabPercentage).toBigInteger());
		
			int vadisabilityserviceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int vadisabilityserviceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalvadisabilityserviceUK = vadisabilityserviceUKWithDisab + vadisabilityserviceUKWithOutDisab;
			double vadisabilityserviceUKDisabPercentage = vadisabilityserviceUKWithDisab/totalvadisabilityserviceUK ;
			
			disabIncomeAndSourceDataBean.setVadisabilityserviceUKWithDisab(BigInteger.valueOf(vadisabilityserviceUKWithDisab));
			disabIncomeAndSourceDataBean.setVadisabilityserviceUKWithOutDisab(BigInteger.valueOf(vadisabilityserviceUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalvadisabilityserviceUK(BigInteger.valueOf(totalvadisabilityserviceUK));
			disabIncomeAndSourceDataBean.setVadisabilityserviceUKDisabPercentage(BigDecimal.valueOf(vadisabilityserviceUKDisabPercentage).toBigInteger());
		
			int privatedisabilityAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int privatedisabilityAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalprivatedisabilityAO = privatedisabilityAOWithDisab + privatedisabilityAOWithOutDisab;
			double privatedisabilityAODisabPercentage = privatedisabilityAOWithDisab/totalprivatedisabilityAO ;
			
			disabIncomeAndSourceDataBean.setPrivatedisabilityAOWithDisab(BigInteger.valueOf(privatedisabilityAOWithDisab));
			disabIncomeAndSourceDataBean.setPrivatedisabilityAOWithOutDisab(BigInteger.valueOf(privatedisabilityAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalprivatedisabilityAO(BigInteger.valueOf(totalprivatedisabilityAO));
			disabIncomeAndSourceDataBean.setPrivatedisabilityAODisabPercentage(BigDecimal.valueOf(privatedisabilityAODisabPercentage).toBigInteger());
		
			int privatedisabilityACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int privatedisabilityACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalprivatedisabilityAC = privatedisabilityACWithDisab + privatedisabilityACWithOutDisab;
			double privatedisabilityACDisabPercentage = privatedisabilityACWithDisab/totalprivatedisabilityAC ;
			
			disabIncomeAndSourceDataBean.setPrivatedisabilityACWithDisab(BigInteger.valueOf(privatedisabilityACWithDisab));
			disabIncomeAndSourceDataBean.setPrivatedisabilityACWithOutDisab(BigInteger.valueOf(privatedisabilityACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalprivatedisabilityAC(BigInteger.valueOf(totalprivatedisabilityAC));
			disabIncomeAndSourceDataBean.setPrivatedisabilityACDisabPercentage(BigDecimal.valueOf(privatedisabilityACDisabPercentage).toBigInteger());
			
			int privatedisabilityUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int privatedisabilityUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalprivatedisabilityUK = privatedisabilityUKWithDisab + privatedisabilityUKWithOutDisab;
			double privatedisabilityUKDisabPercentage = privatedisabilityUKWithDisab/totalprivatedisabilityUK ;
		
			disabIncomeAndSourceDataBean.setPrivatedisabilityUKWithDisab(BigInteger.valueOf(privatedisabilityUKWithDisab));
			disabIncomeAndSourceDataBean.setPrivatedisabilityUKWithOutDisab(BigInteger.valueOf(privatedisabilityUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalprivatedisabilityUK(BigInteger.valueOf(totalprivatedisabilityUK));
			disabIncomeAndSourceDataBean.setPrivatedisabilityUKDisabPercentage(BigDecimal.valueOf(privatedisabilityUKDisabPercentage).toBigInteger());
	
			int workerscompAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int workerscompAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalworkerscompAO = workerscompAOWithDisab + workerscompAOWithOutDisab;
			double workerscompAODisabPercentage = workerscompAOWithDisab/totalworkerscompAO ;
			
			disabIncomeAndSourceDataBean.setWorkerscompAOWithDisab(BigInteger.valueOf(workerscompAOWithDisab));
			disabIncomeAndSourceDataBean.setWorkerscompAOWithOutDisab(BigInteger.valueOf(workerscompAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalworkerscompAO(BigInteger.valueOf(totalworkerscompAO));
			disabIncomeAndSourceDataBean.setWorkerscompAODisabPercentage(BigDecimal.valueOf(workerscompAODisabPercentage).toBigInteger());
	
			int workerscompACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int workerscompACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalworkerscompAC = workerscompACWithDisab + workerscompACWithOutDisab;
			double workerscompACDisabPercentage = workerscompACWithDisab/totalworkerscompAC ;
			
			disabIncomeAndSourceDataBean.setWorkerscompACWithDisab(BigInteger.valueOf(workerscompACWithDisab));
			disabIncomeAndSourceDataBean.setWorkerscompACWithOutDisab(BigInteger.valueOf(workerscompACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalworkerscompAC(BigInteger.valueOf(totalworkerscompAC));
			disabIncomeAndSourceDataBean.setWorkerscompACDisabPercentage(BigDecimal.valueOf(workerscompACDisabPercentage).toBigInteger());
			
			int workerscompUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int workerscompUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalworkerscompUK = workerscompUKWithDisab + workerscompUKWithOutDisab;
			double workerscompUKDisabPercentage = workerscompUKWithDisab/totalworkerscompUK ;
		
			disabIncomeAndSourceDataBean.setWorkerscompUKWithDisab(BigInteger.valueOf(workerscompUKWithDisab));
			disabIncomeAndSourceDataBean.setWorkerscompUKWithOutDisab(BigInteger.valueOf(workerscompUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalworkerscompUK(BigInteger.valueOf(totalworkerscompUK));
			disabIncomeAndSourceDataBean.setWorkerscompUKDisabPercentage(BigDecimal.valueOf(workerscompUKDisabPercentage).toBigInteger());
	
			int tanfAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int tanfAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totaltanfAO = tanfAOWithDisab + tanfAOWithOutDisab;
			double tanfAODisabPercentage = tanfAOWithDisab/totaltanfAO ;
			
			disabIncomeAndSourceDataBean.setTanfAOWithDisab(BigInteger.valueOf(tanfAOWithDisab));
			disabIncomeAndSourceDataBean.setTanfAOWithOutDisab(BigInteger.valueOf(tanfAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotaltanfAO(BigInteger.valueOf(totaltanfAO));
			disabIncomeAndSourceDataBean.setTanfAODisabPercentage(BigDecimal.valueOf(tanfAODisabPercentage).toBigInteger());
	
			int tanfACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int tanfACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totaltanfAC = tanfACWithDisab + tanfACWithOutDisab;
			double tanfACDisabPercentage = tanfACWithDisab/totaltanfAC ;
			
			disabIncomeAndSourceDataBean.setTanfACWithDisab(BigInteger.valueOf(tanfACWithDisab));
			disabIncomeAndSourceDataBean.setTanfACWithOutDisab(BigInteger.valueOf(tanfACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotaltanfAC(BigInteger.valueOf(totaltanfAC));
			disabIncomeAndSourceDataBean.setTanfACDisabPercentage(BigDecimal.valueOf(tanfACDisabPercentage).toBigInteger());
			
			int tanfUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int tanfUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totaltanfUK = tanfUKWithDisab + tanfUKWithOutDisab;
			double tanfUKDisabPercentage = tanfUKWithDisab/totaltanfUK ;
		
			disabIncomeAndSourceDataBean.setTanfUKWithDisab(BigInteger.valueOf(tanfUKWithDisab));
			disabIncomeAndSourceDataBean.setTanfUKWithOutDisab(BigInteger.valueOf(tanfUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotaltanfUK(BigInteger.valueOf(totaltanfUK));
			disabIncomeAndSourceDataBean.setTanfUKDisabPercentage(BigDecimal.valueOf(tanfUKDisabPercentage).toBigInteger());
			
			int socsecretirementAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int socsecretirementAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalsocsecretirementAO = socsecretirementAOWithDisab + socsecretirementAOWithOutDisab;
			double socsecretirementAODisabPercentage = socsecretirementAOWithDisab/totalsocsecretirementAO ;
			
			disabIncomeAndSourceDataBean.setSocsecretirementAOWithDisab(BigInteger.valueOf(socsecretirementAOWithDisab));
			disabIncomeAndSourceDataBean.setSocsecretirementAOWithOutDisab(BigInteger.valueOf(socsecretirementAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalsocsecretirementAO(BigInteger.valueOf(totalsocsecretirementAO));
			disabIncomeAndSourceDataBean.setSocsecretirementAODisabPercentage(BigDecimal.valueOf(socsecretirementAODisabPercentage).toBigInteger());
			
			int socsecretirementACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int socsecretirementACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalsocsecretirementAC = socsecretirementACWithDisab + socsecretirementACWithOutDisab;
			double socsecretirementACDisabPercentage = socsecretirementACWithDisab/totalsocsecretirementAC ;
			
			disabIncomeAndSourceDataBean.setSocsecretirementACWithDisab(BigInteger.valueOf(socsecretirementACWithDisab));
			disabIncomeAndSourceDataBean.setSocsecretirementACWithOutDisab(BigInteger.valueOf(socsecretirementACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalsocsecretirementAC(BigInteger.valueOf(totalsocsecretirementAC));
			disabIncomeAndSourceDataBean.setSocsecretirementACDisabPercentage(BigDecimal.valueOf(socsecretirementACDisabPercentage).toBigInteger());
			
			int socsecretirementUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int socsecretirementUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalsocsecretirementUK = socsecretirementUKWithDisab + socsecretirementUKWithOutDisab;
			double socsecretirementUKDisabPercentage = socsecretirementUKWithDisab/totalsocsecretirementUK ;
		
			disabIncomeAndSourceDataBean.setSocsecretirementUKWithDisab(BigInteger.valueOf(socsecretirementUKWithDisab));
			disabIncomeAndSourceDataBean.setSocsecretirementUKWithOutDisab(BigInteger.valueOf(socsecretirementUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalsocsecretirementUK(BigInteger.valueOf(totalsocsecretirementUK));
			disabIncomeAndSourceDataBean.setSocsecretirementUKDisabPercentage(BigDecimal.valueOf(socsecretirementUKDisabPercentage).toBigInteger());
		
			int pensionAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int pensionAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalpensionAO = pensionAOWithDisab + pensionAOWithOutDisab;
			double pensionAODisabPercentage = pensionAOWithDisab/totalpensionAO ;
			
			disabIncomeAndSourceDataBean.setPensionAOWithDisab(BigInteger.valueOf(pensionAOWithDisab));
			disabIncomeAndSourceDataBean.setPensionAOWithOutDisab(BigInteger.valueOf(pensionAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalpensionAO(BigInteger.valueOf(totalpensionAO));
			disabIncomeAndSourceDataBean.setPensionAODisabPercentage(BigDecimal.valueOf(pensionAODisabPercentage).toBigInteger());
			
			int pensionACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int pensionACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalpensionAC = pensionACWithDisab + pensionACWithOutDisab;
			double pensionACDisabPercentage = pensionACWithDisab/totalpensionAC ;
			
			disabIncomeAndSourceDataBean.setPensionACWithDisab(BigInteger.valueOf(pensionACWithDisab));
			disabIncomeAndSourceDataBean.setPensionACWithOutDisab(BigInteger.valueOf(pensionACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalpensionAC(BigInteger.valueOf(totalpensionAC));
			disabIncomeAndSourceDataBean.setPensionACDisabPercentage(BigDecimal.valueOf(pensionACDisabPercentage).toBigInteger());
			
			int pensionUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int pensionUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalpensionUK = pensionUKWithDisab + pensionUKWithOutDisab;
			double pensionUKDisabPercentage = pensionUKWithDisab/totalpensionUK ;
		

			disabIncomeAndSourceDataBean.setPensionUKWithDisab(BigInteger.valueOf(pensionUKWithDisab));
			disabIncomeAndSourceDataBean.setPensionUKWithOutDisab(BigInteger.valueOf(pensionUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalpensionUK(BigInteger.valueOf(totalpensionUK));
			disabIncomeAndSourceDataBean.setPensionUKDisabPercentage(BigDecimal.valueOf(pensionUKDisabPercentage).toBigInteger());
		
			int childsupportAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int childsupportAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalchildsupportAO = childsupportAOWithDisab + childsupportAOWithOutDisab;
			double childsupportAODisabPercentage = childsupportAOWithDisab/totalchildsupportAO ;
			
				
			disabIncomeAndSourceDataBean.setChildsupportAOWithDisab(BigInteger.valueOf(childsupportAOWithDisab));
			disabIncomeAndSourceDataBean.setChildsupportAOWithOutDisab(BigInteger.valueOf(childsupportAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalchildsupportAO(BigInteger.valueOf(totalchildsupportAO));
			disabIncomeAndSourceDataBean.setChildsupportAODisabPercentage(BigDecimal.valueOf(childsupportAODisabPercentage).toBigInteger());
			
			int childsupportACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int childsupportACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalchildsupportAC = childsupportACWithDisab + childsupportACWithOutDisab;
			double childsupportACDisabPercentage = childsupportACWithDisab/totalchildsupportAC ;
			
			disabIncomeAndSourceDataBean.setChildsupportACWithDisab(BigInteger.valueOf(childsupportACWithDisab));
			disabIncomeAndSourceDataBean.setChildsupportACWithOutDisab(BigInteger.valueOf(childsupportACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalchildsupportAC(BigInteger.valueOf(totalchildsupportAC));
			disabIncomeAndSourceDataBean.setChildsupportACDisabPercentage(BigDecimal.valueOf(childsupportACDisabPercentage).toBigInteger());
			
			int childsupportUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int childsupportUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalchildsupportUK = childsupportUKWithDisab + childsupportUKWithOutDisab;
			double childsupportUKDisabPercentage = childsupportUKWithDisab/totalchildsupportUK ;
		
					
			disabIncomeAndSourceDataBean.setChildsupportUKWithDisab(BigInteger.valueOf(childsupportUKWithDisab));
			disabIncomeAndSourceDataBean.setChildsupportUKWithOutDisab(BigInteger.valueOf(childsupportUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalchildsupportUK(BigInteger.valueOf(totalchildsupportUK));
			disabIncomeAndSourceDataBean.setChildsupportUKDisabPercentage(BigDecimal.valueOf(childsupportUKDisabPercentage).toBigInteger());
			
			int othersourceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int othersourceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalothersourceAO = othersourceAOWithDisab + othersourceAOWithOutDisab;
			double othersourceAODisabPercentage = othersourceAOWithDisab/totalothersourceAO ;
			
			disabIncomeAndSourceDataBean.setOthersourceAOWithDisab(BigInteger.valueOf(othersourceAOWithDisab));
			disabIncomeAndSourceDataBean.setOthersourceAOWithOutDisab(BigInteger.valueOf(othersourceAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalothersourceAO(BigInteger.valueOf(totalothersourceAO));
			disabIncomeAndSourceDataBean.setOthersourceAODisabPercentage(BigDecimal.valueOf(othersourceAODisabPercentage).toBigInteger());
		
			int othersourceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int othersourceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalothersourceAC = othersourceACWithDisab + othersourceACWithOutDisab;
			double othersourceACDisabPercentage = othersourceACWithDisab/totalothersourceAC ;
			
			disabIncomeAndSourceDataBean.setOthersourceACWithDisab(BigInteger.valueOf(othersourceACWithDisab));
			disabIncomeAndSourceDataBean.setOthersourceACWithOutDisab(BigInteger.valueOf(othersourceACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalothersourceAC(BigInteger.valueOf(totalothersourceAC));
			disabIncomeAndSourceDataBean.setOthersourceACDisabPercentage(BigDecimal.valueOf(othersourceACDisabPercentage).toBigInteger());
		
			int othersourceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int othersourceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalothersourceUK = othersourceUKWithDisab + othersourceUKWithOutDisab;
			double othersourceUKDisabPercentage = othersourceUKWithDisab/totalothersourceUK ;
		
			disabIncomeAndSourceDataBean.setOthersourceUKWithDisab(BigInteger.valueOf(othersourceUKWithDisab));
			disabIncomeAndSourceDataBean.setOthersourceUKWithOutDisab(BigInteger.valueOf(othersourceUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalothersourceUK(BigInteger.valueOf(totalothersourceUK));
			disabIncomeAndSourceDataBean.setOthersourceUKDisabPercentage(BigDecimal.valueOf(othersourceUKDisabPercentage).toBigInteger());
		
			int noSourceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int noSourceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalnoSourceAO = noSourceAOWithDisab + noSourceAOWithOutDisab;
			double noSourceAODisabPercentage = noSourceAOWithDisab/totalnoSourceAO ;
			
			disabIncomeAndSourceDataBean.setNoSourceAOWithDisab(BigInteger.valueOf(noSourceAOWithDisab));
			disabIncomeAndSourceDataBean.setNoSourceAOWithOutDisab(BigInteger.valueOf(noSourceAOWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalnoSourceAO(BigInteger.valueOf(totalnoSourceAO));
			disabIncomeAndSourceDataBean.setNoSourceAODisabPercentage(BigDecimal.valueOf(noSourceAODisabPercentage).toBigInteger());
		
			int noSourceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int noSourceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalnoSourceAC = noSourceACWithDisab + noSourceACWithOutDisab;
			double noSourceACDisabPercentage = noSourceACWithDisab/totalnoSourceAC ;
			
			disabIncomeAndSourceDataBean.setNoSourceACWithDisab(BigInteger.valueOf(noSourceACWithDisab));
			disabIncomeAndSourceDataBean.setNoSourceACWithOutDisab(BigInteger.valueOf(noSourceACWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalnoSourceAC(BigInteger.valueOf(totalnoSourceAC));
			disabIncomeAndSourceDataBean.setNoSourceACDisabPercentage(BigDecimal.valueOf(noSourceACDisabPercentage).toBigInteger());

			int noSourceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int noSourceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalnoSourceUK = noSourceUKWithDisab + noSourceUKWithOutDisab;
			double noSourceUKDisabPercentage = noSourceUKWithDisab/totalnoSourceUK ;
			
			disabIncomeAndSourceDataBean.setNoSourceUKWithDisab(BigInteger.valueOf(noSourceUKWithDisab));
			disabIncomeAndSourceDataBean.setNoSourceUKWithOutDisab(BigInteger.valueOf(noSourceUKWithOutDisab));
			disabIncomeAndSourceDataBean.setTotalnoSourceUK(BigInteger.valueOf(totalnoSourceUK));
			disabIncomeAndSourceDataBean.setNoSourceUKDisabPercentage(BigDecimal.valueOf(noSourceUKDisabPercentage).toBigInteger());

			//AO
			int overallTotalAODisab =  earnedAOWithDisab+ssiAOWithDisab+ssdiAOWithDisab+vadisabilityserviceAOWithDisab
					 +privatedisabilityAOWithDisab+workerscompAOWithDisab+tanfAOWithDisab+socsecretirementAOWithDisab
					 +pensionAOWithDisab+childsupportAOWithDisab+othersourceAOWithDisab+noSourceAOWithDisab;
			int overallTotalAOWithOutDisab =earnedAOWithOutDisab+ssiAOWithOutDisab+ssdiAOWithOutDisab
					+vadisabilityserviceAOWithOutDisab+privatedisabilityAOWithOutDisab+workerscompAOWithOutDisab
					+tanfAOWithOutDisab+socsecretirementAOWithOutDisab+pensionAOWithOutDisab+childsupportAOWithOutDisab
					+othersourceAOWithOutDisab+noSourceAOWithOutDisab;
					
					int overallTotalAOEarned = totalAOEarned+totalssiAO+totalssdiAO+totalvadisabilityserviceAO
					+totalprivatedisabilityAO+totalworkerscompAO+totaltanfAO+totalsocsecretirementAO+totalpensionAO
					+totalchildsupportAO+totalothersourceAO+totalnoSourceAO;	
					
					disabIncomeAndSourceDataBean.setTotalAOWithDisab(BigInteger.valueOf(overallTotalAODisab));
					disabIncomeAndSourceDataBean.setTotalAOWithOutDisab(BigInteger.valueOf(overallTotalAOWithOutDisab));
					disabIncomeAndSourceDataBean.setTotalAO(BigInteger.valueOf(overallTotalAOEarned));
			// AC	
					
					int overallTotalACDisab= earnedACWithDisab+ssiACWithDisab+ssdiACWithDisab+vadisabilityserviceACWithDisab
					+privatedisabilityACWithDisab+workerscompACWithDisab+tanfACWithDisab+socsecretirementACWithDisab
					+pensionACWithDisab+childsupportACWithDisab+othersourceACWithDisab+noSourceACWithDisab;
					
					int overallTotalACWithOutDisab =earnedACWithOutDisab+ssiACWithOutDisab+ssdiACWithOutDisab+vadisabilityserviceACWithOutDisab
					+privatedisabilityACWithOutDisab+workerscompACWithOutDisab+tanfACWithOutDisab+socsecretirementACWithOutDisab
					+pensionACWithOutDisab+childsupportACWithOutDisab+othersourceACWithOutDisab+noSourceACWithOutDisab;
					
					int overallTotalACEarned = totalACEarned+totalssiAC+totalssdiAC+totalvadisabilityserviceAC
					+totalprivatedisabilityAC+totalworkerscompAC+totaltanfAC+totalsocsecretirementAC
					+totalpensionAC+totalchildsupportAC+totalothersourceAC+totalnoSourceAC;
					
					disabIncomeAndSourceDataBean.setTotalACWithDisab(BigInteger.valueOf(overallTotalACDisab));
					disabIncomeAndSourceDataBean.setTotalACWithOutDisab(BigInteger.valueOf(overallTotalACWithOutDisab));
					disabIncomeAndSourceDataBean.setTotalAC(BigInteger.valueOf(overallTotalACEarned));
		
					
					//UK
					int overallTotalUKDisab= earnedUKWithDisab+ssiUKWithDisab+ssdiUKWithDisab+vadisabilityserviceUKWithDisab
					+privatedisabilityUKWithDisab+workerscompUKWithDisab+tanfUKWithDisab+socsecretirementUKWithDisab
					+pensionUKWithDisab+childsupportUKWithDisab+othersourceUKWithDisab+noSourceUKWithDisab;
					
					int overallTotalUKWithOutDisab =earnedUKWithOutDisab+ssiUKWithOutDisab+ssdiUKWithOutDisab+vadisabilityserviceUKWithOutDisab
					+privatedisabilityUKWithOutDisab+workerscompUKWithOutDisab+tanfUKWithOutDisab+socsecretirementUKWithOutDisab
					+pensionUKWithOutDisab+childsupportUKWithOutDisab+noSourceUKWithOutDisab+othersourceUKWithOutDisab;
					
					int overallTotalUKEarned = totalUKEarned+totalssiUK+totalssdiUK+totalvadisabilityserviceUK
					+totalprivatedisabilityUK+totalworkerscompUK+totaltanfUK+totalsocsecretirementUK
					+totalpensionUK+totalchildsupportUK+totalothersourceUK+totalnoSourceUK;

					disabIncomeAndSourceDataBean.setTotalUKWithDisab(BigInteger.valueOf(overallTotalUKDisab));
					disabIncomeAndSourceDataBean.setTotalUKWithOutDisab(BigInteger.valueOf(overallTotalUKWithOutDisab));
					disabIncomeAndSourceDataBean.setTotalUK(BigInteger.valueOf(overallTotalUKEarned));
		
		} catch (Exception e) {
			logger.error("Error in Q19bBeanMaker:" + e);
		}
			}
			return Arrays.asList(disabIncomeAndSourceDataBean);
		}
		
		public static List<String> getClients(String schema,String query,ReportData data) {
			ResultSet resultSet = null;
			List<String> enrollments = new ArrayList<>();
			Statement statement = null;
			Connection connection = null;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(query,schema,data));
				
			 while(resultSet.next()) {
				 enrollments.add(resultSet.getString(1));
		     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
						//connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return enrollments;
		}
		
		
		public static int getIncomeCntByHouseHoldType(String schema,String query,HouseHoldType houseHoldType,ReportData data) {
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			int count =0;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				resultSet = statement.executeQuery(formatQuery(joinEnrollmentIds(query, data, houseHoldType),schema,data));
			 while(resultSet.next()) {
				 count = resultSet.getInt(1);
		     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
						//connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return count;
		}
		
		 protected static String joinEnrollmentIds(String query,ReportData data, HouseHoldType houseHoldType) {
			 StringBuilder builder = new StringBuilder();
			 
				List<EnrollmentModel> enrollments = null;
				if(HouseHoldType.AO == houseHoldType) {
					enrollments = data.getAdultsWithOutChildren();
				} else if(HouseHoldType.AC == houseHoldType) {
					enrollments = data.getAdultWithChildren();
				} else if (HouseHoldType.UK == houseHoldType) {
					enrollments = data.getAdultsUnknownHHType();
				}
				 if(CollectionUtils.isNotEmpty(enrollments)) {
					 builder.append(" and e.id in  ( ");
					 int count = 0;
					 for(EnrollmentModel enrollment : enrollments) {
						 builder.append("'"+enrollment.getProjectEntryID()+"'");
						 if(count != enrollments.size()) {
							 builder.append(",");
						 }
					 }
					 builder.deleteCharAt(builder.length() -1);
					 builder.append(" ) ");
				 }
				String newQuery = query + builder.toString();
				return newQuery;
		 }
		
		public static int getIncomeCntForAnnualAssesment(String schema,String query,String datacollectionStage,ReportData data) {
			ResultSet resultSet = null;
			Statement statement = null;
			Connection connection = null;
			int count =0;
			try {
				connection = ImpalaConnection.getConnection();
				statement = connection.createStatement();
				data.setQueryDataCollectionStage(datacollectionStage);
				resultSet = statement.executeQuery(formatQuery(query,schema,data));
				List<ClientModel> clients = data.getVeterans();
				if(CollectionUtils.isEmpty(clients)) {
					return count;
				}
				 if(CollectionUtils.isNotEmpty(clients)) {
					 StringBuilder enrollmentBuilder = new StringBuilder(" and e.dedup_client_id in  ( ");
					 int index = 0;
					 for(ClientModel client : clients) {
						 enrollmentBuilder.append("'"+client.getDedupClientId()+"'");
						 if(index != clients.size()) {
							 enrollmentBuilder.append(",");
						 }
					 }
					 enrollmentBuilder.deleteCharAt(enrollmentBuilder.length() -1);
					 enrollmentBuilder.append(" ) ");
					 query = query + enrollmentBuilder.toString();
				 }
			 while(resultSet.next()) {
				 count = resultSet.getInt(1);
		     }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
						//connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			return count;
		}
}
