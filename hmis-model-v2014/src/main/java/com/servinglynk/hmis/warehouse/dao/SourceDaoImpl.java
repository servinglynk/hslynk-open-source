/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.stagv2014.Export;

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
		com.servinglynk.hmis.warehouse.model.stagv2014.Source sourceModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Source();
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
		hydrateCommonFields(sourceModel, domain, String.valueOf(source.getSourceID()),0);
		insert(sourceModel);
              getCurrentSession().flush();
              getCurrentSession().clear();
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		// TODO Auto-generated method stub
		com.servinglynk.hmis.warehouse.model.stagv2014.Source source = export.getSource();
		Set sources = new HashSet<>();
		sources.add(source);
		hydrateBulkUploadActivity(sources, com.servinglynk.hmis.warehouse.model.v2014.Source.class.getSimpleName(), export,id);
		if(source !=null) {
			com.servinglynk.hmis.warehouse.model.v2014.Source target = new com.servinglynk.hmis.warehouse.model.v2014.Source();
			BeanUtils.copyProperties(source, target, getNonCollectionFields(target));
			target.setDateCreated(LocalDateTime.now());
			target.setDateUpdated(LocalDateTime.now());
			insertOrUpdate(target);
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
