/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
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
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Exit.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, getProjectGroupCode(domain));
		if(CollectionUtils.isNotEmpty(exits)){
			exits.parallelStream().forEach(e->processData(e, domain, data, modelMap, relatedModelMap, exportEntity));
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2014.Exit.class.getSimpleName(), domain, exportEntity);
	}
	public void processData(Exit exit,ExportDomain domain,Data data,Map<String,HmisBaseModel> modelMap,Map<String,HmisBaseModel> relatedModelMap,com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {
		com.servinglynk.hmis.warehouse.model.v2014.Exit model = null;
		try {
			model = getModelObject(domain, exit,data,modelMap);
			model.setDestination(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(exit.getDestination())));
			model.setOtherdestination(exit.getOtherDestination());
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
			model.setExitdate(BasicDataGenerator.getLocalDateTime(exit.getExitDate()));
			Enrollment enrollmentModel = (Enrollment) getModel(Exit.class.getSimpleName(),Enrollment.class, exit.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
			model.setEnrollmentid(enrollmentModel);
			model.setExport(exportEntity);
			performSaveOrUpdate(model);
		}catch(Exception e) {
			String errorMessage = "Exception in:"+exit.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
			if (model != null) {
				Error2014 error = new Error2014();
				error.model_id = model.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = model.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = model.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Exit getModelObject(ExportDomain domain, Exit exit ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Exit modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Exit) getModel(Exit.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Exit.class, exit.getExitID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			
		}
		 com.servinglynk.hmis.warehouse.model.v2014.Exit model = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
		  // org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		  model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
		  performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,exit.getExitID(),data);
		
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Exit createExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
		   exit.setId(UUID.randomUUID());
		   insert(exit);
	       return exit;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exit updateExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
	       update(exit);
	       return exit;
	   }
	   public void deleteExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
	       delete(exit);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exit getExitById(UUID exitId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exit.class);
		      criteria.add(Restrictions.eq("id", exitId));
		      List<com.servinglynk.hmis.warehouse.model.v2014.Exit> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Exit>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Exit>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentExitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
	@Override
	public void hydrate(ExportDomain domain, Map<String, HmisBaseModel> exportModelMap,
			Map<String, HmisBaseModel> relatedModelMap) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
