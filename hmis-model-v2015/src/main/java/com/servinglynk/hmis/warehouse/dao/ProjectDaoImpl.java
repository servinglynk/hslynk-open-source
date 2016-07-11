/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Organization;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Export;
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
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if(projects !=null && projects.size() > 0)
		{
			for(Project project : projects)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2015.Project projectModel = getModelObject(domain, project, data);
					//projectModel.setAffiliations(affiliation);
					projectModel.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
					Organization organization = (Organization) getModel(Organization.class, project.getOrganizationID(),getProjectGroupCode(domain),true);
					projectModel.setOrganizationid(organization);
					projectModel.setProjectname(project.getProjectName());
					projectModel.setProjectcommonname(project.getProjectCommonName());
					projectModel.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
					//projectModel.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
					projectModel.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
					projectModel.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
					projectModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateCreated()));
					projectModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(project.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, project.getProjectID(),getProjectGroupCode(domain),true);
					projectModel.addEnrollment(enrollmentModel);
					projectModel.setExport(exportEntity);
					exportEntity.addProject(projectModel);
					performSaveOrUpdate(projectModel);
				}catch(Exception e) {
					logger.error("Exception beause of the project::"+project.getProjectID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Project.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Project getModelObject(ExportDomain domain, Project Project ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Project projectModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			projectModel = (com.servinglynk.hmis.warehouse.model.v2015.Project) getModel(com.servinglynk.hmis.warehouse.model.v2015.Project.class, Project.getProjectID(), getProjectGroupCode(domain),false);
		
		if(projectModel == null) {
			projectModel = new com.servinglynk.hmis.warehouse.model.v2015.Project();
			projectModel.setId(UUID.randomUUID());
			projectModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(projectModel, domain,Project.getProjectID(),data.i+data.j);
		return projectModel;
	}
	

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Project createProject(com.servinglynk.hmis.warehouse.model.v2015.Project project){
		   project.setId(UUID.randomUUID());
	       insert(project);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Project updateProject(com.servinglynk.hmis.warehouse.model.v2015.Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.v2015.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Project getProjectById(UUID projectId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Project) get(com.servinglynk.hmis.warehouse.model.v2015.Project.class, projectId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(UUID organizationId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return countRows(criteria);
	   }
}
