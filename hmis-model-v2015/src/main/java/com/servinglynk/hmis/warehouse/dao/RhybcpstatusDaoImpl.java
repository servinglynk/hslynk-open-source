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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class RhybcpstatusDaoImpl extends ParentDaoImpl implements
		RhybcpstatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(RhybcpstatusDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<RHYBCPStatus> rhybcpStatusList = domain.getExport().getRHYBCPStatus();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class, getProjectGroupCode(domain));
		if(rhybcpStatusList !=null && !rhybcpStatusList.isEmpty())
		{
			for(RHYBCPStatus rhybcpStatus : rhybcpStatusList)
			{
				RhybcpStatus rhybcpstatusModel = null;
				try {
					
					rhybcpstatusModel = getModelObject(domain, rhybcpStatus,data,modelMap);
					rhybcpstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateCreated()));
					rhybcpstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateUpdated()));
					rhybcpstatusModel.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getFYSBYouth())));
					rhybcpstatusModel.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getReasonNoServices())));
					rhybcpstatusModel.setStatusDate(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getStatusDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, rhybcpStatus.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					rhybcpstatusModel.setEnrollmentid(enrollmentModel);
					rhybcpstatusModel.setExport(exportEntity);
					performSaveOrUpdate(rhybcpstatusModel);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the rhybcpStatus::"+rhybcpStatus.getRHYBCPStatusID() +" Exception ::"+e.getMessage();
					if(rhybcpstatusModel != null){
						Error2015 error = new Error2015();
						error.model_id = rhybcpstatusModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = rhybcpstatusModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = rhybcpstatusModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class.getSimpleName(), domain,exportEntity);
		}

	}

	public com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus getModelObject(ExportDomain domain, RHYBCPStatus rhybcpStatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpStatusModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			rhybcpStatusModel = (com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus) getModel(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class, rhybcpStatus.getRHYBCPStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(rhybcpStatusModel == null) {
			rhybcpStatusModel = new com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus();
			rhybcpStatusModel.setId(UUID.randomUUID());
			rhybcpStatusModel.setRecordToBeInserted(true);
			
		}else{
			++data.j;
		}
		hydrateCommonFields(rhybcpStatusModel, domain,rhybcpStatus.getRHYBCPStatusID(),data);
		return rhybcpStatusModel;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	   public com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus){
	       rhybcpstatus.setId(UUID.randomUUID()); 
	       insert(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus){
	       update(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus rhybcpstatus){
	       delete(rhybcpstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus getRhybcpstatusById(UUID rhybcpstatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus) get(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class, rhybcpstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentRhybcpstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
