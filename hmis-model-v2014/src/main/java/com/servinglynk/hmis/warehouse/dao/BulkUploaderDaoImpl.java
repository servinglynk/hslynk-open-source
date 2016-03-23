package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.Organization;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.stagv2014.HmisUser;
import com.servinglynk.hmis.warehouse.model.v2014.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2014.Bedinventory;
import com.servinglynk.hmis.warehouse.model.v2014.BulkUpload;
import com.servinglynk.hmis.warehouse.model.v2014.Client;
import com.servinglynk.hmis.warehouse.model.v2014.Commercialsexualexploitation;
import com.servinglynk.hmis.warehouse.model.v2014.Connectionwithsoar;
import com.servinglynk.hmis.warehouse.model.v2014.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2014.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2014.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2014.Employment;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.v2014.Funder;
import com.servinglynk.hmis.warehouse.model.v2014.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2014.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.v2014.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2014.Inventory;
import com.servinglynk.hmis.warehouse.model.v2014.LastPermAddress;
import com.servinglynk.hmis.warehouse.model.v2014.Lastgradecompleted;
import com.servinglynk.hmis.warehouse.model.v2014.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2014.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2014.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Percentami;
import com.servinglynk.hmis.warehouse.model.v2014.Project;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcompletionstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Referralsource;
import com.servinglynk.hmis.warehouse.model.v2014.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Schoolstatus;
import com.servinglynk.hmis.warehouse.model.v2014.Services;
import com.servinglynk.hmis.warehouse.model.v2014.Sexualorientation;
import com.servinglynk.hmis.warehouse.model.v2014.Site;
import com.servinglynk.hmis.warehouse.model.v2014.VeteranInfo;
import com.servinglynk.hmis.warehouse.model.v2014.Worsthousingsituation;
import com.servinglynk.hmis.warehouse.model.v2014.Youthcriticalissues;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

