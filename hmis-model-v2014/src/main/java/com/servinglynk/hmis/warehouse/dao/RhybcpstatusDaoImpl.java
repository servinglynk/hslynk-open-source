/**
 * 
 */
package com.servinglynk.hmis.warehouse.dao;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.hbase.thrift2.generated.THBaseService.Iface;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory
			.getLogger(RhybcpstatusDaoImpl.class);
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
				if(StringUtils.isNotBlank(rhybcpStatus.getProjectEntryID())) {
					UUID uuid = domain.getEnrollmentProjectEntryIDMap().get(rhybcpStatus.getProjectEntryID());
					if(id != null) {
						Enrollment enrollmentModel = (Enrollment) get(Enrollment.class,uuid);
						rhybcpstatusModel.setEnrollmentid(enrollmentModel);
					}else {
						logger.warn("RHYBCPStatus : A match was not found for Project EntryID:{}",rhybcpStatus.getProjectEntryID());
					}
				}
				rhybcpstatusModel.setExport(exportEntity);
				exportEntity.addRhybcpstatus(rhybcpstatusModel);
				i++;
				hydrateCommonFields(rhybcpstatusModel, domain,rhybcpStatus.getRHYBCPStatusID(),i);
			}
		}

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
