package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntrySSVF;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.EntrySSVFPercentAMIEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryssvfDaoImpl extends ParentDaoImpl implements EntryssvfDao{
	private static final Logger logger = LoggerFactory
			.getLogger(EntryssvfDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class, getProjectGroupCode(domain));
		List<EntrySSVF> entrySSVFs = export.getEntrySSVF();
		if (entrySSVFs != null && entrySSVFs.size() > 0) {
			for (EntrySSVF entrySSVF : entrySSVFs) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entrySsvfModel = null;
				try {
					entrySsvfModel = getModelObject(domain, entrySSVF,data,modelMap);
					entrySsvfModel.setAddressDataQuality(new Integer(entrySSVF.getAddressDataQuality()).intValue());
					entrySsvfModel.setDeleted(false);
					entrySsvfModel.setHpScreeningScore(new Integer(entrySSVF.getHPScreeningScore()).intValue());
					entrySsvfModel.setLastPermanentCity(entrySSVF.getLastPermanentCity());
					entrySsvfModel.setLastPermanentState(entrySSVF.getLastPermanentState());
					entrySsvfModel.setLastPermanentStreet(entrySSVF.getLastPermanentStreet());
					entrySsvfModel.setLastPermanentZip(new Integer(entrySSVF.getLastPermanentZIP()).toString());
					entrySsvfModel.setPercentami(EntrySSVFPercentAMIEnum.lookupEnum(BasicDataGenerator.getStringValue(entrySSVF.getPercentAMI())));
					entrySsvfModel.setVamcStation(entrySSVF.getVAMCStation());
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, entrySSVF.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					entrySsvfModel.setEnrollmentid(enrollmentModel);
					entrySsvfModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entrySSVF.getDateCreated()));
					entrySsvfModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entrySSVF.getDateUpdated()));
					entrySsvfModel.setExport(exportEntity);
					entrySsvfModel.setSync(false);
					performSaveOrUpdate(entrySsvfModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the entryRhy::"+entrySSVF.getEntrySSVFID() +" Exception ::"+e.getMessage();
					if(entrySsvfModel != null){
						Error2015 error = new Error2015();
						error.model_id = entrySsvfModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = entrySsvfModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = entrySsvfModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
	  }
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class.getSimpleName(), domain,exportEntity);
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Entryssvf getModelObject(ExportDomain domain, EntrySSVF entryssvf ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvfModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			entryssvfModel = (com.servinglynk.hmis.warehouse.model.v2015.Entryssvf) getModel(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class, entryssvf.getEntrySSVFID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(entryssvfModel == null) {
			entryssvfModel = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
			entryssvfModel.setId(UUID.randomUUID());
			entryssvfModel.setRecordToBeInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(entryssvfModel, domain,entryssvf.getEntrySSVFID(),data,modelMap);
		return entryssvfModel;
	}

	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entrySsvf) {
			if(entrySsvf !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf target = new com.servinglynk.hmis.warehouse.model.v2015.Entryssvf();
				BeanUtils.copyProperties(entrySsvf, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, entrySsvf.getExport().getId());
				exportEntity.addEntryssvf(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvfByDedupCliendId = getEntryssvfByDedupEntryssvfId(entrySsvf.getId(),entrySsvf.getProjectGroupCode());
				if(entryssvfByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Entryssvf createEntryssvf(Entryssvf entryssvf) {
		entryssvf.setId(UUID.randomUUID());
			insert(entryssvf);
		return entryssvf;
	}


	@Override
	public Entryssvf updateEntryssvf(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvf) {
			update(entryssvf);
		return entryssvf;
	}


	@Override
	public void deleteEntryssvf(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf entryssvf) {
			delete(entryssvf);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryssvf getEntryssvfById(UUID entrySsvfId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);
		criteria.add(Restrictions.eq("id", entrySsvfId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entrySsvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria);
		if(entrySsvf.size()>0) return entrySsvf.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryssvf getEntryssvfByDedupEntryssvfId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entryssvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria);
		if(entryssvf !=null && entryssvf.size()>0) return entryssvf.get(0);
		return null;
	}
	/*public com.servinglynk.hmis.warehouse.model.stagv2015.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2015.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.stagv2015.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> getAllEntryssvf(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> entryssvf = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf>) findByCriteria(criteria,startIndex,maxItems);
		return entryssvf;
	}
	
	
	public long getEntryssvfCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		return countRows(criteria);
	}

	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryssvf> getAllEnrollmentEntryssvfs(UUID enrollmentId, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		criteria.createAlias("enrollmentid", "enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id",enrollmentId));
		return (List<Entryssvf>) findByCriteria(criteria,startIndex,maxItems);
	}

	
	public long getEnrollmentEntryssvfsCount(UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryssvf.class);	
		criteria.createAlias("enrollmentid", "enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id",enrollmentId));
		return countRows(criteria);
	}


}
