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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.DateOfEngagement;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DateofengagementDaoImpl extends ParentDaoImpl implements
		DateofengagementDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DateofengagementDaoImpl.class);
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception
	{
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,domain.getExport().getExportID(),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class, getProjectGroupCode(domain));
		List<DateOfEngagement> dateOfEngagements = domain.getExport().getDateOfEngagement();
		if(dateOfEngagements!=null &&!dateOfEngagements.isEmpty())
		{
			for(DateOfEngagement dateOfEngagement: dateOfEngagements)
			{
			 try {
				 Dateofengagement dateOfEngagementModel = getModelObject(domain, dateOfEngagement,data,modelMap);
				 dateOfEngagementModel.setDateofengagement(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateOfEngagement()));
				 Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, dateOfEngagement.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap);
				 dateOfEngagementModel.setEnrollmentid(enrollmentModel);
				 dateOfEngagementModel.setExport(exportEntity);
				 dateOfEngagementModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
				 dateOfEngagementModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				 performSaveOrUpdate(dateOfEngagementModel);
			 } catch(Exception e) {
				 logger.error("Exception beause of the Dateofengagement::"+dateOfEngagement.getDateOfEngagementID() +" Exception ::"+e.getMessage());
				 throw new Exception(e);
			 }
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Disabilities.class.getSimpleName(), domain,exportEntity);

	}
	
	public com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement getModelObject(ExportDomain domain, DateOfEngagement dateofengagement ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement dateofengagementModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			dateofengagementModel = (com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement) getModel(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class, dateofengagement.getDateOfEngagementID(), getProjectGroupCode(domain),false,modelMap);
		
		if(dateofengagementModel == null) {
			dateofengagementModel = new com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement();
			dateofengagementModel.setId(UUID.randomUUID());
			dateofengagementModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(dateofengagementModel, domain,dateofengagement.getDateOfEngagementID(),data.i+data.j);
		return dateofengagementModel;
	}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID());
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement getDateofengagementById(UUID dateofengagementId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement) get(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class, dateofengagementId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
