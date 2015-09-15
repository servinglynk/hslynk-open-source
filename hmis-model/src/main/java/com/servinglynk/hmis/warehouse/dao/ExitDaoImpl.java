/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.staging.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitDaoImpl extends ParentDaoImpl implements ExitDao {
	
	@Autowired
	private ParentDaoFactory factory;
	

	public List<com.servinglynk.hmis.warehouse.model.staging.Exit> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.staging.Exit.class);
		query.add(Restrictions.eq("dateCreated", new Date())); 
		List<com.servinglynk.hmis.warehouse.model.staging.Exit> list = (List<com.servinglynk.hmis.warehouse.model.staging.Exit>) findByCriteria(query);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		if(exits !=null && exits.size() > 0)
		{
			for(Exit exit : exits)
			{
				com.servinglynk.hmis.warehouse.model.staging.Exit exitModel = new com.servinglynk.hmis.warehouse.model.staging.Exit();
				UUID id = UUID.randomUUID();
				exitModel.setId(id);
				domain.getExitMap().put(exit.getExitID(), id);
				exitModel.setDestination(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(exit.getDestination())));
				exitModel.setOtherdestination(exit.getOtherDestination());
				exitModel.setDateCreated(BasicDataGenerator.getLocalDate(exit.getDateCreated()));
				exitModel.setDateUpdated(BasicDataGenerator.getLocalDate(exit.getDateUpdated()));
				exitModel.setExitdate(BasicDataGenerator.getLocalDate(exit.getExitDate()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(exit.getProjectEntryID()));
				exitModel.setEnrollmentid(enrollmentModel);
				com.servinglynk.hmis.warehouse.model.staging.Export exportEntity = (com.servinglynk.hmis.warehouse.model.staging.Export) get(com.servinglynk.hmis.warehouse.model.staging.Export.class, domain.getExportId());
				exitModel.setExport(exportEntity);
				exportEntity.addExit(exitModel);
				insertOrUpdate(exitModel);
			}
			
			factory.getFamilyreunificationDao().hydrateStaging(domain);
			factory.getExithousingassessmentDao().hydrateStaging(domain);
			factory.getHousingassessmentdispositionDao().hydrateStaging(domain);
			factory.getExitplansactionsDao().hydrateStaging(domain);
			factory.getConnectionwithsoarDao().hydrateStaging(domain);
			factory.getProjectcompletionstatusDao().hydrateStaging(domain);
			}



	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.staging.Export export) {
		Set<com.servinglynk.hmis.warehouse.model.staging.Exit> exits = export.getExits();
		if(exits != null && !exits.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.staging.Exit exit : exits) {
				if(exit != null) {
					com.servinglynk.hmis.warehouse.model.live.Exit target = new com.servinglynk.hmis.warehouse.model.live.Exit();
					BeanUtils.copyProperties(exit, target,getNonCollectionFields(target));
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
