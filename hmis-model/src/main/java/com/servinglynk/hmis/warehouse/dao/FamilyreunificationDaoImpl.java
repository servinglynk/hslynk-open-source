/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FamilyReunification;
import com.servinglynk.hmis.warehouse.enums.FamilyreunificationFamilyreunificationachievedEnum;
import com.servinglynk.hmis.warehouse.model.staging.Exit;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Familyreunification;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FamilyreunificationDaoImpl extends ParentDaoImpl implements
		FamilyreunificationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FamilyReunification> familyReunifications = domain.getExport().getFamilyReunification();
		if(familyReunifications!=null && familyReunifications.size() >0 ) 
		{
			for(FamilyReunification familyReunification : familyReunifications)
			{
				Familyreunification familyreunificationModel = new Familyreunification();
				familyreunificationModel.setId(UUID.randomUUID());
				familyreunificationModel.setDateCreated(BasicDataGenerator.getLocalDate(familyReunification.getDateCreated()));
				familyreunificationModel.setDateUpdated(BasicDataGenerator.getLocalDate(familyReunification.getDateUpdated()));
				familyreunificationModel.setFamilyreunificationachieved(FamilyreunificationFamilyreunificationachievedEnum.lookupEnum(BasicDataGenerator.getStringValue(familyReunification.getFamilyReunificationAchieved())));
				Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(familyReunification.getExitID()));
				familyreunificationModel.setExitid(exit);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				familyreunificationModel.setExport(exportEntity);
				exportEntity.addFamilyreunification(familyreunificationModel);
				insertOrUpdate(familyreunificationModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Familyreunification> familyreunifications = export.getFamilyreunifications();
		if(familyreunifications !=null && !familyreunifications.isEmpty()) {
			for(Familyreunification familyreunification : familyreunifications) {
				if(familyreunification != null) {
					com.servinglynk.hmis.warehouse.model.live.Familyreunification target = new com.servinglynk.hmis.warehouse.model.live.Familyreunification();
					BeanUtils.copyProperties(familyreunification, target,getNonCollectionFields(target));
					insert(target);
				}
			}
		}
		
	}

}
