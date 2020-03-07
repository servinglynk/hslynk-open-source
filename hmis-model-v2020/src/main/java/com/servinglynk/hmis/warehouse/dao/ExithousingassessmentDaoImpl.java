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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.Exit;
import com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExithousingassessmentDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class, getProjectGroupCode(domain));
		if(exitHousingAssessments !=null && !exitHousingAssessments.isEmpty())
		{
				for(ExitHousingAssessment exitHousingAssessment : exitHousingAssessments)
				{
					Exithousingassessment exithousingassessmentModel = null;
					try {
						exithousingassessmentModel = getModelObject(domain, exitHousingAssessment, data, modelMap);
						if(exithousingassessmentModel.isIgnored()) {
							continue;
						}
						exithousingassessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
						exithousingassessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
						exithousingassessmentModel.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum((exitHousingAssessment.getHousingAssessment())));
						exithousingassessmentModel.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum((exitHousingAssessment.getSubsidyInformation())));
						Exit exit = (Exit) getModel(Exit.class, exitHousingAssessment.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
						exithousingassessmentModel.setExitid(exit);
						exithousingassessmentModel.setExport(exportEntity);
						performSaveOrUpdate(exithousingassessmentModel,domain);
					}catch(Exception e ){
						String errorMessage = "Exception beause of the exitHousingAssessment::"+exitHousingAssessment.getExitHousingAssessmentID() +" Exception ::"+e.getMessage();
						if(exithousingassessmentModel != null){
							Error2020 error = new Error2020();
							error.model_id = exithousingassessmentModel.getId();
							error.bulk_upload_ui = domain.getUpload().getId();
							error.project_group_code = domain.getUpload().getProjectGroupCode();
							error.source_system_id = exithousingassessmentModel.getSourceSystemId();
							error.type = ErrorType.ERROR;
							error.error_description = errorMessage;
							error.date_created = exithousingassessmentModel.getDateCreated();
							performSave(error);
						}
						logger.error(errorMessage);
					}
				}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment getModelObject(ExportDomain domain, ExitHousingAssessment exithousingassessment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment) getModel(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class, exithousingassessment.getExitHousingAssessmentID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		} else {
			com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment model = new com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment();
			// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exithousingassessment.getDateUpdated()));
			performMatch(domain, modelFromDB, model, data);
		
		}
		hydrateCommonFields(modelFromDB, domain,exithousingassessment.getExitHousingAssessmentID(),data);
		return modelFromDB;
	}
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment createExithousingassessment(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment exithousingassessment) {
		exithousingassessment.setId(UUID.randomUUID());
			insert(exithousingassessment);
		return exithousingassessment;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment updateExithousingassessment(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment exithousingassessment) {
			update(exithousingassessment);
		return exithousingassessment;
	}


	@Override
	public void deleteExithousingassessment(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment exithousingassessment) {
			delete(exithousingassessment);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment getExithousingassessmentById(UUID exithousingassessmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);
		criteria.add(Restrictions.eq("id", exithousingassessmentId));
		List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment>) findByCriteria(criteria);
		if(exithousingassessment.size()>0) return exithousingassessment.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment getExithousingassessmentByDedupExithousingassessmentId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment>) findByCriteria(criteria);
		if(exithousingassessment !=null && exithousingassessment.size()>0) return exithousingassessment.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> getAllExithousingassessment(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);	
		List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> exithousingassessment = (List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment>) findByCriteria(criteria,startIndex,maxItems);
		return exithousingassessment;
	}
	
	
	public long getExithousingassessmentCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);	
		return countRows(criteria);
	}

	@Override
	public void hydrateLive(Exithousingassessment exithousingassessment) {
		// TODO Auto-generated method stub
		
	}
	
	   public List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment> getAllExitExithousingassessments(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getExitExithousingassessmentsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
