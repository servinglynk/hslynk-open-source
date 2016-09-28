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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.NonCashBenefits;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsBenefitsfromanysourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthersourceEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsOthertanfEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistanceongoingEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsRentalassistancetempEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsSnapEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanfchildcareEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsTanftransportationEnum;
import com.servinglynk.hmis.warehouse.enums.NoncashbenefitsWicEnum;
import com.servinglynk.hmis.warehouse.model.v2016.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2016.Error2016;
import com.servinglynk.hmis.warehouse.model.v2016.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class NoncashbenefitsDaoImpl extends ParentDaoImpl implements
		NoncashbenefitsDao {
	private static final Logger logger = LoggerFactory
			.getLogger(NoncashbenefitsDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<NonCashBenefits> nonCashBenefitsList = domain.getExport().getNonCashBenefits();
		com.servinglynk.hmis.warehouse.model.v2016.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2016.Export) getModel(com.servinglynk.hmis.warehouse.model.v2016.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class, getProjectGroupCode(domain));
		if(nonCashBenefitsList !=null && !nonCashBenefitsList.isEmpty())
		{
			for(NonCashBenefits nonCashBenefits : nonCashBenefitsList)
			{
				Noncashbenefits noncashbenefitsModel = null;
				try{
					noncashbenefitsModel = getModelObject(domain, nonCashBenefits,data,modelMap);
					noncashbenefitsModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(nonCashBenefits.getDateCreated()));
					noncashbenefitsModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(nonCashBenefits.getDateUpdated()));
					noncashbenefitsModel.setBenefitsfromanysource(NoncashbenefitsBenefitsfromanysourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getBenefitsFromAnySource())));
					noncashbenefitsModel.setOthersource(NoncashbenefitsOthersourceEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherSource())));
					noncashbenefitsModel.setOthersourceidentify(nonCashBenefits.getOtherSourceIdentify());
					noncashbenefitsModel.setOthertanf(NoncashbenefitsOthertanfEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getOtherTANF())));
					noncashbenefitsModel.setRentalassistanceongoing(NoncashbenefitsRentalassistanceongoingEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceOngoing())));
					noncashbenefitsModel.setRentalassistancetemp(NoncashbenefitsRentalassistancetempEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getRentalAssistanceTemp())));
					noncashbenefitsModel.setSnap(NoncashbenefitsSnapEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getSNAP())));
					noncashbenefitsModel.setTanfchildcare(NoncashbenefitsTanfchildcareEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFChildCare())));
					noncashbenefitsModel.setTanftransportation(NoncashbenefitsTanftransportationEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getTANFTransportation())));
					noncashbenefitsModel.setWic(NoncashbenefitsWicEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getWIC())));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, nonCashBenefits.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					noncashbenefitsModel.setEnrollmentid(enrollmentModel);
					noncashbenefitsModel.setExport(exportEntity);
					noncashbenefitsModel.setInformationDate(BasicDataGenerator.getLocalDateTime(nonCashBenefits.getInformationDate()));
					noncashbenefitsModel.setDataCollectionStage(DataCollectionStageEnum.lookupEnum(BasicDataGenerator.getStringValue(nonCashBenefits.getDataCollectionStage())));
					performSaveOrUpdate(noncashbenefitsModel);
				} catch(Exception e){
					String errorMessage = "Exception beause of the nonCashBenefits::"+nonCashBenefits.getNonCashBenefitsID() +" Exception ::"+e.getMessage();
					if(noncashbenefitsModel != null){
						Error2016 error = new Error2016();
						error.model_id = noncashbenefitsModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = noncashbenefitsModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = noncashbenefitsModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class.getSimpleName(), domain,exportEntity);

	}

	public com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits getModelObject(ExportDomain domain, NonCashBenefits noncashbenefits ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits) getModel(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class, noncashbenefits.getNonCashBenefitsID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits model = new com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits();
		org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(noncashbenefits.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,noncashbenefits.getNonCashBenefitsID(),data);
		return model;
	}
	

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits createNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits noncashbenefits){
	       noncashbenefits.setId(UUID.randomUUID());
	       insert(noncashbenefits);
	       return noncashbenefits;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits updateNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits noncashbenefits){
	       update(noncashbenefits);
	       return noncashbenefits;
	   }
	   public void deleteNoncashbenefits(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits noncashbenefits){
	       delete(noncashbenefits);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits getNoncashbenefitsById(UUID noncashbenefitsId){
	       return (com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits) get(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class, noncashbenefitsId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits> getAllEnrollmentNoncashbenefits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentNoncashbenefitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2016.Noncashbenefits.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
