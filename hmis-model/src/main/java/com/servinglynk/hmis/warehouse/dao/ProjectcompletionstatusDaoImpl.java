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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Exit;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.model.stagv2014.Projectcompletionstatus;
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
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				projectcompletionstatusModel.setExport(exportEntity);
				exportEntity.addProjectcompletionstatus(projectcompletionstatusModel);
				hydrateCommonFields(projectcompletionstatusModel, domain);
				insertOrUpdate(projectcompletionstatusModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Projectcompletionstatus> projectcompletionstatuses = export.getProjectcompletionstatuses();
		if(projectcompletionstatuses != null && !projectcompletionstatuses.isEmpty()) {
			for(Projectcompletionstatus projectcompletionstatus : projectcompletionstatuses) {
				if(projectcompletionstatus != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus target = new com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus();
					BeanUtils.copyProperties(projectcompletionstatus, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Exit exitModel = (com.servinglynk.hmis.warehouse.model.v2014.Exit) get(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, projectcompletionstatus.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addProjectcompletionstatus(target);
					 target.setDateCreated(LocalDateTime.now());
					 target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
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
	       criteria.add(Restrictions.eq("enrollmentid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitProjectCompletionStatusesCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("enrollmentid.id", exitId));
	       return countRows(criteria);
	   }
}
