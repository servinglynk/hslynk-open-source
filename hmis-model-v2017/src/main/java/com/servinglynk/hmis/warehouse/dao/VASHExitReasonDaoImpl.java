/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.CMExitReasonEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.VashExitReason;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;


/**
 * @author Sandeep
 *
 */
public class VASHExitReasonDaoImpl extends ParentDaoImpl implements VASHExitReasonDao {
	private static final Logger logger = LoggerFactory.getLogger(VASHExitReasonDaoImpl.class);
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason> expVASHExitReasons= domain.getExport().getVashExitReason();
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class, getProjectGroupCode(domain));
		if(expVASHExitReasons !=null && !expVASHExitReasons.isEmpty())
		{
				for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason expVASHExitReason : expVASHExitReasons)
				{
					com.servinglynk.hmis.warehouse.model.v2017.VashExitReason vashExitReasonModel = null;
					try {
						vashExitReasonModel = getModelObject(domain, expVASHExitReason, data, modelMap);
						vashExitReasonModel.setCmExitReason(CMExitReasonEnum.lookupEnum(expVASHExitReason.getCmExitReason()));
						com.servinglynk.hmis.warehouse.model.v2017.Exit exit = (com.servinglynk.hmis.warehouse.model.v2017.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2017.Exit.class,expVASHExitReason.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						vashExitReasonModel.setExitid(exit);
						performSaveOrUpdate(vashExitReasonModel);
					}catch(Exception e ){
						String errorMessage = "Exception beause of the VASHExitReasons ::"+expVASHExitReason.getVashExitReasonID() +" Exception ::"+e.getMessage();
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
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2017.VashExitReason getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VASHExitReason expVASHExitReason ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.VashExitReason modelFromDB = null;
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.VashExitReason) getModel(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class, expVASHExitReason.getVashExitReasonID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.VashExitReason();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.VashExitReason model = new com.servinglynk.hmis.warehouse.model.v2017.VashExitReason();
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(expVASHExitReason.getDateCreated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,expVASHExitReason.getVashExitReasonID(),data);
		return model;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.VashExitReason createVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason vashExitReason) {
		vashExitReason.setId(UUID.randomUUID());
		insert(vashExitReason);
		return vashExitReason;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.VashExitReason updateVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason vashExitReason) {
			update(vashExitReason);
		return vashExitReason;
	}


	@Override
	public void deleteVashExitReason(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason vashExitReason) {
			delete(vashExitReason);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.VashExitReason getVashExitReasonById(UUID vashExitReasonId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class);
		criteria.add(Restrictions.eq("id", vashExitReasonId));
		List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason> vashExitReason = (List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason>) findByCriteria(criteria);
		if(vashExitReason.size()>0) return vashExitReason.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason> getAllVashExitReason(String exitId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason> vashExitReason = (List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason>) findByCriteria(criteria,startIndex,maxItems);
		return vashExitReason;
	}
	
	
	public long getVashExitReasonCount(String exitId){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class);	
		return countRows(criteria);
	}

	@Override
	public List<VashExitReason> getAllExitVashExitReasons(UUID exitId, Integer startIndex, Integer maxItems) {
	 	DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class);
	    criteria.createAlias("exitid", "exitid");
	    criteria.add(Restrictions.eq("exitid.id", exitId));
	    return (List<com.servinglynk.hmis.warehouse.model.v2017.VashExitReason>) findByCriteria(criteria,startIndex,maxItems);
	}

	@Override
	public long getExitVashExitReasonsCount(UUID exitId) {
		 DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.VashExitReason.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	}

}
