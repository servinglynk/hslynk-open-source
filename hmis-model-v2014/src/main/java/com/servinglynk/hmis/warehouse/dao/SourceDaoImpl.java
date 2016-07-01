/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;

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
		List<Source> sources = new ArrayList<>();
		sources.add(source);
		hydrateBulkUploadActivityStaging(sources, com.servinglynk.hmis.warehouse.model.v2014.Source.class.getSimpleName(), domain);
		com.servinglynk.hmis.warehouse.model.v2014.Source sourceModel = new com.servinglynk.hmis.warehouse.model.v2014.Source();
		sourceModel.setSoftwarevendor(source.getSoftwareVendor());
		//sourceModel.setSoftwareversion(BasicDataGenerator.getStringValue(source.getSoftwareVersion()));
		sourceModel.setSourcecontactemail(source.getSourceContactEmail());
		sourceModel.setSourcecontactextension(String.valueOf(source.getSourceContactExtension()));
		sourceModel.setSourcecontactfirst(source.getSourceContactFirst());
		sourceModel.setSourcecontactlast(source.getSourceContactLast());
		sourceModel.setSourceid(String.valueOf(source.getSourceID()));
		sourceModel.setSourcename(source.getSourceName());
		UUID id = UUID.randomUUID();
		domain.setSourceId(id);
		sourceModel.setId(id);
		//hydrateCommonFields(sourceModel, domain, String.valueOf(source.getSourceID()),0);
            //  getCurrentSession().flush();
          //    getCurrentSession().clear();
	}
}
