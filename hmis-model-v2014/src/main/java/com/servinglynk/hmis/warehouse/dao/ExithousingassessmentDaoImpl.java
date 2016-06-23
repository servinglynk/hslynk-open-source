/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ExitHousingAssessment;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentHousingassessmentEnum;
import com.servinglynk.hmis.warehouse.enums.ExithousingassessmentSubsidyinformationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Exit;
import com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExithousingassessmentDaoImpl extends ParentDaoImpl implements
		ExithousingassessmentDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ExitHousingAssessment> exitHousingAssessments = domain.getExport().getExitHousingAssessment();
		hydrateBulkUploadActivityStaging(exitHousingAssessments, com.servinglynk.hmis.warehouse.model.v2014.Exithousingassessment.class.getSimpleName(), domain);
		int i=0;
		if(exitHousingAssessments !=null && !exitHousingAssessments.isEmpty()) 
		{
				for(ExitHousingAssessment exitHousingAssessment : exitHousingAssessments)
				{
					Exithousingassessment exithousingassessmentModel = new Exithousingassessment();
					exithousingassessmentModel.setId(UUID.randomUUID());
					exithousingassessmentModel.setDateCreated(LocalDateTime.now());
					exithousingassessmentModel.setDateUpdated(LocalDateTime.now());
					exithousingassessmentModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateCreated()));
					exithousingassessmentModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exitHousingAssessment.getDateUpdated()));
					exithousingassessmentModel.setHousingassessment(ExithousingassessmentHousingassessmentEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getHousingAssessment())));
					exithousingassessmentModel.setSubsidyinformation(ExithousingassessmentSubsidyinformationEnum.lookupEnum(BasicDataGenerator.getStringValue(exitHousingAssessment.getSubsidyInformation())));
					Exit exit = (Exit) get(Exit.class, domain.getExitMap().get(exitHousingAssessment.getExitID()));
					exithousingassessmentModel.setExitid(exit);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
					exithousingassessmentModel.setExport(exportEntity);
					exportEntity.addExithousingassessment(exithousingassessmentModel);
					i++;
					hydrateCommonFields(exithousingassessmentModel, domain, String.valueOf(exitHousingAssessment.getExitHousingAssessmentID()),i);
				}
		}
	}
}
