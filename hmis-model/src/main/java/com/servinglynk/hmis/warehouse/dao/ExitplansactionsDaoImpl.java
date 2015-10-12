/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPlansActions;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsAssistancemainstreambenefitsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsExitcounselingEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsFurtherfollowupservicesEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsOtheraftercareplanoractionEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsPermanenthousingplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsResourcepackageEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsScheduledfollowupcontactsEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsTemporaryshelterplacementEnum;
import com.servinglynk.hmis.warehouse.enums.ExitplansactionsWrittenaftercareplanEnum;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Exitplansactions;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitplansactionsDaoImpl extends ParentDaoImpl implements
		ExitplansactionsDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ExitPlansActions> exitPlansActionsList = domain.getExport().getExitPlansActions();
		if(exitPlansActionsList !=null && !exitPlansActionsList.isEmpty()) 
		{
			for(ExitPlansActions exitPlansActions : exitPlansActionsList)
			{
				Exitplansactions exitplansactionsModel = new Exitplansactions();
				exitplansactionsModel.setId(UUID.randomUUID());
				exitplansactionsModel.setDateCreated(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateCreated()));
				exitplansactionsModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(exitPlansActions.getDateUpdated()));
				exitplansactionsModel.setAssistancemainstreambenefits(ExitplansactionsAssistancemainstreambenefitsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getAssistanceMainstreamBenefits())));
				exitplansactionsModel.setExitcounseling(ExitplansactionsExitcounselingEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getExitCounseling())));
				exitplansactionsModel.setFurtherfollowupservices(ExitplansactionsFurtherfollowupservicesEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getFurtherFollowUpServices())));
				exitplansactionsModel.setOtheraftercareplanoraction(ExitplansactionsOtheraftercareplanoractionEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getOtherAftercarePlanOrAction())));
				exitplansactionsModel.setPermanenthousingplacement(ExitplansactionsPermanenthousingplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getPermanentHousingPlacement())));
				exitplansactionsModel.setResourcepackage(ExitplansactionsResourcepackageEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getResourcePackage())));
				exitplansactionsModel.setScheduledfollowupcontacts(ExitplansactionsScheduledfollowupcontactsEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getScheduledFollowUpContacts())));
				exitplansactionsModel.setTemporaryshelterplacement(ExitplansactionsTemporaryshelterplacementEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getTemporaryShelterPlacement())));
				exitplansactionsModel.setWrittenaftercareplan(ExitplansactionsWrittenaftercareplanEnum.lookupEnum(BasicDataGenerator.getStringValue(exitPlansActions.getWrittenAftercarePlan())));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(exitPlansActions.getExitID()));
				exitplansactionsModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				exitplansactionsModel.setExport(exportEntity);
				exportEntity.addExitplansactions(exitplansactionsModel);
				insertOrUpdate(exitplansactionsModel);
			}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<Exitplansactions> exitplansactionss = export.getExitplansactionss();
		if(exitplansactionss !=null && !exitplansactionss.isEmpty()) {
			for(Exitplansactions exitplansactions : exitplansactionss) {
				if(exitplansactions != null) {
					com.servinglynk.hmis.warehouse.model.live.Exitplansactions target = new com.servinglynk.hmis.warehouse.model.live.Exitplansactions();
					BeanUtils.copyProperties(exitplansactions, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Exit exitModel = (com.servinglynk.hmis.warehouse.model.live.Exit) get(com.servinglynk.hmis.warehouse.model.live.Exit.class, exitplansactions.getExitid().getId());
					target.setExitid(exitModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addExitplansactions(target);
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
