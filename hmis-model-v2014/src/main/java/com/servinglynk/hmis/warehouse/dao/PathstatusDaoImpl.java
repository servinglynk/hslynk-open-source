/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Pathstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PathstatusDaoImpl extends ParentDaoImpl implements PathstatusDao {
	private static final Logger logger = LoggerFactory
			.getLogger(PathstatusDaoImpl.class);
	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) throws Exception {
		List<PATHStatus> pathStatusList = domain.getExport().getPATHStatus();
		Long i=new Long(0L);
		Data data =new Data();
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) getModel(com.servinglynk.hmis.warehouse.model.v2014.Export.class,String.valueOf(domain.getExport().getExportID()),getProjectGroupCode(domain));
		if(pathStatusList !=null && !pathStatusList.isEmpty())
		{
			for(PATHStatus pathStatus : pathStatusList)
			{
				try {
					Pathstatus pathstatusModel = getModelObject(domain, pathStatus,data);
					pathstatusModel.setClientEnrolledInPath( new Long(BasicDataGenerator.getStringValue(pathStatus.getClientEnrolledInPATH())));
					pathstatusModel.setReasonNotEnrolled(PathstatusReasonnotenrolledEnum.lookupEnum(String.valueOf(pathStatus.getReasonNotEnrolled())));
					pathstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateCreated()));
					pathstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateUpdated()));
					Enrollment enrollmentModel = (Enrollment) getModel(Enrollment.class, pathStatus.getProjectEntryID(),getProjectGroupCode(domain));
					pathstatusModel.setEnrollmentid(enrollmentModel);
					pathstatusModel.setExport(exportEntity);
					if(exportEntity !=null)
						exportEntity.addPathstatus(pathstatusModel);
					performSaveOrUpdate(pathstatusModel);
				} catch(Exception e) {
					logger.error("Failure in PATHStatus:::"+pathStatus.toString()+ " with exception"+e.getLocalizedMessage());
					throw new Exception(e);
				}
			}
		}
	}

	public com.servinglynk.hmis.warehouse.model.v2014.Pathstatus getModelObject(ExportDomain domain,PATHStatus pathstatus ,Data data) {
		com.servinglynk.hmis.warehouse.model.v2014.Pathstatus PathstatusModel = null;
		// We always insert for a Full refresh and update if the record exists for Delta refresh
		if(!isFullRefresh(domain))
			PathstatusModel = (com.servinglynk.hmis.warehouse.model.v2014.Pathstatus) getModel(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class, pathstatus.getPathStatusID(), getProjectGroupCode(domain));
		
		if(PathstatusModel == null) {
			PathstatusModel = new com.servinglynk.hmis.warehouse.model.v2014.Pathstatus();
			PathstatusModel.setId(UUID.randomUUID());
			PathstatusModel.setInserted(true);
			++data.i;
		}else{
			++data.j;
		}
		hydrateCommonFields(PathstatusModel, domain,pathstatus.getPathStatusID(),data.i+data.j);
		return PathstatusModel;
	}

	   public com.servinglynk.hmis.warehouse.model.v2014.Pathstatus createPathstatus(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus pathstatus){
	       pathstatus.setId(UUID.randomUUID()); 
	       insert(pathstatus);
	       return pathstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Pathstatus updatePathstatus(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus pathstatus){
	       update(pathstatus);
	       return pathstatus;
	   }
	   public void deletePathstatus(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus pathstatus){
	       delete(pathstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Pathstatus getPathstatusById(UUID pathstatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Pathstatus) get(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class, pathstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Pathstatus> getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Pathstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentPathstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
