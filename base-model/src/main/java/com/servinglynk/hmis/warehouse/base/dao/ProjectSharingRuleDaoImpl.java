package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.ProjectSharingRuleEntity;

public class ProjectSharingRuleDaoImpl extends QueryExecutorImpl implements ProjectSharingRuleDao {

	public ProjectSharingRuleEntity createSharingRule(ProjectSharingRuleEntity entity) {
		entity.setId(UUID.randomUUID());
		insert(entity);
		return entity;
	}
	
	public void updateSharingRule(ProjectSharingRuleEntity entity) {
		update(entity);
	}
	
	
	public void deleteSharingRule(ProjectSharingRuleEntity entity) {
		delete(entity);
	}
	
	
	public ProjectSharingRuleEntity getBySharingRuleId(UUID sharingRuleId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSharingRuleEntity.class);
		criteria.add(Restrictions.eq("id",sharingRuleId));
		List<ProjectSharingRuleEntity> sharingRuleEntities = (List<ProjectSharingRuleEntity>) findByCriteria(criteria);
		if(sharingRuleEntities.isEmpty()) return null;
		return sharingRuleEntities.get(0);
	}
	
	public List<ProjectSharingRuleEntity> getSharingRules() {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSharingRuleEntity.class);
		return (List<ProjectSharingRuleEntity>) findByCriteria(criteria);
	}

	@Override
	public List<UUID> getSharedClients(UUID accountId, String projectGroupCode) {
		String queryString = "select * from base.get_shared_clients('"+accountId+"','"+projectGroupCode+"')";
		  org.hibernate.Query query = getCurrentSession().createSQLQuery(queryString)
				  .addScalar("rclientIds",org.hibernate.type.PostgresUUIDType.INSTANCE);
		  
		  return query.list();
	}
	
	public List<UUID> getSharedEnrollemnts(UUID accountId, String projectGroupCode) {
		String queryString = "select * from base.get_shared_enrollments('"+accountId+"','"+projectGroupCode+"')";
		  org.hibernate.Query query = getCurrentSession().createSQLQuery(queryString)
				  .addScalar("rclientIds",org.hibernate.type.PostgresUUIDType.INSTANCE);
		  
		  return query.list();
	}

	@Override
	public List<ProjectSharingRuleEntity> getSharingRules(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectSharingRuleEntity.class);
		return (List<ProjectSharingRuleEntity>) findByCriteria(criteria, startIndex,maxItems);
	}
	
}
