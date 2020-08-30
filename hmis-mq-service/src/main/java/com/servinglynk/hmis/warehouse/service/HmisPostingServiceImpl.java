package com.servinglynk.hmis.warehouse.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.servinglynk.hmis.warehouse.model.HmisPostingModel;
import com.servinglynk.hmis.warehouse.model.QuestionResponseModel;
import com.servinglynk.hmis.warehouse.model.SessionModel;

@Service
public class HmisPostingServiceImpl implements HmisPostingService {

	@Override
	public void postHmis(HmisPostingModel hmisPostingModel, SessionModel session) {
			if(hmisPostingModel != null) {
				List<QuestionResponseModel> questionResponses = hmisPostingModel.getQuestionResponses();
				if(!CollectionUtils.isEmpty(questionResponses)) {
					for( QuestionResponseModel questionResponseModel : questionResponses) {
						System.out.println(questionResponseModel.getQuestionId());
					}
				}
			}
	}

}
