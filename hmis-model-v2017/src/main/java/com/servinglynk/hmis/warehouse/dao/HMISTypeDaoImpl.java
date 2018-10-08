package com.servinglynk.hmis.warehouse.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.servinglynk.hmis.warehouse.model.v2017.HMISTypeModel;

public class HMISTypeDaoImpl extends ParentDaoImpl implements HmisTypeDao {
	
	
	public List<HMISTypeModel> getDataElementTypes(){
		DetachedCriteria criteria = DetachedCriteria.forClass(HMISTypeModel.class);
		ProjectionList projectionList = Projections.projectionList();	
		projectionList.add(Projections.distinct(Projections.property("name")),"name");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(HMISTypeModel.class));
		return (List<HMISTypeModel>) findByCriteria(criteria);
	}

	public List<HMISTypeModel> getDataElements(String name){
		DetachedCriteria criteria = DetachedCriteria.forClass(HMISTypeModel.class);
		if(name!=null) criteria.add(Restrictions.eq("name", name).ignoreCase());
		criteria.addOrder(Order.asc("sortOrder"));
		return (List<HMISTypeModel>) findByCriteria(criteria);
	}
}