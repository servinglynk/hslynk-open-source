/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.base.util.ErrorType;
import com.servinglynk.hmis.warehouse.model.v2014.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class EnrollmentCocDaoImpl extends ParentDaoImpl implements
		EnrollmentCocDao {
	
	private static final Logger logger = LoggerFactory
			.getLogger(EnrollmentCocDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		
		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap, domain.getUpload().getId());
		Data data =new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class, getProjectGroupCode(domain));
		Map<String,HmisBaseModel> projectCocModelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Projectcoc.class, getProjectGroupCode(domain));
		if(enrollmentCoCs!=null)
		{
			for(EnrollmentCoC enrollmentCoc : enrollmentCoCs)
			{
				EnrollmentCoc enrollmentCocModel = null;
				try {
					enrollmentCocModel = getModelObject(domain, enrollmentCoc,data,modelMap);
					enrollmentCocModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
					enrollmentCocModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,enrollmentCoc.getProjectEntryID(),getProjectGroupCode(domain),true,relatedModelMap, domain.getUpload().getId());
					enrollmentCocModel.setEnrollmentid(enrollmentModel);
     				Projectcoc projectCoc = (Projectcoc) getModel(Projectcoc.class,enrollmentCoc.getProjectCoCID(),getProjectGroupCode(domain),false,projectCocModelMap, domain.getUpload().getId());
					enrollmentCocModel.setProjectCoc(projectCoc);	
					//enrollmentCocModel.setCocCode(enrollmentCoc.get
					enrollmentCocModel.setExport(exportEntity);
					performSaveOrUpdate(enrollmentCocModel);
				} catch (Exception e) {
					String errorMessage = "Error occured with "+enrollmentCoc.toString() + " Execption :::"+e.getLocalizedMessage();
					if (enrollmentCocModel != null) {
						Error2014 error = new Error2014();
						error.model_id = enrollmentCocModel.getId();
						error.bulk_upload_ui = domain.getUpload().getId();
						error.project_group_code = domain.getUpload().getProjectGroupCode();
						error.source_system_id = enrollmentCocModel.getSourceSystemId();
						error.type = ErrorType.ERROR;
						error.error_description = errorMessage;
						error.date_created = enrollmentCocModel.getDateCreated();
						performSave(error);
					}
					logger.error(errorMessage);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, EnrollmentCoc.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getModelObject(ExportDomain domain, EnrollmentCoC enrollmentCoc ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCocModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			enrollmentCocModel = (com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc) getModel(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class, enrollmentCoc.getEnrollmentCoCID(), getProjectGroupCode(domain),false,modelMap, domain.getUpload().getId());
		
		if(enrollmentCocModel == null) {
			enrollmentCocModel = new com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc();
			enrollmentCocModel.setId(UUID.randomUUID());
			enrollmentCocModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(enrollmentCocModel, domain,enrollmentCoc.getEnrollmentCoCID(),data.i+data.j);
		return enrollmentCocModel;
	}
}
