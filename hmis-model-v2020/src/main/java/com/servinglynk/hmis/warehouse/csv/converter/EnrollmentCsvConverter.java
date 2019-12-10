package com.servinglynk.hmis.warehouse.csv.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.servinglynk.hmis.warehouse.csv.BaseCSV;
import com.servinglynk.hmis.warehouse.csv.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2020.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2020.Moveindate;
import com.servinglynk.hmis.warehouse.model.v2020.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2020.RhybcpStatus;

@Component
public class EnrollmentCsvConverter extends BaseCsvConverter {

	public Enrollment entityToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity) {
		 Enrollment model = new Enrollment();
	     if(entity !=null) {
	    	 model.setEnrollmentID(getId(entity.getId()));
	    	 if(entity.getClient() != null)
	    		 model.setPersonalID(entity.getClient().getSourceSystemId());
	    	 model.setDateToStreetESSH(entity.getDatetostreetessh().toString());
	    	 if(entity.getDisablingcondition() !=null)
	    		 model.setDisablingCondition(entity.getDisablingcondition().getValue());
	    	 
	    	  model.setEntryDate(getDate(entity.getEntrydate()));
	    	  model.setHouseholdID(entity.getHouseholdid());
	    	  if(entity.getLengthOfStay() !=null)
	    		  model.setLengthOfStay(entity.getLengthOfStay().getValue());
	    	  if(entity.getLivingSituation() !=null)
	    		  model.setLivingSituation(entity.getLivingSituation().getValue());
	    	  if(entity.getLosunderthreshold() !=null)
	    		  model.setLOSUnderThreshold(entity.getLosunderthreshold().getValue());
	    	  
	    	  if(entity.getPreviousStreetESSH() != null)
	    		  model.setPreviousStreetESSH(entity.getPreviousStreetESSH().getValue());
	    	  if(entity.getMonthshomelesspastthreeyears() !=null)
	    		  model.setMonthsHomelessPastThreeYears(entity.getMonthshomelesspastthreeyears().getValue());
	    	  if(entity.getProject() !=null)
	    		  model.setProjectID(getId(entity.getProject().getId()));
	    	  if(entity.getRelationshiptohoh() !=null)
	    		  model.setRelationshipToHoH((entity.getRelationshiptohoh().getValue()));
	    	  if(entity.getTimeshomelesspastthreeyears() != null)
	    		  model.setTimesHomelessPastThreeYears(entity.getTimeshomelesspastthreeyears().getValue());
	    			 
		     if(entity.getUserId() !=null)
				model.setUserID(entity.getUserId().toString());
			model.setDateCreated(entity.getDateCreated().toString());
			model.setDateUpdated(entity.getDateUpdated().toString());
			if(entity.getExport() != null)
				model.setExportID(entity.getExport().getSourceSystemId());
	     }
		//model.setPITCount(entity.);
		return model;
	}
	
	/***
	 * Convert all the MoveinDate into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> moveindateToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Moveindate> moveindates) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(moveindates)) {
			for(Moveindate childEntity : moveindates) {
				Enrollment model = entityToCsv(entity);
				model.setMoveInDate(getDate(childEntity.getMoveindate()));
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}
	/***
	 * Convert all the entryssvfs into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> entryssvfsToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Entryssvf> entryssvfs) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(entryssvfs)) {
			for(Entryssvf childEntity : entryssvfs) {
				Enrollment model = entityToCsv(entity);
				
				if(childEntity.getAddressDataQuality() !=null)
				  model.setAddressDataQuality(childEntity.getAddressDataQuality().getValue());
				if(childEntity.getHpScreeningScore() !=null)
				  model.setHPScreeningScore(String.valueOf(childEntity.getHpScreeningScore()));
				  model.setLastPermanentCity(childEntity.getLastPermanentCity());
				  model.setLastPermanentState(childEntity.getLastPermanentState());
				  model.setLastPermanentStreet(childEntity.getLastPermanentStreet());
		    	  if(StringUtils.isNotBlank(childEntity.getLastPermanentZip()))
		    		  model.setLastPermanentZIP(childEntity.getLastPermanentZip());
		    	  if(childEntity.getPercentami() != null)
		    		  model.setPercentAMI(childEntity.getPercentami().getValue());
		    	  model.setVAMCStation(childEntity.getVamcStation());
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}
	
	
	/***
	 * Convert all the MoveinDate into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> rhybcpStatusToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<RhybcpStatus> rhybcpStatuses) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(rhybcpStatuses)) {
			for(RhybcpStatus childEntity : rhybcpStatuses) {
				Enrollment model = entityToCsv(entity);
				if(childEntity.getEligibleForRhy() != null)
					model.setEligibleForRHY(childEntity.getEligibleForRhy().getValue());
				model.setDateOfBCPStatus(getDate(childEntity.getStatusDate()));
				if(childEntity.getRunawayYouth() !=null)
					model.setRunawayYouth(childEntity.getRunawayYouth().getValue());
				if(childEntity.getReasonNoServices() !=null)
					model.setReasonNoServices(childEntity.getReasonNoServices().getValue());
		    	  
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}
	
	/***
	 * Convert all the Entryrhssps into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> dateOfEngagementToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Dateofengagement> dateOfEngagements) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(dateOfEngagements)) {
			for(Dateofengagement childEntity : dateOfEngagements) {
				Enrollment model = entityToCsv(entity);
				model.setDateOfEngagement(getDate(childEntity.getDateofengagement()));
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}
	
	
	/***
	 * Convert all the Entryrhssps into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> entryrhspToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Entryrhsp> entryrhsps) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(entryrhsps)) {
			for(Entryrhsp childEntity : entryrhsps) {
				Enrollment model = entityToCsv(entity);
				if(childEntity.getWorstHousingSituation() != null) 
				model.setWorstHousingSituation(String.valueOf(childEntity.getWorstHousingSituation()));
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}	
	
	/***
	 * Convert all the PathStatus into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> pathStatusToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Pathstatus> pathStatuses) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(pathStatuses)) {
			for(Pathstatus childEntity : pathStatuses) {
				Enrollment model = entityToCsv(entity);
				model.setClientEnrolledInPATH(String.valueOf(childEntity.getClientEnrolledInPath()));
				model.setDateOfPATHStatus(getDate(childEntity.getDateOfStatus()));
				if(childEntity.getReasonNotEnrolled() != null)
					model.setReasonNotEnrolled(childEntity.getReasonNotEnrolled().getValue());
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}	
	
	
	/***
	 * Convert all the Entryrhy into enrollment
	 * @param entity
	 * @param entryrhsps
	 * @return
	 */
	public List<Enrollment> entryrhyToCsv(com.servinglynk.hmis.warehouse.model.v2020.Enrollment entity,Set<Entryrhy> entryrhys) {
		List<Enrollment>  enrollments = new ArrayList<Enrollment>();
		if(CollectionUtils.isNotEmpty(entryrhys)) {
			for(Entryrhy childEntity : entryrhys) {
				Enrollment model = entityToCsv(entity);
				 if(childEntity.getAlcoholDrugAbuseFamilyMbr() != null)
			  	   model.setAlcoholDrugAbuseFam(childEntity.getAlcoholDrugAbuseFamilyMbr().getValue());
				 if(childEntity.getMonthsChildWelfrForestCare() != null)
		    	   model.setChildWelfareMonths(String.valueOf(childEntity.getMonthsChildWelfrForestCare()));
				 if(childEntity.getYearsChildWelfrForestCare() != null)
				   model.setChildWelfareYears((childEntity.getYearsChildWelfrForestCare().getValue()));
				 if(childEntity.getCountOutReachReferralApproaches() != null)
				   model.setCountOutreachReferralApproaches(String.valueOf(childEntity.getCountOutReachReferralApproaches()));
				 if(childEntity.getSexualOrientation() != null)
				   model.setSexualOrientation(childEntity.getSexualOrientation().getValue());
				 if(childEntity.getFormerlyWardChildWelfrForestCare() != null) 
				   model.setFormerWardChildWelfare(childEntity.getFormerlyWardChildWelfrForestCare().getValue());
				 if(childEntity.getFormerlyWardOfJuvenileJustice() != null)
					 model.setFormerWardJuvenileJustice(childEntity.getFormerlyWardOfJuvenileJustice().getValue());
				 if(childEntity.getIncarceratedParent() != null)
				  model.setIncarceratedParent(childEntity.getIncarceratedParent().getValue());
				 if(childEntity.getInsufficientIncomeToSupportYouth() != null)
				  model.setInsufficientIncome(childEntity.getInsufficientIncomeToSupportYouth().getValue());
				 if(childEntity.getMonthsJuvenileJustice() != null)
				  model.setJuvenileJusticeMonths(String.valueOf(childEntity.getMonthsJuvenileJustice()));
				 if(childEntity.getYearsJuvenileJustice() != null)
					model.setJuvenileJusticeYears(childEntity.getYearsJuvenileJustice().getValue());
				 if(childEntity.getMentalHealthIssuesFamilyMbr() != null)
					 model.setMentalHealthIssuesFam(childEntity.getMentalHealthIssuesFamilyMbr().getValue());
				 if(childEntity.getPhysicalDisabilityFamilyMbr() != null)
				  model.setPhysicalDisabilityFam(childEntity.getPhysicalDisabilityFamilyMbr().getValue());
				 if(childEntity.getReferralSource() != null)
					  model.setReferralSource(childEntity.getReferralSource().getValue());
				  if(childEntity.getUnemployementFamilyMbr() != null)
				  model.setUnemploymentFam(childEntity.getUnemployementFamilyMbr().getValue());
				  
				  model.setSexualOrientationOther(childEntity.getSexualOrientationOther());
				
				if(childEntity.getUserId() !=null)
					model.setUserID(childEntity.getUserId().toString());
				model.setDateCreated(childEntity.getDateCreated().toString());
				model.setDateUpdated(childEntity.getDateUpdated().toString());
				if(childEntity.getExport() != null)
					model.setExportID(childEntity.getExport().getSourceSystemId());
				enrollments.add(model);
			}
		}
		return enrollments;
	}	
		
	public void writeToCSV(Set<com.servinglynk.hmis.warehouse.model.v2020.Enrollment> enrollments,boolean fillHeaders) {
		List<BaseCSV> baseCSVs = null;
		if(fillHeaders) {
			baseCSVs = getBaseCSVs(new Enrollment());
		}else {
			baseCSVs = new ArrayList<BaseCSV>();
		}
		try {
		if(CollectionUtils.isNotEmpty(enrollments)) {
			for(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment : enrollments) {
				
				baseCSVs.add(entityToCsv(enrollment));
				Set<Entryrhsp> entryrhsps = enrollment.getEntryrhsps();
				if(CollectionUtils.isNotEmpty(entryrhsps)) {
					baseCSVs.addAll(entryrhspToCsv(enrollment,entryrhsps));
				}
				Set<Dateofengagement> dateofengagements = enrollment.getDateofengagements();
				if(CollectionUtils.isNotEmpty(dateofengagements)) {
					baseCSVs.addAll(dateOfEngagementToCsv(enrollment, dateofengagements));
				}
				Set<Moveindate> moveinDates = enrollment.getMoveinDates();
				if(CollectionUtils.isNotEmpty(moveinDates)) {
					baseCSVs.addAll(moveindateToCsv(enrollment, moveinDates));
				}
				Set<RhybcpStatus> rhybcpStatuses = enrollment.getRhybcpStatuses();
				if(CollectionUtils.isNotEmpty(rhybcpStatuses)) {
					baseCSVs.addAll(rhybcpStatusToCsv(enrollment, rhybcpStatuses));
				}
				Set<Entryssvf> entryssvfs = enrollment.getEntryssvfs();
				if(CollectionUtils.isNotEmpty(entryssvfs)) {
					baseCSVs.addAll(entryssvfsToCsv(enrollment, entryssvfs));
				}
				Set<Entryrhy> entryrhies = enrollment.getEntryrhies();
				if(CollectionUtils.isNotEmpty(entryrhies)) {
					baseCSVs.addAll(entryrhyToCsv(enrollment, entryrhies));
				}
				Set<Pathstatus> pathStatuses = enrollment.getPathStatuses();
				if(CollectionUtils.isNotEmpty(pathStatuses)) {
					baseCSVs.addAll(pathStatusToCsv(enrollment, pathStatuses));
				}
			}
		}
			CsvFileWriter.writeToCsv("Enrollment.csv",baseCSVs);
		}catch(Exception e) { // eat the exception for now. I need to log it 
			}
		}
	
}
