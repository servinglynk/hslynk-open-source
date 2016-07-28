/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardchildwelfareDaoImpl extends ParentDaoImpl implements
		FormerwardchildwelfareDao {
	private static final Logger logger = LoggerFactory
			.getLogger(FormerwardchildwelfareDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<FormerWardChildWelfare> formerWardChildWelfares = domain.getExport().getFormerWardChildWelfare();
		Long i=new Long(0L);
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(formerWardChildWelfares !=null && !formerWardChildWelfares.isEmpty() ) 
		{
			for(FormerWardChildWelfare formerWardChildWelfare : formerWardChildWelfares)
			{
				Formerwardchildwelfare formerwardchildwelfareModel = null;
				try {
					formerwardchildwelfareModel = getModelObject(domain, formerWardChildWelfare,data,modelMap);
					formerwardchildwelfareModel.setChildwelfaremonths(BasicDataGenerator.getIntegerValue(formerWardChildWelfare.getChildWelfareMonths()));
					formerwardchildwelfareModel.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getChildWelfareYears())));
					formerwardchildwelfareModel.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getFormerWardChildWelfare())));
					formerwardchildwelfareModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateCreated()));
					formerwardchildwelfareModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, formerWardChildWelfare.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					formerwardchildwelfareModel.setExport(exportEntity);
					formerwardchildwelfareModel.setEnrollmentid(enrollmentModel);
					performSaveOrUpdate(formerwardchildwelfareModel);
				}catch(Exception e) {
					String errorMessage = "Exception in:"+formerWardChildWelfare.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
					if (formerwardchildwelfareModel != null) {
						Error2014 error = new Error2014();
						error.model_id = formerwardchildwelfareModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = formerwardchildwelfareModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = formerwardchildwelfareModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getModelObject(ExportDomain domain, FormerWardChildWelfare formerWardChildWelfare ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerwardchildwelfareModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			formerwardchildwelfareModel = (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare) getModel(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, formerWardChildWelfare.getFormerWardChildWelfareID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(formerwardchildwelfareModel == null) {
			formerwardchildwelfareModel = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare();
			formerwardchildwelfareModel.setId(UUID.randomUUID());
			formerwardchildwelfareModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(formerwardchildwelfareModel, domain,formerWardChildWelfare.getFormerWardChildWelfareID(),data.i+data.j);
		return formerwardchildwelfareModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare createFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       formerWardChildWelfare.setId(UUID.randomUUID()); 
	       insert(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare updateFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       update(formerWardChildWelfare);
	       return formerWardChildWelfare;
	   }
	   public void deleteFormerWardChildWelfare(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare formerWardChildWelfare){
	       delete(formerWardChildWelfare);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare getFormerWardChildWelfareById(UUID formerWardChildWelfareId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare) get(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class, formerWardChildWelfareId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare> getAllEnrollmentFormerWardChildWelfares(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentFormerWardChildWelfaresCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
