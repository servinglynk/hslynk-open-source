package com.servinglynk.hmis.warehouse.service; 

import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.core.model.Questions;
public interface QuestionService {

   Questions getAllQuestions(String displayText, Boolean includepicklist, String description,Integer startIndex, Integer maxItems) throws Exception ;

Question getQuestionsHudId(Boolean includepicklist, String hudQuestionId);
}
