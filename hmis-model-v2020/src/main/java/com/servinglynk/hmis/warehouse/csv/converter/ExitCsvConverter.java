package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Exit;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2020.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2020.RHYAfterCare;
import com.servinglynk.hmis.warehouse.model.v2020.VashExitReason;

@Component
public class ExitCsvConverter extends BaseCsvConverter {

	public Exit entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Exit entity) {
		 Exit model = new Exit();
		  if(entity.getDestination() != null)
		  model.setDestination(entity.getDestination().getValue());
		  
	   	  model.setExitDate(getDate(entity.getExitdate()));
	   	  model.setExitID(getId(entity.getId()));
	   	  model.setOtherDestination(entity.getOtherdestination());
	 
	   	 Enrollment enrollmentid = entity.getEnrollmentid();
	     if(enrollmentid != null) {
	  	   model.setEnrollmentID(getId(enrollmentid.getId()));
	  	   Client client = enrollmentid.getClient();
	  	   if(client != null)
	  		   model.setPersonalID(getId(client.getId()));
	     }
	     
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
	 * Convert all the Entryrhssps into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Exit> exithousingassessmentsToCsv(com.servinglynk.hmis.warehouse.model.v2020.Exit entity,Set<Exithousingassessment> exithousingassessments) {
		List<Exit>  exits = new ArrayList<Exit>();
		if(CollectionUtils.isNotEmpty(exithousingassessments)) {
			for(Exithousingassessment childEntity : exithousingassessments) {
				Exit model = entityToCsv(entity);
				
				if(childEntity.getHousingassessment()!=null)
				       model.setHousingAssessment(childEntity.getHousingassessment().getValue());
				if(childEntity.getSubsidyinformation()  != null)
				       model.setSubsidyInformation(childEntity.getSubsidyinformation().getValue());
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				exits.add(model);
			}
		}
		return exits;
	}
	
	
	/***
	 * Convert all the exitrhies into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Exit> exitrhiesToCsv(com.servinglynk.hmis.warehouse.model.v2020.Exit entity,Set<Exitrhy> exitrhies) {
		List<Exit>  exits = new ArrayList<Exit>();
		if(CollectionUtils.isNotEmpty(exitrhies)) {
			for(Exitrhy childEntity : exitrhies) {
				Exit model = entityToCsv(entity);
				
				 model.setExitID(getId(entity.getId()));
				 
			       if(childEntity.getProjectCompletionStatus()!=null)
			       model.setProjectCompletionStatus(childEntity.getProjectCompletionStatus().getValue());
			       if(childEntity.getEarlyExitReason()!=null)
			       model.setEarlyExitReason(childEntity.getEarlyExitReason().getValue());
			       if(childEntity.getExchangeForSex() !=null)
			    	   model.setExchangeForSex(childEntity.getExchangeForSex().getValue());
			       if(childEntity.getExchangeForSexPastThreeMonths() != null)
			    	   model.setExchangeForSexPastThreeMonths(childEntity.getExchangeForSexPastThreeMonths().getValue());
			       if(childEntity.getCountOfExchangeForSex() !=null)
			    	   model.setCountOfExchangeForSex(childEntity.getCountOfExchangeForSex().getValue());
			       if(childEntity.getAskedOrForcedToExchangeForSex() !=null)
			    	   model.setAskedOrForcedToExchangeForSex(childEntity.getAskedOrForcedToExchangeForSex().getValue());
			       if(childEntity.getAskedOrForcedToExchangeForSexPastThreeMonths() !=null)
			    	   model.setAskedOrForcedToExchangeForSexPastThreeMonths(childEntity.getAskedOrForcedToExchangeForSexPastThreeMonths().getValue());
			       if(childEntity.getWorkPlacePromiseDifference() !=null)
			    	   model.setWorkplacePromiseDifference(childEntity.getWorkPlacePromiseDifference().getValue());
			       if(childEntity.getWorkPlaceViolenceThreats() !=null)
			    	   model.setWorkplaceViolenceThreats(childEntity.getWorkPlaceViolenceThreats().getValue());
			       if(childEntity.getCoercedToContinueWork() !=null)
			    	   model.setCoercedToContinueWork(childEntity.getCoercedToContinueWork().getValue());
			       if(childEntity.getLaborExploitPastThreeMonths() !=null)
			    	   model.setLaborExploitPastThreeMonths(childEntity.getLaborExploitPastThreeMonths().getValue());
			       if(childEntity.getCounselingReceived() !=null)
			    	   model.setCounselingReceived(childEntity.getCounselingReceived().getValue());
			       if(childEntity.getIndividualCounseling() !=null)
			    	   model.setIndividualCounseling(childEntity.getIndividualCounseling().getValue());
			       if(childEntity.getFamilyCounseling() !=null)
			    	   model.setFamilyCounseling(childEntity.getFamilyCounseling().getValue());
			       if(childEntity.getGroupCounseling() !=null)
			    	   model.setGroupCounseling(childEntity.getGroupCounseling().getValue());
			       if(childEntity.getSessionCountAtExit() !=null)
			    	   model.setSessionCountAtExit(String.valueOf(childEntity.getSessionCountAtExit()));
			       if(childEntity.getSessionsInPlan() !=null)
			    	   model.setSessionsInPlan(String.valueOf(childEntity.getSessionsInPlan()));
			       if(childEntity.getPostExitCounselingPlan() !=null)
			    	   model.setPostExitCounselingPlan(childEntity.getPostExitCounselingPlan().getValue());
			       if(childEntity.getDestinationSafeClient() !=null)
			    	   model.setDestinationSafeClient(childEntity.getDestinationSafeClient().getValue());
			       if(childEntity.getDestinationSafeWorker() !=null)
			    	   model.setDestinationSafeWorker(childEntity.getDestinationSafeWorker().getValue());
			       if(childEntity.getPosAdultConnections() !=null)
			    	   model.setPosAdultConnections(childEntity.getPosAdultConnections().getValue());
			       if(childEntity.getPosPeerConnections() !=null)
			    	   model.setPosPeerConnections(childEntity.getPosPeerConnections().getValue());
			       if(childEntity.getPosCommunityConnections() !=null)
			    	   model.setPosCommunityConnections(childEntity.getPosCommunityConnections().getValue());
			     
			       
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				exits.add(model);
			}
		}
		return exits;
	}
	
	
	
	
	/***
	 * Convert all the exitrhies into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Exit> rhyAfterCaresToCsv(com.servinglynk.hmis.warehouse.model.v2020.Exit entity,Set<RHYAfterCare> rhyAfterCares) {
		List<Exit>  exits = new ArrayList<Exit>();
		if(CollectionUtils.isNotEmpty(rhyAfterCares)) {
			for(RHYAfterCare childEntity : rhyAfterCares) {
				Exit model = entityToCsv(entity);
				 model.setExitID(getId(entity.getId()));
				 
			       if(childEntity.getAfterCareDate() !=null)
			    	   model.setAftercareDate(getDate(childEntity.getAfterCareDate()));
			       if(childEntity.getAfterProvided() !=null)
			    	   model.setAftercareProvided(childEntity.getAfterProvided().getValue());
			       if(childEntity.getEmailSocialMedia() !=null)
			    	   model.setEmailSocialMedia(childEntity.getEmailSocialMedia().getValue());
			       if(childEntity.getInPersonGroup() !=null)
			    	   model.setInPersonGroup(childEntity.getInPersonGroup().getValue());
			       if(childEntity.getInPersonIndividual()!=null)
			    	   model.setInPersonIndividual(childEntity.getInPersonIndividual().getValue());
			       if(childEntity.getTelephone() !=null)
			    	   model.setTelephone(childEntity.getTelephone().getValue());
			       
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				exits.add(model);
			}
		}
		return exits;
	}
	
	/***
	 * Convert all the exitrhies into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Exit> vashExitReasonsToCsv(com.servinglynk.hmis.warehouse.model.v2020.Exit entity,Set<VashExitReason> vashExitReasons) {
		List<Exit>  exits = new ArrayList<Exit>();
		if(CollectionUtils.isNotEmpty(vashExitReasons)) {
			for(VashExitReason childEntity : vashExitReasons) {
				Exit model = entityToCsv(entity);
				 model.setExitID(getId(entity.getId()));
				 
				if(childEntity.getCmExitReason() !=null)
			    	model.setCMExitReason(childEntity.getCmExitReason().getValue());
				   
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				exits.add(model);
			}
		}
		return exits;
	}
	
	
	
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Exit> exits,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Exit());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		
		if(CollectionUtils.isNotEmpty(exits)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Exit exit : exits) {
				baseCSVs.add(entityToCsv(exit));
				
				Set<Exithousingassessment> exithousingassessments = exit.getExithousingassessments();
				if(CollectionUtils.isNotEmpty(exithousingassessments))  {
					baseCSVs.addAll(exithousingassessmentsToCsv(exit, exithousingassessments));
				}
				Set<Exitrhy> exitrhies = exit.getExitrhies();
				if(CollectionUtils.isNotEmpty(exitrhies))  {
					baseCSVs.addAll(exitrhiesToCsv(exit, exitrhies));
				}
				Set<RHYAfterCare> rhyAfterCares = exit.getRhyAfterCares();
				if(CollectionUtils.isNotEmpty(rhyAfterCares))  {
					baseCSVs.addAll(rhyAfterCaresToCsv(exit, rhyAfterCares));
				}
				Set<VashExitReason> vasExitReasons = exit.getVasExitReasons();
				if(CollectionUtils.isNotEmpty(vasExitReasons))  {
					baseCSVs.addAll(vashExitReasonsToCsv(exit, vasExitReasons));
				}
			}
		}
			CsvFileWriter.writeToCsv("Exit.csv",baseCSVs);
			fillHeaders = false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
		 //e.printStackTrace();
		}
	}

	
}
