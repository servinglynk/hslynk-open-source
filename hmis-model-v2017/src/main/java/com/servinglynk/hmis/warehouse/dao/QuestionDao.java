package com.servinglynk.hmis.warehouse.dao; 

import java.util.List;

import com.servinglynk.hmis.warehouse.model.v2017.QuestionEntity;

public interface QuestionDao {

   List<QuestionEntity> getAllQuestionEntities(Integer startIndex, Integer maxItems);
   long getQuestionEntitysCount();
   QuestionEntity getQuestionsHudId(String hudQuestionId);
}
