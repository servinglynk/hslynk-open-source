/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SchoolStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Schoolstatus;
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
		if(schoolStatusList!=null && !schoolStatusList.isEmpty())
		{
			for(SchoolStatus schoolStatus : schoolStatusList)
			{
			Schoolstatus schoolstatusModel = new Schoolstatus();
			UUID id = UUID.randomUUID();
			schoolstatusModel.setId(id);
			schoolstatusModel.setDateCreated(BasicDataGenerator.getLocalDateTime(schoolStatus.getDateCreated()));
			schoolstatusModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(schoolStatus.getDateUpdated()));
			schoolstatusModel.setInformationDate(BasicDataGenerator.getLocalDateTime(schoolStatus.getInformationDate()));
			schoolstatusModel.setSchoolStatus(BasicDataGenerator.getIntegerValue(schoolStatus.getSchoolStatus()));
			if(schoolStatus.getProjectEntryID() !=null && !"".equals(schoolStatus.getProjectEntryID())) {
				UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((schoolStatus.getProjectEntryID()));
				if(uuid !=null) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
					schoolstatusModel.setEnrollmentid(enrollmentModel);
				}
					
			}
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
			schoolstatusModel.setExport(exportEntity);
			exportEntity.addSchoolstatus(schoolstatusModel);
			insertOrUpdate(schoolstatusModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Schoolstatus> schoolstatuses = export.getSchoolstatuses();
		if(schoolstatuses !=null && !schoolstatuses.isEmpty()) {
			for(Schoolstatus schoolstatus : schoolstatuses) {
				if(schoolstatus != null) {
					com.servinglynk.hmis.warehouse.model.live.Schoolstatus target = new com.servinglynk.hmis.warehouse.model.live.Schoolstatus();
					BeanUtils.copyProperties(schoolstatus, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, schoolstatus.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addSchoolstatus(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
					insertOrUpdate(target);
				}
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

}
