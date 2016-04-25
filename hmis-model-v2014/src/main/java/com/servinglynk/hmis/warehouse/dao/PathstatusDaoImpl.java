/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Pathstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class PathstatusDaoImpl extends ParentDaoImpl implements PathstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<PATHStatus> pathStatusList = domain.getExport().getPATHStatus();
		hydrateBulkUploadActivityStaging(pathStatusList, com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(pathStatusList !=null && !pathStatusList.isEmpty())
		{
			for(PATHStatus pathStatus : pathStatusList)
			{
				Pathstatus pathstatusModel = new Pathstatus();
				UUID id = UUID.randomUUID();
				pathstatusModel.setId(id);
				pathstatusModel.setClientEnrolledInPath( new Long(BasicDataGenerator.getStringValue(pathStatus.getClientEnrolledInPATH())));
				pathstatusModel.setReasonNotEnrolled(PathstatusReasonnotenrolledEnum.lookupEnum(String.valueOf(pathStatus.getReasonNotEnrolled())));
				pathstatusModel.setDateCreated(LocalDateTime.now());
				pathstatusModel.setDateUpdated(LocalDateTime.now());
				pathstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateCreated()));
				pathstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(pathStatus.getDateUpdated()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(pathStatus.getProjectEntryID()));
				pathstatusModel.setEnrollmentid(enrollmentModel);
				pathstatusModel.setExport(exportEntity);
				exportEntity.addPathstatus(pathstatusModel);
				i++;
				hydrateCommonFields(pathstatusModel, domain,String.valueOf(pathStatus.getPathStatusID()),i);
				insert(pathstatusModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Pathstatus> pathstatuses = export.getPathstatuses();
		hydrateBulkUploadActivity(pathstatuses, com.servinglynk.hmis.warehouse.model.v2014.Pathstatus.class.getSimpleName(), export,id);
		if(pathstatuses != null && !pathstatuses.isEmpty()) {
			for(Pathstatus pathStatus : pathstatuses) {
				if(pathStatus != null) {
					com.servinglynk.hmis.warehouse.model.v2014.Pathstatus target = new com.servinglynk.hmis.warehouse.model.v2014.Pathstatus();
					BeanUtils.copyProperties(pathStatus, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, pathStatus.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addPathstatus(target);
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
