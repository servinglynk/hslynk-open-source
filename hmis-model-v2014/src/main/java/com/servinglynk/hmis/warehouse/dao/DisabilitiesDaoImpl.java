/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
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
		Map<String, HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class,
				getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),
				com.servinglynk.hmis.warehouse.model.v2014.Export.class,
				String.valueOf(domain.getExport().getExportID()), getProjectGroupCode(domain), false, exportModelMap,
				domain.getUpload().getId());
		String insertTableSQL = "INSERT INTO v2014.disabilities("+
				"id, disabilityresponse, disabilitytype, documentationonfile, indefiniteandimpairs, pathhowconfirmed, pathsmiinformation, enrollmentid, receivingservices, project_group_code, date_created, date_created_from_source, date_updated_from_source, date_updated, user_id, export_id, parent_id, version, source_system_id, deleted, active, sync, datacollectionstage, information_date) "+
				"VALUES (?,?, CAST(? AS v2014.disability_type), CAST(? AS v2014.no_yes), CAST(? AS v2014.five_val_dk_refused), CAST(? AS v2014.path_how_confirmed), CAST(? AS v2014.path_smi_info_how_confirmed), ?, CAST(? AS v2014.five_val_dk_refused), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CAST(? AS v2014.datacollectionstage), ?)"; 
		PreparedStatement preparedStatement = getConnection().prepareStatement(insertTableSQL);;
		int batchTotal = 0;
		if (CollectionUtils.isNotEmpty(disabilitiesList)) {
			for(Disabilities disabilities : disabilitiesList) {
				processData(disabilities, domain, data, modelMap, relatedModelMap, exportEntity,batchTotal,preparedStatement);
				batchTotal++;
			}
		}
		   int[] result = preparedStatement.executeBatch();
           preparedStatement.clearBatch();
		connection.commit();
		hydrateBulkUploadActivityStaging(data.i, data.j, data.ignore,
				com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(), domain, exportEntity);
	}

	public void processData(Disabilities disabilities, ExportDomain domain, Data data,
			Map<String, HmisBaseModel> modelMap, Map<String, HmisBaseModel> relatedModelMap,
			com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity, int batchTotal,PreparedStatement preparedStatement) {

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
			hydrate(model,batchTotal++,preparedStatement,model.getExport().getId(),UUID.randomUUID());
			//performSaveOrUpdate(model);
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

	public void hydrate(com.servinglynk.hmis.warehouse.model.v2014.Disabilities model, int batchTotal, PreparedStatement preparedStatement,UUID exportId,UUID id) {
			
		try {
			 	connection.setAutoCommit(false);
		        preparedStatement.setObject(1,id);
		        preparedStatement.setInt(2, model.getDisabilityresponse() !=null ? model.getDisabilityresponse() : 0);
				preparedStatement.setString(3,model.getDisabilitytype() != null ? model.getDisabilitytype().getValue(): "99" );
				preparedStatement.setString(4,model.getDocumentationonfile() !=null ? model.getDocumentationonfile().getValue():"99" );
				preparedStatement.setString(5,model.getIndefiniteandimpairs() !=null ? model.getIndefiniteandimpairs().getValue():"99");
				preparedStatement.setString(6,model.getPathhowconfirmed() !=null ? model.getPathhowconfirmed().getValue():"99");
				preparedStatement.setString(7,model.getPathsmiinformation() !=null ? model.getPathsmiinformation().getValue(): "99");
				preparedStatement.setObject(8,model.getEnrollmentid() != null ? model.getEnrollmentid().getId(): null);
				preparedStatement.setString(9,model.getReceivingservices() !=null ? model.getReceivingservices().getValue(): "99");
				preparedStatement.setString(10,model.getProjectGroupCode());
				preparedStatement.setTimestamp(11,getCurrentTimeStamp());
				preparedStatement.setTimestamp(12,getTimeStamp(model.getDateCreatedFromSource()));
				preparedStatement.setTimestamp(13,getTimeStamp(model.getDateUpdatedFromSource()));
				preparedStatement.setTimestamp(14,getCurrentTimeStamp());
				preparedStatement.setObject(15,model.getUserId());
				preparedStatement.setObject(16,exportId != null ? exportId : null);
				preparedStatement.setObject(17,null);
				preparedStatement.setInt(18,0);
				preparedStatement.setString(19,model.getSourceSystemId());
				preparedStatement.setBoolean(20,false);
				preparedStatement.setBoolean(21,true);
				preparedStatement.setBoolean(22,false);
				preparedStatement.setString(23,model.getDataCollectionStage() !=null ? model.getDataCollectionStage().getValue(): null);
				preparedStatement.setTimestamp(24,getTimeStamp(model.getInformationDate()));
		        preparedStatement.addBatch();
		        if (batchTotal % 1000 == 0 ) {
		            int[] result = preparedStatement.executeBatch();
		            logger.info("Executing batch at ID::"+model.getSourceSystemId());
		            preparedStatement.clearBatch();
		            batchTotal=0;                    
		        }
			}
		     catch (SQLException e) {
		    	 logger.error("Error in Disabilities table source id"+model.getSourceSystemId()+ "execption:"+e.getStackTrace());
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
		if (!isFullRefresh(domain))
			modelFromDB = (com.servinglynk.hmis.warehouse.model.v2014.Disabilities) getModel(
					com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class.getSimpleName(),
					com.servinglynk.hmis.warehouse.model.v2014.Disabilities.class, disabilities.getDisabilitiesID(),
					getProjectGroupCode(domain), false, modelMap, domain.getUpload().getId());

		if (modelFromDB == null) {
			modelFromDB = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
			modelFromDB.setId(UUID.randomUUID());
			modelFromDB.setRecordToBeInserted(true);
		}
		com.servinglynk.hmis.warehouse.model.v2014.Disabilities model = new com.servinglynk.hmis.warehouse.model.v2014.Disabilities();
		// org.springframework.beans.BeanUtils.copyProperties(modelFromDB,
		// model);
		model.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(disabilities.getDateUpdated()));
		performMatch(domain, modelFromDB, model, data);
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
