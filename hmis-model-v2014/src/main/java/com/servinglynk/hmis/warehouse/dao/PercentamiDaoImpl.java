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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PercentamiDaoImpl extends ParentDaoImpl implements PercentamiDao {
	private static final Logger logger = LoggerFactory
			.getLogger(PercentamiDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<PercentAMI> percentAMIs = domain.getExport().getPercentAMI();
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(Percentami.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		if(percentAMIs !=null && !percentAMIs.isEmpty())
		{
			for(PercentAMI percentAMI :percentAMIs)
			{
				Percentami model = null;
				try {
					model = getModelObject(domain, percentAMI,data,modelMap);
					model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateCreated()));
					model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(percentAMI.getDateUpdated()));
					model.setPercentage(BasicDataGenerator.getIntegerValue(percentAMI.getPercentAMI()));
					Enrollment enrollmentModel = (Enrollment) getModel(Percentami.class.getSimpleName(),Enrollment.class, percentAMI.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					model.setEnrollmentid(enrollmentModel);
					model.setExport(exportEntity);
					HmisBaseModel hmisBaseModel = modelMap.get(model.getSourceSystemId());
					if(hmisBaseModel !=null ) {
						modelMatch(hmisBaseModel, model);
					}
					performSaveOrUpdate(model);
				} catch(Exception e) {
					 String errorMessage = "Failure in Percentami:::"+percentAMI.toString()+ " with exception"+e.getLocalizedMessage();
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
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Percentami.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Percentami getModelObject(ExportDomain domain,PercentAMI percentami ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Percentami percentamiModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			percentamiModel = (com.servinglynk.hmis.warehouse.model.v2014.Percentami) getModel(Percentami.class.getSimpleName(),com.servinglynk.hmis.warehouse.model.v2014.Percentami.class, percentami.getPercentAMIID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(percentamiModel == null) {
			percentamiModel = new com.servinglynk.hmis.warehouse.model.v2014.Percentami();
			percentamiModel.setId(UUID.randomUUID());
			percentamiModel.setRecordToBeInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(percentamiModel, domain,percentami.getPercentAMIID(),data.i+data.j);
		return percentamiModel;
	}
	 public com.servinglynk.hmis.warehouse.model.v2014.Percentami createPercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       percentami.setId(UUID.randomUUID()); 
	       insert(percentami);
	       return percentami;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Percentami updatePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       update(percentami);
	       return percentami;
	   }
	   public void deletePercentami(com.servinglynk.hmis.warehouse.model.v2014.Percentami percentami){
	       delete(percentami);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Percentami getPercentamiById(UUID percentamiId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Percentami) get(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class, percentamiId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Percentami> getAllEnrollmentPercentamis(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Percentami>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentPercentamisCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Percentami.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
