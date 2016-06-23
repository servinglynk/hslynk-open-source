/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
import com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class VeteranInfoDaoImpl extends ParentDaoImpl implements VeteranInfoDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(VeteranInfoDaoImpl.class);
	
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export = domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.VeteranInfo> veteranInfoList = export
				.getVeteranInfo();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		hydrateBulkUploadActivityStaging(veteranInfoList, com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo.class.getSimpleName(), domain);
		int i=0;
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
				vInfo.setDateCreated(LocalDateTime.now());
				vInfo.setDateUpdated(LocalDateTime.now());
				vInfo.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateCreated()));
				vInfo.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateUpdated()));
				UUID clientId = domain.getClientPersonalIDMap().get(veteranInfo.getPersonalID());
				if(clientId !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Client client = (com.servinglynk.hmis.warehouse.model.v2014.Client) get(com.servinglynk.hmis.warehouse.model.v2014.Client.class, clientId);
					vInfo.setClient(client);
				}else{
					logger.warn("A match was not found with the PersonID:{}",veteranInfo.getPersonalID());
				}
				vInfo.setExport(exportEntity);
				//vInfo.setUser(exportEntity.getUser());
				exportEntity.addVeteranInfo(vInfo);
				i++;
				hydrateCommonFields(vInfo, domain,veteranInfo.getVeteranInfoID(),i);
			}
		}
	}
	
	   public com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo){
	       veteranInfo.setId(UUID.randomUUID()); 
	       insert(veteranInfo);
	       return veteranInfo;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo){
	       update(veteranInfo);
	       return veteranInfo;
	   }
	   public void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo veteranInfo){
	       delete(veteranInfo);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo getVeteranInfoById(UUID veteranInfoId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo) get(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo.class, veteranInfoId);
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getClientVeteranInfosCount(UUID clientId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return countRows(criteria);
	   }
}
