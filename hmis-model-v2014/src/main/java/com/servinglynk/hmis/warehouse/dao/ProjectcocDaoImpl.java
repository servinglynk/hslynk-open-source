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
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Project;
import com.servinglynk.hmis.warehouse.model.stagv2014.Projectcoc;
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
	@Transactional
	public void hydrateStaging(ExportDomain domain) {
		
		List<ProjectCoC> projectCoCs = domain.getExport().getProjectCoC();
		hydrateBulkUploadActivityStaging(projectCoCs, com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class.getSimpleName(), domain);
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
			com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
			projectcocModel.setExport(exportEntity);
			exportEntity.addProjectcoc(projectcocModel);
			hydrateCommonFields(projectcocModel, domain, String.valueOf(projectCoc.getProjectCoCID()));
			insertOrUpdate(projectcocModel);
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Projectcoc> projectcocs = export.getProjectcocs();
		hydrateBulkUploadActivity(projectcocs, com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class.getSimpleName(), export,id);
		if(projectcocs != null && !projectcocs.isEmpty()) {
			for(Projectcoc projectcoc : projectcocs) {
				if(projectcoc != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Projectcoc target = new com.servinglynk.hmis.warehouse.model.v2014.Projectcoc();
					BeanUtils.copyProperties(projectcoc, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class,projectcoc.getExport().getId());
					target.setExport(exportEntity);
					com.servinglynk.hmis.warehouse.model.v2014.Project projectEntity = (com.servinglynk.hmis.warehouse.model.v2014.Project) get(com.servinglynk.hmis.warehouse.model.v2014.Project.class,projectcoc.getProjectid().getId());
					target.setProjectid(projectEntity);
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insert(target);
				}
			}
		}
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
	
	   public com.servinglynk.hmis.warehouse.model.v2014.Project createProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       insert(project);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project updateProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project getProjectById(UUID projectId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Project) get(com.servinglynk.hmis.warehouse.model.v2014.Project.class, projectId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Project> getAllProjects(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       return countRows(criteria);
	   }

	   
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcoc createProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc){
	       projectcoc.setId(UUID.randomUUID()); 
	       insert(projectcoc);
	       return projectcoc;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcoc updateProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc){
	       update(projectcoc);
	       return projectcoc;
	   }
	   public void deleteProjectcoc(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc projectcoc){
	       delete(projectcoc);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcoc getProjectcocById(UUID projectcocId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Projectcoc) get(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, projectcocId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Projectcoc> getAllProjectProjectcocs(UUID projectId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Projectcoc>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectProjectcocsCount(UUID projectId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class);
	       criteria.createAlias("projectid", "projectid");
	       criteria.add(Restrictions.eq("projectid.id", projectId));
	       return countRows(criteria);
	   }
}
