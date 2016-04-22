/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.stagv2014.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitDaoImpl extends ParentDaoImpl implements ExitDao {
	
	@Autowired
	private ParentDaoFactory factory;
	

	public List<com.servinglynk.hmis.warehouse.model.stagv2014.Exit> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.stagv2014.Exit.class);
		query.add(Restrictions.eq("dateCreated", new Date())); 
		List<com.servinglynk.hmis.warehouse.model.stagv2014.Exit> list = (List<com.servinglynk.hmis.warehouse.model.stagv2014.Exit>) findByCriteria(query);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		hydrateBulkUploadActivityStaging(exits, com.servinglynk.hmis.warehouse.model.v2014.Exit.class.getSimpleName(), domain);
		com.servinglynk.hmis.warehouse.model.stagv2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2014.Export) get(com.servinglynk.hmis.warehouse.model.stagv2014.Export.class, domain.getExportId());
		int i=0;
		if(exits !=null && exits.size() > 0)
		{
			for(Exit exit : exits)
			{
				i++;
				com.servinglynk.hmis.warehouse.model.stagv2014.Exit exitModel = new com.servinglynk.hmis.warehouse.model.stagv2014.Exit();
				UUID id = UUID.randomUUID();
				exitModel.setId(id);
				domain.getExitMap().put(exit.getExitID(), id);
				exitModel.setDestination(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(exit.getDestination())));
				exitModel.setOtherdestination(exit.getOtherDestination());
				exitModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateCreated()));
				exitModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
				exitModel.setDateCreated(LocalDateTime.now());
				exitModel.setDateUpdated(LocalDateTime.now());
				exitModel.setExitdate(BasicDataGenerator.getLocalDateTime(exit.getExitDate()));
				if(exit.getProjectEntryID() !=null && !"".equals(exit.getProjectEntryID())) {
				UUID uuid = domain.getEnrollmentProjectEntryIDMap().get((exit.getProjectEntryID()));
				if(uuid !=null) {
					Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, uuid);
					exitModel.setEnrollmentid(enrollmentModel);
				}
					
			}
			
				exitModel.setExport(exportEntity);
				exportEntity.addExit(exitModel);
				hydrateCommonFields(exitModel, domain, exit.getExitID(),i);
				insert(exitModel);
			}
			}
	}

	@Override
	public void hydrateLive(
			com.servinglynk.hmis.warehouse.model.stagv2014.Export export, Long id) {
		Set<com.servinglynk.hmis.warehouse.model.stagv2014.Exit> exits = export.getExits();
		hydrateBulkUploadActivity(exits, com.servinglynk.hmis.warehouse.model.v2014.Exit.class.getSimpleName(), export,id);
		if(exits != null && !exits.isEmpty()) {
			for(com.servinglynk.hmis.warehouse.model.stagv2014.Exit exit : exits) {
				if(exit != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Exit target = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
					BeanUtils.copyProperties(exit, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, exit.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addExit(target);
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

	   public com.servinglynk.hmis.warehouse.model.v2014.Exit createExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
		   exit.setId(UUID.randomUUID());
		   insert(exit);
	       return exit;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exit updateExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
	       update(exit);
	       return exit;
	   }
	   public void deleteExit(com.servinglynk.hmis.warehouse.model.v2014.Exit exit){
	       delete(exit);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Exit getExitById(UUID exitId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Exit) get(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, exitId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Exit>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentExitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
