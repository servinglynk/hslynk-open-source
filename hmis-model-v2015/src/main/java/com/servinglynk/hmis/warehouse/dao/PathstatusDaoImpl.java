/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Pathstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PathstatusDaoImpl extends ParentDaoImpl implements PathstatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(PathstatusDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<PATHStatus> pathStatusList = domain.getExport().getPATHStatus();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class, getProjectGroupCode(domain));
		if(pathStatusList !=null && !pathStatusList.isEmpty())
		{
			for(PATHStatus pathStatus : pathStatusList)
			{
				Pathstatus pathstatusModel = null;
				try {
					pathstatusModel = getModelObject(domain, pathStatus,data,modelMap);
					pathstatusModel.setClientEnrolledInPath( new Long(BasicDataGenerator.getStringValue(pathStatus.getClientEnrolledInPATH())));
					pathstatusModel.setReasonNotEnrolled(PathstatusReasonnotenrolledEnum.lookupEnum(String.valueOf(pathStatus.getReasonNotEnrolled())));
					pathstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateCreated()));
					pathstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, pathStatus.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					pathstatusModel.setEnrollmentid(enrollmentModel);
					pathstatusModel.setExport(exportEntity);
					performSaveOrUpdate(pathstatusModel);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the pathStatus::"+pathStatus.getPathStatusID() +" Exception ::"+e.getMessage();
					if(pathstatusModel != null){
						Error2015 error = new Error2015();
						error.model_id = pathstatusModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = pathstatusModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = pathstatusModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class.getSimpleName(), domain,exportEntity);
		}
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus getModelObject(ExportDomain domain, PATHStatus pathstatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatusModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			pathstatusModel = (com.servinglynk.hmis.warehouse.model.v2015.Pathstatus) getModel(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class, pathstatus.getPathStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(pathstatusModel == null) {
			pathstatusModel = new com.servinglynk.hmis.warehouse.model.v2015.Pathstatus();
			pathstatusModel.setId(UUID.randomUUID());
			pathstatusModel.setRecordToBeInserted(true);
			
		}else{
			++data.j;
		}
		hydrateCommonFields(pathstatusModel, domain,pathstatus.getPathStatusID(),data);
		return pathstatusModel;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
	}
	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus createPathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       pathstatus.setId(UUID.randomUUID());
	       insert(pathstatus);
	       return pathstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus updatePathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       update(pathstatus);
	       return pathstatus;
	   }
	   public void deletePathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       delete(pathstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus getPathstatusById(UUID pathstatusId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Pathstatus) get(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class, pathstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Pathstatus> getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Pathstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentPathstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
