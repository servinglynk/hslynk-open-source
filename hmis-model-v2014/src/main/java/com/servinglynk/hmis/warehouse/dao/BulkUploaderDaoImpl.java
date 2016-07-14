package com.servinglynk.hmis.warehouse.dao;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Appender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper;
import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.Client;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2014.Affiliation;
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
import com.servinglynk.hmis.warehouse.model.v2014.Organization;
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

public class BulkUploaderDaoImpl extends ParentDaoImpl implements
		BulkUploaderDao {
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BulkUploaderDaoImpl.class);
	
	@Autowired
	ParentDaoFactory parentDaoFactory;
	
	@Autowired
	BulkUploadHelper bulkUploadHelper;
	
	@Autowired
	ChronicHomelessCalcHelper chronicHomelessCalcHelper;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender) {
		try {
			if (appender != null) {
				logger.addAppender(appender);
			}
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			long startNanos = System.nanoTime();
			Sources sources = null;
			try {
				sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity);
			} catch (Exception ex) {
				throw new Exception("HUD File Uploaded is in an invalid Format", ex);
			}
			logger.info(getClass().getSimpleName() + ".File reading took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");

			Source source = null;
			try {
				source = sources.getSource();
			} catch (Exception ex) {
				throw new Exception("HUD File Uploaded is in an invalid Format :Unable to get source from sources", ex);
			}
			Export export = null;
			try {
				export = source.getExport();
			} catch (Exception ex) {
				throw new Exception("HUD File Uploaded is in an invalid Format : Unable to get export from source", ex);
			}
			UUID exportId = UUID.randomUUID();
			ExportDomain domain = new ExportDomain();
			domain.setExport(export);
			domain.setUpload(upload);
			domain.setSource(source);
			parentDaoFactory.getSourceDao().hydrateStaging(domain);
			parentDaoFactory.getExportDao().hydrateStaging(domain);
			logger.debug(" Bulk Upload Processing client Table Begin.....");
			parentDaoFactory.getClientDao().hydrateStaging(domain);
			logger.debug(" Bulk Upload Processing client Table Ends.....");
			parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain);
			parentDaoFactory.getOrganizationDao().hydrateStaging(domain);
			parentDaoFactory.getProjectDao().hydrateStaging(domain);
			parentDaoFactory.getEnrollmentDao().hydrateStaging(domain);
			parentDaoFactory.getCommercialsexualexploitationDao().hydrateStaging(domain);
			parentDaoFactory.getDateofengagementDao().hydrateStaging(domain);
			parentDaoFactory.getAffiliationDao().hydrateStaging(domain);
			parentDaoFactory.getProjectcocDao().hydrateStaging(domain);
			parentDaoFactory.getFunderDao().hydrateStaging(domain);
			parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain);
			parentDaoFactory.getInventoryDao().hydrateStaging(domain);
			parentDaoFactory.getSiteDao().hydrateStaging(domain);
			parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain);
			parentDaoFactory.getServicesDao().hydrateStaging(domain);
			parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain);

			parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain);
			parentDaoFactory.getEmploymentDao().hydrateStaging(domain);
			parentDaoFactory.getExitDao().hydrateStaging(domain);
			parentDaoFactory.getFamilyreunificationDao().hydrateStaging(domain);
			parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain);
			parentDaoFactory.getHousingassessmentdispositionDao().hydrateStaging(domain);
			parentDaoFactory.getExitplansactionsDao().hydrateStaging(domain);
			parentDaoFactory.getConnectionwithsoarDao().hydrateStaging(domain);
			parentDaoFactory.getProjectcompletionstatusDao().hydrateStaging(domain);
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
			parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSchoolstatusDao().hydrateStaging(domain);
			parentDaoFactory.getSexualorientationDao().hydrateStaging(domain);
			parentDaoFactory.getWorsthousingsituationDao().hydrateStaging(domain);
			parentDaoFactory.getYouthcriticalissuesDao().hydrateStaging(domain);
			upload.setStatus(UploadStatus.STAGING.getStatus());
			upload.setExportId(exportId);
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
		} catch (Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(e.getMessage());
			logger.error("Error executing the bulk upload process:: ", e);
			try {
				parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			} catch (Exception ex) {
				logger.error(ex);
			}
		} finally {
			if (appender != null) {
				logger.removeAppender(appender);
			}
		}
		return upload;
	}
	/*
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
	*/
	
	
	@Override
	public void deleteStagingByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class,exportId);
		deleteFromDB(exportEntity);
	}

	@Override
	public void deleteLiveByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class,exportId);
		hardDelete(exportEntity);
	}

	
	@Override
	@Transactional
	public void undoDeleteLiveByExportId(UUID exportId) {
//		com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class,exportId);
//		unDeleteFromDB(exportEntity);
		undoSoftDeleteByExportId(Affiliation.class.getName(), exportId);
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
		//undoSoftDeleteByExportId(HmisBulkUpload.class.getName(), exportId);
	}
	
	@Override
	public void deleteLiveByProjectGroupCode(String projectGroupCode, UUID exportId) {
		softDeleteByProjectGroupCode(Affiliation.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(com.servinglynk.hmis.warehouse.model.v2014.Client.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Commercialsexualexploitation.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Connectionwithsoar.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Dateofengagement.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Disabilities.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Domesticviolence.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Employment.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Enrollment.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(EnrollmentCoc.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Exit.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Exithousingassessment.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Exitplansactions.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Export.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Familyreunification.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Formerwardchildwelfare.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Formerwardjuvenilejustice.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Funder.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Healthinsurance.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(HealthStatus.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Housingassessmentdisposition.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Incomeandsources.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Inventory.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Lastgradecompleted.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(LastPermAddress.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Medicalassistance.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Noncashbenefits.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Organization.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Pathstatus.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Percentami.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Project.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Projectcoc.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Projectcompletionstatus.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Referralsource.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Residentialmoveindate.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Rhybcpstatus.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Schoolstatus.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Services.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Sexualorientation.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Site.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Source.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(VeteranInfo.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Worsthousingsituation.class.getName(), projectGroupCode, exportId);
		softDeleteByProjectGroupCode(Youthcriticalissues.class.getName(), projectGroupCode, exportId);
	}
	
}

