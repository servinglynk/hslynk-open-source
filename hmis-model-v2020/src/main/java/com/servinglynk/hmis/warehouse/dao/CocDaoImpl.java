
package com.servinglynk.hmis.warehouse.dao;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ProjectCoC;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.GeographyTypeEnum;
import com.servinglynk.hmis.warehouse.model.v2020.Coc;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.HMISTypeModel;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2020.Project;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class CocDaoImpl  extends ParentDaoImpl implements CocDao{
	private static final Logger logger = LoggerFactory
			.getLogger(CocDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
	    Export export = domain.getExport();
	    com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) getModel(com.servinglynk.hmis.warehouse.model.v2020.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Coc.class, getProjectGroupCode(domain));
		List<ProjectCoC> cocs = export.getCoC();
		if (CollectionUtils.isNotEmpty(cocs)) {
			for (ProjectCoC coc : cocs) {
				com.servinglynk.hmis.warehouse.model.v2020.Coc cocModel = null;
				try {
					cocModel = getModelObject(domain, coc,data,modelMap);
					if(cocModel.isIgnored()) {
						continue;
					}
					cocModel.setCoccode(coc.getCoCCode());
					cocModel.setAddress1(coc.getAddress1());
					cocModel.setAddress2(coc.getAddress2());
					cocModel.setCity(coc.getCity());
					cocModel.setGeoCode(coc.getGeoCode());
					cocModel.setExport(exportEntity);
					cocModel.setGeographyType(GeographyTypeEnum.lookupEnum(coc.getGeographyType()));
					cocModel.setState(coc.getState());
					cocModel.setZip(coc.getZip());
					Project project = (Project) getModel(Project.class,coc.getProjectID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					cocModel.setProjectid(project);
					cocModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(coc.getDateCreated()));
					cocModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(coc.getDateUpdated()));
					cocModel.setExport(exportEntity);
					performSaveOrUpdate(cocModel,domain);
				}catch(Exception e) {
					String errorMessage = "Exception beause of the Coc::"+coc.getCoCCode() +" Exception ::"+e.getMessage();
					if(cocModel != null){
						Error2020 error = new Error2020();
						error.model_id = cocModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = cocModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = cocModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
	}
		hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2020.Coc.class.getSimpleName(), domain, exportEntity);
	
	}
	
	public  com.servinglynk.hmis.warehouse.model.v2020.Coc getModelObject(ExportDomain domain, ProjectCoC coc,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2020.Coc modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2020.Coc) getModel(com.servinglynk.hmis.warehouse.model.v2020.Coc.class, coc.getCoCCode(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(domain.isReUpload()) {
			if(modelFromDB != null) {
				return modelFromDB;
			}
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Coc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
			data.i++;
			return modelFromDB;
		}
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2020.Coc();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true); 
			data.i++;
		}else {
			com.servinglynk.hmis.warehouse.model.v2020.Coc model = new com.servinglynk.hmis.warehouse.model.v2020.Coc();
			// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(coc.getDateUpdated()));
			performMatch(domain, modelFromDB, model, data);
		}
		hydrateCommonFields(modelFromDB, domain,coc.getCoCCode(),data);
		return modelFromDB;
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.v2020.Coc coc) {
			if(coc !=null) {
				com.servinglynk.hmis.warehouse.model.v2020.Coc target = new com.servinglynk.hmis.warehouse.model.v2020.Coc();
				BeanUtils.copyProperties(coc, target, new String[] {"enrollments","veteranInfoes"});
				com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) get(com.servinglynk.hmis.warehouse.model.v2020.Export.class, coc.getExport().getId());
				exportEntity.addCoc(target);
				target.setExport(exportEntity);
				com.servinglynk.hmis.warehouse.model.v2020.Coc clientByDedupCliendId = getCocByDedupCliendId(coc.getId(),coc.getProjectGroupCode());
				if(clientByDedupCliendId ==null) {
					insert(target);	
				}
			}
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

	   public com.servinglynk.hmis.warehouse.model.v2020.Project createProject(com.servinglynk.hmis.warehouse.model.v2020.Project project){
	       insert(project);
	       return project;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Project updateProject(com.servinglynk.hmis.warehouse.model.v2020.Project project){
	       update(project);
	       return project;
	   }
	   public void deleteProject(com.servinglynk.hmis.warehouse.model.v2020.Project project){
	       delete(project);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2020.Project getProjectById(UUID projectId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2020.Project) get(com.servinglynk.hmis.warehouse.model.v2020.Project.class, projectId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2020.Project> getAllProjects(Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Project.class);
	       return (List<com.servinglynk.hmis.warehouse.model.v2020.Project>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getProjectCount(){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Project.class);
	       return countRows(criteria);
	   }

	   
	 
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Coc createCoc(
			com.servinglynk.hmis.warehouse.model.v2020.Coc coc) {
			coc.setId(UUID.randomUUID());
			insert(coc);
		return coc;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Coc updateCoc(
			com.servinglynk.hmis.warehouse.model.v2020.Coc coc) {
			update(coc);
		return coc;
	}


	@Override
	public void deleteCoc(
			com.servinglynk.hmis.warehouse.model.v2020.Coc coc) {
			delete(coc);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2020.Coc getCocById(UUID cocId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);
		criteria.add(Restrictions.eq("id", cocId));
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria);
		if(coc.size()>0) return coc.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Coc getCocByDedupCliendId(UUID id,String projectGroupCode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		criteria.add(Restrictions.eq("projectGroupCode", projectGroupCode));
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}
	public com.servinglynk.hmis.warehouse.model.v2020.Coc getCocByDedupCliendIdFromStaging(UUID id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);
		criteria.add(Restrictions.eq("dedupClientId", id));
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria);
		if(coc !=null && coc.size()>0) return coc.get(0);
		return null;
	}

	public List<com.servinglynk.hmis.warehouse.model.v2020.Coc> getAllCoc(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);	
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria,startIndex,maxItems);
		return coc;
	}
	
	
	public long getCocCount(){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);	
		return countRows(criteria);
	}



	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2020.Coc> getAllCocsByDistictCocCode() {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);	
		ProjectionList projectionList = Projections.projectionList();	
		projectionList.add(Projections.distinct(Projections.property("coccode")),"coccode");
		criteria.setProjection(projectionList);
		criteria.setResultTransformer(Transformers.aliasToBean(com.servinglynk.hmis.warehouse.model.v2020.Coc.class));
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria);
		return coc;
	}



	@Override
	public long getCocsCount(UUID projectId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);	
		criteria.createAlias("projectid","projectid");
		criteria.add(Restrictions.eq("projectid.id", projectId));
		return countRows(criteria);
	}

	@Override
	public List<Coc> getAllCocs(UUID projectId, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2020.Coc.class);	
		criteria.createAlias("projectid","projectid");
		criteria.add(Restrictions.eq("projectid.id", projectId));
		List<com.servinglynk.hmis.warehouse.model.v2020.Coc> coc = (List<com.servinglynk.hmis.warehouse.model.v2020.Coc>) findByCriteria(criteria,startIndex,maxItems);
		return coc;
	}


}
