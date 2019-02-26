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
import com.servinglynk.hmis.warehouse.enums.NoYesEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;


/**
 * @author Sandeep
 *
 */
public class RHYAfterCareDaoImpl extends ParentDaoImpl implements RHYAfterCareDao {
	private static final Logger logger = LoggerFactory.getLogger(RHYAfterCareDaoImpl.class);
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYAfterCare> rhyAfterCares= domain.getExport().getRhyAfterCare();
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class, getProjectGroupCode(domain));
		if(rhyAfterCares !=null && !rhyAfterCares.isEmpty())
		{
				for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYAfterCare rhyAfterCare : rhyAfterCares)
				{
					com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCareModel = null;
					try {
						rhyAfterCareModel = getModelObject(domain, rhyAfterCare, data, modelMap);
						rhyAfterCareModel.setAfterProvided(NoYesEnum.lookupEnum((rhyAfterCare.getAfterCareProvided())));
						rhyAfterCareModel.setEmailSocialMedia(NoYesEnum.lookupEnum(rhyAfterCare.getEmailSocialMedia()));
						rhyAfterCareModel.setInPersonGroup(NoYesEnum.lookupEnum(rhyAfterCare.getInPersonIndividual()));
						rhyAfterCareModel.setInPersonIndividual(NoYesEnum.lookupEnum(rhyAfterCare.getInPersonIndividual()));
						rhyAfterCareModel.setTelephone(NoYesEnum.lookupEnum(rhyAfterCare.getTelephone()));
						rhyAfterCareModel.setExport(exportEntity);
						com.servinglynk.hmis.warehouse.model.v2017.Exit exit = (com.servinglynk.hmis.warehouse.model.v2017.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2017.Exit.class,rhyAfterCare.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						rhyAfterCareModel.setExitid(exit);
						rhyAfterCareModel.setAfterCareDate(BasicDataGenerator.getLocalDateTime(rhyAfterCare.getAfterCareDate()));
						
						performSaveOrUpdate(rhyAfterCareModel,domain);
					}catch(Exception e ){
						String errorMessage = "Exception beause of the RHYAfterCare ::"+rhyAfterCare.getRhyAfterCareID() +" Exception ::"+e.getMessage();
						if(rhyAfterCareModel != null){
							Error2017 error = new Error2017();
							error.model_id = rhyAfterCareModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = rhyAfterCareModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = rhyAfterCareModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYAfterCare expRhyAfterCare ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare modelFromDB = null;
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare) getModel(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class, expRhyAfterCare.getRhyAfterCareID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare model = new com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare();
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(expRhyAfterCare.getAfterCareDate()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,expRhyAfterCare.getRhyAfterCareID(),data);
		return model;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare createRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare) {
		rhyAfterCare.setId(UUID.randomUUID());
		insert(rhyAfterCare);
		return rhyAfterCare;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare updateRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare) {
			update(rhyAfterCare);
		return rhyAfterCare;
	}


	@Override
	public void deleteRhyAfterCare(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare rhyAfterCare) {
			delete(rhyAfterCare);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare getRhyAfterCareById(UUID rhyAfterCareId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
		criteria.add(Restrictions.eq("id", rhyAfterCareId));
		List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> rhyAfterCare = (List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare>) findByCriteria(criteria);
		if(rhyAfterCare.size()>0) return rhyAfterCare.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllRHYAfterCare(String inPersonGroup,Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> rhyAfterCare = (List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare>) findByCriteria(criteria,startIndex,maxItems);
		return rhyAfterCare;
	}
	
	
	public long getRhyAfterCareCount(String inPersonGroup){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);	
		return countRows(criteria);
	}

	   public List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare> getAllExitRHYAfterCares(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitRHYAfterCaresCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.RHYAfterCare.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
}
