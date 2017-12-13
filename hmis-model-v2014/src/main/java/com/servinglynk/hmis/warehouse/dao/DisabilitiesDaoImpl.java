/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Disabilities;
import com.servinglynk.hmis.warehouse.enums.DataCollectionStageEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDisabilitytypeEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesDocumentationonfileEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesIndefiniteandimpairsEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathhowconfirmedEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesPathsmiinformationEnum;
import com.servinglynk.hmis.warehouse.enums.DisabilitiesReceivingservicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Error2014;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class DisabilitiesDaoImpl extends ParentDaoImpl implements DisabilitiesDao {
	private static final Logger logger = LoggerFactory.getLogger(DisabilitiesDaoImpl.class);
	private static final String PROPERTY_NAME_DATABASE_DRIVER   = "db.driver";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "db.password";
    private static final String PROPERTY_NAME_DATABASE_URL      = "db.url";
    private static final String PROPERTY_NAME_DATABASE_USERNAME = "db.username";
    
	@Resource
	private Environment env;
		
	public void hydrateStaging(ExportDomain domain, Map<String, HmisBaseModel> exportModelMap,
			Map<String, HmisBaseModel> relatedModelMap) throws Exception {
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = new HashMap<String, HmisBaseModel>();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),
				com.servinglynk.hmis.warehouse.model.v2014.Export.class,
				String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap,
				domain.getUpload().getId());
		if (CollectionUtils.isNotEmpty(disabilitiesList)) {
			for(Disabilities disabilities : disabilitiesList) {
				processData(disabilities, domain, data, modelMap, relatedModelMap, exportEntity);
			}
		}
		hydrateBulkUploadActivityStaging(data.i, data.j, data.ignore,
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain, exportEntity);
	}

	public void hydrate(ExportDomain domain, Map<String, HmisBaseModel> exportModelMap,
			Map<String, HmisBaseModel> relatedModelMap) throws Exception {
		Export export = domain.getExport();
		List<Disabilities> disabilitiesList = export.getDisabilities();
		Data data = new Data();
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class,
				getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),
				com.servinglynk.hmis.warehouse.model.v2014.Export.class,
				String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap,
				domain.getUpload().getId());
		 String fileName =domain.getUpload().getId()+"-disab.csv";
		if (CollectionUtils.isNotEmpty(disabilitiesList)) {
		
			 BufferedOutputStream bout = null;
				try {
		     bout = new BufferedOutputStream( new FileOutputStream(fileName));
		     int i=1;
		     int total =1;
		     
			for(Disabilities disabilities : disabilitiesList) {
				processLargeData(disabilities, domain, data, modelMap, relatedModelMap, exportEntity,bout);
				if(i % 50000 == 0) {
					logger.info("Writing to file disab ::"+fileName);
					bout.close();
					copyDisabilitiesData(fileName);
					logger.info("Copy command executed on file ::"+fileName);
					fileName = domain.getUpload().getId()+"disab-"+total+".csv";
					bout = new BufferedOutputStream( new FileOutputStream(fileName)) ;
					total++;
				}
				i++;
			}
			
		   }catch (IOException e) {
	        } finally {
           if (bout != null) {
               try {
                   bout.close();
                   copyDisabilitiesData(fileName);
               } catch (Exception e) {
            	   
               }
           }
	       }
		}
		hydrateBulkUploadActivityStaging(data.i, data.j, data.ignore,
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain, exportEntity);
	}
	
	
	public void copyDisabilitiesData(String fileName) {
		FileReader fr = null;
		try {
			
            CopyManager cm = new CopyManager((BaseConnection) getConnection());

             fr = new FileReader(fileName);
            cm.copyIn("COPY v2014.disabilities FROM STDIN WITH DELIMITER AS ','", fr);

        } catch (SQLException | IOException ex) {
        	ex.printStackTrace();

        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (Exception ex) {
            	ex.printStackTrace();
            }
        }
	}
	public void processData(Disabilities disabilities, ExportDomain domain, Data data,
			Map<String, HmisBaseModel> modelMap, Map<String, HmisBaseModel> relatedModelMap,
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity) {

		com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = getModelObject(domain, disabilities, data,
				modelMap);
		
		try {
			model.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
			model.setDisabilitytype(DisabilitiesDisabilitytypeEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
			model.setDocumentationonfile(DisabilitiesDocumentationonfileEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
			model.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
			model.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
			model.setPathsmiinformation(DisabilitiesPathsmiinformationEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
			model.setReceivingservices(DisabilitiesReceivingservicesEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
			Enrollment enrollmentModel = (Enrollment) parentDaoFactory.getEnrollmentDao().getEnrollmentByProjectGroupCodeAndSourceSystem(domain.getUpload().getProjectGroupCode(), disabilities.getDisabilitiesID(), null);
			model.setEnrollmentid(enrollmentModel);
			model.setInformationDate(BasicDataGenerator.getLocalDateTime(disabilities.getInformationDate()));
			model.setDataCollectionStage(DataCollectionStageEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDataCollectionStage())));
			model.setExport(exportEntity);
			performSaveOrUpdate(model);
		} catch (Exception e) {
			String errorMessage = "Exception in Disabilities :" + disabilities.getProjectEntryID() + ":: Exception"
					+ e.getStackTrace();
			if (model != null) {
				Error2014 error = new Error2014();
				error.model_id = model.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = model.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = model.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
	}
	
	public void processLargeData(Disabilities disabilities, ExportDomain domain, Data data,
			Map<String, HmisBaseModel> modelMap, Map<String, HmisBaseModel> relatedModelMap,
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity, BufferedOutputStream bout) {

		com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = getModelObject(domain, disabilities, data,
				modelMap);
		
		try {
			model = getModelObject(domain, disabilities, data, modelMap);
			model.setDisabilityresponse(BasicDataGenerator.getIntegerValue(disabilities.getDisabilityResponse()));
			model.setDisabilitytype(DisabilitiesDisabilitytypeEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDisabilityType())));
			model.setDocumentationonfile(DisabilitiesDocumentationonfileEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDocumentationOnFile())));
			model.setIndefiniteandimpairs(DisabilitiesIndefiniteandimpairsEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getIndefiniteAndImpairs())));
			model.setPathhowconfirmed(DisabilitiesPathhowconfirmedEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHHowConfirmed())));
			model.setPathsmiinformation(DisabilitiesPathsmiinformationEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getPATHSMIInformation())));
			model.setReceivingservices(DisabilitiesReceivingservicesEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getReceivingServices())));
			model.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateCreated()));
			model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
			Enrollment enrollmentModel = (Enrollment) getModel(
					com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), Enrollment.class,
					disabilities.getProjectEntryID(), getProjectGroupCode(domain), true, relatedModelMap,
					domain.getUpload().getId());
			model.setEnrollmentid(enrollmentModel);
			model.setInformationDate(BasicDataGenerator.getLocalDateTime(disabilities.getInformationDate()));
			model.setDataCollectionStage(DataCollectionStageEnum
					.lookupEnum(BasicDataGenerator.getStringValue(disabilities.getDataCollectionStage())));
			model.setExport(exportEntity);
			hydrate(model,model.getExport().getId(),UUID.randomUUID(),bout);
		               
		} catch (Exception e) {
			String errorMessage = "Exception in Disabilities :" + disabilities.getProjectEntryID() + ":: Exception"
					+ e.getStackTrace();
			if (model != null) {
				Error2014 error = new Error2014();
				error.model_id = model.getId();
				error.bulk_upload_ui = domain.getUpload().getId();
				error.project_group_code = domain.getUpload().getProjectGroupCode();
				error.source_system_id = model.getSourceSystemId();
				error.type = ErrorType.ERROR;
				error.error_description = errorMessage;
				error.date_created = model.getDateCreated();
				performSave(error);
			}
			logger.error(errorMessage);
		}
	}
	
	public void hydrate(com.servinglynk.hmis.warehouse.model.v2014.Disabilities model,UUID exportId,UUID id,BufferedOutputStream bout) {
			
		try {
				String commaDemiliter =",";
				StringBuilder builder = new StringBuilder();
				builder.append(id);
				builder.append(commaDemiliter);
				builder.append( model.getDisabilityresponse() !=null ? model.getDisabilityresponse() : 0);
				builder.append(commaDemiliter);
				builder.append(model.getDisabilitytype() != null ? model.getDisabilitytype().getValue(): "99");
				builder.append(commaDemiliter);
				builder.append(model.getDocumentationonfile() !=null ? model.getDocumentationonfile().getValue():"99");
				builder.append(commaDemiliter);
				builder.append(model.getIndefiniteandimpairs() !=null ? model.getIndefiniteandimpairs().getValue():"99");
				builder.append(commaDemiliter);
				builder.append(model.getPathhowconfirmed() !=null ? model.getPathhowconfirmed().getValue():"99");
				builder.append(commaDemiliter);
				builder.append(model.getPathsmiinformation() !=null ? model.getPathsmiinformation().getValue(): "99");
				builder.append(commaDemiliter);
				builder.append(model.getEnrollmentid() != null ? model.getEnrollmentid().getId(): "00000000-0000-0000-0000-000000000000");
				builder.append(commaDemiliter);
				builder.append(model.getReceivingservices() !=null ? model.getReceivingservices().getValue(): "99");
				builder.append(commaDemiliter);
				builder.append(model.getProjectGroupCode());
				builder.append(commaDemiliter);
				builder.append(getCurrentTimeStamp());
				builder.append(commaDemiliter);
				builder.append(getTimeStamp(model.getDateCreatedFromSource()));
				builder.append(commaDemiliter);
				builder.append(getTimeStamp(model.getDateUpdatedFromSource()));
				builder.append(commaDemiliter);
				builder.append(getCurrentTimeStamp());
				builder.append(commaDemiliter);
				builder.append(model.getUserId() !=null ? model.getUserId() :"00000000-0000-0000-0000-000000000000");
				builder.append(commaDemiliter);
				builder.append(exportId != null ? exportId : "00000000-0000-0000-0000-000000000000");
				builder.append(commaDemiliter);
			    builder.append("00000000-0000-0000-0000-000000000000");
				builder.append(commaDemiliter);
				builder.append(0);
				builder.append(commaDemiliter);
				builder.append(model.getSourceSystemId());
				builder.append(commaDemiliter);
				builder.append(false);
				builder.append(commaDemiliter);
				builder.append(true);
				builder.append(commaDemiliter);
				builder.append(false);
				builder.append(commaDemiliter);
				builder.append(model.getDataCollectionStage() !=null ? model.getDataCollectionStage().getValue(): null);
				builder.append(commaDemiliter);
				builder.append(getTimeStamp(model.getInformationDate()));
//				builder.append(commaDemiliter);
//				builder.append(
//				builder.append(commaDemiliter);
//		        preparedStatement.addBatch();
//		        if (batchTotal % 1000 == 0 ) {
//		            int[] result = preparedStatement.executeBatch();
//		            logger.info("Executing batch at ID::"+model.getSourceSystemId());
//		            preparedStatement.clearBatch();
//		            batchTotal=0;                    
//		        }
		        bout.write(builder.toString().getBytes());
		        bout.write("\n".getBytes());
			}
		     catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	private  java.sql.Timestamp getTimeStamp(LocalDateTime dateTime) {
		return Timestamp.valueOf(dateTime);
	}

	private  java.sql.Timestamp getCurrentTimeStamp() {
	
		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());
	
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getModelObject(ExportDomain domain,
			Disabilities disabilities, Data data, Map<String, HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Disabilities modelFromDB = null;
		// We always insert for a Full refresh and update if the record exists
		// for Delta refresh
		if (modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
		model.setId(UUID.randomUUID());
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB,
		// model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
		hydrateCommonFields(model, domain, disabilities.getDisabilitiesID(), data);

		return model;
	}

	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities createDisabilities(
			com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities) {
		disabilities.setId(UUID.randomUUID());
		insert(disabilities);
		return disabilities;
	}

	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities updateDisabilities(
			com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities) {
		update(disabilities);
		return disabilities;
	}

	public void deleteDisabilities(com.servinglynk.hmis.warehouse.model.v2014.Disabilities disabilities) {
		delete(disabilities);
	}

	public com.servinglynk.hmis.warehouse.model.v2014.Disabilities getDisabilitiesById(UUID disabilitiesId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
		criteria.add(Restrictions.eq("id", disabilitiesId));
		List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> entities = (List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities>) findByCriteria(
				criteria);
		if (!entities.isEmpty())
			return entities.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities> getAllEnrollmentDisabilitiess(
			UUID enrollmentId, Integer startIndex, Integer maxItems) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
		criteria.createAlias("enrollmentid", "enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		return (List<com.servinglynk.hmis.warehouse.model.v2014.Disabilities>) findByCriteria(criteria, startIndex,
				maxItems);
	}

	public long getEnrollmentDisabilitiessCount(UUID enrollmentId) {
		DetachedCriteria criteria = DetachedCriteria
				.forClass(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class);
		criteria.createAlias("enrollmentid", "enrollmentid");
		criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
		return countRows(criteria);
	}
	
	
	
    public Connection connection = null;
    public Connection getConnection() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    env.getRequiredProperty(PROPERTY_NAME_DATABASE_URL),
                    env.getRequiredProperty(PROPERTY_NAME_DATABASE_USERNAME),
                    env.getRequiredProperty(PROPERTY_NAME_DATABASE_PASSWORD));
        }
        if (connection.isClosed()) {
            throw new SQLException("connection could not initiated");
        }
        return connection;
    }
}
