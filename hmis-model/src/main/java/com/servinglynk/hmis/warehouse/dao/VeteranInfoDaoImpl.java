/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoAfghanistanOefEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDesertStormEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoDischargeStatusEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOifEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoIraqOndEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoKoreanWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoMilitaryBranchEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoOtherTheaterEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoVietnamWarEnum;
import com.servinglynk.hmis.warehouse.enums.VeteranInfoWorldWar2Enum;
import com.servinglynk.hmis.warehouse.model.staging.Client;
import com.servinglynk.hmis.warehouse.model.staging.VeteranInfo;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class VeteranInfoDaoImpl extends ParentDaoImpl implements VeteranInfoDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export = domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VeteranInfo> veteranInfoList = export
				.getVeteranInfo();
		if (veteranInfoList != null && !veteranInfoList.isEmpty()) {
			for (com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VeteranInfo veteranInfo : veteranInfoList) {
				
				VeteranInfo vInfo = new VeteranInfo();
				vInfo.setAfghanistanOef(VeteranInfoAfghanistanOefEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getAfghanistanOEF())));
				vInfo.setDesertStorm(VeteranInfoDesertStormEnum
						.lookupEnum(String.valueOf(veteranInfo
								.getDesertStorm())));
				vInfo.setDischargeStatus(VeteranInfoDischargeStatusEnum
						.lookupEnum(String.valueOf(veteranInfo
								.getDischargeStatus())));
				vInfo.setIraqOif(VeteranInfoIraqOifEnum
						.lookupEnum(String.valueOf(veteranInfo
								.getIraqOIF())));
				vInfo.setIraqOnd(VeteranInfoIraqOndEnum
						.lookupEnum(String.valueOf(veteranInfo
								.getIraqOND())));
				vInfo.setOtherTheater(VeteranInfoOtherTheaterEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getOtherTheater())));
				vInfo.setKoreanWar(VeteranInfoKoreanWarEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getVietnamWar())));
				vInfo.setMilitaryBranch(VeteranInfoMilitaryBranchEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getMilitaryBranch())));
				vInfo.setVietnamWar(VeteranInfoVietnamWarEnum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getVietnamWar())));
				vInfo.setWorldWar2(VeteranInfoWorldWar2Enum
						.lookupEnum(BasicDataGenerator
								.getStringValue(veteranInfo
										.getWorldWarII())));
				vInfo.setYearEntrdService(new Integer(veteranInfo
						.getYearEnteredService()));
				vInfo.setYearSeperated(new Integer(veteranInfo
						.getYearSeparated()));
				vInfo.setId(UUID.randomUUID());
				UUID clientId = domain.getClientPersonalIDMap().get(veteranInfo.getPersonalID());
				com.servinglynk.hmis.warehouse.model.staging.Client client = (com.servinglynk.hmis.warehouse.model.staging.Client) get(com.servinglynk.hmis.warehouse.model.staging.Client.class, clientId);
				vInfo.setClient(client);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				vInfo.setExport(exportEntity);
				exportEntity.addVeteranInfo(vInfo);
				insert(vInfo);
			}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
				throw new UnsupportedOperationException("This method is not supported");
	}
	
	@Override
	public void hydrateLive(Client client) {
		Set<VeteranInfo> veteranInfoes = client.getVeteranInfoes();
		if(veteranInfoes !=null && !veteranInfoes.isEmpty()) {
			for(VeteranInfo veteranInfo : veteranInfoes) {
				if(veteranInfo !=null) {
					com.servinglynk.hmis.warehouse.model.live.VeteranInfo target = new com.servinglynk.hmis.warehouse.model.live.VeteranInfo();
					BeanUtils.copyProperties(veteranInfo, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, client.getExport().getId());
					target.setExport(exportEntity);
					com.servinglynk.hmis.warehouse.model.live.Client clientModel = (com.servinglynk.hmis.warehouse.model.live.Client) get(com.servinglynk.hmis.warehouse.model.live.Client.class, client.getId());
					target.setClient(clientModel);
					insert(target);
				}
			}
		}
	}
}
