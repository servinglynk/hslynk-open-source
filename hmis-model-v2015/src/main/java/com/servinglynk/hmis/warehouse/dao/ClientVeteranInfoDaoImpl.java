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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
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
import com.servinglynk.hmis.warehouse.model.stagv2015.Client;
import com.servinglynk.hmis.warehouse.model.stagv2015.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientVeteranInfoDaoImpl extends ParentDaoImpl implements ClientVeteranInfoDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export = domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo> veteranInfoList = export
				.getClientVeteranInfo();
		hydrateBulkUploadActivityStaging(veteranInfoList, com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class.getSimpleName(), domain);
		if (veteranInfoList != null && !veteranInfoList.isEmpty()) {
			for (com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo veteranInfo : veteranInfoList) {

				ClientVeteranInfo vInfo = new ClientVeteranInfo();
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
				vInfo.setDateCreated(LocalDateTime.now());
				vInfo.setDateUpdated(LocalDateTime.now());
				vInfo.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateCreated()));
				vInfo.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateUpdated()));
				UUID clientId = domain.getClientPersonalIDMap().get(veteranInfo.getPersonalID());
				com.servinglynk.hmis.warehouse.model.stagv2015.Client client = (com.servinglynk.hmis.warehouse.model.stagv2015.Client) get(com.servinglynk.hmis.warehouse.model.stagv2015.Client.class, clientId);
				vInfo.setClient(client);
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				vInfo.setExport(exportEntity);
				vInfo.setUserId(exportEntity.getUserId());
				exportEntity.addClientVeteranInfo(vInfo);
				hydrateCommonFields(vInfo, domain);
				insert(vInfo);
			}
		}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2015.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2015.ClientVeteranInfo> veteranInfos = export.getClientVeteranInfoes();
		hydrateBulkUploadActivity(veteranInfos, com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class.getSimpleName(), export);
		if(veteranInfos !=null && !veteranInfos.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2015.ClientVeteranInfo veteranInfo : veteranInfos) {
				com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo target = new com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo();
				BeanUtils.copyProperties(veteranInfo, target, getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, veteranInfo.getExport().getId());
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Client clientModel = (com.servinglynk.hmis.warehouse.model.v2015.Client) get(com.servinglynk.hmis.warehouse.model.v2015.Client.class, veteranInfo.getClient().getId());
				target.setClient(clientModel);
				target.setDateCreated(LocalDateTime.now());
				target.setDateUpdated(LocalDateTime.now());
				insert(target);
			}
		}
	}

	@Override
	public void hydrateLive(Client client) {
		Set<ClientVeteranInfo> veteranInfoes = client.getClientVeteranInfoes();
		if(veteranInfoes !=null && !veteranInfoes.isEmpty()) {
			for(ClientVeteranInfo veteranInfo : veteranInfoes) {
				if(veteranInfo !=null) {
					com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo target = new com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo();
					BeanUtils.copyProperties(veteranInfo, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, client.getExport().getId());
					target.setExport(exportEntity);
					com.servinglynk.hmis.warehouse.model.v2015.Client clientModel = (com.servinglynk.hmis.warehouse.model.v2015.Client) get(com.servinglynk.hmis.warehouse.model.v2015.Client.class, client.getId());
					target.setClient(clientModel);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
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


	   public com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo veteranInfo){
	       veteranInfo.setId(UUID.randomUUID());
	       insert(veteranInfo);
	       return veteranInfo;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo veteranInfo){
	       update(veteranInfo);
	       return veteranInfo;
	   }
	   public void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo veteranInfo){
	       delete(veteranInfo);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo getVeteranInfoById(UUID veteranInfoId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo) get(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class, veteranInfoId);
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getClientVeteranInfosCount(UUID clientId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return countRows(criteria);
	   }
}
