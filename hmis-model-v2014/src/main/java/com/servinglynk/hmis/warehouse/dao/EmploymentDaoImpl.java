/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EmploymentDaoImpl extends ParentDaoImpl implements EmploymentDao {

	private static final Logger logger = LoggerFactory
			.getLogger(EmploymentDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<Employment> employmentList  = domain.getExport().getEmployment();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(employmentList!=null && !employmentList.isEmpty())
		{
			for(Employment employment : employmentList)
			{
				try {
					
					com.servinglynk.hmis.warehouse.model.v2014.Employment employmentModel = getModelObject(domain, employment,data);
					employmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(employment.getDateCreated()));
					employmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(employment.getDateUpdated()));
					employmentModel.setEmployed(EmploymentEmployedEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmployed())));
					employmentModel.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmploymentType())));;
					employmentModel.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getNotEmployedReason())));
					employmentModel.setInformationDate(BasicDataGenerator.getLocalDateTime(employment.getInformationDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, employment.getProjectEntryID(),getProjectGroupCode(domain));
					employmentModel.setEnrollmentid(enrollmentModel);
					employmentModel.setExport(exportEntity);
					if(exportEntity != null)
						exportEntity.addEmployment(employmentModel);
					performSaveOrUpdate(employmentModel);
				} catch(Exception e) {
					logger.error("Exception in:"+employment.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Employment.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Employment getModelObject(ExportDomain domain, Employment employment ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Employment employmentModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			employmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Employment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Employment.class, employment.getEmploymentID(), getProjectGroupCode(domain));
		
		if(employmentModel == null) {
			employmentModel = new com.servinglynk.hmis.warehouse.model.v2014.Employment();
			employmentModel.setId(UUID.randomUUID());
			employmentModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(employmentModel, domain,employment.getEmploymentID(),data.i+data.j);
		return employmentModel;
	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Employment createEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment){
	       employment.setId(UUID.randomUUID()); 
	       insert(employment);
	       return employment;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Employment updateEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment){
	       update(employment);
	       return employment;
	   }
	   public void deleteEmployment(com.servinglynk.hmis.warehouse.model.v2014.Employment employment){
	       delete(employment);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Employment getEmploymentById(UUID employmentId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Employment) get(com.servinglynk.hmis.warehouse.model.v2014.Employment.class, employmentId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Employment> getAllEnrollmentEmployments(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Employment.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Employment>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentEmploymentsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Employment.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
