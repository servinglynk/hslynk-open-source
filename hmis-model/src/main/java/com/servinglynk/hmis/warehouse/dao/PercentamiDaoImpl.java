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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PercentAMI;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Percentami;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PercentamiDaoImpl extends ParentDaoImpl implements PercentamiDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<PercentAMI> percentAMIs = domain.getExport().getPercentAMI();
		if(percentAMIs !=null && !percentAMIs.isEmpty())
		{
			for(PercentAMI percentAMI :percentAMIs)
			{
				Percentami percentamoModel = new Percentami();
				UUID id = UUID.randomUUID();
				percentamoModel.setId(id);
				percentamoModel.setDateCreated(BasicDataGenerator.getLocalDate(percentAMI.getDateCreated()));
				percentamoModel.setDateUpdated(BasicDataGenerator.getLocalDate(percentAMI.getDateUpdated()));
				percentamoModel.setPercentage(BasicDataGenerator.getIntegerValue(percentAMI.getPercentAMI()));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(percentAMI.getProjectEntryID()));
				percentamoModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				percentamoModel.setExport(exportEntity);
				exportEntity.addPercentami(percentamoModel);
				insertOrUpdate(percentamoModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Percentami> percentamis = export.getPercentamis();
		if(percentamis !=null && !percentamis.isEmpty()) {
			for(Percentami percentami : percentamis) {
				if(percentami != null) {
					com.servinglynk.hmis.warehouse.model.live.Percentami  target = new com.servinglynk.hmis.warehouse.model.live.Percentami();
					BeanUtils.copyProperties(percentami, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, percentami.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addPercentami(target);
					insertOrUpdate(target);
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
