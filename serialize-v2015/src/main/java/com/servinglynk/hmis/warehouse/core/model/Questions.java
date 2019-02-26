package com.servinglynk.hmis.warehouse.core.model; 

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.servinglynk.hmis.warehouse.PaginatedModel;

@JsonRootName("questions")
public class Questions extends PaginatedModel{


       @JsonProperty("questions") 
       List<Question>questions = new ArrayList<Question>();
       public List<Question> getQuestions() {
           return questions;
       }

        public void setQuestions(List<Question> questions) {
           this.questions = questions;
       }
 
       public void addQuestion(Question question) {
           this.questions.add(question);
       }
 }
