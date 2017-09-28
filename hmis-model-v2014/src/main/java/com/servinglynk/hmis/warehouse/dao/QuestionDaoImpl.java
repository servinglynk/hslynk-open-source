package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.v2014.QuestionEntity;

public class QuestionDaoImpl extends QueryExecutorImpl implements QuestionDao {

	@SuppressWarnings("unchecked")
	public List<QuestionEntity> getAllQuestionEntities(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(QuestionEntity.class);

		return (List<QuestionEntity>) findByCriteria(criteria, startIndex, maxItems);
	}

	public long getQuestionEntitysCount() {
		DetachedCriteria criteria = DetachedCriteria.forClass(QuestionEntity.class);
		return countRows(criteria);
	}

	@Override
	public QuestionEntity getQuestionsHudId(String hudQuestionId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(QuestionEntity.class);
		criteria.add(Restrictions.eq("hudQuestionId", hudQuestionId));
		List<QuestionEntity> list = (List<QuestionEntity>) findByCriteria(criteria);
		if (!list.isEmpty())
			return list.get(0);
		return null;
	}
}