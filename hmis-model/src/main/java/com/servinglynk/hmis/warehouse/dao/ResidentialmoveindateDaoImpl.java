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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.ResidentialMoveInDate;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ResidentialmoveindateInpermanenthousingEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.model.staging.Export;
import com.servinglynk.hmis.warehouse.model.staging.Residentialmoveindate;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ResidentialmoveindateDaoImpl extends ParentDaoImpl implements
		ResidentialmoveindateDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<ResidentialMoveInDate> residentialMoveInDates = domain.getExport().getResidentialMoveInDate();
		if(residentialMoveInDates != null && !residentialMoveInDates.isEmpty())
		{
			for( ResidentialMoveInDate residentialMoveInDate : residentialMoveInDates)
			{
				UUID id = UUID.randomUUID();
				Residentialmoveindate residentialmoveindateModel = new Residentialmoveindate();
				residentialmoveindateModel.setId(id);
				residentialmoveindateModel.setInpermanenthousing(ResidentialmoveindateInpermanenthousingEnum.lookupEnum(BasicDataGenerator.getStringValue(residentialMoveInDate.getInPermanentHousing())));
				residentialmoveindateModel.setResidentialmoveindate(BasicDataGenerator.getLocalDate(residentialMoveInDate.getResidentialMoveInDate()));
				residentialmoveindateModel.setDateCreated(BasicDataGenerator.getLocalDate(residentialMoveInDate.getDateCreated()));
				residentialmoveindateModel.setDateUpdated(BasicDataGenerator.getLocalDate(residentialMoveInDate.getDateUpdated()));
				Enrollment enrollment = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(residentialMoveInDate.getProjectEntryID()));
				residentialmoveindateModel.setEnrollmentid(enrollment);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				residentialmoveindateModel.setExport(exportEntity);
				exportEntity.addResidentialmoveindate(residentialmoveindateModel);
				insertOrUpdate(residentialmoveindateModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Residentialmoveindate> residentialmoveindates = export.getResidentialmoveindates();
		if(residentialmoveindates != null && !residentialmoveindates.isEmpty()) {
			for(Residentialmoveindate residentialmoveindate : residentialmoveindates) {
				if(residentialmoveindate != null) {
					com.servinglynk.hmis.warehouse.model.live.Residentialmoveindate target = new com.servinglynk.hmis.warehouse.model.live.Residentialmoveindate();
					BeanUtils.copyProperties(residentialmoveindate, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.live.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.live.Enrollment) get(com.servinglynk.hmis.warehouse.model.live.Enrollment.class, residentialmoveindate.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.live.Export exportEntity = (com.servinglynk.hmis.warehouse.model.live.Export) get(com.servinglynk.hmis.warehouse.model.live.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addResidentialmoveindate(target);
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
