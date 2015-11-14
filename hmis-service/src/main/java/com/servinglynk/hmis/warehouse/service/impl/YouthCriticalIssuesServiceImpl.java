package com.servinglynk.hmis.warehouse.service.impl; 

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssue;
import com.servinglynk.hmis.warehouse.core.model.YouthCriticalIssues;
import com.servinglynk.hmis.warehouse.service.YouthCriticalIssuesService;
import com.servinglynk.hmis.warehouse.service.converter.YouthCriticalIssuesConverter;
import com.servinglynk.hmis.warehouse.service.exception.EnrollmentNotFound;
import com.servinglynk.hmis.warehouse.service.exception.YouthCriticalIssuesNotFoundException;


public class YouthCriticalIssuesServiceImpl extends ServiceBase implements YouthCriticalIssuesService  {

	   @Transactional
	   public YouthCriticalIssue createYouthCriticalIssues(YouthCriticalIssue youthCriticalIssues,UUID enrollmentId,String caller){
	       com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues pYouthCriticalIssues = YouthCriticalIssuesConverter.modelToEntity(youthCriticalIssues, null);
	       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
	       if(pEnrollment == null) throw new EnrollmentNotFound(); 
	       pYouthCriticalIssues.setEnrollmentid(pEnrollment); 
	       pYouthCriticalIssues.setDateCreated(LocalDateTime.now());
	       pYouthCriticalIssues.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
	       daoFactory.getYouthcriticalissuesDao().createYouthCriticalIssues(pYouthCriticalIssues);
	       youthCriticalIssues.setYouthCriticalIssuesId(pYouthCriticalIssues.getId());
	       return youthCriticalIssues;
	   }


	   @Transactional
	   public YouthCriticalIssue updateYouthCriticalIssues(YouthCriticalIssue youthCriticalIssues,UUID enrollmentId,String caller){
	       com.servinglynk.hmis.warehouse.model.live.Enrollment pEnrollment = daoFactory.getEnrollmentDao().getEnrollmentById(enrollmentId); 
	       if(pEnrollment == null) throw new EnrollmentNotFound(); 
	       com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues pYouthCriticalIssues = daoFactory.getYouthcriticalissuesDao().getYouthCriticalIssuesById(youthCriticalIssues.getYouthCriticalIssuesId());
	       if(pYouthCriticalIssues==null) throw new YouthCriticalIssuesNotFoundException();

	       YouthCriticalIssuesConverter.modelToEntity(youthCriticalIssues, pYouthCriticalIssues);
	       pYouthCriticalIssues.setEnrollmentid(pEnrollment); 
	       pYouthCriticalIssues.setDateUpdated(LocalDateTime.now());
	       pYouthCriticalIssues.setUser(daoFactory.getHmisUserDao().findByUsername(caller));
	       daoFactory.getYouthcriticalissuesDao().updateYouthCriticalIssues(pYouthCriticalIssues);
	       youthCriticalIssues.setYouthCriticalIssuesId(pYouthCriticalIssues.getId());
	       return youthCriticalIssues;
	   }


	   @Transactional
	   public YouthCriticalIssue deleteYouthCriticalIssues(UUID youthCriticalIssuesId,String caller){
	       com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues pYouthCriticalIssues = daoFactory.getYouthcriticalissuesDao().getYouthCriticalIssuesById(youthCriticalIssuesId);
	       if(pYouthCriticalIssues==null) throw new YouthCriticalIssuesNotFoundException();

	       daoFactory.getYouthcriticalissuesDao().deleteYouthCriticalIssues(pYouthCriticalIssues);
	       return new YouthCriticalIssue();
	   }


	   @Transactional
	   public YouthCriticalIssue getYouthCriticalIssuesById(UUID youthCriticalIssuesId){
	       com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues pYouthCriticalIssues = daoFactory.getYouthcriticalissuesDao().getYouthCriticalIssuesById(youthCriticalIssuesId);
	       if(pYouthCriticalIssues==null) throw new YouthCriticalIssuesNotFoundException();

	       return YouthCriticalIssuesConverter.entityToModel( pYouthCriticalIssues );
	   }


	   @Transactional
	   public YouthCriticalIssues getAllEnrollmentYouthCriticalIssuess(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       YouthCriticalIssues youthCriticalIssuess = new YouthCriticalIssues();
	        List<com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues> entities = daoFactory.getYouthcriticalissuesDao().getAllEnrollmentYouthCriticalIssuess(enrollmentId,startIndex,maxItems);
	        for(com.servinglynk.hmis.warehouse.model.live.Youthcriticalissues entity : entities){
	           youthCriticalIssuess.addYouthCriticalIssue(YouthCriticalIssuesConverter.entityToModel(entity));
	        }
	        long count = daoFactory.getYouthcriticalissuesDao().getEnrollmentYouthCriticalIssuessCount(enrollmentId);
	        SortedPagination pagination = new SortedPagination();
	 
	        pagination.setFrom(startIndex);
	        pagination.setReturned(youthCriticalIssuess.getYouthCriticalIssues().size());
	        pagination.setTotal((int)count);
	        youthCriticalIssuess.setPagination(pagination);
	        return youthCriticalIssuess; 
	   }


}
