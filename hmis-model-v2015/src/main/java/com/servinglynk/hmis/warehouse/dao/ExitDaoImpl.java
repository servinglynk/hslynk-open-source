/**
 *
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.v2015.Enrollment;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class ExitDaoImpl extends ParentDaoImpl implements ExitDao {
	private static final Logger logger = LoggerFactory
			.getLogger(ExitDaoImpl.class);
	@Autowired
	private ParentDaoFactory factory;


	public List<com.servinglynk.hmis.warehouse.model.v2015.Exit> findUnProcessedUploads(String status) throws Exception{
		DetachedCriteria query = DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exit.class);
		query.add(Restrictions.eq("dateCreated", new Date()));
		List<com.servinglynk.hmis.warehouse.model.v2015.Exit> list = (List<com.servinglynk.hmis.warehouse.model.v2015.Exit>) findByCriteria(query);
		return list;
	}

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) getModel(com.servinglynk.hmis.warehouse.model.v2015.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain),false);
		Data data =new Data();
		if(exits !=null && exits.size() > 0)
		{
			for(Exit exit : exits)
			{
				try {
					
					com.servinglynk.hmis.warehouse.model.v2015.Exit exitModel = new com.servinglynk.hmis.warehouse.model.v2015.Exit();
					exitModel.setDestination(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(exit.getDestination())));
					exitModel.setOtherdestination(exit.getOtherDestination());
					exitModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateCreated()));
					exitModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
					exitModel.setExitdate(BasicDataGenerator.getLocalDateTime(exit.getExitDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, exit.getProjectEntryID(),getProjectGroupCode(domain),true);
					exitModel.setEnrollmentid(enrollmentModel);
					exitModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addExit(exitModel);
					performSaveOrUpdate(exitModel);
				}catch(Exception e) {
					logger.error("Exception beause of the exit::"+exit.getExitID() +" Exception ::"+e.getMessage());
					throw new Exception(e);
				}
			 }
			}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2015.Exit.class.getSimpleName(), domain,exportEntity);
	}

	

	@Override
	public void hydrateHBASE(SyncDomain syncDomain) {
		// TODO Auto-generated method stub

	}

	   public com.servinglynk.hmis.warehouse.model.v2015.Exit createExit(com.servinglynk.hmis.warehouse.model.v2015.Exit exit){
		   exit.setId(UUID.randomUUID());
		   insert(exit);
	       return exit;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Exit updateExit(com.servinglynk.hmis.warehouse.model.v2015.Exit exit){
	       update(exit);
	       return exit;
	   }
	   public void deleteExit(com.servinglynk.hmis.warehouse.model.v2015.Exit exit){
	       delete(exit);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Exit getExitById(UUID exitId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Exit) get(com.servinglynk.hmis.warehouse.model.v2015.Exit.class, exitId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Exit> getAllEnrollmentExits(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Exit>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentExitsCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Exit.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
