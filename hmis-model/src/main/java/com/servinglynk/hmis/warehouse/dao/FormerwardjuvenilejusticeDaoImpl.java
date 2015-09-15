/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardJuvenileJustice;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardjuvenilejusticeJuvenilejusticeyearsEnum;
import com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Formerwardjuvenilejustice;
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
		if(formerWardJuvenileJustices !=null && !formerWardJuvenileJustices.isEmpty()) 
		{
			for(FormerWardJuvenileJustice formerWardJuvenileJustice : formerWardJuvenileJustices )
			{
				Formerwardjuvenilejustice formerWardJuvenileJusticeModel = new Formerwardjuvenilejustice();
				formerWardJuvenileJusticeModel.setFormerwardjuvenilejustice(FormerwardjuvenilejusticeFormerwardjuvenilejusticeEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getFormerWardJuvenileJustice())));
				formerWardJuvenileJusticeModel.setJuvenilejusticemonths(BasicDataGenerator.getIntegerValue(formerWardJuvenileJustice.getJuvenileJusticeMonths()));
				formerWardJuvenileJusticeModel.setJuvenilejusticeyears(FormerwardjuvenilejusticeJuvenilejusticeyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardJuvenileJustice.getJuvenileJusticeYears())));
				formerWardJuvenileJusticeModel.setId(UUID.randomUUID());
				formerWardJuvenileJusticeModel.setDateCreated(BasicDataGenerator.getLocalDate(formerWardJuvenileJustice.getDateCreated()));
				formerWardJuvenileJusticeModel.setDateUpdated(BasicDataGenerator.getLocalDate(formerWardJuvenileJustice.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(formerWardJuvenileJustice.getProjectEntryID()));
				formerWardJuvenileJusticeModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				formerWardJuvenileJusticeModel.setExport(exportEntity);
				exportEntity.addFormerwardjuvenilejustice(formerWardJuvenileJusticeModel);
				insertOrUpdate(formerWardJuvenileJusticeModel);
				
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Formerwardjuvenilejustice> formerwardjuvenilejustices = export.getFormerwardjuvenilejustices();
		if(formerwardjuvenilejustices != null && !formerwardjuvenilejustices.isEmpty()) {
			for(Formerwardjuvenilejustice formerwardjuvenilejustice : formerwardjuvenilejustices) {
				if(formerwardjuvenilejustice != null) {
					Formerwardchildwelfare target = new Formerwardchildwelfare();
					BeanUtils.copyProperties(formerwardjuvenilejustice, target, getNonCollectionFields(target));
					insert(target);
				}
			}
		}
	}

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void performSave(Iface client, Object entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected List performGet(Iface client, Object entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
