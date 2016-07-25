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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus;
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
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(rhybcpStatusList !=null && !rhybcpStatusList.isEmpty())
		{
			for(RHYBCPStatus rhybcpStatus : rhybcpStatusList)
			{
				Rhybcpstatus rhybcpstatusModel = null;
				try {
					rhybcpstatusModel = getModelObject(domain, rhybcpStatus,data,modelMap);
					rhybcpstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateCreated()));
					rhybcpstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateUpdated()));
					rhybcpstatusModel.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getFYSBYouth())));
					rhybcpstatusModel.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getReasonNoServices())));
					rhybcpstatusModel.setStatusDate(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getStatusDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,rhybcpStatus.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					rhybcpstatusModel.setEnrollmentid(enrollmentModel);
					rhybcpstatusModel.setExport(exportEntity);
					performSaveOrUpdate(rhybcpstatusModel);
				} catch(Exception e) {
					String errorMessage = "Failure in Rhybcpstatus:::"+rhybcpStatus.toString()+ " with exception"+e.getLocalizedMessage();
					if (rhybcpstatusModel != null) {
						Error2014 error = new Error2014();
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
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class.getSimpleName(), domain,exportEntity);

	}
	public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus getModelObject(ExportDomain domain,RHYBCPStatus rhybcpstatus ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatusModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			rhybcpstatusModel = (com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus) getModel(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class, rhybcpstatus.getRHYBCPStatusID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(rhybcpstatusModel == null) {
			rhybcpstatusModel = new com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus();
			rhybcpstatusModel.setId(UUID.randomUUID());
			rhybcpstatusModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(rhybcpstatusModel, domain,rhybcpstatus.getRHYBCPStatusID(),data.i+data.j);
		return rhybcpstatusModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       rhybcpstatus.setId(UUID.randomUUID()); 
	       insert(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       update(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       delete(rhybcpstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus) get(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class, rhybcpstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentRhybcpstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
