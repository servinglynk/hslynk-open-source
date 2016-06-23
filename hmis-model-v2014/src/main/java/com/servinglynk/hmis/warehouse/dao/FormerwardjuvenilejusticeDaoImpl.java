/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardJuvenileJustice;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeJuvenilejusticeyearsEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardjuvenilejusticeDaoImpl extends ParentDaoImpl implements
		FormerwardjuvenilejusticeDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FormerWardJuvenileJustice> formerWardJuvenileJustices = domain.getExport().getFormerWardJuvenileJustice();
		hydrateBulkUploadActivityStaging(formerWardJuvenileJustices, com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(formerWardJuvenileJustices !=null && !formerWardJuvenileJustices.isEmpty()) 
		{
			for(FormerWardJuvenileJustice formerWardJuvenileJustice : formerWardJuvenileJustices )
			{
				Formerwardjuvenilejustice formerWardJuvenileJusticeModel = new Formerwardjuvenilejustice();
				formerWardJuvenileJusticeModel.setFormerwardjuvenilejustice(FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getFormerWardJuvenileJustice())));
				formerWardJuvenileJusticeModel.setJuvenilejusticemonths(BasicDataGenerator.getIntegerValue(formerWardJuvenileJustice.getJuvenileJusticeMonths()));
				formerWardJuvenileJusticeModel.setJuvenilejusticeyears(FormerwardjuvenilejusticeJuvenilejusticeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getJuvenileJusticeYears())));
				formerWardJuvenileJusticeModel.setId(UUID.randomUUID());
				formerWardJuvenileJusticeModel.setDateCreated(LocalDateTime.now());
				formerWardJuvenileJusticeModel.setDateUpdated(LocalDateTime.now());
				formerWardJuvenileJusticeModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateCreated()));
				formerWardJuvenileJusticeModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(formerWardJuvenileJustice.getProjectEntryID()));
				formerWardJuvenileJusticeModel.setEnrollmentid(enrollmentModel);
				formerWardJuvenileJusticeModel.setExport(exportEntity);
				exportEntity.addFormerwardjuvenilejustice(formerWardJuvenileJusticeModel);
				i++;
				hydrateCommonFields(formerWardJuvenileJusticeModel, domain, formerWardJuvenileJustice.getFormerWardJuvenileJusticeID(),i);
			}
		}
	}
}
