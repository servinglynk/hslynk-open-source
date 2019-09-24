package com.servinglynk.hmis.warehouse.dao; 

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2020.QuestionEntity;

public interface QuestionDao {

   List<QuestionEntity> getAllQuestionEntities(String displayText, String description,Integer startIndex, Integer maxItems);
   long getQuestionEntitysCount(String displayText, String description);
   QuestionEntity getQuestionsHudId(String hudQuestionId);
}
