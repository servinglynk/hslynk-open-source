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
import com.servinglynk.hmis.warehouse.domain.Sources.Source.Export.RHYBCPStatus;
import com.servinglynk.hmis.warehouse.domain.SyncDomain;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusFysbYouthEnum;
import com.servinglynk.hmis.warehouse.enums.RhybcpStatusReasonNoServicesEnum;
import com.servinglynk.hmis.warehouse.model.v2014.Enrollment;
import com.servinglynk.hmis.warehouse.model.v2014.Export;
import com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus;
import com.servinglynk.hmis.warehouse.util.BasicDataGenerator;

/**
 * @author Sandeep
 *
 */
public class RhybcpstatusDaoImpl extends ParentDaoImpl implements
		RhybcpstatusDao {

	/* (non-Javadoc)
	 * @see com.servinglynk.hmis.warehouse.dao.ParentDao#hydrate(com.servinglynk.hmis.warehouse.dao.Sources.Source.Export, java.util.Map)
	 */
	@Override
	public void hydrateStaging(ExportDomain domain) {
		List<RHYBCPStatus> rhybcpStatusList = domain.getExport().getRHYBCPStatus();
		hydrateBulkUploadActivityStaging(rhybcpStatusList, com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class.getSimpleName(), domain);
		int i=0;
		com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, domain.getExportId());
		if(rhybcpStatusList !=null && !rhybcpStatusList.isEmpty())
		{
			for(RHYBCPStatus rhybcpStatus : rhybcpStatusList)
			{
				Rhybcpstatus rhybcpstatusModel = new Rhybcpstatus();
				UUID id = UUID.randomUUID();
				rhybcpstatusModel.setId(id);
				rhybcpstatusModel.setDateCreated(LocalDateTime.now());
				rhybcpstatusModel.setDateUpdated(LocalDateTime.now());
				rhybcpstatusModel.setDateCreatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateCreated()));
				rhybcpstatusModel.setDateUpdatedFromSource(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getDateUpdated()));
				rhybcpstatusModel.setFysbYouth(RhybcpStatusFysbYouthEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getFYSBYouth())));
				rhybcpstatusModel.setReasonNoServices(RhybcpStatusReasonNoServicesEnum.lookupEnum(BasicDataGenerator.getStringValue(rhybcpStatus.getReasonNoServices())));
				rhybcpstatusModel.setStatusDate(BasicDataGenerator.getLocalDateTime(rhybcpStatus.getStatusDate()));
				Enrollment enrollmentModel = (Enrollment) get(Enrollment.class, domain.getEnrollmentProjectEntryIDMap().get(rhybcpStatus.getProjectEntryID()));
				rhybcpstatusModel.setEnrollmentid(enrollmentModel);
				rhybcpstatusModel.setExport(exportEntity);
				exportEntity.addRhybcpstatus(rhybcpstatusModel);
				i++;
				hydrateCommonFields(rhybcpstatusModel, domain,rhybcpStatus.getRHYBCPStatusID(),i);
				insert(rhybcpstatusModel);
			}
		}

	}

	@Override
	public void hydrateLive(Export export, Long id) {
		Set<Rhybcpstatus> rhybcpstatuses = export.getRhybcpstatuses();
		hydrateBulkUploadActivity(rhybcpstatuses, com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class.getSimpleName(), export,id);
		if(rhybcpstatuses !=null && !rhybcpstatuses.isEmpty()) {
			for(Rhybcpstatus rhybcpstatus : rhybcpstatuses) {
				if(rhybcpstatus !=null) {
					com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus target = new com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus();
					BeanUtils.copyProperties(rhybcpstatus, target, getNonCollectionFields(target));
					com.servinglynk.hmis.warehouse.model.v2014.Enrollment enrollmentModel = (com.servinglynk.hmis.warehouse.model.v2014.Enrollment) get(com.servinglynk.hmis.warehouse.model.v2014.Enrollment.class, rhybcpstatus.getEnrollmentid().getId());
					target.setEnrollmentid(enrollmentModel);
					com.servinglynk.hmis.warehouse.model.v2014.Export exportEntity = (com.servinglynk.hmis.warehouse.model.v2014.Export) get(com.servinglynk.hmis.warehouse.model.v2014.Export.class, export.getId());
					target.setExport(exportEntity);
					exportEntity.addRhybcpstatus(target);
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

	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus createRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       rhybcpstatus.setId(UUID.randomUUID()); 
	       insert(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus updateRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       update(rhybcpstatus);
	       return rhybcpstatus;
	   }
	   public void deleteRhybcpstatus(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus rhybcpstatus){
	       delete(rhybcpstatus);
	   }
	   public com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus getRhybcpstatusById(UUID rhybcpstatusId){ 
	       return (com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus) get(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class, rhybcpstatusId);
	   }
	   public List<com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus> getAllEnrollmentRhybcpstatuss(UUID enrollmentId,Integer startIndex, Integer maxItems){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return (List<com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus>) findByCriteria(criteria,startIndex,maxItems);
	   }
	   public long getEnrollmentRhybcpstatussCount(UUID enrollmentId){
	       DetachedCriteria criteria=DetachedCriteria.forClass(com.servinglynk.hmis.warehouse.model.v2014.Rhybcpstatus.class);
	       criteria.createAlias("enrollmentid", "enrollmentid");
	       criteria.add(Restrictions.eq("enrollmentid.id", enrollmentId));
	       return countRows(criteria);
	   }
}
