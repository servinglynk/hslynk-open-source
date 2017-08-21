package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.lang.model.type.ErrorType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class RHYAfterCareDaoImpl extends ParentDaoImpl implements RHYAfterCareDao{

	
	private static final Logger logger = LoggerFactory.getLogger(RHYAfterCareDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		 List<RHYAfterCare> rhyAfterCares = domain.getExport().getRhyAfterCare();
		 com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		 Data data =new Data();
		 Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class, getProjectGroupCode(domain));
		 if(rhyAfterCares != null && !rhyAfterCares.isEmpty())
		 {
			 for(RHYAfterCare rhyAfterCare : rhyAfterCares)
			 {
				 com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCareModel = null;
				 try {
					 rhyAfterCareModel = getModelObject(domain, rhyAfterCare,data,modelMap);
					 rhyAfterCareModel.setAfterCareDate(rhyAfterCare.getAfterCareDate());
					 rhyAfterCareModel.setAfterProvided(rhyAfterCare.getAfterProvided());
					 rhyAfterCareModel.setEmailSocialMedia(rhyAfterCare.getEmailSocialMedia());
					 rhyAfterCareModel.setId(rhyAfterCare.getId());
					 rhyAfterCareModel.setInPersonGroup(rhyAfterCare.getInPersonGroup());
					 rhyAfterCareModel.setInPersonIndividual(rhyAfterCare.getInPersonIndividual());
					 rhyAfterCareModel.setTelephone(rhyAfterCare.getTelephone());
					 performSaveOrUpdate(rhyAfterCareModel);
				 } catch(Exception e){
					 String errorMessage = "Exception because of the rhyAfterCare::"+rhyAfterCare.getId() +" Exception ::"+e.getMessage();
					 if(rhyAfterCareModel != null){
						 Error2017 error = new Error2017();
						 error.model_id = rhyAfterCareModel.getId();
						 error.bulk_upload_ui = domain.getUpload().getId();
						 error.project_group_code = domain.getUpload().getProjectGroupCode();
						 error.source_system_id = rhyAfterCareModel.getSourceSystemId();
						 error.type = ErrorType.ERROR;
						 error.error_description = errorMessage;
//						 error.date_created = rhyAfterCareModel.getDateCreated();
						 performSave(error);
					 }
					 logger.error(errorMessage);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getModelObject(ExportDomain domain, RHYAfterCare rhyAfterCare ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare) getModel(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class, rhyAfterCare.getId(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare model = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setAfterCareDate(BasicDataGenerator.getLocalDateTime(rhyAfterCare.getAfterCareDate()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,rhyAfterCare.getId(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare createRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare){
		   rhyAfterCare.setId(UUID.randomUUID());
	       insert(rhyAfterCare);
	       RHYAfterCareEntity entity = new RHYAfterCareEntity();
	       BeanUtils.copyProperties(rhyAfterCare, entity);
	       insert(entity);
	       return rhyAfterCare;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare updateRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare){
	       update(rhyAfterCare);
	       return rhyAfterCare;
	   }
	   public void deleteRHYAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare){
	       delete(rhyAfterCare);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getRHYAfterCareById(UUID rhyAfterCareId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
		      criteria.add(Restrictions.eq("id", rhyAfterCareId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllRHYAfterCare(String inPersonGroup,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
	       criteria.add(Restrictions.eq("inPersonGroup", inPersonGroup));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getConnectionWithSoarCount(String inPersonGroup){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
	       criteria.add(Restrictions.eq("inPersonGroup", inPersonGroup));
	       return countRows(criteria);
	   }

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}







}
