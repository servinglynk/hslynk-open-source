package com.servinglynk.report.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.servinglynk.hive.connection.ImpalaConnection;
import com.servinglynk.report.bean.ReportData;
import com.servinglynk.report.model.ClientModel;
import com.servinglynk.report.model.EnrollmentModel;
import com.servinglynk.report.model.HouseHoldType;

public class Q27iBeanMaker extends BaseBeanMaker {
	
	public static List<Q27iDataBean> getQ27iYouthList(ReportData data){
		
		Q27iDataBean q25gDataBean = new Q27iDataBean();
		
		if(data.isLiveMode()) {
			try{
			
			String exitQuery = " select count(e.dedup_client_id) as cnt  from %s.incomeandsources i, %s.enrollment e ,%s.client c,%s.exit ext where  e.client_id = c.id and   e.id=i.enrollmentid  and   e.id=ext.enrollmentid "+ 
					" and TO_DATE(i.information_date) = TO_DATE(ext.exitdate)  and i.information_date <= :endDate  and i.datacollectionstage='3' and e.ageatentry >= 18  and e.ageatentry <= 25 and i.incomefromanysource is not null and i.incomefromanysource not in ('8','9','99) and e.disablingcondition is not null and e.disablingcondition not in ('8','9','99)  ";
	
			int earnedAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.AO, data);
			int earnedAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalAOEarned = earnedAOWithDisab + earnedAOWithOutDisab;
			double earnedAODisabPercentage = earnedAOWithDisab/totalAOEarned ;
			
			int earnedACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.AC, data);
			int earnedACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalACEarned = earnedACWithDisab + earnedACWithOutDisab;
			double earnedACDisabPercentage = earnedACWithDisab/totalACEarned ;
			
			int earnedUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='1' ", HouseHoldType.UK, data);
			int earnedUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +" and  earned ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalUKEarned = earnedUKWithDisab + earnedUKWithOutDisab;
			double earnedUKDisabPercentage = earnedUKWithDisab/totalUKEarned ;
		

			int ssiAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int ssiAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalssiAO = ssiAOWithDisab + ssiAOWithDisab;
			double ssiAODisabPercentage = ssiAOWithDisab/ssiAOWithDisab ;
			
			int ssiACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.AC ,data);
			int ssiACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalssiAC = ssiACWithDisab + ssiACWithDisab;
			double ssiACDisabPercentage = ssiACWithDisab/totalssiAC ;
			
			int ssiUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int ssiUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssi ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalssiUK = ssiUKWithDisab + ssiUKWithOutDisab;
			double ssiUKDisabPercentage = ssiUKWithDisab/totalssiUK ;
			
			
			int ssdiAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int ssdiAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalssdiAO = ssdiAOWithDisab + ssdiAOWithOutDisab;
			double ssdiAODisabPercentage = ssdiAOWithDisab/totalssdiAO ;
			
			int ssdiACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int ssdiACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalssdiAC = ssdiACWithDisab + ssdiACWithOutDisab;
			double ssdiACDisabPercentage = ssdiACWithDisab/totalssdiAC ;
			
			int ssdiUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int ssdiUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and ssdi ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalssdiUK = ssdiACWithDisab + ssdiACWithOutDisab;
			double ssdiUKDisabPercentage = ssdiUKWithDisab/totalssdiUK ;
			
			
			int vadisabilityserviceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int vadisabilityserviceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalvadisabilityserviceAO = ssdiAOWithDisab + ssdiAOWithOutDisab;
			double vadisabilityserviceAODisabPercentage = vadisabilityserviceAOWithDisab/totalvadisabilityserviceAO ;

			int vadisabilityserviceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int vadisabilityserviceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalvadisabilityserviceAC = vadisabilityserviceACWithDisab + vadisabilityserviceACWithOutDisab;
			double vadisabilityserviceACDisabPercentage = vadisabilityserviceACWithDisab/totalvadisabilityserviceAC ;
			
			int vadisabilityserviceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int vadisabilityserviceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and vadisabilityservice ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalvadisabilityserviceUK = vadisabilityserviceACWithDisab + vadisabilityserviceACWithOutDisab;
			double vadisabilityserviceUKDisabPercentage = vadisabilityserviceUKWithDisab/totalvadisabilityserviceUK ;
			
		
			int privatedisabilityAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int privatedisabilityAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalprivatedisabilityAO = privatedisabilityAOWithDisab + privatedisabilityAOWithOutDisab;
			double privatedisabilityAODisabPercentage = privatedisabilityAOWithDisab/totalprivatedisabilityAO ;
			
			int privatedisabilityACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int privatedisabilityACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalprivatedisabilityAC = privatedisabilityACWithDisab + privatedisabilityACWithOutDisab;
			double privatedisabilityACDisabPercentage = privatedisabilityACWithDisab/totalprivatedisabilityAC ;
			
			int privatedisabilityUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int privatedisabilityUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and privatedisability ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalprivatedisabilityUK = privatedisabilityACWithDisab + privatedisabilityACWithOutDisab;
			double privatedisabilityUKDisabPercentage = privatedisabilityUKWithDisab/totalprivatedisabilityUK ;
		
			int workerscompAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int workerscompAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalworkerscompAO = workerscompAOWithDisab + workerscompAOWithOutDisab;
			double workerscompAODisabPercentage = workerscompAOWithDisab/totalworkerscompAO ;
			
			int workerscompACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int workerscompACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalworkerscompAC = workerscompACWithDisab + workerscompACWithOutDisab;
			double workerscompACDisabPercentage = workerscompACWithDisab/totalworkerscompAC ;
			
			int workerscompUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int workerscompUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and workerscomp ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalworkerscompUK = workerscompACWithDisab + workerscompACWithOutDisab;
			double workerscompUKDisabPercentage = workerscompUKWithDisab/totalworkerscompUK ;
		
