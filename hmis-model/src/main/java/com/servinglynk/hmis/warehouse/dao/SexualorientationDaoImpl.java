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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.SexualOrientation;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.SexualorientationSexualorientationEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Sexualorientation;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class SexualorientationDaoImpl extends ParentDaoImpl implements
		SexualorientationDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<SexualOrientation> sexualOrientations = domain.getExport().getSexualOrientation();
		if(sexualOrientations !=null && !sexualOrientations.isEmpty())
		{
			for(SexualOrientation sexualOrientation : sexualOrientations)
			{
				Sexualorientation sexualorientationModel = new Sexualorientation();
				UUID id = UUID.randomUUID();
				sexualorientationModel.setId(id);
				sexualorientationModel.setDateCreated(BasicDataGenerator.getLocalDate(sexualOrientation.getDateCreated()));
				sexualorientationModel.setDateUpdated(BasicDataGenerator.getLocalDate(sexualOrientation.getDateUpdated()));
				sexualorientationModel.setSexualorientation(SexualorientationSexualorientationEnum.lookupEnum(BasicDataGenerator.getStringValue(sexualOrientation.getSexualOrientation())));
				
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(sexualOrientation.getProjectEntryID()));
				sexualorientationModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				sexualorientationModel.setExport(exportEntity);
				exportEntity.addSexualorientation(sexualorientationModel);
				insertOrUpdate(sexualorientationModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export) {
		Set<Sexualorientation> sexualorientations = export.getSexualorientations();
		if(sexualorientations !=null && !sexualorientations.isEmpty()) {
			for(Sexualorientation sexualorientation : sexualorientations) {
				if(sexualorientation != null) {
					com.servinglynk.hmis.warehouse.model.live.Sexualorientation target = new com.servinglynk.hmis.warehouse.model.live.Sexualorientation();
					BeanUtils.copyProperties(sexualorientation, target);
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
