/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
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
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
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
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class, String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap, domain.getUpload().getId());
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class, getProjectGroupCode(domain));
		if (CollectionUtils.isNotEmpty(veteranInfoList)) {
			for (com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ClientVeteranInfo veteranInfo : veteranInfoList) {
				com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo vInfo = null;
				try {
					vInfo = getModelObject(domain, veteranInfo, data, modelMap);
					if(vInfo.isIgnored()) {
						vInfo.setAfghanistanOef(VeteranInfoAfghanistanOefEnum
								.lookupEnum(veteranInfo
												.getAfghanistanOEF()));
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
								.lookupEnum(veteranInfo
												.getOtherTheater()));
						vInfo.setKoreanWar(VeteranInfoKoreanWarEnum
								.lookupEnum(veteranInfo
												.getVietnamWar()));
						vInfo.setMilitaryBranch(VeteranInfoMilitaryBranchEnum
								.lookupEnum(veteranInfo
												.getMilitaryBranch()));
						vInfo.setVietnamWar(VeteranInfoVietnamWarEnum
								.lookupEnum(veteranInfo
												.getVietnamWar()));
						vInfo.setWorldWar2(VeteranInfoWorldWar2Enum
								.lookupEnum(veteranInfo
												.getWorldWarII()));
						vInfo.setYearEntrdService(new Integer(veteranInfo
								.getYearEnteredService()));
						vInfo.setYearSeperated(new Integer(veteranInfo
								.getYearSeparated()));
						vInfo.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateCreated()));
						vInfo.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(veteranInfo.getDateUpdated()));
						com.servinglynk.hmis.warehouse.model.v2020.Client client = (com.servinglynk.hmis.warehouse.model.v2020.Client) getModel(com.servinglynk.hmis.warehouse.model.v2020.Client.class, veteranInfo.getPersonalID(), getProjectGroupCode(domain), true, relatedModelMap, domain.getUpload().getId());
						vInfo.setClient(client);
						vInfo.setExport(exportEntity);
						performSaveOrUpdate(vInfo,domain);
					}
				} catch (Exception e) {
					String errorMessage = "Exception because of the client::" + veteranInfo.getClientVeteranInfoID() + " Exception ::" + e.getMessage();
					if(vInfo != null){
						Error2020 error = new Error2020();
						error.model_id = vInfo.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = vInfo.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = vInfo.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class.getSimpleName(), domain, exportEntity);
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo getModelObject(ExportDomain domain, ClientVeteranInfo clientVeteranInfo,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo) getModel(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class, clientVeteranInfo.getClientVeteranInfoID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
			return modelFromDB;
		}
		com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo model = new com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(clientVeteranInfo.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,clientVeteranInfo.getClientVeteranInfoID(),data);
		return model;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}
	   public com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo createVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo){
	       veteranInfo.setId(UUID.randomUUID());
	       insert(veteranInfo);
	       return veteranInfo;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo updateVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo){
	       update(veteranInfo);
	       return veteranInfo;
	   }
	   public void deleteVeteranInfo(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo veteranInfo){
	       delete(veteranInfo);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo getVeteranInfoById(UUID veteranInfoId){
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class);
		      criteria.add(Restrictions.eq("id", veteranInfoId));
		      List<com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo> entities = (List<com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }

	   @SuppressWarnings("unchecked")
	   public List<com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo> getAllClientVeteranInfos(UUID clientId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getClientVeteranInfosCount(UUID clientId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo.class);
	       criteria.createAlias("client", "client");
	       criteria.add(Restrictions.eq("client.id", clientId));
	       return countRows(criteria);
	   }
}
