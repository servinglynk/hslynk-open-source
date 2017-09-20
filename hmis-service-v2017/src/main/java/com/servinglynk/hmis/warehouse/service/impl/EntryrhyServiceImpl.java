package com.servinglynk.hmis.warehouse.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.core.model.Entryrhy;
import com.servinglynk.hmis.warehouse.service.EntryrhyService;
import com.servinglynk.hmis.warehouse.service.converter.EntryrhyConverter;
import com.servinglynk.hmis.warehouse.core.model.Entryrhys;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAlcoholDrugAbuseFamEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYCoercedToContinueWorkEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYExchangeForSexPastThreeMonthsEnum;
import com.servinglynk.hmis.warehouse.enums.EntryRHYcountOfExchangeForSexpEnum;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.EntryrhyNotFoundException;
import com.servinglynk.hmis.warehouse.SortedPagination;


public class EntryrhyServiceImpl extends ServiceBase implements EntryrhyService  {

   @Transactional
   public Entryrhy createEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Entryrhy pEntryrhy = EntryrhyConverter.modelToEntity(entryrhy, null);
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       pEntryrhy.setEnrollmentid(pEnrollment);
       pEntryrhy.setAlcoholDrugAbuseFamilyMbr(EntryRHYAlcoholDrugAbuseFamEnum.lookupEnum(String.valueOf(entryrhy.getAlcoholDrugAbuseFamilyMbr())));
       pEntryrhy.setAskedOfForcedToExchangeForSex(EntryRHYAskedOrForcedToExchangeForSexEnum.lookupEnum(String.valueOf(entryrhy.getAskedOfForcedToExchangeForSex())));
       pEntryrhy.setAskedOfForcedToExchangeForSexPastThreeMonths(EntryRHYAskedOrForcedToExchangeForSexPastThreeMonthsEnum.lookupEnum(String.valueOf(entryrhy.getAskedOfForcedToExchangeForSexPastThreeMonths())));
       pEntryrhy.setCoercedToContinueWork(EntryRHYCoercedToContinueWorkEnum.lookupEnum(String.valueOf(entryrhy.getCoercedToContinueWork())));
       pEntryrhy.setCountOfExchangeForSex(EntryRHYcountOfExchangeForSexpEnum.lookupEnum(String.valueOf(entryrhy.getCountOfExchangeForSex())));
       pEntryrhy.setCountOutReachReferralApproaches(entryrhy.getCountOutReachReferralApproaches());
       pEntryrhy.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(String.valueOf(entryrhy.getDataCollectionStage())));
       pEntryrhy.setExchangeForSex(EntryRHYExchangeForSexEnum.lookupEnum(String.valueOf(entryrhy.getExchangeForSex())));
       pEntryrhy.setExchangeForSexPastThreeMonths(EntryRHYExchangeForSexPastThreeMonthsEnum.lookupEnum(String.valueOf(entryrhy.getExchangeForSexPastThreeMonths())));
       pEntryrhy.setFormerlyWardChildWelfrForestCare();
       pEntryrhy.setFormerlyWardOfJuvenileJustice(formerlyWardOfJuvenileJustice);
       pEntryrhy.setIncarceratedParent(incarceratedParent);
       pEntryrhy.setInformationDate(informationDate);
       pEntryrhy.setInsufficientIncomeToSupportYouth(insufficientIncomeToSupportYouth);
       pEntryrhy.setLaborExploitPastThreeMonths(laborExploitPastThreeMonths);
       pEntryrhy.setMentalHealthIssuesFamilyMbr(mentalHealthIssuesFamilyMbr);
       pEntryrhy.setMonthsJuvenileJustice(monthsJuvenileJustice);
       pEntryrhy.setPhysicalDisabilityFamilyMbr(physicalDisabilityFamilyMbr);
       pEntryrhy.setReferralSource(referralSource);
       pEntryrhy.setSexualOrientation(sexualOrientation);
       pEntryrhy.setWorkPlacePromiseDifference(workPlacePromiseDifference);
       pEntryrhy.setWorkPlaceViolenceThreat(workPlaceViolenceThreat);
       pEntryrhy.setYearsChildWelfrForestCare(yearsChildWelfrForestCare);
       pEntryrhy.setYearsJuvenileJustice(yearsJuvenileJustice);
       pEntryrhy.setDateCreated(LocalDateTime.now());
       daoFactory.getProjectDao().populateUserProjectGroupCode(pEntryrhy, caller);
       daoFactory.getEntryrhyDao().createEntryrhy(pEntryrhy);
       entryrhy.setEntryrhyId(pEntryrhy.getId());
       return entryrhy;
   }


   @Transactional
   public Entryrhy updateEntryrhy(Entryrhy entryrhy,UUID enrollmentId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId);
       if(pEnrollment == null) throw new EnrollmentNotFound();
       com.servinglynk.hmis.warehouse.model.v2017.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhy.getEntryrhyId());
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       EntryrhyConverter.modelToEntity(entryrhy, pEntryrhy);
       pEntryrhy.setEnrollmentid(pEnrollment);
       pEntryrhy.setDateUpdated(LocalDateTime.now());
       pEntryrhy.setUserId(daoFactory.getHmisUserDao().findByUsername(caller).getId());
       daoFactory.getEntryrhyDao().updateEntryrhy(pEntryrhy);
       entryrhy.setEntryrhyId(pEntryrhy.getId());
       return entryrhy;
   }


   @Transactional
   public Entryrhy deleteEntryrhy(UUID entryrhyId,String caller){
       com.servinglynk.hmis.warehouse.model.v2017.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhyId);
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       daoFactory.getEntryrhyDao().deleteEntryrhy(pEntryrhy);
       return new Entryrhy();
   }


   @Transactional
   public Entryrhy getEntryrhyById(UUID entryrhyId){
       com.servinglynk.hmis.warehouse.model.v2017.Entryrhy pEntryrhy = daoFactory.getEntryrhyDao().getEntryrhyById(entryrhyId);
       if(pEntryrhy==null) throw new EntryrhyNotFoundException();

       return EntryrhyConverter.entityToModel( pEntryrhy );
   }


   @Transactional
   public Entryrhys getAllEnrollmentEntryrhys(UUID enrollmentId,Integer startIndex, Integer maxItems){
       Entryrhys entryrhys = new Entryrhys();
        List<com.servinglynk.hmis.warehouse.model.v2017.Entryrhy> entities = daoFactory.getEntryrhyDao().getAllEnrollmentEntryrhys(enrollmentId,startIndex,maxItems);
        for(com.servinglynk.hmis.warehouse.model.v2017.Entryrhy entity : entities){
           entryrhys.addEntryrhy(EntryrhyConverter.entityToModel(entity));
        }
        long count = daoFactory.getEntryrhyDao().getEnrollmentEntryrhysCount(enrollmentId);
        SortedPagination pagination = new SortedPagination();

        pagination.setFrom(startIndex);
        pagination.setReturned(entryrhys.getEntryrhys().size());
        pagination.setTotal((int)count);
        entryrhys.setPagination(pagination);
        return entryrhys;
   }


}
