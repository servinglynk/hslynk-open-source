/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Project;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ProjectContinuumprojectEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectProjecttypeEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectResidentialaffiliationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTargetpopulationEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectTrackingmethodEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
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
		if(projects !=null && projects.size() > 0)
		{
			
			for(Project project : projects)
			{
				com.servinglynk.hmis.warehouse.model.staging.Project projectModel = new com.servinglynk.hmis.warehouse.model.staging.Project();
				UUID id = UUID.randomUUID();
				projectModel.setId(id);
				//projectModel.setAffiliations(affiliation);
				projectModel.setContinuumproject(ProjectContinuumprojectEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getContinuumProject())));
				//projectModel.setFunders(funder);
				domain.getOrganizationProjectMap().put(BasicDataGenerator.getStringValue(project.getOrganizationID()),id);
				domain.getAffiliationProjectMap().put(project.getProjectID(), id);
				//projectModel.setProjectcocs(projectcoc);
				projectModel.setProjectname(project.getProjectName());
				projectModel.setProjectcommonname(project.getProjectCommonName());
				projectModel.setProjecttype(ProjectProjecttypeEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getProjectType())));
				projectModel.setResidentialaffiliation(ProjectResidentialaffiliationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getResidentialAffiliation())));
				projectModel.setTargetpopulation(ProjectTargetpopulationEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTargetPopulation())));
				projectModel.setTrackingmethod(ProjectTrackingmethodEnum.lookupEnum(BasicDataGenerator.getStringValue(project.getTrackingMethod())));
				projectModel.setDateCreated(BasicDataGenerator.getLocalDate(project.getDateCreated()));
				projectModel.setDateUpdated(BasicDataGenerator.getLocalDate(project.getDateUpdated()));
				if(project.getProjectID() !=null && !"".equals(project.getProjectID())) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(project.getProjectID()));
					projectModel.setEnrollmentid(enrollmentModel);	
				}
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				projectModel.setExport(exportEntity);
				exportEntity.addProject(projectModel);
				insertOrUpdate(projectModel);
			}
			factory.getOrganizationDao().hydrateStaging(domain);
			factory.getAffiliationDao().hydrateStaging(domain);
			factory.getFunderDao().hydrateStaging(domain);
			}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Project> projects = export.getProjects();
		if(projects != null && !projects.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Project project : projects) {
				if(project != null) {
					com.servinglynk.hmis.warehouse.model.live.Project target = new com.servinglynk.hmis.warehouse.model.live.Project();
					BeanUtils.copyProperties(project, target,getNonCollectionFields(target));
//					Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(project.getProjectID()));
//					projectModel.setEnrollmentid(enrollmentModel);
//					com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
//					projectModel.setExport(exportEntity);
//					exportEntity.addProject(projectModel);
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
	   public List<com.servinglynk.hmis.warehouse.model.live.Project> getAllProjects(UUID organizationId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return (List<com.servinglynk.hmis.warehouse.model.live.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(UUID organizationId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.live.Project.class);
	       criteria.createAlias("organizationid", "organizationid");
	       criteria.add(Restrictions.eq("organizationid.id", organizationId));
	       return countRows(criteria);
	   }
}
