package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EntryRHSP;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class EntryrhspDaoImpl extends ParentDaoImpl implements EntryrhspDao{
	private static final Logger logger = LoggerFactory
			.getLogger(EntryrhspDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class, getProjectGroupCode(domain));
		List<EntryRHSP> entryRhsps = export.getEntryRHSP();
		if (entryRhsps != null && entryRhsps.size() > 0) {
			for (EntryRHSP entryRhsp : entryRhsps) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhspModel = null;
				try {
					entryRhspModel = getModelObject(domain, entryRhsp,data,modelMap);
					entryRhspModel.setWorstHousingSituation(Integer.parseInt(entryRhsp.getWorstHousingSituation()));
					//Sandeep TODO: Why am I seeing projectID here it should be projectEntryID.
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, entryRhsp.getProjectID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					entryRhspModel.setEnrollmentid(enrollmentModel);
					entryRhspModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhsp.getDateCreated()));
					entryRhspModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryRhsp.getDateUpdated()));
					entryRhspModel.setExport(exportEntity);
					entryRhspModel.setSync(false);
					entryRhspModel.setDeleted(false);
					performSaveOrUpdate(entryRhspModel);
				} catch(Exception e) {
					 String errorMessage = "Exception beause of the entryRhsp::"+entryRhsp.getEntryRHSPID() +" Exception ::"+e.getMessage();
					if(entryRhspModel != null){
						Error2015 error = new Error2015();
						error.model_id = entryRhspModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = entryRhspModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = entryRhspModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
	   }
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class.getSimpleName(), domain,exportEntity);
	}

	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRshp) {
			if(entryRshp !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp target = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
				BeanUtils.copyProperties(entryRshp, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, entryRshp.getExport().getId());
				exportEntity.addEntryrhsp(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhspByDedupCliendId = getEntryrhspByDedupEntryrhspId(entryRshp.getId(),entryRshp.getProjectGroupCode());
				if(entryRhspByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp getModelObject(ExportDomain domain, EntryRHSP entryrhsp ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp) getModel(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class, entryrhsp.getEntryRHSPID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp model = new com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp();
		//org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(entryrhsp.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,entryrhsp.getEntryRHSPID(),data);
		return model;
	}

    
	private Date getDateInFormat(String dob) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
        	formatter = new SimpleDateFormat("yyyy-MM-dd");
              date = (Date)((DateFormat) formatter).parse(dob);
            
            String s = formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp createEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
		entryRhsp.setId(UUID.randomUUID());
			insert(entryRhsp);
		return entryRhsp;
	}


	@Override
	public Entryrhsp updateEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
			update(entryRhsp);
		return entryRhsp;
	}


	@Override
	public void deleteEntryrhsp(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp entryRhsp) {
			delete(entryRhsp);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp getEntryrhspById(UUID entryrhspId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);
		criteria.add(Restrictions.eq("id", entryrhspId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria);
		if(entryrhsp.size()>0) return entryrhsp.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp getEntryrhspByDedupEntryrhspId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);
		if(id == null || projectGroupCode == null) return null;
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria);
		if(entryrhsp !=null && entryrhsp.size()>0) return entryrhsp.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> getAllEntryrhsp(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp> entryrhsp = (List<com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp>) findByCriteria(criteria,startIndex,maxItems);
		return entryrhsp;
	}
	
	
	public long getEntryrhspCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp.class);	
		return countRows(criteria);
	}


	public List<Entryrhsp> getAllEnrollmentEntryrhsps(UUID enrollmentId, Integer startIndex, Integer maxItems) {
			DetachedCriteria criteria = DetachedCriteria.forClass(Entryrhsp.class);
			criteria.createAlias("enrollmentid","enrollmentid");
			criteria.add(Restrictions.eq("enrollmentid.id",enrollmentId));
		return (List<Entryrhsp>) findByCriteria(criteria,startIndex,maxItems);
	}

	public long getEnrollmentEntryrhspsCount(UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Entryrhsp.class);
		criteria.createAlias("enrollmentid","enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id",enrollmentId));
		return countRows(criteria);
	}

}
