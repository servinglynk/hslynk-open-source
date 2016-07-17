/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.model.v2014.HmisBaseModel;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExithousingassessmentDaoImpl.class);
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain , Map<String,HmisBaseModel> exportModelMap, Map<String,HmisBaseModel> relatedModelMap) throws Exception {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		Data data=new Data();
		Map<String,HmisBaseModel> modelMap = getModelMap(com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class, getProjectGroupCode(domain));
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false,exportModelMap);
		if(exitHousingAssessments !=null && !exitHousingAssessments.isEmpty()) 
		{
				for(ExitHousingAssessment exitHousingAssessment : exitHousingAssessments)
				{
					try {
						Exithousingassessment exithousingassessmentModel = getModelObject(domain, exitHousingAssessment,data,modelMap);
						exithousingassessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
						exithousingassessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
						exithousingassessmentModel.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getHousingAssessment())));
						exithousingassessmentModel.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getSubsidyInformation())));
						Exit exit = (Exit) getModel(Exit.class,exitHousingAssessment.getExitID(),getProjectGroupCode(domain),true,relatedModelMap);
						exithousingassessmentModel.setExitid(exit);
						exithousingassessmentModel.setExport(exportEntity);
						performSaveOrUpdate(exithousingassessmentModel);
					} catch(Exception e) {
						logger.error("Exception in:"+exitHousingAssessment.getExitHousingAssessmentID()+  ":: Exception" +e.getLocalizedMessage());
						throw new Exception(e);
					}
				
				}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class.getSimpleName(), domain, exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment getModelObject(ExportDomain domain, ExitHousingAssessment exitHousingAssessment ,Data data, Map<String,HmisBaseModel> modelMap) {
		com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment ExitHousingAssessmentModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			ExitHousingAssessmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment) getModel(com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class, exitHousingAssessment.getExitHousingAssessmentID(), getProjectGroupCode(domain),false,modelMap);
		
		if(ExitHousingAssessmentModel == null) {
			ExitHousingAssessmentModel = new com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment();
			ExitHousingAssessmentModel.setId(UUID.randomUUID());
			ExitHousingAssessmentModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(ExitHousingAssessmentModel, domain,exitHousingAssessment.getExitHousingAssessmentID(),data.i+data.j);
		return ExitHousingAssessmentModel;
	}
}
