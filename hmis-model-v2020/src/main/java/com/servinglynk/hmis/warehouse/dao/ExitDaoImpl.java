/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.Error2017;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitDaoImpl extends ParentDaoImpl implements ExitDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExitDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;


	public List<com.servinglynk.hmis.warehouse.model.v2020.Exit> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exit.class);
		query.add(Restrictions.eq("dateCreated", new Date()));
		List<com.servinglynk.hmis.warehouse.model.v2020.Exit> list = (List<com.servinglynk.hmis.warehouse.model.v2020.Exit>) findByCriteria(query);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Exit.class, getProjectGroupCode(domain));
		if(exits !=null && exits.size() > 0)
		{
			for(Exit exit : exits)
			{
				com.servinglynk.hmis.warehouse.model.v2020.Exit exitModel = null;
				try {
					exitModel = getModelObject(domain, exit, data, modelMap);
					exitModel.setDestination(ExitDestinationEnum.lookupEnum((exit.getDestination())));
					exitModel.setOtherdestination(exit.getOtherDestination());
					exitModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateCreated()));
					exitModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
					exitModel.setExitdate(BasicDataGenerator.getLocalDateTime(exit.getExitDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, exit.getEnrollmentID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					exitModel.setEnrollmentid(enrollmentModel);
					exitModel.setExport(exportEntity);
					performSaveOrUpdate(exitModel,domain);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the exit::"+exit.getExitID() +" Exception ::"+e.getMessage();
					if(exitModel != null){
						Error2017 error = new Error2017();
						error.model_id = exitModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = exitModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = exitModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			 }
			}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Exit.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2020.Exit getModelObject(ExportDomain domain, Exit exit ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Exit modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2020.Exit.class, exit.getExitID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Exit();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Exit();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2020.Exit model = new com.servinglynk.hmis.warehouse.model.v2020.Exit();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,exit.getExitID(),data);
		return model;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2020.Exit createExit(com.servinglynk.hmis.warehouse.model.v2020.Exit exit){
		   exit.setId(UUID.randomUUID());
		   insert(exit);
	       return exit;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Exit updateExit(com.servinglynk.hmis.warehouse.model.v2020.Exit exit){
	       update(exit);
	       return exit;
	   }
	   public void deleteExit(com.servinglynk.hmis.warehouse.model.v2020.Exit exit){
	       delete(exit);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Exit getExitById(UUID exitId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exit.class);
		      criteria.add(Restrictions.eq("id", exitId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.Exit> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.Exit>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.Exit>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentExitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
