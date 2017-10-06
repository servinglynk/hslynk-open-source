package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.UnmarshalException;

import org.apache.log4j.Appender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
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
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.Exitplansactions;
import com.servinglynk.hmis.warehouse.model.v2014.Familyreunification;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.model.v2014.Funder;
import com.servinglynk.hmis.warehouse.model.v2014.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2014.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
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
	@Transactional
	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,Boolean isFileFromS3) {
		try {
			if (appender != null) {
				logger.addAppender(appender);
			}
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			//saveUpload(upload);
			long startNanos = System.nanoTime();
			Sources sources = null;
			try {
				sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
			} catch (UnmarshalException ex) {
				logger.error("Error executing the bulk upload process:: ", ex);
				upload.setStatus(UploadStatus.ERROR.getStatus());
				upload.setDescription(!"null".equals(String.valueOf(ex.getCause()))  ? String.valueOf(ex.getCause()) : ex.getMessage());
				insertOrUpdate(upload);
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
			ExportDomain domain = new ExportDomain();
			domain.setExport(export);
			domain.setUpload(upload);
			domain.setSource(source);
			domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
			parentDaoFactory.getSourceDao().hydrateStaging(domain,exportModelMap,exportModelMap); // Done
			parentDaoFactory.getExportDao().hydrateStaging(domain,exportModelMap,exportModelMap); // Done
			logger.info(" Bulk Upload Processing client Table Begin.....");
			startNanos = System.nanoTime();
			parentDaoFactory.getClientDao().hydrateStaging(domain,exportModelMap,null); // DOne
			logger.info(" Bulk Upload Processing client Table Ends.....");
			logger.info("Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Client.class, getProjectGroupCode(domain));
			parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
			Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, getProjectGroupCode(domain));
			parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap,orgModelMap); // Done
			Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Project.class, getProjectGroupCode(domain));
			parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
			parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
			parentDaoFactory.getProjectcocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
			
			Map<String, HmisBaseModel> projectCocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, getProjectGroupCode(domain));
			parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,projectCocModelMap); // Done
			parentDaoFactory.getSiteDao().hydrateStaging(domain,exportModelMap,projectCocModelMap); // Done
			
			parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
			parentDaoFactory.getCommercialsexualexploitationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			
			parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			
			parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getServicesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			//parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done

			parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getExitDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, getProjectGroupCode(domain));
			parentDaoFactory.getFamilyreunificationDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getHousingassessmentdispositionDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getExitplansactionsDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getConnectionwithsoarDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getProjectcompletionstatusDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			parentDaoFactory.getFormerwardchildwelfareDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getFormerwardjuvenilejusticeDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getLastgradecompletedDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getLastPermAddressDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done


			parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getPercentamiDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getReferralsourceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getSchoolstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getSexualorientationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getWorsthousingsituationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			parentDaoFactory.getYouthcriticalissuesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		//	System.out.println("Session Statistics "+getCurrentSession().getStatistics().toString());
			
		    calculateChronicHomeless(enrollmentModelMap);
			upload.setStatus(UploadStatus.STAGING.getStatus());
			upload.setExportId(domain.getExportId());
			insertOrUpdate(upload);
		} catch (Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(!"null".equals(String.valueOf(e.getCause()))  ? String.valueOf(e.getCause()) : e.getMessage());
			insertOrUpdate(upload);
			logger.error("Error executing the bulk upload process:: ", e);
		} finally {
			if (appender != null) {
				logger.removeAppender(appender);
			}
		}
		return upload;
	}
	
	public void saveError(BulkUpload upload) {
		try {
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			Error2014 error = new Error2014();
			error.setBulk_upload_ui(upload.getId());
			error.setDate_created(LocalDateTime.now());
			error.setError_description(upload.getDescription());
			error.setProject_group_code(upload.getProjectGroupCode());
			error.setTable_name("BulkUpload");
			error.setType(ErrorType.ERROR);
			performSave(error);
		} catch (Exception ex) {
			logger.error(ex);
		}
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
	
	@Transactional(readOnly = false)
	public void saveUpload(BulkUpload upload) {
		getCurrentSession().evict(upload);
		insertOrUpdate(upload);
		getCurrentSession().flush();
		getCurrentSession().clear();
	}
	
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
	
	public void calculateChronicHomeless(Map<String,HmisBaseModel> enrollmentModelMap) {
		if(!enrollmentModelMap.isEmpty()) {
			Collection<HmisBaseModel> enrollments = enrollmentModelMap.values();
			for(HmisBaseModel model : enrollments) {
				Enrollment enrollmentModel = (Enrollment) model;
				Enrollment enrollment = (Enrollment) get(Enrollment.class, enrollmentModel.getId());
				enrollment.setChronicHomeless(chronicHomelessCalcHelper.isEnrollmentChronicHomeless(enrollment));
				getCurrentSession().merge(enrollment);
			}
		}
	}

	@Override
	@Transactional
	public BulkUpload processBase(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
		
			if (appender != null) {
				logger.addAppender(appender);
			}
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			saveUpload(upload);
			try {
			long startNanos = System.nanoTime();
			Sources sources = null;
			try {
				sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
			} catch (UnmarshalException ex) {
				logger.error("Error executing the bulk upload process:: ", ex);
				upload.setStatus(UploadStatus.ERROR.getStatus());
				upload.setDescription(!"null".equals(String.valueOf(ex.getCause()))  ? String.valueOf(ex.getCause()) : ex.getMessage());
				insertOrUpdate(upload);
				throw new Exception("HUD File Uploaded is in an invalid Format", ex);
			}
			logger.info( "Base Process:::"+getClass().getSimpleName() + ".File reading took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");

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
			ExportDomain domain = new ExportDomain();
			domain.setExport(export);
			domain.setUpload(upload);
			domain.setSource(source);
			domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
			parentDaoFactory.getSourceDao().hydrateStaging(domain,exportModelMap,exportModelMap); // Done
			parentDaoFactory.getExportDao().hydrateStaging(domain,exportModelMap,exportModelMap); // Done
			logger.info("Base Process::: Bulk Upload Processing client Table Begin.....");
			startNanos = System.nanoTime();
			parentDaoFactory.getClientDao().hydrateStaging(domain,exportModelMap,null); // DOne
			logger.info(" Base Process::: Bulk Upload Processing client Table Ends.....");
			logger.info("Base Process::: Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			upload.setStatus(UploadStatus.ENROLLMENT.getStatus());
			upload.setExportId(domain.getExportId());
			if(isFileFromS3) {
				deleteFile(upload.getInputpath()); 
			}
			deleteFile(upload.getInputpath()+"-temp.xml");
			insertOrUpdate(upload);
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Base Process:::Base in base process....."+e.getLocalizedMessage() +" Cause"+e.getCause());
		}
			return upload;
	
	}

	@Override
	public BulkUpload processEnrollment(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
		if (appender != null) {
			logger.addAppender(appender);
		}
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		saveUpload(upload);
		ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Client.class, getProjectGroupCode(domain));
		parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
		logger.info(" Enrollment Process::: Bulk Upload Processing client Table Ends.....");
		logger.info("Enrollment Process::: Enrollment table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.C_CLIENT.getStatus());
		upload.setExportId(domain.getExportId());
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		upload.setStatus(UploadStatus.C_CLIENT.getStatus());
		insertOrUpdate(upload);
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Error in Enrollment process....."+e.getLocalizedMessage()+ "cause::"+e.getCause());
		}
			return upload;
		
	}
	@Override
	public BulkUpload processClientChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,
			Appender appender, Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
		ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		saveUpload(upload);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Client.class, getProjectGroupCode(domain));
		parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
		parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
		Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Organization.class, getProjectGroupCode(domain));
		parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap,orgModelMap); // Done
		Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Project.class, getProjectGroupCode(domain));
		parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		parentDaoFactory.getProjectcocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		
		Map<String, HmisBaseModel> projectCocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, getProjectGroupCode(domain));
		parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,projectCocModelMap); // Done
		parentDaoFactory.getSiteDao().hydrateStaging(domain,exportModelMap,projectCocModelMap); // Done
		upload.setExportId(domain.getExportId());
		upload.setStatus(UploadStatus.EXIT.getStatus());
		upload.setExportId(domain.getExportId());
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		insertOrUpdate(upload);
		logger.info("ExitChildren Process::: Client Children table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Error in Client Children process....."+e.getLocalizedMessage() +" cause:"+e.getCause());
		}
			return upload;
		
	}

	@Override
	@Transactional
	public BulkUpload processExit(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
		ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		saveUpload(upload);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
		parentDaoFactory.getExitDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap); // Done
		logger.info(" Exit Process::: Bulk Upload Processing client Table Ends.....");
		logger.info("Exit Process::: Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.C_EMENT.getStatus());
		upload.setExportId(domain.getExportId());
		insertOrUpdate(upload);
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Error in Exit process....."+e.getLocalizedMessage()+ " cause::"+e.getCause());
		}
			return upload;
	}

	@Override
	public BulkUpload processDisabilities(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		//saveUpload(upload);
		try {
		long startNanos = System.nanoTime();
		Sources sources = null;
		try {
			sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
		} catch (UnmarshalException ex) {
			logger.error("Error executing the bulk upload process:: ", ex);
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(!"null".equals(String.valueOf(ex.getCause()))  ? String.valueOf(ex.getCause()) : ex.getMessage());
			insertOrUpdate(upload);
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
		ExportDomain domain = new ExportDomain();
		domain.setExport(export);
		domain.setUpload(upload);
		domain.setSource(source);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
		parentDaoFactory.getDisabilitiesDao().hydrate(domain,exportModelMap,enrollmentModelMap); // Done
		logger.info(" Disabilities Process::: Bulk Upload Processing client Table Ends.....");
		logger.info("Disabilities Process::: Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.STAGING.getStatus());
		upload.setExportId(domain.getExportId());
		//Delete all the files
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		insertOrUpdate(upload);
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			e.printStackTrace();
			logger.error(" Error in Disabilities process....."+e.getLocalizedMessage() +" cause:"+e.getCause());
		}
			return upload;
	}
	
	private void deleteFile(String fileName) {
		try{
    		File file = new File(fileName);
    		if(file.delete()){
    			logger.info(file.getName() + " is deleted!");
    		}else{
    			logger.info("Delete operation is failed.");
    		}

    	}catch(Exception e){
    		logger.error(" Error in File Deletion ....."+e.getLocalizedMessage() +" cause:"+e.getCause());
    	}
	}
	/***
	 * Get Source data after reading the file.
	 * @param upload
	 * @param projectGroupdEntity
	 * @param appender
	 * @param isFileFromS3
	 * @param domain
	 * @return
	 * @throws Exception
	 */
    private ExportDomain getSource(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) throws Exception {
    	long startNanos = System.nanoTime();
    	ExportDomain domain = new ExportDomain();
    	if (appender != null) {
			logger.addAppender(appender);
		}
		Sources sources = null;
		try {
			sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
		} catch (UnmarshalException ex) {
			logger.error("Error executing the bulk upload process:: ", ex);
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(!"null".equals(String.valueOf(ex.getCause()))  ? String.valueOf(ex.getCause()) : ex.getMessage());
			insertOrUpdate(upload);
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
		domain.setExport(export);
		domain.setUpload(upload);
		domain.setSource(source);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
		return domain;
    }

	@Override
	public BulkUpload processExitChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
		ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		saveUpload(upload);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, getProjectGroupCode(domain));
		parentDaoFactory.getFamilyreunificationDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getHousingassessmentdispositionDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getExitplansactionsDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getConnectionwithsoarDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getProjectcompletionstatusDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		logger.info("ExitChildren Process::: ExitChildren table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.DISAB.getStatus());
		upload.setExportId(domain.getExportId());
		insertOrUpdate(upload);
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Error in Exit Children process....."+e.getLocalizedMessage() +" cause:"+e.getCause());
		}
			return upload;
	}
	
	@Override
	public BulkUpload processEnrollmentChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,
			Appender appender, Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
		ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
		upload.setStatus(UploadStatus.INPROGRESS.getStatus());
		saveUpload(upload);
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, getProjectGroupCode(domain));
		parentDaoFactory.getCommercialsexualexploitationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		
		parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		
		parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getServicesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done

		parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getFormerwardchildwelfareDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getFormerwardjuvenilejusticeDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getLastgradecompletedDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getLastPermAddressDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done


		parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getPercentamiDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getReferralsourceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getSchoolstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getSexualorientationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getWorsthousingsituationDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getYouthcriticalissuesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		upload.setExportId(domain.getExportId());
		upload.setStatus(UploadStatus.C_EXIT.getStatus());
		upload.setExportId(domain.getExportId());
		insertOrUpdate(upload);
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		logger.info("ExitChildren Process::: ExitChildren table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			insertOrUpdate(upload);
			logger.error(" Error in ExitChildren process....."+e.getLocalizedMessage() +" cause:"+e.getCause());
		}
			return upload;
	}
	
}

