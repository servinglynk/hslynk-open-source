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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ResidentialmoveindateDaoImpl extends ParentDaoImpl implements
		ResidentialmoveindateDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ResidentialmoveindateDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ResidentialMoveInDate> residentialMoveInDates = domain.getExport().getResidentialMoveInDate();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Residentialmoveindate.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(residentialMoveInDates != null && !residentialMoveInDates.isEmpty())
		{
			for( ResidentialMoveInDate residentialMoveInDate : residentialMoveInDates)
			{
				Residentialmoveindate residentialmoveindateModel = null;
				try {
					residentialmoveindateModel = getModelObject(domain, residentialMoveInDate,data,modelMap);
					residentialmoveindateModel.setInpermanenthousing(ResidentialmoveindateInpermanenthousingEnum.lookupEnum(BasicDataGenerator.getStringValue(residentialMoveInDate.getInPermanentHousing())));
					residentialmoveindateModel.setResidentialmoveindate(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getResidentialMoveInDate()));
					residentialmoveindateModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getDateCreated()));
					residentialmoveindateModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(residentialMoveInDate.getDateUpdated()));
					Enrollment enrollment = (Enrollment) getModel(Residentialmoveindate.class.getSimpleName(),Enrollment.class,residentialMoveInDate.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					residentialmoveindateModel.setExport(exportEntity);
					residentialmoveindateModel.setEnrollmentid(enrollment);
					performSaveOrUpdate(residentialmoveindateModel);
				} catch(Exception e) {
					String errorMessage = "Failure in ResidentialMoveInDate:::"+residentialMoveInDate.toString()+ " with exception"+e.getLocalizedMessage();
					if (residentialmoveindateModel != null) {
						Error2014 error = new Error2014();
						error.model_id = residentialmoveindateModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = residentialmoveindateModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = residentialmoveindateModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Residentialmoveindate.class.getSimpleName(), domain, exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate getModelObject(ExportDomain domain,ResidentialMoveInDate residentialmoveindate ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate residentialmoveindateModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			residentialmoveindateModel = (com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate) getModel(Residentialmoveindate.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate.class, residentialmoveindate.getResidentialMoveInDateID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(residentialmoveindateModel == null) {
			residentialmoveindateModel = new com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate();
			residentialmoveindateModel.setId(UUID.randomUUID());
			residentialmoveindateModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(residentialmoveindateModel, domain,residentialmoveindate.getResidentialMoveInDateID(),data.i+data.j);
		return residentialmoveindateModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate createResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate residentialmoveindate){
	       residentialmoveindate.setId(UUID.randomUUID()); 
	       insert(residentialmoveindate);
	       return residentialmoveindate;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate updateResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate residentialmoveindate){
	       update(residentialmoveindate);
	       return residentialmoveindate;
	   }
	   public void deleteResidentialmoveindate(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate residentialmoveindate){
	       delete(residentialmoveindate);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate getResidentialmoveindateById(UUID residentialmoveindateId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate) get(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate.class, residentialmoveindateId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate> getAllEnrollmentResidentialmoveindates(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentResidentialmoveindatesCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
