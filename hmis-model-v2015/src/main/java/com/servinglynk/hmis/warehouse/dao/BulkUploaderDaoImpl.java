package com.servinglynk.hmis.warehouse.dao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

import org.apache.log4j.Appender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2015.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2015.Client;
import com.servinglynk.hmis.warehouse.model.v2015.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.model.v2015.Coc;
import com.servinglynk.hmis.warehouse.model.v2015.Contact;
import com.servinglynk.hmis.warehouse.model.v2015.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2015.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2015.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2015.Education;
import com.servinglynk.hmis.warehouse.model.v2015.Employment;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2015.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2015.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2015.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2015.Error2015;
import com.servinglynk.hmis.warehouse.model.v2015.Exit;
import com.servinglynk.hmis.warehouse.model.v2015.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2015.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2015.Funder;
import com.servinglynk.hmis.warehouse.model.v2015.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2015.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2015.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2015.Housingassessmentdisposition;
import com.servinglynk.hmis.warehouse.model.v2015.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2015.Inventory;
import com.servinglynk.hmis.warehouse.model.v2015.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2015.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2015.Organization;
import com.servinglynk.hmis.warehouse.model.v2015.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2015.Project;
import com.servinglynk.hmis.warehouse.model.v2015.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.model.v2015.RhybcpStatus;
import com.servinglynk.hmis.warehouse.model.v2015.ServiceFaReferral;
import com.servinglynk.hmis.warehouse.model.v2015.Site;

