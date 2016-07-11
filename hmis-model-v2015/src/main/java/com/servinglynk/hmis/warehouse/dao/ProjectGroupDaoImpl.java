package com.servinglynk.hmis.warehouse.dao;


import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
import com.servinglynk.hmis.warehouse.model.v2015.ProjectProjectGroupMapEntity;

public class ProjectGroupDaoImpl extends ParentDaoImpl implements ProjectGroupDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectGroupDaoImpl.class);
	@Override
	public ProjectGroupEntity createProjectGroup(ProjectGroupEntity projectGroupEntity) {
			insert(projectGroupEntity);
		return projectGroupEntity;
	}

	@Override
	public ProjectGroupEntity updateProjectGroup(ProjectGroupEntity projectGroupEntity) {
		update(projectGroupEntity);
		return projectGroupEntity;
	}

	@Override
	public void deleteProjectGroup(ProjectGroupEntity projectGroupEntity) {
		delete(projectGroupEntity);
	}

	@Override
	public ProjectGroupEntity getProjectGroupById(UUID projectGroupId){
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectGroupEntity.class);
		criteria.add(Restrictions.eq("id",projectGroupId));
		java.util.List<ProjectGroupEntity> projectGroupEntities = (java.util.List<ProjectGroupEntity>) findByCriteria(criteria);
		if(projectGroupEntities.size()>0) return projectGroupEntities.get(0);
		return null;

	}


	@Override
	public ProjectGroupEntity getProjectGroupByGroupCode(String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ProjectGroupEntity.class);
		criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode));
		java.util.List<ProjectGroupEntity> projectGroupEntities = (java.util.List<ProjectGroupEntity>) findByCriteria(criteria);
		if(projectGroupEntities.size()>0) return projectGroupEntities.get(0);
		return null;
	}

	@Override
	public ProjectProjectGroupMapEntity addProjectToProjectGroup(ProjectProjectGroupMapEntity projectGroupMapEntity) {
				insert(projectGroupMapEntity);
		return projectGroupMapEntity;
	}

	@Override
	public ProjectProjectGroupMapEntity deleteProjectToProjectGroup(
			ProjectProjectGroupMapEntity projectGroupMapEntity) {
		// TODO Auto-generated method stub
		return null;
	}


	public void deleteProjectGroupMap(ProjectProjectGroupMapEntity entity){
		delete(entity);
	}


	   public long getProjectGroupCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity.class);
	       return countRows(criteria);
	   }

	   public List<com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity> getAllProjectGroups(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity.class);
	       return (List<com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity>) findByCriteria(criteria,startIndex,maxItems);
	   }

	@Override
	public void hydrateStaging(ExportDomain domain) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
}
