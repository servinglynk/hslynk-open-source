/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.base.HmisUser;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Organization;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectDaoImpl extends ParentDaoImpl implements ProjectDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Project> projects = domain.getExport().getProject();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Project.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Project.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(projects !=null && projects.size() > 0)
		{
			for(Project project : projects)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Project model = null;
				try {
					model = getModelObject(domain, project,data,modelMap);
					//projectModel.setAffiliations(affiliation);
					model.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
					model.setProjectname(project.getProjectName());
					Organization organization = (Organization)getModel(Project.class.getSimpleName(),Organization.class, project.getOrganizationID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setOrganizationid(organization);
					model.setProjectcommonname(project.getProjectCommonName());
					model.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
					model.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
					model.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
					model.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
					model.setExport(exportEntity);
					if(model.isRecordToBoInserted()) {
						com.servinglynk.hmis.warehouse.model.base.Project baseProject = new com.servinglynk.hmis.warehouse.model.base.Project();
						BeanUtils.copyProperties(model, baseProject, new String[] {"organizationid"});
						baseProject.setSchemaYear(2014);
						factory.getBaseProjectDao().createProject(baseProject);
					}
					
					performSaveOrUpdate(model);
				} catch(Exception e) {
					String errorMessage = "Failure in Project:::"+project.toString()+ " with exception"+e.getLocalizedMessage();
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
			}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Project.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Project getModelObject(ExportDomain domain,Project project ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Project modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Project) getModel(Project.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Project.class, project.getProjectID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Project();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Project model = new com.servinglynk.hmis.warehouse.model.v2014.Project();
		  org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,project.getProjectID(),data);
		return model;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Project createProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
		   project.setId(UUID.randomUUID());
			com.servinglynk.hmis.warehouse.model.base.Project baseProject = new com.servinglynk.hmis.warehouse.model.base.Project();
			BeanUtils.copyProperties(project, baseProject, new String[] {"organizationid"});
			baseProject.setSchemaYear(2014);
			insert(project);
			factory.getBaseProjectDao().createProject(baseProject);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project updateProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
		   com.servinglynk.hmis.warehouse.model.base.Project baseProject = new com.servinglynk.hmis.warehouse.model.base.Project();
			BeanUtils.copyProperties(project, baseProject, new String[] {"organizationid"});
			baseProject.setSchemaYear(2014);
			update(project);
			factory.getBaseProjectDao().updateProject(baseProject);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Project getProjectById(UUID projectId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
		      criteria.add(Restrictions.eq("id", projectId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Project> projects = (List<com.servinglynk.hmis.warehouse.model.v2014.Project>) findByCriteria(criteria);
		      if(!projects.isEmpty()) return projects.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Project> getAllProjects(String projectGroupCode,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(String projectGroupCode){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
	       return countRows(criteria);
	   }
	   
	   /***
		 * populates User Id and project group code.
		 * @param className
		 * @param projectGroupCode
		 * @return
		 */
		public void populateUserProjectGroupCode(HmisBaseModel model,String caller) {
			if(model != null && caller != null) {
				HmisUser user = parentDaoFactory.getHmisUserDao().findByUsername(caller);
				if(user != null) {
					model.setUserId(user.getId());
					ProjectGroupEntity projectGroupEntity = user.getProjectGroupEntity();
					if(projectGroupEntity != null) {
						model.setProjectGroupCode(projectGroupEntity.getProjectGroupCode());
					}
				}
			}
				
		}
}
