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

import com.servinglynk.hmis.warehouse.domain.ExportDomain;
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.PATHStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.PathstatusReasonnotenrolledEnum;
import com.servinglynk.hmis.warehouse.model.stagv2015.Enrollment;
import com.servinglynk.hmis.warehouse.model.stagv2015.Export;
import com.servinglynk.hmis.warehouse.model.stagv2015.Pathstatus;
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
				com.servinglynk.hmis.warehouse.model.stagv2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.stagv2015.Export) get(com.servinglynk.hmis.warehouse.model.stagv2015.Export.class, domain.getExportId());
				pathstatusModel.setExport(exportEntity);
				exportEntity.addPathStatus(pathstatusModel);
				hydrateCommonFields(pathstatusModel, domain);
				insertOrUpdate(pathstatusModel);
			}
		}
	}

	@Override
	public void hydrateLive(Export export) {
		Set<Pathstatus> pathstatuses = export.getPathStatuses();
		if(pathstatuses != null && !pathstatuses.isEmpty()) {
			for(Pathstatus pathStatus : pathstatuses) {
				if(pathStatus != null) {
					com.servinglynk.hmis.warehouse.model.v2015.Pathstatus target = new com.servinglynk.hmis.warehouse.model.v2015.Pathstatus();
					BeanUtils.copyProperties(pathStatus, target,getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2015.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2015.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2015.Enrollment.class, pathStatus.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2015.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2015.Export) get(com.servinglynk.hmis.warehouse.model.v2015.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addPathStatus(target);
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


	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus createPathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       pathstatus.setId(UUID.randomUUID());
	       insert(pathstatus);
	       return pathstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus updatePathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       update(pathstatus);
	       return pathstatus;
	   }
	   public void deletePathstatus(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus pathstatus){
	       delete(pathstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2015.Pathstatus getPathstatusById(UUID pathstatusId){
	       return (com.servinglynk.hmis.warehouse.model.v2015.Pathstatus) get(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class, pathstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2015.Pathstatus> getAllEnrollmentPathstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2015.Pathstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentPathstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2015.Pathstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }

}
