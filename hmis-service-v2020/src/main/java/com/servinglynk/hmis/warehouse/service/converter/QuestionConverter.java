package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.model.v2020.QuestionEntity;

public class QuestionConverter   {



   public static Question entityToModel (QuestionEntity entity, Boolean includepicklist) {
       Question model = new Question();
       model.setQuestionId(entity.getId());
       model.setQuestionDescription(entity.getQuestionDescription());
       model.setDisplayText(entity.getDisplayText());
       model.setQuestionDataType(entity.getQuestionDataType());
       model.setQuestionType(entity.getQuestionType());
       model.setHudQuestionId(entity.getHudQuestionId());
       if(!includepicklist) {
         model.setPicklistGroupName(entity.getPicklistGroupName());
         if(entity.getPicklistGroupName()!=null) model.addLink(new ActionLink("pickList", "/hmis-clientapi/rest/v2020/hmistypes/"+entity.getPicklistGroupName()+"/values"));
       }
//       if(entity.getUpdateURLTemplate()!=null) model.addLink(new ActionLink("updateUriTemplate", entity.getUpdateURLTemplate(),entity.getUriObjectField()));
       if(entity.getUriObjectField()!=null) model.setUriObjectField(entity.getUriObjectField());
       if(entity.getUpdateURLTemplate()!=null) model.setUpdateUriTemplate(entity.getUpdateURLTemplate());
       if(entity.getQuestionGroupId()!=null) model.setQuestionGroupId(entity.getQuestionGroupId());
      return model;
   }
   
   
   public static Question entityToModelV2 (QuestionEntity entity, Boolean includepicklist) {
       Question model = new Question();
       model.setQuestionId(entity.getId());
       model.setQuestionDescription(entity.getQuestionDescription());
       model.setDisplayText(entity.getDisplayText());
       model.setQuestionDataType(entity.getQuestionDataType());
       model.setQuestionType(entity.getQuestionType());
       model.setHudQuestionId(entity.getHudQuestionId());
         model.setPicklistGroupName(entity.getPicklistGroupName());
//       if(entity.getUpdateURLTemplate()!=null) model.addLink(new ActionLink("updateUriTemplate", entity.getUpdateURLTemplate(),entity.getUriObjectField()));
       if(entity.getUriObjectField()!=null) model.setUriObjectField(entity.getUriObjectField());
       if(entity.getUpdateURLTemplate()!=null) model.setUpdateUriTemplate(entity.getUpdateURLTemplate());
       if(entity.getQuestionGroupId()!=null) model.setQuestionGroupId(entity.getQuestionGroupId());
      return model;
   }


}
  