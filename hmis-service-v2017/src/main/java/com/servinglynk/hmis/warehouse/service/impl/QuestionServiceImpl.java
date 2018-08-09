package com.servinglynk.hmis.warehouse.service.impl; 

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.HMISType;
import com.servinglynk.hmis.warehouse.core.model.HMISTypes;
import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.core.model.Questions;
import com.servinglynk.hmis.warehouse.model.v2017.QuestionEntity;
import com.servinglynk.hmis.warehouse.service.QuestionService;
import com.servinglynk.hmis.warehouse.service.converter.QuestionConverter;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;


@Component
public class QuestionServiceImpl extends ServiceBase implements QuestionService  {

   @Transactional
   public Questions getAllQuestions(String displayText, String description,Integer startIndex, Integer maxItems){
       Questions Questions = new Questions();
        List<QuestionEntity> entities = daoFactory.getQuestionDao().getAllQuestionEntities(displayText, description,startIndex,maxItems);
        for(QuestionEntity entity : entities){
        	Question question = QuestionConverter.entityToModel(entity);
        	if(entity.getPicklistGroupName()!=null) {
        		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(entity.getPicklistGroupName());
        		for(HMISType hmisType : pickList.getHmisTypes()) {
        			question.addPickList(hmisType);
        		}
        		
        	}
           Questions.addQuestion(question);
        }
        long count = daoFactory.getQuestionDao().getQuestionEntitysCount(displayText, description);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(Questions.getQuestions().size());
        pagination.setTotal((int)count);
        pagination.setMaximum(200);
        Questions.setPagination(pagination);
        return Questions; 
   }
	
   @Transactional
	public Question getQuestionsHudId(String hudQuestionId) {
	   QuestionEntity questionEntity = daoFactory.getQuestionDao().getQuestionsHudId(hudQuestionId);
	   if(questionEntity==null) throw new ResourceNotFoundException("No question found with selected hudQuestionId "+hudQuestionId);
	   Question question = QuestionConverter.entityToModel(questionEntity);
	   
   		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(questionEntity.getPicklistGroupName());
   		for(HMISType hmisType : pickList.getHmisTypes()) {
			question.addPickList(hmisType);
		}
   			
   	return question;
	}
}