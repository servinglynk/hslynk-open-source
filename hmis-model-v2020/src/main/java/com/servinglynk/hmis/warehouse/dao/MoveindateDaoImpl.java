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
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;


/**
 * @author Sandeep
 *
 */
public class MoveindateDaoImpl extends ParentDaoImpl implements MoveindateDao {
	private static final Logger logger = LoggerFactory.getLogger(MoveindateDaoImpl.class);
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Moveindate> expMoveindate = domain.getExport().getMoveInDate();
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class, getProjectGroupCode(domain));
		if(expMoveindate !=null && !expMoveindate.isEmpty())
		{
				for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Moveindate expMoveindates : expMoveindate)
				{
					com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveindateModel = null;
					try {
						moveindateModel = getModelObject(domain, expMoveindates, data, modelMap);
						moveindateModel.setMoveindate(BasicDataGenerator.getLocalDateTime(expMoveindates.getDateCreated()));
						//moveindateModel.setInpermanenthousing(MoveindateInpermanenthousin.lookupEnum((expMoveindates.getInPermanentHousing())));
						moveindateModel.setDateCreated(BasicDataGenerator.getLocalDateTime(expMoveindates.getDateCreated()));
						moveindateModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(expMoveindates.getDateUpdated()));
						
						performSaveOrUpdate(moveindateModel,domain);
					}catch(Exception e ){
						String errorMessage = "Exception beause of the MoveInDate::"+expMoveindates.getMoveInDateID() +" Exception ::"+e.getMessage();
						if(moveindateModel != null){
							Error2017 error = new Error2017();
							error.model_id = moveindateModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = moveindateModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = moveindateModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2017.Moveindate getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Moveindate expMoveInDate ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Moveindate modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Moveindate) getModel(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class, expMoveInDate.getMoveInDateID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Moveindate model = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(expMoveInDate.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,expMoveInDate.getMoveInDateID(),data);
		return model;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Moveindate createMoveIdDate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveIdDate) {
		moveIdDate.setId(UUID.randomUUID());
			insert(moveIdDate);
		return moveIdDate;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Moveindate updateMoveIdDate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveInDate) {
			update(moveInDate);
		return moveInDate;
	}


	@Override
	public void deletemoveInDate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveInDate) {
			delete(moveInDate);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Moveindate getMoveInDateById(UUID moveInDateId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
		criteria.add(Restrictions.eq("id", moveInDateId));
		List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> moveInDate = (List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate>) findByCriteria(criteria);
		if(moveInDate.size()>0) return moveInDate.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> getAllMoveInDate(UUID enrollmentId,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> moveInDate = (List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate>) findByCriteria(criteria,startIndex,maxItems);
		return moveInDate;
	}
	
	
	public long getMoveInDateCount(UUID enrollmentId){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);	
		return countRows(criteria);
	}
	
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> getAllEnrollmentResidentialmoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentResidentialmoveindatesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }


}
