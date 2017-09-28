package com.servinglynk.hmis.warehouse.service.converter; 

import com.servinglynk.hmis.warehouse.core.model.ActionLink;
import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.model.v2016.QuestionEntity;

public class QuestionConverter   {



   public static Question entityToModel (QuestionEntity entity) {
       Question model = new Question();
       model.setQuestionId(entity.getId());
       model.setQuestionDescription(entity.getQuestionDescription());
       model.setDisplayText(entity.getDisplayText());
       model.setQuestionDataType(entity.getQuestionDataType());
       model.setQuestionType(entity.getQuestionType());
       model.setHudQuestionId(entity.getHudQuestionId());
       model.setPicklistGroupName(entity.getPicklistGroupName());
      if(entity.getPicklistGroupName()!=null) model.addLink(new ActionLink("pickList", "/hmis-clientapi/rest/v2014/hmistypes/"+entity.getPicklistGroupName()+"/values"));
      if(entity.getUpdateURLTemplate()!=null) model.addLink(new ActionLink("updateUriTemplate", entity.getUpdateURLTemplate()));
      return model;
   }


}
