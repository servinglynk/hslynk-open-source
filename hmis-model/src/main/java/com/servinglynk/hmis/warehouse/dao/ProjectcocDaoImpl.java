/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Project;
import com.servinglynk.hmis.warehouse.model.staging.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcocDaoImpl extends ParentDaoImpl implements ProjectcocDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		
		List<ProjectCoC> projectCoCs = domain.getExport().getProjectCoC();
		for(ProjectCoC projectCoc : projectCoCs)
		{
			UUID id = UUID.randomUUID();
			Projectcoc projectcocModel = new Projectcoc();
			projectcocModel.setId(id);
			projectcocModel.setCoccode(projectCoc.getCoCCode());
			projectcocModel.setDateCreated(BasicDataGenerator.getLocalDateTime(projectCoc.getDateCreated()));
			projectcocModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(projectCoc.getDateUpdated()));
			if(projectCoc.getProjectID()!=null && !"".equals(projectCoc.getProjectID())) {
				UUID uuid = domain.getProjectCocMap().get(projectCoc.getProjectID());
				if(uuid !=null) {
					Project projectModel = (Project) get(Project.class, uuid);
					projectcocModel.setProjectid(projectModel);
					domain.getProjectCocMap().put(String.valueOf(projectCoc.getProjectCoCID()), id);
				}
			}
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
			projectcocModel.setExport(exportEntity);
			exportEntity.addProjectcoc(projectcocModel);
			insertOrUpdate(projectcocModel);
		}
		factory.getInventoryDao().hydrateStaging(domain);
		factory.getSiteDao().hydrateStaging(domain);
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Projectcoc> projectcocs = export.getProjectcocs();
		if(projectcocs != null && !projectcocs.isEmpty()) {
			for(Projectcoc projectcoc : projectcocs) {
				if(projectcoc != null) {
					com.servinglynk.hmis.warehouse.model.live.Projectcoc target = new com.servinglynk.hmis.warehouse.model.live.Projectcoc();
					BeanUtils.copyProperties(projectcoc, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class,projectcoc.getExport().getId());
					target.setExport(exportEntity);
					com.servinglynk.hmis.warehouse.model.live.Project projectEntity = (com.servinglynk.hmis.warehouse.model.live.Project) get(com.servinglynk.hmis.warehouse.model.live.Project.class,projectcoc.getProjectid().getId());
					target.setProjectid(projectEntity);
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insert(target);
				}
			}
		}
		factory.getInventoryDao().hydrateLive(export);
		factory.getSiteDao().hydrateLive(export);
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
	   public com.servinglynk.hmis.warehouse.model.live.Project createProject(com.servinglynk.hmis.warehouse.model.live.Project project){
	       insert(project);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Project updateProject(com.servinglynk.hmis.warehouse.model.live.Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.live.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Project getProjectById(UUID projectId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Project) get(com.servinglynk.hmis.warehouse.model.live.Project.class, projectId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Project> getAllProjects(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Project.class);
	       return (List<com.servinglynk.hmis.warehouse.model.live.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Project.class);
	       return countRows(criteria);
	   }

	   
	   public com.servinglynk.hmis.warehouse.model.live.Projectcoc createProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc){
	       projectcoc.setId(UUID.randomUUID()); 
	       insert(projectcoc);
	       return projectcoc;
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Projectcoc updateProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc){
	       update(projectcoc);
	       return projectcoc;
	   }
	   public void deleteProjectcoc(com.servinglynk.hmis.warehouse.model.live.Projectcoc projectcoc){
	       delete(projectcoc);
	   }
	   public com.servinglynk.hmis.warehouse.model.live.Projectcoc getProjectcocById(UUID projectcocId){ 
	       return (com.servinglynk.hmis.warehouse.model.live.Projectcoc) get(com.servinglynk.hmis.warehouse.model.live.Projectcoc.class, projectcocId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.live.Projectcoc> getAllProjectProjectcocs(UUID projectId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Projectcoc.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Projectcoc>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectProjectcocsCount(UUID projectId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Projectcoc.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return countRows(criteria);
	   }
}
