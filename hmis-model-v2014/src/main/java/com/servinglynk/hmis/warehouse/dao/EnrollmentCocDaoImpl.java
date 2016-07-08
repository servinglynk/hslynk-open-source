/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.EnrollmentCoC;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc;
import com.servinglynk.hmis.warehouse.model.v2014.Projectcoc;
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
	public void hydrateStaging(ExportDomain domain) throws Exception {
		
		List<EnrollmentCoC> enrollmentCoCs = domain.getExport().getEnrollmentCoC();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		Long i =new Long(0L);
		Data data =new Data();
		if(enrollmentCoCs!=null)
		{
			for(EnrollmentCoC enrollmentCoc : enrollmentCoCs)
			{
				try {
					EnrollmentCoc enrollmentCocModel = getModelObject(domain, enrollmentCoc,data);
					enrollmentCocModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateCreated()));
					enrollmentCocModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(enrollmentCoc.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class,enrollmentCoc.getProjectEntryID(),getProjectGroupCode(domain));
					enrollmentCocModel.setEnrollmentid(enrollmentModel);
     				Projectcoc projectCoc = (Projectcoc) getModel(Projectcoc.class,enrollmentCoc.getProjectCoCID(),getProjectGroupCode(domain));
					enrollmentCocModel.setProjectCoc(projectCoc);	
					//enrollmentCocModel.setCocCode(enrollmentCoc.get);
					enrollmentCocModel.setExport(exportEntity);
					if(exportEntity != null)
						exportEntity.addEnrollmentCoc(enrollmentCocModel);
					performSaveOrUpdate(enrollmentCocModel);
				} catch (Exception e) {
					logger.error("Error occured with "+enrollmentCoc.toString() + " Execption :::"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, EnrollmentCoc.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc getModelObject(ExportDomain domain, EnrollmentCoC enrollmentCoc ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc enrollmentCocModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			enrollmentCocModel = (com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc) getModel(com.servinglynk.hmis.warehouse.model.v2014.EnrollmentCoc.class, enrollmentCoc.getEnrollmentCoCID(), getProjectGroupCode(domain));
		
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