public class BulkUploaderDaoImpl extends ParentDaoImpl implements
		BulkUploaderDao {
	
	
	@Autowired
	ParentDaoFactory parentDaoFactory;
	
	@Autowired
	BulkUploadHelper bulkUploadHelper;
	
	@Override
	@Transactional
	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity) {
		try {
			//upload.setId(UUID.randomUUID());
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			Sources sources = bulkUploadHelper.getSourcesFromFiles(upload,projectGroupdEntity);
			
			Source source = sources.getSource();
			Export export = source.getExport();
			UUID exportId = UUID.randomUUID();
			ExportDomain domain = new ExportDomain();
			domain.setExport(export);
			domain.setExportId(exportId);
			domain.setUpload(upload);
			domain.setSource(source);
			parentDaoFactory.getSourceDao().hydrateStaging(domain);
			if(export != null)
			{
				com.servinglynk.hmis.warehouse.model.stagv2014.Export exportModel  = new com.servinglynk.hmis.warehouse.model.stagv2014.Export();
				exportModel.setExportDate(BasicDataGenerator.getLocalDateTime(export.getExportDate()));
				exportModel.setExportdirective(export.getExportDirective());
				exportModel.setExportperiodtype(export.getExportPeriodType());
				exportModel.setId(exportId);
				exportModel.setDateCreated(LocalDateTime.now());
				exportModel.setDateUpdated(LocalDateTime.now());
//				com.servinglynk.hmis.warehouse.model.staging.HmisUser user = (com.servinglynk.hmis.warehouse.model.staging.HmisUser) get(com.servinglynk.hmis.warehouse.model.staging.HmisUser.class, upload.getUser().getId());
			//	exportModel.setUser(user);
				com.servinglynk.hmis.warehouse.model.stagv2014.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Source) get(com.servinglynk.hmis.warehouse.model.stagv2014.Source.class, domain.getSourceId());
				exportModel.setSource(sourceEntity);
				exportModel.setProjectGroupCode(upload.getProjectGroupCode());
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
		//	parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain);
			parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSchoolstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSexualorientationDao().hydrateStaging(domain);
			parentDaoFactory.getWorsthousingsituationDao().hydrateStaging(domain);
			parentDaoFactory.getYouthcriticalissuesDao().hydrateStaging(domain);
			upload.setStatus(UploadStatus.STAGING.getStatus());
			com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, exportId);
			parentDaoFactory.getSourceDao().hydrateLive(exportEntity);
			if(exportEntity!=null) {
				com.servinglynk.hmis.warehouse.model.v2014.Export target = new com.servinglynk.hmis.warehouse.model.v2014.Export();
				BeanUtils.copyProperties(exportEntity, target,getNonCollectionFields(target));
				com.servinglynk.hmis.warehouse.model.v2014.Source sourceEntity = (com.servinglynk.hmis.warehouse.model.v2014.Source) get(com.servinglynk.hmis.warehouse.model.v2014.Source.class, domain.getSourceId());
				target.setSource(sourceEntity);
				insert(target);	
			}
			com.servinglynk.hmis.warehouse.model.v2014.Export exportLive = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, exportId);
			upload.setExport(exportLive);
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload); 
		} catch (Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(e.getMessage());
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			e.printStackTrace();
		}
		return upload;
	}
	
	public HmisUser getHmisUser(String id) {
		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
		criteria.createAlias("projectGroupEntity","projectGroupEntity");
		
		criteria.add(Restrictions.eq("id", id));
		
		List<HmisUser> users = (List<HmisUser>) findByCriteria(criteria);
		if(users!=null ) {
			return users.get(0);
		}
		return null;
	}
	
	
	@Override
	@Transactional
	public void moveFromStagingToLive(BulkUpload bulkUpload) {
		try {
		UUID exportId = bulkUpload.getExport().getId();
		com.servinglynk.hmis.warehouse.model.stagv2014.Export export = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, exportId);
		parentDaoFactory.getClientDao().hydrateLive(export);
		parentDaoFactory.getVeteranInfoDao().hydrateLive(export);
		parentDaoFactory.getEnrollmentDao().hydrateLive(export);
		parentDaoFactory.getCommercialsexualexploitationDao().hydrateLive(export);
		//parentDaoFactory.getDateofengagementDao().hydrateLive(export);
		//parentDaoFactory.getOrganizationDao().hydrateLive(export);
//		parentDaoFactory.getOrganizationDao().hydrateLive(export);
		parentDaoFactory.getProjectDao().hydrateLive(export);
		parentDaoFactory.getEnrollmentCocDao().hydrateLive(export);
		parentDaoFactory.getProjectcocDao().hydrateLive(export);
		parentDaoFactory.getResidentialmoveindateDao().hydrateLive(export);
		parentDaoFactory.getServicesDao().hydrateLive(export);
		parentDaoFactory.getDateofengagementDao().hydrateLive(export);
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
		parentDaoFactory.getLastPermAddressDao().hydrateLive(export);
		parentDaoFactory.getMedicalassistanceDao().hydrateLive(export);
		parentDaoFactory.getNoncashbenefitsDao().hydrateLive(export);
		parentDaoFactory.getPathstatusDao().hydrateLive(export);
		parentDaoFactory.getPercentamiDao().hydrateLive(export);
		parentDaoFactory.getReferralsourceDao().hydrateLive(export);
		//parentDaoFactory.getResidentialmoveindateDao().hydrateLive(export);
		parentDaoFactory.getRhybcpstatusDao().hydrateLive(export);
		parentDaoFactory.getSchoolstatusDao().hydrateLive(export);
		parentDaoFactory.getSexualorientationDao().hydrateLive(export);
		parentDaoFactory.getWorsthousingsituationDao().hydrateLive(export);
		parentDaoFactory.getYouthcriticalissuesDao().hydrateLive(export);
		bulkUpload.setStatus(UploadStatus.LIVE.getStatus());
		parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(bulkUpload);
		}
		catch (Exception e) {
			bulkUpload.setStatus(UploadStatus.ERROR.getStatus());
			bulkUpload.setDescription(e.getMessage());
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(bulkUpload);
		}
	}
	
	
	
	@Override
	public void deleteStagingByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class,exportId);
		deleteFromDB(exportEntity);
	}

	@Override
	public void deleteLiveByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class,exportId);
		hardDelete(exportEntity);
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
	
	@Override
	@Transactional
	public void undoDeleteLiveByExportId(UUID exportId) {
//		com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class,exportId);
//		unDeleteFromDB(exportEntity);
		undoSoftDeleteByExportId(Affiliation.class.getName(), exportId);
		undoSoftDeleteByExportId(Bedinventory.class.getName(), exportId);
		undoSoftDeleteByExportId(Commercialsexualexploitation.class.getName(), exportId);
		undoSoftDeleteByExportId(Connectionwithsoar.class.getName(), exportId);
		undoSoftDeleteByExportId(Dateofengagement.class.getName(), exportId);
		undoSoftDeleteByExportId(Disabilities.class.getName(), exportId);
		undoSoftDeleteByExportId(Domesticviolence.class.getName(), exportId);
		undoSoftDeleteByExportId(Employment.class.getName(), exportId);
		undoSoftDeleteByExportId(Enrollment.class.getName(), exportId);
		undoSoftDeleteByExportId(EnrollmentCoc.class.getName(), exportId);
		undoSoftDeleteByExportId(Client.class.getName(), exportId);
		undoSoftDeleteByExportId(Exit.class.getName(), exportId);
		undoSoftDeleteByExportId(Exithousingassessment.class.getName(), exportId);
		undoSoftDeleteByExportId(Exitplansactions.class.getName(), exportId);
		undoSoftDeleteByExportId(Export.class.getName(), exportId);
		undoSoftDeleteByExportId(Familyreunification.class.getName(), exportId);
		undoSoftDeleteByExportId(Formerwardchildwelfare.class.getName(), exportId);
		undoSoftDeleteByExportId(Formerwardjuvenilejustice.class.getName(), exportId);
		undoSoftDeleteByExportId(Funder.class.getName(), exportId);
		undoSoftDeleteByExportId(Healthinsurance.class.getName(), exportId);
		undoSoftDeleteByExportId(HealthStatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Housingassessmentdisposition.class.getName(), exportId);
		undoSoftDeleteByExportId(Incomeandsources.class.getName(), exportId);
		undoSoftDeleteByExportId(Inventory.class.getName(), exportId);
		undoSoftDeleteByExportId(Lastgradecompleted.class.getName(), exportId);
		undoSoftDeleteByExportId(LastPermAddress.class.getName(), exportId);
		undoSoftDeleteByExportId(Medicalassistance.class.getName(), exportId);
		undoSoftDeleteByExportId(Noncashbenefits.class.getName(), exportId);
		undoSoftDeleteByExportId(Organization.class.getName(), exportId);
		undoSoftDeleteByExportId(Pathstatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Percentami.class.getName(), exportId);
		undoSoftDeleteByExportId(Project.class.getName(), exportId);
		undoSoftDeleteByExportId(Projectcoc.class.getName(), exportId);
		undoSoftDeleteByExportId(Projectcompletionstatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Referralsource.class.getName(), exportId);
		undoSoftDeleteByExportId(Residentialmoveindate.class.getName(), exportId);
		undoSoftDeleteByExportId(Rhybcpstatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Schoolstatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Services.class.getName(), exportId);
		undoSoftDeleteByExportId(Sexualorientation.class.getName(), exportId);
		undoSoftDeleteByExportId(Site.class.getName(), exportId);
		undoSoftDeleteByExportId(Source.class.getName(), exportId);
		undoSoftDeleteByExportId(VeteranInfo.class.getName(), exportId);
		undoSoftDeleteByExportId(Worsthousingsituation.class.getName(), exportId);
		undoSoftDeleteByExportId(Youthcriticalissues.class.getName(), exportId);
		undoSoftDeleteByExportId(BulkUpload.class.getName(), exportId);
	}
	
	@Override
	public void deleteLiveByProjectGroupCode(String projectGroupCode) {
		softDeleteByProjectGroupCode(Affiliation.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Bedinventory.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Client.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Commercialsexualexploitation.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Connectionwithsoar.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Dateofengagement.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Disabilities.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Domesticviolence.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Employment.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Enrollment.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(EnrollmentCoc.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Exit.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Exithousingassessment.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Exitplansactions.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Export.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Familyreunification.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Formerwardchildwelfare.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Formerwardjuvenilejustice.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Funder.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Healthinsurance.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(HealthStatus.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Housingassessmentdisposition.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Incomeandsources.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Inventory.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Lastgradecompleted.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(LastPermAddress.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Medicalassistance.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Noncashbenefits.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Organization.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Pathstatus.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Percentami.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Project.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Projectcoc.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Projectcompletionstatus.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Referralsource.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Residentialmoveindate.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Rhybcpstatus.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Schoolstatus.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Services.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Sexualorientation.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Site.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Source.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(VeteranInfo.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Worsthousingsituation.class.getName(), projectGroupCode);
		softDeleteByProjectGroupCode(Youthcriticalissues.class.getName(), projectGroupCode);
	}
	
}

