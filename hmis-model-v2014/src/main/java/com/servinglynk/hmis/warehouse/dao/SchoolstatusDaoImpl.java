/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SchoolStatus;
import com.servinglynk.hmis.warehouse.enums.SchoolStatusEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SchoolstatusDaoImpl extends ParentDaoImpl implements
		SchoolstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<SchoolStatus> schoolStatusList = domain.getExport().getSchoolStatus();
		hydrateBulkUploadActivityStaging(schoolStatusList, com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(schoolStatusList!=null && !schoolStatusList.isEmpty())
		{
			for(SchoolStatus schoolStatus : schoolStatusList)
			{
			Schoolstatus schoolstatusModel = new Schoolstatus();
			UUID id = UUID.randomUUID();
			schoolstatusModel.setId(id);
			schoolstatusModel.setDateCreated(LocalDateTime.now());
			schoolstatusModel.setDateUpdated(LocalDateTime.now());
			schoolstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(schoolStatus.getDateCreated()));
			schoolstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(schoolStatus.getDateUpdated()));
			schoolstatusModel.setInformationDate(BasicDataGenerator.getLocalDateTime(schoolStatus.getInformationDate()));
			schoolstatusModel.setSchoolStatus(
			SchoolStatusEnum
			.lookupEnum(BasicDataGenerator
					.getStringValue(schoolStatus.getSchoolStatus())));
			if(schoolStatus.getProjectEntryID() !=null && !"".equals(schoolStatus.getProjectEntryID())) {
				UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((schoolStatus.getProjectEntryID()));
				if(uuid !=null) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
					schoolstatusModel.setEnrollmentid(enrollmentModel);
				}
					
			}
			schoolstatusModel.setExport(exportEntity);
			exportEntity.addSchoolstatus(schoolstatusModel);
			i++;
			hydrateCommonFields(schoolstatusModel, domain, schoolStatus.getSchoolStatusID(),i);
			}
		}

	}
	   public com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus createSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus){
	       schoolstatus.setId(UUID.randomUUID()); 
	       insert(schoolstatus);
	       return schoolstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus updateSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus){
	       update(schoolstatus);
	       return schoolstatus;
	   }
	   public void deleteSchoolstatus(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus schoolstatus){
	       delete(schoolstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus getSchoolstatusById(UUID schoolstatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus) get(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus.class, schoolstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus> getAllEnrollmentSchoolstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentSchoolstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
