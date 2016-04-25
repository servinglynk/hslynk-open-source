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
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class LastgradecompletedDaoImpl extends ParentDaoImpl implements
		LastgradecompletedDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.
	 * hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<LastGradeCompleted> lastGradeCompletedList = domain.getExport()
				.getLastGradeCompleted();
		hydrateBulkUploadActivityStaging(lastGradeCompletedList, com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if (lastGradeCompletedList != null && !lastGradeCompletedList.isEmpty()) {
			for (LastGradeCompleted lastGradeCompleted : lastGradeCompletedList) {
				Lastgradecompleted lastGradeCompletedModel = new Lastgradecompleted();
				UUID id = UUID.randomUUID();
				lastGradeCompletedModel.setId(id);
				lastGradeCompletedModel
						.setLastgradecompleted(LastgradecompletedLastgradecompletedEnum
								.lookupEnum(BasicDataGenerator
										.getStringValue(lastGradeCompleted
												.getLastGradeCompleted())));

				lastGradeCompletedModel.setDateCreated(LocalDateTime.now());
				lastGradeCompletedModel.setDateUpdated(LocalDateTime.now());
				lastGradeCompletedModel.setDateCreatedFromSource(BasicDataGenerator
						.getLocalDateTime(lastGradeCompleted.getDateCreated()));
				lastGradeCompletedModel.setDateUpdatedFromSource(BasicDataGenerator
						.getLocalDateTime(lastGradeCompleted.getDateUpdated()));
				if(lastGradeCompleted.getProjectEntryID() !=null && !"".equals(lastGradeCompleted.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((lastGradeCompleted.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						lastGradeCompletedModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				lastGradeCompletedModel.setExport(exportEntity);
				exportEntity.addLastgradecompleted(lastGradeCompletedModel);
				i++;
				hydrateCommonFields(lastGradeCompletedModel, domain, lastGradeCompleted.getLastGradeCompletedID(),i);
				insert(lastGradeCompletedModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Lastgradecompleted> lastgradecompleteds = export.getLastgradecompleteds();
		hydrateBulkUploadActivity(lastgradecompleteds, com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted.class.getSimpleName(), export,id);
		if(lastgradecompleteds != null) {
			for(Lastgradecompleted lastgradecompleted : lastgradecompleteds) {
				if(lastgradecompleted != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted target = new com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted();
					BeanUtils.copyProperties(lastgradecompleted, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, lastgradecompleted.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addLastgradecompleted(target);
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
