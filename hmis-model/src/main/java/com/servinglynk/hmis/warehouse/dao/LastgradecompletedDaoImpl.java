/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.LastGradeCompleted;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.LastgradecompletedLastgradecompletedEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Lastgradecompleted;
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
				lastGradeCompletedModel.setDateCreated(BasicDataGenerator
						.getLocalDate(lastGradeCompleted.getDateCreated()));
				lastGradeCompletedModel.setDateUpdated(BasicDataGenerator
						.getLocalDate(lastGradeCompleted.getDateUpdated()));
				if(lastGradeCompleted.getProjectEntryID() !=null && !"".equals(lastGradeCompleted.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((lastGradeCompleted.getProjectEntryID()));
					if(uuid !=null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
						lastGradeCompletedModel.setEnrollmentid(enrollmentModel);
					}
						
				}
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				lastGradeCompletedModel.setExport(exportEntity);
				exportEntity.addLastgradecompleted(lastGradeCompletedModel);
				insertOrUpdate(lastGradeCompletedModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Lastgradecompleted> lastgradecompleteds = export.getLastgradecompleteds();
		if(lastgradecompleteds != null) {
			for(Lastgradecompleted lastgradecompleted : lastgradecompleteds) {
				if(lastgradecompleted != null) {
					com.servinglynk.hmis.warehouse.model.live.Lastgradecompleted target = new com.servinglynk.hmis.warehouse.model.live.Lastgradecompleted();
					BeanUtils.copyProperties(lastgradecompleted, target,getNonCollectionFields(target));
					insert(target);
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
