/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;

/**
 * @author Sandeep
 *
 */
public class SourceDaoImpl extends ParentDaoImpl implements SourceDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) {
		Source source = domain.getSource();
		List<Source> sources = new ArrayList<>();
		sources.add(source);
		Data data = new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Source.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Source sourceModel = getModelObject(domain, source,data,modelMap);
		sourceModel.setSoftwarevendor(source.getSoftwareVendor());
		//sourceModel.setSoftwareversion(BasicDataGenerator.getStringValue(source.getSoftwareVersion()));
		sourceModel.setSourcecontactemail(source.getSourceContactEmail());
		sourceModel.setSourcecontactextension(String.valueOf(source.getSourceContactExtension()));
		sourceModel.setSourcecontactfirst(source.getSourceContactFirst());
		sourceModel.setSourcecontactlast(source.getSourceContactLast());
		sourceModel.setSourceid(String.valueOf(source.getSourceID()));
		sourceModel.setSourcename(source.getSourceName());
		performSaveOrUpdate(sourceModel);
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Source.class.getSimpleName(), domain,null);
	}
	
	
	public com.servinglynk.hmis.warehouse.model.v2014.Source getModelObject(ExportDomain domain, Source source ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Source sourceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			sourceModel = (com.servinglynk.hmis.warehouse.model.v2014.Source) getModel(com.servinglynk.hmis.warehouse.model.v2014.Source.class, source.getSourceID(), getProjectGroupCode(domain),false,modelMap);
		
		if(sourceModel == null) {
			sourceModel = new com.servinglynk.hmis.warehouse.model.v2014.Source();
			sourceModel.setId(UUID.randomUUID());
			sourceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(sourceModel, domain,source.getSourceID(),data.i+data.j);
		return sourceModel;
	}

}
