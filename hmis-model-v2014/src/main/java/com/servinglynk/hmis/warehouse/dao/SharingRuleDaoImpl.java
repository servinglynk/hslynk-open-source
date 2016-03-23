package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.base.dao.QueryExecutorImpl;
import com.servinglynk.hmis.warehouse.model.base.RoleEntity;
import com.servinglynk.hmis.warehouse.model.base.UserRoleMapEntity;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.SharingRuleEntity;

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
	
	@SuppressWarnings({ "unchecked" })
	public List<Enrollment> getSharedEnrollments(UUID userId,UUID organizationId){
		
		DetachedCriteria roleCriteria = DetachedCriteria.forClass(UserRoleMapEntity.class);
		roleCriteria.createAlias("accountEntity", "user");
		roleCriteria.add(Restrictions.eq("user.id", userId));
		List<RoleEntity> roles = (List<RoleEntity>) findByCriteria(roleCriteria);
		
	
		DetachedCriteria criteria = DetachedCriteria.forClass(SharingRuleEntity.class);
		criteria.createAlias("toOrganization", "toOrganization");
		criteria.createAlias("project", "project");
		criteria.add(Restrictions.in("role", roles));
		

		Criterion orgCriterion = Restrictions.eq("toOrganization.id", organizationId);
				
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