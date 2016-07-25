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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitPATH;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitPathConnectionWithSOAREnum;
import com.servinglynk.hmis.warehouse.model.v2015.Exitpath;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class ExitpathDaoImpl extends ParentDaoImpl implements ExitpathDao{
	private static final Logger logger = LoggerFactory
			.getLogger(ExitpathDaoImpl.class);
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
	    com.servinglynk.hmis.warehouse.domain.Sources.Source.Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class, getProjectGroupCode(domain));
		List<ExitPATH> exitpath = export.getExitPATH();
		if (exitpath != null && exitpath.size() > 0) {
			for (ExitPATH exitpaths : exitpath) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpathModel = null;
				try {
					exitpathModel = getModelObject(domain, exitpaths,data,modelMap);
					exitpathModel.setConnectionWithSoar(ExitPathConnectionWithSOAREnum.lookupEnum(BasicDataGenerator.getStringValue(exitpaths.getConnectionWithSOAR())));
					com.servinglynk.hmis.warehouse.model.v2015.Exit exit = (com.servinglynk.hmis.warehouse.model.v2015.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, exitpaths.getExitID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					exitpathModel.setExitid(exit);
					exitpathModel.setDeleted(false);
					exitpathModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitpaths.getDateCreated()));
					exitpathModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitpaths.getDateUpdated()));
					exitpathModel.setExport(exportEntity);
					exitpathModel.setSync(false);
					performSaveOrUpdate(exitpathModel);
				} catch(Exception e) {
					String errorMessage = "Exception beause of the exitpath::"+exitpaths.getExitPATHID() +" Exception ::"+e.getMessage();
					if(exitpathModel != null){
						Error2015 error = new Error2015();
						error.model_id = exitpathModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = exitpathModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = exitpathModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
	
	}

	public com.servinglynk.hmis.warehouse.model.v2015.Exitpath getModelObject(ExportDomain domain, ExitPATH exitpath ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpathModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			exitpathModel = (com.servinglynk.hmis.warehouse.model.v2015.Exitpath) getModel(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class, exitpath.getExitPATHID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(exitpathModel == null) {
			exitpathModel = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
			exitpathModel.setId(UUID.randomUUID());
			exitpathModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(exitpathModel, domain,exitpath.getExitPATHID(),data.i+data.j);
		return exitpathModel;
	}

	
	@Override
	public void hydrateLive(com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpath) {
			if(exitpath !=null) {
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath target = new com.servinglynk.hmis.warehouse.model.v2015.Exitpath();
				BeanUtils.copyProperties(exitpath, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, exitpath.getExport().getId());
				exportEntity.addExitpath(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpathByDedupCliendId = getExitpathByDedupExitpathId(exitpath.getId(),exitpath.getProjectGroupCode());
				if(exitpathByDedupCliendId ==null) {
					insert(target);	
				}
			}
	}
	
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Exitpath createExitpath(Exitpath exitpath) {
		exitpath.setId(UUID.randomUUID());
			insert(exitpath);
		return exitpath;
	}


	@Override
	public Exitpath updateExitpath(com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpath) {
			update(exitpath);
		return exitpath;
	}


	@Override
	public void deleteExitpath(com.servinglynk.hmis.warehouse.model.v2015.Exitpath exitpath) {
			delete(exitpath);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitpath getExitpathById(UUID exitpathId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
		criteria.add(Restrictions.eq("id", exitpathId));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria);
		if(exitpath.size()>0) return exitpath.get(0);
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2015.Exitpath getExitpathByDedupExitpathId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria);
		if(exitpath !=null && exitpath.size()>0) return exitpath.get(0);
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
	public List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> getAllExitpath(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);	
		List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> exitpath = (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria,startIndex,maxItems);
		return exitpath;
	}
	
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath> getAllExitExitpaths(UUID exitId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Exitpath>) findByCriteria(criteria,startIndex,maxItems);
	   }
	
	public long getExitExitpathsCount(UUID exitId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);
	       criteria.createAlias("exitid", "exitid");
	       criteria.add(Restrictions.eq("exitid.id", exitId));
	       return countRows(criteria);
	   }
	
	public long getExitpathCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exitpath.class);	
		return countRows(criteria);
	}

}
