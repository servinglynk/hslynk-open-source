package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.live.Enrollment;
import com.servinglynk.hmis.warehouse.model.live.SharingRuleEntity;

public class SharingRuleDaoImpl extends QueryExecutorImpl implements SharingRuleDao {
	
	
	
	public SharingRuleEntity insertSharingRule(SharingRuleEntity sharingRuleEntity){
			insert(sharingRuleEntity);
		return sharingRuleEntity;
	}

	@Override
	public SharingRuleEntity updateSharingRule(SharingRuleEntity sharingRuleEntity) {
			update(sharingRuleEntity);
		return sharingRuleEntity;
	}

	
	public SharingRuleEntity getSharingRuleId(UUID sharingRuleId){
		return (SharingRuleEntity) get(SharingRuleEntity.class,sharingRuleId);
	}
	
	@Override
	public void deleteSharingRule(SharingRuleEntity sharingRuleEntity) {
		delete(sharingRuleEntity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Enrollment> getSharedEnrollments(UUID roleId,UUID projectId,UUID organizationId){
		DetachedCriteria criteria = DetachedCriteria.forClass(SharingRuleEntity.class);
		
		criteria.createAlias("role", "role");
		criteria.createAlias("toOrganization", "toOrganization");
		criteria.createAlias("project", "project");
		
		Criterion roleCriterion = Restrictions.eq("role.id", roleId);
		Criterion orgCriterion = Restrictions.eq("toOrganization.id", organizationId);
		Criterion projectCriterion = Restrictions.eq("project.id", projectId);
		
		if(projectId!=null){
			criteria.add(Restrictions.or(projectCriterion));
		}
		
		if(roleId!=null){
			criteria.add(Restrictions.or(roleCriterion));
		}
		
		if(organizationId!=null){
			criteria.add(Restrictions.or(orgCriterion));
		}
		
		List<SharingRuleEntity> sharingRuleEntities = (List<SharingRuleEntity>) findByCriteria(criteria);
		
		List<Enrollment> enrollments = new ArrayList<Enrollment>();
		
		for(SharingRuleEntity sharingRuleEntity : sharingRuleEntities){
			enrollments.add(sharingRuleEntity.getEnrollment());
		}
		
		return enrollments;
	}

}