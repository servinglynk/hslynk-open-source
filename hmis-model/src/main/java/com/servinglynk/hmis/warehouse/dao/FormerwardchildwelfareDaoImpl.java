/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.springframework.beans.BeanUtils;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.FormerWardChildWelfare;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareChildwelfareyearsEnum;
import com.servinglynk.hmis.warehouse.enums.FormerwardchildwelfareFormerwardchildwelfareEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Formerwardchildwelfare;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class FormerwardchildwelfareDaoImpl extends ParentDaoImpl implements
		FormerwardchildwelfareDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<FormerWardChildWelfare> formerWardChildWelfares = domain.getExport().getFormerWardChildWelfare();
		if(formerWardChildWelfares !=null && !formerWardChildWelfares.isEmpty() ) 
		{
			for(FormerWardChildWelfare formerWardChildWelfare : formerWardChildWelfares)
			{
				Formerwardchildwelfare formerwardchildwelfareModel = new Formerwardchildwelfare();
				formerwardchildwelfareModel.setId(UUID.randomUUID());
				formerwardchildwelfareModel.setChildwelfaremonths(BasicDataGenerator.getIntegerValue(formerWardChildWelfare.getChildWelfareMonths()));
				formerwardchildwelfareModel.setChildwelfareyears(FormerwardchildwelfareChildwelfareyearsEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getChildWelfareYears())));
				formerwardchildwelfareModel.setFormerwardchildwelfare(FormerwardchildwelfareFormerwardchildwelfareEnum.lookupEnum(BasicDataGenerator.getStringValue(formerWardChildWelfare.getFormerWardChildWelfare())));
				formerwardchildwelfareModel.setDateCreated(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateCreated()));
				formerwardchildwelfareModel.setDateUpdated(BasicDataGenerator.getLocalDateTime(formerWardChildWelfare.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(formerWardChildWelfare.getProjectEntryID()));
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				formerwardchildwelfareModel.setExport(exportEntity);
				formerwardchildwelfareModel.setEnrollmentid(enrollmentModel);
				exportEntity.addFormerwardchildwelfare(formerwardchildwelfareModel);
				insertOrUpdate(formerwardchildwelfareModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Formerwardchildwelfare> formerwardchildwelfares = export.getFormerwardchildwelfares();
		if(formerwardchildwelfares != null && !formerwardchildwelfares.isEmpty()) {
			for(Formerwardchildwelfare formerwardchildwelfare : formerwardchildwelfares) {
				if(formerwardchildwelfare !=null) {
					com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare target = new com.servinglynk.hmis.warehouse.model.live.Formerwardchildwelfare();
					BeanUtils.copyProperties(formerwardchildwelfare, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, formerwardchildwelfare.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addFormerwardchildwelfare(target);
					target.setDateCreated(LocalDateTime.now());
					target.setDateUpdated(LocalDateTime.now());
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
