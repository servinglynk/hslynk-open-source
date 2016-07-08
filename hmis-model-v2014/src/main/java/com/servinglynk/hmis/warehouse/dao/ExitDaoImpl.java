/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.Exit;
import com.servinglynk.hmis.warehouse.enums.ExitDestinationEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
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
	
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		Export export = domain.getExport();
		List<Exit> exits = export.getExit();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		Long i=new Long(0L);
		Data data =new Data();
		if(exits !=null && exits.size() > 0)
		{
			for(Exit exit : exits)
			{
				try {
					com.servinglynk.hmis.warehouse.model.v2014.Exit exitModel = getModelObject(domain, exit,data);
					exitModel.setDestination(ExitDestinationEnum.lookupEnum(BasicDataGenerator.getStringValue(exit.getDestination())));
					exitModel.setOtherdestination(exit.getOtherDestination());
					exitModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateCreated()));
					exitModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(exit.getDateUpdated()));
					exitModel.setExitdate(BasicDataGenerator.getLocalDateTime(exit.getExitDate()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, exit.getProjectEntryID(),getProjectGroupCode(domain));
					exitModel.setEnrollmentid(enrollmentModel);
					exitModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addExit(exitModel);
					performSaveOrUpdate(exitModel);
				}catch(Exception e) {
					logger.error("Exception in:"+exit.getProjectEntryID()+  ":: Exception" +e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
		hydrateBulkUploadActivityStaging(data.i,data.j, com.servinglynk.hmis.warehouse.model.v2014.Exit.class.getSimpleName(), domain, exportEntity);
	}
	public com.servinglynk.hmis.warehouse.model.v2014.Exit getModelObject(ExportDomain domain, Exit Exit ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Exit exitModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			exitModel = (com.servinglynk.hmis.warehouse.model.v2014.Exit) getModel(com.servinglynk.hmis.warehouse.model.v2014.Exit.class, Exit.getExitID(), getProjectGroupCode(domain));
		
		if(exitModel == null) {
			exitModel = new com.servinglynk.hmis.warehouse.model.v2014.Exit();
			exitModel.setId(UUID.randomUUID());
			exitModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(exitModel, domain,Exit.getExitID(),data.i+data.j);
		return exitModel;
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
