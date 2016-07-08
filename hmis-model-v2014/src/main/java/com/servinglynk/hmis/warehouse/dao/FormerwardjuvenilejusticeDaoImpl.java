/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger logger = LoggerFactory
			.getLogger(FormerwardjuvenilejusticeDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<FormerWardJuvenileJustice> formerWardJuvenileJustices = domain.getExport().getFormerWardJuvenileJustice();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		if(formerWardJuvenileJustices !=null && !formerWardJuvenileJustices.isEmpty()) 
		{
			for(FormerWardJuvenileJustice formerWardJuvenileJustice : formerWardJuvenileJustices )
			{
				try {
					Formerwardjuvenilejustice formerWardJuvenileJusticeModel = getModelObject(domain, formerWardJuvenileJustice,data);
					formerWardJuvenileJusticeModel.setFormerwardjuvenilejustice(FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getFormerWardJuvenileJustice())));
					formerWardJuvenileJusticeModel.setJuvenilejusticemonths(BasicDataGenerator.getIntegerValue(formerWardJuvenileJustice.getJuvenileJusticeMonths()));
					formerWardJuvenileJusticeModel.setJuvenilejusticeyears(FormerwardjuvenilejusticeJuvenilejusticeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getJuvenileJusticeYears())));
					formerWardJuvenileJusticeModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateCreated()));
					formerWardJuvenileJusticeModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(formerWardJuvenileJustice.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, formerWardJuvenileJustice.getProjectEntryID(),getProjectGroupCode(domain),true);
					formerWardJuvenileJusticeModel.setEnrollmentid(enrollmentModel);
					formerWardJuvenileJusticeModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addFormerwardjuvenilejustice(formerWardJuvenileJusticeModel);
					performSaveOrUpdate(formerWardJuvenileJusticeModel);
				}catch (Exception e) {
					logger.error("Exception in:"+formerWardJuvenileJustice.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class.getSimpleName(), domain,exportEntity);
	}
	
	public com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice getModelObject(ExportDomain domain, FormerWardJuvenileJustice formerWardJuvenileJustice ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice formerwardjuvenilejusticeModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			formerwardjuvenilejusticeModel = (com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice) getModel(com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice.class, formerWardJuvenileJustice.getFormerWardJuvenileJusticeID(), getProjectGroupCode(domain),false);
		
		if(formerwardjuvenilejusticeModel == null) {
			formerwardjuvenilejusticeModel = new com.servinglynk.hmis.warehouse.model.v2014.Formerwardjuvenilejustice();
			formerwardjuvenilejusticeModel.setId(UUID.randomUUID());
			formerwardjuvenilejusticeModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(formerwardjuvenilejusticeModel, domain,formerWardJuvenileJustice.getFormerWardJuvenileJusticeID(),data.i+data.j);
		return formerwardjuvenilejusticeModel;
	}
}
