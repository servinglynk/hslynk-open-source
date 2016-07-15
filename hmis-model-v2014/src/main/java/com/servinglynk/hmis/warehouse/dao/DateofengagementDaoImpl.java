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
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DateofengagementDaoImpl extends ParentDaoImpl implements
		DateofengagementDao {
	private static final Logger logger = LoggerFactory
			.getLogger(DateofengagementDao.class);
	
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception 
	{
		List<DateOfEngagement> dateOfEngagements = domain.getExport().getDateOfEngagement();
		Long i =new Long(0L);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
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
					if(exportEntity  != null)
						exportEntity.addDateofengagement(dateOfEngagementModel);
					dateOfEngagementModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateCreated()));
					dateOfEngagementModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(dateOfEngagement.getDateUpdated()));
				} catch(Exception e) {
					String msg = "Exception in:"+dateOfEngagement.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage();
					logger.error(msg);
					throw new Exception(msg,e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, Dateofengagement.class.getSimpleName(), domain, exportEntity);
	}
	
	  public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getModelObject(ExportDomain domain, DateOfEngagement DateOfEngagement,Data data, Map<String,HmisBaseModel> modelMap) {
		  com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagementModel = null;
		  if(!isFullRefresh(domain))
			  dateofengagementModel = (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement) getModel(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, DateOfEngagement.getDateOfEngagementID(), getProjectGroupCode(domain),false,modelMap);
		
		  if(dateofengagementModel == null) {
			dateofengagementModel = new com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement();
			dateofengagementModel.setId(UUID.randomUUID());
			dateofengagementModel.setInserted(true);
			++data.i;
		  }else{
			  ++data.j;
		  }
		  hydrateCommonFields(dateofengagementModel, domain,DateOfEngagement.getDateOfEngagementID(),data.i+data.j);
		  return dateofengagementModel;
      }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement createDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       dateofengagement.setId(UUID.randomUUID()); 
	       insert(dateofengagement);
	       return dateofengagement;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement updateDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       update(dateofengagement);
	       return dateofengagement;
	   }
	   public void deleteDateofengagement(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement dateofengagement){
	       delete(dateofengagement);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement getDateofengagementById(UUID dateofengagementId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement) get(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class, dateofengagementId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement> getAllEnrollmentDateofengagements(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentDateofengagementsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
