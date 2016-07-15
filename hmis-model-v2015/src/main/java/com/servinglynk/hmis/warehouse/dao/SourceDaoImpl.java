/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;

/**
 * @author Sandeep
 *
 */
public class SourceDaoImpl extends ParentDaoImpl implements SourceDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Source source = domain.getSource();
		Data data = new Data();
		com.servinglynk.hmis.warehouse.model.v2015.Source sourceModel = getModelObject(domain, source, data);
		sourceModel.setSoftwarevendor(source.getSoftwareVendor());
		//sourceModel.setSoftwareversion(BasicDataGenerator.getStringValue(source.getSoftwareVersion()));
		sourceModel.setSourcecontactemail(source.getSourceContactEmail());
		sourceModel.setSourcecontactextension(String.valueOf(source.getSourceContactExtension()));
		sourceModel.setSourcecontactfirst(source.getSourceContactFirst());
		sourceModel.setSourcecontactlast(source.getSourceContactLast());
		sourceModel.setSourceid(String.valueOf(source.getSourceID()));
		sourceModel.setSourcename(source.getSourceName());
		performSaveOrUpdate(sourceModel);
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Source.class.getSimpleName(), domain,null);
	}
	
	
	public com.servinglynk.hmis.warehouse.model.v2015.Source getModelObject(ExportDomain domain, Source source ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2015.Source sourceModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			sourceModel = (com.servinglynk.hmis.warehouse.model.v2015.Source) getModel(com.servinglynk.hmis.warehouse.model.v2015.Source.class, source.getSourceID(), getProjectGroupCode(domain),false);
		
		if(sourceModel == null) {
			sourceModel = new com.servinglynk.hmis.warehouse.model.v2015.Source();
			sourceModel.setId(UUID.randomUUID());
			sourceModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(sourceModel, domain,source.getSourceID(),data.i+data.j);
		return sourceModel;
	}


	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

}
