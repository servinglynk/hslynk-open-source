/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcompletionstatusDaoImpl extends ParentDaoImpl implements
		ProjectcompletionstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ProjectCompletionStatus> projectCompletionStatusList = domain.getExport().getProjectCompletionStatus();
		hydrateBulkUploadActivityStaging(projectCompletionStatusList, com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(projectCompletionStatusList !=null && !projectCompletionStatusList.isEmpty()) 
		{
			for(ProjectCompletionStatus projectCompletionStatus : projectCompletionStatusList)
			{
				Projectcompletionstatus projectcompletionstatusModel = new Projectcompletionstatus();
				projectcompletionstatusModel.setId(UUID.randomUUID());
				projectcompletionstatusModel.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getEarlyExitReason())));
				projectcompletionstatusModel.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getProjectCompletionStatus())));
				projectcompletionstatusModel.setDateCreated(LocalDateTime.now());
				projectcompletionstatusModel.setDateUpdated(LocalDateTime.now());
				projectcompletionstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateCreated()));
				projectcompletionstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateUpdated()));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(projectCompletionStatus.getExitID()));
				projectcompletionstatusModel.setExitid(exit);
				projectcompletionstatusModel.setExport(exportEntity);
				exportEntity.addProjectcompletionstatus(projectcompletionstatusModel);
				i++;
				hydrateCommonFields(projectcompletionstatusModel, domain, projectCompletionStatus.getProjectCompletionStatusID(),i);
			}
		}
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus createProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       projectCompletionStatus.setId(UUID.randomUUID()); 
	       insert(projectCompletionStatus);
	       return projectCompletionStatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus updateProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       update(projectCompletionStatus);
	       return projectCompletionStatus;
	   }
	   public void deleteProjectCompletionStatus(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectCompletionStatus){
	       delete(projectCompletionStatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus getProjectCompletionStatusById(UUID projectCompletionStatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus) get(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class, projectCompletionStatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus> getAllExitProjectCompletionStatuses(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitProjectCompletionStatusesCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
