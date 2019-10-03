package com.servinglynk.hmis.warehouse.service.impl; 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.servinglynk.hmis.warehouse.SortedPagination;
import com.servinglynk.hmis.warehouse.core.model.HMISType;
import com.servinglynk.hmis.warehouse.core.model.HMISTypes;
import com.servinglynk.hmis.warehouse.core.model.HudQuestionDefinition;
import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.core.model.Questions;
import com.servinglynk.hmis.warehouse.model.v2020.QuestionEntity;
import com.servinglynk.hmis.warehouse.service.QuestionService;
import com.servinglynk.hmis.warehouse.service.converter.QuestionConverter;
import com.servinglynk.hmis.warehouse.service.exception.ResourceNotFoundException;


@Component
public class QuestionServiceImpl extends ServiceBase implements QuestionService  {
	
	ObjectMapper mapper = new ObjectMapper();

   @Transactional
   public Questions getAllQuestions(String displayText,Boolean includepicklist, String description,Integer startIndex, Integer maxItems) throws Exception {
       Questions Questions = new Questions();
        List<QuestionEntity> entities = daoFactory.getQuestionDao().getAllQuestionEntities(displayText, description,startIndex,maxItems);
        for(QuestionEntity entity : entities){
        	Question question = QuestionConverter.entityToModel(entity,includepicklist);
        	if(entity.getPicklistGroupName()!=null) {
        		Map<String, String> pickListValues = new HashMap<String,String>();
        		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(entity.getPicklistGroupName());
        		
        		for(HMISType hmisType : pickList.getHmisTypes()) {
        			if(includepicklist) question.addPickList(hmisType);
        			question.getPickListValues().put(hmisType.getValue(), hmisType.getDescription());
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
	public Question getQuestionsHudId(Boolean includepicklist,String hudQuestionId) {
	   QuestionEntity questionEntity = daoFactory.getQuestionDao().getQuestionsHudId(hudQuestionId);
	   if(questionEntity==null) throw new ResourceNotFoundException("No question found with selected hudQuestionId "+hudQuestionId);
	   Question question = QuestionConverter.entityToModel(questionEntity,includepicklist);
	   if(questionEntity.getPicklistGroupName()!=null & includepicklist) {
   		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(questionEntity.getPicklistGroupName());
   		for(HMISType hmisType : pickList.getHmisTypes()) {
			if(includepicklist) question.addPickList(hmisType);
			question.getPickListValues().put(hmisType.getValue(), hmisType.getDescription());
		}
	   }
   			
   	return question;
	}
   
   
   @Transactional
	public Question getQuestionsHudIdV2(Boolean includepicklist,String hudQuestionId) {
	   QuestionEntity questionEntity = daoFactory.getQuestionDao().getQuestionsHudId(hudQuestionId);
	   if(questionEntity==null) throw new ResourceNotFoundException("No question found with selected hudQuestionId "+hudQuestionId);
	   Question question = QuestionConverter.entityToModelV2(questionEntity,includepicklist);
	   if(questionEntity.getPicklistGroupName()!=null & includepicklist) {
   		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(questionEntity.getPicklistGroupName());
   		for(HMISType hmisType : pickList.getHmisTypes()) {
			if(includepicklist) question.addPickList(hmisType);
			question.getPickListValues().put(hmisType.getValue(), hmisType.getDescription());
		}
    	HudQuestionDefinition definition = new HudQuestionDefinition();
    	definition.setOptions(question.getPickListValues());
    	definition.setQuestionType(question.getQuestionType());
    	definition.setTitle(question.getDisplayText());
    	question.setDefinition(definition);
    	question.setPickListValues(null);
	   }
   			
   	return question;
	}
   
   @Transactional
   public Questions getAllQuestionsV2(String displayText,Boolean includepicklist, String description,Integer startIndex, Integer maxItems) throws Exception {
       Questions questions = new Questions();
        List<QuestionEntity> entities = daoFactory.getQuestionDao().getAllQuestionEntities(displayText, description,startIndex,maxItems);
        for(QuestionEntity entity : entities){
        	Question question = QuestionConverter.entityToModelV2(entity,includepicklist);
        	if(entity.getPicklistGroupName()!=null) {
        		HMISTypes pickList =serviceFactory.getHmisTypeService().getDataElements(entity.getPicklistGroupName());
        		for(HMISType hmisType : pickList.getHmisTypes()) {
        			question.getPickListValues().put(hmisType.getValue(), hmisType.getDescription());
        		}
        	}
        	HudQuestionDefinition definition = new HudQuestionDefinition();
        	definition.setOptions(question.getPickListValues());
        	definition.setQuestionType(question.getQuestionType());
        	definition.setTitle(question.getDisplayText());
        	question.setDefinition(definition);
        	question.setPickListValues(null);
        	questions.addQuestion(question);
        }
        long count = daoFactory.getQuestionDao().getQuestionEntitysCount(displayText, description);
        SortedPagination pagination = new SortedPagination();
 
        pagination.setFrom(startIndex);
        pagination.setReturned(questions.getQuestions().size());
        pagination.setTotal((int)count);
        pagination.setMaximum(200);
        questions.setPagination(pagination);
        return questions; 
   }
}