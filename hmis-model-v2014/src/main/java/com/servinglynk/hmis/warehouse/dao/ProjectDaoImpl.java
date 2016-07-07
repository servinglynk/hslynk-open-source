/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
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
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<Project> projects = domain.getExport().getProject();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(projects !=null && projects.size() > 0)
		{
			for(Project project : projects)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2014.Project projectModel = getModelObject(domain, project,data);
					//projectModel.setAffiliations(affiliation);
					projectModel.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
					projectModel.setProjectname(project.getProjectName());
					Organization organization = (Organization)getModel(Organization.class, project.getOrganizationID(),getProjectGroupCode(domain));
					projectModel.setOrganizationid(organization);
					projectModel.setProjectcommonname(project.getProjectCommonName());
					projectModel.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
					projectModel.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
					projectModel.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
					projectModel.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
					projectModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateCreated()));
					projectModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
					projectModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addProject(projectModel);
					performSaveOrUpdate(projectModel);
				} catch(Exception e) {
					logger.error("Failure in Project:::"+project.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
    		  }
			}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Project.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Project getModelObject(ExportDomain domain,Project project ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Project projectModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			projectModel = (com.servinglynk.hmis.warehouse.model.v2014.Project) getModel(com.servinglynk.hmis.warehouse.model.v2014.Project.class, project.getProjectID(), getProjectGroupCode(domain));
		
		if(projectModel == null) {
			projectModel = new com.servinglynk.hmis.warehouse.model.v2014.Project();
			projectModel.setId(UUID.randomUUID());
			projectModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(projectModel, domain,project.getProjectID(),data.i+data.j);
		return projectModel;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Project createProject(com.servinglynk.hmis.warehouse.model.v2014.Project project){
		   project.setId(UUID.randomUUID());
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
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(UUID organizationId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return countRows(criteria);
	   }
}