public class BulkUploaderDaoImpl extends ParentDaoImpl implements
		BulkUploaderDao {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BulkUploaderDaoImpl.class);
	
	@Autowired
	ParentDaoFactory parentDaoFactory;
	
	@Autowired
	BulkUploadHelper bulkUploadHelper;
	

	/***
	 * Perform Bulk Upload for Core Tables
	 */
	@Override
	@Transactional
	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		try {
			if (appender != null) {
				logger.addAppender(appender);
			}
			long startNanos = System.nanoTime();
			logger.debug("Bulk Uploader Process Begins..........");
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			insertOrUpdate(upload);
			ExportDomain domain = getDomain(upload, projectGroupdEntity, isFileFromS3);
			parentDaoFactory.getSourceDao().hydrateStaging(domain,null,null); // DONE
			logger.info("Staging Source table.........");
			parentDaoFactory.getExportDao().hydrateStaging(domain,null,null); // Done
			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
			startNanos = System.nanoTime();
			parentDaoFactory.getClientDao().hydrateStaging(domain,exportModelMap,null); // DONE
			logger.info("Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Client.class, getProjectGroupCode(domain));
			parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			//Inserting organization inserts Org,Project,Funder,Coc,Inventory,Site and Affiliation.
		    parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
			Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Organization.class, getProjectGroupCode(domain));
			parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap, orgModelMap); // Done
			startNanos = System.nanoTime();
			parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			logger.info("Enrollment table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
			parentDaoFactory.getExitDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			upload.setExportId(domain.getExportId());
			upload.setStatus(UploadStatus.STAGING.getStatus());
			logger.debug("Chaning status of Bulk_upload table to STAGING");
			insertOrUpdate(upload); 
			logger.debug("Bulk Upload Staging Process Ends.....");
		} catch (Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(!"null".equals(String.valueOf(e.getCause()))  ? String.valueOf(e.getCause()) : e.getMessage());
			saveError(upload);
		}
		finally {
			if (appender != null) {
				logger.removeAppender(appender);
			}
		}
		return upload;
	}
	
	private ExportDomain getDomain(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Boolean isFileFromS3) throws Exception {
		long startNanos = System.nanoTime();
		Source source = getSource(upload, projectGroupdEntity, isFileFromS3);
		Export export = null;
		try {
			export = source.getExport();
		} catch (Exception ex) {
			throw new Exception("HUD File Uploaded is in an invalid Format : Unable to get export from source", ex);
		}
		logger.info("Time take to read the "+upload.getInputpath()+ " was " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		ExportDomain domain = new ExportDomain();
		domain.setExport(export);
		domain.setUpload(upload);
		domain.setSource(source);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
		return domain;
	}
	
	private Source getSource(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		Sources sources = null;
		try {
			sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
		} catch (UnmarshalException ex) {
			logger.error("Error executing the bulk upload process:: ", ex);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(getClass().getSimpleName() + ".File reading took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");

		return sources.getSource();
	}
	/***
	 * Perform Bulk Upload for processProjectChildren Tables
	 */
	@Override
	@Transactional
	public void processProjectChildren(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processProjectChildren Begins..........");
		long startNanos = System.nanoTime();
			try {
				ExportDomain domain = getDomain(upload, projectGroupdEntity, isFileFromS3);
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Project.class, getProjectGroupCode(domain));
				parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getCocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				Map<String, HmisBaseModel> cocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Coc.class, getProjectGroupCode(domain));
				parentDaoFactory.getSiteDao().hydrateStaging(domain,exportModelMap,cocModelMap); // Done
				parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,cocModelMap); // Done
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Done
			logger.info("processProjectChildren tables took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	/***
	 * Perform Bulk Upload for processEnrollmentChildrenPart1 Tables
	 */
	@Override
	@Transactional
	public void processEnrollmentChildrenPart1(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processEnrollmentChildrenPart1 Begins..........");
		long startNanos = System.nanoTime();
			try {
				ExportDomain domain = getDomain(upload, projectGroupdEntity, isFileFromS3);
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
				parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // DOne
				parentDaoFactory.getHousingassessmentdispositionDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Done
			logger.info("processEnrollmentChildrenPart1 tables took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	/***
	 * Perform Bulk Upload for processEnrollmentChildrenPart2 Tables
	 */
	@Override
	@Transactional
	public void processEnrollmentChildrenPart2(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processEnrollmentChildrenPart2 Begins..........");
		long startNanos = System.nanoTime();
			try {
				ExportDomain domain = getDomain(upload, projectGroupdEntity, isFileFromS3);
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
				parentDaoFactory.getEntryrhspDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryrhyDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryssvfDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getContactDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getServiceFaReferralDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Done
			logger.info("processEnrollmentChildrenPart2 tables took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	/***
	 * Perform Bulk Upload for processEnrollmentChildrenPart3 Tables
	 */
	@Override
	@Transactional
	public void processEnrollmentChildrenPart3(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processEnrollmentChildrenPart3 Begins..........");
		long startNanos = System.nanoTime();
			try {
				ExportDomain domain = getDomain(upload, projectGroupdEntity, isFileFromS3);
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
				parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Done
			logger.info("processEnrollmentChildrenPart3 tables took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	/***
	 * Perform Bulk Upload for processDisabilities Tables
	 */
	@Override
	@Transactional
	public void processDisabilities(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processDisabilities Begins..........");
		long startNanos = System.nanoTime();
		ExportDomain domain = new ExportDomain();
		domain.setUpload(upload);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
			try {
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, getProjectGroupCode(domain));
				parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Done
		logger.info("Disabilities table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	/***
	 * Perform Bulk Upload for processExitChildrenPart1 Tables
	 */
	@Override
	@Transactional
	public void processExitChildrenPart1(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		if (appender != null) {
			logger.addAppender(appender);
		}
		logger.debug("processExitChildrenPart1 Begins..........");
		long startNanos = System.nanoTime();
		ExportDomain domain = new ExportDomain();
		domain.setUpload(upload);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
			try {
				Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Export.class, getProjectGroupCode(domain));
				Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, getProjectGroupCode(domain));
				parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getExitpathDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getExitrhyDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
			   } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Done
			logger.info("processExitChildrenPart1 table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
	}
	public void saveError(BulkUpload upload) {
		try {
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			Error2015 error = new Error2015();
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
	
//	public HmisUser getHmisUser(String id) {
//		DetachedCriteria criteria = DetachedCriteria.forClass(HmisUser.class);
//		criteria.createAlias("projectGroupEntity","projectGroupEntity");
//		
//		criteria.add(Restrictions.eq("id", id));
//		
//		List<HmisUser> users = (List<HmisUser>) findByCriteria(criteria);
//		if(users!=null ) {
//			return users.get(0);
//		}
//		return null;
//	}
//	
	
	
	@Override
	public void deleteStagingByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class,exportId);
		deleteFromDB(exportEntity);
	}

	@Override
	public void deleteLiveByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class,exportId);
		hardDelete(exportEntity);
	}

	@Override
	@Transactional
	public void undoDeleteLiveByExportId(UUID exportId) {
//		com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class,exportId);
//		unDeleteFromDB(exportEntity);
		undoSoftDeleteByExportId(Affiliation.class.getName(), exportId);
		undoSoftDeleteByExportId(Dateofengagement.class.getName(), exportId);
		undoSoftDeleteByExportId(Disabilities.class.getName(), exportId);
		undoSoftDeleteByExportId(Domesticviolence.class.getName(), exportId);
		undoSoftDeleteByExportId(Employment.class.getName(), exportId);
		undoSoftDeleteByExportId(Enrollment.class.getName(), exportId);
		undoSoftDeleteByExportId(EnrollmentCoc.class.getName(), exportId);
		undoSoftDeleteByExportId(Client.class.getName(), exportId);
		undoSoftDeleteByExportId(Exit.class.getName(), exportId);
		undoSoftDeleteByExportId(Exithousingassessment.class.getName(), exportId);
		undoSoftDeleteByExportId(Export.class.getName(), exportId);
		undoSoftDeleteByExportId(Funder.class.getName(), exportId);
		undoSoftDeleteByExportId(Healthinsurance.class.getName(), exportId);
		undoSoftDeleteByExportId(HealthStatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Housingassessmentdisposition.class.getName(), exportId);
		undoSoftDeleteByExportId(Incomeandsources.class.getName(), exportId);
		undoSoftDeleteByExportId(Inventory.class.getName(), exportId);
		undoSoftDeleteByExportId(Medicalassistance.class.getName(), exportId);
		undoSoftDeleteByExportId(Noncashbenefits.class.getName(), exportId);
		undoSoftDeleteByExportId(Organization.class.getName(), exportId);
		undoSoftDeleteByExportId(Project.class.getName(), exportId);
		undoSoftDeleteByExportId(Residentialmoveindate.class.getName(), exportId);
		undoSoftDeleteByExportId(RhybcpStatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Site.class.getName(), exportId);
		undoSoftDeleteByExportId(Source.class.getName(), exportId);
		undoSoftDeleteByExportId(ClientVeteranInfo.class.getName(), exportId);
		undoSoftDeleteByExportId(BulkUpload.class.getName(), exportId);
	}
	
	@Override
	public void deleteLiveByProjectGroupCode(String projectGroupCode, UUID exportId) {
		softDeleteByProjectGroupCode(Affiliation.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(com.servinglynk.hmis.warehouse.model.v2015.Client.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Dateofengagement.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Disabilities.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Domesticviolence.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Employment.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Enrollment.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(EnrollmentCoc.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Exit.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Exithousingassessment.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Export.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Funder.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Healthinsurance.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(HealthStatus.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Housingassessmentdisposition.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Incomeandsources.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Inventory.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Medicalassistance.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Noncashbenefits.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Organization.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Pathstatus.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Project.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Residentialmoveindate.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(RhybcpStatus.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Site.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Source.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(ClientVeteranInfo.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Coc.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Contact.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Education.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Entryrhsp.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Entryrhy.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Entryssvf.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Exitrhy.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(ServiceFaReferral.class.getName(), projectGroupCode,exportId);
	}
	
}

