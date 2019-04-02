package com.servinglynk.hmis.warehouse.base.dao;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.model.base.SharingRuleEntity;

public class SharingRuleDaoImpl extends QueryExecutorImpl implements SharingRuleDao {

	
	public List<SharingRuleEntity> getSharingRules(UUID roleId,String toProjectGroup){
		DetachedCriteria criteria = DetachedCriteria.forClass(SharingRuleEntity.class);
//		criteria.createAlias("role","role");
		//if(roleId!=null) criteria.add(Restrictions.eq("role.id", roleId));
		criteria.add(Restrictions.eq("toProjectGroup", toProjectGroup));
		return (List<SharingRuleEntity>) getByCriteria(criteria);
	}

	@Override
	public List<UUID> getSharedEnrollments(List<UUID> projects, String schemaYear) {
			
		String query = "select id from "+schemaYear+".enrollment where deleted =false and  projectid in ('"+StringUtils.join(projects.toArray(), ',').replaceAll(",", "','")+"')";
		System.out.println(query);
		return findIdsByNativeQuery(query);
	}

	@Override
	public List<UUID> getSharedClients(List<UUID> enrollments, String schemaYear) {
		String query = "SELECT * FROM "+schemaYear+".client WHERE deleted = FALSE " + 
				"AND ID IN ( SELECT client_id FROM "+schemaYear+".enrollment WHERE ID in ('"+StringUtils.join(enrollments.toArray(), ',').replaceAll(",", "','")+"'))";
		System.out.println(query);
		return findIdsByNativeQuery(query);
	}

	@Override
	public SharingRuleEntity create(SharingRuleEntity entity) {
			entity.setId(UUID.randomUUID());
			insert(entity);
		return entity;
	}
}