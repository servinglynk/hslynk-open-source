package com.servinglynk.hmis.warehouse.service; 

import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.core.model.Questions;
public interface QuestionService {

   Questions getAllQuestions(String displayText, String description,Integer startIndex, Integer maxItems);

Question getQuestionsHudId(String hudQuestionId);
}