			int tanfAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int tanfAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totaltanfAO = tanfAOWithDisab + tanfAOWithOutDisab;
			double tanfAODisabPercentage = tanfAOWithDisab/totaltanfAO ;
			
			int tanfACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int tanfACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totaltanfAC = tanfACWithDisab + tanfACWithOutDisab;
			double tanfACDisabPercentage = tanfACWithDisab/totaltanfAC ;
			
			int tanfUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int tanfUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and tanf ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totaltanfUK = tanfACWithDisab + tanfACWithOutDisab;
			double tanfUKDisabPercentage = tanfUKWithDisab/totaltanfUK ;
		
			int socsecretirementAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int socsecretirementAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalsocsecretirementAO = socsecretirementAOWithDisab + socsecretirementAOWithOutDisab;
			double socsecretirementAODisabPercentage = socsecretirementAOWithDisab/totalsocsecretirementAO ;
			
			int socsecretirementACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int socsecretirementACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalsocsecretirementAC = socsecretirementACWithDisab + socsecretirementACWithOutDisab;
			double socsecretirementACDisabPercentage = socsecretirementACWithDisab/totalsocsecretirementAC ;
			
			int socsecretirementUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int socsecretirementUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and socsecretirement ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalsocsecretirementUK = socsecretirementACWithDisab + socsecretirementACWithOutDisab;
			double socsecretirementUKDisabPercentage = socsecretirementUKWithDisab/totalsocsecretirementUK ;
		
			
			int pensionAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int pensionAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalpensionAO = pensionAOWithDisab + pensionAOWithOutDisab;
			double pensionAODisabPercentage = pensionAOWithDisab/totalpensionAO ;
			
			int pensionACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int pensionACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalpensionAC = pensionACWithDisab + pensionACWithOutDisab;
			double pensionACDisabPercentage = pensionACWithDisab/totalpensionAC ;
			
			int pensionUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int pensionUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and pension ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalpensionUK = pensionACWithDisab + pensionACWithOutDisab;
			double pensionUKDisabPercentage = pensionUKWithDisab/totalpensionUK ;
		
			
			int childsupportAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int childsupportAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalchildsupportAO = childsupportAOWithDisab + childsupportAOWithOutDisab;
			double childsupportAODisabPercentage = childsupportAOWithDisab/totalchildsupportAO ;
			
			int childsupportACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int childsupportACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalchildsupportAC = childsupportACWithDisab + childsupportACWithOutDisab;
			double childsupportACDisabPercentage = childsupportACWithDisab/totalchildsupportAC ;
			
			int childsupportUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int childsupportUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and childsupport ='1' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalchildsupportUK = childsupportACWithDisab + childsupportACWithOutDisab;
			double childsupportUKDisabPercentage = childsupportUKWithDisab/totalchildsupportUK ;
		
			
			int othersourceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int othersourceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalothersourceAO = othersourceAOWithDisab + othersourceAOWithOutDisab;
			double othersourceAODisabPercentage = othersourceAOWithDisab/totalothersourceAO ;
			
			int othersourceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int othersourceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalothersourceAC = othersourceACWithDisab + othersourceACWithOutDisab;
			double othersourceACDisabPercentage = othersourceACWithDisab/totalothersourceAC ;
			
			int othersourceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int othersourceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and  ( othersource ='1' or alimony ='1' or unemployment ='1' or vadisabilitynonservice='1' or ga='1' ) and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalothersourceUK = othersourceACWithDisab + othersourceACWithOutDisab;
			double othersourceUKDisabPercentage = othersourceUKWithDisab/totalothersourceUK ;
		
			
			int noSourceAOWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.AO,data);
			int noSourceAOWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.AO,data);
			int totalnoSourceAO = noSourceAOWithDisab + noSourceAOWithOutDisab;
			double noSourceAODisabPercentage = noSourceAOWithDisab/totalnoSourceAO ;
			
			int noSourceACWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.AC,data);
			int noSourceACWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.AC,data);
			int totalnoSourceAC = noSourceACWithDisab + noSourceACWithOutDisab;
			double noSourceACDisabPercentage = noSourceACWithDisab/totalnoSourceAC ;
			
			int noSourceUKWithDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='1' ", HouseHoldType.UK,data);
			int noSourceUKWithOutDisab = getIncomeCntByHouseHoldType(data.getSchema(), exitQuery +"  and incomefromanysource ='0' and e.disablingcondition ='0' ", HouseHoldType.UK,data);
			int totalnoSourceUK = noSourceACWithDisab + noSourceACWithOutDisab;
			double noSourceUKDisabPercentage = noSourceUKWithDisab/totalnoSourceUK ;
			

		} catch (Exception e) {
			logger.error("Error in Q17BeanMaker:" + e);
		}
			}
			return Arrays.asList(q25gDataBean);
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
			 StringBuilder builder = new StringBuilder(" and e.id in  ( ");
			 
				List<EnrollmentModel> enrollments = null;
				if(HouseHoldType.AO == houseHoldType) {
					enrollments = data.getAdultsWithOutChildren();
				} else if(HouseHoldType.AC == houseHoldType) {
					enrollments = data.getAdultWithChildren();
				} else if (HouseHoldType.UK == houseHoldType) {
					enrollments = data.getAdultsUnknownHHType();
				}
				 if(CollectionUtils.isNotEmpty(enrollments)) {
					 int count = 0;
					 for(EnrollmentModel enrollment : enrollments) {
						 builder.append("'"+enrollment.getProjectEntryID()+"'");
						 if(count != enrollments.size()) {
							 builder.append(",");
						 }
					 }
				 }
				 builder.deleteCharAt(builder.length() -1);
				 builder.append(" ) ");
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
