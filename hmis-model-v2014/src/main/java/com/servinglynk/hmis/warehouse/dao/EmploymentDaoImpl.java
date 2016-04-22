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
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Employment;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmployedEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentEmploymentTypeEnum;
import com.servinglynk.hmis.warehouse.enums.EmploymentNotEmployedReasonEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EmploymentDaoImpl extends ParentDaoImpl implements EmploymentDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	@Transactional
	public void hydrateStaging(ExportDomain domain) {
		List<Employment> employmentList  = domain.getExport().getEmployment();
		hydrateBulkUploadActivityStaging(employmentList, com.servinglynk.hmis.warehouse.model.v2014.Employment.class.getSimpleName(), domain);
		if(employmentList!=null && !employmentList.isEmpty())
		{
			for(Employment employment : employmentList)
			{
				com.servinglynk.hmis.warehouse.model.stagv2014.Employment employmentModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Employment();
				employmentModel.setId(UUID.randomUUID());

				employmentModel.setDateCreated(LocalDateTime.now());
				employmentModel.setDateUpdated(LocalDateTime.now());
				employmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(employment.getDateCreated()));
				employmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(employment.getDateUpdated()));
				employmentModel.setEmployed(EmploymentEmployedEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmployed())));
				employmentModel.setEmploymentType(EmploymentEmploymentTypeEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getEmploymentType())));;
				employmentModel.setNotEmployedReason(EmploymentNotEmployedReasonEnum.lookupEnum(BasicDataGenerator.getStringValue(employment.getNotEmployedReason())));
				employmentModel.setInformationDate(BasicDataGenerator.getLocalDateTime(employment.getInformationDate()));
				
				if(employment.getProjectEntryID() !=null && !"".equals(employment.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((employment.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						employmentModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
				employmentModel.setExport(exportEntity);
				hydrateCommonFields(employmentModel, domain, employment.getEmploymentID());
				exportEntity.addEmployment(employmentModel);
				insertOrUpdate(employmentModel);				
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Employment> employments = export.getEmployments();
		hydrateBulkUploadActivity(employments, com.servinglynk.hmis.warehouse.model.v2014.Employment.class.getSimpleName(),export, id);
		if(employments != null && !employments.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Employment employment : employments) {
				com.servinglynk.hmis.warehouse.model.v2014.Employment target = new com.servinglynk.hmis.warehouse.model.v2014.Employment();
				BeanUtils.copyProperties(employment, target,getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, employment.getEnrollmentid().getId());
				target.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
				target.setExport(exportEntity);
				exportEntity.addEmployment(target);
				target.setDateCreated(LocalDateTime.now());
				target.setDateUpdated(LocalDateTime.now());
				insertOrUpdate(target);
			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
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
