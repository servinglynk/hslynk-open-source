package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.lang.model.type.ErrorType;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.Geography;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class GeographyDaoImpl  extends ParentDaoImpl implements GeographyDao {
	

	private static final Logger logger = LoggerFactory.getLogger(GeographyDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		 List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Geography> geography = domain.getExport().getGeography();
		 com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		 Data data =new Data();
		 Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Geography.class, getProjectGroupCode(domain));
		 if(geography != null && !geography.isEmpty())
		 {
			 for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Geography geo : geography)
			 {
				 com.servinglynk.hmis.warehouse.model.v2017.Geography geographyModel = null;
				 try {
					 geographyModel = getModelObject(domain, geo,data,modelMap);
					 geographyModel.setAddress1(geo.getAddress1());
					 geographyModel.setAddress2(geo.getAddress2());
					 geographyModel.setCity(geo.getCity());
					 geographyModel.setState(geo.getState());
					 geographyModel.setGeoCode(geo.getGeoCode());
					 geographyModel.setGeography_type(geo.getGeography_type());
					 geographyModel.setZip(geo.getZip());
					 geographyModel.setInformationDate(geo.getInformationDate());
					 performSaveOrUpdate(geographyModel);
				 } catch(Exception e){
					 String errorMessage = "Exception because of the geography::"+geo.getId() +" Exception ::"+e.getMessage();
					 if(geographyModel != null){
						 Error2017 error = new Error2017();
						 error.model_id = geographyModel.getId();
						 error.bulk_upload_ui = domain.getUpload().getId();
						 error.project_group_code = domain.getUpload().getProjectGroupCode();
						 error.source_system_id = geographyModel.getSourceSystemId();
						 error.type = ErrorType.ERROR;
						 error.error_description = errorMessage;
						 error.date_created = geographyModel.getDateCreated();
						 performSave(error);
					 }
					 logger.error(errorMessage);
				 }
			 }
		 }
		 hydrateBulkUploadActivityStaging(data.i,data.j,data.ignore, com.servinglynk.hmis.warehouse.model.v2017.Geography.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2017.Geography getModelObject(ExportDomain domain, Geography geography ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Geography modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Geography) getModel(com.servinglynk.hmis.warehouse.model.v2017.Geography.class, geography.getId(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Geography();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Geography model = new com.servinglynk.hmis.warehouse.model.v2017.Geography();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB, model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(geography.getInformationDate()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,geography.getId(),data);
		return model;
	}
	   public com.servinglynk.hmis.warehouse.model.v2017.Geography createGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography){
		   geography.setId(UUID.randomUUID());
	       insert(geography);
	       GeographyEntity entity = new GeographyEntity();
	       BeanUtils.copyProperties(geography, entity);
	       insert(entity);
	       return geography;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Geography updateGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography){
	       update(geography);
	       return geography;
	   }
	   public void deleteGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography){
	       delete(geography);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2017.Geography getGeographyById(UUID geographyId){ 
		      DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);
		      criteria.add(Restrictions.eq("id", geographyId));
		      List<com.servinglynk.hmis.warehouse.model.v2017.Geography> entities = (List<com.servinglynk.hmis.warehouse.model.v2017.Geography>) findByCriteria(criteria);
		      if(!entities.isEmpty()) return entities.get(0);
		      return null;
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2017.Geography> getAllGeography(String geoCode,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);
	       criteria.add(Restrictions.eq("geoCode", geoCode));
	       return (List<com.servinglynk.hmis.warehouse.model.v2017.Geography>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getGeographyCount(String geoCode){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);
	       criteria.add(Restrictions.eq("geoCode", geoCode));
	       return countRows(criteria);
	   }

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



}
