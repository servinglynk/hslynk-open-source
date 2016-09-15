/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcocDaoImpl extends ParentDaoImpl implements ProjectcocDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectcocDaoImpl.class);

	
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
		List<ProjectCoC> projectCoCs = domain.getExport().getProjectCoC();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Projectcoc.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		for(ProjectCoC projectCoc : projectCoCs)
		{
			Projectcoc model = null;
			try {
				model = getModelObject(domain, projectCoc,data,modelMap);
				model.setCoccode(projectCoc.getCoCCode());
				Project projectModel = (Project) getModel(Projectcoc.class.getSimpleName(),Project.class, projectCoc.getProjectID(),getProjectGroupCode(domain),true ,relatedModelMap, domain.getUpload().getId());
				model.setProjectid(projectModel);
				model.setExport(exportEntity);
				
				performSaveOrUpdate(model);
			} catch(Exception e) {
				String errorMessage = "Failure in Projectcoc:::"+projectCoc.toString()+ " with exception"+e.getLocalizedMessage();
				if (model != null) {
					Error2014 error = new Error2014();
					error.model_id = model.getId();
					error.bulk_upload_ui = domain.getUpload().getId();
					error.project_group_code = domain.getUpload().getProjectGroupCode();
					error.source_system_id = model.getSourceSystemId();
					error.type = ErrorType.ERROR;
					error.error_description = errorMessage;
					error.date_created = model.getDateCreated();
					performSave(error);
				}
				logger.error(errorMessage);
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, Projectcoc.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Projectcoc getModelObject(ExportDomain domain,ProjectCoC projectcoc ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Projectcoc modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Projectcoc) getModel(Projectcoc.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, projectcoc.getProjectCoCID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Projectcoc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Projectcoc model = new com.servinglynk.hmis.warehouse.model.v2014.Projectcoc();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(projectcoc.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,projectcoc.getProjectCoCID(),data);
		return model;
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
