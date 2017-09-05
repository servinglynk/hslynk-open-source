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
import com.servinglynk.hmis.warehouse.model.v2017.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.Moveindate;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class MoveindateDaoImpl extends ParentDaoImpl implements
		MoveindateDao {
	private static final Logger logger = LoggerFactory.getLogger(MoveindateDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<Moveindate> moveindates = domain.getExport().getMoveInDate();
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class, getProjectGroupCode(domain));
		if(moveindates != null && !moveindates.isEmpty())
		{
			for( Moveindate moveindate : moveindates)
			{
				Moveindate moveindateModel = null;
				try {
					moveindateModel = getModelObject(domain, moveindate,data,modelMap);
					moveindateModel.setResidentialmoveindate(BasicDataGenerator.getLocalDateTime(moveindate.getMoveindate()));
					moveindateModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(moveindate.getDateCreated()));
					moveindateModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(moveindate.getDateUpdated()));
					Enrollment enrollment = (Enrollment) getModel(Enrollment.class, moveindate.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					moveindateModel.setEnrollmentid(enrollment);
					moveindateModel.setExport(exportEntity);
					performSaveOrUpdate(moveindateModel);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the moveInDate::"+moveindate.getId() +" Exception ::"+e.getMessage();
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
			hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class.getSimpleName(), domain,exportEntity);
		}
	}

	public com.servinglynk.hmis.warehouse.model.v2017.Moveindate getModelObject(ExportDomain domain, Moveindate moveindate ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Moveindate modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Moveindate) getModel(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class, moveindate.getId(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Moveindate model = new com.servinglynk.hmis.warehouse.model.v2017.Moveindate();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(moveindate.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,moveindate.getId(),data);
		return model;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}


	   public com.servinglynk.hmis.warehouse.model.v2017.Moveindate createResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveindateId){
		   moveindateId.setId(UUID.randomUUID());
	       insert(moveindateId);
	       return moveindateId;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Moveindate updateResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate moveindateId){
	       update(moveindateId);
	       return moveindateId;
	   }
	   public void deleteResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2017.Moveindate residentialmoveindate){
	       delete(residentialmoveindate);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Moveindate getMoveindateById(UUID moveindateId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
		      criteria.add(Restrictions.eq("id", moveindateId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate> getAllEnrollmentMoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Moveindate>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentMoveindatesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Moveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

	@Override
	public Moveindate createMoveindate(Moveindate moveinDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Moveindate updateMoveindate(Moveindate moveinDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMoveindate(Moveindate moveinDate) {
		// TODO Auto-generated method stub
		
	}
}
