package com.servinglynk.hmis.warehouse.dao;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.UnmarshalException;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Appender;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.AwsS3Client;
import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.dao.helper.BulkUploadHelper2020;
import com.servinglynk.hmis.warehouse.dao.helper.ChronicHomelessCalcHelper;
import com.servinglynk.hmis.warehouse.dao.helper.ZipFileProcessor;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources;
import com.servinglynk.hmis.warehouse.domain.Sources.Source;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Moveindate;
import com.servinglynk.hmis.warehouse.enums.UploadStatus;
import com.servinglynk.hmis.warehouse.model.base.BulkUpload;
import com.servinglynk.hmis.warehouse.model.base.FileExportEntity;
import com.servinglynk.hmis.warehouse.model.base.FileExportParamEntity;
import com.servinglynk.hmis.warehouse.model.base.ProjectGroupEntity;
import com.servinglynk.hmis.warehouse.model.v2020.Affiliation;
import com.servinglynk.hmis.warehouse.model.v2020.Client;
import com.servinglynk.hmis.warehouse.model.v2020.ClientVeteranInfo;
import com.servinglynk.hmis.warehouse.model.v2020.Coc;
import com.servinglynk.hmis.warehouse.model.v2020.Contact;
import com.servinglynk.hmis.warehouse.model.v2020.Dateofengagement;
import com.servinglynk.hmis.warehouse.model.v2020.Disabilities;
import com.servinglynk.hmis.warehouse.model.v2020.Domesticviolence;
import com.servinglynk.hmis.warehouse.model.v2020.Education;
import com.servinglynk.hmis.warehouse.model.v2020.Employment;
import com.servinglynk.hmis.warehouse.model.v2020.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2020.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhsp;
import com.servinglynk.hmis.warehouse.model.v2020.Entryrhy;
import com.servinglynk.hmis.warehouse.model.v2020.Entryssvf;
import com.servinglynk.hmis.warehouse.model.v2020.Error2020;
import com.servinglynk.hmis.warehouse.model.v2020.Exit;
import com.servinglynk.hmis.warehouse.model.v2020.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2020.Exitrhy;
import com.servinglynk.hmis.warehouse.model.v2020.Funder;
import com.servinglynk.hmis.warehouse.model.v2020.HealthStatus;
import com.servinglynk.hmis.warehouse.model.v2020.Healthinsurance;
import com.servinglynk.hmis.warehouse.model.v2020.HmisBaseModel;
import com.servinglynk.hmis.warehouse.model.v2020.Incomeandsources;
import com.servinglynk.hmis.warehouse.model.v2020.Inventory;
import com.servinglynk.hmis.warehouse.model.v2020.Medicalassistance;
import com.servinglynk.hmis.warehouse.model.v2020.Noncashbenefits;
import com.servinglynk.hmis.warehouse.model.v2020.Organization;
import com.servinglynk.hmis.warehouse.model.v2020.Pathstatus;
import com.servinglynk.hmis.warehouse.model.v2020.Project;
import com.servinglynk.hmis.warehouse.model.v2020.RhybcpStatus;
import com.servinglynk.hmis.warehouse.model.v2020.ServiceFaReferral;

