package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason;

public class VASHExitReasonDaoImpl extends ParentDaoImpl implements VASHExitReasonDao{
	

	
	private static final Logger logger = LoggerFactory.getLogger(VASHExitReasonDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		 List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason> vashExitReasons = domain.getExport().getVashExitReason();
		 com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		 Data data =new Data();
		 Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class, getProjectGroupCode(domain));
		 if(vashExitReasons != null && !vashExitReasons.isEmpty())
		 {
			 for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason vashExitReason : vashExitReasons)
			 {
				 com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReasonModel = null;
				 try {
					 vashExitReasonModel = getModelObject(domain, vashExitReasonModel,data,modelMap);
					 vashExitReasonModel.setExitId(vashExitReason.getExitId());
					 vashExitReasonModel.setCmExitReason(vashExitReason.getCmExitReason());
					 performSaveOrUpdate(vashExitReasonModel);
				 } catch(Exception e){
					 String errorMessage = "Exception because of the vashExitReasons::"+vashExitReason.getId() +" Exception ::"+e.getMessage();
					 if(vashExitReasonModel != null){
						 Error2017 error = new Error2017();
						 error.model_id = vashExitReasonModel.getId();
						 error.bulk_upload_ui = domain.getUpload().getId();
						 error.project_group_code = domain.getUpload().getProjectGroupCode();
						 error.source_system_id = vashExitReasonModel.getSourceSystemId();
						 error.type = ErrorType.ERROR;
						 error.error_description = errorMessage;
						 error.date_created = vashExitReasonModel.getDateCreated();
						 performSave(error);
					 }
					 logger.error(errorMessage);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason getModelObject(ExportDomain domain, VASHExitReason vashExitReasonModel ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason) getModel(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class, vashExitReasonModel.getId(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason model = new com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(vashExitReasonModel.getCmExitReason());
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,vashExitReasonModel.getId(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason createVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason){
		   vashExitReason.setId(UUID.randomUUID());
	       insert(vashExitReason);
	       VASHExitReasonEntity entity = new VASHExitReasonEntity();
	       BeanUtils.copyProperties(vashExitReason, entity);
	       insert(entity);
	       return vashExitReason;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason updateVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason){
	       update(vashExitReason);
	       return vashExitReason;
	   }
	   public void deleteVASHExitReason(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason vashExitReason){
	       delete(vashExitReason);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason getVASHExitReasonById(UUID vashExitReasonId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class);
		      criteria.add(Restrictions.eq("id", vashExitReasonId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason> getAllVASHExitReason(String exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class);
	       criteria.add(Restrictions.eq("exitId", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getVASHExitReasonCount(String exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VASHExitReason.class);
	       criteria.add(Restrictions.eq("exitId", exitId));
	       return countRows(criteria);
	   }

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


}
