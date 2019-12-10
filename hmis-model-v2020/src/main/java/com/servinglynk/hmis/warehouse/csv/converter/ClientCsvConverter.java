package com.servinglynk.hmis.warehouse.csv.converter;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Client;
import com.servinglynk.hmis.warehouse.enums.ClientRaceEnum;
import com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo;

@Component
public class ClientCsvConverter extends BaseCsvConverter {

	public Client entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Client entity) {
		 Client model = new Client();
	     

		 if(entity.getDob()!=null)
				model.setDob(Date.from(entity.getDob().atZone(ZoneId.systemDefault()).toInstant()).toString());
			    if(entity.getDobDataQuality()!=null)
				model.setDobDataQuality(entity.getDobDataQuality().getValue());
			    if(entity.getEthnicity()!=null)
				model.setEthnicity(entity.getEthnicity().getValue());
			    if(entity.getFirstName()!=null)
				model.setFirstName(entity.getFirstName());
			    if(entity.getGender()!=null)
				model.setGender(entity.getGender().getValue());
			    if(entity.getLastName()!=null)
				model.setLastName(entity.getLastName());
			    if(entity.getMiddleName()!=null)
				model.setMiddleName(entity.getMiddleName());
			    if(entity.getNameDataQuality()!=null)
				model.setNameDataQuality(entity.getNameDataQuality().getValue());
			    if(entity.getNameSuffix()!=null)
				model.setNameSuffix(entity.getNameSuffix());
			    
			    ClientRaceEnum race = entity.getRace();
			    if(race != null) {
					   if(StringUtils.equals(race.getValue(), "1")) {
		    			   model.setAmIndAKNative("1");
		    		   }else if (StringUtils.equals(race.getValue(), "2")) {
		    			   model.setAsian("1");
		    		   }else if (StringUtils.equals(race.getValue(), "3")) {
		    			   model.setBlackAfAmerican("1");
		    		   }else if (StringUtils.equals(race.getValue(), "4")) {
		    			   model.setNativeHIOtherPacific("1");
		    		   }else if (StringUtils.equals(race.getValue(), "5")) {
		    			   model.setWhite("1");
			      }
			    }
			    
			    if(entity.getRace()!=null)
			    	model.setRaceNone(entity.getRace().getValue());
			    if(entity.getSsn()!=null)
				model.setSsn(entity.getSsn());
			    if(entity.getSsnDataQuality()!=null)
				model.setSsnDataQuality(entity.getSsnDataQuality().getValue());
			    if(entity.getId()!=null)
				model.setPersonalID(getId(entity.getId()));
			    if(entity.getVeteranStatus()!=null)
				model.setVeteranStatus(entity.getVeteranStatus().getValue());
			    
			    
	     if(entity.getUserId() !=null)
			model.setUserID(entity.getUserId().toString());
		model.setDateCreated(entity.getDateCreated().toString());
		model.setDateUpdated(entity.getDateUpdated().toString());
		if(entity.getExport() != null)
			model.setExportID(entity.getExport().getSourceSystemId());
		
		//model.setPITCount(entity.);
		return model;
	}
	
	/***
	 * Convert all the PathStatus into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Client> veteranInfoToCsv(com.servinglynk.hmis.warehouse.model.v2020.Client entity,Set<ClientVeteranInfo> clientVeteranInfos) {
		List<Client>  clients = new ArrayList<Client>();
		if(CollectionUtils.isNotEmpty(clientVeteranInfos)) {
			for(ClientVeteranInfo childEntity : clientVeteranInfos) {
				Client model = entityToCsv(entity);
				 	   if(childEntity.getYearEntrdService()!=null)
				       model.setYearEnteredService(String.valueOf(childEntity.getYearEntrdService()));
					   if(childEntity.getYearSeperated()!=null)
				       model.setYearSeparated(String.valueOf(childEntity.getYearSeperated()));
					   if(childEntity.getWorldWar2()!=null)
				       model.setWorldWarII(childEntity.getWorldWar2().getValue());
					   if(childEntity.getKoreanWar()!=null)
				       model.setKoreanWar(childEntity.getKoreanWar().getValue());
					   if(childEntity.getVietnamWar()!=null)
				       model.setVietnamWar(childEntity.getVietnamWar().getValue());
					   if(childEntity.getDesertStorm()!=null)
				       model.setDesertStorm(childEntity.getDesertStorm().getValue());
					   if(childEntity.getAfghanistanOef()!=null)
				       model.setAfghanistanOEF(childEntity.getAfghanistanOef().getValue());
					   if(childEntity.getIraqOif()!=null)
				       model.setIraqOIF(childEntity.getIraqOif().getValue());
					   if(childEntity.getIraqOnd()!=null)
				       model.setIraqOND(childEntity.getIraqOnd().getValue());
					   if(childEntity.getOtherTheater()!=null)
				       model.setOtherTheater(childEntity.getOtherTheater().getValue());
					   if(childEntity.getMilitaryBranch()!=null)
				       model.setMilitaryBranch(childEntity.getMilitaryBranch().getValue());
					   if(childEntity.getDischargeStatus()!=null)
				       model.setDischargeStatus(childEntity.getDischargeStatus().getValue());
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				clients.add(model);
			}
		}
		return clients;
	}	
	
	public void writeToCSV(com.servinglynk.hmis.warehouse.model.v2020.Client client,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Client());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
				baseCSVs.add(entityToCsv(client));
				Set<ClientVeteranInfo> veteranInfoes = client.getVeteranInfoes();
				baseCSVs.addAll(veteranInfoToCsv(client, veteranInfoes));
				CsvFileWriter.writeToCsv("childEntity.csv",baseCSVs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}
	
}
