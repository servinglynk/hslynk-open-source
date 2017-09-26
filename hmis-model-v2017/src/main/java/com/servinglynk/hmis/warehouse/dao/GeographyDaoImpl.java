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

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.GeographyEnum;
import com.servinglynk.hmis.warehouse.model.v2017.Error2017;
import com.servinglynk.hmis.warehouse.model.v2017.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;


/**
 * @author Sandeep
 *
 */
public class GeographyDaoImpl extends ParentDaoImpl implements GeographyDao {
	private static final Logger logger = LoggerFactory.getLogger(GeographyDaoImpl.class);
	
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Geography> expGeography = domain.getExport().getGeography();
		com.servinglynk.hmis.warehouse.model.v2017.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2017.Export) getModel(com.servinglynk.hmis.warehouse.model.v2017.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2017.Geography.class, getProjectGroupCode(domain));
		if(expGeography !=null && !expGeography.isEmpty())
		{
				for(com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Geography expGeographies : expGeography)
				{
					com.servinglynk.hmis.warehouse.model.v2017.Geography geographyModel = null;
					try {
						geographyModel = getModelObject(domain, expGeographies, data, modelMap);
						geographyModel.setAddress1(expGeographies.getAddress1());
						geographyModel.setAddress2(expGeographies.getAddress2());
						geographyModel.setCity(expGeographies.getCity());
						geographyModel.setGeoCode(GeographyEnum.lookupEnum(expGeographies.getGeoCode()));
						geographyModel.setGeographyType(expGeographies.getGeographyType());
						geographyModel.setInformationDate(BasicDataGenerator.getLocalDateTime(expGeographies.getInformationDate()));
						geographyModel.setState(expGeographies.getState());
						geographyModel.setZip(expGeographies.getZip());
						
						performSaveOrUpdate(geographyModel);
					}catch(Exception e ){
						String errorMessage = "Exception beause of the Geography ::"+expGeographies.getGeographyID() +" Exception ::"+e.getMessage();
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

	public com.servinglynk.hmis.warehouse.model.v2017.Geography getModelObject(ExportDomain domain, com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Geography expGeography ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2017.Geography modelFromDB = null;
		if(!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2017.Geography) getModel(com.servinglynk.hmis.warehouse.model.v2017.Geography.class, expGeography.getGeographyID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2017.Geography();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2017.Geography model = new com.servinglynk.hmis.warehouse.model.v2017.Geography();
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(expGeography.getInformationDate()));
		performMatch(domain, modelFromDB, model, data);
		hydrateCommonFields(model, domain,expGeography.getGeographyID(),data);
		return model;
	}
	
	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Geography createGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography) {
		geography.setId(UUID.randomUUID());
		insert(geography);
		return geography;
	}


	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Geography updateGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography) {
			update(geography);
		return geography;
	}


	@Override
	public void deleteGeography(com.servinglynk.hmis.warehouse.model.v2017.Geography geography) {
			delete(geography);
		
	}


	@SuppressWarnings("unchecked")
	@Override
	public com.servinglynk.hmis.warehouse.model.v2017.Geography getGeographyById(UUID geographyId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);
		criteria.add(Restrictions.eq("id", geographyId));
		List<com.servinglynk.hmis.warehouse.model.v2017.Geography> geography = (List<com.servinglynk.hmis.warehouse.model.v2017.Geography>) findByCriteria(criteria);
		if(geography.size()>0) return geography.get(0);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<com.servinglynk.hmis.warehouse.model.v2017.Geography> getAllGeography(Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);	
		List<com.servinglynk.hmis.warehouse.model.v2017.Geography> geography = (List<com.servinglynk.hmis.warehouse.model.v2017.Geography>) findByCriteria(criteria,startIndex,maxItems);
		return geography;
	}
	
	
	public long getGeographyCount(String geoCode){
		DetachedCriteria criteria = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2017.Geography.class);	
		return countRows(criteria);
	}

}
