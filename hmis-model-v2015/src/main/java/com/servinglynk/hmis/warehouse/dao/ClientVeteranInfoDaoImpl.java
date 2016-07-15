/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo;
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
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ClientVeteranInfoDaoImpl extends ParentDaoImpl implements ClientVeteranInfoDao {

	private static final Logger logger = LoggerFactory
			.getLogger(ClientVeteranInfoDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		Export export = domain.getExport();
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo> veteranInfoList = export
				.getClientVeteranInfo();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class, getProjectGroupCode(domain));
		if (veteranInfoList != null && !veteranInfoList.isEmpty()) {
			for (com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo veteranInfo : veteranInfoList) {
				try {
				com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo vInfo = getModelObject(domain, veteranInfo,data,modelMap);
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
				vInfo.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateCreated()));
				vInfo.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateUpdated()));
				com.servinglynk.hmis.warehouse.model.v2015.Client client = (com.servinglynk.hmis.warehouse.model.v2015.Client) getModel(com.servinglynk.hmis.warehouse.model.v2015.Client.class, veteranInfo.getPersonalID(),getProjectGroupCode(domain),true,relatedModelMap);
				vInfo.setClient(client);
				vInfo.setExport(exportEntity);
				vInfo.setUserId(exportEntity.getUserId());
				if(exportEntity !=null)
					exportEntity.addClientVeteranInfo(vInfo);
				performSaveOrUpdate(vInfo);
				} catch(Exception e ){
					logger.error("Exception beause of the client::"+veteranInfo.getClientVeteranInfoID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i, data.j, com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class.getSimpleName(), domain, exportEntity);
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo getModelObject(ExportDomain domain, ClientVeteranInfo clientVeteranInfo,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo clientVeteranInfoModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			clientVeteranInfoModel = (com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo) getModel(com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo.class, clientVeteranInfo.getClientVeteranInfoID(), getProjectGroupCode(domain),false,modelMap);
		
		if(clientVeteranInfoModel == null) {
			clientVeteranInfoModel = new com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo();
			clientVeteranInfoModel.setId(UUID.randomUUID());
			clientVeteranInfoModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(clientVeteranInfoModel, domain,clientVeteranInfo.getClientVeteranInfoID(),data.i+data.j);
		return clientVeteranInfoModel;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

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
