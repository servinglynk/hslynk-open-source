package com.servinglynk.hmis.warehouse.rest; 

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.servinglynk.hmis.warehouse.annotations.APIMapping;
import com.servinglynk.hmis.warehouse.core.model.Question;
import com.servinglynk.hmis.warehouse.core.model.Questions;

@RestController
@RequestMapping
public class QuestionsController extends ControllerBase { 


   @RequestMapping(method=RequestMethod.GET,value="/questions")
   @APIMapping(value="SURVEY_API_GET_ALL_QUESTION",checkTrustedApp=true,checkSessionToken=true)
   public Questions getAllQuestions(@RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
              			@RequestParam(value="text",required=false) String displayText,
            			@RequestParam(value="name",required=false) String description,
            			@RequestParam(value="includepicklist",required=false,defaultValue="false") Boolean includepicklist,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null || maxItems > 200) maxItems =200;
        return serviceFactory.getQuestionService().getAllQuestions(displayText,includepicklist,description,startIndex,maxItems); 
   }
   
   @RequestMapping(method=RequestMethod.GET,value="/questions/{hudQuestionId:.+}")
   @APIMapping(value="SURVEY_API_GET_ALL_QUESTION",checkTrustedApp=true,checkSessionToken=true)
   public Question getQuestionsHudId(
                       @PathVariable(value="hudQuestionId") String hudQuestionId,
                       @RequestParam(value="includepicklist",required=false,defaultValue="false") Boolean includepicklist,
                       HttpServletRequest request) throws Exception {
        return serviceFactory.getQuestionService().getQuestionsHudId(includepicklist,hudQuestionId); 
   }
   
   @RequestMapping(method=RequestMethod.GET,value="/v2/questions")
   @APIMapping(value="SURVEY_API_GET_ALL_QUESTION",checkTrustedApp=true,checkSessionToken=true)
   public Questions getAllQuestionsV2(@RequestParam(value="startIndex", required=false) Integer startIndex, 
                       @RequestParam(value="maxItems", required=false) Integer maxItems,
              			@RequestParam(value="text",required=false) String displayText,
            			@RequestParam(value="name",required=false) String description,
            			@RequestParam(value="includepicklist",required=false,defaultValue="false") Boolean includepicklist,
                       HttpServletRequest request) throws Exception {
           if (startIndex == null) startIndex =0;
           if (maxItems == null || maxItems > 200) maxItems =200;
        return serviceFactory.getQuestionService().getAllQuestionsV2(displayText,includepicklist,description,startIndex,maxItems); 
   }
   
   @RequestMapping(method=RequestMethod.GET,value="/v2/questions/{hudQuestionId:.+}")
   @APIMapping(value="SURVEY_API_GET_ALL_QUESTION",checkTrustedApp=true,checkSessionToken=true)
   public Question getQuestionsHudIdV2(
                       @PathVariable(value="hudQuestionId") String hudQuestionId,
                       @RequestParam(value="includepicklist",required=false,defaultValue="false") Boolean includepicklist,
                       HttpServletRequest request) throws Exception {
        return serviceFactory.getQuestionService().getQuestionsHudIdV2(includepicklist,hudQuestionId); 
   }

}