public class BulkUploaderDaoImpl extends ParentDaoImpl implements
		BulkUploaderDao {
	
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(BulkUploaderDaoImpl.class);
	
	@Autowired
	ParentDaoFactory parentDaoFactory;
	
	@Autowired
	BulkUploadHelper2020 bulkUploadHelper;
	
	@Autowired
	ChronicHomelessCalcHelper chronicHomelessCalcHelper;
	
	@Override
	@Transactional
	public BulkUpload performLoad(Long l,Appender appender,Boolean isFileFromS3) {
		BulkUpload upload = parentDaoFactory.getBulkUploaderWorkerDao().getBulkUploadId(l);
		try {
			if (appender != null) {
				logger.addAppender(appender);
			}
			logger.info("Bulk Uploader Process Begins..........");
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			ProjectGroupEntity projectGroupdEntity = parentDaoFactory.getProjectGroupDao().getProjectGroupByGroupCode(upload.getProjectGroupCode());
			insertOrUpdate(upload);
			long startNanos = System.nanoTime();
			Sources sources = null;
			try {
				sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
			} catch (UnmarshalException ex) {
				logger.error("Error executing the bulk upload process:: ", ex);
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
//			domain.setReUpload(true);
	//		domain.setReloadAll(true);
			upload.setDescription("enrollment");
			domain.setReloadAll(true);
			domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
			parentDaoFactory.getSourceDao().hydrateStaging(domain,null,null);
			Map<String, HmisBaseModel> sourceMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Source.class, getProjectGroupCode(domain));
			parentDaoFactory.getExportDao().hydrateStaging(domain,null,sourceMap);
			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
			startNanos = System.nanoTime();
		
			logger.info("Starting processing of Client table");
			if(StringUtils.equalsIgnoreCase("client", upload.getDescription()) || domain.isReloadAll() || domain.isReloadAll()) {
				parentDaoFactory.getClientDao().hydrateStaging(domain,exportModelMap,null); // DONE
				logger.info("Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			}
			
			if(StringUtils.equalsIgnoreCase("veteran_info", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
				parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			}
			//Inserting organization inserts Org,Project,Funder,Coc,Inventory,Site and Affiliation.
			if(StringUtils.equalsIgnoreCase("organization", upload.getDescription()) || domain.isReloadAll()) {
				parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
				Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Organization.class, getProjectGroupCode(domain));
				parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap, orgModelMap); // Done
				
			}
			
			if(StringUtils.equalsIgnoreCase("enrollment", upload.getDescription()) || domain.isReloadAll()) {
				startNanos = System.nanoTime();
				Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
				parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
				logger.info("Enrollment table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			}
			Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
			if(StringUtils.equalsIgnoreCase("pchild", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Project.class, getProjectGroupCode(domain));
				parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getCocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
			}
		
			if(StringUtils.equalsIgnoreCase("pcoc", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> cocModelMap = getCocModelMap(com.servinglynk.hmis.warehouse.model.v2020.Coc.class, getProjectGroupCode(domain));
				parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,cocModelMap); // Done
		    }
			if(StringUtils.equalsIgnoreCase("enrollmentcoc", upload.getDescription()) || domain.isReloadAll()) {
				parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			}
			
			if(StringUtils.equalsIgnoreCase("penrollment", upload.getDescription()) || domain.isReloadAll()) {
				
				parentDaoFactory.getAssessmentDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getAssessmentQuestionsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getAssessmentResultsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getCurrentLivingSituationDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getEventDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				
				parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				startNanos = System.nanoTime();
				parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				logger.info("Disabilities table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
				parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // DOne
				parentDaoFactory.getExitDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				
				parentDaoFactory.getEntryrhspDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryrhyDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryssvfDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getContactDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getServiceFaReferralDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEducationDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap); //Done

				parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getConnectionWithSoarDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
			
		    }
			if(StringUtils.equalsIgnoreCase("pexit", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Exit.class, getProjectGroupCode(domain));
				parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getExitrhyDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getVashExitReasonDao().hydrateStaging(domain, exportModelMap, exitModelMap);
				parentDaoFactory.getRhyAfterCareDao().hydrateStaging(domain, exportModelMap, exitModelMap);
			}
			calculateChronicHomelessness(upload.getProjectGroupCode());
				upload.setStatus(UploadStatus.STAGING.getStatus());
				insertOrUpdate(upload);
		} catch (Exception e) {
			e.printStackTrace();
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription("Cause::"+e.getCause() + "Message::"+e.getMessage());
			saveError(upload);
		}
		finally {
			if (appender != null) {
				logger.removeAppender(appender);
			}
		}
		return upload;
	}
	
	@Override
	@Transactional
	public BulkUpload performBulkUpload(BulkUpload upload, ProjectGroupEntity projectGroupdEntity,Appender appender,Boolean isFileFromS3) {
		try {
			if (appender != null) {
				logger.addAppender(appender);
			}
			logger.info("Bulk Uploader Process Begins..........");
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			insertOrUpdate(upload);
			long startNanos = System.nanoTime();
			Sources sources = null;
			try {
				sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
			} catch (UnmarshalException ex) {
				logger.error("Error executing the bulk upload process:: ", ex);
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
			//domain.setReUpload(true);
			domain.setReloadAll(true);
			
			domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);

			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
			startNanos = System.nanoTime();
			logger.info("Starting processing of Client table");
			if(StringUtils.equalsIgnoreCase("client", upload.getDescription()) || domain.isReloadAll() || domain.isReloadAll()) {
				parentDaoFactory.getClientDao().hydrateStaging(domain,exportModelMap,null); // DONE
				logger.info("Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			}
			
			if(StringUtils.equalsIgnoreCase("veteran_info", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
				parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
			}
			//Inserting organization inserts Org,Project,Funder,Coc,Inventory,Site and Affiliation.
			if(StringUtils.equalsIgnoreCase("organization", upload.getDescription()) || domain.isReloadAll()) {
				parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
				Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Organization.class, getProjectGroupCode(domain));
				parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap, orgModelMap); // Done
				
			}
			
			if(StringUtils.equalsIgnoreCase("enrollment", upload.getDescription()) || domain.isReloadAll()) {
				startNanos = System.nanoTime();
				Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
				parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
				logger.info("Enrollment table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
			}
		
			
			if(StringUtils.equalsIgnoreCase("pchild", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Project.class, getProjectGroupCode(domain));
				parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getCocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
				parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
			}
		
			if(StringUtils.equalsIgnoreCase("pcoc", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> cocModelMap = getCocModelMap(com.servinglynk.hmis.warehouse.model.v2020.Coc.class, getProjectGroupCode(domain));
				parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,cocModelMap); // Done
		    }
			if(StringUtils.equalsIgnoreCase("enrollmentcoc", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
				parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
			}
			
			if(StringUtils.equalsIgnoreCase("penrollment", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
				
				parentDaoFactory.getAssessmentDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getAssessmentQuestionsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getAssessmentResultsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getCurrentLivingSituationDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				parentDaoFactory.getEventDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
				
				parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				startNanos = System.nanoTime();
				parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				logger.info("Disabilities table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
				parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // DOne
				parentDaoFactory.getExitDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				
				parentDaoFactory.getEntryrhspDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryrhyDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEntryssvfDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getContactDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getServiceFaReferralDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getEducationDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap); //Done

				parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
				parentDaoFactory.getConnectionWithSoarDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
			
		    }
			if(StringUtils.equalsIgnoreCase("pexit", upload.getDescription()) || domain.isReloadAll()) {
				Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Exit.class, getProjectGroupCode(domain));
				parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getExitrhyDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
				parentDaoFactory.getVashExitReasonDao().hydrateStaging(domain, exportModelMap, exitModelMap);
				parentDaoFactory.getRhyAfterCareDao().hydrateStaging(domain, exportModelMap, exitModelMap);
			}
//			upload.setExportId(domain.getExportId());
			upload.setStatus(UploadStatus.STAGING.getStatus());
			logger.debug("Chaning status of Bulk_upload table to STAGING");
			insertOrUpdate(upload); 
			logger.debug("Bulk Upload Staging Process Ends.....");
		} catch (Exception e) {
			e.printStackTrace();
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription("Cause::"+e.getCause() + "Message::"+e.getMessage());
			saveError(upload);
		}
		finally {
			if (appender != null) {
				logger.removeAppender(appender);
			}
		}
		return upload;
	}
	public void saveError(BulkUpload upload) {
		try {
			parentDaoFactory.getBulkUploaderWorkerDao().insertOrUpdate(upload);
			Error2020 error = new Error2020();
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
	
	/***
	 * Get Models by source system id and project group code.
	 * @param className
	 * @param projectGroupCode
	 * @return
	 */
	protected Map<String,HmisBaseModel> getCocModelMap(Class className ,String projectGroupCode) {
		Map<String,HmisBaseModel> resultsMap = new HashMap<String, HmisBaseModel>();
		if(projectGroupCode !=null) {
			Criteria criteria = getCurrentSession().createCriteria(className);
			criteria.add(Restrictions.eq("projectGroupCode",projectGroupCode.trim()));
			criteria.add(Restrictions.eq("deleted",false));
			criteria.addOrder( Order.desc("dateCreated") );
			@SuppressWarnings("unchecked")
			List<HmisBaseModel> models = (List<HmisBaseModel>) criteria.list() ;
			if(CollectionUtils.isNotEmpty(models)) {
				 for(HmisBaseModel model : models ){
					 Coc coc = (Coc) model;
					 if(StringUtils.isNotBlank(coc.getCoccode()))
						 resultsMap.put(coc.getCoccode(), model);
				 }
			}
		}
		return resultsMap;
	}
	
	@Override
	public void calculateChronicHomelessness(String projectGroupCode) {
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, projectGroupCode);
		if(!enrollmentModelMap.isEmpty()) {
			Collection<HmisBaseModel> enrollments = enrollmentModelMap.values();
			for(HmisBaseModel model : enrollments) {
				Enrollment enrollmentModel = (Enrollment) model;
				Enrollment enrollment = (Enrollment) get(Enrollment.class, enrollmentModel.getId());
				enrollment.setChronicHomeless(chronicHomelessCalcHelper.isEnrollmentChronicHomeless(enrollment));
				if(enrollment.isChronicHomeless()) {
					enrollment.setDateUpdated(LocalDateTime.now());
					getCurrentSession().merge(enrollment);
				}
			}
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
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) get(com.servinglynk.hmis.warehouse.model.v2020.Export.class,exportId);
		deleteFromDB(exportEntity);
	}

	@Override
	public void deleteLiveByExportId(UUID exportId) {
		com.servinglynk.hmis.warehouse.model.v2020.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2020.Export) get(com.servinglynk.hmis.warehouse.model.v2020.Export.class,exportId);
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
		undoSoftDeleteByExportId(Incomeandsources.class.getName(), exportId);
		undoSoftDeleteByExportId(Inventory.class.getName(), exportId);
		undoSoftDeleteByExportId(Medicalassistance.class.getName(), exportId);
		undoSoftDeleteByExportId(Noncashbenefits.class.getName(), exportId);
		undoSoftDeleteByExportId(Organization.class.getName(), exportId);
		undoSoftDeleteByExportId(Project.class.getName(), exportId);
		undoSoftDeleteByExportId(Moveindate.class.getName(), exportId);
		undoSoftDeleteByExportId(RhybcpStatus.class.getName(), exportId);
		undoSoftDeleteByExportId(Source.class.getName(), exportId);
		undoSoftDeleteByExportId(ClientVeteranInfo.class.getName(), exportId);
		undoSoftDeleteByExportId(BulkUpload.class.getName(), exportId);
	}
	
	@Override
	public void deleteLiveByProjectGroupCode(String projectGroupCode, UUID exportId) {
		softDeleteByProjectGroupCode(Affiliation.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(com.servinglynk.hmis.warehouse.model.v2020.Client.class.getName(), projectGroupCode,exportId);
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
		softDeleteByProjectGroupCode(Incomeandsources.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Inventory.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Medicalassistance.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Noncashbenefits.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Organization.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Pathstatus.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Project.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(Moveindate.class.getName(), projectGroupCode,exportId);
		softDeleteByProjectGroupCode(RhybcpStatus.class.getName(), projectGroupCode,exportId);
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
	
	@Transactional(readOnly = false)
	public void saveUpload(BulkUpload upload) {
		getCurrentSession().evict(upload);
		insertOrUpdate(upload);
		getCurrentSession().flush();
		getCurrentSession().clear();
	}
	
	@Override
	@Transactional
	public BulkUpload processBase(BulkUpload upload, ProjectGroupEntity projectGroupdEntity, Appender appender,
			Boolean isFileFromS3) {
			if (appender != null) {
				logger.addAppender(appender);
			}
		try {
			logger.info("Base Process::: Bulk Upload Processing Begin.....");
			upload.setStatus(UploadStatus.INPROGRESS.getStatus());
			saveUpload(upload);
			long startNanos = System.nanoTime();
			ExportDomain domain = getSource(upload, projectGroupdEntity, appender, isFileFromS3);
			
			parentDaoFactory.getSourceDao().hydrateStaging(domain,null,null);
			Map<String, HmisBaseModel> sourceMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Source.class, getProjectGroupCode(domain));
			parentDaoFactory.getExportDao().hydrateStaging(domain,null,sourceMap);
			logger.info("Base Process::: Bulk Upload Processing client Table Begin.....");
			startNanos = System.nanoTime();
			Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
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
			upload.setDescription(" Upload Error:"+e.getMessage());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
		parentDaoFactory.getEnrollmentDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
		logger.info(" Enrollment Process::: Bulk Upload Processing client Table Ends.....");
		logger.info("Enrollment Process::: Enrollment table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.C_CLIENT.getStatus());
		upload.setExportId(domain.getExportId());
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		insertOrUpdate(upload);
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(" Upload Error:"+e.getMessage());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> clientModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Client.class, getProjectGroupCode(domain));
		parentDaoFactory.getVeteranInfoDao().hydrateStaging(domain,exportModelMap,clientModelMap); // Done
		//Inserting organization inserts Org,Project,Funder,Coc,Inventory,Site and Affiliation.
		parentDaoFactory.getOrganizationDao().hydrateStaging(domain,exportModelMap,null); // Done
		Map<String, HmisBaseModel> orgModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Organization.class, getProjectGroupCode(domain));
		parentDaoFactory.getProjectDao().hydrateStaging(domain,exportModelMap, orgModelMap); // Done
		Map<String, HmisBaseModel> projectModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Project.class, getProjectGroupCode(domain));
		parentDaoFactory.getAffiliationDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		parentDaoFactory.getCocDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		parentDaoFactory.getFunderDao().hydrateStaging(domain,exportModelMap,projectModelMap); // Done
		Map<String, HmisBaseModel> cocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Coc.class, getProjectGroupCode(domain));
		parentDaoFactory.getInventoryDao().hydrateStaging(domain,exportModelMap,cocModelMap); // Done

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
			upload.setDescription(" Upload Error:"+e.getMessage());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
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
			upload.setDescription(" Upload Error:"+e.getMessage());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
		parentDaoFactory.getDisabilitiesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		logger.info(" Disabilities Process::: Bulk Upload Processing client Table Ends.....");
		logger.info("Disabilities Process::: Client table took " + TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos) + " millis");
		upload.setStatus(UploadStatus.STAGING.getStatus());
		upload.setExportId(domain.getExportId());
		logger.info(" Calculating Chronic Homelessness.....");
		parentDaoFactory.getBulkUploaderDao().calculateChronicHomelessness(upload.getProjectGroupCode());
		upload.setStatus(UploadStatus.LIVE.getStatus());
		//Delete all the files
		if(isFileFromS3) {
			deleteFile(upload.getInputpath()); 
		}
		deleteFile(upload.getInputpath()+"-temp.xml");
		insertOrUpdate(upload);
		}catch(Exception e) {
			upload.setStatus(UploadStatus.ERROR.getStatus());
			upload.setDescription(" Upload Error:"+e.getMessage());
			insertOrUpdate(upload);
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
			logger.info("Reading the file::"+upload.getInputpath());
			sources = bulkUploadHelper.getSourcesFromFiles(upload, projectGroupdEntity,isFileFromS3);
		} catch (Exception ex) {
			logger.error("Error executing the bulk upload process:: ", ex);
			upload.setStatus(UploadStatus.ERROR.getStatus());
			String errorMessage = "HUD File Uploaded is in an invalid Format";
			String errorDesc = !"null".equals(String.valueOf(ex.getCause()))  ? String.valueOf(ex.getCause()) : ex.getMessage();
			
			upload.setDescription(errorMessage  +":"+ ex.getMessage());
			
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
		if(StringUtils.equals("RELOAD", upload.getDescription()) || domain.isReloadAll()) {
			domain.setReUpload(true);
		}
		domain.setExport(export);
		domain.setUpload(upload);
		domain.setSource(source);
		domain.setUserId(upload.getUser()!=null ?  upload.getUser().getId():null);
		domain.setFullRefresh(upload.isIgnoreDuplicateCheck());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> exitModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Exit.class, getProjectGroupCode(domain));
		parentDaoFactory.getExithousingassessmentDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getExitrhyDao().hydrateStaging(domain,exportModelMap,exitModelMap); // Done
		parentDaoFactory.getVashExitReasonDao().hydrateStaging(domain, exportModelMap, exitModelMap);
		parentDaoFactory.getRhyAfterCareDao().hydrateStaging(domain, exportModelMap, exitModelMap);
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
			upload.setDescription(" Upload Error:"+e.getMessage());
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
		Map<String, HmisBaseModel> exportModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Export.class, getProjectGroupCode(domain));
		Map<String, HmisBaseModel> enrollmentModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2020.Enrollment.class, getProjectGroupCode(domain));
		
		parentDaoFactory.getAssessmentDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
		parentDaoFactory.getAssessmentQuestionsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
		parentDaoFactory.getAssessmentResultsDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
		parentDaoFactory.getCurrentLivingSituationDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
		parentDaoFactory.getEventDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
		
		parentDaoFactory.getDateofengagementDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getEnrollmentCocDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getResidentialmoveindateDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		startNanos = System.nanoTime();
		parentDaoFactory.getDomesticviolenceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getEmploymentDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // DOne

		
		parentDaoFactory.getEntryrhspDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getEntryrhyDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getEntryssvfDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getContactDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getServiceFaReferralDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getHealthinsuranceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getHealthStatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done


		parentDaoFactory.getIncomeandsourcesDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getMedicalassistanceDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getNoncashbenefitsDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getPathstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getRhybcpstatusDao().hydrateStaging(domain,exportModelMap,enrollmentModelMap); // Done
		parentDaoFactory.getConnectionWithSoarDao().hydrateStaging(domain, exportModelMap, enrollmentModelMap);
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
			upload.setDescription(" Upload Error:"+e.getMessage());
			insertOrUpdate(upload);
			logger.error(" Error in ExitChildren process....."+e.getLocalizedMessage() +" cause:"+e.getCause());
		}
			return upload;
	}
	
	
	@Override
	@Transactional
	public boolean performFileExport(FileExportEntity fileExport, Appender appender,Boolean isFileFromS3) {
		long startNanos = System.nanoTime();
		try {
			List<FileExportEntity> fileExportEntities = parentDaoFactory.getFileExportDao().getFileExportByStatusEmailSent("INITIAL", false);
			if(CollectionUtils.isNotEmpty(fileExportEntities)) {
				FileExportEntity fileExportEntity = fileExportEntities.get(0);
				List<String> projectIds = new ArrayList<>();
				List<FileExportParamEntity> fileExportParams = fileExportEntity.getFileExportParams();
				for(FileExportParamEntity fileExportParam : fileExportParams) {
					projectIds.add(fileExportParam.getValue());
				}
				// Get the Projects from the above criteria:
				boolean fillHeaders = true;
				List<Project> projectsForExport = parentDaoFactory.getProjectDao().getProjectsForExport(fileExportEntity.getProjectGroupCode(), projectIds, fileExportEntity.getStartDate(), fileExportEntity.getEndDate());
				// Now convert Project Entities to CSV
				parentDaoFactory.getProjectCsvConverter().writeToCSV(projectsForExport,fillHeaders);
				for(Project project : projectsForExport) {
					 parentDaoFactory.getOrganizationCsvConverter().writeToCSV(project.getOrganizationid(), fillHeaders);
					 parentDaoFactory.getProjectCocCsvConverter().writeToCSV(project.getCocs(), fillHeaders);
					 parentDaoFactory.getExportCsvConverter().writeToCSV(project.getExport(), fillHeaders);
					 parentDaoFactory.getInventoryCsvConverter().writeToCSV(project.getInventories(), fillHeaders);
					 parentDaoFactory.getAffiliationCsvConverter().writeToCSV(project.getAffiliations(),fillHeaders);
					 parentDaoFactory.getFunderCsvConverter().writeToCSV(project.getFunders(),fillHeaders);
					 Set<Enrollment> enrollments = project.getEnrollments();
					 parentDaoFactory.getEnrollmentCsvConverter().writeToCSV(enrollments,fillHeaders);
					 if(CollectionUtils.isNotEmpty(enrollments)) {
						 for(com.servinglynk.hmis.warehouse.model.v2020.Enrollment enrollment : enrollments) {
							 parentDaoFactory.getClientCsvConverter().writeToCSV(enrollment.getClient(), fillHeaders);
							 parentDaoFactory.getAssessmentCsvConverter().writeToCSV(enrollment.getAssessments(), fillHeaders);
							 parentDaoFactory.getAssessmentQuestionsCsvConverter().writeToCSV(enrollment.getAssessmentQuestions(), fillHeaders);
							 parentDaoFactory.getAssessmentResultsCsvConverter().writeToCSV(enrollment.getAssessmentResults(), fillHeaders);
							 parentDaoFactory.getCurrentLivingSituationCsvConverter().writeToCSV(enrollment.getCurrentLivingSituations(), fillHeaders);
							 parentDaoFactory.getDisabilitiesCsvConverter().writeToCSV(enrollment.getDisabilitieses(), fillHeaders);
							 parentDaoFactory.getEmploymentEducationCsvConverter().writeToCSV(enrollment, fillHeaders);
							 parentDaoFactory.getEnrollmentCocCsvConverter().writeToCSV(enrollment.getEnrollmentCocs(), fillHeaders);
							 parentDaoFactory.getExitCsvConverter().writeToCSV(enrollment.getExits(), fillHeaders);
							 parentDaoFactory.getHealthAndDvCsvConverter().writeToCSV(enrollment, fillHeaders);
							 parentDaoFactory.getIncomeBenefitsCsvConverter().writeToCSV(enrollment, fillHeaders);
							 parentDaoFactory.getServicesCsvConverter().writeToCSV(enrollment, fillHeaders);
							 fillHeaders = false;
						 }
					 }
					 fillHeaders = false;
				}
				ProjectGroupEntity projectGroupByGroupCode = parentDaoFactory.getProjectGroupDao().getProjectGroupByGroupCode(fileExportEntity.getProjectGroupCode());
				
	          	  // Get the bucket name from project group code.
	            	ZipFileProcessor.createZipFile("/Users/sdolia/github/hmis-lynk-open-source/hmis-load-processor-v2020/", "/Users/sdolia/github/hmis-lynk-open-source/",fileExportEntity.getId()+".zip");
	            	
	        		Collection<File> files =  FileUtils.listFiles(new File("/Users/sdolia/github/hmis-lynk-open-source/hmis-load-processor-v2020/"), new String[]{"csv"}, true);
	    			for (File file : files) {
	    			  file.delete();
	    			}
	    			fileExportEntity.setStatus("COMPLETED");
	    			parentDaoFactory.getFileExportDao().updateFileExport(fileExportEntity);
	    			
	            	//SyncPostgresProcessor.updateReportConfig("BEFORE_S3", reportConfig.getId());
	    		    String bucketName = projectGroupByGroupCode.getBucketName();
	    			AwsS3Client client = new AwsS3Client();
	    			client.uploadFile(fileExportEntity.getId()+".zip", "Export/"+fileExportEntity.getId()+".zip",bucketName);
	    			// update the report config to 
	    	
	    			
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
			
	
}

