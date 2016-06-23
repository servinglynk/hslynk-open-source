/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
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

	@Autowired
	private ParentDaoFactory factory;
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<Project> projects = domain.getExport().getProject();
		hydrateBulkUploadActivityStaging(projects, com.servinglynk.hmis.warehouse.model.v2014.Project.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(projects !=null && projects.size() > 0)
		{
			
			for(Project project : projects)
			{
				com.servinglynk.hmis.warehouse.model.v2014.Project projectModel = new com.servinglynk.hmis.warehouse.model.v2014.Project();
				UUID id = UUID.randomUUID();
				projectModel.setId(id);
				//projectModel.setAffiliations(affiliation);
				projectModel.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
				//projectModel.setFunders(funder);
				domain.getAffiliationProjectMap().put(project.getProjectID(), id);
				domain.getProjectCocMap().put(project.getProjectID(), id);
				//projectModel.setProjectcocs(projectcoc);
				projectModel.setProjectname(project.getProjectName());
				Organization organization = (Organization)get(Organization.class, domain.getOrganizationProjectMap().get(project.getOrganizationID()));
				projectModel.setOrganizationid(organization);
				projectModel.setProjectcommonname(project.getProjectCommonName());
				projectModel.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
				projectModel.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
				projectModel.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
				projectModel.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
				projectModel.setDateCreated(LocalDateTime.now());
				projectModel.setDateUpdated(LocalDateTime.now());
				projectModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateCreated()));
				projectModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
				projectModel.setExport(exportEntity);
				exportEntity.addProject(projectModel);
				i++;
				hydrateCommonFields(projectModel, domain, project.getProjectID(),i);
			}
			}

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
