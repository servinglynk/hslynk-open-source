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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCompletionStatus;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusEarlyexitreasonEnum;
import com.servinglynk.hmis.warehouse.enums.ProjectcompletionstatusProjectcompletionstatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ProjectcompletionstatusDaoImpl extends ParentDaoImpl implements
		ProjectcompletionstatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ProjectcompletionstatusDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ProjectCompletionStatus> projectCompletionStatusList = domain.getExport().getProjectCompletionStatus();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Projectcompletionstatus.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(projectCompletionStatusList !=null && !projectCompletionStatusList.isEmpty()) 
		{
			for(ProjectCompletionStatus projectCompletionStatus : projectCompletionStatusList)
			{
				Projectcompletionstatus projectcompletionstatusModel = null;
				try {
					projectcompletionstatusModel = getModelObject(domain, projectCompletionStatus,data,modelMap);
					projectcompletionstatusModel.setId(UUID.randomUUID());
					projectcompletionstatusModel.setEarlyexitreason(ProjectcompletionstatusEarlyexitreasonEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getEarlyExitReason())));
					projectcompletionstatusModel.setProjectcompletionstatus(ProjectcompletionstatusProjectcompletionstatusEnum.lookupEnum(BasicDataGenerator.getStringValue(projectCompletionStatus.getProjectCompletionStatus())));
					projectcompletionstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateCreated()));
					projectcompletionstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(projectCompletionStatus.getDateUpdated()));
					Exit exit = (Exit) getModel(Projectcompletionstatus.class.getSimpleName(),Exit.class, projectCompletionStatus.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					projectcompletionstatusModel.setExitid(exit);
					projectcompletionstatusModel.setExport(exportEntity);
					performSaveOrUpdate(projectcompletionstatusModel);
				} catch(Exception e) {
					 String errorMessage = "Failure in Projectcompletionstatus:::"+projectCompletionStatus.toString()+ " with exception"+e.getLocalizedMessage();
					if (projectcompletionstatusModel != null) {
						Error2014 error = new Error2014();
						error.model_id = projectcompletionstatusModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = projectcompletionstatusModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = projectcompletionstatusModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class.getSimpleName(), domain,exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus getModelObject(ExportDomain domain,ProjectCompletionStatus projectcompletionstatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus projectcompletionstatusModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			projectcompletionstatusModel = (com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus) getModel(Projectcompletionstatus.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus.class, projectcompletionstatus.getProjectCompletionStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(projectcompletionstatusModel == null) {
			projectcompletionstatusModel = new com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus();
			projectcompletionstatusModel.setId(UUID.randomUUID());
			projectcompletionstatusModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(projectcompletionstatusModel, domain,projectcompletionstatus.getProjectCompletionStatusID(),data.i+data.j);
		return projectcompletionstatusModel;
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
