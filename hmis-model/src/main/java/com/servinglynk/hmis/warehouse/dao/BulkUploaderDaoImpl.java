package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.model.staging.BulkUpload;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class BulkUploaderDaoImpl extends ParentDaoImpl implements
		BulkUploaderDao {
	@Autowired
	ParentDaoFactory parentDaoFactory;
	
	@Autowired
	BulkUploadHelper bulkUploadHelper;
	
	@Override
	@Transactional
	public BulkUpload performBulkUpload(BulkUpload upload) {
		try {
			
			upload.setStatus("INPROGRESS");
			parentDaoFactory.getBulkUploaderWorkerDao().insert(upload);
			Sources sources = bulkUploadHelper.getSourcesFromFiles(upload);
			Source source = sources.getSource();
			Export export = source.getExport();
			UUID exportId = UUID.randomUUID();
			ExportDomain domain = new ExportDomain();
			domain.setExport(export);
			domain.setExportId(exportId);
			domain.setSource(source);
			parentDaoFactory.getSourceDao().hydrateStaging(domain);
			if(export != null)
			{
				com.servinglynk.hmis.warehouse.model.staging.Export exportModel  = new com.servinglynk.hmis.warehouse.model.staging.Export();
				exportModel.setExportDate(BasicDataGenerator.getLocalDate(export.getExportDate()));
				exportModel.setExportdirective(export.getExportDirective());
				exportModel.setExportperiodtype(export.getExportPeriodType());
				exportModel.setId(exportId);
				com.servinglynk.hmis.warehouse.model.staging.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.staging.Source) get(com.servinglynk.hmis.warehouse.model.staging.Source.class, domain.getSourceId());
				exportModel.setSource(sourceEntity);
				//export.getExportPeriod()
				insert(exportModel);
			}
			parentDaoFactory.getClientDao().hydrateStaging(domain);
			parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain);
			parentDaoFactory.getEnrollmentDao().hydrateStaging(domain);
			parentDaoFactory.getCommercialsexualexploitationDao().hydrateStaging(domain);
			parentDaoFactory.getDateofengagementDao().hydrateStaging(domain);
			parentDaoFactory.getProjectDao().hydrateStaging(domain);
			parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain);
			parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain);
			parentDaoFactory.getServicesDao().hydrateStaging(domain);
			parentDaoFactory.getDateofengagementDao().hydrateStaging(domain);
			parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain);
			parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain);
			parentDaoFactory.getEmploymentDao().hydrateStaging(domain);
			parentDaoFactory.getExitDao().hydrateStaging(domain);
			parentDaoFactory.getFormerwardchildwelfareDao().hydrateStaging(domain);
			parentDaoFactory.getFormerwardjuvenilejusticeDao().hydrateStaging(domain);
			parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain);
			parentDaoFactory.getHealthStatusDao().hydrateStaging(domain);
			parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain);
			parentDaoFactory.getLastgradecompletedDao().hydrateStaging(domain);
			parentDaoFactory.getLastPermAddressDao().hydrateStaging(domain);
			parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain);
			parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain);
			parentDaoFactory.getPathstatusDao().hydrateStaging(domain);
			parentDaoFactory.getPercentamiDao().hydrateStaging(domain);
			parentDaoFactory.getReferralsourceDao().hydrateStaging(domain);
			parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain);
			parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSchoolstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSexualorientationDao().hydrateStaging(domain);
			parentDaoFactory.getWorsthousingsituationDao().hydrateStaging(domain);
			parentDaoFactory.getYouthcriticalissuesDao().hydrateStaging(domain);
			upload.setStatus("STAGING");
			com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, exportId);
			upload.setExport(exportEntity);
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return upload;
	}
	
	@Override
	@Transactional
	public void moveFromStagingToLive(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.staging.Export export = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, exportId);
		parentDaoFactory.getSourceDao().hydrateLive(export);
		if(export!=null) {
			com.servinglynk.hmis.warehouse.model.live.Export target = new com.servinglynk.hmis.warehouse.model.live.Export();
			BeanUtils.copyProperties(export, target,getNonCollectionFields(target));
			com.servinglynk.hmis.warehouse.model.live.Source source = target.getSource();
			if(source != null && source.getId() != null) {
				com.servinglynk.hmis.warehouse.model.live.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.live.Source) get(com.servinglynk.hmis.warehouse.model.live.Source.class, source.getId());
				target.setSource(sourceEntity);
			}
			insert(target);	
		}
		
		parentDaoFactory.getClientDao().hydrateLive(export);
		parentDaoFactory.getVeteranInfoDao().hydrateLive(export);
		parentDaoFactory.getEnrollmentDao().hydrateLive(export);
		parentDaoFactory.getCommercialsexualexploitationDao().hydrateLive(export);
		parentDaoFactory.getDateofengagementDao().hydrateLive(export);
		parentDaoFactory.getProjectDao().hydrateLive(export);
		parentDaoFactory.getEnrollmentCocDao().hydrateLive(export);
		parentDaoFactory.getResidentialmoveindateDao().hydrateLive(export);
		parentDaoFactory.getServicesDao().hydrateLive(export);
		//parentDaoFactory.getDateofengagementDao().hydrateLive(export);
		parentDaoFactory.getDisabilitiesDao().hydrateLive(export);
		parentDaoFactory.getDomesticviolenceDao().hydrateLive(export);
		parentDaoFactory.getEmploymentDao().hydrateLive(export);
		parentDaoFactory.getExitDao().hydrateLive(export);
		parentDaoFactory.getFormerwardchildwelfareDao().hydrateLive(export);
		parentDaoFactory.getFormerwardjuvenilejusticeDao().hydrateLive(export);
		parentDaoFactory.getHealthinsuranceDao().hydrateLive(export);
		parentDaoFactory.getHealthStatusDao().hydrateLive(export);
		parentDaoFactory.getIncomeandsourcesDao().hydrateLive(export);
		parentDaoFactory.getLastgradecompletedDao().hydrateLive(export);
		//parentDaoFactory.getLastPermAddressDao().hydrateLive(export);
		parentDaoFactory.getMedicalassistanceDao().hydrateLive(export);
		parentDaoFactory.getNoncashbenefitsDao().hydrateLive(export);
		parentDaoFactory.getPathstatusDao().hydrateLive(export);
		parentDaoFactory.getPercentamiDao().hydrateLive(export);
		parentDaoFactory.getReferralsourceDao().hydrateLive(export);
//		parentDaoFactory.getResidentialmoveindateDao().hydrateLive(export);
		parentDaoFactory.getRhybcpstatusDao().hydrateLive(export);
		parentDaoFactory.getSchoolstatusDao().hydrateLive(export);
		parentDaoFactory.getSexualorientationDao().hydrateLive(export);
		parentDaoFactory.getWorsthousingsituationDao().hydrateLive(export);
		parentDaoFactory.getYouthcriticalissuesDao().hydrateLive(export);	
	}
	
	@Override
	public void deleteStagingByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class,exportId);
		delete(exportEntity);
	}

	@Override
	public void deleteLiveByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class,exportId);
		delete(exportEntity);
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

